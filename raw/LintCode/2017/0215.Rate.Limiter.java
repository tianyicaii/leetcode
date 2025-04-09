/*

Implement a rate limiter, provide one method:
    is_ratelimited (timestamp, event, rate, increment).
            timestamp:  The current timestamp, which is an integer and in second unit.
            event:      The string to distinct different kinds of event. for example, "login" or "signup".
            rate:       The rate of the limit. 1/s (1 time per second), 2/m (2 times per minute), 10/h (10 times per hour), 100/d (100 times per day). The format is [integer]/[s/m/h/d].
            increment:  Whether we should increase the counter. (or take this call as a hit of the given event)
    The method should return true or false to indicate the event is limited or not.

Example
    is_ratelimited(1, "login", "3/m", true),    return false.
    is_ratelimited(11, "login", "3/m", true),   return false.
    is_ratelimited(21, "login", "3/m", true),   return false.
    is_ratelimited(30, "login", "3/m", true),   return true.
    is_ratelimited(65, "login", "3/m", true),   return false.
    is_ratelimited(300, "login", "3/m", true),  return false.

*/


    public class RateLimiter {

        private HashMap<String, List<Integer>> map = new HashMap<>();  // map event to last accesses
        
        public boolean isRatelimited (int current_timestamp, String event, String rate, boolean increment) {
            
            int i = rate.indexOf("/");
            int limit = Integer.parseInt(rate.substring(0, i));
            
            char type = rate.charAt(i + 1);
            int duration = 1;  // convert time unit to seconds
            if      (type == 'm') duration = 60;
            else if (type == 'h') duration = 60 * 60;
            else if (type == 'd') duration = 60 * 60 * 24;
            else ; // unit is already in seconds
            
            int start_timestamp = current_timestamp - duration + 1;  // portion of history that is relevant, +1 to include start_timestamp
            if (!map.containsKey(event)) map.put(event, new ArrayList<Integer>());
            int count = count_events(map.get(event), start_timestamp);  // count number of events since start_timestamp, including start_timestamp
            boolean is_ratelimited = (count >= limit);
            
            
            if (increment && !is_ratelimited)  // accept and record this event
                insert_event(map.get(event), current_timestamp);
            return is_ratelimited;
        }
        
        public void insert_event(List<Integer> event, int timestamp) {
            event.add(timestamp);  // list is in increasing time stamp order
        }
        
        // use binary search algorithm to count how many events happened
        // after start_timestamp because event is sorted by time stamp
        
        public int count_events (List<Integer> event, int start_timestamp) {
            if (event.isEmpty()) return 0;
            int l = 0;
            int r = event.size() - 1;
            if (event.get(l) >= start_timestamp) return event.size();
            if (event.get(r) < start_timestamp) return 0;

            while (l < r - 1) {
                int mid = (l + r) / 2;
                if (event.get(mid) >= start_timestamp) r = mid;
                else l = mid;
            }
            return event.size() - r;
        }
    }
