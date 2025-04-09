// https://leetcode.com/problems/inorder-successor-in-bst/


public class Solution {
	

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) return null;

		TreeNode succ = null;
		while (root != null) {
			if (root.val <= p.val) root = root.right;
			else {
				succ = root;
				root = root.left;
			}
		}
		return succ;
	}


}


