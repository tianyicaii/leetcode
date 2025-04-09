// https://leetcode.com/problems/word-pattern-ii/


public class Solution {
	

	public boolean wordPatternMatch (String pattern, String str) {
		Map<Character, String> p2s = new HashMap<>();
		Map<String, Character> s2p = new HashMap<>();
		return helper(pattern, 0, str, 0, p2s, s2p);
	}	
	
	private boolean helper (String pattern, int pIdx, String str, int sIdx, Map<Character, String> p2s, Map<String, Character> s2p) {
		if (pIdx == pattern.length() && sIdx == str.length()) return true;
		if (pIdx == pattern.length() || sIdx == str.length()) return false;
		
		char p = pattern.charAt(pIdx);
		
		if (p2s.containsKey(p)) {
			String ss = p2s.get(p);
			if (!str.startsWith(ss, sIdx)) return false;
			else return helper(pattern, pIdx + 1, str, sIdx + ss.length(), p2s, s2p);  // a bug was caused by missing "return"
		}
		
		for (int i = sIdx + 1; i <= str.length(); i++) {  // i is ending index for substring
			String s = str.substring(sIdx, i);
			if (s2p.containsKey(s)) continue;  // keep trying
			
			p2s.put(p, s);
			s2p.put(s, p);
			
			if (helper(pattern, pIdx + 1, str, i, p2s, s2p)) return true;
			
			p2s.remove(p);
			s2p.remove(s);
		}
		return false;
	}


}

