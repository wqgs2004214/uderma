package u.derma.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LoginOutController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String logout(HttpSession session) {
		//清除登录状态
		session.removeAttribute("status");
		return "redirect:/login";
	}
}
