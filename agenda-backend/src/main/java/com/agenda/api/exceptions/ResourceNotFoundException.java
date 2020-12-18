package com.agenda.api.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L; 
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
