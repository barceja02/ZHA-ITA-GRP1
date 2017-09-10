package com.group1.booking.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Locale;

import org.codehaus.jackson.JsonNode;

//import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group1.booking.models.BookingInfo;
import com.group1.booking.service.*;

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
		JsonNode rootNode = new ObjectMapper().readTree(new StringReader(params)); //convert to readable note
		//rootNode.get("parameter") returns the value of the parameter
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
}
