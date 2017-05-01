package com.jcommerce;

import com.jcommerce.backend.persistence.domain.backend.Role;
import com.jcommerce.backend.persistence.domain.backend.User;
import com.jcommerce.backend.persistence.domain.backend.UserRole;
import com.jcommerce.backend.service.UserService;
import com.jcommerce.enums.PlansEnum;
import com.jcommerce.enums.RolesEnum;
import com.jcommerce.utils.UsersUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication

public class JcommerceApplication implements CommandLineRunner {

    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(JcommerceApplication.class);

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(JcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = UsersUtils.createBasicUser();
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
        LOG.debug("Creating user with username {}", user.getUsername());
        userService.createUser(user, PlansEnum.PRO, userRoles);
        LOG.info("User {} created", user.getUsername());
    }
}
