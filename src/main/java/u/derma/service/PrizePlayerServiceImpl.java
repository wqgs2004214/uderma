package u.derma.service;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import u.derma.model.WeixinGoods;

@Service("prizePlayerService")
public class PrizePlayerServiceImpl implements PrizePlayerServiceI {
	private final Logger log = Logger.getLogger(PrizePlayerServiceImpl.class);
	@Autowired
	private WeixinGoodsServiceI weixinGoodsService;
	
	//奖品数组
	private List<WeixinGoods> prizeArray;
	
	
	@Override
	public synchronized WeixinGoods play() {
		if (prizeArray == null) {
			prizeArray = weixinGoodsService.getAll();
		}
		Collections.shuffle(prizeArray);
		log.debug("奖品信息:" + JSON.toJSONString(prizeArray));
		int id = get_round();
		WeixinGoods resultGoods = null;
		for (WeixinGoods goods:prizeArray) {
			if (id == goods.getPrizeGoodsId()) {
				int goodsNumber = goods.getPrizeGoodsNumber();
				if (goodsNumber > 0) {
					goods.setPrizeGoodsNumber(goodsNumber - 1);
					resultGoods = goods;
				}
			}
		}
		return resultGoods;
	}
	
	/**
	 * 随机算法
	 * @return
	 */
	private int get_round() {
		int goodsId = 0;
		int count = 0;
		for (WeixinGoods goods : prizeArray) {
			count += goods.getPrizeGoodsNumber();
		}
		
		//随机获取的号码
		for (WeixinGoods goods : prizeArray) {
			int goodsNumber = goods.getPrizeGoodsNumber();
			int n = Math.round(count);
			if (n <= goodsNumber) {
				goodsId = goods.getPrizeGoodsId();
				break;
			} else {
				count -= goodsNumber;
			}
		}
		return goodsId;
	}

}
