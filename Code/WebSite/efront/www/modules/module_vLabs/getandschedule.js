var devaWasDisplayed;
var interval = -1;
var certinterval = null;
var firstTime = true;
var isLeftOpen = 0;
var iscerttest = false;
var is_admin_user = false;
var is_mentor_user = false;
var rdpTabInfo = [];
var currentTabSelected = 0; 


function reloadDevaFrontEmbedded() { 
    if(!iscerttest){
        devaWasDisplayed = getCurDevaInsInfo();
        
        if (!devaWasDisplayed) {
            // sms: updated 6/4/2011 commented out the below line
            // interval = setInterval('getCurDevaInsInfo()', 10000);
            
			if ($('#resourcetype').val() == "VIRTUAL LAB") {
				createInstantAppointmentEmbedded(
                        $('#username').val(), 
						$('#encryptedPassword').val(),
                        $('#course').val(), 
                        $('#resourcetype').val(),
						$('#hours').val(),
						$('#minutes').val());
            } else if ($('#resourcetype').val() == "CERTIFICATE"){
      //           createInstantAppointment4CTDialogBox(
      //                   $('#username').val(), 
						// $('#encryptedPassword').val(),
      //                   $('#course').val(), 
      //                   $('#resourcetype').val());
            }
        }
    }else{	//iscerttest
    	alert("in else");
  //   	alert("RDFE: in else");
		// isLeftOpen = parseInt($("#isLeftOpen").val());
		// //progressDialogBox(true);
		// if(!getUserCurApp()){
		// 	var message = "You appointment has expired.";

		// 	if(isLeftOpen == 0){
		// 		devaWasDisplayed = getCurDevaInsInfo();
		// 		alert("ELSE DEVA: " + devawasDispayed);
		// 		if (!devaWasDisplayed) {
		// 			var newevent = 
		// 				getCreateNewEventObjFromInstantApp4CTForm(
		// 					$('#username').val(), 
		// 					$('#encryptedPassword').val(),
  //                       	$('#course').val(), 
		// 					$('#resourcetype').val());
								
		// 			if (scheduleAppointmentWithEncryptedPassword(newevent, $('#username').val())) {
		// 				certinterval = setInterval('getCurDevaInsInfo()', 10000);
		// 			}
		// 		}
		// 	}else{
		// 		//closeQuizLeftOpen();	
		// 	}
		
		// }else{
		// 	alert("else2");
		// 	devaWasDisplayed = getCurDevaInsInfo();
		// 	if (!devaWasDisplayed) {
		// 			var newevent = 
		// 				getCreateNewEventObjFromInstantApp4CTForm(
		// 					$('#username').val(), 
		// 					$('#encryptedPassword').val(),
  //                       	$('#course').val(), 
		// 					$('#resourcetype').val());
			
		// 		if (scheduleAppointmentWithEncryptedPassword(newevent, $('#username').val())) {
		// 			//alert("3test: "+$('#resourcetype').val());
		// 			certinterval = setInterval('getCurDevaInsInfo()', 10000);
		// 			//getCurDevaInsInfo();
		// 		}
				
		// 	}
		// }
    }
}

function getCurDevaInsInfo() {
	devaWasDisplayed = false;
	
	var user = $('#username').val(); 
	
	var tryCount = 0;
		tryCount++;
		
		$.ajax({
			type: 'POST',
			url: 'virtuallabs-wscalls.php',
			dataType: 'json',
			async: false,
			data: {
				action: 'getDevaInsInfo',
				requestingUser: user,
				username: user,
				course: $('#course').val(),
				resourceType: $('#resourcetype').val()
			},
			success: function(vms) {
				
				var devaGraphURL = "";
				var quizURL = "";

				setupTimeControlButtons();
				setupVMControlButtons();
				if(vms != null) {
					if (vms.success) {
						//vmc_init();

						devaWasDisplayed = true;
						if (interval != -1) {
							clearInterval(interval);
							interval = -1;
						}
                            
                        // sms: updated on 6/2/2011 
						// sms: updated on 6/4/2011 commented out the below line
						// if (interval == -1) {
							//var div = "";
							//var kaseyaServer = "http://kaseya2.cis.fiu.edu/";
							//var kaseyaServer = "http://" + vms.kserver.name + ":" + vms.kserver.httpPort;
							/*
						if ($('#resourcetype').val() == "CERTIFICATE") {

							var questionsURL = '../quiz/view.php?id=1282';
							$("#devaTabs").append('<a id="questions" class="devaTabs ui-corner-all" ' + 
									' href="'+questionsURL+'"'+ 
									' target="mainscreen">'+
							'<span>Questions</span></a>');

						}
							 */
                            
                            if(iscerttest){
								// clearInterval(certinterval);
        //                         quizURL = $("#examURL").val();//var devaGraphURL = 
								
								// // Added by SMS: 8/8/2011
								// // New Window link for the questions
								// // SMS: 7/22/2014 Changed to avoid closing a cert test in the New Window
        //                         // $("#devaTabs").append('<a id="quizURL" href="'+quizURL+'" target="quizWindow" class="quizURL">New Window</a>');
        //                         $("#devaTabs").append('<a id="quizURL" href="'+quizURL+'&isinnewwindow=1" target="quizWindow" class="quizURL">New Window</a>');
								// // SMS End Change
								// //
        //                         // Quesitons Tab
								// $("#devaTabs").append('<a id="examQuestions" class="devaTabs ui-corner-all" ' + 
        //                                 ' href="#">'+
        //                         '<span>Exam Questions</span></a>');
								
								// $("#devaTabContent").hide();
								
                            }else{
                            	//load the tabs and fill in the connection info table
                            	$('#conninfotable').append("<tr><td><center>Kaseya Server</center></td><td><center>http</center></td><td><center>" 
                            		+ vms.kserver.name + ":" + vms.kserver.httpPort + "</center></td><td><center>" 
                            		+ vms.kserver.httpPort + "</center></td><td><center>" 
                            		+ vms.kserver.username +"</center></td><td><center>" 
                            		+ hideVMPassword(vms.kserver.password) + "</center></td><td><center></center></td></tr>");
                            	$('#conninfotable').append("<tr><td><center>" + vms.vmInfo[0].name + "</center></td><td><center>RDP</center></td><td><center>" 
                            		+ vms.vmInfo[0].accessAddress + "</center></td><td><center>" 
                            		+ vms.vmInfo[0].accessPort + "</center></td><td><center>" 
                            		+ vms.vmInfo[0].username +"</center></td><td><center>" 
                            		+ hideVMPassword(vms.vmInfo[0].password) + "</center></td><td><center>"
                            		+ vms.vmInfo[0].domain + "</center></td></tr>");
                            	$('#conninfotable').append("<tr><td><center>" + vms.vmInfo[1].name + "</center></td><td><center>RDP</center></td><td><center>" 
                            		+ vms.vmInfo[1].accessAddress + "</center></td><td><center>" 
                            		+ vms.vmInfo[1].accessPort + "</center></td><td><center>" 
                            		+ vms.vmInfo[1].username +"</center></td><td><center>" 
                            		+ hideVMPassword(vms.vmInfo[1].password) + "</center></td><td><center>"
                            		+ vms.vmInfo[1].domain + "</center></td></tr>");
                            	$('#conninfotable').append("<tr><td><center>" + vms.vmInfo[2].name + "</center></td><td><center>RDP</center></td><td><center>" 
                            		+ vms.vmInfo[2].accessAddress + "</center></td><td><center>" 
                            		+ vms.vmInfo[2].accessPort + "</center></td><td><center>" 
                            		+ vms.vmInfo[2].username +"</center></td><td><center>" 
                            		+ hideVMPassword(vms.vmInfo[2].password) + "</center></td><td><center>"
                            		+ vms.vmInfo[2].domain + "</center></td></tr>");
                            	$('#conninfotable').append("<tr><td><center>" + vms.vmInfo[3].name + "</center></td><td><center>RDP</center></td><td><center>" 
                            		+ vms.vmInfo[3].accessAddress + "</center></td><td><center>" 
                            		+ vms.vmInfo[3].accessPort + "</center></td><td><center>" 
                            		+ vms.vmInfo[3].username +"</center></td><td><center>" 
                            		+ hideVMPassword(vms.vmInfo[3].password) + "</center></td><td><center>"
                            		+ vms.vmInfo[3].domain + "</center></td></tr>");
                            	$('#conninfotable').append("<tr><td><center>" + vms.vmInfo[4].name + "</center></td><td><center>RDP</center></td><td><center>" 
                            		+ vms.vmInfo[4].accessAddress + "</center></td><td><center>" 
                            		+ vms.vmInfo[4].accessPort + "</center></td><td><center>" 
                            		+ vms.vmInfo[4].username +"</center></td><td><center>" 
                            		+ hideVMPassword(vms.vmInfo[4].password) + "</center></td><td><center>"
                            		+ vms.vmInfo[4].domain + "</center></td></tr>");

                            	//store vminfo
                            	for (var i=0; i<vms.vmInfo.length; i++) {
                            		//var gid = createGuacId(15);
                            		var linkURL = $("#guacUrl").val() +vms.vmInfo[i].accessPort+ '?id=' +vms.vmInfo[i].accessPort+ '&guac.hostname='+
									vms.vmInfo[i].accessAddress+'&guac.port='+vms.vmInfo[i].accessPort+
									'&guac.domain='+vms.vmInfo[i].domain+
									'&guac.username='+escape(vms.vmInfo[i].username)+
									'&guac.password=icard005test';	//vms.vmInfo[i].password 

									//alert("linkurl= " +linkURL);

                            		rdpTabInfo.push({ 
													tabId:		i+2, //because our vm tabs start at index 2 since it's 0 based
													ready:		false, 
													showing:	false, 
													state:		null,
													veInsId:	vms.vmInfo[i].veInsId,
													veInsAddr:	vms.vmInfo[i].accessAddress,
													veInsPort:	vms.vmInfo[i].accessPort,
													veName:		vms.vmInfo[i].name,
													veInsURL: 	linkURL 	
													});
                            	}
                            	console.log(rdpTabInfo);
                            	$("#wait").hide();
                            	$('#tabs').tabs("refresh");
                            	$('#tabs').show();
						 		$('#veInsId').val(vms.vmInfo[0].veInsId);
						}
						
						if(iscerttest){
							// $(".devaTabs").css({"color":"#2E6E9E", "background-color":"#86B3D5", "font-weight": "normal", "padding": "2px 5px 2px 5px"});
							// $("#examQuestions").css({"color":"#E17009", "background-color":"#DFEFFC", "font-weight": "bold", "padding": "2px 5px 12px 5px"});
							// selectTab("examQuestions");
							
							// var questionsInterval = setInterval(function(){
							//     //console.log('isLoaded: '+$("#examscreenid").contents().find("#pageLoaded").html());
							//     if($("#examscreenid").contents().find("#pageLoaded").html()){
							// 	clearInterval(questionsInterval);
							// 	progressDialogBox(false);
							//     }
							// }, 5000);
						}
					} else {
						//retry = false;
						// alert(vms.reason + " retry is: " + retry + " tryCount is:" + tryCount);
					}
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				// if (tryCount < 5) {
				// 	// alert("Trying... " + tryCount);
				// 	retry = true;
				// } else {
				// 	retry = false;
					//noticeDialog("Virtual Machine Server", message, "alert");
					console.error("ts: " + textStatus + " err: " + errorThrown);
					alert("The server may be down or too busy at this moment! " +
						"Wait for a couple of minutes and try again! " +
						"If the problem persist, you should contact sadjadi@cs.fiu.edu");

					window.location = "KU-poweredby-ITS.html";
					
				//}
			}
		});
	// } while (retry);
	
	if(!isTimeSet){
		setTimeControl();	
	}
	
	// sms: updated on 6/2/2011
	/*
	if (devaWasDisplayed) {
		
		if (firstTime) {
			firstTime = false;
		} else {
			if (interval != -1) {
				clearInterval(interval);
				interval = -1;
				// window.location.reload();
				// sms: updated 6/4/2011 added the below line
				progressDialogBox(false);
				setClick4Tabs();
			} else {
				progressDialogBox(false);
			}	
		}	
	}
	*/
	return devaWasDisplayed;
}

function createGuacId(num){
	var temp = "";
	for(var i=0; i < num; i++){
		var digit = Math.floor(Math.random()*10);
		temp += digit;
	}
	return temp;
}

function createInstantAppointmentEmbedded(username, encryptedPassword, course, type, hours, minutes) {
			                
	//progressDialogBox(true);
				
	setTimeout(function(){	// Added: to allow the progress bar to appear.
					
		var neweventWithEncryptedPassword = getCreateNewEventObjFromInstantAppEmbedded(username, encryptedPassword, course, type, hours, minutes);
		if (scheduleAppointmentWithEncryptedPassword(neweventWithEncryptedPassword, username)) {} 
		else {
			alert("Your requested appointment could not be scheduled!");
		} 				
	}, 2000);	// wait 2 seconds
				
	// sms: updated 6/4/2011 added the below line
	interval = setInterval('getCurDevaInsInfo()', 10000);

}

function getCreateNewEventObjFromInstantAppEmbedded(username, encryptedPassword, course, type, hours, minutes){
			
	var userCurTime = getUserCurrentTime(username); // new Date();
	var end = parseISO8601(userCurTime, true);
   
	end.setHours(end.getHours()+parseInt(hours));
    end.setMinutes(end.getMinutes()+parseInt(minutes));

	var typeModified = type.replace(/ /g,"-");
	var actions = [];  // need to assign real actions
	actions[0] = "edit";
	actions[1] = "cancel";
	
	var eventClass = "div"+typeModified.toLowerCase()+"-"+course.replace(/ /g, "-").toLowerCase()+" scheduled";
	var newevent = {
		resourceType: type,
		title : type,
		editable: true,
		start : "",
		end : end,
		className : eventClass,
		allDay: false,
		course: course,
		type: typeModified.toLowerCase(),
		encryptedPassword: encryptedPassword,
		actions: actions
	};	
	
	//console.log(newevent);
	return newevent;
}

function getUserCurrentTime(username) {
	
	var userCurTime = new Date();
	
	$.ajax({
		type: 'POST',
		url: 'virtuallabs-wscalls.php',
		dataType: 'json',
		async: false,
		timeout: 4000,
		data: {
			action: 'getUserCurrentTime',
			username: username
		},
		success: function(data){
			var message = "";
			
			if (data) {
				userCurTime = data;
			}
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			console.error("error:" + textStatus + "\n errorThrown: " + errorThrown);
		}
	});

	return userCurTime;
}

function scheduleAppointmentWithEncryptedPassword(eventWithEncryptedPassword, username) {
	var dateformatter = "yyyy-mm-dd'T'HH:MM:ss";	
	var success = false;
	var requestType;
	var startDate;
    
	// showProgressBar(true);
	if (eventWithEncryptedPassword.start != "") {
		startDate = event.start.format(dateformatter);
	} else {
		startDate = "";
	}
    
	requestType = getRequestType();

	$.ajax({
		type: 'POST',
		url: 'virtuallabs-wscalls.php',
		dataType: 'json',
		// sms: updated on 6/2/2011
		async: true,
		// sms: updated on 6/2/2011
		timeout: 0,
		data: {
			action: 'scheduleAppointmentsWithEncryptedPassword',
			id: '',
			requestingUser:  username, 
			username: username,
			encryptedPassword: eventWithEncryptedPassword.encryptedPassword,
			start: startDate,
			end: eventWithEncryptedPassword.end.format(dateformatter),
			resourceType: eventWithEncryptedPassword.resourceType,
			course: eventWithEncryptedPassword.course,
			affiliationId: '',
			availabilityStatus: '',
			requestType: requestType
		},
		success: function(data){
            if(!data.id){
                isScheduled = false;
                //noticeDialog("Schedule Certificate Exam", data.availabilityStatus, "alert");
				//noticeDialogWithRedirect("Schedule "  + eventWithEncryptedPassword.resourceType, data.availabilityStatus, "alert", $("#courseURL").val());
				alert("Unable to schedule appointment for " +  username + ". Please try again later.");
				window.location = "KU-poweredby-ITS.html";
            }else{
                isScheduled = true;
            }
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			// var header = "Schedule Appointment";
			// var message = "We were unable to schedule you for this appointment.<br/><br/> ** please try again later.";
			// message = textStatus + " : " +errorThrown;
			//noticeDialog(header, message, icon);
			console.error("ts: " + textStatus + " err: " + errorThrown);
			alert("We were unable to schedule you for this appointment. Please try again later.");
			window.location = "KU-poweredby-ITS-NotAvailable.html";
			// showProgressBar(false);
		}
	});
	
	// sms: updated on 6/2/2011
	// return success;
	return true;
}

function getRequestType() {
	var requestType;
	
	if(is_admin_user){
		requestType = "Host";
	}else if(is_mentor_user){
		requestType = "Mentor";
	}else{
		requestType = "User";
	}
	
	return requestType;
}

function getUserCurApp(){

	var success = false;
	var user = "icard005test"; //$('#username').val()

	$.ajax({
		type: 'POST',
		url: 'vmcontrols.php',
		dataType: 'json',
		async: false,
		data: {
			action: 'getUserCurAppId',
			requestingUser: user,
			username: user,
			course: $('#course').val(),
			resourceType: $('#resourcetype').val()
		},
		success: function(data){
			
			if(data.success){
				success = data.success;
			}
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Delete Appointment";
			var message = "We were unable to remove this appointment.<br/> **please try again later.";
			//var icon = "alert";
			//message = textStatus + " : " +errorThrown;
			//noticeDialog(header, message, icon);
			alert(message);
		}
	});
	
	return success;

}

function getCreateNewEventObjFromInstantApp4CTForm(username, course, type){

	var userCurTime = getUserCurrentTime(username); // new Date();
	var end = parseISO8601(userCurTime, true);
	end.setHours(end.getHours()+2);
	
	var typeModified = type.replace(/ /g,"-");
	var actions = [];  // need to assign real actions
	actions[0] = "edit";
	actions[1] = "cancel";
	
	var eventClass = "div"+typeModified.toLowerCase()+"-"+course.replace(/ /g, "-").toLowerCase()+" scheduled";
	var newevent = {
		resourceType: type,
		title : type,
		editable: true,
		start : "",
		end : end,
		className : eventClass,
		allDay: false,
		course: course,
		type: typeModified.toLowerCase(),
		actions: actions
	};	
	
	return newevent;
}

function hideVMPassword(password){
	var secret = "";
	
	for (i=0;i<password.length;i++){
		if(i<2 && password.length>2){
		   secret += password.charAt(i);
		}else if(i>=password.length-2 && password.length>4){
		   secret += password.charAt(i);
		}else{
		   secret += "*";
		}
	}
	return secret;
}

function fixDate(d, check) { // force d to be on check's YMD, for daylight savings purposes
	if (+d) { // prevent infinite looping on invalid dates
		while (d.getDate() != check.getDate()) {
			d.setTime(+d + (d < check ? 1 : -1) * HOUR_MS);
		}
	}
}

function parseISO8601(s, ignoreTimezone) {
	// derived from http://delete.me.uk/2005/03/iso8601.html
	// TODO: for a know glitch/feature, read tests/issue_206_parseDate_dst.html
	var m = String(s).match(/^([0-9]{4})(-([0-9]{2})(-([0-9]{2})([T ]([0-9]{2}):([0-9]{2})(:([0-9]{2})(\.([0-9]+))?)?(Z|(([-+])([0-9]{2}):([0-9]{2})))?)?)?)?$/);
	if (!m) {
		return null;
	}
	var date = new Date(m[1], 0, 1),
		check = new Date(m[1], 0, 1, 9, 0),
		offset = 0;
	if (m[3]) {
		date.setMonth(m[3] - 1);
		check.setMonth(m[3] - 1);
	}
	if (m[5]) {
		date.setDate(m[5]);
		check.setDate(m[5]);
	}
	fixDate(date, check);
	if (m[7]) {
		date.setHours(m[7]);
	}
	if (m[8]) {
		date.setMinutes(m[8]);
	}
	if (m[10]) {
		date.setSeconds(m[10]);
	}
	if (m[12]) {
		date.setMilliseconds(Number("0." + m[12]) * 1000);
	}
	fixDate(date, check);
	if (!ignoreTimezone) {
		if (m[14]) {
			offset = Number(m[16]) * 60 + Number(m[17]);
			offset *= m[15] == '-' ? 1 : -1;
		}
		offset -= date.getTimezoneOffset();
	}
	return new Date(+date + (offset * 60 * 1000));
}

function startStatusInterval(){
	checkRDPMachineStatus(true);
}