package com.dailyjava.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class QuoteReaderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuoteReaderService.class);

	private final WebClient webClient;
	private final ReactiveCircuitBreaker circuitBreaker;
	

	public QuoteReaderService(ReactiveCircuitBreakerFactory circuitBreakerFactory ) {
		this.webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
		this.circuitBreaker = circuitBreakerFactory.create("/quotes/api");
	}
	
	public Mono<String> readQuote(){
		
		long startTime = System.currentTimeMillis();
		
		Mono<String> quote = circuitBreaker.run(webClient.get().uri("/quotes/api").retrieve().bodyToMono(String.class), throwable -> {
			LOGGER.warn("Error Making request to Quote Reader service", throwable);
			return Mono.just("No Quotes today !!! :( ");
		});
		
		long endTime = System.currentTimeMillis();
		
		LOGGER.info("Total time to retrieve results = {}",
				endTime - startTime);
		
		return quote;
	}
}
