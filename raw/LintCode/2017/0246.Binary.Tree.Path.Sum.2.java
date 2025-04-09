/*
 *  http://www.lintcode.com/en/problem/binary-tree-path-sum-ii/
 *
 *  Your are given a binary tree in which each node contains a value. Design an algorithm to get all paths which sum to a given value.
 *  The path does *not* need to start or end at the root or a leaf, but it must go in a straight line down.
 */

	public List<List<Integer>> binaryTreePathSum2 (TreeNode root, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		helper(ans, target, root, new ArrayList<>(), 0);
		return ans;
	}

	private void helper (List<List<Integer>> ans, int target, TreeNode root, List<Integer> path, int sumFromRoot) {
		path.add(root.val);
		sumFromRoot += root.val;

		for (int i = path.size() - 1, p = 0; i >= 0; i--) {  // try to find a suffix that add up to target
			p += path.get(i);
			if (p == target) {  // there might be more than one such suffixes ending at current node
				List<Integer> v = new ArrayList<>();
				for (int j = i; j < path.size(); j++) {
					v.add(path.get(j));
				}
				ans.add(v);
			}
		}
		
		if (root.left != null) helper(ans, target, root.left, path, sumFromRoot);
		if (root.right != null) helper(ans, target, root.right, path, sumFromRoot);
		path.remove(path.size() - 1);
	}
