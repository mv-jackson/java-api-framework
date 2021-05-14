package com.bpdts.api;

import Config.FileWriter;
import com.bpdts.api.api.Users;
import com.bpdts.api.payloads.response.UsersResponseData;
import io.restassured.response.Response;
import net.sf.geographiclib.Geodesic;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import net.sf.geographiclib.GeodesicData;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.path.json.JsonPath.with;
import static org.hamcrest.MatcherAssert.assertThat;


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
    public void Test3 () throws IOException {
        // 51 deg 30 min 26 sec N
        double londonLat = 51 + (30 / 60.0) + (26 / 60.0 / 60.0);
        // 0 deg 7 min 39 sec W
        double londonLon = 0 - (7 / 60.0) - (39 / 60.0 / 60.0);
        List<UsersResponseData> qualifyingUsers = new ArrayList<>();

        Response response = Users.getUsers();
        JSONArray users = new JSONArray((response.asString()));


        for (int i = 0; i < users.length(); i++) {

            users.getJSONObject(i);
            JSONObject user = users.getJSONObject(i);
            double longitude = user.getDouble("longitude");
            double latitude = user.getDouble("latitude");
            GeodesicData result = Geodesic.WGS84.Inverse(londonLat, londonLon, latitude, longitude);

            double distanceInMeters = result.s12;
            double distanceInMiles = distanceInMeters / 1609.34;

            if (distanceInMiles <= 50)
            {

                List<JSONObject> validUsers = new ArrayList<>();
                validUsers.add(user);

                //System.console().printf(userValid.getId() + " " + userValid.getFirst_name() + " " + userValid.getLast_name()) ;

                FileWriter f = new FileWriter();
                f.WriteToFile(user,distanceInMiles);



            }
        }

        //return qualifyingUsers;
    }


}




