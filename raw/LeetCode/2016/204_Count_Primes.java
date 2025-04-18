// https://leetcode.com/problems/count-primes/


public class Solution {


	public int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		for (int i = 2; i * i < n; i++) {
			if (isPrime[i] == false) continue;
			
			for (int j = 2; i * j < n; j++) {
				isPrime[i * j] = false;
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) count += 1;
		}
		return count;
	}	


}

