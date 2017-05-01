package com.jcommerce.config;

import com.jcommerce.backend.service.EmailService;
import com.jcommerce.backend.service.MockEmailService;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Riyazuddin M on 4/30/2017.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/.jcommerce/application-dev.properties")
public class DevelopmentConfig {
    @Bean
    public EmailService emailService() {

        return new MockEmailService();
    }

    @Bean
    public ServletRegistrationBean h2ConsoleServletRegistration() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
        bean.addUrlMappings("/console/*");
        return bean;
    }
}
