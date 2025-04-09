/*
 *  http://www.lintcode.com/en/problem/binary-tree-longest-consecutive-sequence/
 *
 *  Given a binary tree, find the length of the longest consecutive increasing sequence path.
 *  The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 *  The longest consecutive path need to be from parent to child while increasing. (cannot be the reverse).
 */

	int globalMax;
	public int longestConsecutive (TreeNode root) {
		globalMax = 0;
		helper(root);
		return globalMax;
	}

	private int helper (TreeNode root) {
		if (root == null) return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		int localMax = 1;  // +1 for root
		if (root.left != null && root.left.val == root.val + 1) localMax = Math.max(localMax, left + 1);
		if (root.right != null && root.right.val == root.val + 1) localMax = Math.max(localMax, right + 1);
		globalMax = Math.max(localMax, globalMax);
		return localMax;
	}
