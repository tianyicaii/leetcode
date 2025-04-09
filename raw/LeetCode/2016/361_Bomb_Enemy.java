// https://leetcode.com/problems/bomb-enemy/


public class Solution {


	public int maxKilledEnemies (char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int[] cols = new int[n];
		int ans = 0;
		
		
		for (int i = 0; i < m; i++) {
			
			int rowCount = 0;
			for (int j = 0; j < n; j++) {
				
				if (grid[i][j] == 'W') {  // reset counter
					rowCount = 0;
					cols[j] = 0;
				}
				
				else {  // not wall
					if (i == 0 || grid[i-1][j] == 'W') {  // column counter was reset
						for (int k = i; k < m && grid[k][j] != 'W'; k++)  // extend this column
							cols[j] += (grid[k][j] == 'E') ? 1 : 0;
					}
					if (j == 0 || grid[i][j-1] == 'W') {  // row counter was reset
						for (int k = j; k < n && grid[i][k] != 'W'; k++)  // extend this row
							rowCount += (grid[i][k] == 'E') ? 1 : 0;;
					}
					if (grid[i][j] == '0') // only drop at open locations
						ans = Math.max(ans, cols[j] + rowCount);
				}
			}
		}
		
		
		return ans;
	}	


}

