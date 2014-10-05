package u.derma.service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import u.derma.dao.WeixinGoodsMapper;
import u.derma.dao.WeixinUserMapper;
import u.derma.model.WeixinGoods;
import u.derma.model.WeixinUser;
import u.derma.utils.Configs;
import u.derma.utils.HttpUtils;

@Service("weixinGoodsService")
public class WeixinGoodsServiceImpl implements WeixinGoodsServiceI {
	@Autowired
	private WeixinGoodsMapper weixinGoodsMapper;
	@Override
	public WeixinGoods selectByGoodsId(int prizeGoodsId) {
		return weixinGoodsMapper.selectByGoodsId(prizeGoodsId);
	}
	@Override
	public int insert(WeixinGoods goods) {
		return weixinGoodsMapper.insert(goods);
	}
	@Override
	public int deletePrizeGoodsById(int prizeGoodsId) {
		return weixinGoodsMapper.deletePrizeGoodsById(prizeGoodsId);
	}
	@Override
	public List<WeixinGoods> getAll() {
		return weixinGoodsMapper.getAll();
	}

	
}
