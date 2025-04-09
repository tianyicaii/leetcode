// https://leetcode.com/problems/graph-valid-tree/


public class Solution {


	// n == 2000 leetcode case failed on DFS, BFS


	private Map<Integer, Set<Integer>> buildGraph (int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int i = 0; i < n; i++)
			graph.put(i, new HashSet<>());

		for (int[] e : edges) {
			int from = e[0];
			int to   = e[1];
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		return graph;
	}

// DFS

	public boolean validTree (int n, int[][] edges) {
		if (n == 0) return true;
		Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
		Set<Integer> visited = new HashSet<>();
		if (helper(graph, visited, 0, 0) == false) return false;
		return visited.size() == graph.size();
	}

	public boolean helper (Map<Integer, Set<Integer>> graph, Set<Integer> visited, Integer prnt, Integer node) {  // return false if loop detected
		if (visited.contains(node)) return false;
		visited.add(node);
		for (Integer e : graph.get(node)) {
			if (e == prnt) continue;
			if (helper(graph, visited, node, e) == false) return false;
		} 
		return true;
	}

// BFS

	public boolean validTree (int n, int[][] edges) {
		if (n == 0) return true;  // empty tree
		if (edges.length != n - 1) return false;  // ignore self-loop, duplicate edge,

		Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
		Set<Integer> visited = new HashSet<>();
		Deque<Integer> bfs = new ArrayDeque<>();
		Deque<Integer> par = new ArrayDeque<>();
		bfs.offerLast(0);  // root
		par.offerLast(0);  // rooted at itself
		visited.add(0);

		while (!bfs.isEmpty()) {

			Integer v = bfs.pollFirst();
			Integer p = par.pollFirst();

			for (Integer e: graph.get(v)) {
				if (e == p) continue;  // ignore its parent
				if (visited.contains(e)) return false;  // loop
				visited.add(e);
				bfs.offerLast(e);
				par.offerLast(v);
			}
		}

		return visited.size() == graph.size();  // all visited
	}

// UF

	private class UF {

		HashMap<Integer, Integer> id;
		HashMap<Integer, Integer> sz;
		int n;
		
		public UF (int size) {
			n = size;
			id = new HashMap<>();
			sz = new HashMap<>();
			for (int i = 0; i < size; i++) {
				id.put(i, i);
				sz.put(i, 1);
			}
		}

		public int find (int x) {
			while (x != id.get(x)) {
				int pp = id.get(id.get(x));
				id.put(x, pp);
				x = pp;
			}
			return x;
		}

		public void union (int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y) return;
			if (sz.get(x) < sz.get(y)) {
				id.put(x, y);
				sz.put(y, sz.get(x) + sz.get(y));
			}
			else {
				id.put(y, x);
				sz.put(x, sz.get(x) + sz.get(y));
			}
			n -= 1;
		}

		public boolean isConnected (int x, int y) {
			return find(x) == find(y);
		}
	}

	public boolean validTree (int n, int[][] edges) {
		UF uf = new UF(n);
		for (int[] e : edges) {
			int from = e[0];
			int to   = e[1];
			if (uf.isConnected(from, to)) return false;
			uf.union(from, to);
		}
		return uf.n == 1;
	}


}

