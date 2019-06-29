<!-- All Complaint Queue- EC
	
	Created by Vijaya Meena	On 02-June-2017
	This page to show complaint details		  
-->

<%@page import="org.apache.jasper.tagplugins.jstl.core.Choose"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:choose>
	<c:when test="${list.complaintBean.getComplaintStatus()==6}">
		<style>
#menu5 {
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}
</style>
	</c:when>
	<c:otherwise>
		<style>
#menu4 {
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}
</style>
	</c:otherwise>

</c:choose>


<%
	String totalCount = request.getParameter("totalCount");
	String newCount = request.getParameter("newCount");
	String assignCount = request.getParameter("assignCount");
	String closedCount = request.getParameter("closedCount");
	String escalationCount= request.getParameter("escalationCount");
 
	if (totalCount != null) {
%>

 

<h2
	style='text-align: center; background-color: #B6B6B4; font-size: 17px; color: white; font-weight: bold;'>Complaint
	Details</h2>


<c:choose>
	<c:when test="${!empty list.complaintQueue}">
		<table
			class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
			id='complaintQueueTable'>
			<thead>
				<tr>
					<th style='width:60px;'><spring:message code="label.complaintNumber" /></th>
					<th><spring:message code="label.channel" /></th>
					<th>Status</th>
					<th><spring:message code="label.recievedDateTime" /></th>
					<th>Category</th>

					<th><spring:message code="label.agencyid" /></th>
					<th><spring:message code="label.agencytime" /></th>
					<th><spring:message code="label.cloesedby" /></th>
					<th><spring:message code="label.resolvedtime" /></th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.complaintQueue}" var="complaint">
					<tr>
						<td><form:form method='post'
								id="${complaint.getComplaintID()}" commandName="complaintQueue"
								action="editComplaint.do">
								<form:hidden path="complaintID"
									value="${complaint.getComplaintID()}" />
								<a
									href="javascript:fnSubmitForm('${complaint.getComplaintID()}');"><span
									class='count'>${complaint.getComplaintNumber()}</span></a>
							</form:form></td>

						<td>${complaint.getComplaintSourceName()}</td>
						<td>${complaint.getComplaintStatusName()}</td>
						<td>${complaint.getCreatedDate()}</td>
						<td>${complaint.getComplaintCategoryName()}</td>
						<td>${complaint.getAssignedAgentName()}</td>
						<td>${complaint.getAgentAssignedTime()}</td>
						<td>${complaint.getComplaintClosedName()}</td>
						<td>${complaint.getComplaintResolvedTime()}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>

<%
	}

	else if (newCount != null) {
%>
 
<h2
	style='text-align: center; background-color: #B6B6B4; font-size: 17px; color: white; font-weight: bold;'>Complaints
	Pending</h2>

<c:choose>
	<c:when test="${!empty list.complaintQueue}">
		<table
			class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
			id='complaintQueueTable'>
			<thead>
				<tr>
					<th><spring:message code="label.complaintNumber" /></th>
					<th><spring:message code="label.channel" /></th>
					<th>Status</th>
					<th>Category</th>
					<th><spring:message code="label.recievedDateTime" /></th>
					<%-- 					<th><spring:message code="label.status" /></th> --%>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.complaintQueue}" var="complaint">
					<tr>
						<td><form:form method='post'
								id="${complaint.getComplaintID()}" commandName="complaintQueue"
								action="editComplaint.do">
								<form:hidden path="complaintID"
									value="${complaint.getComplaintID()}" />
								<a
									href="javascript:fnSubmitForm('${complaint.getComplaintID()}');"><span
									class='count'>${complaint.getComplaintNumber()}</span></a>
							</form:form></td>

						<td>${complaint.getComplaintSourceName()}</td>
						<td>${complaint.getComplaintStatusName()}</td>
						<td>${complaint.getComplaintCategoryName()}</td>
						<td>${complaint.getCreatedDate()}</td>
						<%-- 						<td>${complaint.getComplaintStatus()}</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>

<%
	}

	else if (assignCount != null) {
%>
 
<h2
	style='text-align: center; background-color: #B6B6B4; font-size: 17px; color: white; font-weight: bold;'>Complaints
	Assigned</h2>

<c:choose>
	<c:when test="${!empty list.complaintQueue}">
		<table
			class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
			id='complaintQueueTable'>
			<thead>
				<tr>
					<th><spring:message code="label.complaintNumber" /></th>
					<th><spring:message code="label.channel" /></th>
					<td>Status</td>
					<th><spring:message code="label.recievedDateTime" /></th>
					<th>Category</th> 
					<th>Assigned To</th>
					<th><spring:message code="label.agencytime" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.complaintQueue}" var="complaint">
					<tr>
						<td><form:form method='post'
								id="${complaint.getComplaintID()}" commandName="complaintQueue"
								action="editComplaint.do">
								<form:hidden path="complaintID"
									value="${complaint.getComplaintID()}" />
								<a
									href="javascript:fnSubmitForm('${complaint.getComplaintID()}');"><span
									class='count'>${complaint.getComplaintNumber()}</span></a>
							</form:form></td>

						<td>${complaint.getComplaintSourceName()}</td>
						<td>${complaint.getComplaintStatusName()}</td>
						<td>${complaint.getCreatedDate()}</td>
						<td>${complaint.getComplaintCategoryName()}</td>
						<td>${complaint.getAssignedOfficerName()}</td>
						<td>${complaint.getAgentAssignedTime()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>

<%
	}

	else if (closedCount != null) {
%>
 
<h2
	style='text-align: center; background-color: #B6B6B4; font-size: 17px; color: white; font-weight: bold;'>Complaints
	Closed</h2>

<c:choose>
	<c:when test="${!empty list.complaintQueue}">
		<table
			class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
			id='complaintQueueTable'>
			<thead>
				<tr>
					<th><spring:message code="label.complaintNumber" /></th>
					<th><spring:message code="label.channel" /></th>
					<th>Status</th> 
					<th><spring:message code="label.recievedDateTime" /></th>
					<th>Category</th> 
					<th><spring:message code="label.cloesedby" /></th>
					<th><spring:message code="label.resolvedtime" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.complaintQueue}" var="complaint">
					<tr>
						<td><form:form method='post'
								id="${complaint.getComplaintID()}" commandName="complaintQueue"
								action="editComplaint.do">
								<form:hidden path="complaintID"
									value="${complaint.getComplaintID()}" />
								<a
									href="javascript:fnSubmitForm('${complaint.getComplaintID()}');"><span
									class='count'>${complaint.getComplaintNumber()}</span></a>
							</form:form></td>

						<td>${complaint.getComplaintSourceName()}</td>
						<td>${complaint.getComplaintStatusName()}</td>
						<td>${complaint.getCreatedDate()}</td>
						<td>${complaint.getComplaintCategoryName()}</td>
						<td>${complaint.getComplaintClosedName()}</td>
						<td>${complaint.getComplaintResolvedTime()}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>

<%
    }

    else if (escalationCount != null) {
%>

<h2
    style='text-align: center; background-color: #B6B6B4; font-size: 17px; color: white; font-weight: bold;'>Complaints
    Escalated</h2>

<c:choose>
    <c:when test="${!empty list.complaintQueue}">
        <table
            class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
            id='complaintQueueTable'>
            <thead>
                <tr>
                    <th><spring:message code="label.complaintNumber" /></th>
                    <th><spring:message code="label.channel" /></th>
                    <td>Status</td>
                    <th><spring:message code="label.recievedDateTime" /></th>
                    <th>Category</th> 
                    <th><spring:message code="label.escalationTo" /></th>
                    <th><spring:message code="label.escalationTime" /></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list.complaintQueue}" var="complaint">
                    <tr>
                        <td><form:form method='post'
                                id="${complaint.getComplaintID()}" commandName="complaintQueue"
                                action="editComplaint.do">
                                <form:hidden path="complaintID"
                                    value="${complaint.getComplaintID()}" />
                                <a
                                    href="javascript:fnSubmitForm('${complaint.getComplaintID()}');"><span
                                    class='count'>${complaint.getComplaintNumber()}</span></a>
                            </form:form></td>

                        <td>${complaint.getComplaintSourceName()}</td>
                        <td>Escalated</td>
                        <td>${complaint.getCreatedDate()}</td>
                        <td>${complaint.getComplaintCategoryName()}</td>
                        <td>${complaint.getAssignedOfficerName()}</td>
                        <td>${complaint.getAgentAssignedTime()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>

<%
	} else {
%>


<c:choose>
	<c:when test="${!empty list.complaintQueue}">
		<table
			class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
			id='complaintQueueTable'>
			<thead>
				<tr>
					<th><spring:message code="label.complaintNumber" /></th>
					<th><spring:message code="label.channel" /></th>
					<th>Status</th>
					<th>Category</th>
					<th><spring:message code="label.recievedDateTime" /></th>
					

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.complaintQueue}" var="complaint">
					<tr>
						<td><form:form method='post'
								id="${complaint.getComplaintID()}" commandName="complaintQueue"
								action="editComplaint.do">
								<form:hidden path="complaintID"
									value="${complaint.getComplaintID()}" />
								<a
									href="javascript:fnSubmitForm('${complaint.getComplaintID()}');"><span
									class='count'>${complaint.getComplaintNumber()}</span></a>
							</form:form></td>

						<td>${complaint.getComplaintSourceName()}</td>
						<td>${complaint.getComplaintStatusName()}</td>
						<td>${complaint.getComplaintCategoryName()}</td>
						<td>${complaint.getCreatedDate()}</td>
						<%-- 						<td>${complaint.getComplaintStatus()}</td> --%>


					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
<%
	}
%>
