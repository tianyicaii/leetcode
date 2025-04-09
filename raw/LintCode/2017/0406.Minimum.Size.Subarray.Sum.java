/*
 *  http://www.lintcode.com/en/problem/minimum-size-subarray-sum/
 *
 *  Given an array of n *positive* integers and a positive integer s,
 *  find the minimal length of a subarray of which the sum ≥ s.
 *  If there isn't one, return -1 instead.
 */


//  elements are positive, => to prove that we will land on the minimum window
//  move right side will increase sum,
//  move left side will decrease sum.

// sliding window
	public int minimumSize (int[] nums, int s) {

		int ans = Integer.MAX_VALUE;
		int left = 0;  // first element in window
		int right = 0;  // last element in window
		int sum = 0;
		
		while (right < nums.length) {
			sum += nums[right];  // right points to last element of subarray

			while (sum >= s) {  // a valid window is found
				ans = Math.min(ans, right - left + 1);
				sum -= nums[left++];  // left points element before first of subarray
			}

			right ++;  // right points elements after last
		}
		
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}



	public int minimumSize (int[] nums, int s) {
		int[] prefix = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) prefix[i] = prefix[i-1] + nums[i-1];
		if (prefix[nums.length] < s) return -1;
		
		int left = 0;
		int right = 0;
		int ans = Integer.MAX_VALUE;

		while (true) {
			while (right <= nums.length && prefix[right] - prefix[left] < s) right++;
			if (right > nums.length) break;
			// a valid window is found here
			ans = Math.min(ans, right - left);
			left ++;
		}
		return ans;
	}
