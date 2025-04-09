/*
 *  http://www.lintcode.com/en/problem/string-permutation-ii/#
 *
 *  Given a string, find all permutations of it without duplicates.
 */

	TreeMap<Character, Integer> map;  // lintcode needs answer to be sorted
	List<String> ans;
	
	public List<String> stringPermutation2 (String str) {	
		map = new TreeMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) map.put(str.charAt(i), 0);
			map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
		}
		ans = new ArrayList<>();
		dfs(new StringBuilder());
		return ans;
	}

	private void dfs (StringBuilder path) {
		if (map.isEmpty()) {
			ans.add(path.toString());
			return;
		}
		
		
		TreeMap<Character, Integer> copy = new TreeMap<>(map);
		for (Map.Entry<Character, Integer> e : copy.entrySet()) {
			path.append(e.getKey());
			if (e.getValue() == 1) map.remove(e.getKey());
			else map.put(e.getKey(), e.getValue() - 1);
			
			dfs(path);
			
			path.delete(path.length() - 1, path.length());
			map.put(e.getKey(), e.getValue());
		}

	}
