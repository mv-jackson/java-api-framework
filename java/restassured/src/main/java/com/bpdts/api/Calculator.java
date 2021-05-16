package com.bpdts.api;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import org.json.JSONObject;

public class Calculator {

    // 51 deg 30 min 26 sec N
    private static double londonLat = 51 + (30 / 60.0) + (26 / 60.0 / 60.0);
    // 0 deg 7 min 39 sec W
    private static double londonLon = 0 - (7 / 60.0) - (39 / 60.0 / 60.0);

    public Calculator(){

    }
        public static double getDistance(JSONObject user){

            double longitude = user.getDouble("longitude");
            double latitude = user.getDouble("latitude");
            GeodesicData result = Geodesic.WGS84.Inverse(londonLat, londonLon, latitude, longitude);
            double distanceInMeters = result.s12;
            double distanceInMiles = distanceInMeters / 1609.34;

            return distanceInMiles;

        }
}
