package u.derma.service;

import java.util.List;

import u.derma.model.WeixinUser;


public interface WeixinUserServiceI {

	List<WeixinUser> getAll();
	
	int addLotteryNumber(String userid);
	
	int minusLotteryNumber(String userid);
	
	int insert(WeixinUser user);
	
	WeixinUser selectByUserid(String userid);
	
}
