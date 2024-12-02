package JsonServer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Profile_Automation {

    @Test
    public void createProfile()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "      \"id\": \"102\",\n" +
                        "      \"name\": \"UI/UX Developer\"\n" +
                        "    }")
                .when()
                .post("http://localhost:3000/profile");
        response.prettyPrint();
    }

    @Test
    public void ViewProfileById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .get("http://localhost:3000/profile/100");
        response.prettyPrint();
    }

    @Test
    public void ViewAllProfile()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .get("http://localhost:3000/profile");
        response.prettyPrint();
    }

    @Test
    public void updateProfileById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .body("{\n" +
                        "      \"id\": \"7791\",\n" +
                        "      \"name\": \"PLSQL Developer\"\n" +
                        "}")
                .when()
                .put("http://localhost:3000/profile/7791");
        response.prettyPrint();
    }

    @Test
    public void deleteProfileById()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .when()
                .delete("http://localhost:3000/profile/7791");
        response.prettyPrint();
    }
}
