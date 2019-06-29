

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
			style='text-align: center; background-color: #B6B6B4; font-size: 17px; height: 10px; color: white; font-weight: bold;'>Committi
			Center Dashboard</td>
	</tr>
	<tr>
		<form:form method='post' id="0" commandName="dashboardForm"
			action="complaintQueue.do">
			<td><spring:message code="label.totalComplaints" /> <form:hidden
					path="complaintStatus" value="0" /> <a
				href="javascript:fnSubmitForm('0');"><span class='count'>${list.count.getTotalComplaints()}</span></a>
				<input type="hidden" id='totalCount' name='totalCount'
				value="${list.count.getTotalComplaints()}" /></td>
		</form:form>

		<form:form method='post' id="1" commandName="dashboardForm"
			action="complaintQueue.do">
			<td><spring:message code="label.newComplaints" /> <form:hidden
					path="complaintStatus" value="1" /> <a
				href="javascript:fnSubmitForm('1');"><span class='count'>${list.count.getNewComplaints()}</span></a>
				<input type="hidden" id='newCount' name='newCount'
				value="${list.count.getNewComplaints()}" /></td>
		</form:form>

		<form:form method='post' id="2" commandName="dashboardForm"
			action="complaintQueue.do">
			<td><spring:message code="label.assignedComplaints" /> <form:hidden
					path="complaintStatus" value="2" /> <a
				href="javascript:fnSubmitForm('2');"><span class='count'>${list.count.getAssignedComplaints()}</span></a>
				<input type="hidden" id='assignCount' name='assignCount'
				value="${list.count.getAssignedComplaints()}" /></td>
		</form:form>

		<form:form method='post' id="5" commandName="dashboardForm"
			action="complaintQueue.do">
			<td><spring:message code="label.acknowledgedCount" /> <form:hidden
					path="complaintStatus" value="5" /> <a
				href="javascript:fnSubmitForm('5');"><span class='count'>${list.count.getAcknowledgeCount()}</span></a>
				<input type="hidden" id='acknowledgedCount' name='acknowledgedCount'
				value="${list.count.getAcknowledgeCount()}" /></td>
		</form:form>



		<form:form method='post' id="6" commandName="dashboardForm"
			action="complaintQueue.do">
			<td><spring:message code="label.closedbyfieldofficer" /> <form:hidden
					path="complaintStatus" value="6" /> <a
				href="javascript:fnSubmitForm('6');"><span class='count'>${list.count.getClosedByFieldOfficer()}</span></a>
				<input type="hidden" id='closedbyfieldofficer'
				name='closedbyfieldofficer'
				value="${list.count.getClosedByFieldOfficer()}" /></td>
		</form:form>

		<form:form method='post' id="10" commandName="dashboardForm"
			action="complaintQueue.do">
			<td><spring:message code="label.esclation" /> <form:hidden
					path="complaintStatus" value="10" /> <a
				href="javascript:fnSubmitForm('10');"><span class='count'>${list.count.getEscalationCount()}</span></a>
				<input type="hidden" id='escalationCount' name='escalationCount'
				value="${list.count.getEscalationCount()}" /></td>
		</form:form>
		<form:form method='post' id="7" commandName="dashboardForm"
			action="complaintQueue.do">
			<td><spring:message code="label.resolved" /> <form:hidden
					path="complaintStatus" value="7" /> <a
				href="javascript:fnSubmitForm('7');"><span class='count'>${list.count.getRelovedCount()}</span></a>
				<input type="hidden" id='resolvedCount' name='resolvedCount'
				value="${list.count.getRelovedCount()}" /></td>
		</form:form>
	</tr>
	<tr>
 
		<form:form method='post' id="4" commandName="dashboardForm"
			action="complaintQueue.do">
			<td colspan='2'><spring:message code="label.rejected" /> <form:hidden
					path="complaintStatus" value="4" /> <a
				href="javascript:fnSubmitForm('4');"><span class='count'>${list.count.getRejectedCount()}</span></a>
				<input type="hidden" id='rejectedCount' name='rejectedCount'
				value="${list.count.getRejectedCount()}" /></td>
		</form:form>

		<td colspan="5">User Feedback: <span class='td'>Yes
		</span> <span class='count1'>${list.count.getYesCount()}</span> <span
			class='td'>No </span> <span class='count1'>${list.count.getNoCount()}</span>
			<span class='td'>NA </span> <span class='count1'>${list.count.getNACount()}</span>
		</td>


	</tr>


	<input type="hidden" id='totalChannelCount' name='totalChannelCount'
		value="${list.count.getTotalChannelCount()}" />
	<input type="hidden" id='SMSChannelCount' name='SMSChannelCount'
		value="${list.count.getSMSChannelCount()}" />
	<input type="hidden" id='IVRChannelCount' name='EmailChannelCount'
		value="${list.count.getIVRChannelCount()}" />
	<input type="hidden" id='EmailChannelCount' name='AppChannelCount'
		value="${list.count.getEmailChannelCount()}" />
	<input type="hidden" id='mobileAppChannelCount'
		name='mobileAppChannelCount'
		value="${list.count.getMobileAppChannelCount()}" />
	<input type="hidden" id='walkinCount' name='walkinCount'
		value="${list.count.getWalkinCount()}" />
		<input type="hidden" id='tappalCount' name='tappalCount'
        value="${list.count.getTappalCount()}" />
        
        <c:set var="total" value="${0}"/> 
        <c:set var="count" value="0" scope="page"/> 
       <c:forEach items="${list.ap}" var="category" >
            <c:set var="count" value="${count+1}" scope="page"/> 
           <input type="hidden" id="category${count}" value="${category.getCategoryCount()}" />
          <c:set var="total" value="${total + category.getCategoryCount()}"/>
      
    </c:forEach>
        
        <input type="hidden"  value="${total}" id="categoryTotal"/>
        
        

</table>
<br>
<br>
<div>
	<div id="compliantDashboard"
		style="width: 32%; height: 400px; float: left;"></div>
	 <div id="categoryDashboard"
        style="width: 32%; height: 400px; float:left;margin-left: 2%;"></div>
	<div id="complaintSummaryChart"
		style="width: 32%; height: 400px; float: left; margin-left: 2%;"></div>
</div>
<div>
   
</div>
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
    
    var totalCount = 10;
	var newCount = 20;
	var assignCount = 30;
	var acknowledgedCount =20;
	var closedbyfieldofficer = 40;
	var resolvedCount = 20;
	var rejectedCount = 30;
	
	var categoryTotal=20;
    var categoryMD=40;
    var categoryGF=50;
    var categoryLI=60;
    var categoryPO=20;
    var categoryDI=30;
    var categoryVE=30;
    var categoryPA=80;
    var categoryPO=40;
    var categoryEL=8
    var category10=20;
    var category11=10;
    var category12=20;
    

	var data = [   {
		"Compliants" : "Pending",
		"Count" : newCount
	}, {
		"Compliants" : "Approved",
		"Count" : assignCount
	}, {
		"Compliants" : "Rejected",
		"Count" : acknowledgedCount
	}, {
		"Compliants" : "Canceled",
		"Count" : closedbyfieldofficer
	},
	{
		"Compliants" : "Completed ",
		"Count" : rejectedCount
	},
	 {
			"Compliants" : "Not Yet",
			"Count" : closedbyfieldofficer
		}
	/* , 
	{
		"Compliants" : "Resolved",
		"Count" : resolvedCount
	}, {
		"Compliants" : "NRC Water ",
		"Count" : rejectedCount
	}  */
	
	];

	fnPlotPieChart(data, "compliantDashboard", "Complaint Count:"+totalCount);
	
	
	

    
	var datas = [ {
        "Compliants" : "Pending",
        "Count" : categoryMD
    }, {
        "Compliants" : "Approved",
        "Count" : categoryGF
    }, {
        "Compliants" : "Rejected",
        "Count" : categoryLI
    }, {
        "Compliants" : "Canceled",
        "Count" : categoryPO
    }, {
        "Compliants" : "Completed",
        "Count" : categoryDI
    }, {
        "Compliants" : "Not Yet",
        "Count" : categoryVE
    }/* , {
        "Compliants" : "Paid News",
        "Count" : categoryPA
    }, 
    {
        "Compliants" : "Political",
        "Count" : categoryPO
    },
    {
        "Compliants" : "Electoral/EPIC",
        "Count" : categoryEL
    },
    {
        "Compliants" : "Political Parties",
        "Count" : category10
    },
    {
        "Compliants" : "Candidates",
        "Count" : category11
    },
    {
        "Compliants" : "Others",
        "Count" : category12
    } */
   
    ];
	

	
	fnPlotPieChart(datas, "categoryDashboard", "Category Count:"+$("#categoryTotal").val());
	
	

	/* var totalChannelCount = parseInt($('#totalChannelCount').val());
	var SMSChannelCount = parseInt($('#SMSChannelCount').val());
	var EmailChannelCount = parseInt($('#EmailChannelCount').val());
	var IVRChannelCount = parseInt($('#IVRChannelCount').val());
	var mobileAppChannelCount = parseInt($('#mobileAppChannelCount').val());
	var walkinCount = parseInt($('#walkinCount').val());
	var tappalCount = parseInt($('#tappalCount').val());
 */
 var totalChannelCount =20;
	var SMSChannelCount = 30;
	var EmailChannelCount =40;
	var IVRChannelCount = 50;
	var mobileAppChannelCount =20;
	var walkinCount = 60;
	var tappalCount =70;
 
 
	var channelData = [ {
		"Compliants" : "Pending",
		"Count" : tappalCount
	}, {
		"Compliants" : "Approved",
		"Count" : walkinCount
	}, {
		"Compliants" : "Rejected",
		"Count" : SMSChannelCount
	}, {
		"Compliants" : "Canceled",
		"Count" : EmailChannelCount
	}, {
		"Compliants" : "Completed",
		"Count" : IVRChannelCount
	}, {
		"Compliants" : "Not Yet",
		"Count" : mobileAppChannelCount
	},
	 {
		"Compliants" : "Withdraw",
		"Count" : mobileAppChannelCount
	}

	];

	fnPlotPieChart(channelData, "complaintSummaryChart", "Total Complaint : "
			+ totalChannelCount);
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