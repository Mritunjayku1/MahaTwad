<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  
    <!--END GLOBAL STYLES -->

    <!-- PAGE LEVEL STYLES -->
    <link href="library/assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" href="library/assets/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="library/assets/css/main.css" />
    <link rel="stylesheet" href="library/assets/css/theme.css" />
    <link rel="stylesheet" href="library/assets/css/MoneAdmin.css" />
    <link rel="stylesheet" href="library/assets/plugins/Font-Awesome/css/font-awesome.css" />
	    <link rel="stylesheet" href="library/assets/plugins/validationengine/css/validationEngine.jquery.css" />

<style>
.bg_heading {
	text-align: left;
    font-size: 20px;
    color: white;
    margin-top: -32px;
    margin-left: 195px;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}
/* #menu3{
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
} */
input[type="search"]{
height:30px !important;
}

 input[type="file"] {
    width: 330px;
    height: 35px;
    padding-top:9px;
    }

#paymentTable input[type="text"] {
	width: 300px;
    height: 35px;
    padding: 5px;
}



#paymentTable input[type="button"] {
	width: 100px;
    height: 30px;
}

select {
	width: 300px;
    height: 35px;
    padding: 5px;
}

#successMessage {
	margin-left: 450px;
	z-index: 20000;
	margin-top: 20px;
	position: absolute;
	color: green;
}

.error {
	color: red;
}
</style>
<script src='JS/complaints/searchComplaints.js'></script>

<script type="text/javascript">

function validateAddForm() {
	  	var numberReg = /^[0-9]*$/;

	  	var paymentTypeId = $("#paymentTypeId");
	  	var paymentAmount = $("#paymentAmountId");
	  	var gstPercent = $("#gstPercentId");
	  	
	  	

	  	var inputVal = new Array(paymentTypeId,paymentAmount,gstPercent);

	  	$('.error').hide();
	  	flag = true;
	  	for (i = 0; i < inputVal.length; i++) {
	  		if (inputVal[i].val() == "") {
	  			inputVal[i]
	  					.after('<br/><span class="error"> This field is required. </span>');
	  			inputVal[i].focus();
	  			flag = false;
	  		} 
	  		
	  		else if (inputVal[i].attr('id') == 'paymentAmountId' &&  !numberReg.test(inputVal[i].val())) {
	  			inputVal[i].after('<br/><span class="error"> Please enter Amount in Numeric only. </span>');
	  			inputVal[i].focus();
	  			flag = false;
	  		}
	  		else if (inputVal[i].attr('id') == 'gstPercentId' &&  !numberReg.test(inputVal[i].val())) {
	  			inputVal[i].after('<br/><span class="error"> Please enter GST Percent in Numeric only. </span>');
	  			inputVal[i].focus();
	  			flag = false;
	  		}
	  		
	  		
	  	}
	  	return flag;
	  }



$(function() {
	var appId="";
	var companyPaymentDtlID="";
	var legCompName="";
	var contactPersonName="";
	
	var headerList = "class1,class2,class3,class4,class5,class22,class23,class10".split(',');
	/* 
	$.ajax({
		type:"GET",
		url:"getHeaderList.do",
		async:false,
		data:{
			
			'appId':'1'
			
		},
		success:function(response){
			headerList=response.split(',');
		}
	}); */
	
	
	$('#dataTables-example').find('th[class]').hide();
	$('#dataTables-example').find('td[class]').hide();
	for (var i = 0; i < headerList.length; i++) {
		 $('.'+headerList[i]).show();
	}
	
	$('#showHeaderList').click(function(){
		$('#headerListId').css('display','block');
		for (var i = 0; i < headerList.length; i++) {
			 $('#'+headerList[i]).attr('checked',true);
		}
	});
	
	$('#previewHeaderButton').click(function(){
		$('#dataTables-example').find('th[class]').hide();
		$('#dataTables-example').find('td[class]').hide();
	    $('#headerListId td input:checkbox:checked').each(function(){
		   var id=$(this).attr('id');
		   $('.'+id).show();
		   $('#headerListId').css('display','none');
	});	
	});
	
	$('#saveHeaderButton').click(function(){
		var headerList = "";
		 $('#headerListId td input:checkbox:checked').each(function(){
			   headerList= headerList +","+$(this).attr('id');
		 });
		$.ajax({
			type:"POST",
			url:"eeSaveHeaderList.do",
			async:false,
			data:{
				
				'appId':'1',
				'paymentDesc':headerList.substring(1)
				
			},
			success:function(response){
				alert(response);
				window.location.reload();
			}
		});
	});
	
	$(".receiptDate").val($.datepicker.formatDate('dd-mm-yy', new Date()));
	
	$('input[name="approveBtn"]').click(function(){
		var appIdArray = $(this).attr("id").split("_");
		appId =  appIdArray[1];
		companyPaymentDtlID=appIdArray[2];
		legCompName=appIdArray[3];
		contactPersonName=appIdArray[4];
		
		 var payment=$('#payment_'+appId).text();
		if(payment == null || payment=='')
		{
		alert("Application fee not paid !")
		return false;
		}
		
		$('#appId').val(appId);
		$('#legCompName').val(legCompName);
		$('#contactPersonName').val(contactPersonName);
		
		
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'600px','modal':'true'});
		/* $('#paymentTypeId option[value="1"]').attr('disabled',true);
		$('#paymentTypeId option[value="3"]').attr('disabled',true);
		$('#paymentTypeId option[value="2"]').attr('selected',true);
		$('#paymentAmountId').focus(); */
		
		/* $.ajax({
			type : "GET",
			url : "getUpfrontCharges.do",
			data : {"appId":appId},
			async : false,
            success : function(response) {
            	response = JSON.parse(response);
				$('#gstPercentId').val(response.gstPercent);
				$('#paymentAmountId').val(response.upfrontCharges);
				
			}
			});
		 */
	}); 
	
	$('.closeBtn,.imgClose').click(function(){
		$(".ui-dialog-content").dialog("close");
		
	}); 

	/* $('#paymentAmountId').blur(function(){
		var paymentAmount = $(this).val();
		var gstAmount = $('#gstAmountId').val();
		var gstPercent = $('#gstPercentId').val();
		if(paymentAmount!="" && gstAmount==0 && gstPercent != "" && gstPercent != 0){
			var gstAmount = paymentAmount*gstPercent/100;
			$('#gstAmountId').val(gstAmount);
		}
		else{
			$('#gstAmountId').val(0);
		}
		if(paymentAmount!="" && !Number.isNaN(paymentAmount) && !Number.isNaN(gstAmount)){
			$('#totalAmountId').val(parseInt(paymentAmount)+parseInt(gstAmount));
		}
		else{
			$('#totalAmountId').val(0);
		}
	});

	$('#gstPercentId').blur(function(){
		var paymentAmount = $('#paymentAmountId').val();
		var gstPercent = $('#gstPercentId').val();
		
		if(paymentAmount!="" && !Number.isNaN(paymentAmount) && gstPercent != "" && !Number.isNaN(gstPercent)){
			var gstAmount = paymentAmount*gstPercent/100;
			$('#gstAmountId').val(gstAmount);
			$('#totalAmountId').val(parseInt(paymentAmount)+parseInt(gstAmount));
		}
		else{
			$('#gstAmountId').val(0);
			$('#totalAmountId').val(0);
		}
	});

 */

	$('#paymentSaveBtnId').click(function(){
		if(validateAddForm()){
			
			$("#paymentSaveBtnId").prop("disabled", true);
   			// localStorage.setItem('isFileUploaded', true);
   	        var form = $('#uploadFormId')[0];
   	        var data = new FormData(form);

   	        $.ajax({
   	            type: "POST",
   	            enctype: 'multipart/form-data',
   	            async:false,
   	            url: "uploadMultipleFileByAdmin.do",
   	            data: data,
   	            processData: false,
   	            contentType: false,
   	            cache: false,
   	            timeout: 600000,
   	            success: function (response) {
   	         	alert(response);
   	               // $("#btnSubmit").prop("disabled", false);

   	            },
   	        });
   		 
   	    
		$.ajax({
			type:"POST",
			url:"eeAddPayment.do",
			async:false,
			data:{
				
				'appId':appId,
				/* 'paymentType':$('#paymentTypeId').val(),
				'paymentAmount':$('#paymentAmountId').val(),
				'gstPercent':$('#gstPercentId').val(),
				'gstAmount':$('#gstAmountId').val(), */
				'totalAmount':$('#totalAmountId').val(),
				'receiptDate':$('#receiptDate_'+appId).val(),
				'inspectedDate':$('#inspectionDateId').val(),
				'referenceFile':$('#referenceFileId').val(),
				'referenceDate':$('#referenceDateId').val(),
				'paymentDesc':$('#paymentDescId').val(),
				'legCompName':$('#legCompName').val(),
				'contactPersonName':$('#contactPersonName').val(),
				'companyPaymentDtlID':companyPaymentDtlID
				
			
			},
			success:function(response){
				alert(response);
				
				window.location.reload();
			}
		});
		}
	});

	
	
	
	
	/* $('input[name="approveBtn"]')
			.click(
					function() {
						var appRef = $(this).attr('id');
						var inspectionDate = $(this).closest('tr').find(
								'td:nth-child(7)').find(
								'input[type="text"]').val();
						if (inspectionDate == null || inspectionDate == '') {
							alert("Please select  inspection Date !")
							return false;
						}
						if (confirm("Are you sure want to Submit ?")) {
							$.ajax({
								type : "POST",
								url : "eeSendInspectionDate.do",
								data : {
									'appRef' : appRef,
									'inspectionDate' : inspectionDate
								},
								success : function(response) {
									//$('#successMessage').text(response);
									alert(response);
									window.location.reload();

								}
							});
						}

					}); */
	$(".inspectionDate").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		//maxDate : new Date(),
		showOn : "button",
		minDate : 0,
		maxDate : "+2Y",
		buttonImageOnly : true,
	//	buttonText : "Select date",
		buttonImage : "library/img/datepicker.png",
		showAnim : "slideDown",
	});

});












$(function(){
	/* $('input[name="approvedBtn"]').click(function(){
		//alert(1);
		var approvedAppRef = $(this).attr('id');
		var appId = approvedAppRef.split("_");
		var managementComments=$('#managementComments_'+appId[1]).val();
		if(managementComments == null || managementComments=='')
		{
		alert("Please enter the Comments !")
		return false;
		}
		if(confirm("Are you sure want to Approve ? ")){
		$.ajax({
			type:"POST",
			url:"eePaymentPendingApproved.do",
			data:{'appId':appId[1],'paymentTypeDesc':managementComments,'companyPaymentDtlID':appId[2]},
			success:function(response){
				alert(response);
				window.location.reload();
				
			}
		});
		}
		
	}); */
	$('button[name="rejectedBtn"]').click(function(){
		var approvedAppRef = $(this).attr('id');
		var appId = approvedAppRef.split("_");
		var managementComments=$('#managementComments_'+appId[1]).val();
		if(managementComments == null || managementComments=='')
		{
		alert("Please enter the Comments !")
		return false;
		}
		if(confirm("Are you sure want to Reject ? ")){
		$.ajax({
			type:"POST",
			url:"ddPaymentRejected.do",
			data:{'appId':appId[1],'managementComments':managementComments,'companyPaymentDtlID':appId[2]},
			success:function(response){
				alert(response);
				window.location.reload();
				
			}
		});
		}
		
	});
});





</script>

<div id="addDialog" style="display: none;">
<form id="uploadFormId" method="POST" enctype="multipart/form-data">
<input type="hidden" name="appId" id="appId" value=''/>
<input type="hidden" name="legCompName" id="legCompName" value=''/>
<input type="hidden" name="contactPersonName" id="contactPersonName" value=''/>
<img class="imgClose" src="library/img/Close_SMS.png"
		style="width: 40px; border-width: 0px; float: right; margin-top: -11px; margin-right: -5px; cursor: pointer;">
	<h2 class="bg_heading">Pre-Feasability Details</h2>
	<table id="paymentTable" style="margin-left: 30px;margin-top: 20px;">
<%-- 	<tr><td><span><b>Payment Type:</b></span><span style="color: red;">*</span></td><td>
			<select  id="paymentTypeId">
                                <c:forEach items="${list.paymentTypeDtl}" var="app" varStatus="count">
                                    <option value="${app.getPaymentId()}">${app.getPaymentType()}</option>
                                </c:forEach>
            </select></td></tr>
			
<tr><td><span><b>Payment Amount:</b></span><span style="color: red;">*</span></td><td>

			<input placeholder="Ex: 100" type="text" id="paymentAmountId" name="paymentAmount" style=""/></td></tr>

<tr><td><span><b>GST %:</b></span><span style="color: red;">*</span></td><td>
			<input placeholder="Ex: 10" type="text" id="gstPercentId" name="gstPercent" style="" value=""  readonly="readonly" style="background-color: lightgrey;"/></td></tr>

<tr><td><span><b>GST Amount:</b></span></td><td>
			<input placeholder="Ex: 12" type="text" id="gstAmountId" name="gstAmount" readonly="readonly" value="0" style="background-color: lightgrey;"/></td></tr>
 --%>
<tr><td><span><b>Upfront Charges:</b></span></td><td>
			<input placeholder="Ex: 123" type="text" id="totalAmountId" name="totalAmount"/></td></tr>


<tr><td><span><b>Inspection Date:</b></span></td><td>
<input placeholder="Ex: DD-MM-YYYY" type="text" class="inspectionDate"  id="inspectionDateId" name="inspectionDate" readonly="readonly"  style="background-color: lightgrey;"/>
</td></tr>

<tr><td><span><b>Reference File:</b></span></td><td>
			<input placeholder="Reference File" type="text" id="referenceFileId" name="referenceFile"  /></td></tr>

<tr><td><span><b>Reference Date:</b></span></td><td>
<input placeholder="Ex: DD-MM-YYYY" type="text" class="inspectionDate"  id="referenceDateId" name="referenceDate" readonly="readonly"  style="background-color: lightgrey;"/>
</td></tr>


<tr><td colspan="2"><hr style="margin: 0px;width: 95%;"/></td></tr>

<tr><td><span><b>Upload Pre feasibility report:</b></span></td><td><input type="file" name="file" accept=".doc,.docx,.dwg,.pdf,.txt,.xlsx,.xls"></td></tr>

<!-- <tr><td><span><b>Upload consent form:</b></span></td><td><input type="file" name="file" accept=".doc,.docx,.dwg,.pdf,.txt,.xlsx,.xls"></td></tr> -->

<tr><td colspan="2"><hr  style="margin-top: 5px;width: 95%;"/></td></tr>
 
<tr><td><span><b>Remarks:</b></span></td><td>
			<input placeholder="Ex: ABC" type="text" id="paymentDescId" name="paymentDesc" style=""/></td></tr>
		<tr><td colspan="2" align="center" height="70px">	<input type="button" value="Save" id="paymentSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/></td></tr>
	
	

	</table>
	
	</form>		
	</div>
	
	<div id="headerListId" style="position: absolute;left:375px;top:285px;z-index:200;display:none;background-color: #FCFCF4; width:600px;">

	<table  width="100%" class="table table-striped table-bordered table-hover">
	<tr> <td colspan="6">  </td></tr>
		<tr>
			<td width="5%" ><input type="checkbox" id="class1" /></td>
			<td width="27%" style="color: black !important"><b>App Ref#</b></td>
			<td width="5%"><input type="checkbox" id="class11" /></td>
			<td width="27%" style="color: black !important"><b>Branch Name</b></td>
			<td width="5%"><input type="checkbox" id="class10" /></td>
		    <td width="27%" style="color: black !important"><b>Receipt Date</b></td>
		   
			
		</tr>
		<tr>
	        <td><input type="checkbox" id="class2" /></td>
		    <td style="color: black !important"><b>Name of Company</b></td>
		    <td><input type="checkbox" id="class12" /></td>
			<td style="color: black !important"><b>Mobile Number</b></td>
			 <td><input type="checkbox" id="class20" /></td>
			<td style="color: black !important"><b>Work Type</b></td>
		</tr>
		<tr>
                                            
		    <td><input type="checkbox" id="class3" /></td>
		    <td style="color: black !important"><b>Name of Person</b></td>
		    <td><input type="checkbox" id="class13" /></td>
			<td style="color: black !important"><b>Email Id</b></td>
			 <td><input type="checkbox" id="class9" /></td>
		    <td style="color: black !important"><b>Payment Status</b></td>
		    
		</tr>
		<tr>
                                             
		    <td><input type="checkbox" id="class4" /></td>
		    <td style="color: black !important"><b>Division Name</b></td>
		    <td><input type="checkbox" id="class14" /></td>
			<td style="color: black !important"><b>District</b></td>
			<td><input type="checkbox" id="class19" /></td>
		    <td style="color: black !important"><b>REQs of water</b></td>
		</tr>
		<tr>
                                              
		    <td><input type="checkbox" id="class5" /></td>
		    <td style="color: black !important"><b>Total Payment Amount</b></td>
		    <td><input type="checkbox" id="class15" /></td>
			<td style="color: black !important"><b>Taluk</b></td>
			<td><input type="checkbox" id="class8" /></td>
		    <td style="color: black !important"><b>DD Bank Name</b></td>
		  
		</tr>
		<tr>
                                            
		    <td><input type="checkbox" id="class6" /></td>
		    <td style="color: black !important"><b>DD NO</b></td>
		    <td><input type="checkbox" id="class16" /></td>
			<td style="color: black !important"><b>Village</b></td>
			 <td><input type="checkbox" id="class18" /></td>
			<td style="color: black !important"><b>Is this New Connection?</b></td>
		</tr>
		<tr>
                                            
		    <td><input type="checkbox" id="class7" /></td>
		    <td style="color: black !important"><b>DD Date</b></td>
		    <td><input type="checkbox" id="class17" /></td>
			<td style="color: black !important"><b>Survey Field No</b></td>
			 <td><input type="checkbox" id="class21" /></td>
			<td style="color: black !important"><b>Site Address</b></td>
		</tr>
		<tr>
                                             
		   
		</tr>
		
		
		<tr><td colspan="6" style="text-align: center;"><input type="Button" value="Preview Header" id="previewHeaderButton"/><input type="Button" value="Save Header" id="saveHeaderButton" style="margin-left: 10px;"/></td></tr>
	
	
	</table>
	
	</div>
	
<table class='table-bordered table table-striped display'
	style='width: 100%; font-size: 28px;'>
<tr>
		<td colspan='8'
			style='text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;'>
			Pending Application fee</td>
	</tr>
</table>

        <div id="content" style="margin-left: 0px !important">
<div id="successMessage"></div>
            <div class="inner">
                <div class="row">
                    
                </div>

               


                <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        
                        <div class="panel-body">
                        <div  id="showHeaderList" title="Update Table Header" style="display:none;'position: absolute;top:20px;left:600px;z-index:100"><input type="button" value="Modify Table Header"/></div>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                           <!--  <th style="color:black !important"></th> -->
                                            <th class="class1" style="color:black !important"><b>App Ref#</b></th>
                                            <th class="class2" style="color:black !important"><b>Name of Company</b></th>
                                             <th class="class3" style="color:black !important"><b>Name of Person</b></th>
                                              <th class="class4" style="color:black !important"><b>Division Name</b></th>
                                            <th class="class5" style="color:black !important"><b>Total Payment Amount</b></th>
                                             <th class="class22" style="color:black !important"><b>Transaction Ref No</b></th>
                                            <th class="class23" style="color:black !important"><b>Bank Ref No</b></th>
                                            <th class="class6" style="color:black !important"><b>DD NO</b></th>
                                             <th class="class7" style="color:black !important"><b>DD Date</b></th>
                                            <th class="class8" style="color:black !important"><b>DD Bank Name</b></th>
                                            <th class="class9" style="color:black !important"><b>Payment Status</b></th>
                                            
                                              <th class="class11" style="color:black !important"><b>Branch Name</b></th>
                                            <th class="class12" style="color:black !important"><b>Mobile Number</b></th>
                                             <th class="class13" style="color:black !important"><b>Email Id</b></th>
                                              <th class="class14" style="color:black !important"><b>District</b></th>
                                            <th class="class15" style="color:black !important"><b>Taluk</b></th>
                                            <th class="class16" style="color:black !important"><b>Village</b></th>
                                             <th class="class17" style="color:black !important"><b>Survey Field No</b></th>
                                            <th class="class18" style="color:black !important"><b>Is New Connection</b></th>
                                            <th class="class19" style="color:black !important"><b>REQs of water</b></th>
                                             <th class="class20" style="color:black !important"><b> Work Type</b></th>
                                              <th class="class21" style="color:black !important"><b>Site Address</b></th>
                                            <th class="class10" style="color:black !important"><b>Receipt Date</b></th>
                                            
                                            
                           
                                              <th></th>
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                     <c:forEach items="${list.appBean}" var="app" >
          
          							
          									 
          								<tr class="odd gradeX">
          							<td class="class1" > <a href="EEViewForm.do?appId=${app.getAppId()}" style="color: rgb(128,128,128)">${app.getAppId()}</a></td>
                                            <td class="class2" >${app.getLegCompName()}</td>
                                            
                                             <td class="class3" >${app.getContactPersonName()}</td>
                                             <td class="class4" >${app.getDivisionName()}</td>
                                               <td class="class5"  id="payment_${app.getAppId()}">${app.getPaymentAmount()}</td>
                                                <td class="class22" >${app.getTransactionRefNo()}</td>
                                             <td class="class23" >${app.getBankRefNo()}</td>
                                                <td class="class6"  id="ddNo_${app.getAppId()}">${app.getDdNo()}</td>
                                                 <td class="class7" >${app.getDdDate()}</td>
                                                  <td class="class8" >${app.getDdBankName()}</td>
                                                   <td class="class9" >${app.getPaymentStatusDisplay()}</td>
                                                   
                                             <td class="class11" >${app.getDdBankBranch()}</td>
                                             <td class="class12" >${app.getMobileNum()}</td>
                                            
                                             <td class="class13" >${app.getEmailAddr()}</td>
                                             <td class="class14" >${app.getDistrict()}</td>
                                             <td class="class15" >${app.getTaluk()}</td>
                                             <td class="class16" >${app.getVillage()}</td>
                                             <td class="class17" >${app.getSurveyFieldNo()}</td>
                                             <td class="class18" >${app.getIsNewConnection()}</td>
                                             <td class="class19" >${app.getReqMld()}</td>
                                             <td class="class20" >${app.getWorkTypeDisplay()}</td>
                                             <td class="class21" >${app.getDoorNo()} ${app.getPlotNo()} ${app.getStreetName()} ${app.getLocation()} ${app.getPinCode()}</td>
                                           
                                             <td class="class10" class="center"><input type="text" title="dd-mm-yyyy" id="receiptDate_${app.getAppId()}"  class="receiptDate" style="width: 100px;height: 25px;"/></td>
                                             <%--  <td class="center"><textarea id="managementComments_${app.getAppId()}" name="managementComments" style="width:100%;height:100%;"></textarea></td> --%>
                                              <td><input type="button" class="paymentClass"
												name="approveBtn" id="approved_${app.getAppId()}_${app.getCompanyPaymentDtlID()}_${app.getLegCompName()}_${app.getContactPersonName()}"
												value="Upload Pre-feasibility report" /></td>
                                             <!--  <td class="center"> -->
                                             <%--  <input type="button" class="paymentClass" id="approved_${app.getAppId()}_${app.getCompanyPaymentDtlID()}" name="approvedBtn" style="width: auto;" value="Approved"/> --%>
											 <%--  <button class="cancelbtn" id="rejected_${app.getAppId()}_${app.getCompanyPaymentDtlID()}" name="rejectedBtn" style="width: auto;">Rejected</button> --%>
											<!--   </td> -->
                                           
                                        </tr>	 
          									 
          							 </c:forEach>
                          
                                    </tbody>
                                </table>
                            </div>
                           
                        </div>
                    </div>
                </div>
            </div>
			

            </div>




        </div>
       <!--END PAGE CONTENT -->
<c:choose>
	<c:when test="${!empty list.results}">

		<table
			class='jDataTable table-bordered table tabel-striped bootstrap-datatable display'
			id='tblSearchcomplaintTable'>
			<thead>
				<tr>
					<th><spring:message code="label.complaintNumber" /></th>
					<th><spring:message code="label.channel" /></th>
					<th style='min-width:150px;'><spring:message code="label.recievedDateTime" /></th>
					<th><spring:message code="label.content" /></th>
					<th><spring:message code="label.status" /></th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</c:when>
	<c:otherwise>

		<div id='alertBox' style='display: none;'>
			<h3>No Records found</h3>
		</div>
		<%
			if (request.getParameter("isSumbitted") != null
							&& "Y".equals(request.getParameter("isSumbitted"))) {
		%>
		<script>
			$('#alertBox').show();
			$("#alertBox").dialog({
				resizable : false,
				height : 115,
				width : "30%",
				modal : true,
				position : 'center',
				title : "Information",
				closeOnEscape : false,
				dialogClass : "noclose",
				buttons : {
					"Ok" : function() {
						$(this).dialog("close");
					}
				}
			});
		</script>
		<%
			}
		%>
	</c:otherwise>
</c:choose>

<!-- PAGE LEVEL SCRIPTS -->
    <script src="library/assets/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="library/assets/plugins/dataTables/dataTables.bootstrap.js"></script>
     <script>
         $(document).ready(function () {
             $('#dataTables-example').dataTable();
         });
    </script>
     <!-- END PAGE LEVEL SCRIPTS -->