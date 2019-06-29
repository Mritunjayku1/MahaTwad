
package com.water.ws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.water.bean.ApplicationBean;
import com.water.bean.CategoryFormBean;
import com.water.bean.CircleDivisionFormBean;
import com.water.bean.CmwWaterConnBean;
import com.water.bean.CompanyDtlBean;
import com.water.bean.ConnectionFormBean;
import com.water.bean.DDPaymentFormBean;
import com.water.bean.DashboardCountBean;
import com.water.bean.DistrictFormBean;
import com.water.bean.DistrictTalukFormBean;
import com.water.bean.DivisionSubDivisionFormBean;
import com.water.bean.EmployeeFormBean;
import com.water.bean.OfficeFormBean;
import com.water.bean.OracleDbBean;
import com.water.bean.PaymentFormBean;
import com.water.bean.RegionCircleFormBean;
import com.water.bean.RegionFormBean;
import com.water.bean.TalukVillageFormBean;
import com.water.bean.VillageSchemeFormBean;
import com.water.bean.ZoneDivisionFormBean;
import com.water.dao.DashboardDao;
import com.water.daoImpl.DashboardDaoImpl;
import com.water.model.Application;
import com.water.model.CompanyDtl;
import com.water.model.CompanyPaymentDtl;
import com.water.model.ComplaintDetails;
import com.water.model.Documents;
import com.water.model.EmployeeDetails;
import com.water.model.MasterCategory;
import com.water.model.MasterCircle;
import com.water.model.MasterDistrict;
import com.water.model.MasterHODivision;
import com.water.model.MasterOffice;
import com.water.model.MasterPayment;
import com.water.model.MasterPaymentType;
import com.water.model.MasterReconnection;
import com.water.model.MasterRegion;
import com.water.model.MasterStatus;
import com.water.model.MasterZone;
import com.water.util.HibernateUtil;
import com.water.util.SMSBuilder;
import com.water.util.StatusConstant;

/**
 * @author Mahalingam Created on 02-June-2017 for DashboardService :
 * 
 */
@Path("DashboardService")
public class DashboardService {

	/*ComplaintDao complaintDao;*/
	DashboardDao dashboardDao;

	Gson gson;

	ResourceBundle rb = ResourceBundle.getBundle("resources/constant");

	String EC_Folder = rb.getString("EC_Folder");
	private ApplicationBean applicationBean;

	
	@POST
	@Path("/getviewApp")
	@Produces(MediaType.APPLICATION_JSON)
	public String getviewApp( ApplicationBean appFormBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		//System.out.println(appid);
//AppFormBean appFormBean=new AppFormBean();
		Application appDtls =  dashboardDao.getApplicationDtls(appFormBean);
		
		
		
		
		//for (Application app : appDtls) {
			/*MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");*/
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(appDtls.getAppId());
			applicationBean.setCategoryType(appDtls.getCategoryType().getCategoryName());
			
			
			//applicationBean.setContactPersonName(appDtls.getContactPersonName());
			if(appDtls.getCmwssbZoneNum()!=null && appDtls.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("");
			}
			else if(appDtls.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(appDtls.getCmwssbZoneNum().getZoneDesc());
			}
			
			
			
			if(appDtls.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(appDtls.getIsReconnectionForService()!= null && appDtls.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(appDtls.getIsReconnectionForService()!= null && appDtls.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
		
			applicationBean.setCdoorNo(appDtls.getCdoorNo());
			applicationBean.setCplotNo(appDtls.getCplotNo());
			applicationBean.setCstreetName(appDtls.getCstreetName());
			applicationBean.setClocation(appDtls.getClocation());
			applicationBean.setCpinCode(appDtls.getCpinCode());
			applicationBean.setWebAddress(appDtls.getWebAddress());
			
			if(appDtls.getLandLineNo()!=null){
				applicationBean.setLandLineNo(appDtls.getLandLineNo().toString());
			}
			
			
			if(appDtls.getIsNewConnection()!=null && appDtls.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(appDtls.getIsNewConnection()!=null && appDtls.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(appDtls.getDivId()!=null  && appDtls.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(appDtls.getDivId()!=null)
			{
				applicationBean.setDivId(appDtls.getDivId().getDivDesc());
			}
			applicationBean.setDoorNo(appDtls.getDoorNo());
			applicationBean.setPlotNo(appDtls.getPlotNo());
			applicationBean.setStreetName(appDtls.getStreetName());
			applicationBean.setLocation(appDtls.getLocation());
			applicationBean.setPinCode(appDtls.getPinCode());
			
			if(appDtls.getIsExistConnectionForAlteration()!=null && appDtls.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(appDtls.getIsExistConnectionForAlteration()!=null && appDtls.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
			}
			applicationBean.setSalutation(appDtls.getSalutation());
			applicationBean.setContactPersonName(appDtls.getContactPersonName());
			applicationBean.setLegCompName(appDtls.getLegCompName());
			applicationBean.setMobileNum(appDtls.getMobileNum().toString());

			applicationBean.setEmailAddr(appDtls.getEmailAddr());
			applicationBean.setAddrPremSought(appDtls.getAddrPremSought());
			
			if(appDtls.getReqMld()!=null)
			applicationBean.setReqMld(appDtls.getReqMld().toString());
			if(appDtls.getAnnAssmtVal()!=null)
				applicationBean.setAnnAssmtVal(appDtls.getAnnAssmtVal().toString());
			if(appDtls.getBillNo1()!=null)
				applicationBean.setBillNo1(appDtls.getBillNo1().toString());
			if(appDtls.getBillNo2()!=null)
				applicationBean.setBillNo2(appDtls.getBillNo2().toString());

			if(appDtls.getIntrPlumStatus()!=null && appDtls.getIntrPlumStatus()==0){
				applicationBean.setIntrPlumStatus("NO");
			}
			if(appDtls.getIntrPlumStatus()!=null && appDtls.getIntrPlumStatus()==1){
				applicationBean.setIntrPlumStatus("YES");
			}
			
			if(appDtls.getWatSevProp()!=null && appDtls.getWatSevProp()==0){
				applicationBean.setWatSevProp("NO");
			}
			if(appDtls.getWatSevProp()!=null && appDtls.getWatSevProp()==1){
				applicationBean.setWatSevProp("YES");
			}

			if(appDtls.getWorkType()==0){
				applicationBean.setWorkType("Treated (Chloronated)");
			}
			if(appDtls.getWorkType()==1){
				applicationBean.setWorkType("Raw Water");
			}
			if(appDtls.getWorkType()==2){
				applicationBean.setWorkType("Secondary treated water");
			}
			
			if(appDtls.getPaymentType() != null && appDtls.getPaymentType()==0){
				applicationBean.setPaymentType("Offline");
				applicationBean.setDdNum(appDtls.getDdNum().toString());
			}
			else if(appDtls.getPaymentType() != null){
				applicationBean.setPaymentType("Online");
			}
			
			applicationBean.setCreateDate(appDtls.getCreateTs().toString());
            return gson.toJson(applicationBean);



	}
	
	
	@POST
	@Path("/listViewAllApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listViewAllApplication() {
	dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listViewAllApplication();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType().getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			if(app.getStatusFlag().toString().equals("Y") && app.getInsStatusId()==1)
			{
				applicationBean.setAppStatus("Yet to Start");
			}
			if(app.getStatusFlag().toString().equals("Y") && app.getInsStatusId()!=1 )
			{
				applicationBean.setAppStatus("Approved");
			}
			if(app.getStatusFlag().toString().equals("R"))
			{
				applicationBean.setAppStatus("Rejected");
			}
			if(app.getStatusFlag().toString().equals("C"))
			{
				applicationBean.setAppStatus("Connection Completed");
			}
			if(app.getStatusFlag().toString().equals("P"))
			{
				applicationBean.setAppStatus("Payment Paid");
			}
			
			//applicationBean.setCorrespondenceAddr(app.getCorrespondenceAddr());
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	@POST
	@Path("/listCePendingApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listCePendingApplication() {
	dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listCePendingApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType().getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
			
			
			//applicationBean.setCorrespondenceAddr(app.getCorrespondenceAddr());
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
		
	
	@POST
	@Path("/getApplicationDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getApplicationDetails( ApplicationBean appFormBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		//System.out.println(appid);
//AppFormBean appFormBean=new AppFormBean();
		Application appDtls =  dashboardDao.getApplicationDetails(appFormBean);
		ApplicationBean applicationBean = new ApplicationBean();
		
		if(appDtls!=null)
		{
		
		
		//for (Application app : appDtls) {
			/*MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");*/
			
			applicationBean.setAppId(appDtls.getAppId());
			applicationBean.setCategoryType(appDtls.getCategoryType().getCategoryName());
			
			//applicationBean.setContactPersonName(appDtls.getContactPersonName());
			if(appDtls.getCmwssbZoneNum()!=null && appDtls.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("");
			}
			else if(appDtls.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(appDtls.getCmwssbZoneNum().getZoneDesc());
			}
			
			/*if(appDtls.getReconnectionType() !=null && appDtls.getReconnectionType().getReConnDesc()==null)
			{
			
				applicationBean.setReconnectionType("");
			}
			else
			{
				applicationBean.setReconnectionType(appDtls.getReconnectionType().getReConnDesc());
			}*/
			
			/*if(appDtls.getIsReconnectionForService()==0){
				applicationBean.setIsReconnectionForService("No");
			}
			else{
				applicationBean.setIsReconnectionForService("Yes");
				applicationBean.setReconnectionType(appDtls.getReconnectionType().getReConnDesc());
				
			}*/
			/////////////
			
			if(appDtls.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(appDtls.getIsReconnectionForService()!= null && appDtls.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(appDtls.getIsReconnectionForService()!= null && appDtls.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
		
			applicationBean.setCdoorNo(appDtls.getCdoorNo());
			applicationBean.setCplotNo(appDtls.getCplotNo());
			applicationBean.setCstreetName(appDtls.getCstreetName());
			applicationBean.setClocation(appDtls.getClocation());
			applicationBean.setCpinCode(appDtls.getCpinCode());
			applicationBean.setWebAddress(appDtls.getWebAddress());
			if(appDtls.getLandLineNo()!=null){
				applicationBean.setLandLineNo(appDtls.getLandLineNo().toString());
			}
			
			if(appDtls.getIsNewConnection()!=null && appDtls.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(appDtls.getIsNewConnection()!=null && appDtls.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(appDtls.getDivId()!=null  && appDtls.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(appDtls.getDivId()!=null)
			{
				applicationBean.setDivId(appDtls.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(appDtls.getDoorNo());
			applicationBean.setPlotNo(appDtls.getPlotNo());
			applicationBean.setStreetName(appDtls.getStreetName());
			applicationBean.setLocation(appDtls.getLocation());
			applicationBean.setPinCode(appDtls.getPinCode());
			
			if(appDtls.getIsExistConnectionForAlteration()!=null && appDtls.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(appDtls.getIsExistConnectionForAlteration()!=null && appDtls.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
			}
			applicationBean.setSalutation(appDtls.getSalutation());
			applicationBean.setContactPersonName(appDtls.getContactPersonName());
			applicationBean.setLegCompName(appDtls.getLegCompName());
			applicationBean.setMobileNum(appDtls.getMobileNum().toString());

			applicationBean.setEmailAddr(appDtls.getEmailAddr());
			applicationBean.setAddrPremSought(appDtls.getAddrPremSought());
			
			if(appDtls.getReqMld()!=null)
			applicationBean.setReqMld(appDtls.getReqMld().toString());
			
			if(appDtls.getAnnAssmtVal()!=null)
				applicationBean.setAnnAssmtVal(appDtls.getAnnAssmtVal().toString());
			if(appDtls.getBillNo1()!=null)
				applicationBean.setBillNo1(appDtls.getBillNo1().toString());
			if(appDtls.getBillNo2()!=null)
				applicationBean.setBillNo2(appDtls.getBillNo2().toString());

			if(appDtls.getIntrPlumStatus()!=null && appDtls.getIntrPlumStatus()==0){
				applicationBean.setIntrPlumStatus("NO");
			}
			if(appDtls.getIntrPlumStatus()!=null && appDtls.getIntrPlumStatus()==1){
				applicationBean.setIntrPlumStatus("YES");
			}
			
			if(appDtls.getWatSevProp()!=null && appDtls.getWatSevProp()==0){
				applicationBean.setWatSevProp("NO");
			}
			if(appDtls.getWatSevProp()!=null && appDtls.getWatSevProp()==1){
				applicationBean.setWatSevProp("YES");
			}

			if(appDtls.getWorkType()==0){
				applicationBean.setWorkType("Treated (Chloronated)");
			}
			if(appDtls.getWorkType()==1){
				applicationBean.setWorkType("Raw Water");
			}
			if(appDtls.getWorkType()==2){
				applicationBean.setWorkType("Secondary treated water");
			}
			
			if(appDtls.getPaymentType() != null && appDtls.getPaymentType()==0){
				applicationBean.setPaymentType("Offline");
				applicationBean.setDdNum(appDtls.getDdNum().toString());
			}
			else if(appDtls.getPaymentType() != null){
				applicationBean.setPaymentType("Online");
			}
			
			
			if(appDtls.getMcStatus().getStatusId()==2 && (appDtls.getPaidfinalFee()!=null) ){
				applicationBean.setCeStatus("Approved by MC");
			//	applicationBean.setRemarks("Work is going to  Start");
			}
			if(appDtls.getMcStatus().getStatusId()==2 && (appDtls.getPaidfinalFee()==null ) ){
				applicationBean.setCeStatus("Tendering process underway.");
				//applicationBean.setRemarks("Connection payment not yet received.");
			}
			/*else if(appDtls.getEeStatus().getStatusId()==2){
				applicationBean.setCeStatus("Approved by EE. It is under MC for Final Settlement");
				applicationBean.setRemarks(appDtls.getRemarks().toString());
			}*/
			else if(appDtls.getCeStatus().getStatusId()==2){
				applicationBean.setCeStatus("payment successful");
			//	applicationBean.setCeStatus("Application submitted; verification and inspection pending1.");
				//applicationBean.setRemarks("");
			}
		
			else if(appDtls.getEeStatus().getStatusId()==1 && appDtls.getInsStatusId()==2 && appDtls.getPaidProcessFee()!=null && appDtls.getStatusFlag()=='Y'){
				//applicationBean.setCeStatus("Under by EE. Initial processing cost Rs "+appDtls.getInitialPayment()+" received successfully , "+" you will receive inspection date  shortly  your registered mobile and email.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
				applicationBean.setCeStatus("Inspection completed; pending approval/ tendering process.");
			}
			else if(appDtls.getEeStatus().getStatusId()==2 && appDtls.getInsStatusId()==2  && appDtls.getStatusFlag()=='Y'){
				applicationBean.setCeStatus("Inspection completed; pending approval/ tendering process.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getEeStatus().getStatusId()==2 && appDtls.getStatusFlag()=='R'){
				applicationBean.setCeStatus("EE Rejected your Application");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getMcStatus().getStatusId()==2 && appDtls.getStatusFlag()=='R'){
				applicationBean.setCeStatus("MC Rejected your Application");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getEeStatus().getStatusId()==3 && appDtls.getInsStatusId()==3 && (appDtls.getPaidfinalFee()==null) ){
				applicationBean.setCeStatus("Tender awarded; Please Pay Connection Payment.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getEeStatus().getStatusId()==3 && appDtls.getInsStatusId()==3 && (appDtls.getPaidfinalFee()!=null)){
				applicationBean.setCeStatus("Tendering process underway.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getMcStatus().getStatusId()==3 && appDtls.getInsStatusId()==3 && (appDtls.getPaidfinalFee()!=null)){
				applicationBean.setCeStatus("Tender awarded; Work under progress.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getEeStatus().getStatusId()==2 && appDtls.getInsStatusId()==1 && appDtls.getPaidProcessFee()==null){
				applicationBean.setCeStatus("Under by EE. Initial processing cost Rs "+appDtls.getInitialPayment()+"  send it to Your registered mobile and email.Please pay this url :  http://localhost:8080/TwadWeb/initialPayment.do");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else{
				applicationBean.setCeStatus("payment successful");
				//applicationBean.setCeStatus("Application submitted; verification and inspection pending.");
				//applicationBean.setRemarks("Address Verification going on");
			}
			
			
			applicationBean.setCreateDate(appDtls.getCreateTs().toString());


		}
		else
		{
			applicationBean.setAppId("Application No Invalid!");
			applicationBean.setCreateDate("Application No Invalid!");
			applicationBean.setCeStatus("Application No Invalid!");
		}
		
		//}
		//System.out.println("app:"+appDtls);

		return gson.toJson(applicationBean);

		
		//return gson.toJson(appDtls);
		//return "NoData";

	}
	
	
	@POST
	@Path("/listEePendingApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listEePendingApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listEePendingApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType().getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			
			if(app.getRemarks()!=null )
			{
				applicationBean.setRemarks(app.getRemarks());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			
			/*if(app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		*/
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	
	
	@POST
	@Path("/listTrackApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listTrackApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listTrackApplication();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType().getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			
			if(app.getRemarks()!=null )
			{
				applicationBean.setRemarks(app.getRemarks());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			
			if(app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	@POST
	@Path("/listMcPendingApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listMcPendingApplication() {
		return new Gson().toJson(new DashboardDaoImpl().listMcPendingApplicationDtls());
		}
	
	
	@POST
	@Path("/getUpfrontCharges")
	@Produces(MediaType.APPLICATION_JSON)
	public DDPaymentFormBean getUpfrontCharges(DDPaymentFormBean ddPaymentFormBean ){
		return new DashboardDaoImpl().getUpfrontCharges(ddPaymentFormBean);
		}
	
	
	
	@POST
	@Path("/listAfterInspection")
	@Produces(MediaType.APPLICATION_JSON)
	public String listAfterInspection() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<CompanyDtl> appDtls = dashboardDao.listAfterInspection();
		List<CompanyDtlBean> applicationBeanList = new ArrayList<CompanyDtlBean>();
		for (CompanyDtl app : appDtls) {
			//MasterZone mastr=new MasterZone();
			//mastr.setZoneDesc("other");
			CompanyDtlBean applicationBean = new CompanyDtlBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
		//	applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			/*if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}*/
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			//applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			/*if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}*/
			/*if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}*/
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
		//	applicationBean.setPinCode(app.getCpinCode());
			
			
			applicationBean.setLegCompName(app.getLegCompName());
		//	applicationBean.setCreateDate(app.getCreateTs().toString());
			/*if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}*/
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/listEstimate")
	@Produces(MediaType.APPLICATION_JSON)
	public String listEstimate() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<CompanyDtl> appDtls = dashboardDao.listEstimate();
		List<CompanyDtlBean> applicationBeanList = new ArrayList<CompanyDtlBean>();
		for (CompanyDtl app : appDtls) {
			//MasterZone mastr=new MasterZone();
			//mastr.setZoneDesc("other");
			CompanyDtlBean applicationBean = new CompanyDtlBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
		//	applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			/*if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}*/
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			//applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			/*if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}*/
			/*if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}*/
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
		//	applicationBean.setPinCode(app.getCpinCode());
			
			
			applicationBean.setLegCompName(app.getLegCompName());
		//	applicationBean.setCreateDate(app.getCreateTs().toString());
			/*if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}*/
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/listMOU")
	@Produces(MediaType.APPLICATION_JSON)
	public String listMOU() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<CompanyDtl> appDtls = dashboardDao.listMOU();
		List<CompanyDtlBean> applicationBeanList = new ArrayList<CompanyDtlBean>();
		for (CompanyDtl app : appDtls) {
			//MasterZone mastr=new MasterZone();
			//mastr.setZoneDesc("other");
			CompanyDtlBean applicationBean = new CompanyDtlBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
		//	applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			/*if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}*/
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			//applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			/*if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}*/
			/*if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}*/
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
		//	applicationBean.setPinCode(app.getCpinCode());
			
			
			applicationBean.setLegCompName(app.getLegCompName());
		//	applicationBean.setCreateDate(app.getCreateTs().toString());
			/*if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}*/
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/eeApplicationFeePending")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeApplicationFeePending(CompanyDtlBean companyDtlBean) {

		return new Gson().toJson(new DashboardDaoImpl().eeApplicationFeePending(companyDtlBean));
	}
	
	@POST
	@Path("/eeUpfrontChargesPending")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeUpfrontChargesPending(CompanyDtlBean companyDtlBean) {

		return new Gson().toJson(new DashboardDaoImpl().eeUpfrontChargesPending(companyDtlBean));
	}
	
	@POST
	@Path("/eeFullPaymentPending")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeFullPaymentPending(CompanyDtlBean companyDtlBean) {

		return new Gson().toJson(new DashboardDaoImpl().eeFullPaymentPending(companyDtlBean));
	}
	
	@POST
	@Path("/eePaymentPending")
	@Produces(MediaType.APPLICATION_JSON)
	public String eePaymentPending(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eePaymentPending(companyDtlBean));

	}
	
	
	@POST
	@Path("/eePaymentCompleted")
	@Produces(MediaType.APPLICATION_JSON)
	public String eePaymentCompleted(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eePaymentCompleted(companyDtlBean));

	}
	@POST
	@Path("/eeInspectedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeInspectedApplication(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eeInspectedApplication(companyDtlBean));

	}
	@POST
	@Path("/eeMCApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeMCApproved(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eeMCApproved(companyDtlBean));

	}
	@POST
	@Path("/eeFullPaymentCompleted")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeFullPaymentCompleted(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eeFullPaymentCompleted(companyDtlBean));

	}
	@POST
	@Path("/eeExecution")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeExecution(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eeExecution(companyDtlBean));

	}
	
	
	
	
	@POST
	@Path("/listProsFeePendingPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public String listProsFeePendingPayment() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listProsFeePendingPayment();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	
	@POST
	@Path("/listeeConPendingPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public String listeeConPendingPayment() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listEePaymentPendingApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/listConPendingPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public String listConPendingPayment() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listConPendingPayment();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/listConPaidDtls")
	@Produces(MediaType.APPLICATION_JSON)
	public String listConPaidDtls() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listConPaidDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			
			
			applicationBean.setEstimationCost(String.valueOf(app.getPaidfinalFee()));
			
			applicationBean.setInitialPayment(app.getPaidProcessFee());
			
			/*if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	
	
	@GET
	@Path("/listEeApprovedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listEeApprovedApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listEeApprovedApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	
	@GET
	@Path("/listMcApprovedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listMcApprovedApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listMcApprovedApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}

	@GET
	@Path("/listCeApprovedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listCeApprovedApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listceApprovedApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			/*if(app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}*/
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}

	
	@POST
	@Path("/CeApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String CeApproved(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.ceApproved(applicationBean));

	}
	

	@POST
	@Path("/registeredApplicationApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String registeredApplicationApproved(DDPaymentFormBean dDPaymentFormBean) {
	Session	session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
try{
	transaction.begin();
	CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
	companyDtl.setRegion((MasterRegion) session.get(MasterRegion.class, Integer.parseInt(dDPaymentFormBean.getRegion())));
	companyDtl.setCircle((MasterCircle) session.get(MasterCircle.class, Integer.parseInt(dDPaymentFormBean.getCircle())));
	companyDtl.setDivision((MasterHODivision) session.get(MasterHODivision.class, Integer.parseInt(dDPaymentFormBean.getDivision())));
	companyDtl.setEeStatus( (MasterStatus)session.get(MasterStatus.class,1));
	companyDtl.setActive(2);
	companyDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
	session.update(companyDtl);
	transaction.commit();
	
	//maha addedd
	
	
	final Integer emailType=3;
	final String status="test";
	
	final Integer smsType = 2;
	final String smsTemp="Dear%20sir,%20Your%20"+dDPaymentFormBean.getAppId()+"%20Application%20Assigned%20to%20Executive%20Officer.";
	final String smsTempEE="You%20have%20received%20Application"+dDPaymentFormBean.getAppId();
	final String application_ID = dDPaymentFormBean.getAppId();
	Thread notify = new Thread(new Runnable() {
		@Override
		public void run() {
			SMSBuilder obj = new SMSBuilder();
			obj.getSmsTemplate(application_ID,smsType,smsTemp);
			obj.getStatus(application_ID, status);
			
			obj.getSmsTemplatetoEE(application_ID,smsType,smsTempEE);
			obj.getStatustoEE(application_ID, status);
		}
	}, "notify");
	notify.start();
	
}
catch(Exception e){
	e.printStackTrace();
	transaction.rollback();
	return "Application not Approved";
}
finally{
	session.close();
}
		return "Application Approved";

	}
	
	
	
	
	
	@POST
	@Path("/transferApplicationSave")
	@Produces(MediaType.APPLICATION_JSON)
	public String transferApplicationSave(DDPaymentFormBean dDPaymentFormBean) {
	Session	session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
try{
	transaction.begin();
	CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
	companyDtl.setRegion((MasterRegion) session.get(MasterRegion.class, Integer.parseInt(dDPaymentFormBean.getRegion())));
	companyDtl.setCircle((MasterCircle) session.get(MasterCircle.class, Integer.parseInt(dDPaymentFormBean.getCircle())));
	companyDtl.setDivision((MasterHODivision) session.get(MasterHODivision.class, Integer.parseInt(dDPaymentFormBean.getDivision())));
	companyDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
	session.update(companyDtl);
	transaction.commit();
	
	//maha addedd
	
	
	final Integer emailType=3;
	final String status="test";
	
	final Integer smsType = 2;
	final String smsTemp="Dear%20sir,%20Your%20"+dDPaymentFormBean.getAppId()+"%20Application%20Assigned%20to%20Executive%20Officer.";
	final String smsTempEE="You%20have%20received%20Application"+dDPaymentFormBean.getAppId();
	final String application_ID = dDPaymentFormBean.getAppId();
	Thread notify = new Thread(new Runnable() {
		@Override
		public void run() {
			SMSBuilder obj = new SMSBuilder();
			obj.getSmsTemplate(application_ID,smsType,smsTemp);
			obj.getStatus(application_ID, status);
			
			obj.getSmsTemplatetoEE(application_ID,smsType,smsTempEE);
			obj.getStatustoEE(application_ID, status);
		}
	}, "notify");
	notify.start();
	
}
catch(Exception e){
	e.printStackTrace();
	transaction.rollback();
	return "Application not Transfered";
}
finally{
	session.close();
}
		return "Application Transfered";

	}
	
	
	
	@POST
	@Path("/registeredApplicationRejected")
	@Produces(MediaType.APPLICATION_JSON)
	public String registeredApplicationRejected(DDPaymentFormBean dDPaymentFormBean) {
		Session	session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	try{
		transaction.begin();
		CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
		companyDtl.setActive(0);
		companyDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
		session.update(companyDtl);
		transaction.commit();
		
	}
	catch(Exception e){
		e.printStackTrace();
		transaction.rollback();
		return "Application is not Rejected";
	}
	finally{
		session.close();
	}
			return "Application Rejected";

		}


	@POST
	@Path("/approvedApplicationEdit")
	@Produces(MediaType.APPLICATION_JSON)
	public String approvedApplicationEdit(DDPaymentFormBean dDPaymentFormBean) {
	Session	session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
try{
	transaction.begin();
	CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
	companyDtl.setDivision(null);
	companyDtl.setEeStatus( (MasterStatus)session.get(MasterStatus.class,1));
	companyDtl.setActive(1);
	session.update(companyDtl);
	transaction.commit();
	
		
}
catch(Exception e){
	e.printStackTrace();
	transaction.rollback();
	return "Application unable to Edit";
}
finally{
	session.close();
}
		return "Application Moved to Pending Tab";

	}

	
	
	
	
	@POST
	@Path("/ddPaymentApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String ddPaymentApproved(DDPaymentFormBean dDPaymentFormBean) {
	Session	session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
try{
	
	Transaction tx1 =  session.beginTransaction();
	CompanyDtl companyDtl = (CompanyDtl)session.get(CompanyDtl.class,dDPaymentFormBean.getAppId());
	companyDtl.setEeStatus( (MasterStatus)session.get(MasterStatus.class,1));
	companyDtl.setActive(2);
	companyDtl.setUpdateTs(new Date());
	companyDtl.setUpdateUserId("Administrator");
	session.update(companyDtl);
	tx1.commit();
	
	
	transaction.begin();
	CompanyPaymentDtl  companyPaymentDtl = (CompanyPaymentDtl) session.get(CompanyPaymentDtl.class, dDPaymentFormBean.getCompanyPaymentDtlID());
	companyPaymentDtl.setPaymentStatusFlag('A');
	companyPaymentDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
	session.update(companyPaymentDtl);
	transaction.commit();
	
}
catch(Exception e){
	e.printStackTrace();
	transaction.rollback();
	return "DD is not Approved";
}
finally{
	session.close();
}
		return "DD Approved";

	}
	
	@POST
	@Path("/ddPaymentRejected")
	@Produces(MediaType.APPLICATION_JSON)
	public String ddPaymentRejected(DDPaymentFormBean dDPaymentFormBean) {
		Session	session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	try{
		transaction.begin();
		CompanyPaymentDtl  companyPaymentDtl = (CompanyPaymentDtl) session.get(CompanyPaymentDtl.class, dDPaymentFormBean.getCompanyPaymentDtlID());
		companyPaymentDtl.setPaymentStatusFlag('R');
		companyPaymentDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
		session.update(companyPaymentDtl);
		transaction.commit();
		
	}
	catch(Exception e){
		e.printStackTrace();
		transaction.rollback();
		return "DD is not Rejected";
	}
	finally{
		session.close();
	}
			return "DD REjected";

		}
	
	@POST
	@Path("/paymentApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String paymentApproved(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.paymentApproved(applicationBean));

	}
	
	@POST
	@Path("/eeRejcted")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeRejcted(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.eeRejected(applicationBean));

	}
	
	@POST
	@Path("/SendEstimationCost")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendEstimationCost(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return dashboardDao.SendEstimationCost(applicationBean);

	}
	
	@POST
	@Path("/SendOracleDb")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendOracleDb(OracleDbBean oracleDbBean) throws ParseException {
		
		SimpleDateFormat source = new SimpleDateFormat("dd-mm-yyyy");
		
		SimpleDateFormat target = new SimpleDateFormat("yyyy-mm-dd");
		
		
		CmwWaterConnBean cmwWaterConnBean = new CmwWaterConnBean();
		
		cmwWaterConnBean.setChALLAN_NO(oracleDbBean.getAppId());
		cmwWaterConnBean.setAdDITIONAL_AMT(((Float)Float.parseFloat(oracleDbBean.getInitialPaymentCost())).intValue());
		cmwWaterConnBean.setChALLAN_AMT(((Float)Float.parseFloat(oracleDbBean.getEstimationCost())).intValue());
		cmwWaterConnBean.setDaTE_OF_CONN(target.parse(target.format(source.parse(oracleDbBean.getCompletionDate()))));
		cmwWaterConnBean.setDaTE_OF_SANC(target.parse(target.format(source.parse(oracleDbBean.getCommissionDate()))));
		cmwWaterConnBean.setAdDITION_DATE(target.parse(target.format(source.parse(oracleDbBean.getCommissionDate()))));
		cmwWaterConnBean.setGst_AMT(((Float)Float.parseFloat(oracleDbBean.getGstAmount())).intValue());
		cmwWaterConnBean.setTotal_AMT(((Float)Float.parseFloat(oracleDbBean.getTotalAmount())).intValue());
		
		

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return dashboardDao.SendOracleDb(cmwWaterConnBean);

	}
	@POST
	@Path("/eeWidthdraw")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeWidthdraw(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.eeWidthdraw(applicationBean));

	}
	
	
	@POST
	@Path("/SendinitialPaymentCost")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendinitialPaymentCost(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.sendInitialPaymentCost(applicationBean));

	}
	@POST
	@Path("/isMcDicision")
	@Produces(MediaType.APPLICATION_JSON)
	public String isMcDicision(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.isMcDicision(applicationBean));

	}
	
	@POST
	@Path("/isMcTrckDicision")
	@Produces(MediaType.APPLICATION_JSON)
	public String isMcTrckDicision(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.isMcTrckDicision(applicationBean));

	}
	
	
	
	
	/*@POST
	@Path("/SendInspectionDateOLD")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendInspectionDateOLD(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.SendInspectionDate(applicationBean));

	}*/
	@POST
	@Path("/SendInspectionDate")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendInspectionDate(CompanyDtlBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.SendInspectionDate(applicationBean));

	}
	
	

	
	@POST
	@Path("/getceDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getceDashboardCount() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();

		//DashboardBean dashboardBean = new DashboardBean();
		DashboardCountBean dashboardCountBean=new DashboardCountBean();

		for (Object[] rowData : dashboardDao.getceDashboardCount()) {
			dashboardCountBean.setTotalRegister(Integer.parseInt(rowData[0]
					.toString()));
			dashboardCountBean.setPenndingApplication(Integer.parseInt(rowData[1]
					.toString()));
			dashboardCountBean.setApprovedApplication(Integer.parseInt(rowData[2]
					.toString()));

			dashboardCountBean.setPaidApplication(Integer.parseInt(rowData[3]
					.toString()));

			dashboardCountBean.setYesCount(3);

			dashboardCountBean.setNoCount(30);

			dashboardCountBean.setNACount(20);
			dashboardCountBean.setNACount(20);
			

		}
		return gson.toJson(dashboardCountBean);
	}


	@POST
	@Path("/getPaymentDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPaymentDashboardCount() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();

		//DashboardBean dashboardBean = new DashboardBean();
		DashboardCountBean dashboardCountBean=new DashboardCountBean();

		for (Object[] rowData : dashboardDao.getPaymentDashboardCount()) {
			
			
			dashboardCountBean.setApprovedApplication(Integer.parseInt(rowData[0]
					.toString()));

			dashboardCountBean.setRejectedApplication(Integer.parseInt(rowData[1]
					.toString()));
			dashboardCountBean.setPenndingApplication(Integer.parseInt(rowData[2]
					.toString()));

			dashboardCountBean.setYesCount(3);

			dashboardCountBean.setNoCount(30);

			dashboardCountBean.setNACount(20);
			dashboardCountBean.setNACount(20);
			

		}
		return gson.toJson(dashboardCountBean);
	}
	
	
	
	@POST
	@Path("/registeredApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String registeredApplication() {
		return new Gson().toJson(new DashboardDaoImpl().registeredApplication());

	}
	
	@POST
	@Path("/approvedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String approvedApplication() {
		return new Gson().toJson(new DashboardDaoImpl().approvedApplication());

	}
	@POST
	@Path("/transferApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String transferApplication() {
		return new Gson().toJson(new DashboardDaoImpl().transferApplication());

	}
	
	@POST
	@Path("/rejectedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String rejectedApplication() {
		return new Gson().toJson(new DashboardDaoImpl().rejectedApplication());

	}

	@POST
	@Path("/paymentPendingList")
	@Produces(MediaType.APPLICATION_JSON)
	public String paymentPendingList() {
		return new Gson().toJson(new DashboardDaoImpl().paymentPendingList());

	}
		
	
	@GET
	@Path("/paymentRejectedList")
	@Produces(MediaType.APPLICATION_JSON)
	public String paymentRejectedList() {

		return new Gson().toJson(new DashboardDaoImpl().paymentRejectedList());
	}

	
	@GET
	@Path("/paymentApprovedList")
	@Produces(MediaType.APPLICATION_JSON)
	public String paymentApprovedList() {

		return new Gson().toJson(new DashboardDaoImpl().paymentApprovedList());
	}

	
	
	@GET
	@Path("/ddPaymentViewAllList")
	@Produces(MediaType.APPLICATION_JSON)
	public String ddPaymentViewAllList() {
		
		List<CompanyDtl> companyDtlsList = new DashboardDaoImpl().ddPaymentViewAllList();
		List<DDPaymentFormBean> ddPaymentFormBeanList = new ArrayList<>();
		for (CompanyDtl app : companyDtlsList) {
			DDPaymentFormBean ddPaymentFormBean = new DDPaymentFormBean();

ddPaymentFormBean.setAppId(app.getAppId());
ddPaymentFormBean.setLegCompName(app.getLegCompName());
ddPaymentFormBean.setCdoorNo(app.getCdoorNo());
ddPaymentFormBean.setCplotNo(app.getCplotNo());
ddPaymentFormBean.setCstreetName(app.getCstreetName());
ddPaymentFormBean.setClocation(app.getClocation());
ddPaymentFormBean.setCpinCode(app.getCpinCode());
ddPaymentFormBean.setSalutation(app.getSalutation());
ddPaymentFormBean.setContactPersonName(app.getContactPersonName());
ddPaymentFormBean.setMobileNum(app.getMobileNum());
ddPaymentFormBean.setEmailAddr(app.getEmailAddr());
ddPaymentFormBean.setCategoryType(app.getCategoryType().getCategoryName());
if(null != app.getDivision())
ddPaymentFormBean.setDivisionName(app.getDivision().getDivisionName());

ddPaymentFormBean.setAddrPremSought(app.getAddrPremSought());
ddPaymentFormBean.setDoorNo(app.getDoorNo());
ddPaymentFormBean.setPlotNo(app.getPlotNo());
ddPaymentFormBean.setStreetName(app.getStreetName());
ddPaymentFormBean.setLocation(app.getLocation());
ddPaymentFormBean.setDistrict(app.getDistrict().getDistrictName());
if(null != app.getTaluk())
ddPaymentFormBean.setTaluk(app.getTaluk().getTalukName());
if(null != app.getVillage())
ddPaymentFormBean.setVillage(app.getVillage().getVillageName());
ddPaymentFormBean.setPincode(app.getPinCode());
ddPaymentFormBean.setSurveyFieldNo(app.getSurveyFieldNo());
ddPaymentFormBean.setIsNewConnection(app.getIsNewConnection());
ddPaymentFormBean.setReqMld(app.getReqMld());
ddPaymentFormBean.setGstAmount(app.getGstAmount());
ddPaymentFormBean.setTotalAmount(app.getTotalAmount());
ddPaymentFormBean.setIntrPlumStatus(app.getIntrPlumStatus());
ddPaymentFormBean.setWorkType(app.getWorkType());
ddPaymentFormBean.setPaymentStatus(app.getPaymentStatus());
ddPaymentFormBean.setCreateDate(app.getCreateTs().toString());

ddPaymentFormBean.setMcUser(app.getMcUser());
ddPaymentFormBean.setMcSLTCUser(app.getMcSLTCUser());
ddPaymentFormBean.setMcBoardUser(app.getMcBoardUser());

if(app.getActive()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.HOUSER_ASSIGN_OFFICE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PENDING_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_APPLICATION_FEE+"\n"+StatusConstant.EEUSER_PENDING_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.MCUSER_APPROVED_FULL_PAYMENT +"\n"+StatusConstant.EEUSER_PENDING_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==4){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_FULL_PAYMENT);
}
/*else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_WAITING_INSPECTION);
}*/
else if(app.getActive()==3 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_UPFRONT_CHARGES+"\n"+StatusConstant.MCUSER_PENDING_FULL_PAYMENT_APPROVAL);
}


			
			ddPaymentFormBeanList.add(ddPaymentFormBean);
		}
		

		return new Gson().toJson(ddPaymentFormBeanList);
	}
	
	
	
	
	@POST
	@Path("/eeViewAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeViewAll(CompanyDtlBean companyDtlBean){
		
		List<CompanyDtl> companyDtlsList = new DashboardDaoImpl().eeViewAll(companyDtlBean);
		List<DDPaymentFormBean> ddPaymentFormBeanList = new ArrayList<>();
		for (CompanyDtl app : companyDtlsList) {
			DDPaymentFormBean ddPaymentFormBean = new DDPaymentFormBean();

ddPaymentFormBean.setAppId(app.getAppId());
ddPaymentFormBean.setLegCompName(app.getLegCompName());
ddPaymentFormBean.setCdoorNo(app.getCdoorNo());
ddPaymentFormBean.setCplotNo(app.getCplotNo());
ddPaymentFormBean.setCstreetName(app.getCstreetName());
ddPaymentFormBean.setClocation(app.getClocation());
ddPaymentFormBean.setCpinCode(app.getCpinCode());
ddPaymentFormBean.setSalutation(app.getSalutation());
ddPaymentFormBean.setContactPersonName(app.getContactPersonName());
ddPaymentFormBean.setMobileNum(app.getMobileNum());
ddPaymentFormBean.setEmailAddr(app.getEmailAddr());
ddPaymentFormBean.setCategoryType(app.getCategoryType().getCategoryName());
if(null != app.getDivision())
ddPaymentFormBean.setDivisionName(app.getDivision().getDivisionName());

ddPaymentFormBean.setAddrPremSought(app.getAddrPremSought());
ddPaymentFormBean.setDoorNo(app.getDoorNo());
ddPaymentFormBean.setPlotNo(app.getPlotNo());
ddPaymentFormBean.setStreetName(app.getStreetName());
ddPaymentFormBean.setLocation(app.getLocation());
ddPaymentFormBean.setDistrict(app.getDistrict().getDistrictName());
if(null != app.getTaluk())
ddPaymentFormBean.setTaluk(app.getTaluk().getTalukName());
if(null != app.getVillage())
ddPaymentFormBean.setVillage(app.getVillage().getVillageName());
ddPaymentFormBean.setPincode(app.getPinCode());
ddPaymentFormBean.setSurveyFieldNo(app.getSurveyFieldNo());
ddPaymentFormBean.setIsNewConnection(app.getIsNewConnection());
ddPaymentFormBean.setReqMld(app.getReqMld());
ddPaymentFormBean.setGstAmount(app.getGstAmount());
ddPaymentFormBean.setTotalAmount(app.getTotalAmount());
ddPaymentFormBean.setIntrPlumStatus(app.getIntrPlumStatus());
ddPaymentFormBean.setWorkType(app.getWorkType());
ddPaymentFormBean.setPaymentStatus(app.getPaymentStatus());
ddPaymentFormBean.setCreateDate(app.getCreateTs().toString());

ddPaymentFormBean.setMcUser(app.getMcUser());
ddPaymentFormBean.setMcSLTCUser(app.getMcSLTCUser());
ddPaymentFormBean.setMcBoardUser(app.getMcBoardUser());

if(app.getActive()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.HOUSER_ASSIGN_OFFICE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PENDING_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_APPLICATION_FEE+"\n"+StatusConstant.EEUSER_PENDING_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.MCUSER_APPROVED_FULL_PAYMENT +"\n"+StatusConstant.EEUSER_PENDING_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==4){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_FULL_PAYMENT);
}
/*else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_WAITING_INSPECTION);
}*/
else if(app.getActive()==3 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_UPFRONT_CHARGES+"\n"+StatusConstant.MCUSER_PENDING_FULL_PAYMENT_APPROVAL);
}


			
			ddPaymentFormBeanList.add(ddPaymentFormBean);
		}
		

		return new Gson().toJson(ddPaymentFormBeanList);
	}
	
	
	

	@POST
	@Path("/paymentViewForm")
	@Produces(MediaType.APPLICATION_JSON)
	public DDPaymentFormBean paymentViewForm(DDPaymentFormBean ddPaymentFormBean) {
		
		CompanyDtl app = new DashboardDaoImpl().paymentViewForm(ddPaymentFormBean);
		
if(app !=null){
ddPaymentFormBean.setAppId(app.getAppId());
ddPaymentFormBean.setLegCompName(app.getLegCompName());
ddPaymentFormBean.setCdoorNo(app.getCdoorNo());
ddPaymentFormBean.setCplotNo(app.getCplotNo());
ddPaymentFormBean.setCstreetName(app.getCstreetName());
ddPaymentFormBean.setClocation(app.getClocation());
ddPaymentFormBean.setCpinCode(app.getCpinCode());
ddPaymentFormBean.setSalutation(app.getSalutation());
ddPaymentFormBean.setContactPersonName(app.getContactPersonName());
ddPaymentFormBean.setMobileNum(app.getMobileNum());
ddPaymentFormBean.setEmailAddr(app.getEmailAddr());
ddPaymentFormBean.setCategoryType(app.getCategoryType().getCategoryName());
if(null != app.getDivision())
ddPaymentFormBean.setDivisionName(app.getDivision().getDivisionName());

ddPaymentFormBean.setAddrPremSought(app.getAddrPremSought());

ddPaymentFormBean.setDoorNo(app.getDoorNo());
ddPaymentFormBean.setPlotNo(app.getPlotNo());
ddPaymentFormBean.setStreetName(app.getStreetName());
ddPaymentFormBean.setLocation(app.getLocation());
ddPaymentFormBean.setDistrict(app.getDistrict().getDistrictName());
if(null != app.getTaluk())
ddPaymentFormBean.setTaluk(app.getTaluk().getTalukName());
if(null != app.getVillage())
ddPaymentFormBean.setVillage(app.getVillage().getVillageName());
ddPaymentFormBean.setPincode(app.getPinCode());
ddPaymentFormBean.setSurveyFieldNo(app.getSurveyFieldNo());

ddPaymentFormBean.setCreateDate(app.getCreateTs().toString());

ddPaymentFormBean.setIsNewConnection(app.getIsNewConnection());
if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
	ddPaymentFormBean.setIsNewConnectionDisplay("NO");
}
else if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
	ddPaymentFormBean.setIsNewConnectionDisplay("YES");
}

ddPaymentFormBean.setReqMld(app.getReqMld());
/*ddPaymentFormBean.setApplicationFee(app.getApplicationFee()+"");
ddPaymentFormBean.setGstPercent(app.getGstPercent()+"");
ddPaymentFormBean.setUpfrontCharges(app.getUpfrontCharges());
ddPaymentFormBean.setGstAmount(app.getGstAmount());
ddPaymentFormBean.setTotalAmount(app.getTotalAmount());*/

/*ddPaymentFormBean.setIntrPlumStatus(app.getIntrPlumStatus());

ddPaymentFormBean.setWorkType(app.getWorkType());
*/

if(app.getIntrPlumStatus()!=null && app.getIntrPlumStatus()==0){
	ddPaymentFormBean.setIntrPlumStatusDisplay("NO");
}
else if(app.getIntrPlumStatus()!=null && app.getIntrPlumStatus()==1){
	ddPaymentFormBean.setIntrPlumStatusDisplay("YES");
}


if(app.getWorkType()==0){
	ddPaymentFormBean.setWorkTypeDisplay("Treated (Chloronated)");
}
else if(app.getWorkType()==1){
	ddPaymentFormBean.setWorkTypeDisplay("Secondary treated water");
}

ddPaymentFormBean.setPaymentStatus(app.getPaymentStatus());

if(app.getPaymentStatus()==0){
	ddPaymentFormBean.setPaymentStatusDisplay("Pending");
}
else{
	ddPaymentFormBean.setPaymentStatusDisplay("Paid");
}




if(app.getActive()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.HOUSER_ASSIGN_OFFICE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PENDING_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_APPLICATION_FEE+"\n"+StatusConstant.EEUSER_PENDING_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.MCUSER_APPROVED_FULL_PAYMENT +"\n"+StatusConstant.EEUSER_PENDING_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==4){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_FULL_PAYMENT);
}
/*else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_WAITING_INSPECTION);
}*/
else if(app.getActive()==3 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_UPFRONT_CHARGES+"\n"+StatusConstant.MCUSER_PENDING_FULL_PAYMENT_APPROVAL);
}	

}


List<MasterPayment> masterPaymentList = new DashboardDaoImpl().getManagementSetpaymentList(ddPaymentFormBean.getAppId());
for(MasterPayment masterPayment :masterPaymentList){
	
	if(masterPayment.getPaymentType().getPaymentTypeId()==1){
		ddPaymentFormBean.setApplicationFee(masterPayment.getPaymentAmount()+"");
		ddPaymentFormBean.setGstPercent(masterPayment.getGstPercent()+"");
		ddPaymentFormBean.setGstAmount(masterPayment.getGstAmount());
		ddPaymentFormBean.setTotalAmount(masterPayment.getTotalAmount());
	}
	else if(masterPayment.getPaymentType().getPaymentTypeId()==2)
	   ddPaymentFormBean.setUpfrontCharges(Integer.parseInt(masterPayment.getTotalAmount()));
	else if(masterPayment.getPaymentType().getPaymentTypeId()==3)
		   ddPaymentFormBean.setFullPayment(Integer.parseInt(masterPayment.getTotalAmount()));
	
}


List<DDPaymentFormBean> ddPaymentFormBeans = new ArrayList<>();

List<CompanyPaymentDtl> companyPaymentDtlList = new DashboardDaoImpl().getUserPaymentList(ddPaymentFormBean.getAppId());

for(CompanyPaymentDtl companyPaymentDtl :companyPaymentDtlList){
	DDPaymentFormBean ddPaymentBean = new DDPaymentFormBean();
	ddPaymentBean.setTransactionRefNo(companyPaymentDtl.getTransactionRefNo());
	ddPaymentBean.setBankRefNo(companyPaymentDtl.getBankRefNo());
	
	ddPaymentBean.setPaymentType(companyPaymentDtl.getPaymentType().getPaymentType());
	ddPaymentBean.setPaymentAmount(companyPaymentDtl.getPaymentAmount());
	
	ddPaymentFormBeans.add(ddPaymentBean);
}

ddPaymentFormBean.setPaymentList(ddPaymentFormBeans);

		return ddPaymentFormBean;
	}

	
	
	@POST
	@Path("/geteeDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String geteeDashboardCount(CompanyDtlBean companyDtlBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();

		//DashboardBean dashboardBean = new DashboardBean();
		DashboardCountBean dashboardCountBean=new DashboardCountBean();

		for (Object[] rowData : dashboardDao.geteeDashboardCount(companyDtlBean)) {
			dashboardCountBean.setApplicationFeePending(Integer.parseInt(rowData[0]
					.toString()));
			dashboardCountBean.setUpfrontChargesPending(Integer.parseInt(rowData[1]
					.toString()));
			dashboardCountBean.setFullPaymentPending(Integer.parseInt(rowData[2]
					.toString()));
			
			dashboardCountBean.setFullPaymentCompleted(Integer.parseInt(rowData[3]
					.toString()));
			dashboardCountBean.setExecution(Integer.parseInt(rowData[4]
					.toString()));

			/*dashboardCountBean.setApprovedApplication(Integer.parseInt(rowData[3]
					.toString()));*/
			

			dashboardCountBean.setYesCount(3);

			dashboardCountBean.setNoCount(30);

			dashboardCountBean.setNACount(20);
			dashboardCountBean.setNACount(20);

		}
		return gson.toJson(dashboardCountBean);
	}
	
	@POST
	@Path("/getMCDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMCDashboardCount() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();

		DashboardCountBean dashboardCountBean=new DashboardCountBean();

		/*for (Object[] rowData : dashboardDao.getMCDashboardCount()) {
			*/
			dashboardCountBean.setPenndingApplication(Integer.parseInt(dashboardDao.getMCDashboardCount()));
			
		//}
		return gson.toJson(dashboardCountBean);
	}

	
	
	
	
	
	
	
	


/*
	@POST
	@Path("updateDocumentInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateDocumentInfo(ComplaintBean complaintBean) {
		gson = new Gson();
		complaintDao = new ComplaintDaoImpl();
		ComplaintDetails complaintDetails = new ComplaintDetails();
		complaintDetails = complaintDao.updateDocumentInfo(complaintBean);
		return gson.toJson(complaintDetails);
	}*/




	@SuppressWarnings("resource")
	@POST
	@Path("/fileUpload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String fileUpload(FormDataMultiPart multipartdata) {
		InputStream inputstream = null;
		OutputStream outputstream = null;
		Session session = null;
		Transaction transaction = null;
		String result = null;

		try {
			if (multipartdata != null) {

				Integer userId = Integer.parseInt(multipartdata.getField(
						"userId").getValue());

				String complaintNumber = multipartdata.getField(
						"complaintNumber").getValue();

				Integer complaintID = Integer.parseInt(multipartdata.getField(
						"complaint_No").getValue());

				FormDataBodyPart bodypartdata = multipartdata
						.getField("fileObject");
				ContentDisposition contentdisposition = bodypartdata
						.getContentDisposition();

				InputStream uploadedInputStream = bodypartdata
						.getValueAs(InputStream.class);
				try {

					if (!new File(EC_Folder + complaintNumber + "//").exists())
						new File(EC_Folder + complaintNumber).mkdirs();

					OutputStream outpuStream = new FileOutputStream(new File(
							EC_Folder + complaintNumber + "//"
									+ contentdisposition.getFileName()));

					int read = 0;

					byte[] bytes = new byte[1024];

					outpuStream = new FileOutputStream(new File(EC_Folder
							+ complaintNumber + "//"
							+ contentdisposition.getFileName()));

					while ((read = uploadedInputStream.read(bytes)) != -1) {
						outpuStream.write(bytes, 0, read);
					}
					outpuStream.flush();
					outpuStream.close();

				} catch (IOException e) {
					e.printStackTrace();

				}

				// FileUtils.copyFileToDirectory(bodypartdata,
				// directoryPath);
				Long filesize = Long.valueOf(multipartdata.getField("filesize")
						.getValue());

				if (filesize == null) {
					return result = "Folder size has exceeded";
				} else {
					String filepath = EC_Folder + complaintNumber + "//"
							+ contentdisposition.getFileName();

					session = HibernateUtil.getSessionFactory().openSession();
					transaction = session.beginTransaction();
					transaction.begin();
					Integer complaintId = (Integer) session
							.createCriteria(ComplaintDetails.class)
							.add(Restrictions.eq("complaintID", complaintID))
							.setProjection(Projections.property("complaintID"))
							.setMaxResults(1).uniqueResult();
					System.out.println("ComplainId : " + complaintId);

					if (complaintId != null) {
						inputstream = bodypartdata
								.getValueAs(InputStream.class);
						outputstream = new FileOutputStream(filepath);
						int read = 0;
						byte[] bytes = new byte[2048];
						while ((read = inputstream.read(bytes)) != -1) {
							outputstream.write(bytes, 0, read);
						}
						outputstream.flush();

						Documents document = new Documents();
						if (userId > 0)
							document.setDocumentOwner(userId);
						else
							document.setDocumentOwner(0);

						document.setComplaintID(complaintId);
						document.setCreatedDate(new Date());
						document.setDocumentPath(complaintNumber + "//"
								+ contentdisposition.getFileName());
						document.setIsActive(true);
						session.save(document);
						result = "success";
					} else {
						result = "error";
					}

					transaction.commit();
				}

			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
			return null;
		} finally {
			if (inputstream != null) {
				try {
					inputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputstream != null) {
				try {
					outputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	

	@POST
	@Path("/getPublicDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPublicDashboardCount(ApplicationBean applicationBean) {

//		complaintDao = new ComplaintDaoImpl();
		dashboardDao=new DashboardDaoImpl();
		gson = new Gson();

DashboardCountBean dashboardBean;

		List<DashboardCountBean> dashboardBeanList = new ArrayList<DashboardCountBean>();

		
		 for (Object[] rowData : dashboardDao
		  .getPublicDashboardCount(applicationBean)) {
		 
		dashboardBean = new DashboardCountBean();
		dashboardBean.setCategoryID(23);
		dashboardBean.setCategoryName("CE");
		dashboardBean.setCategoryCount(30);
		dashboardBean.setIcon("test");
		dashboardBean.setBgColor("red");
		dashboardBeanList.add(dashboardBean);
		 }
		return gson.toJson(dashboardBeanList);
	}
	@POST
	@Path("addNewUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNewUser(EmployeeFormBean employeeFormBean) {
		
	return new DashboardDaoImpl().addNewUser(employeeFormBean);
	}
	@POST
	@Path("editUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editUser(EmployeeFormBean employeeFormBean) {
		
	return new DashboardDaoImpl().editUser(employeeFormBean);
	}
	@POST
	@Path("deleteUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteUser(EmployeeFormBean employeeFormBean) {
		
	return new DashboardDaoImpl().deleteUser(employeeFormBean);
	}
	
	@POST
	@Path("/getUserDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserDtl() {
		gson = new Gson();
		
		List<EmployeeDetails> employeeDetailsList =  new DashboardDaoImpl().getUserDtl();
		List<EmployeeFormBean> employeeFormBeanList = new ArrayList<>();
		
		for(EmployeeDetails employeeDetails:employeeDetailsList){
		
			EmployeeFormBean employeeFormBean = new EmployeeFormBean();
			employeeFormBean.setEmail(employeeDetails.getEmailAddr());
			employeeFormBean.setMobile(String.valueOf(employeeDetails.getPhoneNum()));
			employeeFormBean.setName(employeeDetails.getUserFirstName());
			employeeFormBean.setPassword(employeeDetails.getLoginPassword());
			employeeFormBean.setRole(employeeDetails.getUserRole().getRoleName());
			employeeFormBean.setRoleId(String.valueOf(employeeDetails.getUserRole().getRoleId()));
			if(employeeDetails.getUserDivision() != null){
			employeeFormBean.setDivision(employeeDetails.getUserDivision().getDivisionName());
			employeeFormBean.setDivisionId(String.valueOf(employeeDetails.getUserDivision().getDivisionId()));
			}
			employeeFormBean.setUserId(String.valueOf(employeeDetails.getUserId()));
			employeeFormBean.setUsername(employeeDetails.getLoginUserName());
			employeeFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(employeeFormBeanList);
	}
	

	@POST
	@Path("addCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addCategory(CategoryFormBean categoryFormBean) {
		
	return new DashboardDaoImpl().addCategory(categoryFormBean);
	}
	@POST
	@Path("editCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editCategory(CategoryFormBean categoryFormBean) {
		
	return new DashboardDaoImpl().editCategory(categoryFormBean);
	}
	@POST
	@Path("deleteCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCategory(CategoryFormBean categoryFormBean) {
		
	return new DashboardDaoImpl().deleteCategory(categoryFormBean);
	}
	
	@POST
	@Path("/getCategoryDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoryDtl() {
		gson = new Gson();
		
		List<MasterCategory> masterCategoryList =  new DashboardDaoImpl().getCategoryDtl();
		List<CategoryFormBean> categoryFormBeanList = new ArrayList<>();
		
		for(MasterCategory masterCategory:masterCategoryList){
		
			CategoryFormBean employeeFormBean = new CategoryFormBean();
			
			employeeFormBean.setCategoryId(String.valueOf(masterCategory.getCategoyId()));
			employeeFormBean.setCategoryName(masterCategory.getCategoryName());
			employeeFormBean.setCategoryDesc(masterCategory.getCategoryDesc());
			categoryFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(categoryFormBeanList);
	}
	
	
	
	@POST
	@Path("addOffice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addOffice(OfficeFormBean officeFormBean) {
		
	return new DashboardDaoImpl().addOffice(officeFormBean);
	}
	@POST
	@Path("editOffice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editOffice(OfficeFormBean officeFormBean) {
		
	return new DashboardDaoImpl().editOffice(officeFormBean);
	}
	@POST
	@Path("deleteOffice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteOffice(OfficeFormBean officeFormBean) {
		
	return new DashboardDaoImpl().deleteOffice(officeFormBean);
	}
	
	@POST
	@Path("/getOfficeDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOfficeDtl() {
		gson = new Gson();
		
		List<MasterOffice> masterOfficeList =  new DashboardDaoImpl().getOfficeDtl();
		List<OfficeFormBean> officeFormBeanList = new ArrayList<>();
		
		for(MasterOffice masterOffice:masterOfficeList){
		
			OfficeFormBean employeeFormBean = new OfficeFormBean();
			
			employeeFormBean.setOfficeId(String.valueOf(masterOffice.getCategoyId()));
			employeeFormBean.setOfficeName(masterOffice.getOfficeName());
			employeeFormBean.setOfficeDesc(masterOffice.getOfficeDesc());
			officeFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(officeFormBeanList);
	}
	
	
	
	
	
	@POST
	@Path("addPaymentType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addPaymentType(PaymentFormBean paymentTypeFormBean) {
		
	return new DashboardDaoImpl().addPaymentType(paymentTypeFormBean);
	}
	@POST
	@Path("editPaymentType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editPaymentType(PaymentFormBean paymentTypeFormBean) {
		
	return new DashboardDaoImpl().editPaymentType(paymentTypeFormBean);
	}
	@POST
	@Path("deletePaymentType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletePaymentType(PaymentFormBean paymentTypeFormBean) {
		
	return new DashboardDaoImpl().deletePaymentType(paymentTypeFormBean);
	}
	
	@POST
	@Path("/getPaymentTypeDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPaymentTypeDtl() {
		gson = new Gson();
		
		List<MasterPaymentType> masterPaymentTypeList =  new DashboardDaoImpl().getPaymentTypeDtl();
		List<PaymentFormBean> paymentTypeFormBeanList = new ArrayList<>();
		
		for(MasterPaymentType masterPaymentType:masterPaymentTypeList){
		
			PaymentFormBean employeeFormBean = new PaymentFormBean();
			
			employeeFormBean.setPaymentId(String.valueOf(masterPaymentType.getPaymentTypeId()));
			employeeFormBean.setPaymentType(masterPaymentType.getPaymentType());
			employeeFormBean.setPaymentTypeDesc(masterPaymentType.getPaymentTypeDesc());
			paymentTypeFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(paymentTypeFormBeanList);
	}
	
	
	@POST
	@Path("addPayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addPayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().addPayment(paymentFormBean);
	}
	
	@POST
	@Path("eeAddPayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeAddPayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeAddPayment(paymentFormBean);
	}
	
	@POST
	@Path("eeSaveHeaderList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeSaveHeaderList(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeSaveHeaderList(paymentFormBean);
	}
	
	@POST
	@Path("getHeaderList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getHeaderList(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().getHeaderList(paymentFormBean);
	}
	
	@POST
	@Path("eeAddFullPayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeAddFullPayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeAddFullPayment(paymentFormBean);
	}
	
	
	
	
	
	@POST
	@Path("eePaymentPendingApproved")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eePaymentPendingApproved(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eePaymentPendingApproved(paymentFormBean);
	}
	
	@POST
	@Path("eePaymentCompletedApproved")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eePaymentCompletedApproved(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eePaymentCompletedApproved(paymentFormBean);
	}
	
	@POST
	@Path("/eePaymentCompletedMoveToExecution")
	@Produces(MediaType.APPLICATION_JSON)
	public String eePaymentCompletedMoveToExecution(DDPaymentFormBean dDPaymentFormBean) {
		Session	session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	try{
		transaction.begin();
		CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
		companyDtl.setActive(2);
		companyDtl.setEeStatus( (MasterStatus)session.get(MasterStatus.class,5));
		session.update(companyDtl);
		transaction.commit();
		
	}
	catch(Exception e){
		e.printStackTrace();
		transaction.rollback();
		return "Application not Saved";
	}
	finally{
		session.close();
	}
			return "Application Moved to Execution";

		}


	
	
	@POST
	@Path("eeFullPaymentApproved")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeFullPaymentApproved(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeFullPaymentApproved(paymentFormBean);
	}
	
	@POST
	@Path("eeMCApprovedBtn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeMCApprovedBtn(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeMCApprovedBtn(paymentFormBean);
	}
	
	@POST
	@Path("mcApprovePayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String mcApprovePayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().mcApprovePayment(paymentFormBean);
	}
	
	
	@POST
	@Path("editPayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editPayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().editPayment(paymentFormBean);
	}
	@POST
	@Path("deletePayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletePayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().deletePayment(paymentFormBean);
	}
	
	@POST
	@Path("/getPaymentDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPaymentDtl() {
		gson = new Gson();
		
		List<MasterPayment> masterPaymentList =  new DashboardDaoImpl().getPaymentDtl();
		List<PaymentFormBean> paymentFormBeanList = new ArrayList<>();
		
		for(MasterPayment masterPayment:masterPaymentList){
		
			PaymentFormBean employeeFormBean = new PaymentFormBean();
			
			if(null != masterPayment.getAppId())
			employeeFormBean.setAppId(masterPayment.getAppId().getAppId());
			employeeFormBean.setPaymentId(String.valueOf(masterPayment.getPaymentId()));
			employeeFormBean.setPaymentType(masterPayment.getPaymentType().getPaymentType());
			employeeFormBean.setPaymentTypeId(String.valueOf(masterPayment.getPaymentType().getPaymentTypeId()));
			employeeFormBean.setPaymentAmount(masterPayment.getPaymentAmount());
			employeeFormBean.setPaymentDesc(masterPayment.getPaymentDesc());
			
			employeeFormBean.setGstAmount(masterPayment.getGstAmount());
			employeeFormBean.setGstPercent(masterPayment.getGstPercent());
			employeeFormBean.setTotalAmount(masterPayment.getTotalAmount());
			
			paymentFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(paymentFormBeanList);
	}
	
	
	
	
	
	
	
	@POST
	@Path("addConnectionType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addConnectionType(ConnectionFormBean connectionFormBean) {
		
	return new DashboardDaoImpl().addConnectionType(connectionFormBean);
	}
	@POST
	@Path("editConnectionType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editConnectionType(ConnectionFormBean connectionFormBean) {
		
	return new DashboardDaoImpl().editConnectionType(connectionFormBean);
	}
	@POST
	@Path("deleteConnectionType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteConnectionType(ConnectionFormBean connectionFormBean) {
		
	return new DashboardDaoImpl().deleteConnectionType(connectionFormBean);
	}
	
	@POST
	@Path("/getConnectionTypeDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConnectionTypeDtl() {
		gson = new Gson();
		
		List<MasterReconnection> masterReconnectionList =  new DashboardDaoImpl().getConnectionTypeDtl();
		List<ConnectionFormBean> connectionFormBeanList = new ArrayList<>();
		
		for(MasterReconnection masterReconnection:masterReconnectionList){
			ConnectionFormBean connectionFormBean = new ConnectionFormBean();
			connectionFormBean.setConnectionId(String.valueOf(masterReconnection.getReConnId()));
			connectionFormBean.setConnectionName(masterReconnection.getConnectionType());
			connectionFormBean.setConnectionDesc(masterReconnection.getReConnDes());
			connectionFormBeanList.add(connectionFormBean);
		}
            return gson.toJson(connectionFormBeanList);
	}
	
	
	
	
	
	
	
	
	@POST
	@Path("addZone")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addZone(ZoneDivisionFormBean zoneDivisionFormBean) {
		
	return new DashboardDaoImpl().addZone(zoneDivisionFormBean);
	}
	
	
	
	@POST
	@Path("addDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addDivision(ZoneDivisionFormBean zoneDivisionFormBean) {
		
	return new DashboardDaoImpl().addDivision(zoneDivisionFormBean);
	}
	@POST
	@Path("editDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editDivision(ZoneDivisionFormBean zoneDivisionFormBean) {
		
	return new DashboardDaoImpl().editDivision(zoneDivisionFormBean);
	}
	@POST
	@Path("deleteDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteDivision(ZoneDivisionFormBean zoneDivisionFormBean) {
		
	return new DashboardDaoImpl().deleteDivision(zoneDivisionFormBean);
	}
	
	@POST
	@Path("/getDivisionDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDivisionDtl() {
		gson = new Gson();
		
		List<ZoneDivisionFormBean> zoneDivisionFormBeanList =  new DashboardDaoImpl().getDivisionDtl();
		/*List<ZoneDivisionFormBean> zoneDivisionFormBeanList = new ArrayList<>();
		
		for(MasterReconnection masterReconnection:masterReconnectionList){
			ZoneDivisionFormBean zoneDivisionFormBean = new ZoneDivisionFormBean();
			zoneDivisionFormBean.setConnectionId(String.valueOf(masterReconnection.getReConnId()));
			zoneDivisionFormBean.setConnectionName(masterReconnection.getConnectionType());
			zoneDivisionFormBean.setConnectionDesc(masterReconnection.getReConnDes());
			zoneDivisionFormBeanList.add(zoneDivisionFormBean);
		}*/
            return gson.toJson(zoneDivisionFormBeanList);
	}

	
	
	
	
	
	
	
	
	
	

	@POST
	@Path("addDistrict")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addDistrict(DistrictFormBean districtFormBean) {
		
	return new DashboardDaoImpl().addDistrict(districtFormBean);
	}
	@POST
	@Path("editDistrict")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editDistrict(DistrictFormBean districtFormBean) {
		
	return new DashboardDaoImpl().editDistrict(districtFormBean);
	}
	@POST
	@Path("deleteDistrict")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteDistrict(DistrictFormBean districtFormBean) {
		
	return new DashboardDaoImpl().deleteDistrict(districtFormBean);
	}
	
	@POST
	@Path("/getDistrictDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDistrictDtl() {
		gson = new Gson();
		
		List<MasterDistrict> masterDistrictList =  new DashboardDaoImpl().getDistrictDtl();
		List<DistrictFormBean> districtFormBeanList = new ArrayList<>();
		
		for(MasterDistrict masterDistrict:masterDistrictList){
		
			DistrictFormBean employeeFormBean = new DistrictFormBean();
			
			employeeFormBean.setDistrictId(String.valueOf(masterDistrict.getDistrictId()));
			employeeFormBean.setDistrictName(masterDistrict.getDistrictName());
			districtFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(districtFormBeanList);
	}

		
	
	
	@POST
	@Path("addTaluk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addTaluk(DistrictTalukFormBean districtTalukFormBean) {
		
	return new DashboardDaoImpl().addTaluk(districtTalukFormBean);
	}
	@POST
	@Path("editTaluk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editTaluk(DistrictTalukFormBean districtTalukFormBean) {
		
	return new DashboardDaoImpl().editTaluk(districtTalukFormBean);
	}
	@POST
	@Path("deleteTaluk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteTaluk(DistrictTalukFormBean districtTalukFormBean) {
		
	return new DashboardDaoImpl().deleteTaluk(districtTalukFormBean);
	}
	
	@POST
	@Path("/getTalukDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTalukDtl() {
		gson = new Gson();
		
		List<DistrictTalukFormBean> districtTalukFormBeanList =  new DashboardDaoImpl().getTalukDtl();
            return gson.toJson(districtTalukFormBeanList);
	}


	@POST
	@Path("addVillage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addVillage(TalukVillageFormBean talukVillageFormBean) {
		
	return new DashboardDaoImpl().addVillage(talukVillageFormBean);
	}
	@POST
	@Path("editVillage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editVillage(TalukVillageFormBean talukVillageFormBean) {
		
	return new DashboardDaoImpl().editVillage(talukVillageFormBean);
	}
	@POST
	@Path("deleteVillage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteVillage(TalukVillageFormBean talukVillageFormBean) {
		
	return new DashboardDaoImpl().deleteVillage(talukVillageFormBean);
	}
	
	@POST
	@Path("/getVillageDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVillageDtl() {
		gson = new Gson();
		
		List<TalukVillageFormBean> talukVillageFormBeanList =  new DashboardDaoImpl().getVillageDtl();
            return gson.toJson(talukVillageFormBeanList);
	}

	

	@POST
	@Path("addScheme")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addScheme(VillageSchemeFormBean villageSchemeFormBean) {
		
	return new DashboardDaoImpl().addScheme(villageSchemeFormBean);
	}
	@POST
	@Path("editScheme")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editScheme(VillageSchemeFormBean villageSchemeFormBean) {
		
	return new DashboardDaoImpl().editScheme(villageSchemeFormBean);
	}
	@POST
	@Path("deleteScheme")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteScheme(VillageSchemeFormBean villageSchemeFormBean) {
		
	return new DashboardDaoImpl().deleteScheme(villageSchemeFormBean);
	}
	
	@POST
	@Path("/getSchemeDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSchemeDtl() {
		gson = new Gson();
		
		List<VillageSchemeFormBean> villageSchemeFormBeanList =  new DashboardDaoImpl().getSchemeDtl();
            return gson.toJson(villageSchemeFormBeanList);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@POST
	@Path("addRegion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addRegion(RegionFormBean regionFormBean) {
		
	return new DashboardDaoImpl().addRegion(regionFormBean);
	}
	@POST
	@Path("editRegion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editRegion(RegionFormBean regionFormBean) {
		
	return new DashboardDaoImpl().editRegion(regionFormBean);
	}
	@POST
	@Path("deleteRegion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteRegion(RegionFormBean regionFormBean) {
		
	return new DashboardDaoImpl().deleteRegion(regionFormBean);
	}
	
	@POST
	@Path("/getRegionDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRegionDtl() {
		gson = new Gson();
		
		List<MasterRegion> masterRegionList =  new DashboardDaoImpl().getRegionDtl();
		List<RegionFormBean> regionFormBeanList = new ArrayList<>();
		
		for(MasterRegion masterRegion:masterRegionList){
		
			RegionFormBean employeeFormBean = new RegionFormBean();
			
			employeeFormBean.setRegionId(String.valueOf(masterRegion.getRegionId()));
			employeeFormBean.setRegionName(masterRegion.getRegionName());
			regionFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(regionFormBeanList);
	}

		
	
	
	@POST
	@Path("addCircle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addCircle(RegionCircleFormBean regionCircleFormBean) {
		
	return new DashboardDaoImpl().addCircle(regionCircleFormBean);
	}
	@POST
	@Path("editCircle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editCircle(RegionCircleFormBean regionCircleFormBean) {
		
	return new DashboardDaoImpl().editCircle(regionCircleFormBean);
	}
	@POST
	@Path("deleteCircle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCircle(RegionCircleFormBean regionCircleFormBean) {
		
	return new DashboardDaoImpl().deleteCircle(regionCircleFormBean);
	}
	
	@POST
	@Path("/getCircleDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCircleDtl() {
		gson = new Gson();
		
		List<RegionCircleFormBean> regionCircleFormBeanList =  new DashboardDaoImpl().getCircleDtl();
            return gson.toJson(regionCircleFormBeanList);
	}


	@POST
	@Path("addHODivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addHODivision(CircleDivisionFormBean circleDivisionFormBean) {
		
	return new DashboardDaoImpl().addHODivision(circleDivisionFormBean);
	}
	@POST
	@Path("editHODivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editHODivision(CircleDivisionFormBean circleDivisionFormBean) {
		
	return new DashboardDaoImpl().editHODivision(circleDivisionFormBean);
	}
	@POST
	@Path("deleteHODivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteHODivision(CircleDivisionFormBean circleDivisionFormBean) {
		
	return new DashboardDaoImpl().deleteHODivision(circleDivisionFormBean);
	}
	
	@POST
	@Path("/getHODivisionDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHODivisionDtl() {
		gson = new Gson();
		
		List<CircleDivisionFormBean> talukDivisionFormBeanList =  new DashboardDaoImpl().getHODivisionDtl();
            return gson.toJson(talukDivisionFormBeanList);
	}

	
	@POST
	@Path("addSubDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addSubDivision(DivisionSubDivisionFormBean divisionSubDivisionFormBean) {
		
	return new DashboardDaoImpl().addSubDivision(divisionSubDivisionFormBean);
	}
	@POST
	@Path("editSubDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editSubDivision(DivisionSubDivisionFormBean divisionSubDivisionFormBean) {
		
	return new DashboardDaoImpl().editSubDivision(divisionSubDivisionFormBean);
	}
	@POST
	@Path("deleteSubDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteSubDivision(DivisionSubDivisionFormBean divisionSubDivisionFormBean) {
		
	return new DashboardDaoImpl().deleteSubDivision(divisionSubDivisionFormBean);
	}
	
	@POST
	@Path("/getSubDivisionDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSubDivisionDtl() {
		gson = new Gson();
		
		List<DivisionSubDivisionFormBean> talukSubDivisionFormBeanList =  new DashboardDaoImpl().getSubDivisionDtl();
            return gson.toJson(talukSubDivisionFormBeanList);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@POST
	@Path("/getFixedPaymentAmount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFixedPaymentAmount() {
		
            return new Gson().toJson(new DashboardDaoImpl().getFixedPaymentAmount());
	}


	
	
	
	
	
	
	
	
}











/*package com.water.ws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.water.bean.ApplicationBean;
import com.water.bean.CategoryFormBean;
import com.water.bean.CircleDivisionFormBean;
import com.water.bean.CmwWaterConnBean;
import com.water.bean.CompanyDtlBean;
import com.water.bean.ConnectionFormBean;
import com.water.bean.DDPaymentFormBean;
import com.water.bean.DashboardCountBean;
import com.water.bean.DistrictFormBean;
import com.water.bean.DistrictTalukFormBean;
import com.water.bean.DivisionSubDivisionFormBean;
import com.water.bean.EmployeeFormBean;
import com.water.bean.OfficeFormBean;
import com.water.bean.OracleDbBean;
import com.water.bean.PaymentFormBean;
import com.water.bean.RegionCircleFormBean;
import com.water.bean.RegionFormBean;
import com.water.bean.TalukVillageFormBean;
import com.water.bean.VillageSchemeFormBean;
import com.water.bean.ZoneDivisionFormBean;
import com.water.dao.DashboardDao;
import com.water.daoImpl.DashboardDaoImpl;
import com.water.model.Application;
import com.water.model.CompanyDtl;
import com.water.model.CompanyPaymentDtl;
import com.water.model.ComplaintDetails;
import com.water.model.Documents;
import com.water.model.EmployeeDetails;
import com.water.model.MasterCategory;
import com.water.model.MasterCircle;
import com.water.model.MasterDistrict;
import com.water.model.MasterHODivision;
import com.water.model.MasterOffice;
import com.water.model.MasterPayment;
import com.water.model.MasterPaymentType;
import com.water.model.MasterReconnection;
import com.water.model.MasterRegion;
import com.water.model.MasterStatus;
import com.water.model.MasterZone;
import com.water.util.HibernateUtil;
import com.water.util.SMSBuilder;
import com.water.util.StatusConstant;

*//**
 * @author Mahalingam Created on 02-June-2017 for DashboardService :
 * 
 *//*
@Path("DashboardService")
public class DashboardService {

	ComplaintDao complaintDao;
	DashboardDao dashboardDao;

	Gson gson;

	ResourceBundle rb = ResourceBundle.getBundle("resources/constant");

	String EC_Folder = rb.getString("EC_Folder");
	private ApplicationBean applicationBean;

	
	@POST
	@Path("/getviewApp")
	@Produces(MediaType.APPLICATION_JSON)
	public String getviewApp( ApplicationBean appFormBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		//System.out.println(appid);
//AppFormBean appFormBean=new AppFormBean();
		Application appDtls =  dashboardDao.getApplicationDtls(appFormBean);
		
		
		
		
		//for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(appDtls.getAppId());
			applicationBean.setCategoryType(appDtls.getCategoryType().getCategoryName());
			
			
			//applicationBean.setContactPersonName(appDtls.getContactPersonName());
			if(appDtls.getCmwssbZoneNum()!=null && appDtls.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("");
			}
			else if(appDtls.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(appDtls.getCmwssbZoneNum().getZoneDesc());
			}
			
			
			
			if(appDtls.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(appDtls.getIsReconnectionForService()!= null && appDtls.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(appDtls.getIsReconnectionForService()!= null && appDtls.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
		
			applicationBean.setCdoorNo(appDtls.getCdoorNo());
			applicationBean.setCplotNo(appDtls.getCplotNo());
			applicationBean.setCstreetName(appDtls.getCstreetName());
			applicationBean.setClocation(appDtls.getClocation());
			applicationBean.setCpinCode(appDtls.getCpinCode());
			applicationBean.setWebAddress(appDtls.getWebAddress());
			
			if(appDtls.getLandLineNo()!=null){
				applicationBean.setLandLineNo(appDtls.getLandLineNo().toString());
			}
			
			
			if(appDtls.getIsNewConnection()!=null && appDtls.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(appDtls.getIsNewConnection()!=null && appDtls.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(appDtls.getDivId()!=null  && appDtls.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(appDtls.getDivId()!=null)
			{
				applicationBean.setDivId(appDtls.getDivId().getDivDesc());
			}
			applicationBean.setDoorNo(appDtls.getDoorNo());
			applicationBean.setPlotNo(appDtls.getPlotNo());
			applicationBean.setStreetName(appDtls.getStreetName());
			applicationBean.setLocation(appDtls.getLocation());
			applicationBean.setPinCode(appDtls.getPinCode());
			
			if(appDtls.getIsExistConnectionForAlteration()!=null && appDtls.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(appDtls.getIsExistConnectionForAlteration()!=null && appDtls.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
			}
			applicationBean.setSalutation(appDtls.getSalutation());
			applicationBean.setContactPersonName(appDtls.getContactPersonName());
			applicationBean.setLegCompName(appDtls.getLegCompName());
			applicationBean.setMobileNum(appDtls.getMobileNum().toString());

			applicationBean.setEmailAddr(appDtls.getEmailAddr());
			applicationBean.setAddrPremSought(appDtls.getAddrPremSought());
			
			if(appDtls.getReqMld()!=null)
			applicationBean.setReqMld(appDtls.getReqMld().toString());
			if(appDtls.getAnnAssmtVal()!=null)
				applicationBean.setAnnAssmtVal(appDtls.getAnnAssmtVal().toString());
			if(appDtls.getBillNo1()!=null)
				applicationBean.setBillNo1(appDtls.getBillNo1().toString());
			if(appDtls.getBillNo2()!=null)
				applicationBean.setBillNo2(appDtls.getBillNo2().toString());

			if(appDtls.getIntrPlumStatus()!=null && appDtls.getIntrPlumStatus()==0){
				applicationBean.setIntrPlumStatus("NO");
			}
			if(appDtls.getIntrPlumStatus()!=null && appDtls.getIntrPlumStatus()==1){
				applicationBean.setIntrPlumStatus("YES");
			}
			
			if(appDtls.getWatSevProp()!=null && appDtls.getWatSevProp()==0){
				applicationBean.setWatSevProp("NO");
			}
			if(appDtls.getWatSevProp()!=null && appDtls.getWatSevProp()==1){
				applicationBean.setWatSevProp("YES");
			}

			if(appDtls.getWorkType()==0){
				applicationBean.setWorkType("Treated (Chloronated)");
			}
			if(appDtls.getWorkType()==1){
				applicationBean.setWorkType("Raw Water");
			}
			if(appDtls.getWorkType()==2){
				applicationBean.setWorkType("Secondary treated water");
			}
			
			if(appDtls.getPaymentType() != null && appDtls.getPaymentType()==0){
				applicationBean.setPaymentType("Offline");
				applicationBean.setDdNum(appDtls.getDdNum().toString());
			}
			else if(appDtls.getPaymentType() != null){
				applicationBean.setPaymentType("Online");
			}
			
			applicationBean.setCreateDate(appDtls.getCreateTs().toString());
            return gson.toJson(applicationBean);



	}
	
	
	@POST
	@Path("/listViewAllApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listViewAllApplication() {
	dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listViewAllApplication();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType().getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			if(app.getStatusFlag().toString().equals("Y") && app.getInsStatusId()==1)
			{
				applicationBean.setAppStatus("Yet to Start");
			}
			if(app.getStatusFlag().toString().equals("Y") && app.getInsStatusId()!=1 )
			{
				applicationBean.setAppStatus("Approved");
			}
			if(app.getStatusFlag().toString().equals("R"))
			{
				applicationBean.setAppStatus("Rejected");
			}
			if(app.getStatusFlag().toString().equals("C"))
			{
				applicationBean.setAppStatus("Connection Completed");
			}
			if(app.getStatusFlag().toString().equals("P"))
			{
				applicationBean.setAppStatus("Payment Paid");
			}
			
			//applicationBean.setCorrespondenceAddr(app.getCorrespondenceAddr());
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	@POST
	@Path("/listCePendingApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listCePendingApplication() {
	dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listCePendingApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType().getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
			
			
			//applicationBean.setCorrespondenceAddr(app.getCorrespondenceAddr());
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
		
	
	@POST
	@Path("/getApplicationDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public String getApplicationDetails( ApplicationBean appFormBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		//System.out.println(appid);
//AppFormBean appFormBean=new AppFormBean();
		Application appDtls =  dashboardDao.getApplicationDetails(appFormBean);
		ApplicationBean applicationBean = new ApplicationBean();
		
		if(appDtls!=null)
		{
		
		
		//for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			
			applicationBean.setAppId(appDtls.getAppId());
			applicationBean.setCategoryType(appDtls.getCategoryType().getCategoryName());
			
			//applicationBean.setContactPersonName(appDtls.getContactPersonName());
			if(appDtls.getCmwssbZoneNum()!=null && appDtls.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("");
			}
			else if(appDtls.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(appDtls.getCmwssbZoneNum().getZoneDesc());
			}
			
			if(appDtls.getReconnectionType() !=null && appDtls.getReconnectionType().getReConnDesc()==null)
			{
			
				applicationBean.setReconnectionType("");
			}
			else
			{
				applicationBean.setReconnectionType(appDtls.getReconnectionType().getReConnDesc());
			}
			
			if(appDtls.getIsReconnectionForService()==0){
				applicationBean.setIsReconnectionForService("No");
			}
			else{
				applicationBean.setIsReconnectionForService("Yes");
				applicationBean.setReconnectionType(appDtls.getReconnectionType().getReConnDesc());
				
			}
			/////////////
			
			if(appDtls.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(appDtls.getIsReconnectionForService()!= null && appDtls.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(appDtls.getIsReconnectionForService()!= null && appDtls.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
		
			applicationBean.setCdoorNo(appDtls.getCdoorNo());
			applicationBean.setCplotNo(appDtls.getCplotNo());
			applicationBean.setCstreetName(appDtls.getCstreetName());
			applicationBean.setClocation(appDtls.getClocation());
			applicationBean.setCpinCode(appDtls.getCpinCode());
			applicationBean.setWebAddress(appDtls.getWebAddress());
			if(appDtls.getLandLineNo()!=null){
				applicationBean.setLandLineNo(appDtls.getLandLineNo().toString());
			}
			
			if(appDtls.getIsNewConnection()!=null && appDtls.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(appDtls.getIsNewConnection()!=null && appDtls.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(appDtls.getDivId()!=null  && appDtls.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(appDtls.getDivId()!=null)
			{
				applicationBean.setDivId(appDtls.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(appDtls.getDoorNo());
			applicationBean.setPlotNo(appDtls.getPlotNo());
			applicationBean.setStreetName(appDtls.getStreetName());
			applicationBean.setLocation(appDtls.getLocation());
			applicationBean.setPinCode(appDtls.getPinCode());
			
			if(appDtls.getIsExistConnectionForAlteration()!=null && appDtls.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(appDtls.getIsExistConnectionForAlteration()!=null && appDtls.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
			}
			applicationBean.setSalutation(appDtls.getSalutation());
			applicationBean.setContactPersonName(appDtls.getContactPersonName());
			applicationBean.setLegCompName(appDtls.getLegCompName());
			applicationBean.setMobileNum(appDtls.getMobileNum().toString());

			applicationBean.setEmailAddr(appDtls.getEmailAddr());
			applicationBean.setAddrPremSought(appDtls.getAddrPremSought());
			
			if(appDtls.getReqMld()!=null)
			applicationBean.setReqMld(appDtls.getReqMld().toString());
			
			if(appDtls.getAnnAssmtVal()!=null)
				applicationBean.setAnnAssmtVal(appDtls.getAnnAssmtVal().toString());
			if(appDtls.getBillNo1()!=null)
				applicationBean.setBillNo1(appDtls.getBillNo1().toString());
			if(appDtls.getBillNo2()!=null)
				applicationBean.setBillNo2(appDtls.getBillNo2().toString());

			if(appDtls.getIntrPlumStatus()!=null && appDtls.getIntrPlumStatus()==0){
				applicationBean.setIntrPlumStatus("NO");
			}
			if(appDtls.getIntrPlumStatus()!=null && appDtls.getIntrPlumStatus()==1){
				applicationBean.setIntrPlumStatus("YES");
			}
			
			if(appDtls.getWatSevProp()!=null && appDtls.getWatSevProp()==0){
				applicationBean.setWatSevProp("NO");
			}
			if(appDtls.getWatSevProp()!=null && appDtls.getWatSevProp()==1){
				applicationBean.setWatSevProp("YES");
			}

			if(appDtls.getWorkType()==0){
				applicationBean.setWorkType("Treated (Chloronated)");
			}
			if(appDtls.getWorkType()==1){
				applicationBean.setWorkType("Raw Water");
			}
			if(appDtls.getWorkType()==2){
				applicationBean.setWorkType("Secondary treated water");
			}
			
			if(appDtls.getPaymentType() != null && appDtls.getPaymentType()==0){
				applicationBean.setPaymentType("Offline");
				applicationBean.setDdNum(appDtls.getDdNum().toString());
			}
			else if(appDtls.getPaymentType() != null){
				applicationBean.setPaymentType("Online");
			}
			
			
			if(appDtls.getMcStatus().getStatusId()==2 && (appDtls.getPaidfinalFee()!=null) ){
				applicationBean.setCeStatus("Approved by MC");
			//	applicationBean.setRemarks("Work is going to  Start");
			}
			if(appDtls.getMcStatus().getStatusId()==2 && (appDtls.getPaidfinalFee()==null ) ){
				applicationBean.setCeStatus("Tendering process underway.");
				//applicationBean.setRemarks("Connection payment not yet received.");
			}
			else if(appDtls.getEeStatus().getStatusId()==2){
				applicationBean.setCeStatus("Approved by EE. It is under MC for Final Settlement");
				applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getCeStatus().getStatusId()==2){
				applicationBean.setCeStatus("payment successful");
			//	applicationBean.setCeStatus("Application submitted; verification and inspection pending1.");
				//applicationBean.setRemarks("");
			}
		
			else if(appDtls.getEeStatus().getStatusId()==1 && appDtls.getInsStatusId()==2 && appDtls.getPaidProcessFee()!=null && appDtls.getStatusFlag()=='Y'){
				//applicationBean.setCeStatus("Under by EE. Initial processing cost Rs "+appDtls.getInitialPayment()+" received successfully , "+" you will receive inspection date  shortly  your registered mobile and email.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
				applicationBean.setCeStatus("Inspection completed; pending approval/ tendering process.");
			}
			else if(appDtls.getEeStatus().getStatusId()==2 && appDtls.getInsStatusId()==2  && appDtls.getStatusFlag()=='Y'){
				applicationBean.setCeStatus("Inspection completed; pending approval/ tendering process.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getEeStatus().getStatusId()==2 && appDtls.getStatusFlag()=='R'){
				applicationBean.setCeStatus("EE Rejected your Application");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getMcStatus().getStatusId()==2 && appDtls.getStatusFlag()=='R'){
				applicationBean.setCeStatus("MC Rejected your Application");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getEeStatus().getStatusId()==3 && appDtls.getInsStatusId()==3 && (appDtls.getPaidfinalFee()==null) ){
				applicationBean.setCeStatus("Tender awarded; Please Pay Connection Payment.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getEeStatus().getStatusId()==3 && appDtls.getInsStatusId()==3 && (appDtls.getPaidfinalFee()!=null)){
				applicationBean.setCeStatus("Tendering process underway.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getMcStatus().getStatusId()==3 && appDtls.getInsStatusId()==3 && (appDtls.getPaidfinalFee()!=null)){
				applicationBean.setCeStatus("Tender awarded; Work under progress.");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else if(appDtls.getEeStatus().getStatusId()==2 && appDtls.getInsStatusId()==1 && appDtls.getPaidProcessFee()==null){
				applicationBean.setCeStatus("Under by EE. Initial processing cost Rs "+appDtls.getInitialPayment()+"  send it to Your registered mobile and email.Please pay this url :  http://localhost:8080/TwadWeb/initialPayment.do");
				//applicationBean.setRemarks(appDtls.getRemarks().toString());
			}
			else{
				applicationBean.setCeStatus("payment successful");
				//applicationBean.setCeStatus("Application submitted; verification and inspection pending.");
				//applicationBean.setRemarks("Address Verification going on");
			}
			
			
			applicationBean.setCreateDate(appDtls.getCreateTs().toString());


		}
		else
		{
			applicationBean.setAppId("Application No Invalid!");
			applicationBean.setCreateDate("Application No Invalid!");
			applicationBean.setCeStatus("Application No Invalid!");
		}
		
		//}
		//System.out.println("app:"+appDtls);

		return gson.toJson(applicationBean);

		
		//return gson.toJson(appDtls);
		//return "NoData";

	}
	
	
	@POST
	@Path("/listEePendingApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listEePendingApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listEePendingApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType().getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			
			if(app.getRemarks()!=null )
			{
				applicationBean.setRemarks(app.getRemarks());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			
			if(app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	
	
	@POST
	@Path("/listTrackApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listTrackApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listTrackApplication();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType().getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			
			if(app.getRemarks()!=null )
			{
				applicationBean.setRemarks(app.getRemarks());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			
			if(app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
		
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
				applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	@POST
	@Path("/listMcPendingApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listMcPendingApplication() {
		return new Gson().toJson(new DashboardDaoImpl().listMcPendingApplicationDtls());
		}
	
	
	@POST
	@Path("/getUpfrontCharges")
	@Produces(MediaType.APPLICATION_JSON)
	public DDPaymentFormBean getUpfrontCharges(DDPaymentFormBean ddPaymentFormBean ){
		return new DashboardDaoImpl().getUpfrontCharges(ddPaymentFormBean);
		}
	
	
	
	@POST
	@Path("/listAfterInspection")
	@Produces(MediaType.APPLICATION_JSON)
	public String listAfterInspection() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<CompanyDtl> appDtls = dashboardDao.listAfterInspection();
		List<CompanyDtlBean> applicationBeanList = new ArrayList<CompanyDtlBean>();
		for (CompanyDtl app : appDtls) {
			//MasterZone mastr=new MasterZone();
			//mastr.setZoneDesc("other");
			CompanyDtlBean applicationBean = new CompanyDtlBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
		//	applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			//applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
		//	applicationBean.setPinCode(app.getCpinCode());
			
			
			applicationBean.setLegCompName(app.getLegCompName());
		//	applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/listEstimate")
	@Produces(MediaType.APPLICATION_JSON)
	public String listEstimate() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<CompanyDtl> appDtls = dashboardDao.listEstimate();
		List<CompanyDtlBean> applicationBeanList = new ArrayList<CompanyDtlBean>();
		for (CompanyDtl app : appDtls) {
			//MasterZone mastr=new MasterZone();
			//mastr.setZoneDesc("other");
			CompanyDtlBean applicationBean = new CompanyDtlBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
		//	applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			//applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
		//	applicationBean.setPinCode(app.getCpinCode());
			
			
			applicationBean.setLegCompName(app.getLegCompName());
		//	applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/listMOU")
	@Produces(MediaType.APPLICATION_JSON)
	public String listMOU() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<CompanyDtl> appDtls = dashboardDao.listMOU();
		List<CompanyDtlBean> applicationBeanList = new ArrayList<CompanyDtlBean>();
		for (CompanyDtl app : appDtls) {
			//MasterZone mastr=new MasterZone();
			//mastr.setZoneDesc("other");
			CompanyDtlBean applicationBean = new CompanyDtlBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
		//	applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			//applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
		//	applicationBean.setPinCode(app.getCpinCode());
			
			
			applicationBean.setLegCompName(app.getLegCompName());
		//	applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/eeApplicationFeePending")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeApplicationFeePending(CompanyDtlBean companyDtlBean) {

		return new Gson().toJson(new DashboardDaoImpl().eeApplicationFeePending(companyDtlBean));
	}
	
	@POST
	@Path("/eeUpfrontChargesPending")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeUpfrontChargesPending(CompanyDtlBean companyDtlBean) {

		return new Gson().toJson(new DashboardDaoImpl().eeUpfrontChargesPending(companyDtlBean));
	}
	
	@POST
	@Path("/eeFullPaymentPending")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeFullPaymentPending(CompanyDtlBean companyDtlBean) {

		return new Gson().toJson(new DashboardDaoImpl().eeFullPaymentPending(companyDtlBean));
	}
	
	@POST
	@Path("/eePaymentPending")
	@Produces(MediaType.APPLICATION_JSON)
	public String eePaymentPending(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eePaymentPending(companyDtlBean));

	}
	
	
	@POST
	@Path("/eePaymentCompleted")
	@Produces(MediaType.APPLICATION_JSON)
	public String eePaymentCompleted(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eePaymentCompleted(companyDtlBean));

	}
	@POST
	@Path("/eeInspectedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeInspectedApplication(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eeInspectedApplication(companyDtlBean));

	}
	@POST
	@Path("/eeMCApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeMCApproved(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eeMCApproved(companyDtlBean));

	}
	@POST
	@Path("/eeFullPaymentCompleted")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeFullPaymentCompleted(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eeFullPaymentCompleted(companyDtlBean));

	}
	@POST
	@Path("/eeExecution")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeExecution(CompanyDtlBean companyDtlBean) {
		return new Gson().toJson(new DashboardDaoImpl().eeExecution(companyDtlBean));

	}
	
	
	
	
	@POST
	@Path("/listProsFeePendingPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public String listProsFeePendingPayment() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listProsFeePendingPayment();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	
	@POST
	@Path("/listeeConPendingPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public String listeeConPendingPayment() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listEePaymentPendingApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/listConPendingPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public String listConPendingPayment() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listConPendingPayment();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	@POST
	@Path("/listConPaidDtls")
	@Produces(MediaType.APPLICATION_JSON)
	public String listConPaidDtls() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listConPaidDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			
			
			applicationBean.setEstimationCost(String.valueOf(app.getPaidfinalFee()));
			
			applicationBean.setInitialPayment(app.getPaidProcessFee());
			
			if(app.getCmwssbZoneNum()!=null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum()!=null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==0){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==1){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	
	
	@GET
	@Path("/listEeApprovedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listEeApprovedApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listEeApprovedApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}
	
	
	@GET
	@Path("/listMcApprovedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listMcApprovedApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listMcApprovedApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}

	@GET
	@Path("/listCeApprovedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String listCeApprovedApplication() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		

		List<Application> appDtls = dashboardDao.listceApprovedApplicationDtls();
		List<ApplicationBean> applicationBeanList = new ArrayList<ApplicationBean>();
		for (Application app : appDtls) {
			MasterZone mastr=new MasterZone();
			mastr.setZoneDesc("other");
			ApplicationBean applicationBean = new ApplicationBean();
			applicationBean.setAppId(app.getAppId());
			applicationBean.setCategoryType(app.getCategoryType()
					.getCategoryName());
			applicationBean.setSalutation(app.getSalutation());
			applicationBean.setContactPersonName(app.getContactPersonName());
			applicationBean.setReqMld(app.getReqMld().toString());
			if(app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			if(app.getCmwssbZoneNum() != null && app.getCmwssbZoneNum().getZoneDesc().equals(null))
			{
			
				applicationBean.setCmwssbZoneNum("other");
			}
			else if(app.getCmwssbZoneNum() != null)
			{
				applicationBean.setCmwssbZoneNum(app.getCmwssbZoneNum()
						.getZoneDesc());
			}
			
			if(app.getIsReconnectionForService() == null )
			{
				applicationBean.setIsReconnectionForService("NO");	
			}
			
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 0 )
			{
				applicationBean.setIsReconnectionForService("NO");
			}
			if(app.getIsReconnectionForService()!= null && app.getIsReconnectionForService() == 1 )
			{
				applicationBean.setIsReconnectionForService("YES");
			}
			applicationBean.setCdoorNo(app.getCdoorNo());
			applicationBean.setCplotNo(app.getCplotNo());
			applicationBean.setCstreetName(app.getCstreetName());
			applicationBean.setClocation(app.getClocation());
			applicationBean.setCpinCode(app.getCpinCode());
			applicationBean.setWebAddress(app.getWebAddress());
			if(app.getLandLineNo()!=null){
				applicationBean.setLandLineNo(app.getLandLineNo().toString());
			}
			
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
				applicationBean.setIsNewConnection("NO");
			}
			if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
				applicationBean.setIsNewConnection("YES");
			}
			if(app.getDivId()!=null  && app.getDivId().getDivDesc().equals(null)){
				applicationBean.setDivId("");
			}
			else if(app.getDivId()!=null)
			{
				applicationBean.setDivId(app.getDivId().getDivDesc());
				applicationBean.setRemarks(app.getRemarks());
			}
			
			applicationBean.setDoorNo(app.getDoorNo());
			applicationBean.setPlotNo(app.getPlotNo());
			applicationBean.setStreetName(app.getStreetName());
			applicationBean.setLocation(app.getLocation());
			applicationBean.setPinCode(app.getPinCode());
			
			applicationBean.setLegCompName(app.getLegCompName());
			applicationBean.setCreateDate(app.getCreateTs().toString());
			if(app.getIsExistConnectionForAlteration()!=null && app.getIsExistConnectionForAlteration()==1){
			applicationBean.setIsExistConnectionForAlteration("NO");
			}
			if(app.getIsExistConnectionForAlteration()!=null&&app.getIsExistConnectionForAlteration()==2){
				applicationBean.setIsExistConnectionForAlteration("YES");
				}
			applicationBeanList.add(applicationBean);
		

		}
		

		return gson.toJson(applicationBeanList);

	}

	
	@POST
	@Path("/CeApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String CeApproved(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.ceApproved(applicationBean));

	}
	

	@POST
	@Path("/registeredApplicationApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String registeredApplicationApproved(DDPaymentFormBean dDPaymentFormBean) {
	Session	session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
try{
	transaction.begin();
	CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
	companyDtl.setRegion((MasterRegion) session.get(MasterRegion.class, Integer.parseInt(dDPaymentFormBean.getRegion())));
	companyDtl.setCircle((MasterCircle) session.get(MasterCircle.class, Integer.parseInt(dDPaymentFormBean.getCircle())));
	companyDtl.setDivision((MasterHODivision) session.get(MasterHODivision.class, Integer.parseInt(dDPaymentFormBean.getDivision())));
	companyDtl.setEeStatus( (MasterStatus)session.get(MasterStatus.class,1));
	companyDtl.setActive(2);
	companyDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
	session.update(companyDtl);
	transaction.commit();
	
	//maha addedd
	
	
	final Integer emailType=3;
	final String status="test";
	
	final Integer smsType = 2;
	final String smsTemp="Dear%20sir,%20Your%20"+dDPaymentFormBean.getAppId()+"%20Application%20Assigned%20to%20Executive%20Officer.";
	final String smsTempEE="You%20have%20received%20Application"+dDPaymentFormBean.getAppId();
	final String application_ID = dDPaymentFormBean.getAppId();
	Thread notify = new Thread(new Runnable() {
		@Override
		public void run() {
			SMSBuilder obj = new SMSBuilder();
			obj.getSmsTemplate(application_ID,smsType,smsTemp);
			obj.getStatus(application_ID, status);
			
			obj.getSmsTemplatetoEE(application_ID,smsType,smsTempEE);
			obj.getStatustoEE(application_ID, status);
		}
	}, "notify");
	notify.start();
	
}
catch(Exception e){
	e.printStackTrace();
	transaction.rollback();
	return "Application not Approved";
}
finally{
	session.close();
}
		return "Application Approved";

	}
	
	
	
	
	
	@POST
	@Path("/transferApplicationSave")
	@Produces(MediaType.APPLICATION_JSON)
	public String transferApplicationSave(DDPaymentFormBean dDPaymentFormBean) {
	Session	session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
try{
	transaction.begin();
	CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
	companyDtl.setRegion((MasterRegion) session.get(MasterRegion.class, Integer.parseInt(dDPaymentFormBean.getRegion())));
	companyDtl.setCircle((MasterCircle) session.get(MasterCircle.class, Integer.parseInt(dDPaymentFormBean.getCircle())));
	companyDtl.setDivision((MasterHODivision) session.get(MasterHODivision.class, Integer.parseInt(dDPaymentFormBean.getDivision())));
	companyDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
	session.update(companyDtl);
	transaction.commit();
	
	//maha addedd
	
	
	final Integer emailType=3;
	final String status="test";
	
	final Integer smsType = 2;
	final String smsTemp="Dear%20sir,%20Your%20"+dDPaymentFormBean.getAppId()+"%20Application%20Assigned%20to%20Executive%20Officer.";
	final String smsTempEE="You%20have%20received%20Application"+dDPaymentFormBean.getAppId();
	final String application_ID = dDPaymentFormBean.getAppId();
	Thread notify = new Thread(new Runnable() {
		@Override
		public void run() {
			SMSBuilder obj = new SMSBuilder();
			obj.getSmsTemplate(application_ID,smsType,smsTemp);
			obj.getStatus(application_ID, status);
			
			obj.getSmsTemplatetoEE(application_ID,smsType,smsTempEE);
			obj.getStatustoEE(application_ID, status);
		}
	}, "notify");
	notify.start();
	
}
catch(Exception e){
	e.printStackTrace();
	transaction.rollback();
	return "Application not Transfered";
}
finally{
	session.close();
}
		return "Application Transfered";

	}
	
	
	
	@POST
	@Path("/registeredApplicationRejected")
	@Produces(MediaType.APPLICATION_JSON)
	public String registeredApplicationRejected(DDPaymentFormBean dDPaymentFormBean) {
		Session	session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	try{
		transaction.begin();
		CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
		companyDtl.setActive(0);
		companyDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
		session.update(companyDtl);
		transaction.commit();
		
	}
	catch(Exception e){
		e.printStackTrace();
		transaction.rollback();
		return "Application is not Rejected";
	}
	finally{
		session.close();
	}
			return "Application Rejected";

		}


	@POST
	@Path("/approvedApplicationEdit")
	@Produces(MediaType.APPLICATION_JSON)
	public String approvedApplicationEdit(DDPaymentFormBean dDPaymentFormBean) {
	Session	session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
try{
	transaction.begin();
	CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
	companyDtl.setDivision(null);
	companyDtl.setEeStatus( (MasterStatus)session.get(MasterStatus.class,1));
	companyDtl.setActive(1);
	session.update(companyDtl);
	transaction.commit();
	
		
}
catch(Exception e){
	e.printStackTrace();
	transaction.rollback();
	return "Application unable to Edit";
}
finally{
	session.close();
}
		return "Application Moved to Pending Tab";

	}

	
	
	
	
	@POST
	@Path("/ddPaymentApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String ddPaymentApproved(DDPaymentFormBean dDPaymentFormBean) {
	Session	session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
try{
	
	Transaction tx1 =  session.beginTransaction();
	CompanyDtl companyDtl = (CompanyDtl)session.get(CompanyDtl.class,dDPaymentFormBean.getAppId());
	companyDtl.setEeStatus( (MasterStatus)session.get(MasterStatus.class,1));
	companyDtl.setActive(2);
	companyDtl.setUpdateTs(new Date());
	companyDtl.setUpdateUserId("Administrator");
	session.update(companyDtl);
	tx1.commit();
	
	
	transaction.begin();
	CompanyPaymentDtl  companyPaymentDtl = (CompanyPaymentDtl) session.get(CompanyPaymentDtl.class, dDPaymentFormBean.getCompanyPaymentDtlID());
	companyPaymentDtl.setPaymentStatusFlag('A');
	companyPaymentDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
	session.update(companyPaymentDtl);
	transaction.commit();
	
}
catch(Exception e){
	e.printStackTrace();
	transaction.rollback();
	return "DD is not Approved";
}
finally{
	session.close();
}
		return "DD Approved";

	}
	
	@POST
	@Path("/ddPaymentRejected")
	@Produces(MediaType.APPLICATION_JSON)
	public String ddPaymentRejected(DDPaymentFormBean dDPaymentFormBean) {
		Session	session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	try{
		transaction.begin();
		CompanyPaymentDtl  companyPaymentDtl = (CompanyPaymentDtl) session.get(CompanyPaymentDtl.class, dDPaymentFormBean.getCompanyPaymentDtlID());
		companyPaymentDtl.setPaymentStatusFlag('R');
		companyPaymentDtl.setManagementComments(dDPaymentFormBean.getManagementComments());
		session.update(companyPaymentDtl);
		transaction.commit();
		
	}
	catch(Exception e){
		e.printStackTrace();
		transaction.rollback();
		return "DD is not Rejected";
	}
	finally{
		session.close();
	}
			return "DD REjected";

		}
	
	@POST
	@Path("/paymentApproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String paymentApproved(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.paymentApproved(applicationBean));

	}
	
	@POST
	@Path("/eeRejcted")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeRejcted(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.eeRejected(applicationBean));

	}
	
	@POST
	@Path("/SendEstimationCost")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendEstimationCost(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return dashboardDao.SendEstimationCost(applicationBean);

	}
	
	@POST
	@Path("/SendOracleDb")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendOracleDb(OracleDbBean oracleDbBean) throws ParseException {
		
		SimpleDateFormat source = new SimpleDateFormat("dd-mm-yyyy");
		
		SimpleDateFormat target = new SimpleDateFormat("yyyy-mm-dd");
		
		
		CmwWaterConnBean cmwWaterConnBean = new CmwWaterConnBean();
		
		cmwWaterConnBean.setChALLAN_NO(oracleDbBean.getAppId());
		cmwWaterConnBean.setAdDITIONAL_AMT(((Float)Float.parseFloat(oracleDbBean.getInitialPaymentCost())).intValue());
		cmwWaterConnBean.setChALLAN_AMT(((Float)Float.parseFloat(oracleDbBean.getEstimationCost())).intValue());
		cmwWaterConnBean.setDaTE_OF_CONN(target.parse(target.format(source.parse(oracleDbBean.getCompletionDate()))));
		cmwWaterConnBean.setDaTE_OF_SANC(target.parse(target.format(source.parse(oracleDbBean.getCommissionDate()))));
		cmwWaterConnBean.setAdDITION_DATE(target.parse(target.format(source.parse(oracleDbBean.getCommissionDate()))));
		cmwWaterConnBean.setGst_AMT(((Float)Float.parseFloat(oracleDbBean.getGstAmount())).intValue());
		cmwWaterConnBean.setTotal_AMT(((Float)Float.parseFloat(oracleDbBean.getTotalAmount())).intValue());
		
		

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return dashboardDao.SendOracleDb(cmwWaterConnBean);

	}
	@POST
	@Path("/eeWidthdraw")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeWidthdraw(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.eeWidthdraw(applicationBean));

	}
	
	
	@POST
	@Path("/SendinitialPaymentCost")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendinitialPaymentCost(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.sendInitialPaymentCost(applicationBean));

	}
	@POST
	@Path("/isMcDicision")
	@Produces(MediaType.APPLICATION_JSON)
	public String isMcDicision(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.isMcDicision(applicationBean));

	}
	
	@POST
	@Path("/isMcTrckDicision")
	@Produces(MediaType.APPLICATION_JSON)
	public String isMcTrckDicision(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.isMcTrckDicision(applicationBean));

	}
	
	
	
	
	@POST
	@Path("/SendInspectionDateOLD")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendInspectionDateOLD(ApplicationBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.SendInspectionDate(applicationBean));

	}
	@POST
	@Path("/SendInspectionDate")
	@Produces(MediaType.APPLICATION_JSON)
	public String SendInspectionDate(CompanyDtlBean applicationBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();
		return gson.toJson(dashboardDao.SendInspectionDate(applicationBean));

	}
	
	

	
	@POST
	@Path("/getceDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getceDashboardCount() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();

		//DashboardBean dashboardBean = new DashboardBean();
		DashboardCountBean dashboardCountBean=new DashboardCountBean();

		for (Object[] rowData : dashboardDao.getceDashboardCount()) {
			dashboardCountBean.setTotalRegister(Integer.parseInt(rowData[0]
					.toString()));
			dashboardCountBean.setPenndingApplication(Integer.parseInt(rowData[1]
					.toString()));
			dashboardCountBean.setApprovedApplication(Integer.parseInt(rowData[2]
					.toString()));

			dashboardCountBean.setPaidApplication(Integer.parseInt(rowData[3]
					.toString()));

			dashboardCountBean.setYesCount(3);

			dashboardCountBean.setNoCount(30);

			dashboardCountBean.setNACount(20);
			dashboardCountBean.setNACount(20);
			

		}
		return gson.toJson(dashboardCountBean);
	}


	@POST
	@Path("/getPaymentDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPaymentDashboardCount() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();

		//DashboardBean dashboardBean = new DashboardBean();
		DashboardCountBean dashboardCountBean=new DashboardCountBean();

		for (Object[] rowData : dashboardDao.getPaymentDashboardCount()) {
			
			
			dashboardCountBean.setApprovedApplication(Integer.parseInt(rowData[0]
					.toString()));

			dashboardCountBean.setRejectedApplication(Integer.parseInt(rowData[1]
					.toString()));
			dashboardCountBean.setPenndingApplication(Integer.parseInt(rowData[2]
					.toString()));

			dashboardCountBean.setYesCount(3);

			dashboardCountBean.setNoCount(30);

			dashboardCountBean.setNACount(20);
			dashboardCountBean.setNACount(20);
			

		}
		return gson.toJson(dashboardCountBean);
	}
	
	
	
	@POST
	@Path("/registeredApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String registeredApplication() {
		return new Gson().toJson(new DashboardDaoImpl().registeredApplication());

	}
	
	@POST
	@Path("/approvedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String approvedApplication() {
		return new Gson().toJson(new DashboardDaoImpl().approvedApplication());

	}
	@POST
	@Path("/transferApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String transferApplication() {
		return new Gson().toJson(new DashboardDaoImpl().transferApplication());

	}
	
	@POST
	@Path("/rejectedApplication")
	@Produces(MediaType.APPLICATION_JSON)
	public String rejectedApplication() {
		return new Gson().toJson(new DashboardDaoImpl().rejectedApplication());

	}

	@POST
	@Path("/paymentPendingList")
	@Produces(MediaType.APPLICATION_JSON)
	public String paymentPendingList() {
		return new Gson().toJson(new DashboardDaoImpl().paymentPendingList());

	}
		
	
	@GET
	@Path("/paymentRejectedList")
	@Produces(MediaType.APPLICATION_JSON)
	public String paymentRejectedList() {

		return new Gson().toJson(new DashboardDaoImpl().paymentRejectedList());
	}

	
	@GET
	@Path("/paymentApprovedList")
	@Produces(MediaType.APPLICATION_JSON)
	public String paymentApprovedList() {

		return new Gson().toJson(new DashboardDaoImpl().paymentApprovedList());
	}

	
	
	@GET
	@Path("/ddPaymentViewAllList")
	@Produces(MediaType.APPLICATION_JSON)
	public String ddPaymentViewAllList() {
		
		List<CompanyDtl> companyDtlsList = new DashboardDaoImpl().ddPaymentViewAllList();
		List<DDPaymentFormBean> ddPaymentFormBeanList = new ArrayList<>();
		for (CompanyDtl app : companyDtlsList) {
			DDPaymentFormBean ddPaymentFormBean = new DDPaymentFormBean();

ddPaymentFormBean.setAppId(app.getAppId());
ddPaymentFormBean.setLegCompName(app.getLegCompName());
ddPaymentFormBean.setCdoorNo(app.getCdoorNo());
ddPaymentFormBean.setCplotNo(app.getCplotNo());
ddPaymentFormBean.setCstreetName(app.getCstreetName());
ddPaymentFormBean.setClocation(app.getClocation());
ddPaymentFormBean.setCpinCode(app.getCpinCode());
ddPaymentFormBean.setSalutation(app.getSalutation());
ddPaymentFormBean.setContactPersonName(app.getContactPersonName());
ddPaymentFormBean.setMobileNum(app.getMobileNum());
ddPaymentFormBean.setEmailAddr(app.getEmailAddr());
ddPaymentFormBean.setCategoryType(app.getCategoryType().getCategoryName());
if(null != app.getDivision())
ddPaymentFormBean.setDivisionName(app.getDivision().getDivisionName());

ddPaymentFormBean.setAddrPremSought(app.getAddrPremSought());
ddPaymentFormBean.setDoorNo(app.getDoorNo());
ddPaymentFormBean.setPlotNo(app.getPlotNo());
ddPaymentFormBean.setStreetName(app.getStreetName());
ddPaymentFormBean.setLocation(app.getLocation());
ddPaymentFormBean.setDistrict(app.getDistrict().getDistrictName());
ddPaymentFormBean.setTaluk(app.getTaluk().getTalukName());
ddPaymentFormBean.setVillage(app.getVillage().getVillageName());
ddPaymentFormBean.setPincode(app.getPinCode());
ddPaymentFormBean.setSurveyFieldNo(app.getSurveyFieldNo());
ddPaymentFormBean.setIsNewConnection(app.getIsNewConnection());
ddPaymentFormBean.setReqMld(app.getReqMld());
ddPaymentFormBean.setGstAmount(app.getGstAmount());
ddPaymentFormBean.setTotalAmount(app.getTotalAmount());
ddPaymentFormBean.setIntrPlumStatus(app.getIntrPlumStatus());
ddPaymentFormBean.setWorkType(app.getWorkType());
ddPaymentFormBean.setPaymentStatus(app.getPaymentStatus());
ddPaymentFormBean.setCreateDate(app.getCreateTs().toString());

ddPaymentFormBean.setMcUser(app.getMcUser());
ddPaymentFormBean.setMcSLTCUser(app.getMcSLTCUser());
ddPaymentFormBean.setMcBoardUser(app.getMcBoardUser());

if(app.getActive()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.HOUSER_ASSIGN_OFFICE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PENDING_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_APPLICATION_FEE+"\n"+StatusConstant.EEUSER_PENDING_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.MCUSER_APPROVED_FULL_PAYMENT +"\n"+StatusConstant.EEUSER_PENDING_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==4){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_WAITING_INSPECTION);
}
else if(app.getActive()==3 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_UPFRONT_CHARGES+"\n"+StatusConstant.MCUSER_PENDING_FULL_PAYMENT_APPROVAL);
}


			
			ddPaymentFormBeanList.add(ddPaymentFormBean);
		}
		

		return new Gson().toJson(ddPaymentFormBeanList);
	}
	
	
	
	
	@POST
	@Path("/eeViewAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String eeViewAll(CompanyDtlBean companyDtlBean){
		
		List<CompanyDtl> companyDtlsList = new DashboardDaoImpl().eeViewAll(companyDtlBean);
		List<DDPaymentFormBean> ddPaymentFormBeanList = new ArrayList<>();
		for (CompanyDtl app : companyDtlsList) {
			DDPaymentFormBean ddPaymentFormBean = new DDPaymentFormBean();

ddPaymentFormBean.setAppId(app.getAppId());
ddPaymentFormBean.setLegCompName(app.getLegCompName());
ddPaymentFormBean.setCdoorNo(app.getCdoorNo());
ddPaymentFormBean.setCplotNo(app.getCplotNo());
ddPaymentFormBean.setCstreetName(app.getCstreetName());
ddPaymentFormBean.setClocation(app.getClocation());
ddPaymentFormBean.setCpinCode(app.getCpinCode());
ddPaymentFormBean.setSalutation(app.getSalutation());
ddPaymentFormBean.setContactPersonName(app.getContactPersonName());
ddPaymentFormBean.setMobileNum(app.getMobileNum());
ddPaymentFormBean.setEmailAddr(app.getEmailAddr());
ddPaymentFormBean.setCategoryType(app.getCategoryType().getCategoryName());
if(null != app.getDivision())
ddPaymentFormBean.setDivisionName(app.getDivision().getDivisionName());

ddPaymentFormBean.setAddrPremSought(app.getAddrPremSought());
ddPaymentFormBean.setDoorNo(app.getDoorNo());
ddPaymentFormBean.setPlotNo(app.getPlotNo());
ddPaymentFormBean.setStreetName(app.getStreetName());
ddPaymentFormBean.setLocation(app.getLocation());
ddPaymentFormBean.setDistrict(app.getDistrict().getDistrictName());
ddPaymentFormBean.setTaluk(app.getTaluk().getTalukName());
ddPaymentFormBean.setVillage(app.getVillage().getVillageName());
ddPaymentFormBean.setPincode(app.getPinCode());
ddPaymentFormBean.setSurveyFieldNo(app.getSurveyFieldNo());
ddPaymentFormBean.setIsNewConnection(app.getIsNewConnection());
ddPaymentFormBean.setReqMld(app.getReqMld());
ddPaymentFormBean.setGstAmount(app.getGstAmount());
ddPaymentFormBean.setTotalAmount(app.getTotalAmount());
ddPaymentFormBean.setIntrPlumStatus(app.getIntrPlumStatus());
ddPaymentFormBean.setWorkType(app.getWorkType());
ddPaymentFormBean.setPaymentStatus(app.getPaymentStatus());
ddPaymentFormBean.setCreateDate(app.getCreateTs().toString());

ddPaymentFormBean.setMcUser(app.getMcUser());
ddPaymentFormBean.setMcSLTCUser(app.getMcSLTCUser());
ddPaymentFormBean.setMcBoardUser(app.getMcBoardUser());

if(app.getActive()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.HOUSER_ASSIGN_OFFICE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PENDING_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_APPLICATION_FEE+"\n"+StatusConstant.EEUSER_PENDING_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.MCUSER_APPROVED_FULL_PAYMENT +"\n"+StatusConstant.EEUSER_PENDING_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==4){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_WAITING_INSPECTION);
}
else if(app.getActive()==3 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_UPFRONT_CHARGES+"\n"+StatusConstant.MCUSER_PENDING_FULL_PAYMENT_APPROVAL);
}


			
			ddPaymentFormBeanList.add(ddPaymentFormBean);
		}
		

		return new Gson().toJson(ddPaymentFormBeanList);
	}
	
	
	

	@POST
	@Path("/paymentViewForm")
	@Produces(MediaType.APPLICATION_JSON)
	public DDPaymentFormBean paymentViewForm(DDPaymentFormBean ddPaymentFormBean) {
		
		CompanyDtl app = new DashboardDaoImpl().paymentViewForm(ddPaymentFormBean);
		
if(app !=null){
ddPaymentFormBean.setAppId(app.getAppId());
ddPaymentFormBean.setLegCompName(app.getLegCompName());
ddPaymentFormBean.setCdoorNo(app.getCdoorNo());
ddPaymentFormBean.setCplotNo(app.getCplotNo());
ddPaymentFormBean.setCstreetName(app.getCstreetName());
ddPaymentFormBean.setClocation(app.getClocation());
ddPaymentFormBean.setCpinCode(app.getCpinCode());
ddPaymentFormBean.setSalutation(app.getSalutation());
ddPaymentFormBean.setContactPersonName(app.getContactPersonName());
ddPaymentFormBean.setMobileNum(app.getMobileNum());
ddPaymentFormBean.setEmailAddr(app.getEmailAddr());
ddPaymentFormBean.setCategoryType(app.getCategoryType().getCategoryName());
if(null != app.getDivision())
ddPaymentFormBean.setDivisionName(app.getDivision().getDivisionName());

ddPaymentFormBean.setAddrPremSought(app.getAddrPremSought());

ddPaymentFormBean.setDoorNo(app.getDoorNo());
ddPaymentFormBean.setPlotNo(app.getPlotNo());
ddPaymentFormBean.setStreetName(app.getStreetName());
ddPaymentFormBean.setLocation(app.getLocation());
ddPaymentFormBean.setDistrict(app.getDistrict().getDistrictName());
ddPaymentFormBean.setTaluk(app.getTaluk().getTalukName());
ddPaymentFormBean.setVillage(app.getVillage().getVillageName());
ddPaymentFormBean.setPincode(app.getPinCode());
ddPaymentFormBean.setSurveyFieldNo(app.getSurveyFieldNo());

ddPaymentFormBean.setCreateDate(app.getCreateTs().toString());

ddPaymentFormBean.setIsNewConnection(app.getIsNewConnection());
if(app.getIsNewConnection()!=null && app.getIsNewConnection()==0){
	ddPaymentFormBean.setIsNewConnectionDisplay("NO");
}
else if(app.getIsNewConnection()!=null && app.getIsNewConnection()==1){
	ddPaymentFormBean.setIsNewConnectionDisplay("YES");
}

ddPaymentFormBean.setReqMld(app.getReqMld());
ddPaymentFormBean.setApplicationFee(app.getApplicationFee()+"");
ddPaymentFormBean.setGstPercent(app.getGstPercent()+"");
ddPaymentFormBean.setUpfrontCharges(app.getUpfrontCharges());
ddPaymentFormBean.setGstAmount(app.getGstAmount());
ddPaymentFormBean.setTotalAmount(app.getTotalAmount());

ddPaymentFormBean.setIntrPlumStatus(app.getIntrPlumStatus());

ddPaymentFormBean.setWorkType(app.getWorkType());


if(app.getIntrPlumStatus()!=null && app.getIntrPlumStatus()==0){
	ddPaymentFormBean.setIntrPlumStatusDisplay("NO");
}
else if(app.getIntrPlumStatus()!=null && app.getIntrPlumStatus()==1){
	ddPaymentFormBean.setIntrPlumStatusDisplay("YES");
}


if(app.getWorkType()==0){
	ddPaymentFormBean.setWorkTypeDisplay("Treated (Chloronated)");
}
else if(app.getWorkType()==1){
	ddPaymentFormBean.setWorkTypeDisplay("Secondary treated water");
}

ddPaymentFormBean.setPaymentStatus(app.getPaymentStatus());

if(app.getPaymentStatus()==0){
	ddPaymentFormBean.setPaymentStatusDisplay("Pending");
}
else{
	ddPaymentFormBean.setPaymentStatusDisplay("Paid");
}




if(app.getActive()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.HOUSER_ASSIGN_OFFICE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PENDING_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_APPLICATION_FEE);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_APPLICATION_FEE+"\n"+StatusConstant.EEUSER_PENDING_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==2  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_UPFRONT_CHARGES);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.MCUSER_APPROVED_FULL_PAYMENT +"\n"+StatusConstant.EEUSER_PENDING_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==3  && app.getPaymentStatus()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_PAID_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==4){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_FULL_PAYMENT);
}
else if(app.getActive()==2 && app.getEeStatus().getStatusId()==1){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_WAITING_INSPECTION);
}
else if(app.getActive()==3 && app.getPaymentStatus()==0){
	ddPaymentFormBean.setManagementComments(StatusConstant.EEUSER_APPROVED_UPFRONT_CHARGES+"\n"+StatusConstant.MCUSER_PENDING_FULL_PAYMENT_APPROVAL);
}	

}


List<MasterPayment> masterPaymentList = new DashboardDaoImpl().getManagementSetpaymentList(ddPaymentFormBean.getAppId());
for(MasterPayment masterPayment :masterPaymentList){
	
	if(masterPayment.getPaymentType().getPaymentTypeId()==1){
		ddPaymentFormBean.setApplicationFee(masterPayment.getPaymentAmount()+"");
		ddPaymentFormBean.setGstPercent(masterPayment.getGstPercent()+"");
		ddPaymentFormBean.setGstAmount(masterPayment.getGstAmount());
		ddPaymentFormBean.setTotalAmount(masterPayment.getTotalAmount());
	}
	else if(masterPayment.getPaymentType().getPaymentTypeId()==2)
	   ddPaymentFormBean.setUpfrontCharges(Integer.parseInt(masterPayment.getTotalAmount()));
	else if(masterPayment.getPaymentType().getPaymentTypeId()==3)
		   ddPaymentFormBean.setFullPayment(Integer.parseInt(masterPayment.getTotalAmount()));
	
}


List<DDPaymentFormBean> ddPaymentFormBeans = new ArrayList<>();

List<CompanyPaymentDtl> companyPaymentDtlList = new DashboardDaoImpl().getUserPaymentList(ddPaymentFormBean.getAppId());

for(CompanyPaymentDtl companyPaymentDtl :companyPaymentDtlList){
	DDPaymentFormBean ddPaymentBean = new DDPaymentFormBean();
	ddPaymentBean.setTransactionRefNo(companyPaymentDtl.getTransactionRefNo());
	ddPaymentBean.setBankRefNo(companyPaymentDtl.getBankRefNo());
	
	ddPaymentBean.setPaymentType(companyPaymentDtl.getPaymentType().getPaymentType());
	ddPaymentBean.setPaymentAmount(companyPaymentDtl.getPaymentAmount());
	
	ddPaymentFormBeans.add(ddPaymentBean);
}

ddPaymentFormBean.setPaymentList(ddPaymentFormBeans);

		return ddPaymentFormBean;
	}

	
	
	@POST
	@Path("/geteeDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String geteeDashboardCount(CompanyDtlBean companyDtlBean) {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();

		//DashboardBean dashboardBean = new DashboardBean();
		DashboardCountBean dashboardCountBean=new DashboardCountBean();

		for (Object[] rowData : dashboardDao.geteeDashboardCount(companyDtlBean)) {
			dashboardCountBean.setApplicationFeePending(Integer.parseInt(rowData[0]
					.toString()));
			dashboardCountBean.setUpfrontChargesPending(Integer.parseInt(rowData[1]
					.toString()));
			dashboardCountBean.setFullPaymentPending(Integer.parseInt(rowData[2]
					.toString()));
			
			dashboardCountBean.setFullPaymentCompleted(Integer.parseInt(rowData[3]
					.toString()));
			dashboardCountBean.setExecution(Integer.parseInt(rowData[4]
					.toString()));

			dashboardCountBean.setApprovedApplication(Integer.parseInt(rowData[3]
					.toString()));
			

			dashboardCountBean.setYesCount(3);

			dashboardCountBean.setNoCount(30);

			dashboardCountBean.setNACount(20);
			dashboardCountBean.setNACount(20);

		}
		return gson.toJson(dashboardCountBean);
	}
	
	@POST
	@Path("/getMCDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMCDashboardCount() {

		dashboardDao = new DashboardDaoImpl();
		gson = new Gson();

		DashboardCountBean dashboardCountBean=new DashboardCountBean();

		for (Object[] rowData : dashboardDao.getMCDashboardCount()) {
			
			dashboardCountBean.setPenndingApplication(Integer.parseInt(dashboardDao.getMCDashboardCount()));
			
		//}
		return gson.toJson(dashboardCountBean);
	}

	
	
	
	
	
	
	
	



	@POST
	@Path("updateDocumentInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateDocumentInfo(ComplaintBean complaintBean) {
		gson = new Gson();
		complaintDao = new ComplaintDaoImpl();
		ComplaintDetails complaintDetails = new ComplaintDetails();
		complaintDetails = complaintDao.updateDocumentInfo(complaintBean);
		return gson.toJson(complaintDetails);
	}




	@SuppressWarnings("resource")
	@POST
	@Path("/fileUpload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String fileUpload(FormDataMultiPart multipartdata) {
		InputStream inputstream = null;
		OutputStream outputstream = null;
		Session session = null;
		Transaction transaction = null;
		String result = null;

		try {
			if (multipartdata != null) {

				Integer userId = Integer.parseInt(multipartdata.getField(
						"userId").getValue());

				String complaintNumber = multipartdata.getField(
						"complaintNumber").getValue();

				Integer complaintID = Integer.parseInt(multipartdata.getField(
						"complaint_No").getValue());

				FormDataBodyPart bodypartdata = multipartdata
						.getField("fileObject");
				ContentDisposition contentdisposition = bodypartdata
						.getContentDisposition();

				InputStream uploadedInputStream = bodypartdata
						.getValueAs(InputStream.class);
				try {

					if (!new File(EC_Folder + complaintNumber + "//").exists())
						new File(EC_Folder + complaintNumber).mkdirs();

					OutputStream outpuStream = new FileOutputStream(new File(
							EC_Folder + complaintNumber + "//"
									+ contentdisposition.getFileName()));

					int read = 0;

					byte[] bytes = new byte[1024];

					outpuStream = new FileOutputStream(new File(EC_Folder
							+ complaintNumber + "//"
							+ contentdisposition.getFileName()));

					while ((read = uploadedInputStream.read(bytes)) != -1) {
						outpuStream.write(bytes, 0, read);
					}
					outpuStream.flush();
					outpuStream.close();

				} catch (IOException e) {
					e.printStackTrace();

				}

				// FileUtils.copyFileToDirectory(bodypartdata,
				// directoryPath);
				Long filesize = Long.valueOf(multipartdata.getField("filesize")
						.getValue());

				if (filesize == null) {
					return result = "Folder size has exceeded";
				} else {
					String filepath = EC_Folder + complaintNumber + "//"
							+ contentdisposition.getFileName();

					session = HibernateUtil.getSessionFactory().openSession();
					transaction = session.beginTransaction();
					transaction.begin();
					Integer complaintId = (Integer) session
							.createCriteria(ComplaintDetails.class)
							.add(Restrictions.eq("complaintID", complaintID))
							.setProjection(Projections.property("complaintID"))
							.setMaxResults(1).uniqueResult();
					System.out.println("ComplainId : " + complaintId);

					if (complaintId != null) {
						inputstream = bodypartdata
								.getValueAs(InputStream.class);
						outputstream = new FileOutputStream(filepath);
						int read = 0;
						byte[] bytes = new byte[2048];
						while ((read = inputstream.read(bytes)) != -1) {
							outputstream.write(bytes, 0, read);
						}
						outputstream.flush();

						Documents document = new Documents();
						if (userId > 0)
							document.setDocumentOwner(userId);
						else
							document.setDocumentOwner(0);

						document.setComplaintID(complaintId);
						document.setCreatedDate(new Date());
						document.setDocumentPath(complaintNumber + "//"
								+ contentdisposition.getFileName());
						document.setIsActive(true);
						session.save(document);
						result = "success";
					} else {
						result = "error";
					}

					transaction.commit();
				}

			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
			return null;
		} finally {
			if (inputstream != null) {
				try {
					inputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputstream != null) {
				try {
					outputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	

	@POST
	@Path("/getPublicDashboardCount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPublicDashboardCount(ApplicationBean applicationBean) {

//		complaintDao = new ComplaintDaoImpl();
		dashboardDao=new DashboardDaoImpl();
		gson = new Gson();

DashboardCountBean dashboardBean;

		List<DashboardCountBean> dashboardBeanList = new ArrayList<DashboardCountBean>();

		
		 for (Object[] rowData : dashboardDao
		  .getPublicDashboardCount(applicationBean)) {
		 
		dashboardBean = new DashboardCountBean();
		dashboardBean.setCategoryID(23);
		dashboardBean.setCategoryName("CE");
		dashboardBean.setCategoryCount(30);
		dashboardBean.setIcon("test");
		dashboardBean.setBgColor("red");
		dashboardBeanList.add(dashboardBean);
		 }
		return gson.toJson(dashboardBeanList);
	}
	@POST
	@Path("addNewUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNewUser(EmployeeFormBean employeeFormBean) {
		
	return new DashboardDaoImpl().addNewUser(employeeFormBean);
	}
	@POST
	@Path("editUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editUser(EmployeeFormBean employeeFormBean) {
		
	return new DashboardDaoImpl().editUser(employeeFormBean);
	}
	@POST
	@Path("deleteUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteUser(EmployeeFormBean employeeFormBean) {
		
	return new DashboardDaoImpl().deleteUser(employeeFormBean);
	}
	
	@POST
	@Path("/getUserDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserDtl() {
		gson = new Gson();
		
		List<EmployeeDetails> employeeDetailsList =  new DashboardDaoImpl().getUserDtl();
		List<EmployeeFormBean> employeeFormBeanList = new ArrayList<>();
		
		for(EmployeeDetails employeeDetails:employeeDetailsList){
		
			EmployeeFormBean employeeFormBean = new EmployeeFormBean();
			employeeFormBean.setEmail(employeeDetails.getEmailAddr());
			employeeFormBean.setMobile(String.valueOf(employeeDetails.getPhoneNum()));
			employeeFormBean.setName(employeeDetails.getUserFirstName());
			employeeFormBean.setPassword(employeeDetails.getLoginPassword());
			employeeFormBean.setRole(employeeDetails.getUserRole().getRoleName());
			employeeFormBean.setRoleId(String.valueOf(employeeDetails.getUserRole().getRoleId()));
			if(employeeDetails.getUserDivision() != null){
			employeeFormBean.setDivision(employeeDetails.getUserDivision().getDivisionName());
			employeeFormBean.setDivisionId(String.valueOf(employeeDetails.getUserDivision().getDivisionId()));
			}
			employeeFormBean.setUserId(String.valueOf(employeeDetails.getUserId()));
			employeeFormBean.setUsername(employeeDetails.getLoginUserName());
			employeeFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(employeeFormBeanList);
	}
	

	@POST
	@Path("addCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addCategory(CategoryFormBean categoryFormBean) {
		
	return new DashboardDaoImpl().addCategory(categoryFormBean);
	}
	@POST
	@Path("editCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editCategory(CategoryFormBean categoryFormBean) {
		
	return new DashboardDaoImpl().editCategory(categoryFormBean);
	}
	@POST
	@Path("deleteCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCategory(CategoryFormBean categoryFormBean) {
		
	return new DashboardDaoImpl().deleteCategory(categoryFormBean);
	}
	
	@POST
	@Path("/getCategoryDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCategoryDtl() {
		gson = new Gson();
		
		List<MasterCategory> masterCategoryList =  new DashboardDaoImpl().getCategoryDtl();
		List<CategoryFormBean> categoryFormBeanList = new ArrayList<>();
		
		for(MasterCategory masterCategory:masterCategoryList){
		
			CategoryFormBean employeeFormBean = new CategoryFormBean();
			
			employeeFormBean.setCategoryId(String.valueOf(masterCategory.getCategoyId()));
			employeeFormBean.setCategoryName(masterCategory.getCategoryName());
			employeeFormBean.setCategoryDesc(masterCategory.getCategoryDesc());
			categoryFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(categoryFormBeanList);
	}
	
	
	
	@POST
	@Path("addOffice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addOffice(OfficeFormBean officeFormBean) {
		
	return new DashboardDaoImpl().addOffice(officeFormBean);
	}
	@POST
	@Path("editOffice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editOffice(OfficeFormBean officeFormBean) {
		
	return new DashboardDaoImpl().editOffice(officeFormBean);
	}
	@POST
	@Path("deleteOffice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteOffice(OfficeFormBean officeFormBean) {
		
	return new DashboardDaoImpl().deleteOffice(officeFormBean);
	}
	
	@POST
	@Path("/getOfficeDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOfficeDtl() {
		gson = new Gson();
		
		List<MasterOffice> masterOfficeList =  new DashboardDaoImpl().getOfficeDtl();
		List<OfficeFormBean> officeFormBeanList = new ArrayList<>();
		
		for(MasterOffice masterOffice:masterOfficeList){
		
			OfficeFormBean employeeFormBean = new OfficeFormBean();
			
			employeeFormBean.setOfficeId(String.valueOf(masterOffice.getCategoyId()));
			employeeFormBean.setOfficeName(masterOffice.getOfficeName());
			employeeFormBean.setOfficeDesc(masterOffice.getOfficeDesc());
			officeFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(officeFormBeanList);
	}
	
	
	
	
	
	@POST
	@Path("addPaymentType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addPaymentType(PaymentFormBean paymentTypeFormBean) {
		
	return new DashboardDaoImpl().addPaymentType(paymentTypeFormBean);
	}
	@POST
	@Path("editPaymentType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editPaymentType(PaymentFormBean paymentTypeFormBean) {
		
	return new DashboardDaoImpl().editPaymentType(paymentTypeFormBean);
	}
	@POST
	@Path("deletePaymentType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletePaymentType(PaymentFormBean paymentTypeFormBean) {
		
	return new DashboardDaoImpl().deletePaymentType(paymentTypeFormBean);
	}
	
	@POST
	@Path("/getPaymentTypeDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPaymentTypeDtl() {
		gson = new Gson();
		
		List<MasterPaymentType> masterPaymentTypeList =  new DashboardDaoImpl().getPaymentTypeDtl();
		List<PaymentFormBean> paymentTypeFormBeanList = new ArrayList<>();
		
		for(MasterPaymentType masterPaymentType:masterPaymentTypeList){
		
			PaymentFormBean employeeFormBean = new PaymentFormBean();
			
			employeeFormBean.setPaymentId(String.valueOf(masterPaymentType.getPaymentTypeId()));
			employeeFormBean.setPaymentType(masterPaymentType.getPaymentType());
			employeeFormBean.setPaymentTypeDesc(masterPaymentType.getPaymentTypeDesc());
			paymentTypeFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(paymentTypeFormBeanList);
	}
	
	
	@POST
	@Path("addPayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addPayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().addPayment(paymentFormBean);
	}
	
	@POST
	@Path("eeAddPayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeAddPayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeAddPayment(paymentFormBean);
	}
	
	@POST
	@Path("eeSaveHeaderList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeSaveHeaderList(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeSaveHeaderList(paymentFormBean);
	}
	
	@POST
	@Path("getHeaderList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getHeaderList(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().getHeaderList(paymentFormBean);
	}
	
	@POST
	@Path("eeAddFullPayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeAddFullPayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeAddFullPayment(paymentFormBean);
	}
	
	
	
	
	
	@POST
	@Path("eePaymentPendingApproved")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eePaymentPendingApproved(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eePaymentPendingApproved(paymentFormBean);
	}
	
	@POST
	@Path("eePaymentCompletedApproved")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eePaymentCompletedApproved(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eePaymentCompletedApproved(paymentFormBean);
	}
	
	@POST
	@Path("/eePaymentCompletedMoveToExecution")
	@Produces(MediaType.APPLICATION_JSON)
	public String eePaymentCompletedMoveToExecution(DDPaymentFormBean dDPaymentFormBean) {
		Session	session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	try{
		transaction.begin();
		CompanyDtl  companyDtl = (CompanyDtl) session.get(CompanyDtl.class, dDPaymentFormBean.getAppId());
		companyDtl.setActive(2);
		companyDtl.setEeStatus( (MasterStatus)session.get(MasterStatus.class,5));
		session.update(companyDtl);
		transaction.commit();
		
	}
	catch(Exception e){
		e.printStackTrace();
		transaction.rollback();
		return "Application not Saved";
	}
	finally{
		session.close();
	}
			return "Application Moved to Execution";

		}


	
	
	@POST
	@Path("eeFullPaymentApproved")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeFullPaymentApproved(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeFullPaymentApproved(paymentFormBean);
	}
	
	@POST
	@Path("eeMCApprovedBtn")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String eeMCApprovedBtn(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().eeMCApprovedBtn(paymentFormBean);
	}
	
	@POST
	@Path("mcApprovePayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String mcApprovePayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().mcApprovePayment(paymentFormBean);
	}
	
	
	@POST
	@Path("editPayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editPayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().editPayment(paymentFormBean);
	}
	@POST
	@Path("deletePayment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletePayment(PaymentFormBean paymentFormBean) {
		
	return new DashboardDaoImpl().deletePayment(paymentFormBean);
	}
	
	@POST
	@Path("/getPaymentDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPaymentDtl() {
		gson = new Gson();
		
		List<MasterPayment> masterPaymentList =  new DashboardDaoImpl().getPaymentDtl();
		List<PaymentFormBean> paymentFormBeanList = new ArrayList<>();
		
		for(MasterPayment masterPayment:masterPaymentList){
		
			PaymentFormBean employeeFormBean = new PaymentFormBean();
			
			if(null != masterPayment.getAppId())
			employeeFormBean.setAppId(masterPayment.getAppId().getAppId());
			employeeFormBean.setPaymentId(String.valueOf(masterPayment.getPaymentId()));
			employeeFormBean.setPaymentType(masterPayment.getPaymentType().getPaymentType());
			employeeFormBean.setPaymentTypeId(String.valueOf(masterPayment.getPaymentType().getPaymentTypeId()));
			employeeFormBean.setPaymentAmount(masterPayment.getPaymentAmount());
			employeeFormBean.setPaymentDesc(masterPayment.getPaymentDesc());
			
			employeeFormBean.setGstAmount(masterPayment.getGstAmount());
			employeeFormBean.setGstPercent(masterPayment.getGstPercent());
			employeeFormBean.setTotalAmount(masterPayment.getTotalAmount());
			
			paymentFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(paymentFormBeanList);
	}
	
	
	
	
	
	
	
	@POST
	@Path("addConnectionType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addConnectionType(ConnectionFormBean connectionFormBean) {
		
	return new DashboardDaoImpl().addConnectionType(connectionFormBean);
	}
	@POST
	@Path("editConnectionType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editConnectionType(ConnectionFormBean connectionFormBean) {
		
	return new DashboardDaoImpl().editConnectionType(connectionFormBean);
	}
	@POST
	@Path("deleteConnectionType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteConnectionType(ConnectionFormBean connectionFormBean) {
		
	return new DashboardDaoImpl().deleteConnectionType(connectionFormBean);
	}
	
	@POST
	@Path("/getConnectionTypeDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConnectionTypeDtl() {
		gson = new Gson();
		
		List<MasterReconnection> masterReconnectionList =  new DashboardDaoImpl().getConnectionTypeDtl();
		List<ConnectionFormBean> connectionFormBeanList = new ArrayList<>();
		
		for(MasterReconnection masterReconnection:masterReconnectionList){
			ConnectionFormBean connectionFormBean = new ConnectionFormBean();
			connectionFormBean.setConnectionId(String.valueOf(masterReconnection.getReConnId()));
			connectionFormBean.setConnectionName(masterReconnection.getConnectionType());
			connectionFormBean.setConnectionDesc(masterReconnection.getReConnDes());
			connectionFormBeanList.add(connectionFormBean);
		}
            return gson.toJson(connectionFormBeanList);
	}
	
	
	
	
	
	
	
	
	@POST
	@Path("addZone")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addZone(ZoneDivisionFormBean zoneDivisionFormBean) {
		
	return new DashboardDaoImpl().addZone(zoneDivisionFormBean);
	}
	
	
	
	@POST
	@Path("addDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addDivision(ZoneDivisionFormBean zoneDivisionFormBean) {
		
	return new DashboardDaoImpl().addDivision(zoneDivisionFormBean);
	}
	@POST
	@Path("editDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editDivision(ZoneDivisionFormBean zoneDivisionFormBean) {
		
	return new DashboardDaoImpl().editDivision(zoneDivisionFormBean);
	}
	@POST
	@Path("deleteDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteDivision(ZoneDivisionFormBean zoneDivisionFormBean) {
		
	return new DashboardDaoImpl().deleteDivision(zoneDivisionFormBean);
	}
	
	@POST
	@Path("/getDivisionDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDivisionDtl() {
		gson = new Gson();
		
		List<ZoneDivisionFormBean> zoneDivisionFormBeanList =  new DashboardDaoImpl().getDivisionDtl();
		List<ZoneDivisionFormBean> zoneDivisionFormBeanList = new ArrayList<>();
		
		for(MasterReconnection masterReconnection:masterReconnectionList){
			ZoneDivisionFormBean zoneDivisionFormBean = new ZoneDivisionFormBean();
			zoneDivisionFormBean.setConnectionId(String.valueOf(masterReconnection.getReConnId()));
			zoneDivisionFormBean.setConnectionName(masterReconnection.getConnectionType());
			zoneDivisionFormBean.setConnectionDesc(masterReconnection.getReConnDes());
			zoneDivisionFormBeanList.add(zoneDivisionFormBean);
		}
            return gson.toJson(zoneDivisionFormBeanList);
	}

	
	
	
	
	
	
	
	
	
	

	@POST
	@Path("addDistrict")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addDistrict(DistrictFormBean districtFormBean) {
		
	return new DashboardDaoImpl().addDistrict(districtFormBean);
	}
	@POST
	@Path("editDistrict")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editDistrict(DistrictFormBean districtFormBean) {
		
	return new DashboardDaoImpl().editDistrict(districtFormBean);
	}
	@POST
	@Path("deleteDistrict")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteDistrict(DistrictFormBean districtFormBean) {
		
	return new DashboardDaoImpl().deleteDistrict(districtFormBean);
	}
	
	@POST
	@Path("/getDistrictDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDistrictDtl() {
		gson = new Gson();
		
		List<MasterDistrict> masterDistrictList =  new DashboardDaoImpl().getDistrictDtl();
		List<DistrictFormBean> districtFormBeanList = new ArrayList<>();
		
		for(MasterDistrict masterDistrict:masterDistrictList){
		
			DistrictFormBean employeeFormBean = new DistrictFormBean();
			
			employeeFormBean.setDistrictId(String.valueOf(masterDistrict.getDistrictId()));
			employeeFormBean.setDistrictName(masterDistrict.getDistrictName());
			districtFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(districtFormBeanList);
	}

		
	
	
	@POST
	@Path("addTaluk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addTaluk(DistrictTalukFormBean districtTalukFormBean) {
		
	return new DashboardDaoImpl().addTaluk(districtTalukFormBean);
	}
	@POST
	@Path("editTaluk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editTaluk(DistrictTalukFormBean districtTalukFormBean) {
		
	return new DashboardDaoImpl().editTaluk(districtTalukFormBean);
	}
	@POST
	@Path("deleteTaluk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteTaluk(DistrictTalukFormBean districtTalukFormBean) {
		
	return new DashboardDaoImpl().deleteTaluk(districtTalukFormBean);
	}
	
	@POST
	@Path("/getTalukDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTalukDtl() {
		gson = new Gson();
		
		List<DistrictTalukFormBean> districtTalukFormBeanList =  new DashboardDaoImpl().getTalukDtl();
            return gson.toJson(districtTalukFormBeanList);
	}


	@POST
	@Path("addVillage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addVillage(TalukVillageFormBean talukVillageFormBean) {
		
	return new DashboardDaoImpl().addVillage(talukVillageFormBean);
	}
	@POST
	@Path("editVillage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editVillage(TalukVillageFormBean talukVillageFormBean) {
		
	return new DashboardDaoImpl().editVillage(talukVillageFormBean);
	}
	@POST
	@Path("deleteVillage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteVillage(TalukVillageFormBean talukVillageFormBean) {
		
	return new DashboardDaoImpl().deleteVillage(talukVillageFormBean);
	}
	
	@POST
	@Path("/getVillageDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVillageDtl() {
		gson = new Gson();
		
		List<TalukVillageFormBean> talukVillageFormBeanList =  new DashboardDaoImpl().getVillageDtl();
            return gson.toJson(talukVillageFormBeanList);
	}

	

	@POST
	@Path("addScheme")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addScheme(VillageSchemeFormBean villageSchemeFormBean) {
		
	return new DashboardDaoImpl().addScheme(villageSchemeFormBean);
	}
	@POST
	@Path("editScheme")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editScheme(VillageSchemeFormBean villageSchemeFormBean) {
		
	return new DashboardDaoImpl().editScheme(villageSchemeFormBean);
	}
	@POST
	@Path("deleteScheme")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteScheme(VillageSchemeFormBean villageSchemeFormBean) {
		
	return new DashboardDaoImpl().deleteScheme(villageSchemeFormBean);
	}
	
	@POST
	@Path("/getSchemeDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSchemeDtl() {
		gson = new Gson();
		
		List<VillageSchemeFormBean> villageSchemeFormBeanList =  new DashboardDaoImpl().getSchemeDtl();
            return gson.toJson(villageSchemeFormBeanList);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@POST
	@Path("addRegion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addRegion(RegionFormBean regionFormBean) {
		
	return new DashboardDaoImpl().addRegion(regionFormBean);
	}
	@POST
	@Path("editRegion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editRegion(RegionFormBean regionFormBean) {
		
	return new DashboardDaoImpl().editRegion(regionFormBean);
	}
	@POST
	@Path("deleteRegion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteRegion(RegionFormBean regionFormBean) {
		
	return new DashboardDaoImpl().deleteRegion(regionFormBean);
	}
	
	@POST
	@Path("/getRegionDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRegionDtl() {
		gson = new Gson();
		
		List<MasterRegion> masterRegionList =  new DashboardDaoImpl().getRegionDtl();
		List<RegionFormBean> regionFormBeanList = new ArrayList<>();
		
		for(MasterRegion masterRegion:masterRegionList){
		
			RegionFormBean employeeFormBean = new RegionFormBean();
			
			employeeFormBean.setRegionId(String.valueOf(masterRegion.getRegionId()));
			employeeFormBean.setRegionName(masterRegion.getRegionName());
			regionFormBeanList.add(employeeFormBean);
		}
            return gson.toJson(regionFormBeanList);
	}

		
	
	
	@POST
	@Path("addCircle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addCircle(RegionCircleFormBean regionCircleFormBean) {
		
	return new DashboardDaoImpl().addCircle(regionCircleFormBean);
	}
	@POST
	@Path("editCircle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editCircle(RegionCircleFormBean regionCircleFormBean) {
		
	return new DashboardDaoImpl().editCircle(regionCircleFormBean);
	}
	@POST
	@Path("deleteCircle")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCircle(RegionCircleFormBean regionCircleFormBean) {
		
	return new DashboardDaoImpl().deleteCircle(regionCircleFormBean);
	}
	
	@POST
	@Path("/getCircleDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCircleDtl() {
		gson = new Gson();
		
		List<RegionCircleFormBean> regionCircleFormBeanList =  new DashboardDaoImpl().getCircleDtl();
            return gson.toJson(regionCircleFormBeanList);
	}


	@POST
	@Path("addHODivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addHODivision(CircleDivisionFormBean circleDivisionFormBean) {
		
	return new DashboardDaoImpl().addHODivision(circleDivisionFormBean);
	}
	@POST
	@Path("editHODivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editHODivision(CircleDivisionFormBean circleDivisionFormBean) {
		
	return new DashboardDaoImpl().editHODivision(circleDivisionFormBean);
	}
	@POST
	@Path("deleteHODivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteHODivision(CircleDivisionFormBean circleDivisionFormBean) {
		
	return new DashboardDaoImpl().deleteHODivision(circleDivisionFormBean);
	}
	
	@POST
	@Path("/getHODivisionDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHODivisionDtl() {
		gson = new Gson();
		
		List<CircleDivisionFormBean> talukDivisionFormBeanList =  new DashboardDaoImpl().getHODivisionDtl();
            return gson.toJson(talukDivisionFormBeanList);
	}

	
	@POST
	@Path("addSubDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addSubDivision(DivisionSubDivisionFormBean divisionSubDivisionFormBean) {
		
	return new DashboardDaoImpl().addSubDivision(divisionSubDivisionFormBean);
	}
	@POST
	@Path("editSubDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editSubDivision(DivisionSubDivisionFormBean divisionSubDivisionFormBean) {
		
	return new DashboardDaoImpl().editSubDivision(divisionSubDivisionFormBean);
	}
	@POST
	@Path("deleteSubDivision")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteSubDivision(DivisionSubDivisionFormBean divisionSubDivisionFormBean) {
		
	return new DashboardDaoImpl().deleteSubDivision(divisionSubDivisionFormBean);
	}
	
	@POST
	@Path("/getSubDivisionDtl")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSubDivisionDtl() {
		gson = new Gson();
		
		List<DivisionSubDivisionFormBean> talukSubDivisionFormBeanList =  new DashboardDaoImpl().getSubDivisionDtl();
            return gson.toJson(talukSubDivisionFormBeanList);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@POST
	@Path("/getFixedPaymentAmount")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFixedPaymentAmount() {
		
            return new Gson().toJson(new DashboardDaoImpl().getFixedPaymentAmount());
	}


	
	
	
	
	
	
	
	
}
*/