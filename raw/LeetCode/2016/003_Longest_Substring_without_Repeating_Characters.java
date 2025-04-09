// https://leetcode.com/problems/longest-substring-without-repeating-characters/


public class Solution {


	public int lengthOfLongestSubstring (String s) {
		
		
		Set<Character> inWindow = new HashSet<>();
		
		
		int left = 0;
		int right = 0;
		int max = 0;
		
		
		while (right < s.length()) {
			while (inWindow.contains(s.charAt(right))) {
				inWindow.remove(s.charAt(left));
				left ++;
			}
			inWindow.add(s.charAt(right));
			max = Math.max(max, right - left + 1);
			right ++;
		}
		
		
		return max;
	}


}

