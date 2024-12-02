package JsonServer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Post_Automation {
    @Test
    public void createPost()
    {
        Response response = RestAssured.given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "      \"id\": \"1\",\n" +
                        "      \"title\": \"Backend Developer\",\n" +
                        "      \"author\": \"Rohit\"\n" +
                        "    }")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
    }

    @Test
    public void ViewPostById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/josn")
                .when()
                .get("http://localhost:3000/posts/3");
        response.prettyPrint();
    }
    @Test
    public void ViewAllPost()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/josn")
                .when()
                .get("http://localhost:3000/posts");
        response.prettyPrint();
    }

    @Test
    public void updatePostById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "        \"id\": \"1\",\n" +
                        "        \"title\": \"Frontend Developer\",\n" +
                        "        \"author\": \"Virat\"\n" +
                        "}")
                .when()
                .put("http://localhost:3000/posts/1");
        response.prettyPrint();
    }

    @Test
    public void deletePostById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .delete("http://localhost:3000/posts/1");
        response.prettyPrint();
    }
}
