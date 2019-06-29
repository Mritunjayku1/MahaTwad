<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
	background-color: #0BB09F;
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
	left: 50%;
	height: 50%;
	top: 50%;
	right: 50%;
}
.uploadbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #DAB304;
	left: 50%;
	height: 50%;
	top: 50%;
	right: 50%;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

.imgcontainer1 {
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
	height: 68%;
	overflow: auto;
	background-color: white;
	width: 469px !important;
}
.modalr {
	display: none;
	position: fixed;
	z-index: 1;
	left: 50%;
	top: 50%;
	height: 38%;
	overflow: auto;
	background-color: white;
	width: 469px !important;
}
.modalr td{
padding-top:100px;
padding-left:100px;

}
.modal td{
padding-top:15px;
padding-left:10px;

}
select,input[type="text"]{
width:150px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 0px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

.modalr-content {
	background-color: #fefefe;
	margin: 100% auto 100% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 0px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}


/* The Close Button (x) */
.popupclose {
	position: absolute;
	right: 10px;
	top: 3px !important;
	color: red;
	font-size: 35px;
	font-weight: bold;
}

.popupclose:hover,.popupclose:focus {
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
.row-fluid,.span12{
width:100% !important;
}
/* div[role="dialog"]{
border-radius:15px; 
}
.loginDialog{
	display:none;
	width:400px;
	height:200px;
	padding:0px !important;
	overflow: hidden !important;
} */

 div[role="dialog"]{
/* border-radius:15px;  */
left:410px !important;
}
</style>
<!-- <script src='JS/complaints/searchComplaints.js'></script> -->

<script type="text/javascript">
localStorage.setItem('isFileUploaded', false);
	function getPaymentDetails(id) {
		$('#id01').css({
			'display' : 'block'
		});
		
		$('#appId').val(id);
		$('#estCostAppId').val(id);
		
	}
	function gst() {
		
		
		alert("gst");
		
	}
	
	
	function Widthdraw(id) {
		$('#id01').css({
			'display' : 'block'
		});
		$('#appId').val(id);
		$.ajax({
			type : "POST",
			url : "eeWidthdraw.do",
			data : {
				'appRef' : appRef
			},
			success : function(response) {
				alert(response);
				window.location.reload();

			}
		});

	}
	function eeReject(appRef){
		
		appRef = $('#rejectAppId').val();
		
		var txtremarks = document.getElementById('txtremarks').value;
		if (txtremarks == null || txtremarks == '') {
			alert("Please enter the  remarks !");
			return false;
		}
		
			if(confirm("Are you sure want to Reject?")){
		 $.ajax({
			type : "POST",
			url : "eeRejcted.do",
			data : {
				'appRef' : appRef,'remarks':txtremarks
			},
			success : function(response) {
			//	$('#successMessage').text(response);
				alert(response);
				window.location.reload();

			}
		});
		} 
	}
	function gst(estimationcost){
		var estAmt = document.getElementById('txtestpayment').value;
		var gst=(estAmt*18)/100;
		var total=estAmt+gst;
		var g1=parseInt(gst);
		var t1=parseInt(estAmt);
		var total=g1+t1;
		$("#gst").val(g1);
		$("#totalAmount").val(total);
		
		
	}
	
	function SendEstimationCost(appRef) {
		
		appRef = $('#estCostAppId').val();
		
		var isnearest = document.getElementById("isnearest").options[document.getElementById("isnearest").selectedIndex].value;
		var isnewpipeline = document.getElementById("isnewpipeline").options[document.getElementById("isnewpipeline").selectedIndex].value;
		
		 var estimationCost = document.getElementById('txtestpayment').value;
		 var tentaiveDate = document.getElementById('tentaiveDate').value;
		 var gst = document.getElementById('gst').value;
		 var totalAmount = document.getElementById('totalAmount').value;
		 
		 
		 
		 var isproposal="";
		 if (isnearest == '3') {
				alert("Please select the isnearest option ! ");
				return false;
			}
		 if (isnewpipeline == '3') {
				alert("Please select the isnewpipeline option !");
				return false;
			}
		 if (estimationCost == null || estimationCost == '') {
				alert("Please Enter the  Estimation Cost !");
				return false;
			}
		
		 if (tentaiveDate == null || tentaiveDate == '') {
				alert("Please select the TentaiveDate!");
				return false;
			}
		 
		
		var isFileUploaded =  localStorage.getItem('isFileUploaded');
		if(isFileUploaded != 'true'){
			alert("Please upload the File!");
			return false;
		}
	
		 if(confirm("Are you sure want to Submit?")){
		 $.ajax({
			type : "POST",
			url : "SendEstimationCost.do",
			data : {
			//	'appRef' : appRef,'isnearest':isnearest,'isnewpipeline':isnewpipeline,'isproposal':isproposal,'estimationCost':estimationCost,'tentativeDate':tentaiveDate
				'appRef' : appRef,'isnearest':isnearest,'isnewpipeline':isnewpipeline,'isproposal':isproposal,'estimationCost':estimationCost,'gst':gst,'totalAmount':totalAmount,'tentativeDate':tentaiveDate
			},
			success : function(response) {
				alert(response);
				window.location.reload();

			}
		});
		 }
 
	}
	$(function() {
		$(".inspectionDate").datepicker({
			dateFormat : 'dd-mm-yy',
			changeMonth : true,
			changeYear : true,
			//maxDate : new Date(),
			showOn : "button",
			minDate : 0,
			maxDate : "+2Y",
			buttonImageOnly : true,
			buttonText : "Select date",
			buttonImage : "library/img/datepicker.png",
			showAnim : "slideDown",
		});

		var count=0;
   	 $('#clonedDiv').on('click','.addFileId',function(){
   		  var cloned = $('#fileCloneId').clone();
   		  cloned.find('input[type=file]').val("");
   		  cloned.find('img.deleteFileId').remove();
   		  cloned.attr('id','fileCloneId_'+count++);
   		  cloned.css({'margin-left': '25px'});
     		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId"/>');
   		 $('#clonedDiv').append(cloned);
   		 
   		 
   	  });
   	 $('#clonedDiv').on('click','.deleteFileId',function(){
   		  $(this).parent('div').remove();  
   		});
   	  
   	  $("#btnSubmit").click(function (event) {
   		  event.preventDefault();
    		 var flag = true;
    		  $('input[name=file]').each(function(){
    			 
    			  if($(this).val().length==0){
    				alert("Add File or remove the extra file Upload");
    				  flag = false;
    				  localStorage.setItem('isFileUploaded', false);
    			  }
    			
    		  });
    		  
   		  if(flag){
   			 localStorage.setItem('isFileUploaded', true);
   	        var form = $('#uploadFormId')[0];
   	        var data = new FormData(form);
   	        $("#btnSubmit").prop("disabled", true);

   	        $.ajax({
   	            type: "POST",
   	            enctype: 'multipart/form-data',
   	            url: "uploadMultipleFileByAdmin.do",
   	            data: data,
   	            processData: false,
   	            contentType: false,
   	            cache: false,
   	            timeout: 600000,
   	            success: function (response) {
   	         	alert(response);
   	                $("#btnSubmit").prop("disabled", false);

   	            },
   	        });
   		  }
   	  });
		 $('.loginDialog ').parent('div').css({'width':'450px','top':'500px'});
	   		$('.imgClose').click(function(){
	   			$(this).parents('div.loginDialog').dialog('close');
	   		});
		 $('#uploadbtn').click(function(){
	   			$(".ui-dialog-content").dialog("close");
	   			$( "#uploadDialog" ).dialog({ 'width':'450px','modal':'true'});
	   		}); 
		 $('#uploadbtn').click(function(){
	   			$(".ui-dialog-content").dialog("close");
	   			$( "#uploadDialog" ).dialog({ 'width':'450px','modalr':'true'});
	   		}); 
		$('input[name="approveBtn"]').click(function() {
			var appRef = $(this).attr('id');
			/* var remarks=$(this).closest('tr').find('td:nth-child(8)').find('input[type="text"]').val(); */
			var appRef = appRef;
			alert(appRef);
			//var remarks="test";
			if(confirm("Are you sure want to Reject?")){
			$.ajax({
				type : "POST",
				url : "eeRejcted.do",
				data : {
					'appRef' : appRef
				},
				success : function(response) {
					//$('#successMessage').text(response);
					alert(response);
					window.location.reload();

				}
			});
			}

		});
	});

	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	var modalr = document.getElementById('id02');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modalr) {
			modalr.style.display = "none";
		}
	}
</script>

<table class='table-bordered table table-striped display'
	style='width: 100%; font-size: 28px;'>

	<!-- <tr>
		<td colspan='8'
			style='text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;'>
			After Inspection & Payment Estimation</td>
	</tr> -->
	<tr>
		<td colspan='8'
			style='text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;'>
			After Inspection </td>
	</tr>
</table>



<div id="content" style="margin-left: 0px !important">
	
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
										<th style="color: black !important"><b>Contact Person</b></th>
										<th style="color: black !important"><b>Zone#</b></th>
										<th style="color: black !important"><b>Correspondence
												Address</b></th>
										
										<th style="color: black !important"><b>MLD</b></th>
										<th style="color: black !important"><b></b></th>

										<!--  <th style="color:black !important"></th> -->
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${list.appBean}" var="app">



										<tr class="odd gradeX">

											<td><a href="EEViewForm.do?appId=${app.getAppId()}" style="color: rgb(128,128,128)">${app.getAppId()}</a></td>
											<td>${app.getLegCompName()}</td>
										
											<td>${app.getCategoryType()}</td>
											<td class="center">${app.getContactPersonName()}</td>
											<td class="center"></td>
											<td class="center">${app.getCdoorNo()} ${app.getCplotNo()} ${app.getCstreetName()} ${app.getClocation()} }</td>
											
											<td class="center"></td>
											

											<td><button onclick="getPaymentDetails(this.id)"
													class="paymentClass" id="${app.getAppId()}"
													style="width: auto;">Forward</button>
													
													<button onclick="EERejected(this.id)"
													class="cancelbtn" id="${app.getAppId()}"
													style="width: auto;">Rejected</button>
													
											
												
												
												
												
												
							<div class="imgcontainerr">



													<table id="id02" class="modalr" style="display: none;">


														<tr height="20px"
															style="background-color: #1589FF; color: white; font-weight: bold;">
															<td colspan="2" align="center"
																style="padding: 0px !important">Estimation Cost
																Form <span
																onclick="document.getElementById('id02').style.display='none'"
																class="popupclose" title="Close Modalr">&times;</span>
															</td>
														</tr>

														

														<tr>
															<td><label><b>Remarks </b></label></td>
															<td><input type="textarea" width="100%" height="30px" name="txtremarks"
																id="txtremarks" placeholder="EX: Comments">
																
																</td>
														</tr>
														
														<tr>
														
														<tr>


															<td align="center" colspan="2">
																
																<button onclick="eeReject(this.id)"
																	class="paymentClass" id="${app.getAppId()}"
																	style="width: auto;">Submit</button>

															</td>
														</tr>
													</table>

												</div>					
												
												
												
												
												
												
												
												
												
											

			<div class="imgcontainer">

<input type="hidden" id="estCostAppId" value=""/>
<input type="hidden" id="rejectAppId" value=""/>


													<table id="id01" class="modal" style="display: none;">


														<tr height="30px"
															style="background-color: #1589FF; color: white; font-weight: bold;">
															<td colspan="2" align="center"
																style="padding: 0px !important">Estimation Cost
																Form <span
																onclick="document.getElementById('id01').style.display='none'"
																class="popupclose" title="Close Modal">&times;</span>
															</td>
														</tr>

														<tr>
															<td><label><b>Whether water connection will be given directly from the
nearest Transmission/Distribution main</b></label></td>
															<td><select class="lessWidth" id="isnearest"
																name="isnearest">

																	<option value="3">--Select--</option>
																	<option value="1">Yes</option>
																	<option value="0">No</option>
															</select></td>
														</tr>
														<tr>
															<td><label><b>Whether tendering for new pipeline Required</b></label></td>
															<td>
																<!--  <input type="password" placeholder="Enter Password" name="psw" required> -->
																<select class="lessWidth" id="isnewpipeline"
																name="isnewpipeline">
																	<option value="3">--Select--</option>
																	<option value="1">Yes</option>
																	<option value="0">No</option>
															</select>
															</td>
														</tr>

														<tr>
															<td><label><b>Estimation Cost (Rs) </b></label></td>
															<td><input type="text" name="txtestpayment"
																id="txtestpayment" placeholder="Ex: 4,00,000"
																onkeypress='return event.charCode >= 48 && event.charCode <= 57' onkeyup="gst(txtestpayment)" >
																<br></td>
														</tr>
														<tr>
															<td><label><b>GST Rs (18 %) </b></label></td>
															<td><input type="text" name="gst"
																id="gst"  readonly placeholder="Ex: GST @ 18 %"
																onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
																<br></td>
														</tr>
														<tr>
															<td><label><b>Total Cost (Rs) </b></label></td>
															<td><input type="text" name="totalAmount"
																id="totalAmount" readonly placeholder="Ex: 24,00,000"
																onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
																<br></td>
														</tr>
														<tr>
														<tr>
															<td><label><b>Tentative Connection Date</b></label></td>
															<td><input type="text" name="remarks"
																id="tentaiveDate" readonly placeholder="dd-mm-yyyy"
																class="inspectionDate" style="width: 130px !important;"
																value="" /></td>
														</tr>
														<tr>


															<td align="center" colspan="2">
																<button class="uploadbtn" id="uploadbtn"
																	style="width: auto;">Upload Inspection report</button>
																<button onclick="SendEstimationCost(this.id)"
																	class="paymentClass" id="${app.getAppId()}"
																	style="width: auto;">Submit</button>

															</td>
														</tr>
													</table>

												</div></td>

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
		<script>
			$('#alertBox').show();
			$("#alertBox").dialog({
				resizable : false,
				height : 115,
				width : "30%",
				modalr : true,
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


  <script src="library/assets/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="library/assets/plugins/dataTables/dataTables.bootstrap.js"></script>
     <script>
         $(document).ready(function () {
             $('#dataTables-example').dataTable();
         });
    </script>



			<div class="loginDialog" id="uploadDialog" style="display: none;">
<img class="imgClose" src="library/img/Close_SMS.png" style="width:40px;border-width:0px;float: right; margin-top: -42px; margin-right: -5px; cursor: pointer;">
		<table width="100%" align="center"><tr><td align="center">	
	<form id="uploadFormId" method="POST" enctype="multipart/form-data">
	
		<br/><br/>
		<div id="clonedDiv">
		<div id="fileCloneId" >
		<input type="file" name="file" accept=".doc,.docx,.dwg,.pdf,.txt,.xlsx,.xls"><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId"/><br /> 
		</div>
		</div>
		
		<input type="hidden" name="appId" id="appId" value=''><br /> 
		
		
		<input type="submit" id="btnSubmit" value="Upload">
	</form>
	</td></tr></table>
			</div>
		
											
