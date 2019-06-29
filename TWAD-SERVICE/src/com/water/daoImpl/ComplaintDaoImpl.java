package com.water.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.water.bean.ComplaintBean;
import com.water.bean.DocumentBean;
import com.water.dao.ComplaintDao;
import com.water.model.ComplaintDetails;
import com.water.model.Documents;
import com.water.model.MasterFieldCode;
import com.water.util.Common;
import com.water.util.Constant;
import com.water.util.HibernateUtil;
import com.water.util.SMSBuilder;
import com.google.gson.Gson;

/**
 * @author Mahalingam
 * 
 * 
 * 
 *         Created by Mahalingam (Freelancer) On 02-June-2017
 * 
 * 
 * 
 */
public class ComplaintDaoImpl implements ComplaintDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ytu.dao.ComplaintDao#registerCompliant(com.ytu.bean.ComplaintBean)
	 */
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ytu.dao.ComplaintDao#getCompliantDtls(com.ytu.bean.ComplaintBean)
	 */
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ytu.dao.ComplaintDao#listCompliant(com.ytu.bean.ComplaintBean)
	 */
	

	public List<Object[]> listEscalatedComplaints() {
		Session session = sessionFactory.openSession();
		StringBuffer sqlQreyString = new StringBuffer();

		List<Object[]> listcompliants = new ArrayList<Object[]>();
		sqlQreyString.append(Constant.FieldOfficer_Escalation_Select);
		SQLQuery query = session.createSQLQuery(sqlQreyString.toString());
		// query.setParameter("complaintID", compliantId);
		listcompliants = query.list();
		return listcompliants;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.water.dao.ComplaintDao#uploadDocumentInfo(com.water.bean.ComplaintBean)
	 */
	@Override
	public ComplaintDetails updateDocumentInfo(ComplaintBean complaintBean) {

		Session session = sessionFactory.openSession();
		try {

			session.beginTransaction();

			Documents documents = new Documents();
			documents.setComplaintID(complaintBean.getComplaintID());
			documents.setDocumentPath(complaintBean.getAttachementPath());
			documents.setDocumentOwner(complaintBean.getAttachementOwner());
			documents.setIsActive(true);
			documents.setCreatedDate(new java.util.Date());

			session.save(documents);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Object[]> getPublicDashboardCount(ComplaintBean complaintBean) {

		Session session = sessionFactory.openSession();
		StringBuffer sqlQreyString = new StringBuffer();

		List<Object[]> publicDashBoardCount = new ArrayList<Object[]>();
		sqlQreyString.append(Constant.Get_publicdashboardCount);

		if (complaintBean.getAccessTypeID() != null
				&& complaintBean.getAccessTypeID() == 2) {
			sqlQreyString
					.append("  AND ComplaintStatus=7 and PublicCanView=1  ");
		}
		if (complaintBean.getCompliantClosedDate() != null
				&& !"".equals(complaintBean.getCompliantClosedDate())) {

			sqlQreyString
					.append(" AND convert(date,ComplaintRejectCloseTime)='"
							+ Common.convertDateFormat(complaintBean
									.getCompliantClosedDate()) + "'");

			System.out.println(Common.convertDateFormat(complaintBean
					.getCompliantClosedDate()));
		}
		sqlQreyString.append(Constant.Get_publicdashboardCount_1);

		SQLQuery query = session.createSQLQuery(sqlQreyString.toString());

		publicDashBoardCount = query.list();
		return publicDashBoardCount;

	}

	@Override
	public List<Object[]> getDashboardCount() {
		// TODO Auto-generated method stub
		return null;
	}
}
