// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/


public class Solution {


	private class UF {
		int[] id;
		int[] sz;
		int cnt;
		public UF (int size) {
			id = new int[size];
			sz = new int[size];
			cnt = size;
			for (int i = 0; i < size; i++) {
				id[i] = i;
				sz[i] = 1;
			}
		}
		
		public int find (int x) {
			while (x != id[x]) {
				int pp = id[id[x]];
				id[x] = pp;
				x = id[x];
			}
			return x;
		}
		
		public void union (int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y) return;
			if (sz[x] > sz[y]) {
				id[y] = x;
				sz[x] += sz[y];
			}
			else {
				id[x] = y;
				sz[y] += sz[x];
			}
			cnt -= 1;
		}
	}

	
	public int countComponents(int n, int[][] edges) {
		UF G = new UF(n);
		for (int[] e : edges) {
			G.union(e[0], e[1]);
		}
		return G.cnt;
	}


}

