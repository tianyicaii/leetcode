// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/


public class Solution {
	

	public TreeNode buildTree (int[] inorder, int[] postorder) {
		return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
	}	
	private TreeNode helper (int[] inorder, int left, int right, int[] postorder, int index) {
		if (left > right) return null;
		TreeNode root = new TreeNode(postorder[index]);
		int i = left;
		while (inorder[i] != postorder[index]) i++;
		root.left = helper(inorder, left, i-1, postorder, index - 1 - (right - (i+1) + 1));
		root.right = helper(inorder, i+1, right, postorder, index - 1);
		return root;
	}


}

