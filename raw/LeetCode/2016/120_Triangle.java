// https://leetcode.com/problems/triangle/


public class Solution {
	

	public int minimumTotal (List<List<Integer>> triangle) {
		
		
		// row[i] has i+1 elements;
		
		
		int n = triangle.size();  // num of rows
		int[][] dp = new int[2][n + 1];
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (i == n - 1) dp[i%2][j] = triangle.get(i).get(j);
				else            dp[i%2][j] = triangle.get(i).get(j) + Math.min(dp[(i + 1)%2][j], dp[(i + 1)%2][j + 1]);
			}
		}
		return dp[0][0];  // first row, first element
	}


}

