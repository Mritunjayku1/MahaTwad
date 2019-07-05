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
@Table(name = "ProcessDtl")
public class ProcessDtl  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = " PROCESSDTL_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer processDtlID;
	
	@ManyToOne(targetEntity = CompanyDtl.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "APP_ID")
	private CompanyDtl appId;

	
	@Column(name = "EE_USER",nullable = true, length = 100)
	private String eeUser;
	@Column(name = "REFERENCE_File", nullable = true, length = 100)
	private String referenceFile;
	@Column(name = "REFERENCE_DATE", nullable = true, length = 100)
	private String referenceDate;
	@Column(name = "REMARKS", nullable = true, length = 100)
	private String remarks;
	private String user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TS", nullable = false, length = 26)
	private Date createTs;

	
	@Column(name = "CREATE_USERID", nullable = false, length = 30)
	private String createUserId;

	
	
	public Integer getProcessDtlID() {
		return processDtlID;
	}
	public void setProcessDtlID(Integer processDtlID) {
		this.processDtlID = processDtlID;
	}
	public CompanyDtl getAppId() {
		return appId;
	}
	public void setAppId(CompanyDtl appId) {
		this.appId = appId;
	}
	public String getEeUser() {
		return eeUser;
	}
	public void setEeUser(String eeUser) {
		this.eeUser = eeUser;
	}
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
	
}
