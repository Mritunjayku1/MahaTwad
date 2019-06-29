<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class='table-bordered table table-striped display'
	style='width: 100%;'>
	<tr>
		<td
			style='text-align: center; background-color: #B6B6B4; font-size: 15px; height: 10px; color: white; font-weight: bold;'>Exemption
			Report Details</td>
	</tr>

</table>

<table
	class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
	id='complaintQueueTable'>
	<thead>
		<tr>
			<th><spring:message code="label.complaintNumber" /></th>
			<th><spring:message code="label.channel" /></th>
			<th>Complaint Category</th>
			<th>Violation Type</th>
			<th>Reject Reason</th>
			<th>Reject Stage</th>
			<th><spring:message code="label.recievedDateTime" /></th>


		</tr>
	</thead>
	<tbody>
		<tr>
			<td>11-34342467</td>
			<td>Email</td>
			<td>Money Distribution</td>
			<td>Distribution of Money to Voters</td>
			<td>Others</td>
			<td>Reviewed Complaint</td>
			<td>03-06-2017 11:24</td>


		</tr>
		<tr>
			<td>11-8634160</td>
			<td>SMS</td>
			<td>Political Parties</td>
			<td>Permission Issues</td>
			<td>Irrelevant to Current Water</td>
			<td>New Complaint</td>
			<td>03-06-2017 11:24</td>


		</tr>
	</tbody>

</table>

