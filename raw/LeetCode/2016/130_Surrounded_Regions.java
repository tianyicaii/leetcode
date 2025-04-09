// https://leetcode.com/submissions/detail/70413329/


public class Solution {
	

	public void solve (char[][] board) {
		

		if (board == null || board.length <= 2 || board[0].length <= 2) return;
		
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		Deque<Integer> bfs = new ArrayDeque<>();
		
		
		for (int i = 0; i < m; i++) {  // first, last column
			if (board[i][0] == 'O' && !visited[i][0]) {
				bfs.offerLast(getIndex(i, 0, n));
				visited[i][0] = true;
			}
			if (board[i][n-1] == 'O' && !visited[i][n-1]){
				bfs.offerLast(getIndex(i, n-1, n));
				visited[i][n-1] = true;
			}
		}
		for (int j = 0; j < n; j++) {  // first, last row
			if (board[0][j] == 'O' && !visited[0][j]) { 
				bfs.offerLast(getIndex(0, j, n));
				visited[0][j] = true;
			}
			if (board[m-1][j] == 'O' && !visited[m-1][j]) {
				bfs.offerLast(getIndex(m-1, j, n));
				visited[m-1][j] = true;
			}
		}
		
		int[] dirs = { 0, -1, 0, 1, 0 };
		while (!bfs.isEmpty()) {
			int idx = bfs.pollFirst();
			int r = idx / n;
			int c = idx % n;
			for (int k = 0; k < 4; k++) {
				int i = r + dirs[k];
				int j = c + dirs[k + 1];
				if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && board[i][j] == 'O') {
					bfs.offerLast(getIndex(i, j, n));
					visited[i][j] = true;
				}
			}
		}
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) board[i][j] = 'X';
			}
		}
	}	
	
	private int getIndex (int r, int c, int n) {
		return r * n + c;
	}


}

