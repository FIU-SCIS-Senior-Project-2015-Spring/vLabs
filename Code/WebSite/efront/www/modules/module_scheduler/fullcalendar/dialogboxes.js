

    //Initialization

    jQuery(document).ready(function() {

        //jQuery("#create_appointment").click(function(){
        //  recurringEventDialogBox();
        //});

    });

    



//------------------ Dialog Boxes ------------------------------

function editDialogBox(event,view){
    
    var dialogContent = jQuery("#edit-event-dialog").load('modules/module_scheduler/fullcalendar/edit_event.html',function() {
                                                                                             
        var dayformatter = "mm/dd/yyyy";    // mmmm d, yyyy
        var timeformatter = "h:MM TT";      // h:MM:ss TT                                                                               
            
        //jQuery("#edit-event-dialog #startDate").blur();
        //jQuery("#edit-event-dialog #startDate").datepicker();
        //jQuery("#edit-event-dialog #endDate").datepicker();
        
        jQuery("#edit-event-dialog #startDate").datepicker(
        // Commented by SMS: 8/7/2011
        // To address the problem when selecting a choice, it would not select it.
        /*
        {
            minDate: new Date(),
            onClose: function(dateText, inst) {
                jQuery("#edit-event-dialog #endDate").datepicker( "option" ,'minDate', dateText );
            }
        }
        */
        );
        jQuery("#edit-event-dialog #endDate").datepicker(
        // {minDate: event.start.format(dayformatter)}
        );
        
        
        jQuery("#edit-event-dialog #start").ptTimeSelect(
        // Commented by SMS: 8/7/2011
        // To address the problem when selecting a choice, it would not select it.
        /*
        {onClose: function(){
                                                                       
            if(event.resourceType == "certificate"){
       
                var newstart = new Date(startDate.val() + " " + startField.val());
                event.start = newstart;
                correctCertificateEvent(event);
                jQuery(endField).val(event.end.format(timeformatter));
            }
        
        }}
        */
        ); 
        
        jQuery("#edit-event-dialog #end").ptTimeSelect(); 
        
        jQuery("#edit-event-dialog #startDate").focus(function() {
            jQuery("#ptTimeSelectCntr").hide();
        });
        jQuery("#edit-event-dialog #start").focus(function() {
            jQuery("#edit-event-dialog #endDate").datepicker('hide');
            jQuery("#edit-event-dialog #startDate").datepicker('hide');
        });
        jQuery("#edit-event-dialog #endDate").focus(function() {
            jQuery("#ptTimeSelectCntr").hide();
        });
        jQuery("#edit-event-dialog #end").focus(function() {
            jQuery("#edit-event-dialog #startDate").datepicker('hide');
            jQuery("#edit-event-dialog #endDate").datepicker('hide');
        });
            
        var customLabel;
        if(is_admin_user){
            customLabel = "Host";
        }else{
            customLabel = "Course";
        }
        
        if (jQuery.browser.msie) {
            document.getElementById("customddm").innerHTML = customLabel;
        }else{
            jQuery("#edit-event-dialog #customddm").text(customLabel);
        }
        
        resetForm(this);
        
        var typeFieldOptions = "";
        var courseFieldOptions = "";
        //var timezoneFieldOptions = "";
        
        for(var i = 0; i<types.length; i++){
            typeFieldOptions +=  "<option>"+types[i]+"</option>";
        }
        
        for(var i = 0; i<courses.length; i++){
            courseFieldOptions +=  "<option>"+courses[i]+"</option>";
        }
        
        
        /*
        for(var i = 0; i<zones.length; i++){
            timezoneFieldOptions += "<option>"+zones[i]+"</option>";
        }
        */
        //if (jQuery.browser.msie) { alert("TEST: edit appointment form 1"); }
        
        var startDate = jQuery(this).find("input[name='startDate']");
        var endDate = jQuery(this).find("input[name='endDate']");
        var startField = jQuery(this).find("input[name='start']");   //.val(event.start.format(timeformatter));
        var endField = jQuery(this).find("input[name='end']");       //.val(event.end.format(timeformatter));
        var typeField = jQuery(this).find("select[name='type']").html(typeFieldOptions);
        var courseField = jQuery(this).find("select[name='course']").html(courseFieldOptions);
        //var timezoneField = jQuery(this).find("select[name='timezone']").html(timezoneFieldOptions);
        
        var startNow = jQuery(this).find("input[name='startNow']");
        
        //if (jQuery.browser.msie) { alert("TEST: edit appointment form 2"); }
        if(!event.start)
            startDate.val(event.start.format(dayformatter));
        endDate.val(event.end.format(dayformatter));
        if(event.start)
            startField.val(event.start.format(timeformatter));
        endField.val(event.end.format(timeformatter));
        
        typeField.val((event.resourceType).toUpperCase());
        courseField.val(event.course);
        
        // Warns if the appointment spans more than 24 hours
        /*
        var spanValue = "<span id='days_between' style='display:none'>" + days_between(event.start, event.end) + "</span>";
        if (jQuery.browser.msie) {
            var sParent = document.getElementById("endDate").parentNode;
            //alert(sParent.innerHTML);
            sParent.innerHTML += spanValue; 
        }else{
            jQuery(endDate).append(spanValue);
        }*/
        
        
        // Enables and Disable the input fields based on the start date and startnow option, or if a certificate event
        // commented by SMS: 8/7/2011
        // No need for this in the JavaScript as the actions are fixed in the Web Service
        /*
        if(event.resourceType == "certificate"){
            
            //alert("certificate");
            
            jQuery("input[name='endDate']").attr('disabled', 'disabled');
            jQuery("input[name='end']").attr('disabled', 'disabled');
            
            if (jQuery.browser.msie) {
                    document.getElementById(this.id).checked = false;
                    document.getElementById(this.id).disabled = true;
            }else{
                jQuery(startNow).attr('disabled', 'disabled');
                jQuery(startNow).attr('checked','');
            }
        
        
        }else{
            */
            //alert("not certificate");
            
            var today = new Date();
            if(today > event.start){
                jQuery("input[name='startDate']").attr('disabled', 'disabled');
                jQuery("input[name='start']").attr('disabled', 'disabled');
                
                if (jQuery.browser.msie) {
                        document.getElementById(this.id).checked = true;
                        document.getElementById(this.id).disabled = true;
                }else{
                    jQuery(startNow).attr('disabled', 'disabled');
                    jQuery(startNow).attr('checked','checked');
                }
                
                startDate.val("");
                startField.val("");
                
            }else{
                /*
                jQuery("#startDate, #endDate, #start, #end").change(function(){
                
                    var start = new Date(jQuery("input[name='startDate']").val() + " " + jQuery("input[name='start']").val());
                    var end = new Date(jQuery("input[name='endDate']").val() + " " + jQuery("input[name='end']").val());
                    
                    jQuery("#days_between").html(days_between(start, end));
                                    
                });
                */
            
                jQuery(startNow).change(function() {
                    
                    var isChecked = false;
                    
                    if (jQuery.browser.msie) {
                        isChecked = document.getElementById(this.id).checked;
                    }else{
                        isChecked = jQuery(this).attr('checked');
                    }
                    
                    if(!isChecked){
                        jQuery("input[name='startDate']").attr('disabled', '');
                        jQuery("input[name='start']").attr('disabled', '');
                        
                        jQuery("input[name='startDate']").val(event.start.format(dayformatter));
                        
                        jQuery("#edit-event-dialog #endDate").datepicker( "option" ,'minDate', event.start.format(dayformatter));
                        
                    }else{
                        jQuery("input[name='startDate']").attr('disabled', 'disabled');
                        jQuery("input[name='start']").attr('disabled', 'disabled');
        
                        jQuery("input[name='startDate']").val("");
                        jQuery("input[name='start']").val("");
                        
                        jQuery("#edit-event-dialog #endDate").datepicker( "option" ,'minDate', new Date());
                    }
                    
                    
                });
                
            }
        // }
        
        jQuery(this).find("button").focus();
    
    });
    
    
    
    if(event.type == "scheduled"){
        //alert(event.type);
        
        jQuery(dialogContent).dialog({
            autoOpen: false,
            width: 340,
            height: 350,
            modal: true,
            title: "Edit - " + event.title,
            close: function() {
                jQuery("#edit-event-dialog #endDate").datepicker("destroy");
                jQuery("#edit-event-dialog #startDate").datepicker("destroy");
                jQuery(this).dialog("destroy");
                jQuery(this).hide();
            },
            buttons: {
                "confirm new schedule" : function() {
                    var header = "Edit Appointment: Invalid Date";
                    var message = "";
                    var icon = "alert";
                    // Retrieve Form Objects
                    var startDate = jQuery(dialogContent).find("input[name='startDate']");
                    var endDate = jQuery(dialogContent).find("input[name='endDate']");
                    var startField = jQuery(dialogContent).find("input[name='start']");
                    var endField = jQuery(dialogContent).find("input[name='end']");
                    
                    var today = new Date();
                    var startNow = null;
                    
                    //event.title = typeField.val();
                    var start = new Date(startDate.val() + " " + startField.val());
                    var end = new Date(endDate.val() + " " + endField.val());
                    
                    if(today > event.start){
                        startNow = jQuery(dialogContent).find("input[name='startNow']");
                        start = event.start;
                    }
                    
                    if(checkStartEndFields(startDate, startField, endDate, endField, startNow)){
                    
                        if(end>start){
                            jQuery(this).dialog('close');
                            modifyAppointment(event, start, end, false, false);
                            //jQuery(this).dialog("close");
                            
                        }else if(end.toString() == start.toString()){
                            // If dates are exactly the same alter
                            
                            /*
                            if(start.getTime() != event.start.getTime() || end.getTime() != event.end.getTime()){
                                
                                if(end.getTime() < start.getTime()){
                                    end.setDate(end.getDate()+1);  // changes month automatically
                                }else if(start.getTime() == end.getTime()){
                                    end.setHours(end.getHours()+1);
                                }else{
                                    
                                }
                            }
                            */
                            
                            message = "The appointment start time cannot be the same as the appointment end time.1";
                            noticeDialog(header, message, icon);
                            
                        }else{
                        
                            message = "The appointment end date cannot be before the appointment start date.1";
                            noticeDialog(header, message, icon);
                        }
                    }
                    
                },
                "cancel schedule" : function() {
                    jQuery(this).dialog('close');
                    deleteDialogBox(event,dialogContent);
                },
                close : function() {
                    jQuery(this).dialog("close");
                }
            }
        });

    }else{      // Available Events
    
        //alert(event.type);
    
        jQuery(dialogContent).dialog({
            autoOpen: false,
            width: 340,
            height: 350,
            modal: true,
            title: "Edit - " + event.title,
            close: function() {
               jQuery(this).dialog("destroy");
               jQuery(this).hide();
            },
            buttons: {
                "confirm schedule" : function() {
                    var header = "Edit Appointment: Invalid Date";
                    var message = "";
                    var icon = "alert";
                    // Retrieve Form Objects
                    var startDate = jQuery(dialogContent).find("input[name='startDate']");
                    var endDate = jQuery(dialogContent).find("input[name='endDate']");
                    var startField = jQuery(dialogContent).find("input[name='start']");
                    var endField = jQuery(dialogContent).find("input[name='end']");
                    var startNow = jQuery(dialogContent).find("input[name='startNow']");
                    
                    //event.title = typeField.val();
                    var start = new Date(startDate.val() + " " + startField.val());
                    var end = new Date(endDate.val() + " " + endField.val());
                    
                    if(checkStartEndFields(startDate, startField, endDate, endField, startNow)){
                        
                        var today = new Date();
                        
                        if(end>start || end>today){
                            jQuery(this).dialog('close');
                            
                            var newevent = getCreateNewEventObj("#edit-event-dialog");
                        
                            //event.start = start;
                            //event.end = end;
                            //alert(printEvent(event));
                            
                            scheduleAppointment(newevent, view);
                            //modifyAppointment(event, start, end);
                            //jQuery(this).dialog("close");
                            
                        }else if(end.toString() == start.toString()){
                        
                            message = "The appointment start time cannot be the same as the appointment end time.2";
                            noticeDialog(header, message, icon);
                            
                        }else{
                        
                            message = "The appointment end date cannot be before the appointment start date.2";
                            noticeDialog(header, message, icon);
                        }
                    }else{
                        //alert("You are here.");   
                    }
                    
                },
                close : function() {
                    jQuery(this).dialog("close");
                }
            }
        });

    
    }

    jQuery(dialogContent).dialog('open');
    
}

function createDialogBox(newDate,view, starttime){
    

    var createDialog =  jQuery("#create-event-dialog").load('modules/module_scheduler/fullcalendar/create_event.html',function() {
        
        
        //jQuery("#create-event-dialog #startDate").datepicker();
        //jQuery("#create-event-dialog #endDate").datepicker();
        
        jQuery("#create-event-dialog #startDate").datepicker(
        // Commented by SMS: 8/7/2011
        // To address the problem when selecting a choice, it would not select it.
        /*
        {
            minDate: new Date(),
            onClose: function(dateText, inst) {
                jQuery("#create-event-dialog #endDate").datepicker( "option" ,'minDate', dateText);
            }
        }
        */
        );
        jQuery("#create-event-dialog #endDate").datepicker(
        // Commented by SMS: 8/7/2011
        // To address the problem when selecting a choice, it would not select it.
        // {minDate: newDate}
        );
        
        
        
        jQuery("#create-event-dialog #start").ptTimeSelect(); 
        jQuery("#create-event-dialog #end").ptTimeSelect(); 
        
        jQuery("#create-event-dialog #startDate").focus(function() {
            jQuery("#ptTimeSelectCntr").hide();
        });
        jQuery("#create-event-dialog #start").focus(function() {
            jQuery("#create-event-dialog #endDate").datepicker('hide');
            jQuery("#create-event-dialog #startDate").datepicker('hide');
        });
        jQuery("#create-event-dialog #endDate").focus(function() {
            jQuery("#ptTimeSelectCntr").hide();
        });
        jQuery("#create-event-dialog #end").focus(function() {
            jQuery("#create-event-dialog #startDate").datepicker('hide');
            jQuery("#create-event-dialog #endDate").datepicker('hide');
        });
        jQuery("#create-event-dialog #type").focus(function() {
            jQuery("#create-event-dialog #startDate").datepicker('hide');
            jQuery("#create-event-dialog #endDate").datepicker('hide');
            jQuery("#ptTimeSelectCntr").hide();
        });
        jQuery("#create-event-dialog #course").focus(function() {
            jQuery("#create-event-dialog #startDate").datepicker('hide');
            jQuery("#create-event-dialog #endDate").datepicker('hide');
            jQuery("#ptTimeSelectCntr").hide();
        });
        
        var customLabel;
        if(is_admin_user){
            customLabel = "Host";
        }else{
            customLabel = "Course";
        }
        
        if (jQuery.browser.msie) {
            document.getElementById("customddm").innerHTML = customLabel;
        }else{
            jQuery("#create-event-dialog #customddm").text(customLabel);
        }
        resetForm(createDialog);
        
        var dayformatter = "mm/dd/yyyy";    // mmmm d, yyyy 
        var timeformatter = "h:MM TT";      // h:MM:ss TT 
        var typeFieldOptions = "";
        var courseFieldOptions = "";
        //var timezoneFieldOptions = "";
        
        // Load types in the select box, and select current type
        for(var i = 0; i<types.length; i++){
            
            if(avail_resource_listing.length > 0){
                var type = types[i];
                var added = false;
                
                //alert('RESOURCE: '+type);
                for(var j = 0; j <avail_resource_listing.length; j++){
                    if(!added){
                        var newtype = type.replace(/ /g, "-").toLowerCase();
                        //alert('avail_resource_listing: \n'+avail_resource_listing[j]+' \n newtype: \n'+newtype);
                        
                        if(newtype == avail_resource_listing[j]){
                            //alert('MATCH: '+newtype);
                            typeFieldOptions +=  "<option>"+types[i]+"</option>";
                            added = true;
                        }
                    }
                }
            }else{
                typeFieldOptions +=  "<option>"+types[i]+"</option>";
            }
        }
        
        for(var i = 0; i<courses.length; i++){
            
            if(avail_course_listing.length >0){
                var course = courses[i];
                var added = false;
                
                //alert('COURSE: '+course);
                for(var j = 0; j <avail_course_listing.length; j++){
                    
                    if(!added){
                        var newcoursename = course.replace(/ /g, "-").toLowerCase();
                        newcoursename = newcoursename.replace(/\./g, "").toLowerCase();
                        //console.log('avail_course_listing: \n'+avail_course_listing[j]+' \n newcoursename: \n'+newcoursename);
                        
                        if(newcoursename == avail_course_listing[j]){
                            //alert('MATCH: '+newcoursename);
                            courseFieldOptions +=  "<option>"+courses[i]+"</option>";
                            added = true;
                        }
                    }
                }
            }else{
                courseFieldOptions +=  "<option>"+courses[i]+"</option>";
            }
        }
        
        /*
        for(var i = 0; i<zones.length; i++){
            timezoneFieldOptions += "<option>"+zones[i]+"</option>";
        }
        */
        var startDate = jQuery(createDialog).find("input[name='startDate']");
        var endDate = jQuery(createDialog).find("input[name='endDate']");
        var startField = (starttime) ? jQuery(createDialog).find("input[name='start']").val(newDate.format(timeformatter)) : jQuery(createDialog).find("input[name='start']");
        var endField = jQuery(createDialog).find("input[name='end']");
        var typeField = jQuery(createDialog).find("select[name='type']").html(typeFieldOptions);
        var courseField = jQuery(createDialog).find("select[name='course']").html(courseFieldOptions);
        //var timezoneField = jQuery(createDialog).find("select[name='timezone']").html(timezoneFieldOptions);
        var startNow = jQuery(createDialog).find("input[name='startNow']");
    
        startDate.val(newDate.format(dayformatter));
        endDate.val(newDate.format(dayformatter));
        
    /*  
        var start = new Date(startDate.val());
        var today = new Date();
        if(start.format(dayformatter) == today.format(dayformatter)){
            jQuery(startNow).attr('disabled','');
            //alert("IS: "+start);
        }else{
            jQuery(startNow).attr('disabled','disabled');
            //alert("Not: "+start);
        }
    
        jQuery(startDate).change(function() {
                                     
            var start = new Date(jQuery(this).val());
            var today = new Date();
            
            if(start.format(dayformatter) == today.format(dayformatter)){
                jQuery(startNow).attr('disabled','');
                if(start.format(dayformatter) != ""){
                    jQuery(endDate).val(start.format(dayformatter));
                }
            }else{
                jQuery(startNow).attr('checked','');
                jQuery(startNow).attr('disabled','disabled');
            }
        });
    */
    
        jQuery(startNow).change(function() {
            var isChecked = jQuery(startNow).attr('checked');
            var today = new Date();
            
            if(isChecked){
                jQuery(startDate).attr('disabled','disabled');
                jQuery(startField).attr('disabled','disabled');
                
                startDate.val("");
                startField.val("");
                
                jQuery("#create-event-dialog #endDate").datepicker( "option" ,'minDate', new Date());
                
            }else{
                jQuery(startDate).attr('disabled','');
                jQuery(startField).attr('disabled','');
                
                startDate.val(newDate.format(dayformatter));
                startField.val(today.format(timeformatter));
                
                jQuery("#create-event-dialog #endDate").datepicker( "option" ,'minDate', newDate.format(dayformatter));
            }   
        });
    
    });

    jQuery(createDialog).dialog({
        autoOpen: false,
        width: 340,
        modal: true,
        title: "Create New Calendar Event",
        close: function() {
           jQuery(createDialog).dialog("destroy");
           jQuery(createDialog).hide();
           //('#calendar').fullCalendar("removeUnsavedEvents");
        },
        buttons: {
            "create" : function() {
                
                var startDate = jQuery(createDialog).find("input[name='startDate']");
                var endDate = jQuery(createDialog).find("input[name='endDate']");
                var startField = jQuery(createDialog).find("input[name='start']");
                var endField = jQuery(createDialog).find("input[name='end']");
                var startNow = jQuery(createDialog).find("input[name='startNow']");
                
                if(checkStartEndFields(startDate, startField, endDate, endField, startNow)){
                
                    var newevent = getCreateNewEventObj("#create-event-dialog");
                    
                    jQuery(createDialog).dialog("close");
                    //performAction(newevent, "create", view);
                    if(scheduleAppointment(newevent, view)){
                    
                    }
                    
                    /*
                    if(scheduleAppointment(newevent,view)){
                        jQuery('#calendar').fullCalendar('newEvent',newevent);
                    }
                        */                                    
                    //jQuery(createDialog).dialog("close");
                }
            //},
            /*
            'confirm': function(){
                
                var newevent = getCreateNewEventObj("#create-event-dialog");
                confirmEventEdit(newevent);
            */
            },
            close : function() {
                jQuery(createDialog).dialog("close");
            }
        }
    });
    
    jQuery(createDialog).dialog('open');

}


// Delete Event Dialog, takes event and initial dialog box to close on delete button click.
function deleteDialogBox(event, dialogBox, recurring){

    //alert('deleteDialogBox recurring: '+recurring);

    if(recurring){
        
        var deleteContent = jQuery("<div id='delete-confirm' />").html('<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>This event will be permanently deleted and cannot be recovered. Are you sure?</p>');
                    
        jQuery(deleteContent).dialog({
            autoOpen: false,
            resizable: false,
            width: 350,
            title: "Delete Recurring - " + event.title,
            modal: true,
            close: function() {
               jQuery(deleteContent).dialog("destroy");
               jQuery(deleteContent).hide();
            },
            buttons: {
                'cancel all occurrences': function() {
                    //jQuery('#calendar').fullCalendar("removeEvents", event.id);
                    jQuery(this).dialog('close');
                    deleteRecurringDialogBox(event,deleteContent,true);
                    //jQuery(this).dialog('close');
                    if(dialogBox){
                        jQuery(dialogBox).dialog("close");
                    }
                },
                'cancel this occurrence': function() {
                    //jQuery('#calendar').fullCalendar("removeEvents", event.id);
                    jQuery(this).dialog('close');
                    deleteRecurringDialogBox(event,deleteContent,false);
                    //jQuery(this).dialog('close');
                    if(dialogBox){
                        jQuery(dialogBox).dialog("close");
                    }
                },
                close: function() {
                    jQuery(this).dialog('close');
                }
            }
        });
        
        jQuery(deleteContent).dialog('open');
        
    }else{

        var deleteContent = jQuery("<div id='delete-confirm' />").html('<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>This event will be permanently deleted and cannot be recovered. Are you sure?</p>');
                    
        jQuery(deleteContent).dialog({
            autoOpen: false,
            resizable: false,
            width: 350,
            title: "Delete - " + event.title,
            modal: true,
            close: function() {
               jQuery(deleteContent).dialog("destroy");
               jQuery(deleteContent).hide();
            },
            buttons: {
                'delete schedule': function() {
                    //jQuery('#calendar').fullCalendar("removeEvents", event.id);
                    jQuery(this).dialog('close');
                    cancelAppointment(event,false);
                    //jQuery(this).dialog('close');
                    if(dialogBox){
                        jQuery(dialogBox).dialog("close");
                    }
                },
                close: function() {
                    jQuery(this).dialog('close');
                }
            }
        });
        
        jQuery(deleteContent).dialog('open');
                
    }

}

//function confirmDialogBox(event, actionName, view){
function confirmDialogBox(event, view){
    
    var today = new Date();
    var starttime = (today > event.start) ? "<b>NOW</b>" : event.start;
    
    var message = "Would you like to confirm the appointment: <br/>" +
                   "From: "+ starttime  + "<br/>" +
                   "To: "+event.end + "<br/><br/>" +
                   "Course: "+event.course;

    var confirmContent = jQuery("<div id='confirm-confirm' />").html('<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>'+message+'</p>');
                
    jQuery(confirmContent).dialog({
        autoOpen: false,
        resizable: false,
        width: 360,
        title: "Confirm - " + event.title,
        modal: true,
        close: function() {
           jQuery(this).dialog("destroy");
           jQuery(this).hide();
        },
        buttons: {
            "confirm new schedule": function() {
                // Set new appoinment Call
                //performAction(event, actionName, view);
                
                // alter event start so if the start time is in the past, it will begin instantly.
                var today = new Date();
                if(today > event.start){
                    event.start = "";
                }
                
                jQuery(this).dialog('close');
                if(confirmAppointment(event, view)){
                    
                }
                //jQuery(this).dialog('close');

            },
            "edit new schedule": function(){
                jQuery(this).dialog('close');
                editDialogBox(event, view);
                //jQuery(this).dialog('close');
            },
            close: function() {
                jQuery(this).dialog('close');
            }
        }
    });
    
    jQuery(confirmContent).dialog('open');

}

function newDialogBox(newDate, view, starttime){

    var deleteContent = jQuery("<div id='new-confirm' />").html('<p><span class="ui-icon ui-icon-document" style="float:left; margin:0 7px 20px 0;"></span>would you like to create a new event?</p>');
                
    jQuery(deleteContent).dialog({
        autoOpen: false,
        resizable: false,
        width: 350,
        title: "New Calendar Event?",
        modal: true,
        close: function() {
           jQuery(deleteContent).dialog("destroy");
           jQuery(deleteContent).hide();
        },
        buttons: {
            'create event': function() {
                jQuery(this).dialog('close');
                createDialogBox(newDate,view,starttime);
                //jQuery(this).dialog('close');
            },
            'recurring event': function() {
                jQuery(this).dialog('close');
                recurringEventDialogBox(newDate,view,starttime);
                //jQuery(this).dialog('close');
            },
            close: function() {
                jQuery(this).dialog('close');
            }
        }
    });
    
    jQuery(deleteContent).dialog('open');

}

function noticeDialog(header, message, icon, returnObj){
    
    var noticeContent = jQuery("<div id='calendar-notice' />").html('<p><span class="ui-icon ui-icon-'+icon+'" style="float:left; margin:0 7px 20px 0;"></span>'+message+'</p>');
    
    jQuery(noticeContent).dialog({
        modal: true,
        title: header,
        open: function(event, ui) {
            //alert(this.id);
            setTimeout("jQuery('#"+this.id+"').dialog('close');",5000);
        },
        close: function() {
           jQuery(noticeContent).dialog("destroy");
           jQuery(noticeContent).hide();
        },
        buttons: {
            Ok: function() {
                jQuery(this).dialog('close');
            }
        }
    });
    
    jQuery(noticeContent).dialog('open');
    
    
    if(returnObj){
        return noticeContent;
    }
}
function noticeDialog2(header, message, icon, returnObj){
    
    var noticeContent = jQuery("<div id='calendar-notice' />").html('<p><span class="ui-icon ui-icon-'+icon+'" style="float:left; margin:0 7px 20px 0;"></span>'+message+'</p>');
    
    jQuery(noticeContent).dialog({
        modal: true,
        title: header,
        close: function() {
           jQuery(noticeContent).dialog("destroy");
           jQuery(noticeContent).hide();
        },
        buttons: {
            Ok: function() {
                jQuery(this).dialog('close');
            }
        }
    });
    
    jQuery(noticeContent).dialog('open');
    
    if(returnObj){
        return noticeContent;
    }
}

//------------------------------------------------ End Dialog Boxes

//------------------ Progress Bar Dialog Boxes ------------------------------
// Source: http://jqueryui.com/demos/progressbar/
function progressDialogBox(loading){
    
    //alert('progressDialogBox: '+loading);
    
    //var top = jQuery(window).height() / 2;
    //var left = jQuery(window).width() / 2;

    /*
    ("<div></div>").addClass("ui-widget-overlay")).appendTo(document.body).css({width:this.width(),height:this.height()});
    */
    
    //var overlay = jQuery("#progess-overlay");
    var progressContainer = jQuery("#progressbarContainer");
    var progressbar = jQuery("#progressbar");
    
    //jQuery(progressContainer).center();


    //alert('height:'+jQuery(window).height() + ' width:'+jQuery(window).width());
  
    //alert(loading);
    if(loading){
        
        //jQuery(overlay).addClass("ui-widget-overlay");
        
        jQuery(progressContainer).show();
        jQuery(progressbar).progressbar({value: 100});
        
        //jQuery("#progess-overlay").css('height',jQuery(window).height());
        //jQuery("#progess-overlay").css('width',jQuery(window).width());
        //jQuery(progressContainer).center();
        
        jQuery(progressContainer).each(function(){
            var container = jQuery(window);
            var t = jQuery(container).height();
            var l = jQuery(container).width();
            
            var scrollTop = jQuery(window).scrollTop();
            var scrollLeft = jQuery(window).scrollLeft();
            
            //var top = -t / 2;
            //var left = -l / 2;
            
            var top = -50 + scrollTop;
            var left = -125 + scrollLeft;
            
            jQuery(this).css('position', 'absolute').css({ 'margin-left': left + 'px', 'margin-top': top + 'px', 'left': '50%', 'top': '50%' });
            
            jQuery(window).scroll(function () { 
                if(jQuery(progressContainer)){
                    var scrollTop = jQuery(window).scrollTop();
                    var scrollLeft = jQuery(window).scrollLeft();
                    var top = -50 + scrollTop;
                    var left = -125 + scrollLeft;
                    jQuery(progressContainer).css('position', 'absolute').css({ 'margin-left': left + 'px', 'margin-top': top + 'px', 'left': '50%', 'top': '50%' });
                    //alert('scrollTop: '+scrollTop+' scrollLeft: '+scrollLeft);
                }
            });

            
        });
        
        
    }else{
        
        //jQuery(overlay).removeClass("ui-widget-overlay");
        jQuery(progressContainer).hide();
        jQuery(progressbar).progressbar( "destroy" );
        
    }
}

//------------------------------------------------ End Progress Bar Dialog Boxes

//------------------ Confirm Dialog Boxes ------------------------------

function confirmModifyDialogBox(message, title, revertFunc, event, start, end){
    
    var confirmContent = jQuery("<div id='custom-confirm' />").html('<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>'+message+'</p>');
                
    jQuery(confirmContent).dialog({
        autoOpen: false,
        resizable: false,
        width: 350,
        title: title,
        modal: true,
        close: function() {
           jQuery(this).dialog("destroy");
           jQuery(this).hide();
        },
        buttons: {
            "confirm": function(){
                //if(!modifyAppointment(event, start, end)){revertFunc();}
                jQuery(this).dialog('close');
                modifyAppointment(event, start, end, false, true, revertFunc);
                //jQuery(this).dialog('close');
            },
            close: function() {
                jQuery(this).dialog('close');
                revertFunc();
            }
        }
    });
    
    jQuery(confirmContent).dialog('open');

}

function confirmChangeDialogBox(message, title, affiliationId, dayDelta, minuteDelta, revertFunc){
    
    var confirmContent = jQuery("<div id='custom-confirm' />").html('<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>'+message+'</p>');
                
    jQuery(confirmContent).dialog({
        autoOpen: false,
        resizable: false,
        width: 360,
        title: title,
        modal: true,
        close: function() {
           jQuery(this).dialog("destroy");
           jQuery(this).hide();
        },
        buttons: {
            "confirm": function(){
                jQuery(this).dialog('close');
                changeRecurringEvents(affiliationId, dayDelta, minuteDelta, revertFunc);
            },
            close: function() {
                jQuery(this).dialog('close');
                revertFunc();
                
            }
        }
    });
    
    jQuery(confirmContent).dialog('open');

}

//------------------------------------------------ End Confirm Dialog Boxes
//------------------ Recurring Dialog Boxes ------------------------------

function editRecurringDialogBox(event,view){
    
    var dialogContent = jQuery("#edit-event-dialog").load('modules/module_scheduler/fullcalendar/edit_event.html',function() {
                                                                                             
        var dayformatter = "mm/dd/yyyy";    // mmmm d, yyyy
        var timeformatter = "h:MM TT";      // h:MM:ss TT 
        
        //jQuery("#edit-event-dialog #startDate").datepicker();
        //jQuery("#edit-event-dialog #endDate").datepicker();
        
        jQuery("#edit-event-dialog #startDate").datepicker(
        // Commented by SMS: 8/7/2011
        // To address the problem when selecting a choice, it would not select it.
        /*
        {
            minDate: new Date(),
            onClose: function(dateText, inst) {
                jQuery("#edit-event-dialog #endDate").datepicker( "option" ,'minDate', dateText);
            }
        }
        */
        );
        jQuery("#edit-event-dialog #endDate").datepicker(
        // Commented by SMS: 8/7/2011
        // To address the problem when selecting a choice, it would not select it.
        // {minDate: event.start.format(dayformatter)}
        );
        
        jQuery("#edit-event-dialog #start").ptTimeSelect(); 
        jQuery("#edit-event-dialog #end").ptTimeSelect(); 
        
        var customLabel;
        if(is_admin_user){
            customLabel = "Host";
        }else{
            customLabel = "Course";
        }
        
        jQuery("#edit-event-dialog #customddm").text(customLabel);
        
        resetForm(this);

        var typeFieldOptions = "";
        var courseFieldOptions = "";
        //var timezoneFieldOptions = "";
        
        
        for(var i = 0; i<types.length; i++) {
            typeFieldOptions +=  "<option>"+types[i]+"</option>";
        }
        for(var i = 0; i<courses.length; i++){
            courseFieldOptions +=  "<option>"+courses[i]+"</option>";
        }

        var startDate = jQuery(this).find("input[name='startDate']");
        var endDate = jQuery(this).find("input[name='endDate']");
        var startField = jQuery(this).find("input[name='start']").val(event.start.format(timeformatter));
        var endField = jQuery(this).find("input[name='end']").val(event.end.format(timeformatter));
        var typeField = jQuery(this).find("select[name='type']").html(typeFieldOptions);
        var courseField = jQuery(this).find("select[name='course']").html(courseFieldOptions);
        var startNow = jQuery(this).find("input[name='startNow']");
        
        startDate.val(event.start.format(dayformatter));
        endDate.val(event.end.format(dayformatter));
        
        typeField.val((event.resourceType).toUpperCase());
        courseField.val(event.course);
        
        jQuery(startNow).attr('disabled','disabled');
    });
    
    jQuery(dialogContent).dialog({
        autoOpen: false,
        width: 350,
        modal: true,
        title: "Edit Recurring Appointment",
        close: function() {
           jQuery(this).dialog("destroy");
           jQuery(this).hide();
        },
        buttons: {
            "change all occurrences" : function() {
                
                var header = "Edit Recurring Appointment: Invalid Date";
                var message = "";
                var icon = "alert";
                // Retrieve Form Objects
                var startDate = jQuery(dialogContent).find("input[name='startDate']");
                var endDate = jQuery(dialogContent).find("input[name='endDate']");
                var startField = jQuery(dialogContent).find("input[name='start']");
                var endField = jQuery(dialogContent).find("input[name='end']");
                
                //event.title = typeField.val();
                var start = new Date(startDate.val() + " " + startField.val());
                var end = new Date(endDate.val() + " " + endField.val());
                
                
                // Calculate if the new date is being shifted forward or backwards.
                var startIndex = days_between(start,event.start);
                var endIndex = days_between(end,event.end);
                var delta = 1;
                
                if(startIndex > 0){
                    if(event.start > start){
                        startIndex = startIndex * (-1); 
                        delta = (-1);
                    }
                }
                if(endIndex > 0){
                    if(event.start > start){
                        endIndex = endIndex * (-1); 
                    }
                }
                
                
                if(checkStartEndFields(startDate, startField, endDate, endField)){
                    if(end>start){
                        
                        //modifyRecurringAppointment(event, start, end, true);
                        jQuery(this).dialog('close');
                        modifyRecurringAppointment(event, start, startIndex, end, endIndex, delta, true);
                        //jQuery(this).dialog("close");
                        
                    }else if(end.toString() == start.toString()){
                        
                        message = "The appointment start time cannot be the same as the appointment end time.";
                        noticeDialog(header, message, icon);
                        
                    }else{
                    
                        message = "The appointment end date cannot be before the appointment start date.";
                        noticeDialog(header, message, icon);
                    }
                }
                
                
            },
            "change this occurrence" : function() {
                
                var header = "Edit Recurring Appointment: Invalid Date";
                var message = "";
                var icon = "alert";
                // Retrieve Form Objects
                var startDate = jQuery(dialogContent).find("input[name='startDate']");
                var endDate = jQuery(dialogContent).find("input[name='endDate']");
                var startField = jQuery(dialogContent).find("input[name='start']");
                var endField = jQuery(dialogContent).find("input[name='end']");
                
                var today = new Date();
                var startNow = null;
                
                //event.title = typeField.val();
                var start = new Date(startDate.val() + " " + startField.val());
                var end = new Date(endDate.val() + " " + endField.val());
                
                if(today > event.start){
                    startNow = jQuery(dialogContent).find("input[name='startNow']");
                    start = event.start;
                }
                
                var delta = null;
                
                if(checkStartEndFields(startDate, startField, endDate, endField, startNow)){
                    if(end>start){
                        
                        //modifyRecurringAppointment(event, start, end, false);
                        jQuery(this).dialog('close');
                        modifyRecurringAppointment(event, start, 0, end, 0, delta, false);
                        //jQuery(this).dialog("close");
                        
                    }else if(end.toString() == start.toString()){
                        
                        message = "The appointment start time cannot be the same as the appointment end time.";
                        noticeDialog(header, message, icon);
                        
                    }else{
                    
                        message = "The appointment end date cannot be before the appointment start date.";
                        noticeDialog(header, message, icon);
                    }
                }
            },
            close : function() {
                jQuery(this).dialog("close");
            },
            "cancel all occurrences" : function() {
                deleteRecurringDialogBox(event, this, true);
            },
            "cancel this occurrence" : function() {
                deleteRecurringDialogBox(event, this, false);
            }
        }
    });

    jQuery(dialogContent).dialog('open');
    
}


function deleteRecurringDialogBox(event, dialogBox, all){

    var requestType;

    if(all){
    
        var deleteContent = jQuery("<div id='delete-confirm' />").html('<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>These events will be permanently deleted and cannot be recovered. Are you sure?</p>');
                    
        jQuery(deleteContent).dialog({
            autoOpen: false,
            resizable: false,
            width: 350,
            title: "Delete Occurrences",
            modal: true,
            close: function() {
               jQuery(deleteContent).dialog("destroy");
               jQuery(deleteContent).hide();
            },
            buttons: {
                'delete all occurrences': function() {
                    //jQuery('#calendar').fullCalendar("removeEvents", event.id);
                    if(is_mentor_user && event.type == "scheduled"){
                        requestType = "User";
                    }else{
                        requestType = getRequestType(currentUser);
                    }
                    jQuery(this).dialog('close');
                    cancelAllAppointments(event.id, requestType); // id is actually the affiliationId, vice versa
                    //jQuery(this).dialog('close');
                    if(dialogBox){
                        jQuery(dialogBox).dialog("close");
                    }
                },
                close: function() {
                    jQuery(this).dialog('close');
                }
            }
        });
        
        jQuery(deleteContent).dialog('open');
        
    }else{
        
        var deleteContent = jQuery("<div id='delete-confirm' />").html('<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>This event will be permanently deleted and cannot be recovered. Are you sure?</p>');
                    
        jQuery(deleteContent).dialog({
            autoOpen: false,
            resizable: false,
            width: 350,
            title: "Delete - " + event.title,
            modal: true,
            close: function() {
               jQuery(deleteContent).dialog("destroy");
               jQuery(deleteContent).hide();
            },
            buttons: {
                'delete this occurrence': function() {
                    // Switch back the affiliation and id
                    var newAffil = event.affiliation;
                    var newId = event.id;
                    event.affiliation = newId;
                    event.id = newAffil;
                    event.recurring = false;
                    
                    jQuery(this).dialog('close');
                    cancelAppointment(event,false);
                    //jQuery(this).dialog('close');
                    if(dialogBox){
                        jQuery(dialogBox).dialog("close");
                    }
                },
                close: function() {
                    jQuery(this).dialog('close');
                }
            }
        });
        
        jQuery(deleteContent).dialog('open');
    }

}

//------------------------------------------------ End Recurring Dialog Boxes

//------------------ Utilities ------------------------------

function isValidDate(dateStr) {
    //var str = "07/11/1984";

    var success = false;
    var datere = /[0-9]{2}\/[0-9]{2}\/[0-9][0-9]{3}/;
    
    var result = dateStr.match(datere);
    var newDate;
    
    if(result!=null){
        newDate = new Date(result[0]);
    }
    
    if(newDate != null && !isNaN(newDate.getTime())){
        success = true;
    }
    return success;
}

function isValidTime(dateStr, timeStr) {
    //var str = "07/11/1984";

    var success = false;
    var datere = /[0-9]{2}\/[0-9]{2}\/[0-9][0-9]{3}/;
    var timere = /[0-9]{1,2}(:[0-9]{2})\s(pm|am)/i;
    
    var result = dateStr.match(datere);
    var time = timeStr.match(timere);
    var newDate = null;
    
    if(result!=null){
        if(time!=null){
            newDate = new Date(result[0] + " " + time[0]);
            //newDate = new Date("hi"); // Invalide date
            
        }
    }
    
    if(newDate != null && !isNaN(newDate.getTime())){
        success = true;
    }
    return success;
}

function checkStartEndFields(startDate, startField, endDate, endField, startNow){
    
    var validStartDate = false;
    var validStartTime = false;
    var validEndDate = false;
    var validEndTime = false;
    
    var isChecked = jQuery(startNow).attr('checked');
    
    startDate.removeClass('error');
    startField.removeClass('error');
    endDate.removeClass('error');
    endField.removeClass('error');

    if(isValidDate(endDate.val())){
        validEndDate = true;
    }else{
        endDate.addClass('error');  
    }
    
    if(isValidTime(endDate.val(), endField.val())){
        validEndTime = true;
    }else{
        endField.addClass('error'); 
    }
    
    
    //if(validStartDate && validEndDate && validEndTime){
        //if the startNow checkbox is check, ignore
        if(!isChecked){
            
            if(isValidDate(startDate.val())){
                validStartDate = true;
            }else{
                startDate.addClass('error');    
            }
                    
            if(isValidTime(startDate.val(), startField.val())){
                validStartTime = true;
            }else{
                startField.addClass('error');   
            }
        }else{
            if(validEndDate && validEndTime){
                startDate.val("");
                startField.val("");
                validStartDate = true;
                validStartTime = true;
            }
            
        }
    //}
    
    //alert('validStartDate: '+validStartDate+' validStartTime: '+validStartTime+' validEndDate: '+validEndDate+' validEndTime: '+validEndTime);
    return (validStartDate && validStartTime && validEndDate && validEndTime) ? true : false; 

}
//------------------------------------------------ End Utilities

//------------------ Recurring Events ------------------------------

function recurringEventDialogBox(newDate,view,starttime){
        
    var dialogContent = jQuery('#edit-recur-event-dialog').load('modules/module_scheduler/fullcalendar/edit_recur_event2.html', function() {
        
        //appointment time
        jQuery("#edit-recur-event-dialog #startDate").datepicker({
            minDate: new Date()
            /*,
            onClose: function(dateText, inst) {
                // Commented by SMS: 8/7/2011
                // To address the problem when selecting a choice, it would not select it.
                // jQuery("#edit-recur-event-dialog #endDate").datepicker( "option" ,'minDate', dateText );
            }
            */
        });
        jQuery("#edit-recur-event-dialog #endDate").datepicker({minDate: newDate});
        
        
        
        jQuery('#edit-recur-event-dialog #recur_start').ptTimeSelect(); 
        jQuery('#edit-recur-event-dialog #recur_end').ptTimeSelect();
            
        var customLabel;
        if(is_admin_user){
            customLabel = "Host";
        }else{
            customLabel = "Course";
        }
        
        jQuery("#edit-recur-event-dialog #customddm").text(customLabel);
        
        /*
        jQuery("#edit-recur-event-dialog #startDate").focus(function() {
            jQuery("#ptTimeSelectCntr").hide();
        });
        jQuery("#edit-recur-event-dialog #recur_start").focus(function() {
            jQuery("#create-event-dialog #endDate").datepicker('hide');
            jQuery("#create-event-dialog #startDate").datepicker('hide');
        });
        jQuery("#edit-recur-event-dialog #endDate").focus(function() {
            jQuery("#ptTimeSelectCntr").hide();
        });
        
        jQuery("#edit-recur-event-dialog #recur_end").focus(function() {
            jQuery("#create-event-dialog #startDate").datepicker('hide');
            jQuery("#create-event-dialog #endDate").datepicker('hide');
        });
        jQuery("#edit-recur-event-dialog #end_after").focus(function() {
            jQuery("#create-event-dialog #startDate").datepicker('hide');
            jQuery("#create-event-dialog #endDate").datepicker('hide');
            jQuery("#ptTimeSelectCntr").hide();
        });
        */
        /*  
        jQuery("input").focus(function() {
            jQuery("#edit-recur-event-dialog #startDate").datepicker('hide');
            jQuery("#edit-recur-event-dialog #endDate").datepicker('hide');
            jQuery("#ptTimeSelectCntr").hide();
            //alert('jQuery("input").focus(function()');
        });
        */  
        jQuery("#edit-recur-event-dialog #recur_type").focus(function() {
            jQuery("#edit-recur-event-dialog #startDate").datepicker('hide');
            jQuery("#edit-recur-event-dialog #endDate").datepicker('hide');
            jQuery("#ptTimeSelectCntr").hide();
        });
        jQuery("#edit-recur-event-dialog #recur_course").focus(function() {
            jQuery("#edit-recur-event-dialog #startDate").datepicker('hide');
            jQuery("#edit-recur-event-dialog #endDate").datepicker('hide');
            jQuery("#ptTimeSelectCntr").hide();
        });
        /*
        jQuery("#edit-recur-event-dialog #recur_timezone").focus(function() {
            jQuery("#create-event-dialog #startDate").datepicker('hide');
            jQuery("#create-event-dialog #endDate").datepicker('hide');
            jQuery("#ptTimeSelectCntr").hide();
        });
        */
        /*  
        jQuery("fieldset").focus(function() {
            jQuery("#edit-recur-event-dialog #startDate").datepicker('hide');
            jQuery("#edit-recur-event-dialog #endDate").datepicker('hide');
            jQuery("#ptTimeSelectCntr").hide();
            //alert('jQuery("fieldset").focus(function() {');
        });
        */
        //recurrence pattern
        jQuery("#daily").attr('checked', true);
        jQuery("#daily_container").show();
        jQuery("#weekly_container").hide();
        jQuery("#monthly_container").hide(); 
        jQuery("#yearly_container").hide();
        
        
        jQuery("#daily").click(function () { 
            recurType = "daily";
            jQuery("#ocurrences_label").html(recurType +' ocurrences');
            jQuery("#daily_container").show("slow");
            jQuery("#weekly_container").hide();
            jQuery("#monthly_container").hide(); 
            jQuery("#yearly_container").hide();
        
        });
        jQuery("#weekly").click(function () { 
            recurType = "weekly";
            jQuery("#ocurrences_label").html(recurType +' ocurrences');
            jQuery("#weekly_container").show("slow");
            jQuery("#daily_container").hide();
            jQuery("#monthly_container").hide(); 
            jQuery("#yearly_container").hide();
        });
        jQuery("#monthly").click(function () { 
            recurType = "monthly";
            jQuery("#ocurrences_label").html(recurType +' ocurrences');
            jQuery("#monthly_container").show("slow");
            jQuery("#daily_container").hide();
            jQuery("#weekly_container").hide();
            jQuery("#yearly_container").hide();
        });
        jQuery("#yearly").click(function () { 
            recurType = "yearly";
            jQuery("#ocurrences_label").html(recurType +' ocurrences');
            jQuery("#yearly_container").show("slow");
            jQuery("#daily_container").hide();
            jQuery("#weekly_container").hide();
            jQuery("#monthly_container").hide(); 
        });
        
        // Range of Occurance Radio Buttons
        jQuery("#end_after").click(function(){
            jQuery("#ocurrences").focus();
        });
        jQuery("#ocurrences").focus(function(){
            jQuery("#end_after").attr('checked','checked');
        });
        jQuery("#end_by").click(function(){
            jQuery("#endDate").focus();
        });
        jQuery("#endDate").focus(function(){
        
            jQuery("#end_by").attr('checked','checked');
            
        });
    
        var dayformatter = "mm/dd/yyyy";    // mmmm d, yyyy
        var timeformatter = "h:MM TT";      // h:MM:ss TT 
        var typeFieldOptions = "";
        var courseFieldOptions = "";
        //var timezoneFieldOptions = "";
        
        // Load types in the select box, and select current type
        /*for(var i = 0; i<types.length; i++){
            typeFieldOptions +=  "<option>"+types[i]+"</option>";
        }
        for(var i = 0; i<courses.length; i++){
            courseFieldOptions +=  "<option>"+courses[i]+"</option>";
        }*/
        
        for(var i = 0; i<types.length; i++){
            
            if(avail_resource_listing.length > 0){
                var type = types[i];
                var added = false;
                
                //alert('RESOURCE: '+type);
                for(var j = 0; j <avail_resource_listing.length; j++){
                    if(!added){
                        var newtype = type.replace(/ /g, "-").toLowerCase();
                        //alert('avail_resource_listing: \n'+avail_resource_listing[j]+' \n newtype: \n'+newtype);
                        
                        if(newtype == avail_resource_listing[j]){
                            //alert('MATCH: '+newtype);
                            // Modified by SMS: 8/7/2011
                            // To make sure that certificate exams cannot be scheduled on a recurring basis.
                            // alert("1 " + types[i]);
                            if (types[i] != "CERTIFICATE") {
                                // alert("2 " + types[i]);
                                typeFieldOptions +=  "<option>"+types[i]+"</option>";
                            }
                            // typeFieldOptions +=  "<option>"+types[i]+"</option>";
                            added = true;
                        }
                    }
                }
            }else{
                // Modified by SMS: 8/7/2011
                // To make sure that certificate exams cannot be scheduled on a recurring basis.
                // alert("3 " + types[i]);
                if (types[i] != "CERTIFICATE") {
                    // alert("4 " + types[i]);
                    typeFieldOptions +=  "<option>"+types[i]+"</option>";
                }               
                // typeFieldOptions +=  "<option>"+types[i]+"</option>";
            }
        }
        
        for(var i = 0; i<courses.length; i++){
            
            if(avail_course_listing.length >0){
                var course = courses[i];
                var added = false;
                
                //alert('COURSE: '+course);
                for(var j = 0; j <avail_course_listing.length; j++){
                    
                    if(!added){
                        var newcoursename = course.replace(/ /g, "-").toLowerCase();
                        newcoursename = newcoursename.replace(/\./g, "").toLowerCase();
                        //console.log('avail_course_listing: \n'+avail_course_listing[j]+' \n newcoursename: \n'+newcoursename);
                        
                        if(newcoursename == avail_course_listing[j]){
                            //alert('MATCH: '+newcoursename);
                            courseFieldOptions +=  "<option>"+courses[i]+"</option>";
                            added = true;
                        }
                    }
                }
            }else{
                courseFieldOptions +=  "<option>"+courses[i]+"</option>";
            }
        }
        
        
        /*
        for(var i = 0; i<zones.length; i++){
            timezoneFieldOptions += "<option>"+zones[i]+"</option>";
        }*/
        
        var startDate = jQuery(this).find("input[name='startDate']").val(newDate.format(dayformatter));
        var endDate = jQuery(this).find("input[name='endDate']");
        var startField = (starttime) ? jQuery(this).find("input[name='recur_start']").val(newDate.format(timeformatter)) : jQuery(this).find("input[name='recur_start']");
        var endField = jQuery(this).find("input[name='recur_end']");
        
        var typeField = jQuery(this).find("select[name='recur_type']");
        var courseField = jQuery(this).find("select[name='recur_course']");
        //var timezoneField = jQuery(this).find("select[name='recur_timezone']").html(timezoneFieldOptions);
        
        jQuery(typeField).html(typeFieldOptions);
        jQuery(courseField).html(courseFieldOptions);
        /*
        if(is_mentor_user){
            var parent = jQuery(typeField).parent();
            parent.hide();
                
        }*/
        
        // Debugging
        //var startField = jQuery("input[name='recur_start']").val("1:00 PM");
        //var endField = jQuery("input[name='recur_end']").val("3:00 PM");
        
        //Default Values
        jQuery("input[name='daily_num']").val("1");
        jQuery("input[name='weekly_weeks']").val("1");
        jQuery("input[name='monthly_day']").val("1");
        jQuery("input[name='monthly_months']").val("1");
        jQuery("input[name='monthly_months_nth']").val("1");
        jQuery("input[name='yearly_years']").val("1");
        
        jQuery("#edit-recur-event-dialog #ocurrences_label").html('daily ocurrences');
        /*
        alert("ocurrences_label- html");
        jQuery("#edit-recur-event-dialog #ocurrences_label").text('daily ocurrences');
        alert("ocurrences_label- text");
        jQuery("#edit-recur-event-dialog #ocurrences_label").val('daily ocurrences');
        alert("ocurrences_label- val");
        */
    
    });

    jQuery(dialogContent).dialog({
        autoOpen: false,
        height: 500,
        width: 500,
        modal: true,
        buttons: {
            'create recurring event': function() {
                //jQuery("#recur-event-dialog").submit();
                
                if(!generateRecurringEvent(this)){
                    jQuery(this).dialog('close');
                }
                
            },
            close: function() {
                jQuery(this).dialog('close');
    
            }
        },
        close: function() {
            //allFields.val('').removeClass('ui-state-error');
        }
    });
    
    jQuery(dialogContent).dialog('open');
}
    


function generateRecurringEvent(form){
    
    var errorClass = "ui-state-error";
    
    var recurType = jQuery(form).find("input[name='recurrence_choice']:checked").val();
    
    var startTime = jQuery(form).find("input[name='recur_start']");
    var endTime = jQuery(form).find("input[name='recur_end']");
    var course = jQuery(form).find("select[name='recur_course']");
    var resourceType = jQuery(form).find("select[name='recur_type']");
    var time_container = jQuery(form).find("#recur_time");
    
    var end_date_choice = jQuery(form).find("input[name='end_date_choice']:checked");
    var startDate = jQuery(form).find("input[name='startDate']");
    var endDate = jQuery(form).find("input[name='endDate']");
    var ocurrences = jQuery(form).find("input[name='ocurrences']");
    
    var range_table = jQuery(form).find("#range_end_date_choice");
    var range_container = jQuery(form).find("#recur_range");
    
    // Event Vars
    var recur_start, recur_end, recur_course, recur_type;
    var recur_range = {};
    var recur_pattern = {};
    
    var errors = false;

    
    // Appointment Time
    time_container.removeClass(errorClass);
    
    if(startTime.val() || endTime.val()){
        
        if(startTime.val()){
            recur_start = startTime.val();
        }else{
            startTime.addClass(errorClass);
            errors = true;
        }
        
        if(endTime.val()){
            recur_end = endTime.val();
        }else{
            endTime.addClass(errorClass);
            errors = true;
        }
        
    }else{
        time_container.addClass(errorClass);
        errors = true;
    }
    
    recur_type = resourceType.val();
    recur_course = course.val();
    
    // Range of ocurrence
    range_container.removeClass(errorClass);
    range_table.removeClass(errorClass);
    ocurrences.removeClass(errorClass);
    startDate.removeClass(errorClass);
    endDate.removeClass(errorClass);
    
    
    if(end_date_choice.val() || startDate.val()){
    
        if(startDate.val()){
            //HERE
            recur_range.start = startDate.val();
        
        }else{
            startDate.addClass(errorClass);
            errors = true;
        }
    
        if(end_date_choice.val() == "end_after"){
            
            var times = parseInt(ocurrences.val());
            if(times){
                if(times>0){
                    //HERE  
                    recur_range.type = "end_after";
                    recur_range.occurences = times;
                    
                }else{
                    ocurrences.addClass(errorClass);
                    errors = true;
                }
            }else{
                ocurrences.addClass(errorClass);
                errors = true;
            }
            
        }else if(end_date_choice.val() == "end_by"){
            
            if(endDate.val()){
                //HERE
                recur_range.type = "end_by";
                recur_range.endby = endDate.val();
            }else{
                endDate.addClass(errorClass);
                errors = true;
            }
            
        }else{
            range_table.addClass(errorClass);
            errors = true;
        }
    }else{
        range_container.addClass(errorClass);
        errors = true;
    }
                    
    // Recurrence pattern
    if(recurType == "daily"){
    
        // Daily
        var daily_choice = jQuery("input[name=daily_choice]:checked");
        var daily_days = jQuery(form).find("input[name='daily_num']");
        var container = jQuery(form).find("#daily_container");
        
        container.removeClass(errorClass);
        daily_days.removeClass(errorClass);
        
        if(daily_choice.val() == "every_day"){
            var days = parseInt(daily_days.val());
            
            if(days){
                if(days>0){
                    // Here
                    recur_pattern.type = "every_day";
                    recur_pattern.occurences = days;
                }else{
                    daily_days.addClass(errorClass);
                    errors = true;
                }
            }else{
                daily_days.addClass(errorClass);
                errors = true;
            }
            
        }else if(daily_choice.val() == "every_weekday"){
            
            recur_pattern.type = "every_weekday";
        
        }else{
            container.addClass(errorClass);
            errors = true;
        }
        
        if(!errors){
            
            dailyRecurrEvents(recur_start, recur_end, recur_course, recur_type, recur_pattern, recur_range);
        }
        
    }else if(recurType == "weekly"){
        
        // Weekly
        var weekly_weekday = jQuery("input[name=weekly_weekday]:checked")//;
        var num_weeks = jQuery(form).find("input[name='weekly_weeks']");
        var container = jQuery(form).find("#weekly_container");
        var weekly_table = jQuery(form).find("#weekly_weekday_table");
        
        container.removeClass(errorClass);
        weekly_table.removeClass(errorClass);
        num_weeks.removeClass(errorClass);
        
        var weeks = parseInt(num_weeks.val());
        
        if(weekly_weekday.val() || weeks){
            
            if(weeks>0){
                recur_pattern.weeks = weeks;
            }else{
                num_weeks.addClass(errorClass);
                errors = true;
            }
        
            if(weekly_weekday.val()){
                var weekdays = [];
                weekly_weekday.each(function(){
                                             
                    weekdays.push(getWeekdayNumber(jQuery(this).val()));
                    
                });
                recur_pattern.weekdays = weekdays;
            }else{
                weekly_table.addClass(errorClass);
                errors = true;
            }
            
        }else{
            num_weeks.addClass(errorClass);
            container.addClass(errorClass);
            errors = true;
        }
        
        if(!errors){
            weeklyRecurrEvents(recur_start, recur_end, recur_course, recur_type, recur_pattern, recur_range);
        }
        
    }else if(recurType == "monthly"){
        
        // Monthly
        var monthly_choice = jQuery("input[name=monthly_choice]:checked");
        var monthly_days = jQuery(form).find("input[name='monthly_day']");
        var monthly_months;
        //var monthly_num_months = jQuery(form).find("input[name='monthly_num_months']");
        var container = jQuery(form).find("#monthly_container");
        
        container.removeClass(errorClass);
        monthly_days.removeClass(errorClass);
        //monthly_months.removeClass(errorClass);
        //monthly_num_months.removeClass(errorClass);
        
        // recur_pattern: type(string), days(int), months(int)
        
        if(monthly_choice.val() == "monthly_numday"){
            monthly_months = jQuery(form).find("input[name='monthly_months']");
            monthly_months.removeClass(errorClass);
            recur_pattern.type = "monthly_numday";
            
            var days = parseInt(monthly_days.val());
            var months = parseInt(monthly_months.val());
            
            if(days || months){
                if(days){
                    if(days>0){
                        // HERE
                        recur_pattern.days = days;
                    }else{
                        monthly_days.addClass(errorClass);
                        errors = true;
                    }
                }else{
                    monthly_days.addClass(errorClass);
                    errors = true;
                }
                
                if(months){
                    if(months>0){
                        // HERE
                        recur_pattern.months = months;
                    }else{
                        monthly_months.addClass(errorClass);
                        errors = true;
                    }
                }else{
                    monthly_months.addClass(errorClass);
                    errors = true;
                }
            }else{
                container.addClass(errorClass);
                errors = true;
            }
            
        }else if(monthly_choice.val() == "monthly_weekday"){
            
            monthly_months = jQuery(form).find("input[name='monthly_months_nth']");
            monthly_months.removeClass(errorClass);
            recur_pattern.type = "monthly_weekday";
            
            var nth = jQuery(form).find("select[name='monthly_week_num']").val();
            var weekday = jQuery(form).find("select[name='monthly_on_weekdays']").val();
            var months = parseInt(monthly_months.val());
            // recur_pattern: nth
            if(months){
                if(months>0){
                    // HERE
                    recur_pattern.nth = nth.toLowerCase();
                    recur_pattern.weekdays = weekday.toLowerCase(); 
                    recur_pattern.months = months;
                }else{
                    monthly_months.addClass(errorClass);
                    errors = true;
                }
            }else{
                monthly_months.addClass(errorClass);
                errors = true;
            }
            
        }else{
            container.addClass(errorClass);
            errors = true;
        }
        
        if(!errors){
            monthlyRecurrEvents(recur_start, recur_end, recur_course, recur_type, recur_pattern, recur_range);
        }
        
    }else if(recurType == "yearly"){
        
        // Yearly
        var yearly_choice = jQuery("input[name=yearly_choice]:checked");
        var every_years = jQuery(form).find("input[name='yearly_years']");
        var container = jQuery(form).find("#yearly_container");
        
        container.removeClass(errorClass);
        every_years.removeClass(errorClass);
        
        var years = parseInt(every_years.val());
        if(years){
            if(years>0){
                // HERE
                recur_pattern.years = years;
            }else{
                every_years.addClass(errorClass);
                errors = true;
            }
        }else{
            every_years.addClass(errorClass);
            errors = true;
        }
        
        if(yearly_choice.val() == "yearly_on"){
            
            recur_pattern.type = "yearly_on";
            
            var yearly_on_month = jQuery(form).find("select[name='yearly_on_month']");
            var yearly_on_day = jQuery(form).find("select[name='yearly_on_day']");
            
            recur_pattern.month = parseInt(yearly_on_month.val());
            recur_pattern.day = parseInt(yearly_on_day.val());
            
            
        }else if(yearly_choice.val() == "yearly_on_the"){
            
            recur_pattern.type = "yearly_on_the";
            
            var yearly_on_the_week = jQuery(form).find("select[name='yearly_on_the_week']");
            var yearly_on_the_weekdays = jQuery(form).find("select[name='yearly_on_the_weekdays']");
            var yearly_on_the_month = jQuery(form).find("select[name='yearly_on_the_month']");
            
            recur_pattern.nth = yearly_on_the_week.val();
            recur_pattern.weekdays = yearly_on_the_weekdays.val(); 
            recur_pattern.month = parseInt(yearly_on_the_month.val());
            
            
        }else{
            container.addClass(errorClass); 
            errors = true;
        }
        
        if(!errors){
            yearlyRecurrEvents(recur_start, recur_end, recur_course, recur_type, recur_pattern, recur_range);
        }
    
    }
    return errors;
}

//------------------------------------------------ End Recurring Events



function addHostDialogBox(){
    

    var addHostDialog =  jQuery("#add-host-dialog").load('modules/module_scheduler/fullcalendar/add_host.html',function() {

         //jQuery("#add-host-form").validate();
    
         jQuery("#add-host-form").submit(function() {
                 //jQuery("#add-host-form").validate();
                addHost();
                jQuery(addHostDialog).dialog("close");
                return false;
            });
        
    }); 
        
    



    jQuery(addHostDialog).dialog({
        autoOpen: false,
        width: 400,
        modal: true,
        title: "Add new host",
        close: function() {
           jQuery(addHostDialog).dialog("destroy");
           jQuery(addHostDialog).hide();

        },
        buttons: {
            close : function() {
                jQuery(addHostDialog).dialog("close");
            }
        }
    });
    
    jQuery(addHostDialog).dialog('open');

}

function editHostDialogBox(id){
    

    var addHostDialog =  jQuery("#add-host-dialog").load('modules/module_scheduler/fullcalendar/add_host.html',function() {

         //jQuery("#add-host-form").validate();
    
         jQuery("#add-host-form").submit(function() {
                 //jQuery("#add-host-form").validate();
                setHost(id);
                jQuery(addHostDialog).dialog("close");
                return false;
            });
            
        jQuery.ajax({
            type: 'POST',
            url: 'modules/module_scheduler/fullcalendar/calendar.php',
            dataType: 'json',
            data: {
                action: 'getHost',
                requestingUser:  jQuery('#username').val(),
                id:id
            },
            success: function(data){
                
                jQuery("#hname").val(data.host.name);
                jQuery("#husername").val(data.host.username);
                jQuery("#hpassword").val(data.host.password);
                jQuery("#hsshport").val(data.host.sshPort);
                jQuery("#hnumcap").val(data.host.veNumCap);
                jQuery("#hfreeport").val(data.host.veFirstFreePort);
                jQuery("#hport").val(data.host.vePortNum);
                
    
                if(data.host.active==true)
                    jQuery("#hactive").attr('checked', true);
    
       
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                var header = "Manage Hosts";
                var message = "We were unable get host.";
                var icon = "alert";
                message = textStatus + " : " +errorThrown;
                noticeDialog(header, message, icon);
                
            }
        });
        
    }); 
        
    



    jQuery(addHostDialog).dialog({
        autoOpen: false,
        width: 400,
        modal: true,
        title: "Add new host",
        close: function() {
           jQuery(addHostDialog).dialog("destroy");
           jQuery(addHostDialog).hide();

        },
        buttons: {
            close : function() {
                jQuery(addHostDialog).dialog("close");
            }
        }
    });
    
    jQuery(addHostDialog).dialog('open');

}
