package lintcode;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;


class HtmlHelper {
    static List<String> parseUrls(String url) { return new ArrayList<>(); }
}

public class I0234WebCrawler {

    ExecutorService pool = Executors.newFixedThreadPool(3);
    AtomicLong numTasks = new AtomicLong(0);
    ReentrantLock lock = new ReentrantLock();
    List<String> ans = new ArrayList<>();
    Set<String> visited = new HashSet<>();


    class CrawlerTask implements Runnable {

        String url;
        CrawlerTask(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            Set<String> neighbors = new HashSet<>();
            try {
                for (String n : HtmlHelper.parseUrls(url)) {
                    URL x = new URL(n);
                    if (!x.getHost().endsWith("wikipedia.org")) continue;
                    neighbors.add(x.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
                numTasks.decrementAndGet();
                return;
            }

            lock.lock();
            for (String n : neighbors) {
                if (visited.contains(n)) continue;
                visited.add(n);
                ans.add(n);
                numTasks.incrementAndGet();
                pool.execute(new CrawlerTask(n));
            }
            lock.unlock();
            numTasks.decrementAndGet();
        }
    }

    public List<String> crawler(String url) {
        visited.add(url);
        ans.add(url);
        numTasks.incrementAndGet();
        pool.execute(new CrawlerTask(url));
        try {
            while (numTasks.get() != 0) Thread.sleep(3000);  // wait until no more tasks
        } catch (Exception e) { e.printStackTrace(); }
        pool.shutdown();  // otherwise program won't stop
        return ans;
    }
}
