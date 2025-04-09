/*
 *  http://www.lintcode.com/en/problem/kth-largest-element-ii/
 *
 *  Find K-th largest element in an array. and N is much larger than k.
 *
 */

	public int kthLargestElement2 (int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();  // minimum PQ
		for (int i : nums) {
			pq.offer(i);
			if (pq.size() > k) pq.poll();  // poll smallest
		}
		return pq.poll();
	}	


// or, quick selection