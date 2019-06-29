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
@Table(name="MASTER_DIVISION")
public class MasterDivision implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "DIVISION_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer divId;
	
	@Column(name = "DIVISION_DESC", length = 100)
	private String divDesc;
	
	@Column(name = "DIVISION_ADDR",nullable = true, length = 100)
	private String divAddr;
	
	@Column(name = "DIVISION_PHONE", nullable = true,length = 100)
	private String divPhone;
	
	@Column(name = "DIVISION_MOBILE", nullable = true,length = 100)
	private String divMobile;


	@ManyToOne(targetEntity = MasterZone.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "Zone_ID", nullable = true)
	private MasterZone cmwssbZoneNum;
	
	
	
	
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




	
	public Integer getDivId() {
		return divId;
	}


	public void setDivId(Integer divId) {
		this.divId = divId;
	}


	public String getDivDesc() {
		return divDesc;
	}


	public void setDivDesc(String divDesc) {
		this.divDesc = divDesc;
	}


	public MasterZone getCmwssbZoneNum() {
		return cmwssbZoneNum;
	}


	public void setCmwssbZoneNum(MasterZone cmwssbZoneNum) {
		this.cmwssbZoneNum = cmwssbZoneNum;
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


	public String getDivAddr() {
		return divAddr;
	}


	public void setDivAddr(String divAddr) {
		this.divAddr = divAddr;
	}


	public String getDivPhone() {
		return divPhone;
	}


	public void setDivPhone(String divPhone) {
		this.divPhone = divPhone;
	}


	public String getDivMobile() {
		return divMobile;
	}


	public void setDivMobile(String divMobile) {
		this.divMobile = divMobile;
	}


	



}
