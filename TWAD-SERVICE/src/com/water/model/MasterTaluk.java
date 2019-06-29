package com.water.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="MASTER_TALUK")
public class MasterTaluk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "TALUK_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer talukId;
	
	@Column(name = "TALUK_NAME", length = 100)
	private String talukName;
	
	

	@ManyToOne(targetEntity = MasterDistrict.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", nullable = true)
	private MasterDistrict districtId;
	
	
	
	
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


	public Integer getTalukId() {
		return talukId;
	}


	public void setTalukId(Integer talukId) {
		this.talukId = talukId;
	}


	public String getTalukName() {
		return talukName;
	}


	public void setTalukName(String talukName) {
		this.talukName = talukName;
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


	public MasterDistrict getDistrictId() {
		return districtId;
	}


	public void setDistrictId(MasterDistrict districtId) {
		this.districtId = districtId;
	}





}
