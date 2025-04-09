// https://leetcode.com/problems/sparse-matrix-multiplication/


public class Solution {
	

	public int[][] multiply (int[][] A, int[][] B) {
		if (A == null || B == null || A.length == 0 || B.length == 0 || A[0].length == 0 || B[0].length == 0) return new int[][] {};
		
		int m = A.length;
		int K = A[0].length;
		int n = B[0].length;
		int[][] C = new int[m][n];
		
		Map<Integer, Integer>[] rows = (Map<Integer, Integer>[]) new Map[m];
		Map<Integer, Integer>[] cols = (Map<Integer, Integer>[]) new Map[n];
		
		// rows from A
		for (int i = 0; i < m; i++) {
			rows[i] = new HashMap<>();
			for (int j = 0; j < K; j++) {
				if (A[i][j] != 0) rows[i].put(j, A[i][j]);
			}
		}

		// cols from B
		for (int j = 0; j < n; j++) {
			cols[j] = new HashMap<>();
			for (int i = 0; i < K; i++) {
				if (B[i][j] != 0) cols[j].put(i, B[i][j]);
			}
		}

		// multiply
		for (int i = 0; i < m; i++) {
			Map<Integer, Integer> row = rows[i];
			for (Map.Entry<Integer, Integer> x : row.entrySet()) {  // only consider non-zero elements in A
				int k = x.getKey();
				int a = x.getValue();
				for (int j = 0; j < n; j++) {
					Map<Integer, Integer> col = cols[j];
					if (col.containsKey(k))  // only consider non-zero elements in A
						C[i][j] += a * col.get(k);
				}
			}
		}
		
		return C;
	}


}

