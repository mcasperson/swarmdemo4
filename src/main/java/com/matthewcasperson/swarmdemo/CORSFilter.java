package com.matthewcasperson.swarmdemo;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * A CORS filter that will allow remote access to our API and Swagger documentation.
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {
    public void filter(ContainerRequestContext paramContainerRequestContext,
                       ContainerResponseContext paramContainerResponseContext)
            throws IOException {
        paramContainerResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        paramContainerResponseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        paramContainerResponseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        paramContainerResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        paramContainerResponseContext.getHeaders().add("Access-Control-Max-Age", "1209600");
    }
}
