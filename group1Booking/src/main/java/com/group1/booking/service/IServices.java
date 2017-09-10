package com.group1.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.group1.booking.models.Account;
import com.group1.booking.models.BookingInfo;
import com.group1.booking.models.Customer;
import com.group1.booking.models.Location;
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
	
	public String UpdateAccountBy(Account account);
	
	public String DeleteAccountBy(String accountId);
	
	
	//-----------------CustomerDAO-------------

	public ArrayList<Customer> searchAllCustomerReturnList();
	public String CreateCustomer(Customer customer,Account account);
	public String UpdateCustomer(Customer customer);
	public String DeleteCustomer(String id);
	public ArrayList<Customer> searchCustomerByCriteria(String CompanyName,String Address);
	
	//-----------------BookinfInfoDAO-------------
	public ArrayList<BookingInfo> searchBookingInfoByCriteria(String bkgNumber, String cntrNumber, String frCity,
			String toCity);
	public String insertBooking(BookingInfo booking);
	public String updateBooking(BookingInfo booking);
	public String deactivateBooking(ArrayList<String> bookingNumbers);
	
	//---------------LocationDAO
	public Location getLocationByCityCode(String cityCode);
	public String createLocation(Location location);
	public String updateLocation(Location location);
	public ArrayList<Location> getAllLocation();
}
