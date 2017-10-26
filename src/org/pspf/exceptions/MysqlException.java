package org.pspf.exceptions;

import javax.ws.rs.WebApplicationException;

public class MysqlException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MysqlException(Exception e) {
		super(e.getMessage());
	}
	
}
