package com.spring.trx.service.impl;

public class InvalidInsuranceAmountException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidInsuranceAmountException(String cause) {
		super(cause);
	}
}
