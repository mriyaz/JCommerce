package com.jcommerce.config;

import com.jcommerce.backend.service.EmailService;
import com.jcommerce.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;

/**
 * Created by Riyazuddin M on 4/30/2017.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.jcommerce/application-dev.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}
