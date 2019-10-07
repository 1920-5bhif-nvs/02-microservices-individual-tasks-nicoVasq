package at.htl;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api")
public class BarbershopResource {

    @Inject
    @RestClient
    BarbershopService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 5)
    @Fallback(fallbackMethod = "fallback")
    @Counted(name = "Barbershop_called")
    @Timed(name = "timer", description = "How long this task takes to perform", unit = MetricUnits.MILLISECONDS)
    public Response get(){
         return  Response.ok().entity(service.getBarbershop()).build();
    }

    public Response fallback(){
        return Response.ok().entity(Json.createArrayBuilder().build()).build();
    }
}
