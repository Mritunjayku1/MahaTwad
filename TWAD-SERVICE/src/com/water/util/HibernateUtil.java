package com.water.util;

import java.util.ResourceBundle;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	private static final SessionFactory oraclesessionFactory;
	

	static {
		try {
			ResourceBundle rb1 = ResourceBundle.getBundle("resources/constant");
			
			String hibernateCFGUser = rb1.getString("hibernateCFGUser");
			if(hibernateCFGUser.equals("jay")){
				sessionFactory = new AnnotationConfiguration().configure("jay-hibernate.cfg.xml")
						.buildSessionFactory();
			}
			else if(hibernateCFGUser.equals("maha")){
				sessionFactory = new AnnotationConfiguration().configure("maha-hibernate.cfg.xml")
						.buildSessionFactory();
			}
			if(hibernateCFGUser.equals("prod")){
				sessionFactory = new AnnotationConfiguration().configure("prod-hibernate.cfg.xml")
						.buildSessionFactory();
			}
			
			/*sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml")
					.buildSessionFactory();*/
			
			oraclesessionFactory = new AnnotationConfiguration().configure("hibernateoracle.cfg.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static SessionFactory getOraclesessionfactory() {
		return oraclesessionFactory;
	}
}
