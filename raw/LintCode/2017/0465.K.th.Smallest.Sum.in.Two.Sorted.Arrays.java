/*
 *  http://www.lintcode.com/en/problem/kth-smallest-sum-in-two-sorted-arrays/
 *
 *  Given two integer arrays sorted in ascending order and an integer k.
 *  Define sum = a + b, where a is an element from the first array and b is an element from the second one.
 *  Find the kth smallest sum out of all possible sums.
 */


//  heap
//  BFS-like, using heap to impose order
	private class Cell implements Comparable<Cell> {
		int i;
		int j;
		int s;
		public Cell (int i, int j, int s) {
			this.i = i;
			this.j = j;
			this.s = s;
		}
		public int compareTo (Cell other) {
			return this.s - other.s;
		}
	}
	
	private boolean inBound (int[] A, int a, int[] B, int b) {
		return a >= 0 && a < A.length && b >= 0 && b < B.length;
	}

	public int kthSmallestSum (int[] A, int[] B, int k) {

		boolean[][] visited = new boolean[A.length][B.length];
		PriorityQueue<Cell> pq = new PriorityQueue<>();
		Cell first = new Cell(0, 0, A[0] + B[0]);
		pq.offer(first);
		visited[0][0] = true;
		
		for (int i = 0; i < k; i++) {
			Cell curr = pq.poll();
			if (i == k - 1) return curr.s;
			
			//  move in A
			if (inBound(A, curr.i + 1, B, curr.j) && !visited[curr.i + 1][curr.j]) {
				pq.offer(new Cell(curr.i + 1, curr.j, A[curr.i + 1] + B[curr.j]));
				visited[curr.i + 1][curr.j] = true;
			}
			//  move in B
			if (inBound(A, curr.i, B, curr.j + 1) && !visited[curr.i][curr.j + 1]) {
				pq.offer(new Cell(curr.i, curr.j + 1, A[curr.i] + B[curr.j + 1]));
				visited[curr.i][curr.j + 1] = true;
			}
		}
		
		throw new IllegalArgumentException("k = " + k);
	}




//  binary search
	class Range {
		int lt = 0;
		int le = 0;
	}
	
	Range search (int[] A, int[] B, int v) {
		Range ans = new Range();
		
		//  find number elements that are smaller than v
		int i = A.length - 1;
		int j = 0;
		while (i >= 0 && j < B.length) {
			int sum = A[i] + B[j];
			if (sum < v) {
				j ++;
				ans.lt += i + 1;
			} else {
				i--;
			}
		}

		//  find number of elements that are less than or equal to v
		i = A.length - 1;
		j = 0;
		while (i >= 0 && j < B.length) {
			int sum = A[i] + B[j];
			if (sum <= v) {
				j ++;
				ans.le += i + 1;
			} else {
				i --;
			}
		}
		return ans;
	}

	public int kthSmallestSum (int[] A, int[] B, int k) {
		
		int min = A[0] + B[0];
		int max = A[A.length - 1] + B[B.length - 1];
		
		Range ret = search(A, B, min);
		if (ret.le >= k) return min;
		ret = search(A, B, max);
		if (ret.lt < k) return max;
		
		while (min < max - 1) {
			
			int mid = min + (max - min) / 2;
			ret = search(A, B, mid);
			
			if (ret.lt < k && ret.le >= k) return mid;
			if (ret.le < k) min = mid;
			else max = mid;
		}
		
		throw new IllegalArgumentException("invalid k: " + k);
	}
