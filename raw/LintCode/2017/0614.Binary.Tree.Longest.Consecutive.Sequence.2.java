/*
 *  http://www.lintcode.com/en/problem/binary-tree-longest-consecutive-sequence-ii/
 *
 *  Given a binary tree, find the length of the longest consecutive sequence path.
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
	
	public int longestConsecutive2 (TreeNode root) {
		globalMax = 0;
		helper(root);
		return globalMax;
	}

	private Result helper (TreeNode root) {
		if (root == null) return new Result(0, 0);
		
		Result left = helper(root.left);
		Result right = helper(root.right);
		Result ans = new Result(1, 1);
		
		if (root.left != null) {
			if (root.val + 1 == root.left.val) {
				ans.down = 1 + left.down;
			} else if (root.val == root.left.val + 1) {
				ans.up = 1 + left.up;
			} else { ; }
		}
		
		if (root.right != null) {
			if (root.val + 1 == root.right.val) {
				ans.down = Math.max(ans.down, 1 + right.down);
			} else if (root.val == root.right.val + 1) {
				ans.up = Math.max(ans.up, 1 + right.up);
			} else { ; }
		}

		int localMax = ans.up + ans.down - 1;  // up and down are from different children
		globalMax = Math.max(localMax, globalMax);
		return ans;
	}
