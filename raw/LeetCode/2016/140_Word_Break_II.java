// https://leetcode.com/problems/word-break-ii/


public class Solution {
	

	private int getMaxLen (Set<String> wordDict) {
		int max = 0;
		for (String s: wordDict) {
			if (s.length() > max) max = s.length();
		}
		return max;
	}
	
	public List<String> wordBreak (String s, Set<String> wordDict) {
		Map<String, List<String>> mem = new HashMap<>();
		int maxLen = getMaxLen(wordDict);
		helper(s, wordDict, mem, maxLen);
		return mem.get(s);
	}	
	private void helper(String s, Set<String> wordDict, Map<String, List<String>> mem, int maxLen) {
		if (mem.containsKey(s)) return;  // already done.
		
		List<String> ans = new ArrayList<>();
		for (int i = 1; i <= s.length() && i <= maxLen; i++) {
			String prefix = s.substring(0, i);
			String subfix = s.substring(i);
			if (wordDict.contains(prefix)) {
				if (i == s.length()) {
					ans.add(s);
				}
				else {
					helper(subfix, wordDict, mem, maxLen);
					for (String sub : mem.get(subfix)) {
						ans.add(prefix + " " + sub);
					}
				}
			}
		}
		mem.put(s, ans);  // if cannot parse, then list is empty.
	}


}

