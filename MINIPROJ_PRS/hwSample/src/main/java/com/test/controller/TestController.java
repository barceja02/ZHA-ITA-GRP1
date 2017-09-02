package com.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.Test;

@Controller
public class TestController {
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
