/*
 *preassignment.js
 *
 *@author Vanessa Ramirez
 *
 *
 *
 */

var pre_table;
var pre_open_validation_forms = new Array();

var preassignphpURL = "/modules/module_shoppingcart/server/preassignment.php";


function openPreassignmentTab()
{
    $('#tabs').tabs("select","#preassignemntTab");

}


function pre_reload()
{
	$("#preassignmentContainer").html("");
	
	//alert("In preassignment.js, pre_load() function");
	createLoadingDivAfter("#preassignmentContainer","Loading preassignments");

    $.ajax({
        type: 'POST',
        url: preassignphpURL,
        dataType: 'json',
        data: {
            action: 'reload'
        },
        success: function(data){
        	removeLoadingDivAfter("#preassignmentContainer");
          	
        	$('#preassignmentContainer').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="preassignmentTable"></table>' );
            
        	pre_table = $("#preassignmentTable").dataTable({
                "aaData": data,
                "aoColumns": [
                {  "sTitle": "ID" },                              
                {  "bVisible": false },
                { "sTitle": "Course" },
                {  "bVisible": false },
                { "sTitle": "Item" },
                { "sTitle": "Quantity" },
                {  "bVisible": false }
                //{ "sTitle": "Active" , "fnRender": function (oObj) {  return oObj.aData[6]=="1" ? "Yes" : "No"; } },
                ],
        		"bJQueryUI": true,
        		"bAutoWidth": false,
        		"sPaginationType": "full_numbers"
        	});
        	
        	
        	$("#preassignmentTable").removeAttr("style");
        	$('#preassignmentTable tbody tr td').die();
        	$('#preassignmentTable tbody tr td').live('click', pre_rowClickHandler );
        	
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter("#preassignmentContainer");
        	displayError("#preassignmentContainer",errorThrown); 
        }
    });

}

function pre_rowClickHandler(){

	var nTr = this.parentNode;
	var open=false;
	
	try{
		if($(nTr).next().children().first().hasClass("ui-state-highlight"))
			open=true;
	}catch(err){
		alert(err);
	}
	
	if (open){
		/* This row is already open - close it */
		pre_table.fnClose( nTr );
		$(nTr).css("color","");
	}else{
		pre_openDetailsRow(nTr);
	}
}

function pre_openDetailsRow(nTr){

	pre_table.fnOpen( nTr, pre_formatPreassignmentDetails(pre_table, nTr), "ui-state-highlight" );
	var aData = pre_table.fnGetData( nTr );	
	$("#modifyPreassignment"+aData[0]).button();
	$("#deletePreassignment"+aData[0]).button();
	
	var divId = "#preassignmentDetails"+aData[0];
	
	$("#modifyPreassignment"+aData[0]).click(function(){
		$(nTr).css("color","#c5dbec");
		$(divId).empty();
		pre_openForm(divId, false, nTr, aData[0]);			        				
	});
	
	$("#deletePreassignment"+aData[0]).click(function(){
		pre_deletePreassignment(divId, nTr, aData[0]);
	});
	
}

function pre_formatPreassignmentDetails( oTable, nTr )
{
	var aData = oTable.fnGetData( nTr );
	var sOut = '';
	sOut += '<div id="preassignmentDetails'+aData[0]+'">';
	sOut += '	<div class="buttonColumnDetails">';
	sOut += '		<button id="modifyPreassignment'+aData[0]+'">Modify</button>';
	sOut += '		<button id="deletePreassignment'+aData[0]+'">Delete</button>';
	sOut += '	</div>';
	sOut += '</div>';
	
	return sOut;
}

function pre_openForm(containerId, add, nTr, id)
{

	$(containerId).empty();
    $(containerId).hide();

	$(containerId).load("forms/createPreassignment.html", function(){

		  createLoadingDivAfter(containerId,"Loading courses");
		  $.ajax({
		        type: 'POST',
		        url: preassignphpURL,
		        dataType: 'json',
		        data: {
		            action: 'getCourses'
	
		        },
		        success: function(data){
		        	removeLoadingDivAfter(containerId);
		        	var content = '';
		            var courses = data;
		            if(courses.length>0){
		                for(var i in courses)
		                {
		                    content+="<option value='"+courses[i].id+"'>"+courses[i].name+"</option>";                  		
	
		                }            	
		            	
		            }else{
		            	content+="<option value=''>No course available</option>";  
		            }
						
		            $(containerId+" .coursePre").html(content);
						var deleteme = $(containerId+" .coursePre").val();
		            createLoadingDivAfter(containerId,"Loading items");
		            $.ajax({
		                type: 'POST',
		                url: preassignphpURL,
		                dataType: 'json',
		                data: {
		                    action: 'getItems',
		                    courseid:$(containerId+" .coursePre").val()

		                },
		                success: function(data){
		                	removeLoadingDivAfter(containerId);
		                	var content = '';
		                    var items = data;
		                    if(items.length>0){
		        	            for(var i in items)
		        	            {
		        	                content+="<option value='"+items[i].id+"'>"+items[i].name+"</option>";                  		
		        	
		        	            }
		                    }else{
		                    	content+="<option value=''>No elegible item</option>";    
		                    }
		                    
		                    $(containerId+" .itemPre").html(content);
		                    
		                    
		                    $(containerId+" .coursePre").change(function(){
		                        pre_loadItemsForCourse(containerId, $(containerId+" .coursePre").val());
		                    });
				            
				            if(add)
				            {

				            	$(containerId).addClass("ui-state-highlight");
				            	
				            	pre_showForm(containerId);	    
				            	
				            	$(containerId+" .submit").button();
				            	$(containerId+" .cancel").button();

				            	$(containerId + " .submit").click(function() {
				            		
				            		if(pre_isValidForm(containerId)){
				            			var courseId = $(containerId + " .coursePre").val();
				            			var itemId = $(containerId + " .itemPre").val();
				            			var quantity = $(containerId + " .quantityPre").val();
				            			
				            			
				            			$(containerId).slideUp(400, function(){	    			 
				            				pre_addPreassignment(containerId,courseId,itemId, quantity);
				            				$(containerId).empty();
				            				$("#add-preassignment").button("enable");
				            				pre_removeValidationForm(containerId); 
				            			});
				            		}

				            	});

				            	$(containerId+" .cancel").click(function(){
				            		$(containerId).slideUp(400, function(){	    			 
				            			$(containerId).empty();
				            			$("#add-preassignment").button("enable");
				            			pre_removeValidationForm(containerId); 
				            		});

				            	});

				            }else{
				            	
				            	pre_fillOutForm(containerId,id, nTr);  	
				            	
				            	$(containerId+" .submit").button();
				            	$(containerId+" .cancel").button();

				            	$(containerId + " .submit").click(function() {

				            		if(pre_isValidForm(containerId)){
				            			var course = $(containerId + " .coursePre").val();
				            			var item = $(containerId + " .itemPre").val();
				            			var quantity = $(containerId + " .quantityPre").val();

				            			$(containerId).slideUp(400, function(){	    			 
				            				pre_modifyPreassignment(containerId, nTr, id,course,item, quantity);
				            				$(containerId).empty();
				            				pre_removeValidationForm(containerId); 
				            			});


				            		}

				            	});

				            	$(containerId+" .cancel").click(function(){
				            		$(containerId).slideUp(400, function(){	    			 
				            			$(containerId).empty();
				                		$(nTr).css("color","");
				    	                pre_table.fnClose( nTr );
				            			pre_removeValidationForm(containerId); 
				            		});

				            	});
				            }

				            pre_addFormValidation(containerId);
		                         
		                },
		                error: function(XMLHttpRequest, textStatus, errorThrown){
		                	removeLoadingDivAfter(containerId);
		                	displayError(containerId,errorThrown);
		                }
		            });

		        },
		        error: function(XMLHttpRequest, textStatus, errorThrown){
		        	removeLoadingDivAfter(containerId);
		        	displayError(containerId,errorThrown);
		        }
		    });
	  });
}


function pre_fillOutForm(containerId,preassignmentId){

	 createLoadingDivAfter(containerId,"Loading preassignment");
	 
	  $.ajax({
	        type: 'POST',
	        url: preassignphpURL,
	        dataType: 'json',
	        data: {
	            action: 'getPreassignment',
	            id:preassignmentId
	        },
	        success: function(data){
	        	removeLoadingDivAfter(containerId);
	        	var preassignment = data.preassignment;
  				$(containerId+" .coursePre").val(preassignment.courseid);
				var deleteme = preassignment['courseid'];
  				createLoadingDivAfter(containerId,"Loading items");
  				 $.ajax({
  			        type: 'POST',
  			        url: preassignphpURL,
  			        dataType: 'json',
  			        data: {
  			            action: 'getItems',
  			            courseid:preassignment.courseid

  			        },
  			        success: function(data){
  			        	removeLoadingDivAfter(containerId);
  			        	var content = '';
  			            var items = data;
  			            if(items.length>0){
  				            for(var i in items)
  				            {
  				                content+="<option value='"+items[i].id+"'>"+items[i].name+"</option>";                  		 				
  				            }
  			            }else{
  			            	content+="<option value=''>No elegible item</option>";    
  			            }
  			            
  			            $(containerId+" .itemPre").html(content);		
  		      			$(containerId+" .itemPre").val(preassignment.itemid);
  		      			
  		      			
  		      			$(containerId+" .coursePre").attr("disabled","disabled");
  		      			$(containerId+" .itemPre").attr("disabled","disabled");
  		      			
  		          		$(containerId+" .quantityPre").val(preassignment.quantity);      		
  		          		pre_showBasicFormFields(containerId);
  		        	    $(containerId).slideDown(400);
  			                 
  			        },
  			        error: function(XMLHttpRequest, textStatus, errorThrown){
	  			      	removeLoadingDivAfter(containerId);
	  					displayError(containerId, errorThrown, function() {
	  						$(nTr).css("color", "");
	  						pre_table.fnClose(nTr);
	  					});
  			        }
  			    });
	        },
	        error: function(XMLHttpRequest, textStatus, errorThrown){
			      	removeLoadingDivAfter(containerId);
  					displayError(containerId, errorThrown, function() {
  						$(nTr).css("color", "");
  						pre_table.fnClose(nTr); 
  					});
	        }
	  });
}
  
function pre_loadItemsForCourse(containerId,courseId){
	
	createLoadingDivAfter(containerId,"Loading items");
	 
    $.ajax({
        type: 'POST',
        url: preassignphpURL,
        dataType: 'json',
        data: {
            action: 'getItems',
            courseid:courseId

        },
        success: function(data){
        	removeLoadingDivAfter(containerId);
        	var content = '';
            var items = data;
            if(items.length>0){
	            for(var i in items)
	            {
	                content+="<option value='"+items[i].id+"'>"+items[i].name+"</option>";                  		
	
	            }
            }else{
            	content+="<option value='0'>No elegible item</option>";    
            }
            
            $(containerId+" .itemPre").html(content);
                 
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter(containerId);
        	displayError(containerId,"Error collecting data to display in this form");
        }
    });
	
}


function pre_addPreassignment(containerId, courseId, itemId, quantity){
	
	createLoadingDivAfter(containerId,"Creating preassignment");
	
	$.ajax({
        type: 'POST',
        url: preassignphpURL,
        dataType: 'json',
        data: {
            action: 'addPreassignment',
            courseid:courseId,
            itemid:itemId,
            quantity:quantity

        },
        success: function(data){
        	
        	removeLoadingDivAfter(containerId);
            
        	if(!data.success){
            	displayError(containerId,data.message);	
            }
            else{
            	
            	displayMessage(containerId,"Preassignment added successfully!");
            	var p = data.preassignment;
            	pre_table.fnAddData( [p.id,
            	                      p.courseId,
            	                      p.courseName,
            	                      p.itemId,
				                      p.itemName,
				                      p.quantity,
				                      p.active
				                      ] );
            }

        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown); 
        }
    });
	
	
}

function pre_modifyPreassignment(containerId, nTr, id, courseId, itemId, quantity){
	
	createLoadingDivAfter(containerId,"Modifying preassignment");
	
	$.ajax({
        type: 'POST',
        url: preassignphpURL,
        dataType: 'json',
        data: {
            action: 'modifyPreassignment',
            courseid:courseId,
            itemid:itemId,
            quantity:quantity,
            id:id

        },
        success: function(data){
    
        	removeLoadingDivAfter(containerId);
            if(!data.success){
            	displayError(containerId,data.message);	
            }
            else{            	
            	displayMessage(containerId,"Preassignment modified successfully!", function(){
    				$(nTr).css("color","");
                    pre_table.fnClose( nTr );
                });
            	var p = data.preassignment;
            	pre_table.fnUpdate( [ p.id,
            	                      p.courseId,
            	                      p.courseName,
            	                      p.itemId,
				                      p.itemName,
				                      p.quantity,
				                      p.active
				                      ],
				                      nTr,
				                      false,
				                      false);

            }

        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown); 
        }
    });
	
	
}

function pre_deletePreassignment(containerId,nTr, id){
	
	createLoadingDivAfter(containerId,"Deleting preassignment");
	
	$.ajax({
        type: 'POST',
        url: preassignphpURL,
        dataType: 'json',
        data: {
            action: 'deletePreassignment',
            id:id

        },
        success: function(data){
        	removeLoadingDivAfter(containerId);
            if(data.success){
           	 displayMessage(containerId,"Preassignment successfully deleted", function(){
              	pre_table.fnClose( nTr );
          		pre_table.fnDeleteRow(nTr);
              });
            }
            else{
            	displayError(containerId,"Preassignment could not be deleted", function(){
            		$(nTr).css("color","");
                	pre_table.fnClose( nTr );
                });
            }

        },
        error: function(XMLHttpRequest, textStatus, errorThrown){
        	removeLoadingDivAfter(containerId);
        	displayError(containerId,errorThrown); 
        }
    });
	
	
}


function pre_addFormValidation(containerId){

	var formFields = new Array();

	var item = containerId.substring(1)+"_itemPre";
	$(containerId+" .itemPre").attr("id",item);
	var itemValidator = new LiveValidation( item , {wait: 500});
	itemValidator.add( Validate.Presence );
	formFields.push(itemValidator);
	
	var course = containerId.substring(1)+"_coursePre";
	$(containerId+" .coursePre").attr("id",course);
	var courseValidator = new LiveValidation( course , {wait: 500});
	courseValidator.add( Validate.Presence );
	formFields.push(courseValidator);
	
	
	var quantity = containerId.substring(1)+"_quantityPre";
	$(containerId+" .quantityPre").attr("id",quantity);
	var qtyValidator = new LiveValidation( quantity , {wait: 500});
	qtyValidator.add( Validate.Presence );
	qtyValidator.add( Validate.Numericality, { onlyInteger: true, minimum: 1 } );
	formFields.push(qtyValidator);

	var liveValidationForm = { container_id: containerId, form_fields: formFields };
	pre_open_validation_forms.push(liveValidationForm);
}

function pre_removeValidationForm(containerId){

	var tempArray = new Array();
	for(var i=0; i < pre_open_validation_forms.length ; i++){
		if(pre_open_validation_forms[i].container_id != containerId){
			tempArray.push(pre_open_validation_forms[i]);
		}
	}

	pre_open_validation_forms = tempArray;
}

function pre_isValidForm(containerId){
	
	for(var i=0; i < pre_open_validation_forms.length ; i++){
		if(pre_open_validation_forms[i].container_id == containerId){
			return LiveValidation.massValidate(pre_open_validation_forms[i].form_fields);
		}
	}
	return false;
}


function pre_hideAllFormFields(containerId){
	$(containerId+" form fieldset div div").each(function(index) {
	    $(this).find('input[type="text"]').attr("disabled","disabled");
	    $(this).hide();
	  });
}

function pre_showBasicFormFields(containerId){

	
	  $(containerId+" form fieldset div div").each(function(index) {	    	
	    	$(this).find('input[type="text"]').attr("disabled","");
	    	$(this).show();
	  });

}

function pre_showForm(containerId){

	
	  $(containerId+" .itemPreSpan").show();
	  $(containerId+" .coursePreSpan").show();
	  $(containerId+" .quantityPreSpan").show();

	  $(containerId).show();
}

