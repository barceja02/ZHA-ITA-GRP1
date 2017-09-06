package com.group1.booking.impl;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group1.booking.configurations.HibernateContext;

public class BookingInfoDAOImpl {
	SessionFactory sessionFactory;
	//Setter for HibernateSession-> Customize BeanSession since Autowired seems fucked up and shit

	public void setHibernateSession(HibernateContext hibernateSession) {
		sessionFactory = hibernateSession.GetSessionFactory();
	}
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		BookingInfoDAOImpl dao = (BookingInfoDAOImpl) appContext.getBean("BookingInfoDAOImpl");
		dao.test();
	}
	public void test() {
		System.out.println(sessionFactory);
	}

}
