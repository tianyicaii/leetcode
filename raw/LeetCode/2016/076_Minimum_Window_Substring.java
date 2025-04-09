// https://leetcode.com/problems/minimum-window-substring/


public class Solution {
	

	public String minWindow (String s, String t) {
				
		Map<Character, Integer> T = new HashMap<>();  // positive means deficit, positive mean surplus
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int count = 1;
			if (T.containsKey(c))
				count += T.get(c);
			T.put(c, count);
		}
		
		int left = 0;
		int right = 0;
		int start = -1;
		int length = Integer.MAX_VALUE;
		int count = t.length();
		
		while (right < s.length()) {
			
		// absorb right
			char r = s.charAt(right);
			if (T.containsKey(r)) {
				int cnt = T.get(r);
				if (cnt > 0)
					count -= 1;
				T.put(r, cnt - 1);
			}
			
		// spit left
			while (count == 0) {
				if (start == -1 || length > right - left + 1) {
					start = left;
					length = right - left + 1;
				}
				char l = s.charAt(left);
				if (T.containsKey(l)) {
					int cnt = T.get(l);
					if (cnt == 0)
						count += 1;
					T.put(l, cnt + 1);
				}
				left += 1;
			}
			
		// go to next
			right += 1;
		}
		
		if (start == -1) return "";
		return s.substring(start, start + length);
	}


}

