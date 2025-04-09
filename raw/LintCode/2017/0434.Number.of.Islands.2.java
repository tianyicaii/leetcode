/*
 *  http://www.lintcode.com/en/problem/number-of-islands-ii/
 *
 *  Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
 *  Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
 *  The list pair has k operator and each operator has two integer A[i].x, A[i].y means that
 *  you can change the grid matrix[A[i].x][A[i].y] from sea to island.
 *  Return how many island are there in the matrix after each operator.
 */

	public class UF {
		int[] id;
		int[] sz;
		int cnt;
		public UF (int n) {
			id = new int[n];
			sz = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
				sz[i] = 1;
			}
			cnt = n;
		}
		int find (int x) {
			while (id[x] != x) {
				id[x] = id[id[x]];
				x = id[x];
			}
			return id[x];
		}
		boolean connected (int x, int y) {
			return find(x) == find(y);
		}
		void union (int x, int y) {
			if (connected(x, y)) return;
			int left = find(x);
			int right = find(y);
			if (sz[left] > sz[y]) {
				id[right] = left;
				sz[left] += sz[right];
			} else {
				id[left] = right;
				sz[right] += sz[left];
			}
			cnt -= 1;
		}
	}
	
	int[][] board;
	
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	
	int getIndex (int i, int j) {
		return i * board[0].length + j;
	}
	
	boolean inBound (int i, int j) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}
	
	public List<Integer> numIslands2 (int n, int m, Point[] operators) {
		List<Integer> ans = new ArrayList<>();
		if (operators == null) return ans;
		
		UF uf = new UF(n * m);
		board = new int[n][m]; 
		int numWater = n * m;
		
		for (Point p : operators) {
			
			if (board[p.x][p.y] != 1) {
				board[p.x][p.y] = 1;
				-- numWater;
				
				for (int i = 0; i < 4; i++) {
					int x = p.x + dx[i];
					int y = p.y + dy[i];
					if (inBound(x, y) && board[x][y] == 1) {
						uf.union(getIndex(p.x, p.y), getIndex(x, y));
					}
				}

			}
			ans.add(uf.cnt - numWater);  // each water is on component on its own
		}
		return ans;
	}
