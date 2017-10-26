package org.pspf.exceptions;

import javax.ws.rs.WebApplicationException;

public class LorryNotFoundException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6304129198986759431L;

	public LorryNotFoundException() {
		super("Lorry not found");
	}
	
}
