// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/


public class Solution {


	// given curr, we know the next possible smallest integer after it.


	public class Cell implements Comparable<Cell> {
		int idx;
		int val;
		public Cell (int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		public int compareTo (Cell other) {
			return this.val - other.val;
		}
	}
	
	public int kthSmallest (int[][] matrix, int k) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		Set<Integer> visited = new HashSet<>();
		PriorityQueue<Cell> heap = new PriorityQueue<>();
		
		Cell curr = new Cell(0, matrix[0][0]);
		visited.add(curr.idx);
		
		for (int i = 2; i <= k; i++) {
			
			int r = curr.idx / n;  // convert index back to coordinate
			int c = curr.idx % n;
			
			if (r + 1 < m) {  // go down
				int idx = (r + 1) * n + c;
				if (!visited.contains(idx)) {
					heap.offer(new Cell(idx, matrix[r + 1][c]));
					visited.add(idx);  // mark visited
				}
			}
			
			if (c + 1 < n) {  // go right
				int idx = r * n + (c + 1);
				if (!visited.contains(idx)) {
					heap.offer(new Cell(idx, matrix[r][c + 1]));
					visited.add(idx);  // mark visited
				}
			}
			
			// get next smallest
			curr = heap.poll();  // get i th smallest
		}
		return curr.val;
	}


}

