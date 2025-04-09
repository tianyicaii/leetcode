// https://leetcode.com/problems/word-pattern/


public class Solution {
	

	public boolean wordPattern (String pattern, String str) {
		String[] strs = str.split("\\s+");  // split by spaces
		if (pattern.length() != strs.length) return false;
		Map<Character, String> p2s = new HashMap<>();
		Map<String, Character> s2p = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			
			char p = pattern.charAt(i);
			String s = strs[i];
			
			if (p2s.containsKey(p))
				if (!p2s.get(p).equals(s)) return false;
			if (s2p.containsKey(s))
				if (s2p.get(s) != p) return false;
			
			p2s.put(p, s);
			s2p.put(s, p);

		}
		return true;
	}


}

