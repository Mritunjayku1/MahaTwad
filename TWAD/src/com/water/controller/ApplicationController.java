

package com.water.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.water.bean.AppFormBean;
import com.water.bean.ApplicationBean;
import com.water.bean.DDPaymentFormBean;
import com.water.bean.TransactionFormBean;

@Controller
public class ApplicationController {

	@Value("${ApplicationService}")
	String ApplicationService;
	/*@Value("${WaterEmployeeService}")
	String WaterEmployeeService;*/

	
	// getting webservice URL from property file in context
		@Value("${WaterEmployeeService}")
		String WaterEmployeeService;

		// getting webservice URL from property file in context
		@Value("${WaterUtilService}")
		String WaterUtilService;

		// getting webservice URL from property file in context
		@Value("${WaterDashboardService}")
		String WaterDashboardService;

		@Value("${err.LOGIN_ERR_MSG}")
		String LOGIN_ERR_MSG;

		@Value("${EC_Folder}")
		String EC_Folder;

		Gson gson;
		
		
		
		@RequestMapping(value = "/getDDAmount", method = RequestMethod.GET)
		@ResponseBody
		public String getDDAmount(String appId,String mobileNum) throws JsonGenerationException, JsonMappingException, IOException {

			List<AppFormBean> list = new  ArrayList<>();
			
			RestTemplate restTemplate = new RestTemplate();
			AppFormBean appFormBean =new AppFormBean();
			
			appFormBean.setAppId(appId);
			appFormBean.setMobileNum(Long.parseLong(mobileNum));
			//appFormBean.setPaymentType(Integer.parseInt(paymentType));
			
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			@SuppressWarnings("unchecked")
			HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

			ResponseEntity<AppFormBean> output = restTemplate.exchange(
					ApplicationService + "getDDAmount", HttpMethod.POST,
					entity, AppFormBean.class);
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(output.getBody());
			
			
			return json;

		}
		
		
		@RequestMapping(value = "/getOnlinePaymentAmount", method = RequestMethod.GET)
		@ResponseBody
		public String getOnlinePaymentAmount(String appId) throws JsonGenerationException, JsonMappingException, IOException {

			List<AppFormBean> list = new  ArrayList<>();
			
			RestTemplate restTemplate = new RestTemplate();
			AppFormBean appFormBean =new AppFormBean();
			
			appFormBean.setAppId(appId);
			
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			@SuppressWarnings("unchecked")
			HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

			ResponseEntity<AppFormBean> output = restTemplate.exchange(
					ApplicationService + "getOnlinePaymentAmount", HttpMethod.POST,
					entity, AppFormBean.class);
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(output.getBody());
			
			
			return json;

		}
		
		@RequestMapping(value = "/getApplicationFeePaymentAmount", method = RequestMethod.GET)
		@ResponseBody
		public String getApplicationFeePaymentAmount(String appId) throws JsonGenerationException, JsonMappingException, IOException {

			List<AppFormBean> list = new  ArrayList<>();
			
			RestTemplate restTemplate = new RestTemplate();
			AppFormBean appFormBean =new AppFormBean();
			
			appFormBean.setAppId(appId);
			appFormBean.setPaymentType(1);
			
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			@SuppressWarnings("unchecked")
			HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

			ResponseEntity<AppFormBean> output = restTemplate.exchange(
					ApplicationService + "getOnlinePaymentAmount", HttpMethod.POST,
					entity, AppFormBean.class);
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(output.getBody());
			
			
			return json;

		}
		
		
		
		@RequestMapping(value = "/paymentResponse", method = RequestMethod.POST,headers="Accept=application/json")
		@ResponseBody
		public String paymentResponse(@RequestBody AppFormBean appFormBean) {

			RestTemplate restTemplate = new RestTemplate();
		
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

			ResponseEntity<String> output = restTemplate.exchange(
					ApplicationService + "saveApplication", HttpMethod.POST,
					entity, String.class);
			String applicationRef = output.getBody();

			Map<String, String> model = new HashMap<String, String>();
			model.put("applicationRef", applicationRef);
			/* File dir = new File("c:/EC/Temp");
			 File newDir = new File(dir.getParent() + "/" + applicationRef);
					    dir.renameTo(newDir);*/
			return applicationRef;

		}
	/*@RequestMapping(value = "/companyRegister", method = RequestMethod.POST)
	@ResponseBody
	public String companyRegister(AppFormBean appFormBean,HttpServletRequest request) {

		RestTemplate restTemplate = new RestTemplate();
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		
		
		HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				ApplicationService + "saveApplication", HttpMethod.POST,
				entity, String.class);
		String applicationRef = output.getBody();

		Map<String, String> model = new HashMap<String, String>();
		model.put("applicationRef", applicationRef);
		request.getSession().setAttribute("appId", applicationRef);
		 File dir = new File("c:/EC/Temp");
		 File newDir = new File(dir.getParent() + "/" + applicationRef);
				    dir.renameTo(newDir);
		return applicationRef;

	}*/
		@RequestMapping(value = "/companyRegister", method = RequestMethod.POST)
		@ResponseBody
		public String companyRegister(AppFormBean appFormBean,HttpServletRequest request) {

			RestTemplate restTemplate = new RestTemplate();
		
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			
			
			HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

			ResponseEntity<String> output = restTemplate.exchange(
					ApplicationService + "saveApplication", HttpMethod.POST,
					entity, String.class);
			String applicationRef = output.getBody();

			Map<String, String> model = new HashMap<String, String>();
			model.put("applicationRef", applicationRef);
			request.getSession().setAttribute("appId", applicationRef);
			/* File dir = new File("c:/EC/Temp");
			 File newDir = new File(dir.getParent() + "/" + applicationRef);
					    dir.renameTo(newDir);*/
			return applicationRef;

		}
	@RequestMapping(value = "/savePaymentsDetails", method = RequestMethod.POST)
	@ResponseBody
	public String savePaymentsDetails(AppFormBean appFormBean) {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				ApplicationService + "savePaymentsDetails", HttpMethod.POST,
				entity, String.class);
		String applicationRef = output.getBody();

		Map<String, String> model = new HashMap<String, String>();
		model.put("applicationRef", applicationRef);

		return applicationRef;

	}
	
	@RequestMapping(value = "/saveDDPaymentDtls", method = RequestMethod.POST)
	@ResponseBody
	public String saveDDPaymentDtls(DDPaymentFormBean ddPaymentFormBean) throws JsonGenerationException, JsonMappingException, IOException {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(ddPaymentFormBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				ApplicationService + "saveDDPaymentDtls", HttpMethod.POST,
				entity, String.class);
		String applicationRef = output.getBody();

		Map<String, String> model = new HashMap<String, String>();
		model.put("applicationRef", applicationRef);

		if(applicationRef != null){
			applicationRef="DD Saved Successfully";
		}
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String response = ow.writeValueAsString(ddPaymentFormBean);
		
		
		return response;

	}
	
	
	
	@RequestMapping(value = "/saveOnlinePaymentsDetails", method = RequestMethod.POST)
	//@ResponseBody
	public ModelAndView saveOnlinePaymentsDetails(AppFormBean appFormBean, HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        
		if(appFormBean.getPaymentAmount() == null){
		String appFormBeanTemp =  getApplicationFeePaymentAmount(appFormBean.getAppId());
		JSONObject jsonObject = new JSONObject(appFormBeanTemp);
		String applicationFeeAmount = (String) jsonObject.get("totalAmount");
		appFormBean.setPaymentAmount(applicationFeeAmount);
		}
		
		ResourceBundle rb1 = ResourceBundle.getBundle("resources/constant");
		String merchantId = rb1.getString("MerchanId");
		String checksumKey = rb1.getString("ChecksumKey");
		String returnURL = rb1.getString("ReturnURL");
		String paymentURL = rb1.getString("paymentGatewayURL");
		String projectKey = rb1.getString("projectKey");
        //String appId=null;
      // int paymentType=0;
		try {
			/*// String ChecksumKey ="HBxMexHYlNAz";
			if(appFormBean.getPaymentMode().equals("initial"))
			{
				appId=appFormBean.getAppId();
				appFormBean.setPaymentType(1);
				
			}
			if(appFormBean.getPaymentMode().equals("final"))
			{
				appId="F"+appFormBean.getAppId();
				appFormBean.setPaymentType(2);
			}
			*/
			RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			TransactionFormBean transactionFormBean = new TransactionFormBean();
			transactionFormBean.setApplicationId(appFormBean.getAppId());
			transactionFormBean.setPaymentType(appFormBean.getPaymentType()+"");
			transactionFormBean.setStatus("fail");
			
			HttpEntity<?> entity = new HttpEntity(transactionFormBean, headers);

			ResponseEntity<String> output = restTemplate.exchange(
					ApplicationService + "saveTransactionDetails", HttpMethod.POST,
					entity, String.class);
			String transactionId = output.getBody();
			
			
			
			
			
			
			
			
			String checksumParameter = merchantId
					+ "|"
				//	+ "F"+appFormBean.getAppId()
					+  appFormBean.getPaymentType()+"-"+appFormBean.getAppId()+transactionId
					+ "|NA|"
					+ appFormBean.getPaymentAmount()
					+  "|NA|NA|NA|INR|NA|R|"+projectKey+"|NA|NA|F|NA|NA|NA|NA|NA|NA|NA|"
					+ returnURL;
			
			
			String checksumValue = HmacSHA256(checksumParameter, checksumKey);
		
			paymentURL = paymentURL + "?msg=" + checksumParameter + "|"	+ checksumValue;
			System.out.println("xxxxx:"+paymentURL);
		
		}catch(Exception e){
			
		}
		
		
		
		/*RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(appFormBean, headers);
		
		ResponseEntity<String> output = restTemplate.exchange(
				ApplicationService + "saveOnlinePaymentsDetails", HttpMethod.POST,
				entity, String.class);
		String applicationRef = output.getBody();
		
		*/
		
	
	return new ModelAndView("redirect:"+paymentURL);
		}
	
	
	public static String HmacSHA256(String message, String secret) {
		MessageDigest md = null;
		try {

			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(),
					"HmacSHA256");
			sha256_HMAC.init(secret_key);

			byte raw[] = sha256_HMAC.doFinal(message.getBytes());

			StringBuffer ls_sb = new StringBuffer();
			for (int i = 0; i < raw.length; i++)
				ls_sb.append(char2hex(raw[i]));
			return ls_sb.toString(); // step 6
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String char2hex(byte x)

	{
		char arr[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };

		char c[] = { arr[(x & 0xF0) >> 4], arr[x & 0x0F] };
		return (new String(c));
	}

	
	
	@RequestMapping(value = "/onlinePaymentResponse", method = RequestMethod.POST)
	public ModelAndView onlinePaymentResponse(Model model ,HttpServletRequest request, HttpServletResponse response) {
		
		String responseString = request.getParameter("msg");  //"CMWSSBINST|WI20170004|JSM25532327629|569588|2.00|SM2|459150|03|INR|VDDIRECT|NA|NA";//
		String[] responseSplit =  responseString.split("\\|");
		model.addAttribute("transactionRefNo", responseSplit[2]);
		model.addAttribute("bankRefNo", responseSplit[3]);
		
	/*	int paid=Integer.parseInt(responseSplit[4]);
	    double cost=paid/1.18;
		double gst=paid-cost;
		model.addAttribute("amount", cost);
		model.addAttribute("gst", gst);*/
		float paidAmount = 0.0f;
		if(responseSplit[4].matches(".*\\d.*")){
		float f = Float.parseFloat(responseSplit[4]);
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		paidAmount = Float.valueOf(decimalFormat.format(f));
		}
		
		
		model.addAttribute("paidAmount", paidAmount);
		model.addAttribute("Response", responseSplit[24]);
		
		
		
		//String responseStr = responseSplit[24];
		String responseStr = responseSplit[14];
		
		RestTemplate restTemplate = new RestTemplate();
		AppFormBean appFormBean = new AppFormBean();
		String responsePage=null;
		String serviceStatus=null;
		
		String[] appTranc = responseSplit[1].split("TR");
		String[] paymentTypeApplicationId= appTranc[0].split("-");
		String paymentType= paymentTypeApplicationId[0];
		model.addAttribute("paymentType", paymentType);
		String appId= paymentTypeApplicationId[1];
		//String appId=applicationIdRef;
		model.addAttribute("applicationRef", appId);
		
		/*if( applicationIdRef.charAt(0)=='F'){
			appId=applicationIdRef.substring(1);
		}
		*/
		appFormBean.setPaymentType(Integer.parseInt(paymentType));
		appFormBean.setAppId(appId);
		String transactionId = "TR"+appTranc[1];
		if(responseStr.equals("0399")||responseStr.equals("NA")||responseStr.equals("0002")||responseStr.equals("0001"))
		{
			appFormBean.setStatusFlag('F');//transaction Failed .
			responsePage="onlineFinalResponseFailure";
			serviceStatus="onlineFinalResponseFailure";
		}
		/*if(responseStr.matches(".*fail.*")){
			appFormBean.setStatusFlag('F');//transaction Failed .
			responsePage="onlineFinalResponseFailure";
			serviceStatus="onlineFinalResponseFailure";
		}*/
		
		
		else if( responseSplit[3].equals("NA"))
		{
			appFormBean.setStatusFlag('F');//transaction Failed .
			responsePage="onlineFinalResponseFailure";
			serviceStatus="onlineFinalResponseFailure";
		}
		
		else 
		{
			appFormBean.setStatusFlag('Y');
			appFormBean.setInitialPayment(paidAmount+"");//Initial payment
			appFormBean.setTransactionRefNo(responseSplit[2]);
			appFormBean.setBankRefNo(responseSplit[3]);
			responsePage="onlinePaymentResponse";
			serviceStatus="initialPaymentPaid";
			
		}
		
		
		RestTemplate restTemplateTran = new RestTemplate();
		
		HttpHeaders headersTran = new HttpHeaders();
		headersTran.setContentType(MediaType.APPLICATION_JSON);

		TransactionFormBean transactionFormBean = new TransactionFormBean();
		transactionFormBean.setTransactionId(transactionId);
		transactionFormBean.setApplicationId(appId);
		transactionFormBean.setPaymentType(paymentType);
		transactionFormBean.setTotalAmount(paidAmount+"");
		transactionFormBean.setTransactionRefNo(responseSplit[2]);
		transactionFormBean.setBankRefNo(responseSplit[3]);
		transactionFormBean.setStatus("Success");
		
		HttpEntity<?> entityTran = new HttpEntity(transactionFormBean, headersTran);

		ResponseEntity<String> outputTran = restTemplateTran.exchange(
				ApplicationService + "saveTransactionDetails", HttpMethod.POST,
				entityTran, String.class);
		String transactionIdResponse = outputTran.getBody();
		
		model.addAttribute("applicationRef", appId);
		appFormBean.setAppId( appId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				ApplicationService + "updatePaymentDtls", HttpMethod.POST,
				entity, String.class);
		String paymentAmount = output.getBody();
		
		if(paymentAmount!=null && serviceStatus.equals("initialPaymentPaid"))//easybusinessUrl called.
				{
			//AppFormBean appFormBean1 = new AppFormBean();
			//appFormBean.setAppId(appId);
			ResourceBundle rb1 = ResourceBundle.getBundle("resources/constant");
			int res=0;
			String easybusinessUrl = rb1.getString("easybusinessUrl");
			try {
				
				RestTemplate restTemplate1 = new RestTemplate();
				
				HttpHeaders headers1 = new HttpHeaders();
				headers1.setContentType(MediaType.APPLICATION_JSON);

				
				HttpEntity<?> entity1 = new HttpEntity(appFormBean, headers1);

				ResponseEntity<String> output1 = restTemplate1.exchange(
						ApplicationService + "callEasyBusiness", HttpMethod.POST,
						entity1, String.class);
				String cafid = output1.getBody();
				
					
					easybusinessUrl = easybusinessUrl+"/"+appFormBean.getAppId()+"/"+cafid;
				
					URL url1;
					try {
						url1 = new URL(easybusinessUrl);
						System.out.println("statusURL URL :" + easybusinessUrl);
						HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
						conn.connect();
						System.out.println("Status Response Code: "
								+ conn.getResponseCode());
						 res=conn.getResponseCode();
						} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					
					
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally {
				return new ModelAndView(responsePage);
			}
			
		}
		
		
		return new ModelAndView(responsePage);
		
		
		
	}
	
	@RequestMapping(value = "/getPaymentAmount", method = RequestMethod.POST)
	@ResponseBody
	public String getPaymentAmount(@RequestParam String whichPayment,@RequestParam String appId) {

		RestTemplate restTemplate = new RestTemplate();
		AppFormBean appFormBean = new AppFormBean();
		appFormBean.setAppId(appId);
		appFormBean.setInitialPayment(whichPayment);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				ApplicationService + "getPaymentAmount", HttpMethod.POST,
				entity, String.class);
		String paymentAmount = output.getBody();

		return paymentAmount;

	}
	@RequestMapping(value = "/getGstAmount", method = RequestMethod.POST)
	@ResponseBody
	public String getGstAmount(@RequestParam String whichPayment,@RequestParam String appId) {

		RestTemplate restTemplate = new RestTemplate();
		AppFormBean appFormBean = new AppFormBean();
		appFormBean.setAppId(appId);
		appFormBean.setInitialPayment(whichPayment);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				ApplicationService + "getGstAmounts", HttpMethod.POST,
				entity, String.class);
		String gstAmount = output.getBody();

		return gstAmount;

	}
	
	
	@RequestMapping(value = "/getReqMLDCost", method = RequestMethod.POST)
	@ResponseBody
	public String getReqMLDCost(@RequestParam String reqMldId) {
		int MldId=Integer.parseInt(reqMldId);
		  if(MldId<=1000)
		   {
			  MldId=1000;
		   }
	   else if(MldId<= 1500 && MldId>1000)
		   {
		   MldId=1500;
		  
		   
		   }
	   else  if( MldId > 1500 && MldId<= 2000 )
	   {
		   MldId=2000;
	   }
	   else if ( MldId>2000)
	   {
		   MldId=2500; 
	   }
AppFormBean appbean=new AppFormBean();
appbean.setReqMld(String.valueOf(MldId));
		  



			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<?> entity = new HttpEntity(appbean, headers);

			ResponseEntity<String> out = restTemplate.exchange(
					ApplicationService + "getReqMLDCost", HttpMethod.POST, entity,
					String.class);
			
		

		return out.getBody();

	}
	@RequestMapping(value = "/ApplicationDetailsold", method = RequestMethod.GET)
	@ResponseBody
	public String ApplicationDetailsold( @RequestParam String appId) {
		//if(appId !=null && !appId.equals("") ){

			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(appId);
			
			Map<String, Object> model = new HashMap<String, Object>();

			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<?> entity = new HttpEntity(applicationBean, headers);

			ResponseEntity<String> out = restTemplate.exchange(
					WaterDashboardService + "getApplicationDetails", HttpMethod.POST, entity,
					String.class);


			gson = new Gson();
			applicationBean = gson.fromJson(out.getBody().toString(),
					ApplicationBean.class);

			model.put("application", applicationBean);
			
			//return out.getBody();
		//}
		
		return out.getBody();
		
	}
	//getGstAmountfromForm
	@RequestMapping(value = "/getGstAmountForm", method = RequestMethod.POST)
	@ResponseBody
	public String getGstAmountForm(@RequestParam String reqMldId) {
		String initialPaymentCost=null;
		int MldId=Integer.parseInt(reqMldId);
		//MldId
		  if(MldId<=1000)
		   {
			  MldId=1000;
			 // initialPaymentCost="100000";
			//  initialPaymentCost="2";
		   }
	   else if(MldId<= 1500 && MldId>1000)
		   {
		   MldId=1500;
		  
		// initialPaymentCost="150000";
		  // initialPaymentCost="3";
		   
		   }
	   else  if( MldId > 1500 && MldId<= 2000 )
	   {
		   MldId=2000;
		  // initialPaymentCost="200000";
		  // initialPaymentCost="2";
	   }
	   else if ( MldId>2000)
	   {
		   MldId=2500; 
		// initialPaymentCost="250000";
		  // initialPaymentCost="2";
	   }
AppFormBean appbean=new AppFormBean();
appbean.setReqMld(String.valueOf(MldId));
		  



			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<?> entity = new HttpEntity(appbean, headers);

			ResponseEntity<String> out = restTemplate.exchange(
					ApplicationService + "getGstAmount", HttpMethod.POST, entity,
					String.class);
			
		

		return out.getBody();

	}
	@RequestMapping(value = "/getTotalAmount", method = RequestMethod.POST)
	@ResponseBody
	public String getTotalAmount(@RequestParam String reqMldId) {
		String initialPaymentCost=null;
		int MldId=Integer.parseInt(reqMldId);
		//MldId
		  if(MldId<=1000)
		   {
			  MldId=1000;
			 // initialPaymentCost="100000";
			//  initialPaymentCost="2";
		   }
	   else if(MldId<= 1500 && MldId>1000)
		   {
		   MldId=1500;
		  
		// initialPaymentCost="150000";
		  // initialPaymentCost="3";
		   
		   }
	   else  if( MldId > 1500 && MldId<= 2000 )
	   {
		   MldId=2000;
		  // initialPaymentCost="200000";
		  // initialPaymentCost="2";
	   }
	   else if ( MldId>2000)
	   {
		   MldId=2500; 
		// initialPaymentCost="250000";
		  // initialPaymentCost="2";
	   }
AppFormBean appbean=new AppFormBean();
appbean.setReqMld(String.valueOf(MldId));
		  



			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<?> entity = new HttpEntity(appbean, headers);

			ResponseEntity<String> out = restTemplate.exchange(
					ApplicationService + "getTotalAmount", HttpMethod.POST, entity,
					String.class);
			
		

		return out.getBody();

	}
	
	
	@RequestMapping(value = "/initialPaymentOnline", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView initialPaymentOnline(@RequestParam String appId,@RequestParam String ipf) {
		String initialPaymentCost=null;
		ApplicationBean applicationBean = new ApplicationBean();
		applicationBean.setAppId(appId);
		applicationBean.setInitialPaymentCost(ipf);
		Map<String, Object> model = new HashMap<String, Object>();
		  
		  model.put("applicationRef", applicationBean);
		  return new ModelAndView("initialPayment");
			//return new ModelAndView("checkApplicationStatus", "list", model);

		//return initialPaymentCost;

	}
	

	
/*
	@RequestMapping(value = "/downloadImage", method = RequestMethod.POST)
	public String downloadImage(@RequestParam String imageString,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String base64Image = imageString.split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter
				.parseBase64Binary(base64Image);

		ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
		BufferedImage image = ImageIO.read(bis);
		bis.close();
		String path = request.getRealPath("/");
		File outputfile = new File(path + "image.png");
		ImageIO.write(image, "png", outputfile);

		response.setContentType("image/png");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				"Acknowledgement.png");
		response.setHeader(headerKey, headerValue);
		ServletOutputStream out;
		out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(path + "image.png");

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		;
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		bin.close();
		fin.close();
		bout.close();
		out.close();

		return null;
	}

	
	

	@RequestMapping(value = "/downloadPDF", method = RequestMethod.POST)
	public String downloadPDF(@RequestParam String transactionRefNo,@RequestParam String bankRefNo,@RequestParam String applicationRef,@RequestParam String paidAmount,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, DocumentException {
		
		String path = request.getRealPath("/");
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(path + "imagepdf.pdf"));
		document.open();
		Image imageLogo = Image.getInstance(path + "library/img/Logo_Tamil_Nadu.jpg");
		Image imageTest = Image.getInstance(path + "library/img/Acknowlegement.png");
		float[] columnWidths = {3,10};
		PdfPTable tableImage = new PdfPTable(columnWidths);
		
		tableImage.setWidthPercentage(90);
		PdfPCell img1 = new PdfPCell(imageLogo); 
		img1.setBorder(Rectangle.NO_BORDER);
		tableImage.addCell(img1);
		
		
        PdfPCell img2 = new PdfPCell(imageTest);
        img2.setBorder(Rectangle.NO_BORDER);
        img2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tableImage.addCell(img2);
		
		PdfPTable table = new PdfPTable(1);
	    PdfPCell cell1 = new PdfPCell(new Phrase(""));
	    cell1.setFixedHeight(10f);
	    cell1.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell1);
		
		PdfPTable tableHeader = new PdfPTable(1);
		 BaseColor myforeColor = WebColors.getRGBColor("#800000");
		    Font font = new Font();
		    font.setColor(myforeColor);
	    PdfPCell cell2 = new PdfPCell(new Phrase("Acknowledgement",font));
	    cell2.setFixedHeight(30f);
	    BaseColor myColor = WebColors.getRGBColor("#FCFCF4");
	    cell2.setBackgroundColor(myColor);
	   
	    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeader.addCell(cell2);
		
		PdfPTable table1 = new PdfPTable(1);
	    PdfPCell cell = new PdfPCell(new Phrase(""));
	    cell.setFixedHeight(10f);
	    cell.setBorder(Rectangle.NO_BORDER);
		table1.addCell(cell);
		
		PdfPTable tableData = new PdfPTable(2);
		PdfPCell celld1 = new PdfPCell(new Phrase("Transaction Ref No"));
		 BaseColor myColor1 = WebColors.getRGBColor("#EDEDED");
		 celld1.setBackgroundColor(myColor1);
		 celld1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld1.setFixedHeight(25f);
		 celld1.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld1);
		PdfPCell celld2 = new PdfPCell(new Phrase(": "+transactionRefNo));
		 BaseColor myColor2 = WebColors.getRGBColor("#EDEDED");
		 celld2.setBackgroundColor(myColor2);
		 celld2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld2.setFixedHeight(25f);
		 celld2.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld2);
		PdfPCell celld3 = new PdfPCell(new Phrase("Bank Ref No"));
		 celld3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld3.setFixedHeight(25f);
		 celld3.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld3);
		PdfPCell celld4 = new PdfPCell(new Phrase(": "+bankRefNo));
		 celld4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld4.setFixedHeight(25f);
		 celld4.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld4);
		PdfPCell celld5 = new PdfPCell(new Phrase("Application No"));
		 BaseColor myColor5 = WebColors.getRGBColor("#EDEDED");
		 celld5.setBackgroundColor(myColor5);
		 celld5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld5.setFixedHeight(25f);
		 celld5.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld5);
		PdfPCell celld6 = new PdfPCell(new Phrase(": "+applicationRef));
		 BaseColor myColor6 = WebColors.getRGBColor("#EDEDED");
		 celld6.setBackgroundColor(myColor6);
		 celld6.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld6.setFixedHeight(25f);
		 celld6.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld6);
		PdfPCell celld7 = new PdfPCell(new Phrase("Paid Amount"));
		 celld7.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld7.setFixedHeight(25f);
		 celld7.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld7);
		PdfPCell celld8 = new PdfPCell(new Phrase(": "+paidAmount));
		 celld8.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld8.setFixedHeight(25f);
		 celld8.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld8);
		document.add(tableImage);
		document.add(table);
		
		document.add(tableHeader);
		document.add(table1);
		document.add(tableData);
		document.close();
		
		
		response.setContentType("APPLICATION/PDF");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				"Acknowledgement.pdf");
		response.setHeader(headerKey, headerValue);
		ServletOutputStream out;
		out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(path + "imagepdf.pdf");

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		;
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		bin.close();
		fin.close();
		bout.close();
		out.close();

		return null;
	}
*/

	@RequestMapping(value = "/downloadImage", method = RequestMethod.POST)
	public String downloadImage(@RequestParam String imageString,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String base64Image = imageString.split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter
				.parseBase64Binary(base64Image);

		ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
		BufferedImage image = ImageIO.read(bis);
		bis.close();
		String path = request.getRealPath("/");
		File outputfile = new File(path + "image.png");
		ImageIO.write(image, "png", outputfile);

		response.setContentType("image/png");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				"Twad_Receipt.png");
		response.setHeader(headerKey, headerValue);
		ServletOutputStream out;
		out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(path + "image.png");

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		;
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		bin.close();
		fin.close();
		bout.close();
		out.close();

		return null;
	}

	
	

	@RequestMapping(value = "/downloadPDF", method = RequestMethod.POST)
	public String downloadPDF(@RequestParam String transactionRefNo,@RequestParam String bankRefNo,@RequestParam String applicationRef,@RequestParam String paidAmount,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, DocumentException {
		
		String path = request.getRealPath("/");
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream(path + "imagepdf.pdf"));
		document.open();
		Image imageLogo = Image.getInstance(path + "library/img/Logo_Tamil_Nadu.jpg");
		Image imageTest = Image.getInstance(path + "library/img/Acknowlegement.png");
		float[] columnWidths = {3,10};
		PdfPTable tableImage = new PdfPTable(columnWidths);
		
		tableImage.setWidthPercentage(90);
		PdfPCell img1 = new PdfPCell(imageLogo); 
		img1.setBorder(Rectangle.NO_BORDER);
		tableImage.addCell(img1);
		
		
        PdfPCell img2 = new PdfPCell(imageTest);
        img2.setBorder(Rectangle.NO_BORDER);
        img2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tableImage.addCell(img2);
		
		PdfPTable table = new PdfPTable(1);
	    PdfPCell cell1 = new PdfPCell(new Phrase(""));
	    cell1.setFixedHeight(10f);
	    cell1.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell1);
		
		PdfPTable tableHeader = new PdfPTable(1);
		 BaseColor myforeColor = WebColors.getRGBColor("#800000");
		    Font font = new Font();
		    font.setColor(myforeColor);
	    PdfPCell cell2 = new PdfPCell(new Phrase("Acknowledgement",font));
	    cell2.setFixedHeight(30f);
	    BaseColor myColor = WebColors.getRGBColor("#FCFCF4");
	    cell2.setBackgroundColor(myColor);
	   
	    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeader.addCell(cell2);
		
		PdfPTable table1 = new PdfPTable(1);
	    PdfPCell cell = new PdfPCell(new Phrase(""));
	    cell.setFixedHeight(10f);
	    cell.setBorder(Rectangle.NO_BORDER);
		table1.addCell(cell);
		
		PdfPTable tableData = new PdfPTable(2);
		PdfPCell celld1 = new PdfPCell(new Phrase("Transaction Ref No"));
		 BaseColor myColor1 = WebColors.getRGBColor("#EDEDED");
		 celld1.setBackgroundColor(myColor1);
		 celld1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld1.setFixedHeight(25f);
		 celld1.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld1);
		PdfPCell celld2 = new PdfPCell(new Phrase(": "+transactionRefNo));
		 BaseColor myColor2 = WebColors.getRGBColor("#EDEDED");
		 celld2.setBackgroundColor(myColor2);
		 celld2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld2.setFixedHeight(25f);
		 celld2.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld2);
		PdfPCell celld3 = new PdfPCell(new Phrase("Bank Ref No"));
		 celld3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld3.setFixedHeight(25f);
		 celld3.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld3);
		PdfPCell celld4 = new PdfPCell(new Phrase(": "+bankRefNo));
		 celld4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld4.setFixedHeight(25f);
		 celld4.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld4);
		PdfPCell celld5 = new PdfPCell(new Phrase("Application No"));
		 BaseColor myColor5 = WebColors.getRGBColor("#EDEDED");
		 celld5.setBackgroundColor(myColor5);
		 celld5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld5.setFixedHeight(25f);
		 celld5.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld5);
		PdfPCell celld6 = new PdfPCell(new Phrase(": "+applicationRef));
		 BaseColor myColor6 = WebColors.getRGBColor("#EDEDED");
		 celld6.setBackgroundColor(myColor6);
		 celld6.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld6.setFixedHeight(25f);
		 celld6.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld6);
		PdfPCell celld7 = new PdfPCell(new Phrase("Paid Amount"));
		 celld7.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld7.setFixedHeight(25f);
		 celld7.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld7);
		PdfPCell celld8 = new PdfPCell(new Phrase(": "+paidAmount));
		 celld8.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 celld8.setFixedHeight(25f);
		 celld8.setBorder(Rectangle.NO_BORDER);
		tableData.addCell(celld8);
		document.add(tableImage);
		document.add(table);
		
		document.add(tableHeader);
		document.add(table1);
		document.add(tableData);
		document.close();
		
		
		response.setContentType("APPLICATION/PDF");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				"Acknowledgement.pdf");
		response.setHeader(headerKey, headerValue);
		ServletOutputStream out;
		out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(path + "imagepdf.pdf");

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		;
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		bin.close();
		fin.close();
		bout.close();
		out.close();

		return null;
	}

	
	
	
	
	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files,@RequestParam("appId") String appId, HttpServletRequest request) {
		//if(appId==null)
		appId=(String)request.getSession().getAttribute("appId");
		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = file.getOriginalFilename();
			if(name.equals("")){
				continue;
			}
			try {
				byte[] bytes = file.getBytes();

				
				File dir = new File("c:/EC/"+appId);
				if(!dir.exists()){
					dir.mkdirs();
				}
				 
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream("c:/EC/"+appId+"/"+file.getOriginalFilename()));
				stream.write(bytes);
				stream.close();

				
				message = message + "\n"+name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return "You successfully uploaded these files "+message;
	}

	
	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFileByAdmin", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleFileByAdmin(@RequestParam("file") MultipartFile[] files,@RequestParam("appId") String appId, HttpServletRequest request) {
		
		if(null !=request.getSession().getAttribute("appId"))
		appId=(String)request.getSession().getAttribute("appId");
		String message = "";
		String msg="";
		//String success="";
		
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = file.getOriginalFilename();
			if(name.equals("")){
				continue;
			}
			String filesType=file.getOriginalFilename().split("\\.")[1];
			
			if(filesType.equals("mp4")||filesType.equals("mp3"))
			{
				msg="Please upload valid file!";
			}
			else{
			try {
				byte[] bytes = file.getBytes();

				
				File dir = new File("c:/EC/"+appId+"/Admin");
				if(!dir.exists()){
					dir.mkdirs();
				}
				 
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream("c:/EC/"+appId+"/Admin/"+file.getOriginalFilename()));
				stream.write(bytes);
				stream.close();

				
				message = message + "\n"+name;
				msg="You successfully uploaded these files "+message;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
			}
		}
		return msg;
	}


	
	
@RequestMapping(value = "/checkApplicationStatus", method = RequestMethod.GET)
public ModelAndView checkApplicationStatus( @RequestParam String appId/* ,  @RequestParam String mobileNum*/) {
	if(appId !=null && !appId.equals("") ){

		DDPaymentFormBean ddPaymentFormBean = new DDPaymentFormBean();
		ddPaymentFormBean.setAppId(appId);
		//ddPaymentFormBean.setMobileNum(Long.parseLong(mobileNum));
		
		Map<String, Object> model = new HashMap<String, Object>();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity(ddPaymentFormBean, headers);

		
		ResponseEntity<DDPaymentFormBean> output = restTemplate.exchange(
				WaterDashboardService + "paymentViewForm", HttpMethod.POST,
				entity, DDPaymentFormBean.class);
		
		ddPaymentFormBean = output.getBody();
		
		/*if(null != ddPaymentFormBean.getMobileNum() && ddPaymentFormBean.getMobileNum()==Long.parseLong(mobileNum))
		{*/
		model.put("application", ddPaymentFormBean);
		File folder = new File("c:/EC/"+appId);
		File[] listOfFiles = folder.listFiles();
		List<String> fileList = new ArrayList<String>();
		
		    for (int i = 0;listOfFiles!=null &&  i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  fileList.add(listOfFiles[i].getName());
		      }
		    }
		    
		    File folderAdmin = new File("c:/EC/"+appId+"/Admin");
			File[] listOfFilesByAdmin = folderAdmin.listFiles();
			List<String> uploadedFilesByAdmin = new ArrayList<String>();
		    
		    for (int i = 0;listOfFilesByAdmin!=null &&  i < listOfFilesByAdmin.length; i++) {
			      if (listOfFilesByAdmin[i].isFile()) {
			    	  uploadedFilesByAdmin.add(listOfFilesByAdmin[i].getName());
			      }
			    }
		
		    model.put("uploadedFiles", fileList);
		    model.put("uploadedFilesByAdmin", uploadedFilesByAdmin);

		
		
		/*}
		else{
			model.put("application", "Data not found");
		}*/
		
		//model.put("categoryCount", publicdashboard());
		return new ModelAndView("checkApplicationStatus", "list", model);
	
	}
	return new ModelAndView("checkApplicationStatus");
}

@RequestMapping(value = "/ApplicationDetails", method = RequestMethod.GET)
@ResponseBody
public String ApplicationDetails( @RequestParam String appId) {
	//if(appId !=null && !appId.equals("") ){

		ApplicationBean applicationBean = new ApplicationBean();
		applicationBean.setAppId(appId);
		
		Map<String, Object> model = new HashMap<String, Object>();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity(applicationBean, headers);

		ResponseEntity<String> out = restTemplate.exchange(
				WaterDashboardService + "getApplicationDetails", HttpMethod.POST, entity,
				String.class);


		gson = new Gson();
		applicationBean = gson.fromJson(out.getBody().toString(),
				ApplicationBean.class);

		model.put("application", applicationBean);
		
		//return out.getBody();
	//}
	
	return out.getBody();
	
}


@RequestMapping(value = "/withdrawApp", method = RequestMethod.POST)
@ResponseBody
public String withdrawApp( @RequestParam String appId) {
	if(appId !=null && !appId.equals("") ){

		ApplicationBean applicationBean = new ApplicationBean();
		applicationBean.setAppId(appId);
		
		Map<String, Object> model = new HashMap<String, Object>();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity(applicationBean, headers);

		ResponseEntity<String> out = restTemplate.exchange(
				ApplicationService + "withdrawApp", HttpMethod.POST, entity,
				String.class);

		String response = out.getBody();
		
		return response;
	
	}
	return "Not Withdrawn";
	
}




@RequestMapping(value = "/callEasyBusiness", method = RequestMethod.GET)
//@ResponseBody
//public ModelAndView callEasyBusiness(String appId) throws IOException {
public void callEasyBusiness(String appId) throws IOException {
	AppFormBean appFormBean = new AppFormBean();
	appFormBean.setAppId(appId);
	ResourceBundle rb1 = ResourceBundle.getBundle("resources/constant");
	int res=0;
	String easybusinessUrl = rb1.getString("easybusinessUrl");
	try {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		
		HttpEntity<?> entity = new HttpEntity(appFormBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				ApplicationService + "callEasyBusiness", HttpMethod.POST,
				entity, String.class);
		String cafid = output.getBody();
		
			
			
			easybusinessUrl = easybusinessUrl+"/"+appFormBean.getAppId()+"/"+cafid;
	
			URL url1;
			try {
				url1 = new URL(easybusinessUrl);
				System.out.println("statusURL URL :" + easybusinessUrl);
				HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
				conn.connect();
				System.out.println("Status Response Code: "
						+ conn.getResponseCode());
				 res=conn.getResponseCode();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			
			
	
		
		
		
		
	}catch(Exception e){
		
	}
	

	}




}