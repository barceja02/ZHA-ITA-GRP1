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
import com.group1.booking.returnModels.Login;

public class AccountDAOImpl implements AccountDAO {

	SessionFactory sessionFactory;
	public String sqlQuery;

	public void setHibernateSession(HibernateContext hibernateSession) {
		sessionFactory = hibernateSession.GetSessionFactory();
	}

	// TENGKH 20170905: Login Transaction
	public Login ToLogin(String Username, String Password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Account account = null;
		Login login = new Login();
		try {
			tx = session.beginTransaction();
			sqlQuery = "FROM Account WHERE USERNAME = '" + Username + "' AND PASSWORD = '" + Password + "'";
			List Account = session.createQuery(sqlQuery).list();
			if (!Account.isEmpty()) {

				for (Iterator iterator = Account.iterator(); iterator.hasNext();) {
					account = (Account) iterator.next();
				}

				if (Username.equals(account.getUsername()) && Password.equals(account.getPassword())) {
					login.setIsSucces("true");
					login.setCustid(account.getCustID());
					login.setAccountId(String.valueOf(account.getAcctID()));
					login.setRole(account.getRole());
					login.setUsername(account.getUsername());

				}
			} else {
				login.setIsSucces("false");
			}

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return login;
	}

	// TENGKH 20170906: to search by username for Admin CRUD
	public Account SearchByAccountBy(String Username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Account account = null;
		try {
			tx = session.beginTransaction();
			sqlQuery = "FROM Account WHERE USERNAME = '" + Username + "'";
			List Account = session.createQuery(sqlQuery).list();
			for (Iterator iterator = Account.iterator(); iterator.hasNext();) {
				account = (Account) iterator.next();
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

	// TENGKH: to create an account
	// NOTE: before creating an account, customer must first be created in the
	// CUSTOMER_DETAILS table
	public String CreateAccount(Account account) {
		// TODO Auto-generated method stub
		String isSuccess;
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Account Account = account;
		System.err.println(account.getPassword());
		try {
			tx = session.beginTransaction();
			//Account = (Account) session.save(account);
			session.save(Account);
			session.flush();
			tx.commit();
			isSuccess = "true";
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			isSuccess = "false";
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(Account.getAcctID());
		return isSuccess;

	}

	public void UpdateAccount(Account account) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Account> searchAllAccounts() {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		ArrayList<Account> account = null;
		List query;
		try {
			tx = session.beginTransaction();
			query = session.createQuery("FROM Account").list();
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
