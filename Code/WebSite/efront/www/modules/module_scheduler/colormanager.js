//----------------------------------------------- Utilities

function loadColorOptions(){

	jQuery('a.colorEdit').each(function(){
	
		jQuery(this).click(function(){
		
			var status, code, id;
							
			var td = this.id;
			td = td.replace('edit','code');
			code = document.getElementById(td).innerHTML;
			id = td.substring(td.indexOf('-')+1);
			status = document.getElementById('status-'+id).innerHTML;
			 
			editColorDialogBox(id, code, status);
			
			return false;
		});
	});
	jQuery('a.colorDelete').each(function(){
	
		jQuery(this).click(function(){
		
			var status, code, id;
			
			var td = this.id;
			td = td.replace('delete','code');
			code = document.getElementById(td).innerHTML;
			id = td.substring(td.indexOf('-')+1);
			status = document.getElementById('status-'+id).innerHTML;
			
			deleteColorDialogBox(id);
			
			return false;
		});
		
	});
	jQuery('a.colorStatus').each(function(){
	
		jQuery(this).click(function(){
		
			var status, code, id;
			if(jQuery(this).hasClass('disabled')){
				status = "enabled";
			}else if(jQuery(this).hasClass('enabled')){
				status = "disabled";
			}
			
			var td = this.id;
			td = td.replace('status','code');
			code = document.getElementById(td).innerHTML;
			id = td.substring(td.indexOf('-')+1);
			
			if(updateColor(id, code, status)){
			
				var tagname = '#status-'+id;
				jQuery(tagname).removeClass('enabled');
				jQuery(tagname).removeClass('disabled');
				
				jQuery(tagname).addClass(status);
				document.getElementById('status-'+id).innerHTML = status;
			
			}
			
			return false;
		});
	});

}

//----------------------------------------------- Dialog Boxes

function noticeDialog(header, message, icon){
	
	var noticeContent = jQuery("<div id='calendar-notice' />").html('<p><span class="ui-icon ui-icon-'+icon+'" style="float:left; margin:0 7px 20px 0;"></span>'+message+'</p>');
	
	jQuery(noticeContent).dialog({
		modal: true,
		title: header,
		buttons: {
			Ok: function() {
				jQuery(this).dialog('close');
			}
		}
	});
	
	jQuery(noticeContent).dialog('open');
}

function deleteColorDialogBox(id){
	
	var message = "Are you sure you would like to delete this color? <br/> <i>** this change cannot be undone.</i>";

	var confirmContent = jQuery("<div id='confirm-delete' />").html('<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>'+message+'</p>');
				
	jQuery(confirmContent).dialog({
		autoOpen: false,
		resizable: false,
		height: 140,
		title: "Color Manager - Delete",
		modal: true,
		close: function() {
		   jQuery(this).dialog("destroy");
		   jQuery(this).hide();
		},
		buttons: {
			"delete" : function() {
				if(deleteColor(id)){
					var row = jQuery('#code-'+id).parent();
					jQuery(row).empty();
				
				}else{
					var header = "Color Manager - Delete";
					var message = "We were unable to process your request.<br/> **please try again later.";
					noticeDialog(header, message, 'alert');
				}
				
				jQuery(this).dialog('close');

			},
			close: function() {
				jQuery(this).dialog('close');
			}
		}
	});
	
	jQuery(confirmContent).dialog('open');

}

function editColorDialogBox(id, color, status){
		
	var dialogContent = jQuery("<div id='edit-color-dialog' />").load('modules/module_scheduler/fullcalendar/edit_color.html',function() {
	
		reseColorForm(this);
	
		jQuery('#edit-color-dialog #colorCode').val(color);
		jQuery('#colorSelector2 div').css({ backgroundColor: '#'+color});
		
		jQuery('#edit-color-dialog #status').val(status);
		
		jQuery('#edit-color-dialog #colorCode').ColorPicker({
			
			onSubmit: function(hsb, hex, rgb, el) {
				jQuery(el).val(hex);
				jQuery(el).ColorPickerHide();
			},
			onBeforeShow: function () {
				jQuery(this).ColorPickerSetColor(this.value);
			},
			onChange: function (hsb, hex, rgb) {
				jQuery('#edit-color-dialog #colorCode').val(hex);
				jQuery('#colorSelector2 div').css('backgroundColor', '#' + hex);
			}
		})
		.bind('keyup', function(){
			jQuery(this).ColorPickerSetColor(this.value);
		});
		
	});
	
	jQuery(dialogContent).dialog({
		autoOpen: false,
		width: 300,
		modal: true,
		title: "Color Manager - Edit",
		close: function() {
		   jQuery(this).dialog("destroy");
		   jQuery(this).hide();
		},
		buttons: {
			"change" : function() {
				var colorId = jQuery(this).find("input[name='colorid']").val();
				var colorStatus = jQuery(this).find("select[name='status']");
				var colorCode = jQuery(this).find("input[name='colorCode']").val();
				
				//var id = parseInt(colorId);
				var status = colorStatus.val();
				
				if(colorCode.length == 0){
					code = "000000";
				}else{
					code = colorCode;
				}
				
				if(id>0){
					if(updateColor(id, code, status)){
						var tagname = '#status-'+id;
						jQuery(tagname).removeClass('enabled');
						jQuery(tagname).removeClass('disabled');
						
						jQuery(tagname).addClass(status);
						document.getElementById('status-'+id).innerHTML = status;
						document.getElementById('code-'+id).innerHTML = code;
						
						jQuery('#scheduled-'+id).css({ backgroundColor: '#'+code});
						jQuery('#available-'+id).css({ backgroundColor: '#'+code});
					
					}else{
						var header = "Color Manager - Edit";
						var message = "We were unable to process your request.<br/> **please try again later.";
						noticeDialog(header, message, 'alert');
					}
				}
			
				jQuery(this).dialog("close");
			},
			close : function() {
				jQuery(this).dialog("close");
			}
		}
	});
	
	jQuery(dialogContent).dialog('open');
	
}

function insertColorDialogBox(){
	
	var dialogContent = jQuery("<div id='insert-color-dialog' />").load('modules/module_scheduler/fullcalendar/edit_color.html',function() {
		
		reseColorForm(this);
	
		jQuery('#insert-color-dialog #colorCode').val('ffffff');
		jQuery('#colorSelector2 div').css({ backgroundColor: '#ffffff'});
	
		jQuery('#insert-color-dialog #colorCode').ColorPicker({
			
			onSubmit: function(hsb, hex, rgb, el) {
				jQuery(el).val(hex);
				jQuery(el).ColorPickerHide();
			},
			onBeforeShow: function () {
				jQuery(this).ColorPickerSetColor(this.value);
			},
			onChange: function (hsb, hex, rgb) {
				jQuery('#insert-color-dialog #colorCode').val(hex);
				jQuery('#colorSelector2 div').css('backgroundColor', '#' + hex);
			}
		})
		.bind('keyup', function(){
			jQuery(this).ColorPickerSetColor(this.value);
		});
		
	});
	
	jQuery(dialogContent).dialog({
		autoOpen: false,
		width: 300,
		modal: true,
		title: "Color Manager - Create",
		close: function() {
		   jQuery(this).dialog("destroy");
		   jQuery(this).hide();
		},
		buttons: {
			"create" : function() {
			
				var colorStatus = jQuery(this).find("select[name='status']");
				var colorCode = jQuery(this).find("input[name='colorCode']").val();
				
				var status = colorStatus.val();
				
				if(colorCode.length == 0){
					code = "000000";
				}else{
					code = colorCode;
				}
				var id = insertColor(code, status);
				if(id > 0){
					
					var rowCnt = countAllColors();
				
					if(rowCnt > 0){
						var newRow = "";
						
						newRow += "<tr>";
						newRow += "<td>" + rowCnt + "</td>";
						newRow += "<td id='code-" + id + "'>" + code + "</td>";
						newRow += "<td><div id='scheduled-" + id + "' class='colorcode-scheduled' style='background-color: #" + code + "'>S</div>";
						newRow += "<div id='available-" + id + "' class='colorcode-available' style='background-color: #" + code + "'>A</div></td>";
						newRow += "<td><a id='status-" + id + "' class='colorStatus " + status + "'>" + status + "</a></td>";
						newRow += "<td><a id='edit-" + id + "' class='colorEdit'>edit</a></td>";
						newRow += "<td><a id='delete-" + id + "' class='colorDelete'>delete</a></td>";
						newRow += "</tr>";
										
						jQuery('#scheduler-colormap').html(jQuery('#scheduler-colormap').html() + newRow);  
					}
					var tagname = '#status-'+id;
					jQuery(tagname).removeClass('enabled');
					jQuery(tagname).removeClass('disabled');
					
					jQuery(tagname).addClass(status);
					document.getElementById('status-'+id).innerHTML = status;
					document.getElementById('code-'+id).innerHTML = code;
					
					jQuery('#scheduled-'+id).css({ backgroundColor: '#'+code});
					jQuery('#available-'+id).css({ backgroundColor: '#'+code});
					
					loadColorOptions();
				
				}else{
					var header = "Color Manager - Edit";
					var message = "We were unable to process your request.";
					noticeDialog(header, message, 'alert');
				}
				
			
				jQuery(this).dialog("close");
			},
			close : function() {
				jQuery(this).dialog("close");
			}
		}
	});
	
	jQuery(dialogContent).dialog('open');
	
	
}

function reseColorForm(dialogContent) {
	jQuery(dialogContent).find("input").val("");
	jQuery(dialogContent).find("select").val("");
	//jQuery(dialogContent).find("textarea").val("");
  
}



 //----------------------------------------------- Ajax Calls 
 
 function updateColor(id, code, status){
 	//alert('debug: 2');
	//alert('id: '+id+'\n code: '+code+'\n status: '+status);
	
	var success = false;
 
	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/usecolormanager.php',
		dataType: 'json',
		async: false,	//cache: false,	//timeout: 30000,
		data: {
			action: 'updateEventColor',
			id: id,
			code: code,
			status: status
		},
		success: function(data) {
			//alert('id: ' + data.id + '\n status: ' + data.status + '\n color: ' + data.code + '\n result: ' + data.result);
			if(data.result){
				success = true;
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Color Manager Information";
			var message = "We were unable to process your request.<br/> **please try again later.";
			//alert('XMLHttpRequest:'+XMLHttpRequest);alert('textStatus: '+textStatus);alert("Error: " + errorThrown);
			//noticeDialog(header, message, "alert");
	
		}
	});
	
	//alert('debug: here');
 	return success;
 }
 
 function deleteColor(id){
 	
	var success = false;
 
	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/usecolormanager.php',
		dataType: 'json',
		async: false,
		cache: false,	//timeout: 30000,
		data: {
			action: 'deleteEventColor',
			id: id
		},
		success: function(data) {
			//alert('result: ' + data.result);
			// not sure how to handle the result returned.
			if(data.result){
				success = true;
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Color Manager Information";
			var message = "We were unable to process your request.<br/> **please try again later.";
			//alert('XMLHttpRequest:'+XMLHttpRequest);alert('textStatus: '+textStatus);alert("Error: " + errorThrown);
			//noticeDialog(header, message, "alert");
	
		}
	});
	
 	return success;
 }
 
 function insertColor(code, status){
 
	var success = false;
 
	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/usecolormanager.php',
		dataType: 'json',
		async: false,	//cache: false,	//timeout: 30000,
		data: {
			action: 'insertEventColor',
			code: code,
			status: status
		},
		success: function(data) {
			
			if(data.result){
				success = data.id;
			}
						
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Color Manager Information";
			var message = "We were unable to process yourrequest.<br/> **please try again later.";
			//alert('XMLHttpRequest:'+XMLHttpRequest);alert('textStatus: '+textStatus);alert("Error: " + errorThrown);
			//noticeDialog(header, message, "alert");
	
		}
	});
	
 	return success;
 }
 function countAvailColors(){
 
	var success = false;
 
	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/usecolormanager.php',
		dataType: 'json',
		async: false,	//cache: false,	//timeout: 30000,
		data: {
			action: 'countAvailColors'
		},
		success: function(data) {
			
			if(data.result){
				success = data.result;
			}
						
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Color Manager Information";
			var message = "We were unable to process yourrequest.<br/> **please try again later.";
			//alert('XMLHttpRequest:'+XMLHttpRequest);alert('textStatus: '+textStatus);alert("Error: " + errorThrown);
			//noticeDialog(header, message, "alert");
	
		}
	});
	
 	return success;
 }
 function countAllColors(){
 
	var success = false;
 
	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/usecolormanager.php',
		dataType: 'json',
		async: false,	//cache: false,	//timeout: 30000,
		data: {
			action: 'countAllColors'
		},
		success: function(data) {
			
			if(data.result){
				success = data.result;
			}
						
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Color Manager Information";
			var message = "We were unable to process yourrequest.<br/> **please try again later.";
			//alert('XMLHttpRequest:'+XMLHttpRequest);alert('textStatus: '+textStatus);alert("Error: " + errorThrown);
			//noticeDialog(header, message, "alert");
	
		}
	});
	
 	return success;
 }
 function getAvailColors(){
 
	var success = false;
 
	 jQuery.ajax({
		type: 'POST',
		url: 'modules/module_scheduler/fullcalendar/usecolormanager.php',
		dataType: 'json',
		async: false,	//cache: false,	//timeout: 30000,
		data: {
			action: 'getAvailColors'
		},
		success: function(data) {
			
			if(data.result){
				success = data.result;
			}
						
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			var header = "Color Manager Information";
			var message = "We were unable to process yourrequest.<br/> **please try again later.";
			//alert('XMLHttpRequest:'+XMLHttpRequest);alert('textStatus: '+textStatus);alert("Error: " + errorThrown);
			//noticeDialog(header, message, "alert");
	
		}
	});
	
 	return success;
 }