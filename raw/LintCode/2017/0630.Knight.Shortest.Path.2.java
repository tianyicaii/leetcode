/*
 *  http://www.lintcode.com/en/problem/knight-shortest-path-ii/
 *
 *  Given a knight in a chessboard n * m (a binary matrix with 0 as empty and 1 as barrier).
 *  The knight initialze position is (0, 0) and he wants to reach position (n - 1, m - 1),
 *  Knight *can only be from left to right*. Find the shortest path to the destination position,
 *  return the length of the route. Return -1 if knight can not reached.
 */

// this is a dp problem because knight can only jump from left to right
// the solution of a sub-problem does not change as problem size changes


	int[] di = {-2, -1, 1, 2};
	int[] dj = {1, 2, 2, 1};

	private boolean inBound (boolean[][] grid, int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}
	
	public int shortestPath2 (boolean[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] A = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int j = 0; j < n; j++) {  // left to right
			for (int i = 0; i < m; i++) {
				

				if (grid[i][j]) continue;  // barrier
				
				if (i == 0 && j == 0) A[i][j] = 0;
				else {
					for (int k = 0; k < 4; k++) {
						int x = i - di[k];
						int y = j - dj[k];
						if (inBound(grid, x, y) && A[x][y] != Integer.MAX_VALUE) {
							A[i][j] = Math.min(A[i][j], A[x][y] + 1);
						}
					}
				}

				
				
			}
		}
		
		
		return A[m-1][n-1] == Integer.MAX_VALUE ? -1 : A[m-1][n-1];
	}
