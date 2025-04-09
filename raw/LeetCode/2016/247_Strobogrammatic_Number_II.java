// https://leetcode.com/problems/strobogrammatic-number-ii/


public class Solution {


	public List<String> findStrobogrammatic(int n) {

		List<String> ans = new ArrayList<>();
		if (n == 0) return ans;
		if (n == 1) {
			ans.add("0");
			ans.add("1");
			ans.add("8");
			return ans;
		}

		// n is at least 2
		Deque<String> bfs = new ArrayDeque<>();
		if (n % 2 == 1) {
			bfs.offerLast("0");
			bfs.offerLast("1");
			bfs.offerLast("8");
			n -= 1;
		}
		else 
			bfs.offerLast("");
	
		for (int i = 0; i < n-2; i += 2) {
			int sz = bfs.size();
			for (int j = 0; j < sz; j++) {
				String infix = bfs.pollFirst();
				bfs.offerLast("0" + infix + "0");
				bfs.offerLast("1" + infix + "1");
				bfs.offerLast("8" + infix + "8");
				bfs.offerLast("6" + infix + "9");
				bfs.offerLast("9" + infix + "6");
			}
		}

		while (!bfs.isEmpty()) {
			String infix = bfs.pollFirst();
			ans.add("1" + infix + "1");
			ans.add("8" + infix + "8");
			ans.add("6" + infix + "9");
			ans.add("9" + infix + "6");
		}
		return ans;
	}


}

