// https://leetcode.com/problems/spiral-matrix-ii/


public class Solution {


	public int[][] generateMatrix (int n) {
		if (n == 0) return new int[][] {};
		
		int i = 0;
		int j = 0;
		int x = 1;
		int T = 0;
		int L = 0;
		int B = n-1;
		int R = n-1;
		int[][] ans = new int[n][n];
		
		while (true) {
			
			if (L > R || T > B) break;
			while (j <= R) {
				ans[i][j] = x;
				x ++;
				j ++;
			}
			T += 1;
			i += 1;
			j -= 1;
			
			
			if (L > R || T > B) break;
			while (i <= B) {
				ans[i][j] = x;
				x ++;
				i ++;
			}
			R -= 1;
			j -= 1;
			i -= 1;
			
			
			if (L > R || T > B) break;
			while (j >= L) {
				ans[i][j] = x;
				x ++;
				j --;
			}
			B -= 1;
			i -= 1;
			j += 1;
			
			
			if (L > R || T > B) break;
			while (i >= T) {
				ans[i][j] = x;
				x ++;
				i --;
			}
			L += 1;
			j += 1;
			i += 1;
			
		}
		
		return ans;
	}


}

