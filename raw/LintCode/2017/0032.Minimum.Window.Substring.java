/*
 *  http://www.lintcode.com/en/problem/minimum-window-substring/#
 *
 *  Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
 *  Notice
 *      If there is no such window in source that covers all characters in target, return the emtpy string "".
 *      If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.
 */

	public String minWindow (String source , String target) {
		if (target.length() == 0) return "";
		
		HashSet<Character> chars = new HashSet<>();
		HashMap<Character, Integer> counts = new HashMap<>();
		int total = 0;
		for (int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			if (!counts.containsKey(c)) counts.put(c, 0);
			counts.put(c, counts.get(c) + 1);
			chars.add(c);
			total += 1;
		}

		int left = 0;
		int right = 0;
		String ans = "";
		while (right < source.length()) {
			
			while (right < source.length() && total > 0) {
				char c = source.charAt(right);
				if (chars.contains(c)) {
					if (counts.get(c) > 0) total -= 1;  // one more character matched
					counts.put(c, counts.get(c) - 1);  // can go negative
				}
				right ++;
			}
			
			while (total == 0) {  // a valid window is found
				if (ans.equals("") || ans.length() > right - left) ans = source.substring(left, right);
				char c = source.charAt(left);
				if (chars.contains(c)) {
					counts.put(c, counts.get(c) + 1);
					if (counts.get(c) > 0) total += 1;  // one character unmatched
				}
				left ++;
			}
		}
		
		return ans;
	}	
