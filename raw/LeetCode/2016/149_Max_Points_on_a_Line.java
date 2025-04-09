// https://leetcode.com/problems/max-points-on-a-line/


public class Solution {
	

	public int maxPoints(Point[] points) {
		
		
		// slope is dy/dx
		// overlap is special case
		
		int ans = 0;

		// first indexed by dy
		// then indexed by dx
		// keep track of counts
		
		for (int i = 0; i < points.length; i++) {
			
			Map<Integer, Map<Integer, Integer>> lines = new HashMap<>();
			int max = 0;
			int overlap = 0;
			
			int x0 = points[i].x;
			int y0 = points[i].y;
			
			for (int j = i+1; j < points.length; j++) {
				int x1 = points[j].x;
				int y1 = points[j].y;
				if (x1 == x0 && y1 == y0) {  // will be added to any line
					overlap += 1;
					continue;
				}
				
			// get slope
				int dx = x1 - x0;
				int dy = y1 - y0;
				
				if (dx == 0) {
					dx = 0;
					dy = 1;
				}
				else if (dy == 0) {
					dx = 1;
					dy = 0;
				}
				else if (dx < 0 && dy < 0) {
					dx = -dx;
					dy = -dy;
					int gcd = GCD(dx, dy);
					dx = dx/gcd;
					dy = dy/gcd;
					
				}
				else if (dx > 0 && dy > 0) {
					int gcd = GCD(dx, dy);
					dx = dx/gcd;
					dy = dy/gcd;					
				}
				else if (dx < 0 && dy > 0) {
					dx = -dx;
					dy = -dy;
					int gcd = GCD(dx, -dy);
					dx = dx/gcd;
					dy = dy/gcd;
				}
				else {  // dx > 0 && dy < 0
					int gcd = GCD(dx, -dy);
					dx = dx/gcd;
					dy = dy/gcd;
				}
				
				// make dx positive and dy negative if different sign
				// make dx, dy positive if same sign
				// make dy, dy positive if the other is zero
				// overlap is not in hash-table
				
				Map<Integer, Integer> row;
				if (lines.containsKey(dy))
					row = lines.get(dy);
				else {
					row = new HashMap<>();
					lines.put(dy, row);  // insert
				}
				
				int count = 1;
				if (row.containsKey(dx))
					count += row.get(dx);
				row.put(dx, count);  // count ++
				
				max = Math.max(max, count);
			}
			
			ans = Math.max(ans, max + overlap) + 1;
		}
		return ans;

	}
	
	private int GCD (int x, int y) {
		while (y != 0) {
			int mod = x % y;
			x = y;
			y = mod;
		}
		return x;
	}


}

