/*
 *  http://www.lintcode.com/en/problem/binary-tree-longest-consecutive-sequence-iii/
 *
 *  It's follow up problem for Binary Tree Longest Consecutive Sequence II
 *  Given a k-ary tree, find the length of the longest consecutive sequence path.
 *  The path could be start and end at any node in the tree
 */

	class Result {
		int down;  // increasing while going down
		int up;    // increasing while going up
		public Result (int d, int u) {
			down = d;
			up = u;
		}
	}

	int globalMax;
	
	public int longestConsecutive3 (MultiTreeNode root) {
		globalMax = 0;
		helper(root);
		return globalMax;
	}

	private Result helper (MultiTreeNode root) {
		if (root == null) return new Result(0, 0);

		Map<MultiTreeNode, Result> sub = new HashMap<>();
		for (MultiTreeNode x : root.children) {
			sub.put(x, helper(x));
		}

		Result ans = new Result(1, 1);
		for (MultiTreeNode x : root.children) {
			if (root.val + 1 == x.val) {
				ans.down = Math.max(ans.down, 1 + sub.get(x).down);
			} else if (root.val == x.val + 1) {
				ans.up = Math.max(ans.up, 1 + sub.get(x).up);
			} else { ; }
		}

		int localMax = ans.up + ans.down - 1;  // up and down are from different children
		globalMax = Math.max(localMax, globalMax);
		return ans;
	}
