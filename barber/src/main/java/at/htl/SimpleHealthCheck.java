package at.htl;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Liveness
@ApplicationScoped
public class SimpleHealthCheck implements HealthCheck {

    @Inject @RestClient
    BarbershopService service;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("GCA Server Status");

        try {
            service.getBarbershop();
            responseBuilder.up();
        }catch (Exception e){
            responseBuilder.down();
        }

        return responseBuilder.build();
    }
}
