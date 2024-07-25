package com.kboutakhamt.bankaccount.application.common.exception;

public class IllegalAmountException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public IllegalAmountException(String message) {
		super(message);
	}

}
