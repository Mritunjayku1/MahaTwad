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
var schemelist = "";
var villageNameList = "";
$('#dataTables-example input:checkbox').each(function(){
	villageNameList =  villageNameList +","+$(this).closest('tr').find('td:nth-child(3)').text();
});

$('#dataTables-example input:checkbox').each(function(){
	 schemelist =  schemelist +","+$(this).closest('tr').find('td:nth-child(4)').text();
});

function validateAddVillageForm() {
	
	var villageName = $("#villageNameId");
	var schemeNo = $("#clonedDiv .schemeNo");
	var quantity = $("#clonedDiv .quantity");
	/* var schemeAddr = $("#clonedDiv .schemeAddr");
	var schemeMobile = $("#clonedDiv .schemeMobile"); */
	
	

	var inputVal = new Array(villageName,schemeNo,quantity/* ,schemeAddr,schemeMobile */);

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
			 else  if ($(this).attr('id') == 'villageNameId' && $(this).val().length > 1) {
					if(villageNameList.indexOf($(this).val())>-1){
						  $(this).after('<span class="error"> Please enter unique Village Name. </span>');
						  $(this).focus();
						  flag = false;
						}
					}
			 else  if ($(this).attr('class') == 'schemeNo' && (schemelist.indexOf(","+$(this).val()+",")>-1)) {
			
						  $(this).after('<span class="error"> Please enter unique Scheme No. and should be Numeric </span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'schemeMobile' && !/^[0-9]{10}$/.test($(this).val())) {
				$(this).after('<span class="error"> Please enter correct mobile No. </span>');
				$(this).focus();
				flag = false;
			} */
					
		 });
	
		
	}
	return flag;
}

function validateAddSchemeForm() {
	
	var villageName = $("#schemeVillageId");
	var schemeNo = $("#schemeClonedDiv .schemeNo");
	var quantity = $("#schemeClonedDiv .quantity");
	/* var schemeAddr = $("#schemeClonedDiv .schemeAddr");
	var schemeMobile = $("#schemeClonedDiv .schemeMobile"); */
	
	

	var inputVal = new Array(villageName,schemeNo,quantity/* ,schemeAddr,schemeMobile */);

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
			 else  if ($(this).attr('class') == 'schemeNo' && schemelist.indexOf(","+$(this).val()+",")>-1) {
			
						  $(this).after('<span class="error"> Please enter unique Scheme Name </span>');
						  $(this).focus();
						  flag = false;
					}
			
			/*  else if ($(this).attr('class') == 'schemeMobile' && !/^[0-9]{10}$/.test($(this).val())) {
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
	
	var editSchemeNo = $("#editSchemeNoId");
	var editQuantity = $("#editQuantityId");
	/* var editSchemeAddr = $("#editSchemeAddrId");
	var editSchemeMobile = $("#editSchemeMobileId"); */
	
	

	var inputVal = new Array(editSchemeNo,editQuantity/* ,editSchemeAddr,editSchemeMobile */);

	$('.error').hide();
	flag = true;
	for (i = 0; i < inputVal.length; i++) {
		if (inputVal[i].val() == "") {
			inputVal[i]
					.after('<span class="error"> This field is required. </span>');
			inputVal[i].focus();
			flag = false;
		} 
		
		 else  if (inputVal[i].attr('id') == 'editSchemeNoId' && schemelist.indexOf(","+inputVal[i].val()+",")>-1) {
				
			  inputVal[i].after('<span class="error"> Please enter unique Scheme Name </span>');
			  inputVal[i].focus();
			  flag = false;
		}
/* 
else if (inputVal[i].attr('id') == 'editSchemeMobileId' && !/^[0-9]{10}$/.test(inputVal[i].val())) {
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

$('#addVillage').click(function(){
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'500px','modal':'true'});
	}); 

$('#addScheme').click(function(){
	$(".ui-dialog-content").dialog("close");
	$( "#addSchemeDialog" ).dialog({ 'width':'500px','modal':'true'});
}); 
	

	
	
$('#editScheme').click(function(){
	$(".ui-dialog-content").dialog("close");
	var numberOfChecked = $('#dataTables-example td input:checkbox:checked').length;
	if(numberOfChecked==1){
	$( "#editDialog" ).dialog({ 'width':'500px','modal':'true'});
	
	$('#dataTables-example td input:checkbox:checked').each(function(){
		$('#editSchemeId').val($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim());
		$('#editVillageNameId').val($(this).closest('tr').find('td:nth-child(3)').text());
		$('#editSchemeNoId').val($(this).closest('tr').find('td:nth-child(4)').text());
		$('#editQuantityId').val($(this).closest('tr').find('td:nth-child(5)').text());
		/* $('#editSchemeAddrId').val($(this).closest('tr').find('td:nth-child(5)').text());
		$('#editSchemePhoneId').val($(this).closest('tr').find('td:nth-child(6)').text());
		$('#editSchemeMobileId').val($(this).closest('tr').find('td:nth-child(7)').text());
		 */
		villageNameList = villageNameList.replace($(this).closest('tr').find('td:nth-child(3)').text().trim(),"");
		schemelist = schemelist.replace($(this).closest('tr').find('td:nth-child(4)').text().trim(),"");
		
	});
	}
	else{
		alert("Please select only one Scheme to Edit");
	}
	
	
	
}); 
$('.closeBtn,.imgClose').click(function(){
	$(".ui-dialog-content").dialog("close");
	
}); 


$('#schemeSaveBtnId').click(function(){
	var villageSchemeIds = "";
	var villageQuantityIds = "";
	/* var villageSchemeAddrs = "";
	var villageSchemePhones = "";
	var villageSchemeMobiles = ""; */
	 $('#clonedDiv .schemeNo').each(function(){
		 villageSchemeIds = villageSchemeIds +"," + $(this).val();
	 });
	
	 $('#clonedDiv .quantity').each(function(){
		 villageQuantityIds = villageQuantityIds +"," + $(this).val();
	 });
	 
	/*  $('#clonedDiv .schemeAddr').each(function(){
		 villageSchemeAddrs = villageSchemeAddrs +"##" + $(this).val();
	 });
	 
	 $('#clonedDiv .schemePhone').each(function(){
		 villageSchemePhones = villageSchemePhones +"," + $(this).val();
	 });
	 
	 $('#clonedDiv .schemeMobile').each(function(){
		 villageSchemeMobiles = villageSchemeMobiles +"," + $(this).val();
	 });
	  */
	if(validateAddVillageForm()){
	$.ajax({
		type:"POST",
		url:"addVillage.do",
		data:{
			'villageName':$('#villageNameId').val(),
			'schemeNo':villageSchemeIds.substring(1),
			'quantity':villageQuantityIds.substring(1)
			/* 'schemeAddr':villageSchemeAddrs.substring(2),
			'schemePhone':villageSchemePhones.substring(1),
			'schemeMobile':villageSchemeMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});


$('#divSaveBtnId').click(function(){
	var villageSchemeIds = "";
	var villageQuantityIds = "";
	/* var villageSchemeAddrs = "";
	var villageSchemePhones = "";
	var villageSchemeMobiles = ""; */
	 $('#schemeClonedDiv .schemeNo').each(function(){
		 villageSchemeIds = villageSchemeIds +"," + $(this).val();
	 });
	 $('#schemeClonedDiv .quantity').each(function(){
		 villageQuantityIds = villageQuantityIds +"," + $(this).val();
	 });
	 
	/*  $('#schemeClonedDiv .schemeAddr').each(function(){
		 villageSchemeAddrs = villageSchemeAddrs +"##" + $(this).val();
	 });
	 
	 $('#schemeClonedDiv .schemePhone').each(function(){
		 villageSchemePhones = villageSchemePhones +"," + $(this).val();
	 });
	 
	 $('#schemeClonedDiv .schemeMobile').each(function(){
		 villageSchemeMobiles = villageSchemeMobiles +"," + $(this).val();
	 }); */
	if(validateAddSchemeForm()){
	$.ajax({
		type:"POST",
		url:"addScheme.do",
		data:{
			'villageSchemeId':$('#schemeVillageId option:selected').val(),
			'schemeName':villageSchemeIds.substring(1),
			'quantity':villageQuantityIds.substring(1)
			/* 'schemeAddr':villageSchemeAddrs.substring(2),
			'schemePhone':villageSchemePhones.substring(1),
			'schemeMobile':villageSchemeMobiles.substring(1) */
			
		},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});





$('#editSchemeBtn').click(function(){
	if(validateEditForm()){
	$.ajax({
		type:"POST",
		url:"editScheme.do",
		data:{
			'villageSchemeId':$('#editSchemeId').val(),
			'villageName':$('#editVillageNameId').val(),
			'schemeName':$('#editSchemeNoId').val(),
			'quantity':$('#editQuantityId').val()
			/* 'schemeAddr':$('#editSchemeAddrId').val(),
			'schemePhone':$('#editSchemePhoneId').val(),
			'schemeMobile':$('#editSchemeMobileId').val() */
			
		
		},
		success:function(response){
			alert(response);
			window.location.reload();
			
			
		}
	}); 
	}
	
});

$('#deleteScheme').click(function(){
	var schemeList = "";
	var villageNameList = "";
	$('#dataTables-example input:checkbox:checked').each(function(){
		if($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id')!=undefined){
		  schemeList = schemeList +","+$(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim();
		  villageNameList = villageNameList +","+$(this).closest('tr').find('td:nth-child(3)').text().trim();
		}
	});
	if(confirm("Are you sure want to Delete these Scheme "+villageNameList.substring(1)+" ? ")){
	$.ajax({
		type:"POST",
		url:"deleteScheme.do",
		data:{
			'villageSchemeId':schemeList.substring(1)},
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
			<!-- <a href="#" style="padding: 10px;background-color: #78C948;color:white;" id="addVillage">Add New Village</a> -->
			<a href="#" style="padding: 10px;background-color: darkolivegreen;color:white;" id="addScheme">Add New Scheme</a>
			<a style="padding: 10px;background-color: #FEBA17;color:white;" id="editScheme">Edit</a>
			<a style="padding: 10px;background-color: #EE3B41;color:white;" id="deleteScheme">Delete</a>
			
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
                                            <th style="color:black !important"><b>Scheme Name</b></th>
                                             <th style="color:black !important"><b>Quantity</b></th>
                                             <!-- <th style="color:black !important"><b>Address</b></th>
                                              <th style="color:black !important"><b>Phone</b></th>
                                               <th style="color:black !important"><b>Mobile</b></th> -->
                                           
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    
                                    
                                     <c:forEach items="${list.villageSchemeDtl}" var="app" varStatus="count" >
          
                                               <tr class="odd gradeX">
          								
          							
                                            <td><input type="checkbox" id="${app.getSchemeId()}" style="width:15px;"/></td>
                                            <td>${count.count}</td>
                                             <td>${app.getVillageName()}</td>
                                             <td>${app.getSchemeName()}</td>
                                             <td>${app.getQuantity()}</td>
                                             
                                            <%--  <td>${app.getSchemeAddr()}</td>
                                             <td>${app.getSchemePhone()}</td>
                                             <td>${app.getSchemeMobile()}</td> --%>
                                           
                                           
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
		<h2 class="bg_heading">Add New Village</h2>


<span><b>Enter Village Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="villageNameId" name="villageName" /><br/>
				
				
				<div id="clonedDiv">
		<div id="fileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter Scheme Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="schemeNoId_1" class="schemeNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New Scheme Details"/><br /> 

						
<span><b>Enter Quantity:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="quantityId_1" class="quantity" style="margin-left: 5px;width:118px;"/><br /> 
		
		
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="schemeAddrId_1" class="schemeAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="schemePhoneId_1" class="schemePhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="schemeMobileId_1" class="schemeMobile" maxlength="10"  style="margin-left: 14px;width:222px;"/><br/>
				
		 -->
		
		</div>
		</div>
	<input type="button" value="Save" id="schemeSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>
		
		
		

<div id="addSchemeDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Add New Scheme</h2>


<span><b>Select District Name:</b></span><span style="color: red;">*</span>
<select id="schemeVillageId" name="schemeVillageName" style="margin-left: 15px;">
<option value="">--Select District--</option>
<c:forEach var="var" items="${list.villageMap}">
<option value="${var.key}">${var.value}</option>
</c:forEach>


</select><br/>
				
				
				<div id="schemeClonedDiv">
		<div id="schemeFileCloneId" style="border: 1px solid lightgrey;padding:6px;">
						
<span><b>Enter Scheme Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divNoId_1" class="schemeNo" style="margin-left: 5px;width:118px;"/><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId" title="Add New Scheme Details"/><br /> 
		
								
<span><b>Enter Quantity:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="quantityId_1" class="quantity" style="margin-left: 43px;width:118px;"/><br /> 
		
		
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divAddrId_1" class="schemeAddr" style="margin-left: 5px;width:220px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="divPhoneId_1" class="schemePhone" style="margin-left: 16px;width:222px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="divMobileId_1" class="schemeMobile"  maxlength="10" style="margin-left: 14px;width:222px;"/><br/>
				
		 -->
		
		</div>
		</div>
	<input type="button" value="Save" id="divSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>

		</div>







		
		
		<div id="editDialog" style="display: none;">


<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Edit Scheme</h2>
		
				<input type="hidden" id="editSchemeId"/>
                 <span><b>District Name:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editVillageNameId" name="editVillageName" readonly="readonly"  style="margin-left: 60px;"/><br/>
                <span><b>Enter Scheme Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editSchemeNoId" name="editSchemeNo" style="margin-left: 5px;width:118px;"/><br/>
				 <span><b>Enter Quantity:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editQuantityId" name="editQuantity" style="margin-left: 43px;width:118px;"/><br/>
				
				<!-- <span><b>Enter Address:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editSchemeAddrId" name="editSchemeAddr" style="margin-left: 5px;width:227px;"/><br/>
				
				<span><b>Enter Phone:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editSchemePhoneId" name="editSchemePhone" style="margin-left: 16px;width:228px;"/><br/>
				
				<span><b>Enter Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editSchemeMobileId" name="editSchemeMobile"  maxlength="10" style="margin-left: 14px;width:228px;"/><br/>
				
				 -->
				
				
				
				<input type="button" value="Update" id="editSchemeBtn"/> <input type="button" value="Close" class="closeBtn"/>
				
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
        		  cloned.find('.schemeNo').attr('id','schemeNoId_'+idCount);
        		  cloned.find('.quantity').attr('id','quantityId_'+idCount);
        		  
        		 /*  cloned.find('.schemeAddr').attr('id','schemeAddrId_'+idCount);
        		  cloned.find('.schemePhone').attr('id','schemePhoneId_'+idCount);
        		  cloned.find('.schemeMobile').attr('id','schemeMobileId_'+idCount); */
        		  
          		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove Scheme Details"/>');
        		 $('#clonedDiv').append(cloned);
        		 idCount++;
        		 
        	  });
        	 $('#clonedDiv').on('click','.deleteFileId',function(){
        		  $(this).parent('div').remove();  
        		});
        	  
        	 
        	  var idDivCount=2;
         	 $('#schemeClonedDiv').on('click','.addFileId',function(){
         		  var cloned = $('#schemeFileCloneId').clone();
         		  cloned.find('img.deleteFileId').remove();
         		  cloned.attr('id','fileCloneId_'+idCount);
         		  cloned.find('.schemeNo').attr('id','divNoId_'+idCount);
         		  cloned.find('.quantity').attr('id','quantityId_'+idCount);
         		  
         		  /* cloned.find('.schemeAddr').attr('id','divAddrId_'+idCount);
         		  cloned.find('.schemePhone').attr('id','divPhoneId_'+idCount);
         		  cloned.find('.schemeMobile').attr('id','divMobileId_'+idCount); */
         		  
           		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId" title="Remove Scheme Details"/>');
         		 $('#schemeClonedDiv').append(cloned);
         		idDivCount++;
         		 
         	  });
         	 $('#schemeClonedDiv').on('click','.deleteFileId',function(){
         		  $(this).parent('div').remove();  
         		});
         	  
        	 
        	 
        	 
        	 
        	 
        	 
             
         });
    </script>

