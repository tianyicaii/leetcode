// https://leetcode.com/problems/sqrtx/


public class Solution {
	

	public int mySqrt(int x) {
		
		if (x == 0) return 0;  // avoid divide by zero
		
		int left = 1;
		int right = x;
		
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (mid == x / mid) return  mid;
			if (mid  > x / mid) right = mid;
			else                left  = mid;
		}
		
		return left;
		
	}


}


