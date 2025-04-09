
	public int minDepth (TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		if (root.left == null) return minDepth(root.right) + 1;
		if (root.right == null) return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public int minDepth (TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		TreeNode end_of_curr_level = root;
		TreeNode end_of_next_level = null;
		int depth = 1;
		while (!q.isEmpty()) {
			TreeNode x = q.poll();
			if (x.left == null && x.right == null) break;
			if (x.left != null) {
				q.offer(x.left);
				end_of_next_level = x.left;
			}
			if (x.right != null) {
				q.offer(x.right);
				end_of_next_level = x.right;
			}
			if (x == end_of_curr_level) {
				depth += 1;
				end_of_curr_level = end_of_next_level;
				end_of_next_level = null;
			}
		}
		return depth;
	}

	public int minDepth (TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int num_left_in_curr_level = 1;
		int depth = 1;
		while (!q.isEmpty()) {
			TreeNode x = q.poll();
			num_left_in_curr_level --;
			if (x.left == null && x.right == null) break;
			if (x.left != null) q.offer(x.left);
			if (x.right != null) q.offer(x.right);
			if (num_left_in_curr_level == 0) {
				depth += 1;
				num_left_in_curr_level = q.size();
			}
		}
		return depth;
	}

	public int minDepth (TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> curr = new LinkedList<TreeNode>();
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		curr.offer(root);
		int depth = 1;
		while (true) {
			
			if (curr.isEmpty() && next.isEmpty()) break;
			if (curr.isEmpty()) {
				curr = next;
				next = new LinkedList<TreeNode>();
				depth += 1;
			}
			
			TreeNode x = curr.poll();
			
			if (x.left == null && x.right == null) break;
			if (x.left != null) next.offer(x.left);
			if (x.right != null) next.offer(x.right);

		}
		return depth;
	}
