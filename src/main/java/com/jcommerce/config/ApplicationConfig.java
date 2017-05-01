package com.jcommerce.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Riyazuddin M on 5/1/2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.jcommerce.backend.persistence.repositories")
@EntityScan(basePackages = "com.jcommerce.backend.persistence.domain.backend")
@EnableTransactionManagement
public class ApplicationConfig {
}
