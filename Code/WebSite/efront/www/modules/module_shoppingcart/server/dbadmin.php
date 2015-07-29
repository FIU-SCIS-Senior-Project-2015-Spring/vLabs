<?php

ini_set('display_errors',1);
error_reporting(E_ALL);
/*
 * dbadmin.php
 *
 * This class contains methods concerned with the eFront
 * vLabs modules database administration.
 *
 */

require_once((dirname(__FILE__)).'/db/db.php');

if (isset($_POST['action'])) {
	$action = $_POST['action'];
} else {
	$action = "";
}


if (isset($_POST['email'])) {
	$email = $_POST['email'];
} else {
	$email = "";
}


//Reload orders of an specific user depending on who is logged in
if ($action == "getModules") {

	$modules = db_getModules();
    echo json_encode($modules);

}

if ($action =="exportData") {

    $moduleId = "";
    $outputfile = "NEW_module_vlabs_shoppingcart_data.sql";
    if (isset($_POST['modId'])) {
        $moduleId = $_POST['modId'];
    } else {
        $moduleId = "";
    }

    if ($moduleId != "") {
        $modulePrefix = eF_getTableData('module_vlabs_shoppingcart_dbadmin', 'moduleprefix', 'id=' . $moduleId);

        //echo '<script type="text/javascript">alert("Current theme  is: ' . $tid[0]['name'] . '")</script>';
        /*jh this is a good Idea but since the order in which tables are exported
        and exported matters due to referential contraints, this can be done
        as a second phase since time is of the escence now!

                $tableList ="";

                $sql = 'select TABLE_NAME from INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE "' . $modulePrefix[0]['moduleprefix'] .'%"';
                $result = eF_executeQuery($sql);
                $tables_array = array();
                if($result!=null){
                    foreach($result as $r){
                        $t_array = array(
                            "tableName"=>$r['TABLE_NAME']
                        );
                        array_push($tables_array,$t_array);
                        $tableList .= $r['TABLE_NAME'] . " ";
                    }


                }
                //echo "list of tables: " .PHP_EOL;
                //echo $tableList;
                //var_dump($tables_array);
                $output = shell_exec('mysqldump -u '.G_DBUSER.' -p'.G_DBPASSWD.' --no-create-info efront ' . $tableList .' >'. G_ROOTPATH .'www/modules/NEW_module_vlabs_shoppingcart_data.sql');
        */
        $output = shell_exec('mysqldump -u ' . G_DBUSER . ' -p' . G_DBPASSWD . ' --no-create-info efront module_vlabs_shoppingcart module_vlabs_shoppingcart_store_inventory module_vlabs_shoppingcart_order module_vlabs_shoppingcart_payment_method module_vlabs_shoppingcart_user_payment module_vlabs_shoppingcart_order_summary module_vlabs_shoppingcart_package_summary module_vlabs_shoppingcart_preassignment module_vlabs_shoppingcart_log >' . G_ROOTPATH . 'www/modules/' . $outputfile);

        $fp = file_get_contents(G_ROOTPATH . 'www/modules/' . $outputfile);
        if ($fp) {
            echo $fp;
        } else {
            echo "";
        }
    }
}

if ($action =="exportSchema"){

    $moduleId ="";
    $outputfile = "NEW_module_vlabs_shoppingcart_schema.sql";
    if (isset($_POST['modId'])) {
        $moduleId = $_POST['modId'];
    } else {
        $moduleId = "";
    }

    if($moduleId!="") {
        $modulePrefix = eF_getTableData('module_vlabs_shoppingcart_dbadmin', 'moduleprefix', 'id=' . $moduleId);

        //echo '<script type="text/javascript">alert("Current theme  is: ' . $tid[0]['name'] . '")</script>';
        /*jh this is a good Idea but since the order in which tables are exported
        and exported matters due to referential contraints, this can be done
        as a second phase since time is of the escence now!

                $tableList ="";

                $sql = 'select TABLE_NAME from INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE "' . $modulePrefix[0]['moduleprefix'] .'%"';
                $result = eF_executeQuery($sql);
                $tables_array = array();
                if($result!=null){
                    foreach($result as $r){
                        $t_array = array(
                            "tableName"=>$r['TABLE_NAME']
                        );
                        array_push($tables_array,$t_array);
                        $tableList .= $r['TABLE_NAME'] . " ";
                    }


                }
                //echo "list of tables: " .PHP_EOL;
                //echo $tableList;
                //var_dump($tables_array);
                $output = shell_exec('mysqldump -u '.G_DBUSER.' -p'.G_DBPASSWD.' --no-create-info efront ' . $tableList .' >'. G_ROOTPATH .'www/modules/NEW_module_vlabs_shoppingcart_data.sql');
        */

        $output = shell_exec('mysqldump -u ' . G_DBUSER . ' -p' . G_DBPASSWD . ' --no-data efront module_vlabs_shoppingcart module_vlabs_shoppingcart_store_inventory module_vlabs_shoppingcart_order module_vlabs_shoppingcart_payment_method module_vlabs_shoppingcart_user_payment module_vlabs_shoppingcart_order_summary module_vlabs_shoppingcart_package_summary module_vlabs_shoppingcart_preassignment module_vlabs_shoppingcart_log >' . G_ROOTPATH . 'www/modules/' . $outputfile);
        $fp = file_get_contents(G_ROOTPATH . 'www/modules/' . $outputfile);
        if ($fp) {
            echo $fp;
        } else {
            echo "";
        }
    }

}

if ($action =="deleteData"){

    $moduleId ="";
    $outputfile = "NEW_module_vlabs_shoppingcart_data.sql";
    if (isset($_POST['modId'])) {
        $moduleId = $_POST['modId'];
    } else {
        $moduleId = "";
    }

    $passfail = "";

    if($moduleId!=""){
        $modulePrefix = eF_getTableData('module_vlabs_shoppingcart_dbadmin', 'moduleprefix', 'id='. $moduleId);

                $sql = 'select TABLE_NAME from INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE "' . $modulePrefix[0]['moduleprefix'] .'%"';
                $result = eF_executeQuery($sql);
                if($result!=null){
                    foreach($result as $r) {
                        //jh NOTE: this needs to be changed once used in the vlabs module
                        //so that it works for all modules! so the table should be named
                        //module_vlabs_dbadmin instead.
                        if ($r['TABLE_NAME'] != "module_vlabs_shoppingcart_dbadmin") {
                            $sql = 'DELETE ' . $r['TABLE_NAME'] . ' FROM ' . $r['TABLE_NAME'];
                            $resultSql = eF_executeQuery($sql);
                            if ($resultSql != null) {
                                $passfail = "pass";
                            } else {
                                $passfail = "fail";
                                break;
                            }
                        }
                    }
                }

        echo $passfail;
    }else{
        echo "fail";
    }
}

if ($action =="deleteSchema") {

    if (isset($_POST['modId'])) {
        $moduleId = $_POST['modId'];
    } else {
        $moduleId = "";
    }

    $result = eF_executeQuery("drop table if exists module_vlabs_shoppingcart");
    if ($result == null) {
        return "fail";
        return;
    }
    eF_executeQuery("drop table if exists module_vlabs_shoppingcart_payment_method");
    if ($result == null) {
        return "fail";
        return;
    }
    eF_executeQuery("drop table if exists module_vlabs_shoppingcart_user_payment");
    if ($result == null) {
        return "fail";
        return;
    }
    eF_executeQuery("drop table if exists module_vlabs_shoppingcart_order_summary");
    if ($result == null) {
        return "fail";
        return;
    }
    eF_executeQuery("drop table if exists module_vlabs_shoppingcart_package_summary");
    if ($result == null) {
        return "fail";
        return;
    }
    eF_executeQuery("drop table if exists module_vlabs_shoppingcart_preassignment");
    if ($result == null) {
        return "fail";
        return;
    }
    eF_executeQuery("drop table if exists module_vlabs_shoppingcart_store_inventory");
    if ($result == null) {
        return "fail";
        return;
    }
    eF_executeQuery("drop table if exists module_vlabs_shoppingcart_order");
    if ($result == null) {
        return "fail";
        return;
    }
    eF_executeQuery("drop table if exists module_vlabs_shoppingcart_log");
    if ($result == null) {
        return "fail";
        return;
    }

    echo "pass";

}

?>
