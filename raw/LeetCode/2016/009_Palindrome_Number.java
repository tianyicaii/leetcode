// https://leetcode.com/problems/palindrome-number/


public class Solution {


	public boolean isPalindrome(int x) {
		
		if (x < 0) return false;  // corner case
		
		int length = 1;  // one digits
		while (x / length >= 10) length *= 10;  // find highest digit
		
		while (x > 0) {
			int left = x / length;
			int right = x % 10;
			if (left != right) return false;
			x = x % length;  // remove left
			x = x / 10;  // remove right
			length = length / 100;  // length reduce 2
		}
		return true;
		
	}


}

