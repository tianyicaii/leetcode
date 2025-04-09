// https://leetcode.com/problems/perfect-squares/


public class Solutions {


	public int numSquares (int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;  // for perfect squares
		for (int i = 1; i <= n; i++) {
			if (i == 1) dp[i] = 1;
			else {
				for (int j = 1; j * j <= i; j++) {
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
		}
		return dp[n];
	}




	public int numSquares (int n) {

		if (n <= 0) return 0;
	
	// build graph
		List<Integer> edges = new ArrayList<>();  // edges for each vertex
		boolean[] targets = new boolean[n + 1];
		
		for (int i = 1; i * i <= n; i++) {
			edges.add(i * i);
			targets[i * i] = true;
		}
		
	// bfs
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(n);  // source
		
		int depth = 0;
		while (true) {  // every number has a solution
			
			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {  // poll this level
					
				int v = bfs.poll();
				if (targets[v]) return depth + 1;  // number of perfect squares used to get to this level
													// plus one to bring it to zero.
				for (int e : edges) {  // add its unvisited neighbors
					int neighbor = v - e;
					if (neighbor > 0 && !visited[neighbor]) {
						visited[neighbor] = true;
						bfs.offer(neighbor);
					}
				}  // done with neighbors
			}  // done this level
			
			depth += 1;  // go to next level
		}
	}


}

