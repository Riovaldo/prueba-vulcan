package bo.vulcan;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class StudentResourceTest {
    @Test
    @TestSecurity(authorizationEnabled = false)
    void testHelloEndpoint() {
        given()
          .when().get("/api/student")
          .then()
             .statusCode(is(200));
    }

}