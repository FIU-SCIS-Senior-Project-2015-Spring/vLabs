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
		$userTypesID = $currentUser->user['user_types_ID'];
		$rolesPlain = EfrontUser::getRoles(true);
		$roleTypeName = $rolesPlain[$userTypesID];
		
		
		//grab the current theme set to pass as a url paramater.
        //this parameter will be used to properly set the css include for the module to be consistent
		$tid = $_SESSION['s_theme'];
		switch($tid){
			case '1':
			case '2':
			case '7':
				//default
				$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=default&username=$username");	
				break;
			case '3':
			case '5':
				//blue
				$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=blue&username=$username");	
				break;
			case '4':
			case '9':
				//bluehtml
				$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=bluehtml&username=$username");	
				break;
			case '6':
				//green
				$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=green&username=$username");	
				break;
			case '11':
				//flatgrey
				$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=flatgrey&username=$username");	
				break;
			default:
				$smarty -> assign("T_LANDING", $this -> moduleBaseLink . "landing.php?theme=default&username=$username");	
				break;
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


}
