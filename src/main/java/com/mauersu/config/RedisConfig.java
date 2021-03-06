package com.mauersu.config;

import com.mauersu.exception.RedisInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载redis配置文件
 */
public class RedisConfig {

	private static Logger log = LoggerFactory.getLogger(RedisConfig.class);
	
	private final static String DEFAULT_REDIS_PROPERTIES_FILEPATH = RedisConfig.class.getClassLoader().getResource("/").getPath() + "/redis.properties";
	
	/*@Bean(name="redisProperties")*/
	//not-in-use now
	public Properties propertiesConfig() {
		Properties prop = new Properties();
		File file = new File(DEFAULT_REDIS_PROPERTIES_FILEPATH);
		InputStream is = null;
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			is = new FileInputStream(file);
			prop.load(is);
		} catch (IOException e) {
			log.error("cannot load properties of file name: " + DEFAULT_REDIS_PROPERTIES_FILEPATH + " " +  e.toString());
			throw new RedisInitException(e);
		} finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("close io have exception" +  e.toString());
					throw new RedisInitException(e);
				}
			}
		}
		return prop;
	}
	
	
	
}
