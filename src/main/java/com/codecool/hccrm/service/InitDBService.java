package com.codecool.hccrm.service;

import com.codecool.hccrm.model.Role;
import com.codecool.hccrm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

import static com.codecool.hccrm.model.RoleEnum.ROLE_ADMIN;
import static com.codecool.hccrm.model.RoleEnum.ROLE_CEO;
import static com.codecool.hccrm.model.RoleEnum.ROLE_MANAGER;

/**
 * Created by dorasztanko on 2017. 02. 09..
 * Last edited by dorasztanko on 2017. 02. 17..
 */
@Transactional
@Service
public class InitDBService {

    private final String userEmail = "hccrm.robotkutya@gmail.com";

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    private void init() {
        if (roleService.findByName(ROLE_ADMIN.getRole()) == null) {
            Role roleAdmin = new Role(ROLE_ADMIN.getRole());
            roleService.save(roleAdmin);

            User admin = new User("Ádám", "Kocsis", userEmail, passwordEncoder.encode("codecool"), "0036709861178");

            Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleAdmin);
            admin.setRoles(roleSet);
            admin.setVerified(Boolean.TRUE);
            userService.save(admin);
        }
        if (roleService.findByName(ROLE_CEO.getRole()) == null) {
            Role roleCeo = new Role(ROLE_CEO.getRole());
            roleService.save(roleCeo);
        }
        if (roleService.findByName(ROLE_MANAGER.getRole()) == null) {
            Role roleManager = new Role(ROLE_MANAGER.getRole());
            roleService.save(roleManager);
        }
    }
}
