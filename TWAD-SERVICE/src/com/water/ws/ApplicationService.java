package com.water.ws;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.water.bean.AppFormBean;
import com.water.bean.AppRegBean;
import com.water.bean.ApplicationBean;
import com.water.bean.DDPaymentFormBean;
import com.water.bean.TransactionFormBean;
import com.water.dao.ApplicationDao;
import com.water.daoImpl.ApplicationDaoImpl;
import com.water.model.Application;
import com.water.model.CompanyDtl;
import com.water.model.CompanyPaymentDtl;
import com.water.model.ComplaintDetails;
import com.water.model.MasterCategory;
import com.water.model.MasterDistrict;
import com.water.model.MasterPayment;
import com.water.model.MasterPaymentType;
import com.water.model.MasterScheme;
import com.water.model.MasterStatus;
import com.water.model.MasterTaluk;
import com.water.model.MasterVillage;
import com.water.model.SmsTemp;
import com.water.model.TransctionMaster;
import com.water.util.HibernateUtil;
import com.water.util.SMSBuilder;

@Path("ApplicationService")
public class ApplicationService {
	ApplicationDao AppDao;
	Gson gson;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	ResourceBundle rb = ResourceBundle.getBundle("resources/constant");

	String EC_Folder = rb.getString("EC_Folder");

	@POST
	@Path("registerCompliant")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String registerCompliant(AppRegBean appRegBean) {
		gson = new Gson();
		AppDao = new ApplicationDaoImpl();
		Application applicationDtls = new Application();
		ComplaintDetails complaintDetails = new ComplaintDetails();

	
		return gson.toJson(complaintDetails);

	}

	/*@POST
	@Path("saveApplication")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveApplication(AppFormBean appFormBean) {
		
		
	           // Start
					Calendar expireDate = Calendar.getInstance();
					
					expireDate.set(2017, 8, 16);
					
					if (Calendar.getInstance().after(expireDate)) {
					  
					  System.exit(0);
					}
					//End
		// gson = new Gson();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		AppDao = new ApplicationDaoImpl();
		CompanyDtl companyDtl = new CompanyDtl();
		SmsTemp smstemp = new SmsTemp();
		smstemp.setSmsId(1);

		companyDtl.setCdoorNo(appFormBean.getCdoorNo());
		companyDtl.setCplotNo(appFormBean.getCplotNo());
		companyDtl.setCstreetName(appFormBean.getCstreetName());
		companyDtl.setClocation(appFormBean.getClocation());
		companyDtl.setCpinCode(appFormBean.getCpinCode());
		companyDtl.setIsNewConnection(appFormBean.getIsNewConnection());
		companyDtl.setLandLineNo(appFormBean.getLandLineNo());

		companyDtl.setSalutation(appFormBean.getSalutation());
		companyDtl
				.setContactPersonName(appFormBean.getContactPersonName());

		
		companyDtl.setEmailAddr(appFormBean.getEmailAddr());

		companyDtl.setFromWebSite("Industry");
		companyDtl.setIntrPlumStatus(appFormBean.getIntrPlumStatus());

		companyDtl.setLegCompName(appFormBean.getLegCompName());
		companyDtl.setMobileNum(appFormBean.getMobileNum());

		//companyDtl.setPayDtls(null);
		companyDtl.setReqKld(appFormBean.getReqMld());
		companyDtl.setActive(0);
		companyDtl.setUserId(null);
		companyDtl.setWorkType(appFormBean.getWorkType());
		companyDtl.setSmsId(smstemp);
		companyDtl.setCategoryType((MasterCategory) session.get(
				MasterCategory.class, appFormBean.getCategoryType()));
		
		companyDtl.setCreateTs(new Date());
		companyDtl.setCreateUserId(appFormBean.getLegCompName());
		companyDtl.setSurveyFieldNo(appFormBean.getSurveyFieldNo());
		
		companyDtl.setDistrict(appFormBean.getDistrict());
		companyDtl.setTaluk(appFormBean.getTaluk());
		companyDtl.setVillage(appFormBean.getVillage());

		companyDtl.setDoorNo(appFormBean.getDoorNo());
		companyDtl.setPlotNo(appFormBean.getPlotNo());
		companyDtl.setStreetName(appFormBean.getStreetName());
		companyDtl.setLocation(appFormBean.getLocation());
		companyDtl.setPincode(appFormBean.getPinCode());
		companyDtl.setCafId(appFormBean.getCafId());
		companyDtl.setGstAmount(appFormBean.getGstAmount());
		companyDtl.setTotalAmount(appFormBean.getTotalAmount());
		companyDtl.setInsStatusId(1);
		companyDtl.setStatusFlag('E');
		companyDtl.setCeStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		companyDtl.setEeStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		companyDtl.setMcStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		session.save(companyDtl);
		session.beginTransaction().commit();
        return String.valueOf(companyDtl.getAppId());

	}*/
	
	@POST
	@Path("saveApplication")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveApplication(AppFormBean appFormBean) {
		
		
	           /*// Start
					Calendar expireDate = Calendar.getInstance();
					
					expireDate.set(2017, 8, 16);
					
					if (Calendar.getInstance().after(expireDate)) {
					  
					  System.exit(0);
					}
					//End
*/		// gson = new Gson();
		Session session = sessionFactory.openSession();
		CompanyDtl applicationDtls = new CompanyDtl();
		try{
		session.beginTransaction();
		AppDao = new ApplicationDaoImpl();
		
		SmsTemp smstemp = new SmsTemp();
		smstemp.setSmsId(1);

		applicationDtls.setCdoorNo(appFormBean.getCdoorNo());
		applicationDtls.setCplotNo(appFormBean.getCplotNo());
		applicationDtls.setCstreetName(appFormBean.getCstreetName());
		applicationDtls.setClocation(appFormBean.getClocation());
		applicationDtls.setCpinCode(appFormBean.getCpinCode());
		applicationDtls.setIsNewConnection(appFormBean.getIsNewConnection());
		applicationDtls.setLandLineNo(appFormBean.getLandLineNo());

		applicationDtls.setSalutation(appFormBean.getSalutation());
		applicationDtls
				.setContactPersonName(appFormBean.getContactPersonName());

		
		applicationDtls.setEmailAddr(appFormBean.getEmailAddr());

		applicationDtls.setFromWebSite("Industry");
		applicationDtls.setIntrPlumStatus(appFormBean.getIntrPlumStatus());

		applicationDtls.setLegCompName(appFormBean.getLegCompName());
		applicationDtls.setMobileNum(appFormBean.getMobileNum());

		//applicationDtls.setPayDtls(null);
		applicationDtls.setReqMld(appFormBean.getReqMld());
		applicationDtls.setActive(1);
		
		applicationDtls.setUserId(null);
		applicationDtls.setWorkType(appFormBean.getWorkType());
		applicationDtls.setSmsId(smstemp);
		applicationDtls.setCategoryType((MasterCategory) session.get(
				MasterCategory.class, appFormBean.getCategoryType()));
		
		applicationDtls.setCreateTs(new Date());
		applicationDtls.setCreateUserId(appFormBean.getLegCompName());
		applicationDtls.setSurveyFieldNo(appFormBean.getSurveyFieldNo());
		
		applicationDtls.setDistrict( (MasterDistrict) session.get(MasterDistrict.class, Integer.parseInt(appFormBean.getDistrict())));
		if(appFormBean.getTaluk() != null && !appFormBean.getTaluk().equals(""))
		applicationDtls.setTaluk( (MasterTaluk) session.get(MasterTaluk.class, Integer.parseInt(appFormBean.getTaluk())));
		if(appFormBean.getVillage() != null && !appFormBean.getVillage().equals(""))
		applicationDtls.setVillage( (MasterVillage) session.get(MasterVillage.class, Integer.parseInt(appFormBean.getVillage())));
		//applicationDtls.setScheme( (MasterScheme) session.get(MasterScheme.class, Integer.parseInt(appFormBean.getScheme()!=null?appFormBean.getScheme():"0")));
		applicationDtls.setLocalBody(appFormBean.getLocalBody());
		applicationDtls.setAvailability(appFormBean.getAvailability());
		
		applicationDtls.setDoorNo(appFormBean.getDoorNo());
		applicationDtls.setPlotNo(appFormBean.getPlotNo());
		applicationDtls.setStreetName(appFormBean.getStreetName());
		applicationDtls.setLocation(appFormBean.getLocation());
		applicationDtls.setPinCode(appFormBean.getPinCode());
		applicationDtls.setCafId(appFormBean.getCafId());
	//	applicationDtls.setCost(appFormBean.getCost());
		//applicationDtls.setGstPercent(Integer.parseInt(appFormBean.getGstPercent()));
		applicationDtls.setApplicationFee(Integer.parseInt(appFormBean.getCost()));
		applicationDtls.setGstAmount(appFormBean.getGstAmount());
		applicationDtls.setTotalAmount(appFormBean.getTotalAmount());
		applicationDtls.setUpfrontCharges(appFormBean.getUpfrontCharges());
		
		applicationDtls.setInsStatusId(1);
		//applicationDtls.setStatusFlag('E');
		applicationDtls.setStatusFlag('Y');
		applicationDtls.setCeStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		applicationDtls.setEeStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		applicationDtls.setMcStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		session.save(applicationDtls);
		session.beginTransaction().commit();
		
		/*
		Transaction tx =  session.beginTransaction();
		MasterPayment masterPayment = new MasterPayment();
		masterPayment.setAppId((CompanyDtl)session.get(CompanyDtl.class,applicationDtls.getAppId()));
		masterPayment.setPaymentType((MasterPaymentType)session.get(MasterPaymentType.class,2));
		masterPayment.setPaymentAmount(appFormBean.getUpfrontCharges()+"");
		masterPayment.setGstAmount(appFormBean.getUpfrontCharges()+"");
		masterPayment.setGstPercent(10+"");
		masterPayment.setTotalAmount(appFormBean.getUpfrontCharges()+"");
		masterPayment.setStatusFlag('A');
		masterPayment.setUpdateTs(new Date());
		masterPayment.setCreateTs(new Date());
		masterPayment.setUpdateUserId("Administrator");
		masterPayment.setCreateUserId("Administrator");
		session.save(masterPayment);
		tx.commit();
		*/
		
/*
		final Integer smsType = 1;
		final String smsTemp="Thank%20you%20for%20Registering%20Water%20Connection%20Your%20TWAD%20App%20No%20"+applicationDtls.getAppId();
		
		final String application_ID = applicationDtls.getAppId();
		Thread notify = new Thread(new Runnable() {
			@Override
			public void run() {
				SMSBuilder obj = new SMSBuilder();
				obj.getSmsTemplate(application_ID, smsType,smsTemp);
			}
		}, "notify");
		notify.start();*/
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			session.close();
		}
        return String.valueOf(applicationDtls.getAppId());

	}
	
	@POST
	@Path("saveTransactionDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveTransactionDetails(TransactionFormBean transactionFormBean) {
		
		Session session = sessionFactory.openSession();
		TransctionMaster transDtl = new TransctionMaster();
		try{
		session.beginTransaction();
		AppDao = new ApplicationDaoImpl();
		
		transDtl.setAppID((CompanyDtl)session.get(CompanyDtl.class,transactionFormBean.getApplicationId()));
		transDtl.setPaymentType((MasterPaymentType)session.get(MasterPaymentType.class,Integer.parseInt(transactionFormBean.getPaymentType())));
		transDtl.setTotalAmount(transactionFormBean.getTotalAmount());
		transDtl.setTransactionRefNo(transactionFormBean.getTransactionRefNo());
		transDtl.setBankRefNo(transactionFormBean.getBankRefNo());
		transDtl.setStatus(transactionFormBean.getStatus());
		transDtl.setCreateTs(new Date());
		session.saveOrUpdate(transDtl);
		session.beginTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	finally{
		//
		//session.close();
	}
try{
	if(null != transactionFormBean.getBankRefNo() && !transactionFormBean.getBankRefNo().equals("NA") ){
		session.beginTransaction();
		SmsTemp smstemp = new SmsTemp();
		smstemp.setSmsId(1);
        CompanyPaymentDtl companyPaymentDtl = new CompanyPaymentDtl();
        companyPaymentDtl.setAppId((CompanyDtl)session.get(CompanyDtl.class, transactionFormBean.getApplicationId()));
        companyPaymentDtl.setPaymentAmount(transactionFormBean.getTotalAmount());
        companyPaymentDtl.setTransactionRefNo(transactionFormBean.getTransactionRefNo());
        companyPaymentDtl.setBankRefNo(transactionFormBean.getBankRefNo());
        companyPaymentDtl.setPaymentType((MasterPaymentType)session.get(MasterPaymentType.class, Integer.parseInt(transactionFormBean.getPaymentType())));
        
        companyPaymentDtl.setCreateTs(new Date());
        companyPaymentDtl.setUpdateTs(new Date());
        companyPaymentDtl.setCreateUserId(" ");
        companyPaymentDtl.setUpdateUserId(" ");
		

       companyPaymentDtl.setSmsId(smstemp);

		session.save(companyPaymentDtl);
		session.beginTransaction().commit();
		
		CompanyDtl companyDtl = (CompanyDtl)session.get(CompanyDtl.class, transactionFormBean.getApplicationId());
		companyDtl.setPaymentStatus(1);
		session.beginTransaction();
		session.update(companyDtl);
		session.beginTransaction().commit();
	}
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	//session.close();
}	
        return String.valueOf(transDtl.getTransId());

	}
	
	
	@POST
	@Path("updatePaymentDtls")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePaymentDtls(AppFormBean appFormBean) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String amount = "0";
		SmsTemp smstemp = new SmsTemp();
		
		CompanyDtl applicationDtls = (CompanyDtl) session.get(
				CompanyDtl.class, appFormBean.getAppId());
		applicationDtls.setStatusFlag('Y');
		
		/*if(appFormBean.getStatusFlag()=='Y')
		{
			smstemp.setSmsId(1);
			applicationDtls.setSmsId(smstemp);
			applicationDtls.setPaidProcessFee(appFormBean.getPaymentAmount()+"");
		}*/
		/*if(appFormBean.getStatusFlag()=='P')
		{*/
		
			//applicationDtls.setTotalAmount(appFormBean.getInitialPayment());
			applicationDtls.setInsStatusId(4);
			smstemp.setSmsId(5);
			applicationDtls.setSmsId(smstemp);
			applicationDtls.setMcStatus((MasterStatus) session.get(MasterStatus.class, 4));// Payment Paid.
		//}
		
		session.save(applicationDtls);
		session.beginTransaction().commit();
		if(appFormBean.getStatusFlag()=='Y'&& appFormBean.getPaymentType()!=1)
		{
		final Integer smsType = 1;
		//final String smsTemp="Thank%20you%20for%20Registering%20Water%20Connection%20Your%20CMWSSB%20App%20No%20"+appFormBean.getAppId();
		final String smsTemp="Thank%20you%20for%20Payment%20Water%20Connection%20TWAD%20App%20No%20"+appFormBean.getAppId();
		final String application_ID = applicationDtls.getAppId();
		Thread notify = new Thread(new Runnable() {
			@Override
			public void run() {
				SMSBuilder obj = new SMSBuilder();
				obj.getSmsTemplate(application_ID, smsType,smsTemp);
			}
		}, "notify");
		notify.start();
		}
		
		if(appFormBean.getStatusFlag()=='Y'&& appFormBean.getPaymentType()==1)
		{
			final Integer smsType = 1;
			final String smsTemp="Thank%20you%20for%20Registering%20Water%20Connection%20Your%20TWAD%20App%20No%20"+applicationDtls.getAppId();
			
			final String application_ID = applicationDtls.getAppId();
			Thread notify = new Thread(new Runnable() {
				@Override
				public void run() {
					SMSBuilder obj = new SMSBuilder();
					obj.getSmsTemplate(application_ID, smsType,smsTemp);
				}
			}, "notify");
			notify.start();
		}
		if(appFormBean.getStatusFlag()=='P')
		{
		final Integer smsType = 1;
		final String smsTemp="App%20No%20"+appFormBean.getAppId()+"Payment%20Rs%20"+appFormBean.getPaidfinalFee()+"%20Paid%20Successfully";
		final String application_ID = applicationDtls.getAppId();
		Thread notify = new Thread(new Runnable() {
			@Override
			public void run() {
				SMSBuilder obj = new SMSBuilder();
				obj.getSmsTemplate(application_ID, smsType,smsTemp);
			}
		}, "notify");
		notify.start();
		}
		return amount;
		
	}

	@POST
	@Path("getPaymentAmount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getPaymentAmount(AppFormBean appFormBean) {
		AppDao = new ApplicationDaoImpl();
		String amount = "Not Generated";
		Application app = AppDao.getPaymentAmount(appFormBean);
		if(app!=null)
		{
		Integer status = app.getMcStatus().getStatusId();
		Integer threeStatus = 3;
		
		if (appFormBean.getInitialPayment().equalsIgnoreCase("initial")) {
			amount = app.getInitialPayment();
		}
		if (appFormBean.getInitialPayment().equalsIgnoreCase("final")) {

			if (app.getFixedFinalFee() != null && status == threeStatus) {
				amount = String.valueOf(app.getFixedFinalFee());
			}
		}
		}
		return amount;
	}
	@POST
	@Path("getGstAmounts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getGstAmounts(AppFormBean appFormBean) {
		AppDao = new ApplicationDaoImpl();
		String gstAmount = "Not Generated";
		Application app = AppDao.getGstAmounts(appFormBean);
		if(app!=null)
		{
		Integer status = app.getMcStatus().getStatusId();
		Integer threeStatus = 3;
		
		if (appFormBean.getInitialPayment().equalsIgnoreCase("initial")) {
			gstAmount = app.getInitialPayment();
		}
		if (appFormBean.getInitialPayment().equalsIgnoreCase("final")) {

			if (app.getFixedFinalFee() != null && status == threeStatus) {
				gstAmount = String.valueOf(app.getGstAmount());
			}
		}
		}
		return gstAmount;
	}


	@POST
	@Path("withdrawApp")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String withdrawApp(ApplicationBean applicationBean) {
		// gson = new Gson();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		AppDao = new ApplicationDaoImpl();
		Application applicationDtls = (Application) session.get(
				Application.class, applicationBean.getAppId());
		SmsTemp smstemp = new SmsTemp();
		smstemp.setSmsId(1);
		applicationDtls.setStatusFlag('W');
		applicationDtls.setSmsId(smstemp);

		session.save(applicationDtls);
		session.beginTransaction().commit();

		final Integer smsType = 1;
		final String smsTemp="";final String application_ID = applicationDtls.getAppId();
		Thread notify = new Thread(new Runnable() {
			@Override
			public void run() {
				SMSBuilder obj = new SMSBuilder();
				obj.getSmsTemplate(application_ID, smsType,smsTemp);
			}
		}, "notify");
		notify.start();

		return "Application Ref: " + applicationDtls.getAppId() + " Withdrawn";

	}

	@POST
	@Path("savePaymentsDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String savePaymentsDetails(AppFormBean appFormBean) {
		// gson = new Gson();
		Session session = sessionFactory.openSession();
		Application applicationDtls = (Application) session.get(
				Application.class, appFormBean.getAppId());
		try{
		session.beginTransaction();
		AppDao = new ApplicationDaoImpl();
		
		SmsTemp smstemp = new SmsTemp();
		smstemp.setSmsId(1);

		applicationDtls.setDdNum(appFormBean.getDdNum());
		applicationDtls.setDdBankBranch(appFormBean.getDdBranch());
		applicationDtls.setDdBankName(appFormBean.getDdBankName());
		applicationDtls.setDdDate(appFormBean.getDdDate());
		applicationDtls.setPaymentType(appFormBean.getPaymentType());
		if (appFormBean.getPaymentMode().equals("initial")) {
			applicationDtls.setPaidProcessFee(appFormBean
					.getInitialPayment());
		}
		if (appFormBean.getPaymentMode().equals("final")) {
			applicationDtls.setPaidfinalFee(Integer.parseInt(appFormBean
					.getInitialPayment()));
		}

		applicationDtls.setSmsId(smstemp);

		session.save(applicationDtls);
		session.beginTransaction().commit();

		final Integer smsType = 1;
		final String smsTemp="";final String application_ID = applicationDtls.getAppId();
		Thread notify = new Thread(new Runnable() {
			@Override
			public void run() {
				SMSBuilder obj = new SMSBuilder();
				obj.getSmsTemplate(application_ID, smsType,smsTemp);
			}
		}, "notify");
		notify.start();

		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}	
		return String.valueOf(applicationDtls.getAppId());

	}
	
	
	
	
	
	@POST
	@Path("getDDAmount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AppFormBean getDDAmount(AppFormBean appFormBean) {
		
		AppFormBean appFormBeanRes = null;
		Session session = sessionFactory.openSession();
		
		 Criteria crCom = session.createCriteria(CompanyDtl.class,"companyDtl")
					.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()))
		            .add(Restrictions.eq("companyDtl.mobileNum", appFormBean.getMobileNum()));
		 List<CompanyDtl> companyDtllist1 = crCom.list();
		
		 if(!companyDtllist1.isEmpty()){
			 if(companyDtllist1.get(0).getEeStatus().getStatusId()==1 &&  companyDtllist1.get(0).getPaymentStatus()==0)
			   appFormBean.setPaymentType(1);
			 if(companyDtllist1.get(0).getEeStatus().getStatusId()==2 &&  companyDtllist1.get(0).getPaymentStatus()==0)
			   appFormBean.setPaymentType(2);
			 if(companyDtllist1.get(0).getEeStatus().getStatusId()==3 &&  companyDtllist1.get(0).getPaymentStatus()==0)
			   appFormBean.setPaymentType(3);
		 }
		
		
		if(appFormBean.getPaymentType()==1){
			Criteria cr = session.createCriteria(MasterPayment.class,"masterPayment")
					.createCriteria("masterPayment.paymentType","paymentType")
					.add(Restrictions.eq("paymentType.paymentTypeId", 1));
			 List<MasterPayment> masterPaymentlist = cr.list();
			 
			 Criteria cr1 = session.createCriteria(CompanyDtl.class,"companyDtl")
						.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()))
			            .add(Restrictions.eq("companyDtl.mobileNum", appFormBean.getMobileNum()));
			 List<CompanyDtl> companyDtllist = cr1.list();
				 
				  appFormBeanRes = new AppFormBean();
				 if(!masterPaymentlist.isEmpty())
				     appFormBeanRes.setTotalAmount(masterPaymentlist.get(0).getTotalAmount());
				 else{
					 appFormBeanRes.setTotalAmount("NA"); 
				 }
				 if(!companyDtllist.isEmpty())
				     appFormBeanRes.setLegCompName(companyDtllist.get(0).getLegCompName());
				 else{
					 appFormBeanRes.setStatusFlag('N'); 
					 appFormBeanRes.setTotalAmount("NA"); 
				 }
				
				 
		}
		else if(appFormBean.getPaymentType()==2){
			
			

			Criteria cr = session.createCriteria(MasterPayment.class,"masterPayment")
					.createCriteria("masterPayment.paymentType","paymentType")
					.createCriteria("masterPayment.appId","companyDtl")
					.add(Restrictions.eq("paymentType.paymentTypeId",2))
					.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()))
		            .add(Restrictions.eq("companyDtl.mobileNum", appFormBean.getMobileNum()));
			 List<MasterPayment> masterPaymentlist = cr.list();
			
				  appFormBeanRes = new AppFormBean();
				 if(!masterPaymentlist.isEmpty()){
				     appFormBeanRes.setTotalAmount(masterPaymentlist.get(0).getTotalAmount());
				     appFormBeanRes.setLegCompName(masterPaymentlist.get(0).getAppId().getLegCompName());
				 }
				 else{
					 appFormBeanRes.setTotalAmount("NA"); 
				 }
				
				 
				 
		}
		else if(appFormBean.getPaymentType()==3){
			Criteria cr = session.createCriteria(MasterPayment.class,"masterPayment")
					.createCriteria("masterPayment.paymentType","paymentType")
					.createCriteria("masterPayment.appId","companyDtl")
					.add(Restrictions.eq("paymentType.paymentTypeId", appFormBean.getPaymentType()))
					.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()))
		            .add(Restrictions.eq("companyDtl.mobileNum", appFormBean.getMobileNum()));
			 List<MasterPayment> masterPaymentlist = cr.list();
			/* 
			 Criteria cr1 = session.createCriteria(CompanyDtl.class,"companyDtl")
						.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()))
			            .add(Restrictions.eq("companyDtl.mobileNum", appFormBean.getMobileNum()));
			 List<CompanyDtl> companyDtllist = cr1.list();
				 */
				  appFormBeanRes = new AppFormBean();
				 if(!masterPaymentlist.isEmpty()){
				     appFormBeanRes.setTotalAmount(masterPaymentlist.get(0).getTotalAmount());
				     appFormBeanRes.setLegCompName(masterPaymentlist.get(0).getAppId().getLegCompName());
				 }
				 else{
					 appFormBeanRes.setTotalAmount("NA"); 
				 }
				
				 
		}
		appFormBeanRes.setPaymentType(appFormBean.getPaymentType());
        return appFormBeanRes;

	}
	
	
	@POST
	@Path("getOnlinePaymentAmount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AppFormBean getOnlinePaymentAmount(AppFormBean appFormBean) {
		
		AppFormBean  appFormBeanRes = new AppFormBean();
		Session session = sessionFactory.openSession();
		
		 Criteria crCom = session.createCriteria(CompanyDtl.class,"companyDtl")
					.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()));
		 List<CompanyDtl> companyDtllist1 = crCom.list();
		
		 if(!companyDtllist1.isEmpty() && companyDtllist1.get(0).getDivision() != null ){
			 if(companyDtllist1.get(0).getEeStatus().getStatusId()==1 &&  companyDtllist1.get(0).getPaymentStatus()==0)
			   appFormBean.setPaymentType(1);
			 if(companyDtllist1.get(0).getEeStatus().getStatusId()==2 &&  companyDtllist1.get(0).getPaymentStatus()==0)
			   appFormBean.setPaymentType(2);
			 if(companyDtllist1.get(0).getEeStatus().getStatusId()==3 &&  companyDtllist1.get(0).getPaymentStatus()==0)
			   appFormBean.setPaymentType(3);
		 }
		
		
		if(null != appFormBean.getPaymentType() && appFormBean.getPaymentType()==1){
			Criteria cr = session.createCriteria(MasterPayment.class,"masterPayment")
					.createCriteria("masterPayment.paymentType","paymentType")
					.add(Restrictions.eq("paymentType.paymentTypeId", 1));
			 List<MasterPayment> masterPaymentlist = cr.list();
			 
			 Criteria cr1 = session.createCriteria(CompanyDtl.class,"companyDtl")
						.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()));
			 List<CompanyDtl> companyDtllist = cr1.list();
				 
				 
				 if(!masterPaymentlist.isEmpty())
				     appFormBeanRes.setTotalAmount(masterPaymentlist.get(0).getTotalAmount());
				 else{
					 appFormBeanRes.setTotalAmount("NA"); 
				 }
				 if(!companyDtllist.isEmpty())
				     appFormBeanRes.setLegCompName(companyDtllist.get(0).getLegCompName());
				 else{
					 appFormBeanRes.setStatusFlag('N'); 
					 appFormBeanRes.setTotalAmount("NA"); 
				 }
				
				 
		}
		else if(null != appFormBean.getPaymentType() && appFormBean.getPaymentType()==2){
			
			

			Criteria cr = session.createCriteria(MasterPayment.class,"masterPayment")
					.createCriteria("masterPayment.paymentType","paymentType")
					.createCriteria("masterPayment.appId","companyDtl")
					.add(Restrictions.eq("paymentType.paymentTypeId",2))
					.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()));
			 List<MasterPayment> masterPaymentlist = cr.list();
			
				//  appFormBeanRes = new AppFormBean();
				 if(!masterPaymentlist.isEmpty()){
				     appFormBeanRes.setTotalAmount(masterPaymentlist.get(0).getTotalAmount());
				     appFormBeanRes.setLegCompName(masterPaymentlist.get(0).getAppId().getLegCompName());
				 }
				 else{
					 appFormBeanRes.setTotalAmount("NA"); 
				 }
				
				 
				 
		}
		else if(null != appFormBean.getPaymentType() && appFormBean.getPaymentType()==3){
			Criteria cr = session.createCriteria(MasterPayment.class,"masterPayment")
					.createCriteria("masterPayment.paymentType","paymentType")
					.createCriteria("masterPayment.appId","companyDtl")
					.add(Restrictions.eq("paymentType.paymentTypeId", appFormBean.getPaymentType()))
					.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()));
			 List<MasterPayment> masterPaymentlist = cr.list();
			/* 
			 Criteria cr1 = session.createCriteria(CompanyDtl.class,"companyDtl")
						.add(Restrictions.eq("companyDtl.appId", appFormBean.getAppId()))
			            .add(Restrictions.eq("companyDtl.mobileNum", appFormBean.getMobileNum()));
			 List<CompanyDtl> companyDtllist = cr1.list();
				 */
				  //appFormBeanRes = new AppFormBean();
				 if(!masterPaymentlist.isEmpty()){
				     appFormBeanRes.setTotalAmount(masterPaymentlist.get(0).getTotalAmount());
				     appFormBeanRes.setLegCompName(masterPaymentlist.get(0).getAppId().getLegCompName());
				 }
				 else{
					 appFormBeanRes.setTotalAmount("NA"); 
				 }
				
				 
		}
		
		if(null != appFormBean.getPaymentType())
		appFormBeanRes.setPaymentType(appFormBean.getPaymentType());
		
        return appFormBeanRes;

	}
	
	
	@POST
	@Path("saveDDPaymentDtls")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveDDPaymentDtls(DDPaymentFormBean ddPaymentFormBean) {
		Session session = sessionFactory.openSession();
		/*Criteria cr = session.createCriteria(MasterPayment.class,"masterPayment")
				.createCriteria("masterPayment.appId","companyDtl")
				.add(Restrictions.eq("companyDtl.appId", ddPaymentFormBean.getAppId()));
		List<MasterPayment> paymentList = cr.list();
		for(MasterPayment masterPayment : paymentList){
			Transaction tx =  session.beginTransaction();
			masterPayment.setStatusFlag('N');
			session.update(masterPayment);
			tx.commit();
		}
		*/
		
		
		session.beginTransaction();
		SmsTemp smstemp = new SmsTemp();
		smstemp.setSmsId(1);
        CompanyPaymentDtl companyPaymentDtl = new CompanyPaymentDtl();
        companyPaymentDtl.setAppId((CompanyDtl)session.get(CompanyDtl.class, ddPaymentFormBean.getAppId()));
        companyPaymentDtl.setDdBankBranch(ddPaymentFormBean.getDdBankBranch());
        companyPaymentDtl.setDdNo(ddPaymentFormBean.getDdNo());
        companyPaymentDtl.setPaymentAmount(ddPaymentFormBean.getPaymentAmount());
        companyPaymentDtl.setDdBankName(ddPaymentFormBean.getDdBankName());
        companyPaymentDtl.setDdDate(ddPaymentFormBean.getDdDate());
        companyPaymentDtl.setPaymentType((MasterPaymentType)session.get(MasterPaymentType.class, Integer.parseInt(ddPaymentFormBean.getPaymentType())));
        companyPaymentDtl.setLegCompName(ddPaymentFormBean.getLegCompName());
        companyPaymentDtl.setMobileNum(ddPaymentFormBean.getMobileNum());
        
        companyPaymentDtl.setCreateTs(new Date());
        companyPaymentDtl.setUpdateTs(new Date());
        companyPaymentDtl.setCreateUserId(" ");
        companyPaymentDtl.setUpdateUserId(" ");
		

       companyPaymentDtl.setSmsId(smstemp);

		session.save(companyPaymentDtl);
		session.beginTransaction().commit();
		
		CompanyDtl companyDtl = (CompanyDtl)session.get(CompanyDtl.class, ddPaymentFormBean.getAppId());
		companyDtl.setPaymentStatus(1);
		session.beginTransaction();
		session.update(companyDtl);
		session.beginTransaction().commit();

		/*final Integer smsType = 1;
		final String smsTemp="";final String application_ID = ddPaymentFormBean.getAppId();
		Thread notify = new Thread(new Runnable() {
			@Override
			public void run() {
				SMSBuilder obj = new SMSBuilder();
				obj.getSmsTemplate(application_ID, smsType,smsTemp);
			}
		}, "notify");
		notify.start();*/

		return String.valueOf(companyPaymentDtl.getAppId());

	}

	@POST
	@Path("saveOnlinePaymentsDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveOnlinePaymentsDetails(AppFormBean appFormBean)
			throws IOException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		AppDao = new ApplicationDaoImpl();
		Application applicationDtls = (Application) session.get(Application.class, appFormBean.getAppId());
		SmsTemp smstemp = new SmsTemp();
		
   try{
		
		applicationDtls.setPaymentType(appFormBean.getPaymentType());
		if (appFormBean.getPaymentMode().equals("initial")) {
			applicationDtls.setPaidProcessFee(appFormBean
					.getInitialPayment());
			smstemp.setSmsId(1);//onlinesubmission.ftl
		}
		if (appFormBean.getPaymentMode().equals("final")) {
			applicationDtls.setPaidfinalFee(Integer.parseInt(appFormBean
					.getInitialPayment()));
			smstemp.setSmsId(5);//acknowledgementReceipt.ftl
		}
	
		applicationDtls.setInsStatusId(1);
		applicationDtls.setSmsId(smstemp);

		session.save(applicationDtls);
		session.beginTransaction().commit();

   }
	
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		session.close();
	}	

		

		return String.valueOf(applicationDtls.getAppId());

	}

	public static String HmacSHA256(String message, String secret) {
		MessageDigest md = null;
		try {

			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(),
					"HmacSHA256");
			sha256_HMAC.init(secret_key);

			byte raw[] = sha256_HMAC.doFinal(message.getBytes());

			StringBuffer ls_sb = new StringBuffer();
			for (int i = 0; i < raw.length; i++)
				ls_sb.append(char2hex(raw[i]));
			return ls_sb.toString(); // step 6
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String char2hex(byte x)

	{
		char arr[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };

		char c[] = { arr[(x & 0xF0) >> 4], arr[x & 0x0F] };
		return (new String(c));
	}
	
	
	
	@POST
	@Path("callEasyBusiness")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String callEasyBusiness(AppFormBean appFormBean)
			throws IOException {
		return new ApplicationDaoImpl().callEasyBusiness(appFormBean);

	}
	
	@POST
	@Path("getReqMLDCost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getReqMLDCost(AppFormBean appFormBean)
			throws IOException {
		return new ApplicationDaoImpl().getReqMLDCost(appFormBean);

	}
	@POST
	@Path("getGstAmount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getGstAmount(AppFormBean appFormBean)
			throws IOException {
		return new ApplicationDaoImpl().getGstAmount(appFormBean);

	}
	@POST
	@Path("getTotalAmount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getTotalAmount(AppFormBean appFormBean)
			throws IOException {
		return new ApplicationDaoImpl().getTotalAmount(appFormBean);

	}
	
	@POST
	@Path("getApplicationDtls")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getApplicationDtls(AppFormBean appFormBean)
			throws IOException {
		gson = new Gson();
		AppDao = new ApplicationDaoImpl();
		Application applicationDtls = AppDao.getApplicationDtls(appFormBean);

	
		return gson.toJson(applicationDtls);


	}


	


}
