// https://leetcode.com/problems/strobogrammatic-number-iii/


public class Solution {


	public int strobogrammaticInRange(String low, String high) {
		List<String> candi = new ArrayList<>();
		for (int i = low.length(); i <= high.length(); i++) {
			candi.addAll(helper(i, i));
		}
		int count = 0;
		for (String s : candi) {
			if (s.length() == low.length() && s.compareTo(low) < 0) continue;
			if (s.length() == high.length() && s.compareTo(high) > 0) continue;
			count ++;
		}
		return count;
	}

	private List<String> helper (int curr, int total) {  // each function call return Strings of length curr
		List<String> ans = new ArrayList<>();
		if (total == 0) 
			return ans;
		if (curr == 0) {
			ans.add("");
			return ans;
		}
		if (curr == 1) {  // total >= 1
			ans.add("0");
			ans.add("1");
			ans.add("8");
			return ans;
		}
		List<String> infix = helper(curr - 2, total);
		for (String s : infix) {
			if (curr != total)
				ans.add("0" + s + "0");
			ans.add("1" + s + "1");
			ans.add("8" + s + "8");
			ans.add("6" + s + "9");
			ans.add("9" + s + "6");
		}
		return ans;
	}


}

