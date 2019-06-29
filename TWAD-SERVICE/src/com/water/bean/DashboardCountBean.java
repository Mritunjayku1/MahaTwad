package com.water.bean;

public class DashboardCountBean {

	private Integer totalRegister;
	private Integer penndingApplication;
	private Integer approvedApplication;
	private Integer paidApplication;
	private Integer rejectedApplication;
	
	private Integer applicationFeePending;
	private Integer upfrontChargesPending;
	private Integer fullPaymentPending;
	
	private Integer fullPaymentCompleted;
	private Integer execution;
	
	private Integer yesCount;
	private Integer noCount;
	private Integer NACount;
	
	public Integer getApplicationFeePending() {
		return applicationFeePending;
	}

	public void setApplicationFeePending(Integer applicationFeePending) {
		this.applicationFeePending = applicationFeePending;
	}

	public Integer getUpfrontChargesPending() {
		return upfrontChargesPending;
	}

	public void setUpfrontChargesPending(Integer upfrontChargesPending) {
		this.upfrontChargesPending = upfrontChargesPending;
	}

	public Integer getFullPaymentPending() {
		return fullPaymentPending;
	}

	public void setFullPaymentPending(Integer fullPaymentPending) {
		this.fullPaymentPending = fullPaymentPending;
	}

	

     
	public Integer getPaidApplication() {
		return paidApplication;
	}

	public void setPaidApplication(Integer paidApplication) {
		this.paidApplication = paidApplication;
	}

	public Integer getTotalRegister() {
		return totalRegister;
	}

	public void setTotalRegister(Integer totalRegister) {
		this.totalRegister = totalRegister;
	}

	public Integer getPenndingApplication() {
		return penndingApplication;
	}

	public void setPenndingApplication(Integer penndingApplication) {
		this.penndingApplication = penndingApplication;
	}

	public Integer getApprovedApplication() {
		return approvedApplication;
	}

	public void setApprovedApplication(Integer approvedApplication) {
		this.approvedApplication = approvedApplication;
	}

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

	public Integer getRejectedApplication() {
		return rejectedApplication;
	}

	public void setRejectedApplication(Integer rejectedApplication) {
		this.rejectedApplication = rejectedApplication;
	}

	public Integer getFullPaymentCompleted() {
		return fullPaymentCompleted;
	}

	public void setFullPaymentCompleted(Integer fullPaymentCompleted) {
		this.fullPaymentCompleted = fullPaymentCompleted;
	}

	public Integer getExecution() {
		return execution;
	}

	public void setExecution(Integer execution) {
		this.execution = execution;
	}

}
