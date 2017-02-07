package com.codecool.hccrm.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by dorasztanko on 2017.02.07..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserEntityTest {
    private static final String firstName = "John";
    private static final String lastName = "Smith";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createWhenUsernameIsNullShouldThrowException() throws Exception {
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("Username must not be empty");
        new User(null, VIN);
    }

}