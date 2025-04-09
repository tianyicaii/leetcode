// https://leetcode.com/problems/the-skyline-problem/


public class Solution {


	// scan line


	public enum Type { START, END }
	
	public class Point {
		Type t;
		int x;
		int y;
		public Point (Type t, int x, int y) {
			this.t = t;
			this.x = x;
			this.y = y;
		}
	}
	
	public class PointComparator implements Comparator<Point> {
		public int compare (Point a, Point b) {
			if (a.x == b.x) {
				if (a.t == Type.START && b.t == Type.END)   return -1;
				if (a.t == Type.END   && b.t == Type.START) return  1;
				if (a.t == Type.START && b.t == Type.START) return b.y - a.y;
				if (a.t == Type.END   && b.t == Type.END)   return a.y - b.y;
			}
			return a.x - b.x; 
		}
	}
	
	public List<int[]> getSkyline(int[][] buildings) {
		
		List<Point> points = new ArrayList<>();
		for (int[] b : buildings) {
			points.add(new Point(Type.START, b[0], b[2]));
			points.add(new Point(Type.END,   b[1], b[2]));
		}
		Collections.sort(points, new PointComparator());
		
		List<int[]> ans = new ArrayList<>();
		TreeMap<Integer, Integer> underScan = new TreeMap<>();  // use counter to handle duplicates, START points of the same height.
		underScan.put(0, 1);
		
		int prev = 0;
		for (Point p: points) {
			int curr;
			if (p.t == Type.START) {
				addToUnderScan(underScan, p);
				curr = underScan.lastKey();
				if (curr > prev) {  // a new height
					ans.add(new int[] {p.x, curr});
					prev = curr;
				}
			}
			else {  // END point
				removeFromUnderScan(underScan, p);
				curr = underScan.isEmpty() ? 0 : underScan.lastKey();
				if (curr < prev) {
					ans.add(new int[] {p.x, curr});
					prev = curr;
				}
			}
		}
		
		return ans;
	}

	private void addToUnderScan (Map<Integer, Integer> underScan, Point p) {
		if (underScan.containsKey(p.y))
			underScan.put(p.y, underScan.get(p.y) + 1);
		else
			underScan.put(p.y, 1);
	}

	private void removeFromUnderScan (Map<Integer, Integer> underScan, Point p) {
		if (underScan.get(p.y) == 1) underScan.remove(p.y);
		else                         underScan.put(p.y, underScan.get(p.y) - 1);
	}


}

