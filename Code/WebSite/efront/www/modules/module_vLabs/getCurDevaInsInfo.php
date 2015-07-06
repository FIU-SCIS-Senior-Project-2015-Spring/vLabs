<?php

ini_set("soap.wsdl_cache_enabled", "0");

header("Access-Control-Allow-Origin: *");

$wsdl="http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl";
$location ="http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs";

if (isset($_POST['requestingUser'])) {

	$requestingUser = $_POST['requestingUser'];

} else {

	$requestingUser = "";

}

if (isset($_POST['username'])) {

	$username = $_POST['username'];

} else {

	$username = "";

}

if (isset($_POST['course'])) {

	$course = $_POST['course'];

} else {

	$course = "";

}

if (isset($_POST['resourceType'])) {

	$resourceType = $_POST['resourceType'];

} else {

	$resourceType = "";

}

//************************************************************************************************

try {

	$params1 = array(
		'requestingUser' => $requestingUser,
        'username' => $username,
        'course' => $course,
        'resourceType' => $resourceType );

	$client = new SoapClient($wsdl, array('location'=>$location));

	$result = $client->getDevaInsInfo($params1);
	 
	echo json_encode($result);
	 
} catch (Exception $e) {

	echo $e->getMessage();

} catch (SoapFault $soapfault) {

	echo $soapfault->getMessage();

}

//************************************************************************************************

?>


