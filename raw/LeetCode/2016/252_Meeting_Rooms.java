// https://leetcode.com/problems/meeting-rooms/


public class Solution {


	private class ByStart implements Comparator<Interval> {
		public int compare (Interval a, Interval b) {
			return a.start - b.start;
		}
	}

	public boolean canAttendMeetings (Interval[] intervals) {
		Arrays.sort(intervals, new ByStart());
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i-1].end) return false;
		}
		return true;
	}


}

