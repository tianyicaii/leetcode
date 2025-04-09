/*
 *  http://www.lintcode.com/en/problem/data-stream-median/
 *
 *  Numbers keep coming, return the median of numbers at every time a new number added.
 */


// median is max for one half and min for the other half
// this is a problem to find min / max in a stream => heap.


	private class InverseComparator implements Comparator<Integer> {
		public int compare (Integer a, Integer b) {
			return b - a;
		}
	}

	PriorityQueue<Integer> left = new PriorityQueue<Integer>(new InverseComparator());
	PriorityQueue<Integer> right = new PriorityQueue<Integer>();
	
	private void add (int i) {
		if (left.isEmpty()) left.offer(i);
		else if (i > left.peek()) right.offer(i);
		else left.offer(i);
		// invariant: left.size() == right.size() || left.size() == right.size() + 1
		if (left.size() < right.size()) left.offer(right.poll());
		else if (left.size() > right.size() + 1) right.offer(left.poll());
		else ;
	}
	
	private int getMedian () {
		return left.peek();
	}
	
	public int[] medianII(int[] nums) {
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
			ans[i] = getMedian();
		}
		return ans;
	}
