package com.group1.booking.dao;

import java.util.ArrayList;

import com.group1.booking.models.Account;
import com.group1.booking.models.Customer;

public interface CustomerDAO {
	public ArrayList<Customer> searchAllReturnList();
	public String CreateCustomer(Customer customer,Account account);
	public String UpdateCustomer(Customer customer);
	public String DeleteCustomer(String id);
	public Customer searchCriteria(String id, String CompanyName);
}
