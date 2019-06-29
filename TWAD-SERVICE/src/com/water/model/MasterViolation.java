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
@Table(name = "tblMasterViolationType")
public class MasterViolation implements Serializable {

	/**
	 * @author Mahalingam Created on 02-06-2017 for ViolationType DropDown
	 * 
	 */
	private static final long serialVersionUID = -6622220080263026230L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ViolationTypeID")
	private Integer violationTypeID;

	@Column(name = "ViolationType")
	private String violationType;

	@Column(name = "IsActive")
	private Boolean isActive;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	public Integer getViolationTypeID() {
		return violationTypeID;
	}

	public void setViolationTypeID(Integer violationTypeID) {
		this.violationTypeID = violationTypeID;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
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
