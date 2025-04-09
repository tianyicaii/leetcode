package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class I0121WordLadder2 {
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> visited = new HashMap<>();
        bfs(start, end, dict, graph, visited);
        if (!visited.containsKey(end)) return ans;
        dfs(ans, new ArrayList<>(), end, graph, visited, visited.get(end));
        return ans;
    }

    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> graph, Map<String, Integer> visited) {
        Queue<String> bfs = new LinkedList<>();
        bfs.offer(start);
        visited.put(start, 0);
        int length = 0;
        while (!bfs.isEmpty()) {
            int N = bfs.size();
            length++;
            for (int i = 0; i < N; i++) {
                String x = bfs.poll();
                List<String> neighbors = getNeighbors(x, dict);
                graph.put(x, neighbors);
                if (x.equals(end)) return;
                for (String n : neighbors) {
                    if (visited.containsKey(n)) continue;
                    visited.put(n, length);
                    bfs.offer(n);
                }
            }
        }
    }

    private void dfs(List<List<String>> ans, ArrayList<String> path, String end, Map<String, List<String>> graph, Map<String, Integer> visited, int length) {
        if (length == 0) {
            List<String> rp = new ArrayList<>();
            rp.add(end);
            for (int i = path.size() - 1; i >= 0; i--) rp.add(path.get(i));
            ans.add(rp);
            return;
        }
        path.add(end);
        List<String> neighbors = graph.get(end);
        for (String n : neighbors) {
            if (visited.containsKey(n) && visited.get(n) == length - 1) dfs(ans, path, n, graph, visited, length - 1);
        }
        path.remove(path.size() - 1);
    }

    private List<String> getNeighbors(String w, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        int N = w.length();
        for (int i = 0; i < N; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String next = w.substring(0, i) + c + w.substring(i+1, N);
                if (!next.equals(w) && dict.contains(next)) ans.add(next);
            }
        }
        return ans;
    }
}
