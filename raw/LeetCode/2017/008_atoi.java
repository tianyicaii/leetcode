import java.util.*;

public class Solution {

	public int myAtoi (String s) {
		int i = 0;

		while (i < s.length() && Character.isWhitespace(s.charAt(i))) ++i;
		
		int sign = 1;
		if (i < s.length() && s.charAt(i) == '+') {
			++i;
		} else if (i < s.length() && s.charAt(i) == '-') {
			sign = -1;
			++i;
		}
		
		int abs = 0;
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';
			if (sign == 1) {
				if (abs > Integer.MAX_VALUE / 10 || abs == Integer.MAX_VALUE / 10 && digit >= 7) {
					return Integer.MAX_VALUE;
				}
			} else {
				if (abs > Integer.MAX_VALUE / 10 || abs == Integer.MAX_VALUE / 10 && digit >= 8) {
					return Integer.MIN_VALUE;
				}
			}
			abs = abs * 10 + digit;
			++i;
		}
		
		return sign * abs;
	}
}
