$(document).ready(
		function() {
			
			
		}
		
);




$('.dashboard').click(function () {
	
	//alert("one
var appRef = 1234;
		var remarks='test';
		
	alert(1222);
	$.ajax({
		type:"POST",
		url:"ceApprove.do",
		data:{'appRef':appRef,'remarks':remarks},
		success:function(response){
			$('#successMessage').text(response);
			//alert(response);
			
		}
	});
	
});
