package com.water.bean;

import java.util.Date;

public class SmsDatas {
	private Integer sMSDataID;

	private String sMSSenterNumber;

	private String sMSContent;

	private String emailID;

	private boolean isActive;

	private Date createdDate;

	private Date modifiedDate;

	public Integer getsMSDataID() {
		return sMSDataID;
	}

	public void setsMSDataID(Integer sMSDataID) {
		this.sMSDataID = sMSDataID;
	}

	public String getsMSSenterNumber() {
		return sMSSenterNumber;
	}

	public void setsMSSenterNumber(String sMSSenterNumber) {
		this.sMSSenterNumber = sMSSenterNumber;
	}

	public String getsMSContent() {
		return sMSContent;
	}

	public void setsMSContent(String sMSContent) {
		this.sMSContent = sMSContent;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
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

}
