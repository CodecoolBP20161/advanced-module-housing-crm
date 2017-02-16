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
 * Created by dorasztanko on 2017.02.13..
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
        if (roleService.findAll().isEmpty() && userService.findAll().isEmpty()) {
            Role roleAdmin = new Role(adminString);
            roleService.save(roleAdmin);
            Role roleCeo = new Role(ceoString);
            roleService.save(roleCeo);
            Role roleManager = new Role(managerString);
            roleService.save(roleManager);
            User admin = new User("John", "Smith", userEmail, passwordEncoder.encode("password"), "+36709861178");
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleAdmin);
            admin.setRoles(roleSet);
            admin.setVerified(Boolean.TRUE);
            userService.save(admin);
        }
    }
}