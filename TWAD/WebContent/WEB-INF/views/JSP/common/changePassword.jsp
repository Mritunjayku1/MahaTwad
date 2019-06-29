<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--

	EC- User Login screen.
	Created by Mahalingam

 -->
 
<!DOCTYPE html> 

<HTML lang="en">
<HEAD>
<META charset="utf-8">
<META http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="shortcut icon" href="library/img/EC_logo.jpg" >
<TITLE>E-Water | Login</TITLE>
<!-- Bootstrap -->
<LINK href="library/login/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<LINK href="library/login/jquery-ui.min.css" rel="stylesheet"
	type="text/css">
<LINK href="library/login/scree.css" rel="stylesheet" type="text/css">

<link href="library/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
<script src="library/js/jquery-1.7.2.min.js"></script>
<script src="library/js/jquery-ui-1.8.21.custom.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	   $('input[type="password"]').bind("cut copy paste",function(e) {
	      e.preventDefault();
	   });
	   
	   
	  
  		 
  		$('#changePasswordId').click(function() {
			if(validateChangePasswordForm()){
			$.ajax({
				type : "POST",
				url : "managementChangePassword.do",
				data : {
					'userName' : $('#changeUNameId').val(),
					'userEmailId' : $('#changeUEmailId').val(),
					'oldPassword' : $('#oldPasswordId').val(),
					'newPassword' : $('#newPasswordId').val()
				},
				success : function(response) {
					alert(response);
					window.location.reload();

				}
			});
			}

		});
	   
	   
	});
	
	function validateChangePasswordForm(){
		
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var passwordRegex = /^(?=.{8,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$/;
		var emailId = $('#changeUEmailId');
		var oldPasswordId = $('#oldPasswordId');
		var newPasswordId = $('#newPasswordId');
		var confirmPasswordId = $('#confirmPasswordId');
		
		var inputVal = new Array(emailId,oldPasswordId,newPasswordId,confirmPasswordId);

		$('.error').hide();
		
		
		flag = true;
		for (i = 0; i < inputVal.length; i++) {
			var value = inputVal[i].val().replace(/ /g, "");
			
			if (value == "") {
				inputVal[i]
						.after('<br/><span class="error"> This field is required. </span>');
				inputVal[i].focus();
				flag = false;
			} else if (inputVal[i].attr('id') == 'changeUEmailId'
					&& !emailReg.test(value)) {
				inputVal[i]
						.after('<br/><span class="error"> Please enter correct Email Id </span>');
				inputVal[i].focus();
				flag = false;
			}
			else if (inputVal[i].attr('id') == 'newPasswordId'
				&& !passwordRegex.test(inputVal[i].val())) {
			inputVal[i]
					.after('<br/><span class="error"> Please should contains minimum 8 character,<br/> atleast 1 caps, 1 small, 1 number and 1 special character </span>');
			inputVal[i].focus();
			flag = false;
		}
			
			
			else if (inputVal[i].attr('id') == 'confirmPasswordId'
				&& inputVal[i].val() != $('#newPasswordId').val()) {
			inputVal[i]
					.after('<br/><span class="error"> Confirm Password should match with New Password</span>');
			inputVal[i].focus();
			flag = false;
		}
			
		}
		return flag;
	}
	
</script>
<STYLE type="text/css">

.error {
	color: red;
}
input.error {
	border: 1px solid red;
}

label.error {
	color: red;
	font-weight: normal;
}

html {
	height: 100%
}

::-moz-sWater {
	background: #1589FF;
	color: #fff;
	text-shadow: none;
}

::sWater {
	background: #1589FF;
	color: #fff;
	text-shadow: none;
}

body {
/* 	background-image: url('library/img/EC_banner.jpg'); */
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	background-repeat: no-repeat;
/* 	background:#1589FF;  */
	/* background-size : 100%; */
}

.login {
	background: #eceeee;
	border: 1px solid #42464b;
	border-radius: 6px;
	height: 257px;
	margin: 10%;
	width: 298px;
}

.stretch {
	width: 100%;
	height: 100%;
}

.login h1 {
	background-image: linear-gradient(top, #f1f3f3, #d4dae0);
	border-bottom: 1px solid #a6abaf;
	border-radius: 6px 6px 0 0;
	box-sizing: border-box;
	color: #727678;
	display: block;
	height: 43px;
	font: 600 14px/1 'Open Sans', sans-serif;
	padding-top: 14px;
	margin: 0;
	text-align: center;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.2), 0 1px 0 #fff;
}

input[type="password"], input[type="text"] {
	background: url('http://i.minus.com/ibhqW9Buanohx2.png') center left
		no-repeat, linear-gradient(top, #d6d7d7, #dee0e0);
	border: 1px solid #a1a3a3;
	border-radius: 4px;
	box-shadow: 0 1px #fff;
	box-sizing: border-box;
	color: #696969;
	height: 39px;
	margin: 0px; /*10px 0 0 20px; */
	padding-left: 2px 2px;
	transition: box-shadow 0.3s;
	width: 240px;
	margin-top: 20px;
}

input[type="password"]:focus, input[type="text"]:focus {
	box-shadow: 0 0 4px 1px rgba(55, 166, 155, 0.3);
	outline: 0;
}

.show-password {
	display: block;
	height: 16px;
	margin: 26px 0 0 28px;
	width: 87px;
}

input[type="checkbox"] {
	cursor: pointer;
	height: 16px;
	opacity: 0;
	position: relative;
	width: 64px;
}

input[type="checkbox"]:checked {
	left: 29px;
	width: 58px;
}

.toggle {
	background: url(http://i.minus.com/ibitS19pe8PVX6.png) no-repeat;
	display: block;
	height: 16px;
	margin-top: -20px;
	width: 87px;
	z-index: -1;
}

input[type="checkbox"]:checked+.toggle {
	background-position: 0 -16px
}

.change {
	color: #7f7f7f;
	display: inline-block;
	float: right;
	font: 12px/1 sans-serif;
	left: -19px;
	position: relative;
	text-decoration: none;
	top: 5px;
	transition: color .4s;
}

.change:hover {
	color: #3b3b3b
}

input[type="submit"],input[type="button"] {
	width: 240px;
	height: 35px;
	display: block;
	font-family: Arial, "Helvetica", sans-serif;
	font-size: 16px;
	font-weight: bold;
	color: #fff;
	text-decoration: none;
	text-transform: uppercase;
	text-align: center;
	text-shadow: 1px 0px 0px black;
	padding-top: 6px;
	margin: 1%;
	position: relative;
	cursor: pointer;
	border: none;
	background-color: #1589FF;
	background-image: linear-gradient(top, #3db0a6, #3111);
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	border-bottom-left-radius: 5px;
	box-shadow: inset 0px 1px 0px #2ab7ec, 0px 3px 0px 0px #497a78, 0px 6px
		5px white;
		margin-bottom: 15px;
		margin-top: 20px;
}

.shadow {
	background: #000;
	border-radius: 12px 12px 4px 4px;
	box-shadow: 0 0 20px 10px #000;
	height: 12px;
	margin: 30px auto;
	opacity: 0.2;
	width: 270px;
}

input[type="submit"]:active,input[type="button"]:active {
	top: 3px;
	box-shadow: inset 0px 1px 0px #2ab7ec, 0px 2px 0px 0px #31524d, 0px 5px
		3px #999;
}

div.wrap {
	border: 1px solid #1589FF;
	height: 290px;
	width: 290px;
	margin: 12%;
	border-radius: 4%;
}

div.inner {
 	background: white;
	height: 278px;
	width: 278px;
	border-radius: 2%;
	margin: auto;
	margin-top: 5px;
	border: 6px solid #1589FF; 
}

label {
	float: left;
	width: 10em;
	padding-left: 50px;
}


div[role="dialog"] {
	border-radius: 15px;
}

.changeDialog {
	display: none;
	width: 400px;
	padding: 0px !important;
	overflow: hidden !important;
}
.ui-dialog>.ui-widget-header {
	background: blue;
	display: none;
}

.ui-dialog {
	padding: 0px;
	overflow: hidden;
}
.bg_heading {
	text-align: center;
	font-family: Lato;
	font-size: 20px;
	text-transform: uppercase;
	color: white;
	background-color: #2DAAE1;
	border-radius: 15px 0px 0px 0px;
	margin: 0px;
	height: 45px;
	padding-top: 10px;
}

</STYLE>
</HEAD>

<BODY> 
		<!--  <Label style="text-align: center; font-family: alice; width: 100%; color: #1589FF; font-size: 39px; padding: 10px;border-bottom: 2px solid #1589FF;">
		<img src='library/img/EC_logo.jpg' width="70px" height="70px"><font color="blue">  New Water Connections</font> 	
			<br><span style='font-size:17px;font-weight: normal;'></span></Label>  -->
			
			<table	 height="130px" style='background-color: white;'>
		<tr style='background-color: white;'>
			<td width="20%" align="center"><img src="library/img/twad_logo.gif" width="110px"
								height="106px" style="margin-left: 50px;"></td>
							<td width="40%" align="center"><img src="library/img/middleImage.png" width="770px"
								height="50px"></td>
							<!-- <td  width="20%" align="center"><img src="library/img/pic6_2.jpg" width="130px"
								height="130px"></td> -->
		
		</tr>


	</table>
			
	<!-- <DIV class="container" align="center">  -->
             <table width="100%"><tr><td align="center" width="100%">
			
			<table  height="400px">
			<tr  height="20px"><td></td></tr>
			<tr height="50px"><td style="text-align: center; background-color: #FCFCF4; font-size: 25px; height: 10px; color: #800000; font-weight: bold;">Change Password</td></tr>
			<tr  height="20px"><td></td></tr>
			<tr><td align="center" width="600px">
				<input type="text" name="userName" id="changeUNameId" placeholder="Enter UserName" title="Enter UserName" style="padding-left: 10px;" />
			</td></tr>
			<tr><td  align="center" width="600px">
				<input type="text" name="userEmailId" id="changeUEmailId" placeholder="Enter EmailId" title="Enter EmailId" style="padding-left: 10px;"/>
			</td></tr>
			
			<tr><td  align="center" width="600px">
				<input type="Password" name="oldPassword" id="oldPasswordId" placeholder="Enter Old Password" title="Enter Old Password" style="padding-left: 10px;"/>
			</td></tr>
			<tr><td align="center" width="600px">
				<input type="Password" name="newPassword" id="newPasswordId" placeholder="Enter New Password" title="Enter New Password" style="padding-left: 10px;"/>
			</td></tr>
			
			<tr><td align="center" width="600px">
				<input type="Password" name="confirmPasswordId" id="confirmPasswordId" placeholder="Enter Confirm Password" title="Enter Confirm Password" style="padding-left: 10px;"/>
			</td></tr>
			
			<tr><td align="center" width="600px">
				<input type="button" id="changePasswordId" Value="Submit" />
			</td></tr>
			</table>
		</td></tr></table>
		<!-- </DIV> -->

</BODY>
<footer
	style='text-align: center; position: fixed; bottom: 0; width: 100%;border-top:2px solid #1589FF;'>
	<table
		style='text-align: center; vertical-align: middle; width: 100%;   font-size: 12px; color: #1589FF; height: 20px;'>
		<tr>
			<td>Powered by: <a style='color: #1589FF;'
				href="###" target="_blank">TamilNadu </a> &copy; 2019
			</td> 
		</tr>
	</table>
</footer>
</HTML>

