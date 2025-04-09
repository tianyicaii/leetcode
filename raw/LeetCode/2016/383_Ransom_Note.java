// https://leetcode.com/problems/ransom-note/


public class Solution {


	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> counts = new HashMap<>();
		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			counts.put(c, 0);
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			counts.put(c, counts.get(c) + 1);
		}
		for (int i = 0; i < magazine.length(); i++) {
			char c = magazine.charAt(i);
			if (counts.containsKey(c))
				counts.put(c, counts.get(c) - 1);
		}
		for (Map.Entry<Character, Integer> e : counts.entrySet())
			if (e.getValue() > 0) return false;
		return true;
	}


}

