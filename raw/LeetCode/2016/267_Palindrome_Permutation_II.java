// https://leetcode.com/problems/palindrome-permutation-ii/


public class Solution {
	

	public List<String> generatePalindromes (String s) {
		List<String> ans = new ArrayList<>();
		StringBuilder path = new StringBuilder();
		Map<Character, Integer> counts = new HashMap<>();
		Map<Character, Integer> usedCounts = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (counts.containsKey(c)) counts.put(c, counts.get(c) + 1);
			else                       counts.put(c, 1);
		}
	
		Character mid = null;
		for (Map.Entry<Character, Integer> e : counts.entrySet()) {
			if (e.getValue() % 2 == 1) {
				if (mid != null) return ans;  // cannot generate palindrome
				else             mid = e.getKey();
			} 
			usedCounts.put(e.getKey(), 0);
		}
		// able to generate
		if (mid != null) counts.put(mid, counts.get(mid) - 1);  // odd length
		helper(ans, path, counts, usedCounts, mid, 0, s.length() / 2);
		return ans;
	}
	
	// each recursion call take care of one position
	private void helper (List<String> ans, StringBuilder path, Map<Character, Integer> counts, Map<Character, Integer> usedCounts, Character mid, int index, int totalLength) { 
		if (index == totalLength) {
			StringBuilder left = new StringBuilder(path);  // leave path intact.
			String pal = left.toString();
			if (mid != null) pal += mid;
			pal += left.reverse().toString();
			ans.add(pal);
			return;
		}
		
		for (Map.Entry<Character, Integer> e : counts.entrySet()) {
			char c = e.getKey();
			if (e.getValue() == usedCounts.get(c)) continue;
			
			path.append(c);
			usedCounts.put(c, usedCounts.get(c) + 2);
			helper(ans, path, counts, usedCounts, mid, index + 1, totalLength);
			usedCounts.put(c, usedCounts.get(c) - 2);
			path.deleteCharAt(path.length() - 1);
		}
	}


}

