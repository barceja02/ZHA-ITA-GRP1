package com.group1.booking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

//import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController {
	ObjectMapper jsonMapper = new ObjectMapper();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) { 
		ModelAndView modelAndView = new ModelAndView("/js/booking/booking.html");
		return modelAndView;
	}

	/*
	 * return as json if returned value is object. if only one line of string return
	 * use string
	 */
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody String post(@RequestBody String test)
			throws JsonParseException, JsonMappingException, IOException {
		return "hello";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody String test)
			throws JsonParseException, JsonMappingException, IOException {
			
		return "{isSuccess: \"true\",role: \"csv\",userId: 123,username: \"nonie\"}";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody String getAccounts() throws JsonParseException, JsonMappingException, IOException {
//		return jsonMapper.writeValueAsString(accounts);
		return "hello";
	}
}
