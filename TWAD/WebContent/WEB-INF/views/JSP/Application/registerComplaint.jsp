

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="library/css/tooltip.css" rel="stylesheet">
<script src='JS/complaints/registerComplaint.js'></script>
<script src='JS/complaints/jquery.MultiFile.js'></script>
<script type="text/javascript" src="library/js/jquery.jplayer.min.js"></script>
<link rel="stylesheet" href="library/css/premium-pixels.css"
	type="text/css">


<c:if test="${list.response.getComplaintCategoryID()>0}">
	<style>
.readOnly {
	display: none;
}
</style>
</c:if>

<style>
#menu2 {
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}
</style>

<form:form method="POST" id="registerComplaint" name="registerComplaint"
	commandName="registerComplaint" action='saveComplaintDtls.do'
	enctype="multipart/form-data"
	onsubmit="return fnSaveComplaintDetails();">

	<input type="hidden" id="hdnStatus" name="hdnStatus"
		value="${list.response.getComplaintStatus()}" />
	<%-- 	<input type="text" id="complaintStatus" name="complaintStatus" value="${list.response.getComplaintStatus()}" /> --%>


	<input type="hidden" id="complaintID" name="complaintID"
		value="${list.response.getComplaintID()}" />

	<input type="hidden" id="complaintStatus" name="complaintStatus"
		value="${list.response.getComplaintStatus()}" />

	<table class='table-bordered table table-striped display'
		style='width: 100%;'>

		<tr>
			<td colspan='4'
				style='text-align: center; background-color: #B6B6B4; font-size: 17px; height: 10px; color: white; font-weight: bold;'>Complaint
				Details <span id='collapseSec'> <img id='col'
					src='library/img/up.png' title='Collapse' /></span>
			</td>
		</tr>

		<tr class='readOnly'>
			<td><form:label path="complaintNumber">
					<spring:message code="label.complaintNumber" />
				</form:label></td>
			<td><input type="text" name="complaintNumber"
				id="complaintNumber" readonly="readonly"
				value="${list.response.getComplaintNumber()}"></td>
			<td><form:label path="complaintRegisteredTime">
					<spring:message code="label.complaintDate" />
				</form:label></td>
			<td><input type='text' placeholder='DD-MM-YYYY HH:MM'
				name='complaintRegisteredTime' id='complaintRegisteredTime'
				style='width: 175px;'
				value="${list.response.getComplaintRegisteredTime()}" required /> <form:hidden
					path="complaintRegisteredTime" id='complaintRegisteredTime'
					value="${list.response.getComplaintRegisteredTime()} " /></td>
		</tr>
		<tr class='readOnly'>

			<td><spring:message code="label.complaintReceived" /></td>
			<td><form:select path="complaintSource" id="complaintSource"
					required="true">
					<c:choose>
						<c:when test="${!empty list.response.getComplaintNumber()}">
							<form:option value="${list.response.getComplaintSource()}">${list.response.getComplaintSourceName()} </form:option>
						</c:when>
						<c:otherwise>
							<form:option value="">Select</form:option>
							<c:forEach items="${list.channel}" var="channel">
								<form:option value="${channel.getFieldCodeID()}">${channel.getDerivedValue()} </form:option>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</form:select> <input type="hidden" name="hdnComplaintSource"
				id="hdnComplaintSource"
				value="${list.response.getComplaintSource()}"></td>

			<td><spring:message code="label.complaintantType" /></td>
			<td><form:select path="ComplaintRegisteredBy"
					id="ComplaintRegisteredBy" required="true">
					<form:option value="">Select</form:option>
					<c:forEach items="${list.compliantantType}" var="compliantantType">
						<form:option value="${compliantantType.getFieldCodeID()}">${compliantantType.getDerivedValue()} </form:option>
					</c:forEach>
				</form:select> <input type="hidden" name="hdnComplaintRegisteredBy"
				id="hdnComplaintRegisteredBy"
				value="${list.response.getComplaintRegisteredBy()}"></td>
		</tr>

		<tr class='readOnly'>
			<td>Complaint Category</td>
			<td style='width: 28%;'><form:select path="complaintCategoryID"
					id="complaintCategoryID" required="true" style='width:90%;'>
					<form:option value="">Select</form:option>
					<c:forEach items="${list.viloationType}" var="category">
						<form:option value="${category.getFieldCodeID()}">${category.getDerivedValue()} </form:option>
					</c:forEach>
				</form:select> <input type="hidden" id="complaintCategory_ID"
				value="${list.response.getComplaintCategoryID()}"></td>
			<td><spring:message code="label.violationType" /></td>
			<td><form:select path="complaintViolationTypeID"
					id="complaintViolationTypeID" style='width:400px;' required="true">
					<%-- 			<form:option value="">Select1</form:option> --%>
					<%-- 					<c:forEach items="${list.viloationType}" var="viloationType"> --%>
					<%-- 						<form:option value="${viloationType.getFieldCodeID()}">${viloationType.getDerivedValue()} </form:option> --%>
					<%-- 					</c:forEach> --%>
				</form:select> <input type="hidden" name="hdnViolationType" id="hdnViolationType"
				value="${list.response.getComplaintViolationTypeID()}"></td>
		</tr>
		<tr class='readOnly'>
			<td><spring:message code="label.nameOfComplaintant" /></td>
			<td><input type="text" name="complaintSubmitterName"
				class="character" id="complaintSubmitterName"
				value="${list.response.getComplaintSubmitterName()}" /></td>
			<td><spring:message code="label.mobileNo" /></td>
			<td><input type="text" name="complaintSubmitterMobileNo"
				id="complaintSubmitterMobileNo" class="number" maxlength="12"
				onblur="return isNumberKey(event);"
				value="${list.response.getComplaintSubmitterMobileNo()}">
				&emsp; Location &emsp; <form:select path="locationID"
					value="${list.response.getLocationID()}">
					<c:forEach items="${list.location}" var="location"> --%>
						<form:option value="${location.getFieldCodeID()}">${location.getDerivedValue()} </form:option>
					</c:forEach>
				</form:select> <br> <span id="mobNumErr" class='mobNumErr'></span></td>
		</tr>

		<tr class='readOnly'>
			<td><spring:message code="label.emailId" /></td>
			<td><input type="text" name="complaintSubmitterEmailID"
				value="${list.response.getComplaintSubmitterEmailID()}"
				id="complaintSubmitterEmailID"> <br> <span
				id="emailErr" class='emailErr'></span></td>
			<td><spring:message code="label.complaintantAddress" /></td>
			<td><textarea name="complaintSubmitterAddress"
					id="complaintSubmitterAddress"><c:out
						value="${list.response.getComplaintSubmitterAddress()}"></c:out></textarea></td>
		</tr>
		<tr class='readOnly'>
			<td><spring:message code="label.complaintDes" /></td>
			<td colspan="3"><textarea name="complaintContent"
					style="width: 80%" id="complaintContent"><c:out
						value="${list.response.getComplaintContent()}"></c:out></textarea></td>
		</tr>
		<tr class='readOnly'>


			<td><spring:message code="label.evidenceDoc" />
			<td colspan='3'><input type="file" name="documentPath"
				id="documentPath0"><img src='library/img/file_add.png'
				onclick="AddFileUpload()" /> Add More Files <br>
				<div id="FileUploadContainer"></div></td>
		</tr>

		<tr class='readOnly'>
			<td colspan='4'
				style='text-align: center; font-size: 17px; height: 10px; color: #B6B6B4; font-weight: bold;'>Attached
				By Citizen</td>
		</tr>

		<c:forEach items="${list.fileList}" var="fileList"
			varStatus="fileIndex">
			<c:if test="${fileList.getDocumentOwner()==0}">
				<tr class='readOnly'>

					<td colspan='3' style='text-align: center;'>${fileList.getDocumentPath()}</td>
					<td colspan='1' style='text-align: center;'><input
						type="hidden" value="${fileList.getDocumentPath()}"
						name='attachementPath' /> <a
						href="downloadFile.do?attachementPath=${fileList.getDocumentPath()}"
						title='Download'><img src='library/img/download.png' /></a></td>
				</tr>
			</c:if>
		</c:forEach>


		<c:if test="${list.response.getComplaintStatus()!=5}">
			<tr class='titleHeader'>
				<td style='text-align: center;' colspan='4'><input
					type="submit" id="btnSave"
					value="<spring:message code="label.btnSave"/>" /> <input
					type="reset" id="btnReset" onclick="reset()"
					value="<spring:message code="label.btnReset"/>" /></td>
			</tr>
		</c:if>

		<tr class="assignComplaint" id="assignComp">
			<td colspan='4'
				style='text-align: center; background-color: #B6B6B4; font-size: 17px;'><spring:message
					code="label.AssignComplaint" /></td>
		</tr>
		<c:if test="${list.response.getComplaintStatus()>0}">
			<tr class="assignComplaint">

				<td><spring:message code="label.priority" /></td>
				<td><form:select path="complaintPriority"
						id="complaintPriority" required="true">
						<form:option value="">Select</form:option>
						<c:forEach items="${list.priority}" var="priority">
							<form:option value="${priority.getFieldCodeID()}">${priority.getDerivedValue()} </form:option>
						</c:forEach>
					</form:select> <input type="hidden" name="hdnPriority" id="hdnPriority"
					value="${list.response.getComplaintPriority()}"></td>


				<c:choose>
					<c:when test="${not list.response.getComplaintEscalated()}">
						<td><spring:message code="label.assignTo" /></td>
						<td><form:select path="AssignedOfficerID"
								id="AssignedOfficerID" class="select" required="true">
								<c:forEach items="${list.assignTo}" var="assignTo">
									<form:option value="${assignTo.getLoginDetailID()}">${assignTo.getUserName()} </form:option>
								</c:forEach>

							</form:select> <input type="hidden" name="hdnasignedOfficerID"
							id="hdnasignedOfficerID"
							value="${list.response.getAssignedOfficerID()}"></td>
					</c:when>
					<c:otherwise>
					<td><spring:message code="label.assignTo"/></td>
					<td>${list.escalationTo[0].getAssignedOfficerName()}</td>
<%-- 						<td>${complaint.getAssignedOfficerName()}</td> --%>

					</c:otherwise>

				</c:choose>


			</tr>

			<tr class="assignComplaint">

				<td><spring:message code="label.notificationType" /></td>
				<td colspan="1"><form:select path="notificationType"
						id="notificationType">
						<c:forEach items="${list.notification}" var="notification">
							<form:option value="${notification.getFieldCodeID()}">${notification.getDerivedValue()} </form:option>
						</c:forEach>
					</form:select></td>
				    <c:if test="${list.response.getComplaintEscalated()}">
					<td><spring:message code="label.escalationTime" /></td>
					<td>${list.response.getAgentAssignedTime()}</td>
				</c:if>
			</tr>

		</c:if>
		<tr class="rejectComtsDtls">

			<td><spring:message code="label.rejectReason" /></td>
			<td><form:select path="rejectedReason" id="rejectedReason" onchange="fnRejetctReason(this.value);" >
					<c:forEach items="${list.Reason}" var="Reason">
						<form:option value="${Reason.getFieldCodeID()}">${Reason.getDerivedValue()} </form:option>
					</c:forEach>
				</form:select>
				<br><span style='color:red;' id='reasonErr1'></span>
				</td>

			<td><spring:message code="label.rejectedTime" /></td>
			<td><c:out
					value="${list.response.getComplaintRejectCloseTime()}"></c:out></td>

		</tr>

		<tr class="rejectComtsDtls">
			<td><spring:message code="Label.rejectDesc" /></td>
			<td colspan="3"><textarea name="assignedAgentComments"
					style="width: 88%" id="assignedAgentComments"><c:out
						value="${list.response.getAssignedAgentComments()}"></c:out></textarea></td>
		</tr>


		<tr class="assignComplaint" id="assignBtn">

			<td style='text-align: center;' colspan='4'><input type="submit"
				id="btnSave" value="<spring:message code="label.btnAssign"/>" /> <input
				type="button"
				onclick="showDialog('rejectDialog','Rejection Details',350)"
				id="btnReset" value="<spring:message code="label.btnReject"/>" /></td>
		</tr>

		<tr class="fieldOfficerDtls">
			<td colspan='4'
				style='text-align: center; background-color: #B6B6B4; font-size: 17px;'
				class=' '><spring:message code="label.fieldOffDet" /></td>
		</tr>
		<tr class="fieldOfficerDtls">

			<td><spring:message code="label.fieldOffCommets" /></td>
			<td colspan="3"><textarea name="assignedOfficerComments"
					style="width: 82%" id="assignedOfficerComments" readonly><c:out
						value="${list.response.getAssignedOfficerComments()}"></c:out></textarea></td>
		</tr>
		<tr class="fieldOfficerDtls">
			<td><spring:message code="label.fieldOffCommetsDate" /></td>
			<td colspan="4"><label><c:out
						value="${list.response.getComplaintResolvedTime()}"></c:out></label></td>
		</tr>
		<tr class="fieldOfficerDtls">
			<td colspan='4'
				style='text-align: center; font-size: 17px; height: 10px; color: #B6B6B4; font-weight: bold;'>Attached
				By Officer</td>
		</tr>

		<c:forEach items="${list.fileList}" var="fileList"
			varStatus="fileIndex">
			<c:if test="${fileList.getDocumentOwner()>0}">
				<tr class="fieldOfficerDtls">
					<td colspan='3' style='text-align: center;'>${fileList.getDocumentPath()}</td>
					<td colspan='1' style='text-align: center;'><input
						type="hidden" value="${fileList.getDocumentPath()}"
						name='attachementPath' /> <a
						href="downloadFile.do?attachementPath=${fileList.getDocumentPath()}"
						title='Download'><img src='library/img/download.png' /></a></td>
				</tr>
			</c:if>
		</c:forEach>

		<tr class="agentComtsDtls">
			<td colspan='4'
				style='text-align: center; background-color: #B6B6B4; font-size: 17px;'
				class=' '><spring:message code="label.agentReviewDtls" /></td>
		</tr>
		<tr class="agentComtsDtls">

			<td><spring:message code="label.agentcomments" /></td>
			<td colspan="3"><textarea name="assignedAgentComments"
					style="width: 82%" id="assignedAgentComments"><c:out
						value="${list.response.getAssignedAgentComments()}"></c:out></textarea></td>
		</tr>
		<tr class="agentComtsDtls">
			<td><spring:message code="label.notificationType" /></td>
			<td colspan="4"><form:select path="notificationType"
					id="notificationType">
					<c:forEach items="${list.notification}" var="notification">
						<form:option value="${notification.getFieldCodeID()}">${notification.getDerivedValue()} </form:option>
					</c:forEach>
				</form:select></td>
		</tr>

		<tr class="agentComtsDtls">
			<td><spring:message code="label.publicCanView" /></td>
			<td colspan="4"><form:select path="publicCanView"
					id="publicCanView" required="true">
					<form:option value="1">Yes</form:option>
					<form:option value="0">No</form:option>
				</form:select> <input type="hidden" name="hdnpublicCanView" id="hdnpublicCanView"
				value="${list.response.getPublicCanView()}"></td>

		</tr>

		<tr id="agentBtn">

			<td style='text-align: center;' colspan='4'><input type="button"
				onclick="showDialog('reAssignDialog','Re-Assign Details',350);fnSetValues()"
				id="btnReAssign" value="<spring:message code="label.btnReassign"/>" />
				<input type="button" onclick="fnAgentCloseComplaintDetails()"
				id="btnSave" value="<spring:message code="label.btnCloseCompl"/>" />
				<input type="button"
				onclick="showDialog('rejectDialog','Rejection Details',350)"
				id="btnReset" value="<spring:message code="label.btnReject"/>" /></td>
		</tr>


	</table>
	<form:hidden path="isReject" id="isReject" value="N" />
	<div id="rejectDialog" style="display: none;">

		<table class='table-bordered table table-striped display'>
			<tr>
				<td>Reject Reason</td>
				<td><form:select path="rejectedReason" id="rejectedReason"  onchange="fnRejetctReason(this.value);">
						<form:option value="">Select</form:option>
						<c:forEach items="${list.Reason}" var="Reason">
							<form:option value="${Reason.getFieldCodeID()}">${Reason.getDerivedValue()} </form:option>
						</c:forEach>
					</form:select> <input type="hidden" name="hdnrejectedReason"
					id="hdnrejectedReason" value="${list.response.getRejectedReason()}">
				<br><span style='color:red;' id='reasonErr2'></span>
				</td>
			</tr>
			<tr>
				<td>Reject Comments</td>
				<td><textarea name="rejectCommnets" id="rejectCommnets"></textarea></td>
			</tr>
			<tr>

				<td><spring:message code="label.notificationType" /></td>
				<td colspan="4"><form:select path="notificationType"
						id="notificationType">

						<c:forEach items="${list.notification}" var="notification">
							<form:option value="${notification.getFieldCodeID()}">${notification.getDerivedValue()} </form:option>
						</c:forEach>

					</form:select></td>

			</tr>
			<tr>

				<td colspan="2" style="text-align: center;"><input
					type="button" value='Close Complaint' id="btnRecComp"
					style="display: none;" onclick="fnRejectComplaintDetails()">

					<input type="button" value='Close Complaint' id="btnReviewComp"
					style="display: none;"
					onclick="fnAgentReviewRejectComplaintDetails()"></td>
			</tr>
		</table>
		<label id='rejectedReason_ID'></label>
	</div>
	
	 
	<div id="reAssignDialog" style="display: none;">
  
    
     
        <table class='table-bordered table table-striped display'
            style='width: 100%;'>
            <tr class="assignComplaint">
<%--             <td><spring:message code="label.assignTo" /></td> --%>
          
<!--             <td> -->
            
<!--             	<select name="notificationType"   -->
<!--                         id="reAssignedOfficerID" disabled="disabled"> -->
<%--                         <c:forEach items="${list.assignTo}" var="assignTo"> --%>
<%--                             <option value="${assignTo.getLoginDetailID()}">${assignTo.getUserName()} </option> --%>
<%--                         </c:forEach> --%>
<!--                     </select>             -->
<!--             </td> -->
            
             <c:choose>
					<c:when test="${empty list.escalationTo}">
						<td><spring:message code="label.assignTo" /></td>
						<td><form:select path="AssignedOfficerID"
								id="AssignedOfficerID" class="select" >
								<c:forEach items="${list.assignTo}" var="assignTo">
									<form:option value="${assignTo.getLoginDetailID()}">${assignTo.getUserName()} </form:option>
								</c:forEach>

							</form:select> <input type="hidden" name="hdnasignedOfficerID"
							id="hdnasignedOfficerID"
							value="${list.response.getAssignedOfficerID()}"></td>
					</c:when>
					<c:otherwise>
					<td>Assigned To </td>
					<td>${list.escalationTo[0].getAssignedOfficerName()}</td>
<%-- 						<td>${complaint.getAssignedOfficerName()}</td> --%>

					</c:otherwise>

				</c:choose>
				
	            <td><spring:message code="label.reassignTo" /></td>
	                <td><form:select path="notificationType"
	                        id="disableAssignedOfficerID" class="select" onchange='fnSetValues();' >
	                        <c:forEach items="${list.assignTo}" var="assignTo">
	                            <form:option value="${assignTo.getLoginDetailID()}">${assignTo.getUserName()} </form:option>
	                        </c:forEach>
	
	                    </form:select> <input type="hidden" name="hdnasignedOfficerID"
	                    id="hdnasignedOfficerID"
	                    value="${list.response.getAssignedOfficerID()}"></td>
            </tr>
            <tr class="assignComplaint">
                <td><spring:message code="label.priority" /></td>
                <td><form:select path="notificationType"
                        id="reAssigncomplaintPriority">
                        <form:option value="">Select</form:option>
                        <c:forEach items="${list.priority}" var="priority">
                            <form:option value="${priority.getFieldCodeID()}">${priority.getDerivedValue()} </form:option>
                        </c:forEach>
                    </form:select> <input type="hidden" name="hdnreAssigncomplaintPriority" id="hdnreAssigncomplaintPriority"
                    value="${list.response.getComplaintPriority()}"></td>
                    
                    
                <td><spring:message code="label.notificationType" /></td>
                <td colspan="4"><form:select path="notificationType"
                        id="notificationType">
                        <c:forEach items="${list.notification}" var="notification">
                            <form:option value="${notification.getFieldCodeID()}">${notification.getDerivedValue()} </form:option>
                        </c:forEach>
                    </form:select></td>

                
            </tr>

            <tr class="assignComplaint">

            </tr>
            <tr>
            <td><spring:message code="label.reasonForReAssign" /></td>
            <td><textarea name="reAssignComments" id="reAssignComments"></textarea></td>
            </tr>
            <tr>
            <td></td>
            <td style='text-align: center;' colspan="3"><input type="button"
                id="btnSave" value="<spring:message code="label.btnReassign"/>" onclick="fnreAssign();" /></td>                
            </tr>
            
        </table>

     </div>
<label id='assigned_to'></label>

</form:form>



<script>
	var counter = 1;
	function AddFileUpload() {
		var div = document.createElement('DIV');
		div.innerHTML = '<input id="documentPath' + counter + '" name = "documentPath" type="file" /><img src="library/img/no.png"   name="img"'
				+ counter + '" onclick = "RemoveFileUpload(this)" />';
		document.getElementById("FileUploadContainer").appendChild(div);
		counter++;
	}
	function RemoveFileUpload(div) {
		document.getElementById("FileUploadContainer").removeChild(
				div.parentNode);
	}

	if ($("#hdnpublicCanView").val() == 'true') {
		$('#publicCanView option[value=' + 1 + ']')
				.attr('selected', 'selected');
	} else {
		$('#publicCanView option[value=' + 0 + ']')
				.attr('selected', 'selected');
	}
	
	
	$('#complaintSource option[value=' + $("#hdnComplaintSource").val() + ']')
			.attr('selected', 'selected');
	
	
	
	$(
			'#AssignedOfficerID option[value='
					+ $("#hdnasignedOfficerID").val() + ']').attr('selected',
			'selected');

	$(
			'#ComplaintRegisteredBy option[value='
					+ $("#hdnComplaintRegisteredBy").val() + ']').attr(
			'selected', 'selected');

	$(
			'#complaintCategoryID option[value='
					+ $("#complaintCategory_ID").val() + ']').attr('selected',
			'selected');
	$(
			'#complaintViolationTypeID option[value='
					+ $("#hdnViolationType").val() + ']').attr('selected',
			'selected');

	
	$('#complaintPriority option[value=' + $("#hdnPriority").val() + ']').attr(
			'selected', 'selected');

	$('#rejectedReason option[value=' + $("#hdnrejectedReason").val() + ']')
			.attr('selected', 'selected');

	var complaintStatus = $("#hdnStatus").val();

	if (complaintStatus != null && complaintStatus != ''
			&& complaintStatus == 1) {
		$(".rejectComtsDtls").hide();
		$("#btnRecComp").show();
		$("#assignComplaint").show();
		$(".fieldOfficerDtls").hide();
		$(".titleHeader").hide();
		$(".agentComtsDtls").hide();
		$("#agentBtn").hide();
	} else if (complaintStatus != null && complaintStatus != ''
			&& (complaintStatus == 2 || complaintStatus == 5)) {
		$(".rejectComtsDtls").hide();
		$(".fieldOfficerDtls").hide();
		$(".titleHeader").hide();
		$(".agentComtsDtls").hide();
		$("#assignBtn").hide();
		$("#agentBtn").hide();
	} else if (complaintStatus != null && complaintStatus != ''
			&& complaintStatus == 6) {
		 
		
		$(
				'#reAssignedOfficerID option[value='
						+ $("#hdnasignedOfficerID").val() + ']').attr('selected',
				'selected');
		$('#reAssigncomplaintPriority option[value='
						+ $("#hdnreAssigncomplaintPriority").val() + ']').attr('selected', 
				'selected');
		$(".rejectComtsDtls").hide();
		$("#btnRecComp").hide();
		$("#btnReviewComp").show();
		$(".assignComplaint").show();
		$(".titleHeader").hide();
		$("#assignBtn").hide();
	} else if (complaintStatus != null && complaintStatus != ''
			&& complaintStatus == 7) {
		$(".rejectComtsDtls").hide();
		$(".titleHeader").hide();
		$(".assignComplaint").show();
		$("#assignBtn").hide();
		$(".fieldOfficerDtls").show();
		$(".agentComtsDtls").show();
		$("#agentBtn").hide();
	} else if (complaintStatus != null && complaintStatus != ''
			&& complaintStatus == 4) {
		$(".rejectComtsDtls").show();
		$(".assignComplaint").hide();
		$("#assignComp").show();
		$(".fieldOfficerDtls").hide();
		$(".agentComtsDtls").hide();
		$(".titleHeader").hide();
		$("#agentBtn").hide();
	} else {
		$(".rejectComtsDtls").hide();
		$(".titleHeader").show();
		$("#agentBtn").hide();
		$(".agentComtsDtls").hide();
		$(".assignComplaint").hide();
		$("#assignBtn").hide();
		$(".fieldOfficerDtls").hide();

	}

	function openDialog() {
		$('#rejectDialog').show();
		$("#rejectDialog").dialog({
			resizable : false,
			height : 300,
			width : "30%",
			modal : true,
			position : 'center',
			title : "Information",
			closeOnEscape : false,
			dialogClass : "noclose"
		});
	}
</script>

<!-- <div id="skin-wrapper" data-skin-name="premium-pixels" -->
<!-- 	style='display: none;'> -->
<!-- 	<div id="audioPlayer" class="jp-jplayer"></div> -->
<!-- 	<div id="jp_container" class="jp-audio"> -->
<!-- 		<div class="jp-type-playlist"> -->
<!-- 			<div id="jp_container_1"> -->
<!-- 				<div class="jp-gui jp-interface"> -->
<!-- 					<ul class="jp-controls"> -->
<!-- 						<li><a href="#" class="jp-previous" tabindex="1">previous</a></li> -->
<!-- 						<li><a href="#" class="jp-play" tabindex="1">play</a></li> -->
<!-- 						<li><a href="#" class="jp-pause" tabindex="1">pause</a></li> -->
<!-- 						<li><a href="#" class="jp-next" tabindex="1">next</a></li> -->
<!-- 						<li><a href="#" class="jp-stop" tabindex="1">stop</a></li> -->
<!-- 						<li><a href="#" class="jp-mute" tabindex="1" title="mute">mute</a></li> -->
<!-- 						<li><a href="#" class="jp-unmute" tabindex="1" title="unmute">unmute</a></li> -->
<!-- 						<li><a href="#" class="jp-volume-max" tabindex="1" -->
<!-- 							title="max volume">max volume</a></li> -->
<!-- 					</ul> -->
<!-- 					<div class="jp-progress" style='background-color: #F5F5F5'> -->

<!-- 						<div class="jp-seek-bar" > -->
<!-- 						<div class="jp-play-bar"></div> -->
<!-- 						 </div> -->

<!-- 					</div> -->
<!-- 					<div class="jp-volume-bar"> -->
<!-- 						<div class="jp-volume-bar-value"></div> -->
<!-- 					</div> -->
<!-- 					<div class="jp-time-holder"> -->
<!-- 						<div class="jp-current-time"></div> -->
<!-- 						<div class="jp-duration"></div> -->

<!-- 					</div> -->
<!-- 					<ul class="jp-toggles"> -->
<!-- 						<li><a href="#" class="jp-shuffle" tabindex="1" -->
<!-- 							title="shuffle">shuffle</a></li> -->
<!-- 						<li><a href="#" class="jp-shuffle-off" tabindex="1" -->
<!-- 							title="shuffle off">shuffle off</a></li> -->
<!-- 						<li><a href="#" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li> -->
<!-- 						<li><a href="#" class="jp-repeat-off" tabindex="1" -->
<!-- 							title="repeat off">repeat off</a></li> -->
<!-- 					</ul> -->
<!-- 				</div> -->
<!-- 			</div> -->


<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->



