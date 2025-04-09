package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class I0432WeakConnectedComponents {
    
    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    }

    class UF {
        int[] id;
        int[] sz;
        int cnt;

        UF(int N) {
            id = new int[N];
            sz = new int[N];
            cnt = N;
            for (int i = 0; i < N; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a == b) return;

            if (sz[a] > sz[b]) {
                id[b] = a;
                sz[a] += sz[b];
            } else {
                id[a] = b;
                sz[b] += sz[a];
            }
            cnt -= 1;
        }
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {

        Map<DirectedGraphNode, Integer> node2Id = new HashMap<>();
        Map<Integer, DirectedGraphNode> id2Node = new HashMap<>();
        Map<Integer, List<Integer>> components = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        int id = 0;
        for (DirectedGraphNode x : nodes) {
            node2Id.put(x, id);
            id2Node.put(id, x);
            id ++;
        }

        UF uf = new UF(nodes.size());

        for (DirectedGraphNode x : nodes) {
            int i = node2Id.get(x);
            for (DirectedGraphNode y : x.neighbors) {
                int j = node2Id.get(y);
                uf.union(i, j);
            }
        }

        for (DirectedGraphNode x : nodes) {
            int i = node2Id.get(x);
            int r = uf.find(i);
            if (!components.containsKey(r)) components.put(r, new ArrayList<>());
            components.get(r).add(id2Node.get(i).label);
        }

        for (Map.Entry<Integer, List<Integer>> e : components.entrySet()) {
            List<Integer> c = e.getValue();
            Collections.sort(c);
            ans.add(c);
        }

        return ans;
    }

}
