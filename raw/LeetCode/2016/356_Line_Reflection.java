// https://leetcode.com/problems/line-reflection/


public class Solution {


	public boolean isReflected(int[][] points) {
		if (points.length == 0) return true;
		
		Set<String> P = new HashSet<>();
		int minX = points[0][0];
		int maxX = points[0][0];
		for (int[] p : points) {
			minX = Math.min(minX, p[0]);
			maxX = Math.max(maxX, p[0]);
			P.add(p[0] + ", " + p[1]);
		}
		
		int sum = minX + maxX;  // avoid double due to division by 2.
		for (int[] p : points) {
			if (!P.contains((sum - p[0]) + ", " + p[1])) return false;
		}
		return true;
	}


}

