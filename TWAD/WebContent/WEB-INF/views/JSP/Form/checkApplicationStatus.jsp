<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http//www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="library/js/jquery-1.7.2.min.js"></script>
 <link href="library/css/style.css" rel="stylesheet"/> 

 <link rel="stylesheet" href="library/assets/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="library/assets/css/main.css" />
    <link rel="stylesheet" href="library/assets/css/theme.css" />
    <link rel="stylesheet" href="library/assets/css/MoneAdmin.css" />
    <link rel="stylesheet" href="library/assets/plugins/Font-Awesome/css/font-awesome.css" />
	    <link rel="stylesheet" href="library/assets/plugins/validationengine/css/validationEngine.jquery.css" />
 
 
<link href="library/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">



<style>

/* 
tr:nth-child(even) {background: white;height:40px;}
tr:nth-child(odd) {background:#EDEDED ;height:40px;} */


input[type="button"] {
    border-radius 10px;
    background-color #2DAAE1;
    font-weight bold;
    cursor pointer;
    padding 5px 5px 5px 5px;
    margin-left150px; 
    width 100px;
    color white;
    margin-top 30px;
}

#myTable td{
padding-left:10px;
}

#myPaymentTable td,#myPaymentTable th{
padding-left:10px;
}

#myTable td span{
margin-left:10px;
}



</style>


<style>

#myTable tr:nth-child(even) {background: white;height:40px;}
#myTable tr:nth-child(odd) {background:#EDEDED ;height:40px;}
#myPaymentTable tr:nth-child(even) {background: white;height:40px;}
#myPaymentTable tr:nth-child(odd) {background:#EDEDED ;height:40px;}

/* 
input[type="button"] {
    border-radius 10px;
    background-color #2DAAE1;
    font-weight bold;
    cursor pointer;
    padding 5px 5px 5px 5px;
    margin-left150px; 
    width 100px;
    color white;
    margin-top 30px;
}

#myTable td{
padding-left:10px;
}

#myPaymentTable td,#myPaymentTable th{
padding-left:10px;
}

#myTable td span{
margin-left:10px;
} */
</style>

<script type="text/javascript">
$(function(){
$('.downloadfiles').click(function(){
	var fileName=$(this).text();
	var appId = $('#appId').val();
	window.location.href="downloadFiles.do?fileName="+fileName+"&appId="+appId+"&fileLocation="+$(this).attr("name");
});
});

</script>


<script type="text/javascript">

$(document).ready(function(){
	var isStatusButtonClicked = localStorage.getItem('isStatusButtonClicked');
	var isDetailButtonClicked = localStorage.getItem('isDetailButtonClicked');
	
	if(isStatusButtonClicked != 'null'){
		$('#detailsHeader').css({'display':'none'});
		$('#myTable').css({'display':'none'});
		$('#myPaymentHeader').css({'display':'none'});
		$('#myPaymentTable').css({'display':'none'});
		$('#buttonId').css({'display':'none'});
		
		$('#statusHeader').css({'display':'table'});
		$('#statusTable').css({'display':'table'});
	}
	else{
		$('#statusHeader').css({'display':'none'});
		$('#statusTable').css({'display':'none'});
	}
	if(isDetailButtonClicked != 'null'){
		$('#statusHeader').css({'display':'none'});
		$('#statusTable').css({'display':'none'});
		$('#detailsHeader').css({'display':'table'});
		$('#myTable').css({'display':'table'});
		$('#myPaymentHeader').css({'display':'table'});
		$('#myPaymentTable').css({'display':'table'});
		$('#buttonId').css({'display':'table'});
		
	}
	else{
		$('#detailsHeader').css({'display':'none'});
		$('#myTable').css({'display':'none'});
		$('#myPaymentHeader').css({'display':'none'});
		$('#myPaymentTable').css({'display':'none'});
		$('#buttonId').css({'display':'none'});
	}
	$('#apprefbtn').click(function(){
		if($('#appref').val().length==0){
			alert("Please enter Application Ref");
			$('#appref').focus();
			return false;
		}
		/* if($('#mobileNumId').val().length<10){
			alert("Please enter Mobile No");
			$('#mobileNumId').focus();
			return false;
		}
		 */
		 localStorage.setItem('isStatusButtonClicked', true);
		 localStorage.setItem('isDetailButtonClicked', null);
		window.location.href="checkApplicationStatus.do?appId="+$('#appref').val() /* +"&mobileNum="+$('#mobileNumId').val() */;
		
	});
	$('#appdetailbtn').click(function(){
		if($('#appref').val().length==0){
			alert("Please enter Application Ref");
			$('#appref').focus();
			return false;
		}
		/* if($('#mobileNumId').val().length<10){
			alert("Please enter Mobile No");
			$('#mobileNumId').focus();
			return false;
		}
		 */
		 localStorage.setItem('isDetailButtonClicked', true);
		 localStorage.setItem('isStatusButtonClicked', null);
		 window.location.href="checkApplicationStatus.do?appId="+$('#appref').val() /* +"&mobileNum="+$('#mobileNumId').val() */;
		
	});
	
	$('#withdrawAppbtn').click(function(){
		if($('#appref').val().length==0){
			alert("Please enter Application Ref");
			$('#appref').focus();
			return false;
		}
		if(confirm("Are you sure want to withdraw?")){
		$.ajax({
			url:"withdrawApp.do",
			type:"POST",
			data:{'appId':$('#appref').val()},
			success:function(response){
				alert(response);
				window.location.reload();
			}
		});
		}
		
	});
	
	
	});

</script>
</head>
<body>
<table align="center" style="width:90%; font-size: 28px;">

	<tbody>
	
	
<tr><td valign="middle"> 
<table width="100%">
					<tbody>
						<tr>
			<td valign="middle" colspan="2" style="height: 130px; width: 100%;">
				<table width="100%">
					<tbody>
						<tr>
							<td width="25%" align="center"><img src="library/img/twad_logo.gif" width="110px"
								height="106px" style="margin-left: 50px;"></td>
							 <td width="50%" align="center"><img src="library/img/middleImage.png" width="770px"
								height="50px"></td>
							<!-- <td  width="25%" align="center"><img src="library/img/pic6_2.jpg" width="130px"
								height="130px" style="margin-right: 50px;"></td> -->
							<td></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
					</tbody>
				</table>
  </td></tr>
 <tr>
			
			
			
			<td>
			
			<div style="padding: 0px; width: 100%;">
                <div style="background-image: url(library/img/border_bg.jpg); height: 7px; background-repeat: repeat-x;">
                    &nbsp;</div>
            </div>
			</td>
			</tr>
</tbody></table>	
	<br/>
	<table align="center" style="width:65%;height: 100px;"><tbody>
	<tr style="text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;">
		<td><label><b>Application Ref:</b></label> <span style="color: red;">*</span> <input type="text" id="appref"/></td>
		<%-- <td><label><b>Mobile Number:</b></label> <span style="color: red;">*</span>
		<input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' id="mobileNumId" name="mobileNum" maxlength="10" title="Enter Mobile No." /></td> --%>
	</tr>
	<tr>
		<td align="center" colspan="2"><input type="button" id="apprefbtn" value="Get Application Status"/> <input type="button" id="appdetailbtn" style="margin-left:40px;" value="View Application Details"/><!-- <input type="button" id="withdrawAppbtn" style="margin-left:10px;" value="Withdraw Application"/> --><a href="/TwadWeb/index.do" style="margin-left:10px;">Back to Home Page </a></td>
	</tr>
	
</tbody></table>
<c:if test="${'Data not found' ne list.application}">
<table align="center" id="statusHeader" class="table-bordered table table-striped display" style="width: 75%; font-size: 28px;display:none;">

	<tbody><tr>
		<td style="text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;">Application Status ( ${list.application.getAppId()} )</td>
	</tr>
	
</tbody></table>
</c:if>

<%-- <c:if test="${list.application}"> --%>
<c:if test="${'Data not found' ne list.application}">

<table id="statusTable" align="center" class="table-bordered table table-striped display" style="width: 50%;display:none;">
<tbody>

<tr><td width="50%"><b>Application Status</b></td><td>${list.application.getManagementComments()}</td></tr>
<%-- <tr><td width="50%"><b>Remarks</b></td><td>${list.application.getRemarks()}</td></tr> --%>
</tbody>

</table>
		
		
<table id="detailsHeader" class="table-bordered table table-striped display" align="center" style="width: 90%; font-size: 28px;display:none;">

	<tbody><tr>
		<td style="text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;">Application Details</td>
	</tr>
	
</tbody></table>

		<table id="myTable" width="90%" align="center" style="height: 450px;background-color:#FCFCF4; ">
		<tr>
			<td width="25%"><b>Application #</b></td>
			<td width="25%">:<span id="legCompNameId">${list.application.getAppId()}</span></td>
			<td><b>Registered Date</b></td>
			<td>:<span id="dateId">${list.application.getCreateDate()}</td>
		</tr>
		

		<tr>
			<td width="25%"><b>Legal Name of Company</b></td>
			<td width="25%">:<span id="legCompNameId">${list.application.getLegCompName()}</span></td>
			<td width="25%"><b>Name of contact person</b></td>
			<td width="25%">:<span id="contactPersonNameId">${list.application.getSalutation()}
					${list.application.getContactPersonName()}</span></td>
		</tr>
		
		<tr>
			<td><b>Mobile Number</b></td>
			<td>:<span id="mobileNumId">${list.application.getMobileNum()}</span></td>
			<td><b>Land line number</b></td>
			<td>:<span id="landlineNumId">${list.application.getLandLineNo()}</span></td>
		</tr>
		<tr>
			<td><b>Email Id</b></td>
			<td>:<span id="emailAddrId">${list.application.getEmailAddr()}</span></td>
			<td><b>Survey Field No</b></td>
			<td>:<span id="surveyFieldNo">${list.application.getSurveyFieldNo()}</span></td>
		</tr>
		
          <tr>
			<td><b>Address for Correspondence</b></td>
			<td>:<span id="correspondenceAddrId">${list.application.getCdoorNo()}
					${list.application.getCplotNo()}
					${list.application.getCstreetName()}
					${list.application.getClocation()}
					${list.application.getCpinCode()}</span></td>
			<td><b>Site Address</b></td>
			<td>:<span id="addrPremSoughtId">${list.application.getDoorNo()}
					${list.application.getPlotNo()} ${list.application.getStreetName()}
					${list.application.getLocation()} ${list.application.getPinCode()}</span></td>
		</tr>
		
		<tr>
			
			<td><b>District</b></td>
			<td>:<span id="reqMldId">${list.application.getDistrict()}</span></td>
			
			<td><b>Taluk</b></td>
			<td>:<span class="lessWidth"
				id="isExistConnectionForAlterationId">${list.application.getTaluk()}</span></td>
		</tr>
		
		
		<tr>
			
			<td><b>Village</b></td>
			<td>:<span id="reqMldId">${list.application.getVillage()}</span></td>
			
			<td><b>Type of category</b></td>
			<td style="">:<span class="classCategory" id="categoryTypeId">${list.application.getCategoryType()}</span></td>
		</tr>
		
		
		
		
		<tr>

			<td><b>Is this New Connection?</b></td>
			<td>:<span class="lessWidth" id="isNewConnectionId">${list.application.getIsNewConnectionDisplay()}</span></td>
			<td><b>Upfront Charges</b></td>
			<td>: <span class="lessWidth" id="isNewConnectionId">${list.application.getUpfrontCharges()}</span></td>
			
		</tr>

		<tr>
			
			<td><b>Requirement of water in MLD (Million Litres per day)</b></td>
			<td>:<span id="reqMldId">${list.application.getReqMld()}</span></td>
			
			<td><b>Total Amount (Application Fee + GST Amount)</b></td>
			<td>:<span class="lessWidth"
				id="isExistConnectionForAlterationId">${list.application.getTotalAmount()}</span></td>
		</tr>
		
		

		<tr>
			<td><b>Application Fee</b></td>
			<td>:<span class="lessWidth" id="intrPlumStatusId">${list.application.getApplicationFee()}</span></td>

			<td><b>GST Amount</b></td>
			<td>:<span class="lessWidth" id="watSevPropId">${list.application.getGstAmount()}</span></td>
		</tr>
		<tr>
			<td><b>Work Type</b></td>
			<td>:<span class="lessWidth" id="workTypeId">${list.application.getWorkTypeDisplay()}</span></td>
			<td><b>Application Status</b></td>
			<td>:<span class="lessWidth" id="status">${list.application.getManagementComments()}</span></td>
			
		</tr>
			 <tr>
			<td><b>Uploaded Documents By Company</b></td>
			<td colspan="3">:
			 <c:forEach items="${list.uploadedFiles}" var="fileName" >
			
			<a href="#" class="downloadfiles" name="">${fileName}</a><br/>
			</c:forEach>
			
			</td>
		</tr> 
		 <tr>
			<td><b>Uploaded Documents By EE</b></td>
			<td colspan="3">:
			 <c:forEach items="${list.uploadedFilesByAdmin}" var="fileName" >
			
			<a href="#" class="downloadfiles" name="admin">${fileName}</a><br/>
			</c:forEach>
			
			</td>
		</tr> 
		

	</table>
	<br/>
	
	<table id="myPaymentHeader" align="center" class="table-bordered table table-striped display" style="width: 90%; font-size: 28px;">

	<tbody><tr>
		<td style="text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;">Payment Details</td>
	</tr>
	
</tbody></table>

	<table id="myPaymentTable" width="90%" align="center" style="background-color:#FCFCF4; ">
	<tr height= "50px">
	    <th width="20%">Payment Type</th>
	    <th width="20%">DD No</th>
	    <th width="20%">DD Date</th>
	    <th width="20%">DD Amount</th>
	    <th width="20%">Bank Name</th>
	
	</tr>
	
	 <c:forEach items="${list.application.getPaymentList()}" var="paymentDetail" >
	 <tr height= "50px">
	    <td>${paymentDetail.getPaymentType() }</td>
	     <td>${paymentDetail.getDdNo() }</td>
	      <td>${paymentDetail.getDdDate() }</td>
	       <td>${paymentDetail.getPaymentAmount() }</td>
	        <td>${paymentDetail.getDdBankName() }</td>
	 
	 </tr>
			
	</c:forEach>
	
	</table>
	<br/>
	<table id="buttonId" width="90%" align="center">
	
	<tr>
			<td align="center"><input type="button" style="margin-right: 10px;"
				id="printbtnId" onclick="javascript:window.print();"
				name="industrialistSubmitBtn" value="Print" /></td>
		</tr>
	</table>
	
	
	
			</c:if>
		
		
			</body>
			</html>