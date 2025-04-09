
	public boolean isBalanced (TreeNode root) {
		return depth(root) != -1;
	}
	int depth (TreeNode x) {
		if (x == null) return 0;
		int left = depth(x.left);
		int right = depth(x.right);
		if (left == -1 || right == -1) return -1;
		if (Math.abs(left - right) > 1) return -1;
		return Math.max(left, right) + 1;
	}

