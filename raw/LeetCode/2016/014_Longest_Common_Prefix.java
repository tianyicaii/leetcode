// https://leetcode.com/problems/longest-common-prefix/


public class Solution {


	public String longestCommonPrefix (String[] strs) {
		
		if (strs.length == 0) return "";
		
		for (int j = 0; j < strs[0].length(); j++) {
			char c = strs[0].charAt(j);
			for (int i = 1; i < strs.length; i++) {
				if (j == strs[i].length() || c != strs[i].charAt(j))
					return strs[0].substring(0, j);
			}
		}
		return strs[0];
	}


}

