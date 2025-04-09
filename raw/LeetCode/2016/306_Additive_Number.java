// https://leetcode.com/problems/additive-number/


public class Solution {
	

	public boolean isAdditiveNumber (String num) {
		if (num == null || num.length() < 3) return false;
		int n = num.length();
		for (int i = 1; i <= n / 2; i++) {  // length of first number
			if (num.charAt(0) == '0' && i > 1) break;  // avoid "0x"
			for (int j = 1; Math.max(i, j) <= n / 2; j++) {  // length of second number
				if (num.charAt(i) == '0' && j > 1) break;  // avoid "0x"
				BigInteger x = new BigInteger(num.substring(0, i));
				BigInteger y = new BigInteger(num.substring(i, i + j));
				if (isValid(x, y, num, i + j)) return true;
				// else keep trying
			}
		}
		return false;
	}
	
	public boolean isValid (BigInteger x, BigInteger y, String num, int index) {
		if (index == num.length()) return false; // at least 3 numbers
		while (index < num.length()) {
			BigInteger sum = x.add(y);
			if (!num.startsWith(sum.toString(), index)) return false;  // no "0x" problem
			x = y;
			y = sum;
			index += sum.toString().length();
		}
		return true;
	}


}

