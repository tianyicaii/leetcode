// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/


public class Solution {
	

	public void flatten(TreeNode root) {
		if (root == null) return;
		helper(root);
	}	
	private TreeNode helper (TreeNode root) {  // return the tail of resulting linked list
		if (root.left == null && root.right == null) return root;  // leaf
		if (root.left == null) return helper(root.right);
		if (root.right == null) {
			root.right = root.left;
			root.left = null;
			return helper(root.right);
		}
		TreeNode leftEnd = helper(root.left);
		TreeNode rightEnd = helper(root.right);
		leftEnd.right = root.right;
		root.right = root.left;
		root.left = null;
		return rightEnd;
	} 


}

