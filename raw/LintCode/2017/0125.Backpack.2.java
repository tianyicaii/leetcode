/*

http://www.lintcode.com/en/problem/backpack-ii/

Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?
Notice: You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
Each item can be chosen only once.

*/

	public int backPackII (int m, int[] A, int[] V) {
		if (A.length == 0 || m == 0) return 0;

		int[][] mem = new int[A.length][m + 1];  // max value under weight j can be achieved for first i items
		for (int i = 0; i < A.length; i++) {  // for each item
			for (int j = 1; j <= m; j++) {  // for each weight
				
				if (i == 0) {  // first item
					if (j >= A[i]) mem[i][j] = V[i];
					else mem[i][j] = 0;
				} else {  // for each item, we either take it or not take it, if capacity allows
					if (j >= A[i]) mem[i][j] = Math.max(V[i] + mem[i - 1][j - A[i]], mem[i - 1][j]);
					else mem[i][j] = mem[i-1][j];  // out of capacity, cannot take this item
				}
				
			}
		}
		
		return mem[A.length - 1][m];  // with A.lenght many items, under upper bound m, the best we can do is mem[A.length - 1][m]
	}
