<?php
	//include files required for efront's built in db functions
	require_once("../../../libraries/configuration.php");	
	require_once("../../../libraries/database.php");
	require_once("../../../libraries/globals.php");
	try{
		//pull enabled user types from database to populate table
		$enabledusers = eF_getTableData('module_vlabsadmin_enabled_user_types');
		$allusertypes = eF_getTableData('user_types', 'id, name');
	}catch(Exception $e){
		echo $e->getMessage();
	}
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
		<img src="/themes/default/images/16x16/add.png"><a id="adduser" href="#"> Add New User</a>
		<br>

		<!-- Add New User Dialog -->
		<div id="addDialog" title="Grant vLabs Access">
			<p>Select user types that apply:</p>
			<form>
				<fieldset>
					<?php
						foreach($allusertypes as $type){
							$id = $type['id'];
							$name = $type['name'];
							echo "<input type='checkbox' name='$name' value='$id' class='ui-widget-content'> $name";
						}
					?>
				</fieldset>
			</form>
		</div>

		<!-- module_vlabsadmin_enabled_user_types table -->
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
				$userid = $user['user_type_id'];
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
		var addDialog;
		var form;

		//load tab UI
		$("#tabs").tabs();

		//load dialog
		addDialog = $("#addDialog").dialog({
			autoOpen: false,
			height: 300,
			width: 350,
			position: {my: "center center", at: "center center", of: "#tabs"},
			modal: true,
			buttons: {
				"Submit": addUser,
				Cancel: function(){
					addDialog.dialog("close");
				}
			},
			close: function(){
				form[0].reset();
			}
		});

		//the form in the dialog
		form = addDialog.find("form").on("submit", function(event){
			event.preventDefault();
			addUser();
		});


		//when add new user is clicked
		$("#adduser").on("click", function(event){
			event.preventDefault();
			//open dialog
			addDialog.dialog("open");
		});
		

		//when a remove button is clicked
		$("#remove").on("click", function(){
			//grab the user type and id of the selected row
			//$this.parent.parent gets us to the td level in the hierarchy, the .prev gets the previous td sibling
			var user = $(this).parent().parent().prev().text();
			var userid = $(this).parent().parent().prev().prev().text();

			//make an ajax call to updateuseraccess.php to interact with the database
			$.ajax({
				url: "updateUserAccess.php",
				type: "post",
				data: {"request" : "removeuser", "utid" : userid},
				success: function(){
					//remove the row just deleted on success
					$("#" + user).fadeOut(function(){
						$("#" + user).remove();
					});
				}
			});
		});


		function addUser(){
			//grab data from form and ajax
			//close dialog and update table on ajax success

			//array to hold checked info

			var datastring = "";
	
			//for each checked box...
			$("input:checked").each(function(){
				//get the name of the user type and the id of the user type and add them to the array 
				//checkedarray.push($(this).val());
				//checkedarray.push($(this).attr("name"));
				datastring = datastring + $(this).val() + "," + $(this).attr("name") + ",";
			});

			addDialog.dialog("close");

			//make ajax call
			alert("making ajax: " + datastring);
			$.ajax({
				url: "updateUserAccess.php",
				type: "post",
				data: {"request" : "adduser", "data" : datastring},
				success: function(){
					//update table
					var temparr = datastring.split(",");
					for(var i = 0; i < temparr.length - 1; i=i+2){
						//create the table row to append
						$("#vlabsaccess").append("<tr id='" + temparr[i] + "'><td><center>" + temparr[i] + "</center></td>" + 
							"<td><center>" + temparr[i+1] + "</center></td>" + 
							"<td><center><img id='remove' title='Remove User' src='/themes/default/images/16x16/error_delete.png'></center></td></tr>" +"</tr>");
						//display it
						$("#" + temparr[i]).fadeIn(function(){});
					}
				}
			});
		}
	});
</script>
</html>