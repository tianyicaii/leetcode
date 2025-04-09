/*
 * http://www.lintcode.com/en/problem/binary-tree-level-order-traversal-ii/#
 *
 *  Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (ie, from left to right, level by level from leaf to root).
 */

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int sz = q.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < sz; i++) {
				TreeNode x = q.poll();
				level.add(x.val);
				if (x.left != null) q.offer(x.left);
				if (x.right != null) q.offer(x.right);
			}
			ans.add(level);
		}
		
		Collections.reverse(ans);  // bottom up order
		return ans;
	}	
