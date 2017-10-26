package org.pspf.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.pspf.exceptions.UnAuthorizedException;
import org.pspf.helpers.TokenManager;

import io.jsonwebtoken.Claims;

@Provider
public class AuthFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		
		/**
		 * users must be authenticated in order to go beyond
		 * the authentication resource
		 */
		if(!requestContext.getUriInfo().getPath().equals("auth")
				&& !requestContext.getMethod().equals("OPTIONS")
				) {
			String token = requestContext.getHeaders().getFirst("Authorization");
			
			if(token == null) {
				new UnAuthorizedException();
			}
			
			Claims claims = new TokenManager().isValidToken(token);
			String username = (String) claims.get(TokenManager.USERNAME);
			String role = (String) claims.get(TokenManager.ROLE);
			int pensionPointId = (int) claims.get(TokenManager.PENSION_POINT);
			
			requestContext.getHeaders().add(TokenManager.TOKEN_DATA, username + "||" + role + "||" + pensionPointId);
		}
	}
	
}
