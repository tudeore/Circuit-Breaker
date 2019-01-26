package com.cb.helloweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private CircuitBreaker breaker;

	@RequestMapping("/hi")
	public String getMessage() {
		return breaker.readingList();
	}
	
}
