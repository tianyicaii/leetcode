// https://leetcode.com/problems/reverse-string/


public class Solution {


	public String reverseString (String s) {
		char[] c = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			swap(c, i, j);
		}
		return new String(c);
	}	
	
	public void swap (char[] c, int i, int j) {
		char t = c[i];
		c[i]   = c[j];
		c[j]   = t;
	}


}

