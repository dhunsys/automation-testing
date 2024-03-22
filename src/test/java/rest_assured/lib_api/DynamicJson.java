package rest_assured.lib_api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import rest_assured.Payload;

import java.io.*;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test
    public void addBook(){
        RestAssured.baseURI="http://216.10.245.166";
        RequestSpecification requestSpecification=given().log().all();
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(Payload.addBook());
        Response response= requestSpecification.post(": Library/Addbook.php");
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.body().asString());
        JsonPath jsonPath=JsonPath.from(response.body().asString());
System.out.println("book id="+jsonPath.getString("ID"));

    }
    @Test
    public void addBookWithDynamicValues(){
        RestAssured.baseURI="http://216.10.245.166";
        RequestSpecification requestSpecification=given().log().all();
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(Payload.addBook("isbn7654","aisle453"));
        Response response= requestSpecification.post(": Library/Addbook.php");
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.body().asString());
        JsonPath jsonPath=JsonPath.from(response.body().asString());
        System.out.println("book id="+jsonPath.getString("ID"));

    }

    @Test(dataProvider ="BooksData")
    public void addBookWithMultipleDynamicValues(String isbn,String aisle) throws IOException {
        PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
        RestAssured.baseURI="http://216.10.245.166";
        RequestSpecification requestSpecification=given().log().all();
        requestSpecification.filter(RequestLoggingFilter.logRequestTo(log));
        requestSpecification.filter(ResponseLoggingFilter.logResponseTo(log));
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(Payload.addBook(isbn,aisle));
        Response response= requestSpecification.post(": Library/Addbook.php");

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.body().asString());
        JsonPath jsonPath=JsonPath.from(response.body().asString());
        System.out.println("book id="+jsonPath.getString("ID"));

    }

    @Test()
    public void addBookWithStaticFilePayload() throws IOException {
        RestAssured.baseURI="http://216.10.245.166";
        RequestSpecification requestSpecification=given().log().all();
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(Files.readFile(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\addBook.json")));
        Response response= requestSpecification.post(": Library/Addbook.php");
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.body().asString());
        JsonPath jsonPath=JsonPath.from(response.body().asString());
        System.out.println("book id="+jsonPath.getString("ID"));

    }


    @DataProvider(name="BooksData")
    public Object[][]  getData(){
        return new Object[][] {{"ojfwty","9363"},{"cwetee","4253"}, {"okmfet","533"} };
    }


}
