package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.CompanyDTO;
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

    public Company findByPremiseAndTaxNumber(String premise, String taxNumber) {
        return companyRepository.findByPremiseAndTaxNumber(premise, taxNumber);
    }

    @Transactional
    public Company createNewCompany(CompanyDTO dto) throws CompanyAlreadyExistsException {
        if (alreadyExists(dto.getPremise(), dto.getTaxNumber())) {
            throw new CompanyAlreadyExistsException("Already have a company with tax number " + dto.getTaxNumber() + " in " + dto.getPremise() + " registered.");
        }
        Company company  = new Company(dto.getCompanyName(), dto.getTaxNumber(), dto.getPremise());
        return companyRepository.save(company);
    }

    private boolean alreadyExists(String premise, String taxNumber) {
        Company company = findByPremiseAndTaxNumber(premise, taxNumber);
        return company != null;
    }
}
