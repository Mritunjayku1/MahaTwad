package com.water.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="EMPLOYEE_DTL")
public class EmployeeDetails  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USERID", unique = true, nullable = false, length = 100)
	private Integer userId;
	
	
	@Column(name = "USER_FIRST_NAME", nullable = false, length = 100)
	private String userFirstName;

	@Column(name = "USER_MIDDLE_NAME", length = 100)
	private String userMiddleName;

	@Column(name = "USER_LAST_NAME", nullable = false, length = 100 )
	private String userLastName;
	
	
	@Column(name = "LOGIN_USER_NAME", unique=true, nullable=false, length = 100)
	private String loginUserName;
	
	
	@Column(name = "LOGIN_PASSWORD", length = 100)
	private String loginPassword;

	
	@Column(name = "SUPV_NAME", length = 100)
	private String supvName;

	
	@Column(name = "EMAIL_ADDR", length = 254)
	private String emailAddr;

	
	
	@Column(name = "PHONE_NUMBER", precision = 15, scale = 0)
	
	private Long phoneNum;
	
		

	
	
	@Column(name = "STATUS_FLAG", length = 1)
	private Character statusFlag;
	
	
	@Column(name = "USER_SECRTY_LEVEL", precision = 2, scale = 0)
	private Byte userSecrtyLevel;
	
	
	@Column(name = "SHIFT_NUMBER", length = 2)
	private String shiftNumber;
	
	
	@Column(name = "JOB_POSTN", length = 100)
	private String jobPostn;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ADJSTD_HIRE_DATE", length = 10)
	private Date adjstdHireDate;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "HIRE_DATE", length = 10)
	private Date hireDate;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TRMNTN_DATE", length = 10)
	private Date trmntnDate;
	
	
	@Column(name = "HOME_PHONE", precision = 15, scale = 0)
	private Integer homePhone;

	
	@Column(name = "DPT_NAME", length = 100)
	private String dptName;
	
		
	@Column(name = "JOB_CODE", length = 9)
	private String jobCode;
	
	
    @Column(name = "CNTRCR_CMPNY_NAME", length = 100)
	private String cntrcrCmpnyName;
    
    
	@Temporal(TemporalType.DATE)
	@Column(name = "SUP_PSSWD_LAST_UPDATED", length = 10)
	private Date supervisorLastUpdated;
    
   
	  
    @ManyToOne(optional = false)
    @JoinColumn(name = "ROLE_ID")
    private MasterRole userRole;
    
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "DIVISION_ID")
    private MasterHODivision userDivision;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ZONE_ID")
    private MasterZone zoneId;
    
    
    
    
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


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserMiddleName() {
		return userMiddleName;
	}


	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getLoginUserName() {
		return loginUserName;
	}


	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public String getSupvName() {
		return supvName;
	}


	public void setSupvName(String supvName) {
		this.supvName = supvName;
	}


	public String getEmailAddr() {
		return emailAddr;
	}


	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}



	public Character getStatusFlag() {
		return statusFlag;
	}


	public void setStatusFlag(Character statusFlag) {
		this.statusFlag = statusFlag;
	}


	public Byte getUserSecrtyLevel() {
		return userSecrtyLevel;
	}


	public void setUserSecrtyLevel(Byte userSecrtyLevel) {
		this.userSecrtyLevel = userSecrtyLevel;
	}


	public String getShiftNumber() {
		return shiftNumber;
	}


	public void setShiftNumber(String shiftNumber) {
		this.shiftNumber = shiftNumber;
	}


	public String getJobPostn() {
		return jobPostn;
	}


	public void setJobPostn(String jobPostn) {
		this.jobPostn = jobPostn;
	}


	public Date getAdjstdHireDate() {
		return adjstdHireDate;
	}


	public void setAdjstdHireDate(Date adjstdHireDate) {
		this.adjstdHireDate = adjstdHireDate;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public Date getTrmntnDate() {
		return trmntnDate;
	}


	public void setTrmntnDate(Date trmntnDate) {
		this.trmntnDate = trmntnDate;
	}


	public Integer getHomePhone() {
		return homePhone;
	}


	public void setHomePhone(Integer homePhone) {
		this.homePhone = homePhone;
	}


	public String getDptName() {
		return dptName;
	}


	public void setDptName(String dptName) {
		this.dptName = dptName;
	}


	public String getJobCode() {
		return jobCode;
	}


	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}


	public String getCntrcrCmpnyName() {
		return cntrcrCmpnyName;
	}


	public void setCntrcrCmpnyName(String cntrcrCmpnyName) {
		this.cntrcrCmpnyName = cntrcrCmpnyName;
	}


	public Date getSupervisorLastUpdated() {
		return supervisorLastUpdated;
	}


	public void setSupervisorLastUpdated(Date supervisorLastUpdated) {
		this.supervisorLastUpdated = supervisorLastUpdated;
	}


	public MasterRole getUserRole() {
		return userRole;
	}


	public void setUserRole(MasterRole userRole) {
		this.userRole = userRole;
	}


	public MasterZone getZoneId() {
		return zoneId;
	}


	public void setZoneId(MasterZone zoneId) {
		this.zoneId = zoneId;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}


	public MasterHODivision getUserDivision() {
		return userDivision;
	}


	public void setUserDivision(MasterHODivision userDivision) {
		this.userDivision = userDivision;
	}
 


	
	
	


}
