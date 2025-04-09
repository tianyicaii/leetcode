/*
 *  http://www.lintcode.com/en/problem/knight-shortest-path/
 *
 *  Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position,
 *  find the shortest path to a destination position, return the length of the route. 
 *  Return -1 if knight can not reached.
 */


// knight can jump backwards, not a dp problem, solution of subproblem changes as problem size changes

	boolean inbound (boolean[][] grid, int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}

	final int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
	final int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

	public int shortestPath (boolean[][] grid, Point source, Point destination) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<Point> q = new LinkedList<>();
		q.offer(source);
		visited[source.x][source.y] = true;

		int ans = 0;
		while (!q.isEmpty()) {
			
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				Point x = q.poll();
				if (x.x == destination.x && x.y == destination.y) return ans;  // includes the case in which source == destination
				for (int j = 0; j < 8; j++) {
					int r = x.x + dx[j];
					int c = x.y + dy[j];
					if (inbound(grid, r, c) && !grid[r][c] && !visited[r][c]) {
						q.offer(new Point(r, c));
						visited[r][c] = true;
					}
				}
			}
			++ ans;
		}

		return -1;
	}
