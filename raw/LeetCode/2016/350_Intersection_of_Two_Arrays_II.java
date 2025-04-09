// https://leetcode.com/problems/intersection-of-two-arrays-ii/


public class Solution {


	public int[] intersect (int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			int x = nums1[i];
			int y = nums2[j];
			if (x == y) {
				ans.add(x);
				i += 1;
				j += 1;
			}
			else if (x < y) {
				i += 1;
			}
			else {  // x > y
				j += 1;
			}
		}

		int[] ret = new int[ans.size()];
		int idx = 0;
		for (int v : ans) 
			ret[idx++] = v;
		return ret;
	}


}

