package com.water.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.water.bean.ChangePasswordBean;
import com.water.bean.ForgotPasswordBean;
import com.water.bean.LoginBean;
import com.water.daoImpl.LoginDaoImpl;
import com.water.model.EmployeeDetails;

/**
 * @author Mahalingam Created on 25-04-2017 for EmployeeService :
 * 
 *         4.1.1 Student Registration system
 * 
 *         1.User Authentication
 * 
 *         2. Change Password
 * 
 *         3.Register new Student
 * 
 *         4. Mobile No and Email Unique validation
 *
 */
@Path("EmployeeService")
public class EmployeeService {

	Gson gson = new Gson();

	String reponse = null;
	LoginDaoImpl loginServiceDao;
	
	
	
	
	
	
	@POST
	@Path("/forgotPassword")
	@Produces(MediaType.APPLICATION_JSON)
	public String forgotPassword(ForgotPasswordBean forgotPasswordBean) {

		loginServiceDao = new LoginDaoImpl();
		return loginServiceDao.forgotPassword(forgotPasswordBean);

	}
	
	@POST
	@Path("/managementChangePassword")
	@Produces(MediaType.APPLICATION_JSON)
	public String managementChangePassword(ChangePasswordBean changePasswordBean) {

		loginServiceDao = new LoginDaoImpl();
		return loginServiceDao.managementChangePassword(changePasswordBean);

	}
	/**
	 * @param userName
	 * @param password
	 * @return String
	 */
	
	
	
	
	@POST
	@Path("/authenticateUser")
	@Produces(MediaType.APPLICATION_JSON)
	public String authenticateUser(LoginBean loginBean) {

		loginServiceDao = new LoginDaoImpl();
		EmployeeDetails list = loginServiceDao.authenticateUser(loginBean);

		LoginBean loginreult = new LoginBean();

		if (list != null) {

			loginreult.setLoginDetailID(list.getUserId());
			loginreult.setLoginName(list.getUserFirstName());
			loginreult.setRoleID(list.getUserRole().getRoleId());
			if(null !=list.getUserDivision()){
			 loginreult.setDivisionId(list.getUserDivision().getDivisionId()+"");
			}
			//loginreult.setIsActive(list.getStatusFlag());
			loginreult.setResult("success");

			//if (list.getModifiedDate() == null)
			//	loginreult.setResult("newuser");

		} else
			loginreult.setResult("failure");

		reponse = gson.toJson(loginreult);
		return reponse;

	}

	/**
	 * @param userID
	 * @param tmepPassword
	 * @param password
	 * @return String
	 */

	@POST
	@Path("/changePassword")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String changePassword(LoginBean loginbean) {

		loginServiceDao = new LoginDaoImpl();
		LoginBean loginreult = new LoginBean();

		loginreult.setResult(loginServiceDao.changePassword(
				loginbean.getLoginName(), loginbean.getLoginPassword(),
				loginbean.getNewPassword(),
				loginbean.getAccessTypeID().toString()).toString());

		reponse = gson.toJson(loginreult);
		return reponse;

	}

	@GET
	@Path("/forGetPassword")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String forGetPassword(@QueryParam("userName") String studentID) {
		loginServiceDao = new LoginDaoImpl();
		LoginBean loginreult = new LoginBean();
		loginreult.setResult(loginServiceDao.forgetPassword(studentID));
		reponse = gson.toJson(loginreult);
		return reponse;
	}

}
