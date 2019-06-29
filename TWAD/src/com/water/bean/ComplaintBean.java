package com.water.bean;

import java.util.Date;

/**
 * @author Indhumathi.P
 * 
 *         EC Complaint Module
 * 
 *         Created by Indhumathi.P 02-June-2017
 * 
 * 
 */

public class ComplaintBean {

	private Integer complaintID;
	private String complaintNumber;
	private String complaintSubmitterName;
	private String complaintSubmitterMobileNo;
	private String complaintSubmitterEmailID;
	private String complaintContent;
	private String complaintRegisteredTime;
	private Integer complaintRegisteredBy;
	private Integer complaintStatus;
	private String complaintStatusName;
	private Integer complaintSource;
	private String complaintSourceName;
	private Integer complaintPriority;
	private Integer assignedAgentID;
	private String assignedAgentName;
	private Integer complaintantType;
	private Date agentAssignedTime;
	private Integer assignedOfficerID;
	private String assignedOfficerName;
	private Date officerAssignedTime;
	private Date complaintResolvedTime;
	private Date complaintRejectCloseTime;
	private Integer complaintCreatedBy;
	private Integer complaintClosedBy;
	private String complaintClosedName;
	private Date createdDate;
	private Date modifiedDate;
	private String complaintSubmitterAddress;
	private Integer complaintViolationTypeID;
	private Integer complaintCategoryID;
	private String complaintCategoryName;
	private String assignedAgentComments;
	private String assignedOfficerComments;
	private String IVR_filePath;
	private Integer accessTypeID;
	private String isReject;
	private Integer rejectedReason;
	private Integer notificationType;
	private Boolean complaintEscalated;
	private Integer complaintEscalationLevel;

	private String attachementPath;
	private Integer attachementOwner;

	private Integer locationID;
	private String location;
	private String customerFeedBack;

	private String publicCanView;

	private String compliantClosedDate;

	private String roleName;

	public Integer getRejectedReason() {
		return rejectedReason;
	}

	public void setRejectedReason(Integer rejectedReason) {
		this.rejectedReason = rejectedReason;
	}

	public Integer getAccessTypeID() {
		return accessTypeID;
	}

	public void setAccessTypeID(Integer accessTypeID) {
		this.accessTypeID = accessTypeID;
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

	// public Date getComplaintRegisteredTime() {
	// return complaintRegisteredTime;
	// }
	//
	// public void setComplaintRegisteredTime(Date complaintRegisteredTime) {
	// this.complaintRegisteredTime = complaintRegisteredTime;
	// }

	public Integer getComplaintRegisteredBy() {
		return complaintRegisteredBy;
	}

	public String getComplaintRegisteredTime() {
		return complaintRegisteredTime;
	}

	public void setComplaintRegisteredTime(String complaintRegisteredTime) {
		this.complaintRegisteredTime = complaintRegisteredTime;
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

	public Integer getComplaintSource() {
		return complaintSource;
	}

	public void setComplaintSource(Integer complaintSource) {
		this.complaintSource = complaintSource;
	}

	public Integer getComplaintPriority() {
		return complaintPriority;
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

	public Integer getComplaintantType() {
		return complaintantType;
	}

	public void setComplaintantType(Integer complaintantType) {
		this.complaintantType = complaintantType;
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

	public String getIVR_filePath() {
		return IVR_filePath;
	}

	public void setIVR_filePath(String IVR_filePath) {
		this.IVR_filePath = IVR_filePath;
	}

	public String getIsReject() {
		return isReject;
	}

	public void setIsReject(String isReject) {
		this.isReject = isReject;
	}

	public Integer getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(Integer notificationType) {
		this.notificationType = notificationType;
	}

	/**
	 * @return the complaintEscalated
	 */
	public Boolean getComplaintEscalated() {
		return complaintEscalated;
	}

	/**
	 * @param complaintEscalated
	 *            the complaintEscalated to set
	 */
	public void setComplaintEscalated(Boolean complaintEscalated) {
		this.complaintEscalated = complaintEscalated;
	}

	/**
	 * @return the complaintEscalationLevel
	 */
	public Integer getComplaintEscalationLevel() {
		return complaintEscalationLevel;
	}

	/**
	 * @param complaintEscalationLevel
	 *            the complaintEscalationLevel to set
	 */
	public void setComplaintEscalationLevel(Integer complaintEscalationLevel) {
		this.complaintEscalationLevel = complaintEscalationLevel;
	}

	public String getAttachementPath() {
		return attachementPath;
	}

	public void setAttachementPath(String attachementPath) {
		this.attachementPath = attachementPath;
	}

	public Integer getAttachementOwner() {
		return attachementOwner;
	}

	public void setAttachementOwner(Integer attachementOwner) {
		this.attachementOwner = attachementOwner;
	}

	public String getComplaintSourceName() {
		return complaintSourceName;
	}

	public void setComplaintSourceName(String complaintSourceName) {
		this.complaintSourceName = complaintSourceName;
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

	public String getComplaintCategoryName() {
		return complaintCategoryName;
	}

	public void setComplaintCategoryName(String complaintCategoryName) {
		this.complaintCategoryName = complaintCategoryName;
	}

	public String getAssignedAgentName() {
		return assignedAgentName;
	}

	public void setAssignedAgentName(String assignedAgentName) {
		this.assignedAgentName = assignedAgentName;
	}

	public String getAssignedOfficerName() {
		return assignedOfficerName;
	}

	public void setAssignedOfficerName(String assignedOfficerName) {
		this.assignedOfficerName = assignedOfficerName;
	}

	public String getComplaintStatusName() {
		return complaintStatusName;
	}

	public void setComplaintStatusName(String complaintStatusName) {
		this.complaintStatusName = complaintStatusName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCompliantClosedDate() {
		return compliantClosedDate;
	}

	public void setCompliantClosedDate(String compliantClosedDate) {
		this.compliantClosedDate = compliantClosedDate;
	}

	public String getPublicCanView() {
		return publicCanView;
	}

	public void setPublicCanView(String publicCanView) {
		this.publicCanView = publicCanView;
	}

	public String getComplaintClosedName() {
		return complaintClosedName;
	}

	public void setComplaintClosedName(String complaintClosedName) {
		this.complaintClosedName = complaintClosedName;
	}

}
