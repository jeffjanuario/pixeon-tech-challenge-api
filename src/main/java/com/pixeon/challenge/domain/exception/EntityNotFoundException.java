package com.pixeon.challenge.domain.exception;

public class EntityNotFoundException  extends BusinessException{
	private static final long serialVersionUID = 8492072993050194434L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
