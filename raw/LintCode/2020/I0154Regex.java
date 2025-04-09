package lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class I0154Regex {

    Map<Integer, Set<Integer>> G;

    private Set<Integer> dfs(Set<Integer> sources) {
        Set<Integer> visited = new HashSet<>();
        for (int i : sources) dfs(visited, i);
        return visited;
    }

    private void dfs(Set<Integer> visited, int i) {
        if (visited.contains(i)) return;
        visited.add(i);
        for (int j : G.get(i)) dfs(visited, j);
    }
    
    public boolean isMatch(String str, String pat) {
        buildGraph(pat);
        Set<Integer> curr = new HashSet<>();
        curr.add(0);
        curr = dfs(curr);
        
        for (int i = 0; i < str.length(); i++) {
            Set<Integer> next = new HashSet<>();
            for (int x : curr) {
                if (x < pat.length() && 
                    (str.charAt(i) == pat.charAt(x) || pat.charAt(x) == '.')) next.add(x+1);
            }
            curr = dfs(next);
        }
        return curr.contains(pat.length());
    }

    private void buildGraph(String pattern) {
        G = new HashMap<>();
        for (int i = 0; i <= pattern.length(); i++) G.put(i, new HashSet<>());      
        for (int i = 1; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '*') {
                G.get(i).add(i-1);
                G.get(i-1).add(i);
                G.get(i).add(i+1);
            }
        }
    }

}
