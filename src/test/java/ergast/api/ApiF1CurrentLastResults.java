package ergast.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class ApiF1CurrentLastResults {

        @Test
        public void testGetCurrentLastResults() {
            // Define the base URI of the API
            String baseUri = "https://ergast.com/api/f1/current/last/results.json";
            // Send a GET request to the API and get the response
            // Assert that the status code is 200
            given().baseUri(baseUri).when().get().then().assertThat().statusCode(200);
        }
    }

