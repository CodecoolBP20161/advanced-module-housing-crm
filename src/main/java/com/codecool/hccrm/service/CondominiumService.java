package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.CondominiumDTO;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.Condominium;
import com.codecool.hccrm.repository.CondominiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * Created by balag3 on 2017.02.05..
 */
@Service
@Transactional
public class CondominiumService {

    @Autowired
    CondominiumRepository condominiumRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    DateService dateService;

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

    public Condominium findById(Long id) {
        return condominiumRepository.findById(id);
    }

    public Condominium createFromDTO(CondominiumDTO dto) throws ParseException {
        Condominium condominium = new Condominium();
        condominium.setName(dto.getName());
        condominium.setTopographicalNumber(dto.getTopographicalNumber());
        condominium.setParcelNumber(dto.getParcelNumber());
        condominium.setContractingDate(dateService.formatToCalendar(dto.getContractingDate()));
        condominium.setGeneralMeetingResolutionDate(dateService.formatToCalendar(dto.getGeneralMeetingDate()));
        Address address = addressService.createNewAddress(dto);
        condominium.setAddress(address);
        return condominium;
    }
}
