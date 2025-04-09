/*
 *  http://www.lintcode.com/en/problem/heapify/
 *
 *  Given an integer array, heapify it into a min-heap array.
 *  For a heap array A, A[0] is the root of heap,
 *  and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 */


	public void heapify (int[] A) {
		for (int i = A.length / 2 - 1; i >= 0; i--)  // for A.length / 2 and onwards, they do not have children. 
			sink(A, i);
	}
	
	private void sink (int[] A, int x) {
		while (true) {
			int y = 2 * x + 1;
			if (y >= A.length) return;  // lowest level
			if (y + 1 < A.length) y = (A[y] < A[y+1]) ? y : y + 1;  // get min child
			if (A[x] <= A[y]) return;  // minimum heap
			swap(A, x, y);
			x = y;
		}
	}
	
	private void swap (int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
