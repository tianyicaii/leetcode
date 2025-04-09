/*

Parse a html page, extract the Urls in it.
Hint: use regex to parse html.

Example
    Given the following html page:

    <html>
        <body>
            <div>
                <a href="http://www.google.com" class="text-lg">Google</a>
                <a href="http://www.facebook.com" style="display:none">Facebook</a>
            </div>
            <div>
                <a href="https://www.linkedin.com">Linkedin</a>
                <a href = "http://github.io">LintCode</a>
            </div>
        </body>
    </html>

    You should return the Urls in it:
    [
      "http://www.google.com",
      "http://www.facebook.com",
      "https://www.linkedin.com",
      "http://github.io"
    ]

*/


import java.util.regex.*;

public class HtmlParser {
    private static final String HTML_HREF_TAG_PATTERN =  "\\s*(?i)href\\s*=\\s*(\"|')+([^\"'>\\s]*)";

    public List<String> parseUrls (String content) {
        
        List<String> ans = new ArrayList<String>();
        Pattern pattern = Pattern.compile(HTML_HREF_TAG_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        
        while (matcher.find()) {
            String url = matcher.group(2);
            if (url.length() == 0 || url.startsWith("#")) continue;
            else ans.add(url);
        }
        return ans;
    }
} 
