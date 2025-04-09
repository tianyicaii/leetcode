import java.util.*;

public class Solution {
	
	public int lengthOfLongestSubstringTwoDistinct (String s) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int ans = 0;
		for (int left = 0, right = 0; right < s.length(); ++right) {
			if (map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
			} else {
				map.put(s.charAt(right), 1);
			}
			while (map.size() > 2) {
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
				if (map.get(s.charAt(left)) == 0)
					map.remove(s.charAt(left));
				++left;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}
	
	
	public static void main (String[] args) {
		Solution sol = new Solution();


	}

}
