// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/


public class Solution {


	public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
		
		if (root == null || p == null || q == null) return null;
		if (p.val > q.val) return lowestCommonAncestor(root, q, p);

		if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,  p, q);
		if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
		return root;
	}


}

