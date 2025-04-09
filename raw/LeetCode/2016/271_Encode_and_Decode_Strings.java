// https://leetcode.com/problems/encode-and-decode-strings/


public class Solution {
	

	public String encode (List<String> strs) {
		StringBuilder ans = new StringBuilder();
		for (String s : strs) {
			ans.append(s.length());
			ans.append(' ');
			ans.append(s);
		}
		return ans.toString();
	}

	public List<String> decode (String s) {
		List<String> ans = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			int j = s.indexOf(' ', i);
			int length = Integer.parseInt(s.substring(i, j));
			i = j + 1;
			ans.add(s.substring(i, i + length));
			i += length;
		}
		return ans;
	}


}

