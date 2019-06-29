package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CompanyPaymentDtl")
public class CompanyPaymentDtl  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = " COMPANY_PAYMENTDTL_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer companyPaymentDtlID;
	
	@ManyToOne(targetEntity = CompanyDtl.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "APP_ID")
	private CompanyDtl appId;

	 @ManyToOne(optional = true)
	 @JoinColumn(name = "PAYMENT_TYPE_ID")
	 private MasterPaymentType paymentType;
	
	@Column(name = "LEG_COMP_NAME", length = 100)
	private String legCompName;
	
	@Column(name = "MOBILE_NUMBER", precision = 15, scale = 0)
	private Long mobileNum;

	@Column(name = "PAYMENT_AMOUNT", nullable = true, length = 100)
	private String paymentAmount;


	@Column(name = "TRANSACTION_REF_NO", length = 100,nullable = true)
	private String transactionRefNo;
	
	@Column(name = "BANK_REF_NO", length = 100,nullable = true)
	private String bankRefNo;
	
	
	
	@Column(name = "MANAGEMENT_COMMENTS", nullable = true, length = 100)
	private String managementComments;
	
	@Column(name = "PAYMENT_STATUS_FLAG", length = 1)
	private Character paymentStatusFlag='N';

	@Column(name = "DD_NO", nullable = true, length = 100)
	private String ddNo;
	
	@Column(name = "DD_DATE", nullable = true, length = 100)
	private String ddDate;
	@Column(name = "DD_BANK_NAME", nullable = true, length = 100)
	private String ddBankName;
	@Column(name = "DD_BANK_BRANCH", nullable = true, length = 100)
	private String ddBankBranch;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "SMS_ID")
	private SmsTemp SmsId;

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

	

	public CompanyDtl getAppId() {
		return appId;
	}

	public void setAppId(CompanyDtl appId) {
		this.appId = appId;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
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

	public Integer getCompanyPaymentDtlID() {
		return companyPaymentDtlID;
	}

	public void setCompanyPaymentDtlID(Integer companyPaymentDtlID) {
		this.companyPaymentDtlID = companyPaymentDtlID;
	}

	public String getManagementComments() {
		return managementComments;
	}

	public void setManagementComments(String managementComments) {
		this.managementComments = managementComments;
	}

	public String getDdNo() {
		return ddNo;
	}

	public void setDdNo(String ddNo) {
		this.ddNo = ddNo;
	}

	public SmsTemp getSmsId() {
		return SmsId;
	}

	public void setSmsId(SmsTemp smsId) {
		SmsId = smsId;
	}

	public Character getPaymentStatusFlag() {
		return paymentStatusFlag;
	}

	public void setPaymentStatusFlag(Character paymentStatusFlag) {
		this.paymentStatusFlag = paymentStatusFlag;
	}

	public MasterPaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(MasterPaymentType paymentType) {
		this.paymentType = paymentType;
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
