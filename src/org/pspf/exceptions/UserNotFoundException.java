package org.pspf.exceptions;

import javax.ws.rs.WebApplicationException;

public class UserNotFoundException extends WebApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
