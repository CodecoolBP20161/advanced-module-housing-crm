package com.codecool.hccrm.service;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
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


    public void testClient() throws Exception {
        Company company = new Company();
        //company.setCompanyName("Lex Corp");

        Condominium condominium = new Condominium();

//        User user = new User();


//        condominium.setManagerUser(user);
//        Set<Condominium> s = new HashSet<>();
//        s.add(condominium);
//        condominium.setCompany(company);
//
//        Set<User> managers = new HashSet<>();
//        managers.add(user);
//        company.setManagerUsers(managers);
//
//        userService.save(user);
//        companyService.save(company);
//        condominiumService.save(condominium);
//
//        Company company2 = companyService.findByCompanyName("Lex Corp");
//        List<Condominium> condoms = condominiumService.findByCompany(company2);
//        System.out.println(condoms);
//
//        System.out.println("companies:");
//        System.out.println(companyService.findAll());
//        System.out.println("condominiums:");
//        System.out.println(condominiumService.findAll());
//        System.out.println("Users:");
//        System.out.println(userService.findAll());


    }

}
