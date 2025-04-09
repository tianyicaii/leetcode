// https://leetcode.com/problems/gray-code/


public class Solution {
	

	public List<Integer> grayCode (int n) {
		List<Integer> ans = new ArrayList<>();
		ans.add(0);
		if (n == 0) return ans;
		ans.add(1);
		for (int i = 2; i <= n; i++) {
			int sz = ans.size();
			for (int j = sz - 1; j >= 0; j--) {
				ans.add(ans.get(j) | 1 << (i-1));
			}
		}
		return ans;
	}	


}

