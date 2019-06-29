package com.water.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;

import sun.security.ssl.Debug;

import com.water.bean.ChangePasswordBean;
import com.water.bean.ForgotPasswordBean;
import com.water.bean.LoginBean;
import com.water.dao.LoginDao;
import com.water.model.EmployeeDetails;
import com.water.model.Login;
import com.water.util.HibernateUtil;
import com.water.util.SMSBuilder;


public class LoginDaoImpl implements LoginDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public String forgotPassword(ForgotPasswordBean forgotPasswordBean) {
		Session session = sessionFactory.openSession();
		try {

			Criteria cr = session.createCriteria(EmployeeDetails.class);

			cr.add(Restrictions.eq("loginUserName",
					forgotPasswordBean.getUserName())).add(
					Restrictions.eq("emailAddr",
							forgotPasswordBean.getUserEmailId()));
			cr.add(Restrictions.eq("statusFlag", 'Y'));

			EmployeeDetails employeeDetails = (EmployeeDetails) cr
					.uniqueResult();
			final String userPassword = employeeDetails.getLoginPassword();
			final String userEmailId = forgotPasswordBean.getUserEmailId();
			if (userPassword != null && !userPassword.equals("")) {

				// Please implement Email Part here, userPassword variable
				// having correct Password

				final String EmailTemp = "your recentlty requested to forgetpassword to your Tamilnadu corporation water servervices,Your Password is : ";
				Thread notify = new Thread(new Runnable() {
					@Override
					public void run() {
						SMSBuilder obj = new SMSBuilder();
						// obj.getSmsTemplate(application_ID,smsType,smsTemp);
						obj.getForgotEmailTempate(userEmailId, userPassword,
								EmailTemp);

					}
				}, "notify");
				notify.start();
				session.close();

				return "Password sent to your emailId";
			}

		} catch (Exception e) {
			return "Please enter correct username and emailid";
		}
		finally{
			session.close();
		}
		return "";
	}

	@Override
	public String managementChangePassword(ChangePasswordBean changePasswordBean) {
		Session session = sessionFactory.openSession();
		try {

			Criteria cr = session.createCriteria(EmployeeDetails.class);

			cr.add(Restrictions.eq("loginUserName",
					changePasswordBean.getUserName()))
					.add(Restrictions.eq("emailAddr",
							changePasswordBean.getUserEmailId()))
					.add(Restrictions.eq("loginPassword",
							changePasswordBean.getOldPassword()));
			cr.add(Restrictions.eq("statusFlag", 'Y'));

			EmployeeDetails employeeDetails = (EmployeeDetails) cr
					.uniqueResult();
			String userPassword = employeeDetails.getLoginPassword();
			// final String userPassword1 = employeeDetails.getLoginPassword();
			final String userEmailId = changePasswordBean.getUserEmailId();
			final String newPassword = changePasswordBean.getNewPassword();

			if (userPassword != null && !userPassword.equals("")) {

				Transaction tx = session.beginTransaction();

				employeeDetails.setLoginPassword(changePasswordBean
						.getNewPassword());

				employeeDetails.setUpdateTs(new Date());
				session.update(employeeDetails);
				tx.commit();

				final String EmailTemp = "your recentlty requested to your Tamilnadu corporation water servervices,Your Password is : ";
				Thread notify = new Thread(new Runnable() {
					@Override
					public void run() {
						SMSBuilder obj = new SMSBuilder();
						// obj.getSmsTemplate(application_ID,smsType,smsTemp);
						obj.getForgotEmailTempate(userEmailId, newPassword,
								EmailTemp);

					}
				}, "notify");
				notify.start();
				session.close();

				// Please implement Email Part here, userPassword variable
				// having correct Password

				return "Password changed successfully and Email sent to your emailId";
			}

		} catch (Exception e) {
			return "Please enter correct emailid and old Password";
		}
		finally{
			session.close();
		}
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ytu.dao.LoginDao#authenticateUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public EmployeeDetails authenticateUser(LoginBean loginBean) {

		Session session = sessionFactory.openSession();
		EmployeeDetails loginList = null;
		try {

			Criteria cr = session.createCriteria(EmployeeDetails.class);

			/*
			 * //Start Calendar expireDate = Calendar.getInstance(); //ymd
			 * expireDate.set(2017, 8, 16);
			 * 
			 * if (Calendar.getInstance().after(expireDate)) {
			 * 
			 * System.exit(0); } //End
			 */

			if (loginBean.getAccessTypeID() != null
					&& loginBean.getLoginName() != null
					&& loginBean.getLoginPassword() != null) {

				List<Integer> accessType = new ArrayList<Integer>();

				accessType.add(2);

				cr.add(Restrictions.eq("loginUserName",
						loginBean.getLoginName())).add(
						Restrictions.eq("loginPassword",
								loginBean.getLoginPassword()));

			}
			cr.add(Restrictions.eq("statusFlag", 'Y'));

			loginList = (EmployeeDetails) cr.uniqueResult();

		} catch (Exception e) {
			Debug.println("Solution: Please check the Login characters", "");
			e.printStackTrace();
		} finally {
			// session.close();
		}
		return loginList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ytu.dao.LoginDao#changePassword(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean changePassword(String userID, String oldPassword,
			String newPassword, String accessId) {
		Session session = sessionFactory.openSession();

		Login loginList = null;
		boolean isChanged = false;

		try {
			if (accessId.equals("2")) {
				Criteria cr = session.createCriteria(Login.class);

				cr.add(Restrictions.eq("loginName", userID))
						.add(Restrictions
								.sqlRestriction(
										"loginPassword = ? collate Latin1_General_CS_AS_KS_WS",
										oldPassword, new StringType()));

				cr.setMaxResults(1);
				loginList = (Login) cr.uniqueResult();
			} else if (accessId.equals("1")) {
				Criteria cr = session.createCriteria(Login.class);

				cr.add(Restrictions.eq("loginName", userID))
						.add(Restrictions
								.sqlRestriction(
										"loginPassword = ? collate Latin1_General_CS_AS_KS_WS",
										oldPassword, new StringType()));

				cr.setMaxResults(1);
				loginList = (Login) cr.uniqueResult();
			}
			session.beginTransaction();

			if (loginList != null) {
				loginList.setLoginPassword(newPassword);
				loginList.setModifiedDate(new java.util.Date());
				session.update(loginList);
				session.beginTransaction().commit();
				isChanged = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			isChanged = false;
		} finally {
			session.close();
		}
		return isChanged;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ytu.dao.LoginDao#forgetPassword(java.lang.String)
	 */
	@Override
	public String forgetPassword(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
