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
.bg_heading {
	text-align: left;
    font-size: 20px;
    color: white;
    margin-top: -32px;
    margin-left: 90px;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}
/* #menu3{
	background: #E05400;
	background: -webkit-linear-gradient(top, #FFFFFF 3%, #E05400 30%);
} */
input[type="search"]{
height:30px !important;
}
input[type="text"]{
height:25px !important;
}

#paymentTable input[type="button"] {
	width: 100px;
    height: 30px;
}

select {
	width: 300px;
    height: 35px;
    padding: 5px;
}

#successMessage{
	margin-left: 450px;
    z-index: 20000;
    margin-top: 20px;
    position: absolute;
    color: green;
    }
    
    #paymentTable input[type="text"] {
	width: 300px;
    height: 35px;
    padding: 5px;
}

 #paymentTable select {
	width: 300px;
    height: 35px;
    padding: 5px;
}
    
</style>
<script src='JS/complaints/searchComplaints.js'></script>

<script type="text/javascript">

$(function(){
	
	
	$('#paymentSaveBtnId').click(function(){
		 
		  
		  var regionId=$("#regionSearch option:selected").val();
			if(regionId == null || regionId=='')
			{
			alert("Please select Region !")
			return false;
			}
			var circleId= $("#circleSearch option:selected").val();
			if(circleId == null || circleId=='')
			{
			alert("Please select Circle !")
			return false;
			}
		  
		  var divisionId= $("#divisionSearch option:selected").val();
			if(divisionId == null || divisionId=='')
			{
			alert("Please select Division !")
			return false;
			}
			
		  
		  
   		 if(confirm("Are you sure want to change Division ? ")){
   			 $("#paymentSaveBtnId").prop("disabled", true);
   			$.ajax({
   				type:"POST",
   				url:"transferApplicationSave.do",
   				data:{
   					'appId':$('#appId').val(),
   				     'region':regionId,
					'circle':circleId,
					'division':divisionId
   				
   				},
   				
   				success:function(response){
   					alert(response);
   					window.location.reload();
   					
   				}
   			});
   			}
			
	});

	 
 	  $('.regionSearchClass').change(function () {
 		
 		  $.ajax({
					type: "GET",
					async:false,
					url: "library/Circle.json",
					success: function (response)  {
    						
     					var regionSelectedValue =$("#regionSearch option:selected").val();
					var circle = response[regionSelectedValue];
					var option = '<option value="">--Select--</option>';
					if (circle != undefined)
						for (var i = 0; i < circle.length; i++) {

							
										option = option + '<option value="' + circle[i].id + '">' +circle[i].value +'</option>';
							
						}
					$('#circleSearch').find('option').remove();
					$('#circleSearch').append(option);
     					}
     	    	  
	    	  
	    	  });
  	        
 	  
       });



             
              $('.circleSearchClass').change(function () { 
            	  
            	  $.ajax({
              
    					type: "GET",
       					async:false,
       					url: "library/Division.json",
       					success: function (response) {
       						
       					var circleSelectedValue =$("#circleSearch option:selected").val();
						var division = response[circleSelectedValue];
						var option = '<option value="">--Select--</option>';
						if (division != undefined)
							for (var i = 0; i < division.length; i++) {
							option = option + '<option value="' + division[i].id + '">' +division[i].value +'</option>';
							}
						$('#divisionSearch').find('option').remove();
						$('#divisionSearch').append(option);
       					}
       	    	  
       	    	  });
              
            	});

              

	
	 
		
		$('input[name="transferBtn"]').click(function(){
			var transferAppRef = $(this).attr('id');
			var appId = transferAppRef.split("_");
			$('#appId').val(appId[1]);
			$(".ui-dialog-content").dialog("close");
			$( "#addDialog" ).dialog({ 'width':'400px','modal':'true'});
			$('#appIdSpan').text(appId[1]);
			
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
						$('.regionSearchClass').append(option);
						}
		  
		  });
	    
			
		}); 
		
		$('.closeBtn,.imgClose').click(function(){
			$(".ui-dialog-content").dialog("close");
			
		}); 

	 
	 
	 
});
</script>


<div id="addDialog" style="display: none;">
<form id="uploadFormId" method="POST" enctype="multipart/form-data">
<input type="hidden" name="appId" id="appId" value=''/>
<img class="imgClose" src="library/img/Close_SMS.png"
		style="width: 40px; border-width: 0px; float: right; margin-top: -11px; margin-right: -5px; cursor: pointer;">
	<h2 class="bg_heading">Transfer Division</h2>
	<table id="paymentTable" style="margin-left: 30px;margin-top: 20px;height: 300px;">

<tr><td><span><b>App Ref#:</b></span></td><td class="center">
                                             
                                              <span style="font-weight: bold;" id="appIdSpan"></span><br/>
                                              </td></tr>

<tr><td><span><b>Region:</b></span></td><td class="center">
                                             
                                               <select  style="width:200px;" class="regionSearchClass" id="regionSearch"></select>
                                              </td></tr>


<tr><td><span><b>Circle:</b></span></td> <td class="center">
                                              
                                               <select style="width:200px;" class="circleSearchClass" id="circleSearch"></select>
                                              </td></tr>

<tr><td><span><b>Division:</b></span></td> <td class="center">
                                             
                                               <select style="width:200px;" class="divisionSearchClass" id="divisionSearch"> </select>
                                              </td>
                                             </tr>
 
<tr><td><span><b>Remarks:</b></span></td><td>
			<textarea placeholder="Ex: ABC"  id="paymentDescId" name="paymentDesc" style="width: 200px;height: 35px;"></textarea></td></tr>
		<tr><td colspan="2" align="center" height="70px">	<input type="button" value="Save" id="paymentSaveBtnId"/> <input type="button" value="Close"  class="closeBtn"/></td></tr>
	
	

	</table>
	
	</form>		
	</div>
	


<table class='table-bordered table table-striped display'
	style='width: 100%; font-size: 28px;'>
<tr>
		<td colspan='8'
			style='text-align: center; background-color: #FCFCF4; font-size: 17px; height: 10px; color: #800000; font-weight: bold;'>
			Transfer Applications</td>
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
                                            <th style="color:black !important"><b>App Ref#</b></th>
                                            <th style="color:black !important"><b> Name of Company</b></th>
                                            <th style="color:black !important"><b> District</b></th>
                                            <th style="color:black !important"><b>Taluk</b></th>
                                            <th style="color:black !important"><b> Village</b></th>
                                            <th style="color:black !important"><b>Region</b></th>
                                            <th style="color:black !important"><b>Circle</b></th>
                                            <th style="color:black !important"><b>Division</b></th>
                                            <th style="color:black !important"><b>Registered Date</b></th>
                                           <!--  <th style="color:black !important"><b>Remarks</b></th> -->
                                            <th></th>
                                        
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                     <c:forEach items="${list.appBean}" var="app" >
          
          									 
          									 
          								<tr class="odd gradeX">
          								
          							<td > <a href="paymentViewForm.do?appId=${app.getAppId()}" style="color: rgb(128,128,128)">${app.getAppId()}</a></td>
                                            <td>${app.getLegCompName()}</td>
                                             <td>${app.getDistrict()}</td>
                                              <td>${app.getTaluk()}</td>
                                               <td>${app.getVillage()}</td>
                                               <td class="center">${app.getRegionName()}</td>
                                                <td class="center">${app.getCircleName()}</td>
                                               <td class="center">${app.getDivisionName()}</td>
                                             
                                              <td class="center">${app.getCreateTs()}</td>
                            
                                             
                                             
                                              <td class="center">
                                              <input type="button" class="paymentClass" id="transfer_${app.getAppId()}" name="transferBtn" style="width: auto;" value="Transfer"/>
                                              </td>
                                             
                                           
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