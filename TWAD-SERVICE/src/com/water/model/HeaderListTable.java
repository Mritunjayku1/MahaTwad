package com.water.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HEADER_LIST_TABLE")
public class HeaderListTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "HEADER_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Integer headerId;

	@Column(name = "PAGE_NANE", length = 100)
	private String pageName;
	
	@Column(name = "HEADER_LIST", length = 500)
	private String headerList;

	public Integer getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Integer headerId) {
		this.headerId = headerId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getHeaderList() {
		return headerList;
	}

	public void setHeaderList(String headerList) {
		this.headerList = headerList;
	}
	
}
