// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


public class Solution {


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) return null;
		if (root == A) return A;
		if (root == B) return B;
		TreeNode left  = lowestCommonAncestor(root.left,  A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		if (left != null && right != null) return root;
		if (left == null) return right;
		                  return left;
	}


}

