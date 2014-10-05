package u.derma.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import u.derma.model.LotteryEntity;
import u.derma.model.WeixinUser;
import u.derma.service.WeixinUserServiceI;
import u.derma.utils.Configs;
import u.derma.utils.HttpUtils;

@Controller
@RequestMapping("/")
public class WeixinController {
	private final Logger log = Logger.getLogger(WeixinController.class);

	@Autowired
	private WeixinUserServiceI weixinUserService;

	/**
	 * 微信回调接口
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "callback", method = RequestMethod.GET)
	public @ResponseBody
	String callback(@RequestParam String echostr) {
		// 测试回调接口
		return echostr;
	}

	/**
	 * 阅读原文url地址
	 * 
	 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=
	 * wx28d1b2def70df706
	 * &redirect_uri=http%3A%2F%2Fpush3gtest.smt-online.net%2Fuderma
	 * %2Finit%3F&response_type
	 * =userid&scope=snsapi_base&state=ASDSCRATCH#wechat_redirect
	 * https://open.weixin
	 * .qq.com/connect/oauth2/authorize?appid=wx520c15f417810387
	 * &redirect_uri={redirect_uri
	 * }&response_type=userid&scope=snsapi_base&state=123#wechat_redirect
	 * redirect_url为当前controller地址
	 * ,并且会回传用户ID,使用userid字段保存阅读当前页面用户信息,默认给用户一次抽奖机会,如需多次抽奖请用户进行分享
	 * 
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String viewPage(@RequestParam String code, Model model, HttpSession session) {
		log.debug("阅读原文!");
		String getOpenIdUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+Configs.getInstance().getString("AppId")+"&secret="+Configs.getInstance().getString("AppSecret")+"&code=" +code+ "&grant_type=authorization_code";
		log.debug("request openid url:" + getOpenIdUrl);
		String result = HttpUtils.request(getOpenIdUrl);
		log.debug("通过网页授权返回数据:" + result);
		//String userid = ((JSONObject)JSON.parse(result)).getString("appid");
		String userid = "gushuai";
		WeixinUser user = weixinUserService.selectByUserid(userid);
		if (user == null) {
			// 记录新的抽奖用户
			user = new WeixinUser();
			user.setId(UUID.randomUUID().toString());
			user.setUserid(userid);
			user.setLotterynumber(10);
			weixinUserService.insert(user);
		}
		model.addAttribute("user", user);
		session.setAttribute("userid", userid);
		return "views/scratch";
	}

	
	/**
	 * 初始化当前用户状态,判断是否属于关注用户.是否能进行抽奖操作
	 * 
	 * @param code
	 * @return "{"activityId":"134","isFollow":"no","inviteCode":"54b49bb465f16e762065aa99efebdbf4","chance":"2"}"
	 */
	@RequestMapping(value = "init", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public @ResponseBody String init(HttpSession session) {
		String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="
				+ weixinUserService.getAccessToken() + "&next_openid=" + session.getAttribute("userid");
		String result = HttpUtils.request(url);
		JSONObject jsonObject = (JSONObject)JSON.parse(result);
		//获取拉取到得openid个数
		//int count = jsonObject.getIntValue("count");
		int count = 1;
		LotteryEntity lotteryEntity = new LotteryEntity();
		if (count > 0) {
			WeixinUser user = weixinUserService.selectByUserid((String)session.getAttribute("userid"));
			lotteryEntity.setChance(user.getLotterynumber());
			lotteryEntity.setActivityId(user.getUserid());
			lotteryEntity.setIsFollow("YES");
			lotteryEntity.setPlayerInviteCode("123");
		}
		return lotteryEntity.toString();
	}

	
	/**
	 * 触发抽奖操作.会造成减少用户抽奖次数
	 * 
	 * @param userid
	 * @return 0表示失败 1表示成功
	 */
	@RequestMapping(value = "useLottery", method = RequestMethod.GET)
	public int useLottery(@RequestParam String userid) {
		log.debug("调用开始抽奖动作");
		return weixinUserService.minusLotteryNumber(userid);
	}

	@RequestMapping(value="play", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public @ResponseBody String play(HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		weixinUserService.minusLotteryNumber(userid);
		return "{\"prizeDesc\":\"抽中了IPAD\"}";	
	}
	
	
	@RequestMapping(value="getid", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public @ResponseBody String getID(HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		return "{\"status\":\"ok\", \"inviteCode\":\"" + userid + "\"}";	
	}
	
	
	/**
	 * 浏览指定用户分享页面
	 * 
	 * @param sharedId
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "viewShare", method = RequestMethod.GET)
	public String viewShare(@RequestParam String sharedId,
			@RequestParam String userid, Model model) {
		log.debug("浏览分享页面");
		// 如果页面被浏览则给分享用户增加一次抽奖机会
		weixinUserService.addLotteryNumber(sharedId);
		//return viewPage(userid, model);
		return "";
	}

}
