// https://leetcode.com/problems/first-bad-version/


public class Solution {
	

	public int firstBadVersion (int n) {
		if (n < 1) return -1;  // -1 indicates all good

		int left = 1;  // invariant : left is good
		int right = n;  // invariant : right is bad

		if (isBadVersion(left)) return left;
		if (!isBadVersion(right)) return -1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) right = mid;
			else                   left = mid;
		}

		return right;
	}


}

