// https://leetcode.com/problems/spiral-matrix/


public class Solution {


	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) return ans;
		int i = 0;
		int j = 0;
		int L = 0;
		int R = matrix[0].length - 1;
		int T = 0;
		int B = matrix.length - 1;
		
		while (true) {
			
			if (T > B || L > R) break;
			
			// go right
			while (j <= R) {
				ans.add(matrix[i][j]);
				j ++;
			}
			T += 1;
			i += 1;
			j -= 1;
			
			if (T > B || L > R) break;
			
			while (i <= B) {
				ans.add(matrix[i][j]);
				i ++;
			}
			R -= 1;
			j -= 1;
			i -= 1;
			
			if (T > B || L > R) break;
			
			while (j >= L) {
				ans.add(matrix[i][j]);
				j --;
			}
			B -= 1;
			i -= 1;
			j += 1;
			
			if (T > B || L > R) break;
			
			while (i >= T) {
				ans.add(matrix[i][j]);
				i --;
			}
			L += 1;
			j += 1;
			i += 1;
			
		}
		
		return ans;
	}


}

