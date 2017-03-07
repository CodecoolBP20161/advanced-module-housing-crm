package com.codecool.hccrm.controller;

import com.codecool.hccrm.controller.user.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

import static com.codecool.hccrm.logging.LogFormatter.FORMAT;

@Controller
@PropertySource("classpath:messages.properties")
public class PageController {
    private Logger logger = LoggerFactory.getLogger(PageController.class);

    @Value("${logoutSuccess}")
    private String logoutSuccess;

    @Value("${loginError}")
    private String errorMessage;

    @Autowired
    UserController userController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        logger.info(FORMAT.getFormatter() + "Index page is rendered.");

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String error, String logout, Model model, Principal principal) {

        if (principal != null) {
            return userController.renderUserDashboard(model, principal);
        }
        if (error != null) {
            model.addAttribute("error", errorMessage);
        }
        if (logout != null) {
            model.addAttribute("logout", logoutSuccess);
        }
        return "login";
    }


}

