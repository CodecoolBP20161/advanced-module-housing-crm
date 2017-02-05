package com.codecool.hccrm.service;

import com.codecool.hccrm.model.CompanyUser;
import com.codecool.hccrm.repository.CompanyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by balag3 on 2017.02.05..
 */
@Service
@Transactional
public class CompanyUserService {

    @Autowired
    CompanyUserRepository companyUserRepository;

    public void save(CompanyUser companyUser) {
        companyUserRepository.save(companyUser);
    }

    public void delete(CompanyUser companyUser) {
        companyUserRepository.delete(companyUser);
    }

    public List<CompanyUser> findAll() {
        return companyUserRepository.findAll();
    }
}
