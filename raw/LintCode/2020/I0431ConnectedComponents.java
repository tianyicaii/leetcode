package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class I0431ConnectedComponents {
    
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    Set<UndirectedGraphNode> visited = new HashSet<>();
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        for (UndirectedGraphNode x : nodes) {
            List<Integer> c = new ArrayList<>();
            if (!visited.contains(x)) {
                dfs(c, x);
                bfs(c, x);
                Collections.sort(c);
                ans.add(c);
            }
        }
        return ans;
    }

    private void dfs(List<Integer> c, UndirectedGraphNode x) {
        visited.add(x);
        c.add(x.label);
        for (UndirectedGraphNode y : x.neighbors) {
            if (!visited.contains(y)) dfs(c, y);
        }
    }

    private void bfs(List<Integer> c, UndirectedGraphNode x) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(x);
        visited.add(x);

        while (!q.isEmpty()) {
            UndirectedGraphNode curr = q.poll();
            c.add(curr.label);
            for (UndirectedGraphNode next : curr.neighbors) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
    }
}
