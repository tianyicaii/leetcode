/*
 *  http://www.lintcode.com/en/problem/trapping-rain-water-ii/
 *  Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1,
 *  compute how much water it is able to trap after raining.
 */


// for each bar, it either has some water on top
// or it increase boundary hight

	private class Cell implements Comparable<Cell> {
		int i;
		int j;
		int h;
		public Cell (int i, int j, int h) {
			this.i = i;
			this.j = j;
			this.h = h;
		}
		public int compareTo (Cell other) {
			return this.h - other.h;
		}
	}
	
	final int[] di = {-1, 1, 0, 0};
	final int[] dj = {0, 0, -1, 1};
	
	boolean inBound (int[][] board, int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}
	
	public int trapRainWater (int[][] heights) {
		boolean[][] visited = new boolean[heights.length][heights[0].length];
		PriorityQueue<Cell> pq = new PriorityQueue<>();
		for (int i = 0; i < heights.length; i++) {
			pq.offer(new Cell(i, 0, heights[i][0]));
			pq.offer(new Cell(i, heights[0].length-1, heights[i][heights[0].length-1]));
			visited[i][0] = true;
			visited[i][heights[0].length-1] = true;
		}
		for (int j = 0; j < heights[0].length; j++) {
			pq.offer(new Cell(0, j, heights[0][j]));
			pq.offer(new Cell(heights.length-1, j, heights[heights.length-1][j]));
			visited[0][j] = true;
			visited[heights.length-1][j] = true;
		}
		
		int ans = 0;
		while (!pq.isEmpty()) {
			Cell c = pq.poll();
			for (int i = 0; i < 4; i++) {  // for each neighbors
				int x = c.i + di[i];
				int y = c.j + dj[i];
				if (inBound(heights, x, y) && !visited[x][y]) {
					pq.offer(new Cell(x, y, Math.max(c.h, heights[x][y])));  // the new bar acts as existing boundary if it lower, or it increae boundary hight
					visited[x][y] = true;
					ans += Math.max(0, c.h - heights[x][y]);  // add water if this bar is lower
				}
			}
		}
		return ans;
	}
