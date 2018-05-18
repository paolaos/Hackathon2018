package application.controllers;

import application.core.exception.service.ExceptionService;
import application.model.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExceptionController {

    @Autowired
    ExceptionService exceptionService;

    @RequestMapping(value = "/exception/{id}")
    public String getStore(@PathVariable("id") long exceptiopnId,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        model.addAttribute("exception", exceptionService.findById(exceptiopnId));
        return "exception";
    }
}
