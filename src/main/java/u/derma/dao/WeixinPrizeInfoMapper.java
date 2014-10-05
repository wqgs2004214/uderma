package u.derma.dao;

import java.util.List;

import u.derma.model.WeixinGoods;
import u.derma.model.WeixinPrizeInfo;
import u.derma.model.WeixinUser;


public interface WeixinPrizeInfoMapper {
	List<WeixinPrizeInfo> selectByUserid(String userid);
	int insert(WeixinPrizeInfo info);
	List<WeixinPrizeInfo> getAll();
}