import java.util.*;

public class Solution {

	public int lengthOfLongestSubstring (String s) {
		Set<Character> set = new HashSet<Character>();
		int ans = 0;
		for (int left = 0, right = 0; right < s.length(); ++ right) {
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left++));
			}
			set.add(s.charAt(right));
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}

}


import java.util.*;

public class Solution {

	public int lengthOfLongestSubstring (String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int ans = 0;
		for (int left = 0, right = 0; right < s.length(); ++ right) {
			if (map.containsKey(s.charAt(right)) && 
					map.get(s.charAt(right)) >= left) {
				left = map.get(s.charAt(right)) + 1;
			}
			map.put(s.charAt(right), right);
			ans = Math.max(ans, right - left + 1);
		} 
		return ans;
	}
}

