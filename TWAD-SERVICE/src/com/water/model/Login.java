/**
 * 
 */
package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mahalingam Created on 02-06-2017 for Application Login user Entity
 * 
 *         EC Login Module
 *
 */
@Entity
@Table(name = "tblLoginDetails")
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LoginDetailID")
	private Integer loginDetailID;

	@Column(name = "LoginName")
	private String loginName;

	@Column(name = "LoginPassword")
	private String loginPassword;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "RoleID")
	private Integer roleID;

	@Column(name = "MobileNumber")
	private String mobileNumber;

	@Column(name = "EmailID")
	private String emailID;

	@Column(name = "AccessTypeID")
	private Integer accessTypeID;

	@Column(name = "IsActive")
	private Boolean isActive;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
