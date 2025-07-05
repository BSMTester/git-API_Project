package APICurdOperations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestAPICurdOperations {

    @Test(priority = 1)
    public void getOperation(){
        RestAssured.baseURI = "http://localhost:3000/posts";
        RequestSpecification reqspec = RestAssured.given();
        Response response = reqspec.get();
        int ResCode = response.getStatusCode();
        System.out.println("Status Code: "+ResCode);
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println(response.getBody().asPrettyString());
    }

    @Test (priority = 2)
    public void PostOperation(){
        String payLoad = " {\n" +
                "    \"title\": \"Bhagavath geeta\",\n" +
                "    \"author\": \"krishna\"\n" +
                "  }";
        RestAssured.baseURI = "http://localhost:3000/posts";
        RequestSpecification reqSPec = RestAssured.given();
        reqSPec.header("Content-Type", "application/json");
        reqSPec.body(payLoad);
        Response response = reqSPec.post();
       System.out.println("Status Line: "+response.getStatusLine());
    }

    @Test(priority =3)
    public void putOperation(){
        String payLoad = " {\n" +
                "    \"title\": \"Ramayanam\",\n" +
                "    \"author\": \"Rama\"\n" +
                "  }";
        RestAssured.baseURI = "http://localhost:3000/posts/4";
        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.contentType("application/json");
        reqSpec.body(payLoad);
        Response response = reqSpec.put();
        System.out.println(response.asPrettyString());
    }

    @Test(priority = 4)
    public void patchOperatopm(){
        String payLoad = " {\n" +
                "    \"author\": \"Valmiki\"\n" +
                 "  }";
        RestAssured.baseURI = "http://localhost:3000/posts/4";
        RequestSpecification reqspec = RestAssured.given();
        reqspec.contentType("application/json");
        reqspec.body(payLoad);
        Response response = reqspec.patch();
        System.out.println("status Line: "+response.getStatusLine());
        response.prettyPrint();
    }

    @Test(priority = 5)
    public void deleteOperation(){
        RestAssured.baseURI = "http://localhost:3000/posts/10";
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.delete();
        System.out.println("status Line: "+response.getStatusLine());
    }
}
