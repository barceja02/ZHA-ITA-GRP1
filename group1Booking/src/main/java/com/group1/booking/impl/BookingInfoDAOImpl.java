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

			if (bkgNumber.length() > 10) {
				sql += " BOOKING_NUM in ( ";

				String bookingNumbers[] = bkgNumber.split(",");

				for (int i = 0; i < bookingNumbers.length; i++) {
					if (bookingNumbers[i].length() != 10) {
						return null;
					} else {
						sql+= "'" + bookingNumbers[i] + "',";
					}
				}
				sql+= sql.substring(0, sql.length()-1);

			} else {

				if (!"".equals(bkgNumber)) {
					sql += " BOOKING_NUM = " + bkgNumber + " AND";
				}
				if (!"".equals(cntrNumber)) {
					sql += " CONTAINER_NUM = '" + cntrNumber + "' AND";
				}
				if (!"".equals(toCity) && toCity != null && !toCity.equals("null")) {
					sql += " TO_CITY = '" + toCity + "' AND";
				}
				if (!"".equals(frCity) && toCity != null && !frCity.equals("null")) {
					sql += " FROM_CITY = '" + frCity + "' AND";
				}
				sql += " IS_ACTIVE=1";
			}
			List BookingInfo = session.createQuery(sql).list();

			for (Object object : BookingInfo) {
				bookings.add((BookingInfo) object);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		return bookings;

	}

	public boolean isBookingValid(BookingInfo booking) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			String sql = "FROM BookingInfo WHERE CONTAINER_NUM = '" + booking.getContainerNumber() + "' AND IS_ACTIVE = 1";

			List BookingInfo = session.createQuery(sql).list();
			if (BookingInfo.isEmpty()) {
				return true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	public String insertBooking(BookingInfo booking) {

		if (!isBookingValid(booking)) {
			return "Container is already Used";
		}

		Session session = sessionFactory.openSession();

		String bkgNumber = "";
		booking.setIsActive(1);
		
		if (booking.getIsCustomerGood() == 1 && booking.getisDocumentApproved() == 1 && booking.getIsWeightValid() == 1) {
			booking.setIsConfirmed(1);			
		} else {
			booking.setIsConfirmed(0);
		}
		

		try {
			session.beginTransaction();

			bkgNumber = session.save(booking).toString();

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
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
			if (oldBooking.getIsCustomerGood() == 1 && oldBooking.getisDocumentApproved() == 1 && oldBooking.getIsWeightValid() == 1) {
				oldBooking.setIsConfirmed(1);			
			} else {
				oldBooking.setIsConfirmed(0);
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
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
			e.printStackTrace();
			return "Fail";
		}

		return "Success";
	}

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		BookingInfoDAOImpl dao = (BookingInfoDAOImpl) appContext.getBean("BookingInfoDAOImpl");
		BookingInfo booking = new BookingInfo();
		ArrayList<BookingInfo> bookings = dao.searchBookingInfoByCriteria("201700023", "", "", "");
		for (BookingInfo bookingInfo : bookings) {
			System.err.println(bookingInfo);
		}

		// System.err.println(dao.insertBooking(booking));
		// booking.setCargoNature("DG");
		// booking.setContainerNumber("PUTA090817");
		// booking.setNetUnit("lbs");
		// booking.setGrossUnit("lbs");
		//
		// System.err.println(dao.updateBooking(booking));
		//
		// ArrayList<String> str = new ArrayList<String>();
		//
		// str.add("201700020");
		// str.add("201700025");
		// str.add("201700023");
		//
		// System.err.println(dao.deactivateBooking(str));
	}

}
