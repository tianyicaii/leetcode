/*
 *  http://www.lintcode.com/en/problem/word-ladder/
 *
 *  Given two words (start and end), and a dictionary, find the length of *shortest* transformation sequence from start to end, such that:
 *      Only one letter can be changed at a time
 *      Each intermediate word must exist in the dictionary
 */

	public int ladderLength (String start, String end, Set<String> dict) {
		dict.add(end);  // just in case
		Queue<String> q = new LinkedList<>();
		Set<String> seen = new HashSet<>();
		q.offer(start);
		seen.add(start);
		int distance = 1;  // count number of vertices, not number of edges
		
		while (!q.isEmpty()) {
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				String x = q.poll();		
				if (x.equals(end)) return distance;
				for (String e : getNeighbors(x, dict)) {
					if (!seen.contains(e)) {
						seen.add(e);
						q.offer(e);
					}
				}
			}
			++ distance;
		}
		return 0;
	}
	
	List<String> getNeighbors (String s, Set<String> dict) {
		List<String> ans = new ArrayList<>();
		StringBuilder e = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == s.charAt(i)) continue;
				e.setCharAt(i, c);  // change one letter
				if (dict.contains(e.toString())) ans.add(e.toString());
			}
			e.setCharAt(i, s.charAt(i));  // set back to original
		}
		return ans;
	}
