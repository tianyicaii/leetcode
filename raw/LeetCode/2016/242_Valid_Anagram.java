// https://leetcode.com/problems/valid-anagram/


public class Solution {


	public boolean isAnagram (String s, String t) {
		
		// 1. sort then compare
		// 2. hash table
		
		if (s.length() != t.length()) return false;
		Map<Character, Integer> counts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (counts.containsKey(sc))
				counts.put(sc, counts.get(sc) + 1);
			else
				counts.put(sc, 1);
			if (counts.containsKey(tc))
				counts.put(tc, counts.get(tc) - 1);
			else
				counts.put(tc, -1);
		}
		for (Map.Entry<Character, Integer> e : counts.entrySet())
			if (e.getValue() != 0) return false;
		return true;
		
	}


}

