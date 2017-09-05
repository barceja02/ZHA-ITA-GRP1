package com.group1.booking.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.internal.SessionEventListenerManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.group1.booking.configurations.HibernateContext;
import com.group1.booking.dao.AccountDAO;
import com.group1.booking.models.Account;



public class AccountDAOImpl implements AccountDAO {
	
	SessionFactory sessionFactory;
	//Setter for HibernateSession-> Customize BeanSession since Autowired seems fucked up and shit

	public void setHibernateSession(HibernateContext hibernateSession) {
		sessionFactory = hibernateSession.GetSessionFactory();
	}
	

	public String CreateAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Account Account = null;
		System.err.println(account.getPassword());
		try {
			tx = session.beginTransaction();
			Account = (Account)session.save(account);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("tangina");
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(Account.getAcctID());
		return "test";
		
//		return "accountCreated";
	}

	public String Login(String Username, String Password) {
		// TODO Auto-generated method stub

		return "wazzza";
	}

	public void UpdateAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	public Account SearchByAccountBy(String ACCT_ID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Account account = null;
		try {
			tx = session.beginTransaction();
			List Account = session.createQuery("FROM Account WHERE acctID = '" + ACCT_ID+"'").list();
			for (Iterator iterator = Account.iterator(); iterator.hasNext();) {
				account = (Account) iterator.next();
				System.err.print("AcctID" + account.getAcctID());
				System.out.print("  UserId" + account.getUserID());
				System.out.print("  Username" + account.getUsername());
				System.out.print("  Password" + account.getPassword());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return account;
	}

	public ArrayList<Account> searchAllAccounts() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		ArrayList<Account> account = null;
		List query;
		try {
			tx = session.beginTransaction();
			 query =  session.createQuery("FROM Account").list();
			 account = (ArrayList<Account>) query;
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return account;
	}
	
	
	
	
}
