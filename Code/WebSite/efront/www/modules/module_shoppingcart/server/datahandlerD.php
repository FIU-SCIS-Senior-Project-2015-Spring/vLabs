<?php


require_once((dirname(__FILE__)).'/db/db.php');

ini_set('display_errors',1);

/* jh In production enable these values instead:
ini_set('display_errors',0);
ini_set('log_errors',1);
*/

    //echo "before file open";
    $fileName = "php_outfileD.sql";

    $fp = fopen(G_ROOTPATH .'www/modules/'.$fileName, "w+");
    if ( !$fp ) {
     //echo $php_errormsg;
    }else {
        echo "file open successful";
        fwrite($fp, $HTTP_RAW_POST_DATA);
        fclose($fp);
    }

$output = shell_exec('mysql -u '.G_DBUSER.' -p'.G_DBPASSWD.' -D efront  <'. G_ROOTPATH .'www/modules/'.$fileName);

?>
