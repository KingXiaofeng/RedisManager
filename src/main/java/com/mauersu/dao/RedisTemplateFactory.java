package com.mauersu.dao;

import com.mauersu.exception.RedisConnectionException;
import com.mauersu.util.RedisApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis模板工厂
 */
@Service
public class RedisTemplateFactory extends RedisApplication {

	private static Logger log = LoggerFactory.getLogger(RedisTemplateFactory.class);

	/**
	 * 获取redis模板
	 * @param redisName
	 * @return
	 */
	protected static RedisTemplate<String, Object> getRedisTemplate(String redisName) {
		RedisTemplate<String, Object> redisTemplate = redisTemplatesMap.get(redisName);
		if(redisTemplate==null) {
			log.error("redisTemplate==null" + ". had not connected to " + redisName + " this redis server now.");
			throw new RedisConnectionException("had not connected to " + redisName + " this redis server now.");
		}
		return redisTemplate;
	}

	/**
	 * 验证
	 * @param dbIndex
	 */
	private static void validate(int dbIndex) {
		if(0> dbIndex || dbIndex> 15) {
			log.error("0> dbIndex || dbIndex> 15" + "redis dbIndex is invalid : " + dbIndex);
			throw new RedisConnectionException("redis dbIndex is invalid : " + dbIndex);
		}
		return ;
	}
	
}
