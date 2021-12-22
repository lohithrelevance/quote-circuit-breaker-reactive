package com.dailyjava.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailyjava.service.QuoteReaderService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quote")
public class QuoteReaderController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuoteReaderController.class);

	@Autowired
	private QuoteReaderService quoteService;

	@GetMapping(value = "/read")
	public Mono<String> readQuote() {
		
		 LOGGER.info("Going to start calling the REST service with Circuit Breaker");
		
		 return quoteService.readQuote();
	}
	
	
	public Mono<String> quoteFallback(Exception e){
		return Mono.just("No quotes today!!! :(");
	}
	

	
	
	
}
