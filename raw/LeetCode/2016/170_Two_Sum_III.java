// https://leetcode.com/problems/two-sum-iii-data-structure-design/


public class Solution {


	public class TwoSum {

		Map<Integer, Integer> counts = new HashMap<>();
		
	    // Add the number to an internal data structure.
		public void add(int number) {
			int count = 1;
			if (counts.containsKey(number)) 
				count += counts.get(number);
			counts.put(number, count);
		}

	    // Find if there exists any pair of numbers which sum is equal to the value.
		public boolean find(int value) {
			for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
				int x = entry.getKey();
				int y = value - x;
				if (x == y) {
					if (counts.get(x) > 1) return true;
				}
				else {
					if (counts.containsKey(y)) return true;
				}
			}
			return false;
		}
	}


}

