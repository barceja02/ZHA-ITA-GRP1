package com.group1.booking.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.group1.booking.configurations.HibernateContext;
import com.group1.booking.dao.LocationDAO;
import com.group1.booking.models.Location;

public class LocationDAOImpl implements LocationDAO {

	SessionFactory sessionFactory;
	public String sqlQuery;

	public void setHibernateSession(HibernateContext hibernateSession) {
		sessionFactory = hibernateSession.GetSessionFactory();
	}
	
	public Location getLocationByCityCode(String cityCode) {
		Location location = null;
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		
		try {
			tx = session.beginTransaction();
			sqlQuery = "FROM Location WHERE LOC_CITY_NAME LIKE = '" + cityCode + "%'";
			List Location = session.createQuery(sqlQuery).list();
			
			for (Iterator iterator = Location.iterator(); iterator.hasNext();) {
				location = (Location) iterator.next();
			}
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			session.close();
		}
		return location;
	}
	
	public String createLocation(Location location) {
		Transaction tx = null;
		String result = null;
		Session session = sessionFactory.openSession();
		return result;
	}
	
	public String updateLocation(Location location) {
		Transaction tx = null;
		String result = null;
		Session session = sessionFactory.openSession();
		return result;
	}
	
	
	
	
}
