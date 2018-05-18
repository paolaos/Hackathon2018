package application.controllers;

import application.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Analytics {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/analytics")
    public String getLogin() {
        return "analytics";
    }
}
