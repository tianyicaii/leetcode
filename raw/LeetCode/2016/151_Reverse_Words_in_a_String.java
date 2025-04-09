// https://leetcode.com/problems/reverse-words-in-a-string/


public class Solution {
	

	public String reverseWords(String s) {
		
		StringBuilder ans = new StringBuilder();
		int i = s.length() - 1;
		while (i >= 0) {
			while (i >= 0 && Character.isWhitespace(s.charAt(i))) i--;
			if (i < 0) break;
			int j = i-1;
			while (j >= 0 && !Character.isWhitespace(s.charAt(j))) j--;
			String word = s.substring(j + 1, i + 1);
			ans.append(word);
			ans.append(' ');
			i = j - 1;
		}
		
		if (ans.length() == 0) return "";  // nothing found. no trailing space.
		return ans.substring(0, ans.length() - 1);  // remove last space
		
	}


}

