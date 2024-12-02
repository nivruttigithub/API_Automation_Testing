package PetStoreSwagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Store_Automation {
    @Test
    public void createStore()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 3,\n" +
                        "  \"petId\": 3,\n" +
                        "  \"quantity\": 3,\n" +
                        "  \"shipDate\": \"2024-11-27T05:49:58.771Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
    }

    @Test
    public void getStoreById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/3");
              response.prettyPrint();
    }

    @Test
    public void getStoreByStatus()
    {
       Response response = RestAssured
               .given()
               .header("accept","application/json")
               .when()
               .get("https://petstore.swagger.io/v2/store/inventory");
       response.prettyPrint();
    }

    @Test
    public void deleteStoreById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/3");
        response.prettyPrint();
    }

}
