// https://leetcode.com/problems/binary-tree-level-order-traversal/


public class Solution {
	

	public List<List<Integer>> levelOrder (TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		Deque<TreeNode> bfs = new ArrayDeque<>();
		bfs.offerLast(root);
		
		while (!bfs.isEmpty()) {
			int sz = bfs.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < sz; i++) {
				TreeNode node = bfs.pollFirst();
				level.add(node.val);
				if (node.left  != null) bfs.offerLast(node.left);
				if (node.right != null) bfs.offerLast(node.right);
			}
			ans.add(level);
		}
		return ans;
	}


}

