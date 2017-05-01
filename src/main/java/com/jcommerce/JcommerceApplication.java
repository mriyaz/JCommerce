package com.jcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jcommerce.backend.persistence.repositories")
public class JcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JcommerceApplication.class, args);
	}
}
