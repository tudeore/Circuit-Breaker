package com.cb.helloweb.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CircuitBreaker {

	@Autowired
	public RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		URI uri = URI.create("http://localhost:8181/hello");

		return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		return "good Afternoon";
	}

}
