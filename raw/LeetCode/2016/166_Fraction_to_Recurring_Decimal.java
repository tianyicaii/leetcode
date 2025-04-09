// https://leetcode.com/problems/fraction-to-recurring-decimal/


public class Solution {


	public String fractionToDecimal (int numerator, int denominator) {
		
		if (denominator == 0) throw new ArithmeticException(" / 0");
		
		int sign = 1;
		if (numerator < 0 && denominator > 0 ||
			numerator > 0 && denominator < 0)
			sign = -1;
		
		long N = Math.abs((long)numerator);
		long D = Math.abs((long)denominator);
		long Q = N / D;
		long R = N % D;
		
		StringBuilder ans = new StringBuilder();
		if (sign == -1) ans.append('-');
		ans.append(Q);
		if (R == 0) return ans.toString();  // no decimal point
		ans.append('.');
		
		Map<Long, Integer> remainder2Index = new HashMap<>();
		
		while (R != 0) {
			if (remainder2Index.containsKey(R)) {
				int index = remainder2Index.get(R);
				ans.insert(index, '(');
				ans.append(')');
				return ans.toString();
			}
			else {
				remainder2Index.put(R, ans.length());
				R = R * 10;
				Q = R / D;
				R = R % D;
				ans.append(Q);
			}
		}
		return ans.toString();  // no recurring
	}


}

