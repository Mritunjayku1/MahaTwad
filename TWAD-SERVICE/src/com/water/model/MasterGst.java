package com.water.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MASTER_GST")
public class MasterGst {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "GST_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer gstld;
	
	@Column(name = "GST_COST", nullable = false, length = 100)
	private Integer gstCost;
	@Column(name = "GST_DESC")
	private String gstDesc;
	public Integer getGstld() {
		return gstld;
	}
	public void setGstld(Integer gstld) {
		this.gstld = gstld;
	}
	public Integer getGstCost() {
		return gstCost;
	}
	public void setGstCost(Integer gstCost) {
		this.gstCost = gstCost;
	}
	public String getGstDesc() {
		return gstDesc;
	}
	public void setGstDesc(String gstDesc) {
		this.gstDesc = gstDesc;
	}
	
}
