package com.water.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="MASTER_PAYMENT")
public class MasterPayment  implements Serializable {
	
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "sequence_payment_id", strategy = "com.water.daoImpl.PaymentIdGenerator")
	@GeneratedValue(generator = "sequence_payment_id")
	@Column(name = "PAYMENT_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer paymentId;
	
	 @ManyToOne(optional = true)
	 @JoinColumn(name = "APP_ID")
	 private CompanyDtl appId;
	
	 @ManyToOne(optional = true)
	 @JoinColumn(name = "PAYMENT_TYPE_ID")
	 private MasterPaymentType paymentType;

	@Column(name = "PAYMENT_DESC", length = 100)
	private String paymentDesc;
	
	@Column(name = "PAYMENT_AMOUNT", length = 100)
	private String paymentAmount;
	
	@Column(name = "GST_AMOUNT", length = 100)
	private String gstAmount;
	
	@Column(name = "GST_PERCENT", length = 100)
	private String gstPercent;
	
	@Column(name = "TOTAL_AMOUNT", length = 100)
	private String totalAmount;

	
	
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


	public Integer getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}


	public String getPaymentDesc() {
		return paymentDesc;
	}


	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc = paymentDesc;
	}


	public String getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public MasterPaymentType getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(MasterPaymentType paymentType) {
		this.paymentType = paymentType;
	}


	public CompanyDtl getAppId() {
		return appId;
	}


	public void setAppId(CompanyDtl appId) {
		this.appId = appId;
	}	
	
}
