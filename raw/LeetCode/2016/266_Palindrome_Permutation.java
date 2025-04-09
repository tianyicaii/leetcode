// https://leetcode.com/problems/palindrome-permutation/


public class Solution {
	

	public boolean canPermutePalindrome (String s) {
		Map<Character, Integer> counts = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (counts.containsKey(c)) counts.put(c, counts.get(c) + 1);
			else                       counts.put(c, 1);
		}
		boolean oddCount = false;
		for (Map.Entry<Character, Integer> e : counts.entrySet()) {
			if (e.getValue() % 2 == 1) {
				if (oddCount) return false;
				else          oddCount = true;
			} 
		}
		return true;
	}


}

