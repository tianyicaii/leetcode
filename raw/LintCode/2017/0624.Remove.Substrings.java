/*
 *  http://www.lintcode.com/en/problem/remove-substrings/
 *
 *  Given a string s and a set of n substrings.
 *  You are supposed to remove every instance of those n substrings from s so that s is of the minimum length and output this minimum length.
 */

// try all possible ways to reduce s

	public int minLength (String s, Set<String> dict) {
		if (s == null) return 0;
		int ans = s.length();
		Queue<String> q = new LinkedList<>();
		Set<String> seen = new HashSet<>();
		q.offer(s);
		seen.add(s);
		while (!q.isEmpty()) {
			String x = q.poll();
			List<String> neighbors = getNeighbors(x, dict);
			if (neighbors.isEmpty()) ans = Math.min(ans, x.length());  // cannot reduce no more
			else {
				for (String e : neighbors) {
					if (!seen.contains(e)) {
						seen.add(e);
						q.offer(e);
					}
				}
			}
		}
		return ans;
	}
	
	List<String> getNeighbors (String s, Set<String> edges) {  // get all possible substrings with one removal
		List<String> ans = new ArrayList<>();
		for (String e : edges) {
			int i = 0;
			while (true) {
				i = s.indexOf(e, i);
				if (i == -1) break;
				else {
					ans.add(s.substring(0, i) + s.substring(i + e.length()));
					++ i;
				}
			}
		}
		return ans;
	}
