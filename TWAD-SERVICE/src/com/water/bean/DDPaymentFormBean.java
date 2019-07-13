package com.water.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DDPaymentFormBean {

	
	private String appId;
	private String paymentType;
	private String paymentAmount;
	private String managementComments;
	private Character paymentStatusFlag;
	private String ddNo;
	private String ddDate;
	private String ddBankName;
	private String ddBankBranch;
	private String contactPersonName;
	private String legCompName;
	private Date createTs;
	private Integer companyPaymentDtlID;
	private String cdoorNo;
	private String cplotNo;
	private String cstreetName;
	private String clocation;
	private String cpinCode;
	private String salutation;
	private Long mobileNum;
	private Long landLineNo;
	private String emailAddr;
	private String categoryType;
	private Integer regionId;
	private String regionName;
	private Integer circleId;
	private String circleName;
	private Integer divisionId;
	private String divisionName;
	private String addrPremSought;
	private String doorNo;
	private String plotNo;
	private String streetName;
	private String location;
	private String district;
	private String taluk;
	private String village;
	private String pinCode;
	private String surveyFieldNo;
	private String reqMld;
	private String applicationFee;
	private String gstPercent;
	private String gstAmount;
	private String totalAmount;
	private Integer isNewConnection=0;
	private Integer intrPlumStatus=0;
	private Integer workType=0;
	private Integer paymentStatus=0;
	private Integer upfrontCharges=0;
	private Integer fullPayment=0;
	private String mcUser;
	private String mcSLTCUser;
	private String mcBoardUser;
	
	private String isNewConnectionDisplay;
	private String intrPlumStatusDisplay;
	private String workTypeDisplay;
	private String paymentStatusDisplay;
	private String createDate;
	
	
	 private String localBody;
     private String availability;
     private String scheme;
     private String transactionRefNo;
 	 private String bankRefNo;
 	 
 	 
 	 private List<PaymentFormBean> processDtlList;
 	private Map<String,PaymentFormBean> processMap;
 	
	public String getMcSLTCUser() {
		return mcSLTCUser;
	}
	public void setMcSLTCUser(String mcSLTCUser) {
		this.mcSLTCUser = mcSLTCUser;
	}
	public String getMcBoardUser() {
		return mcBoardUser;
	}
	public void setMcBoardUser(String mcBoardUser) {
		this.mcBoardUser = mcBoardUser;
	}
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
	private List<DDPaymentFormBean> paymentList;
	
	private String region;
	private String circle;
	private String division;
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getIsNewConnectionDisplay() {
		return isNewConnectionDisplay;
	}
	public void setIsNewConnectionDisplay(String isNewConnectionDisplay) {
		this.isNewConnectionDisplay = isNewConnectionDisplay;
	}
	public String getIntrPlumStatusDisplay() {
		return intrPlumStatusDisplay;
	}
	public void setIntrPlumStatusDisplay(String intrPlumStatusDisplay) {
		this.intrPlumStatusDisplay = intrPlumStatusDisplay;
	}
	public String getWorkTypeDisplay() {
		return workTypeDisplay;
	}
	public void setWorkTypeDisplay(String workTypeDisplay) {
		this.workTypeDisplay = workTypeDisplay;
	}
	public String getPaymentStatusDisplay() {
		return paymentStatusDisplay;
	}
	public void setPaymentStatusDisplay(String paymentStatusDisplay) {
		this.paymentStatusDisplay = paymentStatusDisplay;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
	public Long getLandLineNo() {
		return landLineNo;
	}
	public void setLandLineNo(Long landLineNo) {
		this.landLineNo = landLineNo;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getAddrPremSought() {
		return addrPremSought;
	}
	public void setAddrPremSought(String addrPremSought) {
		this.addrPremSought = addrPremSought;
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
	public String getPinCode() {
		return pinCode;
	}
	public void setPincode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getSurveyFieldNo() {
		return surveyFieldNo;
	}
	public void setSurveyFieldNo(String surveyFieldNo) {
		this.surveyFieldNo = surveyFieldNo;
	}
	public Integer getIsNewConnection() {
		return isNewConnection;
	}
	public void setIsNewConnection(Integer isNewConnection) {
		this.isNewConnection = isNewConnection;
	}
	public String getReqMld() {
		return reqMld;
	}
	public void setReqMld(String reqMld) {
		this.reqMld = reqMld;
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
	public Integer getIntrPlumStatus() {
		return intrPlumStatus;
	}
	public void setIntrPlumStatus(Integer intrPlumStatus) {
		this.intrPlumStatus = intrPlumStatus;
	}
	public Integer getWorkType() {
		return workType;
	}
	public void setWorkType(Integer workType) {
		this.workType = workType;
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
	public Date getCreateTs() {
		return createTs;
	}
	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getManagementComments() {
		return managementComments;
	}
	public void setManagementComments(String managementComments) {
		this.managementComments = managementComments;
	}
	public Character getPaymentStatusFlag() {
		return paymentStatusFlag;
	}
	public void setPaymentStatusFlag(Character paymentStatusFlag) {
		this.paymentStatusFlag = paymentStatusFlag;
	}
	public String getDdNo() {
		return ddNo;
	}
	public void setDdNo(String ddNo) {
		this.ddNo = ddNo;
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
	public String getDdBankBranch() {
		return ddBankBranch;
	}
	public void setDdBankBranch(String ddBankBranch) {
		this.ddBankBranch = ddBankBranch;
	}
	public Integer getCompanyPaymentDtlID() {
		return companyPaymentDtlID;
	}
	public void setCompanyPaymentDtlID(Integer companyPaymentDtlID) {
		this.companyPaymentDtlID = companyPaymentDtlID;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		if(paymentStatus==0){
			this.paymentStatusDisplay = "Pending";
		}
		else{
			this.paymentStatusDisplay = "Paid";
		}
		this.paymentStatus = paymentStatus;
	}
	public String getGstPercent() {
		return gstPercent;
	}
	public void setGstPercent(String gstPercent) {
		this.gstPercent = gstPercent;
	}
	public String getMcUser() {
		return mcUser;
	}
	public void setMcUser(String mcUser) {
		this.mcUser = mcUser;
	}
	public Integer getUpfrontCharges() {
		return upfrontCharges;
	}
	public void setUpfrontCharges(Integer upfrontCharges) {
		this.upfrontCharges = upfrontCharges;
	}
	public String getApplicationFee() {
		return applicationFee;
	}
	public void setApplicationFee(String applicationFee) {
		this.applicationFee = applicationFee;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public List<DDPaymentFormBean> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<DDPaymentFormBean> paymentList) {
		this.paymentList = paymentList;
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
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getCircleId() {
		return circleId;
	}
	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public Integer getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}
	public Integer getFullPayment() {
		return fullPayment;
	}
	public void setFullPayment(Integer fullPayment) {
		this.fullPayment = fullPayment;
	}
	public List<PaymentFormBean> getProcessDtlList() {
		return processDtlList;
	}
	public void setProcessDtlList(List<PaymentFormBean> processDtlList) {
		this.processDtlList = processDtlList;
	}
	public Map<String,PaymentFormBean> getProcessMap() {
		return processMap;
	}
	public void setProcessMap(Map<String,PaymentFormBean> processMap) {
		this.processMap = processMap;
	}
	
}
