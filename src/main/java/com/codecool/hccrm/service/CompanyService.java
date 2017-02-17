package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.UserCompanyRegistrationDTO;
import com.codecool.hccrm.error.CompanyAlreadyExistsException;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by balag3 on 2017.02.05..
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

    public Company findByCompanyNameOrTaxNumber(String name, String taxNumber) {
        return companyRepository.findByCompanyNameOrTaxNumber(name, taxNumber);
    }

    @Transactional
    public Company createNewCompany(UserCompanyRegistrationDTO dto) throws CompanyAlreadyExistsException {
        if (alreadyExists(dto.getCompanyName(), dto.getTaxNumber())) {
            throw new CompanyAlreadyExistsException("Already have a company with tax number " + dto.getTaxNumber() + " in " + dto.getPremise() + " registered.");
        }
        Company company  = new Company();
        company.setCompanyName(dto.getCompanyName());
        company.setTaxNumber(dto.getTaxNumber());
        return companyRepository.save(company);
    }

    private boolean alreadyExists(String name, String taxNumber) {
        Company company = findByCompanyNameOrTaxNumber(name, taxNumber);
        return company != null;
    }
}
