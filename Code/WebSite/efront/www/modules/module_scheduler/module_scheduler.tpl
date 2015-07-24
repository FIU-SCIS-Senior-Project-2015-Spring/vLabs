{*<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
	<iframe src="{$T_SCHEDULER_LANDING}" style="border:none; position:fixed; width:95%; height:100%"></iframe>
</body>
</html>*}
{php}

//**********************************************************************************************
// Scheduler Calendar
// Using FULLCALENDAR plugin
//**********************************************************************************************


{/php}
<link rel='stylesheet' type='text/css' href='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/css/fullcalendar.css' />
<link rel='stylesheet' type='text/css' href='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/css/jquery.ptTimeSelect.css' />
<link rel='stylesheet' type='text/css' href='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/css/custom-theme/jquery-ui-1.8.1.custom2.css' />
<link href="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/css/cmxformTemplate.css" rel="stylesheet" type="text/css" />
<link href="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/css/cmxform.css" rel="stylesheet" type="text/css" />
<link rel='stylesheet' type='text/css' href='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/css/flexigrid/flexigrid.css' />
<link rel='stylesheet' type='text/css' href='{$T_S_MODULE_THEME_CSS}' />


<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquery-1.4.2.min.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquery-ui-1.8.9.custom.min.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquery.ptTimeSelect.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/dateFormat.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquery.blockUI.js'></script>
<script type="text/javascript" src="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquery.qtip-1.0.min.js"></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquery.jookie.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquery.validate.min.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/cookie.js'></script>

<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/fullcalendar.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/gcal.js'></script>
<script type="text/javascript" src="{$T_SCHEDULER_MODULE_BASELINK}colormanager.js"></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/calendar.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/filters.js'></script>		
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/servicecalls.js'></script> 
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/externalObjects.js'></script> <!-- NEW -->
<!-- script type='text/javascript' src='fullcalendar/user-student.js'></script>
<script type='text/javascript' src='fullcalendar/user-admin.js'></script -->
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/slider-options-menu.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/dialogboxes.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/recurring-events.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery.loader.js'></script>

<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/flexigrid.js'></script>
<!-- script type='text/javascript' src='fullcalendar/flexigrid.pack.js'></script -->

<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}timezone.js'></script>
<script type='text/javascript' src='{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquerytimer-min.js'></script>	<!-- Timer -->


<!-- Context Menu -->
<script src="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/jquery/jquery.contextMenu.js" type="text/javascript"></script>
<link href="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/css/jquery.contextMenu.css" rel="stylesheet" type="text/css" />

<!-- Color Manager -->
<link rel="stylesheet" media="screen" type="text/css" href="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/colorpicker/css/colorpicker_custom.css" />
<link rel="stylesheet" media="screen" type="text/css" href="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/colorpicker/css/layout2.css" />
<script type="text/javascript" src="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/colorpicker/js/colorpicker.js"></script>
<script type="text/javascript" src="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/colorpicker/js/eye.js"></script>
<script type="text/javascript" src="{$T_SCHEDULER_MODULE_BASELINK}fullcalendar/colorpicker/js/utils.js"></script>

<style type='text/css'>
{literal}
	body {
		margin-top: 40px;
		<!--text-align: center;-->
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}

	#calendar {
		width: 900px;
		/*
		float: left;
		margin: 0px 25px 5px 0px;
		*/
		margin: 0 auto;
		}
		
	#host_calendar {
		width: 900px;
		margin: 0 auto;
		}

	/* -- Set here for design purposes. -- */
	/* Accordion ----------------------------------*/
	.ui-accordion .ui-accordion-header { cursor: pointer; position: relative; margin-top: 1px; zoom: 1; }
	.ui-accordion .ui-accordion-li-fix { display: inline; }
	.ui-accordion .ui-accordion-header-active { border-bottom: 0 !important; }
	.ui-accordion .ui-accordion-header a { display: block; font-size: 1em; padding: .5em .5em .5em .7em; color:#ffffff;}
	/* IE7-/Win - Fix extra vertical space in lists */
	.ui-accordion a { zoom: 1; }
	.ui-accordion-icons .ui-accordion-header a { padding-left: 2.2em; }
	.ui-accordion .ui-accordion-header .ui-icon { position: absolute; left: .5em; top: 50%; margin-top: -8px; }
	.ui-accordion .ui-accordion-content { padding: 1em 2.2em; border-top: 0; margin-top: -2px; position: relative; top: 1px; margin-bottom: 2px; overflow: auto; display: none; zoom: 1; }
	.ui-accordion .ui-accordion-content-active { display: block; }

/* actions icons */

	
	.ui-accordion .ui-accordion-content-active .actions-edit{
		float: right;
		display: block;
		width: 25px;
		height: 25px;
		margin: 5px;
		background-image: url(/modules/module_scheduler/fullcalendar/images/list_edit_25px.png);
		cursor: pointer;
	} 
	.ui-accordion .ui-accordion-content-active .actions-cancel {
		float: right;
		display: block;
		width: 25px;
		height: 25px;
		margin: 5px;
		background-image: url(/modules/module_scheduler/fullcalendar/images/list_delete_25px.png);
		cursor: pointer;
	} 
	.ui-accordion .ui-accordion-content-active .actions-confirm {
		float: right;
		display: block;
		width: 25px;
		height: 25px;
		margin: 5px;
		background-image: url(/modules/module_scheduler/fullcalendar/images/list_confirm_25px.png);
		cursor: pointer;
	} 
	.ui-accordion .ui-accordion-content-active .actions-info {
		float: right;
		display: block;
		width: 25px;
		height: 25px;
		margin: 5px;
		background-image: url(/modules/module_scheduler/fullcalendar/images/list_info_25px.png);
		cursor: pointer;
	} 
	
	.ui-progressbar-value { 
		background-image: url(/modules/module_scheduler/fullcalendar/images/pbar-ani.gif);
	}

	
/* selected day */
	.fc-state-selected {
		background-color: #BBD9EE;	 /*#9CB6D6;*/
	}
	.fc-state-selected-today {
		background-color: #FFCC66;
	}
	
/* right-click menu */

   .vmenu{border:1px solid #aaa;position:absolute;background:#fff;	display:none;font-size:0.75em;}
	   .vmenu .first_li span{width:100px;display:block;padding:5px 10px;cursor:pointer}
	   .vmenu .inner_li{display:none;margin-left:120px;position:absolute;border:1px solid #aaa;
		border-left:1px solid #ccc;margin-top:-28px;background:#fff;}
	   .vmenu .sep_li{border-top: 1px ridge #aaa;margin:5px 0}
	   .vmenu .fill_title{font-size:11px;font-weight:bold;/height:15px;/overflow:hidden;word-wrap:break-word;}
	   .context-label { text-transform: capitalize; }

/* filter Options menu */

    #filters { display: block; }
    .mixed-state { cursor: pointer; opacity:0.3; filter:alpha(opacity=30); }
	
	#tabs { min-width: 1130px; }
	#progressbarContainer {
		width: 300px;
		z-index: 5001;
		text-align: center;
		position: absolute;
		top: 50%;
		left: 50%;
	}
	
/* Calendar CSS */

/*
	div.available {opacity:0.4; filter:alpha(opacity=40); color: #333333;}
	div.available-accordion h3 a {opacity:0.4; filter:alpha(opacity=40);}
	div.scheduled-accordion h3 a {opacity:0.9; filter:alpha(opacity=90);}
*/


	div.available {opacity:0.5; color: #333333; filter:alpha(opacity=50);}
	div.available-accordion h3 a {opacity:0.5; filter:alpha(opacity=50);}
	div.scheduled-accordion h3 a {opacity:0.9; filter:alpha(opacity=40);}


	div .available-accordion h3 a:visited {color:#ffffff;}
	div .available-accordion h3 a:hover {font-weight:bold;}

	
	div .scheduled-accordion h3 a:visited {color:#ffffff;}
	div .scheduled-accordion h3 a:hover {font-weight:bold;}
	
	/*-- Calendar and Side Panel Container --*/
	/*
	#sidePanel { float: left; width: 150px; padding: 0 10px; border: 1px solid #ccc; background: #eee; text-align: left; }	

	#sidePanel h4 {
		font-size: 16px;
		margin-top: 0;
		padding-top: 1em;	
	}
	
	.external-event {
		margin: 10px 0;
		padding: 2px 4px;
		background: #3366CC;
		color: #fff;
		font-size: .85em;
		cursor: pointer;
	}
	
	#sidePanel p {
		margin: 1.5em 0;
		font-size: 11px;
		color: #666;
	}
	
	#sidePanel p input {
		margin: 0;
		vertical-align: middle;
	}

	#calendarWrap {
		width: 1100px;
		margin: 0 auto;
	}
	*/
.flexigrid tr td.sorted, .flexigrid div.hDiv th, .flexigrid div.bDiv td {
	display: table-cell!important;
}
	
{/literal}
</style>


<style type="text/css" id="dynamic_css"></style>

</form>
{$T_SCHEDULER_FIELD7}
<script language="javascript">

$(document).ready(function() {ldelim}
	//alert('doSomething');
	jQuery("#timezones").hide();
	//$("#timezone-list").hide();
	//$("#timezone-label").hide();
	tz_init();
	//alert(jQuery("#username").val() + " is the username");

	//var top = $(document).height() / 2;
	//var left = $(document).width() / 2;
	//var indent = $(document).width() / 4; 

	//$("#progess-overlay").addClass("progess-overlay");
	//$("#progess-overlay").css('height',$(document).height());
	//$("#progess-overlay").css('width',$(document).width());
	
		
	//$("#progressbarContainer").css('top', top);
	//$("#progressbarContainer").css('left', left - indent);

{rdelim});
{literal}
var courses = new Array(); // initializing the javascript array
var schedColors = new Array();
var availColors = checkAvailableColors();

function checkAvailableColors(){

	//alert("countAvailColors: "+countAvailColors());
	availColors = countAvailColors();
}
/*
function getAvailableColors(){
	
	 return getAvailColors();
}
*/
{/literal}
{php}

	// Google calendar Feed
	//$calendarfeed = getGoogleCalURL($USER->username);
	//$newuser = get_record('user','username',$USER->username);
	// search on email not id
	//$userprofile = get_record('user_info_data','fieldid',7,'userid',$newuser->id);
	$calendarfeed = $this->get_template_vars('T_SCHEDULER_FIELD7');//$userprofile->data;

	//Colors
	$stack = array();
	$colors = $this->get_template_vars('T_SCHEDULER_COLORS');//get_records('scheduler_colormap','enabled',1); 
	//$count = $colors.length;
 	foreach ($colors as $color)
	{
	//	$count++;
		array_push($stack, $color['colorcode']);

	} 
	//array_push($stack, "".$count);
	$color_str = implode(",", $stack);
	//$color_str = $count;
	//Courses
	
	/*
	$stack = array();
	$courses = get_my_courses($USER->id, 'visible DESC,sortorder ASC', '*', false, 0);
	
	$roles = get_records('role_assignments','userid',$USER->id,'timemodified ASC');
	
	foreach ($roles as $role)
	{
		$context = get_record('context','id',$role->contextid,'contextlevel',50);
		$course =  get_record('course','id',$context->instanceid);
		array_push($stack, $course->fullname);	
	}
	*/
	//$course_str = "";//implode(",", $stack);
	
	
	/*
	//$courses = get_my_courses($USER->id, 'enrolstartdate ASC', '*', false, 0);
	$courses = get_my_courses($USER->id, 'visible DESC, sortorder ASC', '*', false, 0);
	
	foreach ($courses as $course)
	{
		array_push($stack, $course->fullname);		
	}
	$course_str = implode(",", $stack);
	*/
	
	$usersArr = array();
	//$users = get_records("user", "confirmed", 1 , "deleted", 0);

	
	//Role
	//$sql = "SELECT * FROM {$CFG->prefix}role_assignments WHERE userid =".$USER->id;
	//$role_assignment = get_record_sql($sql);
	//$sql2 = "SELECT * FROM {$CFG->prefix}role WHERE id = ".$role_assignment->roleid;
	//$role_obj = get_record_sql($sql2);
	//$fetched = $smarty->fetch('module_scheduler.tpl');
	//echo $this->get_template_vars('T_SCHEDULER_ROLE');
	// this will output nothing as the template has not been executed
	// fetch the template to a variable
	$role = $this->get_template_vars('T_SCHEDULER_ROLE');//$role_obj->shortname;
	
	//Users...
	if($role=='administrator')
	{
	
		//Users
		$usersArr = array();
		//$sql = "SELECT * FROM {$CFG->prefix}user";
		//$sql = "SELECT * FROM {$CFG->prefix}user WHERE username NOT IN('Guest')";
		//$users = get_records_sql($sql);
		//$users = get_users_listing("username");
		$users = $this->get_template_vars('T_SCHEDULER_USERS');
	
		// Added by SMS: 8/7/2011
		// To provide admin with the view of schedules for all the students.
		array_push($usersArr, "ALL_STUDENTS");

 		foreach ($users as $user)
		{
			array_push($usersArr, $user['username']);		
		} 
		$users_str = implode(",", $usersArr);	
		
		
	}

{/php}
</script>

<form id="moodleInfo">

{php}
	if($role =='administrator')
	{
		echo '<input id="usersList" type="hidden" value="'.$users_str.'" />';
	}


{/php}
<input id ="colorList" type="hidden" value= "{php}echo $color_str;{/php}" />
<input id ="coursesList" type="hidden" value="{php}echo $course_str;{/php}"/>
<input id ="username" type="hidden" value= {$T_SCHEDULER_UNAME} />
<input id ="role" type="hidden" value={$T_SCHEDULER_ROLE} />
<input id ="calendarfeed" type="hidden" value="{php}echo $calendarfeed;{/php}" />

<div id='debug'></div>
<div class="wrapper">
    
    <div id="tabs">
        <ul id="tabs-labels">
            <li><a href="#tabs-1">Calendar</a></li>
        </ul>
        <div id="tabs-1">
            <div id="timezones"></div>
            <br />	
            <div id="users"></div>
            <br />	
            <div id="filters"></div>
            
            <div id="calendarWrap">
    			<div id="calendar"></div>
	      		<div id="sidePanel"></div>
            	<div style='clear:both'></div>
            </div>
                
    		
        </div>	
    </div>
    
    <div id='menu-wrap'></div>
		
	<div id='dialogboxes'>
		<div id="edit-recur-event-dialog" title="Edit Calendar Recurring Event"> </div>
		<div id="edit-event-dialog" title="Edit Existing Calendar Event">  </div>
		<div id="create-event-dialog" title="Create New Calendar Event">  </div>
		<div id="add-host-dialog" title="Add New Host">  </div>
        
        <div id="progressbarContainer" tabindex="-1">
        	<center><div id="progressbar"></div></center>
        </div>
        <div id="progess-overlay" style="z-index: 5000; position: absolute;"></div>
	</div>
			
	<div id='debug1'></div>
	<div id='debug2'></div>

</div><!-- End wrapper -->