<?php

//***********************************************************
//						Policy Management
//***********************************************************

require_once ('quotaSystem.php');

ini_set("soap.wsdl_cache_enabled", "0");
header("Content-type: text/x-json");
//***********************************************************
//					Listener
//***********************************************************
if (isset($_POST['action'])) 
    $action = $_POST['action'];
else 
    $action = "";

    
if ($action == "getPolicies") 
{
	session_start(); 
	//TN 6/12/2015 start of edit
/*   	$userId = $_SESSION["userid"];  
	$timeZoneId = db_getUserTimeZone($userId)->data;
	*/
	$response = pol_getPolicies($timeZoneId);   
	//print_r($response);
	//$response = eF_getTableData('module_vlabs_quotasystem_policy');
   	echo json_encode($response);
	// TN 6/12/2015 end of edit, to better follow logic of code
	//echo json_encode($response);	
}
else if ($action == "getAssignablePolicies") 
{
	session_start(); 
	// TN 6/15/2015 start of edit
/* 	$userId = $_SESSION["userid"];  
	$timeZoneId = db_getUserTimeZone($userId)->data; 
*/
	$response = pol_getAssignablePolicies($timeZoneId); 
	//$response = eF_getTableData('module_vlabs_quotasystem_policy');
	//TN 6/16/2015 end of edit
	echo json_encode($response);
	
}
else if($action == "addPolicy")
{
	//TN 6/11/2015 start of edit
	$name = isset($_POST['name']) ? $_POST['name'] : "";
	$description = isset($_POST['description']) ? $_POST['description'] : ""; 
	$type = isset($_POST['typePolicy']) ? $_POST['typePolicy'] : "";
	$start_date = null;
	$nodays_in_period = 0; 
	$noPeriods = 0;
	$absoluteVal = isset($_POST['absolute']) ? $_POST['absolute'] : "" ;
    $activeVal = isset($_POST['active']) ? $_POST['active'] : "" ;
    $assignableVal = isset($_POST['assignable']) ? $_POST['assignable'] : "" ;
    $maximum = 0;
	$minimum = 0;
	$quota_in_period = isset($_POST['quotaInPeriod']) ? $_POST['quotaInPeriod'] : 0;
	
	$absolute = $absoluteVal=="true" ? TRUE : FALSE ;
    $active = $activeVal=="true" ? TRUE : FALSE ;
    $assignable = $assignableVal=="true" ? TRUE : FALSE ;
	//getting the last id in the table, must ask for clarification on this
	//$id = eF_getTableData('module_vlabs_quotasystem_policy', 'id', '', 'id desc', '', '1');
	//echo json_encode($id);
	//$id = intval($id[0]['id']) + 1;
	// increment i and then add said id to the policy arry to add it to the db
   	if($type == "NOEXPIRATION"){

  		if($absolute)
	    {
		   	$start_date = isset($_POST['startDate']) ? $_POST['startDate'] : null;
		   	$days_to_rel_start = null;
		}
		else
		{
		   	$start_date = null;
		   	$days_to_rel_start = isset($_POST['daysToRelStart']) ? $_POST['daysToRelStart'] : 0;		     	  
		}
		$policy = array(//'id' => $id,
						'name' => $name,  
				        'description' => $description, 
				        'policy_type' => $type,
						'number_of_periods' => 1,
						'days_in_period' => PHP_INT_MAX,
						'maximum' => $quota_in_period,
						'minimum' => $quota_in_period,
        				'absolute' => $absolute,
				        'start_date' => $start_date,
	        			'days_to_rel_start' => $days_to_rel_start, 
        				'active' => $active,
                		'assignable' => $assignable,
				        'quota_in_period' => $quota_in_period);
		        	        
    }
  	else if($type == "FIXED"){
	    
  		$nodays_in_period = isset($_POST['noDays']) ? $_POST['noDays'] : 0;
  		
  		if($absolute)
		{
		   	$start_date = isset($_POST['startDate']) ? $_POST['startDate'] : null;
			$days_to_rel_start = null;
		}
		else
		{
		   	$days_to_rel_start = isset($_POST['daysToRelStart']) ? $_POST['daysToRelStart'] : 0;
		}
	    $policy = array(//'id' => $id,
						'name' => $name,  
				        'description' => $description, 
				        'policy_type' => $type,
        				'absolute' => $absolute,
				        'start_date' => $start_date, 
	        			'days_to_rel_start' => $days_to_rel_start, 
				        'days_in_period' => $nodays_in_period, 
						'maximum' => $quota_in_period,
						'minimum' => $quota_in_period,
				        'number_of_periods' => 1, 
        				'active' => $active,
                		'assignable' => $assignable,
				        'quota_in_period' => $quota_in_period);

		        	        
    }else if($type == "GRADUAL"){
        $maxQuota = isset($_POST['maxQuota']) ? $_POST['maxQuota'] : 0;
	    $noPeriods = isset($_POST['noPeriods']) ? $_POST['noPeriods'] : 0;
		$nodays_in_period = isset($_POST['noDays']) ? $_POST['noDays'] : 0;		            	

		if($absolute)
		{
		  	$start_date = isset($_POST['startDate']) ? $_POST['startDate'] : null;
		  	//$start_date = getFormattedDate("/",$start_date);
		    $days_to_rel_start = null;
		}
		else
		{
			$start_date = null;
		  	$days_to_rel_start = isset($_POST['daysToRelStart']) ? $_POST['daysToRelStart'] : 0;
		}    	
	    
	    $policy = array(//'id' => $id,
						'name' => $name, 
				        'description' => $description, 
			        	'policy_type' => $type,
	       				'absolute' => $absolute,
			        	'start_date' => $start_date, 
	       				'days_to_rel_start' => $days_to_rel_start,
				        'days_in_period' => $nodays_in_period, 
				        'number_of_periods' => $noPeriods, 
	       				'active' => $active,
	               		'assignable' => $assignable,
	       				'maximum' => $maxQuota,  
						'minimum' => $quota_in_period,
				        'quota_in_period' => $quota_in_period);
	        
    }else if($type == "MINMAX"){
   	    $maxQuota = isset($_POST['maxQuota']) ? $_POST['maxQuota'] : 0;
   	    $minQuota = isset($_POST['minQuota']) ? $_POST['minQuota'] : 0;
	    $noPeriods = isset($_POST['noPeriods']) ? $_POST['noPeriods'] : 0;
		$nodays_in_period = isset($_POST['noDays']) ? $_POST['noDays'] : 0;
  		        
	    if($absolute)
	    {    
	    	$start_date = isset($_POST['start_date']) ? $_POST['start_date'] : null;
	    	//$start_date = getFormattedDate("/",$start_date);
		    $days_to_rel_start = null;
	    }
	    else
	    {
	    	$start_date = null;
	    	$days_to_rel_start = isset($_POST['daysToRelStart']) ? $_POST['daysToRelStart'] : 0;
	    } 
        $policy = array(//'id' => $id,
						'name' => $name,  
				        'description' => $description, 
			        	'policy_type' => $type,
	       				'absolute' => $absolute,
			        	'start_date' =>$start_date, 
	       				'days_to_rel_start' => $days_to_rel_start, 
				        'days_in_period' => $nodays_in_period, 
				        'number_of_periods' => $noPeriods, 
	       				'active' => $active,
	               		'assignable' => $assignable,
	       				'maximum' => $maxQuota,  
				        'minimum' => $minQuota,
				        'quota_in_period' => $quota_in_period);

    	}
    	session_start(); 
/* 		$userId = $_SESSION["userid"];  
		$timeZoneId = db_getUserTimeZone($userId)->data;
		*/
		$response = pol_addPolicy($policy, $timeZoneId); 		
        //return $result;
		// TN 6/11/2015 end of edit
		echo json_encode($response);

}
else if($action == "modifyPolicy")
{
	$id = isset($_POST['id']) ? $_POST['id'] : 0;
	$name = isset($_POST['name']) ? $_POST['name'] : "";
	$description = isset($_POST['description']) ? $_POST['description'] : ""; 
	$type = isset($_POST['typePolicy']) ? $_POST['typePolicy'] : "";
	$start_date = null;
	$nodays_in_period = 0; 
	$noPeriods = 0;
	$absoluteVal = isset($_POST['absolute']) ? $_POST['absolute'] : "" ;
    $activeVal = isset($_POST['active']) ? $_POST['active'] : "" ;
    $assignableVal = isset($_POST['assignable']) ? $_POST['assignable'] : "" ;
    $maximum = 0;
	$minimum = 0;
	$quota_in_period = isset($_POST['quotaInPeriod']) ? $_POST['quotaInPeriod'] : 0;

	$absolute = $absoluteVal=="true" ? TRUE : FALSE ;
    $active = $activeVal=="true" ? TRUE : FALSE ;
    $assignable = $assignableVal=="true" ? TRUE : FALSE ;

   	if($type == "NOEXPIRATION"){
  		if($absolute)
	    {
		   	$start_date = isset($_POST['startDate']) ? $_POST['startDate'] : null;
		   	//$start_date = getFormattedDate("/",$start_date);
		   	$days_to_rel_start = null;
		}
		else
		{
		   	$start_date = null;
		   	$days_to_rel_start = isset($_POST['daysToRelStart']) ? $_POST['daysToRelStart'] : 0;		     	  
		}
		$policy = array('id' => $id,
						'name' => $name,  
				        'description' => $description, 
				        'policy_type' => $type,
        				'absolute' => $absolute,
				        'start_date' => $start_date,
	        			'days_to_rel_start' => $days_to_rel_start, 
        				'active' => $active,
                		'assignable' => $assignable,
				        'quota_in_period' => $quota_in_period);
		        	        
    }
  	else if($type == "FIXED"){
  		
  	  	$nodays_in_period = isset($_POST['noDays']) ? $_POST['noDays'] : 0;
  		
  		if($absolute)
		{
		   	$start_date = isset($_POST['start_date']) ? $_POST['start_date'] : null;
			$days_to_rel_start = null;
		}
		else
		{
		   	$days_to_rel_start = isset($_POST['daysToRelStart']) ? $_POST['daysToRelStart'] : 0;
		}
		
	    $policy = array('id' => $id,
	    				'name' => $name,  
				        'description' => $description, 
				        'policy_type' => $type,
        				'absolute' => $absolute,
				        'start_date' => $start_date, 
	        			'days_to_rel_start' => $days_to_rel_start, 
				        'days_in_period' => $nodays_in_period, 
				        'number_of_periods' => 1, 
        				'active' => $active,
                		'assignable' => $assignable,
				        'quota_in_period' => $quota_in_period);
		        	        
    }else if($type == "GRADUAL"){
        $maxQuota = isset($_POST['maxQuota']) ? $_POST['maxQuota'] : 0;
	    $noPeriods = isset($_POST['noPeriods']) ? $_POST['noPeriods'] : 0;
		$nodays_in_period = isset($_POST['noDays']) ? $_POST['noDays'] : 0;		            	

		if($absolute)
		{
		  	$start_date = isset($_POST['start_date']) ? $_POST['start_date'] : null;
		  	$start_date = getFormattedDate("/",$start_date);
		    $days_to_rel_start = null;
		}
		else
		{
			$start_date = null;
		  	$days_to_rel_start = isset($_POST['daysToRelStart']) ? $_POST['daysToRelStart'] : 0;
		}    	
	    
	    $policy = array('id' => $id,
	    				'name' => $name, 
				        'description' => $description, 
			        	'policy_type' => $type,
	       				'absolute' => $absolute,
			        	'start_date' => $start_date, 
	       				'days_to_rel_start' => $days_to_rel_start,
				        'days_in_period' => $nodays_in_period, 
				        'number_of_periods' => $noPeriods, 
	       				'active' => $active,
	               		'assignable' => $assignable,
	       				'maximum' => $maxQuota,  
				        'quota_in_period' => $quota_in_period);
	        
    }else if($type == "MINMAX"){
   	    $maxQuota = isset($_POST['maxQuota']) ? $_POST['maxQuota'] : 0;
   	    $minQuota = isset($_POST['minQuota']) ? $_POST['minQuota'] : 0;
	    $noPeriods = isset($_POST['noPeriods']) ? $_POST['noPeriods'] : 0;
		$nodays_in_period = isset($_POST['noDays']) ? $_POST['noDays'] : 0;
  		        
	    if($absolute)
	    {    
	    	$start_date = isset($_POST['startDate']) ? $_POST['startDate'] : null;
	    	//$start_date = getFormattedDate("/",$start_date);
		    $days_to_rel_start = null;
	    }
	    else
	    {
	    	$start_date = null;
	    	$days_to_rel_start = isset($_POST['daysToRelStart']) ? $_POST['daysToRelStart'] : 0;
	    } 
        $policy = array('id' => $id,
        				'name' => $name,  
				        'description' => $description, 
			        	'policy_type' => $type,
	       				'absolute' => $absolute,
			        	'start_date' =>$start_date, 
	       				'days_to_rel_start' => $days_to_rel_start, 
				        'days_in_period' => $nodays_in_period, 
				        'number_of_periods' => $noPeriods, 
	       				'active' => $active,
	               		'assignable' => $assignable,
	       				'maximum' => $maxQuota,  
				        'minimum' => $minQuota,
				        'quota_in_period' => $quota_in_period);

    	}
    	session_start(); 
/* 		$userId = $_SESSION["userid"];  
		$timeZoneId = db_getUserTimeZone($userId)->data;
		*/
		$response = pol_modifyPolicy($policy, $timeZoneId);
		echo json_encode($response);
	
}
else if ($action == "getPolicy") 
{
	//TN 6/12/2015 Start of edit
	session_start(); 
//	$userId = $_SESSION["userid"];  
//	$timeZoneId = db_getUserTimeZone($userId)->data;
	$id = isset($_POST['id']) ? $_POST['id'] : "";
	$response = pol_getPolicy($id,$timeZoneId); 
	//echo json_encode($formattedArray);
	//TN 6/12/2015 end of edit added efront db function
	echo json_encode($response);
}
else if ($action == "deletePolicy") 
{
	// TN 6/11/2015 start of edit
	$id = isset($_POST['id']) ? $_POST['id'] : "";
	$response = pol_deletePolicy($id);
	// TN 6/11/2015 end of edit added efront db connection
	//$result = array('success' => $response);
	echo json_encode($response);
}

//***********************************************************
//						Auxiliary
//***********************************************************
function dateDiff($dformat, $endDate, $beginDate)
{
    $date_parts1=explode($dformat, $beginDate);
    $date_parts2=explode($dformat, $endDate);
    $start_date=gregoriantojd($date_parts1[0], $date_parts1[1], $date_parts1[2]);
    $end_date=gregoriantojd($date_parts2[0], $date_parts2[1], $date_parts2[2]);
    return $end_date - $start_date;
}

function getFormattedDate($dformat,$date){
	$date_parts=explode($dformat, $date);
	return date(DATE_ATOM, mktime(0, 0, 0,$date_parts[0], $date_parts[1], $date_parts[2]));
	
}
?>