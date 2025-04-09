/*

Geohash is a hash function that convert a location coordinate pair into a base32 string.
Check how to generate geohash on wiki: Geohash or just google it for more details.
Try http://geohash.co/.
You task is converting a (latitude, longitude) pair into a geohash string.

Example
    Given lat = 39.92816697, lng = 116.38954991 and precision = 12 which indicate how long the hash string should be.
    You should return wx4g0s8q3jf9.
    The precision is between 1 ~ 12.

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
        
        public String base2ToBase32 (String base2) {  // base2 is of length 60
                final String digits = "0123456789bcdefghjkmnpqrstuvwxyz";  // Why 32? 32 = 2 ^ 5. Why 60? 12 * 5 = 60
                StringBuilder ans = new StringBuilder();
            for (int i = 0; i < 60; i += 5) {  // five digits in binary is one digit in base 32
                    int index = Integer.parseInt(base2.substring(i, i + 5), 2);
                    ans.append(digits.charAt(index));
            }
            return ans.toString();
        }
    }   
