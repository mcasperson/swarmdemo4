package com.matthewcasperson.swarmdemo;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.swagger.SwaggerArchive;

/**
 * Swarm entry point
 */
public class MyMain {
    public static void main(final String... args) throws Exception {

        // Instantiate the container
        final Container container = new Container();

        final JAXRSArchive deployment = ShrinkWrap.create( JAXRSArchive.class );
        deployment.addResource( MyApplication.class );
        deployment.addResource( MyRest.class );

        // Enable the swagger bits
        final SwaggerArchive archive = deployment.as(SwaggerArchive.class);
        // Tell swagger where our resources are
        archive.setResourcePackages("com.matthewcasperson.swarmdemo");
        archive.setTitle("Swagger Demo");

        container.start();
        container.deploy(deployment);
    }
}