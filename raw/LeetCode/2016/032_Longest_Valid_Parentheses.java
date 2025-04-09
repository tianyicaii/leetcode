// https://leetcode.com/problems/longest-valid-parentheses/


public class Solution {


	// DP


	public int longestValidParentheses (String s) {
		int max = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '(') continue;
			else {  // ')'
				if (s.charAt(i-1) == '(') {  // "...()"
					dp[i] = 2;  // one pair
					if (i - 2 >= 0)
						dp[i] += dp[i-2];  // plus previous
				}
				else {  // "...))"
					if (dp[i-1] == 0) continue;  // previous is invalid
					int left = i - dp[i-1] - 1;
					if (left >= 0 && s.charAt(left) == '(') {  // outer nested pair
						dp[i] = dp[i-1] + 2;
						if (left - 1 >= 0)
							dp[i] += dp[left - 1];  // plus previous
					}
				}
				max = Math.max(dp[i], max);
			}
		}
		return max;
	}	




	public int longestValidParentheses (String s) {

		Deque<Integer> stack = new ArrayDeque<>();
		int max = 0;
		
		for (int i = 0, acc = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') stack.offerLast(i);
			else {
				if (stack.isEmpty()) acc = 0;  // cannot accumulate
				else {
					int left = stack.pollLast();
					int len;
					if (stack.isEmpty()) {  // one nested group done
						acc += i - left + 1;
						len = acc;
					}
					else {  // inner pair
						len = i - stack.peekLast();
					}
					max = Math.max(max, len);
				}
			}
		}
		
		return max;
	}	


}

