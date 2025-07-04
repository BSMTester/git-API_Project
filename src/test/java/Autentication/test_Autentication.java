package Autentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class test_Autentication {

    @Test
    public void basicAutontication(){
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification regSpec =  RestAssured.given().auth().basic("postman","password");
        Response response = regSpec.get("/basic-auth");
        String statusLine = response.getStatusLine();
        System.out.println("Status Line: "+statusLine);
    }
}
