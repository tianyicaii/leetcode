/*
 *  http://www.lintcode.com/en/problem/binary-tree-path-sum/
 *
 *  Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
 *  A valid path is from root node to any of the leaf nodes.
 */

	public List<List<Integer>> binaryTreePathSum (TreeNode root, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		helper(ans, target, root, new ArrayList<>(), 0);
		return ans;
	}

	private void helper (List<List<Integer>> ans, int target, TreeNode node, List<Integer> path, int sum) {
		path.add(node.val);
		sum += node.val;
		if (node.left == null && node.right == null) {  // leaf
			if (sum == target) ans.add(new ArrayList<>(path));
		} else {
			if (node.left != null) helper(ans, target, node.left, path, sum);
			if (node.right != null) helper(ans, target, node.right, path, sum);
		}
		path.remove(path.size() - 1);
	}
