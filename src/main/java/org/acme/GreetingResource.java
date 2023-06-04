package org.acme;

import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @ConfigProperty(name = "username")
    String username;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/person")
    public List<Person> listAll() {
        LOG.info("List all person data");
        return Person.listAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/person/{id}")
    public Person findById(@PathParam("id") Long id) {
        LOG.info("Find a person data");
        return Person.findById(id);
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Distributed Tracing Integration with OpenTelemetry and Knative!");
        return "Distributed Tracing Integration with OpenTelemetry and Knative!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("greeting")
    public String greeting() {
        LOG.info("Welcome " + username);
        return "Welcome " + username;
    }

}
