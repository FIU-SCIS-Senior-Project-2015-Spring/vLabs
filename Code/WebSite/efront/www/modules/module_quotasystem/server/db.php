<?php
require_once("../../../../libraries/configuration.php");
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
    //$result = eF_executeNew($sql);//get_record_sql($sql);
    return $result;
}

function db_getAllCourses(){
   	try {
        //$courses = db_getrecords("SELECT c.id, c.shortname FROM mdl_course c");
		$courses = eF_getTableData('module_vlabs_quotasystem_course');
		return $courses;
    } catch (Exception $e) {
        echo $e->getMessage();
        return null;
    }
}

function db_getCourseById($courseId){
   	try {
        //$course = db_getrecord("SELECT c.id, c.shortname FROM mdl_course c WHERE id = ".$courseId);
		$course = eF_getTableData('module_vlabs_quotasystem_course', '*', 'id='.$courseId);
		return $course;
    } catch (Exception $e) {
        echo $e->getMessage();
        return null;
    }
}

function db_getCoursesByUser($userId){
   	try {
		//TN 6/22/2015 edit to grab courses by user from eFront, might be scrapped
		/* $sql = "SELECT c.id, c.shortname FROM mdl_course c WHERE c.id IN";
		$sql .= "( SELECT mc.instanceid FROM mdl_context mc WHERE mc.contextlevel = 50 AND mc.id IN";
		$sql .= "( SELECT ra.contextid FROM mdl_role_assignments ra WHERE ra.roleid = 5 AND ra.userid = ".$userId."))"; */
		//$sql = "SELECT id, shortname FROM module_vlabs_quotasystem_course WHERE id IN";
		//$sql .= "( SELECT course_id FROM module_vlabs_quotasystem_course_enrollment WHERE user_id = ".$userId.")";
		$sql = "SELECT course_id FROM module_vlabs_quotasystem_course_enrollment WHERE user_id = ".$userId;
		//$courses = eF_executeQuery($sql);
		//$courses = eF_getTableData('module_vlabs_quotasystem_course_enrollment');
		$courses = eF_getTableData('module_vlabs_quotasystem_user_profile');
        //$courses = db_getrecords($sql);
		//echo $sql;
		return $courses;
    } catch (Exception $e) {
        echo $e->getMessage();
		return "error message";
        //return null;
    }
}

function db_getAllUsers(){
   	try {
        $sql = "SELECT u.id, u.username, u.firstname, u.lastname FROM mdl_user u WHERE u.id IN"; 
		$sql .= "( SELECT ra.userid FROM mdl_role_assignments ra WHERE ra.roleid = 5 AND ra.contextid IN"; 
		$sql .= "( SELECT mc.id FROM mdl_context mc WHERE mc.contextlevel = 50)) ORDER BY u.lastname";
	    //$users = db_getrecords($sql);
		$users = eF_getTableData("module_vlabs_quotasystem_user_profile");
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
        //$response = eF_getTableData('module_vlabs_quotasystem_policy',"*", "".$userId);
		return $zone;
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}

function db_setUserTimeZone($userId, $timeZoneId){
   	try {
   		
   		//$sql = "UPDATE mdl_user_info_data SET data ='".$timeZoneId."' WHERE userid = ".$userId." and fieldid = 4";
	    //execute_sql($sql,false);
	    
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}

function db_getUserName($userId){
   	try {
   		
   		//$sql = "SELECT username FROM mdl_user WHERE id = ".$userId;
	    //$username = get_record_sql($sql);
        return $username;
    } catch (Exception $e) {
        echo $e->getMessage();
        return null;
    }	
}

//TN 6/18/2015 Start of edit, Adding db queries to the db file

//Policies
function db_getPolicies(){
   	try {

	    $result = eF_getTableData('module_vlabs_quotasystem_policy');
		return $result;
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}
function db_getAssignablePolicies(){
   	try {

		$result = eF_getTableData('module_vlabs_quotasystem_policy', '*', 'assignable=1');
		return $result;
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}
function db_addPolicies($policy){
   	try {

		$result = eF_insertTableData('module_vlabs_quotasystem_policy', $policy);
		return $result;
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}
function db_modifyPolicies($policy, $id){
   	try {
		$result = eF_updateTableData('module_vlabs_quotasystem_policy', $policy, 'id='.$id);
		return $result;
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}
function db_getPolicy($id){
   	try {
		$policy = eF_getTableData('module_vlabs_quotasystem_policy', '*', 'id='.$id);
		return $response;
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}
function db_delPolicies(){
   	try {
		$result = eF_deleteTableData('module_vlabs_quotasystem_policy', 'id='.$id);
		return $result;
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}
// credit
function db_getResourceTypes(){
// uses VLabs database
}
function db_etResourceTypes($params){
 //uses vlabs db
}

function db_getCreditTypes(){
	try {
		$result = eF_getTableData('module_vlabs_quotasystem_credit_type');
		return $result;
	} catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
    
}

function db_getCreditType($id){
    try {
		$result = eF_getTableData('module_vlabs_quotasystem_credit_type', '*', 'id='.$id);
        return $result;
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
    
}

function db_addCreditType($credittype){
    try {
        $result = eF_insertTableData('module_vlabs_quotasystem_credit_type', $credittype);
        return $result;
        
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
    
}

function db_modifyCreditType($id, $name, $resource, $policyId, $courseId, $activeval, $assignval){
    try {
	   $result = eF_updateTableData("module_vlabs_quotasystem_credit_type", $credittype, 'id='.$id);
        return $result;
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
}

function db_deleteCreditType($id){
    try {
        $result = eF_deleteTableData('module_vlabs_quotasystem_credit_type', 'id='.$id);
		return $result;
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
}

/*Report
	function rm_getCurrentPeriodQuotaSummary($courseId){
		try {
			// may need two different functions or a function with default values
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = null;
	        if($courseId != null)
	        	$result = $client->getCurrentPeriodQuotaSummary(array('courseId' => $courseId));
	        else
	        	$result = $client->getCurrentPeriodQuotaSummary();
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}

	function rm_getCurrentPeriodQuotaSummaryByCreditType($creditTypeId){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = $client->getCurrentPeriodQuotaSummaryByCreditType(array('creditTypeId' => $creditTypeId));
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}

	function rm_getCurrentReportByUser($userId){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = $client->getCurrentPeriodQuotaSummaryByUser(array('userId' => $userId));
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}

	function rm_getCurrentReportByUserAndCourse($userId, $courseId){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = $client->getCurrentPeriodQuotaSummaryByUserAndCourse(array('userId' => $userId, 'courseId' => $courseId));
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}

	function rm_getHistoricQuotaSummary($courseId){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = null;
	        if($courseId != null)
	        	$result = $client->getHistoricQuotaSummary(array('courseId' => $courseId));
	        else
	        	$result = $client->getHistoricQuotaSummary();
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}
	

	function rm_getHistoricQuotaSummaryPerPeriods($creditTypeId, $userId, $timeZoneId){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = $client->getHistoricQuotaSummaryPerPeriods(array('creditTypeId' => $creditTypeId, 'userId' => $userId, 'timeZoneId'=>$timeZoneId));
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}

	function rm_getHistoricQuotaSummaryPerUsers($creditTypeId, $periodNumber){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = $client->getHistoricQuotaSummaryPerUsers(array('creditTypeId' => $creditTypeId, 'periodNumber' => $periodNumber));
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}
	
	

	function rm_getHistoricQuotaSummaryByUser($userId, $courseId){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = null;
	        if($courseId != null)
	        	$result = $client->getHistoricQuotaSummaryByUser(array('userId' => $userId, 'courseId' => $courseId));
	       	else 
	       		$result = $client->getHistoricQuotaSummaryByUser(array('userId' => $userId));
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}

	function rm_getHistoricQuotaSummaryByUserAndCreditType($userId, $creditTypeId, $timeZoneId){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	        $result = $client->getHistoricQuotaSummaryByUserAndCreditType(array('userId' => $userId, 'creditTypeId' => $creditTypeId, 'timeZoneId'=>$timeZoneId));
	        return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}*/
?>