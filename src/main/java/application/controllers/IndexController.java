package application.controllers;

import application.core.exception.service.ExceptionService;
import application.core.indicator.service.IndicatorService;
import application.core.user.service.UserService;
import application.core.workprocess.service.WorkProcessService;
import application.model.Indicators;
import application.model.User;
import application.model.WorkProcess;
import application.model.WorkProcessId;
import application.security.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static application.util.DialogMessageUtil.addModelMessage;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    ExceptionService exceptionService;

    @RequestMapping(value = {"/","/index"})
    public String getIndex(Model model) {
        // Retrieve all users and add it as a model attribute.
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(appUser == null) {
            // If we don't find the user, then we send an error message to our view.
            addModelMessage(model, "User incorrecto.","Por favor, revise que haya ingresado correctamente el usuario.", "error");
        }
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("exceptions", exceptionService.getAllExceptions("PENDING"));
        return "dashboard";
    }
}
