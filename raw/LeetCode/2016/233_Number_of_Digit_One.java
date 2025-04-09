// https://leetcode.com/problems/number-of-digit-one/


public class Solution {


	// count number of 1 on each position


	public int countDigitOne (int n) {
		
		if (n <= 0) return 0;
		String s = n + "";
		int ans = 0;
		
		for (int i = 0; i < s.length(); i++) {

			int d    = s.charAt(i) - '0';
			int prev = (i == 0) ?              0 : Integer.parseInt(s.substring(0, i));
			int suff = (i == s.length() - 1) ? 0 : Integer.parseInt(s.substring(i + 1));
			
			if (d == 0) {
				ans += prev * (int) Math.pow(10, s.length() - i - 1);
			}
			else if (d == 1) {
				ans += prev * (int) Math.pow(10, s.length() - i - 1);
				ans += suff + 1;
			}
			else {  // d > 1
				ans += (prev + 1) * (int) Math.pow(10, s.length() - i - 1);
				
			}
		}
		
		return ans;
	}


}

