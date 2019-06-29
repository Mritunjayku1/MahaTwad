package com.water.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CMW_WATER_CONN")
public class CmwWaterConnBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "CHALLAN_NO", unique = true, nullable = false)
	private String chALLAN_NO;
	private String seWER_CHALLAN;
	private String NAME;
	private String DOOR_NO;
	private String PLOT_NO;
	private String STREET_NAME;
	private String LOCATION;
	private String PIN_CODE;
	private Integer AREA_CODE;
	private Integer DIVISION_NO;
	private String CMC_NO;
	private Integer ANNUAL_VALUE;
	private Date DATE_REG;
	private String CATEGORY;
	private String FLAT_METER;
	private String TYPE_OF_BUILD;
	private String PLUMBER_NAME;
	private Integer TOT_PLINTH_AREA;
	private String CLASSIFY;
	private Integer NO_OF_DWELL;
	private Integer RATE_DWELL;
	private Integer CONN_CHARGE;
	private Integer ADV_TAX;
	private Integer FERRULE_SIZE;
	private Integer METER_TESTING;
	@Column(name = "CHALLAN_AMT")
	private Integer chALLAN_AMT;
	private String PAY_TYPE;
	private String DD_NO;
	private Date DD_DATE;
	private String BANK_NAME;
	@Column(name = "ADDITIONAL_AMT")
	private Integer adDITIONAL_AMT;
	@Column(name = "ADDITION_DATE")
	private Date adDITION_DATE;
	private Date RET_TO_PARTY;
	@Column(name = "DATE_OF_SANC")
	private Date daTE_OF_SANC;
	@Column(name = "DATE_OF_CONN")
	private Date daTE_OF_CONN;
	private String BUILD_TYPE;
	private String FLOOR_SPECI;
	private Integer ACK_AMOUNT;
	private Integer DTOT_PLINTH_AREA;
	private Integer DNO_OF_DWELL;
	private Integer DRATE_DWELL;
	private Integer DCONN_CHARGE;
	private Integer TOT_DWELL;
	private String AREA_CODE1;
	private String DIVISION_NO1;
	private Date UPD_DATE;
	private Integer UPD_DT_CYC;
	private String CMDA_CC_NUM;
	private Date CMDA_CC_DT;
	private Integer PHONE_CELL_NO;
	private Integer CELL_NO;
	private String REM;
	private Character SPLBUILDING;
	private Integer WB_CHALL_NO;
	private Date DEMAND_DATE;
	private String CHANNEL;
	private Integer PERMIT_NO;
	private String PNO_SUB;
	private Integer YEAR;
	private String LAST_UPDATE_BY;
	private Date LAST_UPDATE_DATE;
	private String COURT_ORDER;
	private String COMPLE_CERTI;
	private String CREATED_BY;
	private Date CREATED_DATE;
	private Integer PENALTY;
	private String CMC_GROUP;
	private String STREET_CODE;
	private String DEM_FLAG;
	private String DEM_FLAG1;
	private Integer WATER_OTHER;
	private String FLOOR_CAT;
	private String REASONS_PEND;
	private Integer METER_READ;
	private String WT_NO;
	private String RECEIPT_NUMBER;
	private Date RECEIPT_DATE;
	private String ADDL_RECEIPT_NUMBER;
	private Date ADDL_RECEIPT_DATE;
	private String PENALTY_RECEIPT_NUMBER;
	private Date PENALTY_RECEIPT_DATE;
	private Integer IDC_CHALL_NO;
	private Date IDC_CHALL_DT;
	private Integer IDC_AMT;
	private String CMDA_IDC_REF;
	private Integer CMDA_IDC_AMT;
	private Integer NAREA;
	private Integer NDIV;
	private String CMW_MUN_NAME;
	private String CMW_MUN_CAT;
	private Integer CMW_MUN_CON;
	private Integer CMW_MUN_DEPOSIT;
	private Integer APP_FEE;
	private Integer CENT_AMT;
	private Integer RC_AMT;
	private Integer MUN_TOT;
	private String NBUILT_AREA;
	private String CONS_NO;
	private Integer AA_METER_TEST;
	private Integer APP_COST;
	private Integer CMW_VAT;
	private Integer ADDL_DEPOSIT_AMT;
	private Integer ADDL_PEN_AMT;
	private String ADDL_PAY_TYPE;
	private Integer ADDL_DD_NO;
	private Date ADDL_DD_DATE;
	private String ADDL_BANK_NAME;
	private Integer ADDL_WB_CHALL_NO;
	private String CIR_REF_NO;
	private String CHALL_FLAG;
	private Integer PAID_MUN_DAMT;
	private Long MOBILE_NUMBER;
	
	
	public Integer getChALLAN_AMT() {
		return chALLAN_AMT;
	}
	public void setChALLAN_AMT(Integer chALLAN_AMT) {
		this.chALLAN_AMT = chALLAN_AMT;
	}
	public Integer getAdDITIONAL_AMT() {
		return adDITIONAL_AMT;
	}
	public void setAdDITIONAL_AMT(Integer adDITIONAL_AMT) {
		this.adDITIONAL_AMT = adDITIONAL_AMT;
	}
	public Date getAdDITION_DATE() {
		return adDITION_DATE;
	}
	public void setAdDITION_DATE(Date adDITION_DATE) {
		this.adDITION_DATE = adDITION_DATE;
	}
	public Date getDaTE_OF_SANC() {
		return daTE_OF_SANC;
	}
	public void setDaTE_OF_SANC(Date daTE_OF_SANC) {
		this.daTE_OF_SANC = daTE_OF_SANC;
	}
	public Date getDaTE_OF_CONN() {
		return daTE_OF_CONN;
	}
	public void setDaTE_OF_CONN(Date daTE_OF_CONN) {
		this.daTE_OF_CONN = daTE_OF_CONN;
	}
	public Date getRET_TO_PARTY() {
		return RET_TO_PARTY;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getDOOR_NO() {
		return DOOR_NO;
	}
	public void setDOOR_NO(String dOOR_NO) {
		DOOR_NO = dOOR_NO;
	}
	public String getPLOT_NO() {
		return PLOT_NO;
	}
	public void setPLOT_NO(String pLOT_NO) {
		PLOT_NO = pLOT_NO;
	}
	public String getSTREET_NAME() {
		return STREET_NAME;
	}
	public void setSTREET_NAME(String sTREET_NAME) {
		STREET_NAME = sTREET_NAME;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getPIN_CODE() {
		return PIN_CODE;
	}
	public void setPIN_CODE(String pIN_CODE) {
		PIN_CODE = pIN_CODE;
	}
	public Integer getAREA_CODE() {
		return AREA_CODE;
	}
	public void setAREA_CODE(Integer aREA_CODE) {
		AREA_CODE = aREA_CODE;
	}
	public Integer getDIVISION_NO() {
		return DIVISION_NO;
	}
	public void setDIVISION_NO(Integer dIVISION_NO) {
		DIVISION_NO = dIVISION_NO;
	}
	public String getCMC_NO() {
		return CMC_NO;
	}
	public void setCMC_NO(String cMC_NO) {
		CMC_NO = cMC_NO;
	}
	public Integer getANNUAL_VALUE() {
		return ANNUAL_VALUE;
	}
	public void setANNUAL_VALUE(Integer aNNUAL_VALUE) {
		ANNUAL_VALUE = aNNUAL_VALUE;
	}
	public Date getDATE_REG() {
		return DATE_REG;
	}
	public void setDATE_REG(Date dATE_REG) {
		DATE_REG = dATE_REG;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getFLAT_METER() {
		return FLAT_METER;
	}
	public void setFLAT_METER(String fLAT_METER) {
		FLAT_METER = fLAT_METER;
	}
	public String getTYPE_OF_BUILD() {
		return TYPE_OF_BUILD;
	}
	public void setTYPE_OF_BUILD(String tYPE_OF_BUILD) {
		TYPE_OF_BUILD = tYPE_OF_BUILD;
	}
	public String getPLUMBER_NAME() {
		return PLUMBER_NAME;
	}
	public void setPLUMBER_NAME(String pLUMBER_NAME) {
		PLUMBER_NAME = pLUMBER_NAME;
	}
	public Integer getTOT_PLINTH_AREA() {
		return TOT_PLINTH_AREA;
	}
	public void setTOT_PLINTH_AREA(Integer tOT_PLINTH_AREA) {
		TOT_PLINTH_AREA = tOT_PLINTH_AREA;
	}
	public String getCLASSIFY() {
		return CLASSIFY;
	}
	public void setCLASSIFY(String cLASSIFY) {
		CLASSIFY = cLASSIFY;
	}
	public Integer getNO_OF_DWELL() {
		return NO_OF_DWELL;
	}
	public void setNO_OF_DWELL(Integer nO_OF_DWELL) {
		NO_OF_DWELL = nO_OF_DWELL;
	}
	public Integer getRATE_DWELL() {
		return RATE_DWELL;
	}
	public void setRATE_DWELL(Integer rATE_DWELL) {
		RATE_DWELL = rATE_DWELL;
	}
	public Integer getCONN_CHARGE() {
		return CONN_CHARGE;
	}
	public void setCONN_CHARGE(Integer cONN_CHARGE) {
		CONN_CHARGE = cONN_CHARGE;
	}
	public Integer getADV_TAX() {
		return ADV_TAX;
	}
	public void setADV_TAX(Integer aDV_TAX) {
		ADV_TAX = aDV_TAX;
	}
	public Integer getFERRULE_SIZE() {
		return FERRULE_SIZE;
	}
	public void setFERRULE_SIZE(Integer fERRULE_SIZE) {
		FERRULE_SIZE = fERRULE_SIZE;
	}
	public Integer getMETER_TESTING() {
		return METER_TESTING;
	}
	public void setMETER_TESTING(Integer mETER_TESTING) {
		METER_TESTING = mETER_TESTING;
	}
	
	public String getPAY_TYPE() {
		return PAY_TYPE;
	}
	public void setPAY_TYPE(String pAY_TYPE) {
		PAY_TYPE = pAY_TYPE;
	}
	public String getDD_NO() {
		return DD_NO;
	}
	public void setDD_NO(String dD_NO) {
		DD_NO = dD_NO;
	}
	public Date getDD_DATE() {
		return DD_DATE;
	}
	public void setDD_DATE(Date dD_DATE) {
		DD_DATE = dD_DATE;
	}
	public String getBANK_NAME() {
		return BANK_NAME;
	}
	public void setBANK_NAME(String bANK_NAME) {
		BANK_NAME = bANK_NAME;
	}
	
	public void setRET_TO_PARTY(Date rET_TO_PARTY) {
		RET_TO_PARTY = rET_TO_PARTY;
	}
	
	public String getBUILD_TYPE() {
		return BUILD_TYPE;
	}
	public void setBUILD_TYPE(String bUILD_TYPE) {
		BUILD_TYPE = bUILD_TYPE;
	}
	public String getFLOOR_SPECI() {
		return FLOOR_SPECI;
	}
	public void setFLOOR_SPECI(String fLOOR_SPECI) {
		FLOOR_SPECI = fLOOR_SPECI;
	}
	public Integer getACK_AMOUNT() {
		return ACK_AMOUNT;
	}
	public void setACK_AMOUNT(Integer aCK_AMOUNT) {
		ACK_AMOUNT = aCK_AMOUNT;
	}
	public Integer getDTOT_PLINTH_AREA() {
		return DTOT_PLINTH_AREA;
	}
	public void setDTOT_PLINTH_AREA(Integer dTOT_PLINTH_AREA) {
		DTOT_PLINTH_AREA = dTOT_PLINTH_AREA;
	}
	public Integer getDNO_OF_DWELL() {
		return DNO_OF_DWELL;
	}
	public void setDNO_OF_DWELL(Integer dNO_OF_DWELL) {
		DNO_OF_DWELL = dNO_OF_DWELL;
	}
	public Integer getDRATE_DWELL() {
		return DRATE_DWELL;
	}
	public void setDRATE_DWELL(Integer dRATE_DWELL) {
		DRATE_DWELL = dRATE_DWELL;
	}
	public Integer getDCONN_CHARGE() {
		return DCONN_CHARGE;
	}
	public void setDCONN_CHARGE(Integer dCONN_CHARGE) {
		DCONN_CHARGE = dCONN_CHARGE;
	}
	public Integer getTOT_DWELL() {
		return TOT_DWELL;
	}
	public void setTOT_DWELL(Integer tOT_DWELL) {
		TOT_DWELL = tOT_DWELL;
	}
	public String getAREA_CODE1() {
		return AREA_CODE1;
	}
	public void setAREA_CODE1(String aREA_CODE1) {
		AREA_CODE1 = aREA_CODE1;
	}
	public String getDIVISION_NO1() {
		return DIVISION_NO1;
	}
	public void setDIVISION_NO1(String dIVISION_NO1) {
		DIVISION_NO1 = dIVISION_NO1;
	}
	public Date getUPD_DATE() {
		return UPD_DATE;
	}
	public void setUPD_DATE(Date uPD_DATE) {
		UPD_DATE = uPD_DATE;
	}
	public Integer getUPD_DT_CYC() {
		return UPD_DT_CYC;
	}
	public void setUPD_DT_CYC(Integer uPD_DT_CYC) {
		UPD_DT_CYC = uPD_DT_CYC;
	}
	public String getCMDA_CC_NUM() {
		return CMDA_CC_NUM;
	}
	public void setCMDA_CC_NUM(String cMDA_CC_NUM) {
		CMDA_CC_NUM = cMDA_CC_NUM;
	}
	public Date getCMDA_CC_DT() {
		return CMDA_CC_DT;
	}
	public void setCMDA_CC_DT(Date cMDA_CC_DT) {
		CMDA_CC_DT = cMDA_CC_DT;
	}
	public Integer getPHONE_CELL_NO() {
		return PHONE_CELL_NO;
	}
	public void setPHONE_CELL_NO(Integer pHONE_CELL_NO) {
		PHONE_CELL_NO = pHONE_CELL_NO;
	}
	public Integer getCELL_NO() {
		return CELL_NO;
	}
	public void setCELL_NO(Integer cELL_NO) {
		CELL_NO = cELL_NO;
	}
	public String getREM() {
		return REM;
	}
	public void setREM(String rEM) {
		REM = rEM;
	}
	public Character getSPLBUILDING() {
		return SPLBUILDING;
	}
	public void setSPLBUILDING(Character sPLBUILDING) {
		SPLBUILDING = sPLBUILDING;
	}
	public Integer getWB_CHALL_NO() {
		return WB_CHALL_NO;
	}
	public void setWB_CHALL_NO(Integer wB_CHALL_NO) {
		WB_CHALL_NO = wB_CHALL_NO;
	}
	public Date getDEMAND_DATE() {
		return DEMAND_DATE;
	}
	public void setDEMAND_DATE(Date dEMAND_DATE) {
		DEMAND_DATE = dEMAND_DATE;
	}
	public String getCHANNEL() {
		return CHANNEL;
	}
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}
	public Integer getPERMIT_NO() {
		return PERMIT_NO;
	}
	public void setPERMIT_NO(Integer pERMIT_NO) {
		PERMIT_NO = pERMIT_NO;
	}
	public String getPNO_SUB() {
		return PNO_SUB;
	}
	public void setPNO_SUB(String pNO_SUB) {
		PNO_SUB = pNO_SUB;
	}
	public Integer getYEAR() {
		return YEAR;
	}
	public void setYEAR(Integer yEAR) {
		YEAR = yEAR;
	}
	public String getLAST_UPDATE_BY() {
		return LAST_UPDATE_BY;
	}
	public void setLAST_UPDATE_BY(String lAST_UPDATE_BY) {
		LAST_UPDATE_BY = lAST_UPDATE_BY;
	}
	public Date getLAST_UPDATE_DATE() {
		return LAST_UPDATE_DATE;
	}
	public void setLAST_UPDATE_DATE(Date lAST_UPDATE_DATE) {
		LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}
	public String getCOURT_ORDER() {
		return COURT_ORDER;
	}
	public void setCOURT_ORDER(String cOURT_ORDER) {
		COURT_ORDER = cOURT_ORDER;
	}
	public String getCOMPLE_CERTI() {
		return COMPLE_CERTI;
	}
	public void setCOMPLE_CERTI(String cOMPLE_CERTI) {
		COMPLE_CERTI = cOMPLE_CERTI;
	}
	public String getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}
	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}
	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}
	public Integer getPENALTY() {
		return PENALTY;
	}
	public void setPENALTY(Integer pENALTY) {
		PENALTY = pENALTY;
	}
	public String getCMC_GROUP() {
		return CMC_GROUP;
	}
	public void setCMC_GROUP(String cMC_GROUP) {
		CMC_GROUP = cMC_GROUP;
	}
	public String getSTREET_CODE() {
		return STREET_CODE;
	}
	public void setSTREET_CODE(String sTREET_CODE) {
		STREET_CODE = sTREET_CODE;
	}
	public String getDEM_FLAG() {
		return DEM_FLAG;
	}
	public void setDEM_FLAG(String dEM_FLAG) {
		DEM_FLAG = dEM_FLAG;
	}
	public String getDEM_FLAG1() {
		return DEM_FLAG1;
	}
	public void setDEM_FLAG1(String dEM_FLAG1) {
		DEM_FLAG1 = dEM_FLAG1;
	}
	public Integer getWATER_OTHER() {
		return WATER_OTHER;
	}
	public void setWATER_OTHER(Integer wATER_OTHER) {
		WATER_OTHER = wATER_OTHER;
	}
	public String getFLOOR_CAT() {
		return FLOOR_CAT;
	}
	public void setFLOOR_CAT(String fLOOR_CAT) {
		FLOOR_CAT = fLOOR_CAT;
	}
	public String getREASONS_PEND() {
		return REASONS_PEND;
	}
	public void setREASONS_PEND(String rEASONS_PEND) {
		REASONS_PEND = rEASONS_PEND;
	}
	public Integer getMETER_READ() {
		return METER_READ;
	}
	public void setMETER_READ(Integer mETER_READ) {
		METER_READ = mETER_READ;
	}
	public String getWT_NO() {
		return WT_NO;
	}
	public void setWT_NO(String wT_NO) {
		WT_NO = wT_NO;
	}
	public String getRECEIPT_NUMBER() {
		return RECEIPT_NUMBER;
	}
	public void setRECEIPT_NUMBER(String rECEIPT_NUMBER) {
		RECEIPT_NUMBER = rECEIPT_NUMBER;
	}
	public Date getRECEIPT_DATE() {
		return RECEIPT_DATE;
	}
	public void setRECEIPT_DATE(Date rECEIPT_DATE) {
		RECEIPT_DATE = rECEIPT_DATE;
	}
	public String getADDL_RECEIPT_NUMBER() {
		return ADDL_RECEIPT_NUMBER;
	}
	public void setADDL_RECEIPT_NUMBER(String aDDL_RECEIPT_NUMBER) {
		ADDL_RECEIPT_NUMBER = aDDL_RECEIPT_NUMBER;
	}
	public Date getADDL_RECEIPT_DATE() {
		return ADDL_RECEIPT_DATE;
	}
	public void setADDL_RECEIPT_DATE(Date aDDL_RECEIPT_DATE) {
		ADDL_RECEIPT_DATE = aDDL_RECEIPT_DATE;
	}
	public String getPENALTY_RECEIPT_NUMBER() {
		return PENALTY_RECEIPT_NUMBER;
	}
	public void setPENALTY_RECEIPT_NUMBER(String pENALTY_RECEIPT_NUMBER) {
		PENALTY_RECEIPT_NUMBER = pENALTY_RECEIPT_NUMBER;
	}
	public Date getPENALTY_RECEIPT_DATE() {
		return PENALTY_RECEIPT_DATE;
	}
	public void setPENALTY_RECEIPT_DATE(Date pENALTY_RECEIPT_DATE) {
		PENALTY_RECEIPT_DATE = pENALTY_RECEIPT_DATE;
	}
	public Integer getIDC_CHALL_NO() {
		return IDC_CHALL_NO;
	}
	public void setIDC_CHALL_NO(Integer iDC_CHALL_NO) {
		IDC_CHALL_NO = iDC_CHALL_NO;
	}
	public Date getIDC_CHALL_DT() {
		return IDC_CHALL_DT;
	}
	public void setIDC_CHALL_DT(Date iDC_CHALL_DT) {
		IDC_CHALL_DT = iDC_CHALL_DT;
	}
	public Integer getIDC_AMT() {
		return IDC_AMT;
	}
	public void setIDC_AMT(Integer iDC_AMT) {
		IDC_AMT = iDC_AMT;
	}
	public String getCMDA_IDC_REF() {
		return CMDA_IDC_REF;
	}
	public void setCMDA_IDC_REF(String cMDA_IDC_REF) {
		CMDA_IDC_REF = cMDA_IDC_REF;
	}
	public Integer getCMDA_IDC_AMT() {
		return CMDA_IDC_AMT;
	}
	public void setCMDA_IDC_AMT(Integer cMDA_IDC_AMT) {
		CMDA_IDC_AMT = cMDA_IDC_AMT;
	}
	public Integer getNAREA() {
		return NAREA;
	}
	public void setNAREA(Integer nAREA) {
		NAREA = nAREA;
	}
	public Integer getNDIV() {
		return NDIV;
	}
	public void setNDIV(Integer nDIV) {
		NDIV = nDIV;
	}
	public String getCMW_MUN_NAME() {
		return CMW_MUN_NAME;
	}
	public void setCMW_MUN_NAME(String cMW_MUN_NAME) {
		CMW_MUN_NAME = cMW_MUN_NAME;
	}
	public String getCMW_MUN_CAT() {
		return CMW_MUN_CAT;
	}
	public void setCMW_MUN_CAT(String cMW_MUN_CAT) {
		CMW_MUN_CAT = cMW_MUN_CAT;
	}
	public Integer getCMW_MUN_CON() {
		return CMW_MUN_CON;
	}
	public void setCMW_MUN_CON(Integer cMW_MUN_CON) {
		CMW_MUN_CON = cMW_MUN_CON;
	}
	public Integer getCMW_MUN_DEPOSIT() {
		return CMW_MUN_DEPOSIT;
	}
	public void setCMW_MUN_DEPOSIT(Integer cMW_MUN_DEPOSIT) {
		CMW_MUN_DEPOSIT = cMW_MUN_DEPOSIT;
	}
	public Integer getAPP_FEE() {
		return APP_FEE;
	}
	public void setAPP_FEE(Integer aPP_FEE) {
		APP_FEE = aPP_FEE;
	}
	public Integer getCENT_AMT() {
		return CENT_AMT;
	}
	public void setCENT_AMT(Integer cENT_AMT) {
		CENT_AMT = cENT_AMT;
	}
	public Integer getRC_AMT() {
		return RC_AMT;
	}
	public void setRC_AMT(Integer rC_AMT) {
		RC_AMT = rC_AMT;
	}
	public Integer getMUN_TOT() {
		return MUN_TOT;
	}
	public void setMUN_TOT(Integer mUN_TOT) {
		MUN_TOT = mUN_TOT;
	}
	public String getNBUILT_AREA() {
		return NBUILT_AREA;
	}
	public void setNBUILT_AREA(String nBUILT_AREA) {
		NBUILT_AREA = nBUILT_AREA;
	}
	public String getCONS_NO() {
		return CONS_NO;
	}
	public void setCONS_NO(String cONS_NO) {
		CONS_NO = cONS_NO;
	}
	public Integer getAA_METER_TEST() {
		return AA_METER_TEST;
	}
	public void setAA_METER_TEST(Integer aA_METER_TEST) {
		AA_METER_TEST = aA_METER_TEST;
	}
	public Integer getAPP_COST() {
		return APP_COST;
	}
	public void setAPP_COST(Integer aPP_COST) {
		APP_COST = aPP_COST;
	}
	public Integer getCMW_VAT() {
		return CMW_VAT;
	}
	public void setCMW_VAT(Integer cMW_VAT) {
		CMW_VAT = cMW_VAT;
	}
	public Integer getADDL_DEPOSIT_AMT() {
		return ADDL_DEPOSIT_AMT;
	}
	public void setADDL_DEPOSIT_AMT(Integer aDDL_DEPOSIT_AMT) {
		ADDL_DEPOSIT_AMT = aDDL_DEPOSIT_AMT;
	}
	public Integer getADDL_PEN_AMT() {
		return ADDL_PEN_AMT;
	}
	public void setADDL_PEN_AMT(Integer aDDL_PEN_AMT) {
		ADDL_PEN_AMT = aDDL_PEN_AMT;
	}
	public String getADDL_PAY_TYPE() {
		return ADDL_PAY_TYPE;
	}
	public void setADDL_PAY_TYPE(String aDDL_PAY_TYPE) {
		ADDL_PAY_TYPE = aDDL_PAY_TYPE;
	}
	public Integer getADDL_DD_NO() {
		return ADDL_DD_NO;
	}
	public void setADDL_DD_NO(Integer aDDL_DD_NO) {
		ADDL_DD_NO = aDDL_DD_NO;
	}
	public Date getADDL_DD_DATE() {
		return ADDL_DD_DATE;
	}
	public void setADDL_DD_DATE(Date aDDL_DD_DATE) {
		ADDL_DD_DATE = aDDL_DD_DATE;
	}
	public String getADDL_BANK_NAME() {
		return ADDL_BANK_NAME;
	}
	public void setADDL_BANK_NAME(String aDDL_BANK_NAME) {
		ADDL_BANK_NAME = aDDL_BANK_NAME;
	}
	public Integer getADDL_WB_CHALL_NO() {
		return ADDL_WB_CHALL_NO;
	}
	public void setADDL_WB_CHALL_NO(Integer aDDL_WB_CHALL_NO) {
		ADDL_WB_CHALL_NO = aDDL_WB_CHALL_NO;
	}
	public String getCIR_REF_NO() {
		return CIR_REF_NO;
	}
	public void setCIR_REF_NO(String cIR_REF_NO) {
		CIR_REF_NO = cIR_REF_NO;
	}
	public String getCHALL_FLAG() {
		return CHALL_FLAG;
	}
	public void setCHALL_FLAG(String cHALL_FLAG) {
		CHALL_FLAG = cHALL_FLAG;
	}
	public Integer getPAID_MUN_DAMT() {
		return PAID_MUN_DAMT;
	}
	public void setPAID_MUN_DAMT(Integer pAID_MUN_DAMT) {
		PAID_MUN_DAMT = pAID_MUN_DAMT;
	}
	public Long getMOBILE_NUMBER() {
		return MOBILE_NUMBER;
	}
	public void setMOBILE_NUMBER(Long mOBILE_NUMBER) {
		MOBILE_NUMBER = mOBILE_NUMBER;
	}
	public String getChALLAN_NO() {
		return chALLAN_NO;
	}
	public void setChALLAN_NO(String chALLAN_NO) {
		this.chALLAN_NO = chALLAN_NO;
	}
	public String getSeWER_CHALLAN() {
		return seWER_CHALLAN;
	}
	public void setSeWER_CHALLAN(String seWER_CHALLAN) {
		this.seWER_CHALLAN = seWER_CHALLAN;
	}
	
	

}
