// https://leetcode.com/problems/count-numbers-with-unique-digits/


public class Solution {


	// dfs


	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 0;
		n = Math.min(n, 10);  // at most 10
		
		boolean[] visited = new boolean[10];
		int ans = 10;
		for (int len = 2; len <= n; len ++) {  // special case for "0"
			for (int i = 1; i <= 9; i++) {
				visited[i] = true;
				ans += helper(i + "", visited, len);
				visited[i] = false;
			}
		}
		return ans;
	}
	
	private int helper (String path, boolean[] visited, int length) {
		if (path.length() == length) return 1;
		int ans = 0;
		for (int i = 0; i <= 9; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				ans += helper(path + i, visited, length);
				visited[i] = false;
			}
		}
		return ans;
	}




	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		if (n == 1) return 10;
		int ans = 10;
		for (int i = 1, opt = 9, prev = 9; i < n; i++, opt -= 1) {
			prev *= opt;
			ans += prev;
		}	
		return ans;
	}


}

