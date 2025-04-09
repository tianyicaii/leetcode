// https://leetcode.com/problems/repeated-dna-sequences/


public class Solution {


	public List<String> findRepeatedDnaSequences (String s) {
		Map<String, Integer> counts = new HashMap<>();
		for (int i = 0; i + 10 <= s.length(); i++) {
			String sub = s.substring(i, i + 10);
			int count = 1;
			if (counts.containsKey(sub))
				count += counts.get(sub);
			counts.put(sub, count);
		}
		List<String> ans = new ArrayList<>();
		for (Map.Entry<String, Integer> e : counts.entrySet()) {
			if (e.getValue() >= 2) ans.add(e.getKey());
		}
		return ans;
	}


}

