package lintcode;

import java.util.HashSet;
import java.util.Set;

public class I0384LongestSubstringWithoutRepeating {
    
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> seen = new HashSet<>();
        for (int left = 0, right = 0; right < s.length(); ) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right++));
                ans = Math.max(ans, seen.size());
            } else {
                seen.remove(s.charAt(left++));
            }
        }
        return ans;
    }

}
