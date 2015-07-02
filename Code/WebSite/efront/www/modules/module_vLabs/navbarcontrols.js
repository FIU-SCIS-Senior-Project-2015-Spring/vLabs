var timeOverIsSet = false;
var currentAppointmentId;
var currentAppointmentEndDate;
var isTimeSet = false;

function setupTimeControlButtons(){
	$("#addtime").button({
		text: false, 
		//disabled: true, 
		icons: {primary: "ui-icon-plus"}
	}).click(function(){
		var addmins = parseInt($("#timetochange").val());

		if(addmins){
			if(addmins >= 5){
				modifyAppointment(addmins,true);
			}else{
				alert("Extend Appointment: You must enter 5 minutes or more.");	
			}
		}else{
			alert("Extend Appointment: Please enter a valid number.");		
		}
	});

	$("#removetime").button({
		text: false, 
		//disabled: true, 
		icons: {primary: "ui-icon-minus"}
	}).click(function(){
		var addmins = parseInt($("#timetochange").val());

		if(addmins){
			if(addmins >= 5){
				modifyAppointment(addmins,false);
			}else{
				alert("Extend Appointment: You must enter 5 minutes or more.");	
			}
		}else{
			alert("Extend Appointment: Please enter a valid number.");		
		}
	});
	
	$("#ejecttime").button({
		text: false, 
		//disabled: true, 
		icons: {primary: "ui-icon-eject"}
	}).click(function(){
		cancelAppointment();
	});
}

function setupVMControlButtons(){
	$("#poweroffvm").button({
		text: false, 
		icons: {primary: "ui-icon-power"}
	}).click(function(){

	});

    $("#poweronvm").button({
    	text: false, 
    	icons: {primary: "ui-icon-play"}
    }).click(function(){

    });

    $("#shutdownvm").button({
    	text: false, 
    	icons: {primary: "ui-icon-stop"}
    }).click(function(){

    });
    
    $("#restartvm").button({
    	text: false, 
    	icons: {primary: "ui-icon-refresh"}
    }).click(function(){

    });
    
    $("#pausevm").button({
    	text: false, 
    	icons: {primary: "ui-icon-pause"}
    }).click(function(){

    });
    
    $("#refreshvm").button({
    	icons: {primary: "ui-icon-trash"}
    }).click(function(){

    });
}

function modifyAppointment(mins, addmins){
	if (!addmins) {
		mins = -1 * mins;
	}
	
	var success = false;
	
	$.ajax({
		type: 'POST',
		url: 'scheduler/fullcalendar/calendar.php',
		dataType: 'xml',
		async: true,
		data: {
			action: 'extendAppointment',
			//requestingUser:  $('#username').val(),
			//username: $('#username').val(),
			//hardcoded for testing purposes
			requestingUser: "icard005test",
			username: "icard005test",
			id: currentAppointmentId,
			minutes: mins,
			requestType: "User"
		},
		success: function(data){
			var successText, reason, successInt;
			
			$(data).find('reason').each(function() {
				reason = $(this).text();					  
			});
			$(data).find('success').each(function() {
				successText = $(this).text();								  
			});
			
			successInt = parseInt(successText);
			if(successInt > 0){
				success = true;
				timeOverIsSet = false;	// flag: tell the timer control to cget time left over for WS
				setTimeControl();
				
			}else{
				success = false;
				
			}
		},
		error: function(){
			alert("We were unable to modify this appointment for you. Please try again later.");
		}
	});
	return success;
}

function cancelAppointment(){
	var success = false;

	$.ajax({
		type: 'POST',
		url: 'scheduler/fullcalendar/calendar.php',
		dataType: 'xml',
		async: false,
		timeout: 4000,
		data: {
			action: 'cancelAppointment',
			requestingUser:  $('#username').val(),
			username: $('#username').val(),
			id: currentAppointmentId,
			requestType: "User"
		},
		success: function(data){
			var successText, reason, successInt;
			
			$(data).find('reason').each(function() {
				reason = $(this).text();					  
			});
			$(data).find('success').each(function() {
				successText = $(this).text();								  
			});
			
			successInt = parseInt(successText);
			
			if(successInt > 0){
				success = true;
				
			}else{
				success = false;
				
			}

			//relocate
			window.location = "KU-poweredby-ITS.html";
		},
		error: function(){
			alert("We were unable to remove this appointment. Please try again later.");
		}
	});
	return success;
}

function setTimeControl(){
	//for testing:
	var instanceid = '19281120-2fee-43bb-ab6f-de3228d6ac7b';

	if(!timeOverIsSet){	
		if(instanceid){
			$.ajax({
				type: 'POST',
				url: 'vmcontrols.php',
				dataType: 'json',
				async: true,
				data: {
					action: 'getAppointmentTimer',
					instanceId: instanceid
				},
				success: function(data){
					if(data){
						if(data.success){
							var curDate = $.fullCalendar.parseISO8601(data.curDate);
							currentAppointmentEndDate = $.fullCalendar.parseISO8601(data.endDate);
							currentAppointmentId = data.veInsSchId;

							//update timer
							$('span.clock').stop();
							var timerControl = $('span.clock').countDown({
								startNumber: curDate,
								endNumber: currentAppointmentEndDate,
								returnDate: true,
								callBack: function(me) {
									$("#timecontrols").hide();
									$(me).text('00:00:00').css('color','#b00');
									checkAppointmentOver(me);
								}
							});

							timeOverIsSet = true;
							isTimeSet = true;
						}else{
							isTimeSet = false;
							$("#addtime").button("option", "disabled", true);
							$("#removetime").button("option", "disabled", true);
							$("#ejecttime").button("option", "disabled", true);
						}
					}
				},
				error: function(){
					alert("time sync error!");
				}
			});
		}
	}else{
		// Set up Countdown
		$('span.clock').stop();
		var timerControl = $('span.clock').countDown({
			startNumber: new Date(),
			endNumber: currentAppointmentEndDate,
			returnDate: true,
			callBack: function(me) {
				$("#timecontrols").hide();
				$(me).text('00:00:00').css('color','#b00');
				checkAppointmentOver(me);
			}
		});
	}
}

function checkAppointmentOver(me){
	//for testing:
	var instanceid = '19281120-2fee-43bb-ab6f-de3228d6ac7b';
	
	$.ajax({
		type: 'POST',
		url: 'vmcontrols.php',
		dataType: 'json',
		async: true,
		data: {
			action: 'getAppointmentTimer',
			instanceId: instanceid
		},
		success: function(data){
		
			if(data){
				if(data.success){
					$(me).text('calculating...').css('color','#fff');
					timeOverIsSet = false;
					setTimeControl();
				}else{
					$(me).text('Your session is over.').css('color','#b00');
					window.location = "KU-poweredby-ITS.html";
					setTimeout(function(){ window.location.reload(); },3000);	
				}
			}
		}
	});

}

