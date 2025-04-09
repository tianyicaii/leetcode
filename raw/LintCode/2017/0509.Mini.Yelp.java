/*
Design a simple yelp system. Support the following features:
    Add a restaurant with name and location.
    Remove a restaurant with id.
    Search the nearby restaurants by given location.
    A location is represented by latitude and longitude, both in double. A Location class is given in code.

Nearby is defined by distance smaller than k Km .
Restaurant class is already provided and you can directly call Restaurant.create() to create a new object.
Also, a Helper class is provided to calculate the distance between two location, use Helper.get_distance(location1, location2).
A GeoHash class is provided to convert a location to a string.
Try GeoHash.encode(location) to convert location to a geohash string and GeoHash.decode(string) to convert a string to location.

Notice: Learn about GeoHash http://www.lintcode.com/en/help/geohash/

Example
    addRestauraunt("Lint Cafe", 10.4999999, 11.599999)  // return 1
    addRestauraunt("Code Cafe", 10.4999999, 11.512109)  // return 2
    neighbors(10.5, 11.6, 6.7)                          // return ["Lint Cafe"]
    removeRestauraunt(1) 
    neighbors(10.5, 9.6, 6.7)                           // return []

// The distance between location(10.5, 11.6) and "Lint Code" is 0.0001099 km
// The distance between location(10.5, 11.6) and "Code Code" is 9.6120978 km

*/

    public static class MiniYelp {

        static class Location {
            public double latitude, longitude;
            public static Location create (double lati, double longi) { return null; }
        }

        static class Restaurant {
            public int id;
            public String name;
            public Location location;
            public static Restaurant create(String name, Location location) { return null; }
        }

        static class Helper {
            public static double get_distance (Location location1, Location location2) { return 0; }
        }

        static class GeoHash {
            public static String encode(Location location) { return null; }
            public static Location decode(String hashcode) { return null; }
        }


        class Node implements Comparable <Node>{
            public double distance;  // need to sort the list to be returned on distance
            public Restaurant restaurant;
            public Node(double d, Restaurant r) {
                distance = d;
                restaurant = r;
            }
            public int compareTo (Node other) {
                    if (this.distance > other.distance) return 1;
                    if (this.distance < other.distance) return -1;
                    return 0;
            }
        }

        public SortedMap<String, Restaurant> location2Restarant = new TreeMap<>();
        public Map<Integer, String> restaurant2Location = new HashMap<>();
        
        public int addRestaurant (String name, Location location) {
            Restaurant restaurant = Restaurant.create(name, location);
            String hashcode = GeoHash.encode(location) + "." + restaurant.id;  // in case two restaurant at the same location => get unique key
            restaurant2Location.put(restaurant.id, hashcode);
            location2Restarant.put(hashcode, restaurant);
            return restaurant.id;
        }

        public void removeRestaurant (int restaurant_id) {
            if (!restaurant2Location.containsKey(restaurant_id)) return;  // just in case
            String location = restaurant2Location.get(restaurant_id);
            restaurant2Location.remove(restaurant_id);
            location2Restarant.remove(location);
        }

        public List<String> neighbors (Location location, double k) {

            int len = getLength(k);
            String hashcode = GeoHash.encode(location);
            hashcode = hashcode.substring(0, len);  // length of prefix in geo-hash need to match

            List<Node> nearby = new ArrayList<Node>();

            for (Map.Entry<String, Restaurant> e : location2Restarant.subMap(hashcode, (hashcode + "{")).entrySet()) {  // '{': any invalid character has ASCII larger than last valid digit is fine.
                double distance = Helper.get_distance(location, e.getValue().location);
                if (distance <= k)
                    nearby.add(new Node(distance, e.getValue()));  // keep distance to sort result
            }
            Collections.sort(nearby);
            List<String> ans = new ArrayList<String>();
            for (Node r : nearby)
                ans.add(r.restaurant.name);
            return ans;
        }


        int getLength (double k) {  // get the length of prefix of geo-hash that has to match
            double[] sizes = {2500, 630, 78, 20, 2.4, 0.61, 0.076, 0.01911, 0.00478, 0.0005971, 0.0001492, 0.0000186};  // each digit corresponds to how much distance in KM
            for (int i = 0; i < sizes.length; ++i)
                if (k  > sizes[i])
                    return i;
            return sizes.length;
        }
    }
