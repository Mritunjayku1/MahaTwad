package com.water.bean;

import java.util.Date;

public class PaymentFormBean implements Comparable< PaymentFormBean > {
	
	private String paymentId;
	private String companyPaymentDtlID;
	private String inspectedDate;
	private String appId;
	private String paymentTypeId;
	private String paymentType;
	private String paymentAmount;
	private String paymentTypeDesc;
	private String paymentDesc;
	private String gstAmount;
	private String gstPercent;
	private String totalAmount;
	private String mcUser;
	private String contactPersonName;
	private String legCompName;
	private String eeUser;
	private String referenceFile;
	private String referenceDate;
	private String remarks;
	private String receiptDate;
	private String loginName;
	private String availability;
	private Date createdDate;
	
	public String getReferenceFile() {
		return referenceFile;
	}
	public void setReferenceFile(String referenceFile) {
		this.referenceFile = referenceFile;
	}
	public String getReferenceDate() {
		return referenceDate;
	}
	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}
	public String getGstAmount() {
		return gstAmount;
	}
	public void setGstAmount(String gstAmount) {
		this.gstAmount = gstAmount;
	}
	public String getGstPercent() {
		return gstPercent;
	}
	public void setGstPercent(String gstPercent) {
		this.gstPercent = gstPercent;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentDesc() {
		return paymentDesc;
	}
	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc = paymentDesc;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}
	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}
	public String getPaymentTypeId() {
		return paymentTypeId;
	}
	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getCompanyPaymentDtlID() {
		return companyPaymentDtlID;
	}
	public void setCompanyPaymentDtlID(String companyPaymentDtlID) {
		this.companyPaymentDtlID = companyPaymentDtlID;
	}
	public String getInspectedDate() {
		return inspectedDate;
	}
	public void setInspectedDate(String inspectedDate) {
		this.inspectedDate = inspectedDate;
	}
	public String getMcUser() {
		return mcUser;
	}
	public void setMcUser(String mcUser) {
		this.mcUser = mcUser;
	}
	public String getLegCompName() {
		return legCompName;
	}
	public void setLegCompName(String legCompName) {
		this.legCompName = legCompName;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}
	public String getEeUser() {
		return eeUser;
	}
	public void setEeUser(String eeUser) {
		this.eeUser = eeUser;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public int compareTo(PaymentFormBean o) {
		int c = o.getEeUser().compareTo(this.getEeUser());
		if(c==0)
		 c = o.getCreatedDate().compareTo(this.getCreatedDate());
		return c;
	}
	
	
}
