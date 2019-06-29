package com.water.bean;

public class DashboardBean {

	private Integer totalComplaints;
	private Integer pendingIVRcalls;
	private Integer newComplaints;
	private Integer assignedComplaints;
	private Integer closedByFieldOfficer;
	private Integer closedByCommandCenter;

	private Integer acknowledgeCount;
	private Integer relovedCount;
	private Integer rejectedCount;
	private Integer escalationCount; 
	
	private Integer SMSChannelCount;
	private Integer IVRChannelCount;
	private Integer emailChannelCount;
	private Integer mobileAppChannelCount;
	private Integer walkinCount;
	private Integer tappalCount;
	private Integer totalChannelCount;

	private Integer yesCount;
	private Integer noCount;
	private Integer NACount;


	private String icon;
	private String bgColor;
	
	private Integer categoryID;
	private String categoryName;
	private Integer categoryCount;
    

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryCount() {
		return categoryCount;
	}

	public void setCategoryCount(Integer categoryCount) {
		this.categoryCount = categoryCount;
	}


	public Integer getTotalComplaints() {
		return totalComplaints;
	}

	public void setTotalComplaints(Integer totalComplaints) {
		this.totalComplaints = totalComplaints;
	}

	public Integer getPendingIVRcalls() {
		return pendingIVRcalls;
	}

	public void setPendingIVRcalls(Integer pendingIVRcalls) {
		this.pendingIVRcalls = pendingIVRcalls;
	}

	public Integer getNewComplaints() {
		return newComplaints;
	}

	public void setNewComplaints(Integer newComplaints) {
		this.newComplaints = newComplaints;
	}

	public Integer getAssignedComplaints() {
		return assignedComplaints;
	}

	public void setAssignedComplaints(Integer assignedComplaints) {
		this.assignedComplaints = assignedComplaints;
	}

	public Integer getClosedByFieldOfficer() {
		return closedByFieldOfficer;
	}

	public void setClosedByFieldOfficer(Integer closedByFieldOfficer) {
		this.closedByFieldOfficer = closedByFieldOfficer;
	}

	public Integer getClosedByCommandCenter() {
		return closedByCommandCenter;
	}

	public void setClosedByCommandCenter(Integer closedByCommandCenter) {
		this.closedByCommandCenter = closedByCommandCenter;
	}

	public Integer getSMSChannelCount() {
		return SMSChannelCount;
	}

	public void setSMSChannelCount(Integer sMSChannelCount) {
		SMSChannelCount = sMSChannelCount;
	}

	public Integer getIVRChannelCount() {
		return IVRChannelCount;
	}

	public void setIVRChannelCount(Integer iVRChannelCount) {
		IVRChannelCount = iVRChannelCount;
	}

	public Integer getEmailChannelCount() {
		return emailChannelCount;
	}

	public void setEmailChannelCount(Integer emailChannelCount) {
		this.emailChannelCount = emailChannelCount;
	}

	public Integer getMobileAppChannelCount() {
		return mobileAppChannelCount;
	}

	public void setMobileAppChannelCount(Integer mobileAppChannelCount) {
		this.mobileAppChannelCount = mobileAppChannelCount;
	}

	public Integer getTotalChannelCount() {
		return totalChannelCount;
	}

	public void setTotalChannelCount(Integer totalChannelCount) {
		this.totalChannelCount = totalChannelCount;
	}

	public Integer getAcknowledgeCount() {
		return acknowledgeCount;
	}

	public void setAcknowledgeCount(Integer acknowledgeCount) {
		this.acknowledgeCount = acknowledgeCount;
	}

	public Integer getRelovedCount() {
		return relovedCount;
	}

	public void setRelovedCount(Integer relovedCount) {
		this.relovedCount = relovedCount;
	}

	public Integer getRejectedCount() {
		return rejectedCount;
	}

	public void setRejectedCount(Integer rejectedCount) {
		this.rejectedCount = rejectedCount;
	}
	
  
	public Integer getEscalationCount() {
		return escalationCount;
	}

	public void setEscalationCount(Integer escalationCount) {
		this.escalationCount = escalationCount;
	}

	public Integer getWalkinCount() {
		return walkinCount;
	}

	public void setWalkinCount(Integer walkinCount) {
		this.walkinCount = walkinCount;
	}
	
	public Integer getTappalCount() {
		return tappalCount;
	}

	public void setTappalCount(Integer tappalCount) {
		this.tappalCount = tappalCount;
	}

	public Integer getYesCount() {
		return yesCount;
	}

	public void setYesCount(Integer yesCount) {
		this.yesCount = yesCount;
	}

	public Integer getNoCount() {
		return noCount;
	}

	public void setNoCount(Integer noCount) {
		this.noCount = noCount;
	}

	public Integer getNACount() {
		return NACount;
	}

	public void setNACount(Integer NACount) {
		this.NACount = NACount;
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
