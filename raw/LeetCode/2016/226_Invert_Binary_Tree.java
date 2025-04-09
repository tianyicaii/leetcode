

// https://leetcode.com/problems/invert-binary-tree/


public class Solution {


	public TreeNode invertTree (TreeNode root) {
		if (root == null) return null;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = right;
		root.right = left;
		invertTree(left);
		invertTree(right);
		return root;
	}


}

