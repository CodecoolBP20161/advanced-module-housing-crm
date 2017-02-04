package com.codecool.hccrm.service;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.CompanyUser;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by balag3 on 2017.02.03..
 */

@org.springframework.stereotype.Service
public class TestService {

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CondominiumRepository condominiumRepository;

    @Autowired
    private CompanyQueryRepository companyQuery;

    @Autowired
    private CondominiumQueryRepository condominiumQuery;

    @Autowired
    private CompanyUserQueryRepository companyUserQuery;

    @Autowired
    private UserQueryRepository userQuery;

    @Transactional
    public void testClient() throws Exception {
        Company company = new Company();
        //company.setCompanyName("Lex Corp");

        Condominium condominium = new Condominium();

        CompanyUser user = new CompanyUser();


        condominium.setManagerUser(user);
        Set<Condominium> s = new HashSet<>();
        s.add(condominium);
        condominium.setCompany(company);

        Set<CompanyUser> managers = new HashSet<>();
        managers.add(user);
        company.setManagerUsers(managers);

        companyUserRepository.save(user);
        companyRepository.save(company);
        condominiumRepository.save(condominium);

        Company company2 = companyRepository.findByCompanyName("Lex Corp");
        System.out.println(company2.getId());
        List condoms = companyQuery.getCondominiums(company2);
        System.out.println(condoms);
        System.out.println("companies:");
        System.out.println(companyQuery.selectAll());
        System.out.println("condominiums:");
        System.out.println(condominiumQuery.selectAll());
        System.out.println("companyUsers:");
        System.out.println(companyUserQuery.selectAll());
        System.out.println("Users:");
        System.out.println(userQuery.selectAll());


    }

}
