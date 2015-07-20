<?php

//This file cannot be called directly, only included.
if (str_replace(DIRECTORY_SEPARATOR, "/", __FILE__) == $_SERVER['SCRIPT_FILENAME']) {
    exit;
}

/*
 * Class defining the new module
 * The name must match the one provided in the module.xml file
 */
class module_vLabs extends EfrontModule {

	/**
	 * Get the module name, for example "Demo module"
	 *
	 * @see libraries/EfrontModule#getName()
	 */
    public function getName() {
    	//This is a language tag, defined in the file lang-<your language>.php
        return _MODULE_VLABS_MODULEVLABS;
    }

	/**
	 * Return the array of roles that will have access to this module
	 * You can return any combination of 'administrator', 'student' or 'professor'
	 *
	 * @see libraries/EfrontModule#getPermittedRoles()
	 */
    public function getPermittedRoles() {
        return array("administrator", "professor", "student");
    }

	/**
	* Whether this module will be related to a lesson
	*/
	public function isLessonModule(){
		return true;
	}
	
    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getCenterLinkInfo()
     */
    public function getCenterLinkInfo() {
    	return array('title' => $this -> getName(),
                     'image' => $this -> moduleBaseLink . 'img/logo.png',
                     'link'  => $this -> moduleBaseUrl);
    }
	
	/**
	* get current user accessing the module, which is the one logged into eFront
	*/
	public function getCurrentUser(){
		return parent::getCurrentUser();
	}
    
	/**
	* get current course, if one is set
	*/
	public function getCurrentCourse(){
		return parent::getCurrentCourse();
	}
	
	/**
	* get current lesson, if one is set
	*/
	public function getCurrentLesson(){
		return parent::getCurrentLesson();
	}
	
	/**
	* get current unit, if one is set
	*/
	public function getCurrentUnit(){
		return parent::getCurrentUnit();
	}
	
	/**
	* Any commands to be executed on install; ususally creation of tables in database
	*/
	public function onInstall() {
        return true;
    }
	
	/**
	* Any commands to be executed on uninstall; ususally deletion of tables in database
	*/
	public function onUninstall() {
        return true;
    }
	
	/**
	* Any commands to be executed on upgrade; ususally any updates on tables in database
	*/
	public function onUpgrade() {
        return true;
    }
		
    /**
     * The main functionality
     *
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getModule()
     */
    public function getModule() {
    	$smarty = $this -> getSmartyVar();
        $smarty -> assign("T_MODULE_BASEDIR" , $this -> moduleBaseDir);
        $smarty -> assign("T_MODULE_BASELINK" , $this -> moduleBaseLink);
        $smarty -> assign("T_MODULE_BASEURL" , $this -> moduleBaseUrl);
		
		
		$currentUser = $this->getCurrentUser();
		$currentCourse = $this->getCurrentCourse();
		$currentLesson = $this->getCurrentLesson();
		$currentUnit = $this->getCurrentUnit();
		
		$username = $currentUser->user['login'];
        $userID = $currentUser->user['id'];
        $userEmail = $currentUser->user['email'];
		$userTypesID = $currentUser->user['user_types_ID'];
		$rolesPlain = EfrontUser::getRoles(true);
		$roleTypeName = $rolesPlain[$userTypesID];

		$vLabGranted = array(
			'fiu'				=> true, 
			'Employee'			=> true, 
			'KaseyaScholar'			=> true, 
			'KCA'				=> true,
			'KCT'				=> true,
			'Professor'			=> true,
			'KaseyaTester'		=> true,
			'LabSuspend'		=> false,
			'KaseyaPublic'		=> false,
			'Instructors'		=> false,
			'DemoFree'			=> false,
			'KaseyaQuickStart'	=> false,
			'Sales'				=> false,
			'Trial'				=> false,
			'Administrator'		=> false,
			'Student'			=> false
		);

		$username_encoded = urlencode($username);
		$hours = 3;
		$minutes = 0;

		$encrypted_password = $_COOKIE["encrypted_password_4_efront"];
        //$encrypted_password = $currentUser->user['password'];
		//$encrypted_password_encoded = urlencode($encrypted_password);
		//echo "<br> \$encrypted_password_encoded is $encrypted_password_encoded";
        $courseid = $_SESSION['s_courses_ID'];
		//echo "<br> \$courseid is $courseid";
		
		if (!$vLabGranted[$roleTypeName]){
			$debug = $vLabGranted[$roleTypeName];
			$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "KU-poweredby-ITS-NotAvailable.html");
		}
		else{
			//grab the current theme set to pass as a url paramater.
	        //this parameter will be used to properly set the css include for the module to be consistent
			$tid = $_SESSION['s_theme'];
			switch($tid){
				case '1':
				case '2':
				case '7':
					//default
					$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=default&course=$courseid&username=$username&uid=$userID&email=$userEmail&hours=$hours&minutes=$minutes&username_encoded=$username_encoded&encrypted_password=$encrypted_password");	
					break;
				case '3':
				case '5':
					//blue
					$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=blue&course=$courseid&username=$username&uid=$userID&email=$userEmail&hours=$hours&minutes=$minutes&username_encoded=$username_encoded&encrypted_password=$encrypted_password");	
					break;
				case '4':
				case '9':
					//bluehtml
					$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=bluehtml&course=$courseid&username=$username&uid=$userID&email=$userEmail&hours=$hours&minutes=$minutes&username_encoded=$username_encoded&encrypted_password=$encrypted_password");	
					break;
				case '6':
					//green
					$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=green&course=$courseid&username=$username&uid=$userID&email=$userEmail&hours=$hours&minutes=$minutes&username_encoded=$username_encoded&encrypted_password=$encrypted_password");	
					break;
				case '11':
					//flatgrey
					$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=flatgrey&course=$courseid&username=$username&uid=$userID&email=$userEmail&hours=$hours&minutes=$minutes&username_encoded=$username_encoded&encrypted_password=$encrypted_password");	
					break;
				default:
					$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=default&course=$courseid&username=$username&uid=$userID&email=$userEmail&hours=$hours&minutes=$minutes&username_encoded=$username_encoded&encrypted_password=$encrypted_password");	
					break;
			}
		}
        return true;
    }
	
    /**
     * Specify which file to include for template
     *
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getSmartyTpl()
     */
    public function getSmartyTpl() {
    	return $this -> moduleBaseDir ."module_vLabs_page.tpl";
    }

    
    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getNavigationLinks()
     */
    public function getNavigationLinks() {
        return array (array ('title' => _HOME, 'link'  => $_SERVER['PHP_SELF']),
                      array ('title' => $this -> getName(), 'link'  => $this -> moduleBaseUrl));
    }

    public function getLessonModule() {

    	$smarty = $this -> getSmartyVar();
        $smarty -> assign("T_MODULE_BASEURL" , $_SERVER['PHP_SELF'].'?ctg=control_panel');

        try {
        	if (isset($_GET['ajax']) && $_GET['ajax'] == 'vLabTable') {
        		$this -> getAjaxResults();
        		$smarty -> display($this -> moduleBaseDir . "module_vLab_lessonpage.tpl");
        		exit;
        	}
        } catch (Exception $e) {
        	handleAjaxExceptions($e);
        }

        return true;
    }

    public function getLessonSmartyTpl() {
        return $this -> moduleBaseDir."module_vLab_lessonpage.tpl";
    }

    /**
     * Code executed when inside a content unit
     *
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getContentSideInfo()
     */
    public function getContentSideInfo() {
        return true;

    }

    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#getContentToolsLink()
     */
    public function getContentToolsLink() {
        return '<a href = "'.$_SERVER['PHP_SELF'].'?ctg=module&op=module_vLab" title = "'._MODULE_VLAB_CALLEDINCONTENTTOOLS.'">'._MODULE_VLAB_CALLEDINCONTENTTOOLS.'</a>';
    }	
    
    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getContentSmartyTpl()
     */
    public function getContentSmartyTpl() {
        return $this -> moduleBaseDir."module_vLab_content_side.tpl";
    }

    /**
     * If false, then the module title will appear
     *
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getContentSideTitle()
     */
    public function getContentSideTitle() {
    	return _MODULE_VLAB_CONTENTTOOLS;
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getControlPanelModule()
     */
    public function getControlPanelModule() {
   		$smarty = $this -> getSmartyVar();
        $smarty -> assign("T_MODULE_BASEURL" , $_SERVER['PHP_SELF'].'?ctg=control_panel');

        try {
        	if (isset($_GET['ajax']) && $_GET['ajax'] == 'vLabTable') {
        		$this -> getAjaxResults();
        		$smarty -> display($this -> moduleBaseDir . "module_vLab_lessonpage.tpl");
        		exit;
        	}
        } catch (Exception $e) {
        	handleAjaxExceptions($e);
        }

        return true;
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getControlPanelSmartyTpl()
     */
    public function getControlPanelSmartyTpl() {
    	return $this -> moduleBaseDir."module_vLab_cpanelpage.tpl";
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getDashboardModule()
     */
    public function getDashboardModule() {
   		$smarty = $this -> getSmartyVar();
        $smarty -> assign("T_MODULE_BASEURL" , $_SERVER['PHP_SELF'].'?ctg=personal');

        try {
        	if (isset($_GET['ajax']) && $_GET['ajax'] == 'vLabTable') {
        		$this -> getAjaxResults();
        		$smarty -> display($this -> moduleBaseDir . "module_vLab_dashboard.tpl");
        		exit;
        	}
        } catch (Exception $e) {
        	handleAjaxExceptions($e);
        }

        return true;

    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getDashboardSmartyTpl()
     */
    public function getDashboardSmartyTpl() {
    	return $this -> moduleBaseDir."module_vLab_dashboard.tpl";
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getCatalogModule()
     */
    public function getCatalogModule() {
        return true;
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getCatalogSmartyTpl()
     */
    public function getCatalogSmartyTpl() {
    	return $this -> moduleBaseDir."module_vLab_catalog.tpl";
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getLandingPageModule()
     */
    public function getLandingPageModule() {
        return true;
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getLandingPageSmartyTpl()
     */
    public function getLandingPageSmartyTpl() {
    	return $this -> moduleBaseDir."module_vLab_landing_page.tpl";
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getTabSmartyTpl()
     */
    public function getTabSmartyTpl($tabberIdentifier) {
    	switch ($tabberIdentifier) {
    		case 'branches':
    			$tabData = array('tab'   => 'branch_vLab_tab',
    							 'title' => _MODULE_VLAB_BRANCHVLABTAB,
    							 'file'  => $this -> moduleBaseDir.'module_vLab_branch_tab.tpl');
    			break;
    		case 'rules':
    			$tabData = array('tab'   => 'rules_vLab_tab',
    							 'title' => _MODULE_VLAB_RULESVLABTAB,
    							 'file'  => $this -> moduleBaseDir.'module_vLab_rules_tab.tpl');
    			break;
    		default:break;
    	}
        return $tabData;
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getLinkToHighlight()
     */
    public function getLinkToHighlight() {
        return false;
     }


    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getLessonCenterLinkInfo()
     */
    public function getLessonCenterLinkInfo() {
    	return array('title' => $this -> getName(), // .' (getLessonCenterLinkInfo())',
                     'image' => $this -> moduleBaseLink . 'img/logo.png',
                     'link'  => $this -> moduleBaseUrl);
    }

    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#getToolsLinkInfo()
     */
    public function getToolsLinkInfo() {
    	return array('title' => $this -> getName(), // .' (getToolsLinkInfo())',
                     'image' => $this -> moduleBaseLink . 'img/logo.png',
                     'link'  => $this -> moduleBaseUrl);
    	
    }    

    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#getReportsLinkInfo()
     */
    public function getReportsLinkInfo() {
    	return array('title' => $this -> getName(), // .' (getReportsLinkInfo())',
                     'image' => $this -> moduleBaseLink . 'img/logo.png',
                     'link'  => $this -> moduleBaseUrl);
    	
    }    
    
    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#getModuleIcon()
     */
    public function getModuleIcon() {
        return $this -> moduleBaseLink . 'img/logo.png';
    }    
    
    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getSidebarLinkInfo()
     */
	/*
    public function getSidebarLinkInfo() {
    	return array('title' => $this -> getName().' (getSidebarLinkInfo())',
                     'image' => $this -> moduleBaseLink . 'img/logo.png',
                     'link'  => $this -> moduleBaseUrl);
    }
	*/

    //Sample implementation of getSidebarLinkInfo () method
    public function getSidebarLinkInfo () {
        $currentUser = $this -> getCurrentUser();

        // If a professor he should see a link in the lessons menu 
        if ($currentUser -> getType() == "professor") {
            $link_of_menu_lessons = array (
                 'id' => 'other_link_id1',
                 'title' => "Lesson link title",
                 'image' => $this -> moduleBaseLink . 'img/logo.png',
                 'link'  =>$this -> moduleBaseUrl."&module_operation=lesson_related");

            return array ('lessons' => array ($link_of_menu_lessons) );
			
        // ... and if an admin he should see a link in the users menu and in a newly defined menu
        } else if ($currentUser -> getType()  == "administrator") {
        //link using relative path to the eFront images folder
            $link_of_menu_users = array (
                 'id'    => 'users_link_id1',
                 'title' => "Users link title",
                 'image' => $this -> moduleBaseLink . 'img/logo.png',
                 'link'  => $this->moduleBaseUrl."&module_op=user_related");
 
             $link_of_menu_other = array (
                 'id'    => 'other_link_id1',
                 'title' => "Other link title",
                 'image' => $this -> moduleBaseLink . 'img/logo.png',
                 'link'  => $this -> moduleBaseUrl."&module_op=user_related");
 
             return array ('users' => array ($link_of_menu_users),
                           'other' => array ('title' => "Module menu",
                           'links'=> array ($link_of_menu_other)));
 
        }
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onNewUser()
     */
    public function onNewUser($login) {
//        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%login%', formatLogin($login), _MODULE_VLAB_CREATEDUSER)));
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => $login));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onDeleteUser()
     */
    public function onDeleteUser($login) {
		eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%login%', formatLogin($login), _MODULE_VLAB_DELETEDUSER)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onNewLesson()
     */
    public function onNewLesson($lessonId) {
    	$lessonName = eF_getTableData("lessons", "name", "id=$lessonId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%lesson%', $lessonName, _MODULE_VLAB_CREATEDLESSON)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onDeleteLesson()
     */
    public function onDeleteLesson($lessonId) {
    	$lessonName = eF_getTableData("lessons", "name", "id=$lessonId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%lesson%', $lessonName, _MODULE_VLAB_DELETEDLESSON)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onDeleteCourse()
     */
    public function onDeleteCourse($courseId) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%course%', $courseName, _MODULE_VLAB_DELETEDCOURSE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onRevokeCourseVLabificate()
     */
    public function onRevokeCourseVLabificate($login, $courseId) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace(array('%course%', '%login%'), array($courseName, formatTimestamp($login)), _MODULE_VLAB_REVOKEDVLABIFICATE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onIssueCourseVLabificate()
     */
    public function onIssueCourseVLabificate($login, $courseId, $vLabificateArray) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace(array('%course%', '%login%'), array($courseName, formatTimestamp($login)), _MODULE_VLAB_ISSUEDVLABIFICATE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onPrepareCourseVLabificate()
     */
    public function onPrepareCourseVLabificate($login, $courseId, $vLabificateData) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace(array('%course%', '%login%'), array($courseName, formatTimestamp($login)), _MODULE_VLAB_PREPAREDVLABIFICATE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onExportCourse()
     */
    public function onExportCourse($courseId) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%course%', $courseName, _MODULE_VLAB_EXPORTEDCOURSE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onImportCourse()
     */
    public function onImportCourse($courseId, $data) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%course%', $courseName, _MODULE_VLAB_IMPORTEDCOURSE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onNewCourse()
     */
    public function onNewCourse($courseId) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%course%', $courseName, _MODULE_VLAB_CREATEDCOURSE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onCompleteCourse()
     */
    public function onCompleteCourse($courseId, $login) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace(array('%course%', '%login%'), array($courseName, formatTimestamp($login)), _MODULE_VLAB_COMPLETEDCOURSE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onResetProgressInCourse($courseId, $login)
     */
    public function onResetProgressInCourse($courseId, $login) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace(array('%course%', '%login%'), array($courseName, formatTimestamp($login)), _MODULE_VLAB_RESETCOURSE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onResetProgressInCourse($login)
     */
    public function onResetProgressInAllCourses($login) {
    	$courseName = eF_getTableData("courses", "name", "id=$courseId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%login%', formatLogin($login), _MODULE_VLAB_RESETALLCOURSE)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onExportLesson()
     */
    public function onExportLesson($lessonId) {
    	$lessonName = eF_getTableData("lessons", "name", "id=$lessonId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%lesson%', $lessonName, _MODULE_VLAB_EXPORTEDLESSON)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onImportLesson()
     */
    public function onImportLesson($lessonId, $data) {
    	$lessonName = eF_getTableData("lessons", "name", "id=$lessonId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%lesson%', $lessonName, _MODULE_VLAB_IMPORTEDLESSON)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onCompleteLesson()
     */
    public function onCompleteLesson($lessonId, $login) {
    	$lessonName = eF_getTableData("lessons", "name", "id=$lessonId");
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace(array('%lesson%', '%login%'), array($lessonName, formatTimestamp($login)), _MODULE_VLAB_COMPLETEDLESSON)));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onNewPageLoad()
     */
    public function onNewPageLoad() {
    	$this -> fooBar();		//Executed at the beginning of each page load
    	return true;
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onSetTheme()
     */
    public function onSetTheme($theme) {
        eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => "Activated theme {$theme->themes['name']}"));
    }

    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#onDeleteTheme()
     */
    public function onDeleteTheme($theme) {
    	eF_insertTableData("module_vLab_data", array("timestamp" => time(), "data" => str_replace('%theme%', $theme, _MODULE_VLAB_DELETETHEME)));
    }

    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#getTabPageSmartyTpl($tabPageIdentifier)
     */
    public function getTabPageSmartyTpl($tabPageIdentifier) {
    	switch ($tabPageIdentifier) {
    		case 'course_settings':
    			$tabPageData = array('tab_page' => 'course_settings_vLab_tab',			//Use an existing name, to overwrite an existing functionality
	    							 'title' 	=> _MODULE_VLAB_COURSESETTINGSTABPAGE,
    								 'image'	=> $this -> moduleBaseLink.'img/generic.png',
	    							 'file'  	=> $this -> moduleBaseDir.'module_vLab_course_settings_tab_page.tpl');
    			break;
    		default:break;
    	}
        return $tabPageData;
    }


    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#getFieldsetSmartyTpl($fieldsetIdentifier)
     */
    public function getFieldsetSmartyTpl($fieldsetIdentifier) {
    	switch ($fieldsetIdentifier) {
    		case 'lesson_progress':
    			$fieldsetData = array('fieldset' => 'lesson_progress_vLab_fieldset',			//Use an existing name, to overwrite an existing functionality
	    							  'title' 	 => _MODULE_VLAB_LESSONPROGRESSFIELDSET,
	    							  'file'  	 => $this -> moduleBaseDir.'module_vLab_lesson_progress_fieldset.tpl');
    			break;
    		default:break;
    	}
        return $fieldsetData;
    }

    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#onPageFinishLoadingSmartyTpl()
     */
    public function onPageFinishLoadingSmartyTpl() {
    	$this -> fooBar();
    	return $this -> moduleBaseDir.'module_vLab_page_finish.tpl';
    	//Return false if you don't want any code to display
    	//return false;
    }

    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#onIndexPageLoad()
     */
    public static function onIndexPageLoad() {
    	//Return false if you don't want any code to display
    	return false;
    }
    
    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#onBeforeShowContent()
     */
    public function onBeforeShowContent(&$unit) {
    	$unit['data'] = 'This unit data has changed from the cen<br>'.$unit['data'];
    	return true;
    }
    
    /**
     * (non-PHPdoc)
     * @see libraries/EfrontModule#onAddUsersToCourse($courseId, $users)
     */
    public function onAddUsersToCourse($courseId, $users, $lessonAssignments) {
    	return true;
    }

    private function fooBar() {
    	//Do nothing!
    	return true;
    }

    private function getAjaxResults() {
    	$smarty = $this -> getSmartyVar();

    	$vLabData = eF_getTableData("module_vLab_data", "*");
    	isset($_GET['limit']) && eF_checkParameter($_GET['limit'], 'uint') ? $limit = $_GET['limit'] : $limit = G_DEFAULT_TABLE_SIZE;

    	if (isset($_GET['sort']) && eF_checkParameter($_GET['sort'], 'text')) {
    		$sort = $_GET['sort'];
    		isset($_GET['order']) && $_GET['order'] == 'desc' ? $order = 'desc' : $order = 'asc';
    	} else {
    		$sort = 'login';
    	}
    	$vLabData = eF_multiSort($vLabData, $sort, $order);
    	$smarty -> assign("T_TABLE_SIZE", sizeof($vLabData));
    	if (isset($_GET['filter'])) {
    		$vLabData = eF_filterData($vLabData, $_GET['filter']);
    	}
    	if (isset($_GET['limit']) && eF_checkParameter($_GET['limit'], 'int')) {
    		isset($_GET['offset']) && eF_checkParameter($_GET['offset'], 'int') ? $offset = $_GET['offset'] : $offset = 0;
    		$vLabData = array_slice($vLabData, $offset, $limit);
    	}

    	$smarty -> assign("T_DATA_SOURCE", $vLabData);
    }


}
