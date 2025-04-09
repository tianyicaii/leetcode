// https://leetcode.com/problems/dungeon-game/


public class Solution {


	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];  // how much hp needed to move from [i][j] to [m-1][n-1]
		for (int i = m-1; i >= 0; i--) {
			for (int j = n-1; j >= 0; j--) {
				if (i == m-1 && j == n-1) dp[i][j] = dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
				else if (i == m-1)        dp[i][j] = dp[i][j+1] - dungeon[i][j] > 0 ? dp[i][j+1] - dungeon[i][j] : 1;
				else if (j == n-1)        dp[i][j] = dp[i+1][j] - dungeon[i][j] > 0 ? dp[i+1][j] - dungeon[i][j] : 1;
				else {
					int cheaper = Math.min(dp[i+1][j], dp[i][j+1]);
					dp[i][j] = cheaper - dungeon[i][j] > 0 ? cheaper - dungeon[i][j] : 1;
				}
			}
		}
		return dp[0][0];
	}	


}

