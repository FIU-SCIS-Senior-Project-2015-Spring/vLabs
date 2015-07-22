{*Smarty template*}
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="frame-container">
		<iframe src="{$T_LANDING}" frameBorder="0"></iframe>
	</div>
</body>
<style>
	{literal}
	.frame-container{
		position: relative;
		height: 0;
		overflow: hidden;
		padding-bottom: 75%
	}
	.frame-container iframe{
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
	}
	{/literal}
</style>
</html>