/*

http://www.lintcode.com/en/problem/backpack/

Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
Notice: You can not divide any item into small pieces. Each item can only be used once

*/

	public int backPack (int m, int[] A) {
		if (A.length == 0 || m == 0) return 0;

		int[][] mem = new int[A.length][m + 1];  // max weight under j can be achieved for first i items
		for (int i = 0; i < A.length; i++) {  // for each item
			for (int j = 1; j <= m; j++) {  // for each weight
				
				if (i == 0) {  // first item
					if (j >= A[i]) mem[i][j] = A[i];
					else mem[i][j] = 0;
				} else {  // for each item, we either take it or not take it, if capacity allows
					if (j >= A[i]) mem[i][j] = Math.max(A[i] + mem[i - 1][j - A[i]], mem[i - 1][j]);
					else mem[i][j] = mem[i-1][j];  // out of capacity, cannot take this item
				}
				
			}
		}
		
		return mem[A.length - 1][m];  // with A.lenght many items, under upper bound m, the best we can do is mem[A.length - 1][m]
	}

