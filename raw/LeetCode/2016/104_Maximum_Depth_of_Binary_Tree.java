// https://leetcode.com/problems/maximum-depth-of-binary-tree/


public class Solution {
	

	// max depth is the depth of entire tree


	public int maxDepth (TreeNode root) {
		if (root == null) return 0;
		Deque<TreeNode> bfs = new ArrayDeque<>();
		bfs.offerLast(root);
		int depth = 0;
		while (!bfs.isEmpty()) {
			int sz = bfs.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = bfs.pollFirst();
				if (node.left  != null) bfs.offerLast(node.left);
				if (node.right != null) bfs.offerLast(node.right);
			}
			depth += 1;
		}
		return depth;
	}


}

