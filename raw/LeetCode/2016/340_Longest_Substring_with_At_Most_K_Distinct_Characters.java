// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/


public class Solution {


	public int lengthOfLongestSubstringKDistinct (String s, int k) {
		if (s == null || s.length() == 0 || k == 0) return 0;

		Map<Character, Integer> inWindow = new HashMap<>();
		int i = 0;
		int j = 0;
		int max = 0;
		while (j < s.length()) {
			char R = s.charAt(j);
			if (inWindow.containsKey(R))
				inWindow.put(R, inWindow.get(R) + 1);
			else
				inWindow.put(R, 1);

			while (inWindow.size() > k) {
				char L = s.charAt(i);
				inWindow.put(L, inWindow.get(L) - 1);
				if (inWindow.get(L) == 0)
					inWindow.remove(L);
				i++;
			}
			max = Math.max(max, j - i + 1);
			j++;
		}
		return max;
	}


}

