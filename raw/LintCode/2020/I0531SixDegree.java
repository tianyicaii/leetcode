package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class I0531SixDegree {
    
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { 
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>(); 
        }
    }

    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> bfs = new LinkedList<>();
        visited.add(s);
        bfs.offer(s);
        int degree = 0;
        while (!bfs.isEmpty()) {
            int N = bfs.size();
            for (int i = 0; i < N; i++) {
                UndirectedGraphNode x = bfs.poll();
                if (x == t) return degree;
                for (UndirectedGraphNode y : x.neighbors) {
                    if (!visited.contains(y)) {
                        visited.add(y);
                        bfs.offer(y);
                    }
                }
            }
            degree++;
        }
        return -1;
    }
}
