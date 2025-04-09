// https://leetcode.com/problems/super-pow/


public class Solution {


	public int superPow (int a, int[] b) {
		if (b == null || b.length == 0) return 0;
		
		int ans = 1;
		a %= 1337;
		
		for (int i = b.length - 1; i >= 0; i--) {
			
			int p = pow(a, b[i], 1337);
			ans *= p;
			ans %= 1337;
			a = pow(a, 10, 1337);
			a %= 1337;
		}
		
		return ans;
	}
	
	
	
	public int pow (int a, int b, int mod) {
		if (b == 0) return 1;
		
		int ans = 1;
		while (b != 1) {
			if (b % 2 == 1) {
				ans *= a;
				ans %= mod;
			}
			a *= a;
			a %= mod;
			b /= 2;
		}
		return (ans * a) % mod;
	}


}

