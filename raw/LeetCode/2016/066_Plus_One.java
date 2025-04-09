// https://leetcode.com/problems/plus-one/


public class Solution {
	

	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum / 10;
		}
		if (carry == 1) {
			int[] ans = new int[digits.length + 1];
			ans[0] = 1;
			for (int i = 1; i < digits.length + 1; i++) {
				ans[i] = digits[i-1];
			}
			return ans;
		}
		else return digits;
	}


}

