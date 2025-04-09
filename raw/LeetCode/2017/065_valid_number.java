import java.util.*;

public class Solution {

	public boolean isNumber (String s) {
		int i = 0;
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) ++ i;
		boolean ans = false;
		if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) ++ i;
		while (i < s.length() && isDigit(s.charAt(i))) {
			ans = true;
			++ i;
		}
		if (i < s.length() && s.charAt(i) == '.') {
			++ i;
			while (i < s.length() && isDigit(s.charAt(i))) {
				ans = true;
				++ i;
			}
		}
		if (ans == true && i < s.length() && s.charAt(i) == 'e') {
			++ i;
			ans = false;
			if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) ++ i;
			while (i < s.length() && isDigit(s.charAt(i))) {
				ans = true;
				++ i;
			}
		}
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) ++ i;
		return ans && i == s.length();
	}
	
	boolean isDigit (char c) {
		return c >= '0' && c <= '9';
	}
}
