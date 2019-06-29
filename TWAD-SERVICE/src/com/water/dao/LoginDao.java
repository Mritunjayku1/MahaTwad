package com.water.dao;

import com.water.bean.ChangePasswordBean;
import com.water.bean.ForgotPasswordBean;
import com.water.bean.LoginBean;
import com.water.model.EmployeeDetails;
import com.water.model.Login;

/**
 * @author Mahalingam
 * 
 *         4.1 YTU Login Module
 * 
 *         Created by Mahalingam (Freelancer) On 25-Apr-2017
 * 
 *         This Interface is used for Login related operation authenticateUSer
 *         and password change(Mobile)
 * 
 */
public interface LoginDao {

	/**
	 * @param loginBean
	 * @return Login authentication by UserID and password,if success will
	 *         return Login Object
	 */
	public EmployeeDetails authenticateUser(LoginBean loginBean);

	/**
	 * @param userID
	 * @param oldPassword
	 * @param newPassword
	 * @return Boolean
	 * 
	 *         Change password for Mobile App by validating temporary password,
	 *         If password changed will return TRUE
	 */
	public Boolean changePassword(String userID, String oldPassword,
			String newPassword, String accessId);

	public String forgetPassword(String userName);
	
	public String forgotPassword(ForgotPasswordBean forgotPasswordBean);
	public String managementChangePassword(ChangePasswordBean changePasswordBean);
}
