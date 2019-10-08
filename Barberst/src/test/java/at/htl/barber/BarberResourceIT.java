package at.htl.barber;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BarberResourceIT {

    private Client client;
    private WebTarget target;

    @Before
    public void initClient(){
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8091/barbershop");
    }

    @Test
    public void crud(){
        Response response = this.target.request().get();
        int status = response.getStatus();
        assertThat(status, is(200));
        JsonObject shop =response.readEntity(JsonObject.class);
        System.out.println("Barbershop: " + shop);
    }

}
