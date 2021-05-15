package com.bpdts.api.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

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
}