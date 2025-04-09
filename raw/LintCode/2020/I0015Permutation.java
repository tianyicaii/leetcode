package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    描述
    给定一个数字列表，返回其所有可能的排列。

    你可以假设没有重复数字。

    您在真实的面试中是否遇到过这个题？  
    样例
    样例 1：

    输入：[1]
    输出：
    [
    [1]
    ]
    样例 2：

    输入：[1,2,3]
    输出：
    [
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
    ]
    挑战
    使用递归和非递归分别解决。

*/


public class I0015Permutation {
    
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), count(nums));
        return ans;
    }

    private Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : nums) {
            if (counts.containsKey(i)) counts.put(i, counts.get(i) + 1);
            else counts.put(i, 1);
        }
        return counts;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, Map<Integer, Integer> counts) {
        if (counts.isEmpty()) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        Map<Integer, Integer> copy = new HashMap<Integer, Integer>(counts);
        for (Map.Entry<Integer, Integer> e : copy.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();
            if (v == 1) counts.remove(k);
            else counts.put(k, v - 1);

            path.add(k);
            dfs(ans, path, counts);

            path.remove(path.size() - 1);
            counts.put(k, v);
        }
    }

}
