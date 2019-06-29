<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="library/css/style.css" rel="stylesheet"/> 
<!-- <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
 
 
 
 
 <script src="library/js/jquery-1.7.2.min.js"></script>
<script src="library/js/jquery-ui-1.8.21.custom.min.js"></script>
<script src='library/js/jquery.dataTables.min.js'></script>
<script src='library/js/chosen.jquery.js'></script>
<script src='library/js/jquery.validate.js'></script>
<script src='library/js/dataTables.fixedColumns.js'></script>
<script src='library/js/jquery-ui-timepicker-addon.js'></script>
<script src='JS/common.js'></script>


<link href="library/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">

<body style="margin:0px;padding:0px" background="library/img/border_bg.jpg">

<style>
/*  #mydiv {
    margin:auto;
 	position:absolute;
    left: 50%;
    width:1200px;
    height:300px;
     margin-left: -600px;
    border: 0px;
}

 #myTable {
    margin:auto;
 	position:absolute;
    left: 50%;
    width:1200px;
    height:400px;
     margin-left: -600px;
    border: 0px;
}
 */

div[role="dialog"]{
border-radius:15px; 
}
.loginDialog{
	display:none;
	width:400px;
	padding:0px !important;
	overflow: hidden !important;
}
/*
.open{
display:block;
} */
/* 
.dropdown, .dropup {
    position: relative;
} */

input[type="button"] {
    border-radius: 10px;
    background-color: #2DAAE1;
    font-weight: bold;
    cursor: pointer;
    padding: 5px 5px 5px 5px;
    margin-left:150px; 
    width: 100px;
    color: white;
    margin-top: 30px;
}
.ui-dialog > .ui-widget-header {background: blue;display:none;}
.ui-dialog{
padding:0px;
overflow: hidden;
}
.dropdown-inline {
    display: inline-block;
    position: relative;
    font-family: Lato;
    font-size: 13px;
    margin-left: 10px;
    padding-bottom: 10px;
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
.dropdown-menu {
    position: absolute;
     top: 100%; 
     left: 0; 
     z-index: 1000; 
     display: none; 
     float: left; 
     min-width: 160px; 
     padding: 5px 0; 
    margin: 2px 0 0;
    font-size: 14px;
    text-align: left;
    list-style: none;
    background-color: #fff;
    -webkit-background-clip: padding-box;
    background-clip: padding-box;
    border: 1px solid #ccc;
    border: 1px solid rgba(0,0,0,.15);
    border-radius: 4px;
    -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
    box-shadow: 0 6px 12px rgba(0,0,0,.175);
}


.dropdown-menu>li>a {
    display: block;
    padding: 3px 20px;
    clear: both;
    font-weight: 400;
    line-height: 1.42857143;
    color: #333;
    white-space: nowrap;
     font-size: 13px;
}

.ftrmenu{
	font-size:18px;
}

.caret {
    display: inline-block;
    width: 0;
    height: 0;
    margin-left: 2px;
    vertical-align: middle;
    border-top: 4px dashed;
    border-top: 4px solid\9;
    border-right: 4px solid transparent;
    border-left: 4px solid transparent;
}

.bg_heading {
    text-align: left;
    font-family: Lato;
    font-size: 20px;
    text-transform: uppercase;
    color: white;
    background-color: #2DAAE1;
    border-radius:15px 0px 0px 0px;
    margin:0px;
}
input[type="text"],input[type="password"]{
	width: 330px;
    height: 25px;
    margin-left: 15px;
    padding: 5px;
}

select.lessWidth {
	width: 100px;
    height: 40px;
    margin-left: 15px;
    padding: 5px;
}
select.moreWidth {
	width: 226px;
    height: 40px;
    margin-left: 15px;
    padding: 5px;
}

select.classCategory {
	width: 344px;
    height: 40px;
    margin-left: 15px;
    padding: 5px;
}


/* 
.jssora05l {
    background-position: -10px -40px;
}

.jssora05l, .jssora05r, .jssora05ldn, .jssora05rdn {
    position: absolute;
    cursor: pointer;
    display: block;
    background: url(New_library/img/a17.png) no-repeat;
    overflow: hidden;
}

.dropdown-menu > li > a {
    font-size: 15px;
}
.dropdown-menu>li>a {
    display: block;
    padding: 3px 20px;
    clear: both;
    font-weight: 400;
    line-height: 1.42857143;
    color: #333;
    white-space: nowrap;
}
 */
.dropdown-menu .divider {
    height: 1px;
    margin: 9px 0;
    overflow: hidden;
    background-color: #e5e5e5;

}

.error{
color:red;

}

</style>

<script type="text/javascript">

$('.dropdown-inline, .dropdown-slide').hover(function() {
  $(this).find('ul').css({'display':'block'});
}, function() {
  $(this).find('ul').css({'display':'none'});
});

$(function(){
	
	$('#paymentTypeId').change(function(){
		if($(this).val()==1){
			$('#ddNumId').attr('disabled','disabled');
		}
		else{
			$('#ddNumId').removeAttr('disabled');
		}
	});
	
	$('#isReconnectionForServiceId').change(function(){
		if($(this).val()==0){
			$("#reconnectionTypeId").attr('disabled','disabled');
		}
		else{
			$("#reconnectionTypeId").removeAttr('disabled');
		}
	});
	
	
	$('#registrationbtnId').click(function(){
		if(validateForm()){
		
			$('#loading_image').show();
			var dataString = $('#formId').serialize();
		    $.ajax({
		        type: "POST",
		        url: "/TwadWeb/companyRegister.do",
		        data: dataString,
		        async: false,
		        success: function(response) {
		        	$('#loading_image').hide();
		        	$('#applicationRef').val(response);
		        	$('#companyName').val($('#legCompNameId').val());
		        	$('#paymentModeValue').val($('#paymentTypeId').val());
		        	$('#paymentModeText').val($('#paymentTypeId option:selected' ).text());
		        	$('#dd').val($('#ddNumId').val());
		        	
		        	$('#hiddenForm').submit();
		        	
		        }
		    });
		}
		});

	});
	
function validateForm(){


    var numberReg =  /^[0-9]+$/;
    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
    var legCompName  =	$("#legCompNameId");
    var correspondenceAddr  =	$("#correspondenceAddrId");
    var contactPersonName =	$("#contactPersonNameId");
    var mobileNum  = $("#mobileNumId");
    var emailAddr  = $("#emailAddrId");
    var categoryType  = $("#categoryTypeId");
    var addrPremSought  =	$("#addrPremSoughtId");
    var isExistConnectionForAlteration  =	$("#isExistConnectionForAlterationId");
    var isReconnectionForService  =	$("#isReconnectionForServiceId");
    var reqMld  =	$("#reqMldId");
    var workType  = $("#workTypeId");
    var paymentType  =	$("#paymentTypeId");
    

    var inputVal = new Array(legCompName, correspondenceAddr, contactPersonName, mobileNum, emailAddr, categoryType,addrPremSought ,isExistConnectionForAlteration,
    		isReconnectionForService,reqMld,workType,paymentType);


     $('.error').hide();
	for(i=0;i<inputVal.length;i++){
        if(inputVal[i].val() == ""){
        	inputVal[i].after('<span class="error"> Required to Fill </span>');
        	inputVal[i].focus();
        	return false;
        }
        else if(inputVal[i].attr('id')=='emailAddrId' && !emailReg.test(inputVal[i].val())){
        	inputVal[i].after('<span class="error"> Please enter correct Email Id </span>');
        	inputVal[i].focus();
        	return false;
        }
        else if(inputVal[i].attr('id')=='mobileNumId' && inputVal[i].val().length!=10){
        	inputVal[i].after('<span class="error"> Please enter correct mobile No. </span>');
        	inputVal[i].focus();
        	return false;
        }
        else if(inputVal[i].attr('id')=='reqMldId' && !/^[1-9]+$/.test(inputVal[i].val())){
        	inputVal[i].after('<span class="error"> Please enter required MLD in Whole Number </span>');
        	inputVal[i].focus();
        	return false;
        }
        else if(inputVal[i].attr('id')=='contactPersonNameId' && !/^[a-zA-Z\s]+$/.test(inputVal[i].val())){
        	inputVal[i].after('<span class="error"> Please enter Alphabet and Space </span>');
        	inputVal[i].focus();
        	return false;
        }
        else if(inputVal[i].attr('id')=='isReconnectionForServiceId' && inputVal[i].val()==1){
        	if($('#reconnectionTypeId').val()==""){
        		$('#reconnectionTypeId').after('<span class="error"> Please select reconnection Type </span>');
        		$('#reconnectionTypeId').focus();
	        	return false;
        	}
        }
        else if(inputVal[i].attr('id')=='paymentTypeId' && inputVal[i].val()==0){
        	if($('#ddNumId').val()==""){
        		$('#ddNumId').after('<span class="error"> Please enter DD Number </span>');
        		$('#ddNumId').focus();
	        	return false;
        	}
        }
        
         
	}
	if($('#divId').val()!='' && !/^[0-9]{3}$/.test($('#divId').val())){
		$('#divId').after('<span class="error"> Please enter division contains 3 Digit </span>');
		$('#divId').focus();
    	return false;
    }
	
	 if($('#billNumId').val()!='' && !/^\d{3,5}$/.test($('#billNumId').val())){
		$('#billNumId').after('<span class="error"> Please enter Bill Number contains 3 or 5 Digit </span>');
		$('#billNumId').focus();
    	return false;
    } 
	if($('#annAssmtValId').val()!='' && ! /^[0-9]{8}$/.test($('#annAssmtValId').val())){
		$('#annAssmtValId').after('<span class="error"> Please enter Annual Assessment Value contains 8 Digit</span>');
		$('#annAssmtValId').focus();
    	return false;
    }
        return true;
}

</script>


<table id="mydiv" >

<tr><td valign="middle" align="center" style="height:160px;width: 100%;">  <img src="library/img/Logo_Tamil_Nadu.jpg" width="150px" height="150px">
    <img src="library/img/middleImage.png" width="700px" height="150px">  <img src="library/img/pic6_2.jpg" width="150px" height="150px">
    <img src="library/img/loader.gif" style="display: none;" id="loading_image">
  </td><td></td></tr>
  
 
			
			<tr>
			
			
			
			<td colspan="2" height="25px">
			
			<div style="padding: 0px; width: 100%;">
                <div style="background-image: url(library/img/border_bg.jpg); height: 7px; background-repeat: repeat-x;">
                    &nbsp;</div>
            </div>
			</td>
			</tr>
			</table>
			<form id="formId" method="post"  >
			<table id="myTable" width="100%">
			<tr>
			<td colspan="2" align="center" valign="top" height="50px" style="font-weight: bold;font-size: 17px;">Company Registration Details</td><td></td>
			</tr>
			
			
			
			
			
			
<tr><td align="right" width="50%">	Legal Name of Company:<span style="color:red;">*</span></td><td><input type="text" id="legCompNameId" name="legCompName" /></td></tr>
<tr><td align="right">Address for Correspondence:<span style="color:red;">*</span></td><td><input type="text" id="correspondenceAddrId" name="correspondenceAddr"/></td></tr>
<tr><td align="right">Name of contact person:<span style="color:red;">*</span></td><td><input type="text" id="contactPersonNameId" name="contactPersonName"/></td></tr>
<tr><td align="right">Mobile Number:<span style="color:red;">*</span></td><td><input type="text" id="mobileNumId"  name="mobileNum" maxlength="10"/></td></tr>
<tr><td align="right">Email Id:<span style="color:red;">*</span></td><td><input type="text" id="emailAddrId"  name="emailAddr"/></td></tr>
<tr><td align="right">Type of category:<span style="color:red;">*</span></td><td style="position: relative;"><select class="classCategory" id="categoryTypeId"  name="categoryType" style="margin-right: 10px;">
<option value="">--Select--</option>
<option value="1">Commercial (Non water intensive -Metered)</option>
<option value="2">Commercial (Water intensive -Metered)</option>
<option value="3">Private Hospital (Water intensive - Metered)</option>
<option value="4">Institutional (Metered)</option>
<option value="5">All others (Water Intensive - Unmetered)</option>

</select><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: absolute;cursor: pointer;"></td></tr>


<tr><td align="right">Address of the premises for which water connection sought:<span style="color:red;">*</span></td><td><input type="text" id="addrPremSoughtId"  name="addrPremSought"/></td></tr>


<tr><td align="right">Is this an alteration to the existing water/ sewer connection? <span style="color:red;">*</span></td><td><select class="lessWidth" id="isExistConnectionForAlterationId" name="isExistConnectionForAlteration">
<option value="">--Select--</option>
<option value="1">Yes</option>
<option value="0">No</option>
</select></td></tr>

<tr><td align="right">Is this a reconnection of service connection for existing Connection?<span style="color:red;">*</span></td><td>
 <select class="lessWidth" id="isReconnectionForServiceId"  name="isReconnectionForService">

<option value="">--Select--</option>
<option value="1">Yes</option>
<option value="0">No</option>
</select>
<select class="moreWidth" id="reconnectionTypeId" name="reconnectionType">
<option value="">--Select--</option>
<option value="1">Non Payment of Tax</option>
<option value="2">Non Payment of Charges</option>
<option value="3">Shifting</option>
<option value="4">Renewal of Existing Connection</option>
</select></td></tr>


<tr><td align="right">Requirement of water in MLD (Million Litres per day):<span style="color:red;">*</span></td><td><input type="text" id="reqMldId"  name="reqMld"/></td></tr>
<tr><td align="right">CMWSSB Area Number/ Chennai Corporation Zone Number:</td><td style="position: relative;"><select class="lessWidth" id="cmwssbZoneNumId"  name="cmwssbZoneNum" style="margin-right: 10px;">
<option value="">--Select--</option>
<option value="1">Zone 1</option>
<option value="2">Zone 2</option>
<option value="3">Zone 3</option>
<option value="4">Zone 4</option>
<option value="5">Zone 5</option>
<option value="6">Zone 6</option>
<option value="7">Zone 7</option>
<option value="8">Zone 8</option>
<option value="9">Zone 9</option>
<option value="10">Zone 10</option>
<option value="11">Zone 11</option>
<option value="12">Zone 12</option>
<option value="13">Zone 13</option>
<option value="14">Zone 14</option>
<option value="15">Zone 15</option>

</select><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: absolute;cursor: pointer;"></td></tr>
<tr><td align="right">Division No./Depot No:</td><td style="position: relative;"><input type="text" id="divId"  name="divId" style="margin-right: 10px;"/><img src="library/img/pdf-image.jpg" width="35px" height="40px" style="position: absolute;cursor: pointer;"></td></tr>
<tr><td align="right">Bill No. given by Corporation/ Local Authority:</td><td><input type="text" id="billNumId"  name="billNum"/></td></tr>
<tr><td align="right">Annual Assessment value of property fixed by Chennai Corporation/ Local authority:</td><td><input type="text" id="annAssmtValId"  name="annAssmtVal" maxlength="8"/></td></tr>



<tr><td align="right">Whether internal plumbing works are completed:</td><td><select class="lessWidth" id="intrPlumStatusId"  name="intrPlumStatus">
<option value="">--Select--</option>
<option value="1">Yes</option>
<option value="0">No</option>
</select></td></tr>

<tr><td align="right">Whether water/ sewer line is available near the  property:</td><td><select class="lessWidth" id="watSevPropId"  name="watSevProp">
<option value="">--Select--</option>
<option value="1">Yes</option>
<option value="0">No</option>
</select></td></tr>
<tr><td align="right">Work Type:<span style="color:red;">*</span></td><td><select class="lessWidth" id="workTypeId"  name="workType">
<option value="">--Select--</option>
<option value="1">Treated</option>
<option value="0">Non Treated</option>
</select></td></tr>
<tr><td align="right">Payment Type:<span style="color:red;">*</span></td><td><select class="lessWidth" id="paymentTypeId"  name="paymentType">
<option value="">--Select--</option>
<option value="1">Online</option>
<option value="0">Offline</option>
</select></td></tr>
<tr><td align="right">DD Number:<span style="color:grey;">*</span></td><td><input type="text" id="ddNumId"  name="ddNum"/></td></tr>
<tr><td  align="center" valign="middle" colspan="2" height="70px;"><input type="button" id="registrationbtnId"  name="industrialistSubmitBtn" value="Submit"/>
			
			
		</td>
		<td></td>
			
			</tr>
			</table>
			</form>
			
			
			<form style="display: hidden" action="appAcknoledgement.jsp" method="POST" id="hiddenForm">
  <input type="hidden" id="applicationRef" name="applicationRef" value=""/>
  <input type="hidden" id="dd" name="dd" value=""/>
  <input type="hidden" id="companyName" name="companyName" value=""/>
  <input type="hidden" id="paymentModeValue" name="paymentModeValue" value=""/>
   <input type="hidden" id="paymentModeText" name="paymentModeText" value=""/>
 
</form>
			
			
			</body>
			</html>