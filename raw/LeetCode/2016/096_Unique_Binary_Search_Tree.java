// https://leetcode.com/problems/unique-binary-search-trees/


public class Solution {
	

	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;  // empty tree
		dp[1] = 1;  // single node
		for (int i = 2; i <= n; i++) {  // size
			for (int j = 1; j <= i; j++) {  // root value
				dp[i] += dp[j-1] * dp[i-j];
			}
		}
		return dp[n];
	}


}

