package lintcode;

import java.util.HashSet;
import java.util.Set;

public class I0124LongestConsecutiveSubsequence {
    

    public int longestConsecutive(int[] num) {

        Set<Integer> s = new HashSet<>();
        for (int i : num) s.add(i);
        int ans = 0;
        for (int i : num) {
            if (!s.contains(i)) continue;
            int cnt = 1;
            for (int j = i + 1; s.contains(j); j++, cnt++) s.remove(j);
            for (int j = i - 1; s.contains(j); j--, cnt++) s.remove(j);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
