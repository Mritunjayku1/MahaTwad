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
var connectionTypelist = "";
$('#dataTables-example input:checkbox').each(function(){
	 connectionTypelist =  connectionTypelist +","+$(this).closest('tr').find('td:nth-child(3)').text();
});

function validateAddForm() {
	
	var connectionTypeName = $("#connectionTypeNameId");
	
	

	var inputVal = new Array(connectionTypeName);

	$('.error').hide();
	flag = true;
	for (i = 0; i < inputVal.length; i++) {
		if (inputVal[i].val() == "") {
			inputVal[i]
					.after('<span class="error"> This field is required. </span>');
			inputVal[i].focus();
			flag = false;
		} 
		
		else if (inputVal[i].attr('id') == 'connectionTypeNameId' && inputVal[i].val().length > 1) {
			if(connectionTypelist.indexOf(inputVal[i].val())>-1){
			  inputVal[i].after('<span class="error"> Please enter unique ConnectionType Name. </span>');
			  inputVal[i].focus();
			  flag = false;
			}
		}
		
	}
	return flag;
}


function validateEditForm() {
	
	var editConnectionTypeName = $("#editConnectionTypeNameId");
	
	

	var inputVal = new Array(editConnectionTypeName);

	$('.error').hide();
	flag = true;
	for (i = 0; i < inputVal.length; i++) {
		if (inputVal[i].val() == "") {
			inputVal[i]
					.after('<span class="error"> This field is required. </span>');
			inputVal[i].focus();
			flag = false;
		} 
		
		else if (inputVal[i].attr('id') == 'editConnectionTypeNameId' && inputVal[i].val().length > 1) {
			if(connectionTypelist.indexOf(inputVal[i].val())>-1){
			  inputVal[i].after('<span class="error"> Please enter unique ConnectionType Name. </span>');
			  inputVal[i].focus();
			  flag = false;
			}
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

$('#addConnectionType').click(function(){
		$(".ui-dialog-content").dialog("close");
		$( "#addDialog" ).dialog({ 'width':'500px','modal':'true'});
	}); 
$('#editConnectionType').click(function(){
	$(".ui-dialog-content").dialog("close");
	var numberOfChecked = $('#dataTables-example td input:checkbox:checked').length;
	if(numberOfChecked==1){
	$( "#editDialog" ).dialog({ 'width':'500px','modal':'true'});
	
	$('#dataTables-example td input:checkbox:checked').each(function(){
		$('#editConnectionTypeId').val($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim());
		$('#editConnectionTypeNameId').val($(this).closest('tr').find('td:nth-child(3)').text());
		$('#editConnectionTypeDescId').val($(this).closest('tr').find('td:nth-child(4)').text());
		
		connectionTypelist = connectionTypelist.replace($(this).closest('tr').find('td:nth-child(3)').text().trim(),"");
		
	});
	}
	else{
		alert("Please select only one ConnectionType to Edit");
	}
	
	
	
}); 
$('.closeBtn,.imgClose').click(function(){
	$(".ui-dialog-content").dialog("close");
	
}); 


$('#connectionTypeSaveBtnId').click(function(){
	if(validateAddForm()){
	$.ajax({
		type:"POST",
		url:"addConnectionType.do",
		data:{
			'connectionName':$('#connectionTypeNameId').val(),
			'connectionDesc':$('#connectionTypeDescId').val()},
		success:function(response){
			alert(response);
			
			window.location.reload();
		}
	});
	}
});

$('#editConnectionTypeBtn').click(function(){
	if(validateEditForm()){
	$.ajax({
		type:"POST",
		url:"editConnectionType.do",
		data:{
			'connectionId':$('#editConnectionTypeId').val(),
			'connectionName':$('#editConnectionTypeNameId').val(),
			'connectionDesc':$('#editConnectionTypeDescId').val()},
		success:function(response){
			alert(response);
			window.location.reload();
			
			
		}
	}); 
	}
	
});

$('#deleteConnectionType').click(function(){
	var connectionTypeList = "";
	var connectionTypeNameList = "";
	$('#dataTables-example input:checkbox:checked').each(function(){
		if($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id')!=undefined){
		  connectionTypeList = connectionTypeList +","+$(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim();
		  connectionTypeNameList = connectionTypeNameList +","+$(this).closest('tr').find('td:nth-child(3)').text().trim();
		}
	});
	if(confirm("Are you sure want to Delete these ConnectionType "+connectionTypeNameList.substring(1)+" ? ")){
	$.ajax({
		type:"POST",
		url:"deleteConnectionType.do",
		data:{
			'connectionId':connectionTypeList.substring(1)},
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
			<a href="#" style="padding: 10px;background-color: #78C948;color:white;" id="addConnectionType">Add New ConnectionType</a>
			<a style="padding: 10px;background-color: #FEBA17;color:white;" id="editConnectionType">Edit</a>
			<a style="padding: 10px;background-color: #EE3B41;color:white;" id="deleteConnectionType">Delete</a>
			
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
                                            <th style="color:black !important"><b>Connection Type</b></th>
                                            <th style="color:black !important"><b>Description</b></th>
                                           
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    
                                    
                                     <c:forEach items="${list.connectionTypeDtl}" var="app" varStatus="count" >
          
                                               <tr class="odd gradeX">
          								
          							
                                            <td><input type="checkbox" id="${app.getConnectionId()}" style="width:15px;"/></td>
                                            <td>${count.count}</td>
                                             <td>${app.getConnectionName()}</td>
                                             <td>${app.getConnectionDesc()}</td>
                                           
                                           
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
		<h2 class="bg_heading">Add New ConnectionType</h2>
<span><b>Connection Type:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="connectionTypeNameId" name="connectionTypeName" /><br/>
<span><b>Description:</b></span>
				<input placeholder="Ex: ABC" type="text" id="connectionTypeDescId" name="connectionTypeDesc" style="margin-left: 46px;"/><br/>
				<input type="button" value="Save" id="connectionTypeSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>
				
		</div>
		
		
		<div id="editDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Edit ConnectionType</h2>
				<input type="hidden" id="editConnectionTypeId"/>
<span><b>Connection Type:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editConnectionTypeNameId" name="editConnectionTypeName" /><br/>
<span><b>Description:</b></span>
				<input placeholder="Ex: ABC" type="text" id="editConnectionTypeDescId" name="editConnectionTypeDesc" style="margin-left: 46px;"/><br/>
				<input type="button" value="Update" id="editConnectionTypeBtn"/> <input type="button" value="Close" class="closeBtn"/>
				
		</div>
	<script src="library/assets/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="library/assets/plugins/dataTables/dataTables.bootstrap.js"></script>
     <script>
         $(document).ready(function () {
             $('#dataTables-example').dataTable();
         });
    </script>
