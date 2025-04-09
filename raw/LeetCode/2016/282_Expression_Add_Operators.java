// https://leetcode.com/problems/expression-add-operators/


public class Solution {

	
	public List<String> addOperators (String num, int target) {
		List<String> ans = new ArrayList<>();
		String path = "";
		helper(ans, path, num, 0, target, 0, 0);
		return ans;
	}

	private void helper(List<String> ans, String path, String num, int index, int target, long prevTotal, long multiplier) {
		if (index == num.length()) {
			if (prevTotal == target)
				ans.add(path);
			return;
		}
		for (int i = index; i < num.length(); i++) {
			if (i != index && num.charAt(index) == '0') return;  // not start with "0" except "0"

			long operand = Long.parseLong(num.substring(index, i + 1));

			if (index == 0) {
				helper(ans, "" + operand, num, i + 1, target, operand, operand);
			}
			else {
				helper(ans, path + "+" + operand, num, i + 1, target, prevTotal + operand,   operand);
				helper(ans, path + "-" + operand, num, i + 1, target, prevTotal - operand, - operand);
				helper(ans, path + "*" + operand, num, i + 1, target, (prevTotal - multiplier) + (multiplier * operand), (multiplier * operand));
			}
		}
	}


}

