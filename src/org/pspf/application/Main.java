package org.pspf.application;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.pspf.exceptions.mappers.DataNotFoundExceptionMapper;
import org.pspf.exceptions.mappers.ThrowableExceptionMapper;
import org.pspf.exceptions.mappers.UnAuthorizedExceptionMapper;
import org.pspf.exceptions.mappers.UserNotFoundExceptionMapper;
import org.pspf.filters.CorsFilter;
import org.pspf.resources.PspfResources;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * @author Shalitha Mihirnga
 *
 */
@ApplicationPath("api")
public class Main extends Application {
	Logger LOGGER = Logger.getLogger(Main.class.getName());

	public Main() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("PSPF API");
		beanConfig.setVersion("1.0");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080/pspf_api/");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("org.pspf.resources");
		beanConfig.setScan(true);
		
	}

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> resources = new HashSet<Class<?>>();

		resources.add(PspfResources.class);
		
		resources.add(CorsFilter.class);
		
		/*
		 * exception mappers
		 */
		resources.add(ThrowableExceptionMapper.class);
		resources.add(DataNotFoundExceptionMapper.class);
		resources.add(UnAuthorizedExceptionMapper.class);
		resources.add(UserNotFoundExceptionMapper.class);
		

		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return resources;
	}

}
