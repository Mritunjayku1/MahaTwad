

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="refresh" content="60" />
<!-- <script src="library/js/pageScripts/agentPerformance.js"></script> -->

<link rel="stylesheet"
	href="library/graph/styles/jChartFX Palettes/chartfx6.css" />
<script src="library/graph/DashBoardChart.js"></script>
<script src="library/graph/js/jchartfx.system.js"></script>
<script src="library/graph/js/jchartfx.coreVector.js"></script>
<script src="library/graph/js/jchartfx.advanced.js"></script>
<script src="library/graph/js/jchartfx.animation.js"></script>


<link rel="stylesheet" href="library/assets/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="library/assets/css/main.css" />
    <link rel="stylesheet" href="library/assets/css/theme.css" />
    <link rel="stylesheet" href="library/assets/css/MoneAdmin.css" />
    <link rel="stylesheet" href="library/assets/plugins/Font-Awesome/css/font-awesome.css" />
    <!--END GLOBAL STYLES -->

    <!-- PAGE LEVEL STYLES -->
    <link href="library/assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" href="library/assets/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="library/assets/css/main.css" />
    <link rel="stylesheet" href="library/assets/css/theme.css" />
    <link rel="stylesheet" href="library/assets/css/MoneAdmin.css" />
    <link rel="stylesheet" href="library/assets/plugins/Font-Awesome/css/font-awesome.css" />
	    <link rel="stylesheet" href="library/assets/plugins/validationengine/css/validationEngine.jquery.css" />

<style>
.count {
	font-size: 28px;
	color: #1589FF;
}

table.display td {
	font-size: 17px;
}

.count1 {
	font-size: 16px;
	color: #1589FF;
}

table.display .td {
	font-size: 13px;
}

#menu1 {
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}
</style>

<table class='table-bordered table table-striped display'
	style='width: 100%; font-size: 28px;'>

	<tr>
		<td colspan='8'
			style='text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;'>
			Dashboard</td>
	</tr>
	
</table>
<br/>
<div>

	<div id=compliantDashboard
		style="width: 32%; height: 400px; float: left; margin-left: 30%;"></div>

</div>
<div></div>
<script>
	
setTimeout(function(){ 
	var pendingCount =  parseInt(localStorage.getItem("localStorage_penndingApplication"));
	var approvedCount = parseInt(localStorage.getItem("localStorage_approvedApplication"));
	var rejectedCount = parseInt(localStorage.getItem("localStorage_rejectedApplication"));
	
	var data = [ {
		"Compliants" : "Pending",
		"Count" : pendingCount
	}, {
		"Compliants" : "Reassign/Transfer",
		"Count" : approvedCount
	},
	{
		"Compliants" : "Rejected",
		"Count" : rejectedCount
	}

	];

	fnPlotPieChart(data, "compliantDashboard", "Total Registered Application Count:" + (pendingCount +approvedCount+rejectedCount));
	}, 1000);
	</script>