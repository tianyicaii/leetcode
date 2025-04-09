// https://leetcode.com/problems/remove-duplicate-letters/


public class Solution {


	public String removeDuplicateLetters (String s) {
		
		// find each letter's bottom line
		if (s.length() <= 1) return s;
		Map<Character, Integer> lastIndex = new HashMap<>();
		for (int i = s.length() - 1; i >= 0 && lastIndex.size() < 26; i--) {
			char c = s.charAt(i);
			if (!lastIndex.containsKey(c))
				lastIndex.put(c, i);
		} 
		
		
		// get next one to extract
		char next = s.charAt(0);
		for (int i = 0; ; i++) {
			char c = s.charAt(i);
			if (c < next) next = c;
			if (lastIndex.get(c) == i) break;  // c cannot be pushed back even further to give up to other 
		}
		
		
		// get sub-problem
		int i = 0;
		while (s.charAt(i) > next) i++;  // skip all letters that have back-offed
		String sub = s.substring(i + 1).replaceAll("" + next, "");
		return next + removeDuplicateLetters(sub.toString());
	}


}

