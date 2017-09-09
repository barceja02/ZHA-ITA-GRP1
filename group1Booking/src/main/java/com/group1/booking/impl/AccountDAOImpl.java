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

	public String sqlQuery;

	HibernateContext hibernateContext;
	SessionFactory sessionFactory;

	public void setHibernateSession(HibernateContext hibernateSession) {
		hibernateContext = hibernateSession;
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
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Account Account = account;
		try {
			tx = session.beginTransaction();
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

		return isSuccess;

	}

	public String UpdateAccountBy(Account account) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			sqlQuery = "FROM Account WHERE ACCT_ID = " + account.getAcctID();
			List AccountInfo = session.createQuery(sqlQuery).list();
			Account OldAccount = (Account) AccountInfo.iterator().next();
			OldAccount.setAccount(account);
			tx = session.getTransaction();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();
		}

		String x = "sds";
		return x;

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

	public String DeleteAccountBy(String accountId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Account account = null;
		sqlQuery = "FROM Account WHERE ACCT_ID = " + accountId;
		try {
			tx = session.beginTransaction();
			List Account = session.createQuery(sqlQuery).list();
			for (Iterator iterator = Account.iterator(); iterator.hasNext();) {
				account = (Account) iterator.next();
			}
			session.delete(account);
			tx = session.getTransaction();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		String x = "sds";
		return x;

	}

}
