// https://leetcode.com/problems/implement-strstr/


public class Solution {
	

	public int strStr (String haystack, String needle) {
		
		int n = haystack.length();
		int m = needle.length();
		
		for (int i = 0; i + m <= n; i++) {
			boolean found = true;
			for (int j = 0; j < m && found; j++) {
				if (needle.charAt(j) != haystack.charAt(i + j)) found = false;
			}
			if (found) return i;
		}
		return -1;
		
	}
	

}

