/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class Location {
    public static final Location shahAlam = new Location(3.0734, 101.5184);
    public static final Location petalingJaya = new Location(3.1126, 101.6509);
    public static final Location subangJaya = new Location(3.0451, 101.5859);
    public static final Location klang = new Location(3.0432, 101.4407);
    public static final Location puchong = new Location(3.0230, 101.6174);
    public static final Location ampang = new Location(3.1547, 101.7121);
    public static final Location kajang = new Location(2.9912, 101.7879);
    public static final Location cyberjaya = new Location(2.9251, 101.6414);
    public static final Location seriKembangan = new Location(3.0132, 101.7091);
    public static final Location huluLangat = new Location(3.2229, 101.8230);
    
    private static final int earthRadius = 6371;
    private double latitude;
    private double longitude;
    
    public static final Map<String, Location> locationMap = new HashMap<>();

    static {
        locationMap.put("shah alam", shahAlam);
        locationMap.put("petaling jaya", petalingJaya);
        locationMap.put("subang jaya", subangJaya);
        locationMap.put("klang", klang);
        locationMap.put("puchong", puchong);
        locationMap.put("ampang", ampang);
        locationMap.put("kajang", kajang);
        locationMap.put("cyberjaya", cyberjaya);
        locationMap.put("seri kembangan", seriKembangan);
        locationMap.put("hulu langat", huluLangat);
    }

    
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public static double calculateDistance(Location location1, Location location2) {
        double lat1 = Math.toRadians(location1.getLatitude());
        double lon1 = Math.toRadians(location1.getLongitude());
        double lat2 = Math.toRadians(location2.getLatitude());
        double lon2 = Math.toRadians(location2.getLongitude());

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = earthRadius * c;
        
        if (distance == 0.0) {
            distance = distance + 3.0; // If the customer/runner is in the same location as the vendor, it is assumed to be within 3km
            return distance;
        } else {
            // Format the distance to two decimal places
            DecimalFormat df = new DecimalFormat("#.#");
            return Double.parseDouble(df.format(distance));
        }
    }
}

