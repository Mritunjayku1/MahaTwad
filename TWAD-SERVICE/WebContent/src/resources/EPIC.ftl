<html>
<head>
</head>
<body lang=EN-US link=blue vlink=purple style='tab-interval:.5in;font-family:Calibri;font-size:18'>

<div class=Section1>
<p class=MsoBodyText><span>Dear Citizen, </p>

<#if type="invalid">
<p>   Invalid Format.Please send your EPIC number in below Format.  For Ex :In Subject EPIC<space> xxxxxxx
</p>
</#if>
 <#if type="valid">
<p>ElectoralRollDetails is : ${electoralrolldetails} </P>
<p>PollingStationAddress is : ${pollingstationaddress} </P>
<p>Please find the attached image for location</P>
</#if>
<#if type="notfound">
<p>No Data found / Invalid EPIC No</P>
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


