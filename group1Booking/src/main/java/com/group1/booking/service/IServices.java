package com.group1.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.group1.booking.models.Account;
import com.group1.booking.models.BookingInfo;
import com.group1.booking.models.Customer;
import com.group1.booking.returnModels.Login;;

public interface IServices {
	/*Please Add division if a new interface will be added on IServices Interface
	 * this part Consolidate all Interfaces around the DOM to act as a controller
	 * for UI part*/
	//-----------AccountDAO --------------
	public Login ToLogin(String Username, String Password);

	public Account SearchAccountById(String Username);

	public ArrayList<Account> searchAllAccounts();

	public String CreateAccount(Account account);
	
	
	//-----------------CustomerDAO-------------
	public ArrayList<Customer> searchAllReturnList();
	public String CreateCustomer(Customer customer,Account account);
	public String UpdateCustomer(Customer customer);
	public String DeleteCustomer(String id);
	public Customer searchCriteria(String id, String CompanyName);
	
	//-----------------BookinfInfoDAO-------------
	public ArrayList<BookingInfo> searchBookingInfoByCriteria(String bkgNumber, String cntrNumber, String frCity,
			String toCity);
	public String insertBooking(BookingInfo booking);
	public String updateBooking(BookingInfo booking);
	public String deactivateBooking(ArrayList<String> bookingNumbers);
}
