package org.pspf.exceptions;

import javax.ws.rs.WebApplicationException;

public class UnAuthorizedException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3899851476049292084L;
	
	public UnAuthorizedException(String message) {
		super(message);
	}
	
	public UnAuthorizedException() {
		super("User is not authenticated");
	}
	
}
