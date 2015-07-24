<?php
require_once("../../../../libraries/configuration.php");
//require_once("../../../config.php");
//require_once("../lib.php");
//require_once('dblog.php');



function db_execute($sql)
{
    //return execute_sql($sql, false);
    //log($sql);

}


function db_getrecords($sql)
{
    //log($sql);
    //$result = get_records_sql($sql);
    return $result;
}


function db_getrecord($sql)
{
    //log($sql);
    //$result = get_record_sql($sql);
    return $result;
}

function db_getAllCourses(){
   	try {
        //$courses = db_getrecords("SELECT c.id, c.shortname FROM mdl_course c");
		$courses = eF_getTableData("module_vlabs_quotasystem_course");

		return $courses;
    } catch (Exception $e) {
        echo $e->getMessage();
        return null;
    }
}

function db_getCourseById($courseId){
   	try {
        //$course = db_getrecord("SELECT c.id, c.shortname FROM mdl_course c WHERE id = ".$courseId);
		$course = eF_getTableData("module_vlabs_quotasystem_course", "id, shortname", "id = ".$courseId );
		return $course;
    } catch (Exception $e) {
        echo $e->getMessage();
        return null;
    }
}

function db_getCoursesByUser($userId){
   	try {
		$sql = "SELECT c.id, c.shortname FROM mdl_course c WHERE c.id IN";
		$sql .= "( SELECT mc.instanceid FROM mdl_context mc WHERE mc.contextlevel = 50 AND mc.id IN";
		$sql .= "( SELECT ra.contextid FROM mdl_role_assignments ra WHERE ra.roleid = 5 AND ra.userid = ".$userId."))";
        //$courses = db_getrecords($sql);
		//need more reference data. Although in theory the sql could be a change of
		//$sql = "SELECT c.id, c.shortname FROM module_vlabs_quotasystem_course c WHERE c.id IN";
		//$sql .= "( SELECT ra.contextid FROM  module_vlabs_quotasystem_course_enrollment ra WHERE userid = ".$userId.")";
		return $courses;
    } catch (Exception $e) {
        echo $e->getMessage();
        return null;
    }
}

function db_getAllUsers(){
   	try {
        $sql = "SELECT u.id, u.username, u.firstname, u.lastname FROM mdl_user u WHERE u.id IN"; 
		$sql .= "( SELECT ra.userid FROM mdl_role_assignments ra WHERE ra.roleid = 5 AND ra.contextid IN"; 
		$sql .= "( SELECT mc.id FROM mdl_context mc WHERE mc.contextlevel = 50)) ORDER BY u.lastname";
	    //$users = db_getrecords($sql);
        //need more reference data. Although in theory the sql could be a change of, assuming that its coming from the users table
		//$sql = "SELECT u.id, u.username, u.name, u.surname FROM users u;
		return $users;
    } catch (Exception $e) {
        echo $e->getMessage();
        return null;
    }
}

function db_getUserTimeZone($userId){
   	try {  		
   		$sql = "SELECT data FROM mdl_user_info_data WHERE userid = ".$userId." and fieldid = 4";
	    //$zone = get_record_sql($sql);
        //potentially will be unused
		return $zone;
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}

function db_setUserTimeZone($userId, $timeZoneId){
   	try {
   		
   		$sql = "UPDATE mdl_user_info_data SET data ='".$timeZoneId."' WHERE userid = ".$userId." and fieldid = 4";
	    //execute_sql($sql,false);
	    //potentially will be unused
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}

function db_getUserName($userId){
   	try {
   		
   		//$sql = "SELECT username FROM mdl_user WHERE id = ".$userId;
		//$username = get_record_sql($sql);
        //need more reference data. Although in theory the sql could be a change of, assuming that its coming from the users table
		//$sql = "SELECT username FROM users WHERE id = ".$userId;
		return $username;
    } catch (Exception $e) {
        echo $e->getMessage();
        return null;
    }	
}


?>