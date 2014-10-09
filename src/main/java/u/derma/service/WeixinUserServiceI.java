package u.derma.service;

import java.util.List;

import u.derma.model.WeixinUser;


public interface WeixinUserServiceI {

	List<WeixinUser> getAll();
	
	int addLotteryNumber(String openid);
	
	int minusLotteryNumber(String openid);
	
	int insert(WeixinUser user);
	
	WeixinUser selectByOpenid(String openid);
	
}
