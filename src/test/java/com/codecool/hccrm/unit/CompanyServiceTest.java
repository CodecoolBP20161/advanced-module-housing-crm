package com.codecool.hccrm.unit;

import com.codecool.hccrm.dto.SignUpDTO;
import com.codecool.hccrm.model.Address;
import com.codecool.hccrm.model.Company;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.repository.CompanyRepository;
import com.codecool.hccrm.service.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by balag3 on 2017.03.08..
 */
@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {

    @InjectMocks
    CompanyService companyService;

    @Mock
    CompanyRepository companyRepository;

    private Long id = 1L;

    private User ceoUser;

    private Company company;

    private SignUpDTO signUpDTO;

    private Address address;

    @Before
    public void setup() {
        ceoUser = new User();
        address = new Address();
        signUpDTO = new SignUpDTO();

        signUpDTO.setCompanyName("companyName");
        signUpDTO.setTaxNumber("taxNumber");
        signUpDTO.setPremise("Premise");

        company = companyService.createNewCompany(signUpDTO, ceoUser, address);

    }

    @Test
    public void testFindById() {
        companyService.findById(id);

        verify(companyRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByCeoUser() {
        companyService.findByCeoUsers(ceoUser);

        verify(companyRepository, times(1)).findByCeoUsers(ceoUser);
    }

    @Test
    public void findbyCompanyName() {
        companyService.findByCompanyName("companyName");

        verify(companyRepository, times(1)).findByCompanyName("companyName");
    }

    @Test
    public void testSave() {
        Company company = new Company();
        companyService.save(company);

        verify(companyRepository, times(1)).save(company);
    }

    @Test
    public void testDelete() {
        companyService.delete(company);

        verify(companyRepository, times(1)).delete(company);
    }

    @Test
    public void testFindAll() {
        companyService.findAll();

        verify(companyRepository, times(1)).findAll();
    }

    @Test
    public void testFindByCompanyNameOrTaxNumber() {
        companyService.findByCompanyNameOrTaxNumber("companyName", "taxNumber");

        verify(companyRepository, times(1)).findByCompanyNameOrTaxNumber("companyName", "taxNumber");

    }

    @Test
    public void testFindByTaxNumber() {
        companyService.findByTaxNumber("taxNumber");

        verify(companyRepository, times(1)).findByTaxNumber("taxNumber");
    }

    @Test
    public void testCreateNewCompany_CompanyName() {
        assertEquals(signUpDTO.getCompanyName(), company.getCompanyName());
    }

    @Test
    public void testCreateNewCompany_TaxNumber() {
        assertEquals(signUpDTO.getTaxNumber(), company.getTaxNumber());
    }

    @Test
    public void testCreateNewCompany_Premise() {
        assertEquals(signUpDTO.getPremise(), company.getPremise());
    }

    @Test
    public void testCreateNewCompany_CeoUser() {
        assertTrue(company.getCeoUsers().contains(ceoUser));
    }

    @Test
    public void testCreateNewCompany_Address() {
        assertEquals(address, company.getAddress());
    }

    @Test
    public void testCreateNewCompany_Save() {
        company = companyService.createNewCompany(signUpDTO, ceoUser, address);

        verify(companyRepository, times(1)).save(company);
    }

}
