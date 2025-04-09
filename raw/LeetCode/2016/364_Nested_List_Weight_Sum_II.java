// https://leetcode.com/problems/nested-list-weight-sum-ii/


public class Solution {


	// bfs
	
	
	public int depthSumInverse (List<NestedInteger> nestedList) {
		
		Deque<NestedInteger> bfs = new ArrayDeque<>(); 
		for (NestedInteger v : nestedList) {
			bfs.offerLast(v);
		}
		
		int ans = 0;
		int prev = 0;
		while (!bfs.isEmpty()) {
			int sz = bfs.size();
			int curr = 0;
			for (int i = 0; i < sz; i++) {
				NestedInteger v = bfs.pollFirst();
				if (v.isInteger()) {
					curr += v.getInteger();
				}
				else {
					for (NestedInteger e : v.getList())
						bfs.offerLast(e);
				}
			}
			

			prev += curr;  // include new row
			ans += prev;  // add all previous one more time
		}
		
		return ans;
	}


}

