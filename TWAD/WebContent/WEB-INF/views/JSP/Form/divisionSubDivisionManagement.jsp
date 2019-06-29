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
var subDivisionlist = "";
var divisionNameList = "";
$('#dataTables-example input:checkbox').each(function(){
	divisionNameList =  divisionNameList +","+$(this).closest('tr').find('td:nth-child(3)').text();
});

$('#dataTables-example input:checkbox').each(function(){
	 subDivisionlist =  subDivisionlist +","+$(this).closest('tr').find('td:nth-child(4)').text();
});

function validateAddDivisionForm() {
	
	var divisionName = $("#divisionNameId");
	var subDivisionNo = $("#clonedDiv .subDivisionNo");
	/* var subDivisionAddr = $("#clonedDiv .subDivisionAddr");
	var subDivisionMobile = $("#clonedDiv .subDivisionMobile"); */
	
	

	var inputVal = new Array(divisionName,subDivisionNo/* ,subDivisionAddr,subDivisionMobile */);

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
			 else  if ($(this).attr('id') == 'divisionNameId' && $(this).val().length > 1) {
					if(divisionNameList.indexOf($(this).val())>-1){
						  $(this).after('<span class="error"> Please enter unique Division Name. </span>');
						  $(this).focus();
						  flag = false;
						}
					}
			 else  if ($(this).attr('class') == 'subDivisionNo' && subDivisionlist.indexOf(","+$(this).val()+",")>-1) {
			
						  $(this).after('<span class="error"> Please enter unique SubDivision Name</span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'subDivisionMobile' && !/^[0-9]{10}$/.test($(this).val())) {
				$(this).after('<span class="error"> Please enter correct mobile No. </span>');
				$(this).focus();
				flag = false;
			} */
					
		 });
	
		
	}
	return flag;
}

function validateAddSubDivisionForm() {
	
	var divisionName = $("#subDivisionDivisionId");
	var subDivisionNo = $("#subDivisionClonedDiv .subDivisionNo");
	/* var subDivisionAddr = $("#subDivisionClonedDiv .subDivisionAddr");
	var subDivisionMobile = $("#subDivisionClonedDiv .subDivisionMobile"); */
	
	

	var inputVal = new Array(divisionName,subDivisionNo/* ,subDivisionAddr,subDivisionMobile */);

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
			 else  if ($(this).attr('class') == 'subDivisionNo' && subDivisionlist.indexOf(","+$(this).val()+",")>-1) {
			
						  $(this).after('<span class="error"> Please enter unique SubDivision Name </span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'subDivisionMobile' && !/^[0-9]{10}$/.test($(this).val())) {
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
	
	var editSubDivisionNo = $("#editSubDivisionNoId");
	/* var editSubDivisionAddr = $("#editSubDivisionAddrId");
	var editSubDivisionMobile = $("#editSubDivisionMobileId"); */
	
	

	var inputVal = new Array(editSubDivisionNo/* ,editSubDivisionAddr,editSubDivisionMobile */);

	$('.error').hide();
	flag = true;
	for (i = 0; i < inputVal.length; i++) {
		if (inputVal[i].val() == "") {
			inputVal[i]
					.after('<span class="error"> This field is required. </span>');
			inputVal[i].focus();
			flag = false;
		} 
		
		 else  if (inputVal[i].attr('id') == 'editSubDivisionNoId' && subDivisionlist.indexOf(","+inputVal[i].val()+",")>-1) {
				
			  inputVal[i].after('<span class="error"> Please enter unique SubDivision Name </span>');
			  inputVal[i].focus();
			  flag = false;
		}
/* 
else if (inputVal[i].attr('id') == 'editSubDivisionMobileId' && !/^[0-9]{10}$/.test(inputVal[i].val())) {
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

$('#addDivision').click(function(){
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'500px','modal':'true'});
	}); 

$('#addSubDivision').click(function(){
	$(".ui-dialog-content").dialog("close");
	$( "#addSubDivisionDialog" ).dialog({ 'width':'500px','modal':'true'});
}); 
	

	
	
$('#editSubDivision').click(function(){
	$(".ui-dialog-content").dialog("close");
	var numberOfChecked = $('#dataTables-example td input:checkbox:checked').length;
	if(numberOfChecked==1){
	$( "#editDialog" ).dialog({ 'width':'500px','modal':'true'});
	
	$('#dataTables-example td input:checkbox:checked').each(function(){
		$('#editSubDivisionId').val($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim());
		$('#editDivisionNameId').val($(this).closest('tr').find('td:nth-child(3)').text());
		$('#editSubDivisionNoId').val($(this).closest('tr').find('td:nth-child(4)').text());
		
		/* $('#editSubDivisionAddrId').val($(this).closest('tr').find('td:nth-child(5)').text());
		$('#editSubDivisionPhoneId').val($(this).closest('tr').find('td:nth-child(6)').text());
		$('#editSubDivisionMobileId').val($(this).closest('tr').find('td:nth-child(7)').text());
		 */
		divisionNameList = divisionNameList.replace($(this).closest('tr').find('td:nth-child(3)').text().trim(),"");
		subDivisionlist = subDivisionlist.replace($(this).closest('tr').find('td:nth-child(4)').text().trim(),"");
		
	});
	}
	else{
		alert("Please select only one SubDivision to Edit");
	}
	
	
	
}); 
$('.closeBtn,.imgClose').click(function(){
	$(".ui-dialog-content").dialog("close");
	
}); 


$('#subDivisionSaveBtnId').click(function(){
	var divisionSubDivisionIds = "";
	/* var divisionSubDivisionAddrs = "";
	var divisionSubDivisionPhones = "";
	var divisionSubDivisionMobiles = ""; */
	 $('#clonedDiv .subDivisionNo').each(function(){
		 divisionSubDivisionIds = divisionSubDivisionIds +"," + $(this).val();
	 });
	 
	/*  $('#clonedDiv .subDivisionAddr').each(function(){
		 divisionSubDivisionAddrs = divisionSubDivisionAddrs +"##" + $(this).val();
	 });
	 
	 $('#clonedDiv .subDivisionPhone').each(function(){
		 divisionSubDivisionPhones = divisionSubDivisionPhones +"," + $(this).val();
	 });
	 
	 $('#clonedDiv .subDivisionMobile').each(function(){
		 divisionSubDivisionMobiles = divisionSubDivisionMobiles +"," + $(this).val();
	 }); */
	 
	if(validateAddDivisionForm()){
	$.ajax({
		type:"POST",
		url:"addHODivision.do",
		data:{
			'divisionName':$('#divisionNameId').val(),
			'subDivisionNo':divisionSubDivisionIds.substring(1)
			/* 'subDivisionAddr':divisionSubDivisionAddrs.substring(2),
			'subDivisionPhone':divisionSubDivisionPhones.substring(1),
			'subDivisionMobile':divisionSubDivisionMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});


$('#divSaveBtnId').click(function(){
	var divisionSubDivisionIds = "";
	/* var divisionSubDivisionAddrs = "";
	var divisionSubDivisionPhones = "";
	var divisionSubDivisionMobiles = ""; */
	 $('#subDivisionClonedDiv .subDivisionNo').each(function(){
		 divisionSubDivisionIds = divisionSubDivisionIds +"," + $(this).val();
	 });
	 
	/*  $('#subDivisionClonedDiv .subDivisionAddr').each(function(){
		 divisionSubDivisionAddrs = divisionSubDivisionAddrs +"##" + $(this).val();
	 });
	 
	 $('#subDivisionClonedDiv .subDivisionPhone').each(function(){
		 divisionSubDivisionPhones = divisionSubDivisionPhones +"," + $(this).val();
	 });
	 
	 $('#subDivisionClonedDiv .subDivisionMobile').each(function(){
		 divisionSubDivisionMobiles = divisionSubDivisionMobiles +"," + $(this).val();
	 }); */
	if(validateAddSubDivisionForm()){
	$.ajax({
		type:"POST",
		url:"addSubDivision.do",
		data:{
			'divisionSubDivisionId':$('#subDivisionDivisionId option:selected').val(),
			'subDivisionName':divisionSubDivisionIds.substring(1)
			/* 'subDivisionAddr':divisionSubDivisionAddrs.substring(2),
			'subDivisionPhone':divisionSubDivisionPhones.substring(1),
			'subDivisionMobile':divisionSubDivisionMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});





$('#editSubDivisionBtn').click(function(){
	if(validateEditForm()){
	$.ajax({
		type:"POST",
		url:"editSubDivision.do",
		data:{
			'divisionSubDivisionId':$('#editSubDivisionId').val(),
			'divisionName':$('#editDivisionNameId').val(),
			'subDivisionName':$('#editSubDivisionNoId').val()
			/* 'subDivisionAddr':$('#editSubDivisionAddrId').val(),
			'subDivisionPhone':$('#editSubDivisionPhoneId').val(),
			'subDivisionMobile':$('#editSubDivisionMobileId').val() */
			
		
		},
		success:function(response){
			alert(response);
			window.location.reload();
			
			
		}
	}); 
	}
	
});

$('#deleteSubDivision').click(function(){
	var subDivisionList = "";
	var divisionNameList = "";
	$('#dataTables-example input:checkbox:checked').each(function(){
		if($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id')!=undefined){
		  subDivisionList = subDivisionList +","+$(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim();
		  divisionNameList = divisionNameList +","+$(this).closest('tr').find('td:nth-child(3)').text().trim();
		}
	});
	if(confirm("Are you sure want to Delete these SubDivision "+divisionNameList.substring(1)+" ? ")){
	$.ajax({
		type:"POST",
		url:"deleteSubDivision.do",
		data:{
			'divisionSubDivisionId':subDivisionList.substring(1)},
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
			<!-- <a href="#" style="padding: 10px;background-color: #78C948;color:white;" id="addDivision">Add New Division</a> -->
			<a href="#" style="padding: 10px;background-color: darkolivegreen;color:white;" id="addSubDivision">Add New SubDivision</a>
			<a style="padding: 10px;background-color: #FEBA17;color:white;" id="editSubDivision">Edit</a>
			<a style="padding: 10px;background-color: #EE3B41;color:white;" id="deleteSubDivision">Delete</a>
			
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
                                            <th style="color:black !important"><b>Division Name</b></th>
                                            <th style="color:black !important"><b>SubDivision Name</b></th>
                                            <!--  <th style="color:black !important"><b>Address</b></th>
                                              <th style="color:black !important"><b>Phone</b></th>
                                               <th style="color:black !important"><b>Mobile</b></th> -->
                                           
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    
                                    
                                     <c:forEach items="${list.divisionSubDivisionDtl}" var="app" varStatus="count" >
          
                                               <tr class="odd gradeX">
          								
          							
                                            <td><input type="checkbox" id="${app.getSubDivisionId()}" style="width:15px;"/></td>
                                            <td>${count.count}</td>
                                             <td>${app.getDivisionName()}</td>
                                             <td>${app.getSubDivisionName()}</td>
                                             
                                            <%--  <td>${app.getSubDivisionAddr()}</td>
                                             <td>${app.getSubDivisionPhone()}</td>
                                             <td>${app.getSubDivisionMobile()}</td> --%>
                                           
                                           
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
		<h2 class="bg_heading">Add New Division</h2>


<span><b>Enter Division Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divisionNameId" name="divisionName" /><br/>
				
				
				<div id="clonedDiv">
		<div id="fileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter SubDivision Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="subDivisionNoId_1" class="subDivisionNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New SubDivision Details"/><br /> 
		
		
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="subDivisionAddrId_1" class="subDivisionAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="subDivisionPhoneId_1" class="subDivisionPhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="subDivisionMobileId_1" class="subDivisionMobile" maxlength="10"  style="margin-left: 14px;width:222px;"/><br/>
				
		 -->
		
		</div>
		</div>
	<input type="button" value="Save" id="subDivisionSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>
		
		
		

<div id="addSubDivisionDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Add New SubDivision</h2>


<span><b>Select Division Name:</b></span><span style="color: red;">*</span>
<select id="subDivisionDivisionId" name="subDivisionDivisionName">
<option value="">--Select Division--</option>
<c:forEach var="var" items="${list.divisionMap}">
<option value="${var.key}">${var.value}</option>
</c:forEach>


</select><br/>
				
				
				<div id="subDivisionClonedDiv">
		<div id="subDivisionFileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter SubDivision Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divNoId_1" class="subDivisionNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New SubDivision Details"/><br /> 
		
		<!-- 
				<span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divAddrId_1" class="subDivisionAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="divPhoneId_1" class="subDivisionPhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divMobileId_1" class="subDivisionMobile"  maxlength="10" style="margin-left: 14px;width:222px;"/><br/>
				 -->
		
		
		</div>
		</div>
	<input type="button" value="Save" id="divSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>







		
		
		<div id="editDialog" style="display: none;">


<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Edit SubDivision</h2>
		
				<input type="hidden" id="editSubDivisionId"/>
                 <span><b>Division Name:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editDivisionNameId" name="editDivisionName" readonly="readonly"/><br/>
                <span><b>Enter SubDivision Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editSubDivisionNoId" name="editSubDivisionNo" style="margin-left: 5px;width:118px;"/><br/>
				
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editSubDivisionAddrId" name="editSubDivisionAddr" style="margin-left: 5px;width:227px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editSubDivisionPhoneId" name="editSubDivisionPhone" style="margin-left: 16px;width:228px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editSubDivisionMobileId" name="editSubDivisionMobile"  maxlength="10" style="margin-left: 14px;width:228px;"/><br/>
				
				 -->
				
				
				
				<input type="button" value="Update" id="editSubDivisionBtn"/> <input type="button" value="Close" class="closeBtn"/>
				
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
        		  cloned.find('.subDivisionNo').attr('id','subDivisionNoId_'+idCount);
        		  
        		 /*  cloned.find('.subDivisionAddr').attr('id','subDivisionAddrId_'+idCount);
        		  cloned.find('.subDivisionPhone').attr('id','subDivisionPhoneId_'+idCount);
        		  cloned.find('.subDivisionMobile').attr('id','subDivisionMobileId_'+idCount); */
        		  
          		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove SubDivision Details"/>');
        		 $('#clonedDiv').append(cloned);
        		 idCount++;
        		 
        	  });
        	 $('#clonedDiv').on('click','.deleteFileId',function(){
        		  $(this).parent('div').remove();  
        		});
        	  
        	 
        	  var idDivCount=2;
         	 $('#subDivisionClonedDiv').on('click','.addFileId',function(){
         		  var cloned = $('#subDivisionFileCloneId').clone();
         		  cloned.find('img.deleteFileId').remove();
         		  cloned.attr('id','fileCloneId_'+idCount);
         		  cloned.find('.subDivisionNo').attr('id','divNoId_'+idCount);
         		  
         		  /* cloned.find('.subDivisionAddr').attr('id','divAddrId_'+idCount);
         		  cloned.find('.subDivisionPhone').attr('id','divPhoneId_'+idCount);
         		  cloned.find('.subDivisionMobile').attr('id','divMobileId_'+idCount); */
         		  
           		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove SubDivision Details"/>');
         		 $('#subDivisionClonedDiv').append(cloned);
         		idDivCount++;
         		 
         	  });
         	 $('#subDivisionClonedDiv').on('click','.deleteFileId',function(){
         		  $(this).parent('div').remove();  
         		});
         	  
        	 
        	 
        	 
        	 
        	 
        	 
             
         });
    </script>

