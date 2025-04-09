/*
 *  http://www.lintcode.com/en/problem/binary-tree-paths/
 *
 *  Given a binary tree, return all root-to-leaf paths.
 */

// bottom up
	public List<String> binaryTreePaths (TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root == null) return paths;
		List<String> subPaths = new ArrayList<>();
		subPaths.addAll(binaryTreePaths(root.left));
		subPaths.addAll(binaryTreePaths(root.right));
		for (String p : subPaths) {
			paths.add(root.val + "->" + p);
		}
		if (paths.isEmpty()) paths.add(root.val + "");
		return paths;
	}


// top down
	public List<String> binaryTreePaths (TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root == null) return paths;
		Queue<TreeNode> q = new LinkedList<>();
		Queue<String> p = new LinkedList<>();
		q.offer(root);
		p.offer(root.val + "");
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			String path = p.poll();
			if (curr.left == null && curr.right == null) paths.add(path);
			if (curr.left != null) { q.offer(curr.left); p.offer(path + "->" + curr.left.val); }
			if (curr.right != null) { q.offer(curr.right); p.offer(path + "->" + curr.right.val); }
		}
		return paths;
	}
