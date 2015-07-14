//filename: filters.js

//------------------ Filter Options & View Cookies ------------------------------ 

function setViewCurrentDate(viewDate){
	var cookieName = "calendarViewDate";
	//alert("set viewDate: "+viewDate);
	
	jQuery.Jookie.Initialise(cookieName, -1);
	jQuery.Jookie.Set(cookieName, "current", viewDate);
}

function getViewCurrentDate(){
	var cookieName = "calendarViewDate";
	
	jQuery.Jookie.Initialise(cookieName, -1);	
	var value = jQuery.Jookie.Get(cookieName, "current");
	var viewDate = jQuery.fullCalendar.parseDate(value);
	
	//alert("get viewDate: "+viewDate);
	if(viewDate){
		jQuery('#calendar').fullCalendar('gotoDate', viewDate.getFullYear(), viewDate.getMonth(), viewDate.getDate());
	}
}


function deleteViewCookie(username){
	var role = jQuery('#role').val();
	var cookieName;
	
	if(role == 'admin'){
		cookieName = jQuery('#username').val() + '-filterOpts';
	}else{
		cookieName = username + '-filterOpts';
	}
	jQuery.Jookie.Delete(cookieName);
}

function setViewCookie(username){
	var role = jQuery('#role').val();
	//var cookieName = username + '-filterOpts';
	var cookieName, savedView;
	
	if(role == 'admin'){
		cookieName = jQuery('#username').val() + '-filterOpts';
		savedView = jQuery('#calendar').fullCalendar('getView');
	}else{
		cookieName = username + '-filterOpts';
		savedView = jQuery('#calendar').fullCalendar('getView');
	}
	
	//alert("set viewName: "+savedView.name);
	//jQuery.Jookie.Delete(cookieName);
	Delete_Cookie(username);
	//process_cookies(cookieName);
	//alert('deleted');
	jQuery.Jookie.Initialise(cookieName, -1);
	//jQuery.Jookie.Unset(cookieName, "filter-view");
	jQuery.Jookie.Set(cookieName, "filter-view", savedView.name);
	jQuery.Jookie.Set(cookieName, "tab-view", selectedTab);
	
	SetUserView(savedView.name);
}

function getViewCookie(username){
	var role = jQuery('#role').val();
	//var cookieName = username + '-filterOpts';
	var cookieName, viewName;
	
	if(role == 'admin'){
		cookieName = jQuery('#username').val() + '-filterOpts';
	}else{
		cookieName = username + '-filterOpts';
	}
		
	jQuery.Jookie.Initialise(cookieName, -1);	
	viewName = jQuery.Jookie.Get(cookieName, "filter-view");
	selectedTab = jQuery.Jookie.Get(cookieName, "tab-view");
	
	//alert("get viewName: "+viewName);
	
	var jQuerytabs = jQuery('#tabs').tabs();
	jQuerytabs.tabs('select', selectedTab); // switch to third tab

	if(viewName){
		jQuery('#calendar').fullCalendar('changeView', viewName);
	}
	
}

function setFilterCookies(username, filterOpts){
	//alert('setFilterCookies');
	var role = jQuery('#role').val();
	var cookieName;
	
	if(role == 'admin'){
		cookieName = jQuery('#username').val() + '-filterOpts';
	}else{
		cookieName = username + '-filterOpts';
	}
	
	if(filterOpts.length > 0){
		// initialise a cookie that lives for the length of the browser session
		jQuery.Jookie.Delete(cookieName);
		jQuery.Jookie.Initialise(cookieName, -1);
		//jQuery.Jookie.Unset(cookieName, "filter-length");
		jQuery.Jookie.Set(cookieName, "filter-length", filterOpts.length);
	
		for(i in filterOpts){
		   var filter = filterOpts[i];
		   var type = 'type-' + i;
		   var course = 'course-' + i;
		   var resourceType = 'resourceType-' + i;
		   
		   
		   // jQuery.Jookie.Unset(cookieName, type);
		   //jQuery.Jookie.Unset(cookieName, course);
		   //jQuery.Jookie.Unset(cookieName, resourceType);
		   jQuery.Jookie.Set(cookieName, type, filter.type);
		   jQuery.Jookie.Set(cookieName, course, filter.course);
		   jQuery.Jookie.Set(cookieName, resourceType, filter.resourceType);
		}
	
		SetUserFilterOptions(filterOpts);
	}
}

function getFilterCookies(username){
	var role = jQuery('#role').val();
	var cookieName;
	var savedfilter = []; 
	
	if(role == 'admin'){
		cookieName = jQuery('#username').val() + '-filterOpts';
	}else{
		cookieName = username + '-filterOpts';
	}
	
	var flength = parseInt(jQuery.Jookie.Get(cookieName, "filter-length"));
	
	if(flength > 0){
		for (var i = 0; i < flength; i++){
			var type = 'type-' + i;
			var course = 'course-' + i;
			var resourceType = 'resourceType-' + i;
			   
			savedfilter.push({
				type: jQuery.Jookie.Get(cookieName, type),
				course: jQuery.Jookie.Get(cookieName, course),
				resourceType: jQuery.Jookie.Get(cookieName, resourceType)
			});
			
		}
	}
	
	//printJookie(savedfilter);
	isJookie = true;
	Jookiefilter = savedfilter;
	
	return savedfilter;

}

function resetCheckboxFilters(savedfilter){

	//alert('resetCheckboxFilters');
	jQuery('.filters').find('input:checkbox').each(function (){
		//if the current user is a mentor, disable filter avail|sched
		this.checked = false;
		jQuery(this).attr('disabled', '');
			
		//alert("is_mentor_user: "+is_mentor_user);
		if(is_mentor_user){
			this.checked = true;
			jQuery(this).attr('disabled', 'disabled');
		}
	});
	jQuery('#options_pane').find('input:checkbox').each(function (){
		jQuery(this).removeClass("mixed-state");		
		this.checked = false;
	});


	if(jQuery.isArray(savedfilter)){
		/*
		if(!savedfilter.length){
			savedfilter = GetUserFilterOptions();
		}else{
			SetUserFilterOptions(savedfilter);	
		}
		*/
		for(i in savedfilter){
			
			if(savedfilter[i].course && savedfilter[i].type){
				var type = "#" + savedfilter[i].type.toLowerCase();
				var cbid = "#" + savedfilter[i].course.replace(/ /g, "-").toLowerCase() + "-" + savedfilter[i].resourceType.replace(/ /g, "-").toLowerCase();
				cbid = cbid.replace(/\./g,"");
				
				jQuery(type).each(function() { 
					this.checked = true;
					checkBoxStatus(this);
				});
				
				jQuery(cbid).each(function() { 
					this.checked = true;
					checkBoxStatus(this);
				});
			}
			
		}
		
		if(totalboxes >0 ){
			if(counter == totalboxes){							
				jQuery(".types").removeClass("mixed-state");
				jQuery("#courses").removeClass("mixed-state");
				jQuery("#courses").attr("checked",true);
			}else if(counter == 0){	// not checked
				jQuery(".types").removeClass("mixed-state");
				jQuery("#courses").removeClass("mixed-state");
				jQuery("#courses").attr("checked",false);
			}else{
				jQuery("#courses").addClass("mixed-state");
				jQuery("#courses").attr("checked",true);
			}
		}
		
	}else{
		//alert('HERE');
		savedfilter = null;
	}
	
	
	//jQuery("course-item"
}

function printJookie(savedfilter){
	var message = "";
	for(i in savedfilter){
		var type = "#" + savedfilter[i].type.toLowerCase();
		var cbid = "#" + savedfilter[i].course.replace(/ /g, "-").toLowerCase() + "-" + savedfilter[i].resourceType.replace(/ /g, "-").toLowerCase();
		cbid = cbid.replace(/\./g,"");
		
		message += type+" -> "+ cbid +" : "+savedfilter[i].type + " - " + savedfilter[i].course + " - " + savedfilter[i].resourceType +"\n";
	}
	
	alert(message);
}
	
function removeFilterCookies(username){
	var cookieName = username + '-filterOpts';
	
	jQuery.Jookie.Delete(cookieName);

}


function filterEvents(events, filters){
	
	avail_course_listing = [];
	avail_resource_listing = [];
	
	// Sets the filters in a Cookie
	setFilterCookies(currentUser, filters);
	
	//var msg="";

	var filteredEvents = [];
    if(filters.length > 0){ 
		for(i in filters)
		{
			var filter = filters[i];
			var newEvents = [];
				
			if(filter.type && filter.course && filter.resourceType){
				
				//msg += filter.type + " : " + filter.course + " : " + filter.resourceType + "\n";
				avail_course_listing.push(filter.course);
				avail_resource_listing.push(filter.resourceType);
				
			    newEvents = getEventsByAttribute('type',filter.type.replace(/\./g,""), events);
		        newEvents = getEventsByAttribute('course',filter.course.replace(/\./g,""), newEvents);
		        newEvents = getEventsByAttribute('resourceType',filter.resourceType, newEvents); 
				
				/*
				
				if(debug>0){
					alert('filter.course: '+filter.course.replace(/\./g,""));
					alert('newEvents: '+newEvents.length);
					debug--;	
				}
				
				*/
				
				//msg += newEvents.length + "\n";
		        filteredEvents = filteredEvents.concat(newEvents);
			}
		}

	}
	
	//alert(msg);
	return filteredEvents;
}

function trackCourseNames(filters){
	
	var availableCourses = [];
	var msg = "";
	
	for(i in filters){
		var filter = filters[i];
		availableCourses.push(filter.course);
		msg += filter.course + ","; 
	}
	alert(msg);
}

function getEventsByAttribute(attribute,value, events)
{
    var filteredEvents=[];
	//var msg ="events: "+events.length + "\n";
	
	for(i in events)
	{
		var event = events[i];
		//msg += event[attribute].toLowerCase() + " : " + value.toLowerCase() + "\n";
       
	   	var eventAttr = event[attribute].replace(/ /g, "-").toLowerCase()
		eventAttr = eventAttr.replace(/\./g,"");
		/*
        if(event[attribute].toLowerCase() == value.toLowerCase()){
			filteredEvents.push(event);
		}
		*/
		if(eventAttr == value.toLowerCase()){
			filteredEvents.push(event);
		}
	}
	/*
	if(debug>0){
		alert(msg);
		debug--;	
	}*/
	return filteredEvents;
}

function updateEvent(event)
{
	
	for (i in allEvents)
	{
		if(allEvents[i].id == event.id)
		{
			allEvents.splice(i, 1);
			allEvents.push(event);
			break;
		}
			
	}
	
}



function getFilters(){
	var newfilters = [];
	for(i in courses)
	{
		for(j in types)
		{
			var ftype = (jQuery.trim(types[j])).replace(/ /g,"-").toLowerCase();
			var fcourse = (jQuery.trim(courses[i])).replace(/ /g,"-").toLowerCase();
			
			ftype = ftype.replace(/\./g,"");
			fcourse = fcourse.replace(/\./g,"");
			
			var filter = document.getElementById(fcourse+"-"+ftype);
	
			if(filter.checked)
			{
			   
			    if(jQuery("#scheduled").is(":checked"))
			    {
				var newfilter = {type:"scheduled", course:fcourse, resourceType:ftype};
				newfilters.push(newfilter);
				}
				if(jQuery("#available").is(":checked"))
			    {
				var newfilter = {type:"available", course:fcourse, resourceType:ftype};
				newfilters.push(newfilter);
				}
			}
		
		}
	
	}
	
	//alert('getFilters:'+newfilters.length);
	return newfilters;


}


//------------------------------------------------ End Filters
//------------------ Filter Checkboxes ------------------------------ 

function checkboxClick(){
	//alert('checkboxClick');
	
	//showProgressBar(true);
	//var currentTime;
	//var element = jQuery("#debug");
	
	//jQuery(element).html("");
	//currentTime = new Date();
	//jQuery(element).append("<br/>getFilters: "+currentTime);
	filters = getFilters();
	
	//currentTime = new Date();
	//jQuery(element).append("<br/>removeEventSource: "+currentTime);
	jQuery('#calendar').fullCalendar( 'removeEventSource', filteredEvents );
	renderedEvents = 0;
    filteredEvents = [];
	
	//currentTime = new Date();
	//jQuery(element).append("<br/>filterEvents: "+currentTime);
    filteredEvents = filterEvents(allEvents, filters);  
	
	//jQuery(element).append("<br/>filtered:"+filteredEvents.length);
	//alert('filtered:'+filteredEvents.length);
	
	//currentTime = new Date();
	//jQuery(element).append("<br/>addEventSource: "+currentTime);
	
	if(filteredEvents.length > 0){
		showProgressBar(true);
		
		//setTimeout(function(){
			jQuery('#calendar').fullCalendar( 'addEventSource', filteredEvents );   
			
		//}, 2000); 
		
		setTimeout(function(){
	
			showProgressBar(false);
			
		}, 2000);
		
	}
	
	//printEvents(allEvents);



	//currentTime = new Date();
	//jQuery(element).append("<br/>end: "+currentTime);


	// check if filter options are selected - for loading bar
	
	/*jQuery("#courses").each(function() {
		if(!this.checked){
			showProgressBar(false);	
		}
	});
	*/
	
	//alert("filteredEvents: "+filteredEvents.length);

}
//------------------------------------------------ End Filter Checkboxes