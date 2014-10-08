package u.derma.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import u.derma.model.UserBean;

@Controller
@RequestMapping("/login")
@SessionAttributes("userBean")
public class LoginController {
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@ModelAttribute("userBean")
	public UserBean createUserBean() {
		return new UserBean();
	}

	@RequestMapping(method = RequestMethod.GET)
	public void login() {
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@Valid UserBean userBean, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs, HttpSession session) {
		if (result.hasErrors()) {
			return "/login";
		}
		if (!StringUtils.equalsIgnoreCase(userBean.getName(), "admin")
				|| !StringUtils.equalsIgnoreCase(userBean.getPassword(), "123")) {
			redirectAttrs.addFlashAttribute("message", "用户名或密码错误.请重试");
			return "/login";
		}
		// Typically you would save to a db and clear the "form" attribute from
		// the session
		// via SessionStatus.setCompleted(). For the demo we leave it in the
		// session.
		// String message = "Form submitted successfully.  Bound " + userBean;
		// Success response handling
		// redirectAttrs.addFlashAttribute("message", message);
		// return "/index";
		session.setAttribute("status", "1");
		String message = "登录成功";
		redirectAttrs.addFlashAttribute("message", message);
		return "redirect:/home";

	}
}
