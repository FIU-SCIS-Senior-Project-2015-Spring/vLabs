{*Smarty Template*}
<html>
<head>
<!-- CSS -->
<link type="text/css" href="{$T_QS_MODULE_BASELINK}jquery/css/custom-theme/jquery-ui-1.8.6.custom.css" rel="stylesheet" />
<link type="text/css" href="{$T_QS_MODULE_BASELINK}jquery/dataTables/media/css/demo_table_jui.css" rel="stylesheet" />
<link type="text/css" href="{$T_QS_MODULE_BASELINK}jquery/css/jquery-ui-timepicker.css" rel="stylesheet" />
<link type="text/css" href="{$T_QS_MODULE_BASELINK}css/reports.css" rel="stylesheet" />
<link rel="stylesheet" type="{$T_QS_MODULE_BASELINK}text/css" href="css/styles.css" />
<link type="text/css" href="{$T_QS_MODULE_BASELINK}css/validation.css" rel="stylesheet" />

<!-- js Libraries -->
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/jquery-ui-1.8.4.custom.min.js"></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}jquery/dataTables/media/js/jquery.dataTables.min.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/DateFormat.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/date.js'></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/jquery.ui.timepicker.js"></script>


<!-- Reports (flot) -->
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/excanvas.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/jquery.flot.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/jquery.flot.navigate.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/jquery.flot.selection.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/jquery.flot.stack.js"></script>

<!-- LiveValidation -->
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}js/livevalidation/livevalidation.js"></script>

<!-- Our scripts -->
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/timezone.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/loading.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/credits.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/transactions.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/policies.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/reports.js'></script>
</head>
<body>

<div id="wrapper" >
    <div id="tabs">
    	<ul id="tabsul">
			{php}
    			echo '<li><a href="#policiesTab" id="policiesTabLink"><span>Policies</span></a></li>'."\n";
    			echo '<li><a href="#creditsTab" id="creditsTabLink"><span>Credit Types</span></a></li>'."\n";
			{/php}
    	</ul>
    	{php}
    			echo '<div id="policiesTab">'."\n";
		        echo '	<div class="container">'."\n";
		        echo '		<p class="tableTop">'."\n";
		        echo '			<span class="pageTitle">Policies</span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<span class="addButton"><button id="add-policy">Add Policy</button></span>'."\n";
		        echo '		<div class="messageContainer" style="display:none"></div>'."\n";
		        echo '		<div id="addPolicyForm" class="addForm" style="display:none"></div>'."\n";
		        echo '		<div id="policiesTableContainer"></div>'."\n";
		        echo '	</div>'."\n";
		        echo '</div>'."\n";

		        echo '<div id="creditsTab">'."\n";
		        echo '	<div class="container">'."\n";
		        echo '		<p class="tableTop">'."\n";
		        echo '			<span class="pageTitle">Credit Types</span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<span class="addButton"><button id="add-creditType" >Add Credit Type</button></span>'."\n";
		        echo '		<div class="messageContainer" style="display:none"></div>'."\n";
		        echo '		<div id="addCreditTypeForm" class="addForm" style="display:none"></div>'."\n";
		        echo '		<div id="creditsTableContainer"></div>'."\n";
		        echo '	</div>'."\n";
		        echo '</div>'."\n";

		        // SMS: 3/14/2012
		        /*
		        echo '<div id="currentReportTab">'."\n";
		        echo '	<div class="container">'."\n";
		        echo '		<p class="tableTop">'."\n";
		        echo '			<span class="pageTitle">Current Period Reports</span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<p class="radios">'."\n";
		        echo '			<input type="radio" name="currentView" value="byCourse" checked="checked" /><span>By Course</span>'."\n";
		        echo '			<input type="radio" name="currentView" value="byStudent" /><span>By Student</span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<p class="byCourseSelects select breadcrumb">'."\n";
		        echo '			<span>Course: </span><select class="course"><option value="all">All</option></select>'."\n";
		        echo '			<span class="breadcrumb"></span>'."\n";
		        echo '			<span class="loadingId"></span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<p class="byStudentSelects select breadcrumb">'."\n";
		        echo '			<span>Student: </span><select class="student"><option value="none">--Select a student--</option></select>'."\n";
		        echo '			<span> >> Course: </span><select class="course"><option value="all">All</option></select>'."\n";
		        echo '			<span class="breadcrumb"></span>'."\n";
				echo '			<span class="loadingId"></span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<div id="currentReport">'."\n";
		        echo '    		<div class="chart" ></div>'."\n";
		        echo '			<div class="panLeft"></div>'."\n";
		        echo '			<div class="panRight"></div>'."\n";
		        echo '			<div class="sorter">'."\n";
		        echo '				<div class="checkPercentage">'."\n";
		        echo '					<input type="checkbox" name="currentPercentage" checked="checked" /><span>Percentage</span>'."\n";
		        echo '				</div>'."\n";
		        echo '				<ul class="sortable"></ul>'."\n";
		        echo '				<div class="ascDescDiv" id="currentAscDescDiv">'."\n";
				echo '					<p><span>Sort by: </span><select class="sortBy"></select></p>'."\n";
		        echo '					<p><input type="radio" name="currentAscDesc" value="asc"  checked="checked"/><span>Ascendant</span></p>'."\n";
		        echo '					<p><input type="radio" name="currentAscDesc" value="desc"/><span>Descendant</span></p>'."\n";
		        echo '				</div>'."\n";
		        echo '			</div>'."\n";
		        echo '			<div style="clear:both" id="debugC"></div>'."\n";
		        echo '		</div>'."\n";
		        echo '	</div>'."\n";
		        echo '</div>'."\n";

		        echo '<div id="histReportTab">'."\n";
		        echo '	<div class="container">'."\n";
		        echo '		<p class="tableTop">'."\n";
		        echo '			<span class="pageTitle">All-periods Reports</span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<p class="radios">'."\n";
		        echo '			<input type="radio" name="histView" value="byCourse" checked="checked"/><span>By Course</span>     '."\n";
		        echo '			<input type="radio" name="histView" value="byStudent" /><span>By Student</span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<p class="byCourseSelects select breadcrumb">'."\n";
		        echo '			<span>Course: </span><select class="course"><option value="all">All</option></select>'."\n";
		        echo '			<span class="breadcrumb level1"></span>'."\n";
		        echo '			<span class="breadcrumb level2"></span>'."\n";
				echo '			<span class="loadingId"></span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<p class="byStudentSelects select breadcrumb">'."\n";
		        echo '			<span>Student: </span><select class="student"><option value="none">--Select a student--</option></select>'."\n";
		        echo '			<span> >> Course: </span><select class="course"><option value="all">All</option></select>'."\n";
		        echo '			<span class="breadcrumb"></span>'."\n";
				echo '			<span class="loadingId"></span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<div id="histReport">'."\n";
		        echo '    		<div class="chart" ></div>'."\n";
		        echo '			<div class="panLeft"></div>'."\n";
		        echo '			<div class="panRight"></div>'."\n";
		        echo '			<div class="sorter">'."\n";
		        echo '				<div class="checkPercentage">'."\n";
		        echo '					<input type="checkbox" name="histPercentage" checked="checked" /><span>Percentage</span>'."\n";
		        echo '				</div>'."\n";
		        echo '				<ul class="sortable"></ul>'."\n";
		        echo '				<div class="ascDescDiv" id="histAscDescDiv">'."\n";
				echo '					<p><span>Sort by: </span><select class="sortBy"></select></p>'."\n";
		        echo '					<p><input type="radio" name="histAscDesc" value="asc" checked="checked"/><span>Ascendant</span></p>'."\n";
		        echo '					<p><input type="radio" name="histAscDesc" value="desc"/><span>Descendant</span></p>'."\n";
		        echo '				</div>'."\n";
		        echo '			</div>'."\n";
		        echo '			<div style="clear:both" id="debugH"></div>'."\n";
		        echo '		</div>'."\n";
		        echo '	</div>'."\n";
		        echo '</div>'."\n";
		        */
    	{/php}
    </div>
</div>
<script type="text/javascript">
	function loadTabs(){ldelim}
		$("#page").css("min-width","940px");
		tz_init();
    	{php}
			echo "\n";
				echo "\t\t".'pol_init();'."\n";
				echo "\t\t".'ct_init();'."\n";
				// SMS: 3/14/2012
		        // echo "\t\t".'initCurrentReport("");'."\n";
		        // echo "\t\t".'initHistoricReport("");'."\n";
		        //
			
			echo "\n";
		{/php}	
		$('#tabs').tabs();
		{rdelim}
		loadTabs();
</script>
</body>
</html>