// https://leetcode.com/problems/guess-number-higher-or-lower/


public class Solution extends GuessGame {
	

	public int guessNumber(int n) {
		int left = 1;
		int right = n;
		if (guess(left) == 0) return left;
		if (guess(right) == 0) return right;
		// no need to check boundary
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			int retVal = guess(mid);
			if (retVal ==  0) return mid;
			if (retVal == -1) right = mid;
			else               left = mid;
		}
		return -1;  // won't reach here
	}


}
