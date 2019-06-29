package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="MASTER_SUB_DIVISION")
public class MasterSubDivision implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "SUB_DIVISION_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer subDivisionId;
	
	@Column(name = "SUB_DIVISION_NAME", length = 100)
	private String subDivisionName;
	
	

	@ManyToOne(targetEntity = MasterHODivision.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "HO_DIVISION_ID", nullable = true)
	private MasterHODivision divisionId;
	
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TS", nullable = false, length = 26)
	private Date createTs;

	
	@Column(name = "CREATE_USERID", nullable = false, length = 30)
	private String createUserId;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TS", nullable = false, length = 26)
	private Date updateTs;

	
	@Column(name = "UPDATE_USERID", nullable = false, length = 30)
	private String updateUserId;


	public Integer getSubDivisionId() {
		return subDivisionId;
	}


	public void setSubDivisionId(Integer subDivisionId) {
		this.subDivisionId = subDivisionId;
	}


	public String getSubDivisionName() {
		return subDivisionName;
	}


	public void setSubDivisionName(String subDivisionName) {
		this.subDivisionName = subDivisionName;
	}


	public MasterHODivision getDivisionId() {
		return divisionId;
	}


	public void setDivisionId(MasterHODivision divisionId) {
		this.divisionId = divisionId;
	}


	public Date getCreateTs() {
		return createTs;
	}


	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}


	public String getCreateUserId() {
		return createUserId;
	}


	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}


	public Date getUpdateTs() {
		return updateTs;
	}


	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}


	public String getUpdateUserId() {
		return updateUserId;
	}


	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	



}
