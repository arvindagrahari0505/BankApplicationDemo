package com.capgemini.exception;

public class InsufficientOpeningBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "InsufficientOpeningBalanceException";
	}

	@Override
	public String getMessage() {
		return "Insufficient amount to open a new account";
	}
	
	

}
