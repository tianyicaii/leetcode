/*
 *  http://www.lintcode.com/en/problem/word-break/
 *
 *  Given a string s and a dictionary of words dict,
 *  determine if s can be break into a space-separated sequence of one or more dictionary words.
 */

	public boolean wordBreak (String s, Set<String> dict) {
		boolean[] m = new boolean[s.length() + 1];
		m[0] = true;
		int maxLength = getMaxLength(dict);
		for (int i = 1; i <= s.length(); i++) {
			
			
			for (int length = 1; length <= maxLength && length <= i && !m[i]; length ++) {  // no need to look too far back

				int j = i - length;
				if (!m[j]) continue;
				if (dict.contains(s.substring(j, i))) m[i] = true;
				
			}
			

		}
		return m[s.length()];
	}


	private int getMaxLength (Set<String> dict) {
		int ans = 0;
		for (String s : dict) ans = Math.max(ans, s.length());
		return ans;
	}
