package com.mauersu.exception;

/**
 * redis连接异常
 */
public class RedisConnectionException extends RuntimeException {

	public RedisConnectionException(String errormsg) {
		super(errormsg);
	}

}
