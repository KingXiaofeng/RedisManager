package com.mauersu.exception;

/**
 * 方法支持异常
 */
public class MethodNotSupportException extends RuntimeException {
	
	public MethodNotSupportException(String errormsg) {
		super(errormsg);
	}
}
