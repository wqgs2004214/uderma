package rml.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import rml.model.MUser;
import rml.service.MUserServiceI;

@Controller
@RequestMapping("/")
public class MUserController {
	private final Logger log = Logger.getLogger(MUserController.class);
	
	private MUserServiceI muserService;

	public MUserServiceI getMuserService() {
		return muserService;
	}

	@Autowired
	public void setMuserService(MUserServiceI muserService) {
		this.muserService = muserService;
	}
	
	
	/**
	 * 微信回调接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value="callback", method=RequestMethod.GET)
	public @ResponseBody String callback(HttpServletRequest request) {
		log.debug("callback method!" + request.getParameter("echostr"));
		
		return request.getParameter("echostr");
		//return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}
	
	@RequestMapping("listUser")
	public String listUser(Model model) {
		System.out.println("==================================================================================");
		List <MUser> list = muserService.getAll();
		model.addAttribute("userlist", list);
		return "views/listUser";
	}
	
	@RequestMapping(value="addUser")
	public String addUser(MUser muser) {
		String id = UUID.randomUUID().toString();
		muser.setId(id);
		muserService.insert(muser);
		return "redirect:/listUser";
	}
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(String id) {
		
		muserService.delete(id);
		return "redirect:/listUser";
	}
	
	@RequestMapping(value="/updateUserUI")
	public String updateUserUI(String id, HttpServletRequest request) {
		MUser muser = muserService.selectByPrimaryKey(id);
		request.setAttribute("user", muser);
		return "updateUser";
	}

	@RequestMapping(value="/updateUser")
	public String updateUser(MUser muser) {
		
		muserService.update(muser);
		return "redirect:/listUser.do";
	}
}
