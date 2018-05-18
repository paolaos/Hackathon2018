package application.util;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Singleton. Will be used by multiple classes.
public class DialogMessageUtil {

    private DialogMessageUtil(){};

    /**
     * Receive a RedirectAttributes object and add attributes needed to display our event dialog.
     * @param redirectAttributes Attributes that will be send from one controller's method to another.
     * @param messageTitle Dialog title.
     * @param messageAlert Dialog body.
     * @param messageType Dialog type.
     */
    public static void addRedirectMessage(RedirectAttributes redirectAttributes, String messageTitle, String messageAlert, String messageType) {
        redirectAttributes.addFlashAttribute("messageTitle", messageTitle);
        redirectAttributes.addFlashAttribute("messageAlert", messageAlert);
        redirectAttributes.addFlashAttribute("messageType", messageType);
    }

    /**
     * Receive a model and add attributes needed to display our event dialog.
     * @param model Model to which we will add our attributes.
     * @param messageTitle Dialog title.
     * @param messageAlert Dialog body.
     * @param messageType Dialog type.
     */
    public static void addModelMessage(Model model, String messageTitle, String messageAlert, String messageType) {
        model.addAttribute("messageTitle", messageTitle);
        model.addAttribute("messageAlert", messageAlert);
        model.addAttribute("messageType", messageType);
    }
}
