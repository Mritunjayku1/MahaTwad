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
@Table(name = "tblRequesterDetails")
public class EPICLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4096385238266665334L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RequesterDetailID")
	private Integer RequesterDetailID;

	@Column(name = "EpicNumber")
	private String epicNumber;

	@Column(name = "RequestFrom")
	private String from;

	@Column(name = "Channel")
	private Integer ChannelID;

	@Column(name = "CreatedDate")
	private Date createdDate;

	public Integer getRequesterDetailID() {
		return RequesterDetailID;
	}

	public void setRequesterDetailID(Integer requesterDetailID) {
		RequesterDetailID = requesterDetailID;
	}

	public String getEpicNumber() {
		return epicNumber;
	}

	public void setEpicNumber(String epicNumber) {
		this.epicNumber = epicNumber;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Integer getChannelID() {
		return ChannelID;
	}

	public void setChannelID(Integer channelID) {
		ChannelID = channelID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
