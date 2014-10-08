package u.derma.controller;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import u.derma.model.UserBean;

@Controller
@RequestMapping("/login")
@SessionAttributes("userBean")
public class LoginController {
	@ModelAttribute("userBean")
	public UserBean createUserBean() {
		return new UserBean();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "views/login";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid UserBean userBean, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
		System.out.println("-----------------------------------1");
		
		if (result.hasErrors()) {
			System.out.println("-----------------------------------2");
			return null;
		}
		if (!StringUtils.equalsIgnoreCase(userBean.getName() ,"admin") || !StringUtils.equalsIgnoreCase(userBean.getPassword(), "123")) {
			return null;
		}
		// Typically you would save to a db and clear the "form" attribute from the session 
		// via SessionStatus.setCompleted(). For the demo we leave it in the session.
		//String message = "Form submitted successfully.  Bound " + userBean;
		// Success response handling
		//redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/views/index";			
		
	}
}
