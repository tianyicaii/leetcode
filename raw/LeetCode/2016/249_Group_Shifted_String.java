// https://leetcode.com/problems/group-shifted-strings/


public class Solution {


	public List<List<String>> groupStrings (String[] strings) {
		List<List<String>> ans = new ArrayList<>();
		Map<String, List<String>> groups = new HashMap<>();
		for (String s : strings) {
			String key = getKey(s);
			if (!groups.containsKey(key))
				groups.put(key, new ArrayList<>());
			groups.get(key).add(s);
		}
		for (Map.Entry<String, List<String>> e : groups.entrySet()) {
			ans.add(e.getValue());
		}
		return ans;
	}

	private String getKey (String s) {
		if (s.charAt(0) == 'a') return s;
		int diff = s.charAt(0) - 'a';
		char[] key = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			char c = (char)(s.charAt(i) - diff);
			key[i] = c >= 'a' ? c : (char)(c + 26);
		}
		return new String(key);
	}


}

