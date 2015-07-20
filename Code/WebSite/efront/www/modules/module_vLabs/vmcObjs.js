
function vmcObj()
{
    this.workingTab = currentTabSelected;
}
 
/*var obj = new vmcObj();

obj.checkRDPMachineStatus();

obj.AddX(5); 
var obj3 = new vmcObj();

*/


function checkRDPMachineStatus(init) {
	var obj = new vmcObj();
	obj.workingTab = currentTabSelected;
	var today = new Date();
	
	if(init){
		stateInterval = setInterval(function(){ checkRDPMachineStatus(false); },30000);	

	}
	
	//if(currentTabSelected){
		//var istab = currentTabSelected.indexOf("tab");
		
		if(currentTabSelected >= 0){	
			var vmname = getRdpTabInfo('veName', currentTabSelected);
			var instanceId = $('#veInsId').val();
			var hostName = getRdpTabInfo('veInsAddr', currentTabSelected);
			var hostPort = getRdpTabInfo('veInsPort', currentTabSelected);
			
			//var state = 
			obj.getInstanceState(instanceId, vmname, hostName, hostPort);
			
			/*
			setRdpTabInfo('state', obj.workingTab, state, 'checkRDPMachineStatus');
		
			if(state == 'on'){
				obj.isRDPMachineReady(instanceId, vmname, hostName, hostPort);
				//alert('here');
			}else{
				//alert("showCmdMessages(command): "+state);	
				markCurrentInstanceState(getRdpTabInfo('state',obj.workingTab), 'checkRDPMachineStatus - '+getRdpTabInfo('state',currentTabSelected));
				//alert(getRdpTabInfo('state',currentTabSelected));
				showCmdMessages(state);
				//vmInstanceCmd(command, instanceId, vmName);
			}
			*/	
	}
}

vmcObj.prototype.isRDPMachineReady = function(instanceId, vmname, hostName, hostPort) {
	var current = this;
	//this.workingTab = currentTabSelected;
	var workingTab = this.workingTab;
	var debug = "";
 
	$.ajax({
		type: 'POST',
		url: 'vmcontrols.php',
		dataType: 'json',
		async: true,
		data: {
			action: 'isRDPReady',
			hostName: hostName,
			hostPort: hostPort,
			userid: $('#userid').val(),	// JAM added: 03.21.2012
			email: $('#email').val(),
			defaultHeight: '70'
		},
		success: function(data) {
			if(data){
				if(data.success){
					if(data.ready){
						clearInterval(stateInterval);
						
						if(workingTab == currentTabSelected){
							if(!getRdpTabInfo('ready', workingTab)){
								setRdpTabInfo('ready', workingTab, true);

								if(!getRdpTabInfo('showing', workingTab)){	//if not showing
									var url = getRdpTabInfo('veInsURL', workingTab); //$("#veInsURL").val(); 
									//url = url + "&frameBpp=" + data.bpp;
									//url = url + "&frameHeight=" + data.height;
									//url = url + "&frameWidth=" + data.width;
									
									var currentSRC = $(".iframetab").attr('src');

									alert("url is: " + url + "   src is: " + currentSRC);
									//$("#mainscreenid").attr('src',url.replace(/&amp;/g,"&"));
									
									if(currentSRC == url){
									    $('#iframetab' + workingTab)[0].contentWindow.location.reload(true);
									}else{
									    $('#iframetab' + workingTab).attr('src',url.replace(/&amp;/g,"&"));
									}
									
									setRdpTabInfo('showing', workingTab, true);
								}
							}
							markCurrentInstanceState(getRdpTabInfo('state', workingTab),'isRDPMachineReady - '+getRdpTabInfo('state', workingTab));
						}
						
					}else{
						debug = "debug2 3";
						if(workingTab == currentTabSelected){
							debug = "debug2 4";
							if(getRdpTabInfo('ready', workingTab)){
								// Shows a message while waiting
								var message = "This virtual machine is not ready! Please be patient while the RDP server loads.";
								markCurrentInstanceState('disabled');
								$('#iframetab' + workingTab).attr('src','webRDPMessage.php?message='+message);

								setRdpTabInfo('ready', workingTab, false);
								setRdpTabInfo('showing', workingTab, false);
							}
						}
					}
				
				}else{
					alert("RDP Validation: " + data.reason);
					//noticeDialog("RDP Validation", data.reason, "alert");		
					setRdpTabInfo('ready', workingTab, false);
					setRdpTabInfo('showing', workingTab, false);
				}
			
			//wasRDPMachineReady = getRdpTabInfo('ready', this.workingTab);
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			// current.vmInstanceCmd('getState',instanceId, vmname);
			var header = "Instance Command Error: isRDPReady";
			var message = "Command could not be completed.";
			//noticeDialog(header, message, icon);
			//popDownErrorNoticeBox("<b>"+header+"</b><br/> "+message);
			alert(header + " " + message);
			console.log(textStatus + " " + errorThrown);
			setRdpTabInfo('ready', workingTab, false);
			//wasRDPMachineReady = false;
		}/*,
		complete: function(){
		    // Handle the complete event
		    alert('complete');
		}*/

	});
	//popDownErrorNoticeBox(debug);

}

vmcObj.prototype.getInstanceState = function(instanceId, vmName, hostName, hostPort) {
	//alert('getInstanceState: '+instanceId+" "+vmName);
	var result = '';
	var obj = this;

	$.ajax({
		type: 'POST',
		url: 'vmcontrols.php',
		dataType: 'text',
		async: true,
		data: {
			action: 'getState',
			instanceId:  instanceId,
			vmName: vmName,
			requestingUser:  $('#username').val()
		},
		success: function(data) {
			if(data){
				// result = data;
				var state = data;
				result = state;
		
				setRdpTabInfo('state', obj.workingTab, state, 'checkRDPMachineStatus');
				
				if(state == 'on'){
					obj.isRDPMachineReady(instanceId, vmName, hostName, hostPort);
					//alert('here');
				}else{
					//alert("showCmdMessages(command): "+state);	
					markCurrentInstanceState(getRdpTabInfo('state',obj.workingTab), 'checkRDPMachineStatus - '+getRdpTabInfo('state',currentTabSelected));
					//alert(getRdpTabInfo('state',currentTabSelected));
					showCmdMessages(state);
					//vmInstanceCmd(command, instanceId, vmName);
				}
			}
		}
	});
	
	return result;
}

vmcObj.prototype.vmInstanceCmd = function(command, instanceId, vmName) {
	//alert('vmInstanceCmd: '+command);
	var current = this;
	//this.workingTab = currentTabSelected;
	var workingTab = this.workingTab;

	parseStatefromCommand(command,workingTab);
	
	var isASync = true;
	if(command == "getState")
		isASync = false;
		
	$.ajax({
		type: 'POST',
		url: 'vmcontrols.php',
		dataType: 'text',
		async: true,
		data: {
			action: command,
			instanceId:  instanceId,
			vmName: vmName,
			requestingUser:  $('#username').val()
		},
		success: function(data) {
			if(data){
				if(command == "getState"){
					setRdpTabInfo('state', workingTab, data,'vmInstanceCmd: getState');
					markCurrentInstanceState(data,'vmInstanceCmd');
				}else{
					// if the command fails
					//noticeDialog("VM Command", "Please retry your request.", "alert");
					alert("Please retry your request.");	
				}
				
			}else if(command != "getState"){
								
				if(workingTab == currentTabSelected){
					//parseStatefromCommand(command, this.workingTab);
					
					setRdpTabInfo('ready', workingTab, false);
					setRdpTabInfo('showing', workingTab, false);
					
					showCmdMessages(command);
					setTimeControl();
					
					clearInterval(stateInterval);
					
					if(command == "powerOff" || command == "shutdown"){
						setRdpTabInfo('state', workingTab, 'off','vmInstanceCmd: getState');
						markCurrentInstanceState(data,'vmInstanceCmd');
					}else if(command == "suspend"){
						setRdpTabInfo('state', workingTab, 'suspended','vmInstanceCmd: getState');
						markCurrentInstanceState(data,'vmInstanceCmd');
					}else{
						current.vmInstanceCmd('getState', instanceId, vmName);	// -- original
						checkRDPMachineStatus(true);
					}
				}
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			// current.vmInstanceCmd('getState',instanceId, vmname);
			var header = "Instance Command Error: "+command;
			var message = " Command could not be completed.";
			alert(header + message);
		}

	});

}
