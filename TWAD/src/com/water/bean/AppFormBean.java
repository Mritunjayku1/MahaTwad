package com.water.bean;

import java.io.File;

import javax.persistence.Column;

public class AppFormBean {
	
	private String contactPersonName;

	private String legCompName;
	private Long mobileNum;
	private String emailAddr;
	private String correspondenceAddr;
	private Integer categoryType;
	private String doorNo;
	private String plotNo;
	private String streetName;
	private String location;
	private String pinCode;
	private String ddDate;
	private String ddBankName;
	private String ddBranch;
	private Integer isExistConnectionForAlteration;
	private Integer isReconnectionForService;
	private Integer reconnectionType;
	private String reqMld;
	private Integer cmwssbZoneNum;
	private Integer divId;
	private Long annAssmtVal;
	private String billNo1;
	private String billNo2;
	private Integer intrPlumStatus;
	private Integer watSevProp;
	private Integer workType;
	private Integer paymentType;
	private Integer ddNum;
	private String appId ;
	private Integer smsId;
	private String initialPayment;
	private String paidfinalFee;
	private String cdoorNo;
	private String cplotNo;
	private String cstreetName;
	private String clocation;
	private String cpinCode;
	private String webAddress;
	private Integer isNewConnection;
	private Long landLineNo;
	private String salutation;
	private String paymentMode;
     private Character statusFlag;
     private String cafId;
     private String gstAmount;
     private String totalAmount;
 
     private String paymentAmount;
     
     private String surveyFieldNo;
     private String district;
     private String taluk;
     private String village;
     private String cost;
     private String gstPercent;
     private Integer upfrontCharges;
     private String localBody;
     private String availability;
     private String scheme;
     private String transactionRefNo;
 	 private String bankRefNo;
     
	public String getLocalBody() {
		return localBody;
	}
	public void setLocalBody(String localBody) {
		this.localBody = localBody;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getSurveyFieldNo() {
		return surveyFieldNo;
	}
	public void setSurveyFieldNo(String surveyFieldNo) {
		this.surveyFieldNo = surveyFieldNo;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Character getStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(Character statusFlag) {
		this.statusFlag = statusFlag;
	}
	
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getDdDate() {
		return ddDate;
	}
	public void setDdDate(String ddDate) {
		this.ddDate = ddDate;
	}
	public String getDdBankName() {
		return ddBankName;
	}
	public void setDdBankName(String ddBankName) {
		this.ddBankName = ddBankName;
	}
	public String getDdBranch() {
		return ddBranch;
	}
	public void setDdBranch(String ddBranch) {
		this.ddBranch = ddBranch;
	}
	public String getBillNo1() {
		return billNo1;
	}
	public void setBillNo1(String billNo1) {
		this.billNo1 = billNo1;
	}
	public String getBillNo2() {
		return billNo2;
	}
	public void setBillNo2(String billNo2) {
		this.billNo2 = billNo2;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getLegCompName() {
		return legCompName;
	}
	public void setLegCompName(String legCompName) {
		this.legCompName = legCompName;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getCorrespondenceAddr() {
		return correspondenceAddr;
	}
	public void setCorrespondenceAddr(String correspondenceAddr) {
		this.correspondenceAddr = correspondenceAddr;
	}
	public Integer getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
	
	public Integer getIsExistConnectionForAlteration() {
		return isExistConnectionForAlteration;
	}
	public void setIsExistConnectionForAlteration(Integer isExistConnectionForAlteration) {
		this.isExistConnectionForAlteration = isExistConnectionForAlteration;
	}
	public Integer getIsReconnectionForService() {
		return isReconnectionForService;
	}
	public void setIsReconnectionForService(Integer isReconnectionForService) {
		this.isReconnectionForService = isReconnectionForService;
	}
	public Integer getReconnectionType() {
		return reconnectionType;
	}
	public void setReconnectionType(Integer reconnectionType) {
		this.reconnectionType = reconnectionType;
	}
	
	public Integer getCmwssbZoneNum() {
		return cmwssbZoneNum;
	}
	public void setCmwssbZoneNum(Integer cmwssbZoneNum) {
		this.cmwssbZoneNum = cmwssbZoneNum;
	}
	public Integer getDivId() {
		return divId;
	}
	public void setDivId(Integer divId) {
		this.divId = divId;
	}
	public Long getAnnAssmtVal() {
		return annAssmtVal;
	}
	public void setAnnAssmtVal(Long annAssmtVal) {
		this.annAssmtVal = annAssmtVal;
	}
	
	public Integer getIntrPlumStatus() {
		return intrPlumStatus;
	}
	public void setIntrPlumStatus(Integer intrPlumStatus) {
		this.intrPlumStatus = intrPlumStatus;
	}
	public Integer getWatSevProp() {
		return watSevProp;
	}
	public void setWatSevProp(Integer watSevProp) {
		this.watSevProp = watSevProp;
	}
	public Integer getWorkType() {
		return workType;
	}
	public void setWorkType(Integer workType) {
		this.workType = workType;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getDdNum() {
		return ddNum;
	}
	public void setDdNum(Integer ddNum) {
		this.ddNum = ddNum;
	}
	public Integer getSmsId() {
		return smsId;
	}
	public void setSmsId(Integer smsId) {
		this.smsId = smsId;
	}
	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * @return the initialPayment
	 */
	public String getInitialPayment() {
		return initialPayment;
	}
	/**
	 * @param initialPayment the initialPayment to set
	 */
	public void setInitialPayment(String initialPayment) {
		this.initialPayment = initialPayment;
	}
	public String getCdoorNo() {
		return cdoorNo;
	}
	public void setCdoorNo(String cdoorNo) {
		this.cdoorNo = cdoorNo;
	}
	public String getCplotNo() {
		return cplotNo;
	}
	public void setCplotNo(String cplotNo) {
		this.cplotNo = cplotNo;
	}
	public String getCstreetName() {
		return cstreetName;
	}
	public void setCstreetName(String cstreetName) {
		this.cstreetName = cstreetName;
	}
	public String getClocation() {
		return clocation;
	}
	public void setClocation(String clocation) {
		this.clocation = clocation;
	}
	public String getCpinCode() {
		return cpinCode;
	}
	public void setCpinCode(String cpinCode) {
		this.cpinCode = cpinCode;
	}
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	public Integer getIsNewConnection() {
		return isNewConnection;
	}
	public void setIsNewConnection(Integer isNewConnection) {
		this.isNewConnection = isNewConnection;
	}
	public Long getLandLineNo() {
		return landLineNo;
	}
	public void setLandLineNo(Long landLineNo) {
		this.landLineNo = landLineNo;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	/**
	 * @return the reqMld
	 */
	public String getReqMld() {
		return reqMld;
	}
	public void setReqMld(String reqMld) {
		this.reqMld = reqMld;
	}
	public String getPaidfinalFee() {
		return paidfinalFee;
	}
	public void setPaidfinalFee(String paidfinalFee) {
		this.paidfinalFee = paidfinalFee;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getCafId() {
		return cafId;
	}
	public void setCafId(String cafId) {
		this.cafId = cafId;
	}
	public String getGstAmount() {
		return gstAmount;
	}
	public void setGstAmount(String gstAmount) {
		this.gstAmount = gstAmount;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getUpfrontCharges() {
		return upfrontCharges;
	}
	public void setUpfrontCharges(Integer upfrontCharges) {
		this.upfrontCharges = upfrontCharges;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getGstPercent() {
		return gstPercent;
	}
	public void setGstPercent(String gstPercent) {
		this.gstPercent = gstPercent;
	}
	public String getTransactionRefNo() {
		return transactionRefNo;
	}
	public void setTransactionRefNo(String transactionRefNo) {
		this.transactionRefNo = transactionRefNo;
	}
	public String getBankRefNo() {
		return bankRefNo;
	}
	public void setBankRefNo(String bankRefNo) {
		this.bankRefNo = bankRefNo;
	}

	
	
	
	

}
