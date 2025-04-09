// https://leetcode.com/problems/generalized-abbreviation/


public class Solution {


	// each char: either include or not


	public List<String> generateAbbreviations(String word) {
		List<String> ans = new ArrayList<>();
		StringBuilder path = new StringBuilder();
		helper(ans, path, word, 0, 0);
		return ans;
	}

	private void helper (List<String> ans, StringBuilder path, String word, int index, int prevAbbrLen) {
		if (index == word.length()) {
			if (prevAbbrLen > 0)
				ans.add(path.toString() + prevAbbrLen);
			else
				ans.add(path.toString());
			return;
		}

		helper(ans, path, word, index + 1, prevAbbrLen + 1);

		int pathLen = path.length();
		if (prevAbbrLen > 0) {
			path.append(prevAbbrLen);
		}
		path.append(word.charAt(index));
		helper(ans, path, word, index + 1, 0);
		path.delete(pathLen, path.length());
	}


}

