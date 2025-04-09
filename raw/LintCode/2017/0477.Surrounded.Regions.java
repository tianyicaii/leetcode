/*
 *  http://www.lintcode.com/en/problem/surrounded-regions/
 *
 *  Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *  A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
 */

// this is a percolation problem

	private class Coordindate {
		int i;
		int j;
		public Coordindate (int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	private boolean inBound (char[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}
	
	private boolean isEmpty (char[][] board, int i, int j) {
		return board[i][j] == 'O';
	}
	
	int[] di = {-1, 1, 0, 0};
	int[] dj = {0, 0, -1, 1};
	
	public void surroundedRegions (char[][] board) {
		if (board.length == 0 || board[0].length == 0) return;
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		// left and right
		for (int i = 0; i < m; i++) {
			if (isEmpty(board, i, 0) && !visited[i][0]) bfs(board, visited, new Coordindate(i, 0));
			if (isEmpty(board, i, n-1) && !visited[i][n-1]) bfs(board, visited, new Coordindate(i, n-1));
		}
		
		// top and down
		for (int j = 0; j < n; j++) {
			if (isEmpty(board, 0, j) && !visited[0][j]) bfs(board, visited, new Coordindate(0, j));
			if (isEmpty(board, m-1, j) && !visited[m-1][j]) bfs(board, visited, new Coordindate(m-1, j));
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (isEmpty(board, i, j) && !visited[i][j]) board[i][j] = 'X';
			}
		}
	}
	
	private void bfs (char[][] board, boolean[][] visited, Coordindate start) {
		Queue<Coordindate> q = new LinkedList<>();
		visited[start.i][start.j] = true;
		q.offer(start);
		while (!q.isEmpty()) {
			Coordindate curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = curr.i + di[i];
				int y = curr.j + dj[i];
				if (inBound(board, x, y) && isEmpty(board, x, y) && !visited[x][y]) {
					visited[x][y] = true;
					q.offer(new Coordindate(x, y));
				}
			}
		}
	}


// percolation with union find
	private class UF {
		int[] id;
		int[] sz;
		int cnt;
		public UF (int n) {
			id = new int[n];
			sz = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
				sz[i] = 1;
			}
			cnt = n;
		}
		public int find (int x) {
			while (id[x] != x) {
				id[x] = id[id[x]];
				x = id[x];
			}
			return x;
		}
		public boolean isConnected (int x, int y) {
			return find(x) == find(y);
		}
		public void union (int x, int y) {
			if (isConnected(x, y)) return;
			x = find(x);
			y = find(y);
			if (sz[x] > sz[y]) {
				id[y] = x;
				sz[x] += sz[y];
			} else {
				id[x] = y;
				sz[y] += sz[x];
			}
			cnt -= 1;
		}
	}
	
	private int getIndex(char[][] board, int i, int j) {
		return i * board[0].length + j;
	}
	private boolean inBound (char[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}
	private boolean isEmpty (char[][] board, int i, int j) {
		return board[i][j] == 'O';
	}
	int[] di = {-1, 1, 0, 0};
	int[] dj = {0, 0, -1, 1};
	

	public void surroundedRegions (char[][] board) {
		if (board.length == 0 || board[0].length == 0) return;
		int m = board.length;
		int n = board[0].length;
		
		// connect empty cells
		UF uf = new UF(m * n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isEmpty(board, i, j)) {
					for (int k = 0; k < 4; k++) {
						int x = i + di[k];
						int y = j + dj[k];
						if (inBound(board, x, y) && isEmpty(board, x, y)) {
							uf.union(getIndex(board, i, j), getIndex(board, x, y));
						}
					}
				}
			}
		}
		
		// find groups remains empty
		Set<Integer> emptyIds = new HashSet<>();
		for (int i = 0; i < m; i++) {
			if (isEmpty(board, i, 0)) emptyIds.add(uf.find(getIndex(board, i, 0)));
			if (isEmpty(board, i, n-1)) emptyIds.add(uf.find(getIndex(board, i, n-1)));
		}
		for (int j = 0; j < n; j++) {
			if (isEmpty(board, 0, j)) emptyIds.add(uf.find(getIndex(board, 0, j)));
			if (isEmpty(board, m-1, j)) emptyIds.add(uf.find(getIndex(board, m-1, j)));
		}
		
		// flip isolated regions
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isEmpty(board, i, j)) {
					if (!emptyIds.contains(uf.find(getIndex(board, i, j)))) {
						board[i][j] = 'X';
					} 
				}
			}
		}
	}

