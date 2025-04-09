
	public TreeNode sortedArrayToBST (int[] nums) {
		return helper (nums, 0, nums.length - 1);
	}
	TreeNode helper (int[] nums, int left, int right) {
		if (left > right) return null;
		int mid = left + (right - left) / 2;
		TreeNode x = new TreeNode(nums[mid]);
		x.left = helper(nums, left, mid - 1);
		x.right = helper(nums, mid + 1, right);
		return x;
	}
