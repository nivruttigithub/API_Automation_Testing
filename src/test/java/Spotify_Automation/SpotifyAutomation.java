package Spotify_Automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyAutomation {

    String token = "BQBTBJbx5rLKdb6wiQLjBdhiRzudn5sRwdxctCniGS4uA6Aga4uabPiQSbqaJS8wL1OV3V6kKO2jTRZgq2jwerC6D9SXjKSb3MqQpUQ9-H_HX13WsqFACKHXCufsf0jqNpwjws-QC2PgroWykcDXGe1i9anPETX8zfnDoOcsr64CeTplrIRBcet97V8nCnyJymwU8FGuqMh_JdyUciautP7NFPF2PzMSNRYpEqJh8_ZauTqemmdXLp3kebsUy8pDQsff-xCNj1z49hGyDLmqre4WFfWmIPNsMhUnApUwalM5aLbVWE2ckw6PIToytQ5cT6sd71L7jFLWIw";
    String playList_Id = "2jdTwiNfzbOEh1nviJvSrm";
    String artistsId = "4YRxDV8wJFPHPTeXepOstw";
    String userId = "3172r6vnl45gfmwc657d6cdbbj2u";
    @Test
    public void token(){

        Response response = given()
                .queryParam("response_type","token")
                .queryParam("client_id","7217866850164a85a1f30e01a74cb418")
                .queryParam("scope","user-read-private,user-read-email,user-top-read,playlist-modify-public,playlist-modify-private,user-follow-read,user-follow-modify,user-follow-read,user-library-read,user-library-modify,user-read-playback-position,user-library-read,user-read-playback-state,user-modify-playback-state,user-read-currently-playing,user-read-recently-played,playlist-modify-public,playlist-modify-private,playlist-read-private,playlist-read-collaborative,ugc-image-upload")
                .queryParam("redirect_uri","http://localhost:3000/")
                .queryParam("state","state")
                .when()
                .post("https://accounts.spotify.com/authorize");
        response.prettyPrint();
    }
    @Test
    public void createUser()
    {
        String Token ="BQDHz6gWIgVtl_KmbI_lx6Q5pMKAbTCIvKFxiC8Vv38g6RuGZ9Zu1EvAl8wLezQ4SmT5KjnsLnuxqYDI3ojQe0TA-1kcvIsmNU8DyjY8PEQjU1VnnKFdPQ4GuUA17vitpxp9AwiU1BNa6pj4dYFwUgQFWoA3ZaOYuiZubC686OfevA5Xt7TZHK1vMjNAkU9do8V-jLCMJiW7hPFekoZaRtfuHLFUHHY6ZtAFxmqfWilQKZsQ5U7a3GKjC1HJmpVUhcZlXxECrqjW5jWFZHTUf2DuMvb1w_nfwsHfJJC_X_Ebdp2cfvnv6QEpLdS-P_hqVZyDYlAmJufjuw";
        Response response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me");
            response.prettyPeek();
    }

    @Test
    public void GetCurrentUser(){
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me");
        res.prettyPrint();
    }

    @Test
    public void GetUserProfile(){
        Response response =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/users/3172r6vnl45gfmwc657d6cdbbj2u");
        response.prettyPeek();
    }

    @Test
    public void followPlayList(){
        Response response =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/"+playList_Id+"/followers");
        response.prettyPeek();
    }

    @Test
    public void unfollowPlayList(){
        Response response =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("https://api.spotify.com/v1/playlists/"+playList_Id+"/followers");
        response.prettyPeek();
    }

    @Test
    public void followArtists(){
        Response response =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"string\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/following?type=artist&ids=4YRxDV8wJFPHPTeXepOstw");
        response.prettyPeek();
    }

    @Test
    public void unfollowArtists(){
        Response response =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6");
        response.prettyPeek();
    }

    @Test
    public void saveAlbums()
    {
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"0wOjd8Sns9DMtCDH5cIvoo\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/albums");
        res.prettyPrint();
    }

    @Test
    public void getAlbums()
    {
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("\n" +
                        "https://api.spotify.com/v1/albums/4d9tHXsAc0g2gnOJBt33pr");
        res.prettyPrint();
    }

    @Test
    public void getSeveralAlbums()
    {
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/albums?ids=4d9tHXsAc0g2gnOJBt33pr,5tenzflqCjH0SmgvkUULlp");
        res.prettyPrint();
    }

    @Test
    public void checkUserSavedAlbums()
    {
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/albums/contains?ids=5tenzflqCjH0SmgvkUULlp");
        res.prettyPrint();
    }

    @Test
    public void removeUsersSavedAlbums()
    {
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("https://api.spotify.com/v1/me/albums?ids=4d9tHXsAc0g2gnOJBt33pr");
        res.prettyPrint();
    }

    @Test
    public void getArtist()
    {
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/artists/4YRxDV8wJFPHPTeXepOstw");
        res.prettyPrint();
    }

    @Test
    public void getSeveralArtist()
    {
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/artists?ids=4YRxDV8wJFPHPTeXepOstw,0oOet2f43PA68X5RxKobEy");
        res.prettyPrint();
    }

    @Test
    public void getArtistsAlbum()
    {
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("\n" +
                        "https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums");
        res.prettyPrint();
    }

    @Test
    public void getArtistsTopTrack()
    {
        Response res =  given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks");
        res.prettyPrint();
    }

    @Test
    public void createPlaylist()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body("{\n" +
                        "    \"name\": \"spiritual Songs\",\n" +
                        "    \"description\": \"Om Namah Shivay..\",\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/3172r6vnl45gfmwc657d6cdbbj2u/playlists");
        response.prettyPrint();
    }

    @Test
    public void getPlaylist()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/playlists/1RhovJGqPGjLJhSDQFvLEt");
        response.prettyPrint();
    }

    @Test
    public void getUsersPlaylist()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/users/3172r6vnl45gfmwc657d6cdbbj2u/playlists");
        response.prettyPrint();
    }

    @Test
    public void addItemsToPlaylist()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .body(" {\"uris\": [\"spotify:track:02wxkywbuS1ovmUtDn88cb\",\"spotify:track:7HnA75M3apr0nqOyTkSG2L\"]}")
                .post("https://api.spotify.com/v1/playlists/1RhovJGqPGjLJhSDQFvLEt/tracks\n");
        response.prettyPrint();
    }
    @Test
    public void updatePlaylistItems()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .body(" {\n" +
                        "    \"range_start\": 2,\n" +
                        "    \"insert_before\": 3,\n" +
                        "    \"range_length\": 2\n" +
                        "}")
                .put("https://api.spotify.com/v1/playlists/1RhovJGqPGjLJhSDQFvLEt/tracks");
        response.prettyPrint();
    }

    @Test
    public void removePlaylistItems()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .body(" { \"tracks\": [{ \"uri\": \"spotify:track:5XsoDbDt98b0FkFLOhsJuS\" }] }")
                .delete("https://api.spotify.com/v1/playlists/1RhovJGqPGjLJhSDQFvLEt/tracks");
        response.prettyPrint();

    }

    @Test
    public void saveShows()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .put("https://api.spotify.com/v1/me/shows?ids=11VjrLJfoiNvgjjqov4RWh");
        response.prettyPrint();
    }

    @Test
    public void getShows()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/shows/3BOmtsKabnfZg1baCNX0f4");
        response.prettyPrint();
    }


    @Test
    public void removeUsersSavedShows()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete("https://api.spotify.com/v1/me/shows?ids=64mInfKzmJIbuTvcnhRgfW");
        response.prettyPrint();
    }

    @Test
    public void saveTrackforCurrentUser()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"string\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/tracks/4ChG6wj5teda2lZ5B0flgD");
        response.prettyPrint();
    }

    @Test
    public void getTrack()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/tracks/7ABCuDLEY2GyAwnGcqkmt2");
        response.prettyPrint();
    }

    @Test
    public void getSeveralTrack()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/tracks?ids=7ABCuDLEY2GyAwnGcqkmt2,4ChG6wj5teda2lZ5B0flgD");
        response.prettyPrint();
    }

    @Test
    public void removeSavedUsersTrack()
    {
        Response response = RestAssured
                .given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .when()
                .delete("https://api.spotify.com/v1/me/tracks/7ABCuDLEY2GyAwnGcqkmt2");
        response.prettyPrint();
    }

}
