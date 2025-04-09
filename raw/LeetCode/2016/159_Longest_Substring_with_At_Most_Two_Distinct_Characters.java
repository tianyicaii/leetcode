// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/


public class Solution {
	

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		
		
		Map<Character, Integer> counts = new HashMap<>();
		int k = 2;
		int max = 0;
		
		for (int left = 0, right = 0; right < s.length(); right++) {
			
			int count = 1;
			if (counts.containsKey(s.charAt(right)))
				count += counts.get(s.charAt(right));
			counts.put(s.charAt(right), count);
			
			while (counts.size() > k) {
				count = counts.get(s.charAt(left));
				if (count == 1) // last one
					counts.remove(s.charAt(left));
				else
					counts.put(s.charAt(left), count - 1);
				left += 1;
			}
			
			max = Math.max(max, right - left + 1);	
		}
		return max;
		
	}	


}

