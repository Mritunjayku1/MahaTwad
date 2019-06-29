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
input[type="search"]{
height:30px !important;
}
input[type="text"]{
height:25px !important;
}

.bg_heading {
	text-align: left;
    font-size: 20px;
    color: white;
    margin-top: -32px;
    margin-left: 135px;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
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
var taluklist = "";
var districtNameList = "";
$('#dataTables-example input:checkbox').each(function(){
	districtNameList =  districtNameList +","+$(this).closest('tr').find('td:nth-child(3)').text();
});

$('#dataTables-example input:checkbox').each(function(){
	 taluklist =  taluklist +","+$(this).closest('tr').find('td:nth-child(4)').text();
});

function validateAddDistrictForm() {
	
	var districtName = $("#districtNameId");
	var talukNo = $("#clonedDiv .talukNo");
	/* var talukAddr = $("#clonedDiv .talukAddr");
	var talukMobile = $("#clonedDiv .talukMobile"); */
	
	

	var inputVal = new Array(districtName,talukNo/* ,talukAddr,talukMobile */);

	$('.error').hide();
	flag = true;
	var reg = /^[0-9]+$/;
	for (i = 0; i < inputVal.length; i++) {
	
		 $(inputVal[i]).each(function(){
			 if ($(this).val() == "") {
					$(this)
							.after('<span class="error"> This field is required. </span>');
					$(this).focus();
					flag = false;
				} 
			 else  if ($(this).attr('id') == 'districtNameId' && $(this).val().length > 1) {
					if(districtNameList.indexOf($(this).val())>-1){
						  $(this).after('<span class="error"> Please enter unique District Name. </span>');
						  $(this).focus();
						  flag = false;
						}
					}
			 else  if ($(this).attr('class') == 'talukNo' && (!reg.test($(this).val()) || taluklist.indexOf(","+$(this).val()+",")>-1)) {
			
						  $(this).after('<span class="error"> Please enter unique Taluk No. and should be Numeric </span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'talukMobile' && !/^[0-9]{10}$/.test($(this).val())) {
				$(this).after('<span class="error"> Please enter correct mobile No. </span>');
				$(this).focus();
				flag = false;
			} */
					
		 });
	
		
	}
	return flag;
}

function validateAddTalukForm() {
	
	var districtName = $("#talukDistrictId");
	var talukNo = $("#talukClonedDiv .talukNo");
	/* var talukAddr = $("#talukClonedDiv .talukAddr");
	var talukMobile = $("#talukClonedDiv .talukMobile"); */
	
	

	var inputVal = new Array(districtName,talukNo/* ,talukAddr,talukMobile */);

	$('.error').hide();
	flag = true;
	var reg = /^[0-9]+$/;
	for (i = 0; i < inputVal.length; i++) {
	
		 $(inputVal[i]).each(function(){
			 if ($(this).val() == "") {
					$(this)
							.after('<span class="error"> This field is required. </span>');
					$(this).focus();
					flag = false;
				} 
			 else  if ($(this).attr('class') == 'talukNo' && taluklist.indexOf(","+$(this).val()+",")>-1) {
			
						  $(this).after('<span class="error"> Please enter unique Taluk Name </span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'talukMobile' && !/^[0-9]{10}$/.test($(this).val())) {
				$(this).after('<span class="error"> Please enter correct mobile No. </span>');
				$(this).focus();
				flag = false;
			}
 */					
		 });
	
		
	}
	return flag;
}



function validateEditForm() {
	return true;
	
	var editTalukNo = $("#editTalukNoId");
	/* var editTalukAddr = $("#editTalukAddrId");
	var editTalukMobile = $("#editTalukMobileId"); */
	
	

	var inputVal = new Array(editTalukNo/* ,editTalukAddr,editTalukMobile */);

	$('.error').hide();
	flag = true;
	for (i = 0; i < inputVal.length; i++) {
		if (inputVal[i].val() == "") {
			inputVal[i]
					.after('<span class="error"> This field is required. </span>');
			inputVal[i].focus();
			flag = false;
		} 
		
		 else  if (inputVal[i].attr('id') == 'editTalukNoId' && taluklist.indexOf(","+inputVal[i].val()+",")>-1) {
				
			  inputVal[i].after('<span class="error"> Please enter unique Taluk Name </span>');
			  inputVal[i].focus();
			  flag = false;
		}
/* 
else if (inputVal[i].attr('id') == 'editTalukMobileId' && !/^[0-9]{10}$/.test(inputVal[i].val())) {
	inputVal[i].after('<span class="error"> Please enter correct mobile No. </span>');
	inputVal[i].focus();
	flag = false;
}
	 */	
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

$('#addDistrict').click(function(){
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'500px','modal':'true'});
	}); 

$('#addTaluk').click(function(){
	$(".ui-dialog-content").dialog("close");
	$( "#addTalukDialog" ).dialog({ 'width':'500px','modal':'true'});
}); 
	

	
	
$('#editTaluk').click(function(){
	$(".ui-dialog-content").dialog("close");
	var numberOfChecked = $('#dataTables-example td input:checkbox:checked').length;
	if(numberOfChecked==1){
	$( "#editDialog" ).dialog({ 'width':'500px','modal':'true'});
	
	$('#dataTables-example td input:checkbox:checked').each(function(){
		$('#editTalukId').val($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim());
		$('#editDistrictNameId').val($(this).closest('tr').find('td:nth-child(3)').text());
		$('#editTalukNoId').val($(this).closest('tr').find('td:nth-child(4)').text());
		
		/* $('#editTalukAddrId').val($(this).closest('tr').find('td:nth-child(5)').text());
		$('#editTalukPhoneId').val($(this).closest('tr').find('td:nth-child(6)').text());
		$('#editTalukMobileId').val($(this).closest('tr').find('td:nth-child(7)').text());
		 */
		districtNameList = districtNameList.replace($(this).closest('tr').find('td:nth-child(3)').text().trim(),"");
		taluklist = taluklist.replace($(this).closest('tr').find('td:nth-child(4)').text().trim(),"");
		
	});
	}
	else{
		alert("Please select only one Taluk to Edit");
	}
	
	
	
}); 
$('.closeBtn,.imgClose').click(function(){
	$(".ui-dialog-content").dialog("close");
	
}); 


$('#talukSaveBtnId').click(function(){
	var districtTalukIds = "";
	/* var districtTalukAddrs = "";
	var districtTalukPhones = "";
	var districtTalukMobiles = ""; */
	 $('#clonedDiv .talukNo').each(function(){
		 districtTalukIds = districtTalukIds +"," + $(this).val();
	 });
	 
	/*  $('#clonedDiv .talukAddr').each(function(){
		 districtTalukAddrs = districtTalukAddrs +"##" + $(this).val();
	 });
	 
	 $('#clonedDiv .talukPhone').each(function(){
		 districtTalukPhones = districtTalukPhones +"," + $(this).val();
	 });
	 
	 $('#clonedDiv .talukMobile').each(function(){
		 districtTalukMobiles = districtTalukMobiles +"," + $(this).val();
	 });
	  */
	if(validateAddDistrictForm()){
	$.ajax({
		type:"POST",
		url:"addDistrict.do",
		data:{
			'districtName':$('#districtNameId').val(),
			'talukNo':districtTalukIds.substring(1)
			/* 'talukAddr':districtTalukAddrs.substring(2),
			'talukPhone':districtTalukPhones.substring(1),
			'talukMobile':districtTalukMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});


$('#divSaveBtnId').click(function(){
	var districtTalukIds = "";
	/* var districtTalukAddrs = "";
	var districtTalukPhones = "";
	var districtTalukMobiles = ""; */
	 $('#talukClonedDiv .talukNo').each(function(){
		 districtTalukIds = districtTalukIds +"," + $(this).val();
	 });
	 
	/*  $('#talukClonedDiv .talukAddr').each(function(){
		 districtTalukAddrs = districtTalukAddrs +"##" + $(this).val();
	 });
	 
	 $('#talukClonedDiv .talukPhone').each(function(){
		 districtTalukPhones = districtTalukPhones +"," + $(this).val();
	 });
	 
	 $('#talukClonedDiv .talukMobile').each(function(){
		 districtTalukMobiles = districtTalukMobiles +"," + $(this).val();
	 }); */
	if(validateAddTalukForm()){
	$.ajax({
		type:"POST",
		url:"addTaluk.do",
		data:{
			'districtTalukId':$('#talukDistrictId option:selected').val(),
			'talukName':districtTalukIds.substring(1)
			/* 'talukAddr':districtTalukAddrs.substring(2),
			'talukPhone':districtTalukPhones.substring(1),
			'talukMobile':districtTalukMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});





$('#editTalukBtn').click(function(){
	if(validateEditForm()){
	$.ajax({
		type:"POST",
		url:"editTaluk.do",
		data:{
			'districtTalukId':$('#editTalukId').val(),
			'districtName':$('#editDistrictNameId').val(),
			'talukName':$('#editTalukNoId').val()
			/* 'talukAddr':$('#editTalukAddrId').val(),
			'talukPhone':$('#editTalukPhoneId').val(),
			'talukMobile':$('#editTalukMobileId').val() */
			
		
		},
		success:function(response){
			alert(response);
			window.location.reload();
			
			
		}
	}); 
	}
	
});

$('#deleteTaluk').click(function(){
	var talukList = "";
	var districtNameList = "";
	$('#dataTables-example input:checkbox:checked').each(function(){
		if($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id')!=undefined){
		  talukList = talukList +","+$(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim();
		  districtNameList = districtNameList +","+$(this).closest('tr').find('td:nth-child(3)').text().trim();
		}
	});
	if(confirm("Are you sure want to Delete these Taluk "+districtNameList.substring(1)+" ? ")){
	$.ajax({
		type:"POST",
		url:"deleteTaluk.do",
		data:{
			'districtTalukId':talukList.substring(1)},
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
			<!-- <a href="#" style="padding: 10px;background-color: #78C948;color:white;" id="addDistrict">Add New District</a> -->
			<a href="#" style="padding: 10px;background-color: darkolivegreen;color:white;" id="addTaluk">Add New Taluk</a>
			<a style="padding: 10px;background-color: #FEBA17;color:white;" id="editTaluk">Edit</a>
			<a style="padding: 10px;background-color: #EE3B41;color:white;" id="deleteTaluk">Delete</a>
			
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
                                            <th style="color:black !important"><b>District Name</b></th>
                                            <th style="color:black !important"><b>Taluk Name</b></th>
                                             <!-- <th style="color:black !important"><b>Address</b></th>
                                              <th style="color:black !important"><b>Phone</b></th>
                                               <th style="color:black !important"><b>Mobile</b></th> -->
                                           
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    
                                    
                                     <c:forEach items="${list.districtTalukDtl}" var="app" varStatus="count" >
          
                                               <tr class="odd gradeX">
          								
          							
                                            <td><input type="checkbox" id="${app.getTalukId()}" style="width:15px;"/></td>
                                            <td>${count.count}</td>
                                             <td>${app.getDistrictName()}</td>
                                             <td>${app.getTalukName()}</td>
                                             
                                            <%--  <td>${app.getTalukAddr()}</td>
                                             <td>${app.getTalukPhone()}</td>
                                             <td>${app.getTalukMobile()}</td> --%>
                                           
                                           
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
		<h2 class="bg_heading">Add New District</h2>


<span><b>Enter District Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="districtNameId" name="districtName" /><br/>
				
				
				<div id="clonedDiv">
		<div id="fileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter Taluk Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="talukNoId_1" class="talukNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New Taluk Details"/><br /> 
		
		
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="talukAddrId_1" class="talukAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="talukPhoneId_1" class="talukPhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="talukMobileId_1" class="talukMobile" maxlength="10"  style="margin-left: 14px;width:222px;"/><br/>
				
		 -->
		
		</div>
		</div>
	<input type="button" value="Save" id="talukSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>
		
		
		

<div id="addTalukDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Add New Taluk</h2>


<span><b>Select District Name:</b></span><span style="color: red;">*</span>
<select id="talukDistrictId" name="talukDistrictName">
<option value="">--Select District--</option>
<c:forEach var="var" items="${list.districtMap}">
<option value="${var.key}">${var.value}</option>
</c:forEach>


</select><br/>
				
				
				<div id="talukClonedDiv">
		<div id="talukFileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter Taluk Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divNoId_1" class="talukNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New Taluk Details"/><br /> 
		
		
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divAddrId_1" class="talukAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="divPhoneId_1" class="talukPhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divMobileId_1" class="talukMobile"  maxlength="10" style="margin-left: 14px;width:222px;"/><br/>
				
		 -->
		
		</div>
		</div>
	<input type="button" value="Save" id="divSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>







		
		
		<div id="editDialog" style="display: none;">


<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Edit Taluk</h2>
		
				<input type="hidden" id="editTalukId"/>
                 <span><b>District Name:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editDistrictNameId" name="editDistrictName" readonly="readonly"/><br/>
                <span><b>Enter Taluk Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editTalukNoId" name="editTalukNo" style="margin-left: 5px;width:118px;"/><br/>
				
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editTalukAddrId" name="editTalukAddr" style="margin-left: 5px;width:227px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editTalukPhoneId" name="editTalukPhone" style="margin-left: 16px;width:228px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editTalukMobileId" name="editTalukMobile"  maxlength="10" style="margin-left: 14px;width:228px;"/><br/>
				
				 -->
				
				
				
				<input type="button" value="Update" id="editTalukBtn"/> <input type="button" value="Close" class="closeBtn"/>
				
		</div>
	
	<script src="library/assets/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="library/assets/plugins/dataTables/dataTables.bootstrap.js"></script>
     <script>
         $(document).ready(function () {
             $('#dataTables-example').dataTable();
             
             
             var idCount=2;
        	 $('#clonedDiv').on('click','.addFileId',function(){
        		  var cloned = $('#fileCloneId').clone();
        		  cloned.find('img.deleteFileId').remove();
        		  cloned.attr('id','fileCloneId_'+idCount);
        		  cloned.find('.talukNo').attr('id','talukNoId_'+idCount);
        		  
        		 /*  cloned.find('.talukAddr').attr('id','talukAddrId_'+idCount);
        		  cloned.find('.talukPhone').attr('id','talukPhoneId_'+idCount);
        		  cloned.find('.talukMobile').attr('id','talukMobileId_'+idCount); */
        		  
          		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove Taluk Details"/>');
        		 $('#clonedDiv').append(cloned);
        		 idCount++;
        		 
        	  });
        	 $('#clonedDiv').on('click','.deleteFileId',function(){
        		  $(this).parent('div').remove();  
        		});
        	  
        	 
        	  var idDivCount=2;
         	 $('#talukClonedDiv').on('click','.addFileId',function(){
         		  var cloned = $('#talukFileCloneId').clone();
         		  cloned.find('img.deleteFileId').remove();
         		  cloned.attr('id','fileCloneId_'+idCount);
         		  cloned.find('.talukNo').attr('id','divNoId_'+idCount);
         		  
         		  /* cloned.find('.talukAddr').attr('id','divAddrId_'+idCount);
         		  cloned.find('.talukPhone').attr('id','divPhoneId_'+idCount);
         		  cloned.find('.talukMobile').attr('id','divMobileId_'+idCount); */
         		  
           		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove Taluk Details"/>');
         		 $('#talukClonedDiv').append(cloned);
         		idDivCount++;
         		 
         	  });
         	 $('#talukClonedDiv').on('click','.deleteFileId',function(){
         		  $(this).parent('div').remove();  
         		});
         	  
        	 
        	 
        	 
        	 
        	 
        	 
             
         });
    </script>

