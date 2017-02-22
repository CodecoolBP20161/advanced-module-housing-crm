package com.codecool.hccrm.service;

import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.repository.CondominiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by balag3 on 2017.02.05..
 */
@Service
@Transactional
public class CondominiumService {

    @Autowired
    CondominiumRepository condominiumRepository;

    public List<Condominium> findByCompany(Company company) {
        return condominiumRepository.findByCompany(company);
    }

    public void save(Condominium condominium) {
        condominiumRepository.save(condominium);
    }

    public void delete(Condominium condominium) {
        condominiumRepository.delete(condominium);
    }

    public List<Condominium> findAll() {
        return condominiumRepository.findAll();
    }
}
