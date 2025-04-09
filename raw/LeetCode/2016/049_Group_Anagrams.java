// https://leetcode.com/problems/anagrams/


public class Solution {


	public List<List<String>> groupAnagrams (String[] strs) {
		
		Map<String, List<String>> groups = new HashMap<>();
		for (String s : strs) {
			String key = getKey(s);
			List<String> g;
			if (groups.containsKey(key))
				g = groups.get(key);
			else
				g = new ArrayList<>();
			g.add(s);
			groups.put(key, g);
		}
		
		List<List<String>> ans = new ArrayList<>();
		for (Map.Entry<String, List<String>> e : groups.entrySet()) {
			ans.add(e.getValue());
		}
		return ans;
	}	
	
	private String getKey (String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}


}

