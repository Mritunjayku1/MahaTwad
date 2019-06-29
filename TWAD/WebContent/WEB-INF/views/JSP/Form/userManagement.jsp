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
	var userlist = "";
	$('#dataTables-example input:checkbox').each(function(){
		 userlist =  userlist +","+$(this).closest('tr').find('td:nth-child(4)').text();
});
	
	function validateAddForm() {
		var numberReg = /^[0-9]{10}$/;
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var passwordRegex = /^(?=.{8,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$/;
		var userName = $("#userNameId");
		var password = $('#passwordId');
		var name = $("#nameId");
		var mobile = $("#mobileId");
		var email = $("#emailId");
		

		var inputVal = new Array(userName,password, name, mobile,email);
        userlist = userlist +",";
		$('.error').hide();
		flag = true;
		for (i = 0; i < inputVal.length; i++) {
			if (inputVal[i].val() == "") {
				inputVal[i]
						.after('<span class="error"> This field is required. </span>');
				inputVal[i].focus();
				flag = false;
			}
			
			else if (inputVal[i].attr('id') == 'passwordId'
				&& !passwordRegex.test(inputVal[i].val())) {
			inputVal[i]
					.after('<br/><span class="error"> Please should contains minimum 8 character, atleast 1 caps, 1 small, 1 number and 1 special character </span>');
			inputVal[i].focus();
			flag = false;
		}
			
			
			else if (inputVal[i].attr('id') == 'emailId'
					&& !emailReg.test(inputVal[i].val())) {
				inputVal[i]
						.after('<span class="error"> Please enter correct Email Id </span>');
				inputVal[i].focus();
				flag = false;
			} else if (inputVal[i].attr('id') == 'mobileId' &&  !numberReg.test(inputVal[i].val())) {
				inputVal[i].after('<span class="error"> Please enter correct mobile No. </span>');
				inputVal[i].focus();
				flag = false;
			}
			
			else if (inputVal[i].attr('id') == 'userNameId' && userlist.indexOf(","+inputVal[i].val()+",")>-1) {
				  inputVal[i].after('<span class="error"> Please enter unique User Name. </span>');
				  inputVal[i].focus();
				  flag = false;
			}
			
		}
		return flag;
	}
	
	
	function validateEditForm() {
		var numberReg = /^[0-9]{10}$/;
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var passwordRegex =/^(?=.{8,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$/;
		var editUserName = $("#editUserNameId");
		var editPassword = $('#editPasswordId');
		var editName = $("#editNameId");
		var editMobile = $("#editMobileId");
		var editEmail = $("#editEmailId");
		
		userlist = userlist +",";

		var inputVal = new Array(editUserName,editPassword, editName, editMobile,editEmail);

		$('.error').hide();
		flag = true;
		for (i = 0; i < inputVal.length; i++) {
			if (inputVal[i].val() == "") {
				inputVal[i]
						.after('<span class="error"> This field is required. </span>');
				inputVal[i].focus();
				flag = false;
			} 
			
			else if (inputVal[i].attr('id') == 'editPasswordId'
				&& !passwordRegex.test(inputVal[i].val())) {
			inputVal[i]
					.after('<br/><span class="error"> Please should contains minimum 8 character, atleast 1 caps, 1 small, 1 number and 1 special character </span>');
			inputVal[i].focus();
			flag = false;
		}
			
			
			else if (inputVal[i].attr('id') == 'editEmailId'
					&& !emailReg.test(inputVal[i].val())) {
				inputVal[i]
						.after('<span class="error"> Please enter correct Email Id </span>');
				inputVal[i].focus();
				flag = false;
			} else if (inputVal[i].attr('id') == 'mobileId' &&  !numberReg.test(inputVal[i].val())) {
				inputVal[i].after('<span class="error"> Please enter correct mobile No. </span>');
				inputVal[i].focus();
				flag = false;
			}
			
			else if (inputVal[i].attr('id') == 'editUserNameId'  && userlist.indexOf(","+inputVal[i].val()+",")>-1) {
				  inputVal[i].after('<span class="error"> Please enter unique User Name. </span>');
				  inputVal[i].focus();
				  flag = false;
			}
			
		}
		return flag;
	}
	
	
	
	  $.ajax({
			type: "GET",
			async:false,
			url: "library/Region.json",
			success: function (response) {	
				var region = response;
					var option = '<option value="">--Select--</option>';
					if (region != undefined)
						for (var i = 0; i < region.length; i++) {
							option = option + '<option value="' + region[i].id + '">' +region[i].value +'</option>';
						}
					$('.regionSearchClass').find('option').remove();
					$('.regionSearchClass').append(option);}
	  
	  });
     
  	  $('.regionSearchClass').change(function () {
  		  var id = $(this).attr("id");
  	  
  		  $.ajax({
 					type: "GET",
 					async:false,
 					url: "library/Circle.json",
 					success: function (response)  {
     						
      					var regionSelectedValue =$("#"+id+" option:selected").val();
					var circle = response[regionSelectedValue];
					var option = '<option value="">--Select--</option>';
					if (circle != undefined)
						for (var i = 0; i < circle.length; i++) {

							
										option = option + '<option value="' + circle[i].id + '">' +circle[i].value +'</option>';
							
						}
					$('.circleSearchClass').find('option').remove();
					$('.circleSearchClass').append(option);
      					}
      	    	  
 	    	  
 	    	  });
   	        
  	  
        });



              
               $('.circleSearchClass').change(function () { 
             	  
             	  var id = $(this).attr("id");
	    	  
             	  $.ajax({
               
     					type: "GET",
        					async:false,
        					url: "library/Division.json",
        					success: function (response) {
        						
        					var circleSelectedValue =$("#"+id+" option:selected").val();
						var division = response[circleSelectedValue];
						var option = '<option value="">--Select--</option>';
						if (division != undefined)
							for (var i = 0; i < division.length; i++) {
							option = option + '<option value="' + division[i].id + '">' +division[i].value +'</option>';
							}
						$('.divisionSearchClass').find('option').remove();
						$('.divisionSearchClass').append(option);
        					}
        	    	  
        	    	  });
               
             	});

               
	
	
	
	
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

	$('#addUser').click(function(){
			$(".ui-dialog-content").dialog("close");
			$( "#addDialog" ).dialog({ 'width':'500px','modal':'true'});
		}); 
	$('#editUser').click(function(){
		$(".ui-dialog-content").dialog("close");
		var numberOfChecked = $('#dataTables-example td input:checkbox:checked').length;
		if(numberOfChecked==1){
		$( "#editDialog" ).dialog({ 'width':'500px','modal':'true'});
		
		$('#dataTables-example td input:checkbox:checked').each(function(){
			$('#editUserId').val($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim());
			$('#editRoleId option[value="'+$(this).closest('tr').find('td:nth-child(3)').attr('id').trim()+'"]').attr('selected', 'selected');
			$('#editDivisionId option[value="'+$(this).closest('tr').find('td:nth-child(4)').attr('id').trim()+'"]').attr('selected', 'selected');
			$('#editUserNameId').val($(this).closest('tr').find('td:nth-child(5)').text());
			$('#editPasswordId').val($(this).closest('tr').find('td:nth-child(6)').text());
			$('#editNameId').val($(this).closest('tr').find('td:nth-child(7)').text());
			$('#editMobileId').val($(this).closest('tr').find('td:nth-child(9)').text());
			$('#editEmailId').val($(this).closest('tr').find('td:nth-child(8)').text());
			userlist = userlist.replace($(this).closest('tr').find('td:nth-child(5)').text().trim(),"");
			
		});
		}
		else{
			alert("Please select only one User to Edit");
		}
		
		
		
	}); 
	$('.closeBtn,.imgClose').click(function(){
		$(".ui-dialog-content").dialog("close");
		
	}); 
	
	
	$('#userSaveBtnId').click(function(){
		if(validateAddForm()){
		$.ajax({
			type:"POST",
			url:"addNewUser.do",
			data:{
				'roleId':$('#roleId').val(),
				'divisionId':$('#divisionId').val(),
				'username':$('#userNameId').val(),
				'name':$('#nameId').val(),
				'password':$('#passwordId').val(),
				'mobile':$('#mobileId').val(),
				'email':$('#emailId').val()},
			success:function(response){
				alert(response);
				
				window.location.reload();
			}
		});
		}
	});
	
	$('#editUserBtn').click(function(){
		if(validateEditForm()){
		$.ajax({
			type:"POST",
			url:"editUser.do",
			data:{
				'userId':$('#editUserId').val(),
				'divisionId':$('#editDivisionId').val(),
				'roleId':$('#editRoleId').val(),
				'username':$('#editUserNameId').val(),
				'name':$('#editNameId').val(),
				'password':$('#editPasswordId').val(),
				'mobile':$('#editMobileId').val(),
				'email':$('#editEmailId').val()},
			success:function(response){
				alert(response);
				window.location.reload();
				
				
			}
		}); 
		}
		
	});
	
	$('#deleteUser').click(function(){
		var userList = "";
		var userNameList = "";
		$('#dataTables-example input:checkbox:checked').each(function(){
			if($(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id')!=undefined){
			  userList = userList +","+$(this).closest('tr').find('td:nth-child(1)').find('input[type="checkbox"]').attr('id').trim();
			  userNameList = userNameList +","+$(this).closest('tr').find('td:nth-child(4)').text().trim();
			}
		});
		if(confirm("Are you sure want to Delete these Users "+userNameList.substring(1)+" ? ")){
		$.ajax({
			type:"POST",
			url:"deleteUser.do",
			data:{
				'userId':userList.substring(1)},
			success:function(response){
				alert(response);
				window.location.reload();
				
				
			}
		});
		}
	});
	
	
	$('input[name="approveBtn"]').click(function(){
		var appRef = $(this).attr('id');
		var remarks=$(this).closest('tr').find('td:nth-child(8)').find('textarea.remarksCls').val();
		if(remarks == null || remarks=='')
		{
		alert("Please enter the remarks !")
		return false;
		}
		if(confirm("Are you sure want to Approve ? ")){
		$.ajax({
			type:"POST",
			url:"ceApprove.do",
			data:{'appRef':appRef,'remarks':remarks},
			success:function(response){
				//$('#successMessage').text(response);
				alert(response);
				window.location.reload();
				
			}
		});
		}
		
	});
	
	/* $('#roleId,#editRoleId').change(function(){
		var selectedRole = $(this).val();
		if(selectedRole != 2){
			$('.regionSearchClass option').attr('disabled',true);
		}
		else{
			$('.regionSearchClass option').removeAttr('disabled');
		}
	}); */
	
});
</script>
<table class='table-bordered table table-striped display'
	style='width: 100%; font-size: 28px;'>
<tr>
		<td colspan='8'>
			<a href="#" style="padding: 10px;background-color: #78C948;color:white;" id="addUser">Add New User</a>
			<a style="padding: 10px;background-color: #FEBA17;color:white;" id="editUser">Edit</a><a style="padding: 10px;background-color: #EE3B41;color:white;" id="deleteUser">Delete</a>
			
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
                                            <th style="color:black !important"><b>Role</b></th>
                                             <th style="color:black !important"><b>Division Name</b></th>
                                            <th style="color:black !important"><b>User Name</b></th>
                                             <th style="color:black !important"><b>Password</b></th> 
                                             <th style="color:black !important"><b>Name</b></th>
                                            <th style="color:black !important"><b>Email</b></th>
                                             <th style="color:black !important"><b>Mobile</b></th>
                                             <!--  <th style="color:black !important"><b>Status</b></th> -->
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                   
                                    
                                    
                                     <c:forEach items="${list.userDtl}" var="app" varStatus="count" >
          
                                               <tr class="odd gradeX">
          								
          							
                                            <td><input type="checkbox" id="${app.getUserId()}" style="width:15px;"/></td>
                                            <td>${count.count}</td>
                                             <td id="${app.getRoleId()}">${app.getRole()}</td>
                                             <td id="${app.getDivisionId()}">${app.getDivision()}</td>
                                             <td>${app.getUsername()}</td>
                                              <td>*********</td> 
                                            <td class="center">${app.getName()}</td>
                                            <td class="center">${app.getEmail()}</td>
                                          
                                             <td class="center">${app.getMobile()}</td>
                                            <!--  <td class="center">Active</td> -->
                                           
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
<div id="addDialog" style="display: none;">


<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Add New User</h2>
		

<span><b>Role:</b></span><span style="color: red;">*</span>
				<select style="margin-left: 52px;width: 200px;" id="roleId">
				<option value="10">Administrator</option>
				<option value="1">CE</option>
				<option value="2">EE</option>
				<!-- <option value="3">MC</option> -->
				<option value="4">HO</option>
				
				</select><br/>
				
  <span><b>Region:</b></span><span style="color: red;">*</span>
				<select class = "regionSearchClass" style="width: 200px;margin-left:35px; " id="regionId"></select><br/>
				
				<span><b>Circle:</b></span><span style="color: red;">*</span>
				<select class = "circleSearchClass" style="width: 200px;margin-left:44px;" id="circleId"></select><br/>
				
				<span><b>Division:</b></span><span style="color: red;">*</span>
				<select class = "divisionSearchClass" style="width: 200px;margin-left:28px;" id="divisionId"></select><br/>


<span><b>Username:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="userNameId" name="userName" style="margin-left: 14px;"/><br/>
<span><b>Password:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="password" id="passwordId" name="password" style="margin-left: 16px;"/><br/>
<span><b>Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="nameId" name="name" style="margin-left: 42px;" /><br/>
<span><b>Email:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="emailId" name="email" style="margin-left: 43px;" /><br/>
<span><b>Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="mobileId" name="mobile" style="margin-left: 36px;"  maxlength="10" /><br/><br/>
				
				<input type="button" value="Save" id="userSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/>
				
		</div>
		
		
		<div id="editDialog" style="display: none;">

<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -43px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Edit User</h2>
		

<span><b>Role:</b></span><span style="color: red;">*</span>
				<select style="margin-left: 52px;width: 200px;" id="editRoleId">
				<option value="10">Administrator</option>
				<option value="1">CE</option>
				<option value="2">EE</option>
				<option value="3">MC</option>
				<option value="4">HO</option>
				</select><br/>
				<input type="hidden" id="editUserId"/>
				
				
				
                <span><b>Region:</b></span><span style="color: red;">*</span>
				<select class = "regionSearchClass" style="width: 200px;margin-left:35px;" id="editRegionId"></select><br/>
				
				<span><b>Circle:</b></span><span style="color: red;">*</span>
				<select class = "circleSearchClass" style="width: 200px;margin-left:44px;" id="editCircleId"></select><br/>
				
				<span><b>Division:</b></span><span style="color: red;">*</span>
				<select class = "divisionSearchClass" style="width: 200px;margin-left:28px;" id="editDivisionId"></select><br/>
				
<span><b>Username:</b></span><span style="color: red;">&nbsp;</span>
				<input placeholder="Ex: ABC" type="text" id="editUserNameId" name="userName" readonly style="margin-left: 17px;"/><br/>
<span><b>Password:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="password" id="editPasswordId" name="password" style="margin-left: 16px;"/><br/>
<span><b>Name:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editNameId" name="name" style="margin-left: 42px;" readonly /><br/>
<span><b>Email:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editEmailId" name="email" style="margin-left: 43px;" readonly /><br/>
<span><b>Mobile:</b></span><span style="color: red;">*</span>
				<input placeholder="Ex: ABC" type="text" id="editMobileId" name="mobile" style="margin-left: 36px;" maxlength="10" /><br/><br/>
				
				<input type="button" value="Update" id="editUserBtn"/> <input type="button" value="Close" class="closeBtn"/>
				
		</div>
		


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


































<%-- 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div id="dialog1">
<table>

<tr>
				<td align="right" width="48%"><b>Login UserName:</b><span
					style="color: red;">*</span></td>
				<td><input placeholder="Ex: ABC" type="text"
					id="userNameId" name="userName" /></td>
			</tr>
			
			
			<tr>
				<td align="right" width="48%"><b>First Name:</b><span
					style="color: red;">*</span></td>
				<td><input placeholder="Ex: ABC" type="text"
					id="userNameId" name="userName" /></td>
			</tr>
			
			<tr>
				<td align="right" width="48%"><b>Middle Name:</b></td>
				<td><input placeholder="Ex: ABC" type="text"
					id="userNameId" name="userName" /></td>
			</tr>
			
			<tr>
				<td align="right" width="48%"><b>Last Name:</b><span
					style="color: red;">*</span></td>
				<td><input placeholder="Ex: ABC" type="text"
					id="userNameId" name="userName" /></td>
			</tr>
			
			
			
			<tr>
				<td align="right" width="48%"><b>Password:</b><span
					style="color: red;">*</span></td>
				<td><input  type="password"
					id="passwordId" name="password" /></td>
			</tr>
			
			<tr>
				<td align="right" width="48%"><b>Confirm Password:</b><span
					style="color: red;">*</span></td>
				<td><input  type="password"
					id="confirmPasswordId" name="confirmPassword" /></td>
			</tr>
			
			<tr height="100px">
				<td align="center" colspan="2" width="48%"><input type="button" id="userSubmit" value="Register"/></td>
				
			</tr>

</table>
</body>
</html> --%>