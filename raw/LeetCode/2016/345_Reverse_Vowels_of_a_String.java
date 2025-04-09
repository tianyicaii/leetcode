// https://leetcode.com/problems/reverse-vowels-of-a-string/


public class Solution {


	public String reverseVowels (String s) {
		if (s.length() <= 1) return s;

		char[] c = s.toCharArray();
		int i = -1;
		int j = s.length();
		int L = 0;
		int R = s.length() - 1;

		while (true) {

			while (!isVowel(c[++i]))
				if (i == R) break;
			while (!isVowel(c[--j]))
				if (j == L) break;
			if (i < j) {
				swap(c, i, j);
			}
			else
				break;
		}

		return new String(c);
	}

	private boolean isVowel (char c) {
		return "aeiouAEIOU".indexOf(c) != -1;
	}
	
	private void swap (char[] c, int i, int j) {
		char t = c[i];
		c[i]   = c[j];
		c[j]   = t;
	}


}

