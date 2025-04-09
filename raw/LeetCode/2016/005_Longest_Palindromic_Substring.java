// https://leetcode.com/problems/longest-palindromic-substring/


public class Solution {


	public String longestPalindrome(String s) {
		
		String ans = "";
		int max = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int l1 = helper(s, i, i);  // odd length
			if (l1 > max) {
				max = l1;
				int hf = (l1 - 1) / 2;  // exclude middle one
				ans = s.substring(i - hf, i + hf + 1);
			}
			int l2 = helper(s, i, i+1);  // even length
			if (l2 > max) {
				max = l2;
				int hf = l2 / 2;  // including middle one
				ans = s.substring(i - hf + 1, i + hf + 1);
			}
		}
		
		return ans;
	}

	private int helper (String s, int left, int right) {
		
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) != s.charAt(right)) break;
			left --;
			right ++;
		}
		return right - left + 1 - 2;
	}

	
}

