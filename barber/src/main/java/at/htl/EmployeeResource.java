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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("emp")
public class EmployeeResource {

    @Inject
    @RestClient
    EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 2)
    @Counted(name = "employee_called", description = "Amount of requests")
    @Timed(name = "timer", description = "How long this task takes to perform", unit = MetricUnits.MILLISECONDS)
    @Fallback(fallbackMethod = "fallback")
    public Response getAll(){
        return Response.ok().entity(employeeService.getEmployee()).build();
    }

    public Response fallback(){
        return Response.ok().entity(Json.createObjectBuilder().add("Message", "This is the fallback response").build()).build();
    }

}
