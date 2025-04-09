import java.util.*;

public class Solution {


	public boolean isPalindrome (String s) {
		
		int i = 0;
		int j = s.length() - 1;
		
		while (i < j) {
			while (i < j && !isLetter(s.charAt(i)) && !isDigit(s.charAt(i))) ++ i;
			while (i < j && !isLetter(s.charAt(j)) && !isDigit(s.charAt(j))) -- j;
			if (toLowercase(s.charAt(i)) == toLowercase(s.charAt(j))) {
				++ i;
				-- j;
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	public char toLowercase (char c) {
		if (isUppercase(c))
			return (char) (c - 'A' + 'a');
		return
			c;
	}
	
	public boolean isUppercase (char c) {
		return c >= 'A' && c <='Z';
	}
	
	public boolean isLowercase (char c ) {
		return c >= 'a' && c <= 'z';
	}
	
	public boolean isLetter (char c) {
		return isUppercase(c) || isLowercase(c);
	}
	
	public boolean isDigit (char c) {
		return c >= '0' && c <= '9';
	}
	
	
	public static void main (String[] args) {
		
		Solution sol = new Solution();
		String s = "0P";
		System.out.println(sol.isPalindrome(s));
	}

}
