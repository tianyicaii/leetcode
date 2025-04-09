// https://leetcode.com/problems/subsets-ii/


public class Solution {
	

	public List<List<Integer>> subsetsWithDup (int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		Map<Integer, Integer> counts = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int cnt = 1;
			if (counts.containsKey(nums[i]))
				cnt += counts.get(nums[i]);
			counts.put(nums[i], cnt);
		}
		ans.add(new ArrayList<>());
		for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
			int sz = ans.size();
			int x = e.getKey();
			int cnt = e.getValue();
			for (int i = 0; i < cnt; i++) {
				for (int j = i * sz; j < (i + 1) * sz; j++) {
					List<Integer> subset = new ArrayList<>(ans.get(j));
					subset.add(x);
					ans.add(subset);
				}
			}
		}
		return ans;
	}


}

