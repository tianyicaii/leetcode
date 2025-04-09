/*
 *  http://www.lintcode.com/en/problem/binary-tree-zigzag-level-order-traversal/#
 *
 *  Given a binary tree, return the zigzag level order traversal of its nodes' values.
 *  (ie, from left to right, then right to left for the next level and alternate between).
 */

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
		
		for (int i = 0; i < ans.size(); i++) {
			if (i % 2 == 1) Collections.reverse(ans.get(i));
		}
		
		return ans;
	}	
