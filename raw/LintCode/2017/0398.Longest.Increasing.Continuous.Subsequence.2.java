/*
 *  http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence-ii/
 *
 *  Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix.
 *  (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
 */

//  memorable search
//  no clear definition of sub-problem
//  no clear ordering of sub-problem

	public int longestIncreasingContinuousSubsequenceII (int[][] A) {
		if (A.length == 0 || A[0].length == 0) return 0;

		
		int[][] m = new int[A.length][A[0].length];
		boolean[][] visited = new boolean[A.length][A[0].length];
		
		
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				search(A, i, j, m, visited);  // fill up memorable array
				ans = Math.max(ans, m[i][j]);  // take max seen along the way
			}
		}
		return ans;
	}	
	
	boolean inBound (int[][] A, int i, int j) {
		return i >= 0 && i < A.length && j >= 0 && j < A[0].length;
	}
	
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	
	void search (int[][] A, int i, int j, int[][] m, boolean[][] visited) {
		if (visited[i][j]) return;
		int ans = 1;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (inBound(A, x, y) && A[x][y] > A[i][j]) {
				search(A, x, y, m, visited);
				ans = Math.max(ans, m[x][y] + 1);
			}
		}
		visited[i][j] = true;
		m[i][j] = ans;
	}
