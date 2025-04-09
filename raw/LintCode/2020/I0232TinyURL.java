package lintcode;

import java.util.HashMap;
import java.util.Map;

public class I0232TinyURL {

    public class TinyUrl {

        public String longToShort(String url) {
            if (long2Short.containsKey(url)) return long2Short.get(url);
            String tiny = "http://tiny.url/" + integerToString(id++);
            long2Short.put(url, tiny);
            short2Long.put(tiny, url);
            return tiny;
        }

        public String shortToLong(String url) {
            if (!short2Long.containsKey(url)) return "";
            return short2Long.get(url);
        }

        long id = 0;
        final char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Map<String, String> long2Short = new HashMap<>();
        Map<String, String> short2Long = new HashMap<>();

        String integerToString(long id) {
            StringBuilder ans = new StringBuilder();
            while (id != 0) {
                ans.append(chars[(int)(id % chars.length)]);
                id /= chars.length;
            }
            while (ans.length() < 6) ans.append('0');
            return ans.reverse().toString();
        }
    }
}
