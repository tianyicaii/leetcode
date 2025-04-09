
	public List<Integer> spiralOrder (int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		if (matrix.length == 0 || matrix[0].length == 0) return ans;
		int R = matrix.length;
		int C = matrix[0].length;
		int r = 0;
		int c = -1;
		while (true) {
			for (int i = 0; i < C; i++) {
				ans.add(matrix[r][++c]);
			}
			if (--R == 0) break;
			
			for (int i = 0; i < R; i++) {
				ans.add(matrix[++r][c]);
			}
			if (--C == 0) break;

			for (int i = 0; i < C; i++) {
				ans.add(matrix[r][--c]);
			}
			if (--R == 0) break;

			for (int i = 0; i < R; i++) {
				ans.add(matrix[--r][c]);
			}
			if (--C == 0) break;
		}
		return ans;
	}
