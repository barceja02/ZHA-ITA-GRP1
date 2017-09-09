package com.group1.booking.impl;

import java.util.ArrayList;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.group1.booking.configurations.HibernateContext;
import com.group1.booking.dao.CustomerDAO;
import com.group1.booking.models.Account;
import com.group1.booking.models.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	SessionFactory sessionFactory;

	public void setHibernateSession(HibernateContext hibernateSession) {
		sessionFactory = hibernateSession.GetSessionFactory();
	}

	public ArrayList<Customer> searchAllReturnList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String CreateCustomer(Customer customer, Account account) {
		// TODO Auto-generated method stub
		String isCreated;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Customer customerReturn= customer;
		try {
			tx = session.beginTransaction();
			//customerReturn = (Customer) session.save(customer);
			session.save(customer);
			session.flush();
			tx.commit();
		}catch(HibernateException x) {
			if(tx != null)
				isCreated = "false";
				tx.rollback();
		}finally{
			session.close();
		}
		
		/*accountDAO.setHibernateSession(new HibernateContext());*/
		account.setCustID((String.valueOf(customerReturn.getCustomerId())));
		account.setRole(customer.getRole());
		AccountDAOImpl accountDAO = new AccountDAOImpl();
		isCreated = (accountDAO.CreateAccount(account).toString());
		System.out.println("ACCOUNT IS CREATED: " + isCreated);
		
		//return String.valueOf(customerReturn.getCustomerId() + " : " + isCreated );
		return isCreated;
	}

	public String UpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean isSuccess = false;

		System.err.println("testUpdate");
		try {
			tx = session.beginTransaction();
			Customer updateCustomer = (Customer) session.get(Customer.class, customer.getCustomerId());
			updateCustomer.setFirstname(customer.getFirstname()==null||customer.getFirstname()==""?updateCustomer.getFirstname():customer.getFirstname());
			session.update(updateCustomer);
			session.flush();
			tx.commit();
			isSuccess = true;
		}catch(HibernateException x) {
			if(tx != null) {
				tx.rollback();
				isSuccess = false;
				x.printStackTrace();
			}
		}finally{
			session.close();
		}
		return String.valueOf(isSuccess);
	}

	
	public String DeleteCustomer(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean isSuccess = false;
		try {
			tx = session.beginTransaction();
			Customer deleteCustomer = (Customer) session.get(Customer.class, Integer.valueOf(id));
			deleteCustomer.setIsActive(0);
			session.update(deleteCustomer);
			tx.commit();
			isSuccess = true;
		}catch(HibernateException x) {
			if(tx != null) {
				tx.rollback();
				isSuccess = false;
				x.printStackTrace();
			}			
		}finally{
			session.close();
		}
		return String.valueOf(isSuccess);
		
	}
	
	public Customer searchCriteria(String id, String CompanyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
