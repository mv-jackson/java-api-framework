//package com.bpdts.api.api;
//
////import com.bpdts.api.payloads.request.AuthPayload;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//import static io.restassured.RestAssured.given;
//
//public class Auth {
//
//    public static Response postAuth(AuthPayload payload){
//        return given()
//                .contentType(ContentType.JSON)
//                .body(payload)
//                .when()
//                .post("https://restful-booker.herokuapp.com/auth");
//    }
//}
