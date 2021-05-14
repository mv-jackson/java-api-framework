package com.bpdts.api;

import com.bpdts.api.api.Users;
import com.bpdts.api.payloads.response.UsersResponseData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.sf.geographiclib.Geodesic;
import org.junit.jupiter.api.Test;
import net.sf.geographiclib.GeodesicData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


class ApiTest {


    //1.Write a Test for API that returns the number of users
    @Test
    void getTheNumberOfUsers(){

        Response response = Users.getUsers();
        int size = response.jsonPath().getList("id").size();

        System.out.print(size);
        //assertThat(size,greaterThan(1));

    }

    // 2.Write a Test for API that returns the number of users who live in London
    @Test
    public void getLondonUsers(){

        Users user = new Users("London");
        Response response = user.getLondonUsers();
        int size = response.jsonPath().getList("id").size();
        System.out.print(size);

    }

    // 3.Write a Test that looks for users within 50 miles
    // radius of London and output the result to console/text file.
    @Test
    public void Test3 (){
        // 51 deg 30 min 26 sec N
        double londonLat = 51 + (30 / 60.0) + (26 / 60.0 / 60.0);
        // 0 deg 7 min 39 sec W
        double londonLon = 0 - (7 / 60.0) - (39 / 60.0 / 60.0);

        Response response = Users.getUsers();



        for (int i = 0; i < response.jsonPath().getList("id").size(); i++)
        {
            String json = response.asString();
            JsonPath jp = new JsonPath(json);

            UsersResponseData user = new UsersResponseData(response.jsonPath().getList("id").get(i));

            response.jsonPath().getList("id").get(i);
            // ...
            int latitude = userLondon.getInt("latitude");
            int longitude = userLondon.getInt("longitude");

            double userLat = convertToDecimalDegrees(latitude);
            double userLon = convertToDecimalDegrees(longitude);

            GeodesicData result = Geodesic.WGS84.Inverse(londonLat, londonLon, userLat, userLon);

            double distanceInMeters = result.s12;
            double distanceInMiles = distanceInMeters / 1609.34;

            if (distanceInMiles <= 50)
            {
                User user = new User();
                user.setId(id);
                user.setFirstName(first_name);
                // etc.

                qualifyingUsers.add(user);
            }
        }

        return qualifyingUsers;
    }




    }

}
