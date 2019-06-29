

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="library/css/tooltip.css" rel="stylesheet">
<script src='JS/complaints/registerComplaint.js'></script>
<form:form method="GET" id="SendSMSses"
	commandName="SendSMSses" action='SendSMS.do'
	enctype="multipart/form-data">

	<table class='table-bordered table table-striped display'
		style='width: 100%;'>




		<tr>
			<td><spring:message code="label.To" /></td>
			<td><input type="text" name="nameOfComplaintant" required
				class="character" id="nameOfComplaintant" /></td>

		</tr>

		<tr>
			<td><spring:message code="label.message" /></td>
			<td><form:textarea path="complaintantAddress" required="true"
					id="complaintantAddress"></form:textarea></td>

		</tr>



		<tr class='titleHeader'>
			<td></td>
			<td style='text-align: center;' colspan='6'><input
				type="submit" placeholder="9999999999" id="btnSave"
				value="<spring:message code="label.btnSend"/>" /> <input
				type="button" id="btnReset"
				value="<spring:message code="label.btnReset"/>" /></td>
		</tr>

	</table>



</form:form>

