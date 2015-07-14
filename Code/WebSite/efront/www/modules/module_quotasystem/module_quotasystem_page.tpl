{*Smarty Template*}
<html>
<head>
<!-- CSS -->
<link type="text/css" href="{$T_QS_MODULE_BASELINK}jquery/css/custom-theme/jquery-ui-1.8.6.custom.css" rel="stylesheet" />
{*<link type="text/css" href="{$T_QS_MODULE_BASELINK}jquery/dataTables/media/css/demo_table_jui.css" rel="stylesheet" />*}
<link type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.9.1/css/demo_table_jui.css" />
{*<link type="text/css" href="{$T_QS_MODULE_BASELINK}jquery/css/jquery-ui-timepicker.css" rel="stylesheet" />*}
<link type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-timepicker/1.8.1/jquery.timepicker.css" rel="stylesheet" />
<link type="text/css" href="{$T_QS_MODULE_BASELINK}css/reports.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="{$T_QS_MODULE_BASELINK}css/styles.css" />
<link type="text/css" href="{$T_QS_MODULE_BASELINK}css/validation.css" rel="stylesheet" />
<link type='text/css' rel='stylesheet' href='{$T_QS_MODULE_THEME_CSS}'>


<!-- js Libraries -->
{*<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/jquery-ui-1.8.4.custom.min.js"></script>*}
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.4/jquery-ui.min.js"></script>
{*<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}jquery/dataTables/media/js/jquery.dataTables.min.js'></script>*}
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/datatables/1.9.2/jquery.dataTables.min.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/DateFormat.js'></script>
<script type='text/javascript' src='{$T_QS_MODULE_BASELINK}js/date.js'></script>
{*<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/jquery.ui.timepicker.js"></script>*}
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timepicker/1.8.1/jquery.timepicker.js"></script>

<!-- Reports (flot) -->
{*<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/excanvas.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/jquery.flot.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/jquery.flot.navigate.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/jquery.flot.selection.js"></script>
<script type="text/javascript" src="{$T_QS_MODULE_BASELINK}jquery/flot/jquery.flot.stack.js"></script>*}
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/flot/0.8/excanvas.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/flot/0.8/jquery.flot.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/flot/0.8/jquery.flot.navigate.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/flot/0.8/jquery.flot.selection.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/flot/0.8/jquery.flot.stack.min.js"></script>

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
    			echo '<li><a href="#currentReportTab" id="currentReportTabLink"><span>Current Period Report</span></a></li>'."\n";
    			echo '<li><a href="#histReportTab" id="histReportTabLink"><span>All-periods Report</span></a></li>'."\n";
			{/php}
		
    	</ul>
    	{php}
		        echo '<div id="currentReportTab">'."\n";
		        echo '	<div class="container">'."\n";
		        echo '		<p class="tableTop">'."\n";
		        echo '			<span class="pageTitle">Current Period Report</span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<p class="byCourseSelects select breadcrumb">'."\n";
		        echo '			<span>Course: </span><select class="course"><option value="all">All</option></select>'."\n";
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
		        echo '			<span class="pageTitle">All-periods Report</span>'."\n";
		        echo '		</p>'."\n";
		        echo '		<p class="byCourseSelects byStudentSelects select breadcrumb">'."\n";
		        echo '			<span>Course: </span><select class="course"><option value="all">All</option></select>'."\n";
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
    		
    	{/php}
    </div>
</div>
<script type="text/javascript">
	var uid = {$T_QS_UID};
	$(document).ready(function() {ldelim}
		jQuery("#page").css("min-width","940px");
		//tz_init();
    	{php}
			echo "\n";
			//for tcruz, id: 215, until the database is properly converted
			//echo "\t\t".'initCurrentReport(215);'."\n";
		    //echo "\t\t".'initHistoricReport(215);'."\n";
			echo "\t\t".'initCurrentReport(uid);'."\n";
		    echo "\t\t".'initHistoricReport(uid);'."\n";
			echo "\n";
		{/php}
		
		jQuery('#tabs').tabs();
		{rdelim});
</script>
</body>
</html>