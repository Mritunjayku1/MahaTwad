package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Mahalingam Created on 02-06-2017 for Complaint Details Complaint
 *         Details Module
 * 
 */

@Entity
@Table(name = "tblComplaintDetails")
public class ComplaintDetails implements Serializable {

	/** 
	 * 
	 */
	private static final long serialVersionUID = -3459557891831350107L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ComplaintID")
	private Integer complaintID;

	@Column(name = "ComplaintNumber")
	private String complaintNumber;

	@Column(name = "ComplaintSubmitterName")
	private String complaintSubmitterName;

	@Column(name = "ComplaintSubmitterMobileNo")
	private String complaintSubmitterMobileNo;

	@Column(name = "ComplaintSubmitterEmailID")
	private String complaintSubmitterEmailID;

	@Column(name = "ComplaintContent")
	private String complaintContent;

	@Column(name = "ComplaintRegisteredTime")
	private Date complaintRegisteredTime;

	@Column(name = "ComplaintRegisteredBy")
	private Integer complaintRegisteredBy;

	@Column(name = "ComplaintStatus")
	private Integer complaintStatus;

	@Column(name = "location")
	private String location;

	@Column(name = "LocationID")
	private Integer locationID;

	@ManyToOne(optional = false)
	@JoinColumn(name = "complaintSource")
	private MasterFieldCode masterFieldCodeSource;

	@Column(name = "ComplaintPriority")
	private Integer complaintPriority;

	@Column(name = "AssignedAgentID")
	private Integer assignedAgentID;

	@Column(name = "AgentAssignedTime")
	private Date agentAssignedTime;

	@Column(name = "AssignedOfficerID")
	private Integer assignedOfficerID;

	@Column(name = "OfficerAssignedTime")
	private Date officerAssignedTime;

	@Column(name = "ComplaintResolvedTime")
	private Date complaintResolvedTime;

	@Column(name = "ComplaintRejectCloseTime")
	private Date complaintRejectCloseTime;

	@Column(name = "ComplaintCreatedBy")
	private Integer complaintCreatedBy;

	@Column(name = "ComplaintClosedBy")
	private Integer complaintClosedBy;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	@Column(name = "ComplaintSubmitterAddress")
	private String complaintSubmitterAddress;

	@Column(name = "ComplaintViolationTypeID")
	private Integer complaintViolationTypeID;

	@Column(name = "ComplaintCategoryID")
	private Integer complaintCategoryID;

	@Column(name = "AssignedAgentComments")
	private String assignedAgentComments;

	@Column(name = "AssignedOfficerComments")
	private String assignedOfficerComments;

	@Column(name = "RejectedReason")
	private Integer rejectedReason;

	@Column(name = "ComplaintEscalated")
	private Boolean complaintEscalated;

	@Column(name = "ComplaintEscalationLevel")
	private Integer complaintEscalationLevel;

	@Column(name = "CustomerFeedBack")
	private String customerFeedBack;
	
	@Column(name="PublicCanView")
	private Boolean PublicCanView;
	

	public Boolean getPublicCanView() {
		return PublicCanView;
	}

	public void setPublicCanView(Boolean publicCanView) {
		PublicCanView = publicCanView;
	}

	public Integer getRejectedReason() {
		return rejectedReason;
	}

	public void setRejectedReason(Integer rejectedReason) {
		this.rejectedReason = rejectedReason;
	}

	public Integer getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(Integer complaintID) {
		this.complaintID = complaintID;
	}

	public String getComplaintNumber() {
		return complaintNumber;
	}

	public void setComplaintNumber(String complaintNumber) {
		this.complaintNumber = complaintNumber;
	}

	public String getComplaintSubmitterName() {
		return complaintSubmitterName;
	}

	public void setComplaintSubmitterName(String complaintSubmitterName) {
		this.complaintSubmitterName = complaintSubmitterName;
	}

	public String getComplaintSubmitterMobileNo() {
		return complaintSubmitterMobileNo;
	}

	public void setComplaintSubmitterMobileNo(String complaintSubmitterMobileNo) {
		this.complaintSubmitterMobileNo = complaintSubmitterMobileNo;
	}

	public String getComplaintSubmitterEmailID() {
		return complaintSubmitterEmailID;
	}

	public void setComplaintSubmitterEmailID(String complaintSubmitterEmailID) {
		this.complaintSubmitterEmailID = complaintSubmitterEmailID;
	}

	public String getComplaintContent() {
		return complaintContent;
	}

	public void setComplaintContent(String complaintContent) {
		this.complaintContent = complaintContent;
	}

	public Date getComplaintRegisteredTime() {
		return complaintRegisteredTime;
	}

	public void setComplaintRegisteredTime(Date complaintRegisteredTime) {
		this.complaintRegisteredTime = complaintRegisteredTime;
	}

	public Integer getComplaintRegisteredBy() {
		return complaintRegisteredBy;
	}

	public void setComplaintRegisteredBy(Integer complaintRegisteredBy) {
		this.complaintRegisteredBy = complaintRegisteredBy;
	}

	public Integer getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(Integer complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	// public Integer getComplaintSource() {
	// return complaintSource;
	// }
	//
	// public void setComplaintSource(Integer complaintSource) {
	// this.complaintSource = complaintSource;
	// }

	public Integer getComplaintPriority() {
		return complaintPriority;
	}

	public MasterFieldCode getMasterFieldCodeSource() {
		return masterFieldCodeSource;
	}

	public void setMasterFieldCodeSource(MasterFieldCode masterFieldCodeSource) {
		this.masterFieldCodeSource = masterFieldCodeSource;
	}

	public void setComplaintPriority(Integer complaintPriority) {
		this.complaintPriority = complaintPriority;
	}

	public Integer getAssignedAgentID() {
		return assignedAgentID;
	}

	public void setAssignedAgentID(Integer assignedAgentID) {
		this.assignedAgentID = assignedAgentID;
	}

	public Date getAgentAssignedTime() {
		return agentAssignedTime;
	}

	public void setAgentAssignedTime(Date agentAssignedTime) {
		this.agentAssignedTime = agentAssignedTime;
	}

	public Integer getAssignedOfficerID() {
		return assignedOfficerID;
	}

	public void setAssignedOfficerID(Integer assignedOfficerID) {
		this.assignedOfficerID = assignedOfficerID;
	}

	public Date getOfficerAssignedTime() {
		return officerAssignedTime;
	}

	public void setOfficerAssignedTime(Date officerAssignedTime) {
		this.officerAssignedTime = officerAssignedTime;
	}

	public Date getComplaintResolvedTime() {
		return complaintResolvedTime;
	}

	public void setComplaintResolvedTime(Date complaintResolvedTime) {
		this.complaintResolvedTime = complaintResolvedTime;
	}

	public Date getComplaintRejectCloseTime() {
		return complaintRejectCloseTime;
	}

	public void setComplaintRejectCloseTime(Date complaintRejectCloseTime) {
		this.complaintRejectCloseTime = complaintRejectCloseTime;
	}

	public Integer getComplaintCreatedBy() {
		return complaintCreatedBy;
	}

	public void setComplaintCreatedBy(Integer complaintCreatedBy) {
		this.complaintCreatedBy = complaintCreatedBy;
	}

	public Integer getComplaintClosedBy() {
		return complaintClosedBy;
	}

	public void setComplaintClosedBy(Integer complaintClosedBy) {
		this.complaintClosedBy = complaintClosedBy;
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

	public String getAssignedAgentComments() {
		return assignedAgentComments;
	}

	public void setAssignedAgentComments(String assignedAgentComments) {
		this.assignedAgentComments = assignedAgentComments;
	}

	public String getAssignedOfficerComments() {
		return assignedOfficerComments;
	}

	public void setAssignedOfficerComments(String assignedOfficerComments) {
		this.assignedOfficerComments = assignedOfficerComments;
	}

	public String getComplaintSubmitterAddress() {
		return complaintSubmitterAddress;
	}

	public void setComplaintSubmitterAddress(String complaintSubmitterAddress) {
		this.complaintSubmitterAddress = complaintSubmitterAddress;
	}

	public Integer getComplaintViolationTypeID() {
		return complaintViolationTypeID;
	}

	public void setComplaintViolationTypeID(Integer complaintViolationTypeID) {
		this.complaintViolationTypeID = complaintViolationTypeID;
	}

	public Boolean getComplaintEscalated() {
		return complaintEscalated;
	}

	public void setComplaintEscalated(Boolean complaintEscalated) {
		this.complaintEscalated = complaintEscalated;
	}

	public Integer getComplaintEscalationLevel() {
		return complaintEscalationLevel;
	}

	public void setComplaintEscalationLevel(Integer complaintEscalationLevel) {
		this.complaintEscalationLevel = complaintEscalationLevel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCustomerFeedBack() {
		return customerFeedBack;
	}

	public void setCustomerFeedBack(String customerFeedBack) {
		this.customerFeedBack = customerFeedBack;
	}

	public Integer getLocationID() {
		return locationID;
	}

	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}

	public Integer getComplaintCategoryID() {
		return complaintCategoryID;
	}

	public void setComplaintCategoryID(Integer complaintCategoryID) {
		this.complaintCategoryID = complaintCategoryID;
	}

}
