package com.group1.booking.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.group1.booking.configurations.HibernateContext;
import com.group1.booking.dao.CustomerDAO;
import com.group1.booking.models.Account;
import com.group1.booking.models.Customer;
import com.group1.booking.returnModels.CustomerReturnModel;

public class CustomerDAOImpl implements CustomerDAO {
	HibernateContext hibernateContext;
	SessionFactory sessionFactory;

	// SessionFactory Bean Spring
	public void setHibernateSession(HibernateContext hibernateSession) {
		hibernateContext = hibernateSession;
		sessionFactory = hibernateSession.GetSessionFactory();
	}

	// ALLARRA09_08_17: SearchAllcUSTOMER and return List of customer
	@SuppressWarnings("unchecked")
	public ArrayList<CustomerReturnModel> searchAllCustomerReturnList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Customer> tempHold = null;
		try {
			tx = session.beginTransaction();
			tempHold = (List<Customer>) session.createQuery("FROM Customer").list();
			session.flush();
			tx.commit();
		} catch (HibernateException x) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		ArrayList<CustomerReturnModel> crmList = new ArrayList<CustomerReturnModel>();
		for(int z=0; z<tempHold.size();z++) {
			CustomerReturnModel crm = new CustomerReturnModel();
			crm.setID(String.valueOf(tempHold.get(z).getCustomerId()));
			crm.setCompanyName(tempHold.get(z).getCompanyName());
			crmList.add(crm);
		}

		return crmList;
	}

	// ALLARRA: CreateCustomer transaction
	public String CreateCustomer(Customer customer, Account account) {
		// TODO Auto-generated method stub
		String isCreated = "false";
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Customer customerReturn = customer;
		try {
			tx = session.beginTransaction();
			customerReturn.setCustomerId((Integer) session.save(customer));
			session.flush();

			AccountDAOImpl accountDAO = new AccountDAOImpl();
			accountDAO.setHibernateSession(hibernateContext);
			account.setCustID(String.valueOf(customerReturn.getCustomerId()));
			account.setRole(customer.getRole());
			isCreated = (accountDAO.CreateAccount(account).toString());
			if (isCreated.equals("false")) {
				throw new HibernateException("failed to create Account initiating customer rollback");
			}
			isCreated = "true";
			tx.commit();
		} catch (HibernateException x) {
			if (tx != null)
				isCreated = "false";
			tx.rollback();
		} finally {
			session.close();
		}

		System.out.println("ACCOUNT IS CREATED: " + isCreated);
		return isCreated;
	}

	// ALLARRA UpdateCustomer
	public String UpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean isSuccess = false;

		System.err.println("testUpdate");
		try {
			tx = session.beginTransaction();
			Customer updateCustomer = (Customer) session.get(Customer.class, customer.getCustomerId());
			updateCustomer.setCompanyName(customer.getCompanyName() == null || customer.getCompanyName() == ""
					? updateCustomer.getCompanyName()
					: customer.getCompanyName());
			updateCustomer.setLastname(
					customer.getLastname() == null || customer.getLastname() == "" ? updateCustomer.getLastname()
							: customer.getLastname());
			updateCustomer.setFirstname(
					customer.getFirstname() == null || customer.getFirstname() == "" ? updateCustomer.getFirstname()
							: customer.getFirstname());
			updateCustomer.setRole(customer.getRole() == null || customer.getRole() == "" ? updateCustomer.getRole()
					: customer.getRole());
			updateCustomer.setAddress(
					customer.getAddress() == null || customer.getAddress() == "" ? updateCustomer.getAddress()
							: customer.getAddress());
			updateCustomer.setContactNumber(customer.getContactNumber() == null || customer.getContactNumber() == ""
					? updateCustomer.getContactNumber()
					: customer.getContactNumber());
			updateCustomer.setMailAddress(customer.getMailAddress() == null || customer.getMailAddress() == ""
					? updateCustomer.getMailAddress()
					: customer.getMailAddress());
			session.update(updateCustomer);
			session.flush();
			tx.commit();
			isSuccess = true;
		} catch (HibernateException x) {
			if (tx != null) {
				tx.rollback();
				isSuccess = false;
				x.printStackTrace();
			}
		} finally {
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
		} catch (HibernateException x) {
			if (tx != null) {
				tx.rollback();
				isSuccess = false;
				x.printStackTrace();
			}
		} finally {
			session.close();
		}
		return String.valueOf(isSuccess);

	}

	// ALLARRA: Search Customer by criteria CompanyName
	@SuppressWarnings("unchecked")
	public ArrayList<Customer> searchCustomerByCriteria(String CompanyName, String Address) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Customer> tempHold = null;
		try {
			tx = session.beginTransaction();
			String query = ("FROM Customer WHERE ");
			query += !CompanyName.equals("") && !CompanyName.equals("null") && !CompanyName.equals(null)? "companyName LIKE :companyName " : "";
			query += query.contains("companyName")?"AND ":"";
			query += !Address.equals("") && !Address.equals("null") && !Address.equals(null)? "address LIKE :address " : "";
					

			Query test = session.createQuery(query);								
				test.setParameter("companyName", "%"+CompanyName+"%");						
				test.setParameter("address","%"+ Address+ "%");
			tempHold = (List<Customer>) test.list();
			session.flush();
			tx.commit();
		} catch (HibernateException x) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return (ArrayList<Customer>) tempHold;
	}
}