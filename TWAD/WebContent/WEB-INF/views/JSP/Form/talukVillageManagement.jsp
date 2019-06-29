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
var villagelist = "";
var talukNameList = "";
$('#dataTables-example input:checkbox').each(function(){
	talukNameList =  talukNameList +","+$(this).closest('tr').find('td:nth-child(3)').text();
});

$('#dataTables-example input:checkbox').each(function(){
	 villagelist =  villagelist +","+$(this).closest('tr').find('td:nth-child(4)').text();
});

function validateAddTalukForm() {
	
	var talukName = $("#talukNameId");
	var villageNo = $("#clonedDiv .villageNo");
	/* var villageAddr = $("#clonedDiv .villageAddr");
	var villageMobile = $("#clonedDiv .villageMobile"); */
	
	

	var inputVal = new Array(talukName,villageNo/* ,villageAddr,villageMobile */);

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
			 else  if ($(this).attr('id') == 'talukNameId' && $(this).val().length > 1) {
					if(talukNameList.indexOf($(this).val())>-1){
						  $(this).after('<span class="error"> Please enter unique Taluk Name. </span>');
						  $(this).focus();
						  flag = false;
						}
					}
			 else  if ($(this).attr('class') == 'villageNo' && villagelist.indexOf(","+$(this).val()+",")>-1) {
			
						  $(this).after('<span class="error"> Please enter unique Village Name</span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'villageMobile' && !/^[0-9]{10}$/.test($(this).val())) {
				$(this).after('<span class="error"> Please enter correct mobile No. </span>');
				$(this).focus();
				flag = false;
			} */
					
		 });
	
		
	}
	return flag;
}

function validateAddVillageForm() {
	
	var talukName = $("#villageTalukId");
	var villageNo = $("#villageClonedDiv .villageNo");
	/* var villageAddr = $("#villageClonedDiv .villageAddr");
	var villageMobile = $("#villageClonedDiv .villageMobile"); */
	
	

	var inputVal = new Array(talukName,villageNo/* ,villageAddr,villageMobile */);

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
			 else  if ($(this).attr('class') == 'villageNo' && villagelist.indexOf(","+$(this).val()+",")>-1) {
			
						  $(this).after('<span class="error"> Please enter unique Village Name </span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'villageMobile' && !/^[0-9]{10}$/.test($(this).val())) {
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
	
	var editVillageNo = $("#editVillageNoId");
	/* var editVillageAddr = $("#editVillageAddrId");
	var editVillageMobile = $("#editVillageMobileId"); */
	
	

	var inputVal = new Array(editVillageNo/* ,editVillageAddr,editVillageMobile */);

	$('.error').hide();
	flag = true;
	for (i = 0; i < inputVal.length; i++) {
		if (inputVal[i].val() == "") {
			inputVal[i]
					.after('<span class="error"> This field is required. </span>');
			inputVal[i].focus();
			flag = false;
		} 
		
		 else  if (inputVal[i].attr('id') == 'editVillageNoId' && villagelist.indexOf(","+inputVal[i].val()+",")>-1) {
				
			  inputVal[i].after('<span class="error"> Please enter unique Village Name </span>');
			  inputVal[i].focus();
			  flag = false;
		}
/* 
else if (inputVal[i].attr('id') == 'editVillageMobileId' && !/^[0-9]{10}$/.test(inputVal[i].val())) {
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

$('#addTaluk').click(function(){
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'500px','modal':'true'});
	}); 

$('#addVillage').click(function(){
	$(".ui-dialog-content").dialog("close");
	$( "#addVillageDialog" ).dialog({ 'width':'500px','modal':'true'});
}); 
	

	
	
$('#editVillage').click(function(){
	$(".ui-dialog-content").dialog("close");
	var numberOfChecked = $('#dataTables-example td input:checkbox:checked').length;
	if(numberOfChecked==1){
	$( "#editDialog" ).dialog({ 'width':'500px','modal':'true'});
	
	$('#dataTables-example td input:checkbox:checked').each(function(){
		$('#editVillageId').val($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim());
		$('#editTalukNameId').val($(this).closest('tr').find('td:nth-child(3)').text());
		$('#editVillageNoId').val($(this).closest('tr').find('td:nth-child(4)').text());
		
		/* $('#editVillageAddrId').val($(this).closest('tr').find('td:nth-child(5)').text());
		$('#editVillagePhoneId').val($(this).closest('tr').find('td:nth-child(6)').text());
		$('#editVillageMobileId').val($(this).closest('tr').find('td:nth-child(7)').text());
		 */
		talukNameList = talukNameList.replace($(this).closest('tr').find('td:nth-child(3)').text().trim(),"");
		villagelist = villagelist.replace($(this).closest('tr').find('td:nth-child(4)').text().trim(),"");
		
	});
	}
	else{
		alert("Please select only one Village to Edit");
	}
	
	
	
}); 
$('.closeBtn,.imgClose').click(function(){
	$(".ui-dialog-content").dialog("close");
	
}); 


$('#villageSaveBtnId').click(function(){
	var talukVillageIds = "";
	/* var talukVillageAddrs = "";
	var talukVillagePhones = "";
	var talukVillageMobiles = ""; */
	 $('#clonedDiv .villageNo').each(function(){
		 talukVillageIds = talukVillageIds +"," + $(this).val();
	 });
	 
	/*  $('#clonedDiv .villageAddr').each(function(){
		 talukVillageAddrs = talukVillageAddrs +"##" + $(this).val();
	 });
	 
	 $('#clonedDiv .villagePhone').each(function(){
		 talukVillagePhones = talukVillagePhones +"," + $(this).val();
	 });
	 
	 $('#clonedDiv .villageMobile').each(function(){
		 talukVillageMobiles = talukVillageMobiles +"," + $(this).val();
	 }); */
	 
	if(validateAddTalukForm()){
	$.ajax({
		type:"POST",
		url:"addTaluk.do",
		data:{
			'talukName':$('#talukNameId').val(),
			'villageNo':talukVillageIds.substring(1)
			/* 'villageAddr':talukVillageAddrs.substring(2),
			'villagePhone':talukVillagePhones.substring(1),
			'villageMobile':talukVillageMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});


$('#divSaveBtnId').click(function(){
	var talukVillageIds = "";
	/* var talukVillageAddrs = "";
	var talukVillagePhones = "";
	var talukVillageMobiles = ""; */
	 $('#villageClonedDiv .villageNo').each(function(){
		 talukVillageIds = talukVillageIds +"," + $(this).val();
	 });
	 
	/*  $('#villageClonedDiv .villageAddr').each(function(){
		 talukVillageAddrs = talukVillageAddrs +"##" + $(this).val();
	 });
	 
	 $('#villageClonedDiv .villagePhone').each(function(){
		 talukVillagePhones = talukVillagePhones +"," + $(this).val();
	 });
	 
	 $('#villageClonedDiv .villageMobile').each(function(){
		 talukVillageMobiles = talukVillageMobiles +"," + $(this).val();
	 }); */
	if(validateAddVillageForm()){
	$.ajax({
		type:"POST",
		url:"addVillage.do",
		data:{
			'talukVillageId':$('#villageTalukId option:selected').val(),
			'villageName':talukVillageIds.substring(1)
			/* 'villageAddr':talukVillageAddrs.substring(2),
			'villagePhone':talukVillagePhones.substring(1),
			'villageMobile':talukVillageMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});





$('#editVillageBtn').click(function(){
	if(validateEditForm()){
	$.ajax({
		type:"POST",
		url:"editVillage.do",
		data:{
			'talukVillageId':$('#editVillageId').val(),
			'talukName':$('#editTalukNameId').val(),
			'villageName':$('#editVillageNoId').val()
			/* 'villageAddr':$('#editVillageAddrId').val(),
			'villagePhone':$('#editVillagePhoneId').val(),
			'villageMobile':$('#editVillageMobileId').val() */
			
		
		},
		success:function(response){
			alert(response);
			window.location.reload();
			
			
		}
	}); 
	}
	
});

$('#deleteVillage').click(function(){
	var villageList = "";
	var talukNameList = "";
	$('#dataTables-example input:checkbox:checked').each(function(){
		if($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id')!=undefined){
		  villageList = villageList +","+$(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim();
		  talukNameList = talukNameList +","+$(this).closest('tr').find('td:nth-child(3)').text().trim();
		}
	});
	if(confirm("Are you sure want to Delete these Village "+talukNameList.substring(1)+" ? ")){
	$.ajax({
		type:"POST",
		url:"deleteVillage.do",
		data:{
			'talukVillageId':villageList.substring(1)},
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
			<!-- <a href="#" style="padding: 10px;background-color: #78C948;color:white;" id="addTaluk">Add New Taluk</a> -->
			<a href="#" style="padding: 10px;background-color: darkolivegreen;color:white;" id="addVillage">Add New Village</a>
			<a style="padding: 10px;background-color: #FEBA17;color:white;" id="editVillage">Edit</a>
			<a style="padding: 10px;background-color: #EE3B41;color:white;" id="deleteVillage">Delete</a>
			
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
                                            <th style="color:black !important"><b>Taluk Name</b></th>
                                            <th style="color:black !important"><b>Village Name</b></th>
                                            <!--  <th style="color:black !important"><b>Address</b></th>
                                              <th style="color:black !important"><b>Phone</b></th>
                                               <th style="color:black !important"><b>Mobile</b></th> -->
                                           
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    
                                    
                                     <c:forEach items="${list.talukVillageDtl}" var="app" varStatus="count" >
          
                                               <tr class="odd gradeX">
          								
          							
                                            <td><input type="checkbox" id="${app.getVillageId()}" style="width:15px;"/></td>
                                            <td>${count.count}</td>
                                             <td>${app.getTalukName()}</td>
                                             <td>${app.getVillageName()}</td>
                                             
                                            <%--  <td>${app.getVillageAddr()}</td>
                                             <td>${app.getVillagePhone()}</td>
                                             <td>${app.getVillageMobile()}</td> --%>
                                           
                                           
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
		<h2 class="bg_heading">Add New Taluk</h2>


<span><b>Enter Taluk Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="talukNameId" name="talukName" /><br/>
				
				
				<div id="clonedDiv">
		<div id="fileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter Village Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="villageNoId_1" class="villageNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New Village Details"/><br /> 
		
		
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="villageAddrId_1" class="villageAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="villagePhoneId_1" class="villagePhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="villageMobileId_1" class="villageMobile" maxlength="10"  style="margin-left: 14px;width:222px;"/><br/>
				
		 -->
		
		</div>
		</div>
	<input type="button" value="Save" id="villageSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>
		
		
		

<div id="addVillageDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Add New Village</h2>


<span><b>Select Taluk Name:</b></span><span style="color: red;">*</span>
<select id="villageTalukId" name="villageTalukName">
<option value="">--Select Taluk--</option>
<c:forEach var="var" items="${list.talukMap}">
<option value="${var.key}">${var.value}</option>
</c:forEach>


</select><br/>
				
				
				<div id="villageClonedDiv">
		<div id="villageFileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter Village Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divNoId_1" class="villageNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New Village Details"/><br /> 
		
		<!-- 
				<span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divAddrId_1" class="villageAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="divPhoneId_1" class="villagePhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divMobileId_1" class="villageMobile"  maxlength="10" style="margin-left: 14px;width:222px;"/><br/>
				 -->
		
		
		</div>
		</div>
	<input type="button" value="Save" id="divSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>







		
		
		<div id="editDialog" style="display: none;">


<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Edit Village</h2>
		
				<input type="hidden" id="editVillageId"/>
                 <span><b>Taluk Name:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editTalukNameId" name="editTalukName" readonly="readonly"/><br/>
                <span><b>Enter Village Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editVillageNoId" name="editVillageNo" style="margin-left: 5px;width:118px;"/><br/>
				
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editVillageAddrId" name="editVillageAddr" style="margin-left: 5px;width:227px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editVillagePhoneId" name="editVillagePhone" style="margin-left: 16px;width:228px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editVillageMobileId" name="editVillageMobile"  maxlength="10" style="margin-left: 14px;width:228px;"/><br/>
				
				 -->
				
				
				
				<input type="button" value="Update" id="editVillageBtn"/> <input type="button" value="Close" class="closeBtn"/>
				
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
        		  cloned.find('.villageNo').attr('id','villageNoId_'+idCount);
        		  
        		 /*  cloned.find('.villageAddr').attr('id','villageAddrId_'+idCount);
        		  cloned.find('.villagePhone').attr('id','villagePhoneId_'+idCount);
        		  cloned.find('.villageMobile').attr('id','villageMobileId_'+idCount); */
        		  
          		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove Village Details"/>');
        		 $('#clonedDiv').append(cloned);
        		 idCount++;
        		 
        	  });
        	 $('#clonedDiv').on('click','.deleteFileId',function(){
        		  $(this).parent('div').remove();  
        		});
        	  
        	 
        	  var idDivCount=2;
         	 $('#villageClonedDiv').on('click','.addFileId',function(){
         		  var cloned = $('#villageFileCloneId').clone();
         		  cloned.find('img.deleteFileId').remove();
         		  cloned.attr('id','fileCloneId_'+idCount);
         		  cloned.find('.villageNo').attr('id','divNoId_'+idCount);
         		  
         		  /* cloned.find('.villageAddr').attr('id','divAddrId_'+idCount);
         		  cloned.find('.villagePhone').attr('id','divPhoneId_'+idCount);
         		  cloned.find('.villageMobile').attr('id','divMobileId_'+idCount); */
         		  
           		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove Village Details"/>');
         		 $('#villageClonedDiv').append(cloned);
         		idDivCount++;
         		 
         	  });
         	 $('#villageClonedDiv').on('click','.deleteFileId',function(){
         		  $(this).parent('div').remove();  
         		});
         	  
        	 
        	 
        	 
        	 
        	 
        	 
             
         });
    </script>

