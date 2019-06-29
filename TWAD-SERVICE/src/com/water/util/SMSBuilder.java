package com.water.util;

/*Developed by Mahalingam
 * This class used to send sms &email 2017-06-06
 * */
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.water.daoImpl.SmsDataDaoImp;
import com.water.model.Application;
import com.water.model.CompanyDtl;
import com.water.model.EmployeeDetails;

public class SMSBuilder {

	ResourceBundle rb1 = ResourceBundle.getBundle("resources/constant");
	// String CountryCode;
	String MsgTxt;
	String SMSUrl;
	String MobileNo;
	String isSMSEmailActive = "1";
	String statusURL;
  //  String mailMobileNo;
	byte data[] = null;

	public SMSBuilder() {
		// this.CountryCode = rb1.getString("CountryCode");
		this.MsgTxt = rb1.getString("MsgTxt");
		this.SMSUrl = rb1.getString("SMSUrl");
		this.MobileNo = rb1.getString("MobileNo");
		this.isSMSEmailActive = rb1.getString("isSMSEmailActive");
		this.statusURL = rb1.getString("statusUrl");
		//this.mailMobileNo = rb1.getString("mailMobileNo");
		
	}
	public void getStatus(String applicationID, String status)
	{
		statusURL=statusURL+"/"+applicationID+"/"+status;
		//https://103.233.79.150/single_window/Resources/app_cmwssb_status_update/WI20180003/MC APPROVED 
		URL url;
		try {
			url = new URL(statusURL);
			System.out.println("statusURL URL :" + statusURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			System.out.println("StatusURL Response Code: "
					+ conn.getResponseCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
	}
	public void getForgotEmailTempate(String userEmailId,String userPassword,String emailTemp) {
		String isSMSEmailActive = "3";
					try {
						
								
						String TemplateType = "EMAIL";
						if ("EMAIL".equalsIgnoreCase(TemplateType)
								&& userEmailId != null
								&& !"".equals(userEmailId)
								&& "3".equals(isSMSEmailActive)) {

							Map<String, Object> params = new HashMap<String, Object>();
							String emailMsg=emailTemp + userPassword ;

						
							params.put("EmailMsg", emailMsg);
						
							

							String body =emailMsg;
							// String body =
							// "Welcome to Register Water board New Connection Your Ref No is="+app.getAppId();

							new SendEMailUtil().sendMail(
									userEmailId,
									"TN Water New Connection  - Applicationt# "
											+ 0001, body, "", data);
							
						} else
							System.out.println("Email Notification is Inactive or NA");

					} catch (Exception e) {
						e.printStackTrace();
					}

				}


	public void getSmsTemplatetoEE(String applicationID, Integer smsType,String smsTemp) {

		String Message = "";
		String mobnumber = "";
		String Name = "";
		SmsDataDaoImp smsDataDaoImp = new SmsDataDaoImp();
		
		
		List<EmployeeDetails> lstEmp = smsDataDaoImp.getTemplateIDtoEE(applicationID,
				smsType);
		
		for(EmployeeDetails emp:lstEmp){
			
			HashMap<String, String> smsdtls = new HashMap<String, String>();
			smsdtls.put("ToMobileNo", emp.getPhoneNum().toString());
			smsdtls.put("EmailId", emp.getEmailAddr().toString());
			smsdtls.put("Body", smsTemp);
			
			Message = getMsgBody(smsdtls.get("Body"), smsdtls);
			mobnumber = getMsgBody(smsdtls.get("ToMobileNo"), smsdtls);
			try {
			if ("SMS".equalsIgnoreCase("SMS")
					&& smsdtls.get("ToMobileNo") != null
					&& !"".equals(smsdtls.get("ToMobileNo"))) {
				
				SMSUrl=SMSUrl+"&message="+Message+"&"+"number="+mobnumber;
				URL url = new URL(SMSUrl);

				//if ("1".equals(isSMSEmailActive)) {
					System.out.println("SMS URL :" + SMSUrl);
					HttpURLConnection connection = (HttpURLConnection) url
							.openConnection();
					connection.connect();
					System.out.println("Response Code: "
							+ connection.getResponseCode());
			}
			
			String TemplateType = "EMAIL";
			if ("EMAIL".equalsIgnoreCase(TemplateType)
					&& emp.getEmailAddr() != null
					&& !"".equals(emp.getEmailAddr())
					&& "3".equals(isSMSEmailActive)) {

				Map<String, Object> params = new HashMap<String, Object>();

				/*params.put("applicationID", applicationID);
				params.put("Name", app.getLegCompName());
				params.put("EmailMsg", app.getSmsId().getSmsName());
				params.put("Payment", app.getTotalAmount());*/
			//	params.put("InspectionDate", app.getInspectionDate());
			//	params.put("InitialPayment", app.getInitialPayment());
				//params.put("FixedFinalFee", app.getFixedFinalFee().toString());
				//params.put("PaidFinalFee", app.getPaidfinalFee().toString());
				//params.put("MobileNo","976534422");
				//params.put("FixedfinalFee",app.getFixedFinalFee());
				/*if(app.getInspectionDate()!=null)
				{
					params.put("InspectionDate", app.getInspectionDate());
				}
				*/
				String body = "test";
				/*String body = EmailTemplateBuilder.getEmailTemplate(
						emp.getSmsId().getSmsName(), params);*/
				// String body =
				// "Welcome to Register Water board New Connection Your Ref No is="+app.getAppId();

				new SendEMailUtil().sendMail(
						emp.getEmailAddr(),
						"TN Water New Connection  - Applicationt# "
								+"", body, "", data);
				System.out.println("Email Sent To : " + emp.getEmailAddr());
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
        
		System.out
				.println(" Application : getSmsTemplate === " + applicationID);
    
		


	}
	
	
	public void getStatustoEE(String applicationID, String status)
	{
		statusURL=statusURL+"/"+applicationID+"/"+status;
		//https://103.233.79.150/single_window/Resources/app_cmwssb_status_update/WI20180003/MC APPROVED 
		URL url;
		try {
			url = new URL(statusURL);
			System.out.println("statusURL URL :" + statusURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			System.out.println("StatusURL Response Code: "
					+ conn.getResponseCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
	}
	public void getSmsTemplate(String applicationID, Integer smsType,String smsTemp) {

		String Message = "";
		String mobnumber = "";
		String Name = "";
        
		System.out
				.println(" Application : getSmsTemplate === " + applicationID);

		SmsDataDaoImp smsDataDaoImp = new SmsDataDaoImp();

		List<CompanyDtl> lst = smsDataDaoImp.getTemplateID(applicationID,
				smsType);
		for (Iterator<CompanyDtl> iterator = lst.iterator(); iterator.hasNext();) {
			// employees.iterator(); iterator.hasNext();){
			HashMap<String, String> smsdtls = new HashMap<String, String>();

			CompanyDtl app = (CompanyDtl) iterator.next();
			/*System.out.print("First Name: " + app.getAppId());
			System.out.print("  Last Name: " + app.getEmailAddr());
			System.out.println("  Salary: " + app.getMobileNum());
			System.out.println("  SMS 1: " + app.getSmsId().getSmsName());
			System.out.println("  SMS 2: " + app.getSmsId().getSmsDtls());
*/
			smsdtls.put("ToMobileNo", app.getMobileNum().toString());
			smsdtls.put("TemplateType", "SMS");
			smsdtls.put("Body", smsTemp);
			//smsdtls.put("Body", "Test");
			smsdtls.put("applicationID", app.getAppId().toString());
			smsdtls.put("EmailId", app.getEmailAddr());
			smsdtls.put("Name", app.getLegCompName());
			smsdtls.put("EmailMsg", app.getSmsId().getSmsName());
			if(app.getInspectionDate()!=null)
			{
			smsdtls.put("InspectionDate", app.getInspectionDate());
			}
			
			
			

			Message = getMsgBody(smsdtls.get("Body"), smsdtls);
			mobnumber = getMsgBody(smsdtls.get("ToMobileNo"), smsdtls);
			String isSMSEmailActive = "3";
			try {
				if ("SMS".equalsIgnoreCase("SMS")
						&& smsdtls.get("ToMobileNo") != null
						&& !"".equals(smsdtls.get("ToMobileNo"))) {

					Message = getMsgBody(smsdtls.get("Body"), smsdtls);
					mobnumber = getMsgBody(smsdtls.get("ToMobileNo"), smsdtls);

					/*String smsURL = SMSUrl + MobileNo + mobnumber + MsgTxt
							+ URLEncoder.encode(Message, "UTF-8");
					String smsURL1 = SMSUrl +"message"+ Message + "number" + mobnumber
							+ URLEncoder.encode(Message, "UTF-8");*/
					SMSUrl=SMSUrl+"&message="+Message+"&"+"number="+mobnumber;

				//	SMSUrl="http://sms.softsourcetechnologies.com/sendsms/?token=dd20884e842b69da4198eb3fb0c6f0c5&credit=2&sender=WATERI&message="+"kkkkkk"+"&"+"number="+"9688722952";

				//	SMSUrl="http:sms.softsourcetechnologies.com/sendsms/?token=dd20884e842b69da4198eb3fb0c6f0c5&credit=2&sender=WATERI&message="+Message+"&"+"number="+9688722952;
                   // System.out.println("SMSMSMSMSMS:"+SMSUrl);
					URL url = new URL(SMSUrl);

					//if ("1".equals(isSMSEmailActive)) {
						System.out.println("SMS app URL :" + SMSUrl);
						HttpURLConnection connection = (HttpURLConnection) url
								.openConnection();
						connection.connect();
						System.out.println("Response Code: "
								+ connection.getResponseCode());
				/*	} else
						System.out
								.println("SMS Notification is Inactive or NA : "
										+ SMSUrl);

				}*/}
						
				String TemplateType = "EMAIL";
				if ("EMAIL".equalsIgnoreCase(TemplateType)
						&& app.getEmailAddr() != null
						&& !"".equals(app.getEmailAddr())
						&& "3".equals(isSMSEmailActive)) {

					Map<String, Object> params = new HashMap<String, Object>();

					params.put("applicationID", applicationID);
					params.put("Name", app.getLegCompName());
					params.put("EmailMsg", app.getSmsId().getSmsName());
					params.put("Payment", app.getTotalAmount());
				//	params.put("InspectionDate", app.getInspectionDate());
				//	params.put("InitialPayment", app.getInitialPayment());
					//params.put("FixedFinalFee", app.getFixedFinalFee().toString());
					//params.put("PaidFinalFee", app.getPaidfinalFee().toString());
					params.put("MobileNo","976534422");
					//params.put("FixedfinalFee",app.getFixedFinalFee());
					if(app.getInspectionDate()!=null)
					{
						params.put("InspectionDate", app.getInspectionDate());
					}
					

					String body = EmailTemplateBuilder.getEmailTemplate(
							app.getSmsId().getSmsName(), params);
					// String body =
					// "Welcome to Register Water board New Connection Your Ref No is="+app.getAppId();

					new SendEMailUtil().sendMail(
							app.getEmailAddr(),
							"TN Water New Connection  - Applicationt# "
									+ app.getAppId(), body, "", data);
					System.out.println("Email Sent To : " + app.getEmailAddr());
				} else
					System.out.println("Email Notification is Inactive or NA");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public String getMsgBody(String message, HashMap<String, String> mapVal) {
		HashSet<String> keys = new HashSet<String>();

		if (message != null && mapVal.size() > 0) {
			char[] text = message.toCharArray();
			for (int i = 0; i < text.length; i++) {
				String key = "";

				int a = i;
				if (text[a] == '{') {
					while (text[a] != '}') {
						if (text[a] != '}' && text[a] != '{') {

							key = key + text[a];
						}

						a++;

					}

					keys.add(key);

				}
				key = "";

			}

		}

		message = getContent(keys, message, mapVal);
		return message;
	}

	public String getContent(HashSet<String> al, String message,
			HashMap<String, String> map) {
		String old = "";
		try {
			if (message != null)
				for (String key : al) {
					System.out.println("Key : " + key + ", map : " + map
							+ " , message : " + message + "\n old :" + old);

					old = "\\{" + key + "\\}";
					message = message.replaceAll(old, map.get(key));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

}
