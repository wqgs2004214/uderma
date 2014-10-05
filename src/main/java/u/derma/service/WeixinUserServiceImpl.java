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

import u.derma.dao.WeixinUserMapper;
import u.derma.model.WeixinUser;
import u.derma.utils.Configs;
import u.derma.utils.HttpUtils;

@Service("weixinUserService")
public class WeixinUserServiceImpl implements WeixinUserServiceI {
	private final Logger log = Logger.getLogger(WeixinUserServiceImpl.class);
	@Autowired
	private WeixinUserMapper weixinUserMapper;
	private String accessToken;
	private int expires;

	public WeixinUserServiceImpl() {
		Executor exec = Executors.newSingleThreadExecutor();
		exec.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						request();
						if (accessToken != null) {
							log.debug("成功获取accessToken = " + accessToken
									+ ",token过期时间:" + expires);
							Thread.sleep((expires - 200) * 1000);
						} else {
							Thread.sleep(60 * 1000);
						}
					} catch (InterruptedException e) {
						log.debug("", e);
					}
				}

			}
		});
	}

	private void request() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Configs.getInstance().getString("AppId")+"&secret=" + Configs.getInstance().getString("AppSecret");
		String result = HttpUtils.request(url);
		JSONObject jsonObj = (JSONObject) JSON.parse(result);
		if (jsonObj.getString("errcode") == null) {
			accessToken = jsonObj.getString("access_token");
			expires = jsonObj.getIntValue("expires_in");
		}
	}

	@Override
	public List<WeixinUser> getAll() {
		return weixinUserMapper.getAll();
	}

	@Override
	public int addLotteryNumber(String userid) {
		return weixinUserMapper.addLotteryNumber(userid);
	}

	public int minusLotteryNumber(String userid) {
		return weixinUserMapper.minusLotteryNumber(userid);
	}

	@Override
	public int insert(WeixinUser user) {
		return weixinUserMapper.insert(user);
	}

	@Override
	public WeixinUser selectByUserid(String userid) {
		return weixinUserMapper.selectByUserid(userid);
	}

	@Override
	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public int getExpires() {
		return expires;
	}

}
