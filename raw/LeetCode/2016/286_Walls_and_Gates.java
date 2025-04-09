// https://leetcode.com/problems/walls-and-gates/


public class Solution {
	

	// start from door and fill empty rooms when first visited
	

	private int[] dirs = { 0, -1, 0, 1, 0 };

	public void wallsAndGates (int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;  // nothing to compute
		Deque<Integer> bfs = new ArrayDeque<>();
		
		int m = rooms.length;
		int n = rooms[0].length;
		
		// start from doors
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0)
					bfs.offerLast(i * n + j);
			}
		}
		
		int depth = 0;
		while (!bfs.isEmpty()) {
			int sz = bfs.size();
			for (int l = 0; l < sz; l++) {

				int v = bfs.pollFirst();
				int r = v / n;
				int c = v % n;
				
				for (int k = 0; k < 4; k++) {
					
					int i = r + dirs[k];
					int j = c + dirs[k + 1];
					if (i >= 0 && i < m && j >= 0 && j < n && rooms[i][j] == Integer.MAX_VALUE) {
						rooms[i][j] = depth + 1;
						bfs.offerLast(i * n + j);
					}
				}
			}
			depth ++;
		}
	}
	

}

