/*
 *  http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/
 *
 *  Find the kth smallest number in at row and column sorted matrix.
 */


//  heap
	class Cell implements Comparable<Cell> {
		int i;
		int j;
		int v;
		public Cell (int i, int j, int v) {
			this.i = i;
			this.j = j;
			this.v = v;
		}
		@Override
		public int compareTo (Cell o) {
			return this.v - o.v;
		}
	}

	private boolean inBound (int[][] matrix, int i, int j) {
		return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
	}

	public int kthSmallest (int[][] matrix, int k) {

		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[][] visited = new boolean[m][n];
		PriorityQueue<Cell> pq = new PriorityQueue<>();
		pq.add(new Cell(0, 0, matrix[0][0]));

		for (int cnt = 0; cnt < k; cnt++) {
			Cell curr = pq.poll();
			
			if (inBound(matrix, curr.i + 1, curr.j) && !visited[curr.i + 1][curr.j]) {
				pq.offer(new Cell(curr.i + 1, curr.j, matrix[curr.i + 1][curr.j]));
				visited[curr.i + 1][curr.j] = true;
			}

			if (inBound(matrix, curr.i, curr.j + 1) && !visited[curr.i][curr.j + 1]) {
				pq.offer(new Cell(curr.i, curr.j + 1, matrix[curr.i][curr.j + 1]));
				visited[curr.i][curr.j + 1] = true;
			}

			if (cnt == k - 1) return curr.v;
		}
		throw new RuntimeException("invalid k");
	}




//  guess an answer ans check if its rank is k

	private class Range {
		int lt = 0;
		int le = 0;
	}
	
	private Range search (int[][] matrix, int v) {
		// start from top right
		
		Range ans = new Range();
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] < v) {
				ans.lt += (col + 1);  // eliminate one row
				row ++;
			} else {
				col --;
			}
		}

		row = 0;
		col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] <= v) {
				ans.le += (col + 1);  // eliminate one row
				row ++;
			} else {
				col --;
			}
		}
		
		return ans;
	}
	
	public int kthSmallest (int[][] matrix, int k) {
		int min = matrix[0][0];
		int max = matrix[matrix.length - 1][matrix[0].length - 1];

		Range ans = search(matrix, min);
		if (ans.le >= k) return min;
		ans = search(matrix, max);
		if (ans.lt < k) return max;
		
		while (min + 1 < max) {  //  invariant: min < X < max
			int mid = min + (max - min) / 2;
			ans = search(matrix, mid);
			
			if (ans.le >= k && ans.lt < k) return mid;
			if (ans.lt >= k) max = mid;
			else min = mid;
		}

		throw new RuntimeException("invalid k: " + k);
	}
