package com.group1.booking.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group1.booking.configurations.HibernateContext;
import com.group1.booking.dao.BookingInfoDAO;
import com.group1.booking.models.Account;
import com.group1.booking.models.BookingInfo;

public class BookingInfoDAOImpl implements BookingInfoDAO {
	SessionFactory sessionFactory;

	public void setHibernateSession(HibernateContext hibernateSession) {
		sessionFactory = hibernateSession.GetSessionFactory();
	}

	public ArrayList<BookingInfo> searchBookingInfoByCriteria(String bkgNumber, String cntrNumber, String frCity,
			String toCity) {
		ArrayList<BookingInfo> bookings;
		Session session = null;
		try {
			bookings = new ArrayList<BookingInfo>();

			session = sessionFactory.openSession();

			session.beginTransaction();

			String sql = "FROM BookingInfo WHERE ";

			if (!"".equals(bkgNumber)) {
				sql += " BOOKING_NUM = " + bkgNumber + " AND";
			}
			if (!"".equals(cntrNumber)) {
				sql += " CONTAINER_NUM = '" + cntrNumber + "' AND";
			}
			if (!"".equals(toCity)) {
				sql += " TO_CITY = '" + toCity + "' AND";
			}
			if (!"".equals(frCity)) {
				sql += " FROM_CITY = '" + frCity + "' AND";
			}
			sql += " 1=1";

			List BookingInfo = session.createQuery(sql).list();

			for (Object object : BookingInfo) {
				bookings.add((BookingInfo) object);
			}
		} catch (HibernateException e) {
			return null;
		} finally {
			session.close();
		}

		return bookings;

	}

	public String insertBooking(BookingInfo booking) {

		Session session = sessionFactory.openSession();

		String bkgNumber = "Failed";
		try {
			session.beginTransaction();

			bkgNumber = session.save(booking).toString();

			session.getTransaction().commit();
		} catch (Exception e) {
			return "Failed";
		} finally {
			session.close();
		}

		return bkgNumber;

	}

	public String updateBooking(BookingInfo booking) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();

			session.beginTransaction();
			String sql = "FROM BookingInfo WHERE BOOKING_NUM = " + booking.getBookingNum();

			List BookingInfo = session.createQuery(sql).list();

			BookingInfo oldBooking = (BookingInfo) BookingInfo.iterator().next();

			oldBooking.setBooking(booking);

			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			return "Fail";
		} finally {
			session.close();
		}
		return "Success";

	}

	public String deactivateBooking(ArrayList<String> bookingNumbers) {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			BookingInfo booking;
			session.beginTransaction();
			String sql = "FROM BookingInfo WHERE BOOKING_NUM in ( ";

			for (String string : bookingNumbers) {
				sql += "'" + string + "',";
			}
			sql = sql.substring(0, sql.length() - 1);
			sql += ")";

			List BookingInfo = session.createQuery(sql).list();

			for (Iterator iterator = BookingInfo.iterator(); iterator.hasNext();) {
				booking = (BookingInfo) iterator.next();
				booking.setIsActive(0);
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			return "Fail";
		}

		return "Success";
	}

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		BookingInfoDAOImpl dao = (BookingInfoDAOImpl) appContext.getBean("BookingInfoDAOImpl");
		BookingInfo booking = new BookingInfo();
		// ArrayList<BookingInfo> bookings =
		// dao.searchBookingInfoByCriteria("201700023", "", "", "");
		// for (BookingInfo bookingInfo : bookings) {
		// booking = bookingInfo;
		// }
		// System.err.println(dao.insertBooking(booking));
		// booking.setCargoNature("DG");
		// booking.setContainerNumber("PUTA090817");
		// booking.setNetUnit("lbs");
		// booking.setGrossUnit("lbs");
		//
		// System.err.println(dao.updateBooking(booking));

		ArrayList<String> str = new ArrayList<String>();

		str.add("201700020");
		str.add("201700025");
		str.add("201700023");

		System.err.println(dao.deactivateBooking(str));
	}

}
