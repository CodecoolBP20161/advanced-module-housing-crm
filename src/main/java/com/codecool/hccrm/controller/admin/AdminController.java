package com.codecool.hccrm.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.codecool.hccrm.logging.LogFormatter.FORMAT;

/**
 * Created by turbek on 05.02.17.
 * Last edited by dorasztanko on 2017.02.18..
 */
@Controller
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminIndex() {
        logger.info(FORMAT.getFormatter() + "Admin page is called.");

        return "admin/admin_index";
    }
}
