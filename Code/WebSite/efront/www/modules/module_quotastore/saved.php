
<?php
	//grab the theme parameter passed from the url
	$themeset = $_REQUEST['currentTheme'];
	//include the approriate css for the theme 
	switch ($themeset) {
		case 'default':
			echo '<link type="text/css"  href="jquery/jquery-ui-themes/themes/default/jquery-ui.css" rel="stylesheet">';
			echo	'<style type="text/css" media="screen">';
	
			echo	'@import "jquery/jquery-ui-themes/themes/default/demo_table_jui.css";';
	
					/*
					 * Override styles needed due to the mix of three different CSS sources! For proper examples
					 * please see the themes example in the 'Examples' section of this site
					 */

			echo		'.dataTables_info { padding-top: 0; }';
			echo		'.dataTables_paginate { padding-top: 0; }';
			echo		'.css_right { float: right; }';
			echo		'#example_wrapper .fg-toolbar { font-size: 0.8em }';
			echo		'#theme_links span { float: left; padding: 2px 10px; }';
	
			echo 	'</style>';


			break;
		case 'blue':
			echo '<link type="text/css"  href="jquery/jquery-ui-themes/themes/blue/jquery-ui.css" rel="stylesheet">';
		

			echo	'<style type="text/css" media="screen">';
	
			echo	'@import "jquery/jquery-ui-themes/themes/blue/demo_table_jui.css";';
	
					/*
					 * Override styles needed due to the mix of three different CSS sources! For proper examples
					 * please see the themes example in the 'Examples' section of this site
					 */

			echo		'.dataTables_info { padding-top: 0; }';
			echo		'.dataTables_paginate { padding-top: 0; }';
			echo		'.css_right { float: right; }';
			echo		'#example_wrapper .fg-toolbar { font-size: 0.8em }';
			echo		'#theme_links span { float: left; padding: 2px 10px; }';
	
			echo 	'</style>';


			break;
		case 'bluehtml':
			echo '<link type="text/css"  href="jquery/jquery-ui-themes/themes/bluehtml/jquery-ui.css" rel="stylesheet">';
			echo	'<style type="text/css" media="screen">';
	
			echo	'@import "jquery/jquery-ui-themes/themes/bluehtml/demo_table_jui.css";';
	
					/*
					 * Override styles needed due to the mix of three different CSS sources! For proper examples
					 * please see the themes example in the 'Examples' section of this site
					 */

			echo		'.dataTables_info { padding-top: 0; }';
			echo		'.dataTables_paginate { padding-top: 0; }';
			echo		'.css_right { float: right; }';
			echo		'#example_wrapper .fg-toolbar { font-size: 0.8em }';
			echo		'#theme_links span { float: left; padding: 2px 10px; }';
	
			echo 	'</style>';


			break;
		case 'modern_uk':
			echo '<link type="text/css"  href="jquery/jquery-ui-themes/themes/bluehtml/jquery-ui.css" rel="stylesheet">';
			echo	'<style type="text/css" media="screen">';
	
			echo	'@import "jquery/jquery-ui-themes/themes/bluehtml/demo_table_jui.css";';
	
					/*
					 * Override styles needed due to the mix of three different CSS sources! For proper examples
					 * please see the themes example in the 'Examples' section of this site
					 */

			echo		'.dataTables_info { padding-top: 0; }';
			echo		'.dataTables_paginate { padding-top: 0; }';
			echo		'.css_right { float: right; }';
			echo		'#example_wrapper .fg-toolbar { font-size: 0.8em }';
			echo		'#theme_links span { float: left; padding: 2px 10px; }';
	
			echo 	'</style>';
			break;
		case 'green':
			echo '<link type="text/css"  href="jquery/jquery-ui-themes/themes/green/jquery-ui.css" rel="stylesheet">';

			echo	'<style type="text/css" media="screen">';
	
			echo	'@import "jquery/jquery-ui-themes/themes/green/demo_table_jui.css";';
	
					/*
					 * Override styles needed due to the mix of three different CSS sources! For proper examples
					 * please see the themes example in the 'Examples' section of this site
					 */

			echo		'.dataTables_info { padding-top: 0; }';
			echo		'.dataTables_paginate { padding-top: 0; }';
			echo		'.css_right { float: right; }';
			echo		'#example_wrapper .fg-toolbar { font-size: 0.8em }';
			echo		'#theme_links span { float: left; padding: 2px 10px; }';
	
			echo 	'</style>';

			break;
		case 'flatgrey':
			echo '<link type="text/css"  href="jquery/jquery-ui-themes/themes/flatgrey/jquery-ui.css" rel="stylesheet">';

			echo	'<style type="text/css" media="screen">';
	
			echo	'@import "jquery/jquery-ui-themes/themes/flatgrey/demo_table_jui.css";';
	
					/*
					 * Override styles needed due to the mix of three different CSS sources! For proper examples
					 * please see the themes example in the 'Examples' section of this site
					 */

			echo		'.dataTables_info { padding-top: 0; }';
			echo		'.dataTables_paginate { padding-top: 0; }';
			echo		'.css_right { float: right; }';
			echo		'#example_wrapper .fg-toolbar { font-size: 0.8em }';
			echo		'#theme_links span { float: left; padding: 2px 10px; }';
	
			echo 	'</style>';


			break;
		default:
			echo '<link type="text/css"  href="jquery/jquery-ui-themes/themes/default/jquery-ui.css" rel="stylesheet">';
			echo	'<style type="text/css" media="screen">';
	
			echo	'@import "jquery/jquery-ui-themes/themes/default/demo_table_jui.css";';
	
					/*
					 * Override styles needed due to the mix of three different CSS sources! For proper examples
					 * please see the themes example in the 'Examples' section of this site
					 */

			echo		'.dataTables_info { padding-top: 0; }';
			echo		'.dataTables_paginate { padding-top: 0; }';
			echo		'.css_right { float: right; }';
			echo		'#example_wrapper .fg-toolbar { font-size: 0.8em }';
			echo		'#theme_links span { float: left; padding: 2px 10px; }';
	
			echo 	'</style>';


			break;
	}
?>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> 
<script type="text/javascript" src="jquery/jquery-ui/js/jquery-ui-1.8.4.custom.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script> 
<script type='text/javascript' src='jquery/jquery-ui/dataTables/media/js/jquery.dataTables.min.js'></script>
<script type='text/javascript' src='jquery/jquery-ui/dataTables/examples/examples_support/jquery.jeditable.js'></script>
<link type="text/css" href="css/validation.css" rel="stylesheet" />

<!-- LiveValidation -->
<script type="text/javascript" src="js/livevalidation/livevalidation.js"></script>

<!--Our scripts-->
<script type='text/javascript' src='js/loading.js'></script>
<script type='text/javascript' src='js/tabs.js'></script>
<script type='text/javascript' src='js/shoppingcart.js'></script>
<script type='text/javascript' src='js/packages.js'></script>
<script type='text/javascript' src='js/store.js'></script>
<script type='text/javascript' src='js/checkout.js'></script>
<script type='text/javascript' src='js/orders.js'></script>
<script type='text/javascript' src='js/preassignment.js'></script>
<script type='text/javascript' src='js/timezone.js'></script>
<script type='text/javascript' src='js/dbadmin.js'></script>

<!--CSS-->
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<input id ="userid" type="hidden" value="<?= $_REQUEST['currentUser'] ?>" />
<input id ="username" type="hidden" value="<?= '' ?>" />
<input id ="role" type="hidden" value="<?= $_REQUEST['currentRole'] ?>" />
<input id ="email" type="hidden" value="<?= '' ?>" />

<div id="wrapper">
    
    <div id="message" title="System message"></div>
    <div id="createitem-form" class="form" title="Item Details"></div>
    <div id="createpackage-form" class="form" title="Package Information"></div>
    <div id="additemtopkg-form" class="form"  title="Package Item details"></div>
    <div id="tabs"></div>

</div>


