package com.test;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestTransactions {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		TestTransactions transaction = new TestTransactions();

		System.out.println(transaction.addValue("Hello"));
	}

	/* Method to CREATE an employee in the database */
	public Integer addValue(String testValue) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer testId = null;
		try {
			tx = session.beginTransaction();
			Test testData = new Test();
			testData.setTestValue(testValue);
			testId = (Integer) session.save(testData);
			// employeeID = 0;
			session.save(testData);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return testId;
	}

	/* Method to READ all the employees */
//	public void listEmployees() {
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			List employees = session.createQuery("FROM Employee WHERE first_name = 'Nonie'").list();
//			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
//				Test employee = (Test) iterator.next();
//				System.out.print("First Name: " + employee.getFirstName());
//				System.out.print("  Last Name: " + employee.getLastName());
//				System.out.println("  Salary: " + employee.getSalary());
//			}
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}

	/* Method to UPDATE salary for an employee */
//	public void updateEmployee(Integer EmployeeID, int salary) {
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Test employee = (Test) session.get(Test.class, EmployeeID);
//			employee.setSalary(salary);
//			session.update(employee);
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Test employee = (Test) session.get(Test.class, EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}