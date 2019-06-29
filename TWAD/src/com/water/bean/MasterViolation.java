package com.water.bean;

import java.sql.Date;

import javax.persistence.Column;


public class MasterViolation {
	
	
	private Integer fieldCodeID;
	private String keyValue;
	private String derivedValue;
	private Integer orderNumber;
	private Boolean isActive;
	private Date createdDate;
	private Date modifiedDate;
	
	
	public Integer getFieldCodeID() {
		return fieldCodeID;
	}
	public void setFieldCodeID(Integer fieldCodeID) {
		this.fieldCodeID = fieldCodeID;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getDerivedValue() {
		return derivedValue;
	}
	public void setDerivedValue(String derivedValue) {
		this.derivedValue = derivedValue;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
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


	
//	private Integer violationTypeID;
//	private String violationType;
//	
//	private Boolean isActive;
//	private Date createdDate;
//	private Date modifiedDate;
//
//	public Integer getViolationTypeID() {
//		return violationTypeID;
//	}
//
//	public void setViolationTypeID(Integer violationTypeID) {
//		this.violationTypeID = violationTypeID;
//	}
//
//	public String getViolationType() {
//		return violationType;
//	}
//
//	public void setViolationType(String violationType) {
//		this.violationType = violationType;
//	}
//
//	public Boolean getIsActive() {
//		return isActive;
//	}
//
//	public void setIsActive(Boolean isActive) {
//		this.isActive = isActive;
//	}
//
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public Date getModifiedDate() {
//		return modifiedDate;
//	}
//
//	public void setModifiedDate(Date modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}


}
