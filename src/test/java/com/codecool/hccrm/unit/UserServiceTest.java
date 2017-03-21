package com.codecool.hccrm;

import com.codecool.hccrm.dto.SignUpDTO;
import com.codecool.hccrm.model.Role;
import com.codecool.hccrm.model.User;
import com.codecool.hccrm.repository.UserRepository;
import com.codecool.hccrm.service.RoleService;
import com.codecool.hccrm.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

import static com.codecool.hccrm.model.RoleEnum.ROLE_CEO;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by balag3 on 2017.03.02..
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private RoleService roleService;

    private User user = new User("FirstName", "LastName", "Email", "Password", "Phone");

    private SignUpDTO dto = new SignUpDTO();

    @Before
    public void setup() {
        dto.setFirstName("dtoFirst");
        dto.setLastName("dtoLast");
        dto.setEmail("dtoEmail");
        dto.setPassword("dtoPassword");
        dto.setPhoneNumber("dtoPhone");
    }

    @Test
    public void testFindByEmail() {
        when(userRepository.findFirstByEmail("Email")).thenReturn(user);
        when(userRepository.findFirstByEmail("nonExistingEmail")).thenReturn(null);

        assertNotNull(userService.findFirstByEmail("Email"));
        assertNull(userService.findFirstByEmail("nonExistingEmail"));
    }

    @Test
    public void testGetUserList() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        assertNotNull(userService.findAll());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testDelete() {
        userService.delete(user);
        verify(userRepository).delete(eq(user));
    }

    @Test
    public void testFindByEmailAndVerifiedTrue() {
        when(userRepository.findByEmailAndVerifiedTrue("Email")).thenReturn(user);
        when(userRepository.findByEmailAndVerifiedTrue("NonExistingEmail")).thenReturn(null);

        assertNotNull(userService.findByEmailAndVerifiedTrue("Email"));
        assertNull(userService.findByEmailAndVerifiedTrue("NonExistingEmail"));
    }

    @Test
    public void testSave() {
        userService.save(user);
        verify(userRepository).save(eq(user));
    }

    @Test
    public void testCreateUserFromDTOAssigningCorrectValues() {
        when(passwordEncoder.encode(dto.getPassword())).thenReturn("dtoPassword");
        User dtoUser = userService.createNewUser(dto);

        assertEquals("dtoFirst", dtoUser.getFirstName());
        assertEquals("dtoLast", dtoUser.getLastName());
        assertEquals("dtoPassword", dtoUser.getPassword());
        assertEquals("dtoEmail", dtoUser.getEmail());
        assertEquals("dtoPhone", dtoUser.getPhoneNumber());
    }

    @Test
    public void testCreateFromDTOUsingPasswordEncoder() {
        userService.createNewUser(dto);

        verify(passwordEncoder, times(1)).encode(dto.getPassword());
    }

    @Test
    public void testCreateFromDTOAssigningCEORole() {
        Role ceoRole = new Role(ROLE_CEO.getRole());
        when(roleService.findByName(ROLE_CEO.getRole())).thenReturn(ceoRole);
        User dtoUser = userService.createNewUser(dto);

        assertTrue(dtoUser.getRoles().contains(ceoRole));
        verify(roleService, times(1)).findByName(ROLE_CEO.getRole());
    }

}

