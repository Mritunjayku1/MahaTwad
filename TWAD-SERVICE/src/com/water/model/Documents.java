package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mahalingam Created on 02-06-2017 for Document Details Document
 *         Details
 * 
 */

@Entity
@Table(name = "tblDocumentsDetails")
public class Documents implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8155020173019292977L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DocumentsDetailID")
	private Integer documentsDetailID;

	@Column(name = "ComplaintID")
	private Integer complaintID;

	@Column(name = "DocumentPath")
	private String documentPath;

	@Column(name = "DocumentOwner")
	private Integer documentOwner;

	@Column(name = "IsActive")
	private Boolean isActive;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedDate")
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
