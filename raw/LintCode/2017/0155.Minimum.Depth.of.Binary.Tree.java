/*
 *  http://www.lintcode.com/en/problem/minimum-depth-of-binary-tree/
 *
 *  Given a binary tree, find its minimum depth.
 *  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

// recursion
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		if (root.left == null) return minDepth(root.right) + 1;
		if (root.right == null) return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}


// bfs
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int depth = 0;
		while (!q.isEmpty()) {
			depth += 1;
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				TreeNode curr = q.poll();
				if (curr.left == null && curr.right == null) return depth;
				if (curr.left != null) q.offer(curr.left);
				if (curr.right != null) q.offer(curr.right);
			}
		}
		return depth;
	}
