package com.group1.booking.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group1.booking.dao.AccountDAO;
import com.group1.booking.dao.BookingInfoDAO;
import com.group1.booking.dao.CustomerDAO;
import com.group1.booking.impl.AccountDAOImpl;
import com.group1.booking.impl.BookingInfoDAOImpl;
import com.group1.booking.impl.CustomerDAOImpl;
import com.group1.booking.models.Account;
import com.group1.booking.models.BookingInfo;
import com.group1.booking.models.Customer;
import com.group1.booking.returnModels.Login;

public class Services implements IServices {

	//Beaned Ibject
	AccountDAO accountDao;
	CustomerDAO customerDao;
	BookingInfoDAO bookingInfoDAO;
	//Beaned Instanciation for the DAO IMPL to DAO interface
	public void setAccountDAOImpl(AccountDAOImpl accountDAOImpl) {
		this.accountDao = accountDAOImpl;
	}
	public void setCustomerDAOImpl(CustomerDAOImpl customerDAOImpl) {
		this.customerDao = customerDAOImpl;
	}
	public void setBookingInfoDAOImpl(BookingInfoDAOImpl bookingInfoDAOImpl) {
		this.bookingInfoDAO = bookingInfoDAOImpl;
	}
	
	//inversion of Iservice 
	public IServices getAccountServices() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		IServices as = (IServices) appContext.getBean("Services");
		return as;
	}
	
	
	//----------For DOM testing 
	public static void main(String[] args) {
		IServices ias = new Services().getAccountServices();
		
//		Customer customer = new Customer();
//		customer.setAddress("wazzzzzzzzzaaaaaaaa");
//		customer.setCompanyName("wazzaaaa");
//		customer.setContactNumber("+639351534764");
//		customer.setFirstname("Wazzap Mon");
//		customer.setCustomerId(1002);
//		System.err.println("sadfasdfasdfsadf "+ias.UpdateCustomer(customer));
//		
		Customer cust = new Customer();
		Account acct = new Account();
		//cust.setCustomerId(customerId);
		cust.setFirstname("Cristina");
		cust.setLastname("Li");
		cust.setAddress("Adress1");
		cust.setMailAddress("email1");
		cust.setContactNumber("1");
		cust.setRole("CUSTOMER");
		cust.setCompanyName("OOCL");
		
		acct.setUsername("tengkh");
		acct.setPassword("12345");
		acct.setRole("Customer");

		ias.CreateCustomer(cust, acct);
//		ias.CreateAccount(acct);
		
//		//TENGKH: Local testing for login
//		Login login = ias.ToLogin("BITUIGA", "bituiga123");
//		System.out.println("isSuccess: " + login.getIsSucces());
//		System.out.println("Username: " + login.getUsername());
//		System.out.println("UserId: " + login.getUserid());
//		System.out.println("Role: " + login.getRole());
		
		
	}
	
	
	
	
	
	//-----------------ACCOUNT DAO


	public Login ToLogin(String Username, String Password) {
		// TODO Auto-generated method stub
		return accountDao.ToLogin(Username, Password);
	}

	public Account SearchAccountById(String Username) {
		// TODO Auto-generated method stub
		return accountDao.SearchByAccountBy(Username);
	}

	public ArrayList<Account> searchAllAccounts() {
		// TODO Auto-generated method stub
		return accountDao.searchAllAccounts();
	}

	public String CreateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.CreateAccount(account);
	}
	
	//---------------Customer
	public ArrayList<Customer> searchAllCustomerReturnList() {
		// TODO Auto-generated method stub
		
		return customerDao.searchAllCustomerReturnList();
	}
	public String UpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.UpdateCustomer(customer);
	}
	public String DeleteCustomer(String id) {
		// TODO Auto-generated method stub
		return customerDao.DeleteCustomer(id);
	}
	public String CreateCustomer(Customer customer, Account account) {
		// TODO Auto-generated method stub
		return customerDao.CreateCustomer(customer, account);
	}
	public ArrayList<Customer> searchCustomerCriteria(String id, String CompanyName) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomerCriteria(id, CompanyName);
	}
	public ArrayList<Customer> searchCustomerCriteria(String CompanyName) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomerCriteria(CompanyName);
	}

	
	//---------------BookingInfo
	public ArrayList<BookingInfo> searchBookingInfoByCriteria(String bkgNumber, String cntrNumber, String frCity,
			String toCity) {
		// TODO Auto-generated method stub
		return bookingInfoDAO.searchBookingInfoByCriteria(bkgNumber, cntrNumber, frCity, toCity);
	}
	public String insertBooking(BookingInfo booking) {
		// TODO Auto-generated method stub
		return bookingInfoDAO.insertBooking(booking);
	}
	public String updateBooking(BookingInfo booking) {
		// TODO Auto-generated method stub
		return bookingInfoDAO.updateBooking(booking);
	}
	public String deactivateBooking(ArrayList<String> bookingNumbers) {
		// TODO Auto-generated method stub
		return bookingInfoDAO.deactivateBooking(bookingNumbers);
	}

}
