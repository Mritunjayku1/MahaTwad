<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
<style>

#menu5{
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}
</style>

<c:choose>
	<c:when test="${!empty list.complaintQueue}">
		<table
			class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
			id='complaintQueueTable'>
			<thead>
				<tr>
					<th><spring:message code="label.complaintId" /></th>
		
					<th><spring:message code="label.channel" /></th>
					<th><spring:message code="label.recievedDateTime" /></th>
					<th><spring:message code="label.content" /></th>
					<th><spring:message code="label.status" /></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.complaintQueue}" var="complaint">
					<tr>
						<td><form:form method='post' id="${complaint.getComplaintID()}"
							commandName="complaintQueue" action="editComplaint.do">
							<form:hidden path="complaintID"
									value="${complaint.getComplaintID()}" /> <a
								href="javascript:fnSubmitForm('${complaint.getComplaintID()}');"><span
									class='count'>${complaint.getComplaintNumber()}</span></a>
						</form:form></td>
						
						<td>${complaint.getComplaintSource()}</td>
						<td>${complaint.getComplaintRegisteredTime()}</td>
						<td>${complaint.getComplaintContent()}</td>
						<td>${complaint.getComplaintStatus()}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
