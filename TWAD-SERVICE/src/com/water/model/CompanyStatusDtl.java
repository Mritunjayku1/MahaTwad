package com.water.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CompanyStatusDtl {
	@Column(name = "APP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	private String appId;
	@Column(name = "STATUS_FLAG", length = 1)
	private Character statusFlag;

	//@ManyToOne(targetEntity = MasterStatus.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "EE_STATUS")
	private MasterStatus eeStatus;

	//@ManyToOne(targetEntity = MasterStatus.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "CE_STATUS")
	private MasterStatus ceStatus;

	//@ManyToOne(targetEntity = MasterStatus.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "MC_STATUS")
	private MasterStatus mcStatus;

	@Column(name = "INS_STATUS_ID", length = 1)
	private Integer insStatusId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TS", nullable = false, length = 26)
	private Date createTs;

	@Column(name = "CREATE_USERID", nullable = true, length = 30)
	private String createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TS", nullable = true, length = 26)
	private Date updateTs;

	@Column(name = "UPDATE_USERID", nullable = true, length = 30)
	private String updateUserId;


}
