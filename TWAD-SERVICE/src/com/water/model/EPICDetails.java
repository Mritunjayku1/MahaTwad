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
 * 
 * @author Mahalingam Created on 24-06-2017 for EPIC Details Module
 * 
 */

@Entity
@Table(name = "tblEpicDetails")
public class EPICDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1557710223626077786L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EpicID")
	private Integer epicID;

	@Column(name = "EpicNumber")
	private String epicNumber;

	@Column(name = "ElectoralRollDetails")
	private String electoralRollDetails;

	@Column(name = "PollingStationAddress")
	private String pollingStationAddress;

	@Column(name = "KeyMap")
	private String keyMap;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	public Integer getEpicID() {
		return epicID;
	}

	public void setEpicID(Integer epicID) {
		this.epicID = epicID;
	}

	public String getEpicNumber() {
		return epicNumber;
	}

	public void setEpicNumber(String epicNumber) {
		this.epicNumber = epicNumber;
	}

	public String getElectoralRollDetails() {
		return electoralRollDetails;
	}

	public void setElectoralRollDetails(String electoralRollDetails) {
		this.electoralRollDetails = electoralRollDetails;
	}

	public String getPollingStationAddress() {
		return pollingStationAddress;
	}

	public void setPollingStationAddress(String pollingStationAddress) {
		this.pollingStationAddress = pollingStationAddress;
	}

	public String getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(String keyMap) {
		this.keyMap = keyMap;
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
