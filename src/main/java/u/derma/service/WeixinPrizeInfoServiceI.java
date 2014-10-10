package u.derma.service;

import java.util.List;

import u.derma.model.WeixinGoods;
import u.derma.model.WeixinPrizeInfo;
import u.derma.model.WeixinUser;


public interface WeixinPrizeInfoServiceI {

	List<WeixinPrizeInfo> selectByOpenid(String openid);
	int insert(WeixinPrizeInfo info);
	List<WeixinPrizeInfo> getAll();
	List<WeixinPrizeInfo> getRecentPrizeUser();
}
