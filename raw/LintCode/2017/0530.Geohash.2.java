/*

This is a followup question for Geohash.
Convert a Geohash string to latitude and longitude.
Try http://geohash.co/.
Check how to generate geohash on wiki: Geohash or just google it for more details.

Example
    Given "wx4g0s", return lat = 39.92706299 and lng = 116.39465332.
    Return double[2], first double is latitude and second double is longitude.

*/


    public class GeoHash {

        public String encode (double latitude, double longitude, int precision) {
                String longitudeBinary = getBinary(longitude, -180, 180);  // range of longitude is 360, left right full circle
                String latitudeBinary = getBinary(latitude, -90, 90);  // range of latitude is 180, up to down North to South
            StringBuilder binary = new StringBuilder();
            for (int i = 0; i < 30; ++i) {
                    binary.append(longitudeBinary.charAt(i));  // take pairwise instead of appending, give more and more precision in both dimension
                    binary.append(latitudeBinary.charAt(i));
            }
            return base2ToBase32(binary.toString()).substring(0, precision);
        }

        // map double value in range [left, right] to an binary integer inside range [0, 2^31 - 1]
        // each digits from left to right in the mapped integer divide the (remaining) interval in halves
        public String getBinary (double value, double left, double right) {
                StringBuilder b = new StringBuilder();
            for (int i = 0; i < 30; ++i) {  // 30 bits integer, need total 60 for both longitude + latitude
                double mid = (left + right) / 2.0;
                if (value > mid) {
                    left = mid;
                    b.append("1");
                } else {
                    right = mid;
                    b.append("0");
                }
            }
            return b.toString();
        }
        
        final String digits = "0123456789bcdefghjkmnpqrstuvwxyz";  // Why 32? 32 = 2 ^ 5. Why 60? 12 * 5 = 60
        
        public String base2ToBase32 (String base2) {  // base2 is of length 60
                StringBuilder ans = new StringBuilder();
            for (int i = 0; i < 60; i += 5) {  // five digits in binary is one digit in base 32
                    int index = Integer.parseInt(base2.substring(i, i + 5), 2);
                    ans.append(digits.charAt(index));
            }
            return ans.toString();
        }
        
        
        public double[] decode(String geohash) {
            
            int[] mask = {16, 8, 4, 2, 1};
            double[] longitudeInterval = {-180, 180};  // reduce this interval to the closest coordinate
            double[] latitudeInterval = {-90, 90};
            boolean isLongitude = true;

            for (int i = 0; i < geohash.length(); ++i) {
                int index = digits.indexOf(geohash.charAt(i));
                for (int j = 0; j < 5; ++j) {  // for each of the five bits of index, take index as binary number
                    if (isLongitude) refine_interval(longitudeInterval, index, mask[j]);
                    else refine_interval(latitudeInterval, index, mask[j]);
                    isLongitude = !isLongitude;
                }
            }
            
            double[] location = { (latitudeInterval[0] + latitudeInterval[1]) / 2.0, (longitudeInterval[0] + longitudeInterval[1]) / 2.0 };
            return location;
        }

        public void refine_interval(double[] interval, int val, int mask) {
                double mid = (interval[0] + interval[1]) / 2.0;
            if ((val & mask) > 0) interval[0] = mid;  // move left
            else interval[1] = mid;
        }

    }   
