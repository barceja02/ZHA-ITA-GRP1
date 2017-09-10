package com.group1.booking.dao;

import java.util.ArrayList;

import com.group1.booking.models.Account;
import com.group1.booking.models.Customer;
import com.group1.booking.returnModels.CustomerReturnModel;

public interface CustomerDAO {
	public ArrayList<CustomerReturnModel> searchAllCustomerReturnList();
	public String CreateCustomer(Customer customer,Account account);
	public String UpdateCustomer(Customer customer);
	public String DeleteCustomer(String id);
	public ArrayList<Customer> searchCustomerByCriteria(String CompanyName, String Address);
}
