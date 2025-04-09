// https://leetcode.com/problems/number-of-islands/


public class Solution {


	public int numIslands (char[][] grid) {
		
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		int ans = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				if (grid[i][j] == '1' && !visited[i][j]) {
					visited[i][j] = true;
					bfs(grid, visited, i, j);
					// dfs(grid, visited, i, j);
					ans ++;
				}
			}
		}
		
		return ans;
	}
	
	private void bfs (char[][] grid, boolean[][] visited, int r, int c) {
		int m = grid.length;
		int n = grid[0].length;
		int[] dirs = {0, 1, 0, -1, 0};
		
		Deque<Integer> Q = new ArrayDeque<>();
		Q.offerLast(r * n + c);
		while (!Q.isEmpty()) {
			int index = Q.pollFirst();
			int i = index / n;
			int j = index % n;
			for (int k = 0; k < 4; k++) {
				int x = i + dirs[k];
				int y = j + dirs[k + 1];
				if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && !visited[x][y]) {
					visited[x][y] = true;
					Q.offerLast(x * n + y);
				}
			}
		}
	}
	
	private void dfs (char[][] grid, boolean[][] visited, int r, int c) {
		int m = grid.length;
		int n = grid[0].length;
		int[] dirs = {0, 1, 0, -1, 0};
		visited[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int x = r + dirs[k];
			int y = c + dirs[k + 1];
			if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && !visited[x][y]) {
				dfs(grid, visited, x, y);
			}
		}
	}
	

}

