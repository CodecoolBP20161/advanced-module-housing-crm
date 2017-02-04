package com.codecool.hccrm.controller;

import com.codecool.hccrm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    TestService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        service.testClient();
        return "index";
    }
}
