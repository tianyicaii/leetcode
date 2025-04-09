import java.util.*;

public class TwoSum {

	Map<Integer, Integer> m = new HashMap<Integer, Integer>();

	public TwoSum () {
		
	}
	
	public void add (int num) {
		int count = 0;
		if (m.containsKey(num)) count = m.get(num);
		m.put(num, count + 1);
	}
	
	public boolean find (int target) {
		for (Map.Entry<Integer, Integer> e : m.entrySet()) {
			int x = e.getKey();
			int y = target - x;
			if (x == y) {
				if (m.get(x) >= 2)
					return true;
				else continue;
			} else {
				if (m.containsKey(y))
					return true;
				else continue;
			}
		}
		return false;
	}
}
