package com.jcommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Riyazuddin M on 4/30/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Public URLs.
     */
    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/error/**/*",
            "/console/**"
           /* ForgotMyPasswordController.FORGOT_PASSWORD_URL_MAPPING,
            ForgotMyPasswordController.CHANGE_PASSWORD_PATH,
            SignupController.SIGNUP_URL_MAPPING*/
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/payload")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password")
                .roles("USER");
               /* .userDetailsService(userSecurityService)
                .passwordEncoder(passwordEncoder());*/
    }
}
