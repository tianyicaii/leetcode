package lintcode;

import java.util.HashMap;
import java.util.Map;

public class I0386LongestSubstringWithAtMostKDistinct {

    Map<Character, Integer> seen = new HashMap<>();

    private void add(char c) {
        if (!seen.containsKey(c)) seen.put(c, 0);
        seen.put(c, seen.get(c) + 1);
    }

    private void delete(char c) {
        seen.put(c, seen.get(c) - 1);
        if (seen.get(c) == 0) seen.remove(c);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); ) {
            add(s.charAt(j++));
            while (seen.size() > k) delete(s.charAt(i++));
            ans = Math.max(ans, j-i);
        }
        return ans;
    }
}
