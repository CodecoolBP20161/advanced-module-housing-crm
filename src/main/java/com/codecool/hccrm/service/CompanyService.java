package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.SignUpDTO;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by balag3 on 2017.02.05..
 * Last edited by dorasztanko on 2017.02.19..
 */
@Service
@Transactional
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company findByCompanyName(String name) {
        return companyRepository.findByCompanyName(name);
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findByCompanyNameOrTaxNumber(String companyName, String taxNumber) {
        return companyRepository.findByCompanyNameOrTaxNumber(companyName, taxNumber);
    }

    public Company findByTaxNumber(String taxNumber) {
        return companyRepository.findByTaxNumber(taxNumber);
    }

    @Transactional
    public Company createNewCompany(SignUpDTO dto, User ceo, Address address) {
        Company newCompany = new Company(dto.getCompanyName(), dto.getTaxNumber(), dto.getPremise());
        Set<User> ceos = new HashSet<>();
        ceos.add(ceo);
        newCompany.setCeoUsers(ceos);
        newCompany.setAddress(address);
        save(newCompany);
        return newCompany;
    }
}
