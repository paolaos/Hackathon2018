package application.controllers;

import application.core.exception.service.ExceptionService;
import application.core.processmeasureparticipant.service.ProcessMeasureParticipantService;
import application.core.solution.service.SolutionService;
import application.core.user.service.UserService;
import application.model.Exception;
import application.model.ProcessMeasureId;
import application.model.ProcessMeasureParticipant;
import application.model.ProcessMeasureParticipantId;
import application.util.DialogMessageUtil;
import com.mysql.cj.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExceptionController {

    @Autowired
    ExceptionService exceptionService;

    @Autowired
    ProcessMeasureParticipantService processMeasureParticipantService;

    @Autowired
    SolutionService solutionService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/exception/{id}")
    public String getException(@PathVariable("id") long exceptiopnId,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        Exception exception = exceptionService.findById(exceptiopnId);

        if(exception == null) {
            DialogMessageUtil.addRedirectMessage(redirectAttributes, "Exception not found", "Exception is null", "error");
            return "redirect:/index";
        }
        ProcessMeasureId processMeasureId = exception.getProcessMeasure().getProcessMeasureId();

        model.addAttribute("exception", exception);
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("users", processMeasureParticipantService.getParticipantsByProcessMeasure(processMeasureId));
        model.addAttribute("recommendSolution", solutionService.getRecommendedSolution(exceptiopnId));
        model.addAttribute("solutions", solutionService.getAllSolutionsByException(exceptiopnId));

        return "exception";
    }

    @RequestMapping(value = "/exception/add-user")
    public String addUserToException(@RequestParam("userId") String userId,
                                     @RequestParam("exceptionId") long exception,
                                     RedirectAttributes redirectAttributes){
        try {
            Exception exception1 = exceptionService.findById(exception);
            ProcessMeasureParticipant processMeasureParticipant = new ProcessMeasureParticipant();
            ProcessMeasureParticipantId processMeasureParticipantId = new ProcessMeasureParticipantId();
            processMeasureParticipantId.setIndicatorFk(exception1.getIndicatorFk());
            processMeasureParticipantId.setProcessMeasureFk(exception1.getProcessMeasureFk());
            processMeasureParticipantId.setWorkProcessFk(exception1.getWorkProcessFk());
            processMeasureParticipantId.setUserFk(userId);

            processMeasureParticipant.setProcessMeasureParticipantId(processMeasureParticipantId);

            processMeasureParticipantService.insert(processMeasureParticipant);

        } catch (java.lang.Exception e) {
            DialogMessageUtil.addRedirectMessage(redirectAttributes,
                    "Error!",
                    "This user is already a participant.",
                    "error");
            return "redirect:/exception/"+exception;
        }
        DialogMessageUtil.addRedirectMessage(redirectAttributes,
                "Success!",
                "The user was added successfully.",
                "success");
        return "redirect:/exception/"+exception;
    }

    @ModelAttribute(value = "manualException")
    public Exception getManualException() {
        return new Exception();
    }
}
