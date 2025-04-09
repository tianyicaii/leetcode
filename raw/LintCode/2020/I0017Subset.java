package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

    描述
    给定一个含不同整数的集合，返回其所有的子集。

    子集中的元素排列必须是非降序的，解集必须不包含重复的子集。

*/


public class I0017Subset {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), count(nums));
        return ans;
    }

    private Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int i : nums) {
            if (counts.containsKey(i)) counts.put(i, counts.get(i) + 1);
            else counts.put(i, 1);
        }
        return counts;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, Map<Integer, Integer> counts) {
        if (counts.isEmpty()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        Map<Integer, Integer> copy = new TreeMap<>(counts);
        for (Map.Entry<Integer, Integer> e : copy.entrySet()) {  // only uses the first entry
            int k = e.getKey();
            int v = e.getValue();
            counts.remove(k);
            for (int i = 0; i <= v; i++) {
                dfs(ans, path, counts);
                path.add(k);
            }
            for (int i = 0; i <= v; i++) {
                path.remove(path.size() - 1);
            }
            counts.put(k, v);
            break;  // set v.s. permutation
        }
    }

    public static void main(String[] args) {
        I0017Subset solver = new I0017Subset();
        System.out.println(solver.subsets(new int[]{1, 2}));
    }
}
