package com.group1.booking.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;

import org.codehaus.jackson.JsonNode;

//import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group1.booking.models.Account;
import com.group1.booking.models.Customer;
import com.group1.booking.returnModels.CustomerAccountModel;
import com.group1.booking.service.*;
import com.group1.booking.models.BookingInfo;

@Controller
public class BookingController {
	ObjectMapper jsonMapper = new ObjectMapper();
	Services service = new Services();
	IServices serv = service.getAccountServices();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("/js/booking/booking.html");
		return modelAndView;
	}

	/*
	 * return as json if returned value is object. if only one line of string return
	 * use string
	 */

	@RequestMapping(value = "/createBkg", method = RequestMethod.POST)
	public @ResponseBody String createBkg(@RequestBody String params)
			throws JsonParseException, JsonMappingException, IOException {
		BookingInfo booking = jsonMapper.readValue(params, BookingInfo.class);
		String response = serv.insertBooking(booking);
		return response;
	}
	
	@RequestMapping(value = "/editBkg", method = RequestMethod.POST)
	public @ResponseBody String editBkg(@RequestBody String params)
			throws JsonParseException, JsonMappingException, IOException {
		BookingInfo booking = jsonMapper.readValue(params, BookingInfo.class);
		String response = serv.updateBooking(booking);
		return response;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody String params)
			throws JsonParseException, JsonMappingException, IOException {
		JsonNode rootNode = new ObjectMapper().readTree(new StringReader(params)); // convert to readable note
		// rootNode.get("parameter") returns the value of the parameter
		String username = rootNode.get("username").toString().replace("\"", "");
		String password = rootNode.get("password").toString().replace("\"", "");
		return jsonMapper.writeValueAsString(serv.ToLogin(username, password));
	}

	@RequestMapping(value = "/getParty", method = RequestMethod.GET)
	public @ResponseBody String getParty() throws JsonParseException, JsonMappingException, IOException {
		return jsonMapper.writeValueAsString(serv.searchAllCustomerReturnList());
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody String getAccounts() throws JsonParseException, JsonMappingException, IOException {
		// return jsonMapper.writeValueAsString(accounts);
		return "hello";
	}

	@RequestMapping(value = "/homeSearch", method = RequestMethod.POST)
	public @ResponseBody String bookingSearch(@RequestBody String params) throws JsonProcessingException, IOException {
		JsonNode rootNode = new ObjectMapper().readTree(new StringReader(params)); // convert to readable note
		// rootNode.get("parameter") returns the value of the parameter
		String username = rootNode.get("bookingNo").toString().replace("\"", "");
		String password = rootNode.get("containerNo").toString().replace("\"", "");
		System.err.println(serv.searchBookingInfoByCriteria("201700000", "", "", "").size());
		System.out.println(jsonMapper.writeValueAsString(serv.searchBookingInfoByCriteria("201700000", "", "", "")));
		return jsonMapper.writeValueAsString(serv.searchBookingInfoByCriteria("", "", "", "LGB"));
	}

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public @ResponseBody String createCustomer(@RequestBody String param)
			throws JsonParseException, JsonMappingException, IOException {
		CustomerAccountModel CA = jsonMapper.readValue(param, CustomerAccountModel.class);
		Customer customer = new Customer();
		Account account = new Account();
		customer.setCompanyName(CA.getCompanyName());
		customer.setAddress(CA.getAddress());
		customer.setContactNumber(CA.getAddress());
		customer.setFirstname(CA.getFirstname());
		customer.setLastname(CA.getLastname());
		customer.setMailAddress(CA.getMailAddress());
		customer.setRole(CA.getRole());
		account.setUsername(CA.getUsername());
		account.setPassword(CA.getPassword());
		account.setRole(CA.getRole());

		serv.CreateCustomer(customer, account);

		return jsonMapper.writeValueAsString(serv.CreateCustomer(customer, account));
	}
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public @ResponseBody String updateCustomer(@RequestBody String param) throws JsonParseException, JsonMappingException, IOException {
		CustomerAccountModel CA = jsonMapper.readValue(param, CustomerAccountModel.class);
		Customer customer = new Customer();
//		Account account = new Account();
		customer.setCompanyName(CA.getCompanyName());
		customer.setAddress(CA.getAddress());
		customer.setContactNumber(CA.getAddress());
		customer.setFirstname(CA.getFirstname());
		customer.setLastname(CA.getLastname());
		customer.setMailAddress(CA.getMailAddress());
		customer.setRole(CA.getRole());
//		account.setUsername(CA.getUsername());
//		account.setPassword(CA.getPassword());
//		account.setRole(CA.getRole());
		
		return jsonMapper.writeValueAsString(serv.UpdateCustomer(customer));
	}
}
