package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "TransMaster")
public class TransctionMaster implements Serializable {
	
	@Id
	@GenericGenerator(name = "sequence_app_id", strategy = "com.water.daoImpl.TransactionIdGenerator")
	@GeneratedValue(generator = "sequence_app_id")
	@Column(name = "TRNS_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private String transId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "APP_ID")
	private CompanyDtl appID;
	
	 @ManyToOne(optional = true)
	 @JoinColumn(name = "PAYMENT_TYPE_ID")
	 private MasterPaymentType paymentType;

	@Column(name = "TOTAL_AMOUNT", length = 100,nullable = true)
	private String totalAmount;
	
	@Column(name = "TRANSACTION_REF_NO", length = 100,nullable = true)
	private String transactionRefNo;
	
	@Column(name = "BANK_REF_NO", length = 100,nullable = true)
	private String bankRefNo;
	
	@Column(name = "STATUS", nullable = true, length = 1000)
	private String status;
	@Column(name = "STATUS_FLAG", nullable = true, length = 1000)
	private String status_flag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TS", nullable = true, length = 26)
	private Date createTs;

	@Column(name = "CREATE_USERID", nullable = true, length = 30)
	private String createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TS", nullable = true, length = 26)
	private Date updateTs;

	@Column(name = "UPDATE_USERID", nullable = true, length = 30)
	private String updateUserId;

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public CompanyDtl getAppID() {
		return appID;
	}

	public void setAppID(CompanyDtl appID) {
		this.appID = appID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_flag() {
		return status_flag;
	}

	public void setStatus_flag(String status_flag) {
		this.status_flag = status_flag;
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

	public MasterPaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(MasterPaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
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
