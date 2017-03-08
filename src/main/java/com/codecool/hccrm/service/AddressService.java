package com.codecool.hccrm.service;

import com.codecool.hccrm.dto.AddressDTO;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by balag3 on 2017.02.17..
 * Last edited by dorasztanko on 2017.02.19..
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
    public Address createNewAddress(AddressDTO dto) {
        Address newAddress = new Address(dto.getCountry(), dto.getZipCode(), dto.getCity(), dto.getAddressLine1(), dto.getAddressLine2());
        save(newAddress);
        return newAddress;
    }
}
