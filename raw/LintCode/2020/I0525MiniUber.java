package lintcode;

import java.util.HashMap;
import java.util.Map;

class Trip {
    public int id; // trip's id, primary key
    public int driver_id, rider_id; // foreign key
    public double lat, lng; // pick up location
    public Trip(int rider_id, double lat, double lng) {}
}

class Helper {
    public static double get_distance(double lat1, double lng1, double lat2, double lng2) { return 0; }
}



class MiniUber {

    class Location {
        double lat;
        double lng;
        Location(double lat, double lng) { this.lat = lat; this.lng = lng; }
    }

    Map<Integer, Trip> driver2Trip = new HashMap<>();
    Map<Integer, Location> freeDrivers = new HashMap<>();

    public MiniUber() {}


    public Trip report(int driver_id, double lat, double lng) {
        if (driver2Trip.containsKey(driver_id)) {
            Trip t = driver2Trip.get(driver_id);
            // t.lat = lat;
            // t.lng = lng;
            return t;
        }
        if (!freeDrivers.containsKey(driver_id)) {
            freeDrivers.put(driver_id, new Location(lat, lng));
            return null;
        }
        Location l = freeDrivers.get(driver_id);
        l.lat = lat;
        l.lng = lng;
        return null;
    }

    public Trip request(int rider_id, double lat, double lng) {
        Trip t = new Trip(rider_id, lat, lng);
        Double distance = null;
        for (Map.Entry<Integer, Location> e : freeDrivers.entrySet()) {
            int driver = e.getKey();
            Location l = e.getValue();
            double d = Helper.get_distance(l.lat, l.lng, lat, lng);
            if (distance == null || d < distance) {
                distance = d;
                t.driver_id = driver;
            }
        }
        if (distance != null) {
            freeDrivers.remove(t.driver_id);
            driver2Trip.put(t.driver_id, t);
        }
        return t;
    }
}

public class I0525MiniUber {}
