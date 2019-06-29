package com.water.bean;

import java.util.Date;

public class SmsBean {

	
	
	private int SMSDataID;
	private String SMSSenterNumber;
	private String SMSContent;
	private String EmailID;
	private String IsActive;
	private Date CreatedDate;
	private Date ModifiedDate;
	public int getSMSDataID() {
		return SMSDataID;
	}
	public void setSMSDataID(int sMSDataID) {
		SMSDataID = sMSDataID;
	}
	public String getSMSSenterNumber() {
		return SMSSenterNumber;
	}
	public void setSMSSenterNumber(String sMSSenterNumber) {
		SMSSenterNumber = sMSSenterNumber;
	}
	public String getSMSContent() {
		return SMSContent;
	}
	public void setSMSContent(String sMSContent) {
		SMSContent = sMSContent;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public String getIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	public Date getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	
	
	
	
}
