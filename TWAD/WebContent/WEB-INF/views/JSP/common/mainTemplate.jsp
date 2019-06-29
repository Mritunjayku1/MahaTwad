<!--  Created by Mahalingam on 17-04-2017 -->


<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="library/img/EC_logo.jpg">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>



<!-- Java scripts-->
<script src="library/js/jquery-1.7.2.min.js"></script>
<script src="library/js/jquery-ui-1.8.21.custom.min.js"></script>
<script src='library/js/jquery.dataTables.min.js'></script>
<script src='library/js/chosen.jquery.js'></script>
<script src='library/js/jquery.validate.js'></script>
<script src='library/js/dataTables.fixedColumns.js'></script>
<script src='library/js/jquery-ui-timepicker-addon.js'></script>
<script src='JS/common.js'></script>

<!-- End of Java scripts-->

<!-- Style Sheets -->

<link href="library/css/bootstrap-responsive.css" rel="stylesheet">
<link href="library/css/jquery.dataTables.css" rel="stylesheet">
<link href="library/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
<link id="bs-css" href="library/css/bootstrap-cerulean.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="library/css/dataTables.responsive.css" />
<link href='library/css/chosen.css' rel='stylesheet'>
<link href='library/css/uniform.default.css' rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="library/css/jQueryTable.css" />
<link href='library/css/chosen.css' rel='stylesheet'>

<style>
.se-pre-con {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url(library/img/loader.gif) center no-repeat #fff;
}
input[type="checkbox"] {
	width: 20px;
	height: 20px;
	transform: scale(1.5);
	-webkit-transform: scale(1);
}
.se-post-con {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	display:none;
	background: url(library/img/progress.gif) center no-repeat #fff;
}
</style>

<!-- End of Style Sheets -->
</head>

<body>

	<div class="se-pre-con"></div>
	<div class="se-post-con"></div>
	<div id="InternalDialog"></div>
	
	<div class="row-fluid span12" style='text-align: center;'>
		<tiles:insertAttribute name="headerTop"></tiles:insertAttribute>
		
	</div>
	<div class="row-fluid span12" style='text-align: center;'>
	<tiles:insertAttribute name="headerMenu"></tiles:insertAttribute>
	</div>

	<div class="row-fluid span12" style='min-height:2px;'>
		

		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</div>

	<div style='text-align: center'>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

</body>
</html>