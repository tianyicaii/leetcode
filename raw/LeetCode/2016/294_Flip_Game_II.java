// https://leetcode.com/problems/flip-game-ii/


public class Solution {
	

	Map<String, Boolean> mem = new HashMap<>();
	public boolean canWin(String s) {
		if (mem.containsKey(s)) return mem.get(s);
		Boolean ans = null;

		for (int i = 0; i + 2 <= s.length() && ans == null; i++) {
			if (s.substring(i, i + 2).equals("++")) {
				String ss = s.substring(0, i) + "--" + s.substring(i + 2);
				if (!canWin(ss)) ans = true;
				else ;  // try other moves
			}
		}
		if (ans == null)
			ans = false;

		mem.put(s, ans);
		return ans;
	}


}


