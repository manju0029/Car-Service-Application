package com.manju.csa.exception;


public class CarNotFoundException extends RuntimeException {

	private String message;

	public CarNotFoundException(String message) {
		super();
		this.message = message;
	}

	//because we are getting not a set the value
	public String getMessage() {
		return message;
	}
	
}
