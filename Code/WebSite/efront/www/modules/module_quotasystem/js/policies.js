/*
 * pol_table is a global DataTable for Policies
 */
var pol_table;
var pol_open_validation_forms = new Array();


function pol_init(){

	jQuery("#add-policy").button();
	jQuery("#add-policy").button("enable");
    jQuery("#add-policy").click(function() {
    	pol_openForm("#addPolicyForm", true);
    	jQuery("#add-policy").button("disable");
    });
    pol_loadTable();
}

/*
 * Load Policies table
 */

function pol_loadTable()
{
    jQuery("#policiesTableContainer").html("");

    createLoadingDivAfter("#policiesTableContainer", "Loading Policies table");

    jQuery.ajax({
        type: 'POST',
        url: '/modules/module_quotasystem/server/policyManager.php',
        dataType: 'json',
        data: {
            action: 'getPolicies'
        },
        success: function(data){
        	if(data){
        		if(!jQuery.isArray(data))
	        		data = [data];
				//console.log(data);
	        	removeLoadingDivAfter("#policiesTableContainer");

	        	jQuery('#policiesTableContainer').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="policiesTable"></table>' );

	            pol_table = jQuery("#policiesTable").dataTable({
	            	"aaData": data,
	                "aoColumns": [
	                { "bVisible": false },
	                { "sTitle": "Name" },
	                { "sTitle": "Type" },
	                { "sTitle": "Absolute" , "fnRender": function (oObj) { return oObj.aData[3]== 1 ? "Yes" : "No"; } },
	                { "sTitle": "Active" , "fnRender": function (oObj) { return oObj.aData[4]== 1 ? "Yes" : "No"; } },
	                { "sTitle": "Assignable" , "fnRender": function (oObj) { return oObj.aData[5]== 1 ? "Yes" : "No"; } },
	                { "bVisible": false },
	                { "bVisible": false },
	                { "bVisible": false },
	                { "bVisible": false },
	                { "bVisible": false },
	                { "bVisible": false },
	                { "sTitle": "Period quota" },
	                { "bVisible": false },
	                ],
	                "bJQueryUI": true,
	        		"sPaginationType": "full_numbers"
	        	});

	        	jQuery("#policiesTable").removeAttr("style");

	        	jQuery('#policiesTable tbody tr td').die();
	        	jQuery('#policiesTable tbody tr td').live('click', pol_rowClickHandler );
        	}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter("#policiesTableContainer");
        	displayError("#policiesTableContainer",errorThrown);
        }
    });

}

/*
 * Handle the click event on a row in the Policies table
 */
function pol_rowClickHandler()
{

	var nTr = this.parentNode;
	var aData = null;
	try{
		aData = pol_table.fnGetData( nTr );
	}catch(err){
		return;
	}
	var open=false;

	try{
		if(jQuery(nTr).next().children().first().hasClass("ui-state-highlight"))
			open=true;
	}catch(err){}

	var divId = "#policyDetails"+aData[0];

	if (open){
		/* This row is already open - close it */
		pol_table.fnClose( nTr );
		jQuery(nTr).css("color","");
		pol_removeValidationForm(divId);
	}else{
		/* Open this row */
		pol_openDetailsRow( nTr );
	}
}

/*
 * Open Policy details row. Bind events for Modify, Delete, Submit and Cancel
 * buttons
 */
function pol_openDetailsRow( nTr )
{

	pol_table.fnOpen( nTr, pol_formatDetailsRow( nTr ), 'ui-state-highlight' );
	var aData = pol_table.fnGetData( nTr );
	jQuery("#modifyPolicy"+aData[0]).button();
	jQuery("#deletePolicy"+aData[0]).button();

	var divId = "#policyDetails"+aData[0];
	
	jQuery("#modifyPolicy"+aData[0]).click(function(){
		jQuery(nTr).css("color","#c5dbec");
		jQuery(divId).empty();
		pol_openForm(divId, false, nTr, aData[0]);

	});
	jQuery("#deletePolicy"+aData[0]).click(function(){
		jQuery(divId).empty();
		pol_delete(divId, nTr, aData[0]);
	});

}


/*
 * Return html for a Policy details row
 */
function pol_formatDetailsRow ( nTr )
{

	var aData = pol_table.fnGetData( nTr );

	var id = aData[0];
    var name = aData[1];
    var policyType = aData[2];
    var absolute = aData[3];
    var active = aData[4];
    var assignable = aData[5];
	var description = aData[6];
    var startDate = aData[7];
    var daysInPeriod = aData[8];
    var numberOfPeriods = aData[9];
    var maximum = aData[10];
    var minimum = aData[11];
    var quotaInPeriod = aData[12];
    var daysToRelStart = aData[13];

	daysInPeriod = parseInt(daysInPeriod);
	daysToRelStart = parseInt(daysToRelStart);
	
    if(absolute=="Yes"){
    	startDate = startDate.substring(0,19);
	    startDate = Date.parse(startDate);
    }

	var sOut = '';
	sOut += '<div id="policyDetails'+id+'">';

	if(policyType.indexOf("NOEXPIRATION")!=-1){

		if(absolute=="Yes"){
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Quota in period:</strong>'+quotaInPeriod+'</p>';
			sOut += '</div>';
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Start date:</strong>'+startDate.format("mm/dd/yyyy HH:MM")+'</p>';
			sOut += '</div>';
		}else{
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Quota in period:</strong>'+quotaInPeriod+'</p>';
			sOut += '</div>';
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>No. days to start:</strong>'+daysToRelStart+'</p>';
			sOut += '</div>';
		}
	}if(policyType.indexOf("FIXED")!=-1){
		
		if(absolute=="Yes"){
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Quota in period:</strong>'+quotaInPeriod+'</p>';
			sOut += '</div>';
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Start date:</strong>'+startDate.format("mm/dd/yyyy HH:MM")+'</p>';
			
			var expDate = startDate;
			expDate.setDate(expDate.getDate()+daysInPeriod);
			
			sOut += '	<p><strong>Exp. date:</strong>'+expDate.format("mm/dd/yyyy HH:MM")+'</p>';
			sOut += '</div>';
		}else{
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Quota in period:</strong>'+quotaInPeriod+'</p>';
			sOut += '</div>';
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>No. days to start:</strong>'+daysToRelStart+'</p>';
			sOut += '	<p><strong>No. of days:</strong>'+daysInPeriod+'</p>';
			sOut += '</div>';
		}
	}else if(policyType.indexOf("GRADUAL")!=-1){
		if(absolute=="Yes"){
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Quota in period:</strong>'+quotaInPeriod+'</p>';
			sOut += '	<p><strong>Max quota:</strong>'+maximum+'</p>';
			sOut += '</div>';
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Start date:</strong>'+startDate.format("mm/dd/yyyy HH:MM")+'</p>';
			sOut += '	<p><strong>No. of periods:</strong>'+numberOfPeriods+'</p>';
			sOut += '	<p><strong>No. of days per period:</strong>'+daysInPeriod+'</p>';
			sOut += '</div>';
		}else{
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Quota in period:</strong>'+quotaInPeriod+'</p>';
			sOut += '	<p><strong>Max quota:</strong>'+maximum+'</p>';
			sOut += '</div>';
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>No. days to start:</strong>'+daysToRelStart+'</p>';
			sOut += '	<p><strong>No. of periods:</strong>'+numberOfPeriods+'</p>';
			sOut += '	<p><strong>No. of days per period:</strong>'+daysInPeriod+'</p>';
			sOut += '</div>';
		}
	}else if(policyType.indexOf("MINMAX")!=-1){
		if(absolute=="Yes"){
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Quota in period:</strong>'+quotaInPeriod+'</p>';
			sOut += '	<p><strong>Min quota:</strong>'+minimum+'</p>';
			sOut += '	<p><strong>Max quota:</strong>'+maximum+'</p>';
			sOut += '</div>';
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Start date:</strong>'+startDate.format("mm/dd/yyyy HH:MM")+'</p>';
			sOut += '	<p><strong>No. of periods:</strong>'+numberOfPeriods+'</p>';
			sOut += '	<p><strong>No. of days per period:</strong>'+daysInPeriod+'</p>';
			sOut += '</div>';
		}else{
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>Quota in period:</strong>'+quotaInPeriod+'</p>';
			sOut += '	<p><strong>Min quota:</strong>'+minimum+'</p>';
			sOut += '	<p><strong>Max quota:</strong>'+maximum+'</p>';
			sOut += '</div>';
			sOut += '<div class="columnDetails">';
			sOut += '	<p><strong>No. days to start:</strong>'+daysToRelStart+'</p>';
			sOut += '	<p><strong>No. of periods:</strong>'+numberOfPeriods+'</p>';
			sOut += '	<p><strong>No. of days per period:</strong>'+daysInPeriod+'</p>';
			sOut += '</div>';
		}
	}


// Button Column
	sOut += '<div class="buttonColumnDetails">';
	sOut += '	<button id="modifyPolicy'+id+'">Modify</button>';
	sOut += '	<button id="deletePolicy'+id+'">Delete</button>';
	sOut += '</div>';

// Description
	sOut += '<div class="descriptionDetails">';
	sOut += '	<p><strong>Description:</strong>'+description+'</p>';
	sOut += '</div>';

	sOut += '</div>';
	return sOut;
}

/*
 * Hide all form fields in the policy form with id
 */

function pol_hideButtons(containerId){
	jQuery(containerId+" .submit").hide();
	jQuery(containerId+" .cancel").hide();
}

function pol_showButtons(containerId){
	jQuery(containerId+" .submit").show();
	jQuery(containerId+" .cancel").show();
}

function pol_hideAllFormFields(containerId){
	jQuery(containerId+" form fieldset div div").each(function(index) {
	    jQuery(this).find('input[type="text"]').attr("disabled","disabled");
	    jQuery(this).hide();
	  });
}

function pol_showBasicFormFields(containerId){
	jQuery(containerId+" form fieldset div div").each(function(index) {
	    if(index==0 || index==1 || index==4 || index==5 || index==6 || index==15){
	    	jQuery(this).find('input[type="text"]').attr("disabled","");
	    	jQuery(this).show();
	    }
	  });
}

function pol_showNoExpPolicyFields(containerId){
	jQuery(containerId+" .absRelPolicySpan").show();
	jQuery(containerId+" .quotaInPeriodPolicySpan").show();
	jQuery(containerId+" .quotaInPeriodPolicySpan input").attr("disabled","");
	jQuery(containerId+" .activePolicySpan").show();
	pol_absoluteRelative(containerId);
}

function pol_showFixedPolicyFields(containerId){
	jQuery(containerId+" .absRelPolicySpan").show();
	jQuery(containerId+" .quotaInPeriodPolicySpan").show();
	jQuery(containerId+" .quotaInPeriodPolicySpan input").attr("disabled","");
	jQuery(containerId+" .activePolicySpan").show();
	pol_absoluteRelative(containerId);
}

function pol_showGradualPolicyFields(containerId){
	jQuery(containerId+" .absRelPolicySpan").show();
	jQuery(containerId+" .noPeriodsPolicySpan").show();
	jQuery(containerId+" .noPeriodsPolicySpan input").attr("disabled","");
	jQuery(containerId+" .noDaysPeriodPolicySpan").show();
	jQuery(containerId+" .noDaysPeriodPolicySpan input").attr("disabled","");
	//jQuery(containerId+" .maxQuotaPolicySpan").show();
	//jQuery(containerId+" .maxQuotaPolicySpan input").attr("disabled","");
	jQuery(containerId+" .quotaInPeriodPolicySpan").show();
	jQuery(containerId+" .quotaInPeriodPolicySpan input").attr("disabled","");
	pol_absoluteRelative(containerId);
}

function pol_showMinMaxPolicyFields(containerId){
	jQuery(containerId+" .absRelPolicySpan").show();
	jQuery(containerId+" .noPeriodsPolicySpan").show();
	jQuery(containerId+" .noPeriodsPolicySpan input").attr("disabled","");
	jQuery(containerId+" .noDaysPeriodPolicySpan").show();
	jQuery(containerId+" .noDaysPeriodPolicySpan input").attr("disabled","");
	jQuery(containerId+" .maxQuotaPolicySpan").show();
	jQuery(containerId+" .maxQuotaPolicySpan input").attr("disabled","");
	jQuery(containerId+" .minQuotaPolicySpan").show();
	jQuery(containerId+" .minQuotaPolicySpan input").attr("disabled","");
	jQuery(containerId+" .quotaInPeriodPolicySpan").show();
	jQuery(containerId+" .quotaInPeriodPolicySpan input").attr("disabled","");
	pol_absoluteRelative(containerId);
}

function pol_absoluteRelative(containerId){
	var selType = jQuery(containerId+" .typePolicy").val();
	var selAbs = jQuery(containerId+" input:radio[name=absRelPolicy]:checked").val();

	jQuery(containerId+" .activePolicySpan").show();
	jQuery(containerId+" .assignablePolicySpan").show();

	if(selType == "FIXED"){
		if(selAbs=="absPolicy"){
			jQuery(containerId+" .noDaysPolicySpan").hide();
			jQuery(containerId+" .noDaysPolicySpan input").attr("disabled","disabled");
			jQuery(containerId+" .expDatePolicySpan").show();
			jQuery(containerId+" .expDatePolicySpan input").attr("disabled","");
	        jQuery( containerId+" .expDatePolicy" ).datepicker();
		}else if(selAbs=="relPolicy"){
			jQuery(containerId+" .expDatePolicySpan").hide();
			jQuery(containerId+" .expDatePolicySpan input").attr("disabled","disabled");
			jQuery(containerId+" .noDaysPolicySpan").show();
			jQuery(containerId+" .noDaysPolicySpan input").attr("disabled","");
		}
	}

	if(selAbs=="absPolicy"){
		jQuery(containerId+" .startDatePolicySpan").show();
		jQuery(containerId+" .startDatePolicySpan input").attr("disabled","");
		jQuery(containerId+" .startTimePolicySpan").show();
		jQuery(containerId+" .startTimePolicySpan input").attr("disabled","");
		jQuery(containerId+" .noDaysToStartPolicySpan").hide();
		jQuery(containerId+" .noDaysToStartPolicySpan input").attr("disabled","disabled");
        jQuery( containerId+" .startDatePolicy" ).datepicker();
        jQuery( containerId+" .startTimePolicy" ).timepicker({  timeSeparator: ':' })



	}else if(selAbs=="relPolicy"){
		jQuery(containerId+" .startDatePolicySpan").hide();
		jQuery(containerId+" .startDatePolicySpan input").attr("disabled","disabled");
		jQuery(containerId+" .startTimePolicySpan").hide();
		jQuery(containerId+" .startTimePolicySpan input").attr("disabled","disabled");
		jQuery(containerId+" .noDaysToStartPolicySpan").show();
		jQuery(containerId+" .noDaysToStartPolicySpan input").attr("disabled","");
	}



}


function pol_isValidForm(containerId){
	for(var i=0; i < pol_open_validation_forms.length ; i++){
		if(pol_open_validation_forms[i].container_id == containerId){
			return LiveValidation.massValidate(pol_open_validation_forms[i].form_fields);
		}
	}
	//alert("No forms in the pol_open_validation_forms array");
	return false;
}
/*
 * Open Add Policy form on top of the Policies Table
 */
function pol_openForm(containerId, add, nTr, policyId)
{
	jQuery(containerId).empty();
	jQuery(containerId).hide();

    jQuery(containerId).load("/modules/module_quotasystem/policyForm.html", function(){
        pol_hideAllFormFields(containerId);
        pol_hideButtons(containerId);

        jQuery(containerId+" .submit").button();
        jQuery(containerId+" .cancel").button();

        // jQuery(containerId+" .relPolicy").attr("checked", "checked");
        // jQuery(containerId+" .activePolicy").attr("checked", "checked");
        // jQuery(containerId+" .assignablePolicy").attr("checked", "checked");

        jQuery(containerId+" .absPolicy").click(function(){
        	pol_absoluteRelative(containerId);
        });
        jQuery(containerId+" .relPolicy").click(function(){
        	pol_absoluteRelative(containerId);
        });

        jQuery(containerId+" .typePolicy").change(function(){
        	var sel = jQuery(this).val();
        	pol_hideAllFormFields(containerId);
        	pol_showBasicFormFields(containerId);
        	if(sel == "NOEXPIRATION")
        		pol_showNoExpPolicyFields(containerId);
        	else if(sel == "FIXED")
        		pol_showFixedPolicyFields(containerId);
        	else if(sel == "GRADUAL")
        		pol_showGradualPolicyFields(containerId);
        	else if(sel == "MINMAX")
        		pol_showMinMaxPolicyFields(containerId);

        });
        
        var dateformatter = "yyyy-mm-dd'T'HH:MM:ss";

        if(add)
        {
        	pol_showButtons(containerId);
        	pol_showBasicFormFields(containerId);
            pol_showNoExpPolicyFields(containerId);
            pol_absoluteRelative(containerId);
            
    		var today = new Date();
    		jQuery(containerId+" .startDatePolicy").val(today.format("m/d/yyyy"));
    		jQuery(containerId+" .startTimePolicy").val(today.format("HH:MM"));

            jQuery(containerId).addClass("ui-state-highlight");
	        jQuery(containerId+" .submit").click(function(){
				
	        	var time = jQuery(containerId+" .startTimePolicy").val();
		    	var date = jQuery(containerId+" .startDatePolicy").val();
				
	        	var startDate = new Date(date+" "+time);
	        	if(pol_isValidForm(containerId)){
	            	var policyType = jQuery(containerId+" .typePolicy").val();
	            	var absolute = jQuery(containerId+" .absPolicy").is(':checked');
            		var active = jQuery(containerId+" .activePolicy").is(':checked');
            		var assignable = jQuery(containerId+" .assignablePolicy").is(':checked');
					
            		jQuery(containerId).slideUp(400, function(){
            			if(policyType=="NOEXPIRATION"){
    	            		pol_addNoExpPolicy(containerId,
    	            				jQuery(containerId+" .namePolicy").val(),
    			            		jQuery(containerId+" .typePolicy").val(),
    			            		absolute,
    			            		active,
    			           			assignable,
    			           			startDate.format(dateformatter),
    			           			jQuery(containerId+" .noDaysToStartPolicy").val(),
    			               		jQuery(containerId+" .noDaysPolicy").val(),
    			               		jQuery(containerId+" .descriptionPolicy").val(),
    			               		jQuery(containerId+" .quotaInPeriodPolicy").val());
    	            	}
            			else if(policyType=="FIXED"){
            				
            				if(absolute){
            		        	var date = jQuery(containerId+" .expDatePolicy").val();
            		        	var expDate = new Date(date+" "+time);
            		        	var noDays = startDate.dayDiff(expDate);
            				}
            				
    	            		pol_addFixedPolicy(containerId,
    	            				jQuery(containerId+" .namePolicy").val(),
    			            		jQuery(containerId+" .typePolicy").val(),
    			            		absolute,
    			            		active,
    			           			assignable,
    			           			startDate.format(dateformatter),
    			           			jQuery(containerId+" .noDaysToStartPolicy").val(),
    			           			expDate.format(dateformatter),
    			               		noDays,
    			               		jQuery(containerId+" .descriptionPolicy").val(),
    			               		jQuery(containerId+" .quotaInPeriodPolicy").val());
    	            	}
    	            	else if(policyType == "GRADUAL"){
    	            		pol_addGradualPolicy(containerId,
    	            				jQuery(containerId+" .namePolicy").val(),
    	            				jQuery(containerId+" .typePolicy").val(),
    	            				absolute,
    	            				jQuery(containerId+" .noPeriodsPolicy").val(),
    		                		active,
    		                		assignable,
    		                		startDate.format(dateformatter),
    		               			jQuery(containerId+" .noDaysToStartPolicy").val(),
    		               			jQuery(containerId+" .noDaysPeriodPolicy").val(),
    		               			jQuery(containerId+" .maxQuotaPolicy").val(),
    		               			jQuery(containerId+" .descriptionPolicy").val(),
    		               			jQuery(containerId+" .quotaInPeriodPolicy").val());
    	            	}
    	            	else if(policyType == "MINMAX"){
    	            		pol_addMinMaxPolicy(containerId,
    	            				jQuery(containerId+" .namePolicy").val(),
    	            				jQuery(containerId+" .typePolicy").val(),
    		            			absolute,
    		            			jQuery(containerId+" .noPeriodsPolicy").val(),
    		            			active,
    		            			assignable,
    		            			startDate.format(dateformatter),
    		            			jQuery(containerId+" .noDaysToStartPolicy").val(),
    		            			jQuery(containerId+" .noDaysPeriodPolicy").val(),
    		            			jQuery(containerId+" .minQuotaPolicy").val(),
    		            			jQuery(containerId+" .maxQuotaPolicy").val(),
    		            			jQuery(containerId+" .descriptionPolicy").val(),
    		            			jQuery(containerId+" .quotaInPeriodPolicy").val());
    	            	}
    	            	jQuery(containerId).empty();
    	            	jQuery("#add-policy").button("enable");
                		pol_removeValidationForm(containerId);
            		});
	        	}
	        	else{
	        		alert("The Create Policy form contained some errors.\nPlease confirm all required fields have been correctly field before saving.");
	        	}
	        });

	        jQuery(containerId+" .cancel").click(function(){
	        	jQuery(containerId).slideUp(400,function(){
	        		jQuery(containerId).empty();
	        		jQuery("#add-policy").button("enable");
	        	});
	        	pol_removeValidationForm(containerId);
	        });

	        jQuery(containerId).slideDown(400);
        }else{

        	
    		pol_fillOutForm(containerId, nTr, policyId);


	        jQuery(containerId+" .submit").click(function(){


	        	if(pol_isValidForm(containerId)){

	            	var policyType = jQuery(containerId+" .typePolicy").val();

	            	var absolute = jQuery(containerId+" .absPolicy").is(':checked');
            		var active = jQuery(containerId+" .activePolicy").is(':checked');
            		var assignable = jQuery(containerId+" .assignablePolicy").is(':checked');
	            	jQuery(containerId).slideUp(400,function(){

	            		var startDate = null;
	            		
        				if(absolute){
            	        	var time = jQuery(containerId+" .startTimePolicy").val();        	
            	        	var date = jQuery(containerId+" .startDatePolicy").val();
            	        	startDate = new Date(date+" "+time); 
            	        	startDateFormatted = startDate.format(dateformatter);
        				}
	    	        	
	            		if(policyType=="NOEXPIRATION"){
		            		pol_modifyNoExpPolicy(containerId,nTr,policyId,
		            				jQuery(containerId+" .namePolicy").val(),
			            			jQuery(containerId+" .typePolicy").val(),
			            			absolute,
			            			active,
			            			assignable,
			            			startDateFormatted,
			                		jQuery(containerId+" .noDaysToStartPolicy").val(),
			                		jQuery(containerId+" .noDaysPolicy").val(),
			                		jQuery(containerId+" .descriptionPolicy").val(),
			                		jQuery(containerId+" .quotaInPeriodPolicy").val());

		            	}else if(policyType=="FIXED"){
		            		var expDate = null;
            				if(absolute){
            		        	var date = jQuery(containerId+" .expDatePolicy").val();
            		        	var expDate  = new Date(date+" "+time);
            		        	var noDays = startDate.dayDiff(expDate);
            		        	expDateFormatted = expDate.format(dateformatter);
            				}
		            		
		            		pol_modifyFixedPolicy(containerId,nTr,policyId,
		            				jQuery(containerId+" .namePolicy").val(),
			            			jQuery(containerId+" .typePolicy").val(),
			            			absolute,
			            			active,
			            			assignable,
			            			startDateFormatted,
			            			jQuery(containerId+" .noDaysToStartPolicy").val(),
			            			expDateFormatted,
			                		noDays,
			                		jQuery(containerId+" .descriptionPolicy").val(),
			                		jQuery(containerId+" .quotaInPeriodPolicy").val());

		            	}else if(policyType == "GRADUAL"){
			            	pol_modifyGradualPolicy(containerId,nTr,policyId,
			            			jQuery(containerId+" .namePolicy").val(),
			            			jQuery(containerId+" .typePolicy").val(),
			                		absolute,
			                		jQuery(containerId+" .noPeriodsPolicy").val(),
			                		active,
			                		assignable,
			                		startDateFormatted,
			                		jQuery(containerId+" .noDaysToStartPolicy").val(),
			                		jQuery(containerId+" .noDaysPeriodPolicy").val(),
			                		jQuery(containerId+" .maxQuotaPolicy").val(),
			                		jQuery(containerId+" .descriptionPolicy").val(),
			                		jQuery(containerId+" .quotaInPeriodPolicy").val());

		            	}else if(policyType == "MINMAX"){
			            	pol_modifyMinMaxPolicy(containerId,nTr, policyId,
			            			jQuery(containerId+" .namePolicy").val(),
			            			jQuery(containerId+" .typePolicy").val(),
			                		absolute,
			                		jQuery(containerId+" .noPeriodsPolicy").val(),
			                		active,
			                		assignable,
			                		startDateFormatted,
			                		jQuery(containerId+" .noDaysToStartPolicy").val(),
			                		jQuery(containerId+" .noDaysPeriodPolicy").val(),
			                		jQuery(containerId+" .minQuotaPolicy").val(),
			                		jQuery(containerId+" .maxQuotaPolicy").val(),
			                		jQuery(containerId+" .descriptionPolicy").val(),
			                		jQuery(containerId+" .quotaInPeriodPolicy").val());
		            	}

	            		jQuery(containerId).empty();
		                pol_removeValidationForm(containerId);
	            	});
	            }
	        	else{
	        		//alert("The Modify Policy form contained some errors.\nPlease confirm all required fields have been correctly field before saving.");
	        	}
	        });

	        jQuery(containerId+" .cancel").click(function(){
	        	jQuery(containerId).slideUp(400,function(){
            		jQuery(containerId).empty();
            		jQuery(nTr).css("color","");
	                pol_table.fnClose( nTr );
	        	});
	        	pol_removeValidationForm(containerId);
	        });

        }
        pol_addFormValidation(containerId);
    });
}

function pol_addFormValidation(containerId){

	var formFields = new Array();

	var namePolicyId = containerId.substring(1)+"_namePolicy";
	jQuery(containerId+" .namePolicy").attr("id",namePolicyId);
	var policyNameValidator = new LiveValidation( namePolicyId , { wait: 500});
	policyNameValidator.add( Validate.Presence );
	policyNameValidator.add( Validate.Length, { maximum: 45 });
	formFields.push(policyNameValidator);

	var noPeriodsPolicyId = containerId.substring(1)+"_noPeriodsPolicy";
	jQuery(containerId+" .noPeriodsPolicy").attr("id",noPeriodsPolicyId);
	var policyNoPeriodsValidator = new LiveValidation( noPeriodsPolicyId , {wait: 500});
	policyNoPeriodsValidator.add( Validate.Presence );
	policyNoPeriodsValidator.add( Validate.Numericality, { onlyInteger: true } );
	formFields.push(policyNoPeriodsValidator);

	var startDatePolicyId = containerId.substring(1)+"_startDatePolicy";
	jQuery(containerId+" .startDatePolicy").attr("id",startDatePolicyId);
	var policyStartDateValidator = new LiveValidation( startDatePolicyId , {wait: 500});
	policyStartDateValidator.add( Validate.Presence );
	policyStartDateValidator.add( Validate.Date );
	formFields.push(policyStartDateValidator);
	
	var startTimePolicyId = containerId.substring(1)+"_startTimePolicy";
	jQuery(containerId+" .startTimePolicy").attr("id",startTimePolicyId);
	var policyStartTimeValidator = new LiveValidation( startTimePolicyId , {wait: 500});
	policyStartTimeValidator.add( Validate.Presence );
	policyStartTimeValidator.add( Validate.Date );
	formFields.push(policyStartTimeValidator);

	var expDatePolicyId = containerId.substring(1)+"_expDatePolicy";
	jQuery(containerId+" .expDatePolicy").attr("id",expDatePolicyId);
	var policyExpDateValidator = new LiveValidation( expDatePolicyId , {wait: 500});
	policyExpDateValidator.add( Validate.Presence );
	policyExpDateValidator.add( Validate.Date, { after: jQuery(containerId+" .startDatePolicy").get() } );
	formFields.push(policyExpDateValidator);

	var noDaysToStartPolicyId = containerId.substring(1)+"_noDaysToStartPolicy";
	jQuery(containerId+" .noDaysToStartPolicy").attr("id",noDaysToStartPolicyId);
	var noDaysToStartPolicyValidator = new LiveValidation( noDaysToStartPolicyId , {wait: 500});
	noDaysToStartPolicyValidator.add( Validate.Presence );
	noDaysToStartPolicyValidator.add( Validate.Numericality, { onlyInteger: true } );
	formFields.push(noDaysToStartPolicyValidator);

	var noDaysPolicyId = containerId.substring(1)+"_noDaysPolicy";
	jQuery(containerId+" .noDaysPolicy").attr("id",noDaysPolicyId);
	var noDaysPolicyValidator = new LiveValidation( noDaysPolicyId , {wait: 500});
	noDaysPolicyValidator.add( Validate.Presence );
	noDaysPolicyValidator.add( Validate.Numericality, { onlyInteger: true } );
	formFields.push(noDaysPolicyValidator);

	var noDaysPeriodPolicyId = containerId.substring(1)+"_noDaysPeriodPolicy";
	jQuery(containerId+" .noDaysPeriodPolicy").attr("id",noDaysPeriodPolicyId);
	var noDaysPeriodPolicyValidator = new LiveValidation( noDaysPeriodPolicyId , {wait: 500});
	noDaysPeriodPolicyValidator.add( Validate.Presence );
	noDaysPeriodPolicyValidator.add( Validate.Numericality, { onlyInteger: true } );
	formFields.push(noDaysPeriodPolicyValidator);

	var minQuotaPolicyId = containerId.substring(1)+"_minQuotaPolicy";
	jQuery(containerId+" .minQuotaPolicy").attr("id",minQuotaPolicyId);
	var policyMinQuotaValidator = new LiveValidation( minQuotaPolicyId , {wait: 500});
	policyMinQuotaValidator.add( Validate.Presence );
	policyMinQuotaValidator.add( Validate.Numericality, { onlyInteger: true } );
	formFields.push(policyMinQuotaValidator);

	var maxQuotaPolicyId = containerId.substring(1)+"_maxQuotaPolicy";
	jQuery(containerId+" .maxQuotaPolicy").attr("id",maxQuotaPolicyId);
	var policyMaxQuotaValidator = new LiveValidation( maxQuotaPolicyId , {wait: 500});
	policyMaxQuotaValidator.add( Validate.Presence );
	policyMaxQuotaValidator.add( Validate.Numericality, { onlyInteger: true } );
	formFields.push(policyMaxQuotaValidator);


	var quotaInPeriodPolicyId = containerId.substring(1)+"_quotaInPeriodPolicy";
	jQuery(containerId+" .quotaInPeriodPolicy").attr("id",quotaInPeriodPolicyId);
	var policyQuotaInPeriodValidator = new LiveValidation( quotaInPeriodPolicyId , {wait: 500});
	policyQuotaInPeriodValidator.add( Validate.Presence );
	policyQuotaInPeriodValidator.add( Validate.Numericality, { onlyInteger: true } );
	formFields.push(policyQuotaInPeriodValidator);

	var liveValidationForm = { container_id: containerId, form_fields: formFields };
	pol_open_validation_forms.push(liveValidationForm);
}

function pol_removeValidationForm(containerId){

	var tempArray = new Array();
	for(var i=0; i < pol_open_validation_forms.length ; i++){
		if(pol_open_validation_forms[i].container_id != containerId){
			tempArray.push(pol_open_validation_forms[i]);
		}
	}

	pol_open_validation_forms = tempArray;
}

function pol_fillOutForm(containerId, nTr, id){
	createLoadingDivAfter(containerId,"Loading Policy data");

	  jQuery.ajax({
	        type: 'POST',
	        url: '/modules/module_quotasystem/server/policyManager.php',
	        dataType: 'json',
	        data: {
	            action: 'getPolicy',
	            id:id
	        },
	        success: function(data){
	        	removeLoadingDivAfter(containerId);
				//console.log(data);
	    		pol_showButtons(containerId);

	        	var policy = data[0];
	        	var absolute = policy.absolute;
				//console.log(data.policy[0]['id']);
        		if(absolute==1){
        			jQuery(containerId+" .absPolicy").attr("checked",absolute);
        			var startDate = Date.parse(policy.start_date.substring(0,19));
        			var date = startDate.format("mm/dd/yyyy");

        			var time = startDate.format("HH:MM");
            		jQuery(containerId+" .startDatePolicy").val(date);
            		jQuery(containerId+" .startTimePolicy").val(time);
            		
        		}else{
        			jQuery(containerId+" .relPolicy").attr("checked",true);
            		jQuery(containerId+" .noDaysToStartPolicy").val(policy.days_to_rel_start);
        		}

        		if(policy.policy_type=="NOEXPIRATION"){

    				jQuery(containerId+" .namePolicy").val(policy.name);
        			jQuery(containerId+" .typePolicy").val(policy.policyType);
        			jQuery(containerId+" .assignablePolicy").attr("checked", policy.assignable);
        			jQuery(containerId+" .activePolicy").attr("checked", policy.active);
            		jQuery(containerId+" .descriptionPolicy").val(policy.description),
            		jQuery(containerId+" .quotaInPeriodPolicy").val(policy.quota_in_period);
            		pol_showBasicFormFields(containerId);
                	pol_showFixedPolicyFields(containerId);


            	}else if(policy.policy_type=="FIXED"){
            		
            		if(absolute==1){
            			var expDate = start_date;
            			expDate.setDate(expDate.getDate()+policy.days_in_period);
            		}

            		jQuery(containerId+" .expDatePolicy").val(expDate.format("mm/dd/yyyy"));
    				jQuery(containerId+" .namePolicy").val(policy.name);
        			jQuery(containerId+" .typePolicy").val(policy.policy_type);
        			jQuery(containerId+" .assignablePolicy").attr("checked", policy.assignable);
        			jQuery(containerId+" .activePolicy").attr("checked", policy.active);
            		jQuery(containerId+" .noDaysPolicy").val(policy.days_in_period);
            		jQuery(containerId+" .descriptionPolicy").val(policy.description),
            		jQuery(containerId+" .quotaInPeriodPolicy").val(policy.quota_in_period);

            		pol_showBasicFormFields(containerId);
                	pol_showFixedPolicyFields(containerId);

            	}else if(policy.policy_type == "GRADUAL"){

    				jQuery(containerId+" .namePolicy").val(policy.name);
        			jQuery(containerId+" .typePolicy").val(policy.policy_type);
        			jQuery(containerId+" .assignablePolicy").attr("checked", policy.assignable);
        			jQuery(containerId+" .activePolicy").attr("checked", policy.active);
            		jQuery(containerId+" .noDaysPeriodPolicy").val(policy.days_in_period);
            		jQuery(containerId+" .descriptionPolicy").val(policy.description);
            		jQuery(containerId+" .quotaInPeriodPolicy").val(policy.quota_in_period);
            		jQuery(containerId+" .maxQuotaPolicy").val(policy.maximum);
            		jQuery(containerId+" .noPeriodsPolicy").val(policy.number_of_periods);
            		pol_showBasicFormFields(containerId);
            		pol_showGradualPolicyFields(containerId);

            	}else if(policy.policy_type == "MINMAX"){

    				jQuery(containerId+" .namePolicy").val(policy.name);
        			jQuery(containerId+" .typePolicy").val(policy.policy_type);
        			jQuery(containerId+" .assignablePolicy").attr("checked", policy.assignable);
        			jQuery(containerId+" .activePolicy").attr("checked", policy.active);
            		jQuery(containerId+" .noDaysPeriodPolicy").val(policy.days_in_period);
            		jQuery(containerId+" .descriptionPolicy").val(policy.description);
            		jQuery(containerId+" .quotaInPeriodPolicy").val(policy.quota_in_period);
            		jQuery(containerId+" .maxQuotaPolicy").val(policy.maximum);
            		jQuery(containerId+" .minQuotaPolicy").val(policy.minimum);
            		jQuery(containerId+" .noPeriodsPolicy").val(policy.number_of_periods);
            		pol_showBasicFormFields(containerId);
            		pol_showMinMaxPolicyFields(containerId);
            	}

            	jQuery(containerId).slideDown(400);

	        },
	        error: function(XMLHttpRequest, textStatus, errorThrown){
	        	removeLoadingDivAfter(containerId);
	        	displayError(containerId,errorThrown, function(){
	        		jQuery(nTr).css("color","");
	            	pol_table.fnClose( nTr );
	            });
	        }
	    });
}

function pol_addNoExpPolicy(containerId, name, type, absolute, active, assignable, startDate, noDaysToStart, noDays, description, quotaInPeriod){

	createLoadingDivAfter(containerId,"Creating No Expiration Policy");
	jQuery.ajax({
		type: 'POST',
		url: '/modules/module_quotasystem/server/policyManager.php',
		dataType: 'json',
		data: {
			action: 'addPolicy',
			name:name,
			description:description,
			typePolicy:type,
			absolute:absolute,
			active:active,
			assignable:assignable,
			quotaInPeriod:quotaInPeriod,
			noDays:noDays,
			startDate:startDate,
			daysToRelStart:noDaysToStart
		},
		success: function(data){
			removeLoadingDivAfter(containerId);
			if(data.success){
				if(!absolute){
					startDate = null;
				}
				displayMessage(containerId,"Policy ["+name+"] successfully added");
				console.log(data);
				console.log(absolute);
				console.log(active);
				console.log(assignable);
				pol_table.fnAddData( [
				                      data.id,
					                  name,
					                  type,
					                  absolute ? "1" : "0",
					                  active ? "1" : "0",
					                  assignable ? "1" : "0",
					                  description,
					                  startDate,
					                  noDays,
					                  1,
					                  quotaInPeriod,
					                  quotaInPeriod,
					                  quotaInPeriod,
					                  noDaysToStart
					                  ] );

			}else{
				displayError(containerId,data.message);
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			removeLoadingDivAfter(containerId);
			displayError(containerId,errorThrown);
		}
	});
}

function pol_addFixedPolicy(containerId, name, type, absolute, active, assignable, startDate, noDaysToStart, expDate, noDays, description, quotaInPeriod){

	createLoadingDivAfter(containerId,"Creating Fixed Policy");
	
	jQuery.ajax({
		type: 'POST',
		url: '/modules/module_quotasystem/server/policyManager.php',
		dataType: 'json',
		data: {
			action: 'addPolicy',
			name:name,
			description:description,
			typePolicy:type,
			absolute:absolute,
			active:active,
			assignable:assignable,
			quotaInPeriod:quotaInPeriod,
			noDays:noDays,
			startDate:startDate,
			daysToRelStart:noDaysToStart
		},
		success: function(data){
			removeLoadingDivAfter(containerId);
			if(data.success){
				
				displayMessage(containerId,"Policy ["+name+"] successfully added");

				pol_table.fnAddData( [
				                      data.id,
				                      name,
				                      type,
					                  absolute ? "1" : "0",
					                  active ? "1" : "0",
					                  assignable ? "1" : "0",
				                      description,
				                      startDate,
				                      noDays,
				                      1,
				                      quotaInPeriod,
				                      quotaInPeriod,
				                      quotaInPeriod,
				                      noDaysToStart
				                      ] );


			}else{
				displayError(containerId,data.message);
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			removeLoadingDivAfter(containerId);
			displayError(containerId,errorThrown);
		}
	});
}

function pol_addGradualPolicy(containerId, name, type, absolute, noPeriods, active, assignable, startDate, noDaysToStart, noDaysInPeriod, max, description, quotaInPeriod){

    createLoadingDivAfter(containerId,"Creating Gradual Policy");

    jQuery.ajax({
    	type: 'POST',
    	url: '/modules/module_quotasystem/server/policyManager.php',
    	dataType: 'json',
    	data: {
    		action: 'addPolicy',
    		name:name,
    		description:description,
    		typePolicy:type,
    		absolute:absolute,
    		active:active,
    		assignable:assignable,
    		maxQuota:max,
    		quotaInPeriod:quotaInPeriod,
    		noPeriods:noPeriods,
    		noDaysInPeriod:noDaysInPeriod,
    		startDate:startDate,
			daysToRelStart:noDaysToStart
    	},
    	success: function(data){
    		removeLoadingDivAfter(containerId);
    		if(data.success){
    			displayMessage(containerId,"Policy ["+name+"] successfully added");

    			pol_table.fnAddData( [
    			                      data.id,
    			                      name,
    			                      type,
    			                      absolute ? "1" : "0",
    			                      active ? "1" : "0",
    			                      assignable ? "1" : "0",
    			                      description,
    			                      startDate,
    			                      noDaysInPeriod,
    			                      noPeriods,
    			                      max,
    			                      max,
    			                      quotaInPeriod,
    			                      noDaysToStart
    			                      ] );


    		}else{
    			displayError(containerId,data.message);
    		}
    	},
    	error: function(XMLHttpRequest, textStatus, errorThrown){
    		removeLoadingDivAfter(containerId);
    		displayError(containerId,errorThrown);
    	}
    });
}

function pol_addMinMaxPolicy(containerId, name, type, absolute, noPeriods, active, assignable, startDate, noDaysToStart, noDaysInPeriod, min, max, description, quotaInPeriod){

	createLoadingDivAfter(containerId, "Creating Min Max Policy");

	jQuery.ajax({
		type: 'POST',
		url: '/modules/module_quotasystem/server/policyManager.php',
		dataType: 'json',
		data: {
			action: 'addPolicy',
			name:name,
			description:description,
			typePolicy:type,
			absolute:absolute,
			active:active,
			assignable:assignable,
			maxQuota:max,
			minQuota:min,
			quotaInPeriod:quotaInPeriod,
			noPeriods:noPeriods,
			noDaysInPeriod:noDaysInPeriod,
			startDate:startDate,
			daysToRelStart:noDaysToStart
		},
		success: function(data){
			removeLoadingDivAfter(containerId);
			if(data.success){
				displayMessage(containerId,"Policy ["+name+"] successfully added");

				pol_table.fnAddData( [
				                      data.id,
				                      name,
				                      type,
					                  absolute ? "1" : "0",
					                  active ? "1" : "0",
					                  assignable ? "1" : "0",
				                      description,
				                      startDate,
				                      noDaysInPeriod,
				                      noPeriods,
				                      max,
				                      min,
				                      quotaInPeriod,
				                      noDaysToStart
				                      ] );

			}else{
				displayError(containerId,data.message);
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			removeLoadingDivAfter(containerId);
			displayError(containerId,errorThrown);
		}
	});
}

function pol_modifyNoExpPolicy(containerId, nTr, id, name, type, absolute, active, assignable, startDate, noDaysToStart,noDays, description, quotaInPeriod){

	createLoadingDivAfter(containerId, "Modifying No Expiration Policy");

	jQuery.ajax({
		type: 'POST',
		url: '/modules/module_quotasystem/server/policyManager.php',
		dataType: 'json',
		data: {
			action: 'modifyPolicy',
			id:id,
			name:name,
			description:description,
			typePolicy:type,
			absolute:absolute,
			active:active,
			assignable:assignable,
			quotaInPeriod:quotaInPeriod,
			noDays:noDays,
			startDate:startDate,
			daysToRelStart:noDaysToStart
		},
		success: function(data){
			removeLoadingDivAfter(containerId);
			if(data.success){
				if(absolute){
					// pol_formatDetailsRow compares absolute as
					// a string, not a boolean
					absolute = "true";
				}else{
					startDate = null;
				}
				
                displayMessage(containerId,"Policy ["+name+"] successfully modified", function(){
    				jQuery(nTr).css("color","");
                    pol_table.fnClose( nTr );
                });

				pol_table.fnUpdate( [
				                     id,
				                     name,
				                     type,
				                     absolute ? "1" : "0",
				                     active ? "1" : "0",
				                     assignable ? "1" : "0",
				                     description,
				                     startDate,
				                     noDays,
				                     1,
				                     quotaInPeriod,
				                     quotaInPeriod,
				                     quotaInPeriod,
				                     noDaysToStart
				                     ], nTr, false, false );



			}else{
	        	displayError(containerId,data.message, function(){
	        		jQuery(nTr).css("color","");
	            	pol_table.fnClose( nTr );
	            });
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown, function(){
        		jQuery(nTr).css("color","");
            	pol_table.fnClose( nTr );
            });

		}
	});
}

function pol_modifyFixedPolicy(containerId, nTr, id, name, type, absolute, active, assignable, startDate, noDaysToStart, expDate, noDays, description, quotaInPeriod){

	createLoadingDivAfter(containerId, "Modifying Fixed Policy");

	jQuery.ajax({
		type: 'POST',
		url: '/modules/module_quotasystem/server/policyManager.php',
		dataType: 'json',
		data: {
			action: 'modifyPolicy',
			id:id,
			name:name,
			description:description,
			typePolicy:type,
			absolute:absolute,
			active:active,
			assignable:assignable,
			quotaInPeriod:quotaInPeriod,
			noDays:noDays,
			expDate:expDate,
			startDate:startDate,
			daysToRelStart:noDaysToStart
		},
		success: function(data){
			removeLoadingDivAfter(containerId);
			if(data.success){
				if(absolute){
					// pol_formatDetailsRow compares absolute as
					// a string, not a boolean
					absolute = "true";
				}else{
					startDate = null;
				}

                displayMessage(containerId,"Policy ["+name+"] successfully modified", function(){
    				jQuery(nTr).css("color","");
                    pol_table.fnClose( nTr );
                });

				pol_table.fnUpdate( [
				                     id,
				                     name,
				                     type,
				                     absolute ? "1" : "0",
				                     active ? "1" : "0",
				                     assignable ? "1" : "0",
				                     description,
				                     startDate,
				                     noDays,
				                     1,
				                     quotaInPeriod,
				                     quotaInPeriod,
				                     quotaInPeriod,
				                     noDaysToStart
				                     ], nTr, false,  false );



			}else{
	        	displayError(containerId,data.message, function(){
	        		jQuery(nTr).css("color","");
	            	pol_table.fnClose( nTr );
	            });
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown, function(){
        		jQuery(nTr).css("color","");
            	pol_table.fnClose( nTr );
            });

		}
	});
}

function pol_modifyGradualPolicy(containerId, nTr,id, name, type, absolute, noPeriods, active, assignable, startDate, noDaysToStart, noDaysInPeriod, max, description, quotaInPeriod){

	createLoadingDivAfter(containerId,"Modifying Gradual Policy");

	jQuery.ajax({
		type: 'POST',
		url: '/modules/module_quotasystem/server/policyManager.php',
		dataType: 'json',
		data: {
			action: 'modifyPolicy',
			id:id,
			name:name,
			description:description,
			typePolicy:type,
			absolute:absolute,
			active:active,
			assignable:assignable,
			maxQuota:max,
			quotaInPeriod:quotaInPeriod,
			noPeriods:noPeriods,
			noDaysInPeriod:noDaysInPeriod,
			startDate:startDate,
			daysToRelStart:noDaysToStart
		},
		success: function(data){
			removeLoadingDivAfter(containerId);
			if(data.success){
				if(absolute){
					// pol_formatDetailsRow compares absolute as a
					// string, not a boolean
					absolute = "true";
				}else{
					startDate = null;
				}

                displayMessage(containerId,"Policy ["+name+"] successfully modified", function(){
    				jQuery(nTr).css("color","");
                    pol_table.fnClose( nTr );
                });
				pol_table.fnUpdate( [
				                     id,
				                     name,
				                     type,
				                     absolute ? "1" : "0",
				                     active ? "1" : "0",
				                     assignable ? "1" : "0",
				                     description,
				                     startDate,
				                     noDaysInPeriod,
				                     noPeriods,
				                     max,
				                     max,
				                     quotaInPeriod,
				                     noDaysToStart
				                     ] , nTr, false, false );



			}else{
	        	displayError(containerId,data.message, function(){
	        		jQuery(nTr).css("color","");
	            	pol_table.fnClose( nTr );
	            });
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown, function(){
        		jQuery(nTr).css("color","");
            	pol_table.fnClose( nTr );
            });
		}
	});
}

function pol_modifyMinMaxPolicy(containerId, nTr,id, name, type, absolute, noPeriods, active, assignable, startDate, noDaysToStart, noDaysInPeriod, min, max, description, quotaInPeriod){

	createLoadingDivAfter(containerId, "Modifying Min Max Policy");

	jQuery.ajax({
		type: 'POST',
		url: '/modules/module_quotasystem/server/policyManager.php',
		dataType: 'json',
		data: {
			action: 'modifyPolicy',
			id:id,
			name:name,
			description:description,
			typePolicy:type,
			absolute:absolute,
			active:active,
			assignable:assignable,
			maxQuota:max,
			minQuota:min,
			quotaInPeriod:quotaInPeriod,
			noPeriods:noPeriods,
			noDaysInPeriod:noDaysInPeriod,
			startDate:startDate,
			daysToRelStart:noDaysToStart
		},
		success: function(data){
			removeLoadingDivAfter(containerId);
			if(data.success){
				if(absolute){
					// pol_formatDetailsRow compares absolute as
					// a string, not a boolean
					absolute = "true";
				}else{
					startDate = null;
				}
                displayMessage(containerId,"Policy ["+name+"] successfully modified", function(){
    				jQuery(nTr).css("color","");
                    pol_table.fnClose( nTr );
                });

				pol_table.fnUpdate( [
				                     id,
				                     name,
				                     type,
				                     absolute ? "1" : "0",
				                     active ? "1" : "0",
				                     assignable ? "1" : "0",
				                     description,
				                     startDate,
				                     noDaysInPeriod,
				                     noPeriods,
				                     max,
				                     min,
				                     quotaInPeriod,
				                     noDaysToStart
				                     ], nTr, false, false  );



			}else{
	        	displayError(containerId,data.message, function(){
	        		jQuery(nTr).css("color","");
	            	pol_table.fnClose( nTr );
	            });
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown, function(){
        		jQuery(nTr).css("color","");
            	pol_table.fnClose( nTr );
            });
		}
	});
}


function pol_delete(divId, nTr, id){
    
	createLoadingDivAfter(divId, "Deleting Policy");
	var aData = pol_table.fnGetData( nTr );
    var name = aData[1];
    
    jQuery.ajax({
        type: 'POST',
        url: '/modules/module_quotasystem/server/policyManager.php',
        dataType: 'json',
        data: {
            action: 'deletePolicy',
            id:id
        },
        success: function(data){
        	removeLoadingDivAfter(divId);
        	
        	if(data.success){
	            displayMessage(divId,"Policy successfully deleted", function(){
	            	pol_table.fnClose( nTr );
	                pol_table.fnDeleteRow(nTr);
	            });  
        	}else{
            	displayError(divId,data.message, function(){
            		jQuery(nTr).css("color","");
                	pol_table.fnClose( nTr );
                });
        		
        	}

        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter(divId);
        	displayError(divId,errorThrown, function(){
        		jQuery(nTr).css("color","");
            	pol_table.fnClose( nTr );
            });
        }
    });


}

