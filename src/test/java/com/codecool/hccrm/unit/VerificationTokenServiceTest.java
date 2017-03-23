package com.codecool.hccrm.unit;

import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import com.codecool.hccrm.repository.VerificationTokenRepository;
import com.codecool.hccrm.service.VerificationTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by balag3 on 2017.03.08..
 */
@RunWith(MockitoJUnitRunner.class)
public class VerificationTokenServiceTest {

    @InjectMocks
    VerificationTokenService verificationTokenService;

    @Mock
    VerificationTokenRepository verificationTokenRepository;

    VerificationToken verificationToken = new VerificationToken();

    User user = new User();

    @Test
    public void testSave() {
        verificationTokenService.save(verificationToken);

        verify(verificationTokenRepository, times(1)).save(verificationToken);
    }

    @Test
    public void testDelete() {
        verificationTokenService.delete(verificationToken);

        verify(verificationTokenRepository, times(1)).delete(verificationToken);
    }

    @Test
    public void testFindAll() {
        verificationTokenService.findAll();

        verify(verificationTokenRepository, times(1)).findAll();
    }

    @Test
    public void testFindByToken() {
        verificationTokenService.findByToken("token");

        verify(verificationTokenRepository, times(1)).findByToken("token");
    }

    @Test
    public void testFindByUser() {
        verificationTokenService.findByUser(user);

        verify(verificationTokenRepository, times(1)).findByUser(user);
    }

    @Test
    public void testCreateVerificationTokenForSpecificUser() {
        verificationToken = verificationTokenService.createVerificationToken(user);

        assertEquals(user, verificationToken.getUser());
    }

    @Test
    public void testCreateVerificationTokenSave() {
        verificationToken = verificationTokenService.createVerificationToken(user);

        verify(verificationTokenRepository, times(1)).save(verificationToken);
    }
}
