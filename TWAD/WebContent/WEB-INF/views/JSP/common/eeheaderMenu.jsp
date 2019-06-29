<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
#HDropdown-orange-classic,#paymentPendingId {
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

#HDropdown-orange-classic li,#paymentPendingId li {
	display: inline;
	position: relative;
	float: left;
	z-index: 1;
}

#HDropdown-orange-classic li a {
	display: block;
	float: left;
	height: 26px;
	line-height: 26px;
	padding: 0 15px;
	text-decoration: none;
	color: #FFFFFF;
	font-weight: bold;
	font-size: 13px;
	border-left: solid 1px #E6D9D9;
}


#paymentPendingId li a {
    display: block;
    float: left;
    height: 26px;
    line-height: 26px;
    padding: 0 10px;
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

#paymentPendingId li a:hover {
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

#HDropdown-orange-classic span{
padding:3px 7px;
border-radius:50px;
background-color: brown;
}

</style>

<script>

$(function(){
	
	$.ajax({
		type:"GET",
		url:"getEEDashboardCount.do",
		data:{},
		  contentType: "application/json",
	      dataType:"json",
		success:function(response){
			//alert(response.approvedApplication)
			$('#applicationFeeCount').text(response.applicationFeePending);
			$('#upfrontChargesCount').text(response.upfrontChargesPending);
			$('#fullPaymentCount').text(response.fullPaymentPending);
			$('#fullPaymentCompletedCount').text(response.fullPaymentCompleted);
			$('#executionCount').text(response.execution);
			
			localStorage.setItem("localStorage_applicationFeePending",response.applicationFeePending);
			localStorage.setItem("localStorage_upfrontChargesPending",response.upfrontChargesPending);
			localStorage.setItem("localStorage_fullPaymentPending",response.fullPaymentPending);
			localStorage.setItem("localStorage_fullPaymentCompleted",response.fullPaymentCompleted);
			localStorage.setItem("localStorage_execution",response.execution);
			
			
		}
	});
	
	
	$('#paymentPendingliId').hover(function(){
		$('#paymentPendingId').css({'display':'block'});
	});
	
	$('ul#HDropdown-orange-classic li').not('#paymentPendingliId').hover(function(){
		$('#paymentPendingId').css({'display':'none'});
	});
	
	
	
	$('#paymentPendingliId').click(function(){
		sessionStorage.setItem('isPaymentPendingTabClicked', "true");
		$('#paymentPendingId').css({'display':'block'});
	});
	
	$('ul#HDropdown-orange-classic li').not('#paymentPendingliId').click(function(){
		sessionStorage.setItem('isPaymentPendingTabClicked', "false");
		$('#paymentPendingId').css({'display':'none'});
	});
	
	if(sessionStorage.getItem('isPaymentPendingTabClicked')=="true"){
		$('#paymentPendingId').css({'display':'block'});
	}
	else{
		$('#paymentPendingId').css({'display':'none'});
	}
	
	var url = window.location.href;
		$('ul li').removeClass('selectionClass');
		if(url.indexOf("index")>0){
			$('ul li:nth-child(1)').addClass('selectionClass');
			}
		if(url.indexOf("eeDashboard")>0){
		$('ul#HDropdown-orange-classic li:nth-child(2)').addClass('selectionClass');
		}
		/* if(url.indexOf("eePendingApplication")>0){
			$('ul#HDropdown-orange-classic li:nth-child(2)').addClass('selectionClass');
			}
		if(url.indexOf("eePaymentPending")>0){
			$('ul#HDropdown-orange-classic li:nth-child(3)').addClass('selectionClass');
			} */
		/* if(url.indexOf("eePaymentCompleted")>0){
			$('ul#HDropdown-orange-classic li:nth-child(4)').addClass('selectionClass');
			} */
		/* if(url.indexOf("eeInspectedApplication")>0){
			$('ul#HDropdown-orange-classic li:nth-child(4)').addClass('selectionClass');
			}
		if(url.indexOf("eeMCApproved")>0){
			$('ul#HDropdown-orange-classic li:nth-child(5)').addClass('selectionClass');
			} */
			
		if(url.indexOf("eeApplicationFeePending")>0){
			$('ul#HDropdown-orange-classic li:nth-child(3)').addClass('selectionClass');
			}
			if(url.indexOf("eeUpfrontChargesPending")>0){
				$('ul#HDropdown-orange-classic li:nth-child(4)').addClass('selectionClass');
				}
			if(url.indexOf("eeFullPaymentPending")>0){
				$('ul#HDropdown-orange-classic li:nth-child(5)').addClass('selectionClass');
				}
		if(url.indexOf("eeFullPaymentCompleted")>0){
			$('ul#HDropdown-orange-classic li:nth-child(6)').addClass('selectionClass');
			}
		if(url.indexOf("eeExecution")>0){
			$('ul#HDropdown-orange-classic li:nth-child(7)').addClass('selectionClass');
			}
		if(url.indexOf("eeViewAll")>0){
			$('ul#HDropdown-orange-classic li:nth-child(8)').addClass('selectionClass');
			}
		
		/* if(url.indexOf("eePaymentCompleted")>0){
			$('ul#HDropdown-orange-classic li:nth-child(3)').addClass('selectionClass');
			$('ul#paymentPendingId li:nth-child(1)').addClass('selectionClass');
			}
			if(url.indexOf("eeUpfrontChargesPending")>0){
				$('ul#HDropdown-orange-classic li:nth-child(3)').addClass('selectionClass');
				$('ul#paymentPendingId li:nth-child(2)').addClass('selectionClass');
				}
			if(url.indexOf("eeFullPaymentPending")>0){
				$('ul#HDropdown-orange-classic li:nth-child(3)').addClass('selectionClass');
				$('ul#paymentPendingId li:nth-child(3)').addClass('selectionClass');
				} */
});

</script>



<div>
	<ul id="HDropdown-orange-classic">
	 <li><a href="index.do"> Home</a></li>
		<li><a href="eeDashboard.do" > Dashboard</a></li>
		<!-- <li><a href="eeApplicationFeePending.do">Pending Application </a> </li>
	    <li id="paymentPendingliId"><a href="eeApplicationFeePending.do">Payment Pending</a> </li> -->
		<!-- <li><a href="eePaymentCompleted.do">1% Payment Completed</a></li> -->
		<!-- <li><a href="eeInspectedApplication.do">Inspected Application</a></li>
		<li><a href="eeMCApproved.do">MC Approved</a></li> -->
		 <li><a href="eeApplicationFeePending.do">Application Fee Pending &nbsp; <span id="applicationFeeCount"></span> </a> </li>
	    <li><a href="eeUpfrontChargesPending.do">Upfront Charges Pending &nbsp; <span id="upfrontChargesCount"></span> </a> </li>
		<li><a href="eeFullPaymentPending.do">Full Payment Pending &nbsp; <span id="fullPaymentCount"></span> </a></li>
		<li><a href="eeFullPaymentCompleted.do">Full Payment Completed &nbsp; <span id="fullPaymentCompletedCount"></span></a></li>
		<li><a href="eeExecution.do">Execution &nbsp; <span id="executionCount"></span></a></li>
		<li><a href="eeViewAll.do">View All Application </a> </li>  
		
</ul>
 <!--       
<ul id="paymentPendingId" style="width:600px;margin-top: 5px;margin-left: 100px;display: none;position: absolute; z-index: 100;">
        <li><a href="eeApplicationFeePending.do">Application Fee Pending</a> </li>
	    <li><a href="eeUpfrontChargesPending.do">Upfront Charges Pending</a> </li>
		<li><a href="eeFullPaymentPending.do">Full Payment Pending</a></li>
</ul> -->

	
</div>
<br>