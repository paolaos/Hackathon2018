package application.controllers;

import application.core.exception.service.ExceptionService;
import application.core.solution.service.SolutionService;
import application.model.Exception;
import application.model.Solution;
import application.model.SolutionId;
import application.util.DialogMessageUtil;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SolutionController {

    @Autowired
    SolutionService solutionService;

    @Autowired
    ExceptionService exceptionService;

    @RequestMapping(value = "/solution/add-solution")
    @ResponseBody
    public String submitSolution(@RequestParam("exceptionId") Integer exceptionId,
                                 @RequestParam("solutionId") String solutionId,
                                 @RequestParam("description") String description,
                                 RedirectAttributes redirectAttributes) {
        try {

            Exception exception = exceptionService.findById(exceptionId);

            if (exception == null) {
                DialogMessageUtil.addRedirectMessage(redirectAttributes,
                        "Excepción invalida.",
                        "No se encontro la exception de está solución.",
                        "error");
                return "redirect:/dashboard";
            }

            SolutionId newSolutionId = new SolutionId();
            newSolutionId.setExceptionFk(exceptionId);
            newSolutionId.setId(solutionId);

            Solution solution = new Solution();
            solution.setSolutionId(newSolutionId);
            solution.setDescription(description);
            solution.setCount(1);

            solutionService.insert(solution);
        } catch (HibernateException e) {
            return e.getMessage();
        }
        return "";
    }


    @RequestMapping(value = "/solutions/get")
    public List<Solution> getSolutions() {
        return null;
    }

    @RequestMapping(value = "/solution/get/{id}")
    @ResponseBody
    public Object getExceptionSolution(@PathVariable("id") long exceptiopnId,
                                       RedirectAttributes redirectAttributes,
                                       Model model) {

        Solution solution = solutionService.getAllSolutions().get(0);
        return new ResponseEntity<Object>(solution.getDescription(), HttpStatus.OK);
    }
}

