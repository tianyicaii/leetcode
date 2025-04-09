// https://leetcode.com/problems/generate-parentheses/


public class Solution {


	public List<String> generateParenthesis (int n) {
		List<String> ans = new ArrayList<>();
		helper(ans, new StringBuilder(), n, n);
		return ans;
	}
	
	private void helper (List<String> ans, StringBuilder path, int left, int right) {
		if (right == 0) {
			ans.add(path.toString());
			return;
		}
		
		if (left == right) {
			path.append('(');
			helper(ans, path, left-1, right);
			path.deleteCharAt(path.length() - 1);
			return;
		}
		else if (left == 0) {
			path.append(')');
			helper(ans, path, left, right-1);
			path.deleteCharAt(path.length() - 1);
			return;
		}
		else {
			path.append('(');
			helper(ans, path, left-1, right);
			path.deleteCharAt(path.length() - 1);
			path.append(')');
			helper(ans, path, left, right-1);
			path.deleteCharAt(path.length() - 1);
			return;
		}
	}


}

