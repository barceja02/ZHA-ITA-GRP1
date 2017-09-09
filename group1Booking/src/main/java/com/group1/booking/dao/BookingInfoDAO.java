package com.group1.booking.dao;

import java.util.ArrayList;

import com.group1.booking.models.BookingInfo;

public interface BookingInfoDAO {
	
	public ArrayList<BookingInfo> searchBookingInfoByCriteria(String bkgNumber, String cntrNumber, String frCity,
			String toCity);
	public String insertBooking(BookingInfo booking);
	public String updateBooking(BookingInfo booking);
	public String deactivateBooking(ArrayList<String> bookingNumbers);

}
