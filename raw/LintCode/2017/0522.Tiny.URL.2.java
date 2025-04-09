
/*

As a follow up for Tiny URL, we are going to support custom tiny url, so that user can create their own tiny url.

Notice
Custom url may have more than 6 characters in path.

Example
    createCustom("http://www.lintcode.com/", "lccode")
    >> http://tiny.url/lccode
    createCustom("http://www.lintcode.com/", "lc")
    >> error
    longToShort("http://www.lintcode.com/problem/")
    >> http://tiny.url/1Ab38c   // this is just an example, you can have you own 6 characters.
    shortToLong("http://tiny.url/lccode")
    >> http://www.lintcode.com/
    shortToLong("http://tiny.url/1Ab38c")
    >> http://www.lintcode.com/problem/
    shortToLong("http://tiny.url/1Ab38d")
    >> null

*/


    public class TinyUrl2 {

        private HashMap<String, String> short2Long = new HashMap<String, String>();
        private HashMap<String, String> long2Short = new HashMap<String, String>();

        private final String prefix = "http://tiny.url/";
        private long index = 0;
        public String digits = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        private char base10ToBase62 (long d) {
                return digits.charAt((int) d);
        }
        
        private String getNextShortURL () {
                long base10 = index++;
                String shortURL = "";
                while (base10 != 0) {
                    shortURL = base10ToBase62(base10 % 62) + shortURL;
                    base10 /= 62;
                }
                while (shortURL.length() != 6) {
                    shortURL = "0" + shortURL;
                }
                return shortURL;
        }       
        
        String createCustom (String longURL, String shortURL) {
                if (long2Short.containsKey(longURL) && long2Short.get(longURL).equals(shortURL)) return prefix + shortURL;
                if (long2Short.containsKey(longURL) || short2Long.containsKey(shortURL)) return "error";
                long2Short.put(longURL, shortURL);
                short2Long.put(shortURL, longURL);
            return prefix + shortURL;
        }

        public String longToShort (String longURL) {
            if (long2Short.containsKey(longURL)) {
                return prefix + long2Short.get(longURL);
            }
            while (true) {
                    String shortURL = getNextShortURL();
                    if (short2Long.containsKey(shortURL)) continue;
                        long2Short.put(longURL, shortURL);
                        short2Long.put(shortURL, longURL);
                        return prefix + shortURL;
            }
        }

        public String shortToLong (String shortURL) {
                shortURL = shortURL.substring(prefix.length());
            if (short2Long.containsKey(shortURL))
                return short2Long.get(shortURL);
            else return null;
        }
    }
