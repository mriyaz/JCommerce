package com.jcommerce.backend.service;

import com.jcommerce.backend.persistence.domain.backend.Plan;
import com.jcommerce.backend.persistence.domain.backend.User;
import com.jcommerce.backend.persistence.domain.backend.UserRole;
import com.jcommerce.backend.persistence.repositories.PlanRepository;
import com.jcommerce.backend.persistence.repositories.RoleRepository;
import com.jcommerce.backend.persistence.repositories.UserRepository;
import com.jcommerce.enums.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

/**
 * Created by Riyazuddin M on 5/1/2017.
 */
@Service
@Transactional(readOnly=true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {

        Plan plan = new Plan(plansEnum);
        // It makes sure the plans exist in the database
        if (!planRepository.exists(plansEnum.getId())) {
            plan = planRepository.save(plan);
        }

        user.setPlan(plan);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);

        user = userRepository.save(user);

        return user;

    }

}
