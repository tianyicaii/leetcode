/*
 *  http://www.lintcode.com/en/problem/lowest-common-ancestor/
 *
 *  Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *  The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *  Assume two nodes are exist in tree.
 */


	public TreeNode lowestCommonAncestor (TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) return null;
		if (root == A || root == B) return root;
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		if (left == null && right == null) return null;
		if (left != null && right != null) return root;
		if (left != null) return left;  // if A == B, then that node will be returned.
		else return right;  // if only one node is found, then that node is returned.
	}
