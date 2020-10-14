package com.pixeon.challenge.domain.exception;

public class BusinessException  extends RuntimeException{
	private static final long serialVersionUID = -809319978862266568L;
	
	public BusinessException(String message) {
		super(message);
	}

}
