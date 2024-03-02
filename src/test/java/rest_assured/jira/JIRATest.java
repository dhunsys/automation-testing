package rest_assured.jira;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest_assured.util.JsonToMap;

public class JIRATest {
    public String getSessionId(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.basePath("/rest/auth/1/session");
        requestSpecification.body("{ \"username\": \"jira\", \"password\": \"jira\" }");
        Response response=requestSpecification.post();//"/rest/auth/1/session");
        System.out.println("response body: "+response.getBody().asString());
        JsonPath jsonPath=JsonPath.from(response.getBody().asString());
        String jsessionId=jsonPath.getString("session.name");
        Assert.assertEquals(jsessionId,"JSESSIONID");
        String jsessionval=jsonPath.getString("session.value");
        Assert.assertEquals(jsessionval.length(),32);
        Assert.assertEquals(response.getStatusCode(),200);
        return jsessionId+"="+jsessionval;
    }
    @Test()
    public final void loginJira(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.basePath("/rest/auth/1/session");
        requestSpecification.body("{ \"username\": \"jira\", \"password\": \"jira\" }");
        Response response=requestSpecification.post();//"/rest/auth/1/session");
        System.out.println("response body: "+response.getBody().asString());
        JsonPath jsonPath=JsonPath.from(response.getBody().asString());
        String jsessionId=jsonPath.getString("session.name");
        Assert.assertEquals(jsessionId,"JSESSIONID");
        String jsessionval=jsonPath.getString("session.value");
        Assert.assertEquals(jsessionval.length(),32);
        Assert.assertEquals(response.getStatusCode(),200);
        }

    @Test()
    public final void createJiraIssue(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.basePath("/rest/api/2/issue");
        requestSpecification.header("Cookie",getSessionId());
        requestSpecification.body("{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"AP\"\n" +
                "        },\n" +
                "        \"summary\": \"pagination issue\",\n" +
                "\t\"description\": \"no page number\"  ,      \n" +
                "\t\"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "}\n" +
                "}");

        Response response=requestSpecification.post();
        Assert.assertEquals(response.getStatusCode(),201);
        JsonPath jsonPath=JsonPath.from(response.getBody().asString());
        System.out.println("Issue created with id: "+jsonPath.getString("id"));
    }
    @Test()
    public final void createJiraIssueUsingMap(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.basePath("/rest/api/2/issue");
        requestSpecification.header("Cookie",getSessionId());
        requestSpecification.body(JsonToMap.getJsonMap("{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"AP\"\n" +
                "        },\n" +
                "        \"summary\": \"pagination issue\",\n" +
                "\t\"description\": \"no page number\"  ,      \n" +
                "\t\"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "}\n" +
                "}"));

        Response response=requestSpecification.post();
        Assert.assertEquals(response.getStatusCode(),201);
        JsonPath jsonPath=JsonPath.from(response.getBody().asString());
        System.out.println("Issue created with id: "+jsonPath.getString("id"));
    }

    @Test()
    public final void addJiraComment(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.basePath("/rest/api/2/issue/10005/comment");
        requestSpecification.header("Cookie",getSessionId());
        requestSpecification.body("{\n" +
                "    \"body\": \"My comment by rest assured to issue 10005.\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}");
        requestSpecification.log();
        Response response=requestSpecification.post();
        Assert.assertEquals(response.getStatusCode(),201);
        JsonPath jsonPath=JsonPath.from(response.getBody().asString());
        System.out.println("Comment Added with id :"+jsonPath.getString("id"));
    }
    @Test()
    public final void updateJiraComment(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.basePath("/rest/api/2/issue/10005/comment/10003");
        requestSpecification.header("Cookie",getSessionId());
        requestSpecification.body("{\n" +
                "    \"body\": \"Updating My comment by rest assured to issue 10005.\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}");
        requestSpecification.log();
        Response response=requestSpecification.put();
        Assert.assertEquals(response.getStatusCode(),200);
        JsonPath jsonPath=JsonPath.from(response.getBody().asString());
        System.out.println("Comment updated for comment id :"+jsonPath.getString("id"));
    }
    @Test()
    public final void deleteJiraComment(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.basePath("/rest/api/2/issue/10005/comment/10002");
        requestSpecification.header("Cookie",getSessionId());

        requestSpecification.log();
        Response response=requestSpecification.delete();
        Assert.assertEquals(response.getStatusCode(),204);
        System.out.println("Comment 10002 deleted ");
    }
}