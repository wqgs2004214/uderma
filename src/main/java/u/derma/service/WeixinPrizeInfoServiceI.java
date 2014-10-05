package u.derma.service;

import java.util.List;

import u.derma.model.WeixinGoods;
import u.derma.model.WeixinPrizeInfo;
import u.derma.model.WeixinUser;


public interface WeixinPrizeInfoServiceI {

	List<WeixinPrizeInfo> selectByUserid(String userid);
	int insert(WeixinPrizeInfo info);
	List<WeixinPrizeInfo> getAll();
	
}
