package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SolutionController {

    @RequestMapping(value = "/exception/{exceptionId}/add-solution")
    @ResponseBody
    public String submitSolution(@PathVariable("exceptionId") Integer exceptionId,
                                 Model model) {
        return "";
    }

}
