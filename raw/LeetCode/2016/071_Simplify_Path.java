// https://leetcode.com/problems/simplify-path/
// Given an absolute path for a file (Unix style), simplify it

public class Solution {	

	public String simplifyPath (String path) {
		String[] dirs = path.split("/");
		Deque<String> P = new ArrayDeque<>();
		for (String dir : dirs) {
			if (dir.equals("")) continue;  // ignore
			else if (dir.equals(".")) continue;  // ignore
			else if (dir.equals("..")) {
				if (P.isEmpty()) continue;
				else P.pollLast();  // go back
			}
			else P.offerLast(dir);
		}
		StringBuilder ans = new StringBuilder();
		ans.append("/");
		while (!P.isEmpty()) ans.append(P.pollFirst() + "/");
		if (ans.length() == 1) return ans.toString();
		else return ans.substring(0, ans.length() - 1);
	}


}


