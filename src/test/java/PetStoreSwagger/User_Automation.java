package PetStoreSwagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class User_Automation {
    //Create User
    @Test
    public void createUser()
    {
       Response response = RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"nivrutti\",\n" +
                        "  \"firstName\": \"Nivrutti\",\n" +
                        "  \"lastName\": \"Wagh\",\n" +
                        "  \"email\": \"nivruttiwagh18@gmail.com\",\n" +
                        "  \"password\": \"Nivrutti@9307\",\n" +
                        "  \"phone\": \"9307929546\",\n" +
                        "  \"userStatus\": 1\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
       response.prettyPrint();
    }
    // Get User (Login)
    @Test
    public void userLogin()
    {
        Response response = RestAssured.given()
                .header("accept","application/json")
                .queryParam("us","nivrutti")
                .queryParam("pass","Nivrutti@9307")

//                .pathParam("us","nivrutti")
//                .pathParam("pass","Nivrutti@9307")
                .when()
                .get("https://petstore.swagger.io/v2/user/login");
//                .get("https://petstore.swagger.io/v2/user/login?username={us}&password={pass}");
        response.prettyPrint();
    }
    @Test
    public void logoutUser() {
        Response response = RestAssured.given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        response.prettyPrint();
    }
    //Update User
   @Test
    public void updateUser() {
        Response response = RestAssured.given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"rohit\",\n" +
                        "  \"firstName\": \"Rohit\",\n" +
                        "  \"lastName\": \"Wagh\",\n" +
                        "  \"email\": \"rohitw45@gmail.com\",\n" +
                        "  \"password\": \"Rohit@45\",\n" +
                        "  \"phone\": \"9309925631\",\n" +
                        "  \"userStatus\": 1\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/rohit");
        response.prettyPrint();
    }

//Get User by userName
    @Test
    public void getUserByUserName()
    {
        Response response= RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/rohit");
        response.prettyPrint();
    }

    // Delete User
    @Test
    public void deleteUser()
    {
       Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/rohit");
       response.prettyPrint();
    }
}
