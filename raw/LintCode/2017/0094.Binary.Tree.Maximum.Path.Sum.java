/*
 *  http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/
 *
 *  Given a binary tree, find the maximum path sum.
 *  The path may start and end at any node in the tree.
 */

	int globalMax;
	public int maxPathSum (TreeNode root) {
		globalMax = Integer.MIN_VALUE;
		if (root == null) throw new RuntimeException("empty tree");
		helper(root);
		return globalMax;
	}
	private int helper (TreeNode root) {
		if (root == null) return 0;
		int left = Math.max(0, helper(root.left));  // if child has a negative value, better not have sum it.
		int right = Math.max(0, helper(root.right));
		int localMax = root.val + left + right;
		globalMax = Math.max(globalMax, localMax);
		return Math.max(0, root.val + Math.max(left, right));  // take one branch for parent to include
	}
