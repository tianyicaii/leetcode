// https://leetcode.com/problems/isomorphic-strings/


public class Solution {


	// one to one correspondent
	public boolean isIsomorphic (String s, String t) {
		return isFunction(s, t) && isFunction(t, s);
	}	
	
	
	// can map letters in s to letters in t, same letter in s not mapped to different ones in t
	public boolean isFunction (String s, String t) {
		if (s.length() != t.length()) return false;
		Map<Character, Character> S2T = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (S2T.containsKey(a)) {
				if (S2T.get(a) != b) return false;
			}
			else {
				S2T.put(a, b);
			}
		}
		return true;
	}


}

