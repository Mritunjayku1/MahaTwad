<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="library/css/style.css" rel="stylesheet" />





<script src="library/js/jquery-1.7.2.min.js"></script>
<script src="library/js/jquery-ui-1.8.21.custom.min.js"></script>
<script src='library/js/jquery.dataTables.min.js'></script>
<script src='library/js/chosen.jquery.js'></script>
<script src='library/js/jquery.validate.js'></script>
<script src='library/js/dataTables.fixedColumns.js'></script>
<script src='library/js/jquery-ui-timepicker-addon.js'></script>
<script src='JS/common.js'></script>


<link href="library/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">


</head>
<body style="margin: 0px; padding: 0px"
	background="library/img/border_bg.jpg">
	
	
	
	
	<%--  <c:set var = "string1" value = "This is first String."/>
      <c:set var = "string2" value = "${fn:split(string1, ' ')}" />
	<c:forEach items="${string2}" var="app" varStatus="count" >
						 ${app }<br/>
						 </c:forEach> --%>
	
	
	<style>
#mydiv {
	margin: auto;
	position: absolute;
	left: 50%;
	width: 1200px;
	height: 700px;
	margin-left: -600px;
	border: 0px;
}

div[role="dialog"] {
	border-radius: 15px;
}

.loginDialog {
	display: none;
	width: 400px;
	padding: 0px !important;
	overflow: hidden !important;
}
/*
.open{
display:block;
} */
/* 
.dropdown, .dropup {
    position: relative;
} */
input[type="button"] {
	border-radius: 10px;
	background-color: #2DAAE1;
	font-weight: bold;
	cursor: pointer;
	padding: 5px 5px 5px 5px;
	margin-left: 150px;
	width: 100px;
	color: white;
}

.ui-dialog>.ui-widget-header {
	background: blue;
	display: none;
}

.ui-dialog {
	padding: 0px;
	overflow: hidden;
}

.dropdown-inline {
	display: inline-block;
	position: relative;
	font-family: Lato;
	font-size: 13px;
	margin-left: 10px;
	padding-bottom: 10px;
}

.dropdown-slide {
	/*  display: inline-block; */
	position: relative;
	font-family: Lato;
	font-size: 13px;
	/*  margin-left: 10px; */
	padding-bottom: 10px;
}

* {
	border-collapse: collapse;
}

.dropdown-menu {
	position: absolute;
	top: 100%;
	left: 0;
	z-index: 1000;
	display: none;
	float: left;
	min-width: 160px;
	padding: 5px 0;
	margin: 2px 0 0;
	font-size: 14px;
	text-align: left;
	list-style: none;
	background-color: #fff;
	-webkit-background-clip: padding-box;
	background-clip: padding-box;
	border: 1px solid #ccc;
	border: 1px solid rgba(0, 0, 0, .15);
	border-radius: 4px;
	-webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
	box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
}

.dropdown-menu>li>a {
	display: block;
	padding: 3px 20px;
	clear: both;
	font-weight: 400;
	line-height: 1.42857143;
	color: #333;
	white-space: nowrap;
	font-size: 13px;
}

.ftrmenu {
	font-size: 18px;
}

.caret {
	display: inline-block;
	width: 0;
	height: 0;
	margin-left: 2px;
	vertical-align: middle;
	border-top: 4px dashed;
	border-top: 4px solid\9;
	border-right: 4px solid transparent;
	border-left: 4px solid transparent;
}

.bg_heading {
	text-align: left;
	font-family: Lato;
	font-size: 20px;
	text-transform: uppercase;
	color: white;
	background-color: #2DAAE1;
	border-radius: 15px 0px 0px 0px;
	margin: 0px;
}

input[type="text"],input[type="password"] {
	width: 250px;
	height: 25px;
	margin-left: 60px;
	padding: 5px;
}

/* 
.jssora05l {
    background-position: -10px -40px;
}

.jssora05l, .jssora05r, .jssora05ldn, .jssora05rdn {
    position: absolute;
    cursor: pointer;
    display: block;
    background: url(New_library/img/a17.png) no-repeat;
    overflow: hidden;
}

.dropdown-menu > li > a {
    font-size: 15px;
}
.dropdown-menu>li>a {
    display: block;
    padding: 3px 20px;
    clear: both;
    font-weight: 400;
    line-height: 1.42857143;
    color: #333;
    white-space: nowrap;
}
 */
.dropdown-menu .divider {
	height: 1px;
	margin: 9px 0;
	overflow: hidden;
	background-color: #e5e5e5;
}

#map {
	height: 100%;
}
/* Optional: Makes the sample page fill the window. */
html,body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
	<script type="text/javascript">
		$(function() {
			localStorage.setItem('isDetailButtonClicked', null);
			localStorage.setItem('isStatusButtonClicked', null);
			localStorage.setItem('registeredData', null);
		});

			</script>

	<table id="mydiv">

		<tr>
			<td valign="middle" colspan="2" style="height: 155px; width: 100%;">
				<table>
					<tbody>
						<tr>
							<td><img src="library/img/twad_logo.gif" width="150px"
								height="150px" style="margin-left: 50px;"></td>
							<td><img src="library/img/middleImageNw.png" width="800px"
								height="75px"></td>
							<td><img src="library/img/pic6_2.jpg" width="150px"
								height="150px" style="margin-right: 50px;"></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>


		<tr>



			<td colspan="2" height="50px">

				<div style="padding: 0px; width: 100%;">
					<div
						style="background-image: url(library/img/border_bg.jpg); height: 10px; background-repeat: repeat-x;">
						&nbsp;</div>
				</div><!--  <marquee onmouseover="this.stop();" onmouseout="this.start();">
					<a href="#" style="text-decoration: none;"> <img id="Image10"
						src="library/img/new_blink.gif" style="border-width: 0px;">
						<span style="color: #EE7C0D; font-size: 15px;"> TamilNadu
							New Water Connection Chennai Zone Only</span>

					</a>
				</marquee> -->
			</td>
			<td></td>
		</tr>

		<tr>
			

<td valign="top" align="center" style="width: 100%;height: 410px;">
    <div style="width: 460px; margin-top: 50px;">

				<ul style="margin-top: 0px !important; list-style-type: none; padding: 0px">

					<li class="dropdown-slide" id="companyLogin" style="background-color: #FED367; width: 100%; border-bottom: 2px solid #fff; border-right: none !important;"><a href="/TwadWeb/formRegister.do" class="dropdown-toggle" data-toggle="dropdown">
							<table style="width: 100%;" id="companyRegistration">
								<tbody>
									<tr>
										<td style="width: 20%;"><img src="library/img/new.png" style="padding-left: 10px; padding-right: 10px; height: 50px; width: 50px !important;">
										</td>
										<td style="width: 5%;"></td>
										<td style="width: 70%;" class="menu_multi_line"><span style="font-size: 16px; color: Black;"> <span id="Label2">New water connection Registration
													(Industries)</span></span></td>
										<td style="width: 5%;" align="center"></td>
									</tr>
								</tbody>
							</table>
					</a></li>
					<li class="dropdown-slide" style="background-color: #FED367; width: 100%; border-bottom: 2px solid #fff; border-right: none !important;"><a href="/TwadWeb/adminLogin.do" class="dropdown-toggle" data-toggle="dropdown">
							<table style="width: 100%;" id="departmentLogin">
								<tbody>
									<tr>
										<td style="width: 20%;"><img src="library/img/login.jpg" style="padding-left: 10px; padding-right: 10px; height: 50px; width: 50px !important;">
										</td>
										<td style="width: 5%;"></td>
										<td style="width: 70%;" class="menu_multi_line"><span style="font-size: 16px; color: Black;"> <span id="Label2">TWAD Login</span></span></td>
										<td style="width: 5%;" align="center"></td>
									</tr>
								</tbody>
							</table>
					</a></li>
					<li class="dropdown-slide" style="background-color: #FED367; width: 100%; border-bottom: 2px solid #fff; border-right: none !important;"><a href="/TwadWeb/checkApplicationStatus.do?appId=" class="dropdown-toggle" data-toggle="dropdown">
							<table style="width: 100%;" id="applicationStatus">
								<tbody>
									<tr>
										<td style="width: 20%;"><img src="library/img/application.png" style="padding-left: 10px; padding-right: 10px; height: 50px; width: 50px !important;">
										</td>
										<td style="width: 5%;"></td>
										<td style="width: 70%;" class="menu_multi_line"><span style="font-size: 16px; color: Black;"> <span id="Label2">Application Status</span></span></td>
										<td style="width: 5%;" align="center"></td>
									</tr>
								</tbody>
							</table>
					</a></li>
					<li class="dropdown-slide" style="background-color: #FED367; width: 100%; border-bottom: 2px solid #fff; border-right: none !important;"><a href="/TwadWeb/initialPayment.do" class="dropdown-toggle" data-toggle="dropdown">
							<table style="width: 100%;" id="initialPayment">
								<tbody>
									<tr>
										<td style="width: 20%;"><img src="library/img/RS.jpg" style="padding-left: 10px; padding-right: 10px; height: 50px; width: 50px !important;">
										</td>
										<td style="width: 5%;"></td>
										<td style="width: 70%;" class="menu_multi_line"><span style="font-size: 16px; color: Black;"> <span id="Label2">Payment(Debit/Credit Card)</span></span></td>
										<td style="width: 5%;" align="center"></td>
									</tr>
								</tbody>
							</table>
					</a></li>
					<!--   <li class="dropdown-slide" style="background-color: #FED367; width: 100%; border-bottom: 2px solid #fff;
                                border-right: none !important;"><a href="/Water/initialPayment.do" class="dropdown-toggle" data-toggle="dropdown">
                                    <table style="width: 100%;" id="initialPayment">
                                        <tbody><tr>
                                            <td style="width: 20%;">
                                                <img src="library/img/icon_home5.png" style="padding-left: 10px; padding-right: 10px;
                                                    height: 50px;">
                                            </td>
                                            <td style="width: 5%;">
                                            </td>
                                            <td style="width: 70%;" class="menu_multi_line">
                                                <span style="font-size: 16px; color: Black;">
                                                    <span id="Label2">Withdraw Application</span></span>
                                            </td>
                                            <td style="width: 5%;" align="center">
                                            </td>
                                        </tr>
                                    </tbody></table>
                                </a>
                              
                                
                                </li>  -->

				</ul>
    </div>

			</td>

		</tr>
		<tr>
			<td colspan="2"><hr /></td>
			<td></td>
		</tr>


	</table>


	<form action="validate.do" id="formId" method="post">
		<div class="loginDialog" id="adminLoginDialog">
			<img class="imgClose" src="library/img/Close_SMS.png"
				style="width: 40px; border-width: 0px; float: right; margin-top: -6px; margin-right: -5px; cursor: pointer;">
			<h2 class="bg_heading">Admin Login</h2>
			<p>
				<input type="text" name="userName" placeholder="Enter User Name" />
			</p>
			<p>
				<input type="password" name="loginPassword"
					placeholder="Enter Password" />
			</p>
			<p>
				<input type="submit" id="adminLoginId" Value="Login" />
			</p>
			<p style="padding-left: 30px;">
				Forgot Password? <a href="#">Click here</a>
			</p>
		</div>
	</form>

	<div class="loginDialog" id="cELoginDialog">
		<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -6px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">CE Login</h2>
		<p>
			<input type="text" name="userName" placeholder="Enter User Name" />
		</p>
		<p>
			<input type="password" name="password" placeholder="Enter Password" />
		</p>
		<p>
			<input type="button" id="cELoginId" Value="Login" />
		</p>
		<p style="padding-left: 30px;">
			Forgot Password? <a href="#">Click here</a>
		</p>
	</div>



	<div class="loginDialog" id="eELoginDialog">
		<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -6px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">EE Login</h2>
		<p>
			<input type="text" name="userName" placeholder="Enter User Name" />
		</p>
		<p>
			<input type="password" name="password" placeholder="Enter Password" />
		</p>
		<p>
			<input type="button" id="eELoginId" Value="Login" />
		</p>
		<p style="padding-left: 30px;">
			Forgot Password? <a href="#">Click here</a>
		</p>
	</div>



	<div class="loginDialog" id="companyLoginDialog">
		<img class="imgClose" src="library/img/Close_SMS.png"
			style="width: 40px; border-width: 0px; float: right; margin-top: -6px; margin-right: -5px; cursor: pointer;">
		<h2 class="bg_heading">Company Login</h2>
		<p>
			<input type="text" name="userName"
				placeholder="Enter Application Reference" />
		</p>
		<p>
			<input type="password" name="password" placeholder="Enter Password" />
		</p>
		<p>
			<input type="button" id="companyLoginId" Value="Login" />
		</p>
		<p style="padding-left: 30px;">
			Forgot Password? <a href="#">Click here</a>
		</p>
		<p style="padding-left: 30px;">
			New User? <a href="/TwadWeb/formRegister.do">Click here</a>
		</p>
	</div>






</body>
</html>
