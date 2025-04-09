// https://leetcode.com/problems/merge-intervals/


public class Solution {


	private enum Type { START, END }
	
	private class Point implements Comparable<Point>{
		Type t;
		int  x;
		public Point (Type t, int x) {
			this.t = t;
			this.x = x;
		}
		public int compareTo (Point other) {
			if (this.x == other.x) {
				if      (this.t == Type.START && other.t == Type.END) return -1;
				else if (this.t == Type.END && other.t == Type.START) return  1;
				else                                                  return  0;
			}
			
			return this.x - other.x;
		}
	}
	
	public List<Interval> merge (List<Interval> intervals) {
		
		List<Point> pts = new ArrayList<>();
		for (Interval i : intervals) {
			pts.add(new Point(Type.START, i.start));
			pts.add(new Point(Type.END,   i.end));
		}
		Collections.sort(pts);

		List<Interval> ans = new ArrayList<>();
		int count = 0;
		int start = 0;  // dummy value
		int end   = 0;
		for (Point p : pts) {
			if (p.t == Type.START) {
				if (count == 0) start = p.x;
				count += 1;
			}
			else {
				count -= 1;
				if (count == 0) {
					end = p.x;
					ans.add(new Interval(start, end));
				}
			}
		}
		return ans;
	}


}

