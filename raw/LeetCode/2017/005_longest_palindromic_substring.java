import java.util.*;

public class Solution {
	
	public String longestPalindrome (String s) {
		
		if (s.length() == 0) return "";
		int maxLen = 0;
		int maxIdx = 0;

		boolean[] prev = new boolean[s.length()];
		boolean[] curr = new boolean[s.length()];
		boolean[] next = new boolean[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			prev[i] = true;
			maxIdx = i;
			maxLen = 1;
		}
		
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				curr[i] = true;
				maxIdx = i;
				maxLen = 2;
			}
			else
				curr[i] = false;
		}
		
		for (int len = 3; len <= s.length(); ++len) {
			for (int i = 0; i <= s.length() - len; i++) {
				next[i] = prev[i + 1] && (s.charAt(i) == s.charAt(i + len - 1));
				if (next[i]) {
					maxIdx = i;
					maxLen = len;
				}
			}
			prev = curr;
			curr = next;
			next = new boolean[s.length()];
		}
		
		return s.substring(maxIdx, maxIdx + maxLen);
	}

}


import java.util.*;

public class Solution {

	public String longestPalindrome (String s) {
		
		if (s.length() == 0) return "";
		int maxLen = 0;
		int maxIdx = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int len = helper(s, i, i);
			if (len > maxLen) {
				maxLen = len;
				maxIdx = i - len / 2;
			}
			len = helper(s, i, i + 1);
			if (len > maxLen) {
				maxLen = len;
				maxIdx = i - (len / 2 - 1);
			}
		}

		return s.substring(maxIdx, maxIdx + maxLen);
	}

	int helper (String s, int left, int right) {
		int ans = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			ans = right - left + 1;
			left --;
			right ++;
		}
		return ans;
	}
}
