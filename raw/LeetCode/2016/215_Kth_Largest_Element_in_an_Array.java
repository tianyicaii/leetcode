// https://leetcode.com/problems/kth-largest-element-in-an-array/


public class Solution {


	public int findKthLargest (int[] nums, int k) {

		k = nums.length - k;  // convert to index

		int left = 0;
		int right = nums.length - 1;
		
		while (true) {
			int pivot = helper(nums, left, right, k);
			if      (pivot == k) return nums[pivot];
			else if (pivot <  k) left = pivot + 1;
			else                right = pivot - 1;
		}
	}
	private int helper (int[] nums, int left, int right, int k) {
		
		int length = right - left + 1;
		if (length == 1) return left;  // only one left, partition needs at least two to avoid OOB.
		
		int pivot = (int)(Math.random() * length) + left;
		swap(nums, left, pivot);
		
		int i = left;  // invariant: everything before or at i is smaller or equal to PIVOT
		int j = right + 1;  // invariant: everything after or at j is larger or equal to PIVOT
		while (true) {
			while (nums[++i] < nums[left])
				if (i == right) break;  // all smaller
			while (nums[--j] > nums[left])
				if (j == left) break;  // all larger
			if (i < j)
				swap(nums, i, j);  // re-establish invariant
			else 
				break;  // j points last one on left side; i, j meet or cross
		}
		swap(nums, left, j);
		return j;  // pivot is at j
	}
	
	private void swap (int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}


}

