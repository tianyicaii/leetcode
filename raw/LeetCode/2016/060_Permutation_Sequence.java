// https://leetcode.com/submissions/detail/70108795/


public class Solution {


	public String getPermutation (int n, int k) {
		
		
	// for sequence of length i, there are fact[i] permutations
		int[] facts = new int[n + 1];
		facts[0] = 1;
		for (int i = 1; i <= n; i++) facts[i] = facts[i-1] * i;
		
		
		k = k - 1;  // this many permutations need to be skipped, 0 based index
		boolean[] used = new boolean[n + 1];  // is digit i used?
		
		
		StringBuilder perm = new StringBuilder();
		for (int i = n; i >= 1; i--) {  // number of digits to be decided
			
			
			int unit = facts[i - 1];
			int index = k / unit;  // index for un-used digits


			int d = 1;
			int count = 0;  // number of unused digits skipped
			while (true) {
				if (used[d]) { d += 1; continue;}
				else if (count == index) { break; }
				else { d += 1; count += 1; }
			}
			perm.append(d);
			used[d] = true;

			
			k -= index * facts[i - 1];
		}
		
		return perm.toString();
	}


}

