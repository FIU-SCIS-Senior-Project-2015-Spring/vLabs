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
			$data = $_POST['data'];
			addUser($data);
			break;
	}

	function addUser($data){
		//add user to the enabled_user_types table
		//check to make sure user isn't already there!

		$arr = explode(',', $data);
		echo count($arr);

		for($i = 0; $i < count($arr); $i=$i+2){
			try{
				eF_insertTableData("module_vlabsadmin_enabled_user_types", array("user_type_id" => $arr[$i], "user_type_name" => $arr[$i+1]));
			}catch(Exception $e){
				echo $e->getMessage();
			}
		}

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