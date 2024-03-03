package rest_assured.oauth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class OAuthTest {

    @Test(description = "grant_type=client credential")
    public final void getAccessTokenByClientIdClientSecret() {
        RequestSpecification req = RestAssured.given();
        String res = req.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                .formParams("grant_type", "client_credentials")

                .formParams("scope", "trust")
                .log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
        //get token from response
        JsonPath jsonPath = new JsonPath(res);

        String accessToken = jsonPath.getString("access_token");

        System.out.println(accessToken);
        //now get course detail using access token
        Response r2 = RestAssured.given()

                .queryParams("access_token", accessToken)
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails");
        System.out.println(r2.getBody().asString());
    }
}
