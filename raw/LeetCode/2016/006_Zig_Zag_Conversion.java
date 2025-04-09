// https://leetcode.com/problems/zigzag-conversion/


public class Solution {


	public String convert (String s, int numRows) {
		
		if (numRows == 1) return s;  // avoid out of bound
		
		StringBuilder[] rows = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++)
			rows[i] = new StringBuilder();
		
		
		int p = 0;
		int r = 0;
		while (p != s.length()) {
			
			while (p != s.length() && r < numRows) {  // down
				rows[r].append(s.charAt(p));
				r ++;
				p ++;
			}
			r -= 2;  // second one to last
			
			while (p != s.length() && r >= 0) {  // up
				rows[r].append(s.charAt(p));
				r --;
				p ++;
			}
			r += 2;  // second
		}
		

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < numRows; i++)
			ans.append(rows[i]);
		return ans.toString();
	}


}

