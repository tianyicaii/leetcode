
/*

Implement a web logger, which provide two methods:
    hit(timestamp), record a hit at given timestamp.
    get_hit_count_in_last_5_minutes(timestamp), get hit count in last 5 minutes.
the two methods will be called with non-descending timestamp (in sec).

Example
    hit(1);
    hit(2);
    get_hit_count_in_last_5_minutes(3);
    >> 2
    hit(300);
    get_hit_count_in_last_5_minutes(300);
    >> 3
    get_hit_count_in_last_5_minutes(301);
    >> 2

*/


    public class WebLogger {

        private LinkedList<Integer> timestamps = new LinkedList<Integer>();

        public void hit(int timestamp) {
            timestamps.add(timestamp);
        }

        public int get_hit_count_in_last_5_minutes(int timestamp) {
            while (!timestamps.isEmpty() && timestamps.getFirst()  + 300 <= timestamp)
                timestamps.removeFirst();  // only keep history for the last 5 minutes
            return timestamps.size();
        }
    }
