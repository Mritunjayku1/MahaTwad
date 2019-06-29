package com.water.bean;

import java.sql.Date;

/**
 * @author Mahalingam
 * 
 *         4.1 YTU Login Module
 * 
 *         Created by Mahalingam (Freelancer) On 25-Apr-2017
 * 
 *         This class is used for login module. and to retrieve user inform to
 *         store in session once the user is valid The same class will be used
 *         for both web and mobile authentication
 * 
 */
/**
 * @author Mahalingam
 *
 *         Jun 15, 2017
 */
public class LoginBean {

	private Integer loginDetailID;

	private String loginName;

	private String loginPassword;

	private String userName;

	private String newPassword;

	private Integer roleID;

	private String mobileNumber;

	private String emailID;

	private Integer accessTypeID;

	private Boolean isActive;

	private Date createdDate;

	private Date modifiedDate;

	private String result;
	
	private String divisionId;

	public Integer getLoginDetailID() {
		return loginDetailID;
	}

	public void setLoginDetailID(Integer loginDetailID) {
		this.loginDetailID = loginDetailID;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Integer getAccessTypeID() {
		return accessTypeID;
	}

	public void setAccessTypeID(Integer accessTypeID) {
		this.accessTypeID = accessTypeID;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

}
