<?php
	//include files needed to use eFront's built in db functions
	require_once("../../../libraries/configuration.php");	
	require_once("../../../libraries/database.php");
	require_once("../../../libraries/globals.php");
	require_once("config.php");
?>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--jQuery-->
<script src="jquery/jquery-2.1.4.min.js"></script>
<!--Bootstrap Latest compiled and minified CSS/JS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<!-- jQueryUI-->
<?php
	//grab the theme parameter passed from the url
	$themeset = $_GET['theme'];
	//include the approriate css for the theme 
	switch ($themeset) {
		case 'default':
			echo "<link type='text/css' rel='stylesheet' href='jquery-ui-themes/themes/default/jquery-ui.css'>";
			break;
		case 'blue':
			echo "<link type='text/css' rel='stylesheet' href='jquery-ui-themes/themes/blue/jquery-ui.css'>";
			break;
		case 'bluehtml':
			echo "<link type='text/css' rel='stylesheet' href='jquery-ui-themes/themes/bluehtml/jquery-ui.css'>";
			break;
		case 'green':
			echo "<link type='text/css' rel='stylesheet' href='jquery-ui-themes/themes/green/jquery-ui.css'>";
			break;
		case 'flatgrey':
			echo "<link type='text/css' rel='stylesheet' href='jquery-ui-themes/themes/flatgrey/jquery-ui.css'>";
			break;
		default:
			echo "<link type='text/css' rel='stylesheet' href='jquery-ui-themes/themes/default/jquery-ui.css'>";
			break;
	}
?>
<script type="text/javascript" src="jquery-ui/jquery-ui.min.js"></script>
<script src="jqtimer/jquery.countdown.js"></script>

</head>
<body id="docbody">
	<input id="userid" type="hidden" value="<?php echo $_GET['uid']; ?>" />
	<input id="username" type="hidden" value="<?php echo $_GET['username']; ?>" />
	<input id="hours" type="hidden" value="<?php echo $_GET['hours']; ?>" />
	<input id="minutes" type="hidden" value="<?php echo $_GET['minutes']; ?>" />
	<input id="encryptedPassword" type="hidden" value="<?php echo $_GET['encrypted_password']; ?>" />
	<input id="courseURL" type="hidden" value="KU-poweredby-ITS.html"/>
	<input id="resourcetype" type="hidden" value="VIRTUAL LAB" />
	<input id="veInsId" type="hidden" value="false"/>
	<input id="guacUrl" type="hidden" value="<?php echo $GUACAMOLE_URL; ?>" />
	<?php
	//grab the course name
		$courseId = $_GET['course'];
		$courseInfo = eF_getTableData("courses", "name", "id=$courseId");
		foreach($courseInfo as $cinfo){
			$cname = $cinfo['name'];
			echo "<input id='course' type='hidden' value='$cname'/>";
		}
	?>

<!-- nav bar -->
<div id="toolbar" class="ui-widget-header ui-corner-all">
	<div style="display:inline">
		<div id="timecontrols" style="display:inline">
		 minutes: <input type="text" id="timetochange" name="timetochange" value="5" placeholder="5" maxlength="2" size="2">
	 	<button id="addtime">Add time to your virtual-lab appointment</button>
	 	<button id="removetime">Remove time from your virtual-lab appointment</button>
	 	<button id="ejecttime">Cancel the remaining virtual-lab appointment</button>
	 	</div>
	 	<span class="clock" style="rgb(0,0,0);"></span>
	</div>
	<div id="vmcontrols" style="display:inline">
		<button id="poweroffvm">Power Off</button>
		<button id="poweronvm">Power On</button>
		<button id="shutdownvm">Shutdown</button>
		<button id="restartvm">Restart</button>
		<button id="pausevm">Pause</button>
		<button id="refreshvm">Refresh</button>
	</div>
</div>

<!-- Tabs -->
<div id="tabs">
	<ul>
		<li><a class="nonrdptab" href="#tabs-1">Network Diagram</a></li>
		<li><a class="nonrdptab" href="#tabs-2">Connection Info</a></li>

		<li><a class="rdptab" href="#tabs-3" rel="http://vlabs-dev.cs.fiu.edu:8080/guacamole/#/client/c/vc9-50491-dc">Domain Controller</a>
		<span class="ui-icon ui-icon-extlink" role="presentation" title="Open RDP session in a new tab!"></span><li>
		
		<li><a class="rdptab" href="#tabs-4" rel="http://vlabs-dev.cs.fiu.edu:8080/guacamole/#/client/c/vc9-50492-ws1">Workstation 1</a>
		<span class="ui-icon ui-icon-extlink" role="presentation" title="Open RDP session in a new tab!"></span></li>
		
		<li><a class="rdptab" href="#tabs-5" rel="http://vlabs-dev.cs.fiu.edu:8080/guacamole/#/client/c/vc9-50493-ws2">Workstation 2</a>
		<span class="ui-icon ui-icon-extlink" role="presentation" title="Open RDP session in a new tab!"></span><li>
		
		<li><a class="rdptab" href="#tabs-6" rel="http://vlabs-dev.cs.fiu.edu:8080/guacamole/#/client/c/vc9-50494-reception">Reception</a>
		<span class="ui-icon ui-icon-extlink" role="presentation" title="Open RDP session in a new tab!"></span><li>
		
		<li><a class="rdptab" href="#tabs-7" rel="http://vlabs-dev.cs.fiu.edu:8080/guacamole/#/client/c/vc9-50492-laptop-ceo">Laptop-Ceo</a>
		<span class="ui-icon ui-icon-extlink" role="presentation" title="Open RDP session in a new tab!"></span><li>
	</ul>
	<!-- Network Diagram -->
	<div id="tabs-1"> 
		<center><img src=http://ita-portal.cis.fiu.edu/mod/deva/embedded/img/K2-3_Network-Diagram.png></center>
	</div>
	<!-- Connection Info -->
	<div id="tabs-2">
		<table id="conninfotable" class="table table-striped">
			<tr>
				<td><center><strong>Machine Name</strong></center></td>
				<td><center><strong>Connection Protocol</strong></center></td>
				<td><center><strong>Host Name</strong></center></td>
				<td><center><strong>Host Port</strong></center></td>
				<td><center><strong>Username</strong></center></td>
				<td><center><strong>Password</strong></center></td>
				<td><center><strong>Domain</strong></center></td>
			</tr>
		</table>
	</div>
	<!-- RDP session tabs -->
	<div id="tabs-3" class="tabwhitespace">
	</div>
	<div id="tabs-4" class="tabwhitespace">
	</div>
	<div id="tabs-5" class="tabwhitespace">
	</div>
	<div id="tabs-6" class="tabwhitespace">
	</div>
	<div id="tabs-7" class="tabwhitespace">
	</div>
</div>
</body>
<script type="text/javascript" src="scheduler/fullcalendar/fullcalendar.js"></script>
<script type="text/javascript" src="dateFormat.js"></script>
<script type="text/javascript" src="navbarcontrols.js"></script> 
<script type="text/javascript" src="getandschedule.js"></script>
<script type="text/javascript" src="vmcObjs.js"></script> 
<script>
	$(function() {
		//initialize tab UI but hide until user is verified and the tabs have been properly loaded
		$("#tabs").tabs();
		$("#tabs").hide();

		//load the user's instance
		reloadDevaFrontEmbedded();
		setTimeControl();
		startStatusInterval();

		//clicking a rdp tab
		$("a.rdptab").click(function(){
			currentTabSelected = $('#tabs').tabs("option", "active");	//0 based index
			//show vm controls
			$("#vmcontrols").show();
			loadTab($(this).attr("href"), $(this).attr("rel"));		
		});

		//clicking a non-rdp tab
		$("a.nonrdptab").click(function(){
			currentTabSelected = $('#tabs').tabs("option", "active");	//0 based index
			//hide vm controls
			$("#vmcontrols").hide();
		});
		
		//new tab button clicks
		$("span.ui-icon-extlink").click(function(){
			//grab the appropriate rdp link
			var link = $(this).prev().attr("rel");
			window.open(link);
		});
		
		//handle clicking outside the frame
		$(".tabwhitespace, .tabIframeWrapper").click(function(){
			$("iframe").focus();
		});
	});

function loadTab(tab, url){
	if($(tab).find("iframe").length != 0){
		//just refocus the tab to the frame
		$("iframe").focus();
	}
	else{
		//create and load iframe
		var html = [];
		html.push('<div class="tabIframeWrapper">');
		html.push('<iframe class="iframetab" src="' + url + '" width="100%" height="70%" style="border:none"></iframe>');
		html.push('</div>');
		$(tab).append(html.join(""));
		$("iframe").focus();
	}
}
</script>
</html>