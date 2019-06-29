
<html>
<head>
</head>
<body lang=EN-US link=blue vlink=purple style='tab-interval:.5in;font-family:Calibri;font-size:18'>

<div class=Section1>
<p class=MsoBodyText><span>Dear Citizen, </p>

 <#if compliantStatus="1">
<p>Greetings from CEO Tamilnadu.</p>
<p>Thank you for using E-Water system to register your complaint.</p>
<p>Your Complaint Number is : ${complaintNo} </P>
<p>Please refer this number for further tracking of complaints you made.
</p>
</#if>
<#if compliantStatus ="7"> 
<p>We thank you for complaining with us. </p>
<br>
<p>Your Complaint Number is : ${complaintNo} is Closed</P>
<br>
<p>If you are satisfied with our action, Please Click here as 
<a href='http://117.239.180.151/WaterService/Services/DashboardService/registerSMSCompliant?complaintSource=${compliantSource}&complaintSubmitterMobileNo=${compliantEmailId}&complaintContent=CMP ${complaintNumber} Y'>YES</a> Else 
<a href='http://117.239.180.151/WaterService/Services/DashboardService/registerSMSCompliant?complaintSource=${compliantSource}&complaintSubmitterMobileNo=${compliantEmailId}&complaintContent=CMP ${complaintNumber} N'>NO</a></p>
</#if>

<#if compliantStatus ="4" >
<p>We herewith inform you that your registered complaint ${complaintNo} had been rejected</p>
</#if>
<br>
<p>Thank you </>
<p>Best regards, </p>
<p><b>District Water Officer,</b></p>
<p><b>Chennai, Tamilnadu </b> </p>
<p>Note: : Making false declaration is punishable offence, This is a computer generated mail. Please do not reply </p>
</div>

</body>
</html>


