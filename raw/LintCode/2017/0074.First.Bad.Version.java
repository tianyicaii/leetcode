/*
 *  http://www.lintcode.com/en/problem/first-bad-version/
 *
 *  The code base version is an integer start from 1 to n.
 *  One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests.
 *  Find the first bad version.
 *  You can call SVNRepo.isBadVersion(v) to help you determine which version is the first bad one.
 */

	public int findFirstBadVersion (int n) {
		if (n <= 0) return -1;
		if (SVNRepo.isBadVersion(1)) return 1;
		if (!SVNRepo.isBadVersion(n)) return -1;
		int left = 1;
		int right = n;
		while (right - left > 1) {  // invariant: left is good version, right is bad version
			int mid = left + (right - left) / 2;
			if (SVNRepo.isBadVersion(mid)) right = mid;
			else left = mid;
		}
		return right;
	}

	static class SVNRepo {
		public static boolean isBadVersion (int k) { return false; }
	}
