/*
 *  http://www.lintcode.com/en/problem/valid-palindrome/
 *
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */

	public boolean isPalindrome(String s) {
		
		int i = 0;
		int j = s.length() - 1; 
		while (true) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (i >= j) break;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
			i ++;
			j --;
				
		}
		
		return true;
	}
