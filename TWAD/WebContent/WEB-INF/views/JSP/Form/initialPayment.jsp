<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http//www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="library/assets/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="library/assets/css/main.css" />
<link rel="stylesheet" href="library/assets/css/theme.css" />
<!-- <link rel="stylesheet" href="library/assets/css/MoneAdmin.css" /> -->
<link rel="stylesheet"
	href="library/assets/plugins/Font-Awesome/css/font-awesome.css" />
<!--END GLOBAL STYLES -->

<!-- PAGE LEVEL STYLES -->
<link href="library/assets/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

 <script src="library/js/jquery-1.7.2.min.js"></script>
 
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<style>

#myTable td{
padding-left:10px;
}

#myTable td span{
margin-left:10px;
}
.error{
color:red;

}
input[type="button"] {
    border-radius: 10px;
    background-color: #2DAAE1;
    font-weight: bold;
    cursor: pointer;
    padding: 5px 5px 5px 5px;
    width: 100px;
    color: white;
    margin-top: 30px;
}
input[type="text"],select {
	width: 280px;
    height: 40px;
    padding: 5px;
    border: 1px solid #cccccc;
}

input[readonly]{
background-color: #eeeeee;
border: 1px solid #cccccc;
}

.tdPadding{
padding-left:305px;
}

</style>
<script type="text/javascript">

$(document).ready(function(){
	
	$(".ddDateClass").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		maxDate : new Date(),
		showOn : "button",
		buttonImageOnly : true,
		buttonText : "Select date",
		buttonImage : "library/img/datepicker.png",
		showAnim : "slideDown",
	});
 
	
	function validateForm(){
	 
	    var numberReg =  /^[0-9]+$/;
	    var mobileReg =  /^[0-9]{10}$/;
	    var dateReg =  /^\d{2}-\d{2}-\d{4}$/;
	  
	    var paymentTypeId = $('#paymentTypeId');
	    var appId  =	$("#appId");
	    var mobileNumId = $('#mobileNumId');
	     var paymentDDAmountId = $('#paymentDDAmountId');
	    var paymentDDNoId = $('#paymentDDNoId');
	    var paymentDDDateId = $('#paymentDDDateId');
	    var paymentDDBankNameId = $('#paymentDDBankNameId');
	    var paymentDDBranchNameId = $('#paymentDDBranchNameId');
	    var flag = true;
	
	    var inputVal = new Array(paymentTypeId,appId,mobileNumId,paymentDDAmountId,paymentDDNoId,paymentDDDateId,paymentDDBankNameId,paymentDDBranchNameId);
		

	     $('.error').hide();
		for(var i=0;i<inputVal.length;i++){
	        if(inputVal[i].val() == ""){
	        	inputVal[i].after('<span class="error"> This field is required. </span>');
	        	inputVal[i].focus();
	        	flag = false;
	        }
	        else if(inputVal[i].attr('id')=='mobileNumId' && !mobileReg.test(inputVal[i].val())){
	        	inputVal[i].after('<span class="error"> Please enter your correct Mobile No</span>');
	        	inputVal[i].focus();
	        	flag = false;
	        }
	         else if(inputVal[i].attr('id')=='paymentDDAmountId' && !numberReg.test(inputVal[i].val())){
	        	inputVal[i].after('<span class="error"> Please enter DD Amount in Numeric</span>');
	        	inputVal[i].focus();
	        	flag = false;
	        }
	        else if(inputVal[i].attr('id')=='paymentDDNoId' && !numberReg.test(inputVal[i].val())){
	        	inputVal[i].after('<span class="error"> Please enter DD Number in Numeric</span>');
	        	inputVal[i].focus();
	        	flag = false;
	        }
	      
	}


		return flag;
 }
	$('#submitPaymentId').click(function(){
		if(validateForm())
		{
			if(confirm("Are you sure want to Submit ?")){
			$('#loading_image').show();
			var dataString = $('#formId').serialize();
			$.ajax({
				type : "POST",
				url : "saveDDPaymentDtls.do",
				data : dataString,
				async : false,

				success : function(response) {
					response = JSON.parse(response);
					$('#loading_image').hide();
					
					$('#ddAckApplicationRef').val(response.appId);
					$('#ddAckCompanyName').val(response.legCompName);
					$('#ddAckDDAmount').val(response.paymentAmount);
					$('#ddAckDDNo').val(response.ddNo);
					$('#ddAckDDBankName').val(response.ddBankName);
					$('#ddAckDDBranchName').val(response.ddBankBranch);
					$('#ddAckDDDate').val(response.ddDate);
					$('#ddAckPaymentType').val(response.paymentType);
				    $('#ddAckHiddenForm').submit();
				}
				});
		  
			}
		}
		});
	
	$('#paymentTypeId option').attr('disabled',true);
	
	$('#appId,#mobileNumId').blur(function(){
		$('#paymentTypeId option').attr('disabled',true);
		var appId = $('#appId').val();
		var mobileNumId = $('#mobileNumId').val();
		var paymentTypeId = $('#paymentTypeId').val();
		if(appId != "" && mobileNumId != ""){
			$.ajax({
				type : "GET",
				url : "getDDAmount.do",
				/* contentType: "application/json;charset=utf-8",
		        dataType: "json", */
				data : {"appId":appId,"mobileNum":mobileNumId/* ,"paymentType":paymentTypeId */},
				async : false,
                success : function(response) {
                	response = JSON.parse(response);
					$('#legCompNameId').val(response.legCompName);
					$('#paymentDDAmountId').val(response.totalAmount);
					
					var paymentType=response.paymentType;
					$('#paymentTypeId option[value='+paymentType+']').attr('selected',true);
					$('#paymentTypeId option[value='+paymentType+']').removeAttr('disabled');
					
				}
				});
		}
		else{
			return false;
		}
	});
	
/* $('#paymentTypeId').change(function(){
		if($(this).val()!=""){
			$('#mobileNumId').blur();
		}
		else{
			return false;
		}
}); */
	
	
/* $(document).keydown(function (event) {
    if (event.keyCode == 123) { // Prevent F12
        return false;
    } else if (event.ctrlKey && event.shiftKey && event.keyCode == 73) { // Prevent Ctrl+Shift+I        
        return false;
    }
});  */
	
	});
	


</script>

</head>
<body>


<table align="center" style="width: 1200px; font-size: 28px;background-color: white;">

		<tr>
			<td valign="middle" colspan="2" style="height: 130px; width: 100%;">
				<table width="100%">
					<tbody>
						<tr>
							<td width="25%" align="center"><img src="library/img/twad_logo.gif" width="110px"
								height="106px" style="margin-left: 50px;"></td>
							 <td width="50%" align="center"><img src="library/img/middleImage.png" width="770px"
								height="50px"></td>
							<!--<td  width="25%" align="center"><img src="library/img/pic6_2.jpg" width="130px"
								height="130px" style="margin-right: 50px;"></td> -->
							<td></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>


		<tr>



			<td colspan="2" height="10px">

				<div style="padding: 0px; width: 100%;">
					<div
						style="background-image: url(library/img/border_bg.jpg); height: 10px; background-repeat: repeat-x;">
						&nbsp;</div>
				</div>
			</td>
			<td></td>
		</tr>

			
	</table>
	<img src="library/img/loader.gif" style="display: none;" id="loading_image">
	
<table id="statusHeader" align="center" class="table-bordered table table-striped display" style="width: 970px;">

	<tbody><tr>
		<td style="text-align: center; background-color: #FCFCF4; font-size: 25px; height: 10px; color: #800000; font-weight: bold;">Payment</td>
	</tr>
	
</tbody></table>
	<form id="formId" style="width:970px;margin-left: 195px;">
	<table id="initialId" width="100%" align="center" style="margin-left: 0px;">	
	
	<tr><td class="tdPadding" width="50%"><b>Enter Application Ref:</b><span style="color:red;">*</span></td><td><input type="text" placeholder ="Enter Application Ref" id="appId" name="appId" value=""/></td></tr>

<tr><td  class="tdPadding" width="50%">
 
                                <label><b>Mobile Number:</b></label> <span style="color: red;">*</span></td><td>
                                <input placeholder="Ex: 1234567891" type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' id="mobileNumId" name="mobileNum" maxlength="10" data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Mobile No." />
                           
 </td></tr>
<tr><td class="tdPadding" width="50%"><b>Payment Type:</b><span style="color:red;">*</span></td><td>
<select id="paymentTypeId" name="paymentType">
                                    
                                        <option value="1">Application Fee</option>
                                    
                                        <option value="2">Upfront Charges</option>
                                    
                                        <option value="3">Full Payment</option>
                                    
                </select>

</td></tr>	

 
 <tr><td  class="tdPadding" width="50%">
  
                                <label><b>Legal Name of Company:</b></label></td><td>
                                <input placeholder="Ex: ABC Company" type="text" id="legCompNameId" name="legCompName" readonly data-toggle="popover" data-trigger="focus" data-placement="right" title="Enter Company Name" />

                         
 </td></tr>
 <tr><td class="tdPadding" width="50%"><b>DD Amount:</b></td><td>
  <div class="input-group">
                                        <span class="input-group-addon"><img
											src="library/img/RupeeImage.png" /></span>
                                        <input type="text" placeholder ="DD Amount" title="Please enter DD Amount" id="paymentDDAmountId" name="paymentAmount" readonly style="width: 245px;" />
                                    </div>
 
 
 </td></tr>
 <tr><td class="tdPadding" width="50%"><b>DD NO:</b><span style="color:red;">*</span></td><td><input type="text"  placeholder ="123456" title="Please Enter DD No" id="paymentDDNoId" name="ddNo"/></td></tr>
 <tr><td class="tdPadding" width="50%"><b>DD Date:</b><span style="color:red;">*</span></td><td><input type="text"  placeholder ="DD-MM-YYYY" readonly title="Please Enter DD Date" class="ddDateClass" id="paymentDDDateId" name="ddDate"/></td></tr>
 <tr><td class="tdPadding" width="50%"><b>Bank Name:</b><span style="color:red;">*</span></td><td><input type="text"  placeholder ="Ex Indian Bank" title="Please Enter Bank Name" id="paymentDDBankNameId" name="ddBankName"/></td></tr>
  <tr><td class="tdPadding" width="50%"><b>Branch:</b><span style="color:red;">*</span></td><td><input type="text"  placeholder ="Enter Branch Name" title="Please Enter Branch Name" id="paymentDDBranchNameId" name="ddBankBranch"/></td></tr>

<tr><td colspan="2" align="center" style="height: 50px;">
<input type="button" id="submitPaymentId"   value="Submit"/> <a href="/TwadWeb/index.do">Back to Home Page </a>

</td></tr></tbody>

			</table>
			
		</form>
		
		<form style="display: hidden" action="ddAcknowledgement.jsp" method="POST" id="ddAckHiddenForm">
    <input type="hidden" id="ddAckApplicationRef" name="applicationRef" value="" />
    <input type="hidden" id="ddAckCompanyName" name="companyName" value="" />
    <input type="hidden" id="ddAckApplicantName" name="applicantName" value="" />
     <input type="hidden" id="ddAckDDAmount" name="ddAmount" value="" />
      <input type="hidden" id="ddAckDDNo" name="ddNo" value="" />
      <input type="hidden" id="ddAckDDBankName" name="ddBankName" value="" />
      <input type="hidden" id="ddAckDDBranchName" name="ddBranchName" value="" />
       <input type="hidden" id="ddAckDDDate" name="ddDate" value="" />
    <input type="hidden" id="ddAckPaymentType" name="paymentType" value="" />

</form>
		
		
			</body>
			</html>