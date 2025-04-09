package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class I0135CombinationSum {
    
    List<List<Integer>> ans;
    TreeSet<Integer> candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        this.candidates = new TreeSet<>();
        for (int i : candidates) this.candidates.add(i);
        dfs(new ArrayList<Integer>(), 0, target);
        return ans;
    }

    private void dfs(List<Integer> path, int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (candidates.isEmpty())return;

        int cnt = 0;
        int x = candidates.pollFirst();
        candidates.remove(x);

        while (target >= 0) {
            dfs(path, index + 1, target);
            target -= x;
            path.add(x);
            cnt ++;
        }

        for (int i = 0; i < cnt; i++) {
            path.remove(path.size() - 1);
        }
        candidates.add(x);
    }
}
