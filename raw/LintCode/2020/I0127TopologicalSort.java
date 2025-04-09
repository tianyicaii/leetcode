package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class I0127TopologicalSort {

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    };

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        return extractNodes(getInDegree(graph));        
    }

    private Map<DirectedGraphNode, Integer> getInDegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> inDegree = new HashMap<>();
        for (DirectedGraphNode n : graph) {
            inDegree.put(n, 0);
        }
        for (DirectedGraphNode x : graph) {
            for (DirectedGraphNode y : x.neighbors) {
                inDegree.put(y, inDegree.get(y) + 1);
            }
        }
        return inDegree;
    }

    private ArrayList<DirectedGraphNode> extractNodes(Map<DirectedGraphNode, Integer> inDegree) {
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        for (Map.Entry<DirectedGraphNode, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) ans.add(e.getKey());
        }
        for (int i = 0; i < ans.size(); i++) {
            DirectedGraphNode x = ans.get(i);
            for (DirectedGraphNode y : x.neighbors) {
                inDegree.put(y, inDegree.get(y) - 1);
                if (inDegree.get(y) == 0) ans.add(y);
            }
        }
        return ans;
    }


    ArrayList<DirectedGraphNode> graph;
    Set<DirectedGraphNode> visited;
    Stack<DirectedGraphNode> reversePostOrder;

    public ArrayList<DirectedGraphNode> topSort_(ArrayList<DirectedGraphNode> graph) {
        this.graph = graph;
        visited = new HashSet<>();
        reversePostOrder = new Stack<>();
        for (DirectedGraphNode v : graph) {
            if (!visited.contains(v)) dfs(v);
        }
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        while (!reversePostOrder.isEmpty()) {
            ans.add(reversePostOrder.pop());
        }
        return ans;
    }

    private void dfs(DirectedGraphNode v) {
        visited.add(v);
        for (DirectedGraphNode u : v.neighbors) {
            if (!visited.contains(u)) dfs(u);
        }
        reversePostOrder.push(v);
    }
}
