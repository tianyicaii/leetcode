/*
 *  http://www.lintcode.com/en/problem/build-post-office-ii/
 *
 *  Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two),
 *  find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.
 *  Return the smallest sum of distance. Return -1 if it is not possible.
 */

	// run BFS from each house, and check every empty space
	
	class Coordinate {
		int i;
		int j;
		Coordinate (int x, int y) {
			this.i = x;
			this.j = y;
		}
	}

	final int[] dx = new int[] {-1, +1, 0, 0};
	final int[] dy = new int[] {0, 0, +1, -1};
	
	int E = 0;  // empty
	int H = 1;  // house
	int W = 2;  // wall

	boolean inbound (int[][] grid, Coordinate x) {
		return x.i >= 0 && x.i < grid.length && x.j >= 0 && x.j < grid[0].length;
	}
	
	int[][] houseCount;  // a valid point has to be able to reach all houses
	int[][] distanceCount;  // return a valid point with minimum total distance
	
	public int shortestDistance (int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) return -1;

		List<Coordinate> houses = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == H) houses.add(new Coordinate(i, j));
			}
		}

		houseCount = new int[grid.length][grid[0].length];
		distanceCount = new int[grid.length][grid[0].length];
		for (Coordinate c : houses) {  // start at each house, and mark all other reachable empty spaces 
			bfs(grid, c);
		}
		
		Integer ans = null;  // might not exist an spot from which all house are reachable
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {  //  empty space
					if (houseCount[i][j] == houses.size() && (ans == null || distanceCount[i][j] < ans))
						ans = distanceCount[i][j];
				}
			}
		}
		return ans == null ? -1 : ans;
	}

	void bfs (int[][] grid, Coordinate start) {
		Queue<Coordinate> q = new LinkedList<>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		q.add(start);
		int step = 0;
		while (!q.isEmpty()) {
			int sz = q.size();
			++ step;
			for (int i = 0; i < sz; i++) {
				Coordinate c = q.poll();
				for (int j = 0; j < 4; j++) {
					Coordinate n = new Coordinate(c.i + dx[j], c.j + dy[j]);
					if (inbound(grid, n) && !visited[n.i][n.j] && grid[n.i][n.j] == E) {  // explore empty space that has not been visited yet
						visited[n.i][n.j] = true;
						q.offer(n);
						houseCount[n.i][n.j] += 1;
						distanceCount[n.i][n.j] += step;
					}
				}
			}
		}
	}
