package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Hello from RESTEasy Reactive");
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hola")
    public String hola() {
        LOG.info("Hola Daniel");
        return "Hola Daniel";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting")
    public String hogreetingla() {
        LOG.info("Welcome Quarkus and Opentelmetry!");
        return "Welcome Quarkus and Opentelmetry!";
    }

}