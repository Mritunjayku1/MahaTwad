<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
</style>

<div>
	<table	 height="130px" style='background-color: white;'>
		<tr style='background-color: white;'>
			<td width="20%" align="center"><img src="library/img/twad_logo.gif" width="110px"
								height="106px" style="margin-left: 50px;"></td>
							 <td width="40%" align="center"><img src="library/img/middleImage.png" width="770px"
								height="50px"></td>
						<!--	<td  width="20%" align="center"><img src="library/img/pic6_2.jpg" width="130px"
								height="130px"></td> -->
			<td
				style='text-align: right; width: 20%; color: #1589FF; text-shadow: 1px 7px 10px #a6a1a1; font-size: 14px;padding-right: 80px;'>
				Hi! <c:out value="${sessionScope.LoginName}" /> <a href='signOut.do'
				title='Sign Out'><img src='library/img/logout.png'> Sign Out </a><br/><br/>
				<a href="changePasswordPage.do">Change Password </a>
			</td>
		</tr>


	</table>
</div>



