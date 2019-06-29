package com.water.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.water.bean.ComplaintBean;
import com.water.dao.DropDownListDao;
import com.water.model.Documents;
import com.water.model.Login;
import com.water.model.MasterFieldCode;
import com.water.util.HibernateUtil;

/**
 * @author Mahalingam
 * 
 * 
 * 
 *         Created by Mahalingam On 03-June-2017
 * 
 * 
 * 
 */
public class DropDownListDaoImpl implements DropDownListDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public List<MasterFieldCode> listFieldCode(String Key) {

		Session session = sessionFactory.openSession();

		List<MasterFieldCode> fieldCodeList = new ArrayList<MasterFieldCode>();
		try {
			Criteria cr = session.createCriteria(MasterFieldCode.class);

			cr.add(Restrictions.eq("isActive", true));
			cr.add(Restrictions.eq("keyValue", Key));
			cr.addOrder(Order.asc("orderNumber"));
			fieldCodeList = (List<MasterFieldCode>) cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fieldCodeList;
	}

	@Override
	public List<Login> listAssignTo() {

		Session session = sessionFactory.openSession();

		List<Login> listAssignTo = new ArrayList<Login>();
		try {
			Criteria cr = session.createCriteria(Login.class);

			cr.add(Restrictions.eq("isActive", true));
			cr.add(Restrictions.in("roleID", new Integer[] { 2, 8, 9 }));
			listAssignTo = (List<Login>) cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listAssignTo;
	}

	public static void main(String[] args) {
		System.out.println(new DropDownListDaoImpl()
				.listFiles(new ComplaintBean()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ytu.dao.DropDownListDao#listFiles(com.ytu.bean.ComplaintBean)
	 */
	@Override
	public List<Documents> listFiles(ComplaintBean complaintBean) {
		Session session = sessionFactory.openSession();

		List<Documents> documents = new ArrayList<Documents>();
		try {

			Criteria cr = session.createCriteria(Documents.class);
			cr.add(Restrictions.eq("complaintID",
					complaintBean.getComplaintID()));
			documents = (List<Documents>) cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return documents;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.water.dao.DropDownListDao#listSubFieldCode(java.lang.String,
	 * java.lang.Integer)
	 */
	@Override
	public List<MasterFieldCode> listSubFieldCode(String Key, Integer parentID) {
		Session session = sessionFactory.openSession();

		List<MasterFieldCode> fieldCodeList = new ArrayList<MasterFieldCode>();
		try {
			Criteria cr = session.createCriteria(MasterFieldCode.class);

			cr.add(Restrictions.eq("isActive", true));
			if (Key != null && !"".equals(Key))
				cr.add(Restrictions.eq("keyValue", Key));

			if (parentID != null && parentID > 0)
				cr.add(Restrictions.eq("parentID", parentID));

			cr.addOrder(Order.asc("orderNumber"));
			fieldCodeList = (List<MasterFieldCode>) cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fieldCodeList;
	}
}
