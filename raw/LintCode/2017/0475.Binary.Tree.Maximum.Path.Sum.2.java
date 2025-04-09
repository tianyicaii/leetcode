/*
 *  http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum-ii/
 *
 *  Given a binary tree, find the maximum path sum from root.
 *  The path may end at any node in the tree and contain at least one node in it.
 */

	public int maxPathSum2 (TreeNode root) {
		if (root == null) throw new RuntimeException("empty tree");
		int left = (root.left != null) ? Math.max(0, maxPathSum2(root.left)) : 0;
		int right = (root.right != null) ? Math.max(0, maxPathSum2(root.right)) : 0;
		return root.val + Math.max(left, right);
	}
