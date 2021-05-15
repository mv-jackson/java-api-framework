package com.bpdts.api;

import com.bpdts.api.api.Calculator;
import com.bpdts.api.api.FileWriter;
import com.bpdts.api.api.Users;
import com.bpdts.api.payloads.response.UsersResponseData;
import io.restassured.response.Response;
import net.sf.geographiclib.Geodesic;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import net.sf.geographiclib.GeodesicData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ApiTest {

    // 1.Write a Test for API that returns the number of users
    @Test
    void getTheNumberOfUsers(){

        Response response = Users.getUsers();
        int size = response.jsonPath().getList("id").size();

        System.out.print(size);
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
    public void getUsersWithin50Miles () throws IOException {
        // 51 deg 30 min 26 sec N
        double londonLat = 51 + (30 / 60.0) + (26 / 60.0 / 60.0);
        // 0 deg 7 min 39 sec W
        double londonLon = 0 - (7 / 60.0) - (39 / 60.0 / 60.0);
        List<UsersResponseData> qualifyingUsers = new ArrayList<>();

        Response response = Users.getUsers();
        JSONArray users = new JSONArray((response.asString()));

        for (int i = 0; i < users.length(); i++) {

            JSONObject user = users.getJSONObject(i);
            double distanceInMiles = Calculator.getDistance(user);

            if (distanceInMiles <= 50)
            { 
                List<JSONObject> validUsers = new ArrayList<>();
                validUsers.add(user);
                FileWriter f = new FileWriter();
                f.WriteToFile(user,distanceInMiles);
            }
        }
    }
}




