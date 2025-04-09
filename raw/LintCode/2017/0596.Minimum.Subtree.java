/*
 *  http://www.lintcode.com/en/problem/minimum-subtree/
 *
 *  Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 */

	TreeNode ans;
	Integer min;
	
	public TreeNode findSubtree (TreeNode root) {
		if (root == null) return null;
		helper(root);
		return ans;
	}
	
	private Integer helper (TreeNode node) {
		if (node == null) return null;
		Integer left = helper(node.left);
		Integer right = helper(node.right);
		Integer ret = node.val + (left == null ? 0 : left) + (right == null ? 0 : right);
		if (min == null || min > ret) {
			min = ret;
			ans = node;
		}
		return ret;
	}
