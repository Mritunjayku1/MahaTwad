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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblMasterFieldCode")
public class MasterFieldCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4317685826987825715L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FieldCodeID")
	private Integer fieldCodeID;

	@Column(name = "KeyValue")
	private String keyValue;

	@Column(name = "DerivedValue")
	private String derivedValue;

	@Column(name = "OrderNumber")
	private Integer orderNumber;

	@Column(name = "parentID")
	private Integer parentID;

	@Column(name = "IsActive")
	private Boolean isActive;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	@Column(name = "Icon")
	private String icon;

	@Column(name = "Color")
	private String color;

	@OneToMany(mappedBy = "masterFieldCodeSource", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ComplaintDetails> complaintDetails;

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

	public Set<ComplaintDetails> getComplaintDetails() {
		return complaintDetails;
	}

	public void setComplaintDetails(Set<ComplaintDetails> complaintDetails) {
		this.complaintDetails = complaintDetails;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
