<?php
require('config.php');
require_once("../../../libraries/configuration.php");	
require_once("../../../libraries/database.php");
require_once("../../../libraries/globals.php");
ini_set("soap.wsdl_cache_enabled", "0");

header("Access-Control-Allow-Origin: *");

$wsdl=$VIRTUAL_LABS_WSDL;//"http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl";
$location =$WEB_SERVICES_URL;

		
if (isset($_POST['action'])){
	$action = $_POST['action'];   
}else{
	$action = "";
}


if (isset($_POST['arr'])){
	$arr = $_POST['arr'];   
}else{
	$arr = "";
} 

//echo $arr;


//*****************************************************************************************

if($action == 'getState'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['instanceId']) && isset($_POST['vmName'])){
		$instanceId = $_POST['instanceId']; 
		$vmName = $_POST['vmName'];
	
		echo instanceCmdRequest($instanceId, $vmName, 'getstate','');
	}
	
}else if ($action=='powerOff'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['instanceId']) && isset($_POST['vmName'])){
		$instanceId = $_POST['instanceId']; 
		$vmName = $_POST['vmName'];
		
		instanceCmdRequest($instanceId, $vmName, 'stop', 'hard');
	}
	
}else if ($action=='shutdown'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['instanceId']) && isset($_POST['vmName'])){
		$instanceId = $_POST['instanceId']; 
		$vmName = $_POST['vmName'];
		
		instanceCmdRequest($instanceId, $vmName, 'stop', 'soft');
	}
	
}else if ($action=='suspend'){
	header('Content-Type: text/x-json');	
	
	if (isset($_POST['instanceId']) && isset($_POST['vmName'])){
		$instanceId = $_POST['instanceId']; 
		$vmName = $_POST['vmName'];
	
		instanceCmdRequest($instanceId, $vmName, 'suspend', 'soft');
	}

}else if ($action=='powerOn'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['instanceId']) && isset($_POST['vmName'])){
		$instanceId = $_POST['instanceId']; 
		$vmName = $_POST['vmName'];
		
		instanceCmdRequest($instanceId, $vmName, 'start', 'soft');	
	}
	
}else if ($action=='restart'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['instanceId']) && isset($_POST['vmName'])){
		$instanceId = $_POST['instanceId']; 
		$vmName = $_POST['vmName'];
		
		instanceCmdRequest($instanceId, $vmName, 'reset', 'hard');	
	}
	
}else if ($action=='refresh'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['instanceId']) && isset($_POST['vmName'])){
		$instanceId = $_POST['instanceId']; 
		$vmName = $_POST['vmName'];
		$encryptedPassword = $_POST['encryptedPassword'];
	
		refreshInstanceRequest($instanceId, $vmName, $encryptedPassword);
	}
		
}else if ($action=='refreshAll'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['instanceId']) && isset($_POST['vmName'])){
		$instanceId = $_POST['instanceId'];
		$encryptedPassword = $_POST['encryptedPassword']; 
		//$vmName = $_POST['vmName'];
	
		refreshAllInstanceRequest($instanceId, $encryptedPassword);
	}
		
}
else if ($action=='getAppointmentTimer'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['instanceId'])){
		$instanceId = $_POST['instanceId']; 
	
		getAppointmentTimer($instanceId);	
		
	}
	
}else if ($action=='isRDPReady'){
	header('Content-Type: text/x-json');
	// Edited: JAM 03.21.2012
	if (isset($_POST['hostName']) && isset($_POST['hostPort']) && isset($_POST['userid'])){
		$hostName = $_POST['hostName']; 
		$hostPort = $_POST['hostPort'];
		$userid = $_POST['userid'];
		$defaultHeight = $_POST['defaultHeight'];
		$email = $_POST['email'];
		
		isRDPReady($hostName, $hostPort, $userid, $defaultHeight, $email);	// Edited: JAM 03.21.2012
		
	}
}else if ($action=='getUserCurAppId'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['resourceType']) && isset($_POST['course'])){
		$username = $_POST['username']; 
		$course = $_POST['course'];
		$resourceType = $_POST['resourceType'];
	
		getUserCurAppId($username, $course, $resourceType);
		
	}
}else if ($action=='getBpp'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['email'])){
		$email = $_POST['email'];
		
		$bpp = getBppValue($email);
		echo json_encode($bpp);
	}else{
		$action = "";
	}
}else if ($action=='setBpp'){
	header('Content-Type: text');

	if (isset($_POST['email'])){
		$email = $_POST['email'];
		$bpp = $_POST['bpp'];
		
		setBpp($email,$bpp);
	}else{
		$action = "";
	}
}else if ($action=='getResolution'){
	header('Content-Type: text/x-json');
	
	if (isset($_POST['email'])){
		$email = $_POST['email'];
		
		$resolution = getResolutionValue($email);
		echo json_encode($resolution);
	}else{
		$action = "";
	}
}else if ($action=='setResolution'){
	header('Content-Type: text');

	if (isset($_POST['email'])){
		$email = $_POST['email'];
		$resolution = $_POST['resolution'];
		
		setResolution($email, $resolution);
	}else{
		$action = "";
	}
}


//*****************************************************************************************

function instanceCmdRequest($devaInsId, $vmName, $cmd1, $cmd2){
	require('config.php');
	$wsdl=$VIRTUAL_LABS_WSDL;//"http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl";
	$location =$WEB_SERVICES_URL;
	
	//$devaInsId = 'c9bfaa50-2036-4b93-a701-848a6671864f';
	//$vmName = 'xp-4';
	
	//$devaInsId = 'c9bfaa50-2036-4b93-a701-848a6671864f';
	//$vmName = 'Laptop 1 (laptop1)';
	
	try {
					
		$params = array('devaInsId' => $devaInsId,
						'vmName' => $vmName,
						'cmdParam1' => $cmd1,
						'cmdParam2' => $cmd2 ); 			

		$client=new SoapClient($wsdl,array('location'=>$location));

		$result = $client->RunVMCmd($params);
		

	} catch (Exception $e) {
	
		echo $e->getMessage();
	
	}catch (SoapFault $soapfault) {
	
		echo $soapfault->getMessage();
	}	
	return $result->returnValue;
}



function refreshInstanceRequest($devaInsId, $vmName, $encryptedPassword){
	require('config.php');
	$wsdl=$VIRTUAL_LABS_WSDL;//"http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl";
	$location =$WEB_SERVICES_URL;
	
	//$devaInsId = 'c9bfaa50-2036-4b93-a701-848a6671864f';
	//$vmName = 'Laptop 1 (laptop1)';
	
	try {
					
		$params = array('devaInsId' => $devaInsId,
						'vmName' => $vmName,
						'encryptedPassword' => $encryptedPassword); 			

		$client=new SoapClient($wsdl,array('location'=>$location));

		$result = $client->refreshVMWithEncryptedPassword($params);
		

	} catch (Exception $e) {
	
		echo $e->getMessage();
	
	}catch (SoapFault $soapfault) {
	
		echo $soapfault->getMessage();
	}	
	return $result;
}



function refreshAllInstanceRequest($devaInsId, $encryptedPassword){
	require('config.php');
	$wsdl=$VIRTUAL_LABS_WSDL;//"http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl";
	$location =$WEB_SERVICES_URL;
	
	//$devaInsId = 'c9bfaa50-2036-4b93-a701-848a6671864f';
	//$vmName = 'Laptop 1 (laptop1)';
	
	try {
					
		$params = array('devaInsId' => $devaInsId,
						'encryptedPassword' => $encryptedPassword); 			

		$client=new SoapClient($wsdl,array('location'=>$location));

		$result = $client->refreshVEWithEncryptedPassword($params);
		

	} catch (Exception $e) {
	
		echo $e->getMessage();
	
	}catch (SoapFault $soapfault) {
	
		echo $soapfault->getMessage();
	}	
	return $result;
}



function getAppointmentTimer($devaInsId){
	require('config.php');
	$wsdl=$VIRTUAL_LABS_WSDL;//"http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl";
	$location =$WEB_SERVICES_URL;
	
	//$devaInsId = 'c9bfaa50-2036-4b93-a701-848a6671864f';
	
	try {
					
		$params = array('devaInsId' => $devaInsId); 			

		$client=new SoapClient($wsdl,array('location'=>$location));

		$result = $client->getEndDate4CurrentDevaIns($params);
		

	} catch (Exception $e) {
	
		echo $e->getMessage();
	
	}catch (SoapFault $soapfault) {
	
		echo $soapfault->getMessage();
	}	
	
	echo json_encode($result);
	//return $result;
}

function isRDPReady($hostName, $hostPort, $userid, $defaultHeight, $email){	// Edited: JAM 03.21.2012
	require('config.php');
	$wsdl=$VIRTUAL_LABS_WSDL;//"http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl";
	$location =$WEB_SERVICES_URL;
	
	try{
					
		$params = array('hostName' => $hostName,
				'hostport' => $hostPort ); 			

		$client=new SoapClient($wsdl,array('location'=>$location));

		$result = $client->isRDPReady($params);
		$result->bpp = getBppValue($email);
		$result->height = getResolutionHeight($email,$defaultHeight);
		$result->width = getResolutionWidth($email);

	} catch (Exception $e) {
	
		echo $e->getMessage();
	
	}catch (SoapFault $soapfault) {
	
		echo $soapfault->getMessage();
	}	
	
	echo json_encode($result);
	//return $result;
}

function getUserCurAppId($username, $course, $resourceType){
	require('config.php');
	$wsdl=$VIRTUAL_LABS_WSDL;//"http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl";
	$location =$WEB_SERVICES_URL;
	
	try{
					
		$params = array('username' => $username,
						'course' => $course,
						'resourceType' => $resourceType ); 			

		$client=new SoapClient($wsdl,array('location'=>$location));

		$result = $client->getUserCurAppId($params);
		

	} catch (Exception $e) {
	
		echo $e->getMessage();
	
	}catch (SoapFault $soapfault) {
	
		echo $soapfault->getMessage();
	}	
	
	echo json_encode($result);
	//return $result;
}

function getBppValue($email){
    try {  		
   	//$sql = "SELECT data FROM module_vlabs_user_info_data WHERE email = ".$email." and field_id = 19";
		$bppdata = eF_getTableData("module_vlabs_user_info_data", "data", "email='$email' and field_id=19");
		if(empty($bppdata)){
			return "default";
		}
		foreach($bppdata as $bpp){
			$bppval = $bpp['data'];
			return $bppval;
		}
    } catch (Exception $e) {
        //echo $e->getMessage();
		return "default";
    }
}

function getBpp($email){
    try {  		
	   	//$sql = "SELECT data FROM mdl_user_info_data WHERE userid = ".$userId." and fieldid = 19";
		$bpp = eF_getTableData("module_vlabs_user_info_data", "data", "email='$email' and field_id=19");
    } catch (Exception $e) {
        //echo $e->getMessage();
		$bpp = null;
    }
	return $bpp;
}

function setBpp($email, $bpp){
   	try {
		eF_insertOrupdateTableData("module_vlabs_user_info_data", array("email" => $email, "field_id" => 19 ,"data" => $bpp), "email='$email' and field_id=19");
		echo "changed";
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}

function getResolution($email){
     try {  		
	   	//$sql = "SELECT data FROM mdl_user_info_data WHERE userid = ".$userId." and fieldid = 19";
		$res = eF_getTableData("module_vlabs_user_info_data", "data", "email='$email' and field_id=20");
    } catch (Exception $e) {
        //echo $e->getMessage();
		$res = null;
    }
	return $res;
}
function getResolutionValue($email){
    try {  		
   	//$sql = "SELECT data FROM module_vlabs_user_info_data WHERE email = ".$email." and field_id = 19";
		$res = eF_getTableData("module_vlabs_user_info_data", "data", "email='$email' and field_id=20");
		if(empty($res)){
			return "default";
		}
		foreach($res as $resolution){
			$resval = $resolution['data'];
			return $resval;
		}
    } catch (Exception $e) {
        //echo $e->getMessage();
		return "default";
    }
}
function setResolution($email, $resolution){
   	try {
		eF_insertOrupdateTableData("module_vlabs_user_info_data", array("email" => $email, "field_id" => 20 ,"data" => $resolution), "email='$email' and field_id=20");
		echo "changed";
    } catch (Exception $e) {
        echo $e->getMessage();
    }	
}
function getResolutionHeight($email,$defaultHeight){
    $resString = getResolutionValue($email);
    $pos = strrpos($resString, "x");
    if ($pos === false) { // Not Found
        //echo 'width="100%" height="'.$defaultHeight.'%"';
	$height = $defaultHeight."%";
    }else{
        //$w = substr($resString, 0, $pos);
        $h = substr($resString, $pos+1);
        //echo 'width="'.$w.'px" height="'.$h.'px"';
	$height = $h."px";
    }
    return $height;
}
function getResolutionWidth($email){
    $resString = getResolutionValue($email);
    $pos = strrpos($resString, "x");
    if ($pos === false) { // Not Found
	$width = "100%";
    }else{
        $w = substr($resString, 0, $pos);
        $width = $w."px";
    }
    return $width;
}
//bottomFrameHeightPercentage

//*****************************************************************************************


?>