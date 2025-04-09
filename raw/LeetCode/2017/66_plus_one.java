import java.util.*;

public class Solution {

	public int[] plusOne (int[] digits) {
		
		int carry = 1;
		for (int i = digits.length - 1; i >= 0 && carry == 1; i--) {
			int sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum / 10;
		}
		if (carry == 1) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}
		return digits;
	}

}
