package com.water.bean;

import java.util.Date;

public class FieldcodeBean {

	private Integer fieldCodeID;

	private String keyValue;

	private String derivedValue;

	private Integer orderNumber;

	private Integer parentID;

	private Boolean isActive;

	private Date createdDate;

	private Date modifiedDate;

	private String icon;
	private String bgColor;

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

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

}
