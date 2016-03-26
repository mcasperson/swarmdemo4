package com.matthewcasperson.swarmdemo;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Our REST interface
 */
@Path("/")
@Api(value = "/", description = "Sample REST API")
public class MyRest {
    @GET
    @Path("/helloWorld")
    public String helloWorld() {
        return "Hello World";
    }
}
