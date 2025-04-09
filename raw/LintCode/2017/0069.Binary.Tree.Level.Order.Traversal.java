/*
 *  http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/#
 *
 *  Given a binary tree, return the level order traversal of its nodes' values.
 *  (ie, from left to right, level by level).
 */

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>(); 
		if (root == null) return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			List<Integer> level = new ArrayList<>(); 
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				TreeNode x = q.poll();
				level.add(x.val);
				if (x.left  != null) q.offer(x.left);
				if (x.right != null) q.offer(x.right);
			}
			ans.add(level);
		}
		return ans;
	}
