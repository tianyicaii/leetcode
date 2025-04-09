// https://leetcode.com/problems/substring-with-concatenation-of-all-words/


public class Solution {
	

	public List<Integer> findSubstring (String s, String[] words) {
		
		List<Integer> ans = new ArrayList<>();
		
		int n = s.length();
		int m = words.length;
		if (m == 0 || n == 0) return ans;
		int l = words[0].length();
		
		Map<String, Integer> dict = new HashMap<>();
		Map<String, Integer> window = new HashMap<>();
		
		for (String word : words) {
			int count = 1;
			if (dict.containsKey(word))
				count += dict.get(word);
			dict.put(word, count);
		}
		
		for (int i = 0; i <= n - m * l; i++) {  // substring can start anywhere
			boolean found = true;
			window.clear();
			for (int j = 0; j < m && found; j ++) {  // match each word
				String curr = s.substring(i + j*l, i + (j+1)*l);
				if (!dict.containsKey(curr)) {
					found = false;
					break;
				}
				int count = 1;
				if (window.containsKey(curr))
					count += window.get(curr);
				window.put(curr, count);
				if (count > dict.get(curr)) {
					found = false;
					break;
				}
			}
			if (found) ans.add(i);
		}
		
		return ans;
	}


}

