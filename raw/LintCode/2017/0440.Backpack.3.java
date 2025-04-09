/*

http://www.lintcode.com/en/problem/backpack-iii/

Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with size m.
What's the maximum value can you put into the backpack?
Notice: You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

*/


// [OPTIMAL]
	public int backPackIII (int[] A, int[] V, int m) {
		if (A.length == 0 || m == 0) return 0;

		int[][] mem = new int[A.length + 1][m + 1];  // max value under weight j can be achieved for first i items
		for (int i = 1; i <= A.length; i++) {  // for each item, (0 item have 0 value)
			for (int j = 1; j <= m; j++) {  // for each weight
				

					mem[i][j] = mem[i-1][j];  // cannot be worse than without this item

					if (A[i-1] <= j) {  // able to add one more
						mem[i][j] = Math.max(V[i-1] + mem[i][j - A[i-1]], mem[i][j]);  // sub-problem is on the same row!
					}


				
			}
		}
		
		return mem[A.length][m];  // with A.lenght many items, under upper bound m, the best we can do is mem[A.length][m]
	}


// [!!! NOT OPTIMAL]
	public int backPackIII (int[] A, int[] V, int m) {
		if (A.length == 0 || m == 0) return 0;

		int[][] mem = new int[A.length + 1][m + 1];  // max value under weight j can be achieved for first i items
		for (int i = 1; i <= A.length; i++) {  // for each item, (0 item have 0 value)
			for (int j = 1; j <= m; j++) {  // for each weight
				

					mem[i][j] = mem[i-1][j];  // cannot be worse than without this item
					int cnt = 1;
					while (A[i-1] * cnt <= j) { // [!!! this is repeated on the same row, between smaller j and larger j]
						mem[i][j] = Math.max(V[i-1] * cnt + mem[i - 1][j - A[i-1] * cnt], mem[i][j]);  // get max possible
						cnt += 1;
					}

				
			}
		}
		
		return mem[A.length][m];  // with A.lenght many items, under upper bound m, the best we can do is mem[A.length][m]
	}
