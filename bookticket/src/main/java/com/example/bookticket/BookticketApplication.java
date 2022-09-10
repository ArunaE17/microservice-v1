package com.example.bookticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class BookticketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookticketApplication.class, args);
	}

}
