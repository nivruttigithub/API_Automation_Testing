package JsonServer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Comments_Automation {
    @Test
    public void createComments()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "      \"id\": \"3\",\n" +
                        "      \"body\": \"Bad comment\",\n" +
                        "      \"postId\": 3\n" +
                        "}")
                .when()
                .post("http://localhost:3000/comments");
        response.prettyPrint();
    }

    @Test
    public void ViewCommentById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/josn")
                .when()
                .get("http://localhost:3000/comments/3");
        response.prettyPrint();
    }

    @Test
    public void ViewAllComments()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/josn")
                .when()
                .get("http://localhost:3000/comments");
        response.prettyPrint();
    }

    @Test
    public void updateCommentById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "        \"id\": \"3\",\n" +
                        "        \"body\": \"Good comment\",\n" +
                        "        \"postId\": 3\n" +
                        "    }")
                .when()
                .put("http://localhost:3000/comments/3");
        response.prettyPrint();
    }

    @Test
    public void deleteCommentById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .delete("http://localhost:3000/comments/1");
        response.prettyPrint();
    }
}
