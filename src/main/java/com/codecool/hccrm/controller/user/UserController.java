package com.codecool.hccrm.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dorasztanko on 2017.02.19..
 */
@Controller
public class UserController {

    @RequestMapping(value = {"/user/dashboard"}, method = RequestMethod.GET)
    public String renderUserDashboard() {
        return "user_dashboard";
    }
}
