package com.mauersu.exception;

/**
 * 并发异常
 */
public class ConcurrentException extends RuntimeException {

	public ConcurrentException(String msg) {
		super(msg);
	}
	
}
