// https://leetcode.com/problems/decode-ways/


public class Solution {
	

	public int numDecodings(String s) {
		
		int n = s.length();
		if (n == 0) return 0;
		if (s.charAt(0) == '0') return 0;
		
		int[] dp = new int[3];
		dp[0] = 1;  // successfully decoded  s.length    !=  0
		dp[1] = 1;  // one way to decode,    s.charAt(0) != '0'
		
		for (int i = 2; i <= s.length(); i++) {  // length of substring
			char b = s.charAt(i-1);
			char a = s.charAt(i-2);
			
			if (a == '0') {
				if (b == '0') dp[i % 3] = 0;  // illegal
				else          dp[i % 3] = dp[(i-1) % 3];  // have to split
			}
			else if (a == '1') {
				if (b == '0') dp[i % 3] = dp[(i-2) % 3];  // have to bundle
				else          dp[i % 3] = dp[(i-2) % 3] + dp[(i-1) % 3];  // either way
			}
			else if (a == '2') {
				if      (b == '0') dp[i % 3] = dp[(i-2) % 3];  // have to bundle
				else if (b >  '6') dp[i % 3] = dp[(i-1) % 3];  // have to split
				else               dp[i % 3] = dp[(i-2) % 3] + dp[(i-1) % 3];  // either way
			}
			else {  // a > '2'
				if (b == '0') dp[i % 3] = 0;  // illegal
				else          dp[i % 3] = dp[(i-1) % 3];  // have to split
			}
		}
		return dp[n % 3];
	}	


}

