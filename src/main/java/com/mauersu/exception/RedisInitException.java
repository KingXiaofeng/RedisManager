package com.mauersu.exception;

/**
 * redis初始化异常
 */
public class RedisInitException extends RuntimeException {

	public RedisInitException(Exception e) {
		super(e);
	}

	public RedisInitException(String msg, Throwable e1) {
		super(msg, e1);
	}
	
}
