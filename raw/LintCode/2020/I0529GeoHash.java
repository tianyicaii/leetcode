package lintcode;

public class I0529GeoHash {
    


    final String DIGITS = "0123456789bcdefghjkmnpqrstuvwxyz";
    final int DIGIT_WIDTH = 5;  // 1 digits equals 5 bits
    final int BINARY_LENGTH = 60;
    final int GEO_LENGTH = 12;
    final double LONGITUDE_MIN = -180;
    final double LONGITUDE_MAX = 180;
    final double LATITUDE_MIN = -90;
    final double LATITUDE_MAX = 90;


    String getBinary(double min, double max, double x) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < BINARY_LENGTH/2; i++) {
            double mid = min + (max - min) / 2;
            if (x > mid) {
                ans.append('1');
                min = mid;
            } else {
                ans.append('0');
                max = mid;
            }
        }
        return ans.toString();
    }

    String binaryToGeo(String binary) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < BINARY_LENGTH; i += 5) {
            int index = Integer.parseInt(binary.substring(i, i+5), 2);
            ans.append(DIGITS.charAt(index));
        }
        return ans.toString();
    }

    public String encode(double latitude, double longitude, int precision) {
        String lng = getBinary(LONGITUDE_MIN, LONGITUDE_MAX, longitude);
        String lat = getBinary(LATITUDE_MIN, LATITUDE_MAX, latitude);
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < BINARY_LENGTH/2; i++) {
            binary.append(lng.charAt(i));
            binary.append(lat.charAt(i));
        }
        return binaryToGeo(binary.toString()).substring(0, precision);
    }

    String geoToBinary(String geo) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < geo.length(); i++) {
            int index = DIGITS.indexOf(geo.charAt(i));
            String binaryIndex = Integer.toBinaryString(index);
            String paddedZero = String.format("%5s", binaryIndex).replace(' ', '0');
            ans.append(paddedZero);
        }
        return ans.toString();
    }

    double[] getRange(String binary, double min, double max) {
        for (int i = 0; i < binary.length(); i++) {
            double mid = min + (max - min) / 2.0;
            char c = binary.charAt(i);
            if (c == '1') min = mid;
            else max = mid;
        }
        return new double [] {min, max};
    }

    public double[] decode(String geohash) {
        String binary = geoToBinary(geohash);
        StringBuilder lng = new StringBuilder();
        StringBuilder lat = new StringBuilder();
        for (int i = 0, isLng = 1; i < binary.length(); i++) {
            if (isLng == 1) lng.append(binary.charAt(i));
            else lat.append(binary.charAt(i));
            isLng = 1-isLng;
        }
        double[] lngRange = getRange(lng.toString(), LONGITUDE_MIN, LONGITUDE_MAX);
        double[] latRange = getRange(lat.toString(), LATITUDE_MIN, LATITUDE_MAX);

        return new double[] {
                (latRange[0] + latRange[1])/2.0,
                (lngRange[0] + lngRange[1])/2.0
        };
    }
}
