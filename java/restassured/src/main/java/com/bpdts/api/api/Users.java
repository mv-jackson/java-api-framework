package com.bpdts.api.api;

//import com.bpdts.api.payloads.request.AuthPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import io.restassured.http.*;


public class Users {

        private static String baseUrl = "https://bpdts-test-app.herokuapp.com";
        private static  String City;

    public Users(String city){

        City = city;

    }
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
    public static Response getLondonUsers(){
        //curl -X GET "https://bpdts-test-app.herokuapp.com/city/London/users" -H "accept: application/json"


        Response response =
                given()
                        .header("Accept","application/json")
                        .when()
                        .get(baseUrl + "/city/" + City + "/users")
                        .then()
                        .extract()
                        .response();

        return response;

    }


//        public static Response getBooking(int id, String mediaType) {
//            return given().header("Accept", mediaType).get(baseUrl + "/booking/" + Integer.toString(id));
//        }
//
//        public static Response postBooking(BookingPayload payload) {
//            return given()
//                    .contentType(ContentType.JSON)
//                    .body(payload)
//                    .when()
//                    .post(baseUrl + "/booking");
//        }
//
//        public static Response deleteBooking(int id, String tokenValue) {
//            return given()
//                    .header("Cookie", "token=" + tokenValue)
//                    .delete(baseUrl + "/booking/" + Integer.toString(id));
//        }
//    }
}
