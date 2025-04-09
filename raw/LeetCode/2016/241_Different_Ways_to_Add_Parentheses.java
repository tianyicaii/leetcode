// https://leetcode.com/problems/different-ways-to-add-parentheses/


public class Solution {


	Map<String, List<Integer>> mem = new HashMap<>();
	public List<Integer> diffWaysToCompute (String input) {
		if (mem.containsKey(input)) return mem.get(input);
		List<Integer> ans = new ArrayList<>();
		
		
		boolean hasOperator = false;
		
		for (int i = 0; i < input.length(); i++) {
			int c = input.charAt(i);
			if ("+-*/".indexOf(c) != -1) {  // operator
				hasOperator = true;
				List<Integer> left  = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i+1));
				for (int l : left) {
					for (int r : right) {
						if      (c == '+') ans.add(l + r);
						else if (c == '-') ans.add(l - r);
						else               ans.add(l * r);
					}
				}
			}
		}

		if (hasOperator == false) ans.add(Integer.parseInt(input));
		
		mem.put(input, ans);
		return ans;
	}


}

