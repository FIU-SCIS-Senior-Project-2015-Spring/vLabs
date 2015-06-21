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
			$id = $_POST['id'];
			$name = $_POST['name'];
			addUser($id, $name);
			break;
	}

	function addUser($id, $name){
		//add user to the enabled_user_types table
		try{
			//this inserts the record if it doesn't already exist, if it does, it just updates. 
			eF_insertOrupdateTableData("module_vlabsadmin_enabled_user_types", array("user_type_id" => "$id", "user_type_name" => "$name"), "user_type_id=$id");
		}catch(Exception $e){
			echo $e->getMessage();
		}
	}

	function removeUser($uid){
		//remove user from the enabled_user_types table
		try{
			eF_deleteTableData("module_vlabsadmin_enabled_user_types", "user_type_id=$uid");
		}catch(Exception $e){
			echo $e->getMessage();
		}
	}
?>