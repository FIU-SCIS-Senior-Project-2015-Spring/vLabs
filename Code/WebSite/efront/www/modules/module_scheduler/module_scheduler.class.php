<?php
include("../../../libraries/configuration.php");


//This file cannot be called directly, only included.
if (str_replace(DIRECTORY_SEPARATOR, "/", __FILE__) == $_SERVER['SCRIPT_FILENAME']) {
    exit;
}

/*
 * Class defining the new module
 * The name must match the one provided in the module.xml file
 */
class module_scheduler extends EfrontModule {

	/**
	 * Get the module name, for example "Demo module"
	 *
	 * @see libraries/EfrontModule#getName()
	 */
    public function getName() {
    	//This is a language tag, defined in the file lang-<your language>.php
        return _MODULE_SCHEDULER_MODULESCHEDULER;
    }

	/**
	 * Return the array of roles that will have access to this module
	 * You can return any combination of 'administrator', 'student' or 'professor'
	 *
	 * @see libraries/EfrontModule#getPermittedRoles()
	 */
    public function getPermittedRoles() {
        return array("administrator", "professor", "student");		//This module will be available to administrators
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
     * The main functionality
     *
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getModule()
     */
   public function getModule() {
    	$smarty = $this -> getSmartyVar();
        $smarty -> assign("T_SCHEDULER_MODULE_BASEDIR" , $this -> moduleBaseDir);
        $smarty -> assign("T_SCHEDULER_MODULE_BASELINK" , $this -> moduleBaseLink);
        $smarty -> assign("T_SCHEDULER_MODULE_BASEURL" , $this -> moduleBaseUrl);
		$smarty -> assign("T_SCHEDULER_LANDING", $this -> moduleBaseLink . "view.php");
		$userlogin = $this->getCurrentUser()->user['login'];
		$uid = eF_getTableData('module_vlabs_quotasystem_user_profile','*',"username = '" . $userlogin. "'");
		//$uid = 2;
		$smarty->assign("T_SCHEDULER_UID", $uid[0]['id']);
		$smarty->assign("T_SCHEDULER_ROLE", $this->getCurrentUser()->user['user_type']);
		$smarty->assign("T_SCHEDULER_UNAME", $userlogin);
		//$colorcount = 10;//eF_countTableData('module_vlabs_scheduler','*',"enable = 1");
		//$smarty->assign("T_SCHEDULER_COLORCOUNT", $colorcount);
		//$colors = 10;//eF_getTableData('module_vlabs_scheduler','*',"enable = 1");
		//$smarty->assign("T_SCHEDULER_COLORS", $colors);
		$email = 'sadjadi@cis.fiu.edu';
		$field7 = eF_getTableData('module_vlabs_user_info_data','*',"email = '" . $email. "' and field_id = 7");
		$smarty->assign("T_SCHEDULER_FIELD7", $field7[0]['data']);
		$users = eF_getTableData('module_vlabs_quotasystem_user_profile', '*', '', 'username');
		$smarty->assign("T_SCHEDULER_USERS", $users);
        return true;
    }

    /**
     * Specify which file to include for template
     *
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getSmartyTpl()
     */
    public function getSmartyTpl() {
		return $this->moduleBaseDir . "module_scheduler.tpl";

	}
/*
	public function onInstall(){
		eF_ExecuteQuery("create table module_vlabs_user_info_fields(    
			id bigint(10) unsigned NOT NULL AUTO_INCREMENT,
			shortname varchar(255) NOT NULL,
			name longtext NOT NULL, 
			datatype varchar(255) NOT NULL,
			description longtext,
			categoryid bigint(10) unsigned NOT NULL,
			sortorder bigint(10) unsigned NOT NULL,
			required tinyint(2) unsigned NOT NULL,
			locked tinyint(2) unsigned NOT NULL,
			visible smallint(4) unsigned NOT NULL,
			forceunique tinyint(2) unsigned NOT NULL,
			signup tinyint(2) unsigned NOT NULL,
			defaultdata longtext,
			param1 longtext,
			param2 longtext,
			param3 longtext,
			param4 longtext,
			param5 longtext,
			PRIMARY KEY(id)
		);")
		eF_ExecuteQuery("create table module_vlabs_user_info_fields(    
			email varchar(150) NOT NULL,
			field_id bigint(10) unsigned NOT NULL,
			data longtext NOT NULL
		);")

	}
	public function onUninstall(){

	}
 	public function onUpgrade(){

	} */
   
    /**
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getNavigationLinks()
     */
    public function getNavigationLinks() {
        return array (array ('title' => _HOME, 'link'  => $_SERVER['PHP_SELF']),
                      array ('title' => $this -> getName(), 'link'  => $this -> moduleBaseUrl));
    }
	//this will allow the module to appear in other places besides the admin level
	public function getToolsLinkInfo() {
    	return array('title' => $this -> getName(), // .' (getToolsLinkInfo())',
                     'image' => $this -> moduleBaseLink . 'img/logo.png',
                     'link'  => $this -> moduleBaseUrl);
    	
    }   


}
