<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="library/css/style.css" rel="stylesheet"/> 
 <link rel="stylesheet"
	href="library/assets/plugins/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="library/assets/css/main.css" />
<link rel="stylesheet" href="library/assets/css/theme.css" />
<link rel="stylesheet" href="library/assets/css/MoneAdmin.css" />
<link rel="stylesheet"
	href="library/assets/plugins/Font-Awesome/css/font-awesome.css" />
<link href="library/assets/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />

  
 <link href="library/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
 <script src="library/js/jquery-1.7.2.min.js"></script>
<script src="library/js/jquery-ui-1.8.21.custom.min.js"></script>
<script src='library/js/chosen.jquery.js'></script>
<script src='library/js/html2canvas.js'></script>




 <style type="text/css">
 td span{
 padding-left: 10px;
 }
 body{
 font-size: 14px;
 }
 input[type="button"],input[type="submit"] {
    border-radius: 10px;
    background-color: #2DAAE1;
    font-weight: bold;
    cursor: pointer;
    padding: 5px 5px 5px 5px;
    width: 200px;
    color: white;
}

div[role="dialog"]{
border-radius:15px; 
}
.loginDialog{
	display:none;
	width:400px;
	height:200px;
	padding:0px !important;
	overflow: hidden !important;
}

#ackTable tr:nth-child(even) {background: white;height:40px;}
#ackTable tr:nth-child(odd) {background:#EDEDED ;height:40px;}

#ackTable td{
padding-left:10px;
font-size: 17px;
font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}

 </style>
</head>
<body style="margin:0px;padding:0px">
<div id="ackDiv">
<table id="mydiv" align="center">

<tr><td valign="middle" align="center" style="height:160px;width: 100%;"> 
<table><!-- <tr><td>
 <img src="library/img/twad_logo.gif" width="110px" height="106px"></td><td>
    <img src="library/img/Acknowlegement.png" width="800px" height="75px">
    </td></tr></table>
  </td></tr> -->
  
 
			<!-- 
			<tr>
			
			
			
			<td colspan="2" height="25px">
			
			<div style="padding: 0px; width: 100%;">
                <div style="background-image: url(library/img/border_bg.jpg); height: 7px; background-repeat: repeat-x;">
                    &nbsp;</div>
            </div>
			</td>
			</tr> -->
			<tr>
			<td valign="middle" colspan="2" style="height: 130px; width: 100%;">
				<table width="100%">
					<tbody>
						<tr>
							<td width="25%" align="center"><img src="library/img/twad_logo.gif" width="110px"
								height="106px" style="margin-left: 50px;"></td>
							 <td width="50%" align="center"><img src="library/img/middleImage.png" width="770px"
								height="50px"></td>
							<!-- <td  width="25%" align="center"><img src="library/img/pic6_2.jpg" width="130px"
								height="130px" style="margin-right: 50px;"></td> -->
							<td></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
			
			</table>
<table id="statusHeader" align="center" class="table-bordered table table-striped display" style="width: 970px;">

	<tbody><tr>
		<td style="text-align: center; background-color: #FCFCF4; font-size: 25px; height: 10px; color: #800000; font-weight: bold;">Acknowledgement</td>
	</tr>
	
</tbody></table>
<table width="50%" id="ackTable" align="center" style="font-size: 20px;">

<tr><td align="left" width="50%"><b> Name of the Applicant</b></td><td  width="50%">:<span><%=request.getParameter("applicantName")%></span></td></tr>
<tr><td align="left"><b>Application Reference No</b></td><td>:<span><%=request.getParameter("applicationRef")%></span></td></tr>
<%-- <tr><td align="left" colspan="2"><b>Site Address</b></td><td colspan="2">:<span><%=request.getParameter("siteAddr")%></span></td></tr>
<tr><td align="left" colspan="2"><b>Type of connection</b></td><td colspan="2">:<span>New connection</span></td></tr>
<tr><td align="left" colspan="2"><b>Work Type</b></td><td colspan="2">:<span><%=request.getParameter("workTyp")%></span></td></tr>
<tr><td align="left" colspan="2"><b>Mobile Number</b></td><td colspan="2">:<span><%=request.getParameter("mobNo")%></span></td></tr>
<tr><td align="left" colspan="2"><b>Requirement of water in KLD</b></td><td colspan="2" >:<span><%=request.getParameter("mld")%></span></td></tr> --%>


</table>

</div>


<table width="40%" align="center" style="font-size: 15px;margin-top: 10px;">

<tr height="70px" style="font-weight: bold;font-size: 17px;"><td colspan="2" align="center">Note: Please note it Application Reference No for Future Reference.</td></tr>
<tr height="70px" style="font-weight: bold;"><td align="center"><input type="button" id="load" value="Download"/></td>
<td><input type="button"
				id="printbtnId" onclick="javascript:window.print();"
				name="industrialistSubmitBtn" value="Print" /></td></tr>
<tr><td align="center"><a href="/TwadWeb/index.do"><b>Back to Home Page</b> </a></td></tr>
</table>




<form action="/TwadWeb/downloadImage.do" id="imageFormId" method="post">

<input type="hidden" id="imageString" name="imageString" value=""/>
</form>


			<div class="loginDialog" id="uploadDialog">
<img class="imgClose" src="library/img/Close_SMS.png" style="width:40px;border-width:0px;float: right; margin-top: -6px; margin-right: -5px; cursor: pointer;">
		<table width="100%" align="center"><tr><td align="center">	
	<form id="uploadFormId" method="POST" enctype="multipart/form-data">
	<span id="successMessage" style="color:green;"></span>
	<span id="errorMessage" style="color:red;"></span>
		<br/><br/>
		<div id="clonedDiv">
		<div id="fileCloneId" >
		<input type="file" name="file"><img src="library/img/add.JPG" width="25px" height="25px" class="addFileId"/><br /> 
		</div>
		</div>
		
		<input type="hidden" name="appId" value='<%=request.getParameter("applicationRef")%>'><br /> 
		
		
		<input type="submit" id="btnSubmit" value="Upload">
	</form>
	</td></tr></table>
			</div>




      <script>
          $(function(){
        	 var count=0;
        	 $('#clonedDiv').on('click','.addFileId',function(){
        		  var cloned = $('#fileCloneId').clone();
        		  cloned.find('img.deleteFileId').remove();
        		  cloned.attr('id','fileCloneId_'+count++);
        		  cloned.css({'margin-left': '25px'});
          		 cloned.find('.addFileId').after('<img src="library/img/delete.JPG" width="25px" height="25px" class="deleteFileId"/>');
        		 $('#clonedDiv').append(cloned);
        		 
        		 
        	  });
        	 $('#clonedDiv').on('click','.deleteFileId',function(){
        		  $(this).parent('div').remove();  
        		});
        	  
        	  $("#btnSubmit").click(function (event) {
        		  event.preventDefault();
         		 var flag = true;
         		  $('input[name=file]').each(function(){
         			 
         			  if($(this).val().length==0){
         				 $('#errorMessage').text("Add File or remove the extra file Upload");
         				  flag = false;
         			  }
         			
         		  });
         		  
        		  if(flag){
        	       
        	        var form = $('#uploadFormId')[0];
        	        var data = new FormData(form);
        	        $("#btnSubmit").prop("disabled", true);

        	        $.ajax({
        	            type: "POST",
        	            enctype: 'multipart/form-data',
        	            url: "uploadMultipleFile.do",
        	            data: data,
        	            processData: false,
        	            contentType: false,
        	            cache: false,
        	            timeout: 600000,
        	            success: function (data) {
        	            	$('#successMessage').text(data);
        	                $("#btnSubmit").prop("disabled", false);

        	            },
        	        });
        		  }
        	  });
        	
           $('#load').click(function(){ //calling this function when Save button pressed
              html2canvas($('#ackDiv'), {//give the div id whose image you want in my case this is #cont
              onrendered: function (canvas) {
              var base64_string = canvas.toDataURL("image/png",1.0);//here set the image extension and now image data is in var img that will send by our ajax call to our api or server site page

             $('#imageString').val(base64_string);
              $('#imageFormId').submit();
              
             
              }
              });
          });
         
           $('.loginDialog ').parent('div').css({'width':'500px','top':'500px'});
   		$('.imgClose').click(function(){
   			$(this).parents('div.loginDialog').dialog('close');
   		});
   	 $('#uploadbtn').click(function(){
   			$(".ui-dialog-content").dialog("close");
   			$( "#uploadDialog" ).dialog({ 'width':'500px','modal':'true'});
   		}); 
   	  
           
        });
      </script> 

</body>
</html>