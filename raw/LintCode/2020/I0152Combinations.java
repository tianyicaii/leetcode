package lintcode;

import java.util.ArrayList;
import java.util.List;

public class I0152Combinations {
    
    
    
    List<List<Integer>> ans;
    int n;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        this.n = n;
        dfs(new ArrayList<>(), 1, k);
        return ans;
    }

    private void dfs(List<Integer> path, int i, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i > n) return;

        dfs(path, i+1, k);
        path.add(i);
        dfs(path, i+1, k-1);
        path.remove(path.size()-1);
    }
}
