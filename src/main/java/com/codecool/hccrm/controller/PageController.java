package com.codecool.hccrm.controller;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.CompanyUser;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.repository.CompanyRepository;
import com.codecool.hccrm.repository.CompanyUserRepository;
import com.codecool.hccrm.repository.CondominiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

@Controller
public class PageController {

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CondominiumRepository condominiumRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        Company c = new Company();
        companyRepository.save(c);

        Condominium cm = new Condominium();
        condominiumRepository.save(cm);

        CompanyUser u = new CompanyUser();
        companyUserRepository.save(u);

        cm.setManagerUser(u);
        Set<Condominium> s = new HashSet<>();
        s.add(cm);
        c.setCondominiums(s);


        return "index";
    }
}
