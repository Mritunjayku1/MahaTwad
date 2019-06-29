package com.water.bean;

import java.util.Date;

/**
 * 
 * @author Mahalingam Created on 24-06-2017 for EPIC Details Module
 * 
 */
public class EPICBean {

	private Integer epicID;

	private String epicNumber;

	private String electoralRollDetails;

	private String pollingStationAddress;

	private String keyMap;

	private Date createdDate;

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
