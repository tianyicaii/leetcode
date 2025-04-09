// https://leetcode.com/problems/insert-interval/


public class Solution {


	public List<Interval> insert (List<Interval> intervals, Interval newInterval) {
		List<Interval> ans = new ArrayList<>();
		int position = 0;
		for (Interval i : intervals) {
			if      (i.end < newInterval.start) {
				position += 1;
				ans.add(i);
			}
			else if (i.start > newInterval.end)
				ans.add(i);
			else {
				newInterval.start = Math.min(i.start, newInterval.start);
				newInterval.end   = Math.max(i.end,   newInterval.end);
			}
		}
		ans.add(position, newInterval);
		return ans;
	}


}

