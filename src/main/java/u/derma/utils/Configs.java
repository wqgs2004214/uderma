package u.derma.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

public class Configs {
	private static final Logger log = Logger.getLogger(Configs.class);
	private static Configs INSTANCE = new Configs();
	private Configuration config;
	private Configs() {
		try {
			config = new PropertiesConfiguration("config.properties");
		} catch (ConfigurationException e) {
			log.debug("配置文件装载失败", e);
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
}
