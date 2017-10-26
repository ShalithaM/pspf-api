package org.pspf.exceptions;

import javax.ws.rs.WebApplicationException;
		
public class InsertNotSuccessfulException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2264884029720211615L;

	public InsertNotSuccessfulException(String message) {
		super(message);
	}
	
	public InsertNotSuccessfulException() {
		super("Insert was not successful");
	}
	
}
