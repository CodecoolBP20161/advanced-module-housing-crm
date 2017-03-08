package com.codecool.hccrm;

import com.codecool.hccrm.dto.AddressDTO;
import com.codecool.hccrm.dto.SignUpDTO;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.repository.AddressRepository;
import com.codecool.hccrm.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by balag3 on 2017.03.07..
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @InjectMocks
    AddressService addressService;

    @Mock
    AddressRepository addressRepository;

    private AddressDTO signUpDTO = new SignUpDTO();

    private Address address = new Address();

    @Before
    public void setup() {
        signUpDTO.setCountry("Country");
        signUpDTO.setZipCode("ZipCode");
        signUpDTO.setCity("City");
        signUpDTO.setAddressLine1("Address_1");
        signUpDTO.setAddressLine1("Address_1");
    }

    @Test
    public void testSave() {
        addressService.save(address);

        verify(addressRepository, times(1)).save(address);
    }

    @Test
    public void testDelete() {
        addressService.delete(address);

        verify(addressRepository, times(1)).delete(address);
    }

    @Test
    public void testFindAll() {
        addressService.findAll();

        verify(addressRepository, times(1)).findAll();
    }

    @Test
    public void testCreateAddressFromDTO() {
        Address address = addressService.createNewAddress(signUpDTO);

        assertEquals(address.getCountry(), signUpDTO.getCountry());
        assertEquals(address.getCity(), signUpDTO.getCity());
        assertEquals(address.getZipCode(), signUpDTO.getZipCode());
        assertEquals(address.getAddressLine1(), signUpDTO.getAddressLine1());
        assertEquals(address.getAddressLine2(), signUpDTO.getAddressLine2());
    }

    @Test
    public void testCreateFromDTOSave () {
        Address address = addressService.createNewAddress(signUpDTO);

        verify(addressRepository, times(1)).save(address);

    }
}
