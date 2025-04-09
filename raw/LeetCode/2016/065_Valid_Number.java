// https://leetcode.com/problems/valid-number/


public class Solution {
	

	public boolean isNumber(String s) {


		int i = 0;
		int n = s.length();
		boolean isValid = false;
		
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		
		// optional sign
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++; 
		
		// integral
		while (i < n && Character.isDigit(s.charAt(i))) { isValid = true; i++; }
		
		// fraction
		if (i < n && s.charAt(i) == '.') i++;
		while (i < n && Character.isDigit(s.charAt(i))) { isValid = true; i++; }
		
		// exponent
		if (i < n && isValid && (s.charAt(i) == 'E' || s.charAt(i) == 'e')) {

			isValid = false; 
			i++; 
			// sign
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
			while (i < n && Character.isDigit(s.charAt(i))) { isValid = true; i++; }

		}
		
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		
		return isValid && i == n;
		
	}


}

