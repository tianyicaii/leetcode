/*
 *  http://www.lintcode.com/en/problem/binary-tree-path-sum-iii/
 *
 *  Give a parent binary tree, and a target number, find all path that the sum of nodes equal to target.
 *  The path could be start and end at any node in the tree.
 *
 *  This is not a tree in general sense, not a normal binary tree. We can go from a child to its parent.
 *  A tree has no cycle, we only need to keep track from which node we got to current node to avoid re-visiting.
 *  Each valid path is added in both directions. left => right, and right => left.
 */

	public List<List<Integer>> binaryTreePathSum3 (ParentTreeNode root, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		dfs(ans, target, root);  // try starting at each node
		return ans;
	}
	
	private void dfs (List<List<Integer>> ans, int target, ParentTreeNode root) {
		helper(ans, target, root, null, new ArrayList<>(), 0);  // root has parent == null
		if (root.left != null) dfs(ans, target, root.left);  // try new starting point at each child
		if (root.right != null) dfs(ans, target, root.right);
	}
	
	private void helper (List<List<Integer>> ans, int target, ParentTreeNode curr, ParentTreeNode from, List<Integer> path, int sum) {
		// use "from" to keep track where we came from, so that we can avoid overlapping (revisiting)
		path.add(curr.val);
		sum += curr.val;
		if (sum == target) ans.add(new ArrayList<>(path));
		if (curr.parent != null && from != curr.parent) helper(ans, target, curr.parent, curr, path, sum);
		if (curr.left != null   && from != curr.left)   helper(ans, target, curr.left, curr, path, sum);
		if (curr.right != null  && from != curr.right)  helper(ans, target, curr.right, curr, path, sum);
		path.remove(path.size() - 1);
	}


	class ParentTreeNode {
		public int val;
		public ParentTreeNode parent, left, right;
	}