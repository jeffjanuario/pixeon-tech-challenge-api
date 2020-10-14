package com.pixeon.challenge.domain.exception;

import lombok.Getter;

public class ValidatorObjectException extends BusinessException {

	private static final long serialVersionUID = -8698659212403287944L;
	@Getter
	protected final String stackTraceString;

	public ValidatorObjectException(String msg) {
		super(msg);
		this.stackTraceString = getStackTrace(this);
	}

	protected static String getStackTrace(Exception e) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Math.min(6, e.getStackTrace().length); i++) {
			sb.append(e.getStackTrace()[i].toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
