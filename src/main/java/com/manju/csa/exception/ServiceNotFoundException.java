package com.manju.csa.exception;

public class ServiceNotFoundException extends RuntimeException 
{
	private String message;
	
	public ServiceNotFoundException(String message)
	{
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
