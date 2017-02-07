package com.codecool.hccrm.integration.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by dorasztanko on 2017.02.07..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PageControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testIndexPage() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertTrue(body.contains("Index page displayed."));
    }
}