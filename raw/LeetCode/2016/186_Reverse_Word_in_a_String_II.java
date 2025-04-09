// https://leetcode.com/problems/reverse-words-in-a-string-ii/


public class Solution {


	public void reverseWords (char[] s) {

		reverseInterval(s, 0, s.length - 1);
		int i = 0;
		while (i < s.length) {
			int j = i + 1;
			while (j < s.length && !Character.isWhitespace(s[j])) j ++;
			reverseInterval(s, i, j-1);
			i = j + 1;
		}
	}
	
	public void reverseInterval (char[] s, int i, int j) {
		for ( ; i < j; i++, j--) swap(s, i, j);
	}
	
	public void swap (char[] s, int i, int j) {
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}


}

