

public class Solution {
	

	// binary search on values


	public int findDuplicate (int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		int n = nums.length;
		int low = 1;
		int high = n-1;
		
		if (countLTE(nums, low) > 1) return low;
		
		while (low < high - 1) {
			int mid = low + (high - low) / 2;
			int cnt = countLTE(nums, mid);
			if (cnt <= mid) low = mid;
			else           high = mid;
				
		}
		return high;
	}	
	
	private int countLTE (int[] nums, int x) {
		int ans = 0;
		for (int i : nums) 
			if (i <= x) ans += 1;
		return ans;
	}


}

