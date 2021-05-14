package bpdts.test.app.herokuapp.com;

import bpdts.test.app.herokuapp.com.api.Users;
import bpdts.test.app.herokuapp.com.payloads.request.AuthPayload;
import bpdts.test.app.herokuapp.com.payloads.response.AuthResponse;
import io.restassured.response.Response;
import org.junit.Test;
import


//import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


public class ApiTest {
    //1.Write a Test for API that returns the number of users
    public void getBookingShouldReturn200(){

        Response response = Users.getUsers();
        int size = response.jsonPath().getList("id").size();

    }

    // 2.Write a Test for API that returns the number of users who live in London
   // @Test
//    public void getBookingIdShouldReturn200(){
//        Response response = Users..getBooking(1, "application/json");
//
//        Response response = delete.getBooking(1, "application/json");
//
//        assertThat(response.getStatusCode(), is(200));
//    }

    // 3.Write a Test that looks for users within 50 miles
    // radius of London and output the result to console/text file.
//    @Test
//    public void getBookingIdWithBadAcceptShouldReturn418(){
//        Response response = delete.getBooking(1, "text/plain");
//
//        assertThat(response.getStatusCode(), is(418));
//    }



//    @Test
//    public void postBookingReturns200(){
//        BookingPayload payload = new BookingPayload.BookingPayloadBuilder()
//                .setFirstname("Mary")
//                .setLastname("White")
//                .setTotalprice(200)
//                .setDepositpaid(true)
//                .setCheckin(new Date())
//                .setCheckout(new Date())
//                .setAdditionalneeds("None")
//                .build();
//
//        Response response = Booking.postBooking(payload);
//
//        assertThat(response.getStatusCode(), is(200));
//    }

//    @Ignore
//    public void deleteBookingReturns201(){
//        BookingPayload payload = new BookingPayload.BookingPayloadBuilder()
//                .setFirstname("Mary")
//                .setLastname("White")
//                .setTotalprice(200)
//                .setDepositpaid(true)
//                .setCheckin(new Date())
//                .setCheckout(new Date())
//                .setAdditionalneeds("None")
//                .build();
//
//        BookingResponse createdBookingResponse = Booking.postBooking(payload).as(BookingResponse.class);
//
//        AuthPayload authPayload = new AuthPayload.AuthPayloadBuilder()
//                .setUsername("admin")
//                .setPassword("password123")
//                .build();
//
//        AuthResponse authResponse = Auth.postAuth(authPayload).as(AuthResponse.class);
//
//        Response deleteResponse = Booking.deleteBooking(
//                createdBookingResponse.getBookingid(),
//                authResponse.getToken());
//
//        assertThat(deleteResponse.getStatusCode(), is(201));
//    }

}
