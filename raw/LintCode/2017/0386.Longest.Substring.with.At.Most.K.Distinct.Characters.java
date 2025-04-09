/*
 *  http://www.lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/
 *
 *  Given a string s, find the length of the longest substring T that contains at most k distinct characters
 */

	public int lengthOfLongestSubstringKDistinct (String s, int k) {
		
		Map<Character, Integer> cnt = new HashMap<>();

		int left = 0;
		int right = 0;
		int max = 0;

		while (right < s.length()) {

			// add character on the right
			char c = s.charAt(right);
			int n = 0;
			if (cnt.containsKey(c)) n = cnt.get(c);
			cnt.put(c, n + 1);
			
			// adjust left
			while (cnt.size() > k) {
				char x = s.charAt(left);
				int m = cnt.get(x);
				if (m == 1) cnt.remove(x);
				else cnt.put(x, m - 1);
				left ++;
			}

			max = Math.max(max, right - left + 1);
			right ++;
		}

		return max;
	}
