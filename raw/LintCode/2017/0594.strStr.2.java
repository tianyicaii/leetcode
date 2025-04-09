/*
 *  http://www.lintcode.com/en/problem/strstr-ii/
 *
 *  Implement strStr function in O(n + m) time.
 *  strStr() return the first index of the target string in a source string.
 *  The length of the target string is m and the length of the source string is n.
 *  If target does not exist in source, just return -1.
 */

	private class IncrementalHash {
		String s;
		int windowLength;
		int base = 33;
		int curr = 0;
		int leadingTerm; // == (base ^ (windowLength))
		int hash; // == (base ^ (windowLength - 1)) * s.charAt(i) + (base ^ (windowLength - 2)) * s.charAt(i + 1) + ... + (base ^ 0) * s.charAt(i + windowLength - 1)

		public IncrementalHash (String s, int windowLength) {
			this.s = s;
			this.windowLength = windowLength;
			this.hash = 0;
			this.leadingTerm = 1;  // == (base ^ 0)
			for (int i = 0; i < windowLength; i++)
				leadingTerm *= base;
		}

		int getNextHash () {
			if (curr == 0) {
				for (int i = 0; i < windowLength; i++)
					hash = hash * base + s.charAt(i);
			} else {  // modular arithmetic
				hash = hash * base + s.charAt(curr + windowLength - 1);
				hash -= s.charAt(curr - 1) * leadingTerm;
			}
			curr ++;
			return hash;
		}
	}
	
	public int strStr2 (String source, String target) {
		if (source == null || target == null) return -1;
		IncrementalHash sourceHash = new IncrementalHash(source, target.length());
		IncrementalHash targetHash = new IncrementalHash(target, target.length());
		int t = targetHash.getNextHash();
		for (int i = 0; i <= source.length() - target.length(); i++) {
			if (sourceHash.getNextHash() == t)
				if(source.substring(i, i + target.length()).equals(target)) return i;
		}
		return -1;
	}
