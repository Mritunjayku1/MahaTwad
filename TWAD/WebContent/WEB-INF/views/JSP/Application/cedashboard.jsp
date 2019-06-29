

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
	
	<tr>
		<form:form method='get' id="0" commandName="dashboardForm"
			action="ceViewApp.do">
			<td><spring:message code="label.totalComplaints" /> <%-- <form:hidden
					path="complaintStatus" value="0" /> --%><!--  <a
				href="javascript:fnSubmitForm('0');"> -->
				<span class='count'>${list.count.getTotalRegister()}</span><!-- </a> -->
				<input type="hidden" id='totalCount' name='totalCount'
				value="${list.count.getTotalRegister()}" /></td>
		</form:form>

		<form:form method='get' id="1" commandName="dashboardForm"
			action="ceViewApp.do">
			<td><spring:message code="label.newComplaints" /> <%-- <form:hidden
					path="complaintStatus" value="1" />  --%><a
				href="javascript:fnSubmitForm('1');"><span class='count'>${list.count.getPenndingApplication()}</span></a>
				<input type="hidden" id='newCount' name='newCount'
				value="${list.count.getPenndingApplication()}" /></td>
		</form:form>

		<form:form method='get' id="2" commandName="dashboardForm"
			action="ceApproved.do">
			<td><spring:message code="label.assignedComplaints" /> <%-- <form:hidden
					path="complaintStatus" value="2" /> --%> <a
				href="javascript:fnSubmitForm('2');"><span class='count'>${list.count.getApprovedApplication()}</span></a>
				<input type="hidden" id='assignCount' name='assignCount'
				value="${list.count.getApprovedApplication()}" /></td>
		</form:form>

		<form:form method='get' id="3" commandName="dashboardForm"
			action="eeConPaidApp.do">
			<td><spring:message code="label.paymentPaidapp" /> <%-- <form:hidden
					path="complaintStatus" value="2" /> --%> <!-- <a
				href="javascript:fnSubmitForm('2');"> -->
			<!-- <a href="javascript:fnSubmitForm('3');"> -->	<span class='count'>${list.count.getPaidApplication()}</span><!-- </a> -->
			<!-- </a> --> <input type="hidden" id='paidCount'
				name='paidCount' value="${list.count.getPaidApplication()}" /></td>
		</form:form>

		<%-- <form:form method='post' id="10" commandName="dashboardForm"
			action="#">
			<td><spring:message code="label.esclation" /> <form:hidden
					path="complaintStatus" value="10" /> <a
				href="javascript:fnSubmitForm('10');"><span class='count'>${list.count.getTotalRegister()}</span></a>
				<input type="hidden" id='escalationCount' name='escalationCount'
				value="${list.count.getTotalRegister()}" /></td>
		</form:form> --%>
		
	</tr>
	


	<input type="hidden" id='totalChannelCount' name='totalChannelCount'
		value="${list.count.getTotalRegister()}" />
	<input type="hidden" id='SMSChannelCount' name='SMSChannelCount'
		value="${list.count.getTotalRegister()}" />
	<input type="hidden" id='IVRChannelCount' name='EmailChannelCount'
		value="${list.count.getTotalRegister()}" />
	<input type="hidden" id='EmailChannelCount' name='AppChannelCount'
		value="${list.count.getTotalRegister()}" />
	<input type="hidden" id='mobileAppChannelCount'
		name='mobileAppChannelCount'
		value="${list.count.getTotalRegister()}" />
	<input type="hidden" id='walkinCount' name='walkinCount'
		value="${list.count.getTotalRegister()}" />
	<input type="hidden" id='tappalCount' name='tappalCount'
		value="${list.count.getTotalRegister()}" />

	<c:set var="total" value="${0}" />
	<c:set var="count" value="0" scope="page" />
	<c:forEach items="${list.categoryCount}" var="category">
		<c:set var="count" value="${count+1}" scope="page" />
		<input type="hidden" id="category${count}"
			value="${category.getCategoryCount()}" />
		<c:set var="total" value="${total + category.getCategoryCount()}" />

	</c:forEach>

	<input type="hidden" value="${total}" id="categoryTotal" />



</table>
<br>
<br>
<div>

	<div id=compliantDashboard
		style="width: 32%; height: 400px; float: left; margin-left: 30%;"></div>

</div>
<div></div>
<script>
	/* var totalCount = parseInt($('#totalCount').val());
	var newCount = parseInt($('#newCount').val());
	var assignCount = parseInt($('#assignCount').val());
	var acknowledgedCount = parseInt($('#acknowledgedCount').val());
	var closedbyfieldofficer = parseInt($('#closedbyfieldofficer').val());
	var resolvedCount = parseInt($('#resolvedCount').val());
	var rejectedCount = parseInt($('#rejectedCount').val());
	
	var categoryTotal=parseInt($("#categoryTotal").val());
	var categoryMD=parseInt($("#category1").val());
	var categoryGF=parseInt($("#category2").val());
	var categoryLI=parseInt($("#category3").val());
	var categoryPO=parseInt($("#category4").val());
	var categoryDI=parseInt($("#category5").val());
	var categoryVE=parseInt($("#category6").val());
	var categoryPA=parseInt($("#category7").val());
	var categoryPO=parseInt($("#category8").val());
	var categoryEL=parseInt($("#category9").val());
	var category10=parseInt($("#category10").val());
	var category11=parseInt($("#category11").val());
	var category12=parseInt($("#category12").val()); */

	var totalCount =  parseInt($('#totalCount').val());
	var newCount =parseInt($('#newCount').val());
	var assignCount = parseInt($('#assignCount').val());
	var paidCount = parseInt($('#paidCount').val());
	var acknowledgedCount = 20;
	var closedbyfieldofficer = 40;
	var resolvedCount = 20;
	var rejectedCount = 30;

	var categoryTotal = 20;
	var categoryMD = 40;
	var categoryGF = 50;
	var categoryLI = 60;
	var categoryPO = 20;
	var categoryDI = 30;
	var categoryVE = 30;
	var categoryPA = 80;
	var categoryPO = 40;
	var categoryEL = 8
	var category10 = 20;
	var category11 = 10;
	var category12 = 20;

	var data = [ {
		"Compliants" : "Total Register",
		"Count" : totalCount
	}, {
		"Compliants" : "Pending Application",
		"Count" : newCount
	}, {
		"Compliants" : "Approved",
		"Count" : assignCount
	},
	{
		"Compliants" : "Paid",
		"Count" : paidCount
	}/* , {
		"Compliants" : "Escalated",
		"Count" : closedbyfieldofficer
	},

	{
		"Compliants" : "Not Yet",
		"Count" : closedbyfieldofficer
	},
	{
		"Compliants" : "Online Register",
		"Count" : closedbyfieldofficer
	},
	{
		"Compliants" : "Offline Register",
		"Count" : closedbyfieldofficer
	} */

	];

	fnPlotPieChart(data, "compliantDashboard", "Total Register Count:" + totalCount);
</script>

<c:if test="${!empty sessionScope.complaintID}">
	<div id='successBox'>
		<h2>
			Complaint Registration successful! complaint ID is <span
				style='color: #1589FF'>${sessionScope.complaintID}</span>
		</h2>

	</div>
	<script>
		$("#successBox").dialog({
			resizable : false,
			height : 165,
			width : "60%",
			modal : true,
			position : 'center',
			title : "Information",
			closeOnEscape : false,
			dialogClass : "noclose",
			buttons : {
				"Ok" : function() {
					$(this).dialog("close");
				}
			}
		});
	</script>
</c:if>
<%
	session.setAttribute("complaintID", "");
%>