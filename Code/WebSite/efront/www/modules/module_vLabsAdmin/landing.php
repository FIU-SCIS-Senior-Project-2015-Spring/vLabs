<?php
	//include files required for efront's built in db functions
	require_once("../../../libraries/configuration.php");	
	require_once("../../../libraries/database.php");
	require_once("../../../libraries/globals.php");
	try{
		//pull enabled user types from database to populate table
		$enabledusers = eF_getTableData('module_vlabsadmin_enabled_user_types');
	}catch(Exception $e){
		echo $e->getMessage();
	}
?>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--Bootstrap Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- jQuery and jQueryUI-->
<script src="jquery/jquery-2.1.4.min.js"></script>
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

<!-- Latest Bootstrap compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<!-- main page -->
<div id="tabs">
	<ul>
		<li><a class="dbtab" href="#tabs-1">User Access</a></li>
		<li><a href="#tabs-2">Tab2</a></li>
	</ul>
	<!-- User Access tab -->
	<div id="tabs-1">
		<h4>Grant/Deny vLabs Access</h4>
		<img src="/themes/default/images/16x16/add.png"><a class="add" href="#"> Add New User</a>
		<br>
		<table id="vlabsaccess" class="table table-striped">
		<tr>
			<td><center><strong>User ID</strong></center></td>
			<td><center><strong>User Type</strong></center></td>
			<td><center><strong>Remove</strong></center></td>
		</tr>
		<?php
			//populate the table using the data from module_vlabsadmin_enabled_user_types
			foreach($enabledusers as $user){ //$user being the current associative array in the $enabledusers array
				//grab the user_type_name for this record
				$userid = $user['user_type_ID'];
				$usertype = $user['user_type_name'];
				echo "<tr id='$usertype'><td><center>" . $userid . "</center></td>";
				echo "<td><center>" . $usertype . "</center></td>";
				echo "<td><center><img id='remove' title='Remove User' src='/themes/default/images/16x16/error_delete.png'></center></td></tr>";
			}
		?>
		</table>
	</div>
	<div id="tabs-2">
		
	</div>
</div>
</body>
<script>
	//when the document is ready
	$(function() {	
		//load tab UI
		$("#tabs").tabs();
		
		//when add new user is clicked
		$("a.add").click(function(){
			//do stuff
		});
		
		//when a remove button is clicked
		$("#remove").on("click", function(){
			//grab the user type and id of the selected row
			var user = $(this).parent().parent().prev().text();
			var userid = $(this).parent().parent().prev().prev().text();

			//make an ajax call to updateuseraccess.php to interact with the database
			$.ajax({
				url: "updateUserAccess.php",
				type: "post",
				data: {"request" : "removeuser", "utid" : userid},
				success: function(){
					//remove the row just deleted
					alert("success");
					$("#" + user).fadeOut(function(){
						$("#" + user).remove();
					});
				}
			});
		});
	});
</script>
</html>