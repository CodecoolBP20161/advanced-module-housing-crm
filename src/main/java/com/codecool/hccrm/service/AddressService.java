package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.UserCompanyRegistrationDTO;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by balag3 on 2017.02.17..
 */
@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public void save(Address address) {
        addressRepository.save(address);
    }

    public void delete(Address address) {
        addressRepository.delete(address);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Transactional
    public Address createNewAddress(UserCompanyRegistrationDTO dto) {
        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setZipCode(dto.getZipCode());
        address.setAddressLine1(dto.getAddressLine1());
        address.setAddressLine2(dto.getAddressLine2());
        save(address);
        return address;
    }
}
