import java.util.*;

public class L0001a_Two_Sum {

	public int[] twoSum (int[] nums, int target) {

		//  for each number x in nums, search for another number y such that x + y = target

		Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			if (!m.containsKey(x))
				m.put(x, new ArrayList<Integer>());
			m.get(x).add(i);
		}
		
		for (int x : nums) {
			int y = target - x;
			int x_i = m.get(x).get(0);
			if (x == y) {
				if (m.get(x).size() >= 2) {
					int y_i = m.get(x).get(1);
					return new int[] {x_i, y_i};
				}
			} else {
				if (m.containsKey(y)) {
					int y_i = m.get(y).get(0);
					return new int[] {x_i, y_i};
				}
			}
		}
		
		//  no solution
		return new int[] {};		
	}

}
