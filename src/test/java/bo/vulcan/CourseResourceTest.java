package bo.vulcan;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class CourseResourceTest {
    @Test
    @TestSecurity(authorizationEnabled = false)
    void testHelloEndpoint() {
        given()
          .when().get("/api/course")
          .then()
             .statusCode(is(200));
    }

}