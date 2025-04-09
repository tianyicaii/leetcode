/*

http://www.lintcode.com/en/problem/minimum-adjustment-cost/

Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
Notice: You can assume each number in the array is a positive integer and not greater than 100.

*/


// we don't know where to set each knob, so that we try every possible settings.


	public int MinAdjustmentCost (List<Integer> A, int target) {
		if (A.size() == 0) return 0;
		
		int max = A.get(0);
		int min = A.get(0);
		for (int i : A) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		
		
		int[][] M = new int[A.size()][max - min + 1];
		for (int i = 0; i < A.size(); i++) {  // for each knob
			for (int j = 0; j <= max - min; j++) {  // for each value of each knob
				
				
				
				if (i == 0) {
					M[i][j] = Math.abs(A.get(i) - (j + min));
				}
				
				else {
					M[i][j] = Integer.MAX_VALUE;
					for (int k = Math.max(min, j + min - target); k <= Math.min(max, j + min + target); k++) {
						M[i][j] = Math.min(M[i][j], M[i-1][k - min]);
					}
					M[i][j] += Math.abs(A.get(i) - (j + min));
				}
				
				
				
			}
		}
		
		
		int ans = M[A.size() - 1][0];
		for (int j = 0; j <= max - min; j++) {
			ans = Math.min(ans, M[A.size() - 1][j]);
		}
		return ans;
	}	
