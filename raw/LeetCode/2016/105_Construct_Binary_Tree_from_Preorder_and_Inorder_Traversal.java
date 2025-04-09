// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


public class Solution {
	

	public TreeNode buildTree (int[] preorder, int[] inorder) {
		return helper(preorder, 0, inorder, 0, inorder.length - 1);
	}	
	private TreeNode helper (int[] preorder, int index, int[] inorder, int left, int right) {
		if (left > right) return null;
		TreeNode root = new TreeNode(preorder[index]);
		int i = left;
		while (inorder[i] != preorder[index]) i++;
		root.left = helper(preorder, index + 1, inorder, left, i-1);
		root.right = helper(preorder, index + 1 + (i-1 - left + 1), inorder, i + 1, right);
		return root;
	}


}

