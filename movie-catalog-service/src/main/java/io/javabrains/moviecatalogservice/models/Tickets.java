package io.javabrains.moviecatalogservice.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Tickets {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    public String callTickets(){
        CircuitBreaker cb = circuitBreakerFactory.create("testbreaker");
      return cb.run(() ->restTemplate.getForObject("http://localhost:8084/booktickets",String.class), throwable -> fallbackservice());
        //String name = restTemplate.getForObject("https://localhost:8084/booktickets",String.class);
        //return name;



    }
    public String fallbackservice(){
        return "fall back ticket Try after some time";
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
