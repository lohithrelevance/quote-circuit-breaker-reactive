package com.dailyjava.config;

import java.time.Duration;

import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;

/*
 * @Configuration public class QuoteCircuitBreakerConfig {
 * 
 * public CircuitBreaker countCircuitBreaker() {
 * 
 * CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
 * .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED).
 * slidingWindowSize(10) .slowCallRateThreshold(50)
 * .slowCallDurationThreshold(Duration.ofSeconds(5)) .build();
 * 
 * CircuitBreakerRegistry circuitBreakerRegistry =
 * CircuitBreakerRegistry.of(circuitBreakerConfig);
 * 
 * CircuitBreaker cBreaker =
 * circuitBreakerRegistry.circuitBreaker("quoteReaderBasedOnCount");
 * 
 * return cBreaker; } }
 */