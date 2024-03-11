package rest_assured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * In Below URL we noticed that the URL is long and less readable:
 *
 * "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1"
 *
 * if you look closely, you will notice that 3 query parameters are being used which are:
 * 1. Customer_ID
 * 2. Password
 * 3. Account_No
 *
 * Rest Assured, helps us pass every part(query, path, header param) separately, making the code more readable and easy to maintain. Also, we can parameterize the data from an external file as required.
 *
 * For using query param, we go back to our definition of the syntax and see that all of them are passed as a part of given.
 */
public class QueryParameters {
    @Test
    public void getResponseBody() {
        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .log().all()
                .when().get("http://demo.guru99.com/V4/sinkministatement.php")
                .then().log().body();
    }

}
