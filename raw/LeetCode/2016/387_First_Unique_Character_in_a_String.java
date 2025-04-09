// https://leetcode.com/problems/first-unique-character-in-a-string/


public class Solution {


	public int firstUniqChar(String s) {

		Map<Character, Integer> counts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			counts.put(c, 0);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			counts.put(c, counts.get(c) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (counts.get(c) == 1) return i;
		}
		return -1;

	}


}

