package com.water.bean;

import java.util.Date;

/**
 * @author Indhumathi.P
 * 
 *         EC Document Module
 * 
 *         Created by Indhumathi.P 02-June-2017
 * 
 * 
 */

public class DocumentBean {

	private Integer documentsDetailID;
	private Integer complaintID;
	private String documentPath;
	private Integer documentOwner;
	private Boolean isActive;
	private Date createdDate;
	private Date modifiedDate;

	public Integer getDocumentsDetailID() {
		return documentsDetailID;
	}

	public void setDocumentsDetailID(Integer documentsDetailID) {
		this.documentsDetailID = documentsDetailID;
	}

	public Integer getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(Integer complaintID) {
		this.complaintID = complaintID;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public Integer getDocumentOwner() {
		return documentOwner;
	}

	public void setDocumentOwner(Integer documentOwner) {
		this.documentOwner = documentOwner;
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
