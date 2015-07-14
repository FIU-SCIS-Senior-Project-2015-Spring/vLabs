function tz_init(){
	//Remove unused update button
	jQuery("#page .navbar .navbutton").empty();
	
	//Use that place to put the timezone picker
	jQuery.ajax({
		type: 'GET',
		url: 'modules/module_scheduler/fullcalendar/timezoneManager.php',
		dataType: 'json',
		data: {
			action: 'getTimeZones'
		},
		success: function(data){
			if(data){
				//Fill select with timezones 
				var tzSelect = '<select id="tz">';

				for (var i in data.timeZoneId){
					tzSelect += '<option val="'+data.timeZoneId[i]+'">'+data.timeZoneId[i]+'</option>';
				}

				tzSelect += '</select>';
				
				//Append select to page
				jQuery("#page .navbar .navbutton").append(tzSelect);
				
				//Set the selected value to match the user's timezone
				//tz_getUserTimeZone();
				jQuery("#tz").val(jQuery.trim(currentTimeZone));
				
				//Attach a change handler to the timezone
				jQuery("#tz").bind("change",function(){
					//var tz = jQuery(this).val();
					//tz_setUserTimeZone(tz);
					
					showProgressBar(true);
	
					setTimeout(function(){		// For Safari

						var timezone = jQuery("#tz").val();
						if(SetUserDefaultTimeZone(timezone)){ 
							//alert("current_user_role:"+current_user_role+" currentUser:"+currentUser);
							//if(currentUser == jQuery('#username').val()){
								//if(is_admin_user){
									//alert("#timezone-list");
									jQuery("#ve_scheduler_form #timezone").val(jQuery.trim(timezone));
									jQuery("#timezone-list").val(jQuery.trim(timezone));
									getConfiguration();
								//}
								
							//}
							loadAppointments(SchedStart, SchedEnd, false, currentUser);
						}else{
							showProgressBar(false);
							
							// timezone was not changed. Revert
							jQuery("#tz").val(jQuery.trim(currentTimeZone));
							
							var header = "Set Default Time Zone";
							var message = "We were unable to set your new timezone.";
							var icon = "alert";
							noticeDialog(header, message, icon);
						}
					}, 2000);
					
				});
			}
		}
	});
}

function tz_getUserTimeZone(){
	jQuery.ajax({
		type: 'GET',
		url: 'modules/module_scheduler/fullcalendar/timezoneManager.php',
		dataType: 'json',
		data: {
			action: 'getUserTimeZone',
			username: currentUser
		},
		success: function(data){
			jQuery("#tz").val(jQuery.trim(data));
		}
	});	
}

function tz_setUserTimeZone(tz){
	
	jQuery.ajax({
		type: 'GET',
		url: 'modules/module_scheduler/fullcalendar/timezoneManager.php',
		dataType: 'json',
		data: {
			action: 'setUserTimeZone',
			timezone: tz,
			username: currentUser
		},
		success: function(data){
			if(data){
				//reload calendar events	
				//alert('success');
			}
		}
	});	
}	
