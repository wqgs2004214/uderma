package u.derma.service;

import java.util.List;

import u.derma.model.WeixinGoods;
import u.derma.model.WeixinUser;


public interface WeixinGoodsServiceI {

	WeixinGoods selectByGoodsId(int prizeGoodsId);
	int insert(WeixinGoods goods);
	int deletePrizeGoodsById(int prizeGoodsId);
	List<WeixinGoods> getAll();
	
}
