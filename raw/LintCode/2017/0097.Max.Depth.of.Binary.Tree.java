/*
 *  http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/
 *
 *  Given a binary tree, find its maximum depth.
 *  The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */


// recursion
	public int maxDepth (TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}


// bfs
	public int maxDepth (TreeNode root) {
		if (root == null) return 0;
		int ans = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int sz = q.size();
			ans += 1;
			for (int i = 0; i < sz; i++) {
				TreeNode x = q.poll();
				if (x.left != null) q.offer(x.left);
				if (x.right != null) q.offer(x.right);
			}
		}
		return ans;
	}
