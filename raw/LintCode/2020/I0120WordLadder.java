package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class I0120WordLadder {

    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        Set<String> visited = new HashSet<>();
        Queue<String> bfs = new LinkedList<>();
        bfs.offer(start);
        visited.add(start);
        int ans = 0;
        while (!bfs.isEmpty()) {
            int N = bfs.size();
            ans ++;
            for (int i = 0; i < N; i++) {
                String x = bfs.poll();
                if (x.equals(end)) return ans;
                List<String> neighbors = getNeighbors(x, dict);
                for (String n : neighbors) {
                    if (visited.contains(n)) continue;
                    visited.add(n);
                    bfs.offer(n);
                }
    
            }
        }
        return -1;
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
