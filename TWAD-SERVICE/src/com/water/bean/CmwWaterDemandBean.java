package com.water.bean;


import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CmwWaterDemandBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String CHALLAN_NO;
	private String CMC_NO;
	private String NAME;
	private Integer RD_FD;
	private String CLASS_CODE;
	private String CATE_CODE;
	private String DEMAND_FLAG;
	private Date FLAG_UPD_DT;
	private String USER_NAME;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCHALLAN_NO() {
		return CHALLAN_NO;
	}
	public void setCHALLAN_NO(String cHALLAN_NO) {
		CHALLAN_NO = cHALLAN_NO;
	}
	public String getCMC_NO() {
		return CMC_NO;
	}
	public void setCMC_NO(String cMC_NO) {
		CMC_NO = cMC_NO;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public Integer getRD_FD() {
		return RD_FD;
	}
	public void setRD_FD(Integer rD_FD) {
		RD_FD = rD_FD;
	}
	public String getCLASS_CODE() {
		return CLASS_CODE;
	}
	public void setCLASS_CODE(String cLASS_CODE) {
		CLASS_CODE = cLASS_CODE;
	}
	public String getCATE_CODE() {
		return CATE_CODE;
	}
	public void setCATE_CODE(String cATE_CODE) {
		CATE_CODE = cATE_CODE;
	}
	public String getDEMAND_FLAG() {
		return DEMAND_FLAG;
	}
	public void setDEMAND_FLAG(String dEMAND_FLAG) {
		DEMAND_FLAG = dEMAND_FLAG;
	}
	public Date getFLAG_UPD_DT() {
		return FLAG_UPD_DT;
	}
	public void setFLAG_UPD_DT(Date fLAG_UPD_DT) {
		FLAG_UPD_DT = fLAG_UPD_DT;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
   
}
