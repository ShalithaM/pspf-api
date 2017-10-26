package org.pspf.exceptions;

import javax.ws.rs.WebApplicationException;

public class DataNotFoundException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4337556377738999174L;

	public DataNotFoundException(String message) {
		super(message);
		System.out.println(message);
	}
	
}
