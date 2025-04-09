// https://leetcode.com/problems/reverse-integer/


public class Solution {


	public int reverse(int x) {
		
		
		int limit = Integer.MAX_VALUE / 10;
		int ans = 0;
		
		
		while (x != 0) {
			
			int d = x % 10;
			
			if (x > 0) {
				if (ans >  limit) return 0;
				if (ans == limit && d > 7) return 0;
			}
			else {  // x <= 0
				if (ans <  -limit) return 0;
				if (ans == -limit && d == -9) return 0;
			}
			
			ans = ans * 10 + d;
			x /= 10;
		}
		
		
		return ans;
	}
	

}

