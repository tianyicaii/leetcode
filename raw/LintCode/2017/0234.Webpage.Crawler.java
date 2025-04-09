/*

http://www.lintcode.com/en/problem/webpage-crawler/#

Implement a webpage Crawler to crawl webpages of http://www.wikipedia.org/.
To simplify the question, let's use url instead of the the webpage content.

Your crawler should:
    Call HtmlHelper.parseUrls(url) to get all urls from a webpage of given url.
    Only crawl the webpage of wikipedia.
    Do not crawl the same webpage twice.
    Start from the homepage of wikipedia: http://www.wikipedia.org/
Notice
    You need do it with multithreading.
    You can use up to 3 threads
    Have you met this question in a real interview? Yes
Example
    Given
        "http://www.wikipedia.org/": ["http://www.wikipedia.org/help/"]
        "http://www.wikipedia.org/help/": []
    Return
        ["http://www.wikipedia.org/", "http://www.wikipedia.org/help/"]

    Given:
        "http://www.wikipedia.org/": ["http://www.wikipedia.org/help/"]
        "http://www.wikipedia.org/help/": ["http://www.wikipedia.org/", "http://www.wikipedia.org/about/"]
        "http://www.wikipedia.org/about/": ["http://www.google.com/"]
    Return
        ["http://www.wikipedia.org/", "http://www.wikipedia.org/help/", "http://www.wikipedia.org/about/"]
*/


import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.net.*;


public class Solution {

    ExecutorService pool = Executors.newFixedThreadPool(3);;
    AtomicLong numTasks = new AtomicLong(0);  // wait for all task to finish
    Lock lock = new ReentrantLock();  // to protect ans::List<String> and visited::Set<String>. 
    List<String> ans = new ArrayList<>();
    Set<String> visited = new HashSet<>();

    private class crawlTask implements Runnable {
        String url;
        public crawlTask (String u) {
            url = u;
        }
        @Override
        public void run () {
            try {
                for (String neighbor : HtmlHelper.parseUrls(url)) {
                    URL neighborURL = new URL(neighbor);
                    if (!neighborURL.getHost().endsWith("wikipedia.org")) continue;  // may throw exception
                    lock.lock();
                    if (!visited.contains(neighbor)) {  // found new URL to crawl
                        visited.add(neighbor);
                        ans.add(neighbor);
                        pool.execute(new crawlTask(neighbor));
                        numTasks.incrementAndGet();
                    }
                    lock.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                numTasks.decrementAndGet();
            }
        }       
    }

    public List<String> crawler (String url) {
        visited.add(url);
        ans.add(url);
        pool.execute(new crawlTask(url));
        numTasks.incrementAndGet();
        try {
            while (numTasks.get() != 0) Thread.sleep(3000);;  // wait until no more tasks
        } catch (Exception e) { e.printStackTrace(); }
        pool.shutdown();  // otherwise program won't stop
        return ans;
    }
}
