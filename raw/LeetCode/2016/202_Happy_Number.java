// https://leetcode.com/problems/happy-number/


public class Solution {


	public boolean isHappy (int n) {
		Set<Integer> seen = new HashSet<>();
		while (true) {
			if (n == 1) return true;
			if (seen.contains(n)) return false;
			seen.add(n);
			n = getNext(n);
		}
	}
	
	private int getNext (int n) {
		int ans = 0;
		while (n != 0) {
			int d = n % 10;
			ans += d * d;
			n = n / 10;
		}
		return ans;
	}


}

