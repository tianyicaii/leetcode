// https://leetcode.com/problems/nested-list-weight-sum/


public class Solution {


	public int depthSum (List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) return 0;

		Deque<NestedInteger> bfs = new ArrayDeque<>();
		for (NestedInteger i : nestedList)
			bfs.offerLast(i);

		int depth = 1;
		int ans = 0;

		while (!bfs.isEmpty()) {

			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {
				NestedInteger v = bfs.pollFirst();
				
				if (v.isInteger()) {
					ans += depth * v.getInteger();
				}
				else {
					for (NestedInteger e : v.getList())
						bfs.offerLast(e);
				}
			}

			depth += 1;  // go to next level
		}

		return ans;
	}


}

