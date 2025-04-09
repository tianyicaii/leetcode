// https://leetcode.com/problems/word-break/


public class Solution {
	

	public boolean wordBreak (String s, Set<String> wordDict) {
		
		int wordMaxLen = 0;
		for (String word : wordDict) {
			if (word.length() > wordMaxLen) wordMaxLen = word.length();
		}
		
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {  // length of sub-problem
			for (int j = 1; j <= i && j <= wordMaxLen && !dp[i]; j++) {  // length of last segment
				if (wordDict.contains(s.substring(i-j, i)) && dp[i-j]) dp[i] = true;
			}
		}
		
		return dp[s.length()];
	}	


}

