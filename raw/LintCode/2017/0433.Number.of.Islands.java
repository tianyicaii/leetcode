/*
 *  http://www.lintcode.com/en/problem/number-of-islands/
 *
 *  Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent,
 *  we consider them in the same island. We only consider up/down/left/right adjacent.
 *  Find the number of islands.
 */


// bfs, dfs
	class Coordinate {
		int i;
		int j;
		Coordinate (int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	final int[] dx = new int[] {-1, +1, 0, 0};
	final int[] dy = new int[] {0, 0, +1, -1};
	
	boolean inbound (boolean[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}
	
	public int numIslands (boolean[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) return 0;
		int ans = 0;

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] && !visited[i][j]) {  // found a new island
					++ ans;
					visited[i][j] = true;
					bfs(grid, visited, i, j);  // to mark all cells belonging to this island.
					// dfs(grid, visited, i, j);
				}
			}
		}
		return ans;
	}

	void bfs (boolean[][] grid, boolean[][] visited, int i, int j) {
		Queue<Coordinate> q = new LinkedList<>();
		q.offer(new Coordinate(i, j));
		while (!q.isEmpty()) {
			Coordinate c = q.poll();
			for (int k = 0; k < 4; k++) {
				int x = c.i + dx[k];
				int y = c.j + dy[k];
				if (inbound(grid, x, y) && grid[x][y] && !visited[x][y]) {
					visited[x][y] = true;            // mark a coordinate before processing it
					q.offer(new Coordinate(x, y));   // to avoid to be added as other cell's neighbor
				}
			}
		}
	}

	void dfs (boolean[][] grid, boolean[][] visited, int i, int j) {
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (inbound(grid, x, y) && grid[x][y] && !visited[x][y]) {
				visited[x][y] = true;      // mark a coordinate before processing it
				dfs(grid, visited, x, y);  // to avoid to be added as other cell's neighbor
			}
		}
	}

// uf
	class UF {
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
		boolean connected(int x, int y) {
			return find(x) == find(y);
		}
		int find (int x) {
			while (id[x] != x) {
				int g = id[id[x]];  // path compression
				id[x] = g;
				x = id[x];
			}
			return x;
		}
		void union (int x, int y) {
			if (connected(x, y)) return;
			int left = find(x);
			int right = find(y);
			if (sz[left] < sz[right]) {
				id[left] = right;
				sz[right] += sz[left];
			} else {
				id[right] = left;
				sz[left] += sz[right];
			}
			cnt -= 1;
		}
	}
	
	int getId (boolean[][] grid, int i, int j) {
		return i * grid[0].length + j;
	}
	
	public int numIslands (boolean[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) return 0;
		UF uf = new UF(grid.length * grid[0].length);
		
		int numZeros = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j]) {
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (inbound(grid, x, y) && grid[x][y]) 
							uf.union(getId(grid, i, j), getId(grid, x, y));
					}
				} else ++ numZeros;
			}
		}

		return uf.cnt - numZeros;
	}
