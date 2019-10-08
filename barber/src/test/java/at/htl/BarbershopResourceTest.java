package at.htl;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BarbershopResourceTest {

    @Test
    public void testBarbershopConnection() {
        given()
          .when().get("/barbershop")
          .then()
             .statusCode(200);
    }

}