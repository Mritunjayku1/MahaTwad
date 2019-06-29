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
var circlelist = "";
var regionNameList = "";
$('#dataTables-example input:checkbox').each(function(){
	regionNameList =  regionNameList +","+$(this).closest('tr').find('td:nth-child(3)').text();
});

$('#dataTables-example input:checkbox').each(function(){
	 circlelist =  circlelist +","+$(this).closest('tr').find('td:nth-child(4)').text();
});

function validateAddRegionForm() {
	
	var regionName = $("#regionNameId");
	var circleNo = $("#clonedDiv .circleNo");
	/* var circleAddr = $("#clonedDiv .circleAddr");
	var circleMobile = $("#clonedDiv .circleMobile"); */
	
	

	var inputVal = new Array(regionName,circleNo/* ,circleAddr,circleMobile */);

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
			 else  if ($(this).attr('id') == 'regionNameId' && $(this).val().length > 1) {
					if(regionNameList.indexOf($(this).val())>-1){
						  $(this).after('<span class="error"> Please enter unique Region Name. </span>');
						  $(this).focus();
						  flag = false;
						}
					}
			 else  if ($(this).attr('class') == 'circleNo' && (!reg.test($(this).val()) || circlelist.indexOf(","+$(this).val()+",")>-1)) {
			
						  $(this).after('<span class="error"> Please enter unique Circle No. and should be Numeric </span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'circleMobile' && !/^[0-9]{10}$/.test($(this).val())) {
				$(this).after('<span class="error"> Please enter correct mobile No. </span>');
				$(this).focus();
				flag = false;
			} */
					
		 });
	
		
	}
	return flag;
}

function validateAddCircleForm() {
	
	var regionName = $("#circleRegionId");
	var circleNo = $("#circleClonedDiv .circleNo");
	/* var circleAddr = $("#circleClonedDiv .circleAddr");
	var circleMobile = $("#circleClonedDiv .circleMobile"); */
	
	

	var inputVal = new Array(regionName,circleNo/* ,circleAddr,circleMobile */);

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
			 else  if ($(this).attr('class') == 'circleNo' && circlelist.indexOf(","+$(this).val()+",")>-1) {
			
						  $(this).after('<span class="error"> Please enter unique Circle Name </span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'circleMobile' && !/^[0-9]{10}$/.test($(this).val())) {
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
	
	var editCircleNo = $("#editCircleNoId");
	/* var editCircleAddr = $("#editCircleAddrId");
	var editCircleMobile = $("#editCircleMobileId"); */
	
	

	var inputVal = new Array(editCircleNo/* ,editCircleAddr,editCircleMobile */);

	$('.error').hide();
	flag = true;
	for (i = 0; i < inputVal.length; i++) {
		if (inputVal[i].val() == "") {
			inputVal[i]
					.after('<span class="error"> This field is required. </span>');
			inputVal[i].focus();
			flag = false;
		} 
		
		 else  if (inputVal[i].attr('id') == 'editCircleNoId' && circlelist.indexOf(","+inputVal[i].val()+",")>-1) {
				
			  inputVal[i].after('<span class="error"> Please enter unique Circle Name </span>');
			  inputVal[i].focus();
			  flag = false;
		}
/* 
else if (inputVal[i].attr('id') == 'editCircleMobileId' && !/^[0-9]{10}$/.test(inputVal[i].val())) {
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

$('#addRegion').click(function(){
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'500px','modal':'true'});
	}); 

$('#addCircle').click(function(){
	$(".ui-dialog-content").dialog("close");
	$( "#addCircleDialog" ).dialog({ 'width':'500px','modal':'true'});
}); 
	

	
	
$('#editCircle').click(function(){
	$(".ui-dialog-content").dialog("close");
	var numberOfChecked = $('#dataTables-example td input:checkbox:checked').length;
	if(numberOfChecked==1){
	$( "#editDialog" ).dialog({ 'width':'500px','modal':'true'});
	
	$('#dataTables-example td input:checkbox:checked').each(function(){
		$('#editCircleId').val($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim());
		$('#editRegionNameId').val($(this).closest('tr').find('td:nth-child(3)').text());
		$('#editCircleNoId').val($(this).closest('tr').find('td:nth-child(4)').text());
		
		/* $('#editCircleAddrId').val($(this).closest('tr').find('td:nth-child(5)').text());
		$('#editCirclePhoneId').val($(this).closest('tr').find('td:nth-child(6)').text());
		$('#editCircleMobileId').val($(this).closest('tr').find('td:nth-child(7)').text());
		 */
		regionNameList = regionNameList.replace($(this).closest('tr').find('td:nth-child(3)').text().trim(),"");
		circlelist = circlelist.replace($(this).closest('tr').find('td:nth-child(4)').text().trim(),"");
		
	});
	}
	else{
		alert("Please select only one Circle to Edit");
	}
	
	
	
}); 
$('.closeBtn,.imgClose').click(function(){
	$(".ui-dialog-content").dialog("close");
	
}); 


$('#circleSaveBtnId').click(function(){
	var regionCircleIds = "";
	/* var regionCircleAddrs = "";
	var regionCirclePhones = "";
	var regionCircleMobiles = ""; */
	 $('#clonedDiv .circleNo').each(function(){
		 regionCircleIds = regionCircleIds +"," + $(this).val();
	 });
	 
	/*  $('#clonedDiv .circleAddr').each(function(){
		 regionCircleAddrs = regionCircleAddrs +"##" + $(this).val();
	 });
	 
	 $('#clonedDiv .circlePhone').each(function(){
		 regionCirclePhones = regionCirclePhones +"," + $(this).val();
	 });
	 
	 $('#clonedDiv .circleMobile').each(function(){
		 regionCircleMobiles = regionCircleMobiles +"," + $(this).val();
	 });
	  */
	if(validateAddRegionForm()){
	$.ajax({
		type:"POST",
		url:"addRegion.do",
		data:{
			'regionName':$('#regionNameId').val(),
			'circleNo':regionCircleIds.substring(1)
			/* 'circleAddr':regionCircleAddrs.substring(2),
			'circlePhone':regionCirclePhones.substring(1),
			'circleMobile':regionCircleMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});


$('#divSaveBtnId').click(function(){
	var regionCircleIds = "";
	/* var regionCircleAddrs = "";
	var regionCirclePhones = "";
	var regionCircleMobiles = ""; */
	 $('#circleClonedDiv .circleNo').each(function(){
		 regionCircleIds = regionCircleIds +"," + $(this).val();
	 });
	 
	/*  $('#circleClonedDiv .circleAddr').each(function(){
		 regionCircleAddrs = regionCircleAddrs +"##" + $(this).val();
	 });
	 
	 $('#circleClonedDiv .circlePhone').each(function(){
		 regionCirclePhones = regionCirclePhones +"," + $(this).val();
	 });
	 
	 $('#circleClonedDiv .circleMobile').each(function(){
		 regionCircleMobiles = regionCircleMobiles +"," + $(this).val();
	 }); */
	if(validateAddCircleForm()){
	$.ajax({
		type:"POST",
		url:"addCircle.do",
		data:{
			'regionCircleId':$('#circleRegionId option:selected').val(),
			'circleName':regionCircleIds.substring(1)
			/* 'circleAddr':regionCircleAddrs.substring(2),
			'circlePhone':regionCirclePhones.substring(1),
			'circleMobile':regionCircleMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});





$('#editCircleBtn').click(function(){
	if(validateEditForm()){
	$.ajax({
		type:"POST",
		url:"editCircle.do",
		data:{
			'regionCircleId':$('#editCircleId').val(),
			'regionName':$('#editRegionNameId').val(),
			'circleName':$('#editCircleNoId').val()
			/* 'circleAddr':$('#editCircleAddrId').val(),
			'circlePhone':$('#editCirclePhoneId').val(),
			'circleMobile':$('#editCircleMobileId').val() */
			
		
		},
		success:function(response){
			alert(response);
			window.location.reload();
			
			
		}
	}); 
	}
	
});

$('#deleteCircle').click(function(){
	var circleList = "";
	var regionNameList = "";
	$('#dataTables-example input:checkbox:checked').each(function(){
		if($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id')!=undefined){
		  circleList = circleList +","+$(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim();
		  regionNameList = regionNameList +","+$(this).closest('tr').find('td:nth-child(3)').text().trim();
		}
	});
	if(confirm("Are you sure want to Delete these Circle "+regionNameList.substring(1)+" ? ")){
	$.ajax({
		type:"POST",
		url:"deleteCircle.do",
		data:{
			'regionCircleId':circleList.substring(1)},
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
			<!-- <a href="#" style="padding: 10px;background-color: #78C948;color:white;" id="addRegion">Add New Region</a> -->
			<a href="#" style="padding: 10px;background-color: darkolivegreen;color:white;" id="addCircle">Add New Circle</a>
			<a style="padding: 10px;background-color: #FEBA17;color:white;" id="editCircle">Edit</a>
			<a style="padding: 10px;background-color: #EE3B41;color:white;" id="deleteCircle">Delete</a>
			
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
                                            <th style="color:black !important"><b>Region Name</b></th>
                                            <th style="color:black !important"><b>Circle Name</b></th>
                                             <!-- <th style="color:black !important"><b>Address</b></th>
                                              <th style="color:black !important"><b>Phone</b></th>
                                               <th style="color:black !important"><b>Mobile</b></th> -->
                                           
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    
                                    
                                     <c:forEach items="${list.regionCircleDtl}" var="app" varStatus="count" >
          
                                               <tr class="odd gradeX">
          								
          							
                                            <td><input type="checkbox" id="${app.getCircleId()}" style="width:15px;"/></td>
                                            <td>${count.count}</td>
                                             <td>${app.getRegionName()}</td>
                                             <td>${app.getCircleName()}</td>
                                             
                                            <%--  <td>${app.getCircleAddr()}</td>
                                             <td>${app.getCirclePhone()}</td>
                                             <td>${app.getCircleMobile()}</td> --%>
                                           
                                           
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
		<h2 class="bg_heading">Add New Region</h2>


<span><b>Enter Region Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="regionNameId" name="regionName" /><br/>
				
				
				<div id="clonedDiv">
		<div id="fileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter Circle Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="circleNoId_1" class="circleNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New Circle Details"/><br /> 
		
		
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="circleAddrId_1" class="circleAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="circlePhoneId_1" class="circlePhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="circleMobileId_1" class="circleMobile" maxlength="10"  style="margin-left: 14px;width:222px;"/><br/>
				
		 -->
		
		</div>
		</div>
	<input type="button" value="Save" id="circleSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>
		
		
		

<div id="addCircleDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Add New Circle</h2>


<span><b>Select Region Name:</b></span><span style="color: red;">*</span>
<select id="circleRegionId" name="circleRegionName">
<option value="">--Select Region--</option>
<c:forEach var="var" items="${list.regionMap}">
<option value="${var.key}">${var.value}</option>
</c:forEach>


</select><br/>
				
				
				<div id="circleClonedDiv">
		<div id="circleFileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter Circle Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divNoId_1" class="circleNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New Circle Details"/><br /> 
		
		
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divAddrId_1" class="circleAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="divPhoneId_1" class="circlePhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divMobileId_1" class="circleMobile"  maxlength="10" style="margin-left: 14px;width:222px;"/><br/>
				
		 -->
		
		</div>
		</div>
	<input type="button" value="Save" id="divSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>







		
		
		<div id="editDialog" style="display: none;">


<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Edit Circle</h2>
		
				<input type="hidden" id="editCircleId"/>
                 <span><b>Region Name:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editRegionNameId" name="editRegionName" readonly="readonly"/><br/>
                <span><b>Enter Circle Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editCircleNoId" name="editCircleNo" style="margin-left: 5px;width:118px;"/><br/>
				
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editCircleAddrId" name="editCircleAddr" style="margin-left: 5px;width:227px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editCirclePhoneId" name="editCirclePhone" style="margin-left: 16px;width:228px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editCircleMobileId" name="editCircleMobile"  maxlength="10" style="margin-left: 14px;width:228px;"/><br/>
				
				 -->
				
				
				
				<input type="button" value="Update" id="editCircleBtn"/> <input type="button" value="Close" class="closeBtn"/>
				
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
        		  cloned.find('.circleNo').attr('id','circleNoId_'+idCount);
        		  
        		 /*  cloned.find('.circleAddr').attr('id','circleAddrId_'+idCount);
        		  cloned.find('.circlePhone').attr('id','circlePhoneId_'+idCount);
        		  cloned.find('.circleMobile').attr('id','circleMobileId_'+idCount); */
        		  
          		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove Circle Details"/>');
        		 $('#clonedDiv').append(cloned);
        		 idCount++;
        		 
        	  });
        	 $('#clonedDiv').on('click','.deleteFileId',function(){
        		  $(this).parent('div').remove();  
        		});
        	  
        	 
        	  var idDivCount=2;
         	 $('#circleClonedDiv').on('click','.addFileId',function(){
         		  var cloned = $('#circleFileCloneId').clone();
         		  cloned.find('img.deleteFileId').remove();
         		  cloned.attr('id','fileCloneId_'+idCount);
         		  cloned.find('.circleNo').attr('id','divNoId_'+idCount);
         		  
         		  /* cloned.find('.circleAddr').attr('id','divAddrId_'+idCount);
         		  cloned.find('.circlePhone').attr('id','divPhoneId_'+idCount);
         		  cloned.find('.circleMobile').attr('id','divMobileId_'+idCount); */
         		  
           		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove Circle Details"/>');
         		 $('#circleClonedDiv').append(cloned);
         		idDivCount++;
         		 
         	  });
         	 $('#circleClonedDiv').on('click','.deleteFileId',function(){
         		  $(this).parent('div').remove();  
         		});
         	  
        	 
        	 
        	 
        	 
        	 
        	 
             
         });
    </script>

