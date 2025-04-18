// https://leetcode.com/problems/shortest-palindrome/


public class Solution {


	public String shortestPalindrome (String s) {
		int i = 0; 
		int j = s.length() - 1;
		while (j >= 0) {
			if (s.charAt(i) == s.charAt(j)) i++;
			j--;
		}
		if (i == s.length()) return s;
		String suffix = s.substring(i);
		return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, i)) + suffix;
	}	


}

