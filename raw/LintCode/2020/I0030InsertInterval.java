package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0030InsertInterval {

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals = add(intervals, newInterval);
        return merge(intervals);
        
    }

    private List<Interval> add(List<Interval> intervals, Interval x) {
        List<Interval> ans = new ArrayList<>();
        boolean added = false;
        for (Interval i : intervals) {
            if (!added && i.start > x.start) {
                ans.add(x);
                added = true;
            }
            ans.add(i);
        }
        if (!added) {
            ans.add(x);
            added = true;
        }
        return ans;
    }

    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        Interval prev = null;
        for (Interval i : intervals) {
            if (prev == null) prev = i;
            else {
                if (prev.end >= i.start) prev.end = Math.max(prev.end, i.end);
                else {
                    ans.add(prev);
                    prev = i;
                }
            }
        }
        ans.add(prev);
        return ans;
    }


}
