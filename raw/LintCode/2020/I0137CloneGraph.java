package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class I0137CloneGraph {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        List<UndirectedGraphNode> nodes = bfs(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> clone = new HashMap<>();
        for (UndirectedGraphNode x : nodes) {
            clone.put(x, new UndirectedGraphNode(x.label));
        }
        for (UndirectedGraphNode x : nodes) {
            UndirectedGraphNode a = clone.get(x);
            for (UndirectedGraphNode y : x.neighbors) a.neighbors.add(clone.get(y));
        }
        return clone.get(node);
    }


    private List<UndirectedGraphNode> bfs(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> visited = new HashSet<>();
        List<UndirectedGraphNode> q = new ArrayList<>();
        q.add(node);
        visited.add(node);
        for (int i = 0; i < q.size(); i++) {
            UndirectedGraphNode x = q.get(i);
            for (UndirectedGraphNode y : x.neighbors) {
                if (visited.contains(y)) continue;
                visited.add(y);
                q.add(y);
            }
        }
        return q;
    }
}
