package rest_assured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MyFirstRestAssuredTest {
    @Test
    public void nonBDDStyleGetRequest() {

        // Create a request specification
        RequestSpecification request = given();

        //Adding URI
        request.baseUri("https://restful-booker.herokuapp.com/booking");

        // Calling GET method on URI. After hitting we get Response
        Response response = request.get();

        // Let's print response body.
        String resString = response.asString();
        System.out.println("Response Details : " + resString);


    }

    /**
     * BDD Style script:
     * <p>
     * Syntax:
     * Given().
     * param("x", "y").
     * header("z", "w").
     * when(). Method().
     * Then().
     * statusCode(XXX).
     * body("x, ”y", equalTo("z"));
     * Where,
     * Given() ‘Given’ keyword, lets you set a background, here, you pass the request headers, query and path param, body, cookies. This is optional if these items are not needed in the request
     * When() ‘when’ keyword marks the premise of your scenario. For example, ‘when’ you get/post/put something, do something else.
     * Method() Substitute this with any of the CRUD operations(get/post/put/delete)
     * Then() Your assert and matcher conditions go here
     * Let us code this with similar to the structure learned earlier of given, when and then;
     * given(). -> No headers required, no query or path param.
     * when(). -> No specific condition setup
     * get()-> above url
     * then(). -> No specific assertions required
     * log(). all() -> Once all the response is fetched, log response, headers, essentially everything that the request returns to you.
     */
    @Test
    public void BDDStyleGetRequest() {

        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/booking")
                .then()
                .log()
                .all();
    }
}
