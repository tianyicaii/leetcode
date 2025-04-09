/*
 *  http://www.lintcode.com/en/problem/word-ladder-ii/
 *
 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 *  Only one letter can be changed at a time
 *  Each intermediate word must exist in the dictionary
 *  Notice
 *      All words have the same length.
 *      All words contain only lowercase alphabetic characters.
 */

	public List<List<String>> findLadders (String start, String end, Set<String> dict) {
		List<List<String>> ans = new ArrayList<>();
		Map<String, Set<String>> graph = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();
		if (!dict.contains(start)) dict.add(start);
		if (!dict.contains(end)) dict.add(end);
		if (!bfs(start, end, dict, graph, distance)) return ans;
		dfs(ans, new ArrayList<>(), start, end, graph, distance);
		return ans;
	}
	
	boolean bfs (String start, String end, Set<String> dict, Map<String, Set<String>> graph, Map<String, Integer> distance) {
		boolean found = false;
		Queue<String> q = new LinkedList<>();
		q.add(start);
		graph.put(start, getNeighbors(start, dict));
		distance.put(start, 0);
		while (!q.isEmpty() && !found) {  // only gathers the shorted paths
			int sz = q.size();
			for (int i = 0; i < sz; i++) {  //  level order traversal
				String x = q.poll();
				for (String e : graph.get(x)) {
					if (distance.containsKey(e)) continue;  // visited
					graph.put(e, getNeighbors(e, dict));  //  add back edges
					distance.put(e, distance.get(x) + 1);
					q.offer(e);
					if (e.equals(end)) found = true;
				}
			}
		}
		return found;
	}

	void dfs (List<List<String>> ans,  List<String> reversedPath, String start, String curr, Map<String, Set<String>> graph, Map<String, Integer> distance) {
		reversedPath.add(curr);
		if (curr.equals(start)) {
			List<String> path = new ArrayList<>(reversedPath);  // copy
			Collections.reverse(path);
			ans.add(path);

		} else {
			for (String e : graph.get(curr)) {
				if (distance.containsKey(e) && distance.get(e) == distance.get(curr) - 1) {  // follow backwards the previous path from start to curr
					dfs(ans, reversedPath, start, e, graph, distance);
				}
			}
		}
		reversedPath.remove(reversedPath.size() - 1);
	}

	Set<String> getNeighbors (String s, Set<String> dict) {
		Set<String> ans = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			for (char x = 'a'; x <= 'z'; x++) {
				if (c == x) continue;
				String e = s.substring(0, i) + x + s.substring(i + 1);
				if (dict.contains(e)) ans.add(e);
			}
		}
		return ans;
	}
