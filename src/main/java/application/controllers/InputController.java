package application.controllers;

import application.core.user.service.UserService;
import application.core.workprocess.service.WorkProcessService;
import application.model.WorkProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputController {

    @Autowired
    UserService userService;

    @Autowired
    WorkProcessService workProcessService;


    @RequestMapping(value = "/input")
    public String getLogin(Model model) {
        model.addAttribute("works", workProcessService.getAll());
        return "input";
    }
}
