package lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class I0178GraphValidTree {
    

    Map<Integer, Set<Integer>> G;
    Set<Integer> visited;

    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        buildGraph(n, edges);
        visited = new HashSet<>();
        visited.add(0);
        for (int i : G.get(0)) dfs(0, i);
        return visited.size() == G.size();
    }

    private void dfs(int prev, int curr) {
        visited.add(curr);
        for (int i : G.get(curr)) {
            if (i == prev) continue;
            if (visited.contains(i)) return;  // cycle
            dfs(curr, i);
        }
    }
    
    private void buildGraph(int n, int[][] edges) {
        G = new HashMap<>();
        for (int i = 0; i < n; i++) G.put(i, new HashSet<>());
        for (int[] e : edges) {
            G.get(e[0]).add(e[1]);
            G.get(e[1]).add(e[0]);
        }
    }
}
