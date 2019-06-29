<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <link rel="stylesheet" href="library/assets/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="library/assets/css/main.css" />
    <link rel="stylesheet" href="library/assets/css/theme.css" />
    <link rel="stylesheet" href="library/assets/css/MoneAdmin.css" />
    <link rel="stylesheet" href="library/assets/plugins/Font-Awesome/css/font-awesome.css" />
    <!--END GLOBAL STYLES -->

    <!-- PAGE LEVEL STYLES -->
    <link href="library/assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" />

<style>
 .bg_heading {
	text-align: left;
    font-size: 20px;
    color: white;
    margin-top: -32px;
    margin-left: 135px;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}  
   
input[type="search"]{
height:30px !important;
}
input[type="text"]{
height:25px !important;
}

#successMessage{
	margin-left: 450px;
    z-index: 20000;
    margin-top: 20px;
    position: absolute;
    color: green;
    }
</style>
<script src='JS/complaints/searchComplaints.js'></script>

<script type="text/javascript">

$(function(){
	
	$('.paymentClass').click(function(){
		appId = $(this).attr('id');
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'550px','modal':'true'});
	}); 
	
	$('.closeBtn,.imgClose').click(function(){
		$(".ui-dialog-content").dialog("close");
		
	}); 
	
	$('#userSaveBtnId').click(function(){
		

		var userCommentsId=$('#userCommentsId').val();
		if(userCommentsId == null || userCommentsId=='')
		{
		alert("Please enter remarks !")
		return false;
		} 
		
		if(confirm("Are you sure want to Submit ?")){
			 $.ajax({
				type:"POST",
				url:"mcApprovePayment.do",
				data:{
					'paymentDesc':$('#userCommentsId').val(),
					'appId':appId,'mcUser':$("input[name='mcUser']:checked").val(),'referenceFile':$('#referenceFileId').val(),'referenceDate':$('#referenceDateId').val()},
				success:function(response){
					alert(response);
					window.location.reload();
					
				}
			});
			}
		
	});
	
	
	$(".inspectionDate").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		//maxDate : new Date(),
		showOn : "button",
		minDate : 0,
		maxDate : "+2Y",
		buttonImageOnly : true,
	//	buttonText : "Select date",
		buttonImage : "library/img/datepicker.png",
		showAnim : "slideDown",
	});
	
	
	
	
	/* $('input[name="approveBtn"]').click(function(){
		var appRef = $(this).attr('id');
		var remarks=$(this).closest('tr').find('td:nth-child(8)').find('input[type="text"]').val();
		$.ajax({
			type:"POST",
			url:"ceApprove.do",
			data:{'appRef':appRef,'remarks':remarks},
			success:function(response){
				$('#successMessage').text(response);
				//alert(response);
				
			}
		});
		
	}); */
});
</script>

<div id="addDialog" style="display: none;">


<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Select User Type</h2>
		<table width="80%" align="center">
		<tr>
		<td align="center"><input type="radio" name="mcUser" id="rtcId" value="RTC" checked="checked"/>SE</td>
		<td align="center"><input type="radio" name="mcUser" id="sltcId"  value="SLTC"/>CE</td>
		<td align="center"><input type="radio" name="mcUser" id="boardId" value="Board"/>Board</td>
		</tr>
		
		<tr><td><span><b>Reference File:</b></span></td><td>
			<input placeholder="Reference File" type="text" id="referenceFileId" name="referenceFile"  /></td></tr>

<tr><td><span><b>Reference Date:</b></span></td><td>
			<input placeholder="Ex: DD-MM-YYYY" type="text" class="inspectionDate"  id="referenceDateId" name="referenceDate" readonly="readonly"  style="background-color: lightgrey;"/></td></tr>
		<tr>
		<td><span><b>Remarks:</b></span> <span style="color: red;">*</span></td><td>
		<textarea id="userCommentsId" name="userComments" style="width:78%;height:100%;"></textarea>
		</td>
		
		</tr>
		
		<tr height="10px"></tr>
<tr><td colspan="3" align="center">
				<input type="button" value="Save" id="userSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>
			</td></tr></table>	
		</div>
		

<table class='table-bordered table table-striped display'
	style='width: 100%; font-size: 28px;'>
<tr>
		<td colspan='8'
			style='text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;'>
			View All Application</td>
	</tr>
</table>


                       <!--PAGE CONTENT -->
        <div id="content" style="margin-left: 0px !important">
<div id="successMessage"></div>
            <div class="inner">
                <div class="row">
                    
                </div>

               


                <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                           <!--  <th style="color:black !important"></th> -->
                                            <th style="color:black !important"><b>App Ref#</b></th>
                                            <th style="color:black !important"><b> Name of Company</b></th>
                                             <th style="color:black !important"><b> Contact Person Name</b></th>
                                          <!--   <th style="color:black !important"><b>Category Type</b></th> -->
                                             <th style="color:black !important"><b>Site Address</b></th>
                                            <!--  <th style="color:black !important"><b>Mobile No</b></th>
                                             <th style="color:black !important"><b>Email</b></th> -->
                                             <th style="color:black !important"><b>Division Name</b></th>
                                            <!--  <th style="color:black !important"><b>REQs MLD</b></th>  -->
                                             <th style="color:black !important"><b>Status</b></th>
                                           <th style="color:black !important"><b>SE-Process Status</b></th>
                                                <th style="color:black !important"><b>CE-Process Status</b></th>
                                                 <th style="color:black !important"><b>Board-Process Status</b></th>
                                                 <th></th>
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                     <c:forEach items="${list.appBean}" var="app" >
          
          									 
          									 
          								<tr class="odd gradeX">
          								
          							<td > <a href="EEViewForm.do?appId=${app.getAppId()}" style="color: rgb(128,128,128)">${app.getAppId()}</a></td>
                                            <td>${app.getLegCompName()}</td>
                                            <td>${app.getContactPersonName()}</td>
                                            <%--  <td>${app.getCategoryType()}</td> --%>
                                            <td class="center">${app.getDoorNo()} ${app.getPlotNo()} ${app.getStreetName()},${app.getPinCode()} </td>
                                         <%--  <td>${app.getMobileNum()}</td>
                                          <td>${app.getEmailAddr()}</td> --%>
                                             <td class="center">${app.getDivisionName()}</td>
                                            <%--  <td class="center">${app.getReqMld()}</td> --%>
                                              <td class="center"><textarea  name="managementComments" style="width:100%;height:100%;">${app.getManagementComments()}</textarea></td>
                                                 <td class="center">${app.getMcUser()}</td>
                                           <td class="center">${app.getMcSLTCUser()}</td>
                                            <td class="center">${app.getMcBoardUser()}</td>
                                            <td><input type="button"
													class="paymentClass" id="${app.getAppId()}" value="Add Process Status"
													style="width: auto;"/></td>
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
					<th style='min-width:150px;'><spring:message code="label.recievedDateTime" /></th>
					<th><spring:message code="label.content" /></th>
					<th><spring:message code="label.status" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.results}" var="results">
					<tr>
						<td>
							<form method='post' id="${results.getComplaintID()}" action="editComplaint.do">
								<input type='hidden' name="complaintID" value="${results.getComplaintID()}" /> <a
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
         $(document).ready(function () {
             $('#dataTables-example').dataTable();
         });
    </script>
     <!-- END PAGE LEVEL SCRIPTS -->