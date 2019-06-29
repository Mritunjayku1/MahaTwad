package com.water.daoImpl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.water.bean.AppFormBean;
import com.water.bean.AppRegBean;
import com.water.bean.ComplaintBean;
import com.water.dao.ApplicationDao;
import com.water.model.Application;
import com.water.model.ComplaintDetails;
import com.water.model.MasterCategory;
import com.water.model.MasterDivision;
import com.water.model.MasterReconnection;
import com.water.model.MasterStatus;
import com.water.model.MasterZone;
import com.water.model.ReqMldToCost;
import com.water.model.SmsTemp;
import com.water.util.HibernateUtil;
import com.water.util.Constant;
import com.water.util.SMSBuilder;

public class ApplicationDaoImpl implements ApplicationDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Application appRegister(AppFormBean appFormBean) {

		// gson = new Gson();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Application applicationDtls = new Application();
		try{
		SmsTemp smstemp = new SmsTemp();
		smstemp.setSmsId(1);

		//applicationDtls.setAddrPremSought(appFormBean.getAddrPremSought());
		applicationDtls.setDoorNo(appFormBean.getDoorNo());
		applicationDtls.setPlotNo(appFormBean.getPlotNo());
		applicationDtls.setStreetName(appFormBean.getStreetName());
		applicationDtls.setLocation(appFormBean.getLocation());
		applicationDtls.setPinCode(appFormBean.getPinCode());
		applicationDtls.setAnnAssmtVal(appFormBean.getAnnAssmtVal());
		applicationDtls.setBillNo1(appFormBean.getBillNo1());
		applicationDtls.setBillNo2(appFormBean.getBillNo2());
		
		
		applicationDtls.setCdoorNo(appFormBean.getCdoorNo());
		applicationDtls.setCplotNo(appFormBean.getCplotNo());
		applicationDtls.setCstreetName(appFormBean.getCstreetName());
		applicationDtls.setClocation(appFormBean.getClocation());
		applicationDtls.setCpinCode(appFormBean.getCpinCode());
		applicationDtls.setWebAddress(appFormBean.getWebAddress());
		applicationDtls.setIsNewConnection(appFormBean.getIsNewConnection());
		
			applicationDtls.setLandLineNo(appFormBean.getLandLineNo());
		
		
			if (appFormBean.getDivId() != null && !appFormBean.getDivId().equals("")) {
				applicationDtls.setDivId((MasterDivision) session.get(MasterDivision.class, appFormBean.getDivId()));
			}
		
		
		
		
		
		applicationDtls
				.setContactPersonName(appFormBean.getContactPersonName());
		
		applicationDtls.setDdNum(appFormBean.getDdNum());
		applicationDtls.setEmailAddr(appFormBean.getEmailAddr());
		applicationDtls.setFromWebSite("Industry");
		applicationDtls.setInsStatusId(0);
		applicationDtls.setIntrPlumStatus(appFormBean.getIntrPlumStatus());
		applicationDtls.setIsExistConnectionForAlteration(appFormBean
				.getIsExistConnectionForAlteration());
		applicationDtls.setIsReconnectionForService(appFormBean
				.getIsReconnectionForService());
		applicationDtls.setLegCompName(appFormBean.getLegCompName());
		applicationDtls.setMobileNum(appFormBean.getMobileNum());
		applicationDtls.setPayDtls(null);
		applicationDtls.setPaymentType(appFormBean.getPaymentType());
		applicationDtls.setReqMld(appFormBean.getReqMld());
		applicationDtls.setStatusFlag('Y');
		applicationDtls.setUserId(null);
		applicationDtls.setWatSevProp(appFormBean.getWatSevProp());
		applicationDtls.setWorkType(appFormBean.getWorkType());
		applicationDtls.setSmsId(smstemp);
		applicationDtls.setCategoryType((MasterCategory) session.get(
				MasterCategory.class, appFormBean.getCategoryType()));
		if (appFormBean.getReconnectionType() != null
				&& !appFormBean.getReconnectionType().equals("")) {
			applicationDtls.setReconnectionType((MasterReconnection) session
					.get(MasterReconnection.class,
							appFormBean.getReconnectionType()));
		}
		applicationDtls.setCeStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		applicationDtls.setEeStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		applicationDtls.setMcStatus((MasterStatus) session.get(
				MasterStatus.class, 1));
		if (appFormBean.getCmwssbZoneNum() != null
				&& !appFormBean.getCmwssbZoneNum().equals("")) {
			applicationDtls.setCmwssbZoneNum((MasterZone) session.get(
					MasterZone.class, appFormBean.getCmwssbZoneNum()));
		}
		applicationDtls.setCreateTs(new Date());

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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			session.close();
		}

		return applicationDtls;
	}

	public Application saveApplication(Application application) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(application);
		session.beginTransaction().commit();
		return null;
	}

	@Override
	public Application getPaymentAmount(AppFormBean appFormBean) {

		// TODO Auto-generated method stub

		Application appDetails = new Application();
		Session session = sessionFactory.openSession();
		try {
			Criteria cr = session.createCriteria(Application.class,"app")
			.createCriteria("app.mcStatus","status");
			cr.add(Restrictions.eq("status.statusId", 3))
			/*if(appFormBean.getCmwssbZoneNum() != null &&  !appFormBean.getCmwssbZoneNum().equals(""))
			cr.createCriteria("app.cmwssbZoneNum" , "zone");
			if(appFormBean.getIsReconnectionForService() != null &&  !appFormBean.getIsReconnectionForService().equals("NO"))
			cr.createCriteria("app.reconnectionType","reconnection");*/
			.add(Restrictions.eq("app.appId",appFormBean.getAppId()));
			appDetails = (Application) cr.uniqueResult();
			
			
					

		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.close();
		}
		return appDetails;
	
	}
	@Override
	public Application getGstAmounts(AppFormBean appFormBean) {

		// TODO Auto-generated method stub

		Application appDetails = new Application();
		Session session = sessionFactory.openSession();
		try {
			Criteria cr = session.createCriteria(Application.class,"app")
			.createCriteria("app.mcStatus","status");
			cr.add(Restrictions.eq("status.statusId", 3))
			/*if(appFormBean.getCmwssbZoneNum() != null &&  !appFormBean.getCmwssbZoneNum().equals(""))
			cr.createCriteria("app.cmwssbZoneNum" , "zone");
			if(appFormBean.getIsReconnectionForService() != null &&  !appFormBean.getIsReconnectionForService().equals("NO"))
			cr.createCriteria("app.reconnectionType","reconnection");*/
			.add(Restrictions.eq("app.appId",appFormBean.getAppId()));
			appDetails = (Application) cr.uniqueResult();
			
			
					

		} catch (Exception e) {
			// TODO: handle exception
		}
		return appDetails;
	
	}
	@Override
	public String callEasyBusiness(AppFormBean appFormBean){
		Session session = sessionFactory.openSession();
		Application application = (Application)session.get(Application.class, appFormBean.getAppId());
		String CafID= application.getCafId();
		return CafID;
	}

	@Override
	public String getReqMLDCost(AppFormBean appFormBean) {
		Session session = sessionFactory.openSession();
		ReqMldToCost reqMldToCost =  null;
		
		Criteria cr = session.createCriteria(ReqMldToCost.class,"app")
				
				.add(Restrictions.eq("app.reqmldrange",Integer.parseInt(appFormBean.getReqMld())));
		reqMldToCost = (ReqMldToCost) cr.uniqueResult();
		
		return String.valueOf(reqMldToCost.getReqmldCost());
	}
	@Override
	public String getGstAmount(AppFormBean appFormBean) {
		Session session = sessionFactory.openSession();
		ReqMldToCost reqMldToCost =  null;
		
		Criteria cr = session.createCriteria(ReqMldToCost.class,"app") // GST
				
				.add(Restrictions.eq("app.reqmldrange",Integer.parseInt(appFormBean.getReqMld())));
		reqMldToCost = (ReqMldToCost) cr.uniqueResult();
		int gst =(reqMldToCost.getReqmldCost()*18)/100;
		
		
		return String.valueOf(gst);
	}
	@Override
	public String getTotalAmount(AppFormBean appFormBean) {
		Session session = sessionFactory.openSession();
		ReqMldToCost reqMldToCost =  null;
		
		Criteria cr = session.createCriteria(ReqMldToCost.class,"app") // GST
				
				.add(Restrictions.eq("app.reqmldrange",Integer.parseInt(appFormBean.getReqMld())));
		reqMldToCost = (ReqMldToCost) cr.uniqueResult();
		int reqCost=reqMldToCost.getReqmldCost();
		int gst =(reqMldToCost.getReqmldCost()*18)/100;
		int totalAmount=reqCost+gst;
		
		
		return String.valueOf(totalAmount);
	}

	@Override
	public Application getApplicationDtls(AppFormBean appFormBean) {
		Session session = sessionFactory.openSession();
		Application application = (Application)session.get(Application.class, appFormBean.getAppId());
		return application;
	}

}
