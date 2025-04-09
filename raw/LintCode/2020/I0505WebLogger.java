package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class I0505WebLogger {


    public class WebLogger {

        Queue<Integer> hits = new LinkedList<>();

        public WebLogger() {}
    
        public void hit(int timestamp) {
            hits.offer(timestamp);
        }

        public int get_hit_count_in_last_5_minutes(int timestamp) {
            while (!hits.isEmpty() && hits.peek() + 300 <= timestamp) hits.poll();
            return hits.size();
        }
    }

}
