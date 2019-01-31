package com.capgemini.exception;

public class InvalidAccountNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6460488240606601756L;

	@Override
	public String toString() {
		return "InvalidAccountNumberException";
	}

	@Override
	public String getMessage() {
		return "You entered a invalid account number";
	}
	
	
}
