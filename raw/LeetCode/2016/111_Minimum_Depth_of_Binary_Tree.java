// https://leetcode.com/problems/minimum-depth-of-binary-tree/


public class Solution {
	

	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		Deque<TreeNode> bfs = new ArrayDeque<>();
		bfs.offerLast(root);
		int depth = 0;
		while (!bfs.isEmpty()) {
			int sz = bfs.size();
			depth += 1;
			for (int i = 0; i < sz; i++) {
				TreeNode node = bfs.pollFirst();
				if (node.left == null && node.right == null) return depth;
				if (node.left != null) bfs.offerLast(node.left);
				if (node.right != null) bfs.offerLast(node.right);
			}
		}
		return depth;
	}	


}

