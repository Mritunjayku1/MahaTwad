package com.water.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="PAYMENT")
public class Payment {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	

	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PAY_INFO_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer payInfoId;
	

	
	
	@Column(name = "TRNS_INFO_ID",  nullable = false, precision = 10, scale = 0)
	private Integer trsInfoId;
	

	
	
	@Column(name = "TRNS_NUMBER",  nullable = false, precision = 10, scale = 0)
	private Integer trsNumber;
	

	
	
	@Column(name = "PAY_TYPE",  nullable = false, precision = 10, scale = 0)
	private Integer payType;
	

	
	
	@Column(name = "PAYMT_GATWAY_NUM", nullable = false, precision = 10, scale = 0)
	private Integer paymtGatwayNum;
	

	
    @Column(name = "PAY_STATUS", length = 1)
	private Character payStatus;
	
	
    @Column(name = "STATUS_FLAG", length = 1)
	private Character statusFlag;

	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TS", nullable = false, length = 26)
	private Date createTs;

	
	@Column(name = "CREATE_USERID", nullable = false, length = 30)
	private String createUserId;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TS", nullable = false, length = 26)
	private Date updateTs;

	
	@Column(name = "UPDATE_USERID", nullable = false, length = 30)
	private String updateUserId;
	

	@ManyToOne(optional = false)
	@JoinColumn(name="APP_ID")
	private Application appId;


	public Integer getPayInfoId() {
		return payInfoId;
	}


	public void setPayInfoId(Integer payInfoId) {
		this.payInfoId = payInfoId;
	}


	public Integer getTrsInfoId() {
		return trsInfoId;
	}


	public void setTrsInfoId(Integer trsInfoId) {
		this.trsInfoId = trsInfoId;
	}


	public Integer getTrsNumber() {
		return trsNumber;
	}


	public void setTrsNumber(Integer trsNumber) {
		this.trsNumber = trsNumber;
	}


	public Integer getPayType() {
		return payType;
	}


	public void setPayType(Integer payType) {
		this.payType = payType;
	}


	public Integer getPaymtGatwayNum() {
		return paymtGatwayNum;
	}


	public void setPaymtGatwayNum(Integer paymtGatwayNum) {
		this.paymtGatwayNum = paymtGatwayNum;
	}


	public Character getPayStatus() {
		return payStatus;
	}


	public void setPayStatus(Character payStatus) {
		this.payStatus = payStatus;
	}


	public Character getStatusFlag() {
		return statusFlag;
	}


	public void setStatusFlag(Character statusFlag) {
		this.statusFlag = statusFlag;
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


	public Application getAppId() {
		return appId;
	}


	public void setAppId(Application appId) {
		this.appId = appId;
	}

	
	
	
}
