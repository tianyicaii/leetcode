// https://leetcode.com/problems/merge-sorted-array/


public class Solution {
	

	public void merge (int[] nums1, int m, int[] nums2, int n) {
		for (int k = nums1.length - 1, i = m-1, j = n-1; k >= 0; k--) {
			if      (i == -1) nums1[k] = nums2[j--];
			else if (j == -1) nums1[k] = nums1[i--];
			else {
				if (nums1[i] > nums2[j])
					nums1[k] = nums1[i--];
				else
					nums1[k] = nums2[j--];
			}
		}
	}


}

