// https://leetcode.com/problems/meeting-rooms-ii/


public class Solution {


	private enum Type { START, END }

	private class Point {
		int x;
		Type t;
		public Point (int x, Type t) {
			this.x = x;
			this.t = t;
		}
	}

	private class PointComparator implements Comparator<Point> {
		public int compare (Point a, Point b) {
			if (a.x == b.x) 
				if      (a.t == Type.END   && b.t == Type.START) return -1;
				else if (a.t == Type.START && b.t == Type.END)   return  1; 
				else                                             return  0;
			else 
				return a.x - b.x;
		}
	}

	public int minMeetingRooms (Interval[] intervals) {
		List<Point> points = new ArrayList<>();
		for (Interval i : intervals) {
			points.add(new Point(i.start, Type.START));
			points.add(new Point(i.end,   Type.END));
		}
		Collections.sort(points, new PointComparator());
		int max = 0;
		int concurrent = 0;
		for (Point p : points) {
			if (p.t == Type.START) concurrent += 1;
			else                   concurrent -= 1;
			max = Math.max(max, concurrent);
		}
		return max;  // max overlap is min num of room needed.
	}


}

