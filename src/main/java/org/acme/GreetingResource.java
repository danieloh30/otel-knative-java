package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @ConfigProperty(name = "username")
    String username;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Hello from RESTEasy Reactive");
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("greeting")
    public String greeting() {
        LOG.info("Welcome KCD Italy 2023, " + username);
        return "Welcome KCD Italy 2023, " + username;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("otel")
    public String hola() {
        LOG.info("Distributed Tracing integrating with Quarkus, Knative and Otel!!");
        return "Distributed Tracing integrating with Quarkus, Knative and Otel!!";
    }

}
