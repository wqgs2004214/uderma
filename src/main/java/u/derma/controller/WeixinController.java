package u.derma.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import u.derma.model.WeixinUser;
import u.derma.service.WeixinUserServiceI;

@Controller
@RequestMapping("/")
public class WeixinController {
	private final Logger log = Logger.getLogger(WeixinController.class);
	
	@Autowired
	private WeixinUserServiceI weixinUserService;
	
	@RequestMapping("listUser")
	public String listUser(Model model) {
		System.out.println("==================================================================================");
		List <WeixinUser> list = weixinUserService.getAll();
		model.addAttribute("userlist", list);
		return "views/listUser";
	}

	/**
	 * 微信回调接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value="callback/{echostr}", method=RequestMethod.GET)
	public @ResponseBody String callback(@PathVariable String echostr) {
		return echostr;
	}

	@RequestMapping(value="view",method=RequestMethod.GET)
	public String viewPage(@RequestParam String userid, Model model) {
		WeixinUser user = weixinUserService.selectByUserid(userid);
		if (user == null) {
			//记录新的抽奖用户
			user = new WeixinUser();
			user.setId(UUID.randomUUID().toString());
			user.setUserid(userid);
			user.setLotterynumber(1);
			weixinUserService.insert(user);
		}
		model.addAttribute("user", user);
		return "views/listUser";
	}
	
	@RequestMapping(value="addUser")
	public String addUser(WeixinUser muser) {
		String id = UUID.randomUUID().toString();
		muser.setId(id);
		weixinUserService.insert(muser);
		return "redirect:/listUser";
	}
	
	
	
//	@RequestMapping(value="/deleteUser")
//	public String deleteUser(String id) {
//		
//		weixinUserService.delete(id);
//		return "redirect:/listUser";
//	}
	
}
