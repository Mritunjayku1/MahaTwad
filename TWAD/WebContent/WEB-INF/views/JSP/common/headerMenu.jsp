<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
#HDropdown-orange-classic {
	margin: 0;
	padding: 0px;
	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 0%) repeat
		scroll 0 0 rgba(0, 0, 0, 0);
	/* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	background: linear-gradient(from top to bottom, #FFFFFF 0%, #1589FF 0%);
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* For Safari 5.1 to 6.0 */
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* Chrome10+,Safari5.1+ */
	background: -moz-linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* FF3.6+ */
	background: -ms-linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* IE10+ */
	background: -o-linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* Opera 11.10+ */
	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 0%);
	height: 26px;
	width: 100%;
	border: solid 1px #1589FF;
	border-width: 1px 1px 1px 0;
	background: -o-linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 0%) repeat
		scroll 0 0 rgba(0, 0, 0, 0);
}

#HDropdown-orange-classic li {
	display: inline;
	position: relative;
	float: left;
	z-index: 1;
}

#HDropdown-orange-classic li a {
	display: block;
	float: left;
	height: 26px;
	line-height: 26px;
	padding: 0 25px;
	text-decoration: none;
	color: #FFFFFF;
	font-weight: bold;
	font-size: 13px;
	border-left: solid 1px #E6D9D9;
}

#HDropdown-orange-classic li a:hover {
	/* 	color: #FFFFFF; */
	/* 	background: #FFFFFF; */
	
}

#HDropdown-orange-classic li ul {
	margin: 0;
	line-height: none;
	position: absolute;
	top: 23px;
	left: 0;
	border: solid 1px #E6D9D9;
	border-width: 0px 1px 1px 1px;
	width: 250px;
	display: none;
	background: #FFFFFF;
}

#HDropdown-orange-classic li:hover ul {
	display: block;
	/* 	background-color:#FFFFFF; */
}

#HDropdown-orange-classic li a:hover {
	/* 	color: #FFFFFF; */
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}

#HDropdown-orange-classic li ul li {
	display: block;
	border-bottom: solid 1px #dbdcd9;
	width: 250px;
	background: url(library/img/menubg.jpg) repeat-x top no-repeat 3px 12px;
	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 10%) repeat
		scroll 0 0 rgba(0, 0, 0, 0);
	/* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #FFFFFF 1%, #1589FF 10%);
	background: linear-gradient(from top to bottom, #FFFFFF 0%, #1589FF 50%);
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	/* For Safari 5.1 to 6.0 */
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	/* Chrome10+,Safari5.1+ */
	background: -moz-linear-gradient(top, #FFFFFF 1%, #1589FF 10%);
	/* FF3.6+ */
	background: -ms-linear-gradient(top, #FFFFFF 1%, #1589FF 50%); */
	/* IE10+ */
	/* 	background: -o-linear-gradient(top, #FFFFFF 1%, #1589FF 50%); */
	/* Opera 11.10+ */
	/* 	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 50%); */
	padding: 0 0 0 1px;
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	/* For Safari 5.1 to 6.0 */
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	/* Chrome10+,Safari5.1+ */
	background: -moz-linear-gradient(top, #FFFFFF 1%, #1589FF 10%);
	cursor: pointer;
}

#HDropdown-orange-classic li ul li:HOVER {
	display: block;
	border-bottom: solid 1px #dbdcd9;
	width: 250px;
	/* 	background: #85807F; */
	background: #E05400;
	color: #FFFFFF;
	padding: 0 0 0 1px;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
	cursor: pointer;
}

#HDropdown-orange-classic li ul li:last-child {
	border-bottom: 0px;
}

#HDropdown-orange-classic li ul a {
	border-width: 0px;
	/* 	color: #FFFFFF; */
	padding: 0 1px 0 10px;
	background-color: transparent;
}

#HDropdown-orange-classic li:hover ul li a {
	color: #FFFFFF;
}

#HDropdown-orange-classic li ul li a:hover {
	/* 	color: #FFFFFF; */
	font-size: 13px;
}
</style>


<div>
	<ul id="HDropdown-orange-classic">
		<li><a href="home.do"><img src='library/img/home.png'/></a>
		<li><a href="dashboard.do" id='menu1' >Coxcxcxmmittinew Center Dashboard</a> <!-- 			<ul> -->
			<!--  			<li><a href="studentList.do">Student Details</a></li> --> <!-- 				<li><a href="studentRegistration.do">Student Registration</a></li> -->
			<!-- 			</ul> --></li>
		<li><a href="registerComplaint.do" id='menu2'>EERegister Status</a> <!-- 			<ul> -->
			<!-- 				<li><a href="viewResult.do">View Result</a></li> --> <!-- 			</ul> -->
		</li>
		<li><a href="registerComplaint.do" id='menu2'>EEApproved Status</a> <!-- 			<ul> -->
			<!-- 				<li><a href="viewResult.do">View Result</a></li> --> <!-- 			</ul> -->
		</li>
		<li><a href="registerComplaint.do" id='menu2'>Pending Status</a> <!-- 			<ul> -->
			<!-- 				<li><a href="viewResult.do">View Result</a></li> --> <!-- 			</ul> -->
		</li>
		<li><a href="registerComplaint.do" id='menu2'>Cancelled Status</a> <!-- 			<ul> -->
			<!-- 				<li><a href="viewResult.do">View Result</a></li> --> <!-- 			</ul> -->
		</li>
		<li><a href="searchComplaint.do" id='menu3'>Search Application</a> <!-- 			<ul> -->
			<!-- 				<li><a href="timeTable.do">Manage TimeTable</a></li> --> <!-- 				<li><a href="viewEditTimeTable.do">View and Edit Timetable</a></li> -->
			<!-- 			</ul>  --></li>
<!-- 		<li><a href="pendingIVRCompliants.do">Pending IVR Complaints</a> -->
			<!-- 			<ul> --> <!-- 				<li><a href="attendance.do">Attendance Dashboard</a></li> -->
			<!-- 				<li><a href="attendanceHistoryDashboard.do">Attendance History</a></li> -->
			<!-- 			</ul></li> -->
		<!-- <li><a href="assignComplaint.do"  id='menu4'> --></a> <!-- 			<ul> -->
			<!-- 				<li><a href="registerComplaints.do">Register Complaints</a></li> -->
			<!-- 				<li><a href="trackComplaints.do">Track Complaints</a></li> -->
			<!-- 				<li><a href="viewComplaints.do">View Complaints</a></li> -->
			<!-- 			</ul>--></li>
		<!-- <li><a href="reviewCompliant.do"  id='menu5'></a>  --><!-- 			<ul> -->
			<!-- 				<li><a href="postSuggestion.do">Post Suggestion</a></li> -->
			<!-- 				<li><a href="viewSuggestions.do">View Suggestions</a></li> -->

			<!--  			</ul> --></li>
<!-- 		<li><a href="exemptionReport.do">Exemption Report</a> 			<ul> -->
			<!-- 				<li><a href="postSuggestion.do">Post Suggestion</a></li> -->
			<!-- 				<li><a href="viewSuggestions.do">View Suggestions</a></li> -->

			<!--  			</ul></li> -->
<!-- 		<li><a href="viewCompliant.do">View Complaints</a> -->
<!-- 			<ul> -->
<!-- 				<li><a href="smsSend.do">SendSms</a></li> -->
<!-- 				<li><a href="ReceiveSms.do">ReceiveSms</a></li> -->
<!-- 			</ul></li> -->
	</ul>
	<!-- 		<li><a href="#">Change password</a></li> -->


<!-- 	</ul> -->
</div>
<br>