package com.example.bookservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Tag(name="Foo Bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {

    private final Logger logger = LoggerFactory.getLogger(FooBarController.class);
    @GetMapping("/foo-bar")
    @Operation(summary = "Foo bar.")
//    @Retry(name="default",fallbackMethod = "falbackMethod")
//    @CircuitBreaker(name="default",fallbackMethod = "falbackMethod")
//    @RateLimiter(name = "default")
    @Bulkhead(name="default")
    public String fooBar(){
        logger.info("request to foo bar received");
//        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar",String.class);
        return "foo-bar";
//        return response.getBody();
    }

    public String falbackMethod(Exception ex){
        return "fall back Method";
    }
}
