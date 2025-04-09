/*
 *  http://www.lintcode.com/en/problem/zombie-in-matrix/
 *
 *  Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).
 *  Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall.
 *  How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
 */

 	class Coordinate {
		int i;
		int j;
		Coordinate (int x, int y) {
			this.i = x;
			this.j = y;
		}
	}
 	
	int P = 0;  // people
	int Z = 1;  // zombie
	int W = 2;  // wall
 	
 	final int[] dx = new int[] {-1, +1, 0, 0};
 	final int[] dy = new int[] {0, 0, +1, -1};

 	boolean inbound (int[][] grid, int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}

	public int zombie (int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

		int numPeople = 0;
		int numDays = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<Coordinate> q = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == P) ++numPeople;
				else if (grid[i][j] == Z) q.offer(new Coordinate(i, j)); 
		}
		
		while (!q.isEmpty()) {
			
			if (numPeople == 0) break;  // All people are infected, but at this point, there might be still zombies in queue unprocessed.
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				Coordinate c = q.poll();
				for (int j = 0; j < 4; j++) {
					int x = c.i + dx[j];
					int y = c.j + dy[j];
					if (inbound(grid, x, y) && grid[x][y] == P && !visited[x][y]) {
						visited[x][y] = true;
						q.offer(new Coordinate(x, y));
						-- numPeople;
					}
				}
			}
			numDays ++;  // another day passed
		}
		
		if (numPeople == 0) return numDays;
		else return -1;
	}
