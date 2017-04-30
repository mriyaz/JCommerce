package com.jcommerce.config;

import com.jcommerce.backend.service.EmailService;
import com.jcommerce.backend.service.MockEmailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;

/**
 * Created by Riyazuddin M on 4/30/2017.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/.jcommerce/application-dev.properties")
public class DevelopmentConfig {
    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
