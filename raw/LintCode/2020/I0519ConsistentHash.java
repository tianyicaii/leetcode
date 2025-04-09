package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0519ConsistentHash {
    
    
    class Interval {
        int start;
        int end;
        int id;
        Interval(int start, int end, int id) { this.start = start; this.end = end; this.id = id; }
        List<Integer> toList() {
            List<Integer> ans = new ArrayList<>();
            ans.add(start);
            ans.add(end);
            ans.add(id);
            return ans;
        }
        Interval split(int newId) {
            int mid = start + (end-start)/2;
            Interval newInterval = new Interval(mid+1, end, newId);
            this.end = mid;
            return newInterval;
        }

        int size() { return end - start + 1; }
        public int compareTo(Interval other) {
            if (this.size() < other.size()) return -1;
            if (this.size() > other.size()) return 1;
            if (this.id < other.id) return 1;
            if (this.id > other.id) return -1;
            return 0;
        }
    }
    
    public List<List<Integer>> consistentHashing(int n) {
    
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 359, 1));

        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < intervals.size(); j++) {
                if (intervals.get(j).compareTo(intervals.get(max)) > 0) max = j;
            }
            intervals.add(max+1, intervals.get(max).split(i));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Interval i : intervals) ans.add(i.toList());
        return ans;
    }
}
