package com.personal.depository.exception;

public class DepositoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public DepositoryException(String errorMessage) {
		super(errorMessage);
	}
}
