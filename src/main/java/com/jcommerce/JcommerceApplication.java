package com.jcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
        //(scanBasePackages = "com.jcommerce")
public class JcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JcommerceApplication.class, args);
	}
}
