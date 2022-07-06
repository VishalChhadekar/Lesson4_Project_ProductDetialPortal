package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Product;

public class HibernateUtil {

	static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
//	
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		configuration.addAnnotatedClass(Product.class);

		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;

	}

}
