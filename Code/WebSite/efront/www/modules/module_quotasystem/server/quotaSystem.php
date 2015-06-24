<?php
require_once('db.php');
require_once ('webserviceconfig.php');

//***********************************************************
//						Policy Management
//***********************************************************

function pol_getPolicies($timeZoneId){
    try {
    	// TN start of removal 6/8/2015
		/*
		//This is the previous version of moodle and its way of passing and accessing data
		$param = array("timeZoneId"=>$timeZoneId);
        $client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
        $result = $client->getPolicies($param);
        
        //print_r($param);
        //print_r($result);

    	$policiesResp = $result->policy;

        $policies = array();

        if (is_array($policiesResp)) {
            $policies = array_merge($policiesResp, $policies);
        } else if ($policiesResp!= null) {
            array_push($policies, $policiesResp);
        }
		
        foreach ($policies as $policy) {
            	$p = array($policy->id,
                $policy->name ,
                $policy->policyType,
                $policy->absolute,
                $policy->active,
                $policy->assignable,
                $policy->description,
                $policy->startDate,
                $policy->daysInPeriod,
                $policy->numberOfPeriods,
                $policy->maximum,
                $policy->minimum,
                $policy->quotaInPeriod,
                $policy->daysToRelStart);
            array_push($formattedPolicies, $p);
        }*/
		//TN end removal
		
		// TN 6/8/2015 start of addition
		// below is the modified vesion to be compatable with eFront, a simple database call. The other versions of the database calls can be found the the database.php file located in the libraries folder of eFront
        $response = eF_getTableData('module_vlabs_quotasystem_policy');
        //$response = eF_executeQuery('Select * from module_vlabs_quotasystem_policy');
		
		$formattedPolicies= array();
		//there is a change in the access of the fields. In theory, the $response seems to be returned as a 2d array where the first part refers to the row and the second part refers to the column name, as such the names are the same as they are in the database.
        //return $response[0]['id']; as an example of how to use said code.
		foreach ($response as $policy) {
			// change in accessing method and changes in names of database columns.
           	$p = array($policy['id'],
            $policy['name'],
            $policy['policy_type'],
            $policy['absolute'],
            $policy['active'],
            $policy['assignable'],
            $policy['description'],
            $policy['start_date'],
            $policy['days_in_period'],
            $policy['number_of_periods'],
            $policy['maximum'],
            $policy['minimum'],
            $policy['quota_in_period'],
            $policy['days_to_rel_start']);
            array_push($formattedPolicies, $p);
        }
		// TN 6/8/2015 end of addition
        return $formattedPolicies;
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
}

function pol_getAssignablePolicies($timeZoneId){
    try {
		//TN 6/16/2015 start of edit
    	$param = array("timeZoneId"=>$timeZoneId);
        $client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
        //$result = $client->getAssignablePolicies($param);
		$result = eF_getTableData('module_vlabs_quotasystem_policy', '*', 'assignable=1');
        //$policiesResp = $result->policy;

        // $policies = array();

        // if (is_array($policiesResp)) {
            // $policies = array_merge($policiesResp, $policies);
        // } else if ($policiesResp != null) {
            // array_push($policies, $policiesResp);
        // }

        $formattedPolicies= array();
         
        foreach ($result as $policy) {
            	$p = array(
            	"id" => $policy['id'],
                "name" => $policy['name'] ,
                "type" => $policy['policy_type']);
            array_push($formattedPolicies, $p);
        }
		//TN 6/16/2015 end of edit Edit column namss. added efront db connections
        return $formattedPolicies;
        
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
}

function pol_addPolicy($policy, $timeZoneId){
	try{
		//$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS)); 
		//$request = array("policy"=>$policy, "timeZoneId"=>$timeZoneId); 
		//$response = $client->addPolicy($request);
		$response = eF_insertTableData('module_vlabs_quotasystem_policy', $policy);
		return array("success"=>true, "id"=>$response);
	} catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
}

function pol_modifyPolicy($policy, $timeZoneId){
	try{
		//$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS)); 
		$request = array("policy"=>$policy, "timeZoneId"=>$timeZoneId); 
		//$client->modifyPolicy($request);
		$response = eF_updateTableData('module_vlabs_quotasystem_policy', $policy, 'id='.$id);
		return array("success"=>true);
	} catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
}

function pol_getPolicy($id, $timeZoneId){
	try{
		$param = array("policyId"=>$id,"timeZoneId"=>$timeZoneId);
		//$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
        //$policy = $client->getPolicyById($param);
		$policy = eF_getTableData('module_vlabs_quotasystem_policy', '*', 'id='.$id);
        return array("policy"=>$policy);
    } catch (Exception $e) {
        return $e->getMessage();
    } catch (SoapFault $soapfault) {
        return $soapfault->getMessage();
    }    
}

function pol_deletePolicy($id){
	try{
	    //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
        //$policy = $client->deletePolicy($id);
		$response = eF_deleteTableData('module_vlabs_quotasystem_policy', 'id='.$id);
        return array("success"=>true);
    } catch (Exception $e) {
      return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
      return array("success"=>false, "message"=>$soapfault->getMessage());
    }  
}


//***********************************************************
//						Credit Management
//***********************************************************

function ct_getResources(){
    try {
        //$params = array('userRole' => 'STUDENT');
        //$client = new SoapClient(WSDL_VL, array('location' => LOCATION_VL));
        //$result = $client->getResourceTypes($params);
        //$resources = $result->resourceType;
        
		return $resources;
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
    
}

function ct_getCourses(){
	return db_getAllCourses();
}
//TN 6/22/2015 adding getCreditTypesByCourses
function ct_getCreditTypesByCourses($courses){
	//$course_format = array();
	//might need to be called from his, assuming his is currently working
	$where = "course_id = ".$courses[0];
	if (is_array($courses)){
			foreach($ele as $courses){
				$where = $where. " or course_id = ". $ele;
			}
	}	
	$response = eF_getTableData("module_vlabs_quotasystem_credit_type", "*", $where);
	echo json_encode($response);

}
function ct_getCreditTypes(){
	try {
        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));

        //$result = $client->getCreditTypes();
		$result = eF_getTableData('module_vlabs_quotasystem_credit_type');
        //$credittype = $result->creditType;
        //$policy = $result->policy;
		//$policy = pol_getPolicy($result['policy_id'],'');
		//$policy = $credittype['policy'];
        //$credittype = //$result['policy'];
/*         $credittypes = array();
        $policies = array();
		return $policy;
         if (is_array($credittype)) {
            $credittypes = array_merge($credittypes, $credittype);
        } else if ($credittype != null) {
            array_push($credittypes, $credittype);
        } 
        
         if (is_array($policy)) {
            $policies = array_merge($policies, $policy);
        } else if ($policy != null) {
            array_push($policies, $policy);
        }  */
	
        $formattedCreditTypes= array();

        foreach ($result as $credittype) {
        	$course = db_getCourseById($credittype['course_id']);
			$policy = eF_getTableData('module_vlabs_quotasystem_policy', '*', 'id='.$credittype['policy_id']);
			if($policy[0]['id'] == $credittype['policy_id'])
        	{
        			$policyName = $policy[0]['name']." : ".$policy[0]['policy_type'];
        	}
			//return $credittype;
			//return $policy;
          	$c = array($credittype['id'],
          				$credittype['name'],			
            			$credittype['resource'] ,
            			$course[0]['shortname'],
            			$policyName,
          				$credittype['active']==1?true: false,
          				$credittype['assignable']==1?true: false);
                    
            array_push($formattedCreditTypes, $c);
        }
		return $formattedCreditTypes;
	} catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
    
}

function ct_getCreditType($id){
    try {
        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
        //$credittype = $client->getCreditTypeById($id);
		$credittype = eF_getTableData('module_vlabs_quotasystem_credit_type', '*', 'id='.$id);
        return array("creditType"=>$credittype);
        
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
    
}

function ct_addCreditType($name, $resource, $policyId, $courseId, $activeval, $assignval){
    try {
    	if($policyId=="")
        	$credittype = array('name' => $name, 'resource' => $resource, 'policy_id'=>null,'course_id' => $courseId, 'active' => $activeval, 'assignable' => $assignval);
        else
        	$credittype = array('name' => $name, 'resource' => $resource, 'policy_id'=>$policyId,'course_id' => $courseId, 'active' => $activeval, 'assignable' => $assignval);

        //$client = new SoapClient(WSDL_QS, array('cache_wsdl' => 0,'location' => LOCATION_QS));
        //$response = $client->addCreditType($credittype);
        $response = eF_insertTableData('module_vlabs_quotasystem_credit_type', $credittype);
        return array("id"=>$response);
        
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
    
}

function ct_modifyCreditType($id, $name, $resource, $policyId, $courseId, $activeval, $assignval){
    try {
		//TN 6/16/2015
    	if($policyId=="")
        	$credittype = array('id' =>$id, 'name' => $name, 'resource' => $resource, 'policy_id'=>null,'course_id' => $courseId, 'active' => $activeval, 'assignable' => $assignval);
        else
        	$credittype = array('id' =>$id, 'name' => $name, 'resource' => $resource, 'policy_id'=>$policyId,'course_id' => $courseId, 'active' => $activeval, 'assignable' => $assignval);

        //$client = new SoapClient(WSDL_QS, array('cache_wsdl' => 0,'location' => LOCATION_QS));
       // $client->modifyCreditType($credittype);
	   $result = eF_updateTableData("module_vlabs_quotasystem_credit_type", $credittype, 'id='.$id);
        return array("success"=>$result);
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
}

function ct_deleteCreditType($id){
    try {
        //$client = new SoapClient(WSDL_QS, array('cache_wsdl' => 0,'location' => LOCATION_QS));
        //$client->deleteCreditType($id);
        $result = eF_deleteTableData('module_vlabs_quotasystem_credit_type', 'id='.$id);
		return array("success"=>true);
    } catch (Exception $e) {
    	return array("success"=>false, "message"=>$e->getMessage());
    } catch (SoapFault $soapfault) {
    	return array("success"=>false, "message"=>$soapfault->getMessage());
    }
}

//***********************************************************
//						Report Management
//***********************************************************

	/*
   	 * Make a webservice call to get the current period's quota 
   	 * summary for all credit types or only for one credit type
   	 * if the @param courseId is set
	 * @param  int $courseId optional
	 * @return array $quotaSummary
   	 */
	function rm_getCurrentPeriodQuotaSummary($courseId){
		try {
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
	
    /*
   	 * Make a webservice call to get current period's quota 
   	 * summary for @param creditTypeId
     * @param int $creditTypeId
	 * @return array $quotaSummary
   	 */
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
	
	/*
     * Make a webservice call to get current period's quota 
     * summary for a user @param userId
	 * @param int $userId
	 * @return array $quotaSummary
     */
	function rm_getCurrentReportByUser($userId){
		try {
	        //$client = new SoapClient(WSDL_QS, array('location' => LOCATION_QS));
	       // $result = $client->getCurrentPeriodQuotaSummaryByUser(array('userId' => $userId));
	        $result = db_getCoursesByUser($userId);
			return $result->quotaSummary;
		        
	    } catch (Exception $e) {
	    	return array("success"=>false, "message"=>$e->getMessage());
	    } catch (SoapFault $soapfault) {
	    	return array("success"=>false, "message"=>$soapfault->getMessage());
	    }
	}
	
	/*
     * Make a webservice call to get current period's quota 
     * summary for all the credit types in a course for a user
     * @param int $userId
	 * @param int $courseId
	 * @return array $quotaSummary
     */
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
	
    /*
   	 * Make a webservice call to get the historic quota summary
	 * for all credit types or only for one credit type
   	 * if the @param courseId is set
	 * @param int $courseId optional
	 * @return array $quotaSummary
   	 */
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
	
    /*
   	 * Make a webservice call to get the historic quota summary
   	 * of a credit type per users
   	 * @param int $creditTypeId
   	 * @param int $userId optional when getHistoricQuotaSummaryPerUsers
   	 * has been called previously
   	 * @return array $quotaSummary
   	 */
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
	
    /*
   	 * Make a webservice call to get the historic quota summary
   	 * of a credit type per users
   	 * @param int $creditTypeId
   	 * @param int $periodNumber optional when getHistoricQuotaSummaryPerPeriods
   	 * has been called previously
   	 * @return array $quotaSummary
	 */
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
	
	
	/*
     * Make a webservice call to get the historic quota summary
     * for a user per credit types
     * @param int $userId 
     * @param int $courseId optional to filter the resulting credit types
     * @return array $quotaSummary
	 */
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
	
	/*
     * Make a webservice call to get the historic quota summary
     * of a credit type for a user per period
     * @param int $userId
     * @param int $creditTypeId
     * @return array $quotaSummary
	 */
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
	}
?>