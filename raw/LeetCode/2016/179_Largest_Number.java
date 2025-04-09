// https://leetcode.com/problems/largest-number/


public class Solution {


	private class MyComparator implements Comparator<String> {
		public int compare (String a, String b) {
			return - (a + b).compareTo(b + a);
		}
	}
	
	public String largestNumber (int[] nums) {
		
		// 1, sort input
		List<String> input = new ArrayList<>();
		for (int i : nums) input.add(i+"");
		Collections.sort(input, new MyComparator());
		StringBuilder ans = new StringBuilder();
		for (String s : input) ans.append(s);
		
		// 2, remove leading zeros
		int start = 0;
		while (start < ans.length() && ans.charAt(start) == '0') start++;
		if (start == ans.length()) return "0";  // all zeros
		else                       return ans.substring(start);
	}


}

