package at.htl;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("barbershop")
@RegisterRestClient
public interface BarbershopService {

    @GET
    @Produces("application/json")
    List<Barbershop> getBarbershop();
}

