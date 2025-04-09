// https://leetcode.com/problems/add-binary/


public class Solution {
	

	public String addBinary (String a, String b) {
		if (a.length() > b.length()) return addBinary(b, a);
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder ans = new StringBuilder();
		int carry = 0;
		while (i >= 0) {
			int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
			carry = sum / 2;
			ans.append(sum % 2);
			i--;
			j--;
		}
		while (j >= 0) {
			int sum = (b.charAt(j) - '0') + carry;
			carry = sum / 2;
			ans.append(sum % 2);
			j--;
		}
		if (carry == 1) ans.append('1');
		return ans.reverse().toString();
	}


}

