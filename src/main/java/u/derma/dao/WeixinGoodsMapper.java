package u.derma.dao;

import java.util.List;

import u.derma.model.WeixinGoods;
import u.derma.model.WeixinUser;


public interface WeixinGoodsMapper {
	WeixinGoods selectByGoodsId(int prizeGoodsId);
	int insert(WeixinGoods goods);
	int deletePrizeGoodsById(int prizeGoodsId);
	List<WeixinGoods> getAll();
}