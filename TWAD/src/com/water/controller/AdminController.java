package com.water.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.water.bean.AppFormBean;
import com.water.bean.CategoryFormBean;
import com.water.bean.ChangePasswordBean;
import com.water.bean.ConnectionFormBean;
import com.water.bean.DDPaymentFormBean;
import com.water.bean.DistrictFormBean;
import com.water.bean.ForgotPasswordBean;
import com.water.bean.LoginBean;
import com.water.bean.PaymentFormBean;
import com.water.bean.ZoneDivisionFormBean;

/**
 * Created by Mahalingam (Freelancer) On 27-Apr-2017
 * 
 * @author Mahalingam
 * 
 *         This class act as Spring controller class.
 * 
 *         Contains action view methods.
 * 
 *         Dropdownlist functions
 * 
 *         List of Bean manipulation from JSON string from Web service
 * 
 *         All methods will call Webservice to fetch the Data from backend
 * 
 *         weservice URL is maaped in Propery files
 * 
 * 
 */
@Controller
public class AdminController {

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

	/**
	 * @return ModelAndView - index page
	 */
	// welcome menu to login to the application
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome(
			@ModelAttribute("loginForm") LoginBean loginBean,
			HttpSession session) {
		return new ModelAndView("index");
	}

	// welcome menu to login to the application
		@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
		public ModelAndView adminLogin(@ModelAttribute("loginForm") LoginBean loginBean,HttpSession session) {
			return new ModelAndView("adminLogin");
		}
		
		@RequestMapping(value = "/changePasswordPage", method = RequestMethod.GET)
		public ModelAndView changePassword() {
			return new ModelAndView("changePasswordPage");
		}

	@RequestMapping(value = "/formRegister", method = RequestMethod.GET)
	public ModelAndView formRegister(HttpServletRequest request) throws JSONException, IOException {
		
		Map<String, Object> model = new HashMap<String, Object>();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity(headers);

		ResponseEntity<String> out = restTemplate.exchange(
				WaterDashboardService + "getCategoryDtl",
				HttpMethod.POST, entity, String.class);

		JSONArray jsonArray = new JSONArray(out.getBody().toString());

		gson = new Gson();

		List<CategoryFormBean> categoryFormBeanList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			CategoryFormBean categoryFormBean = gson.fromJson(
					jsonArray.getString(i), CategoryFormBean.class);
			categoryFormBeanList.add(categoryFormBean);
		}

		
		
		model.put("categoryDtl", categoryFormBeanList);
		
	
		
		/*ResponseEntity<String> out1 = restTemplate.exchange(
				WaterDashboardService + "getConnectionTypeDtl",
				HttpMethod.POST, entity, String.class);

		JSONArray jsonArray1 = new JSONArray(out1.getBody().toString());

		gson = new Gson();

		List<ConnectionFormBean> connectionFormBeanList = new ArrayList<>();

		for (int i = 0; i < jsonArray1.length(); i++) {
			ConnectionFormBean connectionFormBean = gson.fromJson(
					jsonArray1.getString(i), ConnectionFormBean.class);
			connectionFormBeanList.add(connectionFormBean);
		}

		
		
		model.put("connectionTypeDtl", connectionFormBeanList);
		*/
		
		
		
		
		ResponseEntity<String> out1 = restTemplate.exchange(
				WaterDashboardService + "getDistrictDtl",
				HttpMethod.POST, entity, String.class);

		JSONArray jsonArray1 = new JSONArray(out1.getBody().toString());

		gson = new Gson();

		List<DistrictFormBean> districtFormBeanList = new ArrayList<>();

		for (int i = 0; i < jsonArray1.length(); i++) {
			DistrictFormBean districtFormBean = gson.fromJson(
					jsonArray1.getString(i), DistrictFormBean.class);
			districtFormBeanList.add(districtFormBean);
		}

		
		
		model.put("districtDtl", districtFormBeanList);
		
		
		ResponseEntity<String> out2 = restTemplate.exchange(
				WaterDashboardService + "getFixedPaymentAmount",
				HttpMethod.POST, entity, String.class);

		JSONArray jsonArray2 = new JSONArray(out2.getBody().toString());

		gson = new Gson();

		List<DDPaymentFormBean> ddPaymentFormBeanList = new ArrayList<>();

		for (int i = 0; i < jsonArray2.length(); i++) {
			DDPaymentFormBean ddPaymentFormBean = gson.fromJson(
					jsonArray2.getString(i), DDPaymentFormBean.class);
			ddPaymentFormBeanList.add(ddPaymentFormBean);
		}

		
		model.put("fixedPaymentAmount", ddPaymentFormBeanList.get(0));
		
		
		
		

		/*ResponseEntity<String> out2 = restTemplate.exchange(
				WaterDashboardService + "getDivisionDtl",
				HttpMethod.POST, entity, String.class);

		JSONArray jsonArray2 = new JSONArray(out2.getBody().toString());

		gson = new Gson();

		List<ZoneDivisionFormBean> zoneDivisionFormBeanList = new ArrayList<>();

		for (int i = 0; i < jsonArray2.length(); i++) {
			ZoneDivisionFormBean zoneDivisionFormBean = gson.fromJson(
					jsonArray2.getString(i), ZoneDivisionFormBean.class);
			zoneDivisionFormBeanList.add(zoneDivisionFormBean);
		}

		
		
		model.put("zoneDivisionDtl", zoneDivisionFormBeanList);
		
		*/
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("WEB-INF/");
        FileWriter fw = new FileWriter(pathArr[0]+"library/parameter.json");
		BufferedWriter bw = new BufferedWriter(fw);
		
		 bw.write("{\n");
		 bw.write("\"legCompName\":\""+request.getParameter("legCompName")+"\",\n");
		 bw.write("\"correspondenceAddr\":\""+request.getParameter("correspondenceAddr")+"\",\n");
		 bw.write("\"contactPersonName\":\""+request.getParameter("contactPersonName")+"\",\n");
		 bw.write("\"mobileNum\":\""+request.getParameter("mobileNum")+"\",\n");
		 bw.write("\"landLineNo\":\""+request.getParameter("landLineNo")+"\",\n");
		 bw.write("\"emailAddr\":\""+request.getParameter("emailAddr")+"\",\n");
		 bw.write("\"siteAddr\":\""+request.getParameter("siteAddr")+"\"\n");
		 bw.write("\"caf\":\""+request.getParameter("caf")+"\"\n");
		   bw.write("}");
		
		bw.close();
		fw.close();
		
		
		
		
		
		
		return new ModelAndView("formRegister","list",model);
	}
	
	@RequestMapping(value = "/formRegisters", method = RequestMethod.GET)
	public ModelAndView formRegisters(AppFormBean appFormBean,HttpServletRequest request) {
		Map<String, String> model = new HashMap<String, String>();
		model.put("applicationRef", appFormBean.getAppId());
		model.put("legalName", appFormBean.getLegCompName());
		return new ModelAndView("formRegisters");
	}
	/*public String appRegister(AppFormBean appFormBean,HttpServletRequest request) {

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
	@RequestMapping(value = "/initialPayment", method = RequestMethod.GET)
	public ModelAndView initialPayment() throws JSONException {
		Map<String, Object> model = new HashMap<String, Object>();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity(headers);
		

		ResponseEntity<String> out1 = restTemplate.exchange(
				WaterDashboardService + "getPaymentTypeDtl",
				HttpMethod.POST, entity, String.class);

		JSONArray jsonArray1 = new JSONArray(out1.getBody().toString());

		gson = new Gson();

		List<PaymentFormBean> paymenttypeFormBeanList = new ArrayList<>();

		for (int i = 0; i < jsonArray1.length(); i++) {
			PaymentFormBean paymentTypeFormBean = gson.fromJson(
					jsonArray1.getString(i), PaymentFormBean.class);
			paymenttypeFormBeanList.add(paymentTypeFormBean);
		}

		
		
		model.put("paymentTypeDtl", paymenttypeFormBeanList);

		return new ModelAndView("initialPayment", "list", model);
	}
	
	
	@RequestMapping(value = "/onlinePayment", method = RequestMethod.GET)
	public ModelAndView onlinePayment() throws JSONException {
		Map<String, Object> model = new HashMap<String, Object>();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> entity = new HttpEntity(headers);
		

		ResponseEntity<String> out1 = restTemplate.exchange(
				WaterDashboardService + "getPaymentTypeDtl",
				HttpMethod.POST, entity, String.class);

		JSONArray jsonArray1 = new JSONArray(out1.getBody().toString());

		gson = new Gson();

		List<PaymentFormBean> paymenttypeFormBeanList = new ArrayList<>();

		for (int i = 0; i < jsonArray1.length(); i++) {
			PaymentFormBean paymentTypeFormBean = gson.fromJson(
					jsonArray1.getString(i), PaymentFormBean.class);
			paymenttypeFormBeanList.add(paymentTypeFormBean);
		}

		
		
		model.put("paymentTypeDtl", paymenttypeFormBeanList);

		return new ModelAndView("onlinePayment", "list", model);
	}
	
	
	
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	@ResponseBody
	public String forgotPassword(String userName,String userEmailId) {
		
		ForgotPasswordBean forgotPasswordBean = new ForgotPasswordBean(); 
		forgotPasswordBean.setUserName(userName.trim());
		forgotPasswordBean.setUserEmailId(userEmailId.trim());
	
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(forgotPasswordBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				WaterEmployeeService + "forgotPassword", HttpMethod.POST,
				entity, String.class);

		
		
		return output.getBody().toString();
	}
	
	@RequestMapping(value = "/managementChangePassword", method = RequestMethod.POST)
	@ResponseBody
	public String managementChangePassword(String userName,String userEmailId,String oldPassword,String newPassword) {
		
		ChangePasswordBean changePasswordBean = new ChangePasswordBean(); 
		changePasswordBean.setUserName(userName.trim());
		changePasswordBean.setUserEmailId(userEmailId.trim());
		changePasswordBean.setOldPassword(oldPassword);
		changePasswordBean.setNewPassword(newPassword);
	
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(changePasswordBean, headers);

		ResponseEntity<String> output = restTemplate.exchange(
				WaterEmployeeService + "managementChangePassword", HttpMethod.POST,
				entity, String.class);

		
		
		return output.getBody().toString();
	}
	
	
	
	/**
	 * @param userName
	 *            - String- Username
	 * @param password
	 *            -String - password
	 * @param session
	 *            - Httpsession to keep user info on session
	 * @return ModelAndView - view to send back the response
	 */

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView loginCheck(
			@ModelAttribute("loginForm") LoginBean loginBean,
			HttpSession session) {

		Map<String, Object> model = new HashMap<String, Object>();

		boolean isValidUser = false;
		String redirect = null;

		try {

			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			loginBean.setAccessTypeID(2);
			HttpEntity<?> entity = new HttpEntity(loginBean, headers);

			ResponseEntity<String> output = restTemplate.exchange(
					WaterEmployeeService + "authenticateUser", HttpMethod.POST,
					entity, String.class);

			gson = new Gson();
			loginBean = gson.fromJson(output.getBody().toString(),
					LoginBean.class);

			if (loginBean != null && "success".equals(loginBean.getResult())) {

				isValidUser = true;
				session.setAttribute("LoginDetailID",
						loginBean.getLoginDetailID());
				session.setAttribute("LoginID", loginBean.getLoginDetailID());
				session.setAttribute("LoginName", loginBean.getLoginName());
				session.setAttribute("OfficeId", loginBean.getDivisionId());
				session.setAttribute("RoleID", loginBean.getRoleID());
				if (loginBean.getRoleID() == 1) {
				//	redirect = "CEhomePage";
					session.setAttribute("RoleID", loginBean.getRoleID());
					
					redirect= "redirect:/ceDashboard.do";
					
				}
				if (loginBean.getRoleID() == 2) {
					//redirect = "EEhomePage";
					session.setAttribute("RoleID", loginBean.getRoleID());
					redirect= "redirect:/eeDashboard.do";
				}
				if (loginBean.getRoleID() == 3) {
					//redirect = "MChomePage";
					session.setAttribute("RoleID", loginBean.getRoleID());
					redirect= "redirect:/mcdashboard.do";
				}
				if (loginBean.getRoleID() == 4) {
					//redirect = "MChomePage";
					session.setAttribute("RoleID", loginBean.getRoleID());
					redirect= "redirect:/paymentDashboard.do";
				}
				if (loginBean.getRoleID() == 10) {
					//	redirect = "CEhomePage";
					session.setAttribute("RoleID", loginBean.getRoleID());
						redirect= "redirect:/configrationManagement.do";
						
					}

			}

		} catch (Exception we) {
			we.printStackTrace();

			isValidUser = false;
		}

		if (isValidUser) {

			return new ModelAndView(redirect);

		} else {
			model.put("response", LOGIN_ERR_MSG);
			return new ModelAndView("adminLogin", model);
		}

	}

	/**
	 * @param session
	 *            - invalidate the user session and redirect to login page
	 * @return ModelAndView - return value of index page
	 */
	@RequestMapping(value = "/signOut", method = RequestMethod.GET)
	public ModelAndView signOut(
			@ModelAttribute("loginForm") LoginBean loginBean,
			HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return new ModelAndView("index");
	}

	/**
	 * @return ModelAndView This action will be called if any error occurred/404
	 *         status
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView errorPage() {
		return new ModelAndView("errorPage");
	}

	/**
	 * @return ModelAndView - home screen for user after login
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {

		return new ModelAndView("CEhomePage");
	}



	
	
}
