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
class module_quotasystem extends EfrontModule {

	/**
	 * Get the module name, for example "Demo module"
	 *
	 * @see libraries/EfrontModule#getName()
	 */
    public function getName() {
    	//This is a language tag, defined in the file lang-<your language>.php
        return _MODULE_QS_MODULEQS;
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
        $smarty -> assign("T_QS_MODULE_BASEDIR" , $this -> moduleBaseDir);
        $smarty -> assign("T_QS_MODULE_BASELINK" , $this -> moduleBaseLink);
        $smarty -> assign("T_QS_MODULE_BASEURL" , $this -> moduleBaseUrl);
		
		//$_SESSION["userid"] = 10;
		//echo $this->getCurrentUser()->getType();
        return true;
    }

    /**
     * Specify which file to include for template
     *
	 * (non-PHPdoc)
	 * @see libraries/EfrontModule#getSmartyTpl()
     */
    public function getSmartyTpl() {
		if($this->getCurrentUser()->getType() == "administrator")
			return $this -> moduleBaseDir."module_quotasystem_page_admin.tpl";
		else
			return $this -> moduleBaseDir."module_quotasystem_page.tpl";

	}
/*
	public function onInstall(){
    	eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_course");
		$res1 = eF_executeQuery("CREATE TABLE module_vlabs_quotasystem_course (
						id integer NOT NULL,
						fullname character varying(255) NOT NULL,
						shortname character varying(45) NOT NULL,
						update_ts timestamp DEFAULT now() ON UPDATE now(),
						PRIMARY KEY (id)
						
		)");

		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_course_assigned_quota");
		$res2 = eF_executeQuery("CREATE TABLE module_vlabs_quotasystem_course_assigned_quota (
						id integer NOT NULL,
						purchase_id character varying(20),
						quantity double precision NOT NULL,
						credit_type_id integer NOT NULL,
						active boolean NOT NULL,
						update_ts timestamp DEFAULT now() ON UPDATE now(),
						start_date timestamp NOT NULL,
						PRIMARY KEY (id)
		)");

		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_course_enrollment");
		$res3 = eF_executeQuery("CREATE TABLE module_vlabs_quotasystem_course_enrollment (
						id integer NOT NULL,
						user_id integer NOT NULL,
						course_id integer NOT NULL,
						update_ts timestamp DEFAULT now() ON UPDATE now(),
						PRIMARY KEY (id)
		)");

		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_credit_type");
		$res4 = eF_executeQuery("CREATE TABLE module_vlabs_quotasystem_credit_type (
						id integer NOT NULL,
						name character varying(45) NOT NULL,
						resource character varying(45) NOT NULL,
						course_id integer NOT NULL,
						policy_id integer,
						active boolean NOT NULL,
						assignable boolean NOT NULL,
						update_ts timestamp DEFAULT now() ON UPDATE now(),
						PRIMARY KEY (id)
		)");

		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_policy");
		$res4 = eF_executeQuery("CREATE TABLE module_vlabs_quotasystem_policy (
						id integer NOT NULL,
						name character varying(45) NOT NULL,
						description character varying(255),
						policy_type character varying(20) NOT NULL,
						absolute boolean NOT NULL,
						days_to_rel_start integer,
						days_in_period integer NOT NULL,
						number_of_periods integer NOT NULL,
						maximum integer,
						minimum integer,
						quota_in_period integer NOT NULL,
						active boolean NOT NULL,
						assignable boolean NOT NULL,
						update_ts timestamp DEFAULT now() ON UPDATE now(),
						start_date timestamp,
						PRIMARY KEY (id)
		)");

		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_used_quota");
		$res5 = eF_executeQuery("CREATE TABLE module_vlabs_quotasystem_used_quota (
						id integer NOT NULL,
						period_number integer NOT NULL,
						quota integer NOT NULL,
						cancelled boolean NOT NULL,
						appointment_id character varying(45) NOT NULL,
						affiliation_id character varying(45),
						user_assigned_quota_id integer NOT NULL,
						update_ts timestamp DEFAULT now() ON UPDATE now(),
						start_time timestamp  NOT NULL,
						end_time timestamp  NOT NULL,
						PRIMARY KEY (id)
		)");

		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_user_assigned_quota");
		$res6 = eF_executeQuery("CREATE TABLE module_vlabs_quotasystem_user_assigned_quota (
						id integer NOT NULL,
						purchase_id character varying(20),
						quantity double precision NOT NULL,
						user_id integer NOT NULL,
						credit_type_id integer NOT NULL,
						active boolean NOT NULL,
						payment boolean NOT NULL,
						update_ts timestamp DEFAULT now() ON UPDATE now(),
						start_date timestamp  NOT NULL,
						PRIMARY KEY (id)
		)");

		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_user_profile");
		$res6 = eF_executeQuery("CREATE TABLE module_vlabs_quotasystem_user_profile (
						id integer NOT NULL,
						username character varying(45) NOT NULL,
						email character varying(255) NOT NULL,
						update_ts timestamp DEFAULT now() ON UPDATE now(),
						PRIMARY KEY (id), 
						CONSTAINT fk_users FOREIGN KEY (username, email) REFERENCES users(login, email)
		)");
 		eF_executeQuery("ALTER TABLE module_vlabs_quotasystem_user_profile
ADD CONSTRAINT [FK_EmpEducation_Employees]
FOREIGN KEY (empno)REFERENCES employees(empno)
ON DELETE CASCADE ON UPDATE CASCADE"); 
		return ($res1 && $res2 && $res3 && $res4 && $res5 && $res6);
	}
	public function onUninstall(){
		eF_executeQuery("drop table if exists module_quota_system");
		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_course");
		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_course_assigned_quota");
		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_course_enrollment");
		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_credit_type");
		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_policy");
		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_used_quota");
		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_user_assigned_quota");
		eF_executeQuery("DROP TABLE IF EXISTS module_vlabs_quotasystem_user_profile");
    	return true;
	}
 	public function onUpgrade(){
		//eF_executeQuery("ALTER TABLE module_quota_system");
		eF_executeQuery("drop table if exists module_quota_system");
		$res1 = eF_executeQuery("CREATE TABLE module_quota_system(id int(11), name varchar(50), description text, policyType varchar(20), absolute varchar(1), startDate datetime, daysToRelStart int(11), daysInPeriod int(11), numberOfPeriods int(11), active varchar(1), assignable varchar(1), quotaInPeriod int(11))");
    	return $res1;
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
