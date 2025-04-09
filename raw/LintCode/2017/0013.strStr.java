/* 
 *  http://www.lintcode.com/en/problem/strstr/
 *
 *  For a given source string and a target string, you should output the first index (from 0) of target string in source string.
 *  If target does not exist in source, just return -1.
 */

	public int strStr (String source, String target) {
		if (source == null || target == null) return -1;
		for (int i = 0; i <= source.length() - target.length(); i++) {
			if (source.substring(i, i + target.length()).equals(target)) return i;
		}
		return -1;
	}
