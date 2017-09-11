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
	
	@RequestMapping(value = "/searchAccounts", method = RequestMethod.POST)
	public @ResponseBody String searchAccounts(@RequestBody String params)
			throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Account> acct = new ArrayList<Account>();
		acct.add(serv.SearchAccountById(params.replace("\"", "")));
		return jsonMapper.writeValueAsString(acct);
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public @ResponseBody String createAccount(@RequestBody String params)
			throws JsonParseException, JsonMappingException, IOException {
		Account account = jsonMapper.readValue(params, Account.class);
		return serv.CreateAccount(account);
	}
	
	@RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
	public @ResponseBody String updateAccount(@RequestBody String params)
			throws JsonParseException, JsonMappingException, IOException {
		Account account = jsonMapper.readValue(params, Account.class);
		return serv.UpdateAccountBy(account);
	}
	
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
	public @ResponseBody String deleteAccount(@RequestBody String params)
			throws JsonParseException, JsonMappingException, IOException {
		Account account = jsonMapper.readValue(params, Account.class);
		String accountId = String.valueOf(account.getAcctID());
		return serv.DeleteAccountBy(accountId);
	}

	@RequestMapping(value = "/homeSearch", method = RequestMethod.POST)
	public @ResponseBody String bookingSearch(@RequestBody String params) throws JsonProcessingException, IOException {
		JsonNode rootNode = new ObjectMapper().readTree(new StringReader(params)); // convert to readable note
		// rootNode.get("parameter") returns the value of the parameter
		String bookingNo = rootNode.get("bookingNo").toString().replace("\"", "");
		String containerNo = rootNode.get("containerNo").toString().replace("\"", "");
		String frmCity = rootNode.get("frmCity").toString().replace("\"", "");
		String toCity = rootNode.get("toCity").toString().replace("\"", "");
		return jsonMapper.writeValueAsString(serv.searchBookingInfoByCriteria(bookingNo, containerNo, frmCity,toCity ));
	}

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public @ResponseBody String createCustomer(@RequestBody String param)
			throws JsonParseException, JsonMappingException, IOException {
		CustomerAccountModel CA = jsonMapper.readValue(param, CustomerAccountModel.class);
		Customer customer = new Customer();
		Account account = new Account();
		customer.setCompanyName(CA.getCompanyName());
		customer.setAddress(CA.getAddress());
		customer.setContactNumber(CA.getContactNumber());
		customer.setFirstname(CA.getFirstname());
		customer.setLastname(CA.getLastname());
		customer.setMailAddress(CA.getMailAddress());
		customer.setRole(CA.getRole());
		customer.setIsActive(CA.getIsActive());
		account.setUsername(CA.getUsername());
		account.setPassword(CA.getPassword());
		account.setRole(CA.getRole());
		return jsonMapper.writeValueAsString(serv.CreateCustomer(customer, account));
	}
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public @ResponseBody String updateCustomer(@RequestBody String param) throws JsonParseException, JsonMappingException, IOException {
		CustomerAccountModel CA = jsonMapper.readValue(param, CustomerAccountModel.class);
		Customer customer = new Customer();
//		Account account = new Account();
		customer.setCompanyName(CA.getCompanyName());
		customer.setAddress(CA.getAddress());
		customer.setContactNumber(CA.getContactNumber());
		customer.setFirstname(CA.getFirstname());
		customer.setLastname(CA.getLastname());
		customer.setMailAddress(CA.getMailAddress());
		customer.setRole(CA.getRole());
		customer.setCustomerId(CA.getCustomerId());
//		account.setUsername(CA.getUsername());
//		account.setPassword(CA.getPassword());
//		account.setRole(CA.getRole());
		
		return jsonMapper.writeValueAsString(serv.UpdateCustomer(customer));
	}
	
	@RequestMapping(value = "/searchCustomerByCriteria", method = RequestMethod.POST)
	public @ResponseBody String searchCustomerByCriteria(@RequestBody String param)
			throws JsonParseException, JsonMappingException, IOException {
		JsonNode rootNode = new ObjectMapper().readTree(new StringReader(param)); // convert to readable note
		// rootNode.get("parameter") returns the value of the parameter
		String companyName = rootNode.get("companyName").toString().replace("\"", "");
		String address = rootNode.get("address").toString().replace("\"", "");
		return jsonMapper.writeValueAsString(serv.searchCustomerByCriteria(companyName, address));
	}
}
