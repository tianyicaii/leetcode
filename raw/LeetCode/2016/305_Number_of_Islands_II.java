// https://leetcode.com/problems/number-of-islands-ii/


public class Solution {
	

	private class UF {

		Map<Integer, Integer> id;
		Map<Integer, Integer> sz;
		int count;

		public UF (int size) {
			id = new HashMap<>();
			sz = new HashMap<>();
			count = size;
			for (int i = 0; i < size; i++) {
				id.put(i, i);
				sz.put(i, 1);
			}
		}

		public int find (int x) {
			while (x != id.get(x)) {
				int pp = id.get(id.get(x));
				id.put(x, pp);
				x = id.get(x);
			}
			return x;
		}

		public void union (int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y) return;
			if (sz.get(x) > sz.get(y)) {
				id.put(y, x);
				sz.put(x, sz.get(x) + sz.get(y));
			}
			else {
				id.put(x, y);
				sz.put(y, sz.get(x) + sz.get(y));
			}
			count -= 1;
		}

		public boolean isConnected (int x, int y) {
			x = find(x);
			y = find(y);
			return x == y;
		}
	}

	int[] dirs = { 0, -1, 0, 1, 0 };
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) {

		List<Integer> ans = new ArrayList<>();
		boolean[][] board = new boolean[m][n];
		int count = 0;
		UF uf = new UF(m * n);	

		for (int[] p : positions) {

			int r = p[0];
			int c = p[1];
			if (board[r][c]) {  // was land
				ans.add(count);
				continue;
			}

			board[r][c] = true;  // turn to land
			count += 1;
			int x = r * n + c;

			for (int k = 0; k < 4; k++) {  // try connect with neighbors
				int i = r + dirs[k];
				int j = c + dirs[k + 1];
				int y = i * n + j;

				if (i >= 0 && i < m && 
					j >= 0 && j < n && 
					board[i][j] && 
					!uf.isConnected(x, y)) {

					uf.union(x, y);
					count -= 1;  // merged
				}
			}

			ans.add(count);
		}
		return ans;
	}


}

