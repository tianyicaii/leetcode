// https://leetcode.com/problems/length-of-last-word/


public class Solution {


	public int lengthOfLastWord (String s) {
		int i = s.length() - 1;
		while (i >= 0 &&  Character.isWhitespace(s.charAt(i))) i--;
		int j = i;
		while (j >= 0 && !Character.isWhitespace(s.charAt(j))) j--;
		return i - j;
	}


}

