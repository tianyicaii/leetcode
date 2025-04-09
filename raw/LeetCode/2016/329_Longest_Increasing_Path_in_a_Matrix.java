// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/


public class Solution {


	int[] dir = { 0, -1, 0, 1, 0 };

	public int longestIncreasingPath (int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] mem = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(matrix, mem, i, j));
			}
		}
		return max;
	}

	private int dfs (int[][] matrix, int[][] mem, int i, int j) {
		if (mem[i][j] != 0) return mem[i][j];
		int ans = 1;

		int m = matrix.length;
		int n = matrix[0].length;

		for (int k = 0; k < 4; k++) {
			int ii = i + dir[k];
			int jj = j + dir[k + 1];
			if (ii >= 0 && ii < m && jj >= 0 && jj < n && matrix[ii][jj] > matrix[i][j]) {
				ans = Math.max(ans, 1 + dfs(matrix, mem, ii, jj));
			}
		}


		mem[i][j] = ans;
		return ans;
	}


}

