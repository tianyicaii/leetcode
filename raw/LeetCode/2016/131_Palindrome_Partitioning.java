// https://leetcode.com/problems/palindrome-partitioning/


public class Solution {
	

	public List<List<String>> partition (String s) {
		List<List<String>> ans = new ArrayList<>();
		if (s.length() == 0) return ans;  // avoid add a an empty list
		List<String> path = new ArrayList<>();
		helper(ans, path, s, 0);
		return ans;
	}	
	private void helper (List<List<String>> ans, List<String> path, String s, int index) {
		if (index == s.length()) {
			ans.add(new ArrayList<>(path));
			return;
		}
		
		for (int i = index; i < s.length(); i++) {
			String sub = s.substring(index, i + 1);
			if (isPal(sub)) {
				path.add(sub);
				helper(ans, path, s, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}
	private boolean isPal (String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}


}

