

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
       <link href="library/css/style.css" rel="stylesheet" />
        <link href="library/assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
       <link rel="stylesheet" href="library/assets/plugins/bootstrap/css/bootstrap.css" />
        <link href="library/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">

        <script src="library/js/jquery-3.2.1.min.js"></script>
       <script src="library/js/jquery-ui-1.8.21.custom.min.js"></script>
        <script src='library/js/bootstrap.js'></script>
        
<style>
input[type="button"] {
	border-radius: 10px;
	background-color: #2DAAE1;
	font-weight: bold;
	cursor: pointer;
	padding: 5px 5px 5px 5px;
	width: 100px;
	color: white;
}

.dropdown-slide {
	/*  display: inline-block; */
	position: relative;
	font-family: Lato;
	font-size: 13px;
	/*  margin-left: 10px; */
	padding-bottom: 10px;
}

* {
	border-collapse: collapse;
}

.bg_heading {
	text-align: left;
	font-family: Lato;
	font-size: 20px;
	text-transform: uppercase;
	color: white;
	background-color: #2DAAE1;
	border-radius: 15px 0px 0px 0px;
	margin: 0px;
}

input[type="text"], input[type="password"], input[type="file"] {
	width: 330px;
	height: 40px;
	padding: 5px;
}

div.input-group input[readonly] {
	width: 300px;
}

select.lessWidth {
	width: 130px;
	height: 40px;
	padding: 5px;
}

select.moreWidth {
	width: 210px;
	height: 40px;
	padding: 5px;
}

select.classCategory {
	width: 332px;
	height: 40px;
	padding: 5px;
}

.error {
	color: red;
}

div.tabArrow {
	height: 40px;
	color: #fff;
	position: relative;
	width: 200px;
	text-align: center;
	line-height: 40px;
	cursor: pointer;
	margin: 5px;
}
.popover{
        min-width:150px;
    }
    
   /*  #schemeId tr:odd{
    background-color: #f9f9f9;
    } */
    
</style>


<script type = "text/javascript" >
/* 
window.onbeforeunload = function () {
	  return "Are you sure you want to leave?";
	};
 */

	$(document).ready(function() {
		
		
		
		 $("#legCompNameId").val("");
		$("#correspondenceAddrId").val("");
		$("#contactPersonNameId").val("");
		$("#mobileNumId").val("");
		$("#emailAddrId").val("");
		$("#categoryTypeId").val("");
		$("#reqMldId").val("");
		$("#workTypeId").val("1");
		$("#pinCodeId").val("600560");
		$("#isNewConnectionId").val("1");
		$("#cpinCodeId").val(""); 
		$('#surveyFieldNoId').val("");
		$('#localBodyId').val("");
		 
		
		$(document).keydown(function (event) {
		    if (event.keyCode == 123) { // Prevent F12
		        return false;
		    } else if (event.ctrlKey && event.shiftKey && event.keyCode == 73) { // Prevent Ctrl+Shift+I        
		        return false;
		    }
		});
			
		

		$('#personalId').css({
			'background': '#FF7F27'
		});
		$('#siteId,#additionalInfoId').css({
			'background': 'lightgrey'
		});

		var hcafid = $('#HCafId').val();

		if (hcafid == 'null') {

			$('#mobileNumId').removeAttr('readonly');
			$('#landLineNoId').removeAttr('readonly');

		} else {

			$('#mobileNumId').prop('readonly', 'true');
			$('#landLineNoId').prop('readonly', 'true');
		}

		var legCompName = $('#H1').val();
		if (legCompName != null && legCompName != "null") {
			$('#legCompNameId').val(legCompName);
			$('#contactPersonNameId').val($('#H3').val());
			$('#mobileNumId').val($('#H4').val());
			$('#landLineNoId').val($('#H5').val());
			$('#emailAddrId').val($('#H6').val());

			var correspondenceAddr = $('#H2').val();
			if (correspondenceAddr != null &&
				correspondenceAddr != "null") {
				var cAddrArray = correspondenceAddr.split(",");
				$('#cdoorNoId').val(cAddrArray[0]);
				$('#cplotNoId').val(cAddrArray[1]);
				$('#cstreetNameId').val(cAddrArray[2]);
				$('#clocationId').val(cAddrArray[3]);
				$('#cpinCodeId').val(cAddrArray[4]);
			}
			var siteAddr = $('#H7').val();
			if (siteAddr != null && siteAddr != "null") {
				var addrArray = siteAddr.split(",");
				$('#doorNoId').val(addrArray[0]);
				$('#plotNoId').val(addrArray[1]);
				$('#streetNameId').val(addrArray[2]);
				$('#locationId').val(addrArray[3]);
				$('#pinCodeId').val(addrArray[4]);
			}

		}

		var registeredDataLocal = JSON.parse(localStorage.getItem('registeredData'));

		//$("#mobileNumId").prop('readonly', true);
		//$("#landLineNoId").prop('readonly', true);
		if (registeredDataLocal != null) {
			$("#legCompNameId").val(registeredDataLocal.legCompName);
			$("#cdoorNoId").val(registeredDataLocal.cdoorNo);
			$("#cplotNoId").val(registeredDataLocal.cplotNo);
			$("#cstreetNameId").val(registeredDataLocal.cstreetName);
			$("#clocationId").val(registeredDataLocal.clocation);
			$("#cpinCodeId").val(registeredDataLocal.cpinCode);

			$('#salutationId option[value="' +registeredDataLocal.salutation +'"]').attr('selected', 'selected');
			$("#contactPersonNameId").val(registeredDataLocal.contactPersonName);
			$("#mobileNumId").val(registeredDataLocal.mobileNum);
			$("#landLineNoId").val(registeredDataLocal.landLineNo);
			$("#emailAddrId").val(registeredDataLocal.emailAddr.replace('%40', '@'));
			$("#webAddressId").val(registeredDataLocal.webAddress);

			$('#categoryTypeId option[value="' +registeredDataLocal.categoryType +'"]').attr('selected', 'selected');
			$("#doorNoId").val(registeredDataLocal.doorNo);
			$("#plotNoId").val(registeredDataLocal.plotNo);
			$("#streetNameId").val(registeredDataLocal.streetName);
			$("#locationId").val(registeredDataLocal.location);
			$("#pinCodeId").val(registeredDataLocal.pinCode);
			$('#isNewConnectionId option[value="' +registeredDataLocal.isNewConnection +'"]').attr('selected', 'selected');
			$('#isExistConnectionForAlterationId option[value="' +registeredDataLocal.isExistConnectionForAlteration +'"]').attr('selected', 'selected');
            $("#reqMldId").val(registeredDataLocal.reqMld);
			$("#ipf").val(registeredDataLocal.ipf);
			$("#gstAmount").val(registeredDataLocal.gstAmount);
			$("#totalAmount").val(registeredDataLocal.totalAmount);
			$('#cmwssbZoneNumId option[value="' +registeredDataLocal.cmwssbZoneNum +'"]').attr('selected', 'selected');
            $('#intrPlumStatusId option[value="' +registeredDataLocal.intrPlumStatus +'"]').attr('selected', 'selected');
			$('#workTypeId option[value="' +registeredDataLocal.workType +'"]').attr('selected', 'selected');

		}

		$('#districtId').change(function () {
              $.ajax({
							type: "GET",
							url: "library/DistrictTaluk.json",
							success: function (
								response) {
								var districtSelectedValue = $(
										'#districtId option:selected')
									.val();
								var taluk = response[districtSelectedValue];
								var option = '<option value="">--Select Taluk--</option>';
								if (taluk != undefined)
									for (var i = 0; i < taluk.length; i++) {

										$.each(taluk[i],function (key,value) {
													option = option +
														'<option value="' + key + '">' +
														value +
														'</option>';
												});

									}
								$('#talukId').find('option').remove();
								$('#talukId').append(option);
								//$('#taluk option[value="'+registeredDataLocal.divId+'"]').attr('selected', 'selected');

							}
						});
              
            
				});

		$('#talukId').change(function () {
                $.ajax({
							type: "GET",
							url: "library/TalukVillage.json",
							success: function (response) {
								var talukSelectedValue = $('#talukId option:selected').val();
								var village = response[talukSelectedValue];
								var option = '<option value="">--Select Village--</option>';
								if (village != undefined)
									for (var i = 0; i < village.length; i++) {

										$.each(village[i],function (key,value) {
													option = option + '<option value="' + key + '">' +value +'</option>';
										});
									}
								$('#villageId').find('option').remove();
								$('#villageId').append(option);
								//$('#villageId option[value="'+registeredDataLocal.divId+'"]').attr('selected', 'selected');

							}
						});

		});
		
		$('#districtId').change(function () {
            $.ajax({
						type: "GET",
						url: "library/Scheme.json",
						success: function (response) {
							var villageSelectedValue = $('#districtId option:selected').val();
							
							var scheme = response[villageSelectedValue];
							var option = '<thead><tr><th width="70%">Scheme Name</th><th>Quantity</th></tr></thead><tbody>';
							
							if (scheme != undefined)
								for (var i = 0; i < scheme.length; i++) {
                                    option = option + '<tr><td>'+scheme[i].value+'</td><td>'+scheme[i].quantity+'</td></tr>';
								}
							option = option +'</tbody>';
							$('#schemeId').find('tr').remove();
							$('#schemeId').append(option);

						}
					});

	});
		
		
		$('#workTypeId').change(function(){
			var waterType = $(this).val();
			$('#availabilityId').removeAttr('disabled');
			$('#schemeId').removeAttr('disabled');
			if(waterType!=1){
				$('#availabilityId').attr('disabled',true);
				$('#schemeId').attr('disabled',true);
			}
			
		});
		
		$('#schemeId').hide();
		
		$('#availabilityId').change(function(){
			var waterAvailability = $(this).val();
			$('#schemeId').show();
			if(waterAvailability!=1){
				$('#schemeId').hide();
			}
		});
		
		

	/*  $('#reqMldId').blur(function () {

		var reqMldId = $('#reqMldId').val();

		if (reqMldId != "") {
			$.ajax({
				type: "POST",
				url: "getReqMLDCost.do",
				data: {
					'reqMldId': reqMldId
				},
				success: function (response) {
					$('#upfrontChargesId').val(response);

				}

			})
		}

		}); */

		$('#checkAgreeId').change(function(){
			 if($(this).prop("checked") == true){
			   $('#registrationbtnId').removeAttr('disabled');
		       $('#registrationbtnId').css({
			      'background-color' : '#2DAAE1'
		       });
			 }
			 else{
					$('#registrationbtnId').attr('disabled', 'true');
					$('#registrationbtnId').css({
						'background-color' : 'lightgrey'
					});
			 }
		});
		
		
		$('#sameAsSiteAddressId').change(function(){
			 if($(this).prop("checked") == true){
			   $('#cdoorNoId').val($('#doorNoId').val());
			   $('#cplotNoId').val($('#plotNoId').val());
			   $('#cstreetNameId').val($('#streetNameId').val());
			   $('#clocationId').val($('#locationId').val());
			   $('#cpinCodeId').val($('#pinCodeId').val());
			 }
			 /* else{
				 $('#cdoorNoId').val("");
				   $('#cplotNoId').val("");
				   $('#cstreetNameId').val("");
				   $('#clocationId').val("");
				   $('#cpinCodeId').val("");
			 } */
		});
		
		
				

		$('input[type="text"]').each(function() {
			$(this).attr('data-content', $(this).attr('placeholder'));
		});
		$('[data-toggle="popover"]').popover();

		$('.tab2').hide();
		$('.tab3').hide();
		$('#tabBackId').prop('value', 'Back');
		$('#tabchangeId').prop('value', 'Next');
		$('#registrationbtnId,#tabBackId').attr('disabled', 'true');
		$('#registrationbtnId,#tabBackId').css({
			'background-color' : 'lightgrey'
		});

		$('#personalId').click(function() {
			tabCount = 0;
			$('.tab2').hide();
			$('.tab3').hide();
			$('.tab1').show();
			$('#tabBackId').prop('value', 'Back');
			
			$('#tabchangeId').prop('value', 'Next');
			$('#tabchangeId').css({
				'background-color' : '#2DAAE1'
			});
			$('#tabchangeId').removeAttr('disabled');
			
			$('#registrationbtnId,#tabBackId').attr('disabled', 'true');
			$('#registrationbtnId,#tabBackId').css({
				'background-color' : 'lightgrey'
			});
			
			$('#personalId').css({
				'background' : '#FF7F27'
			});
			$('#siteId').css({
				'background' : 'lightgrey'
			});
			$('#additionalInfoId').css({
				'background' : 'lightgrey'
			});
		});
		$('#siteId').click(function() {
			tabCount = 1;
			$('.tab1').hide();
			$('.tab2').show();
			$('.tab3').hide();
			$('#tabBackId').prop('value', 'Back');
			$('#tabchangeId').prop('value', 'Next');
			$('#tabBackId,#tabchangeId').removeAttr('disabled');
			$('#tabBackId,#tabchangeId').css({
				'background-color' : '#2DAAE1'
			});
			
			$('#registrationbtnId').attr('disabled', 'true');
			$('#registrationbtnId').css({
				'background-color' : 'lightgrey'
			});

			$('#personalId').css({
				'background' : 'lightgrey'
			});
			$('#siteId').css({
				'background' : '#FF7F27'
			});
			$('#additionalInfoId').css({
				'background' : 'lightgrey'
			});
		});
		
		$('#additionalInfoId').click(function() {
			tabCount = 2;
			$('.tab1').hide();
			$('.tab2').hide();
			$('.tab3').show();
			$('#tabBackId').prop('value', 'Back');
			$('#tabchangeId').prop('value', 'Next');
			$('#tabchangeId').attr('disabled', 'true');
			$('#tabchangeId').css({
				'background-color' : 'lightgrey'
			});
			
			$('#tabBackId').removeAttr('disabled');
			$('#tabBackId').css({
				'background-color' : '#2DAAE1'
			});

			$('#personalId').css({
				'background' : 'lightgrey'
			});
			$('#siteId').css({
				'background' : 'lightgrey'
			});
			$('#additionalInfoId').css({
				'background' : '#FF7F27'
			});
			
			if($('#checkAgreeId').prop("checked") == true){
				   $('#registrationbtnId').removeAttr('disabled');
			       $('#registrationbtnId').css({
				      'background-color' : '#2DAAE1'
			       });
				 }
				 else{
						$('#registrationbtnId').attr('disabled', 'true');
						$('#registrationbtnId').css({
							'background-color' : 'lightgrey'
						});
				 }
		});
		
		var tabCount = 0;
		
		$('#tabBackId').click(function() {
			
			if(tabCount==1){
				tabCount--;
               $('#personalId').click();
				
			}
            if(tabCount==2){
            	tabCount--;
            	 $('#siteId').click();
			}
		});
		
		$('#tabchangeId').click(function() {
			
			 if(tabCount==1){
	            	isSubmitBtnClicked=true;
	            	if(validateForm()){
	            		tabCount++;
	            	 $('#additionalInfoId').click();
	            	}
				}
			if(tabCount==0){
				
				isSubmitBtnClicked=false;
				
				 if($('#sameAsSiteAddressId').prop("checked") == true){
					   $('#cdoorNoId').val($('#doorNoId').val());
					   $('#cplotNoId').val($('#plotNoId').val());
					   $('#cstreetNameId').val($('#streetNameId').val());
					   $('#clocationId').val($('#locationId').val());
					   $('#cpinCodeId').val($('#pinCodeId').val());
					 }
					
				

				
				if(validateForm()){
					tabCount++;
				 $('#siteId').click();
				}
			}
           
				});
		$("#LoadingImage").hide();

		$('#registrationbtnId').click(function() {
			isSubmitBtnClicked=true;
            var isUpload=true; 
            $('.error').remove();
            $("#LoadingImage").css("display", "block");
							$(".uploadClass").each(function() {
												
												if (this.files[0] != undefined){
													if (this.files[0].size > 5000000) { // 5 * 1000 * 1000 bytes
														$(this).after('<span class="error"> File Should not be more than 5 MB</span>');
														$(this).focus();
														isUpload=false;
														return false;
													}
												}
												else{
													$(this).after('<span class="error"> Please upload the file</span>');
													$(this).focus();
													isUpload=false;
												}
												

							});

							if (isUpload && validateForm()) {
								//if (confirm("Are you sure want to Register ?")) {
									
									var dataString = $('#formId').serialize();
									var form = $('#formId')[0];
									var paymentMode = 'initial';
									var formdata = new FormData(form);

									var isUpload = false;

									$(".uploadClass").each(function() {
														if (this != undefined
																&& $(this)
																		.val() != "") {
															isUpload = true;
														}
									});

									
									
												$('#registrationbtnId').attr('disabled', 'true');
												$('#registrationbtnId').css({
													'background-color' : 'lightgrey'
												});
										 
									
									
									

									$
											.ajax({
												type : "POST",
												url : "companyRegister.do",
												data : dataString,
												async : false,

												success : function(response) {
													if (isUpload) {
														$.ajax({
																	type : "POST",
																	enctype : 'multipart/form-data',
																	url : "uploadMultipleFile.do",
																	data : formdata,
																	processData : false,
																	contentType : false,
																	cache : false,
																	timeout : 600000,
																	async : false,

																	success : function(data) {
																		$('#appId').val(response);
																		/* $('#ackCompanyName').val($('#legCompNameId').val());
																		$('#ackApplicantName').val($('#salutationId').val()+ " "+ $('#contactPersonNameId').val());
																		$('#ackHiddenForm').submit(); */
																		$('#onlineFormId').submit();
																		
																		
																	},
																});
													} else {
														$('#appId').val(response);
														/* $('#ackCompanyName').val($('#legCompNameId').val());
														$('#ackApplicantName').val($('#salutationId').val()+ " "+ $('#contactPersonNameId').val());
														$('#ackHiddenForm').submit(); */
														$('#onlineFormId').submit();
													}

												}
											});
								//}
								
										  
										
								
							}
							else{
								alert("Please validate data again ! ");
								$("#LoadingImage").hide();
							}
						});

	});

	function validateForm() {
		var numberReg = /^[0-9\+]+$/;
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var legCompName = $("#legCompNameId");
		var correspondenceAddr = $("#correspondenceAddrId");
		/* var salutation = $('#salutationId'); */
		var contactPersonName = $("#contactPersonNameId");
		var mobileNum = $("#mobileNumId");
		var emailAddr = $("#emailAddrId");
		var districtId = $('#districtId');
		var talukId = $('#talukId');
		var villageId = $('#villageId');
		var categoryType = $("#categoryTypeId");
		var surveyFieldNoId = $('#surveyFieldNoId');
		var reqMld = $("#reqMldId");
		var workType = $("#workTypeId");
		var paymentType = $("#paymentTypeId");

		var pinCode = $("#pinCodeId");
		var isNewConnection = $("#isNewConnectionId");
		var cpinCode = $("#cpinCodeId");
		var localBody = $("#localBodyId");
		var availability = $("#availabilityId")
		
		
		var inputVal = new Array(legCompName,surveyFieldNoId, cpinCode, contactPersonName,mobileNum, emailAddr, pinCode,districtId);
		if(isSubmitBtnClicked){
		   inputVal = new Array(categoryType, isNewConnection,reqMld, workType,availability);
		}
		$('.error').hide();
		flag = true;
		for (i = 0; i < inputVal.length; i++) {
			if (inputVal[i].val() == "") {
				if(inputVal.length != 5){
					if (inputVal[i].attr('id') == 'mobileNumId'){
						inputVal[i].parent('div').parent('div').find('label').after('<span class="error"> This field is required. </span>');
					}
					else{
				inputVal[i].parent('div').find('label').after('<span class="error"> This field is required. </span>');
					}
				inputVal[i].focus();
				flag = false;
				}
				else{
					inputVal[i].parent('div').find('#categoryTypeId').after('<span class="error"> This field is required. </span>');
					inputVal[i].parent('div').find('input').after('<span class="error"> This field is required. </span>');
					inputVal[i].parent('div').find('#workTypeId').after('<span class="error"> This field is required. </span>');
					inputVal[i].focus();
					if(inputVal[i].attr('id') != 'availabilityId')
					flag = false;
				}
				
			} else if (inputVal[i].attr('id') == 'emailAddrId'
					&& !emailReg.test(inputVal[i].val())) {
				inputVal[i]
						.parent('div')
						.find('label')
						.after(
								'<span class="error"> Please enter correct Email Id </span>');
				inputVal[i].focus();
				flag = false;
			} else if (inputVal[i].attr('id') == 'mobileNumId' && inputVal[i].val().length != 10) {
				inputVal[i].parent('div').parent('div').find('label').after('<span class="error"> Please enter correct mobile No. </span>');
				inputVal[i].focus();
				flag = false;
			} else if (inputVal[i].attr('id') == 'reqMldId'
					&& !/^[1-9][0-9]+$/.test(inputVal[i].val())) {
				inputVal[i]
						.parent('div')
						.find('input')
						.after(
								'<span class="error"> Please enter required KLD in Number   </span>');
				inputVal[i].focus();
				flag = false;
			} else if (inputVal[i].attr('id') == 'contactPersonNameId'
					&& !/^[a-zA-Z\s]+$/.test(inputVal[i].val())) {
				inputVal[i]
						.parent('div')
						.find('label')
						.after(
								'<span class="error"> Please enter Alphabet and Space </span>');
				inputVal[i].focus();
				flag = false;
			} else if ((inputVal[i].attr('id') == 'pinCodeId' || inputVal[i]
					.attr('id') == 'cpinCodeId')
					&& !/^\d{6}$/.test(inputVal[i].val())) {
				inputVal[i]
						.parent('div')
						.find('label')
						.after(
								'<span class="error"> Please enter 6 digit PinCode </span>');
				inputVal[i].focus();
				flag = false;
			}
			
			
			
			 if (inputVal[i].attr('id') == 'workTypeId' && $('#workTypeId').val() == 1) {
					if ($('#availabilityId').val() == "") {
						$('#availabilityId')
						.parent('div')
						.find('select')
								.after(
										'<span class="error"> Please select Availability </span>');
						$('#availabilityId').focus();
						flag = false;
					}
			 }
			 
			/*  if (inputVal[i].attr('id') == 'availabilityId' && $('#availabilityId').val() == 1) {
				
					if ($('#schemeId').val() == "") {
						$('#schemeId')
						.parent('div')
						.find('select')
								.after(
										'<span class="error"> Please select Scheme </span>');
						$('#schemeId').focus();
						flag = false;
					}
			 } */
			
			

		}

		
		  
		/* if(pinCode.val()!="" && (districtId.val()=="" || talukId.val()=="" || villageId.val()=="" )){
			districtId.parent('div').find('label').after(
					'<span class="error"> Please select District,Taluk,Village </span>');
			flag = false;
		}
		 */
		if(localBody.val()=="" && (talukId.val()=="" || villageId.val()=="" )){
			localBody.parent('div').find('label').after(
					'<span class="error"> Please select either Taluk and Village or Local Body </span>');
			flag = false;
		}
		
		
		return flag;
	}
</script>

</head>
<body  style="margin: 0px; padding: 0px">

<table id="mydiv" align="center" width="91%">

    <tr>
        <td valign="middle" colspan="2" style="height: 130px; width: 100%;">
            <table width="100%">
                <tbody>
                    <tr>
                        <td width="25%" align="center"><img src="library/img/twad_logo.gif" width="110px" height="106px" style="margin-left: 50px;"></td>
                        <td width="50%" align="center"><img src="library/img/middleImage.png" width="770px" height="50px"></td>
                       <!-- <td width="25%" align="center"><img src="library/img/pic6_2.jpg" width="130px" height="130px" style="margin-right: 50px;"></td> -->
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </td>
    </tr>

    <tr>
        <td colspan="2">
            <div style="font-weight: bold; font-size: 17px; position: absolute; top: 115px; left: 517px;">
                <font color="blue">Application for new industrial/private
					water supply </font>
            </div>

        </td>
    </tr>

    <tr>

        <td colspan="2" height="25px">

            <div style="padding: 0px; width: 100%;">
                <div style="background-image: url(library/img/border_bg.jpg); height: 7px; background-repeat: repeat-x;">
                    &nbsp;</div>
            </div>
        </td>
    </tr>
</table>

<form id="formId" method="post" enctype="multipart/form-data">
    <input type="hidden" name="appId" value='<%=request.getParameter("applicationRef")%>'>
    <input type="hidden" id="HCafId" name="cafId" value='<%=request.getParameter("caf")%>' />
    <input type="hidden" id="H1" value='<%=request.getParameter("legCompName")%>' />
    <input type="hidden" id="H2" value='<%=request.getParameter("correspondenceAddr")%>' />
    <input type="hidden" id="H3" value='<%=request.getParameter("contactPersonName")%>' />
    <input type="hidden" id="H4" value='<%=request.getParameter("mobileNum")%>' />
    <input type="hidden" id="H5" value='<%=request.getParameter("landLineNo")%>' />
    <input type="hidden" id="H6" value='<%=request.getParameter("emailAddr")%>' />
    <input type="hidden" id="H7" value='<%=request.getParameter("siteAddr")%>' />
    
    <table id="myTable" width="100%">
        <tr>
            <td align="center" valign="top" style="width: 25%; padding-bottom: 10px;">
                <div style="border: 1px solid lightgrey; width: 215px;">
                    <div id="personalId" class="tabArrow">
                        Personal Details <!-- <span class="activeSpan"></span> -->
                    </div>
                    <div id="siteId" class="tabArrow">
                        Site Details <span class="activeSpan"></span>
                    </div>
                     <div id="additionalInfoId" class="tabArrow">
                        Additional Information  <span class="activeSpan"></span>
                    </div>
                </div>
            </td>
            <td style="width: 75%;">
                <table width="100%">

                    <tr>
                        <td>
                            <div id="LoadingImage" style=" position: absolute; top: 200px; left: 650px;">
                                <img src="library/img/loaderTn.gif" />
                            </div>
                        </td>
                    </tr>

                    <tr class="tab1">
                        <td width="50%">
                            <div>
                                <label><b>Legal Name of Company:</b></label> <span style="color: red;">*</span>
                                <br />
                                <input placeholder="Ex: ABC Company" type="text" id="legCompNameId" name="legCompName" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Company Name" />

                            </div>
                            <br />

                        </td>
                        <td width="50%">
                            <div>
                                <label><b>Name of contact person:</b></label> <span style="color: red;">*</span>
                                <br />
                                <select class="classCategory" id="salutationId" name="salutation" style="width: 80px;">
                                    <!-- <option value="">---</option> -->
                                    <option value="Mr">Mr</option>
                                    <option value="Mrs">Mrs</option>
                                </select>
                                <input placeholder="Ex: sachin tendulkar" type="text" id="contactPersonNameId" name="contactPersonName" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Your Name" style="width: 246px;" />
                            </div>
                            <br />
                        </td>

                    </tr>
                    <tr  class="tab1">
                     <td>
                            <div>
                                <label><b>Mobile Number:</b></label> <span style="color: red;">*</span>
                                <br />
                                 <div class="input-group" style="width:332px;">
                                    <span class="input-group-addon">+91</span>
                                    <input class="form-control" placeholder="9677882732"  type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57 && event.charCode = 43' id="mobileNumId" name="mobileNum" maxlength="13" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Mobile No."/>
                                </div>
                                
                            </div>
                            <br />
                        </td>
                     <td width="50%">
                            <div>
                                <label><b>Survey Field No:</b></label> <span style="color: red;">*</span>
                                <br />
                                <input placeholder="Survey Field No" type="text" id="surveyFieldNoId" name="surveyFieldNo" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Survey Field No." />
                            </div>
                            <br />
                        </td>
                        
                        
                        
                       
                    
                    </tr>
                    <tr class="tab1">
                       

 <td>
                        
                         <div>
                                <div style="display: inline-block;float: left;">
                                   <label><b>STD Code</b></label><br/>
                                       <input placeholder="Ex: 12345" type="text" id="stdCodeId" onkeypress="return event.charCode >= 48 && event.charCode <= 57" name="stdCode" style="margin-right: 5px; width: 100px;" maxlength="5" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter STD Code" />
           
                                </div>
                                <div style="margin-left: 22px; display: inline-block;">
                                    <label><b>Land line number:</b></label>
                                    <br />
                                    <div class="input-group">
                                        
                                         <input placeholder="Ex: 1234567891" type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57" id="landLineNoId" name="landLineNo"  maxlength="15" style="margin-right: 5px;width: 200px;"  />
                                    </div>
                                </div>
                            </div>
                        
                            <br />
                        </td>
 <td valign="top" rowspan="3">
                            <div>
                                <label><b>Site Address:</b></label> <span style="color: red;">*</span>
                                <br />
                                <input placeholder="Ex: DoorNo" type="text" id="doorNoId" name="doorNo" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Door No" />
                                <br />
                                <input placeholder="Ex: Plot No" type="text" id="plotNoId" name="plotNo" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Plot No" />
                                <br />
                                <input placeholder="Ex: Street Name" type="text" id="streetNameId" name="streetName" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Street Name" />
                                <br />
                                <input placeholder="Ex: Location" type="text" id="locationId" name="location" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Landmark" />
                                <br />
                                <input placeholder="Ex: PinCode" type="text" id="pinCodeId" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="pinCode" maxlength="6" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Pincode" />
                                <br />
                                <select class="classCategory" title="Select District" id="districtId" name="district" style="margin-right: 10px;">
                                    <option value="">--Select District--</option>
                                    <c:forEach items="${list.districtDtl}" var="app" varStatus="count">
                                        <option value="${app.getDistrictId()}">${app.getDistrictName()}</option>
                                    </c:forEach>
                                </select>
                                <select class="classCategory" title="Select Taluk" id="talukId" name="taluk" style="margin-right: 10px;">
                                    <option value="">--Select Taluk--</option>
                                </select>
                                <select class="classCategory" title="Select Village" id="villageId" name="village" style="margin-right: 10px;">
                                    <option value="">--Select Village--</option>
                                </select>

                            </div>
                             <br />
                            <div>
                                <label><b>Local Body:</b></label>
                                <br />
                                <input placeholder="Local Body" type="text" id="localBodyId" name="localBody" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Local body" />
                            </div>
                            <br/>
                        </td>

                        
                       
                       
                       
                    </tr>
                    <tr class="tab1">
                        <td valign="top">
                            <div>
                                <label><b>Email Id:</b></label> <span style="color: red;">*</span>
                                <br />
                                <input placeholder="Ex: abc@xyz.cd" type="text" id="emailAddrId" name="emailAddr" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Email Id" />
                            </div>
                            <br />
                            <div>
                                <label><b>Address for Correspondence:</b></label> <span style="color: red;">*</span>
                                <br />
                                <input type="checkbox" id="sameAsSiteAddressId"/> <b>Is Correspondence Address same as Site Address?</b>
                                <br/>
                                 <br/>
                                <input placeholder="Ex: DoorNo" type="text" id="cdoorNoId" name="cdoorNo" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Door No" />
                                <br />
                                <input placeholder="Ex: Plot No" type="text" id="cplotNoId" name="cplotNo" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Plot No" />
                                <br />
                                <input placeholder="Ex: Street Name" type="text" id="cstreetNameId" name="cstreetName" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Street Name" />
                                <br />
                                <input placeholder="Ex: Location" type="text" id="clocationId" name="clocation" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Landmark" />
                                <br />
                                <input placeholder="Ex: PinCode" type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' id="cpinCodeId" name="cpinCode" maxlength="6" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Pincode" />
                            </div>
                        </td>
                       <%--  <td valign="top">
                            <div>
                                <label><b>Site Address:</b></label> <span style="color: red;">*</span>
                                <br />
                                <input placeholder="Ex: DoorNo" type="text" id="doorNoId" name="doorNo" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Door No" />
                                <br />
                                <input placeholder="Ex: Plot No" type="text" id="plotNoId" name="plotNo" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Plot No" />
                                <br />
                                <input placeholder="Ex: Street Name" type="text" id="streetNameId" name="streetName" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Street Name" />
                                <br />
                                <input placeholder="Ex: Location" type="text" id="locationId" name="location" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Landmark" />
                                <br />
                                <input placeholder="Ex: PinCode" type="text" id="pinCodeId" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="pinCode" maxlength="6" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Pincode" />
                                <br />
                                <select class="classCategory" title="Select District" id="districtId" name="district" style="margin-right: 10px;">
                                    <option value="">--Select District--</option>
                                    <c:forEach items="${list.districtDtl}" var="app" varStatus="count">
                                        <option value="${app.getDistrictId()}">${app.getDistrictName()}</option>
                                    </c:forEach>
                                </select>
                                <select class="classCategory" title="Select Taluk" id="talukId" name="taluk" style="margin-right: 10px;">
                                    <option value="">--Select Taluk--</option>
                                </select>
                                <select class="classCategory" title="Select Village" id="villageId" name="village" style="margin-right: 10px;">
                                    <option value="">--Select Village--</option>
                                </select>

                            </div>
                        </td>
 --%>
                    </tr>

                    <tr class="tab2">

                       
                        <td  colspan="2">
                            <div>
                                <label><b>Type of category:</b></label> <span style="color: red;">*</span>
                                <select class="classCategory" id="categoryTypeId" name="categoryType" style="margin-right: 10px;margin-left: 55px;">
                                    <option value="">--Select Category--</option>
                                    <c:forEach items="${list.categoryDtl}" var="app" varStatus="count">
                                        <option value="${app.getCategoryId()}">${app.getCategoryName()}</option>
                                    </c:forEach>

                                </select>
                               <!--  <a href="library/TypeOfCategory.pdf" download><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: absolute; cursor: pointer;"></a> -->
 <a href="library/TypeOfCategory.pdf" target="_blank"><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: absolute; cursor: pointer;"></a>
                            </div>
                            <br />
                        </td>
                        
                         
                        <td valign="top" rowspan="5" align="center">
                            <div>
                               <!--  <label><b>Scheme:</b></label>  -->
                                <table class="classCategory table table-striped table-bordered table-hover dataTable no-footer" id="schemeId"   name="scheme" style="margin: 5px;width: 285px;" title="Scheme with Quantity">
                                
                                </table>
                         
                            </div>
                            <br />
                        </td>

                    </tr>

                    <tr class="tab2">
                        <td>
                            <div>
                                <label><b>Is this a new connection?</b> </label> <span style="color: red;">*</span>
                                <select class="lessWidth" id="isNewConnectionId" name="isNewConnection">
                                    <option value="">--Select--</option>
                                    <option value="1">Yes</option>
                                    <option value="0">No</option>
                                </select>
                            </div>
                            <br />
                        </td>
                       
</tr>
 <tr class="tab2">
                        <td>
                        <div>
                                   <label><b>REQs of water<font style="color: rgb(128, 128, 128); font-size: 10px;"> (in KLD):</font></b></label> <span style="color: red;">*</span>
                                       <input placeholder="Ex: 12345" type="text" id="reqMldId" onkeypress='return event.charCode >= 48 && event.charCode <= 57' onkeypress="gst()" name="reqMld" style="margin-right: 5px;margin-left: 30px; width: 130px;" maxlength="5" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Requirement of water" />
                                       <!--  <a href="library/MLD.pdf" download><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: relative; cursor: pointer;"></a> -->
                                </div>
                            <!-- <div>
                                <label><b>Type of water:</b></label> <span style="color: red;">*</span>
                                <select class="classCategory" id="workTypeId" name="workType" style="margin-left: 76px;">
                                    <option value="">--Select--</option>
                                    <option value="1">Treated (Chloronated)</option>
                                    <option value="1">Raw Water</option>
                                    <option value="2">Secondary treated water</option>
                                </select><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: absolute; cursor: pointer;">
                            </div> -->
                            <br />
                        </td>
                    </tr>
<tr class="tab2">
                        <td>
                        <div>
                                <label><b>Type of water:</b></label> <span style="color: red;">*</span>
                                <select class="classCategory" id="workTypeId" name="workType" style="margin-left: 76px;">
                                    <option value="">--Select--</option>
                                    <option value="1">Treated (Chloronated)</option>
                                    <!-- <option value="1">Raw Water</option> -->
                                    <option value="2">Secondary treated water</option>
                               <!--  </select><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: absolute; cursor: pointer;"> -->
                                </select><a href="library/twawsstariff.pdf" target="_blank"><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: absolute; cursor: pointer;">
                            </div>
                        
                                <%-- <div>
                                   <label><b>REQs of water<font style="color: rgb(128, 128, 128); font-size: 10px;"> (in KLD):</font></b></label> <span style="color: red;">*</span>
                                       <input placeholder="Ex: 12345" type="text" id="reqMldId" onkeypress='return event.charCode >= 48 && event.charCode <= 57' onkeypress="gst()" name="reqMld" style="margin-right: 5px;margin-left: 30px; width: 130px;" maxlength="5" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Requirement of water" />
                                        <a href="library/MLD.pdf" download><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: relative; cursor: pointer;"></a>
                                </div> --%>
                              <br/>
                        </td>
                    </tr>
                     
                       <tr class="tab2">
                        <td width="60%">
                            <div>
                                <label><b>Availability of water:</b></label>
                                <select class="classCategory" id="availabilityId" name="availability" style="margin-left: 43px;">
                                    <option value="">--Select--</option>
                                    <option value="1">From TWAD CWSS</option>
                                    <option value="2">Need Dedicated Scheme</option>
                                </select>
                            </div>
                            <br />
                        </td>
                        
                        
                        
                        </tr>
                        <tr class="tab2">
                        
                        </tr>
                    
                    
                    <tr class="tab2">
                        <td valign="top" colspan="2">
                            <div>
                                <div style="display: inline-block;">
                                    <label><b>Application Fee:</b></label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><img
											src="library/img/RupeeImage.png" /></span>
                                        <input class="form-control" placeholder="Auto Genearated" type="text" name="cost" readonly style="width: 125px;" maxlength="3" value="${list.fixedPaymentAmount.getPaymentAmount()}" />
                                    </div>
                                </div>
                                <div style="margin-left: 10px; display: inline-block;">
                                    <label><b>GST Amount<font
											style="color: rgb(128, 128, 128); font-size: 12px;">(GST
												@ ${list.fixedPaymentAmount.getGstPercent()}% )</font>:
									</b></label>
                                    <br />
                                    <div class="input-group">
                                        <span class="input-group-addon"><img
											src="library/img/RupeeImage.png" /></span>
                                        <input class="form-control" placeholder="GST @ 18 % " type="text" id="gstAmount" readonly style="width: 125px;" name="gstAmount"  value="${list.fixedPaymentAmount.getGstAmount()}" />
                                    </div>
                                </div>
                                  <div style="margin-left: 10px; display: inline-block;">
                                <label><b>Total Amount:</b></label>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon"><img
										src="library/img/RupeeImage.png" /></span>
                                    <input class="form-control" placeholder="Ex: Cost * GST 18 %" type="text" id="totalAmount" readonly style="width: 125px;" name="totalAmount"  value="${list.fixedPaymentAmount.getTotalAmount()}"/>
                                </div>
                            </div>
                            </div>
                           
                           
                            <br />
                        </td>
                    </tr>

                 
                    <tr class="tab3">
                        <td><b>Location sketch showing the points of requirement <font
								style="color: rgb(128, 128, 128); font-size: 12px;">(Scale
									not less than 1:400,.dwg file, 5 MB)</font>:<span style="color: red;">*</span>
						</b></td>
                        <td>
                            <input type="file" class="uploadClass" name="file"  />
                        </td>
                    </tr>
                    <tr class="tab3">
                        <td><b>Google map with Lat/Long  <font
								style="color: rgb(128, 128, 128); font-size: 12px;">(.dwg
									file, 5 MB)</font>:<span style="color: red;">*</span>
						</b></td>
                        <td>
                            <input type="file" class="uploadClass" name="file" />
                        </td>
                    </tr>
                   
                    <tr class="tab3">
                        <td width="50%"><b> Ownership proof <font
								style="color: rgb(128, 128, 128); font-size: 12px;">(sale
									deed/ lease deed/ rental deed)</font> self-attested by the applicant
								<font style="color: rgb(128, 128, 128); font-size: 12px;">(
									PDF file, 5 MB)</font>:<span style="color: red;">*</span>
						</b></td>
                        <td width="50%">
                            <input type="file" class="uploadClass" name="file" accept=".pdf" />
                        </td>
            </tr>
            <tr  class="tab3">
            
            <td colspan="2">
             <br/>
            <a> Terms and Conditions</a><br/>
            <ul>
           <li>Those who make early payment will be given priority for consideration.</li>
           <li>TWAD reserves the right to cancel / reject  application or the approval of the connection</li>
           <li>Prioritization of the consumer will be the sole discretion of the Managing Director/TWAD</li>
          </ul>
            <input type="checkbox" id="checkAgreeId" name="checkAgree"/> <b>I Agree</b>
            
            </td>
            
            </tr>

            <tr>

                <td align="center" valign="middle" colspan="2" height="120px;">
                    <input type="button" id="tabBackId" />
                    <input type="button" id="registrationbtnId" name="industrialistSubmitBtn" value="Submit"  />
                    <input type="button" id="tabchangeId" style="margin-right: 185px;"/>

                </td>

            </tr>
            </table>
            </td>
        </tr>
    </table>
</form>
<form style="display: hidden" action="acknowledgement.jsp" method="POST" id="ackHiddenForm">
    <input type="hidden" id="ackApplicationRef" name="applicationRef" value="" />
    <input type="hidden" id="ackCompanyName" name="companyName" value="" />
    <input type="hidden" id="ackApplicantName" name="applicantName" value="" />

</form>

<form style="display: hidden" id="onlineFormId" action="saveOnlinePaymentsDetails.do"  method="POST">
    <input type="hidden"  id="appId" name="appId" value="" />
     <input type="hidden"  id="paymentTypeId" name="paymentType" value="1" />

</form>


</body>
</html>