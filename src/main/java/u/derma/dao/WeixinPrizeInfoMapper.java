package u.derma.dao;

import java.util.List;

import u.derma.model.WeixinGoods;
import u.derma.model.WeixinPrizeInfo;
import u.derma.model.WeixinUser;


public interface WeixinPrizeInfoMapper {
	List<WeixinPrizeInfo> selectByOpenid(String openid);
	int insert(WeixinPrizeInfo info);
	List<WeixinPrizeInfo> getAll();
}