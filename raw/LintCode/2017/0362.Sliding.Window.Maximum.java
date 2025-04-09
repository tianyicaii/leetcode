/*
 *  http://www.lintcode.com/en/problem/sliding-window-maximum/
 *
 *  Given an array of n integer with duplicate number, and a moving window(size k),
 *  move the window at each iteration from the start of the array,
 *  find the maximum number inside the window at each moving.
 */

// deque
// once we see a more recent and larger number, previous smaller ones are not needed,
// for max numbers, keep original order

	ArrayList<Integer> ans = new ArrayList<>();
	Deque<Integer> dq = new ArrayDeque<>();
	
	void enqueue (int i) {
		while (!dq.isEmpty() && dq.peekLast() < i) dq.pollLast();
		dq.offerLast(i);
	}
	
	void dequeue (int i) {
		if (dq.peekFirst() == i) dq.pollFirst();
	}
	
	public ArrayList<Integer> maxSlidingWindow (int[] nums, int k) {

		int i = 0;
		for (; i < k - 1; i++) {
			enqueue(nums[i]);
		}
		for (; i < nums.length; i++) {
			enqueue(nums[i]);
			ans.add(dq.peekFirst());
			dequeue(nums[i - k + 1]);
		}		
		return ans;
	}
