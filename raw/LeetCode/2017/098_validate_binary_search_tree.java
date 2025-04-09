
	public boolean isValidBST (TreeNode root) {
		return helper(root, null, null);
	}
	
	boolean helper (TreeNode x, Integer min, Integer max) {
		if (x == null) return true;
		return (min == null || x.val > min) &&
				(max == null || x.val < max) &&
				helper(x.left, min, x.val) &&
				helper(x.right, x.val, max);
	}





	TreeNode prev = null;
	public boolean isValidBST (TreeNode root) {
		prev = null;
		return inorder_traversal(root);
	}
	boolean inorder_traversal (TreeNode x) {
		if (x == null) return true;
		if (!inorder_traversal(x.left)) return false;
		if (prev != null && x.val <= prev.val) return false;
		prev = x;
		return inorder_traversal(x.right);
	}
