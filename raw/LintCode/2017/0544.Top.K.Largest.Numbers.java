/*
 *  http://www.lintcode.com/en/problem/top-k-largest-numbers/
 *
 *  Given an integer array, find the top k largest numbers in it.
 */

	public int[] topk (int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();  // minimum PQ
		for (int i : nums) {
			pq.offer(i);
			if (pq.size() > k) pq.poll();  // poll smallest
		}

		int[] ans = new int[k];
		for (int i = k - 1; i >= 0; i--) {  // poll from small to large
			ans[i] = pq.poll();
		}
		return ans;
	}

// or, quick sort partition, find number with rank k.
