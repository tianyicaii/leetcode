// https://leetcode.com/problems/count-and-say/


public class Solution {


	public String countAndSay (int n) {
		String ans = "1";
		for (int i = 2; i <= n; i++)
			ans = getNext(ans);
		return ans;
	}		
	private String getNext (String prev) {
		StringBuilder next = new StringBuilder();
		int i = 0;
		while (i < prev.length()) {
			int j = i + 1;
			while (j < prev.length() && prev.charAt(i) == prev.charAt(j)) j++;
			next.append("" + (j - i) + prev.charAt(i));
			i = j;
		}
		return next.toString();
	}


}

