// https://leetcode.com/problems/shortest-word-distance-ii/


public class Solution {


	public class WordDistance {

		Map<String, List<Integer>> locations;
		public WordDistance (String[] words) {
	        locations = new HashMap<>();
	        for (int i = 0; i < words.length; i++) {
	        	if (!locations.containsKey(words[i]))
	        		locations.put(words[i], new ArrayList<>());	
	        	locations.get(words[i]).add(i);	        		
	        }
		}

		public int shortest (String word1, String word2) {
	        List<Integer> list1 = locations.get(word1);
	        List<Integer> list2 = locations.get(word2);
	        if (list1 == null || list2 == null) return Integer.MAX_VALUE;  // dummy
	        int i = 0;
	        int j = 0;
	        int min = Integer.MAX_VALUE;
	        while (i < list1.size() && j < list2.size()) {
	        	int p1 = list1.get(i);
	        	int p2 = list2.get(j);
	        	min = Math.min(min, Math.abs(p1 - p2));
	        	if (p1 < p2) i ++;
	        	else         j ++;
	        }
			return min;
		}
		
	}


}

