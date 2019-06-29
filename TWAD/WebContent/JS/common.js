/**
 * Created by Mahalingam on 25-04-2017
 * 
 * This is common file and accessible on will JSPs
 */

// Load gif image to show that the page is loading
$(window).load(function() {
	$(".se-post-con").hide();
	$(".se-pre-con").fadeOut("slow");
});

$(document).ready(function() {

	var Jtable = $('.jDataTable').dataTable({
		"bSort" : true,
		"pagingType" : "full_numbers",
		"bDestroy" : true,
		// "scrollX" : true,
		// "scrollY" : "370px",
		"aaSorting" : []

	// "scrollCollapse" : true,

	});
	if ($('table').hasClass("jDataTable"))
		new $.fn.dataTable.FixedColumns(Jtable);

	$("#btnCancel").click(function() {
		location.reload(true);
	});

	$(".select").data("Placeholder", "Select option").chosen();

	$(".datePicker").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true
	});
	$(".datePicker").css('width', '120px');
});

// common function for showing dialog box(elemntID,tilte)
function showDialog(dialogID, dialogTitle, height) {
	$('#' + dialogID).show();
	$('#' + dialogID).dialog({
		resizable : false,
		height : height,
		modal : true,
		position : 'center',
		width : "60%",
		show : {
			effect : "fade",
			duration : 200
		},
		hide : {
			effect : "fade",
			duration : 100
		},
		closeOnEscape : false,
		dialogClass : "noclose",
		title : dialogTitle,
		buttons : {
			"Close" : function() {
				window.location.reload();

			}
		}
	});
}

// common function for showing dialog box(msgContent,scrollLimnt)
function fnShowAlert(content, scroll) {
	$("#InternalDialog").html('<h2>' + content + '</h2>');
	$("#InternalDialog").dialog({
		resizable : false,
		height : 125,
		width : "40%",
		modal : true,
		position : 'center',
		title : "Notification",
		closeOnEscape : false,
		dialogClass : "noclose",
		buttons : {
			"Ok" : function() {
				$(this).dialog("close");
				return false;
			}
		}
	});
}

// common function for showing error dialog box
function fnErr() {
	$("#InternalDialog").html("Error occured. Server is not responding!");
	$("#InternalDialog").css("color", "#a7002e");
	$("#InternalDialog").dialog({
		resizable : false,
		height : 140,
		width : '40%',
		modal : true,
		title : "Internal Error!",
		closeOnEscape : false,
		dialogClass : "noclose"

	});
	setTimeout(function() {
		$("#InternalDialog").dialog("close");
	}, 1500);
}

// To list academic year-year
// This fn will return 5 future academic year from current year

function fnGetEnrollmentAndAcademicYear() {

	var year_1 = new Date().getFullYear();
	var year_2 = year_1 + 1;
	var option = '';
	for ( var y = 0; y < 5; y++) {
		var enrollmentYear = (year_1 + y) + "-" + (year_2 + y);
		option += "<option value='" + enrollmentYear + "'>" + enrollmentYear
				+ "</option>";
	}
	$('#YearofEnrollment').html(option);
}

// common function to convert dd-mm-yyyy to yyyy-mm-dd
function covertDateFormat(ddmmyyyy) {
	var yyymmdd = '';
	if (ddmmyyyy != null && ddmmyyyy != undefined && ddmmyyyy != '') {
		yyymmdd = ddmmyyyy.split('\-')[2] + "-" + ddmmyyyy.split('\-')[1] + "-"
				+ ddmmyyyy.split('\-')[0];
	}
	return yyymmdd;
}
// common function to submit form dynamically
function fnSubmitForm(formID) {
	document.getElementById(formID).submit();
}

// Loading major list based on the Degree
function fnGeMajor(degreeID) {

	$.ajax({
		type : "POST",
		url : "getMajorByDegreeID.do",
		data : "degreeID=" + degreeID,
		dataType : 'json',
		success : function(response) {
			$('#majorID').append('<option value="0">All</option>');
			$.each(response, function(val, text) {
				$('#majorID').append(
						'<option value="' + response[val].majorID + '">'
								+ response[val].majorName + '</option>');
			});
		}
	});
}

function fnGetLecturer() {
	$.ajax({
		type : "POST",
		url : "getLecturer.do",
		dataType : 'json',
		success : function(response) {
			$('#lecturerID').append('<option value="">Select</option>');
			$.each(response, function(val, text) {
				$('#lecturerID').append(
						'<option value="' + response[val].lecturerID + '">'
								+ response[val].lecturerName + ' </option>');
			});
		}
	});
}
function padZero(strVal, max) {
	strVal = strVal.toString();
	return strVal.length < max ? padZero("0" + strVal, max) : strVal;
}