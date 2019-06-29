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

a{
cursor:pointer;
}
#menu3{
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}

.bg_heading {
	text-align: left;
    font-size: 20px;
    color: white;
    margin-top: -32px;
    margin-left: 135px;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}

input[type="search"]{
height:30px !important;
}
input[type="text"]{
height:25px !important;
}

.error {
	color: red;
}
#successMessage{
	margin-left: 450px;
    z-index: 20000;
    margin-top: 20px;
    position: absolute;
    color: green;
    }
</style>
<script src='JS/complaints/searchComplaints.js'></script>

<script type="text/javascript">

$(function(){
var paymentlist = "";

$('#paymentAmountId').blur(function(){
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

$('#editPaymentAmountId').blur(function(){
	var paymentAmount = $(this).val();
	var gstAmount = $('#editGstAmountId').val();
	var gstPercent = $('#editGstPercentId').val();
	if(paymentAmount!="" && gstAmount==0 && gstPercent != "" && gstPercent != 0){
		var gstAmount = paymentAmount*gstPercent/100;
		$('#editGstAmountId').val(gstAmount);
	}
	else{
		$('#editGstAmountId').val(0);
	}
	if(paymentAmount!="" && !Number.isNaN(paymentAmount) && gstPercent != "" && !Number.isNaN(gstAmount)){
		$('#editTotalAmountId').val(parseInt(paymentAmount)+parseInt(gstAmount));
	}
	else{
		$('#editTotalAmountId').val(0);
	}
});



$('#editGstPercentId').blur(function(){
	var paymentAmount = $('#editPaymentAmountId').val();
	var gstPercent = $('#editGstPercentId').val();
	if(paymentAmount!="" && !Number.isNaN(paymentAmount) && gstPercent != "" && !Number.isNaN(gstPercent)){
		var gstAmount = paymentAmount*gstPercent/100;
		$('#editGstAmountId').val(gstAmount);
		$('#editTotalAmountId').val(parseInt(paymentAmount)+parseInt(gstAmount));
	}
	else{
		$('#editGstAmountId').val(0);
		$('#editTotalAmountId').val(0);
	}
});



$('#dataTables-example input:checkbox').each(function(){
	 paymentlist =  paymentlist +","+$(this).closest('tr').find('td:nth-child(3)').text();
});

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


function validateEditForm() {
	var numberReg = /^[0-9]*$/;
	var editPaymentTypeId = $("#editPaymentTypeId");
	var editPaymentAmount = $("#editPaymentAmountId");
	var editGstPercent = $("#editGstPercentId");
	
	

	var inputVal = new Array(editPaymentTypeId,editPaymentAmount,editGstPercent);

	$('.error').hide();
	flag = true;
	for (i = 0; i < inputVal.length; i++) {
		if (inputVal[i].val() == "") {
			inputVal[i]
					.after('<br/><span class="error"> This field is required. </span>');
			inputVal[i].focus();
			flag = false;
		} 
		
		else if (inputVal[i].attr('id') == 'editPaymentAmountId' &&  !numberReg.test(inputVal[i].val())) {
			inputVal[i].after('<br/><span class="error"> Please enter Amount in Numeric only. </span>');
			inputVal[i].focus();
			flag = false;
		}
		else if (inputVal[i].attr('id') == 'editGstPercentId' &&  !numberReg.test(inputVal[i].val())) {
			inputVal[i].after('<br/><span class="error"> Please enter GST Percent in Numeric only. </span>');
			inputVal[i].focus();
			flag = false;
		}
		
		
	}
	return flag;
}





$("#all").click(function(){
    $('#dataTables-example input:checkbox').not(this).prop('checked', this.checked);
});

$('#dataTables-example input:checkbox').click(function(){
var numberOfChecked = $('#dataTables-example input:checkbox:checked').length;

var numberOfCheckbox = $('#dataTables-example input:checkbox').length;
if(numberOfChecked==(numberOfCheckbox-1)){
	 $('#all').prop('checked', this.checked);
}
});

$('#addPayment').click(function(){
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'500px','modal':'true'});
	}); 
$('#editPayment').click(function(){
	$(".ui-dialog-content").dialog("close");
	var numberOfChecked = $('#dataTables-example td input:checkbox:checked').length;
	if(numberOfChecked==1){
	$( "#editDialog" ).dialog({ 'width':'500px','modal':'true'});
	
	$('#dataTables-example td input:checkbox:checked').each(function(){
		$('#editPaymentId').val($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim());
		$('#editPaymentTypeId option[value="'+$(this).closest('tr').find('td:nth-child(3)').attr('id').trim()+'"]').attr('selected', 'selected');
		$('#editPaymentAmountId').val($(this).closest('tr').find('td:nth-child(4)').text());
		$('#editGstPercentId').val($(this).closest('tr').find('td:nth-child(5)').text());
		$('#editGstAmountId').val($(this).closest('tr').find('td:nth-child(6)').text());
		$('#editTotalAmountId').val($(this).closest('tr').find('td:nth-child(7)').text());
		$('#editPaymentDescId').val($(this).closest('tr').find('td:nth-child(8)').text());
		
		paymentlist = paymentlist.replace($(this).closest('tr').find('td:nth-child(4)').text().trim(),"");
		
	});
	}
	else{
		alert("Please select only one Payment to Edit");
	}
	
	
	
}); 
$('.closeBtn,.imgClose').click(function(){
	$(".ui-dialog-content").dialog("close");
	
}); 


$('#paymentSaveBtnId').click(function(){
	if(validateAddForm()){
	$.ajax({
		type:"POST",
		url:"addPayment.do",
		data:{
			'paymentType':$('#paymentTypeId').val(),
			'paymentAmount':$('#paymentAmountId').val(),
			'gstPercent':$('#gstPercentId').val(),
			'gstAmount':$('#gstAmountId').val(),
			'totalAmount':$('#totalAmountId').val(),
			'paymentDesc':$('#paymentDescId').val()},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});

$('#editPaymentBtn').click(function(){
	if(validateEditForm()){
	$.ajax({
		type:"POST",
		url:"editPayment.do",
		data:{
			'paymentId':$('#editPaymentId').val(),
			'paymentType':$('#editPaymentTypeId').val(),
			'paymentAmount':$('#editPaymentAmountId').val(),
			'gstPercent':$('#editGstPercentId').val(),
			'gstAmount':$('#editGstAmountId').val(),
			'totalAmount':$('#editTotalAmountId').val(),
			'paymentDesc':$('#editPaymentDescId').val()},
		success:function(response){
			alert(response);
			window.location.reload();
			
			
		}
	}); 
	}
	
});

$('#deletePayment').click(function(){
	var paymentList = "";
	var paymentNameList = "";
	$('#dataTables-example input:checkbox:checked').each(function(){
		if($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id')!=undefined){
		  paymentList = paymentList +","+$(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim();
		  paymentNameList = paymentNameList +","+$(this).closest('tr').find('td:nth-child(3)').text().trim();
		}
	});
	if(confirm("Are you sure want to Delete these Payment "+paymentNameList.substring(1)+" ? ")){
	$.ajax({
		type:"POST",
		url:"deletePayment.do",
		data:{
			'paymentId':paymentList.substring(1)},
		success:function(response){
			alert(response);
			window.location.reload();
			
			
		}
	});
	}
});
});




</script>




<table class='table-bordered table table-striped display'
	style='width: 100%; font-size: 28px;'>
<tr>
		<td colspan='8'>
			<a href="#" style="padding: 10px;background-color: #78C948;color:white;" id="addPayment">Add Payment</a>
			<a style="padding: 10px;background-color: #FEBA17;color:white;" id="editPayment">Edit</a>
			<a style="padding: 10px;background-color: #EE3B41;color:white;" id="deletePayment">Delete</a>
			
			</td>
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
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                           <!--  <th style="color:black !important"></th> -->
                                            <th style="color:black !important"><input type="checkbox" id="all" style="width:15px;"/></th>
                                            <th style="color:black !important"><b> #</b></th>
                                             <th style="color:black !important"><b> App Ref</b></th>
                                             <th style="color:black !important"><b> Payment Type</b></th>
                                            <th style="color:black !important"><b>Payment Amount</b></th>
                                             <th style="color:black !important"><b>GST Percent</b></th>
                                              <th style="color:black !important"><b>GST Amount</b></th>
                                               <th style="color:black !important"><b>Total Amount</b></th>
                                            <th style="color:black !important"><b>Description</b></th>
                                           
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    
                                    
                                     <c:forEach items="${list.paymentDtl}" var="app" varStatus="count" >
          
                                               <tr class="odd gradeX">
          								
          							
                                            <td><input type="checkbox" id="${app.getPaymentId()}" style="width:15px;"/></td>
                                            <td>${count.count}</td>
                                             <td>${app.getAppId()}</td>
                                             <td id="${app.getPaymentTypeId()}">${app.getPaymentType()}</td>
                                             <td>${app.getPaymentAmount()}</td>
                                              <td>${app.getGstPercent()}</td>
                                               <td>${app.getGstAmount()}</td>
                                                <td>${app.getTotalAmount()}</td>
                                             <td>${app.getPaymentDesc()}</td>
                                           
                                           
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

<div id="addDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Add New Payment</h2>
		
<span><b>Payment Type:</b></span><span style="color: red;">*</span>
				<select style="width: 200px;margin-left:45px;" id="paymentTypeId">
				 <option value="">--Select Payment Type--</option>
                                    <c:forEach items="${list.paymentTypeDtl}" var="app" varStatus="count">
                                        <option value="${app.getPaymentId()}">${app.getPaymentType()}</option>
                                    </c:forEach>
                </select><br/>
				
<span><b>Payment Amount:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="paymentAmountId" name="paymentAmount" style="margin-left:25px;"/><br/>

<span><b>GST %:</b></span><span style="color: red;">*</span>
				<input type="text" id="gstPercentId" name="gstPercent" style="margin-left:95px;" value="0"/><br/>

<span><b>GST Amount:</b></span>
				<input placeholder="Ex: 12" type="text" id="gstAmountId" name="gstAmount" readonly="readonly" value="0" style="margin-left:65px;background-color: lightgrey;"/><br/>

<span><b>Total Amount:</b></span>
				<input placeholder="Ex: 123" type="text" id="totalAmountId" name="totalAmount" readonly="readonly" value="0" style="margin-left:58px;background-color: lightgrey;"/><br/>

<span><b>Payment Description:</b></span>
				<input placeholder="Ex: ABC" type="text" id="paymentDescId" name="paymentDesc" style="margin-left: 7px;"/><br/>
				<input type="button" value="Save" id="paymentSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>
				
		</div>
		
		
		<div id="editDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Edit Payment</h2>
				<input type="hidden" id="editPaymentId"/>
				
<span><b>Payment Type:</b></span><span style="color: red;margin-left: 45px;">*</span>
				<select style="width: 200px;" id="editPaymentTypeId">
				 <option value="">--Select Payment Type--</option>
                                    <c:forEach items="${list.paymentTypeDtl}" var="app" varStatus="count">
                                        <option value="${app.getPaymentId()}">${app.getPaymentType()}</option>
                                    </c:forEach>
                </select><br/>
				
<span><b>Payment Amount:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editPaymentAmountId" name="editPaymentAmount" style="margin-left:25px;" /><br/>


<span><b>GST Percent:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: 10" type="text" id="editGstPercentId" name="editGstPercent" style="margin-left:60px;"/><br/>

<span><b>GST Amount:</b></span>
				<input placeholder="Ex: 100" type="text" id="editGstAmountId" name="editGstAmount" readonly="readonly" style="margin-left:65px;background-color: lightgrey;"/><br/>

<span><b>Total Amount:</b></span>
				<input placeholder="Ex: 100" type="text" id="editTotalAmountId" name="editTotalAmount" readonly="readonly" style="margin-left:58px;background-color: lightgrey;"/><br/>


<span><b>Payment Description:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editPaymentDescId" name="editPaymentDesc" style="margin-left: 7px;"/><br/>
				<input type="button" value="Update" id="editPaymentBtn"/> <input type="button" value="Close" class="closeBtn"/>
				
		</div>
	
	<script src="library/assets/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="library/assets/plugins/dataTables/dataTables.bootstrap.js"></script>
     <script>
         $(document).ready(function () {
             $('#dataTables-example').dataTable();
         });
    </script>
