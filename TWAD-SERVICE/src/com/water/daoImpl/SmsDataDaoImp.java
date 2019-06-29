package com.water.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;

import com.water.bean.SmsDatas;
import com.water.bean.SmsBean;
import com.water.dao.SmsDatadao;
import com.water.model.Application;
import com.water.model.CompanyDtl;
import com.water.model.EmployeeDetails;
import com.water.model.TblSMSDatas;
import com.water.util.Constant;
import com.water.util.HibernateUtil;

public class SmsDataDaoImp implements SmsDatadao {

	SessionFactory sessionfact = HibernateUtil.getSessionFactory();

	@Override
	public String smsData(String sender, String message) {

		System.out.println("Tracing " + sender + "message:" + message);
		TblSMSDatas tblsmsdata = new TblSMSDatas();
		Session session = sessionfact.openSession();
		Criteria crit = session.createCriteria(TblSMSDatas.class);
		tblsmsdata.setsMSSenterNumber(sender);
		tblsmsdata.setsMSContent(message);
		// tblsmsdata.setCreatedDate(date.getDate());
		tblsmsdata.setEmailID("maha@gmail.com");
		session.save(tblsmsdata);
		session.beginTransaction().commit();

		// TODO Auto-generated method stub

		return "Message Sent Successfully";
	}

	@Override
	public SmsDatas receiveSMs(String sender, String message) {
		// TODO Auto-generated method stub
		TblSMSDatas tblsmsdata = new TblSMSDatas();
		SmsDatas smsdata = new SmsDatas();
		Session session = sessionfact.openSession();
		Criteria crit = session.createCriteria(TblSMSDatas.class);
		tblsmsdata.setsMSSenterNumber(sender);
		tblsmsdata.setsMSContent(message);
		// tblsmsdata.setCreatedDate(date.getDate());
		tblsmsdata.setEmailID("maha@gmail.com");
		session.save(tblsmsdata);
		session.beginTransaction().commit();
		
		smsdata.setsMSSenterNumber(tblsmsdata.getsMSSenterNumber());
		smsdata.setsMSContent(tblsmsdata.getsMSContent());
		System.out.println("Number in Service :" + smsdata.getsMSSenterNumber()
				+ "  Message  : " + smsdata.getsMSContent());

		return smsdata;
	}

	@Override
	public List<CompanyDtl> getTemplateID(String applicationId, Integer smsType) {
		Session session = sessionfact.openSession();
		List<CompanyDtl> SmsTemplate = new ArrayList<CompanyDtl>();
		Criteria cr = session.createCriteria(CompanyDtl.class);
		cr.add(Restrictions.eq("appId", applicationId));
		SmsTemplate = cr.list();
		return SmsTemplate;
	}
	/*@Override
	public List<EmployeeDetails> getTemplateIDtoEE(String applicationId, Integer smsType) {
		Session session = sessionfact.openSession();
		int  officeId=2;
		List<EmployeeDetails> SmsTemplate = new ArrayList<EmployeeDetails>();
		
		Criteria companyCriteria = session.createCriteria(EmployeeDetails.class,"e1")
		.createCriteria("e1.userDivision","eo1");
		//.createCriteria(CompanyDtl.class,"c1")
		//.createCriteria("c1.office","co1");
		companyCriteria.add(Restrictions.eq("eo1.divisionId",officeId));
		//companyCriteria.add(Restrictions.eq("appId", applicationId));
		
		ProjectionList properties = Projections.projectionList();
		properties.add(Projections.property("emailAddr"));
		properties.add(Projections.property("phoneNum"));
		companyCriteria.setProjection(properties);
		SmsTemplate=companyCriteria.list();
		
		
		Criteria cr = session.createCriteria(EmployeeDetails.class);
		cr.add(Restrictions.eq("appId", applicationId));
		SmsTemplate = cr.list();
		return SmsTemplate;
	}*/
	@Override
	public List<EmployeeDetails> getTemplateIDtoEE(String applicationId, Integer smsType) {
		Session session = sessionfact.openSession();
		int  officeId=2;
		List<EmployeeDetails> SmsTemplate = new ArrayList<EmployeeDetails>();
		try{
		Criteria companyCr = session.createCriteria(CompanyDtl.class,"e2")
				.add(Restrictions.eq("e2.appId", applicationId));
		List<CompanyDtl> companyDtlList =   companyCr.list();
		
		
		Criteria companyCriteria = session.createCriteria(EmployeeDetails.class,"e1")
		.createCriteria("e1.userDivision","eo1")
		//.createCriteria(CompanyDtl.class,"c1")
		//.createCriteria("c1.office","co1");
		.add(Restrictions.eq("eo1.divisionId",companyDtlList.get(0).getDivision().getDivisionId()));
		//companyCriteria.add(Restrictions.eq("appId", applicationId));
		
		/*ProjectionList properties = Projections.projectionList();
		properties.add(Projections.property("emailAddr"));
		properties.add(Projections.property("phoneNum"));
		companyCriteria.setProjection(properties);*/
		SmsTemplate=(List<EmployeeDetails>)companyCriteria.list();
		
		
		/*Criteria cr = session.createCriteria(EmployeeDetails.class);
		cr.add(Restrictions.eq("appId", applicationId));
		SmsTemplate = cr.list();*/
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally{
		session.close();
	}	
		return SmsTemplate;
	}
	
	
}
