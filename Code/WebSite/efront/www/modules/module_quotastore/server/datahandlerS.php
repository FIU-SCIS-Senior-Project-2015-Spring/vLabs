<?php


require_once((dirname(__FILE__)).'/db/db.php');

ini_set('display_errors',1);

/* jh In production enable these values instead:
ini_set('display_errors',0);
ini_set('log_errors',1);

*/

/*
 * datahandlerS.php
 *
 * This file contains methods concerned with the eFront
 * vLabs modules database administration.
 * Here the table schema dump is delivered via a http POST
 * then the http POST is saved in file in the server
 * that file is then imported in MySQL.
 *
 */

    $fileName = "php_outfileS.sql";

    $fp = fopen(G_ROOTPATH .'www/modules/'.$fileName, "w+");
    if ( !$fp ) {

    }else {
        echo "file open successful";
        fwrite($fp, $HTTP_RAW_POST_DATA);
        fclose($fp);
    }

$output = shell_exec('mysql -u '.G_DBUSER.' -p'.G_DBPASSWD.' -D efront  <'. G_ROOTPATH .'www/modules/'.$fileName);

?>
