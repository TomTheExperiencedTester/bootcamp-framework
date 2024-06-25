package ergast.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.bouncycastle.math.raw.Nat.equalTo;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.notNullValue;

public class ApiCurrentLastResults {

    @Test
    public void testGetCurrentLastResults() {
        // Define the base URI of the API
        String baseUri = "https://ergast.com/api/f1/current/last/results.json";
        // Send a GET request to the API and get the response
        // Assert that the status code is 200
        given().
                baseUri(baseUri).
                when().
                get().
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void testMaxVerstappenIsRedBullRacingDriver() {
        // Define the base URI of the API
        String baseUri = "https://ergast.com/api/f1/current/last/results.json";

        // Send a GET request to the API and assert that Max Verstappen is a driver for the Red Bull Racing Team
        given()
                .baseUri(baseUri)
                .when()
                .get()
                .then()
                .assertThat()
                .body("MRData.RaceTable.Races[0].Results.find { it.Driver.driverId == 'max_verstappen' }.Constructor.name", matchesPattern("Red Bull"));
    }

    @Test
    public void testResponseIsJson() {
        // Define the base URI of the API
        String baseUri = "https://ergast.com/api/f1/current/last/results.json";

        // Send a GET request to the API and assert that the response is JSON
        given()
                .baseUri(baseUri)
                .when()
                .get()
                .then()
                .assertThat()
                .contentType("application/json");
    }
    @Test
    public void testResponseContainsRaceTable() {
        // Define the base URI of the API
        String baseUri = "https://ergast.com/api/f1/current/last/results.json";

        // Send a GET request to the API and assert that the response contains the RaceTable
        given()
                .baseUri(baseUri)
                .when()
                .get()
                .then()
                .assertThat()
                .body("MRData.RaceTable", notNullValue());
    }

    @Test
    public void testFirstRaceContainsCircuitName() {
        // Define the base URI of the API
        String baseUri = "https://ergast.com/api/f1/current/last/results.json";

        // Send a GET request to the API and assert that the first race contains the circuit name
        given()
                .baseUri(baseUri)
                .when()
                .get()
                .then()
                .assertThat()
                .body("MRData.RaceTable.Races[0].Circuit.circuitName", notNullValue());
    }

    @Test
    public void testFirstDriverOfFirstRaceHasDriverId() {
        // Define the base URI of the API
        String baseUri = "https://ergast.com/api/f1/current/last/results.json";

        // Send a GET request to the API and assert that the first driver of the first race has a driverId
        given()
                .baseUri(baseUri)
                .when()
                .get()
                .then()
                .assertThat()
                .body("MRData.RaceTable.Races[0].Results[0].Driver.driverId", notNullValue());
    }
    @Test
    public void getToken(){
        String token = given()
                .baseUri("https://vgp-shop.polteq-testing.com/wp-json/jwt-auth/v1/token")
                .when()
                .formParam("username", "trainee4@polteq.com")
                .and().formParam("password", "1AmAPolteqTrainee4")
                .and().post()
                .then()
                .log().everything().extract().body().jsonPath().getString("token");
        System.out.println(token);
    }
}
