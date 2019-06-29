package com.water.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "REQMLD_TO_COST")
public class ReqMldToCost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "REQMLD_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer reqMld;
	
	@Column(name = "REQMLD_COST", nullable = false, length = 100)
	private Integer reqmldCost;
	@Column(name = "REQMLD_DESC", nullable = false)
	private String reqmldDesc;
	@Column(name = "REQMLD_RANGE", nullable = false, length = 100)
	private Integer reqmldrange;
	// reqmld_id reqmld_cost reqmld_desc reqmld_range
	
	public Integer getReqmldrange() {
		return reqmldrange;
	}
	public void setReqmldrange(Integer reqmldrange) {
		this.reqmldrange = reqmldrange;
	}
	public int getReqMld() {
		return reqMld;
	}
	public void setReqMld(int reqMld) {
		this.reqMld = reqMld;
	}
	public Integer getReqmldCost() {
		return reqmldCost;
	}
	public void setReqmldCost(Integer reqmldCost) {
		this.reqmldCost = reqmldCost;
	}
	public String getReqmldDesc() {
		return reqmldDesc;
	}
	public void setReqmldDesc(String reqmldDesc) {
		this.reqmldDesc = reqmldDesc;
	}
	
	

	
}
