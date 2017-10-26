package org.pspf.filters.params;

import javax.ws.rs.HeaderParam;

import org.pspf.helpers.TokenManager;

public class AuthMeta {
	
	//format "{username||role}"
	@HeaderParam(TokenManager.TOKEN_DATA)
	private String param;

	public AuthMeta() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return this.param.split("\\|\\|")[0];
	}

	public String getRole() {
		return this.param.split("\\|\\|")[1];
	}
	
	public int getPensionPoint() {
		return Integer.valueOf(this.param.split("\\|\\|")[2]);
	}
}
