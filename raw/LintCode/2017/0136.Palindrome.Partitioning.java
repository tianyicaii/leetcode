/*
 *  http://www.lintcode.com/en/problem/palindrome-partitioning/
 *
 *  Given a string s, partition s such that every substring of the partition is a palindrome.
 *  Return all possible palindrome partitioning of s.
 */

// try all possibilities
	public List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<>();
		List<String> partition = new ArrayList<>();
		helper(ans, partition, s);
		return ans;
	}

	void helper (List<List<String>> ans, List<String> partition, String s) {
		if (s.length() == 0) {  // all substrings in partitions are palindromes
			ans.add(new ArrayList<String>(partition));
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String prefix = s.substring(0, i);
			if (isPalindrome(prefix)) {
				partition.add(prefix);
				helper(ans, partition, s.substring(i));  // top down approach
				partition.remove(partition.size() - 1);
			}
		}
	}

	boolean isPalindrome (String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}
