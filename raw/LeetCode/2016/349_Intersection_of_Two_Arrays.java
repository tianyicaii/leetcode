// https://leetcode.com/problems/intersection-of-two-arrays/


public class Solution {


	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> S1 = new HashSet<>();
		Set<Integer> S2 = new HashSet<>();
		Set<Integer> I  = new HashSet<>();

		for (int i : nums1)
			S1.add(i);
		for (int i : nums2)
			S2.add(i);

		for (int i : S1) {
			if (S2.contains(i))
				I.add(i);
		}

		int[] ans = new int[I.size()];
		int i = 0;
		for (int v : I)
			ans[i++] = v;
		return ans;
	}


}

