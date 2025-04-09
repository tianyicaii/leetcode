// https://leetcode.com/problems/median-of-two-sorted-arrays/


public class Solution {


	public double findMedianSortedArrays (int[] nums1, int[] nums2) {
		
		int m = nums1.length;
		int n = nums2.length;
		
		if ((m + n) % 2 == 0) {
			int k1 = (m + n) / 2 - 1;
			int k2 = (m + n) / 2;
			return (helper(nums1, 0, m, nums2, 0, n, k1) +
					helper(nums1, 0, m, nums2, 0, n, k2)) / 2.0;
		}
		else {
			int k = (m + n) / 2;
			return helper(nums1, 0, m, nums2, 0, n, k);
		}
	}
	
	private int helper (int[] nums1, int idx1, int m, int[] nums2, int idx2, int n, int k) {
		
		if (m == 0) return nums2[idx2 + k];  // nums1 is exhausted
		if (n == 0) return nums1[idx1 + k];  // nums2 ..
		if (k == 0) return Math.min(nums1[idx1], nums2[idx2]);
		
		
		// to eliminate k/2 elements from nums1 and nums2
		int r1 = idx1 + Math.min(m, (k+1)/2) - 1;  // r1 points to the last elements on the left sub-array
		int r2 = idx2 + Math.min(n, (k+1)/2) - 1;  // r2 ..
		
		
		if (nums1[r1] > nums2[r2]) {
			int len = r2 - idx2 + 1;
			return helper(nums1, idx1, m, nums2, r2 + 1, n - len, k - len);
		}
		else {
			int len = r1 - idx1 + 1;
			return helper(nums1, r1 + 1, m - len, nums2, idx2, n, k - len);
		}
	}


}

