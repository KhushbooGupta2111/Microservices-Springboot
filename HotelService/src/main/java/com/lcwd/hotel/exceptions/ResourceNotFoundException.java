package com.lcwd.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException()
	{
		super("Resrouce not found");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
