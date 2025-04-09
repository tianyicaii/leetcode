package lintcode;

import java.util.HashMap;
import java.util.Map;

public class I0522TinyUrl2 {
    

    public class TinyUrl2 {

        final String prefix = "http://tiny.url/";
        int index = 0;
        char[] digits = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Map<String, String> long2Short = new HashMap<>();
        Map<String, String> short2Long = new HashMap<>();


        private String getNext(int idx) {
            StringBuffer s = new StringBuffer();
            while (idx != 0) {
                s.append(idx % digits.length);
                idx /= digits.length;
            }
            StringBuffer ans = new StringBuffer();
            for (int i = s.length(); i < 6; i++) {
                ans.append(digits[0]);
            }
            ans.append(s.toString());
            return ans.toString();
        }

        public String createCustom(String long_url, String key) {
            if (long2Short.containsKey(long_url)) {
                if (long2Short.get(long_url).equals(key)) return prefix + key;
                return "error";
            } else if (short2Long.containsKey(key)) return "error";
            else {
                add(long_url, key);
                return prefix + key;
            }
        }

        private void add(String longUrl, String shortUrl) {
            long2Short.put(longUrl, shortUrl);
            short2Long.put(shortUrl, longUrl);
        }

        public String longToShort(String long_url) {
            if (long2Short.containsKey(long_url)) return prefix + long2Short.get(long_url);
            do {
                String shortUrl = getNext(index++);
                if (short2Long.containsKey(shortUrl)) continue;
                add(long_url, shortUrl);
                return prefix + shortUrl;
            } while (true);

        }
    
        public String shortToLong(String short_url) {
            short_url = short_url.substring(prefix.length());
            if (short2Long.containsKey(short_url)) return short2Long.get(short_url);
            return null;
        }
    }
}
