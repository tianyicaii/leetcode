/*
 *  http://www.lintcode.com/en/problem/binary-tree-serialization/
 *
 *  Design an algorithm and write code to serialize and deserialize a binary tree.
 *  Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
 */


	public String serialize (TreeNode root) {
		if (root == null) return "{}";
		ArrayList<TreeNode> q = new ArrayList<>();
		q.add(root);
		int index = 0;
		while (index < q.size()) {
			TreeNode x = q.get(index++);
			if (x != null) {
				q.add(x.left);  // null is also added, as if in a complete tree
				q.add(x.right);
			}
		}
		
		StringBuilder ans = new StringBuilder();
		ans.append('{');
		ans.append(q.get(0).val);
		for (int i = 1; i < q.size(); i++) {
			if (q.get(i) == null) ans.append(",#");
			else ans.append("," + q.get(i).val);
		}
		ans.append('}');
		return ans.toString();
	}


	public TreeNode deserialize (String data) {
		if (data.equals("{}")) return null;
		data = data.substring(1, data.length() - 1);
		String[] vals = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int index = 1;
		while (!q.isEmpty()) {
			TreeNode x = q.poll();
			String left = vals[index++];
			String right = vals[index++];
			if (!left.equals("#")) { 
				x.left = new TreeNode(Integer.parseInt(left));
				q.offer(x.left);
			}
			if (!right.equals("#")) {
				x.right = new TreeNode(Integer.parseInt(right));
				q.offer(x.right);
			}
		}
		return root;
	}
