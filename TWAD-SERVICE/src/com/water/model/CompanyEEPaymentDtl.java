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
@Table(name = "CompanyEEPaymentDtl")
public class CompanyEEPaymentDtl  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = " COMPANY_EEPAYMENTDTL_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer companyEEPaymentDtlID;

	@ManyToOne(targetEntity = CompanyDtl.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "APP_ID")
	private String appId;

	@Column(name = "ESTIMATION_AMOUNT", nullable = true, length = 100)
	private Integer estimationAmount;

	@Column(name = "DPR_AMOUNT", nullable = true, length = 100)
	private String dprAmount;

	@Column(name = "MOU_AMOUNT", nullable = true, length = 100)
	private Integer mouAmount;

	@Column(name = "MOU_AMOUNT_GST", nullable = true, length = 100)
	private Integer mouAmountGst;

	@Column(name = "ESTIMATION_AMOUNT_GST", nullable = true, length = 100)
	private Integer estimationAmountGst;

	@Column(name = "DPR_AMOUNT_GST", nullable = true, length = 100)
	private Integer dprAmountGst;

	

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

	

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Integer getEstimationAmount() {
		return estimationAmount;
	}

	public void setEstimationAmount(Integer estimationAmount) {
		this.estimationAmount = estimationAmount;
	}

	public String getDprAmount() {
		return dprAmount;
	}

	public void setDprAmount(String dprAmount) {
		this.dprAmount = dprAmount;
	}

	public Integer getMouAmount() {
		return mouAmount;
	}

	public void setMouAmount(Integer mouAmount) {
		this.mouAmount = mouAmount;
	}

	public Integer getMouAmountGst() {
		return mouAmountGst;
	}

	public void setMouAmountGst(Integer mouAmountGst) {
		this.mouAmountGst = mouAmountGst;
	}

	public Integer getEstimationAmountGst() {
		return estimationAmountGst;
	}

	public void setEstimationAmountGst(Integer estimationAmountGst) {
		this.estimationAmountGst = estimationAmountGst;
	}

	public Integer getDprAmountGst() {
		return dprAmountGst;
	}

	public void setDprAmountGst(Integer dprAmountGst) {
		this.dprAmountGst = dprAmountGst;
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

	public Integer getCompanyEEPaymentDtlID() {
		return companyEEPaymentDtlID;
	}

	public void setCompanyEEPaymentDtlID(Integer companyEEPaymentDtlID) {
		this.companyEEPaymentDtlID = companyEEPaymentDtlID;
	}

}
