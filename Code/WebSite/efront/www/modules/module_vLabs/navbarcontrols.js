var timeOverIsSet = false;
var currentAppointmentId;
var currentAppointmentEndDate;
var isTimeSet = false;
var stateInterval = null;
var iscerttest = false;

function setupTimeControlButtons(){
	$("#addtime").button({
		text: false, 
		disabled: true, 
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
		disabled: true, 
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
		disabled: true, 
		icons: {primary: "ui-icon-eject"}
	}).click(function(){
		cancelAppointment();
	});
}

function setupVMControlButtons(){
	//get vm name by using the selected tab index
	//var curTab = $('#tabs').tabs("option", "active");	//0 based index

	$("#poweroffvm").button({
		text: false, 
		icons: {primary: "ui-icon-power"}
	}).click(function(){
		var instanceId = $('#veInsId').val();
		var state = getRdpTabInfo('state', currentTabSelected);
		var vmname = getRdpTabInfo('veName', currentTabSelected);
		markCurrentInstanceState("disabled");
		var bvObj = new vmcObj();
		setTimeout(function(){ buttonBundleClick('powerOff', instanceId, vmname, bvObj); },3000);
	});

    $("#poweronvm").button({
    	text: false, 
    	icons: {primary: "ui-icon-play"}
    }).click(function(){
    	var instanceId = $('#veInsId').val();
    	var state = getRdpTabInfo('state', currentTabSelected);
		var vmname = getRdpTabInfo('veName', currentTabSelected);
    	markCurrentInstanceState("disabled");
    	var bvObj = new vmcObj();
		setTimeout(function(){ buttonBundleClick('powerOn', instanceId, vmname, bvObj); },3000);
    });

    $("#shutdownvm").button({
    	text: false, 
    	icons: {primary: "ui-icon-stop"}
    }).click(function(){
    	var instanceId = $('#veInsId').val();
    	var state = getRdpTabInfo('state', currentTabSelected);
		var vmname = getRdpTabInfo('veName', currentTabSelected);
    	markCurrentInstanceState("disabled");
    	var bvObj = new vmcObj();
		setTimeout(function(){ buttonBundleClick('shutdown', instanceId, vmname, bvObj); },3000);
    });
    
    $("#restartvm").button({
    	text: false, 
    	icons: {primary: "ui-icon-refresh"}
    }).click(function(){
    	var instanceId = $('#veInsId').val();
    	var state = getRdpTabInfo('state', currentTabSelected);
		var vmname = getRdpTabInfo('veName', currentTabSelected);
    	markCurrentInstanceState("disabled");
    	var bvObj = new vmcObj();
		setTimeout(function(){ buttonBundleClick('restart', instanceId, vmname, bvObj); },3000);
    });
    
    $("#pausevm").button({
    	text: false, 
    	icons: {primary: "ui-icon-pause"}
    }).click(function(){
    	var instanceId = $('#veInsId').val();
    	var state = getRdpTabInfo('state', currentTabSelected);
		var vmname = getRdpTabInfo('veName', currentTabSelected);
    	markCurrentInstanceState("disabled");
    	var bvObj = new vmcObj();
		setTimeout(function(){ buttonBundleClick('suspend', instanceId, vmname, bvObj); },3000);
    });
    
    $("#refreshvm").button({
    	icons: {primary: "ui-icon-trash"}
    }).click(function(){
    	var instanceId = $('#veInsId').val();
    	var state = getRdpTabInfo('state', currentTabSelected);
		var vmname = getRdpTabInfo('veName', currentTabSelected);
    	markCurrentInstanceState("disabled");
    	var bvObj = new vmcObj();
		setTimeout(function(){ buttonBundleClick('refresh', instanceId, vmname, bvObj); },3000);
    });

  //   if(state)
		// markCurrentInstanceState(state);

	$("#vmcontrols").hide();
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
			requestingUser:  $('#username').val(),
			username: $('#username').val(),
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
	var instanceid = $('#veInsId').val();

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
							if(data.resourceType == "CERTIFICATE"){
								//useCertCSS = true;
								
								$("#addtime").addClass('certificate-nav');
								$("#removetime").addClass('certificate-nav');
								$("#ejecttime").addClass('certificate-nav');
								$("#timetochange").addClass('certificate-nav');
																
								$("#addtime").button("option", "disabled", false);
								$("#removetime").button("option", "disabled", true);
								$("#ejecttime").button("option", "disabled", true);

							}else{
								$("#addtime").button("option", "disabled", false);
								$("#removetime").button("option", "disabled", false);
								$("#ejecttime").button("option", "disabled", false);
							}
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
					console.error("time sync error!");
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
	var instanceId = $('#veInsId').val();
	
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

function markCurrentInstanceState(state){	
	
	if(state == "disabled"){
	
		$("#poweroffvm").button("option", "disabled", true);
		$("#poweronvm").button("option", "disabled", true);
		$("#pausevm").button("option", "disabled", true);
		$("#shutdownvm").button("option", "disabled", true);
		$("#restartvm").button("option", "disabled", true);
		$("#refreshvm").button("option", "disabled", true);
	
	}else if(state == "off"){
	
		$("#poweroffvm").button("option", "disabled", true);
		$("#poweronvm").button("option", "disabled", false);
		$("#pausevm").button("option", "disabled", true);
		$("#shutdownvm").button("option", "disabled", true);
		$("#restartvm").button("option", "disabled", true);
		$("#refreshvm").button("option", "disabled", false);
		
	}else if(state == "suspended"){
	
		$("#poweroffvm").button("option", "disabled", true);
		$("#poweronvm").button("option", "disabled", false);
		$("#pausevm").button("option", "disabled", true);
		$("#shutdownvm").button("option", "disabled", true);
		$("#restartvm").button("option", "disabled", true);
		$("#refreshvm").button("option", "disabled", false);
	
	}else if(state == "on"){
		
		$("#poweroffvm").button("option", "disabled", false);
		$("#poweronvm").button("option", "disabled", true);
		$("#pausevm").button("option", "disabled", false);
		$("#shutdownvm").button("option", "disabled", false);
		$("#restartvm").button("option", "disabled", false);
		$("#refreshvm").button("option", "disabled", false);
	
	}else{
	
		$("#poweroffvm").button("option", "disabled", true);
		$("#poweronvm").button("option", "disabled", false);
		$("#pausevm").button("option", "disabled", true);
		$("#shutdownvm").button("option", "disabled", true);
		$("#restartvm").button("option", "disabled", true);
		$("#refreshvm").button("option", "disabled", false);
		
	}	
}

function buttonBundleClick(command, instanceId, vmname, obj){
	alert("inside buttonBundleClick");
	obj.vmInstanceCmd(command, instanceId, vmname);
}

function showCmdMessages(command){
	var message = "";

	if(command == "powerOn"){
		message = "This virtual machine is turning on! This process may take from 5 seconds up to 2 minutes. So, please be patient! If you see a Terminal Server Connection Error message, you should wait for 10 seconds and try again by reloading the tab.";

	}else if(command == "powerOff"){
		message = "This virtual machine has been turned off! If you want to turn it on, you would need to click the Power On button.";

	}else if(command == "shutdown"){
		message = "This virtual machine has been shutdown! If you want to turn it on, you would need to click the Power On button.";
		
	}else if(command == "suspend"){
		message = "This virtual machine has been suspended/paused! If you want to turn it on, you would need to click the Power On button.";
		
	}else if(command == "restart"){
		message = "This virtual machine is being restarted! This process may take from 20 seconds up to 2 minutes. So, please be patient! If you see a Terminal Server Connection Error message, you should wait for 10 seconds and try reloading the tab.";
		
	}else if(command == "refresh"){
		markCurrentInstanceState('disabled');
		message = "This virtual machine is being refreshed! This process may take from 20 seconds up to 2 minutes. So, please be patient! If you see a Terminal Server Connection Error message, you should wait for 10 seconds and try reloading the tab.";
		
	}else if(command == "off"){
		message = "This virtual machine has been turned off! If you want to turn it on, you would need to click the Power On button.";
		
	}else if(command == "suspended"){
		message = "This virtual machine has been suspended/paused! If you want to turn it on, you would need to click the Power On button.";
		
	}else if(command == "on"){
		message = "This virtual machine is getting ready! This process may take from 5 seconds up to 2 minutes. So, please be patient! If you see a Terminal Server Connection Error message, you should wait for 10 seconds and try reloading the tab.";
	}

	alert(message);
}

function parseStatefromCommand(command, workingTab){
	alert("in parseStatefromCommand, working tab is: " + workingTab);
	if(command == 'powerOff' || command == 'shutdown'){
		setRdpTabInfo('state', workingTab, 'off', 'parseStatefromCommand');
	}else if(command == 'suspend'){
		setRdpTabInfo('state', workingTab, 'suspended', 'parseStatefromCommand');
	}else if(command == 'powerOn'){
		setRdpTabInfo('state', workingTab, 'on', 'parseStatefromCommand');
	}else{
		// if 'restart' or 'refresh'	
		setRdpTabInfo('state', workingTab, null, 'parseStatefromCommand');
	}
}

function setRdpTabInfo(pair, tabId, value){
	for(var i = 0; i < rdpTabInfo.length; i++){
		if(rdpTabInfo[i].tabId == tabId)
			rdpTabInfo[i][pair] = value;
	}
}
function getRdpTabInfo(pair, tabId){
	var value;
	for(var i = 0; i < rdpTabInfo.length; i++){
		if(rdpTabInfo[i].tabId == tabId)
			value = rdpTabInfo[i][pair];
	}
	return value;
}