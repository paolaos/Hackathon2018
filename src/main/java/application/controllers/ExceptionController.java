package application.controllers;

import application.core.exception.service.ExceptionService;
import application.core.processmeasureparticipant.service.ProcessMeasureParticipantService;
import application.model.Exception;
import application.model.ProcessMeasureId;
import application.util.DialogMessageUtil;
import com.mysql.cj.core.util.StringUtils;
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

    @Autowired
    ProcessMeasureParticipantService processMeasureParticipantService;

    @RequestMapping(value = "/exception/{id}")
    public String getStore(@PathVariable("id") long exceptiopnId,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        Exception exception = exceptionService.findById(exceptiopnId);

        if(exception == null) {
            DialogMessageUtil.addRedirectMessage(redirectAttributes, "Exception not found", "Exception is null", "error");
            return "redirect:/index";
        }
        ProcessMeasureId processMeasureId = exception.getProcessMeasure().getProcessMeasureId();

        model.addAttribute("exception", exception);
        model.addAttribute("users", processMeasureParticipantService.getParticipantsByProcessMeasure(processMeasureId));

        return "exception";
    }
}
