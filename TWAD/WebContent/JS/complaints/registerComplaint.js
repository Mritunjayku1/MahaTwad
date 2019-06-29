var complaintContent = "";

var reAssignedOfficerID = "";
var reAssigncomplaintPriority = "";
var reassingncmt = "";

$(document)
		.ready(
				function() {

					$("#complaintRegisteredTime").datetimepicker({
						dateFormat : 'dd-mm-yy',
						timeFormat : 'HH:mm',
						changeMonth : true,
						changeYear : true,
						showOn : "button",
						buttonImageOnly : true,
						buttonText : "Select date",
						buttonImage : "library/img/datepicker.png",
						showAnim : "slideDown",
						maxDate : new Date()
					});

					$("#btnReset").click(function() {
						window.location = 'registerComplaint.do';
					});
					$("#complaintSubmitterMobileNo")
							.blur(
									function() {
										var mobile = document
												.getElementById("complaintSubmitterMobileNo").value;
										var pattern = /^\d{10}$/;
										if (mobile != undefined
												&& mobile.length > 0)
											if (mobile != null
													&& mobile.length >= 10
													&& pattern.test(mobile)) {
												$("#mobNumErr").hide();
												$("#btnSave").show();
												return true;
											} else {
												$("#mobNumErr").show();
												$("#mobNumErr")
														.html(
																"Invalid Mobile Number");
												$("#mobNumErr").css('color',
														'red');
												$("#btnSave").hide();
												return false;
											}
									});

					$("#complaintCategoryID").change(function() {
						fnGetSubFieldCode();
					});
					fnGetSubFieldCode();
					$('#col')
							.live(
									'click',
									function() {

										$('#collapseSec')
												.html(
														"<img id='exp' src='library/img/down.png' title='Collapse' />");
										$('.readOnly').show();
									});
					$("#exp")
							.live(
									'click',
									function() {
										$('#collapseSec')
												.html(
														"<img id='col' src='library/img/up.png' title='Expand' />");
										$('.readOnly').hide();
									});

					complaintContent = $("#complaintContent").val();

					// $("#audioPlayer").jPlayer({
					// ready : function() {
					// $(this).jPlayer("setMedia", {
					// m4a : "audio/30655800/30655800_10010682774.wav"
					// });
					// },
					// swfPath : "/js",
					// supplied : "m4a"
					// });
					// $("#audioPlayer1").jPlayer({
					// ready : function() {
					// $(this).jPlayer("setMedia", {
					// m4a : "audio/30655800/30655800_10010682774.wav"
					// });
					// },
					// swfPath : "/js",
					// supplied : "m4a"
					// });
					//
					// $("#audioPlayer").bind(
					// $.jPlayer.event.play,
					// function(event) {
					//
					// var currntTime = '0000';
					// currntTime = $(".jp-current-time").text()
					// .replace(":", "");
					//
					// if ($('#reprocess').is(":checked")) {
					// $('#keywordspotted').val('');
					//
					// var values = "";
					//
					// $('#crossellopportntis').val('');
					// $('#sugestions').val('');
					//
					// var keywords = {};
					//
					// currntTime = $(".jp-current-time").text()
					// .replace(":", "");
					//
					// }
					//
					// });

				});

// function convertDate(ddmmyyyy) {
// $('#complaintRegisteredTime').val(covertDateFormat(ddmmyyyy));
// }
function fnSetValues() {
	if ($('#disableAssignedOfficerID').val() != undefined
			&& $('#disableAssignedOfficerID').val() != '')
		$('#assigned_to').html(
				'<input type="hidden" name="assignedOfficerID" id="assignedOfficerID" value="'
						+ $('#disableAssignedOfficerID').val() + '">');

}
function fnreAssign() {

	$('#btnSave').attr('disabled', true);
	$(".se-post-con").show();

	// reAssignedOfficerID = $("#disableAssignedOfficerID").val();
	reAssigncomplaintPriority = $("#reAssigncomplaintPriority").val();
	reassingncmt = $("#reAssignComments").val();

	$("#complaintStatus").val(25);

	$("#complaintPriority").val(reAssigncomplaintPriority);
	$("#complaintContent").val(
			$.trim(complaintContent) + '  Reason For Re-assiged:'
					+ reassingncmt);
	document.registerComplaint.submit();

}
function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}

function fnSaveComplaintDetails() {

	if ($("#registerComplaint").valid()
			&& $("#ComplaintRegisteredBy").val() != '') {

		$("#complaintStatus").val(2);
		$('#btnSave').attr('disabled', true);
		$(".se-post-con").show();
		return true;
	} else
		return false;
}

function fnAgentCloseComplaintDetails() {
	if ($("#registerComplaint").valid()) {
		$("#complaintStatus").val(7);
		document.registerComplaint.submit();
	} else {
		// $('#btnSave').attr('disabled', true);
		// return false;
	}

}

function fnRejectComplaintDetails() {

	var rejectCmts = $("#rejectCommnets").val();
	var rejectReason = $("#rejectedReason_1").val();

	if (rejectReason != undefined && rejectReason != '' && rejectCmts != null) {

		$("#isReject").val('Y');
		$("#complaintStatus").val(4);
		$("#rejectedReason").val(rejectReason);
		$("#assignedAgentComments").val(rejectCmts);
		document.registerComplaint.submit();

	} else {
		$('#reasonErr2').text('Required field');
		$('#rejectedReason').focus();
		return false;
	}

}

function fnAgentReviewRejectComplaintDetails() {

	var rejectCmts = $("#rejectCommnets").val();
	var rejectReason = $("#rejectedReason_1").val();

	if (rejectReason != undefined && rejectReason != '' && rejectCmts != null) {
		$("#isReject").val('Y');
		$("#complaintStatus").val(4);
		$("#rejectedReason").val(rejectReason);
		$("#assignedAgentComments").val(rejectCmts);
		document.registerComplaint.submit();
	} else {
		$('#reasonErr2').text('Required field');
		$('#rejectedReason').focus();
		return false;
	}
}

function getFileName(fileName) {

	fileName = fileName.split('/').pop().split('\\').pop();
	$('#fileName').val(fileName);
	$('.filename').text(fileName);
	if (fileName != '')
		photoCount = 1;

	var fileInput = document.getElementById("file");
	var fileSize = fileInput.files[0].size / 1024;
	var extension = fileName.replace(/^.*\./, '');

	$(".filename").css('color', '#356135');
	if (extension == fileName) {
		extension = '';
	} else {
		extension = extension.toLowerCase();
	}
	validExtension = 'jpg';
	var docExtArr = validExtension;

	if (extension != docExtArr) {
		$('#photoErr').show();
		$("#photoErr").css("color", "red");
		$("#photoErr").html('Please upload *.' + validExtension + ' Photo');
		return false;

	} else {
		$('#photoErr').show();
		if (fileSize >= 200) {
			$("#photoErr").css("color", "red");
			$("#photoErr")
					.html(
							'Photo size is '
									+ (fileSize / 1024).toFixed(2)
									+ ' MB. Photo size should not be exceed to 200 KB ');
			return false;
		}
		if (fileSize < 200) {
			$("#photoErr").html('Photo size is ' + fileSize.toFixed(2) + ' KB');
			$("#photoErr").css("color", "green");
		}
	}
	return true;
}

function fnGetSubFieldCode() {
	$('#complaintViolationTypeID').empty();
	$('#complaintViolationTypeID').append('<option value="">Select</option>');

	if ($('#complaintCategoryID').val() != null
			&& $('#complaintCategoryID').val() != undefined
			&& $('#complaintCategoryID').val() != '')
		$.ajax({
			type : "POST",
			url : "listSubFieldCode.do?key=ViolationType&parentID="
					+ $('#complaintCategoryID').val(),
			dataType : 'json',
			success : function(response) {
				$.each(response, function(val, text) {

					$('#complaintViolationTypeID').append(
							'<option value="' + response[val].fieldCodeID
									+ '">' + response[val].derivedValue
									+ ' </option>');
				});
				$(
						'#complaintViolationTypeID option[value='
								+ $("#hdnViolationType").val() + ']').attr(
						'selected', 'selected');

			}
		});

}
function fnRejetctReason(reasonID) {

	$('#rejectedReason_ID').html(
			'<input type="hidden" name="rejectedReason_1"  id="rejectedReason_1" value="'
					+ reasonID + '">');
}
