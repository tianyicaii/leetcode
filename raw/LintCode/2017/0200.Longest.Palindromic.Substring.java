/*
 *  http://www.lintcode.com/en/problem/longest-palindromic-substring/
 *
 *  Given a string S, find the longest palindromic substring in S.
 *  You may assume that the maximum length of S is 1000,
 *  and there exists one unique longest palindromic substring.
 */

// find all palindromes
// for palindroms that share the same axis, one can lead to its next larger one in constant time (dp)

	int left = 0;
	int right = 0;
	String s;

	public String longestPalindrome (String s) {
		if (s.length() == 0) return "";
		this.s = s;
		for (int i = 0; i < s.length(); i++) {
			expand(i-1, i+1);
		}
		for (int i = 0; i < s.length() - 1; i++) {
			expand(i, i+1);
		}
		return s.substring(left, right + 1);
	}	
	
	void expand (int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l-=1;
			r+=1;
		}
		l += 1;
		r -= 1;
		if (r - l + 1 > right - left + 1) {
			left = l;
			right = r;
		}
	}

