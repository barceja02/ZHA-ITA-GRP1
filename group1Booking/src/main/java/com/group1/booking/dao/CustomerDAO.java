package com.group1.booking.dao;

import java.util.ArrayList;

import com.group1.booking.models.Account;
import com.group1.booking.models.Customer;

public interface CustomerDAO {
	public ArrayList<Customer> searchAllCustomerReturnList();
	public String CreateCustomer(Customer customer,Account account);
	public String UpdateCustomer(Customer customer);
	public String DeleteCustomer(String id);
	public ArrayList<Customer> searchCustomerCriteria(String CompanyName);
	public ArrayList<Customer> searchCustomerCriteria(String id, String CompanyName);
}
