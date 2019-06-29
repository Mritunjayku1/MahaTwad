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

#menu3{
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
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
	$('input[name="approveBtn"]').click(function(){
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
		
	});
});
</script>
<table class='table-bordered table table-striped display' style='width: 100%; font-size: 28px;'>

	<tr>
		<td colspan='8'
			style='text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;'>
			After Inspection</td>
	</tr>
	</table>

<%-- <form:form id="searchComplaint" commandName="searchComplaint"
	action="searchComplaintResult.do" method="Post"
	onsubmit="return validate();">

	<table class='table-bordered table table-striped display'
		style='width: 100%;'>
		<tr>
			<td colspan='4' style='text-align: center; background-color: #B6B6B4; font-size: 17px;height: 10px;color:white;font-weight: bold;'>Search Application</td>
		</tr>
		<tr>
			<td><spring:message code="label.complaintDate" /></td>
			<td><form:input path="complaintRegisteredTime"
					placeholder="DD-MM-YYYY" readonly="true"
					id="complaintRegisteredTime" />
			<td><spring:message code="label.complaintId" /></td>
			<td><form:input path="complaintNumber" /></td>

		</tr>
		<tr>
			<td><spring:message code="label.complaintSource" /></td>
			<td><form:select path="complaintSource">
					<form:option value="">Select</form:option>
					<c:forEach items="${list.Source}" var="Source">
						<form:option value="${Source.getFieldCodeID()}">${Source.getDerivedValue()} </form:option>
					</c:forEach>
				</form:select></td>
			<td><spring:message code="label.MobileNumber" /></td>
			<td><form:input path="complaintSubmitterMobileNo" id="complaintSubmitterMobileNo" class="number" maxlength="10"/></td>
		</tr>

		<tr>

			<td colspan="4" style="text-align: center;"><input type="submit"
				id="btnSubmit" value="<spring:message code="label.btnSubmit"/>">
				<input type="button" id='btnReset'
				value="<spring:message code="label.btnReset"/>"></td>
		</tr>

	</table>
	<input type="hidden" value='N' name='isSumbitted' id='isSumbitted'>
</form:form> --%>
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
                                            <th style="color:black !important">App Ref#</th>
                                            <th style="color:black !important">Category Type</th>
                                            <th style="color:black !important">Division#</th>
                                            <th style="color:black !important">Contact Person</th>
                                             <th style="color:black !important">Zone#</th>
                                            <th style="color:black !important">Correspondence Address</th>
                                            <th style="color:black !important">Is Connection For Alteration</th>
                                            <th style="color:black !important">Remarks</th>
                                            <th style="color:black !important"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                     <c:forEach items="${list.appBean}" var="app" >
          
          									 
          									 
          								<tr class="odd gradeX">
          								<%-- <c:set var="count" value="${count+1}" scope="page"/>  --%>
          								<%-- <td class="center"><input type="radio" name="radio" id="ceRadio_${count}"/></td> --%>
                                            <td>${app.getAppId()}</td>
                                            <td>${app.getCategoryType()}</td>
                                            <td>${app.getDivId()}</td>
                                            <td class="center">${app.getContactPersonName()}</td>
                                            <td class="center">${app.getCmwssbZoneNum()}</td>
                                            <td class="center">${app.getCorrespondenceAddr()}</td>
                                            <td class="center">${app.getIsExistConnectionForAlteration()}</td>
                                            <td class="center"><input type="text" name="remarks" value=""/></td>
                                            <td class="center"><input type="button" name="approveBtn" id="${app.getAppId()}" value="Approve/Reject"/></td>
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