
/*

Given a long url, make it shorter. To make it simpler, let's ignore the domain name.

You should implement two methods:
    longToShort(url). Convert a long url to a short url.
    shortToLong(url). Convert a short url to a long url starts with http://tiny.url/.
You can design any shorten algorithm, the judge only cares about two things:

The short key's length should equal to 6 (without domain and slash). And the acceptable characters are [a-zA-Z0-9]. For example: abcD9E
No two long urls mapping to the same short url and no two short urls mapping to the same long url.

Example
    Given url = http://www.lintcode.com/faq/?id=10, run the following code (or something similar):
    short_url = longToShort(url) // may return http://tiny.url/abcD9E
    long_url = shortToLong(short_url) // return http://www.lintcode.com/faq/?id=10
    The short_url you return should be unique short url and start with http://tiny.url/ and 6 acceptable characters.
    For example "http://tiny.url/abcD9E" or something else.

*/


    public class TinyUrl {
        
        private Map<String, String> long2Short = new HashMap<>();
        private Map<String, String> short2Long = new HashMap<>();
                
        public String longToShort (String url) {  // add a new mapping
            if (long2Short.containsKey(url)) {  // keep mapping unique
                return long2Short.get(url);
            }
            
            while (true) {
                String shortURL = generateShortURL();  // generate next unique url
                if (!short2Long.containsKey(shortURL)) {
                    short2Long.put(shortURL, url);
                    long2Short.put(url, shortURL);
                    return shortURL;
                }
            }
        }

        public String shortToLong (String url) {
            if (!short2Long.containsKey(url)) return null;
            return short2Long.get(url);
        }

        private String generateShortURL() {
            String allowedChars = 
                "0123456789" +
                "abcdefghijklmnopqrstuvwxyz" + 
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            
            Random rand = new Random();
            String shortURL = "http://tiny.url/";
            for (int i = 0; i < 6; i++) {  // randomly pick until find one.
                int index = rand.nextInt(62);
                shortURL += allowedChars.charAt(index);
            }
            
            return shortURL;
        }
    }


// base 62
    public class TinyUrl {
        
        public static int GLOBAL_ID = 0;  // in base 10, easier to increase, save space
        public String prefix = "http://tiny.url/";
        public String digits = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private HashMap<Integer, String> id2url = new HashMap<Integer, String>();
        private HashMap<String, Integer> url2id = new HashMap<String, Integer>();

        public String longToShort (String longURL) {
            if (url2id.containsKey(longURL)) {  // already mapped
                return prefix + idToShortKey(url2id.get(longURL));
            }
            
            GLOBAL_ID ++;
            url2id.put(longURL, GLOBAL_ID);
            id2url.put(GLOBAL_ID, longURL);
            return prefix + idToShortKey(GLOBAL_ID);
        }
        
        public String shortToLong (String shortURL) {
            shortURL = shortURL.substring(prefix.length());  // remove common prefix
            int id = shortKeytoID(shortURL);
            return id2url.get(id);
        }

        private int shortKeytoID (String shortURL) {  // base 62 to base 0
            int id = 0;
            for (int i = 0; i < shortURL.length(); ++i) {
                id = id * 62 + base62ToBase10(shortURL.charAt(i));
            }
            return id;
        }

        private String idToShortKey (int id) {  // base 10 to base 62, with zero padded
            String shortURL = "";
            while (id > 0) {
                    shortURL = base10ToBase62(id % 62) + shortURL;  // right to left
                id = id / 62;
            }
            while (shortURL.length() < 6) {  // pad with leading zeros
                    shortURL = "0" + shortURL;
            }
            return shortURL;
        }
        
        private int base62ToBase10 (char c) {
            if (c >= '0' && c <= '9') return c - '0';
            if (c >= 'a' && c <= 'z') return c - 'a' + 10;
            return c - 'A' + 36;
        }
        private char base10ToBase62 (int d) {
                return digits.charAt(d);
        }
    }
