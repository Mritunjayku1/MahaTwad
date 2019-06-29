package com.water.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "APP")
public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "sequence_app_id", strategy = "com.water.daoImpl.ApplicationIdGenerator")
	@GeneratedValue(generator = "sequence_app_id")
	@Column(name = "APP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private String appId;

	@Column(name = "SALUTATION", length = 100)
	private String salutation;
	@Column(name = "CON_PERSON_NAME", length = 100)
	private String contactPersonName;

	@Column(name = "LEG_COMP_NAME", length = 100)
	private String legCompName;

	@Column(name = "MOBILE_NUMBER", precision = 15, scale = 0)
	private Long mobileNum;

	@Column(name = "LANDLINE_NUMBER", precision = 15, scale = 0)
	private Long landLineNo;
	
	@Column(name = "EMAIL_ADDR", length = 254)
	private String emailAddr;
	@Column(name = "WEB_ADDR", length = 254)
	private String webAddress;
	
	@Column(name = "C_DOOR_NO", length = 100)
	private String cdoorNo;
	@Column(name = "C_PLOT_NO",  nullable = true,length = 100)
	private String cplotNo;
	@Column(name = "C_STREET_NAME", nullable = true, length = 100)
	private String cstreetName;
	@Column(name = "C_LOCATION", nullable = true, length = 100)
	private String clocation;
	@Column(name = "C_PIN_CODE", nullable = false, length = 100)
	private String cpinCode;

	@ManyToOne(targetEntity = MasterCategory.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID")
	private MasterCategory categoryType;

	@Column(name = "ADDR_PREM_SOUGHT", length = 100)
	private String addrPremSought;
	
	@Column(name = "DOOR_NO", length = 100)
	private String doorNo;
	@Column(name = "PLOT_NO",  nullable = true,length = 100)
	private String plotNo;
	@Column(name = "STREET_NAME", nullable = true, length = 100)
	private String streetName;
	@Column(name = "LOCATION", nullable = true, length = 100)
	private String location;
	@Column(name = "PIN_CODE", nullable = false, length = 100)
	private String pinCode;
	@Column(name = "BILL_NO_1", nullable = true, length = 100)
	private String billNo1;
	@Column(name = "BILL_NO_2", nullable = true, length = 100)
	private String billNo2;
	
	@Column(name = "DD_DATE",nullable = true, length = 100)
	private String ddDate;
	@Column(name = "DD_BANK_NAME",nullable = true, length = 100)
	private String ddBankName;
	@Column(name = "DD_BANK_BRANCH",nullable = true, length = 100)
	private String ddBankBranch;
	@Column(name = "INITIAL_PAYMENT",nullable = true, length = 100)
	private String initialPayment;
	
	
	@Column(name = "IS_EXIST_CONNECTION_ALTERATION", nullable = true, length = 100)
	private Integer isExistConnectionForAlteration;
	
	@Column(name = "IS_NEW_CONNECTION", nullable = false, length = 100)
	private Integer isNewConnection;

	@Column(name = "IS_RECON_SERVICE", nullable = true, length = 100)
	private Integer isReconnectionForService;

	@ManyToOne(targetEntity = MasterReconnection.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "RE_CONN_ID")
	private MasterReconnection reconnectionType;

	@Column(name = "REQ_MLD", nullable = false, length = 100)
	private String reqMld;

	@ManyToOne(targetEntity = MasterZone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Zone_ID", nullable = true)
	private MasterZone cmwssbZoneNum;

	
	@ManyToOne(targetEntity = MasterDivision.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DIVISION_ID", nullable = true)
	private MasterDivision divId;


	@Column(name = "ANN_ASSMT_VAL", nullable = true, length = 100)
	private Long annAssmtVal;

	

	@Column(name = "INTR_PLUM_STATUS", nullable = true, length = 100)
	private Integer intrPlumStatus;

	@Column(name = "WAT_SEV_PROP", nullable = true, length = 100)
	private Integer watSevProp;

	@Column(name = "WORK_TYPE", nullable = false, length = 100)
	private Integer workType;

	@Column(name = "PAYMENT_TYPE", nullable = true, length = 100)
	private Integer paymentType;

	@Column(name = "DD_NUM", nullable = true, length = 100)
	private Integer ddNum;

	


	@Column(name = "FROM_WEBSITE", nullable = false, length = 100)
	private String fromWebSite;

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


	@JoinColumn(name = "USERID")
	private EmployeeDetails userId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "SMS_ID")
	private SmsTemp SmsId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appId", cascade = CascadeType.ALL)
	private Set<Payment> payDtls;
	
	@Column(name = "REMARKS", nullable = true, length = 1000)
	private String remarks;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TS", nullable = false, length = 26)
	private Date createTs;

	@Column(name = "CREATE_USERID", nullable = true, length = 30)
	private String createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TS", nullable = true, length = 26)
	private Date updateTs;

	@Column(name = "UPDATE_USERID", nullable = true, length = 30)
	private String updateUserId;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSPECTION_DATE", nullable = true, length = 26)
	private String inspectionDate;
	
	@Column(name = "FIXED_PROCESSING_FEE", nullable = true, length = 100)
	private Integer fixedProcessFee;
	
	@Column(name = "PAID_PROCESSING_FEE", nullable = true, length = 100)
	private String paidProcessFee;
	
	@Column(name = "FIXED_FINAL_FEE", nullable = true, length = 100)
	private Integer fixedFinalFee;
	
	@Column(name = "PAID_FINAL_FEE", nullable = true, length = 100)
	private Integer paidfinalFee;
	
	@Column(name = "PAID_FINAL_STATUSID", nullable = true, length = 100)
	private Integer paidFinalStatusId;
	
	@Column(name = "PROCESSING_STATUSID", nullable = true, length = 100)
	private Integer processing_StatusId;
	
	@Column(name = "FINAL_STATUSID", nullable = true, length = 100)
	private Integer final_StatusId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMPLETION_DATE", nullable = true, length = 26)
	private Date completionDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMISSION_DATE", nullable = true, length = 26)
	private Date commissionDate;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TENTATIVE_DATE", nullable = true, length = 26)
	private String tentativeDate;
	
	@Column(name = "CAF_ID", length = 100)
	private String	cafId;
	@Column(name = "PAYMENT_AMOUNT", nullable = true, length = 100)
	private Integer paymentAmount;
	
	@Column(name = "GST_AMOUNT", nullable = true, length = 100)
	private Integer gstAmount;
	
	@Column(name = "TOTAL_AMOUNT", nullable = true, length = 100)
	private Integer totalAmount;
	
	
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
	public String getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}
	

	public void setTentativeDate(String tentativeDate) {
		this.tentativeDate = tentativeDate;
	}

	public Integer getFixedProcessFee() {
		return fixedProcessFee;
	}

	public void setFixedProcessFee(Integer fixedProcessFee) {
		this.fixedProcessFee = fixedProcessFee;
	}

	public String getPaidProcessFee() {
		return paidProcessFee;
	}

	public void setPaidProcessFee(String paidProcessFee) {
		this.paidProcessFee = paidProcessFee;
	}

	public Integer getFixedFinalFee() {
		return fixedFinalFee;
	}

	public void setFixedFinalFee(Integer fixedFinalFee) {
		this.fixedFinalFee = fixedFinalFee;
	}

	public Integer getPaidfinalFee() {
		return paidfinalFee;
	}

	public void setPaidfinalFee(Integer paidfinalFee) {
		this.paidfinalFee = paidfinalFee;
	}

	public Integer getPaidFinalStatusId() {
		return paidFinalStatusId;
	}

	public void setPaidFinalStatusId(Integer paidFinalStatusId) {
		this.paidFinalStatusId = paidFinalStatusId;
	}

	public Integer getProcessing_StatusId() {
		return processing_StatusId;
	}

	public void setProcessing_StatusId(Integer processing_StatusId) {
		this.processing_StatusId = processing_StatusId;
	}

	public Integer getFinal_StatusId() {
		return final_StatusId;
	}

	public void setFinal_StatusId(Integer final_StatusId) {
		this.final_StatusId = final_StatusId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	

	public MasterCategory getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(MasterCategory categoryType) {
		this.categoryType = categoryType;
	}

	public String getAddrPremSought() {
		return addrPremSought;
	}

	public void setAddrPremSought(String addrPremSought) {
		this.addrPremSought = addrPremSought;
	}

	public Integer getIsExistConnectionForAlteration() {
		return isExistConnectionForAlteration;
	}

	public void setIsExistConnectionForAlteration(
			Integer isExistConnectionForAlteration) {
		this.isExistConnectionForAlteration = isExistConnectionForAlteration;
	}

	public Integer getIsReconnectionForService() {
		return isReconnectionForService;
	}

	public void setIsReconnectionForService(Integer isReconnectionForService) {
		this.isReconnectionForService = isReconnectionForService;
	}

	public MasterReconnection getReconnectionType() {
		return reconnectionType;
	}

	public void setReconnectionType(MasterReconnection reconnectionType) {
		this.reconnectionType = reconnectionType;
	}

	

	public MasterZone getCmwssbZoneNum() {
		return cmwssbZoneNum;
	}

	public void setCmwssbZoneNum(MasterZone cmwssbZoneNum) {
		this.cmwssbZoneNum = cmwssbZoneNum;
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

	public String getFromWebSite() {
		return fromWebSite;
	}

	public void setFromWebSite(String fromWebSite) {
		this.fromWebSite = fromWebSite;
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

	public EmployeeDetails getUserId() {
		return userId;
	}

	public void setUserId(EmployeeDetails userId) {
		this.userId = userId;
	}

	public Set<Payment> getPayDtls() {
		return payDtls;
	}

	public void setPayDtls(Set<Payment> payDtls) {
		this.payDtls = payDtls;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SmsTemp getSmsId() {
		return SmsId;
	}

	public void setSmsId(SmsTemp smsId) {
		SmsId = smsId;
	}

	/**
	 * @return the doorNo
	 */
	public String getDoorNo() {
		return doorNo;
	}

	/**
	 * @param doorNo the doorNo to set
	 */
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
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

	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Long getLandLineNo() {
		return landLineNo;
	}

	public void setLandLineNo(Long landLineNo) {
		this.landLineNo = landLineNo;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
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

	public Integer getIsNewConnection() {
		return isNewConnection;
	}

	public void setIsNewConnection(Integer isNewConnection) {
		this.isNewConnection = isNewConnection;
	}

	

	public MasterDivision getDivId() {
		return divId;
	}

	public void setDivId(MasterDivision divId) {
		this.divId = divId;
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

	public String getReqMld() {
		return reqMld;
	}

	public void setReqMld(String reqMld) {
		this.reqMld = reqMld;
	}

	public String getCafId() {
		return cafId;
	}

	public void setCafId(String cafId) {
		this.cafId = cafId;
	}

	public Integer getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(Integer gstAmount) {
		this.gstAmount = gstAmount;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Integer paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	
	

	
}
