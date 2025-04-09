
	int max;
	public int maxPathSum (TreeNode root) {
		max = Integer.MIN_VALUE;
		partial(root);	
		return max;
	}
	int partial (TreeNode x) {
		if (x == null) return 0;
		int left = partial(x.left);
		int right = partial(x.right);
		
		max = Math.max(max, left + x.val + right);
		
		int ans = x.val + Math.max(left, right);
		if (ans < 0) return 0;
		else         return ans;
	}
