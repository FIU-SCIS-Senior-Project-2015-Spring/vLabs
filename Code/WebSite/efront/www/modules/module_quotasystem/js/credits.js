/*
 * ct_table is a global DataTable for Credit Types
 */
var ct_table;
var ct_open_validation_forms = new Array();

function ct_init(){
	jQuery("#add-creditType").button();
	jQuery("#add-creditType").click(function() {
    	ct_openForm("#addCreditTypeForm", true, null);
    	jQuery("#add-creditType").button("disable");
    });

    ct_loadTable();
}
/*
 * Load Credit Types table
 */
function ct_loadTable()
{
    jQuery("#creditsTableContainer").html("");

    createLoadingDivAfter("#creditsTableContainer", "Loading Credit Types table");

    jQuery.ajax({
        type: 'POST',
        url: '/modules/module_quotasystem/server/creditTypeManager.php',
        dataType: 'json',
        data: {
            action: 'getCreditTypes'
        },
        success: function(data){
			
			// added: jam - 08.09.2011
			if(data){
        		if(!jQuery.isArray(data))
	        		data = [data];
				//console.log(data);
				removeLoadingDivAfter("#creditsTableContainer");
	
				jQuery('#creditsTableContainer').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="creditsTable"></table>' );
	
				ct_table = jQuery("#creditsTable").dataTable({
					"aaData": data,
					"aoColumns": [
					{  "bVisible": false },
					{ "sTitle": "Name" },
					{ "sTitle": "Resource" },
					{ "sTitle": "Course" },
					{ "sTitle": "Policy" },
					{ "sTitle": "Active" , "fnRender": function (oObj) { return oObj.aData[5]=="true" ? "Yes" : "No"; } },
					{ "sTitle": "Assignable" , "fnRender": function (oObj) { return oObj.aData[6]=="true" ? "Yes" : "No"; } }
					],
					"bJQueryUI": true,
					"bAutoWidth": false,
					"sPaginationType": "full_numbers"
				});
	
				jQuery("#creditsTable").removeAttr("style");
	
				//Attach event handler to each row in the table
				jQuery('#creditsTable tbody tr td').live('click', ct_rowClickHandler);
			
			}
			
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter("#creditsTableContainer");
            displayError("#creditsTableContainer",errorThrown);
        }
    });
}

/*
 * Handle the click event on a row in the Credit Type table
 */
function ct_rowClickHandler(){
	var nTr = this.parentNode;
	var aData = null; 
	try{
		aData = ct_table.fnGetData( nTr );
	}catch(err){
		return;
	}
	var open = false;

	try{
		if(jQuery(nTr).next().children().first().hasClass("ui-state-highlight"))
			open=true;
	}catch(err){}

	var divId = "#creditDetails"+aData[0];

	if (open){
		/* This row is already open - close it */
		ct_table.fnClose( nTr );
		jQuery(nTr).css("color","");
		ct_removeValidationForm(divId);
	}else{
		/* Open this row */
		ct_openDetailsRow( nTr );
	}
}

/*
 * Open Credit Type details row. Bind events for Modify, Delete, Submit and Cancel buttons
 */
function ct_openDetailsRow( nTr ){
	ct_table.fnOpen( nTr, ct_formatDetailsRow(nTr), 'ui-state-highlight' );
	var aData = ct_table.fnGetData( nTr );
	jQuery("#modifyCreditType"+aData[0]).button();
	jQuery("#deleteCreditType"+aData[0]).button();

	var divId = "#creditDetails"+aData[0];

	jQuery("#modifyCreditType"+aData[0]).click(function(){
		jQuery(nTr).css("color","#c5dbec");
		jQuery(divId).empty();
		ct_openForm(divId, false, nTr, aData[0]);
	});

	jQuery("#deleteCreditType"+aData[0]).click(function(){
		jQuery(divId).empty();
		ct_delete(divId, nTr, aData[0]);

	});
}

/*
 * Return html for a Credit Type details row
 */
function ct_formatDetailsRow ( nTr )
{
	var aData = ct_table.fnGetData( nTr );
	var sOut = '';

	sOut += '<div id="creditDetails'+aData[0]+'" style="text-align:right">';
	sOut += '	<button id="modifyCreditType'+aData[0]+'">Modify</button>';
	sOut += '	<button id="deleteCreditType'+aData[0]+'">Delete</button>';
	sOut += '</div>';

	return sOut;
}

function cs_isValidForm(containerId){
	for(var i=0; i < ct_open_validation_forms.length ; i++){
		if(ct_open_validation_forms[i].container_id == containerId){
			return LiveValidation.massValidate(ct_open_validation_forms[i].form_fields);
		}
	}
	//alert("No forms in the ct_open_validation_forms array");
	return false;
}

/*
 * Open Add Credit Type form on top of the Credit Types Table
 * containerId - id for the div that will contain the form
 * add - boolean - true=add, false=edit
 */
function ct_openForm(containerId, add, nTr, creditTypeId)
{
	jQuery(containerId).empty();
	jQuery(containerId).hide();

    jQuery(containerId).load("modules/module_quotasystem/creditTypeForm.html", function(){

        jQuery(containerId+" .submit").button();
        jQuery(containerId+" .cancel").button();

        ct_loadResourcesCoursesPolicies(containerId, add, nTr, creditTypeId);

        ct_addFormValidation(containerId);
    });
}

function ct_addFormValidation(containerId){
	var formFields = new Array();

	var id = containerId.substring(1)+"_nameCreditType";
	jQuery(containerId+" .nameCreditType").attr("id",id);
	var nameValidator = new LiveValidation(id,{ wait: 500 });
	nameValidator.add( Validate.Presence );
	nameValidator.add( Validate.Length, { maximum: 45 });
	formFields.push(nameValidator);

	var liveValidationForm = { container_id: containerId, form_fields: formFields };
	ct_open_validation_forms.push(liveValidationForm);
}

function ct_removeValidationForm(containerId){

	var tempArray = new Array();
	for(var i=0; i < ct_open_validation_forms.length ; i++){
		if(ct_open_validation_forms[i].container_id != containerId){
			tempArray.push(ct_open_validation_forms[i]);
		}
	}

	ct_open_validation_forms = tempArray;
}
/*
 *
 */
function ct_fillOutForm(containerId, nTr, id){

	createLoadingDivAfter(containerId, "Loading Credit Type data");
	  jQuery.ajax({
	        type: 'POST',
	        url: '/modules/module_quotasystem/server/creditTypeManager.php',
	        dataType: 'json',
	        data: {
	            action: 'getCreditType',
	            id:id
	        },
	        success: function(data){
	        	removeLoadingDivAfter(containerId);
				console.log(data);
	        	var creditType =  data.creditType[0];//.creditType;
	        	jQuery(containerId+" .nameCreditType").val(creditType.name);
	        	jQuery(containerId+" .resourceCreditType").val(creditType.resource);
	        	jQuery(containerId+" .policyCreditType").val(creditType.policyId);
	        	jQuery(containerId+" .courseCreditType").val(creditType.courseId);
	        	jQuery(containerId+" .activeCreditType").attr('checked', creditType.active);
	        	jQuery(containerId+" .assignableCreditType").attr('checked', creditType.assignable);

	        	jQuery(containerId).slideDown(400);
	        },
	        error: function(XMLHttpRequest, textStatus, errorThrown){
	        	removeLoadingDivAfter(containerId);
	            displayError(containerId, errorThrown, function(){
	            	jQuery(nTr).css("color","");
	                ct_table.fnClose( nTr );
	            });
	        }
	    });

}


/*
 * Send a request to add a Credit Type in the Quota System
 */
function ct_add(containerId, name, resource, policyId,policyName, courseId,courseName, active, assignable)
{
	createLoadingDivAfter(containerId, "Creating Credit Type");

    jQuery.ajax({
        type: 'POST',
        url: '/modules/module_quotasystem/server/creditTypeManager.php',
        dataType: 'json',
        data: {
            action: 'addCreditType',
            name:name,
            resource:resource,
            active:active,
            policyId:policyId,
            courseId:courseId,
            assignable:assignable
        },
        success: function(data){
        	removeLoadingDivAfter(containerId);
        	ct_table.fnAddData( [
        			data.id,
        			name,
        			resource,
        			courseName,
        			policyName,
        			active ? "true" : "false",
        			assignable ? "true" : "false"] );

        	displayMessage(containerId,"Credit type ["+name+"] successfully added");
        },

        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown);
        }
    });

}

/*
 * Send a request to modify a Credit Type in the Quota System
 */
function ct_modify(containerId, nTr, id, name, resource, policyId,policyName, courseId,courseName, active, assignable)
{
	createLoadingDivAfter(containerId, "Modifying Credit Type");

    jQuery.ajax({
        type: 'POST',
        url: '/modules/module_quotasystem/server/creditTypeManager.php',
        dataType: 'json',
        data: {
            action: 'modifyCreditType',
            id:id,
            name:name,
            resource:resource,
            active:active,
            policyId:policyId,
            courseId:courseId,
            assignable:assignable
        },
        success: function(data){
        	removeLoadingDivAfter(containerId);

        	if(!data.success){
        		displayError(containerId,data.message, function(){
                	jQuery(nTr).css("color","");
                    ct_table.fnClose( nTr );
                });
        	}else{
	            displayMessage(containerId,"Credit Type ["+name+"] successfully modified", function(){
	            	jQuery(nTr).css("color","");
	                ct_table.fnClose( nTr );
	            });
	            
	        	ct_table.fnUpdate( [id,
	        	                    name,
	        	                    resource,
	        	                    courseName,
	        	                    policyName,
	        	                    active ? "true" : "false",
	        	                    assignable ? "true" : "false"],
	        	                    nTr,
	        	                    false,
	        	                    false);
        	}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown, function(){
            	jQuery(nTr).css("color","");
                ct_table.fnClose( nTr );
            });
        }
    });

}

/*
 * Send a request to delete a Credit Type in the Quota System
 */
function ct_delete(divId, nTr, id)
{
	createLoadingDivAfter(divId, "Deleting Credit Type");
    jQuery.ajax({
        type: 'POST',
        url: '/modules/module_quotasystem/server/creditTypeManager.php',
        dataType: 'json',
        data: {
            action: 'deleteCreditType',
            id:id
        },
        success: function(data){
        	removeLoadingDivAfter(divId);
        	
        	if(data.success){
                displayMessage(divId,"Credit Type successfully deleted", function(){
                	ct_table.fnClose( nTr );
            		ct_table.fnDeleteRow(nTr);
	            });  
        	}else{
            	displayError(divId,data.message, function(){
            		jQuery(nTr).css("color","");
                	ct_table.fnClose( nTr );
                });
        		
        	}


        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter(divId);
        	displayError(divId,errorThrown, function(){
            	jQuery(nTr).css("color","");
                ct_table.fnClose( nTr );
            });
        }
    });

}

/*
 * GetCreditTypeInfo
 *
 */
function ct_getCreditType(id){
	   jQuery.ajax({
	        type: 'POST',
	        url: '/modules/module_quotasystem/server/creditTypeManager.php',
	        dataType: 'json',
	        data: {
	            action: 'getCreditType',
	            id:id
	        },
	        success: function(data){
	        	return data.creditType;

	        },
	        error: function(XMLHttpRequest, textStatus, errorThrown){
	        	displayError("creditsTab div",errorThrown);
	        }
	    });

}


/*
 * Fill the select boxes (Course, Resource, Policy) in the Credit Types form
 */
function ct_loadResourcesCoursesPolicies(containerId, add, nTr, creditTypeId)
{
    var content_resources='';
    var content_courses='';
    var content_policies='';

    createLoadingDivAfter(containerId, "Loading Credit Type form");

    jQuery(containerId).hide();
    // load resources and courses
    jQuery.ajax({
        type: 'POST',
        url: '/modules/module_quotasystem/server/creditTypeManager.php',
        dataType: 'json',
        data: {
            action: 'getResources'
        },
        success: function(data){
			//console.log("data from getresouces");
			//console.log(data);
            //Fill out select boxes for resources and courses
            //var resources = data.resources;
            var courses = data.courses;

            //for (var i in resources )
            //    content_resources+="<option value='"+resources[i]+"'>"+resources[i]+"</option>";

            for (var i in courses ){
				if(isNaN(courses[i].id))
					break;
				content_courses+="<option value='"+courses[i].id+"'>"+courses[i].shortname+"</option>";
			}
            jQuery(containerId+" .resourceCreditType").empty();
            jQuery(containerId+" .courseCreditType").empty();
            jQuery(containerId+" .resourceCreditType").append(content_resources);
            jQuery(containerId+" .courseCreditType").append(content_courses);
            // load policies
            jQuery.ajax({
                type: 'POST',
                url: 'server/policyManager.php',
                dataType: 'json',
                data: {
                    action: 'getAssignablePolicies'
                },
                success: function(data){
					//console.log("data from assignablepolicies");
					//console.log(data);
                	removeLoadingDivAfter(containerId);
					//TN 6/16/2015 addition to prevent undefined glitch
                    for (var p in data ){
						if(isNaN(data[p].id))
							break;
                        content_policies+="<option value='"+data[p].id+"'>"+data[p].name+" : "+data[p].type+"</option>";
					}
                    jQuery(containerId+" .policyCreditType").empty();
                    jQuery(containerId+" .policyCreditType").append(content_policies);

                    //Bind events for add
                    if(add)
                    {
                    	jQuery(containerId).addClass("ui-state-highlight");

            	        jQuery(containerId+" .submit").click(function(){

            	        	if(cs_isValidForm(containerId)){

            	                jQuery(containerId).slideUp(400,function(){
                	                ct_add(containerId,
                	                		jQuery(containerId+" .nameCreditType").val(),
                	                		jQuery(containerId+" .resourceCreditType").val(),
                	                		jQuery(containerId+" .policyCreditType").val(),
                	                		jQuery(containerId+" .policyCreditType option[value="+jQuery(containerId+" .policyCreditType").val()+"]").text(),
                	                		jQuery(containerId+" .courseCreditType").val(),
                	                		jQuery(containerId+" .courseCreditType option[value="+jQuery(containerId+" .courseCreditType").val()+"]").text(),
                	                		jQuery(containerId+" .activeCreditType").is(':checked'),
                	                		jQuery(containerId+" .assignableCreditType").is(':checked'));

            	            		jQuery(containerId).empty();
            	            		jQuery("#add-creditType").button("enable");
                	                ct_removeValidationForm(containerId);
            	            	});
            	            }
            	        	else{
            	        		//alert("The Create Credit Type form contained some errors.\nPlease confirm all required fields have been correctly field before saving.");
            	        	}
            	        });

            	        jQuery(containerId+" .cancel").click(function(){

            	        	jQuery(containerId).slideUp(400,function(){
            	        		jQuery(containerId).empty();
            	        		jQuery("#add-creditType").button("enable");
            	        		ct_removeValidationForm(containerId);
            	        	});

            	        });

            	        jQuery(containerId).slideDown(400);
                    }
                    //Bind events for edit
                    else
                    {
                		  ct_fillOutForm(containerId, nTr,  creditTypeId);

                		  jQuery(containerId+" .submit").click(function(){
              	        	var bValid = true;

              	        	if(cs_isValidForm(containerId)){

            	                jQuery(containerId).slideUp(400,function(){
                  	                ct_modify(containerId, nTr, creditTypeId,
                  	                		jQuery(containerId+" .nameCreditType").val(),
                  	                		jQuery(containerId+" .resourceCreditType").val(),
                  	                		jQuery(containerId+" .policyCreditType").val(),
                  	                		jQuery(containerId+" .policyCreditType option[value="+jQuery(containerId+" .policyCreditType").val()+"]").text(),
                  	                		jQuery(containerId+" .courseCreditType").val(),
                  	                		jQuery(containerId+" .courseCreditType option[value="+jQuery(containerId+" .courseCreditType").val()+"]").text(),
                  	                		jQuery(containerId+" .activeCreditType").is(':checked'),
                  	                		jQuery(containerId+" .assignableCreditType").is(':checked')
                  	                );

            	            		jQuery(containerId).empty();
            		                ct_removeValidationForm(containerId);
            	            	});


              	            }
              	        	else{
              	        		//alert("The Modify Credit Type form contained some errors.\nPlease confirm all required fields have been correctly field before saving.");
              	        	}
            	        });

            	        jQuery(containerId+" .cancel").click(function(){

            	        	jQuery(containerId).slideUp(400,function(){
                        		jQuery(containerId).empty();
                        		jQuery(nTr).css("color","");
            	                ct_table.fnClose( nTr );
            	                ct_removeValidationForm(containerId);
            	        	});
            	        });
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown){
                	displayError(containerId,errorThrown);
                }
            });
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	displayError(containerId,errorThrown);
        }
    });



}

/*
 * check if resource is inside resourceArr
 */
function ct_resourceExists(resourceArr, resource)
{
    for(var i in resourceArr)
    {
        if(resourceArr[i].resource == resource)
            return true;
    }

    return false;
}


