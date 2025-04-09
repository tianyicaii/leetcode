// https://leetcode.com/problems/valid-perfect-square/


public class Solution {


	public boolean isPerfectSquare (int num) {
		if (num == 0) return true;
		if (num == 1) return true;
		
		long left = 0;
		long right = num;
		while (left < right - 1) {
			long mid = left + (right - left) / 2;  // easily overflow int
			long square = mid * mid;
			if (square == num) return true;
			if (square <  num) left = mid;
			else               right = mid;
		}
		return false;
	}


}

