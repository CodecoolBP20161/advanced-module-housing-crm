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

/**
 * Created by dorasztanko on 2017. 02. 09..
 * Last edited by dorasztanko on 2017. 02. 17..
 */
@Transactional
@Service
public class InitDBService {

    private final String adminString = "ROLE_ADMIN";
    private final String ceoString = "ROLE_CEO";
    private final String managerString = "ROLE_MANAGER";

    private final String userEmail = "hccrm.robotkutya@gmail.com";

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    private void init() {
        if (roleService.findByName("ROLE_ADMIN") == null) {
            Role roleAdmin = new Role(adminString);
            roleService.save(roleAdmin);

            User admin = new User("Ádám", "Kocsis", userEmail, passwordEncoder.encode("codecool"), "+36709861178");

            Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleAdmin);
            admin.setRoles(roleSet);
            admin.setVerified(Boolean.TRUE);
            userService.save(admin);
        }
        if (roleService.findByName("ROLE_CEO") == null) {
            Role roleCeo = new Role(ceoString);
            roleService.save(roleCeo);
        }
        if (roleService.findByName("ROLE_MANAGER") == null) {
            Role roleManager = new Role(managerString);
            roleService.save(roleManager);
        }
    }
}
