package application.controllers;

import application.core.indicator.service.IndicatorService;
import application.core.user.service.UserService;
import application.core.workprocess.service.WorkProcessService;
import application.model.Indicators;
import application.model.WorkProcess;
import application.model.WorkProcessId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getIndex(Model model) {
        // Retrieve all users and add it as a model attribute.
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }
}
