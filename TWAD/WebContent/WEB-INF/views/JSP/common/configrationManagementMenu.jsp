<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src='JS/complaints/menu.js'></script>

<style>
#HDropdown-orange-classic {
	margin: 0;
	padding: 0px;
	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 0%) repeat
		scroll 0 0 rgba(0, 0, 0, 0);
	/* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	background: linear-gradient(from top to bottom, #FFFFFF 0%, #1589FF 0%);
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* For Safari 5.1 to 6.0 */
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* Chrome10+,Safari5.1+ */
	background: -moz-linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* FF3.6+ */
	background: -ms-linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* IE10+ */
	background: -o-linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	/* Opera 11.10+ */
	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 0%);
	height: 26px;
	width: 100%;
	border: solid 1px #1589FF;
	border-width: 1px 1px 1px 0;
	background: -o-linear-gradient(top, #FFFFFF 1%, #1589FF 0%);
	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 0%) repeat
		scroll 0 0 rgba(0, 0, 0, 0);
}

#HDropdown-orange-classic li {
	display: inline;
	position: relative;
	float: left;
	z-index: 1;
	background-color: #1589FF;
}

#HDropdown-orange-classic li a {
	display: block;
	float: left;
	height: 26px;
	line-height: 26px;
	padding: 0 25px;
	text-decoration: none;
	color: #FFFFFF;
	font-weight: bold;
	font-size: 13px;
	border-left: solid 1px #E6D9D9;
}

#HDropdown-orange-classic li a:hover {
	/* 	color: #FFFFFF; */
	/* 	background: #FFFFFF; */
	
}

#HDropdown-orange-classic li ul {
	margin: 0;
	line-height: none;
	position: absolute;
	top: 23px;
	left: 0;
	border: solid 1px #E6D9D9;
	border-width: 0px 1px 1px 1px;
	width: 250px;
	display: none;
	background: #FFFFFF;
}

#HDropdown-orange-classic li:hover ul {
	display: block;
	/* 	background-color:#FFFFFF; */
}

#HDropdown-orange-classic li a:hover {
	/* 	color: #FFFFFF; */
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}

#HDropdown-orange-classic li ul li {
	display: block;
	border-bottom: solid 1px #dbdcd9;
	width: 250px;
	background: url(library/img/menubg.jpg) repeat-x top no-repeat 3px 12px;
	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 10%) repeat
		scroll 0 0 rgba(0, 0, 0, 0);
	/* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #FFFFFF 1%, #1589FF 10%);
	background: linear-gradient(from top to bottom, #FFFFFF 0%, #1589FF 50%);
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	/* For Safari 5.1 to 6.0 */
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	/* Chrome10+,Safari5.1+ */
	background: -moz-linear-gradient(top, #FFFFFF 1%, #1589FF 10%);
	/* FF3.6+ */
	background: -ms-linear-gradient(top, #FFFFFF 1%, #1589FF 50%); */
	/* IE10+ */
	/* 	background: -o-linear-gradient(top, #FFFFFF 1%, #1589FF 50%); */
	/* Opera 11.10+ */
	/* 	background: linear-gradient(to bottom, #FFFFFF 1%, #1589FF 50%); */
	padding: 0 0 0 1px;
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	/* For Safari 5.1 to 6.0 */
	background: linear-gradient(top, #FFFFFF 1%, #1589FF 50%);
	/* Chrome10+,Safari5.1+ */
	background: -moz-linear-gradient(top, #FFFFFF 1%, #1589FF 10%);
	cursor: pointer;
}

#HDropdown-orange-classic li ul li:HOVER {
	display: block;
	border-bottom: solid 1px #dbdcd9;
	width: 250px;
	/* 	background: #85807F; */
	background: #E05400;
	color: #FFFFFF;
	padding: 0 0 0 1px;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
	cursor: pointer;
}

#HDropdown-orange-classic li ul li:last-child {
	border-bottom: 0px;
}

#HDropdown-orange-classic li ul a {
	border-width: 0px;
	/* 	color: #FFFFFF; */
	padding: 0 1px 0 10px;
	background-color: transparent;
}

#HDropdown-orange-classic li:hover ul li a {
	color: #FFFFFF;
}

#HDropdown-orange-classic li ul li a:hover {
	/* 	color: #FFFFFF; */
	font-size: 13px;
}


.selectionClass{
font-size: 13px;
color: #FFFFFF;
background: #E05400;
background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
}

</style>


<script type="text/javascript">
$(function(){
	var url = window.location.href;
		$('ul li').removeClass('selectionClass');
		if(url.indexOf("index")>0){
			$('ul li:nth-child(1)').addClass('selectionClass');
			}
		if(url.indexOf("configrationManagement")>0){
		$('ul li:nth-child(2)').addClass('selectionClass');
		}
		if(url.indexOf("categoryManagement")>0){
			$('ul li:nth-child(3)').addClass('selectionClass');
			}
		/* if(url.indexOf("reConnectionTypeManagement")>0){
			$('ul li:nth-child(3)').addClass('selectionClass');
			}
		if(url.indexOf("zoneDivisionManagement")>0){
			$('ul li:nth-child(4)').addClass('selectionClass');
			} */
		if(url.indexOf("districtManagement")>0){
			$('ul li:nth-child(4)').addClass('selectionClass');
			}
		if(url.indexOf("districtTalukManagement")>0){
			$('ul li:nth-child(5)').addClass('selectionClass');
			}
		if(url.indexOf("talukVillageManagement")>0){
			$('ul li:nth-child(6)').addClass('selectionClass');
			}
		if(url.indexOf("regionManagement")>0){
			$('ul li:nth-child(7)').addClass('selectionClass');
			}
		if(url.indexOf("regionCircleManagement")>0){
			$('ul li:nth-child(8)').addClass('selectionClass');
			}
		if(url.indexOf("circleDivisionManagement")>0){
			$('ul li:nth-child(9)').addClass('selectionClass');
			}
		if(url.indexOf("divisionSubDivisionManagement")>0){
			$('ul li:nth-child(10)').addClass('selectionClass');
			}
		
		
		
		if(url.indexOf("paymentType.do")>0){
			$('ul li:nth-child(11)').addClass('selectionClass');
			}
		if(url.indexOf("payment.do")>0){
			$('ul li:nth-child(12)').addClass('selectionClass');
			}
		if(url.indexOf("villageSchemeManagement.do")>0){
			$('ul li:nth-child(13)').addClass('selectionClass');
			}
});


</script>



<div>
	<ul id="HDropdown-orange-classic">
	 <li><a href="index.do"> Home</a></li>
	 <li><a href="configrationManagement.do" > User</a> </li> 
	 <li><a href="categoryManagement.do">Category Type</a></li>
	<!--  <li><a href="reConnectionTypeManagement.do">Connection Type</a></li>
	 <li><a href="zoneDivisionManagement.do" >Zone/Division </a></li> -->
	 <li><a href="districtManagement.do">District </a></li> 
	  <li><a href="districtTalukManagement.do">District/Taluk </a></li> 
	   <li><a href="talukVillageManagement.do">Taluk/Village </a></li>
	    <li><a href="regionManagement.do">Region </a></li> 
	  <li><a href="regionCircleManagement.do">Region/Circle </a></li> 
	   <li><a href="circleDivisionManagement.do">Circle/Division </a></li>
	     <li><a href="divisionSubDivisionManagement.do">Division/SubDivision </a></li>
	     <li><a href="paymentType.do">Payment Type</a></li> 
	      <li><a href="payment.do">Payment</a></li> 
	       <li><a href="villageSchemeManagement.do">District/Scheme</a></li> 
	   

	</ul>
	
</div>
<br>