// https://leetcode.com/problems/string-to-integer-atoi/


public class Solution {


	public int myAtoi (String str) {
		
		
		int sgn   = 1;
		int mag   = 0;
		int i     = 0;
		int n     = str.length();
		int limit = Integer.MAX_VALUE / 10;
		
		
		while (i < n && Character.isWhitespace(str.charAt(i))) i++;
		if (i < n) {
			if (str.charAt(i) == '+') i++;
			else if (str.charAt(i) == '-') {
				sgn = -1;
				i++;
			}
		}
		while (i < n && Character.isDigit(str.charAt(i))) {
			int d = str.charAt(i) - '0';
			
			if (mag > limit) {
				if (sgn == 1) return Integer.MAX_VALUE;
				else          return Integer.MIN_VALUE;
			}
			if (mag == limit) {
				if      (sgn == 1  && d >= 8) return Integer.MAX_VALUE;
				else if (sgn == -1 && d == 9) return Integer.MIN_VALUE;
			}
			
			mag = mag * 10 + d;
			i++;
		}
		
		return sgn * mag;
	}


}

