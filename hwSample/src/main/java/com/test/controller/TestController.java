package com.test.controller;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.Test;

@Controller
public class TestController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model)
	{
		ModelAndView modelAndView = new ModelAndView("/js/sample/sample.html");
		return modelAndView;
	}
	
	@RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<Test> createTest(@RequestBody Test test) {

		if(test != null) {
			System.out.println(test.getTestId());
			System.out.println(test.getTestValue());
		}

		return new ResponseEntity<Test>(test, HttpStatus.OK);
	}
}
