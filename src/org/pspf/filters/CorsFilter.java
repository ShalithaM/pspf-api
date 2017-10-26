package org.pspf.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * CORS Filter
 * @author Dinesh Liyanage
 *
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "X-PINGOTHER, Content-Type, User-Name, Password, Authorization");
		responseContext.getHeaders().add("Access-Control-Max-Age", "86400");

	}

}
