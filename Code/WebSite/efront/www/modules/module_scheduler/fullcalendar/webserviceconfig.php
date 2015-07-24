<?php
/**
 * Configuration file for module ...
 *
*/

$WEF_SERVICES_HOST = "http://vlabs.cis.fiu.edu";
$WEB_SERVICES_PORT = "6060";
$WEB_SERVICES_URL  = $WEF_SERVICES_HOST . ":" . $WEB_SERVICES_PORT . "/axis2/services/";
$VIRTUAL_LABS_WSDL     = $WEB_SERVICES_URL . "VirtualLabs?wsdl";
$MENTOR_SCHEDULER_WSDL = $WEB_SERVICES_URL . "MentorScheduler?wsdl";
$VE_SCHEDULER_WSDL     = $WEB_SERVICES_URL . "VEScheduler?wsdl";
$QUOTA_SYSTEM_WSDL     = $WEB_SERVICES_URL . "QuotaSystem?wsdl";

$GUACAMOLE_HOST = "vlabs.cis.fiu.edu";
$GUACAMOLE_PORT = "8080";
$GUACAMOLE_URL  = $GUACAMOLE_HOST . ":" . $GUACAMOLE_PORT . "/guacamole/";
//define('WSDL_VL', 'http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs?wsdl');
//define('LOCATION_VL','http://vlabs.cis.fiu.edu:6060/axis2/services/VirtualLabs');
define('WSDL_VL', $VIRTUAL_LABS_WSDL);
define('LOCATION_VL',$WEB_SERVICES_URL . 'VirtualLabs');

//define('WSDL_QS', 'http://vlabs.cis.fiu.edu:6060/axis2/services/QuotaSystem?wsdl');
//define('LOCATION_QS','http://vlabs.cis.fiu.edu:6060/axis2/services/QuotaSystem');
define('WSDL_QS', $QUOTA_SYSTEM_WSDL);
define('LOCATION_QS',$WEB_SERVICES_URL . 'QuotaSystem');
//define('WSDL_QS', 'http://localhost:8080/axis2/services/QuotaSystem?wsdl');
//define('LOCATION_QS','http://localhost:8080/axis2/services/QuotaSystem');

?>
