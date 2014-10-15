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

import u.derma.dao.WeixinShareViewHistoryMapper;
import u.derma.dao.WeixinUserMapper;
import u.derma.model.WeixinShareViewHistory;
import u.derma.model.WeixinUser;
import u.derma.utils.Configs;
import u.derma.utils.HttpUtils;

@Service("weixinUserService")
public class WeixinUserServiceImpl implements WeixinUserServiceI {
	private final Logger log = Logger.getLogger(WeixinUserServiceImpl.class);
	@Autowired
	private WeixinUserMapper weixinUserMapper;
	
	@Autowired
	private WeixinShareViewHistoryMapper weixinShareViewHistoryMapper;

	@Override
	public List<WeixinUser> getAll() {
		return weixinUserMapper.getAll();
	}

	@Override
	public int addLotteryNumber(String openid) {
		return weixinUserMapper.addLotteryNumber(openid);
	}

	public int minusLotteryNumber(String openid) {
		return weixinUserMapper.minusLotteryNumber(openid);
	}

	@Override
	public int insert(WeixinUser user) {
		return weixinUserMapper.insert(user);
	}

	@Override
	public WeixinUser selectByOpenid(String openid) {
		return weixinUserMapper.selectByOpenid(openid);
	}

	@Override
	public WeixinShareViewHistory select(WeixinShareViewHistory history) {
		return weixinShareViewHistoryMapper.select(history);
	}

	@Override
	public int insertShareViewHistory(WeixinShareViewHistory history) {
		return weixinShareViewHistoryMapper.insert(history);
	}

	
	

}
