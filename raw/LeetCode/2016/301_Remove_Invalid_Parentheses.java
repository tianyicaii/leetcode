// https://leetcode.com/problems/remove-invalid-parentheses/


public class Solution {
	

	// bfs
	

	public List<String> removeInvalidParentheses (String s) {

		List<String> ans = new ArrayList<>();
		Deque<String> bfs = new ArrayDeque<>();
		bfs.offerLast(s);
		Set<String> visited = new HashSet<>();
		visited.add(s);

		boolean found = false;
		while (!bfs.isEmpty() && !found) {
			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {
				String v = bfs.pollFirst();
				if (isValid(v)) {
					found = true;
					ans.add(v);
				}
				else {
					for (String e : getNeighbors(v)) {
						if (!visited.contains(e)) {
							bfs.offerLast(e);
							visited.add(e);
						}
					}
				}
			}
		}
		return ans;
	} 

	// get all strings be removing one ( or )
	private List<String> getNeighbors (String s) {
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == ')')
				ans.add(s.substring(0, i) + s.substring(i + 1));
		}
		return ans;
	}

	// check whether s is balanced
	private boolean isValid (String s) {
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') left += 1;
			if (c == ')') right += 1;
			if (right > left) return false;
		}
		return left == right;
	}


}

