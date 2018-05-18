package application.controllers;

import application.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String getLogin() {
        return "login";
    }
}
