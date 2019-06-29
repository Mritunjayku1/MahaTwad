-<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="library/assets/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="library/assets/css/main.css" />
<link rel="stylesheet" href="library/assets/css/theme.css" />
<link rel="stylesheet" href="library/assets/css/MoneAdmin.css" />
<link rel="stylesheet"
	href="library/assets/plugins/Font-Awesome/css/font-awesome.css" />
<!--END GLOBAL STYLES -->

<!-- PAGE LEVEL STYLES -->
<link href="library/assets/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />



<script type="text/javascript">

function getPaymentDetails(id){
	$('#id01').css({'display':'block'});
	$('#appId').val(id);
	alert(id);
}


function Widthdraw(id){
	$('#id01').css({'display':'block'});
	$('#appId').val(id);
	$.ajax({
		type : "POST",
		url : "eeWidthdraw.do",
		data : {
			'appRef' : appRef
		},
		success : function(response) {
			$('#successMessage').text(response);
			//alert(response);

		}
	});
	
}
	function finalPaymentpaid(appRef) {
		//var appRef = $(this).attr('id');
		alert("1"+appRef);
		$.ajax({
			type : "POST",
			url : "eeRejcted.do",
			data : {
				'appRef' : appRef
			},
			success : function(response) {
				$('#successMessage').text(response);
				//alert(response);

			}
		});

	}
	$(function() {

		$('input[name="approveBtn"]').click(function() {
			var appRef = $(this).attr('id');
			/* var remarks=$(this).closest('tr').find('td:nth-child(8)').find('input[type="text"]').val(); */
			var appRef = appRef;
			alert(appRef);
			//var remarks="test";
			$.ajax({
				type : "POST",
				url : "eeRejcted.do",
				data : {
					'appRef' : appRef
				},
				success : function(response) {
					$('#successMessage').text(response);
					//alert(response);

				}
			});

		});
	});

	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>


<style>



/* Full-width input fields */
input[type=text],input[type=password] {
	width: 20%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	/* color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 15%; */
	width: auto;
	padding: 10px 18px;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 50%;
	top: 50%;
	overflow: auto;
	background-color: white;
	width: 600px !important;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover,.close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 30%;
	}
}











#menu3 {
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}

input[type="search"] {
	height: 30px !important;
}

input[type="text"] {
	height: 25px !important;
}

#successMessage {
	margin-left: 450px;
	z-index: 20000;
	margin-top: 20px;
	position: absolute;
	color: green;
}
</style>
<script src='JS/complaints/searchComplaints.js'></script>

<script type="text/javascript">
	$(function() {
		$('input[name="approveBtn"]')
				.click(
						function() {
							var appRef = $(this).attr('id');
							var initialPaymentCost = $(this).closest('tr')
									.find('td:nth-child(8)').find(
											'input[type="text"]').val();

							if (initialPaymentCost == null
									|| initialPaymentCost == '') {
								alert("Please enter Payment Cost !")
								return false;
							}
							$.ajax({
								type : "POST",
								url : "eeSendInitialPatment.do",
								data : {
									'appRef' : appRef,
									'initialPaymentCost' : initialPaymentCost
								},
								success : function(response) {
									$('#successMessage').text(response);
									//alert(response);

								}
							});

						});
	});
</script>

<table class='table-bordered table table-striped display'
	style='width: 100%; font-size: 28px;'>

	<tr>
		<td colspan='8'
			style='text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;'>
			Application Tracking</td>
	</tr>
</table>



<!--PAGE CONTENT -->
<div id="content" style="margin-left: 0px !important">
	<div id="successMessage"></div>
	<div class="inner">
		<div class="row"></div>




		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
							


								<thead>
									<tr>
										<!--  <th style="color:black !important"></th> -->
										<th style="color: black !important"><b>App Ref#</b></th>
										<th style="color: black !important"><b> Name of
												Company</b></th>
										<th style="color: black !important"><b>Category Type</b></th>

										<th style="color: black !important"><b>Zone#</b></th>
										<th style="color: black !important"><b>Correspondence
												Address</b></th>

										<th style="color: black !important"><b>Registered
												Date</b></th>
										<th style="color: black !important"><b>Prcossing Fee</b></th>
										<th style="color: black !important"><b>Decision</b></th>
										
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${list.appBean}" var="app">



										<tr class="odd gradeX">
											<%-- <c:set var="count" value="${count+1}" scope="page"/>  --%>
											<%-- <td class="center"><input type="radio" name="radio" id="ceRadio_${count}"/></td> --%>
											<td><a href="MCViewForm.do?appId=${app.getAppId()}">${app.getAppId()}</a></td>
											<td>${app.getLegCompName()}</td>
											<%--  <td>${app.getDivId()}</td> --%>
											<td>${app.getCategoryType()}</td>

											<td class="center">${app.getCmwssbZoneNum()}</td>
											<td class="center">${app.getCorrespondenceAddr()}</td>
											<td class="center">${app.getCreateDate()}</td>
											<td class="center">${app.getRemarks()}</td>

											
											<%-- <td class="center"><input type="button"
												name="approveBtn" id="${app.getAppId()}" value="Submit" /></td> --%>
												
												<td><button
													onclick="getPaymentDetails(this.id)" class="paymentClass" id="${app.getAppId()}"
													style="width: auto;">Payment</button>
													
													
												<button onclick="Widthdraw(this.id)"
													style="width: auto;" class="cancelbtn" id="${app.getAppId()}" >WithDraw</button></td>
									
												<div id="id01" class="modal">

												<form class="modal-content animate"
													action="finalPaymnet.do">
													
													<div class="imgcontainer">
														<span
															onclick="document.getElementById('id01').style.display='none'"
															class="close" title="Close Modal">&times;</span>

													</div>

													<div class="container">

															<input type="text" value="" id="appId"/>

														



                                                            <label><b>PAYMENT COST (Rs) </b></label><input
															type="text" name="txtestpayment"><BR>
															<label><b>DD NO </b></label><input
															type="text" name="txtestpayment"><BR>
															<label><b>BANK NAME </b></label><input
															type="text" name="txtestpayment"><BR>
															 <label><b>BRANCH NAME </b></label><input
															type="text" name="txtestpayment">
														<!-- <button type="submit">Submit</button> -->
<button  name="finalPaymentpaid" onclick="finalPaymentpaid('${app.getAppId()}')"
													style="width: auto;" class="Button" id="${app.getAppId()}" >Submit</button>


														<div class="container">
															<button type="button"
																onclick="document.getElementById('id01').style.display='none'"
																class="cancelbtn">Cancel</button>

														</div>
													</div>
												</form>
											</div>
										</tr>

									</c:forEach>

								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>


	</div>




</div>
<!--END PAGE CONTENT -->
<c:choose>
	<c:when test="${!empty list.results}">

		<table
			class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
			id='tblSearchcomplaintTable'>
			<thead>
				<tr>
					<th><spring:message code="label.complaintNumber" /></th>
					<th><spring:message code="label.channel" /></th>
					<th style='min-width: 150px;'><spring:message
							code="label.recievedDateTime" /></th>
					<th><spring:message code="label.content" /></th>
					<th><spring:message code="label.status" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.results}" var="results">
					<tr>
						<td>
							<form method='post' id="${results.getComplaintID()}"
								action="editComplaint.do">
								<input type='hidden' name="complaintID"
									value="${results.getComplaintID()}" /> <a
									href="javascript:fnSubmitForm('<c:out value="${results.getComplaintID()}"/>');">${results.getComplaintNumber()}</a>
							</form>
						</td>

						<td>${results.getComplaintSourceName()}</td>
						<td>${results.getCreatedDate()}</td>
						<td>${results.getComplaintContent()}</td>
						<td>${results.getComplaintStatusName()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>

		<div id='alertBox' style='display: none;'>
			<h3>No Records found</h3>
		</div>
		<%
			if (request.getParameter("isSumbitted") != null
							&& "Y".equals(request.getParameter("isSumbitted"))) {
		%>
		<script>
			$('#alertBox').show();
			$("#alertBox").dialog({
				resizable : false,
				height : 115,
				width : "30%",
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
		<%
			}
		%>
	</c:otherwise>
</c:choose>


<!-- PAGE LEVEL SCRIPTS -->
<script src="library/assets/plugins/dataTables/jquery.dataTables.js"></script>
<script src="library/assets/plugins/dataTables/dataTables.bootstrap.js"></script>
<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});
</script>
<!-- END PAGE LEVEL SCRIPTS -->