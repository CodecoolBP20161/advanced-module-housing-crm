package com.codecool.hccrm.controller;

import com.codecool.hccrm.logging.LogFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    private Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        logger.info(LogFormatter.FORMAT.getFormatter() + "Index page is called.");

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
