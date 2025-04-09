// https://leetcode.com/problems/excel-sheet-column-number/


public class Solution {


	public int titleToNumber(String s) {
		int ans = 0;
		for (int i = s.length() - 1, unit = 1; i >= 0; i--, unit *= 26) {
			ans += (s.charAt(i) - '@') * unit;
		}
		return ans;
	}	


}

