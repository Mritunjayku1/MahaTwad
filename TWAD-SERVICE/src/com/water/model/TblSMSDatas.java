package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblSMSDatas")
public class TblSMSDatas implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SMSDataID")
	private Integer sMSDataID;

	@Column(name = "SMSSenterNumber")
	private String sMSSenterNumber;

	@Column(name = "SMSContent")
	private String sMSContent;

	@Column(name = "EmailID")
	private String emailID;

	@Column(name = "IsActive")
	private boolean isActive;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	public Integer getsMSDataID() {
		return sMSDataID;
	}

	public void setsMSDataID(Integer sMSDataID) {
		this.sMSDataID = sMSDataID;
	}

	public String getsMSSenterNumber() {
		return sMSSenterNumber;
	}

	public void setsMSSenterNumber(String sMSSenterNumber) {
		this.sMSSenterNumber = sMSSenterNumber;
	}

	public String getsMSContent() {
		return sMSContent;
	}

	public void setsMSContent(String sMSContent) {
		this.sMSContent = sMSContent;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
