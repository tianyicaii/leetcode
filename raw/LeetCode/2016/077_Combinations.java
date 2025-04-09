// https://leetcode.com/problems/combinations/


public class Solution {
	

	// C(n, k) = C(n-1, k-1) + C(n-1, k)


	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		if (k == 0) {  // choose nothing
			List<Integer> choices = new ArrayList<>();
			ans.add(choices);
			return ans;
		}
		if (k == n) {  // choose everything
			List<Integer> choices = new ArrayList<>();
			for (int i = 1; i <= k; i++)
				choices.add(i);
			ans.add(choices);
			return ans;
		}
		
		List<List<Integer>> chooseN    = combine(n-1, k-1);
		List<List<Integer>> notChooseN = combine(n-1, k);
		for (List<Integer> choice : chooseN)
			choice.add(n);
		ans.addAll(chooseN);
		ans.addAll(notChooseN);
		
		return ans;
	}


}

