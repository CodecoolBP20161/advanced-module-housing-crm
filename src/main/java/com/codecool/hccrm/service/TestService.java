package com.codecool.hccrm.service;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.model.Role;
import com.codecool.hccrm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by balag3 on 2017.02.03..
 */

@Service
public class TestService {

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @Autowired
    CondominiumService condominiumService;

    @Autowired
    RoleService roleService;

    public void testClient() throws Exception {
        Role admin_r = new Role("ROLE_ADMIN");
        Role ceo_r = new Role("ROLE_CEO");
        Role manager_r = new Role("ROLE_MANAGER");

        Company company = new Company("Lex Corp.", "1234567890", "New York");

        Condominium condominium1 = new Condominium("3546 New York, Pető Street 5.", "331535", 255, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());
        Condominium condominium2 = new Condominium("3547 New York, Alma Street 6.", "336515", 651516, GregorianCalendar.getInstance(), GregorianCalendar.getInstance());

        User user1 = new User("John", "Smith", "hccrm.robotkutya+1@gmail.com", "1234", "+36301234567");
        User user2 = new User("Karen", "Pettigrew", "hccrm.robotkutya+2@gmail.com", "1234", "+36301834567");
        User user3 = new User("Condom", "Team", "hccrm.robotkutya+3@gmail.com", "115654", "+363034567");

        Set<Role> r = new HashSet<>();
        r.add(admin_r);
        user3.setRoles(r);

        Set<Role> r2 = new HashSet<>();
        r2.add(ceo_r);
        user2.setRoles(r2);

        Set<Role> r3 = new HashSet<>();
        r3.add(manager_r);
        r3.add(ceo_r);
        user1.setRoles(r3);

        Set<User> ceos = new HashSet<>();
        ceos.add(user2);
        company.setCeoUsers(ceos);


        condominium1.setManagerUser(user1);
        condominium2.setManagerUser(user2);

        Set<Condominium> s = new HashSet<>();
        s.add(condominium1);
        s.add(condominium2);

        condominium1.setCompany(company);
        condominium2.setCompany(company);

        Set<User> managers = new HashSet<>();
        managers.add(user1);
        managers.add(user2);
        company.setManagerUsers(managers);

        roleService.save(admin_r);
        roleService.save(ceo_r);
        roleService.save(manager_r);
        userService.save(user1);
        userService.save(user2);
        companyService.save(company);
        condominiumService.save(condominium1);
        condominiumService.save(condominium2);

//        System.out.println("companies:");
//        System.out.println(companyService.findAll());
//        System.out.println("condominiums:");
//        System.out.println(condominiumService.findAll());
//        System.out.println("Users:");
//        System.out.println(userService.findAll());
//        System.out.println("Roles:");
//        System.out.println(roleService.findAll());
    }
}
