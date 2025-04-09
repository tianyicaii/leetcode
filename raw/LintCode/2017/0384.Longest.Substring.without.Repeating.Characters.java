/*
 *  http://www.lintcode.com/en/problem/longest-substring-without-repeating-characters/
 *
 *  Given a string, find the length of the longest substring without repeating characters.
 */

	public int lengthOfLongestSubstring (String s) {
		Set<Character> seen = new HashSet<>();
		
		int left = 0;
		int right = 0;
		int max = 0;

		while (right < s.length()) {

			while (seen.contains(s.charAt(right))) {
				seen.remove(s.charAt(left++));
			}

			seen.add(s.charAt(right));
			max = Math.max(max, right - left + 1);
			right ++;
		}
		
		return max;
	}
