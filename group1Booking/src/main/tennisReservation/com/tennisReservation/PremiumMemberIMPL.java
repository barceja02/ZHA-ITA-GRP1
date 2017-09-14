package com.tennisReservation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.group1.booking.configurations.HibernateContext;
import com.group1.booking.impl.AccountDAOImpl;
import com.group1.booking.models.Account;
import com.group1.booking.models.Customer;

public class PremiumMemberIMPL {
	HibernateContext HC = new HibernateContext();
	Session session;

	public Session setHibernateOpenSession() {
		return HC.GetSessionFactory().openSession();
	}
	
//	public void main(String[] args) {
//		session = setHibernateOpenSession();
//		session.close();
//	}
	
	public ArrayList<PremiumMember> getAllPremiumMember() {
		ArrayList<PremiumMember> alM = null;
		
		Session session = setHibernateOpenSession();
		Transaction tx = null;
		List<PremiumMember> tempHold = null;
		try {
			tx = session.beginTransaction();
			tempHold = (List<PremiumMember>) session.createQuery("FROM PremiumMember").list();
			session.flush();
			tx.commit();
		} catch (HibernateException x) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		alM = (ArrayList<PremiumMember>) tempHold;
		
		return alM;	
	}
	
	public String CreatePremiumMember(PremiumMember premiumMember) {
		// TODO Auto-generated method stub
		String isCreated = "false";
		Session session = setHibernateOpenSession();
		Transaction tx = null;
		PremiumMember pMember = premiumMember;
		try {
			tx = session.beginTransaction();
			pMember.setMemberId((Integer) session.save(premiumMember));
			
			session.flush();
			isCreated = "true";
			tx.commit();
		} catch (HibernateException x) {
			if (tx != null)
				isCreated = "false";
			tx.rollback();
		} finally {
			session.close();
		}

		System.out.println("PREMIUM MEMBER CREATED: " + isCreated);
		return isCreated;
	}
	
	
	
}
