package u.derma.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Configs {
	private static final Logger log = Logger.getLogger(Configs.class);
	private static Configs INSTANCE = new Configs();
	private Configuration config;
	private String accessToken;
	private int expires;
	
	private Configs() {
		try {
			config = new PropertiesConfiguration("config.properties");
			
			Executor exec = Executors.newSingleThreadExecutor();
			exec.execute(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							requestAccessToken();
							if (Configs.getInstance().getAccessToken() != null) {
								log.debug("成功获取accessToken = " + Configs.getInstance().getAccessToken()
										+ ",token过期时间:" + Configs.getInstance().getExpires());
								Thread.sleep((Configs.getInstance().getExpires() - 200) * 1000);
								Thread.sleep(5000);
							} else {
								Thread.sleep(60 * 1000);
							}
						} catch (InterruptedException e) {
							log.debug("", e);
						}
					}

				}
			});
			
			
		} catch (ConfigurationException e) {
			log.debug("配置文件装载失败", e);
		}
	}
	
	/**
	 * 请求新的access_token
	 */
	public void requestAccessToken() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Configs.getInstance().getString("AppId")+"&secret=" + Configs.getInstance().getString("AppSecret");
		String result = HttpUtils.request(url);
		log.debug("获取access_token response:" + result);
		JSONObject jsonObj = (JSONObject) JSON.parse(result);
		if (jsonObj.getString("errcode") == null) {
			Configs.getInstance().setAccessToken(jsonObj.getString("access_token"));
			Configs.getInstance().setExpires(jsonObj.getIntValue("expires_in"));
		}
	}
	
	public static Configs getInstance() {
		return INSTANCE;
	}
	
	public String getString(String key) {
		return config.getString(key);
	}
	
	public int getInt(String key) {
		return config.getInt(key);
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpires() {
		return expires;
	}
	public void setExpires(int expires) {
		this.expires = expires;
	}
	
}
