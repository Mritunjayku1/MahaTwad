package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CompanyDtl")
public class CompanyDtl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "sequence_app_id", strategy = "com.water.daoImpl.ApplicationIdGenerator")
	@GeneratedValue(generator = "sequence_app_id")
	@Column(name = "APP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private String appId;

	@Column(name = "LEG_COMP_NAME", length = 100)
	private String legCompName;

	@Column(name = "C_DOOR_NO", length = 100)
	private String cdoorNo;
	@Column(name = "C_PLOT_NO", nullable = true, length = 100)
	private String cplotNo;
	@Column(name = "C_STREET_NAME", nullable = true, length = 100)
	private String cstreetName;
	@Column(name = "C_LOCATION", nullable = true, length = 100)
	private String clocation;
	@Column(name = "C_PIN_CODE", nullable = false, length = 100)
	private String cpinCode;

	@Column(name = "SALUTATION", length = 100)
	private String salutation;

	@Column(name = "CON_PERSON_NAME", length = 100)
	private String contactPersonName;

	@Column(name = "MOBILE_NUMBER", precision = 15, scale = 0)
	private Long mobileNum;

	@Column(name = "LANDLINE_NUMBER", precision = 15, scale = 0)
	private Long landLineNo;

	@Column(name = "EMAIL_ADDR", length = 254)
	private String emailAddr;

	@ManyToOne(targetEntity = MasterCategory.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID")
	private MasterCategory categoryType;
	
	@ManyToOne(targetEntity = MasterOffice.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "OFFICE_ID")
	private MasterOffice office;
	
	@ManyToOne(targetEntity = MasterRegion.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "REGION_ID")
	private MasterRegion region;
	
	@ManyToOne(targetEntity = MasterCircle.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CIRCLE_ID")
	private MasterCircle circle;
	
	@ManyToOne(targetEntity = MasterHODivision.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DIVISION_ID")
	private MasterHODivision division;
	
	
	
	@Column(name = "MANAGEMENT_COMMENTS", nullable = true, length = 100)
	private String managementComments;

	@Column(name = "ADDR_PREM_SOUGHT", length = 100)
	private String addrPremSought;

	@Column(name = "DOOR_NO", length = 100)
	private String doorNo;
	@Column(name = "PLOT_NO", nullable = true, length = 100)
	private String plotNo;
	@Column(name = "STREET_NAME", nullable = true, length = 100)
	private String streetName;
	@Column(name = "LOCATION", nullable = true, length = 100)
	private String location;
	
	@ManyToOne(targetEntity = MasterDistrict.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DISTRICT_ID")
	private MasterDistrict district;
	
	@ManyToOne(targetEntity = MasterTaluk.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "TALUK_ID")
	private MasterTaluk taluk;
	
	@ManyToOne(targetEntity = MasterVillage.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "VILLAGE_ID")
	private MasterVillage village;
	@Column(name = "PINCODE", nullable = false, length = 100)
	private String pinCode;
	@Column(name = "SURVEY_FIELDNO", nullable = true, length = 100)
	private String surveyFieldNo;

	@Column(name = "IS_NEW_CONNECTION", nullable = false, length = 100)
	private Integer isNewConnection;

	@Column(name = "REQ_KLD", nullable = false, length = 100)
	private String reqMld;
	
	@Column(name = "APPLICATION_FEE", nullable = false, length = 100)
	private Integer applicationFee;
	@Column(name = "GST_PERCENT", nullable = true, length = 100)
	private Integer gstPercent=0;
	
	@Column(name = "GST_AMOUNT", nullable = false, length = 100)
	private String gstAmount;
	
	@Column(name = "TOTAL_AMOUNT", nullable = false, length = 100)
	private String totalAmount;

	@Column(name = "INTR_PLUM_STATUS", nullable = true, length = 100)
	private Integer intrPlumStatus;

	@Column(name = "WORK_TYPE", nullable = false, length = 100)
	private Integer workType;

	@Column(name = "UPLOAD_SITE_PLAN", nullable = true, length = 100)
	private String uploadSitePlan;
	@Column(name = "UPLOAD_SUMP_DRAWING", nullable = true, length = 100)
	private String uploadSumpDrawing;
	@Column(name = "UPLOAD_OWNERSHIP", nullable = true, length = 100)
	private String uploadOwnerShip;

	@Column(name = "FROM_WEBSITE", nullable = false, length = 100)
	private String fromWebSite;

	@JoinColumn(name = "USERID")
	private EmployeeDetails userId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "SMS_ID")
	private SmsTemp SmsId;

	@Column(name = "APPLICATION_STATUS", nullable = false, length = 100)
	private Integer applicationStatus=0;
	
	@Column(name = "PAYMENT_STATUS", nullable = false, length = 100)
	private Integer paymentStatus=0;
	
	@Column(name = "ACTIVE", nullable = false, length = 100)
	private Integer active=1;

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSPECTION_DATE", nullable = true, length = 26)
	private String inspectionDate;
	
	@Column(name = "STATUS_FLAG", length = 1)
	private Character statusFlag;

	@ManyToOne(targetEntity = MasterStatus.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "EE_STATUS")
	private MasterStatus eeStatus;

	@ManyToOne(targetEntity = MasterStatus.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CE_STATUS")
	private MasterStatus ceStatus;

	@ManyToOne(targetEntity = MasterStatus.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "MC_STATUS")
	private MasterStatus mcStatus;

	@Column(name = "INS_STATUS_ID", length = 1)
	private Integer insStatusId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMPLETION_DATE", nullable = true, length = 26)
	private Date completionDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMISSION_DATE", nullable = true, length = 26)
	private Date commissionDate;

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TENTATIVE_DATE", nullable = true, length = 26)
	private String tentativeDate;

	@Column(name = "CAF_ID", length = 100)
	private String cafId;
	
	@Column(name = "EE_RECEIPT_DATE", nullable = true, length = 26)
	private String eeReceiptDate;
	@Column(name = "EE_INSPECTION_DATE", nullable = true, length = 26)
	private String eeInspectionDate;
	@Column(name = "EE_REFERENCE_File", nullable = true, length = 26)
	private String eeReferenceFile;
	@Column(name = "EE_REFERENCE_DATE", nullable = true, length = 26)
	private String eeReferenceDate;
	
	@Column(name = "EE_UPFRONT_RECEIPT_DATE", nullable = true, length = 26)
	private String eeUpfrontReceiptDate;
	@Column(name = "EE_UPFRONT_INSPECTION_DATE", nullable = true, length = 26)
	private String eeUpfrontInspectionDate;
	@Column(name = "EE_UPFRONT_REFERENCE_File", nullable = true, length = 26)
	private String eeUpfrontReferenceFile;
	@Column(name = "EE_UPFRONT_REFERENCE_DATE", nullable = true, length = 26)
	private String eeUpfrontReferenceDate;
	
	@Column(name = "MC_RECEIPT_DATE", nullable = true, length = 26)
	private String mcReceiptDate;
	@Column(name = "MC_REFERENCE_File", nullable = true, length = 26)
	private String mcReferenceFile;
	@Column(name = "MC_REFERENCE_DATE", nullable = true, length = 26)
	private String mcReferenceDate;
	@Column(name = "MC_REMARKS", nullable = true, length = 26)
	private String mcRemarks;
	
	@Column(name = "MC_SLTC_RECEIPT_DATE", nullable = true, length = 26)
	private String mcSLTCReceiptDate;
	@Column(name = "MC_SLTC_REFERENCE_File", nullable = true, length = 26)
	private String mcSLTCReferenceFile;
	@Column(name = "MC_SLTC_REFERENCE_DATE", nullable = true, length = 26)
	private String mcSLTCReferenceDate;
	@Column(name = "MC_SLTC_REMARKS", nullable = true, length = 26)
	private String mcSLTCRemarks;
	
	@Column(name = "MC_BOARD_RECEIPT_DATE", nullable = true, length = 26)
	private String mcBoardReceiptDate;
	@Column(name = "MC_BOARD_REFERENCE_File", nullable = true, length = 26)
	private String mcBoardReferenceFile;
	@Column(name = "MC_BOARD_REFERENCE_DATE", nullable = true, length = 26)
	private String mcBoardReferenceDate;
	@Column(name = "MC_BOARD_REMARKS", nullable = true, length = 26)
	private String mcBoardRemarks;
	
	
	@Column(name = "MC_USER",nullable = true, length = 100)
	private String mcUser;
	
	@Column(name = "MC_SLTC_USER",nullable = true, length = 100)
	private String mcSLTCUser;
	@Column(name = "MC_BOARD_USER",nullable = true, length = 100)
	private String mcBoardUser;
	
	@Column(name = "UPFRONT_CHARGES", nullable = true,length = 100)
	private Integer upfrontCharges;
	
	@Column(name = "LOCALBODY",nullable = true, length = 100)
	private String localBody;
	
	
	@Column(name = "AVAILABILITY",nullable = true, length = 100)
	private String availability;
	
	
	
	@ManyToOne(targetEntity = MasterScheme.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "SCHEME_ID")
	private MasterScheme scheme;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TS", nullable = false, length = 26)
	private Date createTs;

	
	@Column(name = "CREATE_USERID", nullable = false, length = 30)
	private String createUserId;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TS", nullable = true, length = 26)
	private Date updateTs;

	
	@Column(name = "UPDATE_USERID", nullable = true, length = 30)
	private String updateUserId;


	public String getAppId() {
		return appId;
	}


	public void setAppId(String appId) {
		this.appId = appId;
	}


	public String getLegCompName() {
		return legCompName;
	}


	public void setLegCompName(String legCompName) {
		this.legCompName = legCompName;
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


	public String getContactPersonName() {
		return contactPersonName;
	}


	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
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


	public MasterCategory getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(MasterCategory categoryType) {
		this.categoryType = categoryType;
	}


	public MasterOffice getOffice() {
		return office;
	}


	public void setOffice(MasterOffice office) {
		this.office = office;
	}


	public String getManagementComments() {
		return managementComments;
	}


	public void setManagementComments(String managementComments) {
		this.managementComments = managementComments;
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


	public MasterDistrict getDistrict() {
		return district;
	}


	public void setDistrict(MasterDistrict district) {
		this.district = district;
	}


	public MasterTaluk getTaluk() {
		return taluk;
	}


	public void setTaluk(MasterTaluk taluk) {
		this.taluk = taluk;
	}


	public MasterVillage getVillage() {
		return village;
	}


	public void setVillage(MasterVillage village) {
		this.village = village;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
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


	public String getUploadSitePlan() {
		return uploadSitePlan;
	}


	public void setUploadSitePlan(String uploadSitePlan) {
		this.uploadSitePlan = uploadSitePlan;
	}


	public String getUploadSumpDrawing() {
		return uploadSumpDrawing;
	}


	public void setUploadSumpDrawing(String uploadSumpDrawing) {
		this.uploadSumpDrawing = uploadSumpDrawing;
	}


	public String getUploadOwnerShip() {
		return uploadOwnerShip;
	}


	public void setUploadOwnerShip(String uploadOwnerShip) {
		this.uploadOwnerShip = uploadOwnerShip;
	}


	public String getFromWebSite() {
		return fromWebSite;
	}


	public void setFromWebSite(String fromWebSite) {
		this.fromWebSite = fromWebSite;
	}


	public EmployeeDetails getUserId() {
		return userId;
	}


	public void setUserId(EmployeeDetails userId) {
		this.userId = userId;
	}


	public SmsTemp getSmsId() {
		return SmsId;
	}


	public void setSmsId(SmsTemp smsId) {
		SmsId = smsId;
	}


	public Integer getApplicationStatus() {
		return applicationStatus;
	}


	public void setApplicationStatus(Integer applicationStatus) {
		this.applicationStatus = applicationStatus;
	}


	public Integer getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public Integer getActive() {
		return active;
	}


	public void setActive(Integer active) {
		this.active = active;
	}


	public String getInspectionDate() {
		return inspectionDate;
	}


	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}


	public Character getStatusFlag() {
		return statusFlag;
	}


	public void setStatusFlag(Character statusFlag) {
		this.statusFlag = statusFlag;
	}


	public MasterStatus getEeStatus() {
		return eeStatus;
	}


	public void setEeStatus(MasterStatus eeStatus) {
		this.eeStatus = eeStatus;
	}


	public MasterStatus getCeStatus() {
		return ceStatus;
	}


	public void setCeStatus(MasterStatus ceStatus) {
		this.ceStatus = ceStatus;
	}


	public MasterStatus getMcStatus() {
		return mcStatus;
	}


	public void setMcStatus(MasterStatus mcStatus) {
		this.mcStatus = mcStatus;
	}


	public Integer getInsStatusId() {
		return insStatusId;
	}


	public void setInsStatusId(Integer insStatusId) {
		this.insStatusId = insStatusId;
	}


	public Date getCompletionDate() {
		return completionDate;
	}


	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}


	public Date getCommissionDate() {
		return commissionDate;
	}


	public void setCommissionDate(Date commissionDate) {
		this.commissionDate = commissionDate;
	}


	public String getTentativeDate() {
		return tentativeDate;
	}


	public void setTentativeDate(String tentativeDate) {
		this.tentativeDate = tentativeDate;
	}


	public String getCafId() {
		return cafId;
	}


	public void setCafId(String cafId) {
		this.cafId = cafId;
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


	public Date getCreateTs() {
		return createTs;
	}


	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}


	public String getCreateUserId() {
		return createUserId;
	}


	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}


	public Date getUpdateTs() {
		return updateTs;
	}


	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}


	public String getUpdateUserId() {
		return updateUserId;
	}


	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getGstPercent() {
		return gstPercent;
	}


	public void setGstPercent(Integer gstPercent) {
		this.gstPercent = gstPercent;
	}


	public Integer getApplicationFee() {
		return applicationFee;
	}


	public void setApplicationFee(Integer applicationFee) {
		this.applicationFee = applicationFee;
	}


	public String getEeReferenceFile() {
		return eeReferenceFile;
	}


	public void setEeReferenceFile(String eeReferenceFile) {
		this.eeReferenceFile = eeReferenceFile;
	}


	public String getEeReferenceDate() {
		return eeReferenceDate;
	}


	public void setEeReferenceDate(String eeReferenceDate) {
		this.eeReferenceDate = eeReferenceDate;
	}


	public String getMcReferenceFile() {
		return mcReferenceFile;
	}


	public void setMcReferenceFile(String mcReferenceFile) {
		this.mcReferenceFile = mcReferenceFile;
	}


	public String getMcReferenceDate() {
		return mcReferenceDate;
	}


	public void setMcReferenceDate(String mcReferenceDate) {
		this.mcReferenceDate = mcReferenceDate;
	}


	public String getEeInspectionDate() {
		return eeInspectionDate;
	}


	public void setEeInspectionDate(String eeInspectionDate) {
		this.eeInspectionDate = eeInspectionDate;
	}


	public String getEeUpfrontInspectionDate() {
		return eeUpfrontInspectionDate;
	}


	public void setEeUpfrontInspectionDate(String eeUpfrontInspectionDate) {
		this.eeUpfrontInspectionDate = eeUpfrontInspectionDate;
	}


	public String getEeUpfrontReferenceFile() {
		return eeUpfrontReferenceFile;
	}


	public void setEeUpfrontReferenceFile(String eeUpfrontReferenceFile) {
		this.eeUpfrontReferenceFile = eeUpfrontReferenceFile;
	}


	public String getEeUpfrontReferenceDate() {
		return eeUpfrontReferenceDate;
	}


	public void setEeUpfrontReferenceDate(String eeUpfrontReferenceDate) {
		this.eeUpfrontReferenceDate = eeUpfrontReferenceDate;
	}


	public String getEeReceiptDate() {
		return eeReceiptDate;
	}


	public void setEeReceiptDate(String eeReceiptDate) {
		this.eeReceiptDate = eeReceiptDate;
	}


	public String getEeUpfrontReceiptDate() {
		return eeUpfrontReceiptDate;
	}


	public void setEeUpfrontReceiptDate(String eeUpfrontReceiptDate) {
		this.eeUpfrontReceiptDate = eeUpfrontReceiptDate;
	}


	public String getMcReceiptDate() {
		return mcReceiptDate;
	}


	public void setMcReceiptDate(String mcReceiptDate) {
		this.mcReceiptDate = mcReceiptDate;
	}


	public String getMcRemarks() {
		return mcRemarks;
	}


	public void setMcRemarks(String mcRemarks) {
		this.mcRemarks = mcRemarks;
	}


	public MasterRegion getRegion() {
		return region;
	}


	public void setRegion(MasterRegion region) {
		this.region = region;
	}


	public MasterCircle getCircle() {
		return circle;
	}


	public void setCircle(MasterCircle circle) {
		this.circle = circle;
	}


	public MasterHODivision getDivision() {
		return division;
	}


	public void setDivision(MasterHODivision division) {
		this.division = division;
	}


	public String getMcSLTCReceiptDate() {
		return mcSLTCReceiptDate;
	}


	public void setMcSLTCReceiptDate(String mcSLTCReceiptDate) {
		this.mcSLTCReceiptDate = mcSLTCReceiptDate;
	}


	public String getMcSLTCReferenceFile() {
		return mcSLTCReferenceFile;
	}


	public void setMcSLTCReferenceFile(String mcSLTCReferenceFile) {
		this.mcSLTCReferenceFile = mcSLTCReferenceFile;
	}


	public String getMcSLTCReferenceDate() {
		return mcSLTCReferenceDate;
	}


	public void setMcSLTCReferenceDate(String mcSLTCReferenceDate) {
		this.mcSLTCReferenceDate = mcSLTCReferenceDate;
	}


	public String getMcSLTCRemarks() {
		return mcSLTCRemarks;
	}


	public void setMcSLTCRemarks(String mcSLTCRemarks) {
		this.mcSLTCRemarks = mcSLTCRemarks;
	}


	public String getMcBoardReceiptDate() {
		return mcBoardReceiptDate;
	}


	public void setMcBoardReceiptDate(String mcBoardReceiptDate) {
		this.mcBoardReceiptDate = mcBoardReceiptDate;
	}


	public String getMcBoardReferenceFile() {
		return mcBoardReferenceFile;
	}


	public void setMcBoardReferenceFile(String mcBoardReferenceFile) {
		this.mcBoardReferenceFile = mcBoardReferenceFile;
	}


	public String getMcBoardReferenceDate() {
		return mcBoardReferenceDate;
	}


	public void setMcBoardReferenceDate(String mcBoardReferenceDate) {
		this.mcBoardReferenceDate = mcBoardReferenceDate;
	}


	public String getMcBoardRemarks() {
		return mcBoardRemarks;
	}


	public void setMcBoardRemarks(String mcBoardRemarks) {
		this.mcBoardRemarks = mcBoardRemarks;
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


	public MasterScheme getScheme() {
		return scheme;
	}


	public void setScheme(MasterScheme scheme) {
		this.scheme = scheme;
	}


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


	

	
}
