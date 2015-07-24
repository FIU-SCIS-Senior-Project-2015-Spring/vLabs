 //filename: calendar.js

	//Configuration
	var coursesLimit = 20;
    var usersLimit = 100;
    var eventsColors = ['A00000 ','0066CC','00CC66','FF9933','990099','cc9900','ff3399' ,'999999', '663300', '666600','008080',  'FF7F7F'];

	/* red,  , blue, green, orange, purple, mustard, pink, gray, brown, olive, teal,    pink */
	//Context menu items

	var actionNames = new Array();

	actionNames[0] = "edit";
	actionNames[1] = "confirm";
	actionNames[2] = "cancel";
	actionNames[3] = "info";

	var _id = 0;	// Id of the EventObjs

	var actionObjects = {};

    var types = [];
	var zones = [];
    var allEvents = [];
    var filteredEvents = []; 
    var courses = [];
    var filters =[];
    
        
    var current_user_role;
    var current_user_username;
    
    var SchedStart;
    var SchedEnd;
	
	var view, viewStart, viewEnd;
	
	var currentEventStart;	// most recent Event selected - dragged 
	var currentEventEnd;
	
	// Modified by SMS: 8/8/2011
	var see_calendar_username;
	// var see_calendar_as;
	var is_admin_user;
	var is_mentor_user;
	
	var isJookie = false;
	var Jookiefilter = [];

	var tags = [];		// for the affiliation ids
	
	var currentUser; // = jQuery('#username').val();
	var eventLoader = 0;
	var renderedEvents = 0;
	var debug = 4;
	
	var selectedTab;
	var loadedtab = false;
	
	var currentTimeZone;
	
	var gContextMenus = [];
	var contextMenus = [];
	var recurringClassEvents = [];
	
	var isloading_events = false;
	var isloading_eventsMessage = null;
	
	var avail_course_listing = [];
	var avail_resource_listing = [];
	
	var gcalEvents = [];
	var showingGoogle = false;
	
	//Initialization

	jQuery(document).ready(function() {
		var today = new Date();
		//console.log(jQuery('#username').val());
		//jQuery('input[id=scheduled]').attr('checked', false);//TODO:get bool from session
		//jQuery('input[id=available]').attr('checked', false);//TODO:get bool from session

		// Check if the adminCookie exist - returns selected user.
		if(getSeeCalendarAsCookies(jQuery('#username').val())){
			currentUser = getSeeCalendarAsCookies(jQuery('#username').val());
			//currentUser = 'admin';
			//console.log("This is the user name from ready true: "+currentUser);
			//getCourses(currentUser);
			
			//var courses_str = getCourses(currentUser);
			//courses = courses_str.split(",",coursesLimit);
			
		}else{
			currentUser = jQuery('#username').val();
			//console.log("This is the user name from ready: "+currentUser);
			//getHostsCourses();
		}
		
		checkUserType(currentUser);	
		
		InitializeCalendar();
		
		view = jQuery('#calendar').fullCalendar('getView');
		
		InitializeInterface();		// must be called before startCalendarTab - dependant

		
		

		//getViewCookie(jQuery('#username').val());
		//getViewCookie(currentUser);
		//getViewCurrentDate();
		
		selectedTab = jQuery("#tabs").tabs('option', 'selected');
		
		if(selectedTab == 0){
			startCalendarTab(true);
		}
		
		/*
	 	jQuery(".fc-button-month a, .fc-button-agendaWeek a, .fc-button-agendaDay a, .fc-button-agendaList a").click(function () {
			setViewCookie(currentUser);
		});
 	*/

	});


function startCalendarTab(initial) {
	
	
	if(!loadedtab){
		loadedtab = true;
		
		//view = jQuery('#calendar').fullCalendar('getView');
		var newDate = new Date();
		var year = newDate.getFullYear();
		var month = newDate.getMonth();
	
		//SchedStart = new Date(year,month-1,1,0,0,0,0);
		//SchedEnd = new Date(year,month+2,0,0,0,0,0);
		
		SchedStart = view.visStart;
		SchedEnd = view.visEnd;
		
		// Check for existing Filter Options
		GetUserView();
		
		
		var savedFilter = getFilterCookies(currentUser);
		
		if(savedFilter.length){
			filters = savedFilter;
		
		}else{
			var saved = GetUserFilterOptions();
			
			if(saved){
				filters = saved;
			}
		}
		
		getColors();
		
		currentTimeZone = jQuery.trim(GetUserDefaultTimeZone());
		
		/*var timezoneFieldOptions = "";
		for(var i = 0; i<zones.length; i++){
			timezoneFieldOptions += "<option>"+zones[i]+"</option>";
		}
		
		jQuery("#timezone-list").html(timezoneFieldOptions);
		*/
		jQuery("#timezone-list").val(currentTimeZone);
		
		
		loadAppointments(SchedStart, SchedEnd, initial, currentUser); // initial load
		//setAppointmentCSS(currentUser);			// --- Moved to the loadAppointments Function
		//Initialize main filters
	
		jQuery("#scheduled").click(function () {
			//showProgressBar(true);
			//alert("CB Debug: 1");
			checkboxClick();
			/*
			setTimeout(function(){
				showProgressBar(false);
			}, 2000);
			*/
		});
	
		jQuery("#available").click(function () {								
			//showProgressBar(true);
			//alert("CB Debug: 2");
			checkboxClick();
			/*
			setTimeout(function(){
				showProgressBar(false);
			}, 2000);
			*/
		});
		
		
		// Every 5 minutes the loadAppointments function is called
		/*
		jQuery.fjTimer({
			interval: 300000,						// 1 min = 60000, 5 min = 300000 
			repeat: true,
			tick: function(counter, timerId) {
				var header = "Calendar Update";
				var message = "Your calendar has just been updated! <br/><br/> If you were attempting to create or edit an appointment, you may have to resubmit your request."; 
				var icon = "alert";
				
				//alert('isloading_events: '+isloading_events);
				if(!isloading_events){								// Check to see if the events are already being loaded.
					
					// close any error dialog boxes
					jQuery("#calendar-notice").dialog('close');
					
					showProgressBar(true);
					loadAppointments(SchedStart, SchedEnd, false, currentUser);
					//if(counter>0){
					//	jQuery(isloading_eventsMessage).dialog('close');
					//}
					isloading_eventsMessage = noticeDialog2(header, message, icon, true);
					setTimeout(function(){
						jQuery(isloading_eventsMessage).dialog('close');		// closes the Notice after 10 seconds
					}, 10000);
					
				}
			}
		});*/
	}

}


 /************************************************************************************************************/


function InitializeCalendar(){		

	//initialExternalPanel();

	jQuery('#calendar').fullCalendar({

		header: {

			left: 'prev,next today newAppt gCal',

			center: 'title',

			right: 'month,agendaWeek,agendaDay,agendaList'

		},
		prevnextClick: function() {		
				
			showProgressBar(true);
			
			SchedStart = view.visStart;
			SchedEnd = view.visEnd;
			
			if(loadedtab){
				var viewDate = jQuery('#calendar').fullCalendar('getDate');
				setViewCurrentDate(viewDate);
			}
			
			//showProgressBar(true);
			
			loadAppointments(SchedStart, SchedEnd, false, currentUser);
			
		},
		viewDisplay: function(view) {
			//var message = "view.name: " + view.name + "\n";
			//message += "view.visStar: "+ view.visStart + "\n view.visEnd: "+view.visEnd;
			//alert(message);
			if(view.name == "agendaList"){
				if(gcalEvents){
					jQuery('#calendar').fullCalendar('removeEventSource',gcalEvents);
					//jQuery('#calendar').fullCalendar('removeEventSource',filteredEvents);
					showingGoogle = false
					renderedEvents = 0;
				}
			}
			
			if(loadedtab){
				//alert("viewDisplay: " + view.name+" renderedEvents: "+renderedEvents + " loadedtab: "+loadedtab);
				showProgressBar(true);
				
				var viewDate = jQuery('#calendar').fullCalendar('getDate');
				setViewCurrentDate(viewDate);
				setViewCookie(currentUser);
			
			
				SchedStart = view.visStart;
				SchedEnd = view.visEnd;
				
				//showProgressBar(true);
				
				loadAppointments(SchedStart, SchedEnd, false, currentUser);
		
				//checkUserType(currentUser);	
				//alert("is_mentor_user: "+is_mentor_user+" is_admin_user: "+is_admin_user);
			}
		},
		loading: function(isLoading, view){
			progressDialogBox(isLoading);
			//alert('loading: '+ view + ' '+isLoading);
		},
		allDayDefault: false,
		editable: true,
		createEventClick: function(){
			var today = new Date();
			newDialogBox(today, view, true);
		},
		showGoogleCal: function(){
			// user profile field: calendarfeed
			var calendarfeed = jQuery('#calendarfeed').val();
			
			if(view.name != "agendaList"){
		
				if(calendarfeed){
					var timezone = jQuery("#tz").val();
					if(gcalEvents){
						jQuery('#calendar').fullCalendar('removeEventSource',gcalEvents);
						renderedEvents = 0;
					}
					gcalEvents = jQuery.fullCalendar.gcalFeed(
											calendarfeed,
											{
												// put your options here
												className:       'gcal-event',
												editable:        false,
												currentTimezone: timezone
											}
										);
					
					if(!showingGoogle){	
						if(gcalEvents){
							showingGoogle = true;
							renderedEvents = 0;
							jQuery('#calendar').fullCalendar('addEventSource', gcalEvents); 
							
						}else{
							noticeDialog("Addtional Calendar Appointments","No appointments availalble to load onto scheduler.","alert");	
						}
					}else{
						showingGoogle = false;
					}
				}else{
					var steps = '<b>To get started, you must first make your Google Calendar public:</b>' +
								'<ol><li>In the Google Calendar interface, locate the "My Calendar" box on the left.</li>' +
								'<li>Click the arrow next to the calendar you need.</li>' +
								'<li>A menu will appear. Click "Share this calendar."</li>' +
								'<li>Check "Make this calendar public."</li>' +
								'<li>Make sure "Share only my free/busy information" is unchecked.</li>' +
								'<li>Click "Save."</li></ol>' +
								'<i>** The FIU Calendar Tool will not work due to permissions set by the administrator.</i><br/><br/>'+
								'<b>Then, you must obtain your calendar\'s XML feed URL:</b>' +
								'<ol><li>In the Google Calendar interface, locate the "My Calendar" box on the left</li>' +
								'<li>Click the arrow next to the calendar you need.</li>' +
								'<li>A menu will appear. Click "Calendar settings."</li>' +
								'<li>In the "Calendar Address" section of the screen, click the XML badge.</li>' +
								'<li>Your feed\'s URL will appear.</li>' +
								'<li>Save this URL in your Moodle profile, under <b>Personal Calendar</b>.</li></ol>';
	
					noticeDialog("Setup Required: XML Feed", steps,"alert");
				}
			}
		},
		eventDragStop: function( event, jsEvent, ui, view ) {
			currentEventStart = event.start.toString();
			currentEventEnd = event.end.toString();
			
			//alert(currentEventStart);
		},
		eventDrop: function( event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view ) {
			// this event has the new start from dragging accross calendar
			
			if(isEditableDate(event.start)){
				// check available slots
				//alert("allow");
				//alert('isEditableDate(currentEventStart): '+isEditableDate(currentEventStart));
				var oldStartDate = jQuery.fullCalendar.parseISO8601(currentEventStart);
				if(!oldStartDate)
					oldStartDate = new Date(currentEventStart);
					
				
				if(event.editable && isEditableDate(oldStartDate)){
					//alert('recurring: '+event.recurring);
					if(!event.recurring){
						var message = event.title + " was moved " +
								dayDelta + " days and " +
								minuteDelta + " minutes. <br/><br/>Please confirm these changes.";
						var title = "Confirm - Edit Scheduled Appointment";
						confirmModifyDialogBox(message, title, revertFunc, event, event.start, event.end);
					}else{
						// edit recuring	
						var message = "More than one event was moved " +
								dayDelta + " days and " +
								minuteDelta + " minutes. <br/><br/>Please confirm these changes.";
						var title = "Confirm - Edit Recurring Scheduled Appointments";
						confirmChangeDialogBox(message, title, event.id, dayDelta, minuteDelta, revertFunc);
		
					}
					//alert(printEvent(event));
					//modifyAppointment(event, event.start, event.end);
				}else{
					if(!isEditableDate(oldStartDate))
						noticeDialog("Invalid Request", "This appointment has already started.","alert");
						
					revertFunc();
				}
				
			}else{
				// move back to previos start time
				noticeDialog("Invalid Request", "An appointment date cannot be set in the past.","alert");
				event.start = new Date(currentEventStart);	
				event.end = new Date (currentEventEnd);
				
			}
			//alert(event.start);
			//modifyAppointment(event, event.start, event.end);
			
		},
		eventResizeStop: function( event, jsEvent, ui, view ) {
			currentEventStart = event.start.toString();
			currentEventEnd = event.end.toString();
		},
		eventResize: function( event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view ) {
			
			if(event.resourceType == "certificate"){
				if(isEditableDate(event.start) || isEditableDate(event.end)){
					// check available slots
					
					if(event.editable){
						//alert('recurring: '+event.recurring);
						if(!event.recurring){
							var message = event.title + " was moved " +
									dayDelta + " days and " +
									minuteDelta + " minutes. <br/><br/>Please confirm these changes.";
							var title = "Confirm - Edit Scheduled Appointment";
							confirmModifyDialogBox(message, title, revertFunc, event, event.start, event.end);
						}else{
							// edit recuring
							var message = "More than one event was moved " +
									dayDelta + " days and " +
									minuteDelta + " minutes. <br/><br/>Please confirm these changes.";
							var title = "Confirm - Edit Recurring Scheduled Appointments";
							confirmChangeDialogBox(message, title, event.id, dayDelta, minuteDelta, revertFunc);
						}	
						//alert(printEvent(event));
						//modifyAppointment(event, event.start, event.end);
					}else{
						revertFunc();
					}
					
				}else{
					// move back to previos start time
					noticeDialog("Invalid Request", "An appointment date cannot be set in the past.","alert");
					event.start = new Date(currentEventStart);
					event.end = new Date (currentEventEnd);	
					
				}
				
			}else{
				// move back to previos start time
				noticeDialog("Invalid Request", "A certificate appointment cannot be edited in this manner.<br/> Please you the edit appointment form.","alert");
				event.start = new Date(currentEventStart);
				event.end = new Date (currentEventEnd);	
				
			}

			
			
			
		},
		dayClick: function(date, allDay, jsEvent, view) {
	
			//showDebug();

			//if (allDay) {
				//alert('Clicked on the entire day: ' + date);
			//}else{
				//alert('Clicked on the slot: ' + date);
			//}
			
			//alert(date.getFullYear());
			//jQuery('#calendar').fullCalendar('gotoDate',date.getFullYear(), date.getMonth(), date.getDate());
			
			
			
			
			
			//jQuery('#calendar').fullCalendar('gotoDate',date.getFullYear());
/*
			if(view.name =="month"){
				// Highlights the currently selected day cell.
				jQuery(".fc-not-today").addClass("fc-state-selected");
				jQuery(".fc-today").addClass("fc-state-selected-today");
				
				jQuery(".fc-state-selected").addClass(function(){
					if(jQuery(this).hasClass("fc-not-today") == false){
						jQuery(this).addClass("fc-not-today");
					}									  
				});
				jQuery(".fc-today").addClass(function(){
					if(jQuery(this).hasClass("fc-state-highlight") == false){
						jQuery(this).addClass("fc-state-highlight");
					}								  
				});
				
				if(jQuery(this).hasClass("fc-today")){
					jQuery(this).removeClass("fc-state-highlight");
				}else if(jQuery(this).hasClass("fc-not-today")){
					jQuery(this).removeClass("fc-not-today");
				}
			}
			
	*/
	
		},
		dayDblClick: function(date, allDay, jsEvent, view) {
			//alert("Double Click");
			clearDebug();
			var today = new Date();
			if (allDay) {
				//alert('Clicked on the entire day: ' + date);
			}else{
				//alert('Clicked on the slot: ' + date);
			}
			
			if(date = isEditableDate(date)){
				var setStarttime = false;
				if(view.name == "agendaWeek" || view.name == "agendaDay"){
					newDialogBox(date, view, true);
				}else{
					(date.getDate() == today.getDate()) ? newDialogBox(date, view, true) : newDialogBox(date,view, false);
				}
			}
			
			
		},
		eventClick: function(event, jsEvent, view) { 	
			// change the border color just for fun
			
			//alert(printEvent(event));
			//alert(printTags(tags));
			
			// For events from the Google Calendar
			if (event.url) {
				window.open(event.url);
				
				return false;
			}
			
			
			if (!event.editable) {
				return;
			}
			//jQuery(this).css('border-color', '#000000');
			
			jQuery(".fc-event").removeClass('selectedEvent');
			jQuery(this).addClass('selectedEvent');
			
			return false;
							

		},
		eventDblClick: function(event, jsEvent, view) {
			
			if (jQuery.browser.msie) {
				//alert(printEvent(event));
			}
			
			correctCertificateEvent(event);
			
			// Double click on the Month, Day and Week Views. - List view does not have a DblClick
			//if (!event.editable){
			if(view.name == "agendaList"){	
				return;
			 }
			 //alert(printEvent(event));
			if(event.type == "scheduled"){
				
				if(is_mentor_user){
					
					if(!event.recurring){
						deleteDialogBox(event);
					}else{
						// delete recuring
						deleteDialogBox(event, null, true);
					}
					
				}else{
					//alert('recurring: '+event.recurring);
					
					if (!event.editable){
						return;
					}
					
					if(!event.recurring){
						editDialogBox(event,view);
					}else{
						// edit recuring
						editRecurringDialogBox(event,view);
					}
				}
				
			}else if(event.type == "available"){
				
				if(is_mentor_user){
					
					if(!event.recurring){
						editDialogBox(event,view);
					}else{
						// edit recuring
						editRecurringDialogBox(event,view);
					}
					
				}else{
					//confirmDialogBox(event, "confirm", view);	
					
					confirmDialogBox(event, view);
				}
			}
			
		},
		eventEditClick: function(event, jsEvent, view) { 
			
			 //if (!event.editable){
			//	return;
			 //}
			
			if(event.type == "scheduled"){
				//alert('recurring: '+event.recurring);
				if(!event.recurring){
					editDialogBox(event,view);
				}else{
					// edit recuring
					editRecurringDialogBox(event,view);
				}
			}else if(event.type == "available"){
				//confirmDialogBox(event, "confirm", view);	
				confirmDialogBox(event, view);
			}
			
		},
		eventCancelClick: function(event, jsEvent, view) {
			//alert(printEvent(event));
			//if (!event.editable){
			//	return;
			//}

			if(event.type == "scheduled"){
				//alert('recurring: '+event.recurring);
				if(!event.recurring){
					deleteDialogBox(event);
				}else{
					// delete recuring
					deleteDialogBox(event, null, true);
				}
				
			}
			
		},
		eventConfirmClick: function(event, jsEvent, view) { 
		
			if(event.type == "available"){
				//confirmDialogBox(event, "confirm", view);
				confirmDialogBox(event, view);
			}
		},
		eventInfoClick: function(event, jsEvent, view) { 
		
			var actions = event.actions;
			var message;
			if(jQuery.isArray(actions)){
				for(var a = 0; a<actions.length; a++){
					message = (actions[a].name == "info") ? actions[a].param : "";
				}
				noticeDialog("Appointment Information", message, "info");
			}
		},
		eventRender: function(event, element) {
			
			if(view.name != "agendaList"){
				renderedEvents++;
				//jQuery("#debug").html("eventRender: "+renderedEvents);
			}
			//setViewCookie(currentUser);
		},
		eventListRender: function() {		// Not being used or called
			renderedEvents++;
			//jQuery("#debug").html("eventRender: "+renderedEvents);
		},
		afterListRender: function() {
			//alert("afterListRender renderedEvents: "+renderedEvents);
			
			setupAccordion();
			if(view){
				showProgressBar(false);
			}
			
		},
		afterMonthRender: function() {
			//alert("afterMonthRender");
			
			if(view){
				showProgressBar(false);
			}
		},
		eventAfterRender: function(event, element, view) { 
			
			//jQuery("#debug").html("eventAfterRender: "+renderedEvents);
			//debugging("eventAfterRender: start - "+event.start);
			
			//getViewCookie(currentUser);
				
			if(event){
				
				if(event.description){
					gContextMenus.push({
									   	qtip: '#'+view.name+'-event-'+event.id,
										desc: event.description,
										id: view.name+'-event-'+event.id
										
									   });
				
				}
				
				//Check if the event is in the past, otherwise change it to editable
				if(!is_mentor_user){
					if(event.type == "scheduled"){
						//event.editable = (isEditableDate(event.start)) ? true: false;
						
						if(!isEditableDate(event.start)){
							if(!isEditableDate(event.end)){
								event.editable = false;	
							}else{
								event.editable = true;	
							}
						}else{
							event.editable = true;	
						}
					}else{
						event.editable = false;
					}
				}else{
					if(event.type == "available"){
						event.editable = (isEditableDate(event.start)) ? true: false;
					}else{
						event.editable = false;
					}
				}
				
				if(view.name != "agendaList"){
					
					
					//alert('debug: #1');
					// month, agendaDay and agendaWeek Views	
					
					//setContextMenu(event, element, view);
					//alert(element.name);
					
					var menuname, listmenu, menu, vitem, qtip,id, menuid;
					var eventNameId = "#"+view.name+"-event-"+event.id;
					var eventNameAffil = view.name+"-span-"+event.affiliation;
					
					// check affiliation Ids
					
					if(event.recurring){
						//alert(printEvent(event));
						vitem = "#"+view.name+"-vitem-"+event.affiliation;
						menuname = "#"+view.name+"-vmenu-"+event.affiliation;
						menuid = view.name+"-vmenu-"+event.affiliation;
						menu = jQuery(menuname); 
						listmenu = setContextMenu(event.affiliation, event.actions, view);
						qtip = "#"+view.name+"-event-"+event.affiliation;
						id = view.name+"-event-"+event.affiliation;
						
						jQuery(element).addClass("recurring");
						
						jQuery('<span class="recurring" id="'+eventNameAffil+'" name="'+eventNameAffil+'"></span>').appendTo(element);

						//alert("After: "+element);
						/*
						recurringClassEvents.push({
												  	affiliationId: event.affiliation,
												  	eventId: event.id
												  });
						*/
						
					}else{
						vitem = "#"+view.name+"-vitem-"+event.id;
						menuname = "#"+view.name+"-vmenu-"+event.id;
						menuid = view.name+"-vmenu-"+event.id;
						menu = jQuery(menuname); 
						listmenu = setContextMenu(event.id, event.actions, view);
						qtip = "#"+view.name+"-event-"+event.id;
						id = view.name+"-event-"+event.id;
					}
					
					//alert(printEvent(event));
					// Tracks the Ids for the context-menus and the listitems.
					contextMenus.push({
			
										menu: menu,
										vitem: vitem,
										menuname: menuname,
										menuid: menuid,
										listmenu: listmenu,
										element: element,
										event: event,
										//actions: event.actions,
										qtip: qtip,
										id: id
										
										});
					
					
					//var elementname = "#"+view.name+"-event-"+event.id;
					
					//var menuname = "#"+view.name+"-vmenu-"+event.id;
					//var listmenu = setContextMenu(event.id, event.actions, view);
					
					
					//alert(menuname+'\n debug: #2 \n'+ event.id);
					//var menu = jQuery("#"+view.name+"-vmenu-"+event.id); 
					
					// special case if event is recurring
					/*
					if(event.recurring){
						
						for(var i=0; i<tags.length; i++){
							if(tags.tagId == event.affiliation){
								for(var i=0; i<tags.length; i++){
									if(tags.tagId == event.affiliation){
										menu = jQuery("#"+view.name+"-vmenu-"+event.affiliation); 
									}
								}
							}
						}
					}
					
					*/
					
					
					
				}
				
				
				// Assigns event Actions afterRender.
				var actions = event.actions;
				
				if(jQuery.isArray(actions)){
					//alert(event.actions);
					for(var a=0; a<actions.length; a++){
						var actionId = "#fc-"+view.name+"-event-"+actions[a].name+"-"+event.id;
						var eventActionButton = jQuery(actionId);
						//alert(actionId+"\n"+actions[a].name);
						if(actions[a].name == "edit"){
							view.eventEditButtonHandler(event, eventActionButton);
						}else if(actions[a].name == "cancel"){
							view.eventCancelButtonHandler(event, eventActionButton);
						}else if(actions[a].name == "confirm"){
							view.eventConfirmButtonHandler(event, eventActionButton);
						}else if(actions[a].name == "info"){
							view.eventInfoButtonHandler(event, eventActionButton);
						}
					}
				}
				
			}
				
			//showProgressBar(true);
			if(renderedEvents > 0){
				if(eventLoader < renderedEvents-1){
						eventLoader++;
						//jQuery("#debug1").html(eventLoader);
						//jQuery("#debug2").html(renderedEvents);
	
				}else{
						//alert("addContextMenusToCalendar - gContextMenus: "+gContextMenus.length);
						eventLoader = 0;
						renderedEvents = 0;
						showProgressBar(false);
						
						setAppointmentCSS(currentUser);
						//alert("Call: addContextMenusToCalendar");
						addContextMenusToCalendar(contextMenus);
						
						
						for(var e=0; e<gContextMenus.length; e++){
							renderQtip(gContextMenus[e].id, gContextMenus[e].desc,true);
						}
						
						gContextMenus = [];
						
						
				}
				
				/*//if(debug >0){
				if(eventLoader > renderedEvents-5){
					debug--;
					alert("renderedEvents: "+renderedEvents+" eventLoader: "+eventLoader);
				}
				
				if(renderedEvents == 0)
					alert("renderedEvents: "+renderedEvents+" eventLoader: "+eventLoader);
				//debugging("eventAfterRender: end");
				*/
			}
		}

	});
}


function correctCertificateEvent(crtEvent){

	if(crtEvent.resourceType == "certificate"){
		var start = new Date(crtEvent.start);
		var end = new Date(crtEvent.start);
		
		end.setHours(end.getHours()+2);
		//end.setSeconds(end.getSeconds()-1);
		
		crtEvent.end = end;
		
		//alert(start);
		//alert(end);
	}
	

}

function addContextMenusToCalendar(contextMenus){
	
	for(var i = 0; i<contextMenus.length; i++){
		//alert("contextMenus: "+1);
		
		
		var element = contextMenus[i].element;
		var menuObj = contextMenus[i].menu;
		var vitem = contextMenus[i].vitem;
		var currentEvent = contextMenus[i].event;
		var actions = currentEvent.actions;
		var qtip = contextMenus[i].qtip;
		var id = contextMenus[i].id;
		var menuname = contextMenus[i].menuname;
		var listmenu = contextMenus[i].listmenu;
		var menuid = contextMenus[i].menuid;
		
		var loaded = false;
		
		//if(i<2){alert(printEvent(currentEvent));}
		
		jQuery(menuname).each(function(){
			loaded = true;
			jQuery(this).replaceWith(listmenu);
		});
		
		if(!loaded){	
			jQuery(listmenu).appendTo("#menu-wrap");		// prevents loading multiple
		}
		
		if (jQuery.browser.msie) {
			jQuery(element).bind('contextmenu',function(e){
				//menuObj
				var current;
		
				if(jQuery(this).hasClass("recurring")){
		
					jQuery(this).find('span.recurring').each(function(){
						current = "#"+this.id;
						current = current.replace("span", "vmenu");
						
					});
					
				}else{
				
					current = "#"+this.id;
					current = current.replace("event", "vmenu");
				}
				
				currentEvent = current.substring(current.indexOf("vmenu-")+6);
				
				jQuery(current).css({ left: e.pageX, top: e.pageY, zIndex: '2001' }).show();
				//jQuery(".vmenu").css({ left: e.pageX, top: e.pageY, zIndex: '2001' }).show();
				jQuery(".vmenu").bind('mouseleave', function(){ jQuery(this).hide(); });
							
				return false;
			});
		
		}else{
												 
			jQuery(element).contextMenu({
					menu: menuid
			},
			function(action, el, pos) {
				
				var current;
		
				if(jQuery(this).hasClass("recurring")){
		
					jQuery(this).find('span.recurring').each(function(){
						current = "#"+this.id;
						current = current.replace("span", "vmenu");
						
					});
					
				}else{
				
					current = "#"+this.id;
					current = current.replace("event", "vmenu");
				}
				
				currentEvent = current.substring(current.indexOf("vmenu-")+6);
				
				jQuery(current).css({ left: e.pageX, top: e.pageY, zIndex: '2001' }).show();
				//jQuery(".vmenu").css({ left: e.pageX, top: e.pageY, zIndex: '2001' }).show();
				jQuery(".vmenu").bind('mouseleave', function(){ jQuery(this).hide(); });
							
				return false;
			
			});
		
		}
		
		//jQuery(menu).find('.first_li').live('click',function() {
		//jQuery(menu).find("#"+view.name+"-vitem-"+event.id).click(function() {
		jQuery(menuname).find(vitem).click(function() {
																   													   
			if( jQuery(this).children().size() == 1 ) {
				
				jQuery(menuname).hide();
				//jQuery('.overlay').hide();
				//alert("clicked");
				//alert(jQuery(this).children().text());
				
				//alert(printEvent(findEvent(currentEvent)));
				jQuery(".vmenu").hide();
				var currentEvent = this.id;
				var idx = currentEvent.indexOf("vitem-")+6;
				//alert(currentEvent.substr(idx));
				performAction(findEvent(currentEvent.substr(idx)),jQuery(this).children().text(), view);
				
			}
		});
		
		jQuery(menuname+ ".vmenu").bind('mouseleave', function(){ jQuery(this).hide(); });
		
		if(jQuery.isArray(actions)){
			// Produce the qTip if any information in the info action		
			for(var a=0; a<actions.length; a++){
				if(actions[a].name == "info"){
					if(actions[a].param != ""){
						// Assign qTip to appointment Div
						//renderQtip("#"+view.name+"-event-"+event.id, actions[a].param);
						renderQtip(id, actions[a].param);
					}
				}
			}
		}
	}
	
	jQuery(".first_li , .sec_li, .inner_li span").hover(function () {
		jQuery(this).css({backgroundColor : '#E0EDFE' , cursor : 'pointer'});
		if ( jQuery(this).children().size() >0 )
			jQuery(this).find('.inner_li').show();
			jQuery(this).css({cursor : 'default'});
	},
	function () {
		jQuery(this).css('background-color' , '#fff' );
		//jQuery(this).find('.inner_li').hide();
	});
	
	//alert("END - addContextMenusToCalendar");

}

function findEvent(id){
	
	for(var i = 0; i < filteredEvents.length; i++){
		if(filteredEvents[i].recurring){
			//alert("recurring");
			if(filteredEvents[i].affiliation == id){
				return filteredEvents[i];
			}
		}else{
			if(filteredEvents[i].id == id){
				//alert("filteredEvents[i].id: "+filteredEvents[i].id + " id: "+id);
				return filteredEvents[i];
			}
		}
	}

}
//------------------------------------------------ End - InitializeCalendar

//------------------ Buffer Function - UserType ------------------------------
/*
function loadAppointments(start, end, init, username) {
	
	if(is_admin_user){
		loadHostAppointments(start, end, init, username);
	}else{
		loadUserAppointments(start, end, init, username);
	}
	
}

function scheduleAppointment(event, view){
	
	if(is_admin_user){
		scheduleHostAppointment(event, view);
	}else{
		scheduleUserAppointment(event, view);
	}
}

function confirmAppointment(event, view){
	
	if(is_admin_user){
		confirmHostAppointment(event, view);
	}else{
		confirmUserAppointment(event, view);
	}
}

function cancelAllAppointments(affiliationId){
	
	if(is_admin_user){
		cancelAllHostAppointments(affiliationId);
	}else{
		cancelAllUserAppointments(affiliationId);
	}
}

function cancelAppointment(event, createNew){
	
	if(is_admin_user){
		cancelHostAppointment(event, createNew);
	}else{
		cancelUserAppointment(event, createNew);
	}
}

function modifyAppointment(event, newStart, newEnd, multiple){
	
	if(is_admin_user){
		modifyHostAppointment(event, newStart, newEnd, multiple);
	}
	}else{
		modifyUserAppointment(event, newStart, newEnd, multiple);
	}
}*/

// No scheduleRecurringAppointment or modifyRecurringAppointment

function getHostsCourses(){
	
	//var courses_str = document.getElementById("coursesList").value;
    //    courses =  courses_str.split(",",coursesLimit);
	//var courses_str = getCourses(currentUser);
	//courses =  courses_str.split(",",coursesLimit);
	//console.log(is_admin_user);
	if(is_admin_user ==true){
		getHosts(currentUser);
	}else{
		getCourses(currentUser);
	}
}


//------------------------------------------------ End - Buffer Function - UserType 
//------------------ Utilities ------------------------------ 

function days_between(date1, date2) {

    // The number of milliseconds in one day
    var ONE_DAY = 1000 * 60 * 60 * 24

    // Convert both dates to milliseconds
    var date1_ms = date1.getTime()
    var date2_ms = date2.getTime()

    // Calculate the difference in milliseconds
    var difference_ms = Math.abs(date1_ms - date2_ms)
    
    // Convert back to days and return
    return Math.round(difference_ms/ONE_DAY)

}

function showProgressBar(show){
	jQuery('#calendar').fullCalendar('loading', view, show);	
}

function checkUserType(user){
	
	// Added by SMS: 8/7/2011
	// To support ALL_STUDENTS view
	see_calendar_username = false;
	if(user == "ALL_STUDENTS"){
		see_calendar_username = true;
		is_admin_user = false;
		is_mentor_user = false;
	}else 
	// SMS
	if(isValidAminUser(user)){
		is_admin_user = true;
		is_mentor_user = false;
	}else if(isValidMentorUser(user)){
		is_admin_user = false;
		is_mentor_user = true;
	}else{
		is_admin_user = false;
		is_mentor_user = false;
	}	
}

function getColors()
{
	var color_str = document.getElementById("colorList").value;
    schedColors =  color_str.split(",");
}

function daysInMonth(month, year) {
	return new Date(year, month, 0).getDate();
}

function printTags(tags){
	var message = "";
	
	for(var i=0; i<tags.length; i++){
		message += "id: " + tags[i].tagId + "\n";
		message += "affiliation: " + tags[i].tagList + "\n";
		message += "isrec: " + tags[i].recurring + "\n\n\n";
	}
	return message;
}

function printEvent(event){
	var message = "";
	
	message += "id: " + event.id + "\n";
	message += "affiliation: " + event.affiliation + "\n";
	message += "title: " + event.title + "\n";
	message += "resourceType: " + event.resourceType + "\n";
	message += "start: " + event.start + "\n";
	message += "end: " + event.end + "\n";
	message += "editable: " + event.editable + "\n";
	message += "className: " + event.className + "\n";
	message += "course: " + event.course + "\n";
	message += "type: " + event.type + "\n";
	message += "actions: " + "\n";
	
	for (i in event.actions){
		message += event.actions[i].name + "\n";
	}
	
	return message;
}

function isEditableDate(selected){
	var today = new Date();
	
	if(today > selected){
		return false
	}else if(selected > today){
		return selected;
	}else if(selected.getDate() == today.getDate()){
		//selected.setTime(today.getTime());
		//selected.setHours(selected.getHours()+1);
		return selected;
	}else{
		return false;	
	}
}

function resetForm(dialogContent) {
  jQuery(dialogContent).find("input").val("");
  jQuery(dialogContent).find("select").val("");
  jQuery(dialogContent).find("textarea").val("");
  
}

function setupAccordion(){
	// Resets the accord to prevent error in display


	jQuery("#accordion").accordion("destroy");               
	// Add: accordion ability to List view
	jQuery("#accordion").accordion({
		 header: "h3",
		 collapsible: true
	});
}

function isValidMentorUser(username){
	var isValid = false;
	
	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'xml',
		async: false,
		data: {
			action: 'isValidMentorUser',
			username: username
		},
		success: function(data){
			
			var success, successInt;
			
			jQuery(data).find('node').each(function() {
				success = jQuery(this).text();								  
			});
			
			successInt = parseInt(success);
			if(successInt){
				isValid = true;
			}
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	
	return isValid;
}

function isValidAminUser(username){
	var isValid = false;
	//debugging("isValidAminUser: ajax called 'isValidAminUser'");
	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'xml',
		async: false,
		data: {
			action: 'isValidAminUser',
			username: username
		},
		success: function(data){
			
			//debugging("isValidAminUser: ajax called success");
			var success, successInt;
			
			jQuery(data).find('node').each(function() {
				success = jQuery(this).text();								  
			});
			
			successInt = parseInt(success);
			if(successInt){
				isValid = true;
			}
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	//debugging("isValidAminUser: end");
	
	//alert(isValid);
	return isValid;	
}

function renderQtip(eventObjId, content, isGoogle){
	//http://craigsworks.com/projects/qtip/docs/tutorials

	var obj = document.getElementById(eventObjId);
	var title = null;
	
	if(isGoogle)
		title = "Appointment Description";
	
	jQuery(obj).qtip({
		content: {
			text: content
			//title: { text: title }
		},
		style: { 
			tip: true,
			color: '#4D9FBF',
			//title: { 'font-size': 10, 'font-weigth':'bold' },
			'font-size': 12 ,
			width: { max: 400 },
			padding: 5,
			background: '#E5F6FE',
			textAlign: 'center',
			border: {
				width: 3,
				radius: 2,
				color: '#4D9FBF'
			}
		},
		position: { 
			corner: { tooltip: 'topMiddle', target: 'bottomMiddle'},
			adjust: {
               resize: true,
               scroll: true
            }
		}
	});

	
	
	/*
	jQuery(obj).qtip({
		content: content,
		style: { 
			tip: { // Now an object instead of a string
				corner: 'topLeft', // We declare our corner within the object using the corner sub-option
				size: {
					x: 20, // Be careful that the x and y values refer to coordinates on screen, not height or width.
					y : 8 // Depending on which corner your tooltip is at, x and y could mean either height or width!
				}
			}
		},
		border: {
			width: 2,
			radius: 3,
			color: '#A2D959'
		},
		name: 'green' // Inherit the rest of the attributes from the preset dark style
	});
	
	
	*/
	
	
	
	
	//alert(eventObjId +' - '+ content);
}

//------------------------------------------------ End Utilities


//------------------ Context Menus ------------------------------
function setContextMenu(id, actions, view){
	
	var menuid = view.name+"-vmenu-"+id;
	var listitemid = view.name+"-vitem-"+id;
	var container = jQuery('<div id="'+menuid+'" class="vmenu" />');
	
	if(jQuery.isArray(actions)){
		for(i in actionNames){
	
			for(var a=0; a<actions.length; a++){
				if(actions[a].name == actionNames[i]){
					if(actions[a].name == "info"){
						var listitem = jQuery('div class="sep_li"></div>').appendTo(container);
					}
					var listitem = jQuery('<div id="'+listitemid+'" class="'+listitemid+' first_li"><span class="context-label">'+ actions[a].name +'</span></div>').appendTo(container);
					
				}
			}
		}
	}
	
	if(actions.length == 0){
		var listitem = jQuery('<div class="first_li"><span class="context-label">no options</span></div>').appendTo(container);
	}
	
	return container;

}

function performAction(event, actionName, view){
	
	if(actionName == "edit"){
		//alert('recurring: '+event.recurring);
		if(!event.recurring){
			editDialogBox(event,view);
		}else{
			//edit recurring
			editRecurringDialogBox(event,view);
		}
	}else if(actionName == "cancel"){
		//alert('recurring: '+event.recurring);
		if(!event.recurring){
			deleteDialogBox(event);	
		}else{
			//cancel recurring
			deleteDialogBox(event, null, true);
		}
	}else if(actionName == "confirm"){
		//alert(event.start);
		//alert(actionName);
		//alert(actionName);
		
		confirmDialogBox(event, view);
		//if(confirmAppointment(event, view)){}
		
		//alert("done");
			
	}else if(actionName == "create"){
		//alert(actionName);
		
		if(scheduleAppointment(event, view)){
			
			
		}
		//alert("done");
			
	}else if(actionName == "info"){
		var actions = event.actions;
		var message;
		if(jQuery.isArray(actions)){
			for(var a = 0; a<actions.length; a++){
				message = (actions[a].name == "info") ? actions[a].param : "";
			}
			noticeDialog("Appointment Information", message, "info");
		}
	}
}
//------------------------------------------------ End Context Menus


function getAvailTimeZones(){
	var username = currentUser;
	var success = false;

	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'xml',
		async: false,
		data: {
			action: 'GetAvailableTimeZoneIds',
			requestingUser:  jQuery('#username').val(),
			username: username
		},
		success: function(data){
			
			if(data){
				jQuery(data).find('zones').each(function() {
				
					var nodes  = this.getElementsByTagName('node');
					if(nodes.length >0){
						if(nodes.length!=0)
						{
							for(var n =0; n<nodes.length; n++)
							{
								zones.push(nodes[n].childNodes[0].nodeValue);
							}
						}
					}
			   });
				
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	
	return success;

}

function GetUserDefaultTimeZone(){
	var username = currentUser;
	var success = false;
	var zone;

	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'xml',
		async: false,
		data: {
			action: 'GetUserDefaultTimeZoneId',
			requestingUser:  jQuery('#username').val(),
			username:  jQuery('#username').val()
		},
		success: function(data){
			
			if(data){
				jQuery(data).find('timeZoneId').each(function() {
					zone = jQuery(this).text();				
				});

			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	
	return zone;

}

function SetUserDefaultTimeZone(timezone){
	var username = currentUser;
	var success = false;

	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'xml',
		async: false,
		data: {
			action: 'SetUserDefaultTimeZoneId',
			requestingUser:  jQuery('#username').val(),
			username: jQuery('#username').val(),
			timezone: timezone
		},
		success: function(data){
			
			if(data){
				var result, reason, successInt;
				
				jQuery(data).find('message').each(function() {
					reason = jQuery(this).text();					  
				});
				jQuery(data).find('success').each(function() {
					result = jQuery(this).text();								  
				});
				
				successInt = parseInt(result);
				
				if(successInt>0){
					success = true;
					currentTimeZone = timezone;
			
				}
				
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	
	return success;

}

function GetUserFilterOptions(){
	var username = currentUser;
	var success = false;
	var filtOpt = null;

	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'json',
		async: false,
		data: {
			action: 'getUserFilterOptions',
			requestingUser:  jQuery('#username').val(),
			username:  jQuery('#username').val()
		},
		success: function(data){
			if(data){
				var arr = jQuery.parseJSON(data);
				if(jQuery.isArray(arr)){
					filtOpt = arr;
				}
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	return filtOpt;

}

function SetUserFilterOptions(filter){
	var username = currentUser;
	var success = false;

	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'json',
		async: false,
		data: {
			action: 'setUserFilterOptions',
			requestingUser:  jQuery('#username').val(),
			username: jQuery('#username').val(),
			filter: JSON.stringify(filter)
		},
		success: function(data){
			
			if(data){
				//var result, reason, successInt;
				
				//alert(data);
				
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	
	//return success;

}

function GetUserView(){
	var username = currentUser;
	var success = false;
	var schedulerView = null;

	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'xml',
		async: false,
		data: {
			action: 'getUserView',
			requestingUser:  jQuery('#username').val(),
			username:  jQuery('#username').val()
		},
		success: function(data){
			
			if(data){
				jQuery(data).find('data').each(function() {
					schedulerView = jQuery(this).text();
					jQuery('#calendar').fullCalendar('changeView', schedulerView);
				});
			}
			
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	
	//return schedulerView;

}

function SetUserView(schedulerView){
	var username = currentUser;
	var success = false;

	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'text',
		async: false,
		data: {
			action: 'setUserView',
			requestingUser:  jQuery('#username').val(),
			username: jQuery('#username').val(),
			view: schedulerView
		},
		success: function(data){
			
			if(data){
				//var result, reason, successInt;
				
				//alert(data);
				
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			
		}
	});
	
	//return success;

}


/*
function confirmEventEdit(event){
	
	var header = "Confirm Available Appointment Time";
	var message = "The requested appointment time is available.";
	var icon = "alert";
	var success = false;
	
	if(scheduleAppointment(event)){
		noticeDialog(header, message, icon);
		success = true;
	}
	
	return success;				// confirm event change	
}
*/
function generateAppointments(events){
	var appointments = [];
	
	if(jQuery.isArray(events)){
		
		for(var i = 0; i < events.length; i++){
			
			appointments.push({
				id: events[i].id,
				userName: (events[i].userName) ? events[i].userName : "",
				start: events[i].start,
				end: events[i].end,
				resourceType: events[i].resourceType,
				course: events[i].course,
				affiliationId: (events[i].affiliationId) ? events[i].affiliationId : "",
				availabilityStatus: (events[i].availabilityStatus) ? events[i].availabilityStatus : "",
				actions: (events[i].action) ? events[i].action : null
		
			});
		
		}
	}else{
		appointments.push({
			id: events.id,
			userName: (events.userName) ? events.userName : "",
			start: events.start,
			end: events.end,
			resourceType: events.resourceType,
			course: events.course,
			affiliationId: (events.affiliationId) ? events.affiliationId : "",
			availabilityStatus: (events.availabilityStatus) ? events.availabilityStatus : "",
			actions: (events.action) ? events.action : null
	
		});
	}
	
	return appointments;
}

function generateAppointment(event){
	var appointment = [];
	
	appointment.push({
			id: event.id,
			userName: (event.userName) ? event.userName : "",
			start: event.start,
			end: event.end,
			resourceType: event.resourceType,
			course: event.course,
			affiliationId: (event.affiliationId) ? event.affiliationId : "",
			availabilityStatus: (event.availabilityStatus) ? event.availabilityStatus : "",
			actions: (event.action) ? event.action : null
	
		});
}

function getActionList(actions){
	
	var eventActions = [];
	
	if(actions){
		var newActions = actions;
		
		for(var i=0; i< newActions.length; i++){
			
				eventActions.push({
					name: newActions[i].type,
					param: newActions[i].content
				});
			
		}
	}
	/*
	}else{
		eventActions.push({
				name: "info",
				param: ""
			});
			
	}
	*/
	return eventActions;
}

//------------------------------------------------ End WS Calls


// Grabs the Event Obj from the create Apointment form
function getCreateNewEventObj(formName){
	var createDialog = jQuery(formName);
	// Retrieve Form Objects
	var startDate = jQuery(createDialog).find("input[name='startDate']");
	var endDate = jQuery(createDialog).find("input[name='endDate']");
	var startField = jQuery(createDialog).find("input[name='start']");
	var endField = jQuery(createDialog).find("input[name='end']");
	var typeField = jQuery(createDialog).find("select[name='type']");
	var courseField = jQuery(createDialog).find("select[name='course']");
	
	var startNow = jQuery(createDialog).find("input[name='startNow']");
	var isChecked = jQuery(startNow).attr('checked');
	
	/// - start now option
	if(isChecked){
		var start = new Date();
		var end = new Date(endDate.val() + " " + endField.val());
	}else{
		var start = new Date(startDate.val() + " " + startField.val());
		var end = new Date(endDate.val() + " " + endField.val());
	}		
	
	var start = new Date(startDate.val() + " " + startField.val());
	var end = new Date(endDate.val() + " " + endField.val());
	
	if(end.getTime() < start.getTime()){
		end.setDate(end.getDate()+1);  // changes month automatically
	}else if(start.getTime() == end.getTime()){
		end.setHours(end.getHours()+1);
	}

	var type = typeField.val().replace(/ /g,"-");
	var course = courseField.val();
	var actions = [];  // need to assign real actions
	actions[0] = "edit";
	actions[1] = "cancel";
	
	var eventClass = "div"+type.toLowerCase()+"-"+course.replace(/ /g, "-").toLowerCase()+" scheduled";
	var newevent = {
		resourceType: typeField.val(),
		title : typeField.val(),
		editable: true,
		start : (isChecked) ? "" : start,
		// Modified by SMS: 8/7/2011
		// Sending null as end date for when the create appointment is for a certificate.
		end: (typeField.val() == "CERTIFICATE") ? null : end,
		// end   : end,
		className : eventClass,
		allDay: false,
		course: course,
		type: type.toLowerCase(),
		actions: actions
	};	
	
	return newevent;
}


//------------------------------------------------------------------------

//VEConfiguration
function createVEConfigurationForm(){

	var dialogContent = jQuery("#tabs-2").load('modules/module_scheduler/fullcalendar/ve_configuration_form.html',function() {
			//Initialize date and time pickers
		jQuery("#startDate_admin").datepicker();
		jQuery("#endDate_admin").datepicker();
		jQuery("#start_admin").ptTimeSelect(); 
		jQuery("#end_admin").ptTimeSelect();
		
	    jQuery("#startDate_user").datepicker();
		jQuery("#endDate_user").datepicker();
		jQuery("#start_user").ptTimeSelect(); 
		jQuery("#end_user").ptTimeSelect(); 
		
		var timezoneFieldOptions = "";
		
		for(var i = 0; i<zones.length; i++){
			//console.log(zones[i]);
			timezoneFieldOptions += "<option>"+zones[i]+"</option>";
		}
		jQuery("#timezone").html(timezoneFieldOptions);
		//console.log("after html");
		jQuery("#timezone").val(currentTimeZone);
		
		jQuery("#timezone").change(function () {
			
			showProgressBar(true);
			
			var timezone = jQuery("#timezone").val();
			if(SetUserDefaultTimeZone(timezone)){
				
				//if(currentUser == jQuery('#username').val()){
					//if(is_admin_user){
						
						jQuery("#timezone-list").val(jQuery.trim(timezone));
						getConfiguration();
						loadedtab = false;
						
						//showProgressBar(true);
						//startCalendarTab(false);
					//}
				//}
						showProgressBar(false);	
				
				//loadAppointments(SchedStart, SchedEnd, false, jQuery("#username").val());
			}else{
				showProgressBar(false);
				
				// timezone was not changed. Revert
				jQuery("#timezone").val(jQuery.trim(currentTimeZone));
				
				var header = "Set Default Time Zone";
				var message = "We were unable to set your new timezone.";
				var icon = "alert";
				noticeDialog(header, message, icon);
				
			}
		});
		
		jQuery("input").focus(function() {
			jQuery("#startDate_admin").datepicker('hide');
			jQuery("#endDate_admin").datepicker('hide');
			jQuery("#startDate_user").datepicker('hide');
			jQuery("#endDate_user").datepicker('hide');
			jQuery("#ptTimeSelectCntr").hide();
		});
		
		jQuery("#start_admin").focus(function() {
			jQuery("#startDate_admin").datepicker('hide');
			jQuery("#endDate_admin").datepicker('hide');
			jQuery("#startDate_user").datepicker('hide');
			jQuery("#endDate_user").datepicker('hide');
			jQuery("#ptTimeSelectCntr").hide();
		});
		jQuery("#end_admin").focus(function() {
			jQuery("#startDate_admin").datepicker('hide');
			jQuery("#endDate_admin").datepicker('hide');
			jQuery("#startDate_user").datepicker('hide');
			jQuery("#endDate_user").datepicker('hide');
			jQuery("#ptTimeSelectCntr").hide();
		});
		jQuery("#start_user").focus(function() {
			jQuery("#startDate_admin").datepicker('hide');
			jQuery("#endDate_admin").datepicker('hide');
			jQuery("#startDate_user").datepicker('hide');
			jQuery("#endDate_user").datepicker('hide');
			jQuery("#ptTimeSelectCntr").hide();
		});
		jQuery("#end_user").focus(function() {
			jQuery("#startDate_admin").datepicker('hide');
			jQuery("#endDate_admin").datepicker('hide');
			jQuery("#startDate_user").datepicker('hide');
			jQuery("#endDate_user").datepicker('hide');
			jQuery("#ptTimeSelectCntr").hide();
		});
		
	    var wholeDateformatter = "yyyy-mm-dd'T'HH:MM:ss";	
		var dayformatter = "mm/dd/yyyy";	// mmmm d, yyyy
		var timeformatter = "h:MM TT";		// h:MM:ss TT 
		
		jQuery("#ve_configuration_save").click(function(){

			var user_startDate = jQuery("#startDate_user").val();
			var user_startTime=jQuery("#start_user").val();
			var startUser = new Date(user_startDate+" "+user_startTime);
			
			var user_endDate = jQuery("#endDate_user").val();
			var user_endTime = jQuery("#end_user").val();
			var endUser = new Date(user_endDate+" "+user_endTime);
	
			
			var admin_endDate = jQuery("#endDate_admin").val();
			var admin_endTime = jQuery("#end_admin").val();
			var endAdmin = new Date(admin_endDate+" "+admin_endTime);
			
			
			var admin_startDate =jQuery("#startDate_admin").val();
			var admin_startTime =jQuery("#start_admin").val();
			var startAdmin = new Date(admin_startDate+" "+admin_startTime);
			
			setConfiguration(startUser.format(dateformatter),endUser.format(dateformatter),
					startAdmin.format(dateformatter),endAdmin.format(dateformatter) );
		});
	
		getConfiguration();
		

	});
}



function getConfiguration(){

	var dayformatter = "mm/dd/yyyy";	// mmmm d, yyyy
	var timeformatter = "h:MM TT";		// h:MM:ss TT 

	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'json',
		async: false,
		data: {
			action: 'getConfiguration',
			requestingUser:  jQuery('#username').val(),
			username: jQuery('#username').val()
		},
		success: function(data){
			
				//var startUser = new Date(data.userStartTime);
				var startUser = new Date(jQuery.fullCalendar.parseISO8601(data.userStartTime, true));
				jQuery("#startDate_user").val(startUser.format(dayformatter));
				jQuery("#start_user").val(startUser.format(timeformatter));
				
				//var endUser = new Date(data.userEndTime);
				var endUser = new Date(jQuery.fullCalendar.parseISO8601(data.userEndTime, true));
				jQuery("#endDate_user").val(endUser.format(dayformatter));
				jQuery("#end_user").val(endUser.format(timeformatter));
		
				//var endAdmin = new Date(data.adminEndTime);
				var endAdmin = new Date(jQuery.fullCalendar.parseISO8601(data.adminEndTime, true));
				jQuery("#endDate_admin").val(endAdmin.format(dayformatter));
				jQuery("#end_admin").val(endAdmin.format(timeformatter));
	
				//var startAdmin = new Date(data.adminStartTime);
				var startAdmin = new Date(jQuery.fullCalendar.parseISO8601(data.adminStartTime, true));
				jQuery("#startDate_admin").val(startAdmin.format(dayformatter));
				jQuery("#start_admin").val(startAdmin.format(timeformatter));
				
				/*
				// sets the date range for getUserAppointments Call
				if(current_user_role == 'admin'){
					SchedStart = new Date(jQuery.fullCalendar.parseISO8601(data.adminStartTime));
					SchedEnd = new Date(jQuery.fullCalendar.parseISO8601(data.adminEndTime));
				}else{
					SchedStart = new Date(jQuery.fullCalendar.parseISO8601(data.userStartTime));
					SchedEnd = new Date(jQuery.fullCalendar.parseISO8601(data.userEndTime));
				}
				*/
			
				//jQuery("#timezone_admin").html(timezoneFieldOptions);
				//jQuery("#timezone_user").html(timezoneFieldOptions);
				
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "VE Configuration";
			var message = "We were unable retrieve the configuration.";
			var icon = "alert";
			message = textStatus + " : " +errorThrown;
			noticeDialog(header, message, icon);
			
		}
	});

}

function setConfiguration(startUser, endUser, startAdmin, endAdmin){

	
	jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'json',
		data: {
			action: 'setConfiguration',
			requestingUser:  jQuery('#username').val(),
			username: jQuery('#username').val(),
			startUser:startUser,
			endUser:endUser,
			startAdmin:startAdmin,
			endAdmin:endAdmin
		},
		success: function(data){
			
			var header = "VE Configuration";
			var message = "Configuration was saved successfully";
			var icon = "alert";
		    noticeDialog(header, message, icon);
		    				
			//if(see_calendar_as==null)
			//	see_calendar_as = jQuery('#username').val();
	
			// sets the date range for getUserAppointments Call
			if(current_user_role == 'admin'){
				SchedStart = new Date(jQuery.fullCalendar.parseISO8601(startAdmin));
				SchedEnd = new Date(jQuery.fullCalendar.parseISO8601(endAdmin));
			}else{
				SchedStart = new Date(jQuery.fullCalendar.parseISO8601(startUser));
				SchedEnd = new Date(jQuery.fullCalendar.parseISO8601(endUser));
			}
			
			
			//alert('debug1');
			//loadAppointments(SchedStart, SchedEnd, false, currentUser); 
			loadedtab = false;	// causes the calendar tab to reload when selected.
			//alert('debug2');
		    
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "VE Configuration";
			var message = "We were unable set the new configuration.";
			var icon = "alert";
			message += "<br/>" + textStatus + " : " +errorThrown;
		    noticeDialog(header, message, icon);
			
		}
	});

	

}


//Hosts
function addHost(){
	 
	 var name = jQuery("#add-host-form").find("input[name='hname']");	 
	 var sshPort = jQuery("#add-host-form").find("input[name='hsshport']");	
	 var username = jQuery("#add-host-form").find("input[name='husername']");	
	 var password = jQuery("#add-host-form").find("input[name='hpassword']");	
	 var numberCap = jQuery("#add-host-form").find("input[name='hnumcap']");	
	 var firstFreePort = jQuery("#add-host-form").find("input[name='hfreeport']");	
	 var portNumber = jQuery("#add-host-form").find("input[name='hport']");	
	 var activeChkbox = jQuery("#add-host-form").find("input[name='hactive']");
	 
	 var active = false;
	 if(activeChkbox.is(':checked'))
	 {
	 	active = true;
	 }
	  
	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'json',
		data: {
			action: 'addHost',
			requestingUser:  jQuery('#username').val(),
			name:name.val(),
			sshPort:sshPort.val(),
			username:username.val(),
			password:password.val(),
			numberCap:numberCap.val(),
			firstFreePort:firstFreePort.val(),
			portNumber:portNumber.val(),
			active:active		
		},
		success: function(data){
			
			var header = "Manage Hosts";
			var message = data.message;
			var icon = "alert";
		    noticeDialog(header, message, icon);
			
			if(data.success){
			    jQuery("#hosts").flexReload(); 
			}
		   
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Manage Hosts";
			var message = "We were unable add new host.";
			var icon = "alert";
			message += "<br/>" + textStatus + " : " +errorThrown;
		    noticeDialog(header, message, icon);
			
		}
	});
	 
	 
	 
	 
}

function deleteHost(id){


	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'json',
		data: {
			action: 'deleteHost',
			requestingUser:  jQuery('#username').val(),
			id:id
		},
		success: function(data){
			
			var header = "Manage Hosts";
			var message = data.message;
			var icon = "alert";
			noticeDialog(header, message, icon);
			
			if(data.success){
				jQuery("#hosts").flexReload(); 
			}
		   
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Manage Hosts";
			var message = "We were unable delete host.";
			var icon = "alert";
			message += "<br/>" + textStatus + " : " +errorThrown;
		    noticeDialog(header, message, icon);
			
		}
	});
	 	 
	 
}

function loadColorManager(){
 	jQuery('#mycolormanager').load('modules/module_scheduler/colormanager.php');
}

function createHostsTable(){
	
	jQuery("#hosts").flexigrid({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/flexigrid.php',
		dataType: 'json',
		colModel : [
			{display: 'Id', name : 'id', width : 30, sortable : true, align: 'center'},
			{display: 'Name', name : 'name', width : 140, sortable : true, align: 'left'},
			{display: 'SSH Port', name : 'sshPort', width : 70, sortable : true, align: 'left'},
			{display: 'Username', name : 'username', width : 110, sortable : true, align: 'left'},
			{display: 'Password', name : 'password', width : 110, sortable : true, align: 'left'},
			{display: 'Number Cap', name : 'veNumCap', width : 80, sortable : true, align: 'left'},
			{display: 'First free port', name : 'veFreePort', width : 80, sortable : true, align: 'left'},
			{display: 'Port Number', name : 'vePortNumber', width : 80, sortable : true, align: 'left'},
			{display: 'Active', name : 'active', width : 80, sortable : true, align: 'left'}
			],
		buttons : [
			{name: 'Add', bclass: 'add', onpress : doCommand},
			{name: 'Delete', bclass: 'delete', onpress : doCommand},
			{name: 'Edit', bclass: 'edit', onpress : doCommand},
			{separator: true}
			],
		searchitems : [
			{display: 'Name', name : 'name', isdefault: true}
			],
		sortname: "id",
		sortorder: "asc",
		usepager: true,
		title: 'Hosts',
		useRp: false,
		rp: 15,	
		showTableToggleBtn: false,
		singleSelect: true,
		requestingUser:  jQuery('#username').val()
	}); 

}

function doCommand(com, grid) {
	if (com == 'Edit') {
		jQuery('.trSelected', grid).each(function() {
			var id = jQuery(this).attr('id');
			id = id.substring(id.lastIndexOf('row')+3);
			editHostDialogBox(id);

		});
	} else if (com == 'Delete') {
		jQuery('.trSelected', grid).each(function() {
			var id = jQuery(this).attr('id');
			id = id.substring(id.lastIndexOf('row')+3);	
			deleteHost(id);
			
		});
	}else if(com == 'Add')
	{
		addHostDialogBox();
	}
}


//Scheduling Host Maintenance
function InitializeMaintenanceCalendar(){		

	jQuery('#host_calendar').fullCalendar({

		header: {

			left: 'prev,next today newAppt gCal',

			center: 'title',

			right: 'month,agendaWeek,agendaDay,agendaList'

		},
		allDayDefault: false,
		editable: true

	});
}


function InitializeInterface(){
	
	getAvailTimeZones();
	currentTimeZone = jQuery.trim(GetUserDefaultTimeZone());
	var timezoneFieldOptions = "TIME";
	for(var i = 0; i<zones.length; i++){
		timezoneFieldOptions += "<option>"+zones[i]+"</option>";
	}
	
	current_user_role = jQuery('#role').val();
	current_user_username = currentUser;

	
	jQuery("#timezones").append('<label id="timezone-label">Timezone &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><select id="timezone-list" />');
	jQuery("#timezone-list").html(timezoneFieldOptions);
	//jQuery("#timezone-list").val("GMT-10:00 HST");
	jQuery("#timezone-list").val(currentTimeZone);

	if(current_user_role=="administrator"){
		//tab1
		jQuery("#users").append('<label>See calendar as </label><select id="users-list" />');
	
		//tab2
		jQuery("#tabs ul").append('<li><a href="#tabs-2">VE Configuration</a></li>');
		jQuery("#tabs").append('<div id="tabs-2"></div>');
		createVEConfigurationForm();
		
		//tab3
		jQuery("#tabs ul").append('<li><a href="#tabs-3">Manage Host</a></li>');
		jQuery("#tabs").append('<div id="tabs-3"></div>');
		jQuery("#tabs-3").append('<div id="hosts"></div>');
		createHostsTable();

		//tab4
		jQuery("#tabs ul").append('<li><a href="#tabs-4">Color Manager</a></li>');
		jQuery("#tabs").append('<div id="tabs-4"></div>');
		jQuery("#tabs-4").append('<div id="mycolormanager"></div>');
		loadColorManager();
		
		//InitializeMaintenanceCalendar();

  		
		var inputText = document.getElementById("usersList").value;
		//alert(usersLimit);
		var users_str = new String(inputText);
	    var users =  users_str.split(",",7);
		
		users =  users_str.split(",");
	    
	    var selection = getSeeCalendarAsCookies( jQuery('#username').val());
		
	

		for(i in users){
			var user = users[i];
			if(isNaN(i)){
				break;
			}
			if(selection==user){
				jQuery("#users-list").append('<option value=\''+user+'\' selected=\'selected\'>'+user+'</option>');
			}else{
				jQuery("#users-list").append('<option value=\''+user+'\'>'+user+'</option>');
			}

		}
		
		jQuery("#users-list").change(function () {
			
			showProgressBar(true);
										  
			var username = jQuery("#users-list").val();
			setSeeCalendarAsCookies(jQuery("#username").val(), username);
			
			// reset the filter options
			
			/*
			jQuery('#filters').find('input').each(function (){
				this.checked = false;
			});
			jQuery('#options_pane').find('input').each(function (){
				jQuery(this).removeClass("mixed-state");		
				this.checked = false;
			});
			*/
			//alert('cleared');
			//resetCheckboxFilters(null);
			//checkboxClick();	// resets the filter Cookies
			
			deleteViewCookie(currentUser);
			setViewCookie(currentUser);
			
			currentUser = username;
			
			checkUserType(currentUser);
			
			//getCourses(username);
			//getResourcesAvailable(username);
			//alert(courses.length + ' ' + types.length);
			
			//jQuery("#options_pane").html(constructOptionTable(courses, types));
			
			/*
			getAvailTimeZones();
			
			currentTimeZone = jQuery.trim(GetUserDefaultTimeZone());
	
			var timezoneFieldOptions = "";
			for(var i = 0; i<zones.length; i++){
				timezoneFieldOptions += "<option>"+zones[i]+"</option>";
			}*/
			jQuery("#timezone-list").html(timezoneFieldOptions);
			jQuery("#timezone-list").val(currentTimeZone);
			
			loadAppointments(SchedStart, SchedEnd, false, username);
						
		});
		
	}
	
	// Set up the drop down menu
	jQuery("#timezone-list").change(function () {
			
		showProgressBar(true);
		
		var timezone = jQuery("#timezone-list").val();
		if(SetUserDefaultTimeZone(timezone)){ 
			//alert("current_user_role:"+current_user_role+" currentUser:"+currentUser);
			//if(currentUser == jQuery('#username').val()){
				//if(is_admin_user){
					//alert("#timezone-list");
					jQuery("#timezone").val(jQuery.trim(timezone));
					getConfiguration();
				//}
				
			//}
			loadAppointments(SchedStart, SchedEnd, false, currentUser);
		}else{
			showProgressBar(false);
			
			// timezone was not changed. Revert
			jQuery("#timezone-list").val(jQuery.trim(currentTimeZone));
			
			var header = "Set Default Time Zone";
			var message = "We were unable to set your new timezone.";
			var icon = "alert";
			noticeDialog(header, message, icon);
		}
	});
	
	//Filter of resources and courses
	if (jQuery.browser.msie) {
		//alert("IE:"+jQuery.browser.msie);
		var filtersDiv = jQuery('#filters');
	
		filtersDiv.append('<div class="dropDown_wrapper container_24" id="topResource_dropDown_wrapper">'+
							 '<div class="filters" id="filters_pane">'+
							 '<table><tr><td><input type="checkbox" id="scheduled" class="checkbox" name="filter" checked="checked" /><label>Scheduled Tasks</label></td></tr>'+
							 '<tr><td><input type="checkbox" id="available" class="checkbox" name="filter" checked="checked" /><label>Available Time Slots</label></td></tr></table>'+
							 '</div><div class="clear"></div>'+
							 '<div id="options_pane"></div>'+
							 '</div>');
							 
		filtersDiv.append('<div class="clear"></div>');    
		filtersDiv.append('<a href="#filterOptions" id="filterOptions_TopResources"><span class="toolbar_title">Filter Options</span></a><br/><br/>');
		
	}else{
		
		jQuery("#filters").append('<div class="dropDown_wrapper container_24" id="topResource_dropDown_wrapper">'+
							 '<div class="filters" id="filters_pane">'+
							 '<table><tr><td><input type="checkbox" id="scheduled" class="checkbox" name="filter" checked="checked" /><label>Scheduled Tasks</label></td></tr>'+
							 '<tr><td><input type="checkbox" id="available" class="checkbox" name="filter" checked="checked" /><label>Available Time Slots</label></td></tr></table>'+
							 '</div><div class="clear"></div>'+
							 '<div id="options_pane"></div>'+
							 '</div>');
							 
		jQuery("#filters").append('<div class="clear"></div>');    
		jQuery("#filters").append('<a href="#filterOptions" id="filterOptions_TopResources"><span class="toolbar_title">Filter Options</span></a><br/><br/>');
		//alert("filtersDiv.innerHTML: "+filtersDiv.innerHTML);
	}
	jQuery("#tabs").tabs();

	jQuery('#tabs').bind('tabsshow', function(event, ui) {
		//alert("tabshow");
		selectedTab = jQuery("#tabs").tabs('option', 'selected');
		//alert(ui.panel.id +' - tab change:'+selectedTab);
	
		if(selectedTab == 0){
			if(!loadedtab){
				showProgressBar(true);	
			}
			startCalendarTab(false);
		}
		
		setViewCookie(currentUser);
		/*
		if (ui.panel.id == "tabs-1") {
			startCalendarTab(false);
		}*/
		
	});
	/*
	jQuery('#tabs').bind( "tabsselect", function(event, ui) {
		alert("tabsselect");
		selectedTab = jQuery("#tabs").tabs('option', 'selected');
		if(selectedTab == 0){
			alert("loadedtab: "+loadedtab);
			if(!loadedtab){
				showProgressBar(true);	
			}
			startCalendarTab(false);
		}
		
		setViewCookie(currentUser);
	});*/


	
	/*
	jQuery("#tabs").tabs({
		select: function(event, ui) {
			
		},
		show: function(event, ui) {
			
		}
	});*/
				

}


function setSeeCalendarAsCookies(username, userSelected){

	var cookieName = username + "-seeCalendarAs";
	jQuery.cookie(cookieName, userSelected);
	

}

function getSeeCalendarAsCookies(username){

	
	var cookieName = username + "-seeCalendarAs";	
	var userSelected = jQuery.cookie(cookieName);
	
	return userSelected;

}

function setHost(id){

	 var name = jQuery("#add-host-form").find("input[name='hname']");	 
	 var sshPort = jQuery("#add-host-form").find("input[name='hsshport']");	
	 var username = jQuery("#add-host-form").find("input[name='husername']");	
	 var password = jQuery("#add-host-form").find("input[name='hpassword']");	
	 var numberCap = jQuery("#add-host-form").find("input[name='hnumcap']");	
	 var firstFreePort = jQuery("#add-host-form").find("input[name='hfreeport']");	
	 var portNumber = jQuery("#add-host-form").find("input[name='hport']");	
	 var activeChkbox = jQuery("#add-host-form").find("input[name='hactive']");
	 
	 var active = false;
	 if(activeChkbox.is(':checked'))
	 {
	 	active = true;
	 }
		
	 
	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/calendar.php',
		dataType: 'json',
		data: {
			action: 'setHost',
			requestingUser:  jQuery('#username').val(),
			id:id,
			name:name.val(),
			sshPort:sshPort.val(),
			username:username.val(),
			password:password.val(),
			numberCap:numberCap.val(),
			firstFreePort:firstFreePort.val(),
			portNumber:portNumber.val(),
			active:active
		},
		success: function(data){
			
			var header = "Manage Hosts";
			var message = data.message;
			var icon = "alert";
		    noticeDialog(header, message, icon);
		    jQuery("#hosts").flexReload(); 

		   
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Manage Hosts";
			var message = "We were unable add set host.";
			var icon = "alert";
			message += "<br/>" + textStatus + " : " +errorThrown;
		    noticeDialog(header, message, icon);
			
		}
	});
	
}

function Get_Cookie( name ) {

	var start = document.cookie.indexOf( name + "=" );
	var len = start + name.length + 1;
	if ( ( !start ) &&
	( name != document.cookie.substring( 0, name.length ) ) )
	{
	return null;
	}
	if ( start == -1 ) return null;
	var end = document.cookie.indexOf( ";", len );
	if ( end == -1 ) end = document.cookie.length;
	return unescape( document.cookie.substring( len, end ) );
}

function Delete_Cookie( name, path, domain ) {
	if ( Get_Cookie( name ) ) document.cookie = name + "=" +
	( ( path ) ? ";path=" + path : "") +
	( ( domain ) ? ";domain=" + domain : "" ) +
	";expires=Thu, 01-Jan-1970 00:00:01 GMT";
}

function process_cookies(cname){
	//reading and splitting the whole cookie
	var cookielist = unescape(document.cookie);
	var each_cookie = cookielist.split(";");
	
	for (i = 0; i < each_cookie.length; i++){
		
		if (each_cookie[i].indexOf(cname) > -1){
			var index = each_cookie[i].indexOf(cname);
			var cookie_data = each_cookie[i].substring(index);
			//alert(cookie_data);
		}
	
	}//ends FOR

}//ends process_cookie() function

