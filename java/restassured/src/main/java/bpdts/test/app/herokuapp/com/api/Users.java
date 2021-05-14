package bpdts.test.app.herokuapp.com.api;

import bpdts.test.app.herokuapp.com.payloads.request.BookingPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


//https://bpdts-test-app.herokuapp.com/city/London/users
public class Users {

    private static String baseUrl = "https://bpdts-test-app.herokuapp.com";

    public static Response getUsers(){


        Response response =
                given()
                        .header("Accept","application/json")
                        .when()
                        .get(baseUrl + "/users")
                        .then()
                        .extract()
                        .response();

        return response;

    }

    public static Response getBooking(int id, String mediaType) {
        return given().header("Accept", mediaType).get(baseUrl + "/booking/" + Integer.toString(id));
    }

    public static Response postBooking(BookingPayload payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(baseUrl + "/booking");
    }

    public static Response deleteBooking(int id, String tokenValue) {
        return given()
                .header("Cookie", "token=" + tokenValue)
                .delete(baseUrl + "/booking/" + Integer.toString(id));
    }
}
