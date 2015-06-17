<?php
	//include files required for efront's built in db functions
	require_once("../../../libraries/configuration.php");	
	require_once("../../../libraries/database.php");
	require_once("../../../libraries/globals.php");

	//grab the request
	switch($_POST['request']){
		case 'removeuser':
			$uid = $_POST['utid'];
			removeUser($uid);
			break;
		case 'adduser':
			$uid = $_POST['utid'];
			$uname = $_POST['utname'];
			break;
	}

	function addUser($uid, $uname){
		//add user to the enabled_user_types table
	}

	function removeUser($uid){
		//remove user from the enabled_user_types table
		try{
			eF_deleteTableData("module_vlabsadmin_enabled_user_types", "user_type_ID=$uid");
		}catch(Exception $e){
			echo $e->getMessage();
		}
	}
?>