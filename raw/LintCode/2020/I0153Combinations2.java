package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class I0153Combinations2 {
    

    List<List<Integer>> ans;
    TreeMap<Integer, Integer> counts;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans = new ArrayList<>();
        counts = new TreeMap<>();
        for (int i : nums) {
            if (!counts.containsKey(i)) counts.put(i, 0);
            counts.put(i, counts.get(i) + 1);
        }
        dfs(new ArrayList<Integer>(), target);
        return ans;
    }

    private void dfs(ArrayList<Integer> path, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (counts.isEmpty() || target < 0) return;  // positive numbers

        Map.Entry<Integer, Integer> e = counts.entrySet().iterator().next();
        int k = e.getKey();
        int v = e.getValue();
        counts.remove(k);

        for (int c = 0; c <= v; c++) {
            dfs(path, target);
            path.add(k);
            target -= k;
        }

        for (int c = 0; c <= v; c++) {
            path.remove(path.size() - 1);
        }
        counts.put(k, v);
    }
}
