$(document).ready(
		function() {

			$("#complaintRegisteredTime").datepicker({
				dateFormat : 'dd-mm-yy',
				changeMonth : true,
				changeYear : true,
				maxDate : new Date(),
				showOn : "button",
				buttonImageOnly : true,
				buttonText : "Select date",
				buttonImage : "library/img/datepicker.png",
				showAnim : "slideDown",
				setDate : new Date()
			});

			$("#complaintRegisteredTime").datepicker().datepicker("setDate",
					new Date());

			$("#btnReset").click(function() {
				window.location = 'searchComplaint.do';
			});

		});

function convertDate(ddmmyyyy) {
	$('#complaintDate').val(covertDateFormat(ddmmyyyy));
}

function validate() {
	if ($('#searchComplaint').valid()) {
		$('#isSumbitted').val('Y');
		return true;
	} else
		return false;

}
