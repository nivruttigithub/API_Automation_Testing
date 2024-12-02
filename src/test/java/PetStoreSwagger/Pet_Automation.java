package PetStoreSwagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Pet_Automation {
    //Create Pet
    @Test
    public void addPet()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(
                        "{\"id\": 3,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 3,\n" +
                        "    \"name\": \"Doggy\"\n" +
                        "  },\n" +
                        "  \"name\": \"Tommy\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 3,\n" +
                        "      \"name\": \"Friendly\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
    }

    //Get Pet ById
    @Test
    public void getPetById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/3");
        response.prettyPrint();
    }
    @Test
    public void getPetByStatus()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();
    }

    @Test
    public void updatePet()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
    }
    @Test
    public void deletePetById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/1");
        response.prettyPrint();
    }
}
