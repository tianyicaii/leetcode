/*
 *  http://www.lintcode.com/en/problem/intersection-of-two-arrays-ii/
 *
 *  Given two arrays, write a function to compute their intersection.
 *  Each element in the result should appear as many times as it shows in both arrays.
 *  The result can be in any order.
 */

	public int[] intersection (int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> intersection = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				intersection.add(nums1[i]);
				++i;
				++j;
			} else if (nums1[i] < nums2[j]) {
				++i;
			} else {
				++j;
			}
		}
		
		int [] ans = new int[intersection.size()];
		for (int k = 0; k < ans.length; k++) {
			ans[k] = intersection.get(k);
		}
		return ans;
	}

