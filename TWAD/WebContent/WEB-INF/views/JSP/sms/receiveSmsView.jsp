

<!--
 /*   Project Name         :   EC
 *    Name  of Module      :   Update voter Details
 *    Copyright            :   Copyright (c) 2017
 *    Company              :   Mahalingam Software Pvt ltd Chennai
 *    Functionality        :   Updating the voter details in DB
 *    Link Name            :   Search
 *    Developer Name       :   Tayaru 
 *    Date                 :   07.05.2017
 */
 -->


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<body>
	

	



		<table class='table-bordered table tabel-striped' style='width: 80%;'
			id='tblVoterDtls'>




			<tr>
				<td colspan='4'
					style='text-align: center; background-color: #B6B6B4;'
					class='titleHeader'><spring:message
						code="label.ProgramInformation" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.To" /></td>
				<td><input type="text" name="sender" id="sender"
						 
						value="${receivesmsdata.getsMSSenterNumber()}"></input></td>
			<tr>
				<td><spring:message code="label.message" /></td>
				<td><input type="text" name="message" id="message"
						 
						value="${receivesmsdata.getsMSContent()}"></input></td>
			<tr>
		</table>

	

	<input id="mydata" type="hidden" name="mydata" value="" />
</body>
