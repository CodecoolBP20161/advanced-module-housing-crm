package com.codecool.hccrm.unit;

import com.codecool.hccrm.model.Role;
import com.codecool.hccrm.repository.RoleRepository;
import com.codecool.hccrm.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * Created by balag3 on 2017.03.08..
 */
@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {

    @InjectMocks
    RoleService roleService;

    @Mock
    RoleRepository roleRepository;

    Role role = new Role();

    @Test
    public void testSave() {
        roleService.save(role);

        verify(roleRepository, times(1)).save(role);
    }

    @Test
    public void testDelete() {
        roleService.delete(role);

        verify(roleRepository, times(1)).delete(role);
    }

    @Test
    public void testFindAll() {
        roleService.findAll();

        verify(roleRepository, times(1)).findAll();
    }

    @Test
    public void testFindByName() {
        roleService.findByName("ROLE_NAME");

        verify(roleRepository, times(1)).findByName("ROLE_NAME");
    }
}
