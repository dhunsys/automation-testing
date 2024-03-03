package rest_assured.jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest_assured.util.JsonToMap;

import java.io.File;

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
        //return something like : JSESSIONID=6E3487971234567896704A9EB4AE501F
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

    /**
     * Key: AP->Jira project key. e.g. project name : apitest(AP)
     */
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

    @Test()
    public final void addAttachmentToAnIssue(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.basePath("/rest/auth/1/session");
        requestSpecification.body("{ \"username\": \"jira\", \"password\": \"jira\" }");
        SessionFilter sessionFilter=new SessionFilter();
        requestSpecification.filter(sessionFilter).log().all();
        Response response=requestSpecification.post();//"/rest/auth/1/session");
        System.out.println("response body: "+response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200);

        //Attachment
        RequestSpecification attachmentRequest=RestAssured.given();
        attachmentRequest.header("X-Atlassian-Token","no-check")
                .header("Content-Type","multipart/form-data")
                .filter(sessionFilter)
                .pathParam("key","10100").
                multiPart("file",new File("C:\\MsPrograms\\gitrepo\\SeleniumTestNGPractice\\src\\main\\resources\\jiraAttachment.txt")).log().all().expect().response();
       Response ar= attachmentRequest.post("/rest/api/2/issue/{key}/attachments");
        Assert.assertEquals(ar.getStatusCode(),200);


    }

    /**
     * relaxedHTTPSValidation : to by pass https security
     */
    @Test()
    public final void getIssue(){
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.baseUri("http://localhost:8080");
        requestSpecification.relaxedHTTPSValidation().header("Content-Type","application/json");
        requestSpecification.basePath("/rest/auth/1/session");
        requestSpecification.body("{ \"username\": \"jira\", \"password\": \"jira\" }");
        SessionFilter sessionFilter=new SessionFilter();
        requestSpecification.filter(sessionFilter).log().all();
        Response response=requestSpecification.post();//"/rest/auth/1/session");
        System.out.println("response body: "+response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200);

        //get issue
        RequestSpecification issueRequest=RestAssured.given();
        issueRequest
                .filter(sessionFilter)
                .pathParam("key","10100").log().all();
        Response ar= issueRequest.get(" /rest/api/2/issue/{key}");
        System.out.println("Response="+ar.getBody().asString());
        Assert.assertEquals(ar.getStatusCode(),200);
        //Number of fields in issue
        JsonPath jsonPath=JsonPath.from(ar.getBody().asString());
        //number of comments in the issue
        System.out.println("Total comments: "+jsonPath.getInt("fields.comment.comments.size()"));
        int totC=jsonPath.getInt("fields.comment.comments.size()");
        //display id of each comment and comment text under body of comment
        for(int i=0;i<totC;i++){
            System.out.println("Comment id is: "+jsonPath.getString("fields.comment.comments["+i+"].id"));
            System.out.println("Comment text: "+jsonPath.getString("fields.comment.comments["+i+"].body"));
        }
    }
}
