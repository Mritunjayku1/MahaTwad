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

<STYLE type="text/css">
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

.forgot {
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

.forgot:hover {
	color: #3b3b3b
}

input[type="submit"] {
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

input[type="submit"]:active {
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
</STYLE>
</HEAD>

<BODY> 
		 <Label style="text-align: center; font-family: alice; width: 100%; color: #1589FF; font-size: 39px; padding: 10px;border-bottom: 2px solid #1589FF;">
		<img src='library/img/EC_logo.jpg' width="70px" height="70px"><font color="blue">   E-Water New Connection System</font> 	
			<br><span style='font-size:17px;font-weight: normal;'>(e - SEVAI Single Desk Portal )</span></Label> 
	<DIV class="container" align="center"> 
<!-- 		<DIV class="hidden-xs"> -->
<!-- 			<IMG class="hidden-xs img-responsive center-block" -->
<!-- 				src="library/img/EC_logo.jpg" alt="Logo" -->
<!-- 				style="float: left; margin-left: 4%" />  -->
				
				
<!-- 		</DIV> --> 
		
		<form:form action="validate.do" commandName="loginForm" method="post"  >
		
			<DIV class="wrap">
				<DIV class="inner">
					<fieldset>
					<br>
						<h2
							style="text-align: center; font-family: alice; width: 60%; color: #1589FF; font-size: 39px; text-shadow: 1px 1px 0px GREY;"></h2>
					</fieldset>

					<DIV class=""> 
						<DIV class="form-group">
							<form:input path="LoginName" autocomplete="off" autofocus="true" class="form-control" id="password" placeholder="User Name" required="true" />
						</DIV>
					</DIV>
					<DIV class="">
						<DIV class="form-group  ">
							<form:password path="LoginPassword" class="form-control" id="password" placeholder="Password" required="true" />
						</DIV>
					</DIV>
					<DIV class="">
						<INPUT class="btn btn-lg btn " type="submit" value="Login" />
					</DIV>

					<c:if test="${!empty response}">
						<DIV class="">
							<h2
								style='text-align: center; font-family: monospace; font-size: 14px; color: red;'>${response}</h2>
						</DIV>
					</c:if>
				</DIV>
			</DIV>
		</form:form>

	</DIV>

</BODY>
<footer
	style='text-align: center; position: fixed; bottom: 0; width: 100%;border-top:2px solid #1589FF;'>
	<table
		style='text-align: center; vertical-align: middle; width: 100%;   font-size: 12px; color: #1589FF; height: 20px;'>
		<tr>
			<td>Powered by: <a style='color: #1589FF;'
				href="###" target="_blank">TamilNadu </a> &copy; 2017
			</td> 
		</tr>
	</table>
</footer>
</HTML>



