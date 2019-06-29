<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="css/style.css" rel="stylesheet"/> 
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body style="margin:0px;padding:0px" background="images/border_bg.jpg">
<style>
/*  #mydiv {
    margin:auto;
 	position:absolute;
    left: 50%;
    width:1200px;
    height:300px;
     margin-left: -600px;
    border: 0px;
}

 #myTable {
    margin:auto;
 	position:absolute;
    left: 50%;
    width:1200px;
    height:400px;
     margin-left: -600px;
    border: 0px;
}
 */

div[role="dialog"]{
border-radius:15px; 
}
.loginDialog{
	display:none;
	width:400px;
	padding:0px !important;
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
    margin-left:150px; 
    width: 100px;
    color: white;
    margin-top: 30px;
}
.ui-dialog > .ui-widget-header {background: blue;display:none;}
.ui-dialog{
padding:0px;
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
    border: 1px solid rgba(0,0,0,.15);
    border-radius: 4px;
    -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
    box-shadow: 0 6px 12px rgba(0,0,0,.175);
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

.ftrmenu{
	font-size:18px;
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
    border-radius:15px 0px 0px 0px;
    margin:0px;
}
input[type="text"],input[type="password"]{
	width: 250px;
    height: 25px;
    margin-left: 15px;
    padding: 5px;
}

select.lessWidth {
	width: 70px;
    height: 40px;
    margin-left: 15px;
    padding: 5px;
}
select.moreWidth {
	width: 174px;
    height: 40px;
    margin-left: 15px;
    padding: 5px;
}

select.classCategory {
	width: 264px;
    height: 40px;
    margin-left: 15px;
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
    background: url(New_Images/a17.png) no-repeat;
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


</style>

<script type="text/javascript">

$('.dropdown-inline, .dropdown-slide').hover(function() {
  $(this).find('ul').css({'display':'block'});
}, function() {
  $(this).find('ul').css({'display':'none'});
});

</script>
<table id="mydiv">

<tr><td valign="middle" colspan="2" style="height:200px;width: 100%;">  <img src="../images/Logo_Tamil_Nadu.jpg" width="150px" height="150px" style="margin-left:75px;">
    <img src="../images/middleImage.png" width="700px" height="150px">  <img src="../images/pic6_2.jpg" width="150px" height="150px" style="margin-right:75px;">
  </td><td></td></tr>
  
  <tr><td colspan="2" align="center">
 			<div class="dropdown-inline">
					<a href="#" class="" data-toggle="dropdown"
						data-hover="dropdown"> <span id="Label8">HOME</span>
						</a>
				</div>
  			<div class="dropdown-inline">
					<a href="#" class="" > <span id="Label8">FOCUS SECTORS</span>
						<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="#">
								<span id="Label9">Test 1</span>
						</a></li>
						<li class="divider"></li>
						<li><a
							href="#">
								<span id="Label14">Test 2</span>
						</a></li>
						<li class="divider"></li>

					</ul>
				</div>
				
				<div class="dropdown-inline">
					<a href="#" class="" data-toggle="dropdown"
						data-hover="dropdown"> <span id="Label8">ABOUT TAMILNADU</span>
						</a>
				</div>
				
				
				<div class="dropdown dropdown-inline">
					<a href="#" class="" data-toggle="dropdown"
						data-hover="dropdown"> <span id="Label8">INVESTOR SERVICES</span>
						</a>
				</div>
				
				<div class="dropdown dropdown-inline">
					<a href="#" class="" data-toggle="dropdown"
						data-hover="dropdown"> <span id="Label8">DEPARTMENT</span>
						</a>
				</div>
				
				<div class="dropdown dropdown-inline">
					<a href="#" class="" data-toggle="dropdown"
						data-hover="dropdown"> <span id="Label8">INFORMATION</span>
						</a>
				</div>
				
				<div class="dropdown dropdown-inline">
					<a href="#" class="" data-toggle="dropdown"
						data-hover="dropdown"> <span id="Label8">CONTACT</span>
						</a>
				</div>
				
				<div class="dropdown dropdown-inline">
					<a href="#" class="" data-toggle="dropdown"
						data-hover="dropdown"> <span id="Label8">TRANSFERS-2017</span>
						</a>
				</div>


			</td><td></td></tr>
			
			<tr>
			
			
			
			<td colspan="2" height="50px">
			
			<div style="padding: 0px; width: 100%;">
                <div style="background-image: url(../images/border_bg.jpg); height: 10px; background-repeat: repeat-x;">
                    &nbsp;</div>
            </div>
			</td>
			</tr>
		
			
			</body>
			</html>